<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        /* Custom class for max-width of 330px */
        .max-width-400px {
            max-width: 400px;
            /* You can add more styles if needed */
        }

        .btn {
            margin-top: 1rem;
        }

        label {
            color: #777;
        }
    </style>
</head>

<body>
    <!-- <h1>Welcome to the Login Page, ${name}!</h1> -->
    <!-- ${name} is called an Expression Language -->

    <h1 class="text-center mt-3">Welcome to the Login Page!</h1>

    <main class="container-sm max-width-400px my-5">
        <form class="form-outline" method="POST">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingUsername" placeholder="Username" name="name">       <!-- name value must match the name declared in @RequestParam variable name in LoginController -->
                <label for="floatingUsername">Username</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">       <!-- name value must match the name declared in @RequestParam variable name in LoginController -->
                <label for="floatingPassword">Password</label>
            </div>
            <small type="hidden" id="errorMessage" class="form-text text-danger">${errorMessage}</small><br>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary flex-fill">Submit</button>
            </div>
        </form>
    </main>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>

</html>