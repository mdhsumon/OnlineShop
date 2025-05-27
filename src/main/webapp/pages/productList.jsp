<%@ include file="header.jsp" %>
<%@ page import="com.onineshop.dtos.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<div class="container product-list">
    <div class="row">
        <%
            List<Map<String, ProductDTO>> products = (List<Map<String, ProductDTO>>) request.getAttribute("products");
            if (products != null && !products.isEmpty()) {
                for (Map<String, ProductDTO> product : products) { %>
                    <div class="col-3">
                        <div class="card m-1 mb-4">
                            <a href="/product/<%= product.get("id") %>">
                                <img src="/images/product.png" class="card-img-top" alt="Product Image">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title"><%= product.get("name") %></h5>
                                <p class="card-subtitle"><%= product.get("price") %> BDT</p>
                                <a href="/product/<%= product.get("id") %>" class="btn btn-success">View Details</a>
                            </div>
                        </div>
                    </div>
        <%      }
            }
        else { %>
            <div class="empty-block">No product found</div>
        <% } %>
    </div>
</div>
<%@ include file="footer.jsp" %>