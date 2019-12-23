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
    idEnquesta = update.message.text[5:]

def bar(bot, update):
    idPregunta = update.message.text[4:]

def pie(bot, update):
    idPregunta = update.message.text[4:]

def report(bot, update):
    report = 0

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