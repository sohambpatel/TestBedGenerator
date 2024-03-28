# Code smell: Poor variable naming
a = 5
b = 10
c = a + b

# Code smell: Magic numbers
if c > 15:
    print("Sum is greater than 15")

# Code smell: Useless comments
# This function adds two numbers
def add_numbers(x, y):
    return x + y  # Adding x and y

result = add_numbers(a, b)

# Code smell: Unused variable
unused_variable = "This variable is unused"

# Code smell: Large function
def complex_function(param1, param2, param3):
    # ... a lot of code ...
    # ... with poor indentation and inconsistent formatting ...
    if some_condition:
        # ... nested code ...
        pass
    # ... more code ...

# Code smell: Redundant code
if a > 0:
    print("a is positive")
else:
    print("a is not positive")

# Code smell: Inconsistent formatting
print("Result:", result)

# Code smell: Using a mutable object as a default parameter
def add_to_list(item, my_list=[]):
    my_list.append(item)
    return my_list

result_list1 = add_to_list(1)
result_list2 = add_to_list(2)

print(result_list1)  # [1, 2] (unexpected result due to mutable default parameter)
print(result_list2)  # [1, 2] (unexpected result due to mutable default parameter)
