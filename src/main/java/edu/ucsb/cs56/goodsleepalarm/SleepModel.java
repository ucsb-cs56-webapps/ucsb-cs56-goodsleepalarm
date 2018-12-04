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

    	SleepWakeAlgorithm.setTime(idealWakeTime, wakeTimeCal);
    	idealWakeTime.set(Calendar.HOUR_OF_DAY, 8);
    	idealWakeTime.set(Calendar.MINUTE, 0);
		
    	SleepWakeAlgorithm.calcTime(sleepTimeCal, wakeTimeCal, idealWakeTime, sleepTime, wakeTime);
    }

    @Override
    public String toString() {
    	if (wakeTime.getTimeInMillis() < sleepTime.getTimeInMillis()) {
    		String output = "Error: wake up time is before sleep time\n";
    		// output += "Sleep time: " + sleepTime.toString() + "\n";
    		// output += "Wake time: " + wakeTime.toString();
    		return output;
    	} else {
            String output = String.format("Sleep: %1$tI:%1$tM %1$Tp\n", sleepTime) ;
            output += String.format("Wake: %1$tI:%1$tM %1$Tp\n", wakeTime) ;
    		return output;
    	}
    }
}
