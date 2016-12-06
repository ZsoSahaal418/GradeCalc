package gradecounter;
import java.util.*;

/**
 *
 * @author John Dixon
 */
public class GradeCounter {
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner to bring in new input
        Scanner scn = new Scanner(System.in);
        String grades = scn.nextLine();
        String letGrade = "";
        
        //split the grades into array slots, split on commas
        String[] scores = grades.split(",");
        int[] numGrades = new int[scores.length];
        
        //fill an array of ints with the number grades
        for(int i = 0;i < scores.length;i++){
            scores[i] = scores[i].trim();
            numGrades[i] = Integer.parseInt(scores[i]);
        }
        
        //Set the array of grades into decending order for printing
        Arrays.sort(numGrades);
        numGrades = reverseArray(numGrades);
        
        //find the number of scores theoretically in each grade group
        int divides = (int)Math.floor((double)numGrades.length/5.0);
        int mod = numGrades.length % 5;
        int add;
        int prn = 0;
        for(int g = 1;g<=5;g++){
            //switch to get needed letter grade for current group
            switch(g){
                case 1:  letGrade = "A";
                     break;
                case 2:  letGrade = "B";
                     break;
                case 3:  letGrade = "C";
                     break;
                case 4:  letGrade = "D";
                     break;
                case 5:  letGrade = "F";
                     break;
            }
            
            //mod check to see if there needs to be a difference in number of scores in group
            if(mod >= g)
                add = 1;
            else
                add = 0;
            
            //print out all scores and the letter grade associated with them
            for(int n = 0;n < divides+add; n++){
                //I would argue a zero will always fall in the bottom 20%
                if(numGrades[prn] <= 0){
                    System.out.println(numGrades[prn] + " : " + "F");
                    prn = prn+1;
                }
                else if(prn < numGrades.length-1){
                    System.out.println(numGrades[prn] + " : " + letGrade);
                    //checks to see if the next number would be an identical score
                    if(numGrades[prn] == numGrades[prn+1] && n == divides+add-1)
                        n = n-1;
                    prn = prn+1;
                }
                else if(prn == numGrades.length-1){
                    System.out.println(numGrades[prn] + " : " + letGrade);
                    prn = prn+1;
                }
                else{
                    continue;
                }
            }
        }
    }
    
    //method to reverse the input array to put in decending order
    static int[] reverseArray(int gradeRev[])
    {
        int rev;
        for (int j = 0; j < gradeRev.length/2; j++) 
        {
            rev = gradeRev[j];
            gradeRev[j] = gradeRev[gradeRev.length-1-j];
            gradeRev[gradeRev.length-1-j] = rev;
        }
        return gradeRev;
    }
}
