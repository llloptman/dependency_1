package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AfishaManager {
    private Film[] films = new Film[0];
    private int filmCount = 10;

    public AfishaManager(int filmCount){
        this.filmCount = filmCount;
    }

    public void add(Film item) {
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

    //Выдаем последние 10 записей, если меньше, то сколько есть в обратном порядке
    public Film[] getAll() {
        if (films.length <= this.filmCount) {
            Film[] result = new Film[films.length];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = 0; i < result.length; i++) {
                int index = films.length - i - 1;
                result[i] = films[index];
            }
            return result;
        } else {
            Film[] result = new Film[this.filmCount];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = result.length - this.filmCount; i < result.length; i++) {
                int index = films.length - i - 1;
                result[i] = films[index];
            }
            return result;
        }
    }

}
