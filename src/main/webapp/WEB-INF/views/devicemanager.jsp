<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page session="false"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>iQYY Device Manager</title>
<link rel="stylesheet" href="<c:url value="/style.css" />">
</head>
<body>
	<header>
		<h1>iQYY Device Manager</h1>
	</header>
	<section id="list">
		<h1>Device Browser</h1>

        <div class="mode-toolbar">
         <div class="left">
           <div>Device Type:</div>
           
           <c:forEach items="${deviceTypeList}" var="deviceType" varStatus="status">
              <c:out value="${deviceType.attributes}" />
              <c:choose>
                 <c:when test="${status.first}">
                   <button id="<c:out value="${deviceType.id}" />" class="split_left" onclick="location='<c:url value="/devicemanager?type=${deviceType.name}" />'">
	                 <c:out value="${deviceType.name}" /> 
	               </button>
                 </c:when>
                 <c:when test="${status.last}">
                   <button id="<c:out value="${deviceType.id}" />" class="split_right" onclick="location='<c:url value="/devicemanager?type=${deviceType.name}" />'">
	                  <c:out value="${deviceType.name}" /> 
	               </button>
                 </c:when>
                 <c:otherwise>
                   <button id="<c:out value="${deviceType.id}" />" onclick="location='<c:url value="/devicemanager?type=${deviceType.name}" />'">
	                  <c:out value="${deviceType.name}" /> 
	               </button>
                 </c:otherwise>
              </c:choose>
           </c:forEach>
         </div>
         <div class="right">
           <button id="platform" class="green" onclick="location='<c:url value="/" />'">Back to Platform</button>
           <button id="device_type" class="green" onclick="location='<c:url value="/devicemanager/devicetype" />'">Manage Device Type</button>
           <button id="settings" class="green" onclick="location='<c:url value="/devicemanager/dmsettings" />'">Settings</button>
         </div>
       </div>
       
       <details open>
			<summary>Devices - <c:out value="${fn:length(deviceList)}" /> <c:out value="${param.type}" />s</summary>

			<table border="1">
				<tr>
					<th>ID</th>
					<th>Name</th>
					
				</tr>
				<c:forEach items="${deviceList}" var="device">
				<tr>
					<td align="left"><c:out value="${device.id}" /></td>
					<td align="left"><c:out value="${device.name}" /></td>
				</tr>
				</c:forEach>
			</table>
		</details>
	</section>
</body>
</html>