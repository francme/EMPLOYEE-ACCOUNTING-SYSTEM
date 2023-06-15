package CollectionOfTextDocuments;

import java.util.ArrayList;
import java.util.List;

class DocumentCollection {
    private String rootFolder;
    private List<TextDocument> documents;

    // Конструктор
    public DocumentCollection(String rootFolder) {
        this.rootFolder = rootFolder;
        this.documents = new ArrayList<>();
    }

    // Метод для добавления документа в коллекцию
    public void addDocument(TextDocument document) {
        documents.add(document);
    }

    // Метод для удаления документа из коллекции
    public void removeDocument(TextDocument document) {
        documents.remove(document);
    }

    // Метод для отображения структуры коллекции
    public void displayCollectionStructure() {
        System.out.println("Структура коллекции:");
        // Реализация вывода структуры коллекции
    }

    // Метод для открытия документа
    public void openDocument(TextDocument document) {
        // Реализация открытия документа
        // с постраничным выводом содержимого
    }

    // Метод для поиска слова в документах коллекции
    public List<TextDocument> searchWordInDocuments(String word) {
        List<TextDocument> searchResults = new ArrayList<>();
        for (TextDocument document : documents) {
            List<Integer> indices = document.searchWord(word);
            if (!indices.isEmpty()) {
                searchResults.add(document);
            }
        }
        return searchResults;
    }

    // Метод для замены слова в документах коллекции
    public void replaceWordInDocuments(String word, String replacement) {
        for (TextDocument document : documents) {
            document.replaceWord(word, replacement);
        }
    }

    // Методы для сортировки коллекции документов по различным критериям
    // ...

    // Метод для вывода коллекции в консоль или файл
    public void printCollection() {
        // Реализация вывода коллекции в консоль или файл
    }
}