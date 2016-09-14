package com.JohnConnolly.TyrantTutor;

import java.util.Random;

public class TyrantTutor {
	
	private String[] messages;
	public String modCode;
	public int classStart;
	private int listCapacity;
	private int usedCount;
	private Random rand;
	
	public static void main(String[] args) {
		
		TyrantTutor tt = new TyrantTutor(30, "CS4411", 3600);
		tt.showList();
		
	}
	
	public TyrantTutor() {
		modCode = "CS4411";
		classStart = 3600;
		listCapacity = 30;
		DataGenerator dataGen = new DataGenerator(modCode, classStart);
		messages = new String[listCapacity];
		
		for(int i = 0; i < listCapacity; i++) {
			messages[i] = dataGen.getNext();
			usedCount++;
		}
				
	}
	
	public TyrantTutor(int capacity, String moduleCode, int hourOfDay) {
		this.modCode = moduleCode;
		this.classStart = hourOfDay;
		DataGenerator dataGen = new DataGenerator(modCode, classStart);
		messages = new String[capacity];
		
		for(int i = 0; i < capacity; i++) {
			messages[i] = dataGen.getNext();
			usedCount++;
		}
	}
	
	public void insert(String attendMsg) {
		if(usedCount < messages.length) {
			messages[usedCount] = attendMsg;
			usedCount++;
		} else {
			System.out.println("Message List is full!");
		}
	}
	
	public void showList() {
		for(int i = 0; i < messages.length; i++) {
			System.out.println(messages[i]);
		}		
	}
	
	public void weLoveInteraction(String msgText) {
		 for(int i = 0; i < messages.length; i++) {
			 System.out.println(phoneOf(messages[i]) + " " + msgText);
		 }
	}
	
	public String chosenOne() {
		rand = new Random();
		if(usedCount > 0) {
			int r = rand.nextInt(usedCount);
			return idOf(messages[r]) + " " + phoneOf(messages[r]);
		} else {
			return "No students in this list";
		}
	}
	
	public boolean whereIs(String ID) {
		int i;
		for(i = 0; i < messages.length && ID.compareTo(idOf(messages[i])) != 0; i++);
		if(i < usedCount) {
			return true;
		} else {
			return false;
		}
	}
	
	public void punctuality(boolean late) {
		int j = 0, k = 0;
		String[] lateAttend = new String[listCapacity];
		String[] onTime = new String[listCapacity];
		for(int i = 0; i < messages.length; i++) {
			if(late == true && timeOf(messages[i]) > classStart) {
				lateAttend[j] = idOf(messages[i]) + " " + phoneOf(messages[i]);
				System.out.println(lateAttend[j] + " LATE");
				j++;
			} else {
				onTime[k] = idOf(messages[k]) + " " + phoneOf(messages[k]);
				System.out.println(onTime[k] + " ON TIME");
				k++;
			}
		}
		
	}
	
	public void questionTime() {
		boolean[] askedStudent = new boolean[usedCount] ;
        int r ;
        int i ;
        int notAskedYet ;
        for(i = 0 ; i < usedCount ; i++)
        {
            askedStudent[i] = false ;
        }
        notAskedYet = usedCount ;
        while(notAskedYet > 0)
        {
            r = rand.nextInt(usedCount) ;
            if(askedStudent[r] == false)
            {
                System.out.println(idOf(messages[r])) ;
                askedStudent[r] = true ;
                notAskedYet-- ;
            }
        }
	}
	
	// Getter and Setter for class start time
	
	public int getClassStart() {
		return classStart;
	}
	
	public void setClassStart(int startTime) {
		classStart = startTime;
	}
	
	// Break down messages into Module, ID, Phone Number and Time    

	private String idOf(String msg)
	{
	    String[] msgComponents = msg.split(" ");
	    return msgComponents[1] ;
	}    
	       
	private String phoneOf(String msg)
	{
	    String[] msgComponents = msg.split(" ");
	    return msgComponents[2] ;
	} 
	      
	private long  timeOf(String msg)
	{
	    String[] msgComponents = msg.split(" ");
	    return Integer.valueOf(msgComponents[3]).intValue() ;
	}
	
}

