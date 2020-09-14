<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="./../css/register.css">
</head>
<body>
<form action="../Controller" method="post">
    <input type="hidden" name="command" value="registration"/>
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter Login" name="login" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required></br>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required></br>

        <label for="full name"><b>Full Name</b></label>
        <input type="text" placeholder="Enter Full Name" name="full-name" required></br>

        <label for="Home City"><b>Home City</b></label>
        <input type="text" placeholder="Enter Home City" name="home-city" required></br>

        <label for="Phone Number"><b>Phone Number</b></label>
        <input type="number" placeholder="Enter Phone Number" name="phone-number" required></br>

        <label for="Birthday"><b>Birthday</b></label>
        <input type="text" placeholder="Enter Birthday" name="birthday" required></br>

        <label for="email"><b>email</b></label>
        <input type="text" placeholder="Enter email" name="email" required></br>

        <hr>

        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="#">Sign in</a>.</p>
    </div>
</form>
</body>
</html>