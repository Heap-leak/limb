<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<b> Login page </b>
<@l.login "/login" />
<a href="/registration"> Add new user </a>

</@c.page>
