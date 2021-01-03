package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.Repository.AfishaRepository;
import ru.netology.domain.Film;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AfishaManager {
    private AfishaRepository repository;
    private int filmCount = 10;

//    public AfishaManager(AfishaRepository repository, int filmCount) {
//        this.repository = repository;
//        this.filmCount = filmCount;
//    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    // Add film to Repository
    public void add(Film film) {
        repository.save(film);
    }

    //Get all films.
    // 1) if there are less films than filmCount then array.length = number of films
    // 2) if there are more films than filmCount then array.length = filmCount
    // 3) inverted return
    public Film[] getAll() {
        Film[] allFilms = repository.findAll();
        Film[] result = new Film[allFilms.length];
        if (allFilms.length <= filmCount) {
            for (int i = 0; i < allFilms.length; i++) {
                int index = allFilms.length - 1 - i;
                result[i] = allFilms[index];
            }
            return result;
        } else {
            for (int i = 0; i < filmCount; i++) {
                int index = filmCount - 1 - i;
                result[i] = allFilms[index];
            }
        }
        return result;
    }

    //Выдаем последние 10 записей, если меньше, то сколько есть в обратном порядке


}
