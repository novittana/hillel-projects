//Создать наследника авто, у которого будет также максимальная скорость 400
//Создать метод, который будет говорить "СТОП" если вы привысили скрость!!!

import util.AutoBrand;
import util.AutoModel;

public class InheritAuto extends Auto {
    public InheritAuto(AutoBrand brand, AutoModel model, Integer mileage) {
        super(brand, model, mileage);
        this.maxSpeed = 400;
    }
}
