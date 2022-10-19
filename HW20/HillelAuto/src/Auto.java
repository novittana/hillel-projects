import util.AutoBrand;
import util.AutoModel;
import util.Util;

import java.nio.file.FileSystemNotFoundException;
import java.util.Date;

//Создать класс авто с полями как в Hillel auto
//        Сделать валидацию на Milage, допустимые значения от 0 до 999999. Проверка должна выполнятся на момент создания обьекта.
public class Auto {
    protected Integer carId;
    protected Integer speed;
    protected Integer maxSpeed;
    protected String carCreatedDate;
    protected Integer mileage;
    //protected Object expence;

    protected AutoBrand brand;
    protected AutoModel model;

    //
    Auto(AutoBrand brand, AutoModel model, Integer mileage) {
        System.out.println("//======CREATING NEW AUTO======//");
        this.carId = Util.getId();
        this.speed = 0;
        this.maxSpeed = 300;
        this.brand = brand;
        this.model = model;
        System.out.println("Checking mileage");
        if (Util.isMilleageValid(mileage) == false) {
            System.out.println("Mileage is not valid - " + mileage);
        } else {
            System.out.println("Mileage is valid");
        }
        this.mileage = mileage;
        this.carCreatedDate = new Date().toString();
    }

    public void setCurrentSpeed(Integer speed){
        System.out.println("Checking current speed");
        if(speed > maxSpeed){
            System.out.println("STOP");
        } else {
            System.out.println("Speed is valid");
        }
        this.speed = speed;
    }

    public void showInfo (){
        System.out.println("\t\t//-------AUTO-------//");
        System.out.println("\t\tCarId - "+ this.carId);
        System.out.println("\t\tBrand - "+ this.brand.toString());
        System.out.println("\t\tModel - "+ this.model.toString());
        System.out.println("\t\tMileage - "+ this.mileage);
        System.out.println("\t\tCar created date - "+ this.carCreatedDate);
        System.out.println("\t\tCurrent speed - "+ this.speed);
        System.out.println("\t\tMax speed - "+ this.maxSpeed);
        System.out.println("\t\t//-----------------//");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
