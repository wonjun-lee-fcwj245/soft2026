package StudentManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // 순서 고정
public class StudentManagerTest {

    StudentManager manager;

    @BeforeAll
    void setUp() {
        manager = new StudentManager();
        manager.addStudent("학생A");
        System.out.println("StudentManager 객체 1회 생성 완료");
    }

    @Test
    @Order(1)
    void testAddStudent() {
        manager.addStudent("김철수");
        assertTrue(manager.hasStudent("김철수"));
    }

    @Test
    @Order(2)
    void testRemoveStudent() {
        manager.removeStudent("학생A");
        assertFalse(manager.hasStudent("학생A"));
    }

    @Test
    @Order(3)
    void testDuplicateAddException() {
        manager.addStudent("홍길동");
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("홍길동");
        });
    }

    @Test
    @Order(4)
    void testRemoveNonExistentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStudent("유령학생");
        });
    }
}