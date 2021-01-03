package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.Repository.AfishaRepository;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerEmptyWithMocksTest {
    @Mock
    private AfishaRepository repository;

    @InjectMocks
    private AfishaManager manager;
    private Film bloodShot = new Film(1, "Бладшот", "боевик", false);




    @Test
    void addOneFilm() {
        Film[] returned = new Film[]{bloodShot};
        doReturn(returned).when(repository).findAll();

        manager.add(new Film(1, "Бладшот", "боевик", false));
        Film[] actual = manager.getAll();
        assertArrayEquals(returned,actual);
    }

    @Test
    void getAll() {
        Film[] returned = new Film[0];
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getAll();
        assertArrayEquals(returned,actual);
    }

}