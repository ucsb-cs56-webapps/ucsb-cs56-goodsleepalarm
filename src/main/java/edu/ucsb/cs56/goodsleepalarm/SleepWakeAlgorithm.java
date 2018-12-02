package edu.ucsb.cs56.goodsleepalarm ;
import java.util.Calendar ;

public class SleepWakeAlgorithm {

    private static int sleepLen = 8 * 60 ;  // for now prioritize length of sleep over everything else
    private static int sleepAfter = 60 ;
    private static int wakeBefore = 3 * 60 ;  //prioritized over sleepAfter  
    private static Calendar wakeTime = Calendar.getInstance() ;
    private static Calendar sleepTime = Calendar.getInstance() ;

    /**
     * Sets one Calendar object with the value of another Calendar object
     * @param dest Calendar object destination to be modified 
     * @param src Calendar object with source values
     */
    public static void setTime(Calendar dest, Calendar src) {
        dest.setTimeInMillis(src.getTimeInMillis()) ;
        dest.setTimeZone(src.getTimeZone()) ;
    }

    /**
     * Calculates the wake up and sleep times and stores them in SleepWakeAlgorithm's static Calendar variables wakeTime and sleepTime, times will be as close to ideal as possible (priority high to low: sleepLen, idealWakeTime, wakeBefore, sleepAfter) 
     * @param fevent Calendar object for first of event of next day
     * @param levent Calendar object for last event of today
     * @param idealWakeTime Calendar object for ideal time to wake
     */
    public static void calcTime(Calendar fevent, Calendar levent, Calendar idealWakeTime, Calendar sleepTimeReturn, Calendar wakeTimeReturn) {
        setTime(wakeTime, fevent) ;
        setTime(sleepTime, levent) ;

        wakeTime.add(Calendar.MINUTE, -wakeBefore) ;
        sleepTime.add(Calendar.MINUTE, sleepAfter) ;
        
        long wmin = wakeTime.getTimeInMillis() / 60000 ;
        long smin = sleepTime.getTimeInMillis() / 60000;
        long imin = idealWakeTime.getTimeInMillis() / 60000 ; 
        int diffWakeIdeal = 0 ;

        // prefer the idealWakeTime and account for the change in case sleep length will be increased
        if (wmin > imin) {
            diffWakeIdeal = (int) (wmin - imin) ;
            setTime(wakeTime, idealWakeTime) ;
            wmin = imin ;
        }

        int minOfSleep = (int) (wmin - smin) ;
        // if there's sleep deficit, increase sleep until sleepBuffer is 0
        // then use up wakeBuffer until 0 if there is still deficit
        // buffers here leave 60 min at least after/before events
        if (minOfSleep < sleepLen) {
            int sleepBuffer = sleepAfter - 60 ;
            if ((sleepLen - minOfSleep) > sleepBuffer) {
                sleepTime.add(Calendar.MINUTE, -sleepBuffer) ;
                minOfSleep += sleepBuffer ;
            }
            else {
                sleepTime.add(Calendar.MINUTE, minOfSleep - sleepLen) ;
                minOfSleep = sleepLen ;
            }

            int wakeBuffer = wakeBefore - 60 + diffWakeIdeal ;
            if ((sleepLen - minOfSleep) > wakeBuffer) 
                wakeTime.add(Calendar.MINUTE, wakeBuffer) ;
            else 
                wakeTime.add(Calendar.MINUTE, sleepLen - minOfSleep) ;
        }

        smin = sleepTime.getTimeInMillis() / 60000 ;
        wmin = wakeTime.getTimeInMillis() / 60000 ;
        minOfSleep = (int) (wmin - smin) ;
        int wakeBuffer = (int) (fevent.getTimeInMillis() / 60000 - wmin - 60) ;
        // reduces sleep length until ideal
        if (minOfSleep >= sleepLen) {

            sleepTime.add(Calendar.MINUTE, minOfSleep - sleepLen) ;
            // increase wakeTime closer to idealWakeTime if possible (priority over wakeBefore) while preserving sleep length 
            if (wmin < imin && wakeBuffer > 0 ) {
                if ((imin - wmin) < wakeBuffer) {
                    setTime(wakeTime, idealWakeTime) ;
                    sleepTime.add(Calendar.MINUTE, (int) (imin - wmin)) ;
                }
                else {
                    wakeTime.add(Calendar.MINUTE, wakeBuffer) ; 
                    sleepTime.add(Calendar.MINUTE, wakeBuffer) ;
                }
            }
        }
        setTime(sleepTimeReturn, sleepTime);
        setTime(wakeTimeReturn, wakeTime);
    }

    // public static void main(String [] args) {
    //     Calendar temp1 = Calendar.getInstance() ;
    //     Calendar temp2 = Calendar.getInstance() ;
    //     Calendar temp3 = Calendar.getInstance() ;
    //     temp1.set(Calendar.HOUR_OF_DAY, 10) ;
    //     temp1.set(Calendar.DAY_OF_MONTH, 29) ;
    //     temp1.add(Calendar.MINUTE, 50) ;
    //     temp2.set(Calendar.HOUR_OF_DAY, 5) ;
    //     temp2.set(Calendar.DAY_OF_MONTH, 29) ;
    //     temp2.add(Calendar.MINUTE, 23) ;
    //     temp3.set(Calendar.DAY_OF_MONTH, 29) ;
    //     temp3.set(Calendar.HOUR_OF_DAY, 8) ;
    //     temp3.add(Calendar.MINUTE, 1) ;
    //     System.out.println(temp1.getTime()) ;
    //     System.out.println(temp2.getTime()) ;
    //     System.out.println(temp3.getTime() + "\n") ;
    //     calcTime(temp1, temp2, temp3) ;
    //     System.out.println(wakeTime.getTime()) ;
    //     System.out.println(sleepTime.getTime()) ;
        // System.out.println("" + SleepWakeAlgorithm.wakeTime.get(Calendar.DAY_OF_MONTH)) ;
        // System.out.println("" + SleepWakeAlgorithm.sleepTime.get(Calendar.DAY_OF_MONTH)) ;
    // }
}
