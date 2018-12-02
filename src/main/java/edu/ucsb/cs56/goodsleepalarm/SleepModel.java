package edu.ucsb.cs56.goodsleepalarm ;
import java.util.Calendar ;
import lombok.Data ;

@Data
public class SleepModel {
    private String wakeup ;		// Start time of first event
    private String sleep ;		// End time of last event

    private Calendar sleepTime = Calendar.getInstance();
    private Calendar wakeTime = Calendar.getInstance();

    public void runSleepWakeAlgorithm() {
    	
    	Calendar sleepTimeCal = Calendar.getInstance();
    	Calendar wakeTimeCal = Calendar.getInstance();
    	Calendar idealWakeTime = Calendar.getInstance();

    	sleepTimeCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(sleep.substring(0, 2)));
    	sleepTimeCal.set(Calendar.MINUTE, Integer.parseInt(sleep.substring(3)));
    	wakeTimeCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(wakeup.substring(0, 2)));
    	wakeTimeCal.set(Calendar.MINUTE, Integer.parseInt(wakeup.substring(3)));
    	wakeTimeCal.add(Calendar.HOUR_OF_DAY, 24);


    	//sleepTimeCal.set(1, 1, 1, Integer.parseInt(sleep.substring(0, 2)), Integer.parseInt(sleep.substring(3), 0));
    	//wakeTimeCal.set(1, 1, 2, Integer.parseInt(wakeup.substring(0, 2)), Integer.parseInt(wakeup.substring(3), 0));
    	
    	SleepWakeAlgorithm.setTime(idealWakeTime, wakeTimeCal);
    	idealWakeTime.set(Calendar.HOUR_OF_DAY, 8);
		
    	SleepWakeAlgorithm.calcTime(wakeTimeCal, sleepTimeCal, idealWakeTime, sleepTime, wakeTime);
    }

    @Override
    public String toString() {
    	if (wakeTime.getTimeInMillis() < sleepTime.getTimeInMillis()) {
    		String output = "Error: wake up time is before sleep time\n";
    		output += "Sleep time: " + sleepTime.toString() + "\n";
    		output += "Wake time: " + wakeTime.toString();
    		return output;
    	} else {
    		String output = "Sleep: " + sleepTime.get(Calendar.HOUR_OF_DAY) + ":" + sleepTime.get(Calendar.MINUTE) + "\n";
    		output += "Wake: " + wakeTime.get(Calendar.HOUR_OF_DAY) + ":" + wakeTime.get(Calendar.MINUTE);
    		return output;
    	}
    }
}
