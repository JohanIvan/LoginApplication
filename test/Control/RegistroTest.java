/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Control.RegistrarUsuario;

/**
 *
 * @author Johan
 */
public class RegistroTest {
    
    private static RegistrarUsuario verificarDatos = new RegistrarUsuario();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
    private String NOMBRE_USUARIO_YA_REGISTRADO = "Nombre de Usuario ya registrado";
    private String DISCREPANCIA_CONTRASEÑAS = "Las contraseñas ingresadas deben coincidir";
    private String USUARIO_REGISTRADO_EXITO = "Usuario Registrado con exito"                                                                    ;
    
    public RegistroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ArrayList<Usuario> usuarios = new ArrayList <Usuario>();
        
        
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");
        
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        
        sistema.setUsuarios(usuarios);
        
        for (Usuario u: sistema.getUsuarios()){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("-------------");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testLongitudNombre() {
        assertEquals(verificarDatos.verificarDatos("a","12345","12345"), LONG_NOMBRE_INCORRECTA);
        assertEquals(verificarDatos.verificarDatos("alejandro","12345","12345"), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testLongitudContrasenia() {
        assertEquals(verificarDatos.verificarDatos("ana","12","12"), LONG_PASSWORD_INCORRECTA);
        assertEquals(verificarDatos.verificarDatos("ana","123456","123456"), LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void testUsuarioRepetido() {
        assertEquals(verificarDatos.verificarDatos("juan","1234","1234"), NOMBRE_USUARIO_YA_REGISTRADO);
    }
    
    @Test
    public void testContraseniasDistintas() {
        assertEquals(verificarDatos.verificarDatos("ana","1234","4321"), DISCREPANCIA_CONTRASEÑAS);
    }
    
    @Test
    public void testTodoBien() {
        assertEquals(verificarDatos.verificarDatos("jhon","4567","4567"), USUARIO_REGISTRADO_EXITO);
    }
    
    @Test
    public void testNoDuplicar() {
        assertEquals(verificarDatos.verificarDatos("emily","1234","1234"), USUARIO_REGISTRADO_EXITO);
        assertEquals(verificarDatos.verificarDatos("emily","1234","1234"), NOMBRE_USUARIO_YA_REGISTRADO);
    }
    
}
