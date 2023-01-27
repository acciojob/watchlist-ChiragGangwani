package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public  String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMovieByDirectorName(String name) {
        return movieRepository.getMovieByDirectorName(name);
    }

    public List<String> getAllMovies() {
        Map<String,Movie> response=movieRepository.getAllMovie();
        List<String> ans= new ArrayList<>();
        for(String s: response.keySet())
            ans.add(s);
        return ans;
    }

    public String deleteDirectorByName(String name) {
        return movieRepository.deleteDirectorByName(name);
    }

    public String deleteAllDirector() {
        return movieRepository.deleteAllDirector();
    }
}
