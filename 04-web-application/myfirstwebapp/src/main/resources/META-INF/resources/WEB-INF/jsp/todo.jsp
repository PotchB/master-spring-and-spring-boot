<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container mt-3">
    <h2 class="text-center">Enter Todo Details</h2>

    <main class="container max-width-400px my-5">

        <form:form class="form-outline" method="POST" modelAttribute="todo">
            
            <!-- Spring Form Tag impt attr: form:form 'modelAttribute' (value must match the variable name of bean or the binding object defined in your Controller Request Handler) -->
            <fieldset class="form-floating mb-3">
                <form:input type="text" class="form-control" id="description" placeholder="Description" path="description" required="required" />
                <form:label for="description" path="description">Description</form:label>
                <form:errors type="hidden" cssClass="text-danger" style="font-size: 0.85rem" path="description" />

                <!-- NOTES -->
                <!-- Spring Form Tag impt attr: form:input 'path' (MUST: path value = bean field name specified in 'form:form modelAttribute' attr) -->
                <!-- Spring Form Tag impt attr: form:errors 'path' (value must match path value from form:input you're making validations on)
                                                        This will display the error if BindingResult has validation errors from your controller -->
                <!-- For using class attr with Spring tags, use 'cssClass' instead of class -->
            </fieldset>

            <fieldset class="form-floating mb-3">
                <form:input type="text" class="form-control" id="targetDate" placeholder="Target Date" path="targetDate" required="required" />
                <form:label for="targetDate" path="targetDate">Target Date</form:label>
                <form:errors type="hidden" cssClass="text-danger" style="font-size: 0.85rem" path="targetDate" />
                
                <!-- NOTES -->
                <!-- Spring Form Tag impt attr: form:input 'path' (MUST: path value = bean field name specified in 'form:form modelAttribute' attr) -->
                <!-- Spring Form Tag impt attr: form:errors 'path' (value must match path value from form:input you're making validations on) 
                                                        This will display the error if BindingResult has validation errors from your controller -->
                <!-- For using class attr with Spring tags, use cssClass instead of class -->
            </fieldset>

            <form:input type="hidden" class="form-control" id="floatingId" path="id" />
            <!-- path value must match the name of the field of the binding object specified in modelAttribute attribute-->

            <form:input type="hidden" class="form-control" id="floatingDone" path="done" />
            <!-- path value must match the name of the field of the binding object specified in modelAttribute attribute-->

            <!-- <small type="hidden" id="errorMessage" class="form-text text-danger">${errorMessage}</small><br> -->
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-success btn-form flex-fill">Submit</button>
            </div>
        </form:form>

    </main>
</div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
    /* $('#targetDate').datepicker({
        format: 'mm-yyyy',
        startView: "months", 
        minViewMode: "months"
    }); */
</script>



