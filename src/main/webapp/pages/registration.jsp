<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Registration</title>
        <link rel="stylesheet" type="text/css" href="css/register.css">
    </head>
    <body>
        <form action="Controller">
          <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>

            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required></br>

            <label for="psw-repeat"><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required></br>

            <label for="Home City"><b>Home City</b></label>
            <input type="text" placeholder="Enter Home City" name="Home City" required></br>

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