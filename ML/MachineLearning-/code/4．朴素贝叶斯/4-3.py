import operator
import re
import feedparser
import random

def bagOfWords2VecMN(vocaList, inputSet):
    returnVec = [0] * len(vocabList)
    for word in inputSet:
        if word in vocaList:
            returnVec[vocabList.index(word)] += 1
    return returnVec


def createVocabList(dataSet):
    vocabSet = set([])  # create empty set
    for document in dataSet:
        vocabSet = vocabSet | set(document)  # union of the two sets
    return list(vocabSet)

def textParse(bigString):
    listOfTokens=re.split(r'\W*', bigString)
    return [tok.lower() for tok in listOfTokens if len(tok)>2]


def calcMostFreq(vocabList,fullText):
    freqDict={}
    for token in vocabList:  
        freqDict[token]=fullText.count(token)  
    sortedFreq=sorted(freqDict.iteritems(),key=operator.itemgetter(1),reverse=True) 
    return sortedFreq[:30]   


def localWords(feed1,feed0):
    docList=[]
    classList=[]
    fullText=[]
    minLen=min(len(feed1['entries']),len(feed0['entries']))
    for i in range(minLen):
        wordList=textParse(feed1['entries'][i]['summary'])
        docList.append(wordList)
        fullText.extend(wordList)
        classList.append(1)
        wordList=textParse(feed0['entries'][i]['summary'])
        docList.append(wordList)
        fullText.extend(wordList)
        classList.append(0)
    vocabList=createVocabList(docList)
    top30Words=calcMostFreq(vocabList,fullText)
    for pairW in top30Words:
        if pairW[0] in vocabList:
            vocabList.remove(pairW[0]) 
    trainingSet=range(2*minLen)
    testSet=[]
    for i in range(20):
        randIndex=int(random.uniform(0,len(trainingSet)))
        testSet.append(trainingSet[randIndex])
        del(trainingSet[randIndex])
    trainMat=[];trainClasses=[]
    for docIndex in trainingSet:
        trainMat.append(bagOfWords2VecMN(vocabList,docList[docIndex]))
        trainClasses.append(classList[docIndex])
    p0V,p1V,pSpam=trainNB0(array(trainMat),array(trainClasses))
    errorCount=0
    for docIndex in testSet:
        wordVector=bagOfWords2VecMN(vocabList,docList[docIndex])
        if classifyNB(array(wordVector),p0V,p1V,pSpam)!=classList[docIndex]:
            errorCount+=1
    print 'the error rate is:',float(errorCount)/len(testSet)
    return vocabList,p0V,p1V


def getTopWords(ny,sf):
    vocabList,p0V,p1V=localWords(ny,sf)
    topNY=[];topSF=[]
    for i in range(len(p0V)):
        if p0V[i]>-6.0:
            topSF.append((vocabList[i],p0V[i]))
        if p1V[i]>-6.0:
            topNY.append((vocabList[i],p1V[i]))
    sortedSF=sorted(topSF,key=lambda pair:pair[1],reverse=True)
    print "SF**SF**SF**SF**SF**SF**SF**SF**SF**SF**SF**SF**SF**SF**"
    for item in sortedSF:
        print item[0]
    sortedNY=sorted(topNY,key=lambda pair:pair[1],reverse=True)
    print "NY**NY**NY**NY**NY**NY**NY**NY**NY**NY**NY**NY**NY**NY**"
    for item in sortedNY:
        print item[0]


if __name__ == "__main__":
    ny=feedparser.parse('http://newyork.craigslist.org/stp/index.rss')
    sf=feedparser.parse('http://sfbay.craigslist.org/stp/index.rss')
    getTopWords(ny,sf)
