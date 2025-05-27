<%@ include file="header.jsp" %>
<div class="container cart-details">
    <form action="/orders" method="post">
        <div class="row">
            <div class="col-6 mb-3">
                <label for="cName" class="form-label">Full Name</label>
                <input type="text" name="customerName" class="form-control" id="cName" placeholder="Full Name">
            </div>
            <div class="col-6 mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="tel" name="customerPhone" class="form-control" id="phone" placeholder="01XX...">
            </div>
        </div>
        <div class="row">
            <div class="col-6 mb-3">
                <label for="cEmail" class="form-label">Email</label>
                <input type="text" name="customerEmail" class="form-control" id="cEmail" placeholder="example@domain.com">
            </div>
            <div class="col-6 mb-3">
                <label for="payment" class="form-label">Payment Method</label>
                <select name="paymentMethod" id="payment" class="form-select">
                    <option value="1">Cash On Delivery</option>
                    <option value="2">bKash</option>
                    <option value="3">Nagad</option>
                    <option value="4">Rocket</option>
                    <option value="5">Card</option>
                </select>
            </div>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <textarea class="form-control" name="customerAddress" id="address" rows="3"></textarea>
        </div>
        <input type="hidden" name="productId" value="${productId}">
        <div style="text-align: center"><button type="submit" class="btn btn-success">Place Order</button></div>
    </form>
</div>
<%@ include file="footer.jsp" %>