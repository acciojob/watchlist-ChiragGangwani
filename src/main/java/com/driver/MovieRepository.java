package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String,Movie>movieDb=new HashMap<>();
    Map<String,Director>directorDb=new HashMap<>();
    Map<String,List<String>>directorMoviePairDb=new HashMap<>();
    public String addMovie(Movie movie) {
        String name=movie.getName();
        if(movieDb.containsKey(name))
            return null;
        movieDb.put(name,movie);
        return "OK";
    }

    public String addDirector(Director director) {
        String name=director.getName();
        if(directorDb.containsKey(name))
            return null;
        directorDb.put(name,director);
        return "OK";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
            if(directorMoviePairDb.containsKey(directorName)) {
                List<String> ans = directorMoviePairDb.get(directorName);
                ans.add(movieName);
                directorMoviePairDb.put(directorName, ans);
                return "OK";
            }
            else if(!directorMoviePairDb.containsKey(directorName)){
                List<String>ans=new ArrayList<>();
                ans.add(movieName);
                directorMoviePairDb.put(directorName, ans);
                return "OK";
            }

        return "null";
    }

    public Movie getMovieByName(String name) {
        if(!movieDb.containsKey(name))
            return null;
        return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
        if(!directorDb.containsKey(name))
            return null;
        return directorDb.get(name);
    }

    public List<String> getMovieByDirectorName(String name) {
        if(!directorMoviePairDb.containsKey(name))
            return null;
        return directorMoviePairDb.get(name);
    }

    public Map<String, Movie> getAllMovie() {
        if(movieDb.isEmpty())
            return null;
        return movieDb;
    }

    public String deleteDirectorByName(String name) {
        if(!directorDb.containsKey(name))
            return null;
        directorDb.remove(name);
        return "OK";
    }

    public String deleteAllDirector() {
        if(directorDb.isEmpty())
            return null;
        directorDb=null;
        return "OK";
    }
}
