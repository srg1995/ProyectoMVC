<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<html>
    <head>
        <title>Spring MVC Form Validation</title>
        <style type="text/css">
            .formFieldError { color: red; }
        </style>
    </head>
    <body>
        <h2>Registrar Usuario:</h2>
        <mvc:form modelAttribute="dato" action="validarForm">
            <div>
            	<mvc:label  path="identificador">Id: </mvc:label>
            	<mvc:input  path="identificador"  /><br>
            	<mvc:errors path="identificador" class="formFieldError"/>
            </div>
            <div>
				<mvc:label  path="nombre">Nombre: </mvc:label>
                <mvc:input  path="nombre"  /><br>
                <mvc:errors path="nombre" class="formFieldError" />
            </div>
            <div>
            	<input type="submit" value="Submit" />
            </div>
           <spring:hasBindErrors name="result">
		  <c:if test="${errors.hasFieldErrors('id')}">
		    <c:set var="errorClass" value="error" />
		  </c:if>
		</spring:hasBindErrors>
            
        </mvc:form>
        
        
        <mvc:form modelAttribute="dato" action="validarFormString">
            <div>
            	<mvc:label  path="identificador">Id: </mvc:label>
            	<mvc:input  path="identificador"  /><br>
            	<mvc:errors path="identificador" class="formFieldError"/>
            </div>
            <div>
				<mvc:label  path="nombre">Nombre: </mvc:label>
                <mvc:input  path="nombre"  /><br>
                <mvc:errors path="nombre" class="formFieldError" />
            </div>
            <div>
            	<input type="submit" value="Submit" />
            </div>
            
            ${errorId}
            
        </mvc:form>

    </body>
</html>