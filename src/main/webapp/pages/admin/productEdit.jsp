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
            <form action="/admin/product/${product.id}" method="post">
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" name="name" class="form-control" id="name" value="${product.name}">
                    </div>
                    <div class="col-6 mb-3">
                        <label for="category" class="form-label">Category</label>
                        <select name="categoryId" id="category" class="form-select">
                            <%  List<Map<String,  CategoryDTO>> categories = (List<Map<String, CategoryDTO>>) request.getAttribute("categories");
                                for (Map<String, CategoryDTO> category : categories) { %>
                                    <option value="<%= category.get("id") %>"><%= category.get("name") %></option>
                            <% } %>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="price" class="form-label">Price</label>
                        <input type="text" name="price" class="form-control" id="price" value="${product.price}">
                    </div>
                    <div class="col-6 mb-3">
                        <label for="status" class="form-label">Status</label>
                        <select name="status" id="status" class="form-select">
                            <option value="1" ${product.status == "1" ? "selected" : ""}>Active</option>
                            <option value="0" ${product.status == "0" ? "selected" : ""}>Inactive</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" name="description" id="description" rows="6">${product.description}</textarea>
                </div>
                <div style="text-align: right"><button type="submit" class="btn btn-success">Update</button></div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>