import pandas as pd
from sklearn.impute import SimpleImputer
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import sklearn.metrics as mt

ex = pd.read_excel("C:/Users/hakan/OneDrive/Masaüstü/Machine Learning/advertising2.xlsx")

data = ex.copy()


imputer = SimpleImputer(missing_values=np.nan,strategy="mean")

imputer = imputer.fit(data)

data.iloc[:,:] = imputer.transform(data)

y = data["Sales"]
X = data[["TV","Radio"]]

X_train , X_test , y_train, y_test = train_test_split(X,y,test_size=0.2,random_state=42)

lr = LinearRegression()
lr.fit(X_train,y_train)

prediction = lr.predict(X_test)

r2 = mt.r2_score(y_test,prediction)

mse = mt.mean_squared_error(y_test,prediction)

rmse = mt.mean_squared_error(y_test,prediction,squared=False)

mae = mt.mean_absolute_error(y_test,prediction)

print(r2)
print(mse)
print(rmse)
print(mae)
