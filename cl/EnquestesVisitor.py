# Generated from Enquestes.g by ANTLR 4.7.1
import networkx as nx
import matplotlib.pyplot as plt
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .EnquestesParser import EnquestesParser
else:
    from EnquestesParser import EnquestesParser

# This class defines a complete generic visitor for a parse tree produced by EnquestesParser.
class EnquestesVisitor(ParseTreeVisitor):
    myGraph = nx.DiGraph()
    idEnquesta = ''
    actualNode = ''
    dictItems = {}
    dictAnswers = {}

    # Visit a parse tree produced by EnquestesParser#root.
    def visitRoot(self, ctx:EnquestesParser.RootContext):
        print("Visit Root: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren();
        l = [next(g) for i in range(ctx.getChildCount())]
        for x in l:
            print(" text=" + x.getText())
        for y in l:
            self.visit(y)
        EnquestesVisitor.myGraph.add_node("END")
        nx.set_node_attributes(EnquestesVisitor.myGraph, EnquestesVisitor.dictAnswers, 'resposta')
        txtRespuestas = nx.get_node_attributes(EnquestesVisitor.myGraph, 'resposta')
        print("/////////////////////////////")
        for x in txtRespuestas:
            print(txtRespuestas[x])
        print("/////////////////////////////")
        for z in EnquestesVisitor.myGraph:
            print("Node=" + z)
            succs = EnquestesVisitor.myGraph.successors(z)
            for y in succs:
                print("Edge=" + y)
                labels = nx.get_edge_attributes(EnquestesVisitor.myGraph, 'label')
                print("Label=" + str(labels[(z,y)]))
                colors = nx.get_edge_attributes(EnquestesVisitor.myGraph, 'color')
                print("Color=" + str(colors[(z,y)]))
                print("")
        for w in EnquestesVisitor.dictItems:
            print("Dict key=" + w + ", Dict value=" + EnquestesVisitor.dictItems[w])
        nx.write_gpickle(EnquestesVisitor.myGraph, EnquestesVisitor.idEnquesta + ".gpickle")
        edges = EnquestesVisitor.myGraph.edges()
        colors = [EnquestesVisitor.myGraph[u][v]['color'] for u,v in edges]
        labelDict = {}
        for u,v in edges:
        	labelDict[(u,v)] = EnquestesVisitor.myGraph[u][v]['label']
        nx.draw_circular(EnquestesVisitor.myGraph, edges=edges, edge_color=colors, with_labels=True, node_size=600, linewidths=2.0)
        nx.draw_networkx_edge_labels(EnquestesVisitor.myGraph, pos=nx.circular_layout(EnquestesVisitor.myGraph), edge_labels=labelDict)
        plt.draw()
        plt.savefig("image.png")
        plt.show()

    # Visit a parse tree produced by EnquestesParser#statement.
    def visitStatement(self, ctx:EnquestesParser.StatementContext):
        print("Visit Statement: count=" + str(ctx.getChildCount()))
        n = next(ctx.getChildren())
        print("statement text=" + n.getText())
        self.visitChildren(ctx)

    # Visit a parse tree produced by EnquestesParser#pregunta.
    def visitPregunta(self, ctx:EnquestesParser.PreguntaContext):
        print("Visit Pregunta: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        for x in l:
            print("pregunta text=" + x.getText())
        EnquestesVisitor.myGraph.add_node((l[0]).getText(), pregunta=(l[5]).getText())
        self.visit(l[5])

    # Visit a parse tree produced by EnquestesParser#phrase.
    def visitPhrase(self, ctx:EnquestesParser.PhraseContext):
        print("Visit Phrase: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        for x in l:
            print("Phrase text word=" + x.getText())

    # Visit a parse tree produced by EnquestesParser#resposta.
    def visitResposta(self, ctx:EnquestesParser.RespostaContext):
        print("Visit Resposta: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        for x in l:
            print("resposta text=" + x.getText())
        EnquestesVisitor.myGraph.add_node((l[0]).getText(), resposta='')
        EnquestesVisitor.actualNode = (l[0]).getText()
        for y in range(5, ctx.getChildCount()):
            self.visit(l[y])
        values = nx.get_node_attributes(EnquestesVisitor.myGraph, 'resposta')
        EnquestesVisitor.dictAnswers[EnquestesVisitor.actualNode] = values[(l[0]).getText()]
        print("options=" + values[(l[0]).getText()])

    # Visit a parse tree produced by EnquestesParser#option.
    def visitOption(self, ctx:EnquestesParser.OptionContext):
        print("Visit Option: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        for x in l:
            print("Option text word=" + x.getText())
        optionWord = ''
        for j in range(ctx.getChildCount()-2):
        	optionWord = optionWord + l[j].getText()
        print("OPTION WORD=" + optionWord)
        values = nx.get_node_attributes(EnquestesVisitor.myGraph, 'resposta')
        print("Val=" + values[EnquestesVisitor.actualNode])
        newValue = values[EnquestesVisitor.actualNode] + '\n' + optionWord
        nx.set_node_attributes(EnquestesVisitor.myGraph, newValue, 'resposta')
        EnquestesVisitor.myGraph.graph[EnquestesVisitor.actualNode] = values[EnquestesVisitor.actualNode] + '\n' + optionWord
        print("**************" + EnquestesVisitor.myGraph.graph[EnquestesVisitor.actualNode])

    # Visit a parse tree produced by EnquestesParser#item.
    def visitItem(self, ctx:EnquestesParser.ItemContext):
        print("Visit Item: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        for x in l:
            print("item text=" + x.getText())
        EnquestesVisitor.myGraph.add_edge((l[5]).getText(), (l[9]).getText(), label=(l[0]).getText(), color='blue')
        EnquestesVisitor.dictItems[(l[0]).getText()] = (l[5]).getText()

    # Visit a parse tree produced by EnquestesParser#alternativa.
    def visitAlternativa(self, ctx:EnquestesParser.AlternativaContext):
        print("Visit Alternativa: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        EnquestesVisitor.actualNode = EnquestesVisitor.dictItems[(l[5]).getText()]
        for x in l:
            print("alternativa text=" + x.getText())
        for y in range(8, ctx.getChildCount() - 2):
            self.visit(l[y])

    # Visit a parse tree produced by EnquestesParser#detour.
    def visitDetour(self, ctx:EnquestesParser.DetourContext):
        print("Visit Detour: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        for x in l:
            print("Detour text word=" + x.getText())
        EnquestesVisitor.myGraph.add_edge(EnquestesVisitor.actualNode, EnquestesVisitor.dictItems[(l[3]).getText()], label=str(l[1]), color='green')

    # Visit a parse tree produced by EnquestesParser#enquesta.
    def visitEnquesta(self, ctx:EnquestesParser.EnquestaContext):
        print("Visit Enquesta: count=" + str(ctx.getChildCount()))
        g = ctx.getChildren()
        l = [next(g) for i in range(ctx.getChildCount())]
        EnquestesVisitor.idEnquesta = (l[0]).getText()
        for x in l:
            print("enquesta text=" + x.getText())
        EnquestesVisitor.myGraph.add_node((l[0]).getText())
        parentNode = (l[0]).getText()
        for y in range(5, ctx.getChildCount() - 1, 2):
            EnquestesVisitor.myGraph.add_edge(parentNode, EnquestesVisitor.dictItems[(l[y]).getText()], label='', color='black')
            parentNode = EnquestesVisitor.dictItems[(l[y]).getText()]
            self.visit(l[y])
        EnquestesVisitor.myGraph.add_edge(parentNode, "END", label='', color='black')