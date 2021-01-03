package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.Repository.AfishaRepository;
import ru.netology.domain.Film;

import static com.sun.tools.doclint.Entity.times;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerNonEmptyWithSetupAndMocksTest {
    @Mock(lenient = true)
    private AfishaRepository repository;
    private AfishaRepository repository1 = new AfishaRepository();


    @InjectMocks
    private AfishaManager manager;
    private AfishaManager manager1 = new AfishaManager(repository1, 5);

    private Film first = new Film(1, "Бладшот", "боевик", false);
    private Film second = new Film(2, "Вперед", "мультфильм", false);
    private Film third = new Film(3, "Номер один", "комедия", true);
    private Film forth = new Film(4, "Номер два", "комедия", true);
    private Film fifth = new Film(5, "Номер три", "комедия", true);
    private Film sixth = new Film(6, "Номер четыре", "комедия", true);
    private Film seventh = new Film(7, "Номер пять", "комедия", true);
    private Film eighth = new Film(8, "Номер шесть", "комедия", true);
    private Film ninth = new Film(9, "Номер семь", "комедия", true);
    private Film tenth = new Film(10, "Номер восемь", "комедия", true);
    private Film eleventh = new Film(11, "Номер девять", "комедия", true);
    private Film twelve = new Film(12, "Номер ltcznm", "комедия", true);

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
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        manager1.add(first);
        manager1.add(second);
        manager1.add(third);
        manager1.add(forth);
        manager1.add(fifth);
        manager1.add(sixth);
        manager1.add(seventh);
//        manager1.add(eighth);
//        manager1.add(ninth);
//        manager1.add(tenth);
//        manager1.add(eleventh);
    }

    @Test
    void addOneFilm() {
        Film[] returned = new Film[]{third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};
        doReturn(returned).when(repository).findAll();
        manager.add(twelve);
        Film[] actual = manager.getAll();
        Film[] expected = new Film[]{twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};

        assertArrayEquals(expected, actual);
        verify(repository).save(twelve);
    }

    @Test
    void amountOfFilms() {
        Film[] returned = new Film[]{third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};
        doReturn(returned).when(repository).findAll();
        int actual = manager.getAll().length;
        int expected = manager.getFilmCount();

        assertEquals(expected, actual);
    }

    @Test
    void setAmountOfFilms() {
        Film[] returned = new Film[]{third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};
        doReturn(returned).when(repository1).findAll();
        int actual = manager1.getAll().length;
        int expected = manager1.getFilmCount();

        assertEquals(expected, actual);

    }

}