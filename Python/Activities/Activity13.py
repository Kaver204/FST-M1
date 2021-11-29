	
# Custom function 
def calculate_sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum
 
numList = [10, 47, 68, 88]
 
# Call the sum() function with numList as argument
result = calculate_sum(numList)
 
# Print result with message
print("The sum of all the elements is: " + str(result))
