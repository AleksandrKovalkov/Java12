package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
    MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
    MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);
    MovieItem fourth = new MovieItem(4, "fourth", "http://github.com/4", 1);
    MovieItem fifth = new MovieItem(5, "fifth", "http://github.com/5", 1);
    MovieItem sixth = new MovieItem(6, "sixth", "http://github.com/6", 1);
    MovieItem seventh = new MovieItem(7, "seventh", "http://github.com/7", 1);
    MovieItem eighth = new MovieItem(8, "eighth", "http://github.com/8", 1);
    MovieItem ninth = new MovieItem(9, "ninth", "http://github.com/9", 1);
    MovieItem tenth = new MovieItem(10, "tenth", "http://github.com/10", 1);
    MovieItem eleventh = new MovieItem(11, "eleventh", "http://github.com/11", 1);
    MovieItem twelfth = new MovieItem(12, "twelfth", "http://github.com/12", 1);

    @Test
    public void testFindAll(){
        MovieManager manager = new MovieManager();

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);

        MovieItem[] actual = manager.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh,eighth,ninth,tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLast() {
        MovieManager manager = new MovieManager();


        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);

        MovieItem[] actual = manager.findLast();
        MovieItem[] expected = new MovieItem[]{tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllListLimit10ItemTest() {
        MovieManager manager = new MovieManager();

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        manager.addMovie(twelfth);

        MovieItem[] actual = manager.findLast();
        MovieItem[] expected = new MovieItem[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void getAllListLimit1ItemTest(){
        MovieManager manager = new MovieManager();

        manager.addMovie(first);

        MovieItem[] actual = manager.findLast();
        MovieItem[] expected = {first};

        assertArrayEquals(expected,actual);
    }

}
