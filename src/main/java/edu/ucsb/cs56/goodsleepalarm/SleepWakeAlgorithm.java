package edu.ucsb.cs56.goodsleepalarm ;
import java.util.Calendar ;

public class SleepWakeAlgorithm {

    // MAYDO: Make variables a range 
    private static int sleepLen= 9 * 60 ;  // prioritize length of sleep over idealWakeTime
    private static int sleepAfter = 60 ; // this and wakeBefore prioritized most and
    private static int wakeBefore = 60 ; // represent hard limits after / before wake / sleep
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
     * Calculates the wake up and sleep times and stores them in SleepWakeAlgorithm's static Calendar variables wakeTime and sleepTime, times will be as close to ideal as possible (priority high to low: sleepAfter = wakeBefore, sleepLen, idealWakeTime) 
     * @param levent Calendar object for last event of today
     * @param fevent Calendar object for first of event of next day
     * @param idealWakeTime Calendar object for ideal time to wake
     * @param sleepTimeRet Calendar object to store calculated sleep time
     * @param wakeTimeRet Calendar object to store calculated wake time
     */
    public static void calcTime(Calendar levent, Calendar fevent, Calendar idealWakeTime, Calendar sleepTimeRet, Calendar wakeTimeRet) {
        setTime(wakeTime, fevent) ;
        setTime(sleepTime, levent) ;

        wakeTime.add(Calendar.MINUTE, -wakeBefore) ;
        sleepTime.add(Calendar.MINUTE, sleepAfter) ;
        
        long wmin = wakeTime.getTimeInMillis() / 60000 ;
        long smin = sleepTime.getTimeInMillis() / 60000;
        long imin = idealWakeTime.getTimeInMillis() / 60000 ; 
        int wakeBuffer = 0 ;

        // prefer the idealWakeTime and account for the change in case sleep length will be increased
        if (wmin > imin) {
            wakeBuffer = (int) (wmin - imin) ;
            setTime(wakeTime, idealWakeTime) ;
            wmin = imin ;
        }

        int minOfSleep = (int) (wmin - smin) ;
        // if there's sleep deficit, increase sleep until wakeBuffer is 0 
        // buffer leaves wakeBefore amount at min at least after/before events
        if (minOfSleep < sleepLen) {

            int sleepDef = sleepLen - minOfSleep ;

            if (sleepDef > wakeBuffer) 
                wakeTime.add(Calendar.MINUTE, wakeBuffer) ;
            else 
                wakeTime.add(Calendar.MINUTE, sleepDef) ;
        }

        smin = sleepTime.getTimeInMillis() / 60000 ;
        wmin = wakeTime.getTimeInMillis() / 60000 ;
        minOfSleep = (int) (wmin - smin) ;
        // reduces sleep length until ideal
        if (minOfSleep >= sleepLen) 
            sleepTime.add(Calendar.MINUTE, minOfSleep - sleepLen) ;

        setTime(sleepTimeRet, sleepTime);
        setTime(wakeTimeRet, wakeTime);
    }
}
