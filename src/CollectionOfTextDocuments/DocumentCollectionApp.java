package CollectionOfTextDocuments;

import java.util.Scanner;

public class DocumentCollectionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentCollection collection = new DocumentCollection("Корневая папка");

        // Отображение структуры коллекции при старте
        collection.displayCollectionStructure();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Открыть документ");
            System.out.println("2. Поиск по документу");
            System.out.println("3. Замена слова или комбинации слов");
            System.out.println("4. Создание нового документа");
            System.out.println("5. Задать корневую папку коллекции");
            System.out.println("6. Просмотр свойств документа");
            System.out.println("7. Сортировка коллекции документов");
            System.out.println("0. Выйти из приложения");
            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            switch (choice) {
                case 1:
                    // Открытие документа
                    // ...
                    break;
                case 2:
                    // Поиск по документу
                    // ...
                    break;
                case 3:
                    // Замена слова или комбинации слов
                    // ...
                    break;
                case 4:
                    // Создание нового документа
                    // ...
                    break;
                case 5:
                    // Задание корневой папки коллекции
                    // ...
                    break;
                case 6:
                    // Просмотр свойств документа
                    // ...
                    break;
                case 7:
                    // Сортировка коллекции документов
                    // ...
                    break;
                case 0:
                    // Выход из приложения
                    System.out.println("До свидания! Спасибо за использование приложения \"Коллекция текстовых документов\"!");
                    return;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите действие из списка.");
            }
        }
    }
}