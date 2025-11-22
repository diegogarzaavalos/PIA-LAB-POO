<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${empty contacto ? 'Nuevo' : 'Editar'} Contacto</title>
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
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .container {
            max-width: 600px;
            width: 100%;
            background: white;
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
        }
        
        h1 {
            color: #333;
            margin-bottom: 30px;
            text-align: center;
            font-size: 2em;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-weight: bold;
        }
        
        input[type="text"],
        select {
            width: 100%;
            padding: 12px;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            font-size: 1em;
            transition: border-color 0.3s;
        }
        
        input[type="text"]:focus,
        select:focus {
            outline: none;
            border-color: #667eea;
        }
        
        .radio-group {
            display: flex;
            gap: 20px;
            margin-top: 8px;
        }
        
        .radio-option {
            display: flex;
            align-items: center;
            gap: 8px;
        }
        
        input[type="radio"] {
            width: 18px;
            height: 18px;
            cursor: pointer;
        }
        
        .btn-group {
            display: flex;
            gap: 15px;
            margin-top: 30px;
        }
        
        .btn {
            flex: 1;
            padding: 15px;
            border: none;
            border-radius: 8px;
            font-size: 1em;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s;
            text-decoration: none;
            text-align: center;
            display: inline-block;
        }
        
        .btn-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        
        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
        
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        
        .btn-secondary:hover {
            background-color: #5a6268;
            transform: translateY(-2px);
        }
        
        .required {
            color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>${empty contacto ? '➕ Nuevo' : '✏️ Editar'} Contacto</h1>
        
        <form action="ContactoServlet" method="post">
            <input type="hidden" name="accion" 
                   value="${empty contacto ? 'insertar' : 'actualizar'}">
            
            <c:if test="${not empty contacto}">
                <input type="hidden" name="id" value="${contacto.id}">
            </c:if>
            
            <div class="form-group">
                <label for="nombre">Nombre <span class="required">*</span></label>
                <input type="text" id="nombre" name="nombre" 
                       value="${contacto.nombre}" required>
            </div>
            
            <div class="form-group">
                <label for="apellidoPaterno">Apellido Paterno <span class="required">*</span></label>
                <input type="text" id="apellidoPaterno" name="apellidoPaterno" 
                       value="${contacto.apellidoPaterno}" required>
            </div>
            
            <div class="form-group">
                <label for="apellidoMaterno">Apellido Materno <span class="required">*</span></label>
                <input type="text" id="apellidoMaterno" name="apellidoMaterno" 
                       value="${contacto.apellidoMaterno}" required>
            </div>
            
            <div class="form-group">
                <label>Sexo <span class="required">*</span></label>
                <div class="radio-group">
                    <div class="radio-option">
                        <input type="radio" id="masculino" name="sexo" value="M" 
                               ${contacto.sexo == 'M' ? 'checked' : ''} required>
                        <label for="masculino">Masculino</label>
                    </div>
                    <div class="radio-option">
                        <input type="radio" id="femenino" name="sexo" value="F" 
                               ${contacto.sexo == 'F' ? 'checked' : ''} required>
                        <label for="femenino">Femenino</label>
                    </div>
                    <div class="radio-option">
                        <input type="radio" id="otro" name="sexo" value="O" 
                               ${contacto.sexo == 'O' ? 'checked' : ''} required>
                        <label for="otro">Otro</label>
                    </div>
                </div>
            </div>
            
            <div class="form-group">
                <label for="telefono">Teléfono <span class="required">*</span></label>
                <input type="text" id="telefono" name="telefono" 
                       value="${contacto.telefono}" 
                       pattern="[0-9]{10}" 
                       placeholder="10 dígitos" required>
            </div>
            
            <div class="form-group">
                <label for="direccion">Dirección <span class="required">*</span></label>
                <input type="text" id="direccion" name="direccion" 
                       value="${contacto.direccion}" required>
            </div>
            
            <div class="form-group">
                <label for="tipoContacto">Tipo de Contacto <span class="required">*</span></label>
                <select id="tipoContacto" name="tipoContacto" required>
                    <option value="">Seleccione...</option>
                    <option value="CASA" ${contacto.tipoContacto == 'CASA' ? 'selected' : ''}>Casa</option>
                    <option value="TRABAJO" ${contacto.tipoContacto == 'TRABAJO' ? 'selected' : ''}>Trabajo</option>
                    <option value="CELULAR" ${contacto.tipoContacto == 'CELULAR' ? 'selected' : ''}>Celular</option>
                    <option value="OTRO" ${contacto.tipoContacto == 'OTRO' ? 'selected' : ''}>Otro</option>
                </select>
            </div>
            
            <div class="btn-group">
                <button type="submit" class="btn btn-primary">
                    ${empty contacto ? '💾 Guardar' : '🔄 Actualizar'}
                </button>
                <a href="ContactoServlet?accion=listar" class="btn btn-secondary">
                    ❌ Cancelar
                </a>
            </div>
        </form>
    </div>
</body>
</html>
