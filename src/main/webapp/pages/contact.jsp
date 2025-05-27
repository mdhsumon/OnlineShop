<%@ include file="header.jsp" %>
<div class="container contact-details">
    <div class="map">
        <iframe
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1605.2652748647931!2d90.41437225714597!3d23.804100231282504!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3755b8b087026b81%3A0x8fa563bbdd5904c2!2sDhaka!5e0!3m2!1sen!2sbd!4v1748343324513!5m2!1sen!2sbd"
                width="100%"
                height="450"
                style="border:0;"
                allowfullscreen=""
                loading="lazy"
                referrerpolicy="no-referrer-when-downgrade">
        </iframe>
    </div>
    <form action="/orders" method="post">
        <div class="row">
            <div class="col-6 mb-3">
                <label for="fName" class="form-label">First Name</label>
                <input type="text" name="fName" class="form-control" id="fName" placeholder="First Name">
            </div>
            <div class="col-6 mb-3">
                <label for="lName" class="form-label">Last Name</label>
                <input type="text" name="lName" class="form-control" id="lName" placeholder="Last Name">
            </div>
        </div>
        <div class="row">
            <div class="col-6 mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" name="phone" class="form-control" id="phone" placeholder="01XX...">
            </div>
            <div class="col-6 mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" name="email" class="form-control" id="email" placeholder="example@domain.com">
            </div>
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Message</label>
            <textarea class="form-control" name="message" id="message" rows="3"></textarea>
        </div>
        <div style="text-align: center"><button type="submit" class="btn btn-success">Send Message</button></div>
    </form>
</div>
<%@ include file="footer.jsp" %>