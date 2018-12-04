package edu.ucsb.cs56.goodsleepalarm ;

import static org.junit.Assert.assertEquals ;

import java.util.Calendar ;
import org.junit.Test ;
import org.junit.Before ;

public class SleepWakeAlgorithmTest {
    private Calendar sleep = Calendar.getInstance() ; 
    private Calendar wake = Calendar.getInstance() ; 
    private Calendar sleepCal = Calendar.getInstance() ; 
    private Calendar wakeCal = Calendar.getInstance() ; 
    private Calendar ideal = Calendar.getInstance() ; 

    public String getString(Calendar c1, Calendar c2) {
        return String.format("%1$tI:%1$tM %1$Tp ", c1) + String.format("%1$tI:%1$tM %1$Tp", c2) ;
    }
    @Before public void setUp() {
        sleep.set(Calendar.DAY_OF_MONTH, 1) ;
        wake.set(Calendar.DAY_OF_MONTH, 2) ;
        SleepWakeAlgorithm.setTime(ideal, wake) ;
    }
    
    @Test
    public void test_calcTime_8P_12P_9A() {
        sleep.set(Calendar.HOUR_OF_DAY, 20) ;
        sleep.set(Calendar.MINUTE, 0) ;
        wake.set(Calendar.HOUR_OF_DAY, 12) ;
        wake.set(Calendar.MINUTE, 0) ;
        ideal.set(Calendar.HOUR_OF_DAY, 9) ;
        ideal.set(Calendar.MINUTE, 0) ;
        SleepWakeAlgorithm.calcTime(sleep, wake, ideal, sleepCal, wakeCal) ;
        assertEquals("12:00 AM 09:00 AM", getString(sleepCal, wakeCal)) ;
    }

    @Test
    public void test_calcTime_1130P_630A_9A() {
        sleep.set(Calendar.HOUR_OF_DAY, 23) ;
        sleep.set(Calendar.MINUTE, 30) ;
        wake.set(Calendar.HOUR_OF_DAY, 6) ;
        wake.set(Calendar.MINUTE, 30) ;
        ideal.set(Calendar.HOUR_OF_DAY, 9) ;
        SleepWakeAlgorithm.calcTime(sleep, wake, ideal, sleepCal, wakeCal) ;
        assertEquals("12:30 AM 05:30 AM", getString(sleepCal, wakeCal)) ;

    }

    @Test
    public void test_calcTime_1115P_653A_506A() {
        sleep.set(Calendar.HOUR_OF_DAY, 23) ;
        sleep.set(Calendar.MINUTE, 15) ;
        wake.set(Calendar.HOUR_OF_DAY, 6) ;
        wake.set(Calendar.MINUTE, 53) ;
        ideal.set(Calendar.HOUR_OF_DAY, 5) ;
        ideal.set(Calendar.MINUTE, 6) ;
        SleepWakeAlgorithm.calcTime(sleep, wake, ideal, sleepCal, wakeCal) ;
        assertEquals("12:15 AM 05:53 AM", getString(sleepCal, wakeCal)) ;

    }

    @Test
    public void test_calcTime_8A_1P_10A() {
        sleep.set(Calendar.HOUR_OF_DAY, 8) ;
        sleep.set(Calendar.MINUTE, 0) ;
        wake.set(Calendar.HOUR_OF_DAY, 13) ;
        wake.set(Calendar.MINUTE, 0) ;
        ideal.set(Calendar.HOUR_OF_DAY, 10) ;
        ideal.set(Calendar.MINUTE, 0) ;
        SleepWakeAlgorithm.calcTime(sleep, wake, ideal, sleepCal, wakeCal) ;
        assertEquals("01:00 AM 10:00 AM", getString(sleepCal, wakeCal)) ;

    }

    @Test
    public void test_calcTime_617P_1154A_823A() {
        sleep.set(Calendar.HOUR_OF_DAY, 18) ;
        sleep.set(Calendar.MINUTE, 17) ;
        wake.set(Calendar.HOUR_OF_DAY, 11) ;
        wake.set(Calendar.MINUTE, 54) ;
        ideal.set(Calendar.HOUR_OF_DAY, 8) ;
        ideal.set(Calendar.MINUTE, 23) ;
        SleepWakeAlgorithm.calcTime(sleep, wake, ideal, sleepCal, wakeCal) ;
        assertEquals("11:23 PM 08:23 AM", getString(sleepCal, wakeCal)) ;

    }

    @Test
    public void test_calcTime_1025P_714A_9A() {
        sleep.set(Calendar.HOUR_OF_DAY, 22) ;
        sleep.set(Calendar.MINUTE, 25) ;
        wake.set(Calendar.HOUR_OF_DAY, 7) ;
        wake.set(Calendar.MINUTE, 14) ;
        ideal.set(Calendar.HOUR_OF_DAY, 9) ;
        ideal.set(Calendar.MINUTE, 0) ;
        SleepWakeAlgorithm.calcTime(sleep, wake, ideal, sleepCal, wakeCal) ;
        assertEquals("11:25 PM 06:14 AM", getString(sleepCal, wakeCal)) ;
    }

    @Test
    public void test_calcTime_1030P_1001A_722A() {
        sleep.set(Calendar.HOUR_OF_DAY, 22) ;
        sleep.set(Calendar.MINUTE, 30) ;
        wake.set(Calendar.HOUR_OF_DAY, 10) ;
        wake.set(Calendar.MINUTE, 01) ;
        ideal.set(Calendar.HOUR_OF_DAY, 7) ;
        ideal.set(Calendar.MINUTE, 22) ;
        SleepWakeAlgorithm.calcTime(sleep, wake, ideal, sleepCal, wakeCal) ;
        assertEquals("11:30 PM 08:30 AM", getString(sleepCal, wakeCal)) ;
    }
}
