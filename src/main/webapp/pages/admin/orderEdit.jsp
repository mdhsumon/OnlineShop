<%@ include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-3">
            <%@ include file="sidebar.jsp" %>
        </div>
        <div class="col-9">
            <form action="">
                <input type="text" value="${order.customerName}">
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>