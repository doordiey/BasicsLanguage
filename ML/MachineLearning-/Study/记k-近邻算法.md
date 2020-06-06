# k-2近邻算法

## 关于该算法的概念

官方说法是：所谓K近邻算法，即是给定一个训练数据集，对新的输入实例，在训练数据集中找到与该实例最邻近的K个实例， 这K个实例的多数属于某个类，就把该输入实例分类到这个类中。

也就是：在分类时，把类型的主要特征提取出来，按照主要特征的情况将训练集的例子都变为坐标轴上的点，然后将要判断的个例的相关特征也找出并且定位到坐标轴的图片上，根据与其最相近多个的已知点的类型的多数类为预测类型。

也就是：物以类聚，人以群分。

这样一来，就把问题具体为计算坐标轴上点的距离问题。距离越小则越相似。

该算法基础不需要进行训练算法。

## 关键问题：

１．选取什么作为分类的主要区分值。（对错误率影响大

２．选择多少个近邻的值作为判断的依据比较合适。

３．距离计算方面

## 相关实例：

###一、约会网站关于约会对象的优化

#### 想要处理的问题：

####想由已知的三个特征及数据分析中达到预测约会对象是否合适的目的。

前情提要：某人使用约会网站寻找约会对象后，对于约会对象有大致的分类，不喜欢的人，魅力一般的人，极具魅力的人。并收集了三个相关信息作为判断是否有魅力的特征。即：每年获得的飞行常客里程数，玩视频游戏所耗时间百分比，每周消费的冰淇淋公斤数。

#### 关于问题的解决：

##### ①数据的准备:(已有采集好的数据：datingTestSet2.txt)即以下代码中的参数filename。

```
def file2matrix(filename):
    fr = open(filename)　
    numberOfLines = len(fr.readlines())
    returnMat = zeros((numberOfLines,3))
    classLabelVector = []
    fr = open(filename)
    index = 0
    for line in fr.readlines():
        line = line.strip()
        listFromLine = line.split('\t')
        returnMat[index,:] = listFromLine[0:3]
        classLabelVector.append(int(listFromLine[-1]))
        index += 1
     #returnMat为三个特征构成的矩阵即如下格式：
    [[4.0920000e+04 8.3269760e+00 9.5395200e-01]
    ……
    [4.3757000e+04 7.8826010e+00 1.3324460e+00]]
    #classLabelVector为每个数据的所属类型的列表即：
    [3, 2, 1, 1, 1, 1, 3, 3, 1, 3, 1, 1,…… 2, 1, 3, 3, 3]
    return returnMat,classLabelVector

```

```
def picture(datingDataMat,datingLabels):#做散点图，将两个特征值的关系做散点图，可以看出三个类型的分布情况
    fig = plt.figure()
    ax = fig.add_subplot(111)    ax.scatter(datingDataMat[:,1],datingDataMat[:,2],15.0*array(datingLabels),15.0*array(datingLabels))
    plt.show()

```

##### ②为了后续计算的方便，要把每种特征的权重调至合理的大小。即归一化特征值。

##### 也就是把所有特征的权重统一化，不然如果各个特征值差距过大会使后续处理不便以及结果失真。

```
def autoNorm(dataSet):＃此处采用了线性函数转换的方式将各个特征值的权重统一为０－１．
#线性函数转换的表达式为：y=(x-MinValue)/(MaxValue-MinValue)
    minVals = dataSet.min(0)　#最小
    maxVals = dataSet.max(0)　#最大
    ranges = maxVals - minVals #差值
    normDataSet = zeros(shape(dataSet))
    m = dataSet.shape[0]
    normDataSet = dataSet - tile(minVals,(m,1))
    normDataSet = normDataSet / tile(ranges,(m,1))
    return normDataSet,ranges,minVals
    #normDataSet为归一化处理后的数据如下：
    [[0.44832535 0.39805139 0.56233353]
 [0.15873259 0.34195467 0.98724416]
 [0.28542943 0.06892523 0.47449629]
 ...
 [0.29115949 0.50910294 0.51079493]
 [0.52711097 0.43665451 0.4290048 ]
 [0.47940793 0.3768091  0.78571804]]

```

#####③计算距离，以及为近邻判断的依据。

