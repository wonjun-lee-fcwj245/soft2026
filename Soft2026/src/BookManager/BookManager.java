package book;

import java.util.HashSet;
import java.util.Set;

public class BookManager {
    private Set<String> books = new HashSet<>();

    // 책 추가
    public void addBook(String title) {
        if (books.contains(title)) {
            throw new IllegalArgumentException("이미 존재하는 책입니다: " + title);
        }
        books.add(title);
    }

    // 책 제거
    public void removeBook(String title) {
        if (!books.contains(title)) {
            throw new IllegalArgumentException("존재하지 않는 책입니다: " + title);
        }
        books.remove(title);
    }

    // 책 조회
    public boolean hasBook(String title) {
        return books.contains(title);
    }
}