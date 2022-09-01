package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class MovieManager {
    private MovieItem[] items = new MovieItem[0];
    int defaultCount = 10;

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll(int movieListLimit) {
        MovieItem[] result = new MovieItem[items.length];
        if (movieListLimit > defaultCount) {
            movieListLimit = defaultCount;
        }
        if (movieListLimit > result.length) {
            movieListLimit = result.length;
        }
        int movieListStart = result.length - movieListLimit;
        for (int i = 0; i < movieListLimit; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }

        MovieItem[] destArr = new MovieItem[movieListLimit];
        System.arraycopy(result, 0, destArr, 0, movieListLimit);
        for (int i = 0; i < movieListLimit; i++) {
            destArr[i] = result[i];
        }
        return destArr;
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