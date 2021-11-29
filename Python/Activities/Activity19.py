	
import pandas	
from pandas import ExcelFile
from pandas import ExcelWriter
 

data = {
	'FirstName':["daniel", "sousa", "kaveri"],
	'LastName':["sousa", "kumari", "sousa"],
	'Email':["daniel@example.com", "sousa@example.com", "kaveri.rath@example.com"],
	'PhoneNumber':["1343893923", "3433434233", "32334343434"]
}
 
# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)
print(dataframe)
 
# Write the dataframe to a Excel file
writer = ExcelWriter('tst1.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)
writer.save()