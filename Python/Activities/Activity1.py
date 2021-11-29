name=input ("Enter your name: ")
age=input ("Enter your age: ")
age1=int(age)
year = ( 2020 - age1) + 100
print (year)
msg=name+" will be of 100 yrs. in the year:{} "
print (msg.format(year))