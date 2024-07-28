import pandas as pd
from sklearn.model_selection import train_test_split
import statsmodels.api as sm
from sklearn.metrics import mean_squared_error
from sklearn.metrics import mean_absolute_error
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

data = pd.read_csv("C:/Users/hakan/OneDrive/Masaüstü/Machine Learning/Salary_Data.csv") # Import the data from .csv file

y = data["Salary"] # Define dependent variable
X = data["YearsExperience"] # Define independent variable



constant = sm.add_constant(X) # Add constant your model

model = sm.OLS(y,constant).fit() # Define your model


X_train , X_test , y_train , y_test = train_test_split(X,y,test_size=0.3,random_state=42) # Split your data as train and test


lr = LinearRegression() # Define your linear regression
lr.fit(X_train.values.reshape(-1, 1), y_train) # Add your train values your linear regression model

y_predict = lr.predict(X_test.values.reshape(-1, 1)) # Predict the dependent values according to test values

plt.scatter(X_test, y_test, color='red', label='Real values') # Draw points for real values
plt.plot(X_test, y_predict, color='blue', label='Predictions') # Draw the linear line for predictions
plt.xlabel('Years Experience')
plt.ylabel('Salary')
plt.title('Salary - Years Experince Relationship')
plt.legend()
plt.show()



print("y = " , lr.intercept_ , "+" , lr.coef_,"x") # Print equation

mse = mean_squared_error(y_test , y_predict) # Calculate mean squared error for validation
mae = mean_absolute_error(y_test , y_predict) # Calculate mean absulate error for validation

print(mse)
print(mae)





