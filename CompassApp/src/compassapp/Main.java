
package compassapp;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CompassDisplay display = display();
        CompassSensor sensor = sensor();
        new DisplayCommand (display,sensor).execute();
        Thread.sleep(1_000_000);
        
        
    }
    
    private static CompassDisplay display(){
        return new CompassDisplay(){
            @Override
            public void display(CompassMeasure measure){
                System.out.println(measure.angle());
            }
        };
    }


        private static CompassSensor sensor(){   
            return new CompassSensor(){    
            
            private CompassMeasure measure = new CompassMeasure(0);
                private CompassSensor.NewCompassMeasure event;
                {
                    new Timer().schedule(task(), 0, 1000);
                }
            
                @Override
                public CompassMeasure measure(){
                    return measure;
                
                }
            
                @Override
                public void on (CompassSensor.NewCompassMeasure event){
                    this.event = event;
                
                }

                private TimerTask task() {
                    return new TimerTask(){
                        @Override
                        public void run(){
                            if (event!=null) event.measure(newMeasure());
                        
                        }
                    
                        private CompassMeasure newMeasure(){
                            return measure = new CompassMeasure( measure.angle()+random());
                        }
                    
                        private double random(){
                            return 0.5 - new Random().nextDouble()*2;
                        }
                    };
               
                }
                
            };
    }
            
}
