/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import Entidad.Sistema;
import Frontera.FramePrincipal;

/**
 *
 * @author Johan
 */
public class RegistrarUsuario {
    
    private Sistema sistema = FramePrincipal.sistema;
    
 public String verificarDatos (String nombre,String contraseña,String confContraseña){
        if(!verificarLongitudNombre(nombre)){
            return("Longitud nombre incorrecta");
        }
        if(!verificarLongitudPassword(contraseña)){
            return ("Longitud contraseña incorrecta");
        }
        for (Usuario u: sistema.getUsuarios()){
            if (u.getNombre().equals(nombre)){
                return ("Nombre de Usuario ya registrado");}
            }
        if (contraseña.equals(confContraseña)){
            Usuario usuarioNuevo = new Usuario();
            usuarioNuevo.setNombre(nombre);
            usuarioNuevo.setPassword(contraseña);
            sistema.getUsuarios().add(usuarioNuevo);
            return "Usuario Registrado con exito";
        }
        return "Las contraseñas ingresadas deben coincidir";
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length() > 1 && nombre.length() <= 6);
    }
    
    public boolean verificarLongitudPassword (String password){
        return ((password.length() >= 3) && (password.length() < 6));
    }   
}

