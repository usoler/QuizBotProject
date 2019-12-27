import pickle
import networkx as nx
from matplotlib import pyplot as plt
from telegram.ext import Updater, CommandHandler, MessageHandler, Filters
from Resposta import Resposta
from RespostesEnquesta import RespostesEnquesta

def start(bot, update):
    bot.send_message(chat_id=update.message.chat_id, text="Conversa iniciada")

def help(bot, update):
    msg = "/start -- inicia la conversa con el bot\n"
    msg += "/help -- muestra una lista de comandas disponibles del bot\n"
    msg += "/author -- muestra el nombre del autor del proyecto y su correo electronico\n"
    msg += "/quiz <idEnquesta> -- inicia un interprete que realiza la encuesta el id dado\n"
    msg += "/bar <idPregunta> -- muestra un diagrama de barras con las respuestas a la pregunta dada\n"
    msg += "/pie <idPregunta> -- muestra un diagrama de quesitos con el porcentaje de las respuesta a la pregunta dada\n"
    msg += "/report -- muestra una tabla con el numero de respuestas obtenidas por cada valor de cada pregunta"
    bot.send_message(chat_id=update.message.chat_id, text=msg)

def author(bot, update):
    msg = "Autor: Luis Oriol Soler Cruz\n"
    msg += "Correo: luis.oriol.soler@est.fib.upc.edu"
    bot.send_message(chat_id=update.message.chat_id, text=msg)

def quiz(bot, update, user_data):
    idEnquesta = update.message.text[6:]

    try:
        print("Try block")
        graph = findGraphById(idEnquesta)
        print("Graph Found")
        nodes = graph.nodes()
        for x in nodes:
            print(x)
    except:
        print("Except block")
        msg = "No se encuentra ninguna encuesta con id = '" + idEnquesta + "'"
        bot.send_message(chat_id=update.message.chat_id, text=msg)

    ## mover a bloque try
    initInterpreter(idEnquesta, graph, bot, update, user_data)
    for x in user_data:
        print(x)
    print(user_data['isAnswering'])
    print(user_data['data'])
    print("All executed")

def bar(bot, update, user_data):
    idPregunta = update.message.text[5:]
    try:
        print("Loading enquesta from Pickle")
        file = open(user_data['enquesta'] + ".pickle", 'rb')
        enquestes = pickle.load(file)
        file.close()
        print("Enquesta loaded")
        print("Getting resposta by id")
        resposta = enquestes.getRespostaById(idPregunta)

        values = []
        numRespostes = []
        print("Starting bucle")
        for x in resposta.getDictOfValues():
            values.append(x)
            numRespostes.append((resposta.getDictOfValues())[x])
        print("Bucle started")
        print("Values:")
        for x in values:
            print(x)
        print("Num Respostes:")
        for x in numRespostes:
            print(x)

        print("Setting bar")
        plt.bar(values, numRespostes)
        print("Saving fig")
        plt.savefig('bar.png')
        print("Closing plt")
        plt.close('all')
        print("Sending photo")
        bot.send_photo(chat_id=update.message.chat_id, photo=open('bar.png', 'rb'))

    except:
        print("No file")

def pie(bot, update):
    idPregunta = update.message.text[5:]

def report(bot, update, user_data):
    try:
        print("Loading enquesta from Pickle")
        file = open(user_data['enquesta'] + ".pickle", 'rb')
        enquestes = pickle.load(file)
        file.close()

        msg = "pregunta   valor   respostes"
        msg += enquestes.getEnquestaText()
        bot.send_message(chat_id=update.message.chat_id, text=msg)
    except:
        print("No file with that idEnquesta")

def findGraphById(id):
    print("Finding graph with id {" + id + "}")
    return nx.read_gpickle("../cl/" + id + ".gpickle")

def initInterpreter(idEnquesta, graph, bot, update, user_data):
    print("Initiating interpreter")
    msg = "Enquesta " + idEnquesta + ":"
    bot.send_message(chat_id=update.message.chat_id, text=msg)
    print("Mensaje enviado")
    for n in graph:
        print("Node=" + n)
        if (str(n) == idEnquesta):
            root = n
            print("Arrel=" + root)
    print("Arrel2=" + root)
    neighbors = graph.neighbors(root)
    for x in neighbors:
        actualNode = x
    print("Primera pregunta: " + actualNode)

    txtPreguntas = nx.get_node_attributes(graph, 'pregunta')
    msg = idEnquesta + "> " + txtPreguntas[actualNode]
    print("**** " + msg)
    successors = graph.neighbors(actualNode)

    answers = []
    alternatives = []
    nodesToProcess = []

    for v in successors:
        if (graph[actualNode][v]['color'] == 'black'):
            print("Encontrada arista negra hacia '" + v + "'")
            blackNode = []
            blackNode.append(0)
            blackNode.append(v)
            blackNode.append(0)
            nodesToProcess.append(blackNode)
        elif (graph[actualNode][v]['color'] == 'blue'):
            print("Encontrada arista azul hacia '" + v + "'")
            answers.append(v)
        else:
            print("Encontrada arista verde hacia '" + v + "'")
            alternatives.append(v)

    for answer in answers:
        print("Respuesta: " + answer)
        txtRespuestas = nx.get_node_attributes(graph, 'resposta')
        msg = msg + txtRespuestas[answer]
        print("/////////////////////////////")
        print(txtRespuestas)
        for x in txtRespuestas:
            print(txtRespuestas[x])
        print("/////////////////////////////")
        print("**** " + msg)

    for alter in alternatives:
        print("Alternativo: " + alter)
        txtRespuestas = nx.get_node_attributes(graph, 'resposta')
        msg = msg + txtRespuestas[alter]
        print(msg)
        labels = nx.get_edge_attributes(graph, 'label')
        optionValue = str(labels[(idEnquesta,alter)])
        print("Option value=" + optionValue)
        greenNode = []
        greenNode.append(1)
        greenNode.append(msg)
        greenNode.append(optionValue)
        nodesToProcess.append(greenNode)

    user_data['graph'] = graph
    user_data['enquesta'] = idEnquesta
    user_data['isAnswering'] = True
    user_data['lastNode'] = actualNode
    user_data['data'] = nodesToProcess

    print("Checking Respostes")
    try:
        print("Loading enquesta from Pickle")
        file = open(idEnquesta + ".pickle", 'rb')
        user_data['respostes'] = pickle.load(file)
        file.close()
    except:
        print("Creating a new RespostesEnquesta")
        user_data['respostes'] = RespostesEnquesta(idEnquesta)
    
    bot.send_message(chat_id=update.message.chat_id, text=msg)

