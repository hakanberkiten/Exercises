import pandas as pd
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures
import sklearn.metrics as mt

excel = pd.read_csv("C:/Users/hakan/OneDrive/Masaüstü/Machine Learning/Real estate.csv")

data = excel.copy()

data.drop(columns=["No","X1 transaction date","X5 latitude","X6 longitude"],axis=1,inplace=True)


data = data.rename(columns={"X2 house age":"House age","X3 distance to the nearest MRT station":"Distance to the nearest MRT station","X4 number of convenience stores":"Number of convenience stores","Y house price of unit area":"House price of unit area"})

y = data["House price of unit area"]
X = data.drop(columns="House price of unit area",axis=1)



polynomial = PolynomialFeatures(degree=3)
X_pol = polynomial.fit_transform(X)

X_train , X_test , y_train , y_test = train_test_split(X_pol,y,test_size=0.2,random_state=42)

pr = LinearRegression()
pr.fit(X_train,y_train)
prediction = pr.predict(X_test)

r2 = mt.r2_score(y_test,prediction)
mse = mt.mean_squared_error(y_test,prediction)

print("Polynomial R^2 =",r2)
print("Polynomial MSE =",mse)
