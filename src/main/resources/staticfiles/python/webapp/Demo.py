from flask import Flask, request, render_template_string, redirect, url_for

app = Flask(__name__)

# Code smell: Hardcoded secret key
app.secret_key = 'insecure_secret_key'

# Code smell: Using eval, which can lead to code injection
@app.route('/eval', methods=['GET', 'POST'])
def eval_endpoint():
    if request.method == 'POST':
        user_input = request.form.get('code')
        result = eval(user_input)  # Security vulnerability: Code injection
        return render_template_string('<p>Result: {{ result }}</p>', result=result)

    return render_template_string('''
        <form method="post">
            <label for="code">Enter code:</label>
            <input type="text" name="code" id="code" />
            <button type="submit">Evaluate</button>
        </form>
    ''')

# Code smell: Storing passwords in plaintext
users = [
    {'username': 'admin', 'password': 'admin_password'},
    {'username': 'user', 'password': 'user_password'}
]

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        username = request.form.get('username')
        password = request.form.get('password')

        for user in users:
            if user['username'] == username and user['password'] == password:  # Security vulnerability: Plaintext password storage
                return redirect(url_for('dashboard'))

        return render_template_string('<p>Invalid username or password</p>')

    return render_template_string('''
        <form method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" /><br>
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" /><br>
            <button type="submit">Login</button>
        </form>
    ''')

@app.route('/dashboard')
def dashboard():
    return render_template_string('<p>Welcome to the dashboard!</p>')

if __name__ == '__main__':
    app.run(debug=True)
