<h1>PROJECT DESCRIPTION</h1>
<p>We want to develop a class called TyrantTutor. The class will be used to store lecture attendance details.
When a student attends a lecture they will send a text message to a specified mobile phone number (e.g. 66999 or 99666 or whatever).
The message will have the lecture module code and the student’s ID number. The system will automatically append the student’s mobile phone number and the time the message was sent (in seconds since midnight 1 Jan 1970).</p>
<p align="center">For example, a typical message would look something like this:<br>
<b>CS4411    09323204     086-7595139      1257260156</b></p>
<p>TyrantTutor stores each message received in a list (of strings). Write the code for the class that maintains the list.
The class should support/provide the following services:</p>

•	When creating instances of the class the user should be able to decide the capacity of the list (i.e. the maximum number of items it can store).
In addition, the user must supply a String value representing the module code and an integer value specifying the hour of the day that the class starts at (i.e. in 24 format, typically a value between 9 and 17).

•	Allow new attendance messages to be inserted into the list. If the list is full then the message should be ignored. The header for the insert operation is
<p align="center"><b>public void insert(String attendMsg)</b></p>

•	Show the current contents of the list on the screen. If the list is empty nothing is displayed on the screen. The header for the showList operation is 
<p align="center"><b>public void showList()</b></p>

•	Send a text message to all the students who showed up for the lecture. The text of the message is passed as a parameter. (Note: We can’t actually send a text message so we will simulate the operation by using System.out.println to display each student phone number and the message on the screen. EndNote)
The header for the weLoveInteraction operation is
<p align="center"><b>public void weLoveInteraction(String msgText)</b></p>

•	Randomly pick an entry from the list. The method returns the student ID number and phone number (i.e. as a concatenated string with one or more spaces between the two values) of the randomly chosen entry.
If the list is empty the method returns an empty string. The header for the chosenOne operation is  
<p align="center"><b>public String chosenOne()</b></p>

•	Determine whether a particular student attended the class or not. The method is passed a student ID number (i.e. as a String) and returns true if the student was in attendance (i.e. has an entry in the list) and false otherwise.
The header for the whereIs operation is  
<p align="center"><b>public boolean whereIs(String ID)</b></p>

•	List on the screen the ID numbers and phone numbers of the students who arrived either early or late. If the list is empty nothing is displayed on the screen.
The method is passed a value indicating which list is required. Passing the value true selects the list of late arrivals. Passing the value false lists the early arrivals.
The header for the punctuality operation is 
<p align="center"><b>public void punctuality(boolean late)</b></p>

•	Randomly select and display an entry from the list until all of the entries have been randomly selected. Each entry should be selected only once. This operation is useful for question time when the tutor asks each student in attendance a question. The header for the questionTime operation is
<p align="center"><b>public void questionTime()</b></p>
