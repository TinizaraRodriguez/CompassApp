
package compassapp;

public class DisplayCommand {
    
    private final CompassDisplay display;
    private final CompassSensor sensor;
    
    public DisplayCommand (CompassDisplay display, CompassSensor sensor){
        this.display = display;
        this.sensor = sensor;
        this.sensor.on(newMeasure());
    }
    
    public void execute(){
        this.display.display(sensor.measure());
    }

    private CompassSensor.NewCompassMeasure newMeasure() {
       return new CompassSensor.NewCompassMeasure() {
           public void measure (CompassMeasure measure){
               display.display(measure);
           }
           
       };
    }
}
