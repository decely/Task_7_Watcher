# Task 7: Наблюдатель

Паттерн Наблюдатель (Observer) определяет зависимость "один-ко-многим" между объектами так, что при изменении состояния одного объекта все зависящие от него объекты уведомляются и обновляются автоматически.

Паттерн Observer определяет объект Subject, хранящий данные (модель), а всю функциональность "представлений" делегирует слабосвязанным отдельным объектам Observer.

При создании наблюдатели Observer регистрируются у объекта Subject.

Когда объект Subject изменяется, он извещает об этом всех зарегистрированных наблюдателей. После этого каждый обозреватель запрашивает у объекта Subject ту часть состояния, которая необходима для отображения данных.

Созданная программа реализует несколько объектов, один из которых выполняет некое действие, а остальные "наблюдают" за ним и выполняют какие либо действия на основе полученной информации. В данном случае объектом выполняющим действие является TimeServer который ведет отсчет виртуального времени, в это же время остальные три объекта ведут отслеживание этого времени, построение фигур и вывод сообщения через указаный промежуток времени(таймер)

Рабочее окно приложения

![изображение](https://user-images.githubusercontent.com/83115120/233280008-15d7eb87-0ccf-4b30-a49b-472535a4e5c7.png)

Архитектура

![изображение](https://user-images.githubusercontent.com/83115120/233280319-fee5267e-0ffa-42ad-b261-7c6bda15901e.png)