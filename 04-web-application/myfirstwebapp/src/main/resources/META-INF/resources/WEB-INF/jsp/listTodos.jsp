<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container mt-3">
    <!-- Bootstrap recommendation is to put all content in a div tag with container class -->
    <!-- <h1 class="text-center mt-3">Welcome to Todos Web App, <i style="color:orange">${name}</i>!</h1>
<hr> -->
    <h2>Your Todos</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <!-- <th>id</th> -->
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <!-- <td path="id">${todo.id}</td> -->
                    <td path="description">${todo.description}</td>
                    <td path="targetDate">${todo.targetDate}</td>
                    <td path="done">${todo.done}</td>
                    <td>
                        <a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                    </td>
                    <td>
                        <a href="/update-todo?id=${todo.id}" class="btn btn-warning">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- <button type="button" class="btn btn-primary blue">Add Todo</button> -->
    <a href="/add-todo" class="btn btn-success">Add Todo</a>
</div>

<%@ include file="common/footer.jspf" %>