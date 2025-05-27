<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Page Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-3">
                <div class="logo">
                    <a href="/"><img src="/images/logo.png" alt="Online Shop Logo"></a>
                </div>
            </div>
            <div class="col-6">
                <nav class="menu">
                    <ul class="nav justify-content-center">
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="/product">Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="/contact">Contact</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-3">
                <div class="option d-flex justify-content-end">
                    <div class="cart">
                        <a href="/checkout"><img src="/images/cart.png" alt="Cart Icon"></a>
                    </div>
                    <div class="user">
                        <a href="/profile"><img src="/images/profile.png" alt="Profile"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>