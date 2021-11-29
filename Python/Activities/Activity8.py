numList = [10, 20, 30, 40, 10]
print(" list: ", numList)
 
#  first element in list
firstElement = numList[0]
#  last element in list
lastElement = numList[len(numList)-1]
# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)