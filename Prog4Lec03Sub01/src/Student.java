/**
 * 学生情報を扱うクラス
 */
public class Student {
    /**
     * 名前
     */
    String name;
    /**
     * 学生ID
     */
    String studentID;
    /**
     * 年齢
     */
    int age;

    /**
     * コンストラクタ
     *
     * @param name      名前
     * @param studentID 学生ID
     * @param age       年齢
     */
    public Student(String name, String studentID, int age) {
        this.name = name;
        this.studentID = studentID;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
