	
import pandas
 
# to store data
data = {
  "Usernames": ["admin", "daniel", "sousa"],
  "Passwords": ["password", "kaveri", "kumari"]
}
 
dataframe = pandas.DataFrame(data)
 
# Print the DataFrame
print(dataframe)

dataframe.to_csv("tst.csv", index=False)