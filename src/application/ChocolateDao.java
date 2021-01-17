package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChocolateDao {
	//Connect to MySQL--see DBConnection
		private Connection connection;
		private ChocolateDao chocolateDao;
		
		private final String GET_CHOCOLATES_QUERY = "SELECT * FROM chocolate_profiles";
		private final String ADD_CHOCOLATE_QUERY = "INSERT INTO chocolate_profiles(type, cacao_solids_percent, sugar_percent, dairy, vanilla) VALUES(?,?,?,?,?)";
		private final String DELETE_CHOCOLATE_BY_ID_QUERY = "DELETE FROM chocolate_profiles WHERE id = ?";
		private final String UPDATE_CHOCOLATE_BY_ID_QUERY = "UPDATE chocolate_profiles SET type = ?, cacao_solids_percent = ?, sugar_percent = ?, dairy = ?, vanilla = ?  WHERE ID = ?";

		public ChocolateDao() {
			//Add connection
			connection = DBConnection.getConnection();
			
		}
		
		public List<Chocolate> getChocolates() throws SQLException{
			ResultSet rs = connection.prepareStatement(GET_CHOCOLATES_QUERY).executeQuery();
			List<Chocolate> chocolates = new ArrayList<Chocolate>();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String type = rs.getString(2);
				int cacao = rs.getInt(3);
				int sugar = rs.getInt(4);
				String dairy = rs.getString(5);
				String vanilla = rs.getString(6);
				
				chocolates.add(new Chocolate(id, type, cacao, sugar, dairy, vanilla));
			}
			
			return chocolates;
			
		}
	
		public void addNewChocolate(String type, int cacao, int sugar, String dairy, String vanilla) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(ADD_CHOCOLATE_QUERY);
			ps.setString(1, type);
			ps.setInt(2, cacao);
			ps.setInt(3, sugar);
			ps.setString(4, dairy);
			ps.setString(5, vanilla);
			ps.executeUpdate();
		}
		
		public void deleteChocolateById(int id) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(DELETE_CHOCOLATE_BY_ID_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		
		public void updateChocolateById(int id, String type, int cacao, int sugar, String dairy, String vanilla) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(UPDATE_CHOCOLATE_BY_ID_QUERY);
			ps.setString(1, type);
			ps.setInt(2, cacao);
			ps.setInt(3, sugar);
			ps.setString(4, dairy);
			ps.setString(5, vanilla);
			ps.setInt(6, id);
			ps.executeUpdate();
		}
}

	

