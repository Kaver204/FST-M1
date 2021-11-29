	
def fibonacci(number):
    if number <= 1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))
 
noOfterms = int(input("Enter a number: "))
 
if noOfterms <= 0:
    print(" enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(noOfterms):
        print(fibonacci(i))