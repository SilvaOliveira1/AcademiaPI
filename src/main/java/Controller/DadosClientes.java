package Controller;

import Model.User;
import Model.UsuariosFuncoes;

public class DadosClientes{
	public static void preparadaDadosInsercaoUsuario(String nome, String email, String senha) {
		//System.out.println(nome + email + senha);
		User usuario = new User();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setPass(senha);
		UsuariosFuncoes<User> pegaDadosUsuario = new UsuariosFuncoes<User>();
		pegaDadosUsuario.insertUsuarioBd(usuario);
	}
	
	public static int preparaDadosBuscaUsuario(String email, String senha) {
		User usuario = new User();
		usuario.setEmail(email);
		usuario.setPass(senha);	
		//System.out.println(email + senha);
		UsuariosFuncoes<User> pegaDadosUsuario = new UsuariosFuncoes<User>();
		if(pegaDadosUsuario.buscaUsuarioBd(usuario, 1) == 1) {
			return 1;
		}else {
			return 0;
		}
	}
}
