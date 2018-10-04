<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout/>
    <label>User: ${username}</label>
    <span><a href="/user">Users List</a></span>
</div>
<div>
    <form method="post" action="/message" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Input message">
        <input type="text" name="tag" placeholder="Tag">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Submit</button>
    </form>
</div>
<div>
    <form method="get" action="/message">
        <input type="text" name="filter" value="${filter?if_exists}" placeholder="Search...">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Filter</button>
    </form>
</div>
<div>Messages List</div>
    <#list messages as message>
    <div>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
            <div>
                <#if message.filename??>
                    <img src="/img/${message.filename}">
                </#if>
            </div>
        </div>
    </div>
    </#list>
</@c.page>