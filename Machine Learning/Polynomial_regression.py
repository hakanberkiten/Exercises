import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
import sklearn.metrics as mt
from sklearn.preprocessing import PolynomialFeatures

excel = pd.read_excel("C:/Users/hakan/OneDrive/Masaüstü/Machine Learning/Temperature-Efficiency.xlsx")

data = excel.copy()


X = data["Temperature"]
y = data.drop(columns="Temperature",axis=1)

X = X.values.reshape(-1,1)
y = y.values.reshape(-1,1)



lr = LinearRegression()
lr.fit(X,y)

prediction = lr.predict(X)

r2_linear = mt.r2_score(y,prediction)
mse_linear = mt.mean_squared_error(y,prediction)

print("Linear R^2 =",r2_linear)
print("Linear MSE =",mse_linear)

polynom = PolynomialFeatures(degree=3)

X_polynom = polynom.fit_transform(X)

lr2 = LinearRegression()
lr2.fit(X_polynom,y)

prediction2  = lr2.predict(X_polynom)

r2_polynom = mt.r2_score(y,prediction2)
mse_polynom = mt.mean_squared_error(y,prediction2)

print("Polynomial R^2 =",r2_polynom)
print("Polynomial MSE =",mse_polynom)

plt.scatter(X,y , color = 'red')
plt.plot(X,prediction2 , color = 'blue')
plt.show()