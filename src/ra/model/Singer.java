package ra.model;

import ra.config.InputMethods;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private  int age;
    private  String nationality;
    private  boolean gender;
    private String genre;

    public Singer() {
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void inputData(){
//        Scanner scanner = new Scanner(System.in);
        // Nhập dữ liệu cho từng trường
        System.out.println("Nhập tên ca sĩ : ");
        this.singerName= InputMethods.getString();
//        while (true) {
//            String result =scanner.nextLine();
//            if (result.trim().equals("")) {
//                System.err.println(InputMethods.EMPTY_ALERT);
//            }else {
//                this.singerName = result;
//                break;
//            }
//        }
        System.out.println("Nhập tuổi ");
        this.age = InputMethods.getPositiveInteger();
        System.out.println("Nhập quốc tịch");
        this.nationality = InputMethods.getString();
        System.out.println("Nhập giới tính ");
        this.gender = InputMethods.getBoolean();
        System.out.println("Nhập thể loại");
        this.genre = InputMethods.getString();
    }
    public void displayData(){
        System.out.println("-----------------------------------------");
        System.out.println("ID : "+singerId + " | Name: "+ singerName);
        System.out.println("Age : "+age + " | Nationality: "+ nationality);
        System.out.println("Gender : "+ (gender?"Nam":"Nữ") + " | Genre : " +genre);
    }
}
