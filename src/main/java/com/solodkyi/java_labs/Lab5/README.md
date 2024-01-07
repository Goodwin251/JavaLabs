# [Лабораторна робота 5](README.md)

Зробив Солодкий Ярослав Тарасович з групи ПД-32

## Мета

1. Зрозуміти базові принципи обробки виняткових ситуацій в Java.
1. Створити спеціалізовані класи винятків для обробки конкретних помилкових сценаріїв.
1. Використовувати пропагацію винятків.

## Завдання

У цій лабораторній роботі вам потрібно реалізувати надійну і стійку до помилок програму, яка імітує спрощену банківську систему. Ця система буде включати створення рахунків, фінансові операції і функції зведення рахунків. Ваше завдання полягає в тому, щоб переконатися, що програма може елегантно обробляти різні типи помилок, не ламаючись. Реалізуйте спеціалізовані класи винятків для обробки спеціалізованих сценаріїв помилок.

## Формат прийняття лабораторної роботи: 

1. Робота повинна мати план розробки програми та послідовність виконаних дій.
1. Код розробленого додатку прикріпити у вигляді посилання на GitHub
1. GitHub повинен мати комміти як ви зробили на протязі розробки програми. Мова коммітів: Англійська

## План розробки

1. Реалізувати клас BankAccount з членами класу accountNumber, accountName і balance.
1. Реалізувати методи deposit(double amount), withdraw(double amount), getBalance() та getAccountSummary().
1. Створити спеціалізовані класи винятків:
	* InsufficientFundsException;
	* NegativeAmountException;
	* AccountNotFoundException.
1. Реалізувати клас Bank, який зберігає колекцію об'єктів BankAccount.
1. У класі Bank, реалізувати методи:
	* createAccount(String accountName, double initialDeposit);
	* findAccount(int accountNumber);
	* transferMoney(int fromAccountNumber, int toAccountNumber, double amount).
1. Обробити винятки для кожного метода, що це потребує.
1. Створити тестові класи, де промоделювати різні сценарії для тестування обробки виняткових ситуацій.
1. Зібрати білд з Maven, щоб перевірити вірність виконання тестів.
1. Залити лабораторну роботу на репозиторій на гітхабі.

## Тести
### [BankAccountTest.java](src/test/java/com/solodkyi/java_labs/Lab5Test/BankAccountTest.java)
	* testDeposit - тест поповнення рахунку;
	* testWithdraw - тест зняття коштів;
	* testNegativeAmountExceptionOnDeposit - поповнення негативною сумою;
	* testInsufficientFundsExceptionOnWithdraw - недостатньо коштів на рахунку для зняття суми;
	* testNegativeAmountExceptionOnWithdraw - зняття негативної суми.
### [BankTest.java](src/test/java/com/solodkyi/java_labs/Lab5Test/BankTest.java)
	* testCreateAccount - тест створення акаунту;
	* testFindAccount - тест пошуку акаунту;
	* testTransferMoney - тест переведення на інший акаунт;
	* testNegativeAmountExceptionOnCreateAccount - стартовий депозит негативного значення;
	* testAccountNotFoundException - акаунт не знайдено пошуком;
	* testInsufficientFundsExceptionOnTransferMoney - недостатньо коштів для переведення суми на інший рахунок;
	* testNegativeAmountExceptionOnTransferMoney - від'ємна сума переведення на інший раухнок.