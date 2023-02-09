package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class MovieManager {
    private MovieItem[] items = new MovieItem[0];
    private int defaultCount = 10;

    MovieManager() {
    }

    public MovieManager(int userLength) {
        if (userLength > 0) {
            defaultCount = userLength;
        }
    }


    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        int movieItem = items.length;
        int localMovieItem = defaultCount;
        if (movieItem < localMovieItem) {
            localMovieItem = movieItem;
        }
        MovieItem[] result = new MovieItem[localMovieItem];

        for (int i = 0; i < result.length; i++) {
            int index = movieItem - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeByMovieId(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getMovieId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}


