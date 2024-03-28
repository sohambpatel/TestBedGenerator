import os

# Code smell: Hardcoded credentials
db_username = "admin"
db_password = "admin_password"

def connect_to_database():
    # Code smell: Using root credentials
    os.system(f"mysql -u {db_username} -p{db_password} -e 'SELECT * FROM users'")

# Code smell: Insecure file handling
def read_sensitive_file(file_path):
    with open(file_path, 'r') as file:
        content = file.read()
        # Process content (e.g., print or use sensitive information)
        print(content)

# Code smell: Lack of input validation
def execute_command(command):
    # Security vulnerability: Command injection
    os.system(command)

if __name__ == "__main__":
    connect_to_database()

    # Assuming "sensitive_file.txt" contains sensitive information
    read_sensitive_file("sensitive_file.txt")

    # Assuming user-provided input
    user_input = input("Enter a command: ")
    execute_command(user_input)
