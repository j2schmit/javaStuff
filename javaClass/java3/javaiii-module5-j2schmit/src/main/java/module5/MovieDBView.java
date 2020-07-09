package module5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MovieDBView extends JFrame {

    private JFrame mainFrame;
    private JPanel moviePanel;
    private JPanel submitPanel;
    private JPanel scrollPanel;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField movieName;
    private JTextField movieId;
    private JTextField movieRating;
    private JTextField movieDescription;
    private JButton submitButton;

    public MovieDBView () throws IOException {
        prepareGUI();
        showTextField();
        mainFrame.setVisible(true);
    }

    private void prepareGUI(){

        mainFrame = new JFrame();
        mainFrame.setSize(800,400);
        mainFrame.setLayout(new GridLayout(0, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        moviePanel = new JPanel();
        moviePanel.setLayout(new GridLayout( 4, 2));

        submitPanel = new JPanel();
        scrollPanel = new JPanel();

        mainFrame.add(moviePanel);
        mainFrame.add(scrollPanel);
        mainFrame.add(submitPanel);

    }

    private void showTextField() throws IOException {

        final JLabel showMovieLabel = new JLabel("Enter Movie To Show: ", JLabel.CENTER);
        movieName = new JTextField(6);
        movieId = new JTextField(6);
        movieRating = new JTextField(6);
        movieDescription = new JTextField(6);
        JLabel idLabel =  new JLabel("ID: ");
        JLabel nameLabel = new JLabel("NAME: ");
        JLabel ratingLabel = new JLabel("RATING: ");
        JLabel descriptionLabel = new JLabel("DESCRIPTION: ");
        table = new JTable(new DefaultTableModel(new String[]{"ID", "NAME", "RATING", "DESCRIPTION"}, 2));
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(new String[] {"1", "Caddy Shack", "10", "Comedy"});
        tableModel.addRow(new String[] {"2", "Goonies", "9", "Adventure"});


        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(350,200));

        submitButton = new JButton("Submit");

        moviePanel.add(nameLabel);
        moviePanel.add(movieName);
        moviePanel.add(idLabel);
        moviePanel.add(movieId);
        moviePanel.add(ratingLabel);
        moviePanel.add(movieRating);
        moviePanel.add(descriptionLabel);
        moviePanel.add(movieDescription);
        submitPanel.add(submitButton);
        scrollPanel.add(scrollPane);

    }

    public Movie getMovie() {
        Movie movie = new Movie();
        String name = movieName.getText();
        movie.setName(name);
        movieName.setText("");
        int id = Integer.parseInt(movieId.getText());
        movie.setId(id);
        movieId.setText("");
        int rating = Integer.parseInt(movieRating.getText());
        movie.setRating(rating);
        movieRating.setText("");
        String description = movieDescription.getText();
        movie.setDescription(description);
        movieDescription.setText("");
        return movie;
    }

    public void addMovie(Movie movie) {
        if (!movie.getName().equals("")) {
            String[] row = new String[]{movie.getId(), movie.getName(), movie.getRating(), movie.getDescription()};
            tableModel.addRow(row);
        }
    }

    void addMovieListener(ActionListener actionListener) {
        submitButton.addActionListener(actionListener);
    }

}

