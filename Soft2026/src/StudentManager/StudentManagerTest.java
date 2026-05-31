package StudentManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    
    @Test
    @Order(5)
    void testGetStudentCount() {
        assertEquals(2, manager.getStudentCount());
    }
    
    @Test
    @Order(6)
    void testGetAllStudents() {
        manager.addStudent("이영희");
        Set<String> all = manager.getAllStudents();
        assertTrue(all.contains("김철수"));
        assertTrue(all.contains("홍길동"));
        assertTrue(all.contains("이영희"));
        assertEquals(3, all.size());
    }
    
    
}