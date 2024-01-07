# [Лабораторна робота 7](https://github.com/Goodwin251/solodkyi_java_labs/blob/main/README.md)

Зробив Солодкий Ярослав Тарасович з групи ПД-32

## Мета

* Розуміння та впровадження класів Java Collection таких як List, Set, Map.
* Проектування та реалізація класів та методів для реального застосування.
* Вивчення принципів об'єктно-орієнтованого програмування: інкапсуляція, наслідування та поліморфізм.
* Застосування власного сортування за допомогою Comparable та Comparator.

## Завдання

Створіть бек - енд платформи Електронної Комерції

Необхідно реалізувати спрощену систему бек-енду для платформи електронної комерції, використовуючи Java Collections, зосереджуючись на управлінні запасами, управлінні корзиною користувача та обробці замовлень.

## Формат прийняття лабораторної роботи: 

1. Робота повинна мати план розробки програми та послідовність виконаних дій.
1. Код розробленого додатку прикріпити у вигляді посилання на GitHub.
1. GitHub повинен мати комміти як ви зробили на протязі розробки програми. Мова коммітів: Англійська.

## План розробки

1. Створення класу Product:
	* Поля: id (Integer), name (String), price (double), stock (int);
	* Реалізувати відповідні конструктори, гетери та сетери;
	* Перевизначити метод toString для правильного представлення;
1. Створення класу User:
	* Поля: id (Integer), username (String), cart (Map<Product, Integer> представляючи Товар та Кількість);
	* Реалізувати відповідні конструктори, гетери, сетери та методи для додавання, видалення та модифікації товарів у кошику.
1. Створення класу Order:
	* Поля: id (Integer), userId (Integer), orderDetails (Map<Product, Integer> представляючи Товар та Кількість), totalPrice (double);
	* Реалізувати відповідні конструктори, гетери, сетери та метод для розрахунку загальної вартості замовлення;
1. Створення класу ECommercePlatform:
	* Поля:
		* users (Map<Integer, User> - користувачі);
		* products (Map<Integer, Product> - товари);
		* orders (Map<Integer, Order> - замовлення);
	* Реалізувати методи для додавання користувачів, товарів, створення замовлення, переліку доступних товарів, переліку користувачів, переліку замовлень та оновлення запасів товарів.
1. Створення класу ECommerceDemo:
	* Це буде ваш основний клас для демонстрації функціональності;
	* Ініціалізувати ECommercePlatform, додати користувачів та товари, симулювати взаємодію користувачів із кошиком та симулювати створення та обробку замовлень.
1. Створення класи для Сортування та Фільтрації:
	* Реалізувати Comparable у класі Product для сортування за ціною;
	* Створіть класи Comparator для сортування Товарів за назвою та запасами;
	* У ECommerceDemo реалізувати функції для відображення списку товарів, відсортованих за назвою, ціною та запасами; 
	* Реалізувати функції для фільтрації товарів за наявністю на складі.
1. Створити рекомендації для Користувача у ECommercePlatform для рекомендації товарів користувачам на основі товарів у їхньому кошику чи історії замовлень.
1. У головному класі ECommerceDemo симулювати серію взаємодій користувачів, оновлень кошика, обробки замовлень, рекомендацій товарів та відобразити кінцевий стан користувачів, товарів та замовлень.
1. Створити тестові класи, де промоделювати різні сценарії для тестування обробки виняткових ситуацій.
1. Зібрати білд з Maven, щоб перевірити вірність виконання тестів.
1. Залити лабораторну роботу на репозиторій на гітхабі.

## Тести

### [ECommercePlatformTest.java](https://github.com/Goodwin251/solodkyi_java_labs/blob/main/src/test/java/com/solodkyi/java_labs/Lab7Test/ECommercePlatformTest.java)
	* testAddUser - додавання користувача;
	* testAddUserWithExistingId - додавання користувача з існуючим Id;
	* testAddProduct - додавання продукту;
	* testAddProductWithExistingId - додавання продукту з існуючим Id;
	* testCreateOrder - створення замовлення;
	* testCreateOrderForNonexistentUser - створення замовлення для не існуючого користувача;
	* testUpdateProductStock - оновити продукти на складі;
	* testUpdateProductStockForNonexistentProduct - оновити склад для не існуючого продукту;
	* testUpdateProductStockToNegativeValue - оновити кількість продукту на негативне число на складі;
	* testListProductsSortedByName - сортування складу за іменем продукту;
	* testListProductsSortedByStock - сортування складу за кількістю продуктів;
	* testFilterProductsByAvailability - фільтрування продуктів за доступністю.

### [OrderTest.java](https://github.com/Goodwin251/solodkyi_java_labs/blob/main/src/test/java/com/solodkyi/java_labs/Lab7Test/OrderTest.java)
	* testValidOrderCreation - правильне створення замовлення;
	* testOrderWithNullDetails - замовлення створене без деталей;
	* testOrderWithEmptyDetails - замовлення створене з пустими деталями;
	* testOrderWithNegativeProductQuantity - створення замовлення з від'ємною кількістю товарів;
	* testSetNullOrderId - встановлення замовленню відсутнього Ід;
	* testSetNullUserId - встановлення користувачу відсутнього Ід.

### [ProductTest.java](https://github.com/Goodwin251/solodkyi_java_labs/blob/main/src/test/java/com/solodkyi/java_labs/Lab7Test/ProductTest.java)
	* testValidProductCreation - правильне створення товару;
	* testSetNegativePrice - встановлення від'ємної ціни товару;
	* testSetNegativeStock - встановлення від'ємної кількості товару;
	* testSetNullProductName - встановлення відсутнього імені товару.
### [UserTest.java](https://github.com/Goodwin251/solodkyi_java_labs/blob/main/src/test/java/com/solodkyi/java_labs/Lab7Test/UserTest.java)
	* testAddProductToCart - додавання продукту до кошика;
	* testRemoveProductFromCart - видалення продукту з кошика;
	* testRemoveNonExistentProductFromCart - видалення не існуючого продукту з кошика;
	* testAddNegativeQuantityToCart - встановлення від'ємного значення товарів кошику;
	* testSetNullUsername - встановлення відсутнього імені користувача.