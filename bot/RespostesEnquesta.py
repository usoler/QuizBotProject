from Resposta import Resposta


class RespostesEnquesta:

    def __init__(self, id):
        print("Initiating RespostesEnquesta")
        self.idEnquesta = id
        self.dictOfRespostes = {}

    def getIdEnquesta(self):
        print("Getting Id Enquesta")
        return self.idEnquesta

    def getDictOfRespostes(self):
        print("Getting dict of respostes")
        return self.dictOfRespostes

    def getRespostaById(self, idPregunta):
        print("Get resposta by id")
        return self.dictOfRespostes[idPregunta]

    def addResposta(self, idPregunta, valorResposta):
        print("Adding resposta")
        if idPregunta in self.dictOfRespostes:
            print("exists resposta, adding value to resposta")
            (self.dictOfRespostes[idPregunta]).addValue(valorResposta)
        else:
            print("Creating a new resposta")
            resposta = Resposta(idPregunta)
            resposta.addValue(valorResposta)
            self.dictOfRespostes[idPregunta] = resposta

    def getEnquestaText(self):
        msg = ''
        for x in self.dictOfRespostes:
            msg += (self.dictOfRespostes[x]).getRespostaText()
        return msg
