import pandas as pd
from sklearn.model_selection import train_test_split
import statsmodels.api as sm
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

data = pd.read_csv("C:/Users/hakan/OneDrive/Masaüstü/Machine Learning/advertising.csv")


X = data[["TV","Radio","Newspaper"]]
y = data["Sales"]

constant = sm.add_constant(X)
model = sm.OLS(y,constant).fit()



X_train , X_test , y_train , y_test = train_test_split(X,y , test_size=0.2,random_state=42)

lr = LinearRegression()

lr.fit(X_train, y_train)
y_predict = lr.predict(X_test)

y_test = y_test.sort_index()

data_frame = pd.DataFrame({"Real values":y_test,"Predictions":y_predict})
data_frame.plot(kind="line")
plt.show()