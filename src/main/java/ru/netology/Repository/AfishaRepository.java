package ru.netology.Repository;

import ru.netology.domain.Film;

public class AfishaRepository {
    private Film[] films = new Film[0];

    //Add film to Repository
    public void save(Film item) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < films
        //.length; i++) {
        //   tmp[i] = films
        //  [i];
        // }
        System.arraycopy(films, 0, tmp, 0, films
                .length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }
// Return film by ID
    public Film findById(int id) {
        Film[] tmp =new Film[1];
        for (Film currentFilm:
             films) {
            if (currentFilm.getFilmId() == id){
                return currentFilm;
            }
        }

        return null;
    }
    //Return all films in Repository
    public Film[] findAll() {
        return films;
    }
    //Remove film by ID

    public void removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getFilmId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }
    public void removeAll() {
        Film[] emptySorage = new Film[0];
        films = emptySorage;
    }


}
