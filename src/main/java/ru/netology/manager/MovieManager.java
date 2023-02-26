package ru.netology.manager;


import ru.netology.domain.MovieItem;

public class MovieManager {
    private MovieItem[] movies = new MovieItem[0];

    private int limit;
    public MovieManager(){
        this.limit = 10;
    };

    public MovieManager(int limit){
        this.limit = limit;
    }
    public void addMovie(MovieItem item) {
        MovieItem[] tmp = new MovieItem[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = item;
        movies = tmp;
    }

    public MovieItem[] findAll() {
        return movies;
    }

    public MovieItem[] findLast() {
        MovieItem[] movies = findAll();
        MovieItem[] result;
        if( limit < movies.length){
            result = new MovieItem[limit];
        }else{
            result = new MovieItem[movies.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i]=movies[index];
        }
        return result;
    }

}


