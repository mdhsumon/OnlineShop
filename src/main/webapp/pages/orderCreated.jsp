<%@ include file="header.jsp" %>
<div class="container order-details">
    <h2>Your order has been placed successfully!</h2>
    <table class="table table-bordered">
        <tr>
            <td>Order ID</td>
            <td>${order.id}</td>
        </tr>
        <tr>
            <td>Customer Name</td>
            <td>${order.customerName}</td>
        </tr>
        <tr>
            <td>Customer Phone</td>
            <td>${order.customerPhone}</td>
        </tr>
        <tr>
            <td>Customer Email</td>
            <td>${order.customerEmail}</td>
        </tr>
        <tr>
            <td>Customer Address</td>
            <td>${order.customerAddress}</td>
        </tr>
        <tr>
            <td>Payment Method</td>
            <td>${order.paymentMethod}</td>
        </tr>
    </table>
    <div class="m-5" style="text-align: center">
        <a href="/product" class="btn btn-success">Shop More</a>
    </div>
</div>
<%@ include file="footer.jsp" %>