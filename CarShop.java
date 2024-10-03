import java.util.ArrayList;
import java.util.Collections;  // Import the Collections class
import java.util.Scanner;  // Import the Scanner class

public class CarShop{

    public static ArrayList<Car> carList = new ArrayList<Car>(); // ArrayList objact to store all cars

    public static void main(String[] args) {
        // create seperator lines
        SepLine mainSep = new SepLine("=", 50);
        SepLine subSep = new SepLine("-", 50);

        mainSep.drawLine();
        System.out.println("> Hello! This is UNC Car Shop!");
        subSep.drawLine();

        // create a stock car & display info
        Car civic = new Car("Civic", "Honda", 0.3f, 110, 0.3f, 0, 0, 0);
        civic.displayInfo();
        System.out.println();

        // upgrade engine
        civic.upgradeEngine(3);

        // upgrade transmission
        civic.upgradeTransmission(3);

        // upgrade brakes
        civic.upgradeBrakes(3);

        // display info (civic)
        civic.displayInfo();
        System.out.println();

        // create a stock car & display info
        Car gallardo = new Car("Gallardo", "Lamborghini", 3.3f, 160, 4.3f, 0, 0, 0);
        gallardo.displayInfo();
        System.out.println();

        // upgrade engine
        gallardo.upgradeEngine(1);

        // upgrade transmission
        gallardo.upgradeTransmission(1);

        // upgrade brakes
        gallardo.upgradeBrakes(1);

        // display info (gallardo)
        gallardo.displayInfo();
        System.out.println();
        
        initiateDragRace(civic, gallardo);
        
        mainSep.drawLine();
    }

    public static void initiateDragRace(Car car1, Car car2){
        // start race
        System.out.println("# Drag Race Started!");

        // calculate avg points for both cars
        double firstCarAvg = car1.carAcceleration * car1.carTopSpeed * car1.carHandling;
        double secondCarAvg = car2.carAcceleration * car2.carTopSpeed * car2.carHandling;

        if(firstCarAvg > secondCarAvg){
            System.out.println("> " + car1.carName + " has won! Race points: " + firstCarAvg);
        } else {
            System.out.println("> " + car2.carName + " has won! Race points: " + secondCarAvg);
        }
    }
}

class Car{
    public String carName;
    public String carManufacturer;
    public float carAcceleration; // 0.0 to 5.0
    public int carTopSpeed; // mph
    public float carHandling; // 0.0 to 5.0
    public int carEngineLvl; // affects 'carAcceleration'
    public int carTransmissionLvl; // affects 'carTopSpeed'
    public int carBrakeLvl; // affects 'carHandling'

    public Car(String carName, String carManufacturer, float carAcceleration, int carTopSpeed, float carHandling, int carEngineLvl, int carTransmissionLvl, int carBrakeLvl){
        this.carName = carName;
        this.carManufacturer = carManufacturer;
        this.carAcceleration = carAcceleration;
        this.carTopSpeed = carTopSpeed;
        this.carHandling = carHandling;
        this.carEngineLvl = carEngineLvl;
        this.carTransmissionLvl = carTransmissionLvl;
        this.carBrakeLvl = carBrakeLvl;
    }

    public void upgradeEngine(int enginePoints){
        this.carEngineLvl += enginePoints;
        pointsCounter(1);
    }

    public void upgradeTransmission(int transmissionPoints){
        this.carTransmissionLvl += transmissionPoints;
        pointsCounter(2);
    }

    public void upgradeBrakes(int brakePoints){
        this.carBrakeLvl += brakePoints;
        pointsCounter(3);
    }

    public void pointsCounter(int upgradePart){ // method to count all engine, transmission, brake points and calculate car performance (Acceleration, Top Speed, Handling)
        // engine -> acceleration | transmission -> top speed | brakes -> handling
        switch(upgradePart){
            case 1:
                // upgrade engine -> accelaration
                switch(this.carEngineLvl){
                    case 1:
                        // increase acceleration by 1.0
                        this.carAcceleration += 1.0;
                        break;
                    case 2:
                        // increase acceleration by 2.0
                        this.carAcceleration += 2.0;
                        break;
                    case 3:
                        // increase acceleration by 3.0
                        this.carAcceleration += 3.0;
                        break;
                    default:
                        // no engine upgrades installed
                        break;
                }
                // trim to 5.0 if goes beyond 5.0
                if(this.carAcceleration > 5.0){
                    this.carAcceleration = 5.0f;
                }
                break;
            case 2:
                // upgrade transmission -> top speed
                switch(this.carTransmissionLvl){
                    case 1:
                        // increase top speed by 30
                        this.carTopSpeed += 30;
                        break;
                    case 2:
                        // increase top speed by 40
                        this.carTopSpeed += 40;
                        break;
                    case 3:
                        // increase top speed by 60
                        this.carTopSpeed += 60;
                        break;
                    default:
                        // no transmission upgrades installed
                        break;
                }
                break;
            default:
                // upgrade brakes -> handling
                switch(this.carBrakeLvl){
                    case 1:
                        // increase handling by 1.0
                        this.carHandling += 1.0;
                        break;
                    case 2:
                        // increase handling by 2.0
                        this.carHandling += 2.0;
                        break;
                    case 3:
                        // increase handling by 3.0
                        this.carHandling += 3.0;
                        break;
                    default:
                        // no brakes upgrades installed
                        break;
                }
                // trim to 5.0 if goes beyond 5.0
                if(this.carHandling > 5.0){
                    this.carHandling = 5.0f;
                }
                break;
        }
    }

    public void displayInfo(){
        System.out.println("> " + this.carManufacturer + " " + this.carName + " with level " + this.carAcceleration + " acceleration, " + this.carTopSpeed + "mph top speed, level " + this.carHandling + " handling.");
        System.out.println("> Engine Level: " + this.carEngineLvl + " | Transmission Level: " + this.carTransmissionLvl + " | Brakes Level: " + this.carBrakeLvl);
    }
}

class SepLine{
	private String lineType;
	private int lineLength;

	public SepLine(String lineType, int lineLength){
		this.lineType = lineType;
		this.lineLength = lineLength;
	}

	public void drawLine(){
        for (int i = 0; i < lineLength; i++) {
            System.out.print(lineType);
        }
        System.out.print("\n");
	}
}