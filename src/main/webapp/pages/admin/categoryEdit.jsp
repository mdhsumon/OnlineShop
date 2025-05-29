<%@ include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-3">
            <%@ include file="sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form action="/admin/category/${category.id}" method="post">
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" name="name" class="form-control" id="name" value="${category.name}">
                    </div>
                    <div class="col-6 mb-3">
                        <label for="status" class="form-label">Status</label>
                        <select name="status" id="status" class="form-select">
                            <option value="1" ${category.status == "1" ? "selected" : ""}>Active</option>
                            <option value="0" ${category.status == "0" ? "selected" : ""}>Inactive</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Customer Address</label>
                    <textarea class="form-control" name="description" id="description" rows="6">${category.description}</textarea>
                </div>
                <div style="text-align: right"><button type="submit" class="btn btn-success">Update</button></div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>