import networkx as nx
from telegram.ext import Updater, CommandHandler, MessageHandler, Filters

queueOfQuestionAnswer = []

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
    #executeInterpreter(idEnquesta, graph, bot, update)
    initInterpreter("E", graph, bot, update, user_data)
    #executeInterpreter("E", graph, bot, update) # HARDCODED
    for x in user_data:
        print(x)
    print(user_data['isAnswering'])
    print(user_data['data'])
    print("All executed")

def bar(bot, update):
    idPregunta = update.message.text[5:]

def pie(bot, update):
    idPregunta = update.message.text[5:]

def report(bot, update):
    report = 0

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
        # Tratar respuesta y esperar resultado
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
        # Si el resultado de la respuesta es la etiqueta 
        # de la arista de 'alter', anyade a nodos a procesar
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
    user_data['respostes'] = {}
    
    bot.send_message(chat_id=update.message.chat_id, text=msg)

def executeInterpreter(idEnquesta, graph, bot, update):
    print("Executing interpreter")
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
    end = False
    nodesToProcess = []
    while not end:
        txtPreguntas = nx.get_node_attributes(graph, 'pregunta')
        msg = idEnquesta + "> " + txtPreguntas[actualNode]
        print("**** " + msg)
        successors = graph.neighbors(actualNode)

        answers = []
        alternatives = []

        for v in successors:
            if (graph[actualNode][v]['color'] == 'black'):
                print("Encontrada arista negra hacia '" + v + "'")
                nodesToProcess.append(v)
            elif (graph[actualNode][v]['color'] == 'blue'):
                print("Encontrada arista azul hacia '" + v + "'")
                answers.append(v)
            else:
                print("Encontrada arista verde hacia '" + v + "'")
                alternatives.append(v)

        for answer in answers:
            # Tratar respuesta y esperar resultado
            print("Respuesta: " + answer)
            txtRespuestas = nx.get_node_attributes(graph, 'resposta')
            msg = msg + txtRespuestas[answer]
            print("/////////////////////////////")
            print(txtRespuestas)
            for x in txtRespuestas:
                print(txtRespuestas[x])
            print("/////////////////////////////")
            print("**** " + msg)
            #bot.send_message(chat_id=update.message.chat_id, text=msg)
            questionAndAnswer = []
            questionAndAnswer.append(0)
            questionAndAnswer.append(msg)
            questionAndAnswer.append(0)
            questionAndAnswer.append(0)
            queueOfQuestionAnswer.append(questionAndAnswer)

        for alter in alternatives:
            # Si el resultado de la respuesta es la etiqueta 
            # de la arista de 'alter', anyade a nodos a procesar
            print("Alternativo: " + alter)
            txtRespuestas = nx.get_node_attributes(graph, 'resposta')
            msg = msg + txtRespuestas[alter]
            print(msg)
            labels = nx.get_edge_attributes(graph, 'label')
            optionValue = str(labels[(idEnquesta,alter)])
            print("Option value=" + optionValue)
            questionAndAnswer = []
            questionAndAnswer.append(1)
            questionAndAnswer.append(msg)
            questionAndAnswer.append(optionValue)
            questionAndAnswer.append(idEnquesta)
            queueOfQuestionAnswer.append(questionAndAnswer)

        print("Comprobando nodos a procesar")
        if nodesToProcess:
            print("Existen nodos a procesar")
            actualNode = nodesToProcess[len(nodesToProcess)-1]
            print(actualNode)
            nodesToProcess.pop()
        else:
            print("End")
            end = True
            for l in queueOfQuestionAnswer:
                print("Element:")
                print(l[0])
                print(l[1])
                print(l[2])
                print(l[3])

def processAnswer(bot, update, user_data):
    if (('isAnswering' in user_data) and (user_data['isAnswering'] == True)):
        print("Processing answer")
        graph = user_data['graph']
        for x in graph:
            print(x)
        # Tratar respuesta
        answer = update.message.text
        print("Answer = " + answer)
        (user_data['respostes'])[user_data['lastNode']] = answer
        for x in user_data['respostes']:
            print(x)
        print((user_data['respostes'])[user_data['lastNode']])

        # Tratar siguiente nodo a procesar
        print("Processing next node")
        nextNode = user_data['data'].pop()
        print("NextNode (down):")
        print(nextNode)


        actualNode = nextNode[1] # Considerando ninguna alternativa
        print("ActualNode (down):")
        print(actualNode)

        if (actualNode == 'END'):
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
                # Tratar respuesta y esperar resultado
                print("Respuesta: " + answer)
                txtRespuestas = nx.get_node_attributes(graph, 'resposta')
                msg = msg + txtRespuestas[answer]
                print("/////////////////////////////")
                print(txtRespuestas)
                for x in txtRespuestas:
                    print(txtRespuestas[x])
                print("/////////////////////////////")
                print("**** " + msg)

            # for alter in alternatives:
               # Si el resultado de la respuesta es la etiqueta 
               # de la arista de 'alter', anyade a nodos a procesar
               # print("Alternativo: " + alter)
               # txtRespuestas = nx.get_node_attributes(graph, 'resposta')
               # msg = msg + txtRespuestas[alter]
               # print(msg)
               # labels = nx.get_edge_attributes(graph, 'label')
               # optionValue = str(labels[(actualNode,alter)])
               # print("Option value=" + optionValue)
               # greenNode = []
               # greenNode.append(1)
               # greenNode.append(msg)
               # greenNode.append(optionValue)
               # (user_data['data']).append(greenNode)

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
dispatcher.add_handler(CommandHandler('bar', bar))
dispatcher.add_handler(CommandHandler('pie', pie))
dispatcher.add_handler(CommandHandler('report', report))
dispatcher.add_handler(MessageHandler(Filters.text, processAnswer, pass_user_data=True))

updater.start_polling()