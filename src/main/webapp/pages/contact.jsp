<%@ include file="header.jsp" %>
<div class="container contact-details">
    <div class="row">
        <div class="col-5">
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
        <div class="col-7">
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="fName">First Name</label>
                        <input type="text" class="form-control" id="fName" placeholder="First Name">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lName">Last Name</label>
                        <input type="text" class="form-control" id="lName" placeholder="Last Name">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="Email">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="phone">Phone</label>
                        <input type="tel" class="form-control" id="phone" placeholder="Phone">
                    </div>
                </div>
                <div class="form-group">
                    <label for="address">Message</label>
                    <input type="text" class="form-control" id="address" placeholder="Message here...">
                </div>
                <button type="submit" class="btn btn-primary">Send Message</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>