# hastorage

1. Установить docker
2. Запустить контейнер postgres:

sudo docker run --name hastorage -p 5454:5432 -e POSTGRES_USER=sanya -e POSTGRES_PASSWORD=passWd1984! -e POSTGRES_DB=hastorage -d postgres:15.8
3. Настроить папку output для проекта и указать в Modules Sources. Добавить её в исключения
4. Указать там же папку ресурсов resources
5. Указать там же папку исходников java
6. Lifcycle справа панель clean, compile, package, install
7. Добавить запуск проекта Applcation класс Main

Вроде ничего не забыл