import pandas as pd
from sklearn.model_selection import train_test_split , KFold
from sklearn.linear_model import LinearRegression
import sklearn.metrics as mt

ex = pd.read_csv("C:/Users/hakan/OneDrive/Masaüstü/Machine Learning/advertising.csv") 

data = ex.copy() 

y = data["Sales"]
X = data.drop(columns="Sales",axis=1)

X_train , X_test, y_train , y_test = train_test_split(X,y,train_size=0.2,random_state=42) 

lr = LinearRegression() 

model = lr.fit(X_train,y_train) 


def score(model,X_train,X_test,y_train,y_test): 
    train_prediction = model.predict(X_train)
    test_prediction = model.predict(X_test)
    
    r2_train = mt.r2_score(y_train,train_prediction)
    r2_test = mt.r2_score(y_test , test_prediction)
    
    mse_train = mt.mean_squared_error(y_train,train_prediction)
    mse_test = mt.mean_squared_error(y_test , test_prediction)
    
    return [r2_train,r2_test,mse_train,mse_test]



linear = LinearRegression()
k = 5
i = 1

best_index = -1
best_r2_test = -float('inf')
best_train_index = None
best_test_index = None

fold = KFold(n_splits=k)

for train_index , test_index in fold.split(X):
    X_train , X_test = X.loc[train_index],X.loc[test_index]
    y_train , y_test =  y.loc[train_index],y.loc[test_index]
    linear.fit(X_train, y_train)
    result = score(model=lr,X_train=X_train,X_test=X_test,y_train=y_train,y_test=y_test)
    
    if result[1] > best_r2_test:  
        best_r2_test = result[1]
        best_index = i
        best_train_index = train_index
        best_test_index = test_index
    
    i += 1


best_X_train, best_X_test = X.loc[best_train_index], X.loc[best_test_index]
best_y_train, best_y_test = y.loc[best_train_index], y.loc[best_test_index]

best_model = LinearRegression()
best_model.fit(best_X_train, best_y_train)

best_result = score(model=best_model, X_train=best_X_train, X_test=best_X_test, y_train=best_y_train, y_test=best_y_test)
print("Train R2 =", best_result[0])
print("Train MSE =", best_result[2])
print("Test R2 =", best_result[1])
print("Test MSE =", best_result[3])