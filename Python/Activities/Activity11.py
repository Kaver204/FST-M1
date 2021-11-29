fruit_shop = {
    "guava": 11,
    "banana": 15,
    "orange": 8,
    "pomegranate": 16
}
 
item = input("What are you looking for? ").lower()
 
if(item in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")
