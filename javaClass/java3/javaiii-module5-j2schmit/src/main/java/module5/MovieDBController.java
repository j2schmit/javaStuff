package module5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MovieDBController {

    private MovieDBView movieDBView;
    private MovieQueries movieQueries;

    public MovieDBController(MovieDBView movieDBView, MovieQueries movieQueries) {
        this.movieDBView = movieDBView;
        this.movieQueries = movieQueries;

        this.movieDBView.addMovieListener(new MovieListener());
    }

    class MovieListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            Movie movie = movieDBView.getMovie();
            try {
                movieQueries.addMovie(movie);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            movieDBView.addMovie(movieQueries.getMovie(movie.getName()));
        }
    }

}
