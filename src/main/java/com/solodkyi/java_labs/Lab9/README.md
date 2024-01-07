# [Лабораторна робота 9](https://github.com/Goodwin251/solodkyi_java_labs/blob/main/README.md)

Зробив Солодкий Ярослав Тарасович з групи ПД-32

## Мета

Вивчити основи Java IO, а також навчитися працювати з веб API та створювати Excel-файли.

## Завдання

* Використовуючи зазначене API ((рекомендовано http://api.recrm.ru/doc), https://fakestoreapi.com/, https://fakeapi.platzi.com/en/rest/products/, aбо створіть самі https://mockoon.com/docs/latest/about/ з https://mockoon.com/mock-samples/category/ecommerce/ темплейтами), отримати дані зі всіх енпоінтів.
* Збережіть отримані дані у форматі Excel.
* Покривайте код jUnit/Moskito тестами.

## Формат прийняття лабораторної роботи: 

1. Робота повинна мати план розробки програми та послідовність виконаних дій.
1. Код розробленого додатку прикріпити у вигляді посилання на GitHub.
1. GitHub повинен мати комміти як ви зробили на протязі розробки програми. Мова коммітів: Англійська.

## План розробки

1. Написати клас для роботи з API.
1. Написати клас для стоврення і записування даних в Excel файл.
1. Виконати HTTP-запит до API для отримання даних.
1. Обробка JSON і передача його в JsonToExcel
1. Перевірка створеного файлу.
1. Створити тестові класи, де промоделювати різні сценарії для тестування обробки виняткових ситуацій.
1. Зібрати білд з Maven, щоб перевірити вірність виконання тестів.
1. Залити лабораторну роботу на репозиторій на гітхабі.

## Тести

### [JsonToExcelTest.java](https://github.com/Goodwin251/solodkyi_java_labs/blob/main/src/test/java/com/solodkyi/java_labs/Lab9Test/JsonToExcelTest.java)
	* testConvertWithNewFile - конвертація json в абсолютно новий excel файл;
	* testConvertWithExistingSheetName - конвертація json в існуючий excel файл.
