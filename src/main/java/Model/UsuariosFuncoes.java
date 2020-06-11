package Model;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.ConnectionSingleton;

public class UsuariosFuncoes<usuarioDados extends User>  {
	private List<User> usuarios = new ArrayList<>();
	public String insertUsuarioBd(usuarioDados newUsuario) {
		try {
			String nome, senha, email;
			nome = newUsuario.getNome();
			senha = newUsuario.getPass();
			email = newUsuario.getEmail();
			//System.out.println(nome + email + senha);
			Connection conn = ConnectionSingleton.getConexao();
			PreparedStatement insertDadosUsuario;
			
			String insertSQL = " INSERT INTO atv_cliente (nome, email, senha) VALUES (?, ?, ?)";
			insertDadosUsuario = conn.prepareStatement(insertSQL);
			insertDadosUsuario.setString(1, nome);
			insertDadosUsuario.setString(2, email);
			insertDadosUsuario.setString(3, senha);
			
			insertDadosUsuario.execute();
			insertDadosUsuario.close();
			return "Cliente cadastrado";
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return "Error ao inserir";
		
		
	}
	public int buscaUsuarioBd(usuarioDados newUsuario, int tipoOperacao) {
		switch (tipoOperacao) {
		case 1:
			try {
				
				String email, senha;
				senha = newUsuario.getPass();
				email = newUsuario.getEmail();
				Connection conn = ConnectionSingleton.getConexao();
				PreparedStatement buscaDadosUsuario;
				//System.out.println(email + senha);
				String buscaUsuario = "SELECT email, senha FROM atv_cliente WHERE email = ? AND senha = ?";
				buscaDadosUsuario = conn.prepareStatement(buscaUsuario);
				buscaDadosUsuario.setString(1, email);
				buscaDadosUsuario.setString(2, senha);
				ResultSet rs = buscaDadosUsuario.executeQuery();
				while(rs.next()) {
					return 1;
				}
				buscaDadosUsuario.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		break;
		case 2:
			try {
			Connection conn = ConnectionSingleton.getConexao();
			PreparedStatement buscaTodosUsuario;
			String buscaGeral = "SELECT codigo, nome, email, senha FROM atv_cliente";
			buscaTodosUsuario =  conn.prepareStatement(buscaGeral);
			ResultSet rs = buscaTodosUsuario.executeQuery();
			while(rs.next()) {
				newUsuario.setNome(rs.getString("nome"));
				newUsuario.setEmail(rs.getString("email"));
				newUsuario.setPass(rs.getString("senha"));
				addUser(newUsuario);			
			}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		break;
		default:
			return 0;
		}
		return 0;
	}
	public void atualizaUsuarioBd(usuarioDados newUsuario) {
		
	}
	public void deleteUsuarioBd(usuarioDados newUsuario) {
		
	}
	
    public void addUser(usuarioDados newUser) {
        this.usuarios.add(newUser);
    }
    
    public User mostrarUsuarios() {
        for (User user : usuarios) {
        	user.getNome();
        	user.getEmail();
        	user.getPass();
           return user;
        }
		return null;
    }
//
//    public int buscaUsuario(String nome, String senha) {
//        for (User user : usuarios) {
//            if (user.getNome() != nome && user.getPass() != senha) {
//                System.out.print("Dados que foram achado: ");
//                System.out.println("Nome: " + user.getNome() + " |Email:" + user.getEmail());
//                return 1;
//            }
//        }
//        return 0;
//    }
}
