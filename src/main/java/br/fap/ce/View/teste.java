package br.fap.ce.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import Core.ConnectionSingleton;

public class teste {
	public static void main(String[] args) throws SQLException {
		Connection conn = ConnectionSingleton.getConexao();
	    PreparedStatement ps;
	    
	    String sql = "SELECT id, telefone FROM telefone";
	    
	    ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()) {
	    	System.out.println("Codigo: " + rs.getInt("id") + "Telefone: " + rs.getString("telefone"));
	    }
	    ps.close();
	    rs.close();
	}
}
