package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String response=movieService.addMovie(movie);
        if(response==null){
            return new ResponseEntity("Movie already Present", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Movie Added", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String response=movieService.addDirector(director);
        if(response==null){
            return new ResponseEntity("Director Already present", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Director Added", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie_Name") String movie_Name,@RequestParam("director_Name") String director_Name){
        String response=movieService.addMovieDirectorPair(movie_Name,director_Name);
        if(response==null){
            return new ResponseEntity("Director Movie pair not available", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Movie Director Pair Added", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        Movie response=movieService.getMovieByName(name);
        if(response==null){
            return new ResponseEntity("Movie not available", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director response=movieService.getDirectorByName(name);
        if(response==null){
            return new ResponseEntity("Movie not available", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-movie-by-director-name/{name}")
    public ResponseEntity getMovieByDirectorName(@PathVariable("name") String name){
        List<String> response=movieService.getMovieByDirectorName(name);
        if(response==null){
            return new ResponseEntity("No Director Available", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> response=movieService.getAllMovies();
        if(response==null){
            return new ResponseEntity("No Movie Available", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        String response=movieService.deleteDirectorByName(name);
        if(response==null){
            return new ResponseEntity("Invalid Director", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-all-director")
    public ResponseEntity deleteAllDirector(){
        String response=movieService.deleteAllDirector();
        if(response==null){
            return new ResponseEntity("No Director Available", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
