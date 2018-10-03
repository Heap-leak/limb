<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout/>
    <span><a href="/user">Users List</a></span>
</div>
<div>
    <form method="post" action="/message">
        <input type="text" name="text" placeholder="Input message">
        <input type="text" name="tag" placeholder="Tag">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Submit</button>
    </form>
</div>
<div>
    <form method="get" action="/message">
        <input type="text" name="filter" placeholder="Search...">
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
        </div>
    </div>
    </#list>
</@c.page>