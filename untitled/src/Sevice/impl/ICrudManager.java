package Sevice.impl;

import Model.Category;

import java.util.List;
import java.util.Scanner;

public interface ICrudManager<E> {
E create(Scanner scanner);
void save(E e);
void update(Scanner scanner);
void deleteById(Scanner scanner);
void disPlayAll(List<E> element);

E findById( Scanner scanner);
}
