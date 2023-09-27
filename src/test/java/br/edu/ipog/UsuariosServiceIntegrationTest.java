package br.edu.ipog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.edu.ipog.model.Usuarios;
import br.edu.ipog.service.UsuariosService;


public class UsuariosServiceIntegrationTest {

	private UsuariosService usuariosService;
    
	private static int testContador = 0; 
	private static int passContador = 0; 
    
	@BeforeAll
	public static void testInicio() {
		System.out.println("********************************");
		System.out.println("*      Testes Iniciados        *");
		System.out.println("********************************");
	}

    @BeforeEach
    public void setUp() {
    	usuariosService = new UsuariosService();
        System.out.print(++testContador+"o. Teste Iniciado...");
    }

    @AfterEach
    public void tearDown() {
    	usuariosService = null;
        System.out.println("Pass");
    }
    
	@AfterAll
	public static void testRelatorio() {
	    System.out.println("********************************");
	    System.out.println("Total de Testes = " + testContador);
	    System.out.println("Sucessos = " + passContador);
	    System.out.println("Falhas = " + (testContador  - passContador));
	    float porcentagem = ((float) passContador / testContador) * 100;
	    System.out.println("Porcentagem = " + porcentagem + "%");
	    System.out.println("********************************");
	}

    @Test
    @Order(1)
    public void testCRUDUsuarios() {
        // Adicionar Usuario
        Usuarios usuarios1 = new Usuarios(1, "welton", "welton@gmail.com.br", "w4321", "A","A");
        usuariosService.adicionarUsuarios(usuarios1);

        // Buscar Usuario por id
        Usuarios usuarioBuscado = usuariosService.buscarUsariosPorId(1);
        Assertions.assertEquals(usuarios1, usuarioBuscado);

        // Listar Usuarios
        List<Usuarios> usuarios = usuariosService.listarUsuarios();
        Assertions.assertEquals(1, usuarios.size());

        // Atualizar Usuario
        usuarios1.setLogin("Harlen");
        usuarios1.setEmail("harlen@gmail.com");
        usuarios1.setSenha("h4321");
        usuarios1.setTipo("U");
        usuarios1.setStatus("B");
        usuariosService.atualizarUsuarios(usuarios1);
        Usuarios usuarioAtualizado = usuariosService.buscarUsariosPorId(1);
        Assertions.assertEquals("Harlen", usuarioAtualizado.getLogin());
        Assertions.assertEquals("harlen@gmail.com", usuarioAtualizado.getEmail());
        Assertions.assertEquals("h4321", usuarioAtualizado.getSenha());
        Assertions.assertEquals("U", usuarioAtualizado.getTipo());
        Assertions.assertEquals("B", usuarioAtualizado.getStatus());

        // Excluir Usuario
        usuariosService.excluirUsuarios(1);
        Usuarios usuarioExcluido = usuariosService.buscarUsariosPorId(1);
        Assertions.assertNull(usuarioExcluido);
        ++passContador;
    }
    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
            "1, welton,welton@gmail.com.br,w4321,A,A,harlen,harlen@gmail.com,h4321,A,A",
            "2, luisgustavo,luisgustavo@gmail.com.br,lg1234,U,A,ana,ana@gmail.com,a1234,U,A",
            "3, lucas,lucas@gmail.com.br,l4321,U,A,rafael,rafael@gmail.com,r6578,U,A",
            "4, romeu,romeu@gmail.com.br,r1234,U,A,thalita,thalita@gmail.com,t789,U,A"
    })
    
    public void testAtualizarUsuarios(int id, String loginAntigo, String emailAntigo, String senhaAntiga, String tipoAntigo, String statusAntigo, String loginNovo, String emailNovo, String senhaNova, String tipoNovo, String statusNovo) {
        // Adicionar usuario
        Usuarios usuarios = new Usuarios(id, loginAntigo, emailAntigo, senhaAntiga, tipoAntigo, statusAntigo);
        usuariosService.adicionarUsuarios(usuarios);

        // Atualizar usuario
        usuarios.setLogin(loginNovo);
        usuarios.setEmail(emailNovo);
        usuarios.setSenha(senhaNova);
        usuarios.setTipo(tipoNovo);
        usuarios.setStatus(statusNovo);
        
        
        usuariosService.atualizarUsuarios(usuarios);

        // Buscar usuario atualizado
        Usuarios UsuarioAtualizado = usuariosService.buscarUsariosPorId(id);
        assertEquals(loginNovo, UsuarioAtualizado.getLogin());
        assertEquals(emailNovo, UsuarioAtualizado.getEmail());
        assertEquals(tipoNovo, UsuarioAtualizado.getTipo());
        assertEquals(statusNovo, UsuarioAtualizado.getStatus());
        
        ++passContador;
    }

}
