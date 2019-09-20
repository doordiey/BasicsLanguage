import pandas as pd
import numpy as np
from sklearn.preprocessing import LabelEncoder,OneHotEncoder
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

dataset = pd.read_csv('50_Startups.csv',sep='\t')
X = dataset.iloc[ : , :-1].values
Y = dataset.iloc[ : ,  4 ].values


labelencoder = LabelEncoder()
X[:, 3] = labelencoder.fit_transform(X[:, 3])
#特殊处理地址的字符串数据
onehotencoder = OneHotEncoder(categorical_features=[3])
X = onehotencoder.fit_transform(X).toarray()
#将地址进行独热编码，消除地址对计算距离的影响

X = X[:, 1:]
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.2, random_state = 0)

regressor = LinearRegression()
regressor.fit(X_train, Y_train)
y_pred = regressor.predict(X_test)
#y_pred为输出结果，为了看出模型的效果可计算比值，输出误差率
print((y_pred-Y_test)/Y_test)
#或者以画图形式显示
a = np.arange(0, 10, 1)
plt.scatter(a, y_pred, color='red')
plt.plot(a, y_pred, color='black')
plt.scatter(a,  Y_test, color='red')
plt.plot(a,  Y_test, color='blue')
plt.show()