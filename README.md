# Student Console Application

## Описание
Данное приложение является консольным инструментом для управления списком студентов. Оно позволяет добавлять, удалять и отображать студентов, а также загружать данные из файла. Приложение реализует принципы SOLID, что делает его гибким и удобным для расширения.

## Функциональность
- Добавление студента в список.
- Удаление студента по ID.
- Отображение всех студентов.
- Очистка списка студентов.
- Загрузка студентов из файла.

## Использование
Запустите приложение через консоль:

### Доступные команды
- add -f <firstName> -l <lastName> -a <age>: Добавить студента.
- remove <id>: Удалить студента по ID.
- show: Показать всех студентов.
- clear-all: Очистить список студентов.
- parse <filename>: Загрузить студентов из файла.

### Пример использования
- add -f John -l Doe -a 20
- remove 1
- show
- parse

## Формат файла для загрузки
Файл должен содержать строки в следующем формате:
Пример:
- John;Doe;20
- Jane;Smith;22

## По умолчанию 
При запуске приложения выставлены настройки в application.properties:
- file.path=src/main/resources/default-students.txt - расположение файла для парсинга студентов
- spring.profiles.active=init - профиль инициализации данных ( профиль default не загружает данные из файла при запуске приложения)