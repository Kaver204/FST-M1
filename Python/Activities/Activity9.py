
listOne = [67, 34, 23, 11, 17]
listTwo = [78, 43, 24, 87, 22]
 
# Print the lists
print("list 1" ,listOne)
print("list 2", listTwo)
 
list3 = []
 
# Iterate through first list to get odd elements
for num in listOne:
    if (num % 2 != 0):
        list3.append(num)
        
# Iterate 
for num in listTwo:
    if (num % 2 == 0):
        list3.append(num)
 
# Print result
print("result List is:")
print(list3)