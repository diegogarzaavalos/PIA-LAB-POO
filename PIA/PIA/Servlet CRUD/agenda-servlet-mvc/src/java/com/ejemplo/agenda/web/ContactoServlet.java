package com.ejemplo.agenda.web;

import com.ejemplo.agenda.dao.ContactoDAO;
import com.ejemplo.agenda.model.Contacto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que maneja las operaciones CRUD de Contacto
 */
@WebServlet(name = "ContactoServlet", urlPatterns = {"/ContactoServlet"})
public class ContactoServlet extends HttpServlet {

    private ContactoDAO contactoDAO;

    @Override
    public void init() throws ServletException {
        contactoDAO = new ContactoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {
            case "listar":
                listarContactos(request, response);
                break;
            case "nuevo":
                mostrarFormularioNuevo(request, response);
                break;
            case "editar":
                mostrarFormularioEditar(request, response);
                break;
            case "eliminar":
                eliminarContacto(request, response);
                break;
            default:
                listarContactos(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "insertar":
                insertarContacto(request, response);
                break;
            case "actualizar":
                actualizarContacto(request, response);
                break;
            default:
                listarContactos(request, response);
                break;
        }
    }

    /**
     * Lista todos los contactos
     */
    private void listarContactos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contacto> contactos = contactoDAO.listarTodos();
        request.setAttribute("contactos", contactos);
        request.getRequestDispatcher("views/lista.jsp").forward(request, response);
    }

    /**
     * Muestra el formulario para nuevo contacto
     */
    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/form.jsp").forward(request, response);
    }

    /**
     * Muestra el formulario para editar contacto
     */
    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contacto contacto = contactoDAO.obtenerPorId(id);
        request.setAttribute("contacto", contacto);
        request.getRequestDispatcher("views/form.jsp").forward(request, response);
    }

    /**
     * Inserta un nuevo contacto
     */
    private void insertarContacto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String sexo = request.getParameter("sexo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String tipoContacto = request.getParameter("tipoContacto");

        Contacto contacto = new Contacto(nombre, apellidoPaterno, apellidoMaterno,
                                         sexo, telefono, direccion, tipoContacto);

        boolean exito = contactoDAO.insertar(contacto);
        
        if (exito) {
            request.setAttribute("mensaje", "Contacto agregado exitosamente");
        } else {
            request.setAttribute("error", "Error al agregar contacto");
        }
        
        listarContactos(request, response);
    }

    /**
     * Actualiza un contacto existente
     */
    private void actualizarContacto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String sexo = request.getParameter("sexo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String tipoContacto = request.getParameter("tipoContacto");

        Contacto contacto = new Contacto(id, nombre, apellidoPaterno, apellidoMaterno,
                                         sexo, telefono, direccion, tipoContacto);

        boolean exito = contactoDAO.actualizar(contacto);
        
        if (exito) {
            request.setAttribute("mensaje", "Contacto actualizado exitosamente");
        } else {
            request.setAttribute("error", "Error al actualizar contacto");
        }
        
        listarContactos(request, response);
    }

    /**
     * Elimina un contacto
     */
    private void eliminarContacto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        boolean exito = contactoDAO.eliminar(id);
        
        if (exito) {
            request.setAttribute("mensaje", "Contacto eliminado exitosamente");
        } else {
            request.setAttribute("error", "Error al eliminar contacto");
        }
        
        listarContactos(request, response);
    }
}
