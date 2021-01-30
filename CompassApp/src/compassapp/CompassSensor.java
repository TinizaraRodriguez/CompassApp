
package compassapp;


public interface CompassSensor {
    
    void on(NewCompassMeasure event);

    public CompassMeasure measure();
        public interface NewCompassMeasure{
            void measure (CompassMeasure measure);
              
        
    }
    
}
