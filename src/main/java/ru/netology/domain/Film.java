package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Film {
  private int filmId;
  private String filmName;
  private String filmGenre;
  private boolean isPremiereTomorrow;
}
