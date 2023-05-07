package hello.core.member.data;

public class Member {

    /*
    * 요구 사항에 있는 것은
    * id
    * name
    * grade
    *
    * 위 3개 말고는 없음.
    * */


    private long id;
    private String name;
    private Grade grade;

    // 생성자 생성
    public Member(long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
