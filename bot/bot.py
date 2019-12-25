import networkx as nx
from telegram.ext import Updater, CommandHandler

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

def quiz(bot, update):
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
    executeInterpreter("E", graph, bot, update) # HARDCODED
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
            for x in txtRespuestas:
                print(txtRespuestas[x])
            print("/////////////////////////////")
            print("**** " + msg)

        for alter in alternatives:
            # Si el resultado de la respuesta es la etiqueta 
            # de la arista de 'alter', anyade a nodos a procesar
            print("Alternativo (no en cuenta ahora)")

        bot.send_message(chat_id=update.message.chat_id, text=msg)

        print("Comprobando nodos a procesar")
        if nodesToProcess:
            print("Existen nodos a procesar")
            actualNode = nodesToProcess[len(nodesToProcess)-1]
            print(actualNode)
            nodesToProcess.pop()
        else:
            print("End")
            end = True


TOKEN = open('token.txt').read().strip()

updater = Updater(token=TOKEN)
dispatcher = updater.dispatcher

dispatcher.add_handler(CommandHandler('start', start))
dispatcher.add_handler(CommandHandler('help', help))
dispatcher.add_handler(CommandHandler('author', author))
dispatcher.add_handler(CommandHandler('quiz', quiz))
dispatcher.add_handler(CommandHandler('bar', bar))
dispatcher.add_handler(CommandHandler('pie', pie))
dispatcher.add_handler(CommandHandler('report', report))

updater.start_polling()