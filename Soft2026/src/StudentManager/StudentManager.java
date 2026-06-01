package StudentManager;
import java.util.HashSet;
import java.util.Set;
public class StudentManager {
    private Set<String> students = new HashSet<>();
    
    // 학생 추가
    public void addStudent(String name) {
        if (students.contains(name)) {
            throw new IllegalArgumentException("이미 존재하는 학생입니다: " + name);
        }
        students.add(name);
    }
    
    // 학생 삭제
    public void removeStudent(String name) {
        if (!students.contains(name)) {
            throw new IllegalArgumentException("존재하지 않는 학생입니다: " + name);
        }
        students.remove(name);
    }
    
    // 학생 존재 여부 확인 (boolean값 반환)
    public boolean hasStudent(String name) {
        return students.contains(name);
    }
    
    // 학생 수 반환
    public int getStudentCount() {
        return students.size();
    }
    
    // 전체 학생 목록 반환
    public Set<String> getAllStudents() {
        return new HashSet<>(students);
    }
}