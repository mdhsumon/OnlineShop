<%@ include file="header.jsp" %>
<%@ page import="com.onineshop.dtos.OrderDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<div class="container">
    <div class="row">
        <div class="col-3">
            <%@ include file="sidebar.jsp" %>
        </div>
        <div class="col-9">
            <table class="table table-bordered table-hover">
                <thead class="table-light">
                    <tr>
                        <th>Product ID</th>
                        <th>Customer Name</th>
                        <th>Customer Phone</th>
                        <th>Customer Email</th>
                        <th>Customer Address</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <%  List<Map<String, OrderDTO>> orders = (List<Map<String, OrderDTO>>) request.getAttribute("orders");
                    for (Map<String, OrderDTO> order : orders) { %>
                <tr>
                    <td><%= order.get("productId") %></td>
                    <td><%= order.get("customerName") %></td>
                    <td><%= order.get("customerPhone") %></td>
                    <td><%= order.get("customerEmail") %></td>
                    <td><%= order.get("customerAddress") %></td>
                    <td>
                        <a href="order/<%= order.get("id") %>" class="btn btn-primary btn-sm">Edit</a>
                        <a href="order/delete/<%= order.get("id") %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>