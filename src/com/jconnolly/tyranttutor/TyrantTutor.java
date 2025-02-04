package com.jconnolly.tyranttutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TyrantTutor {

    @SuppressWarnings("unused")
    private String moduleCode;
    private int classStart;
    private int classSize;
    private List<String> msgList;

    public TyrantTutor(String moduleCode, int classStart, int classSize) {
        this.moduleCode = moduleCode;
        this.classStart = classStart;
        this.classSize = classSize;
        msgList = new ArrayList<>(classSize);
    }

    public void insert(String attendMsg) {
        if(msgList.size() >= classSize) {
            System.out.println("The class is already full!");
        } else {
            msgList.add(attendMsg);
        }
    }

    public void showList() {
        if(!msgList.isEmpty()) {
            for(int i = 0; i < msgList.size(); i++) {
                System.out.println(msgList.get(i));
            }
        } else {
            System.out.println("The List is empty!");
        }
    }

    public void weLoveInteraction(String msgText) {
        String[] msgListParts;
        String phoneNumber;

        if(!msgList.isEmpty()) {
            for(int i = 0; i < msgList.size(); i++) {
                msgListParts = msgList.get(i).split(" ");
                phoneNumber = msgListParts[2];
                System.out.println(phoneNumber + " " + msgText);
            }
        } else {
            System.out.println("The List is empty!");
        }
    }

    public String chosenOne() {
        String[] msgListParts;
        String phoneNumber;
        String studentID;
        Random rand = new Random();

        if(!msgList.isEmpty()) {
            msgListParts = msgList.get(rand.nextInt(classSize)).split(" ");
            studentID = msgListParts[1];
            phoneNumber = msgListParts[2];
            return studentID + " " + phoneNumber;
        } else {
            return "";
        }
    }

    public boolean whereIs(String id) {
        String[] msgListParts;
        String studentID;

        if(!msgList.isEmpty()) {
            for(int i = 0; i < msgList.size(); i++) {
                msgListParts = msgList.get(i).split(" ");
                studentID = msgListParts[1];
                if(studentID.equals(id)) {
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }

    public void punctuality(boolean late) {
        String[] msgListParts;
        long arrivalTime;
        String studentId;
        String phoneNumber;
        List<String> earlyStudents = new ArrayList<>(classSize);
        List<String> lateStudents = new ArrayList<>(classSize);

        for(int i = 0; i < msgList.size(); i++) {
            msgListParts = msgList.get(i).split(" ");
            arrivalTime = Long.parseLong(msgListParts[3]);
            studentId = msgListParts[1];
            phoneNumber = msgListParts[2];
            int messageHour = (int)((arrivalTime / 3600) % 24);
            if(messageHour > classStart) {
                lateStudents.add(studentId + " " + phoneNumber);
            } else {
                earlyStudents.add(studentId + " " + phoneNumber);
            }
        }

        if(late && !lateStudents.isEmpty()) {
            for(int i = 0; i < lateStudents.size(); i++) {
                System.out.println(lateStudents.get(i));
            }
        } else if(!late && !earlyStudents.isEmpty()) {
            for(int i = 0; i < earlyStudents.size(); i++) {
                System.out.println(earlyStudents.get(i));
            }
        } else {
            System.out.println("");
        }
    }

    public void questionTime() {
        List<String> tempList = new ArrayList<>(msgList);
        Collections.shuffle(tempList);

        for(String message : tempList) {
            String[] msgListParts = message.split(" ");
            System.out.println("Question for " + msgListParts[1] + " " + msgListParts[2]);
        }        
    }

}