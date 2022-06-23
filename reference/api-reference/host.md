# Host

## Creating a new host

{% swagger method="post" path="/host" baseUrl="" summary="새로운 호스트 생성" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="name" required="true" %}
The name of host
{% endswagger-parameter %}

{% swagger-parameter in="body" name="ip" required="true" %}
The name of ip
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Host successfully created" %}

{% endswagger-response %}

{% swagger-response status="400: Bad Request" description="The name or IP already exists" %}

{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="Server Error" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## Getting a host

{% swagger method="get" path="/host" baseUrl="" summary="한 호스트 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="path" name="name" required="true" %}
The name of host
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Host successfully checked" %}
```javascript
{
    "hostName": "name",
    "hostIp": "ip",
    "isAlive": true or false,
    "recentAliveAt": "yyyy-MM-dd HH:mm"
}
```
{% endswagger-response %}

{% swagger-response status="401: Unauthorized" description="Can" %}

{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="Sever Error" %}

{% endswagger-response %}
{% endswagger %}

## Getting all hosts

{% swagger method="get" path="/hosts" baseUrl="" summary="전체 호스트 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-response status="200: OK" description="Hosts successfully checked" %}
```javascript
"HostList"
[
  {
    "hostName": "name",
    "hostIp": "ip",
    "isAlive": true or false,
    "recentAliveAt": "yyyy-MM-dd HH:mm"
  }
]
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="Sever Error" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## Updating a host

{% swagger method="put" path="/host" baseUrl="" summary="호스트 수정" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="path" name="name" required="true" %}
The name of host
{% endswagger-parameter %}

{% swagger-parameter in="body" name="name" required="false" %}
The name of host
{% endswagger-parameter %}

{% swagger-parameter in="body" name="ip" required="false" %}
The name of ip
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Host successfully updated" %}

{% endswagger-response %}

{% swagger-response status="400: Bad Request" description="The name or IP already exists" %}

{% endswagger-response %}

{% swagger-response status="401: Unauthorized" description="Can" %}

{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="Server Error" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## Deleting a host

{% swagger method="delete" path="/host" baseUrl="" summary="호스트 삭제" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="path" name="name" required="true" %}
The name of host
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Host successfully deleted" %}

{% endswagger-response %}

{% swagger-response status="401: Unauthorized" description="Can" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="Server Error" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}
