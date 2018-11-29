package edu.ucsb.cs56.goodsleepalarm ;
import java.util.Calendar ;

public class SleepWakeAlgorithm {
    private static int sleepLen = 8 * 60 ;  // for now prioritize length of sleep over everything else
    private static int sleepAfter = 60 ;
    private static int wakeBefore = 60 ;  //prioritized over sleepAfter
    private static Calendar wakeTime = Calendar.getInstance() ;
    private static Calendar sleepTime = Calendar.getInstance() ;

    public static void setTime(Calendar dest, Calendar src) {
        dest.setTimeInMillis(src.getTimeInMillis()) ;
        dest.setTimeZone(src.getTimeZone()) ;
    }

    /**
     * Calculates the wake up and sleep times and stores them in SleepWakeAlgorithm's static Calendar variables wakeTime and sleepTime, times will be as close to ideal as possible
     * @param fevent Calendar object for first of event of next day
     * @param levent Calendar object for last event of today
     * @param idealWakeTime Calendar object for ideal time to wake
     */
    public static void calcTime(Calendar fevent, Calendar levent, Calendar idealWakeTime) {
        setTime(wakeTime, fevent) ;
        setTime(sleepTime, levent) ;

        wakeTime.add(Calendar.MINUTE, -wakeBefore) ;
        sleepTime.add(Calendar.MINUTE, sleepAfter) ;
        
        long wmin = wakeTime.getTimeInMillis() / 60000 ;
        long smin = sleepTime.getTimeInMillis() / 60000;
        long imin = sleepTime.getTimeInMillis() / 60000 ; 

        if (wmin > imin) 
            setTime(wakeTime, idealWakeTime) ;
            // if (fhour >= wakeBefore)
            //     wakeTime.set(Calendar.HOUR_OF_DAY, fhour - wakeBefore) ;
        
        long minOfSleep = wmin - smin ;
        // int minOfSleep = 24 - (lhour + sleepAfter) + fhour ;
        
        // if there's sleep deficit, increase sleep until sleepAfter is 60 min
        // then decrease wakeBefore until 60 min if there is still deficit
        if (minOfSleep < sleepLen) {
            if ((sleepLen - minOfSleep) > (sleepAfter - 60)) {
                sleepTime.add(Calendar.MINUTE, 60 - sleepAfter) ;
                minOfSleep += sleepAfter - 60 ;
            }
            else {
                sleepTime.add(Calendar.MINUTE, (int) (minOfSleep - sleepLen)) ;
                minOfSleep = sleepLen ;
            }

            if ((sleepLen - minOfSleep) > (wakeBefore - 60)) 
                wakeTime.add(Calendar.MINUTE, wakeBefore - 60) ;
            else
                wakeTime.add(Calendar.MINUTE, (int) (sleepLen - minOfSleep)) ;
        }
    }

    public static void main(String [] args) {
        Calendar temp1 = Calendar.getInstance() ;
        Calendar temp2 = Calendar.getInstance() ;
        Calendar temp3 = Calendar.getInstance() ;
        temp1.set(Calendar.HOUR_OF_DAY, 10) ;
        temp1.set(Calendar.DAY_OF_MONTH, 29) ;
        temp1.add(Calendar.MINUTE, 50) ;
        temp2.set(Calendar.HOUR_OF_DAY, 22) ;
        temp2.add(Calendar.MINUTE, 23) ;
        temp3.set(Calendar.DAY_OF_MONTH, 29) ;
        temp3.set(Calendar.HOUR_OF_DAY, 8) ;
        temp3.add(Calendar.MINUTE, -54) ;
        System.out.println(temp1.getTime()) ;
        System.out.println(temp2.getTime()) ;
        System.out.println(temp3.getTime() + "\n") ;
        calcTime(temp1, temp2, temp3) ;
        System.out.println(wakeTime.getTime()) ;
        System.out.println(sleepTime.getTime()) ;
        // System.out.println("" + SleepWakeAlgorithm.wakeTime.get(Calendar.DAY_OF_MONTH)) ;
        // System.out.println("" + SleepWakeAlgorithm.sleepTime.get(Calendar.DAY_OF_MONTH)) ;
    }
}
