import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression

dataset = pd.read_csv('studentscores.csv',sep='\t')
#读取数据集，sep参数设置列之间的分割符号
X = dataset.iloc[:, :1].values
Y = dataset.iloc[:, 1].values
#将X和Y信息从数据集中提取出来
X_train, X_test, Y_train, Y_test = train_test_split( X, Y, test_size = 1/4, random_state = 0)
#将数据集进行分类，分为测试集和训练集

regressor = LinearRegression()
#调用模型
regressor = regressor.fit(X_train,Y_train)
#将训练集数据投入模型

Y_pred = regressor.predict(X_test)
#得到模型的输出结果

#可视化表示
plt.scatter(X_train,Y_train,color='red')
plt.plot(X_train,regressor.predict(X_train),color='blue')
plt.scatter(X_test , Y_test, color = 'red')
plt.plot(X_test , regressor.predict(X_test), color ='blue')
plt.show()