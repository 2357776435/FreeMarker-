<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门小DEMO </title>
</head>
<body>
<#include "head.ftl"/>
<#-- 定义简单类型 -->
<#assign linkman="lol">
${name}:从假数据中获取到的<br>
<#assign name="sgw">
我是被简单类型修改的:${name},你好。${message},爱玩${linkman}<br>

<#assign info={"mobile":"18208533574","address":"贵州省安顺市普定县"}>
电话:${info.mobile} 地址:${info.address}<br>
<br>
<#if success=true>
    你已通过实名认证
<#else>
    你未通过实名认证
</#if>
<br>
<#-- 模拟获取List数据 -->
<#list booksList as books>
    集合索引:${books_index} 书名:${books}<br>
</#list>
共 ${booksList?size} 条记录<br>
<br>
<#-- 模拟获取List集合数据 -->
<#list booksList as books>
    <#if books_index == 0>
        这是第一次循环
    <#else>
        这是第${books_index + 1}次循环
    </#if>
    集合索引: ${books_index}
    ${books}<br>
</#list>
<br>
<#-- 模拟获取Map数据 -->
<#list booksMap?keys as key>
    map的书名:${key},  map的价格:$${booksMap[key]}元<br>
</#list>
<#--<#list booksMap?keys as key>-->
<#--    map中的key书名为:${key}  map中的value价格为:$${booksMap[key]}元<br>-->
<#--</#list>-->
<br>
当前日期：${today?date} <br>
当前时间：${today?time} <br>
当前日期+时间：${today?datetime} <br>
日期格式化： ${today?string("yyyy年MM月dd日 HH时mm分ss秒")}
<br>
累计积分未解决：${point}
<br>
累计积分已解决：${point?c}
<br>
<#--<#assign aaa=123>-->
<#if aaa??>
    aaa变量存在
<#else>
    aaa变量不存在
</#if>
<br>
${aaa!'aaa变量不存在'}
</body>
</html>