```
def classify0(inX,dataSet,labels,k):
    dataSetSize = dataSet.shape[0]
    diffMat = tile(inX,(dataSetSize,1)) - dataSet //与所有数据都进行距离运算
    sqDiffMat = diffMat**2
    sqDistances = sqDiffMat.sum(axis=1)
    distances = sqDistances**0.5
    #以上几个式子为距离度量的计算（此处的距离为欧式距离)
    sortedDistIndicies = distances.argsort()
    ＃对于距离的大小进行排序
    classCount = {}
    for i in range(k):
        voteIlabel = labels[sortedDistIndicies[i]]
        classCount[voteIlabel] = classCount.get(voteIlabel,0) + 1
    #对最相邻的几个对象的类型的数量进行排序
    sortedClassCount = sorted(classCount.iteritems(),key = operator.itemgetter(1),reverse = True)
    return sortedClassCount[0][0]#取出最多的类型作为预测的结果

```

##### ④将上述步骤整合到一起，完整的步骤。进行测试，查看错误率，以此调整到一个较为合适的k值。（判断是否可以以此作为预测的依据）

```
def datingClassTest():#
    hoRatio = 0.1　#测试数据所占比例
    datingDataMat,datingLabels = file2matrix('datingTestSet2.txt')
    normMat,ranges,minVals = autoNorm(datingDataMat)
    m = normMat.shape[0]
    numTestVecs = int(m * hoRatio)
    print('numTestVecs=',numTestVecs)
    errorCount = 0.0
    for i in range(numTestVecs):
        classifierResult = classify0(normMat[i,:],normMat[numTestVecs:m,:],datingLabels[numTestVecs:m],3)
        print('the classifier came back with: %d ,the real answer is: %d'%(classifierResult,datingLabels[i]))
        #输出结果格式如下：
        [(2, 2), (3, 1)]
the classifier came back with: 2 ,the real answer is: 2
　　　　　因为此处k的值为３，则最后比较的是最相近的三个对象。该输出意味着，三个最相近的对象有两个为类型２，一个为类型１．
        if(classifierResult != datingLabels[i]):
            errorCount += 1.0
    print("the total error rate is: %f"%(errorCount / float(numTestVecs)))
    print (errorCount)

```

##### ⑤	给出三个相关特征的量去预测是否适合作为约会对象。（由上述测试，取k为４时，错误率基本稳定于0.03）

```
def classifyPerson():
    resultList = ['not at all','in small doses','in large doses']
    #输入三个特征相关量
    percentTats = float(raw_input('1:percent of game?'))
    ffMiles = float(raw_input("2:flay?"))
    iceCream = float(raw_input("3:ice-cream?"))
    datingDataMat,datingLabels = file2matrix('datingTestSet2.txt')
    picture(datingDataMat,datingLabels)
    normMat,ranges,minVals = autoNorm(datingDataMat)
    inArr = array([ffMiles,percentTats,iceCream])
    classifierResult = classify0((inArr-minVals)/ranges,normMat,datingLabels,４)
    #运行数据准备，归一化数据，计算距离等步骤后得出结论。
    print(resultList[classifierResult - 1])

```

#### 上述过程中的一些别的概念：

##### ①距离度量

距离度量：用来衡量样本之间的相似性。

五种距离度量的方法：

Ａ.欧式距离:两点之间的直线距离（该问题中用的就是欧式距离）

B.曼哈顿距离：即二维平面上两点a(x1,y1)，b(x2,y2)，其两点之间曼哈顿距离为：d=|x1-x2|+|y1-y2|

C.夹角余弦：把两点看成是空间中的两个向量，通过衡量两向量之间的相似性来衡量样本之间的相似性。

