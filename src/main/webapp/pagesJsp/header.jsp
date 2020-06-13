<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:message bundle="${locale}" key="nav.home" var="home"/>
<fmt:message bundle="${locale}" key="nav.about" var="about"/>
<fmt:message bundle="${locale}" key="nav.recipes" var="recipes"/>
<fmt:message bundle="${locale}" key="nav.sign" var="sign"/>
<fmt:message bundle="${locale}" key="nav.admin.page" var="adminpage"/>
<fmt:message bundle="${locale}" key="nav.daily.eating" var="dailyeating"/>
<fmt:message bundle="${locale}" key="nav.progress" var="progress"/>
<fmt:message bundle="${locale}" key="nav.edit" var="edit"/>
<fmt:message bundle="${locale}" key="nav.logout" var="logout"/>
<fmt:message bundle="${locale}" key="nav.contact" var="contact"/>
<!-- header-start -->
<header>
    <div class="header-area ">
        <div id="sticky-header" class="main-header-area progress-sticky">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-xl-3 col-lg-2">
                        <div class="logo">
                            <a href="/">
                                <img class="main-header-logo" src="/static/img/logo_new.png" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-7">
                        <div class="main-menu   d-none d-lg-block">
                            <nav>
                                <ul id="navigation">
                                    <li><a href="/">${home}</a></li>
                                    <li><a href="/info/about">${about}</a></li>
                                    <li><a href="/info/recipes">${recipes}</a></li>
                                    <li hidden name="sign"><a href="/sign/up">${sign}</a></li>
                                    <li hidden name="user"><a href="#">user<i class="ti-angle-down"></i></a>
                                        <ul class="submenu">
                                            <li hidden name="admin"><a href="/admin/products">${adminpage}</a></li>
                                            <li><a href="/user/meals">${dailyeating}</a></li>
                                            <li><a href="/user/progress">${progress}</a></li>
                                            <li><a href="/client/edit">${edit}</a></li>
                                            <li><a href="/sign/out">${logout}</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="/info/contact">${contact}</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                        <c:if test="${sessionScope.local == null || sessionScope.local == 'en_US'}">
                            <div class="search_icon">
                                <a href="/locale/set?lang=ru_RU">
                                    <i>RU</i>
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.local == 'ru_RU'}">
                            <div class="search_icon">
                                <a href="/locale/set?lang=en_US">
                                    <i>EN</i>
                                </a>
                            </div>
                        </c:if>
                    </div>
                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- header-end -->
