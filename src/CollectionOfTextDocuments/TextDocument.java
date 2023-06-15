package CollectionOfTextDocuments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TextDocument {
    private String name;
    private String content;
    private String author;
    private Date createdDate;

    // Конструктор
    public TextDocument(String name, String content, String author, Date createdDate) {
        this.name = name;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
    }

    // Геттеры и сеттеры для полей класса

    // ...

    // Метод для поиска слова в содержимом документа
    public List<Integer> searchWord(String word) {
        List<Integer> indices = new ArrayList<>();
        int index = content.indexOf(word);
        while (index >= 0) {
            indices.add(index);
            index = content.indexOf(word, index + 1);
        }
        return indices;
    }

    // Метод для замены слова в содержимом документа
    public void replaceWord(String word, String replacement) {
        content = content.replace(word, replacement);
    }
}