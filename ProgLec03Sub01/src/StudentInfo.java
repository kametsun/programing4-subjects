/**
 * 複数の学生を管理するクラス
 */
public class StudentInfo {
    /**
     * 取り扱える学生の最大数
     */
    public static final int MAX_COUNT = 100;
    /**
     * 管理する生徒たち
     */
    Student[] students = new Student[MAX_COUNT];
    /**
     * 配列に格納された生徒数
     */
    int studentCount = 0;

    public int getStudentCount() {
        return studentCount;
    }

    /**
     * 学生追加メソッド
     *
     * @param s Student
     * @return boolean
     */
    public boolean addStudents(Student s) {
        if (s == null) return false;
        if (studentCount >= MAX_COUNT) return false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].studentID.equals(s.studentID)) return false;
        }
        students[studentCount++] = s;
        return true;
    }

    /**
     * 登録されているStudentの平均値
     *
     * @return double
     */
    public double getAverage() {
        if (studentCount == 0) return 0;
        double sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += students[i].getAge();
        }
        return sum / studentCount;
    }
}
