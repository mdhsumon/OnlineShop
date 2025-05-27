<%@ include file="header.jsp" %>
<div class="container product-details">
    <div class="row">
        <div class="col-4">
            <div class="product-photo"><img src="/images/product.png" alt="${product.name}"></div>
        </div>
        <div class="col-8">
            <h4>${product.name}</h4>
            <p class="price">${product.price} Taka</p>
            <a href="#" class="btn btn-success">Add To Cart</a>
        </div>
    </div>
    <div class="details-block">
        <h5>Product details</h5>
        <p>${product.description}</p>
    </div>
</div>
<%@ include file="footer.jsp" %>