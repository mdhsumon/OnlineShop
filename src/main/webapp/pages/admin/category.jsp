<%@ include file="header.jsp" %>
<%@ page import="com.onineshop.dtos.CategoryDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<div class="container">
    <div class="row">
        <div class="col-3">
            <%@ include file="sidebar.jsp" %>
        </div>
        <div class="col-9">
            <div style="text-align: right; margin-bottom: 15px"><a href="category/create" class="btn btn-primary">Create</a></div>
            <table class="table table-bcategoryed table-hover">
                <thead class="table-light">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <%  List<Map<String, CategoryDTO>> categories = (List<Map<String, CategoryDTO>>) request.getAttribute("categories");
                    for (Map<String, CategoryDTO> category : categories) { %>
                <tr>
                    <td><%= category.get("id") %></td>
                    <td><%= category.get("name") %></td>
                    <td><%= category.get("description") %></td>
                    <td><%= category.get("status") %></td>
                    <td>
                        <a href="category/<%= category.get("id") %>" class="btn btn-primary btn-sm">Edit</a>
                        <a href="category/delete/<%= category.get("id") %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>