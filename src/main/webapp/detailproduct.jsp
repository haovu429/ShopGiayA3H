<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/10/2021
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Detail Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styledetailproduct.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
</head>
<body>

<div class = "card-wrapper">
    <div class = "card">
        <!-- card left -->
        <c:forEach items="${productid}" var="proid">
        <div class = "product-imgs">
            <div class = "img-display">
                <div class = "img-showcase">
                    <img src = "${proid.image}" alt = "shoe image">
                </div>
            </div>
            <div class = "img-select">
                <div class = "img-item">
                    <a href = "#" data-id = "1">
                        <img src = "images_detail/shoe_1.jpg" alt = "shoe image">
                    </a>
                </div>
                <div class = "img-item">
                    <a href = "#" data-id = "2">
                        <img src = "images_detail/shoe_2.jpg" alt = "shoe image">
                    </a>
                </div>
                <div class = "img-item">
                    <a href = "#" data-id = "3">
                        <img src = "images_detail/shoe_3.jpg" alt = "shoe image">
                    </a>
                </div>
                <div class = "img-item">
                    <a href = "#" data-id = "4">
                        <img src = "images_detail/shoe_4.jpg" alt = "shoe image">
                    </a>
                </div>
            </div>
        </div>
        <!-- card right -->

        <div class = "product-content">
            <h2 class = "product-title">${ proid.name }</h2>
            <a href = "#" class = "product-link">visit nike store</a>
            <div class = "product-rating">
                <i class = "fas fa-star"></i>
                <i class = "fas fa-star"></i>
                <i class = "fas fa-star"></i>
                <i class = "fas fa-star"></i>
                <i class = "fas fa-star-half-alt"></i>
                <span>4.7(21)</span>
            </div>

            <div class = "product-price">
                <p class = "new-price">New Price: <span>$${proid.price}</span></p>
            </div>

            <div class = "product-detail">
                <h2>about this item: </h2>
                <p>${proid.description}</p>
                <ul>
                    <li>Color: <span>Black</span></li>
                    <li>Available: <span>in stock</span></li>
                    <li>Category: <span>Shoes</span></li>
                    <li>Shipping Area: <span>All over the world</span></li>
                    <li>Shipping Fee: <span>Free</span></li>
                </ul>
            </div>

            <div class = "purchase-info">
                <form method="POST" action="CartController">
                <input type = "number" min = "0" value = "1" name="quantity">
                    <input type="hidden" name="pion" value="${proid.name}">
                    <input type="hidden" name="productId" value="${proid.id}">
                    <input type="hidden" name="description" value="${proid.name}">
                    <input type="hidden" name="price" value="${proid.price}">
                    <input type="hidden" name="image" value="${pro.image}">
                <button type = "submit" name="action" class = "btn" value="Add To Cart" style="background: #1CA347">
                    Add to Cart <i class = "fas fa-shopping-cart"></i>
                </button>
                </form>
                <a href="<c:url value = "/index.jsp"/>" class = "btn">Continue Shop</a>
            </div>
            </c:forEach>
            <div class = "social-links">
                <p>Share At: </p>
                <a href = "#">
                    <i class = "fab fa-facebook-f"></i>
                </a>
                <a href = "#">
                    <i class = "fab fa-twitter"></i>
                </a>
                <a href = "#">
                    <i class = "fab fa-instagram"></i>
                </a>
                <a href = "#">
                    <i class = "fab fa-whatsapp"></i>
                </a>
                <a href = "#">
                    <i class = "fab fa-pinterest"></i>
                </a>
            </div>
        </div>
    </div>
</div>
<!--Start of Tawk.to Script-->
<script type="text/javascript">
    var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
    (function(){
        var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
        s1.async=true;
        s1.src='https://embed.tawk.to/62af022cb0d10b6f3e781a12/1g5tq0vpr';
        s1.charset='UTF-8';
        s1.setAttribute('crossorigin','*');
        s0.parentNode.insertBefore(s1,s0);
    })();
</script>
<!--End of Tawk.to Script-->

<script src="js/script_detailproduct"></script>
</body>
</html>
