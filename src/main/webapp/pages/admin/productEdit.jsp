<%@ include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-3">
            <%@ include file="sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form action="/admin/order/${order.id}" method="post">
                <div class="row">
                    <div class="col-6 mb-3">
                        <label for="cName" class="form-label">Customer Name</label>
                        <input type="text" name="customerName" class="form-control" id="cName" value="${order.customerName}">
                    </div>
                    <div class="col-6 mb-3">
                        <label for="cPhone" class="form-label">Customer Phone</label>
                        <input type="text" name="customerPhone" class="form-control" id="cPhone" value="${order.customerPhone}">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Customer Address</label>
                    <textarea class="form-control" name="customerAddress" id="address" rows="3"></textarea>
                </div>
                <div style="text-align: center"><button type="submit" class="btn btn-success">Update</button></div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>