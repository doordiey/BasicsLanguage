import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix

dataset = pd.read_csv('Social_Network_Ads.csv',sep='\t')
X = dataset.iloc[:,[2,3]].values
y = dataset.iloc[:,4].values

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.25, random_state = 0)
sc = StandardScaler()
#作用：去均值和方差归一化。且是针对每一个特征维度来做的，而不是针对样本。
X_train = sc.fit_transform(X_train)
X_test = sc.transform(X_test)

classifier = LogisticRegression()
classifier.fit(X_train, y_train)
y_pred = classifier.predict(X_test)
cm = confusion_matrix(y_test,y_pred)
#根据模型输出结果与实际统计数据生成混淆矩阵，查看混淆矩阵的效果
#可视化混淆矩阵
plt.imshow(cm)
plt.title('cm')
plt.colorbar()
labels = ["True","False"]
tick_marks = np.arange(len(labels))
plt.xticks(tick_marks,labels)
plt.yticks(tick_marks,labels)
plt.ylabel('Forecast')
plt.xlabel('Real')
plt.show()