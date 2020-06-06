# week-1

这里是第一周相关的笔记。

## Welcome

什么是机器学习,关于本课程会学到什么。

## Introduction

机器学习的一些应用实例的介绍。

机器学习的定义：

- 在特定编程的情况下，给予计算机学习能力的领域。 —Arthur Samuel

### Supervised Learning

监督学习中，对于数据集中的每个数据，都有相应的正确答案。

### Unsupervised Learning

无监督学习。【聚类算法】

## Review

一些关于监督学习和非监督学习问题判断的题目。

关于是分类还是回归的一些题目。

## Model and Cost Function

### Model Representation

#### m:训练集数量

#### x:输入变量/特征

#### y:输出变量/目标变量

#### h:假设函数（是一个函数映射）

### Cost Function

下面这个代价函数也被称为平方误差代价函数。【还有别的类型的代价函数】
$$
J(\theta_0, \theta_1) = \dfrac {1}{2m} \displaystyle \sum _{i=1}^m \left ( \hat{y}_{i}- y_{i} \right)^2 = \dfrac {1}{2m} \displaystyle \sum _{i=1}^m \left (h_\theta (x_{i}) - y_{i} \right)^2
$$

#### Cost Function - Intuition I

举例说明如何选择参数使得代价函数的值变小。

#### Cost Function - Intuition II

##### 目标函数：

$$
minJ(\theta_0, \theta_1)
$$

可视化用轮廓图展示一般代价函数的图。

## Parameter Learning

### Gradient Descent

梯度下降算法。

##### 参数更新要同步更新

更新参数的公式为：
$$
\theta_j := \theta_j - \alpha \frac{\partial}{\partial \theta_j} J(\theta_0, \theta_1)
$$

#### Gradient Descent Intuition 

解释更新公式中各项的作用。

偏导的作用求代价函数某点的斜率即将参数往靠近最小值的点移动。

由于靠近最优解时偏导的值会不断减少，所以不必特意减小α的值。

当参数以及到达局部最优点时不再移动。

#### Gradient Descent For Linear Regression

线性回归中利用梯度下降更新参数的公式：
$$
\begin{align*} \text{repeat until convergence: } \lbrace & \newline \theta_0 := & \theta_0 - \alpha \frac{1}{m} \sum\limits_{i=1}^{m}(h_\theta(x_{i}) - y_{i}) \newline \theta_1 := & \theta_1 - \alpha \frac{1}{m} \sum\limits_{i=1}^{m}\left((h_\theta(x_{i}) - y_{i}) x_{i}\right) \newline \rbrace& \end{align*}
$$

## Review

## Linear Algebra Review

### Matrices and Vectors

矩阵与向量的基本介绍。

### Addition and Scalar Multiplication

矩阵基础之加减乘除。

### Matrix Vector Multiplication

矩阵基础之矩阵与向量的乘积。

### Matrix Matrix Multiplication

矩阵基础之矩阵与矩阵的乘积。

### Matrix Multiplication properties

### Inverse and Transpose

逆矩阵与转置。

pinv函数求矩阵的逆。

## Review

