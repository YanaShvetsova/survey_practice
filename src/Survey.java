import java.util.ArrayList;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */


        Scanner input = new Scanner(System.in);
        ArrayList<Participant> allParticipants = new ArrayList<>();
        int eldest = Integer.MIN_VALUE, youngest = Integer.MAX_VALUE;

        do{
            System.out.println(SurveyQuestions.askToJoin);
            String answerToJoin = input.nextLine();

            if(answerToJoin.toLowerCase().startsWith("y")){
                //Increase the participant count by 1 and Ask the other questions
                Participant.addParticipants(); // This will increase the number of participant by one

                System.out.println(SurveyQuestions.askName);
                String name = input.nextLine();

                System.out.println(SurveyQuestions.askAge);
                int age = input.nextInt();

                System.out.println(SurveyQuestions.askGender);
                char gender = input.next().toUpperCase().charAt(0); // F or M

                input.nextLine();

                //Create a new Participant with above info
                Participant p = new Participant(name, age, gender);
                allParticipants.add(p);

                if(gender == 'F') Participant.addFemaleParticipants();
                else Participant.addMaleParticipants();
            }
        } while(Participant.totalNumberOfParticipants < 3);


        for (Participant participant : allParticipants) {
            System.out.println(participant);
            if(participant.age > eldest) eldest = participant.age;
            if(participant.age < youngest) youngest = participant.age;
        }

        System.out.println("The total number of male participants is = " + Participant.totalNumberOfMaleParticipants);
        System.out.println("The total number of female participants is = " + Participant.totalNumberOfFemaleParticipants);

        System.out.println("The age of the youngest person is = " + youngest);
        System.out.println("The age of the eldest person is = " + eldest);
    }
}