D.切比雪夫距离：样本间各对应坐标数值差的最大值。如a(x1,y1)，b(x2,y2),其两点之间的切比雪夫距离为：d＝max( (|x1-x2|) , (|y1-y2| ) ）

E.汉明距离：两个等长字符串之间的汉明距离是两个字符串对应位置的不同字符的个数。

还有很多关于的距离度量的方法，这个链接有相关的介绍及解释：<https://my.oschina.net/hunglish/blog/787596>

##### ②归一化特征

归一化特征的方法不止有线性函数转换一种，还有对数函数转换、反余切函数转换、还有Z-score标准化方法、Z-scores 简单化。

具体方法的选用与实际问题有关，这一点需要遇到更多的问题才能体会其中的差异。

##### ③numpy 中的tile函数

举例说明：

```
numpy.tile( [ 0 , 0 ] , ( 2 , 3 ) )

结果为：array(
[
[0, 0, 0, 0, 0, 0],  
[0, 0, 0, 0, 0, 0]
]
)
　　　　　　    
numpy.tile([0,0],(1,1)) 
结果为：array([[0, 0]])

```



## 二、手写数字识别系统

### 想要处理的问题：

#### 基于KNN算法，构成一个能识别０－９数字的手写数字识别系统

前情提要：因为是手写的，所以同一个数字的写法多少有一定的差异，但保证这些需要识别的数字和已知的大量数据除了写法不同外，具有相同的色彩和大小：宽高是３２像素*３２像素的黑白图像。

### 关于问题的解决：

#### ①数据的准备(已有采集好的数据，即手写数字的图片)

```
def img2vector(filename):#图片信息的处理 将一张图片３２＊３２的０，１数据逐行依次输出
    returnVect = zeros((1,1024))
    fr = open(filename)
    for i in range(32):
        lineStr = fr.readline()
        for j in range(32):
            returnVect[0,32*i+j] = int(lineStr[j])
    return returnVect
```

#### ②此时无需归一化处理，因为其只有一个特征值，且都在（０，１）之间。

#### ③计算距离，以及为近邻判断的依据。（与上一个问题的计算距离方法相同）

```
def classify0(inX,dataSet,labels,k):
    dataSetSize = dataSet.shape[0]
    diffMat = tile(inX,(dataSetSize,1)) - dataSet
    sqDiffMat = diffMat**2
    sqDistances = sqDiffMat.sum(axis=1)
    distances = sqDistances**0.5
    #以上几个式子为距离度量的计算（此处的距离为欧式距离)
    sortedDistIndicies = distances.argsort()
    ＃对于距离的大小进行排序
    classCount = {}
    for i in range(k):
        voteIlabel = labels[sortedDistIndicies[i]]
        classCount[voteIlabel] = classCount.get(voteIlabel,0) + 1
    #对最相邻的几个对象的类型的数量进行排序
    sortedClassCount = sorted(classCount.iteritems(),key = operator.itemgetter(1),reverse = True)
    return sortedClassCount[0][0]#取出最多的类型作为预测的结果
```

#### ④进行测试，查看其错误率

```
def handwritingClassTest():
    hwLabels = []
    trainingFileList = os.listdir('trainingDigits')
    m = len(trainingFileList)
    trainingMat = zeros((m,1024))
    for i in range(m):
        fileNameStr = trainingFileList[i]
        fileStr = fileNameStr.split('.')[0]
        classNumStr = int(fileStr.split('_')[0])
        hwLabels.append(classNumStr)
        trainingMat[i,:] = img2vector('trainingDigits/%s' % fileNameStr)
    testFileList = os.listdir('testDigits')
    errorCount = 0.0
    mTest = len(testFileList)
    for i in range(mTest):
        fileNameStr = testFileList[i]
        fileStr = fileNameStr.split('.')[0]
        classNumStr = int(fileStr.split('_')[0])
        vectorUnderTest = img2vector('testDigits/%s' % fileNameStr)
        classifierResult = classify0(vectorUnderTest,trainingMat,hwLabels,3)
        print("the classifier came back with: %d, the real answer is: %d" % (classifierResult, classNumStr))
        if (classifierResult != classNumStr):
            errorCount += 1.0
    print "\nthe total number of errors is: %d" % errorCount
    print "\nthe total error rate is: %f" % (errorCount / float(mTest))

#错误率０．０１２左右
```

### 此问题与解决上一个问题的原理相同。

##此处为Brute Force 暴力计算，把所有训练的点之间的距离都算了一遍。消耗大。

#### 主要参考链接：<https://github.com/apachecn/MachineLearning/blob/dev/docs/2.k-%E8%BF%91%E9%82%BB%E7%AE%97%E6%B3%95.md>

参考链接后还介绍了sklearn上的三种算法，除了Brute Force以外，还有KD Tree和Bal Tree的相关介绍。










