package module5;

import java.io.IOException;

public class MovieDB {
	public static void main(String[] args) throws IOException {
		MovieQueries movieQueries = new MovieQueries();
		MovieDBView movieDBView = new MovieDBView();
		MovieDBController movieDBController = new MovieDBController(movieDBView, movieQueries);
	}
}
