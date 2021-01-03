package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaManagerOneElementWithSetupTest {
    private AfishaManager manager = new AfishaManager();
    Film one = new Film(1,"first","criminal",false);
    Film two = new Film(9, "Номер семь", "комедия", true);
    @BeforeEach
    public void setUp(){
        manager.add(one);
    }

    @Test
    void addOneFilm(){
        manager.add(two);

        Film[] actual = manager.getAll();
        Film[] exected = new Film[]{two,one};

        assertArrayEquals(exected,actual);
    }
@Test
    void amountOfFilms(){
        manager.add(two);
        int actual = manager.getAll().length;
        int expected = manager.getFilms().length;

        assertEquals(expected,actual);
    }

}