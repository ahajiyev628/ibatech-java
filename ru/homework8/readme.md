# Мини-проект "Счастливая семья" (продолжение)

Суть проекта: описание структуры семьи с учетом того, что у каждого человека есть кровные родственники, а состав семьи может со временем меняться.

# Работа с коллекциями
## Задание

Усовершенствуйте проект: замените все массивы на коллекции.

#### Технические требования:
- Классы `Pet`, `Human`, `Family` содержат реализацию через массивы. Замените все массивы на коллекции.
  - `habits` (привычки) `Pet` храните в интерфейсе `Set`.
  - `schedule` (расписание) `Human` храните в интерфейсе `Map`.
  - `children` (список детей) `Family` храните в интерфейсе`List`.
  - В семье теперь может быть несколько домашних питомцев - храните их в интерфейсе `Set`.
- Исправьте юнит-тесты.

#### Литература:
- [Типы коллекций. Интерфейс Collection](https://metanit.com/java/tutorial/5.1.php)
- [Class ArrayLis](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)
- [Class HashSet](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html)
- [Class HashMap](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)