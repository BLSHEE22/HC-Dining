/*************************************************************************
 Author: Brendan Sheedy
   Written: 8/4/18
   Explanation: This program lets you know whether or not you are spending
                dining dollars at the correct rate.
*************************************************************************/

public class DD {

    public static void main(String[] args) {

        StdOut.println("*********************************");
        StdOut.println("Welcome to Dining Dollar Checker!");
        StdOut.println();
        StdOut.println("We can tell you if you are spending your dining"
                       + " dollars too fast, too slow, or just right.");
        StdOut.println();
        
        /* StdOut.println("This semester, how many days have you spent on campus" 
           + " so far?");
           StdOut.println("(if fall, # of days since August 25th)");*/

        StdOut.println("How many dining dollars did you start off with at the beginning of the year?");

        double startAmt = StdIn.readDouble();

        boolean day_exists = false;

        String month = "";

        int day = 0;

        while (!day_exists) {
        
            StdOut.println("What month are you currently in? (no abbrv)");
        
            month = StdIn.readString();

            if ((month.equalsIgnoreCase("january")) || (month.equalsIgnoreCase("february")) || (month.equalsIgnoreCase("march"))
                || (month.equalsIgnoreCase("april")) || (month.equalsIgnoreCase("may")) || (month.equalsIgnoreCase("june")) ||
                (month.equalsIgnoreCase("july")) || (month.equalsIgnoreCase("august")) || (month.equalsIgnoreCase("september")) ||
                (month.equalsIgnoreCase("october")) || (month.equalsIgnoreCase("november")) ||
                (month.equalsIgnoreCase("december")))
            {
                
                StdOut.println("What day of " + month + "?");

                day = StdIn.readInt();

                switch (month)
                {
                case "January": 
                case "january":
                case "March":
                case "march":
                case "May":
                case "may":
                case "July":
                case "july":
                case "August":
                case "august":
                case "October":
                case "october":
                case "December":
                case "december":
                    if (day <= 31)
                        day_exists = true;
                    else 
                        StdOut.println("There is no " + month + " " + day + "!");
                break;
                case "February":
                case "february":
                    if (day <= 28)
                        day_exists = true;
                    else
                        StdOut.println("There is no " + month + " " + day + "!");
                break;
                case "April":
                case "april":
                case "June":
                case "june":
                case "September":
                case "september":
                case "November": 
                case "november":
                    if (day <= 30)
                        day_exists = true;
                    else
                        StdOut.println("There is no " + month + " " + day + "!");
                break;

                }

                /* StdOut.printf("Great, so you have been on campus for %d days this"
                   + " semester.\n", days);*/
            }
            else
                StdOut.println(month + " is not a month. Re-enter a valid month.");
        }
        
        StdOut.println("So the date is " + month + " " + day + ". How many dining dollars do you have left?");

        double balance = StdIn.readDouble();

        StdOut.printf("So you have $%.2f dining dollars left.\n", balance);

        double totalM = startAmt;

        int totalD = 97;

        int doc = 0;

        switch (month)
        {
        case "January":
        case "january":
            if (day >= 25)
                doc = day - 24;
            else {
                StdOut.println("What are you doing on campus? Class hasn't started yet.");
                doc = 0;
            }
        break;
        case "February":
        case "february":
            if (day <= 26)
                doc = day + 7;
            else {
                StdOut.println("What are you doing on campus? It's spring break.");
                doc = 33;
            }
        break;   
        case "March":
        case "march":
            if (day > 7)
                doc = 26 + day;
            else {
                StdOut.println("What are you doing on campus? It's spring break.");
                doc = 33;
            }
        break;
        case "April":
        case "april":
            if (day > 5)
                doc = 52 + day;
            else
                doc = 57;
        break;
        case "May":
        case "may":
            if (day < 16)
                doc = 82 + day;
            else {
                StdOut.println("What are you doing on campus? The semester's over!");
                doc = 97;
            }
        break;       
        case "June":
        case "june":  
        case "July":
        case "july":
              StdOut.println("What are you doing on campus? The semester's over!");
              doc = 97;
        break;
        case "August":
        case "august":
            if (day >= 25)
                doc = 26 - day;
            else
                StdOut.println("What are you doing on campus? Class hasn't started yet.");
        break;
        case "September":
        case "september":
            doc = day + 7;
        break;
        case "October":
        case "october":
            if (day <= 5)
                doc = 37 + day;
            else
                doc = 37 + day - 9;
        break;
        case "November":
        case "november":
            if (day <= 20)
                doc = 59 + day;
            else
                doc = 59 + day - 5;
        break;
        case "December":
        case "december":
            if (day <= 15)
                doc = 84 + day;
            else
            {
                StdOut.println("What are you doing on campus? The semester's over!");
                doc = 97;
            }
        break;
        
        }

        StdOut.println("That's " + doc + " days on campus so far.");

        double avgbalance = (totalM - ((totalM/totalD)*doc));

        double diff;

        if (balance > avgbalance)
        {
            diff = balance-avgbalance;
            StdOut.printf("You have more money than average! +%.2f\n!", diff);
        }
        else if (avgbalance > balance)
        {
            diff = avgbalance-balance;
            StdOut.printf("You have less money than average: -%.2f...\n", diff);
        }
        else
        {
            diff = 0;
            StdOut.println("You are spending at exactly average pace!"
                           + " Keep it up.\n");
        }
    }
}
                         

         
