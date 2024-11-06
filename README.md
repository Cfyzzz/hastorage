# hastorage

1. Установить docker
2. Запустить контейнер postgres:

sudo docker run --name hastorage -p 5454:5432 -e POSTGRES_USER=sanya -e POSTGRES_PASSWORD=passWd1984! -e POSTGRES_DB=hastorage -d postgres:15.8

3. Установить JDk 17
4. Настроить папку output для проекта и указать в Modules Sources. Добавить её в исключения
5. Указать там же папку ресурсов resources
6. Указать там же папку исходников java
7. Добавить гененрируемую jooq-ом папку target в Sources
8. Lifcycle справа панель clean, compile, package, install
9. Добавить запуск проекта Applcation класс Main
10. В настройках приложения указать подключение http://XXX.XXX.XXX.XXX:8080  - IP адрес машины с базой. Токен указываем любой набор символов, но я обычно указываю по текущей дате SA01112024 - на 01.11.2024

Вроде ничего не забыл
