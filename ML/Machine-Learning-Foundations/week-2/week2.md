# week-2

## Perceptron Hypothesis Set

- 机器学习演算法解决是非题（化为数学平面上线性分类问题）

  - 把不同特征整合起来用向量表示。（即不同特征为不同维度）

  - 为了数学计算的便捷（将是与非定义为1和-1）

  - 感知器（perceptron)如下：

    ![1](https://github.com/doordiey/Machine-Learning-Foundations/week-2/image/1.png)

    此为对于h（x)函数的处理。其中的w为权重。h(x)为感知器，也被称为线性分类器。

    每个h定位到平面上的一条线，每个x定位到平面上的点。

## Perceptron Learning Algorithm

- 关于线性回归的完善提出的PLA算法。（通过下图从向量角度理解机器学习如何修正错误。）

  对下图的解释：红色为当前线的法向量，黑色的为错误的点的向量，而紫色的线为修正后的线的法向量方向。

![2](https://github.com/doordiey/Machine-Learning-Foundations/week-2/image/2.png)

- correct PLA

循环检测是否有值在犯错，当检测到没有值在犯错时，循环停止，机器学习结束，给出当前的h(x)。

- 核心：找出一个犯错的点，用犯错的点对线进行修正。

## Guarantee of PLA

- 关于PLA什么时候停下来。

Linear Separability：线性可分。只有当资料是线性可分时，PLA才可能停下来。即存在一条完美的线可以使不同类别的点分布在线的两边。

部分内容的数学推导。（利用向量内积分析犯错更新其中的数学原理表明每次更新会使线不断修正并且会停止。）

- PLA停止时间的推导
  - 推导公式结果为：![3](https://github.com/doordiey/Machine-Learning-Foundations/week-2/image/3.png)

其中：两个向量最大内积为1。Wf为最符合的线的向量。

## Non-Seperable Data

- 我们的资料可能是非线性可分的，也可能资料存在噪音。

当资料是存在噪音时，我们找一条犯错误最少的线而不是不犯错误的线。

- Pocket Algorithm（找到一个犯错误最少的线）

在PLA的算法上进行一定的更改。随机找一个犯错误的向量对线进行修正，不断的找，只保留效果最好的weights，这样的算法不会自动停下。（也可以不错的解决一些非线性可分问题找到一条不错的线。）

PA会比PLA运算的更慢。（慢在存储以及对两个weights的比较计算上。）





