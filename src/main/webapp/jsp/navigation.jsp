<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">VolunteerNow!</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <!--
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Resources <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                -->
            </ul>

            <div class="nav navbar-right">
                <c:choose>
                    <c:when test="${currentUser == null}">
                        <a class="btn btn-success navbar-btn" href="/login">Sign in</a> or <a href="/login">sign up</a>
                    </c:when>
                    <c:otherwise>
                        <div class="nav navbar-text dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                ${currentUser.nickname}
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Profile</a></li>
                                <li><a href="${logoutUrl}">Logout</a></li>
                            </ul>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <!--/.navbar-collapse -->
    </div>
</div>
