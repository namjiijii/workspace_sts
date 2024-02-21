public class Student {
    private String stuName;
    private int korScore;
    private int engScore;
    private int totalScore;

    public Student(String stuName, int korScore, int engScore) {
        this.stuName = stuName;
        this.korScore = korScore;
        this.engScore = engScore;
        this.totalScore = korScore + engScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", korScore=" + korScore +
                ", engScore=" + engScore +
                ", totalScore=" + totalScore +
                '}';
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getScoreAvg() {
        return totalScore;
    }
}
