<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>

    <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- <h1>Welcome to the Login Page, ${name}!</h1> -->
    <!-- ${name} is called an Expression Language -->
    <div class="container mt-3">
        <h1 class="text-center">Welcome to Todos Web App, <i style="color:orange">${name}</i>!</h1>
        <a href="list-todos">Manage</a> your todos
    </div>


    <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>