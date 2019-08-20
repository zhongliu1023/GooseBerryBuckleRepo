package appstute.in.smartbuckle.model;

/**
 * Created by ashishshah on 04/05/17.
 */

public class UserVo {

    private String userID;
    private String fullName;
    private String email;
    private String password;
    private int cellPhone;
    private int heightFeet;
    private int heightInch;
    private String gender;
    private int weightLbs;
    private String units;
    private int heightCm;
    private int weightKg;



    public UserVo() {
        this.heightFeet = 0;
        this.heightInch = 0;
        this.gender = "";
        this.weightLbs = 0;
        this.units = "";
        this.heightCm = 0;
        this.weightKg = 0;
        this.fullName = "";
        this.email = "";
        this.password = "";
        this.cellPhone = 0;
        this.userID = "";

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(int cellPhone) {
        this.cellPhone = cellPhone;
    }

    public int getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(int heightFeet) {
        this.heightFeet = heightFeet;
    }

    public int getHeightInch() {
        return heightInch;
    }

    public void setHeightInch(int heightInch) {
        this.heightInch = heightInch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(int weightLbs) {
        this.weightLbs = weightLbs;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId=" + userID+
                "fullName" + fullName+
                "email" + email+
                "cellPhone" + cellPhone+
                "password" + password+
                "heightFeet=" + heightFeet +
                ", heightInch=" + heightInch +
                ", gender='" + gender + '\'' +
                ", weightLbs=" + weightLbs +
                ", units='" + units + '\'' +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg +
                '}';
    }
}
