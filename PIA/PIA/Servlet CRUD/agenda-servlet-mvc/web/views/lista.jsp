<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda de Contactos</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
        }
        
        h1 {
            color: #333;
            margin-bottom: 30px;
            text-align: center;
            font-size: 2.5em;
        }
        
        .mensaje, .error {
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 8px;
            font-weight: bold;
        }
        
        .mensaje {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        
        .error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
        
        .btn {
            padding: 12px 25px;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
            display: inline-block;
            margin-bottom: 20px;
            transition: all 0.3s;
            border: none;
            cursor: pointer;
        }
        
        .btn-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        
        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
        
        .btn-warning {
            background-color: #ffc107;
            color: #333;
        }
        
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
        
        .btn-warning:hover, .btn-danger:hover {
            transform: translateY(-2px);
            opacity: 0.9;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        
        thead {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        
        th, td {
            padding: 15px;
            text-align: left;
        }
        
        th {
            font-weight: bold;
            text-transform: uppercase;
            font-size: 0.9em;
        }
        
        tbody tr {
            border-bottom: 1px solid #e0e0e0;
            transition: background-color 0.3s;
        }
        
        tbody tr:hover {
            background-color: #f8f9ff;
        }
        
        .acciones {
            display: flex;
            gap: 10px;
        }
        
        .no-contactos {
            text-align: center;
            padding: 40px;
            color: #999;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>📇 Agenda de Contactos</h1>
        
        <!-- Mensajes -->
        <c:if test="${not empty mensaje}">
            <div class="mensaje">${mensaje}</div>
        </c:if>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <!-- Botón Nuevo Contacto -->
        <a href="ContactoServlet?accion=nuevo" class="btn btn-primary">➕ Nuevo Contacto</a>
        
        <!-- Tabla de Contactos -->
        <c:choose>
            <c:when test="${not empty contactos}">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre Completo</th>
                            <th>Sexo</th>
                            <th>Teléfono</th>
                            <th>Dirección</th>
                            <th>Tipo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="contacto" items="${contactos}">
                            <tr>
                                <td>${contacto.id}</td>
                                <td>${contacto.nombreCompleto}</td>
                                <td>${contacto.sexo}</td>
                                <td>${contacto.telefono}</td>
                                <td>${contacto.direccion}</td>
                                <td>${contacto.tipoContacto}</td>
                                <td class="acciones">
                                    <a href="ContactoServlet?accion=editar&id=${contacto.id}" 
                                       class="btn btn-warning">✏️ Editar</a>
                                    <a href="ContactoServlet?accion=eliminar&id=${contacto.id}" 
                                       class="btn btn-danger"
                                       onclick="return confirm('¿Está seguro de eliminar este contacto?')">
                                       🗑️ Eliminar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="no-contactos">
                    No hay contactos registrados. ¡Agrega tu primer contacto!
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