def processAnswer(bot, update, user_data):
    if (('isAnswering' in user_data) and (user_data['isAnswering'] == True)):
        print("Processing answer")
        graph = user_data['graph']
        for x in graph:
            print(x)
        # Tratar respuesta
        answer = update.message.text
        print("Answer = " + answer)

        (user_data['respostes']).addResposta(str(user_data['lastNode']), answer)

        # Tratar siguiente nodo a procesar
        print("Processing next node")
        nextNode = user_data['data'].pop()
        print("NextNode (down):")

        print(nextNode)

        altNode = []
        while (nextNode[0] == 1):
            if (nextNode[2] == answer):
                altNode = nextNode
            nextNode = user_data['data'].pop()
        if altNode:
            (user_data['data']).append(nextNode)
            nextNode = altNode

        actualNode = nextNode[1]
        print("ActualNode (down):")
        print(actualNode)

        if (actualNode == 'END'):
            dictionaryOfRespostes = (user_data['respostes']).getDictOfRespostes()
            for x in dictionaryOfRespostes:
                print("Pregunta '" + (dictionaryOfRespostes[x]).getIdPregunta() + "'")
                dictionaryOfValues = (dictionaryOfRespostes[x]).getDictOfValues()
                print("Garet")
                for y in dictionaryOfValues:
                    print("inside dict of values bucle")
                    print("Valor: (down)")
                    print(y)
                    print("Comptats: (down)")
                    print(dictionaryOfValues[y])

            print("Opening file")
            file = open(user_data['enquesta'] + ".pickle", 'wb')
            print("Dumping data with Pickle")
            pickle.dump(user_data['respostes'], file, pickle.HIGHEST_PROTOCOL)
            print("Closing file")
            file.close()
            user_data['isAnswering'] = False
            msg = user_data['enquesta'] + "> Gracies pel teu temps!"
            bot.send_message(chat_id=update.message.chat_id, text=msg)
        else:
            txtPreguntas = nx.get_node_attributes(graph, 'pregunta')
            msg = user_data['enquesta'] + "> " + txtPreguntas[actualNode]
            print("**** " + msg)
            successors = graph.neighbors(actualNode)

            answers = []
            alternatives = []
            nodesToProcess = []

            for v in successors:
                if (graph[actualNode][v]['color'] == 'black'):
                    print("Encontrada arista negra hacia '" + v + "'")
                    blackNode = []
                    blackNode.append(0)
                    blackNode.append(v)
                    blackNode.append(0)
                    (user_data['data']).append(blackNode)
                elif (graph[actualNode][v]['color'] == 'blue'):
                    print("Encontrada arista azul hacia '" + v + "'")
                    answers.append(v)
                else:
                    print("Encontrada arista verde hacia '" + v + "'")
                    alternatives.append(v)

            for answer in answers:
                print("Respuesta: " + answer)
                txtRespuestas = nx.get_node_attributes(graph, 'resposta')
                msg = msg + txtRespuestas[answer]
                print("/////////////////////////////")
                print(txtRespuestas)
                for x in txtRespuestas:
                    print(txtRespuestas[x])
                print("/////////////////////////////")
                print("**** " + msg)

            for alter in alternatives:
               print("Alternativo: " + alter)
               labels = nx.get_edge_attributes(graph, 'label')
               optionValue = str(labels[(actualNode,alter)])
               print("Option value=" + optionValue)
               greenNode = []
               greenNode.append(1)
               greenNode.append(alter)
               greenNode.append(optionValue)
               (user_data['data']).append(greenNode)

            user_data['lastNode'] = actualNode
            print(user_data['lastNode'])
            print(user_data['data'])

            bot.send_message(chat_id=update.message.chat_id, text=msg)


TOKEN = open('token.txt').read().strip()

updater = Updater(token=TOKEN)
dispatcher = updater.dispatcher

dispatcher.add_handler(CommandHandler('start', start))
dispatcher.add_handler(CommandHandler('help', help))
dispatcher.add_handler(CommandHandler('author', author))
dispatcher.add_handler(CommandHandler('quiz', quiz, pass_user_data=True))
dispatcher.add_handler(CommandHandler('bar', bar, pass_user_data=True))
dispatcher.add_handler(CommandHandler('pie', pie))
dispatcher.add_handler(CommandHandler('report', report, pass_user_data=True))
dispatcher.add_handler(MessageHandler(Filters.text, processAnswer, pass_user_data=True))

updater.start_polling()