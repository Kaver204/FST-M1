import pytest
 
# Additon test
def test_addition():
	num1 = 11
	num2 = 22
	sum = num1 + num2
	assert sum == 33
 
# Subtraction test
def test_subtraction():
	num1 = 50
	num2 = 20
	diff = num1 - num2
	assert diff == 30
 
# Multiplication test
@pytest.mark.activity
def test_multiplication():
	num1 = 15
	num2 = 15
	prod = num1 * num2
	assert prod == 225
 
# Division test
	
@pytest.mark.activity
def test_division():
	num1 = 200
	num2 = 5
	div = num1 / num2
	assert div == 40