<!DOCTYPE html>
<html>
<head>
    <title>Register Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1DB954;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }

        .card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 300px;
            text-align: center;
        }

        h2 {
            color: #191414;
            margin: 0 0 20px;
            text-align: center;
            font-size: 24px;
        }

        form {
            margin-bottom: 20px;
        }

        form input[type="text"],
        form input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            box-sizing: border-box;
            outline: none;
            background-color: #f2f2f2;
            color: #191414;
        }

        .role-select {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            margin-top: 20px;
        }

        .role-select label {
            margin-right: 10px;
            color: #191414;
            font-weight: bold;
            cursor: pointer;
        }

        .role-select input[type="radio"] {
            display: none;
        }

        .role-select label span {
            position: relative;
            padding: 10px 20px;
            border-radius: 30px;
            background-color: #f2f2f2;
            color: #191414;
            transition: background-color 0.3s, color 0.3s;
        }

        .role-select input[type="radio"]:checked + label span {
            background-color: #191414;
            color: #fff;
        }

        .role-select input[type="radio"]:checked + label:before {
            content: "";
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 10px;
            height: 10px;
            border-radius: 50%;
            background-color: #fff;
        }

        form input[type="submit"] {
            padding: 12px;
            background-color: #191414;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
            transition: background-color 0.3s;
            margin-top: 20px; /* Menambahkan margin-top */
        }

        form input[type="submit"]:hover {
            background-color: #000;
        }

        p {
            margin: 0;
            text-align: center;
        }

        .login-link {
            color: #191414;
            text-decoration: underline;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="card">
    <h2>Please Register!</h2>
    <form action="Register" method="post">
        <input type="text" name="email" placeholder="Email" required><br>
        <input type="password" name="password" placeholder="Password" required><br>

        <div class="role-select">
            <input type="radio" id="admin" name="role" value="admin" required/>
            <label for="admin"><span>Admin</span></label>
            <input type="radio" id="user" name="role" value="user" required/>
            <label for="user"><span>User</span></label>
        </div>

        <input type="submit" value="REGISTER">
    </form>
    <p>If you have already registered, please <span class="login-link" onclick="goToLogin()">login</span>.</p>
</div>

<script>
    function goToLogin() {
        window.location.href = "index.jsp";
    }
</script>
</body>
</html>
