user1 = input("What is Player 1's name? ")
user2 = input("What is Player 2's name? ")

user1_ans = input(user1 + ", Enter your choice ").lower()
user2_ans = input(user2 + ", Enter your choice ").lower()
 
if user1_ans == user2_ans:
    print(" tie!")
elif user1_ans == 'rock':
    if user2_ans == 'scissors':
        print("Rock wins")
    else:
        print("Paper wins")

elif user1_ans == 'paper':
    if user2_ans == 'rock':
        print("Paper wins")
    else:
        print("Scissors win!")

elif user1_ans == 'scissors':
    if user2_ans == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins")

else:
    print("Invalid input.")