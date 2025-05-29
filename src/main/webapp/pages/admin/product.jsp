<%@ include file="header.jsp" %>
<%@ page import="com.onineshop.dtos.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<div class="container">
    <div class="row">
        <div class="col-3">
            <%@ include file="sidebar.jsp" %>
        </div>
        <div class="col-9">
            <div style="text-align: right; margin-bottom: 15px"><a href="product/create" class="btn btn-primary">Create</a></div>
            <table class="table table-bproducted table-hover">
                <thead class="table-light">
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Category ID</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <%  List<Map<String, ProductDTO>> products = (List<Map<String, ProductDTO>>) request.getAttribute("products");
                    for (Map<String, ProductDTO> product : products) { %>
                <tr>
                    <td><%= product.get("name") %></td>
                    <td><%= product.get("price") %></td>
                    <td><%= product.get("description") %></td>
                    <td><%= product.get("categoryId") %></td>
                    <td><%= product.get("status") %></td>
                    <td>
                        <a href="product/<%= product.get("id") %>" class="btn btn-primary btn-sm">Edit</a>
                        <a href="product/delete/<%= product.get("id") %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>