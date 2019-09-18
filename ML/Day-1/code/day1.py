import pandas as pd
import numpy as np
from sklearn.preprocessing import Imputer,LabelEncoder,OneHotEncoder,StandardScaler
from sklearn.model_selection import train_test_split
# 引入必要的库，其中sklearn.cross_validation的名字已经替换

dataset = pd.read_csv('Data.csv')
X = dataset.iloc[:,:-1].values
#iloc 基于整数位置的索引，先行后列
Y = dataset.iloc[:,3].values
imputer = Imputer(missing_values="NaN",strategy="mean",axis=0)
#Imputer用于填补数据缺失值，定义填补规则，按列寻找为'NAN'的缺失值，用该列的平均值将它补全
#其中missing_values缺失值可以为整数或NaN，默认为NaN
#strategy 参数标识替换策略，接收string.默认用均值'mean'，还可以用中位数‘median',众数'most_frequent'
#axis :指定轴数，默认为0代表列，1为行。
imputer = imputer.fit(X[:,1:3])
X[:,1:3] = imputer.transform(X[:,1:3])
labelencoder_X = LabelEncoder()
#用以标签规范化的工具
X[:,0] = labelencoder_X.fit_transform(X[:,0])
#对X数据中所有行的第0列数据进行数据编码
onehotencoder  = OneHotEncoder(categorical_features=[0])
#对第0行数据进行
X = onehotencoder.fit_transform(X).toarray()
labelencoder_Y = LabelEncoder()
Y = labelencoder_Y.fit_transform(Y)
X_train,X_test,Y_train,Y_test = train_test_split(X,Y,test_size=0.2,random_state=0)
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.fit_transform(X.test)

