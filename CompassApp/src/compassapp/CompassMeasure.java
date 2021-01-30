
package compassapp;

public class CompassMeasure {
    
    private final double angle;
    
    public CompassMeasure (double angle){
        this.angle = angle;
    }

    CompassMeasure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public double angle(){
        return angle; 
    }
    
}
