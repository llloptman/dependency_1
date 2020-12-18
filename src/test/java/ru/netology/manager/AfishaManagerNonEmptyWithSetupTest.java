package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaManagerNonEmptyWithSetupTest {
    private AfishaManager manager = new AfishaManager();
    Film first = new Film(1, "Бладшот", "боевик", false);
    Film second = new Film(2, "Вперед", "мультфильм", false);
    Film third = new Film(3, "Номер один", "комедия", true);
    Film forth = new Film(4, "Номер два", "комедия", true);
    Film fifth = new Film(5, "Номер три", "комедия", true);
    Film sixth = new Film(6, "Номер четыре", "комедия", true);
    Film seventh = new Film(7, "Номер пять", "комедия", true);
    Film eighth = new Film(8, "Номер шесть", "комедия", true);
    Film nineth = new Film(9, "Номер семь", "комедия", true);
    Film tenth = new Film(10, "Номер восемь", "комедия", true);
    Film eleventh = new Film(11, "Номер девять", "комедия", true);
    Film twelve = new Film(12, "Номер ltcznm", "комедия", true);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(nineth);
        manager.add(tenth);
        manager.add(eleventh);


    }

    @Test
    void addOneFilm() {
    manager.add(twelve);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{first,second,third,forth,fifth,sixth,seventh,eighth,nineth,tenth,eleventh,twelve};

        assertArrayEquals(expected,actual);
    }

    @Test
    void amountOfFilms(){
        int actual = manager.getAll().length;
        int expected = manager.getFilmCount();

        assertEquals(expected,actual);
    }
    @Test
    void setAmountOfFilms(){
        AfishaManager manager1 = new AfishaManager( 5);
        manager1.add(first);
        manager1.add(second);
        manager1.add(third);
        manager1.add(forth);
        manager1.add(fifth);
        manager1.add(sixth);
        manager1.add(seventh);
        manager1.add(eighth);
        manager1.add(nineth);
        manager1.add(tenth);
        manager1.add(eleventh);

        int actual = manager1.getAll().length;
        int expected = manager1.getFilmCount();

        assertEquals(expected,actual);

    }

}