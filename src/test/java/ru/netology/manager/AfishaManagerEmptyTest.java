package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerEmptyTest {
    private AfishaManager manager = new AfishaManager();

    @Test
    void addOneFilm() {
        manager.add(new Film(1, "Бладшот", "боевик", false));
        Film[] actual = manager.getAll();
        Film[] expected = manager.getFilms();
         assertArrayEquals(expected,actual);
    }

    @Test
    void getAll() {
        Film[] actual = manager.getAll();
        Film[] expected = new Film[0];

        assertArrayEquals(expected,actual);
    }

}