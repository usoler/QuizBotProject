class Resposta:

    def __init__(self, id):
        print("Initiating resposta")
        self.idPregunta = id
        self.dictOfValues = {}

    def getIdPregunta(self):
        print("Getting id pregunta")
        return self.idPregunta

    def getDictOfValues(self):
        print("Getting dict of values")
        return self.dictOfValues

    def getCountByValue(self, value):
        print("Getting count by value")
        return self.dictOfValues[value]

    def addValue(self, valor):
        print("Adding value to resposta")
        if valor in self.dictOfValues:
            print("Incrementing")
            self.dictOfValues[valor] += 1
        else:
            print("Initiating value to one")
            self.dictOfValues[valor] = 1

    def getRespostaText(self):
        msg = ''
        for x in self.dictOfValues:
            msg += "\n" + self.idPregunta + "    " + str(x) + "    " + str(self.dictOfValues[x])
        return msg