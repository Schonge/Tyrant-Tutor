package com.JohnConnolly.TyrantTutor;

import java.util.Random ;
import java.util.Calendar ;

/*
 * Randomly generates data for Tyrant Tutor program.
 */

public class DataGenerator
{ 
    private Random rnd ;
    private String module ; // Module code
    private long startTime ; // Class start time in seconds since midnight
    
    public DataGenerator(String moduleCode, int startHour)
    {
        rnd = new Random(); // Used for generating random numbers
        module = moduleCode ;
        startTime = (Calendar.getInstance().getTimeInMillis()/1000/86400*86400) + (startHour * 3600) ;
        /* The JAVA clock keeps time as a number of miliseconds since midnight 1 Jan 1970. Dividing
         * by 1000 converts it to a number of seconds. 
         * There are 86400 seconds in a day. Dividing the seconds by 86400 calculates how many 'whole'
         * days have elapsed since 1 Jan 1970. Multiplying the number of days by 86400 gets you the
         * time in seconds up to midnight last night. Adding on the number of seconds up to the class
         * start hour SIMULATES a class starting at that time TODAY.
         */
    }
    
    public String getNext()
    {
        int i ;
        long arriveTime ;
        String ID, phoneNumber ;
        
        /* nextInt is a random number generator method. If you specify a value in nextInt, e.g.
         *         nextInt(N)
         * the system will generate a random number in the range 0 to N-1.
         */
        
        // Randomly pick a Student ID number between 1 and 999999. Note the nextInt method generates a
        // value between 0 and 999998. By adding 1 we alter the range to between 1 and 999999.
        ID = "" + (rnd.nextInt(999999) + 1 ) ;
        // Add leading zeros if the length of the random ID number is less than 6 digits
        if(ID.length() < 6) {
            ID = "000000".substring(0,6 - ID.length()) + ID ;
        }
        // Make it a student ID number for a student registering this year
        ID = "09" + ID ;
        
        // Randomly pick a phone number between 1 and 9999999. Note the nextInt method generates a
        // value between 0 and 9999998. By adding 1 we alter the range to between 1 and 9999999.
        phoneNumber = "" + (rnd.nextInt(9999999) + 1 ) ;
        // Add leading zeros if the length of the random phone number is less than 7 digits
        if(phoneNumber.length() < 7) {
            phoneNumber = "0000000".substring(0,7 - phoneNumber.length()) + phoneNumber ;
        }
        
        // Randomly choose a phone network provider i.e. 083 or 085 or 086 or 087
        //                                                0      1      2      3
        i = rnd.nextInt(4) ; // --------------------------^------^------^------^
        phoneNumber = "083.085.086.087.".substring(i*4,i*4+3) + "-"  + phoneNumber ;
        
        // Generate a random number between 0 and 1
        if(rnd.nextInt(2) == 0) {
            // If it is 0 create an EARLY arrival time by subtracting a random number (0 to 299)
            // of seconds from the class start time
            arriveTime = startTime - rnd.nextInt(300) ; // arrive early up to 5 mins before start
        } else {
            // If it is 1 create a LATE arrival time by adding a random number (0 to 599)
            // of seconds to the class start time
            arriveTime = startTime + rnd.nextInt(600) ; // arrive late up to 10 mins after start
        }
        
        // Concatenate the values into a single string and return the string
        return module + " " + ID + " " + phoneNumber + " " + arriveTime ;    
    }
    
    // The test method will generate N sample strings
    public void test(int N)
    {
        int i ;
        for(i = 0 ; i < N ; i++) {
            System.out.println(getNext()) ;
        }
    }
}
