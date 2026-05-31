package book;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookManagerTest {

    static BookManager manager;

    @BeforeAll
    static void setUp() {
        manager = new BookManager();
    }

    @Test
    @Order(1)
    void testAddBook() {
        manager.addBook("Clean Code");

        assertTrue(manager.hasBook("Clean Code"));
    }

    @Test
    @Order(2)
    void testRemoveBook() {
        manager.addBook("Effective Java");
        manager.removeBook("Effective Java");

        assertFalse(manager.hasBook("Effective Java"));
    }

    @Test
    @Order(3)
    void testDuplicateBookException() {
        manager.addBook("Java Basics");

        assertThrows(IllegalArgumentException.class, () -> {
            manager.addBook("Java Basics");
        });
    }

    @Test
    @Order(4)
    void testRemoveNonExistingBookException() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeBook("Unknown Book");
        });
    }
    
    @Test
    @Order(5)
    void testGetBookCount() {
        assertEquals(2, manager.getBookCount());
    }
    
    @Test
    @Order(6)
    void testGetAllBooks() {
        manager.addBook("Refactoring");
        Set<String> all = manager.getAllBooks();
        assertTrue(all.contains("Clean Code"));
        assertTrue(all.contains("Java Basics"));
        assertTrue(all.contains("Refactoring"));
        assertEquals(3, all.size());
    }
}