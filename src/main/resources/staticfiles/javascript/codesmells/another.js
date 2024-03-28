const bcrypt = require('bcrypt');
const mysql = require('mysql');
const express = require('express');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

// Database connection parameters (replace with your actual database details)
const dbConfig = {
  host: 'localhost',
  user: 'root',
  password: 'password',
  database: 'secure_login_db',
};

const connection = mysql.createConnection(dbConfig);

// Security critical code: Password hashing with bcrypt
const saltRounds = 10;

app.post('/login', (req, res) => {
  const { username, password } = req.body;

  // Security critical code: Parameterized SQL query to prevent SQL injection
  const query = 'SELECT * FROM users WHERE username = ?';
  connection.query(query, [username], (err, results) => {
    if (err) {
      console.error('Database error:', err);
      return res.status(500).send('Internal Server Error');
    }

    if (results.length === 1) {
      const hashedPassword = results[0].password;

      // Security critical code: Verify password with bcrypt
      bcrypt.compare(password, hashedPassword, (bcryptErr, bcryptRes) => {
        if (bcryptErr) {
          console.error('Bcrypt error:', bcryptErr);
          return res.status(500).send('Internal Server Error');
        }

        if (bcryptRes) {
          res.status(200).send('Login successful!');
        } else {
          res.status(401).send('Invalid username or password');
        }
      });
    } else {
      res.status(401).send('Invalid username or password');
    }
  });
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});
