---------1 task---------------
2 взвешивания:
(1 взвешивание)
Взвешиваем два любых набора по 3 шара
Если наборы весят одинаково, то:
(2 взвешивание)
 взвешиваем оставшиеся два шара  и определяем тяжёлый шар.
Если наборы весят по-разному, то:
(2 взвешивание)
 из более тяжёлого набора берём любые два шара и взвешиваем.
Если шары весят одинаково, то тяжёлый шар – третий из набора, который не взвешивали. Иначе тяжёлый шар – тот который больше весит.
---------2 task---------------
Берём из первой банки один шарик, из второй два и т.д.
Из пяти банок мы возьмём всего 1+2+3+4+5=15 шариков и взвесим именно их.
Вес будет 15 целых и сколько-то десятых X грамма.  (Например, если шарики тяжелые в 3 банке, то 15.3)
Если тяжёлые шары в X банке(3 банке), то 15.X(15.3), так как из X банки(3 банки) у нас X шара(3 шара).
---------5 task---------------
Класс — это определение общего поведения для объектов
(объекты имеют одинаковый набор свойств, объекты имеют общее поведение)
Объект будет иметь поведение задаваемое этим классом и отличаться от других объектов своим состоянием
(состояние, поведение, уникальность)
 ---------6 task---------------
Инкапсуляция-это сокрытие реализации класса, отделение внутреннего представления от внешнего
1. Инкапсуляция позволяет сократить временные затраты на поиск ошибок и отладку приложения
и более простое внесение изменений.
2. Полный контроль над входящими и исходящими данными
3. Можно, без боязни править реализацию методов компонентов

 ---------9 task--------------

 select us.name, ul.login_time from
 public."USER_LOGINS" ul left join public."USERS" us
 on ul.user_id = us.id

 ---------10 task---------------
 select us.name, max(ul.login_time) from
  public."USER_LOGINS" ul left join public."USERS" us
  on ul.user_id = us.id
 group by  us.name
 order by us.name

 Понравились задания, потому что затрагивают разные области знаний. Особый интерес вызвали задачи на алгоритмическую сложность