<!DOCTYPE html>
<html>
<head>
    <title>Playlist Spotify</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1DB954;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 300px;
            text-align: center;
        }

        h1 {
            color: #191414; /* Warna judul */
            font-size: 32px;
            margin-bottom: 20px;
            text-align: center;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        }

        form {
            margin-bottom: 20px;
        }

        form label {
            display: block;
            text-align: left;
            margin-bottom: 8px;
            color: #191414;
            font-weight: bold;
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
            margin-top: 10px; /* Menambahkan margin top */
        }

        form input[type="submit"]:hover {
            background-color: #000;
        }

        pre {
            background-color: #f5f5f5;
            padding: 20px;
            border-radius: 10px;
            margin-top: 20px;
            font-size: 14px;
            color: #333;
        }

        .register-link {
            color: #191414;
            text-decoration: underline;
            cursor: pointer;
        }

        /* New CSS for radio buttons */
        input[type="radio"]:checked + span {
            background-color: #1DB954;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="card">
    <h1><span style="color: #00bfff;">Playlist</span> Spotify</h1> <!-- Memberikan warna elegan pada judul -->
    <form action="LoginAuth" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" placeholder="Enter your email" required/><br/>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required/><br/>

        <div class="role-select">
            <label for="admin">
                <input type="radio" id="admin" name="role" value="admin" required/>
                <span>Admin</span>
            </label>
            <label for="user">
                <input type="radio" id="user" name="role" value="user" required/>
                <span>User</span>
            </label>
        </div>

        <input type="submit" value="LOGIN"/>
    </form>
    <p>If you haven't registered yet, please <span class="register-link" onclick="goToRegister()">register first</span>.</p>
    <pre>
        <!-- Place any additional information or messages here -->
    </pre>
</div>

<script>
    function goToRegister() {
        window.location.href = "register.jsp";
    }
</script>
</body>
</html>
