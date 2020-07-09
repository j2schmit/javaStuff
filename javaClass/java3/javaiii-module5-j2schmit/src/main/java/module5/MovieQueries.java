package module5;

import java.sql.*;

public class MovieQueries {
	private static final String URL = "jdbc:derby:Example;create=true";

	private Connection connection;

	public MovieQueries() {
		try {
			System.out.println("Connecting to database URL: " + URL);
			connection = DriverManager.getConnection(URL);

			initializeDatabase();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	void initializeDatabase() {
		try {
			resetTable();
		} catch (SQLException e) {
		}
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.execute("CREATE TABLE movies (" +
					"id INTEGER PRIMARY KEY," +
					"name VARCHAR(255)," +
					"rating INTEGER," +
					"description VARCHAR(255))");
			stmt.executeUpdate("INSERT INTO movies VALUES (1, 'Caddy Shack', 10, 'Comedy')");
			stmt.executeUpdate("INSERT INTO movies VALUES (2, 'Goonies', 9, 'Adventure')");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	public void resetTable() throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DROP TABLE movies");
	}

	public void addMovie(Movie movie) throws SQLException {
		Statement stmt = null;
		stmt = connection.createStatement();
		String command = "INSERT INTO movies VALUES (" +
				movie.getId() + ", '" +
				movie.getName() + "', " +
				movie.getRating() + ", '" +
				movie.getDescription() + "')";
		stmt.executeUpdate(command);
	}

	public Movie getMovie(String movieName) {
		Statement stmt = null;
		Movie movie = new Movie();
		try {
			stmt = connection.createStatement();
			String query = "SELECT id, name, rating, description FROM movies WHERE name = '" + movieName + "' ";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setRating(rs.getInt("rating"));
				movie.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
