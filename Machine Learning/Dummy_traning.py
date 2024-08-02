import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import sklearn.metrics as mt
data_set = sns.load_dataset("tips")

data = data_set.copy()



categorical = data.select_dtypes(include=["category"])

categories = []
for i in categorical.columns:
    categories.append(i)


data = pd.get_dummies(data,columns=categories,drop_first=True)

y = data["tip"]
X = data.drop(columns="tip",axis=1)

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.8, random_state=42)

lr = LinearRegression()

lr.fit(X_train,y_train)

prediction = lr.predict(X_test)

y_test = y_test.sort_index()

df = pd.DataFrame({"Real Values":y_test,"Predicton":prediction})

df.plot(kind="line")
plt.show()

print(mt.mean_absolute_error(y_test,prediction))