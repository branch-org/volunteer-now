<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="form-group">
    <form action="search">
        <div class="input-group">
            <input name="searchInput" type="text" class="form-control" value="${searchInput}"  placeholder="Enter City, State or ZIP"/>
              <span class="input-group-btn">
                  <button type="submit" class="btn btn-success">Search</button>
              </span>
        </div>
    </form>
</div>