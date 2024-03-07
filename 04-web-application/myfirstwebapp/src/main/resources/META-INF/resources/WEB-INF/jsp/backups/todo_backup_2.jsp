<!-- To Configure a Form Backing Object to bind an object from TodoController  -->
<!-- Search Google for "Spring For Tag Library Documentation" -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add New Todo</title>

        <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >

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
                color: #999;
            }
        </style>
    </head>

    <body>
        <!-- <h1>Welcome to the Login Page, ${name}!</h1> -->
        <!-- ${name} is called an Expression Language -->

        <div class="container mt-3">
            <h2 class="text-center">Enter Todo Details</h2>

            <main class="container max-width-400px my-5">

                <form:form class="form-outline" method="POST" modelAttribute="todo">
                    <!-- Spring Form Tag impt attr: form:form 'modelAttribute' (value must match the variable name of bean or the binding object defined in your Controller Request Handler) -->
                    <fieldset class="form-floating mb-3">
                        <form:input type="text" class="form-control" id="floatingDescription" placeholder="Description" path="description" required="required" />
                        <!-- Spring Form Tag impt attr: form:input 'path' (value must match the name of the field of the binding object specified in modelAttribute attribute) -->
                        <form:label for="floatingDescription" path="description">Description</form:label>

                        <form:errors cssClass="text-warning" path="description" />
                        <!-- Spring Form Tag impt attr: form:errors 'path' (value must match path value from form:input you're making validations on) This will display the error if BindingResult has validation errors from your controller -->
                        <!-- For using class attr with Spring tags, use cssClass instead of class -->
                    </fieldset>

                    <fieldset class="form-floating mb-3">
                        <form:input type="text" class="form-control" id="targetDate" placeholder="Target Date" path="targetDate" required="required" />
                        <!-- Spring Form Tag impt attr: form:input 'path' (value must match the name of the field of the binding object specified in modelAttribute attribute) -->
                        <form:label for="floatingDescription" path="targetDate">Target Date</form:label>

                        <form:errors cssClass="text-warning" path="targetDate" />
                        <!-- Spring Form Tag impt attr: form:errors 'path' (value must match path value from form:input you're making validations on) This will display the error if BindingResult has validation errors from your controller -->
                        <!-- For using class attr with Spring tags, use cssClass instead of class -->
                    </fieldset>


                    <form:input type="hidden" class="form-control" id="floatingId" path="id" />
                    <!-- path value must match the name of the field of the binding object specified in modelAttribute attribute-->

                    <form:input type="hidden" class="form-control" id="floatingDone" path="done" />
                    <!-- path value must match the name of the field of the binding object specified in modelAttribute attribute-->

                    <!-- <div class="form-floating">
                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example"
                        name="done">
                        <option value=" " selected disabled hidden></option>
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                    <label for="floatingSelect">Is done?</label>
                </div> -->

                    <!-- <small type="hidden" id="errorMessage" class="form-text text-danger">${errorMessage}</small><br> -->
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-success flex-fill">Submit</button>
                    </div>
                </form:form>

            </main>
        </div>


        <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
        <!-- Bootstrap DatePicker -->
        <script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript">
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>
    </body>

    </html>