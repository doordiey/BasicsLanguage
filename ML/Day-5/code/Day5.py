import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import confusion_matrix

dataset = pd.read_csv('Social_Network_Ads.csv',sep='\t')
X = dataset.iloc[:, [2, 3]].values
y = dataset.iloc[:, 4].values
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.25, random_state = 0)
sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.transform(X_test)
#以上部分为数据预处理，与之前一样

classifier = KNeighborsClassifier(n_neighbors=5,metric='minkowski',p=2)
classifier.fit(X_train,y_train)
#n_neighbors取近邻点的个数
# p：p=1为欧式距离，p=2为曼哈顿距离。
#metric 度量： minkowski：闵可夫斯基不等式
y_pred = classifier.predict(X_test)

cm = confusion_matrix(y_test,y_pred)

print(cm)
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