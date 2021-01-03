package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.Repository.AfishaRepository;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerOneElementWithSetupAndMockitoTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    Film one = new Film(1, "first", "criminal", false);
    Film two = new Film(9, "Номер семь", "комедия", true);

    @BeforeEach
    public void setUp() {
        manager.add(one);
    }

    @Test
    void addOneFilm() {
        Film[] returned = new Film[]{one, two};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(two);

        manager.add(two);

        Film[] actual = manager.getAll();
        Film[] exected = new Film[]{two, one};

        assertArrayEquals(exected, actual);
        verify(repository).save(two);
    }

    @Test
    void amountOfFilms() {
        Film[] returned = new Film[]{one, two};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(two);
        manager.add(two);
        int actual = manager.getAll().length;
        int expected = returned.length;

        assertEquals(expected, actual);
    }

}