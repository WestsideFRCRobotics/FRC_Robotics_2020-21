package frc.robot;

public class Field 
{
    private String[][] field_cords= {
                                    {"Z0", "Z1", "Z2", "Z3", "Z4", "Z5", "Z6", "Z7", "Z8", "Z9", "Z10", "Z11", "Z12"},
                                    {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12"},
                                    {"B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12"},
                                    {"C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12"},
                                    {"D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12"},
                                    {"E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "E11", "E12"},
                                    {"F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12"},
                                   }; // A LIST OF ALL POSSIBLE ROBOT AND ITEM LOCATIONS. AcTuAl BrAin DeAtH
    
    public double[] Cord_Pos_Ft (char y, int x)
    {
        int y_counter = 0; // establishes a counter to count the number of loops for y
        int x_counter = 0; // establishes a counter to count the number of loops for x
        double y_final = 0.0; // returned y val
        double x_final = 0.0; // returned x val

        for (String[] m: field_cords)  // creates a loop that isolates a single rows of feild_cords
        {
            
            String a = m[0]; // picks the first cordinate in a list
            char y_guess = a.charAt(0); // gets the letter of the first cordinate in the list
            
            //If the letter is the right one, then it multiplies the counter by 2.5 ft to get the final ft value.
            if (y_guess == y)
            {
                y_final = y_counter * 2.5;
            }
            
            // if it sees and x value in x final, it doesn't run this to lower program complexity.
            if (x_final == 0.0)
            {
                
                for (String z: m)
                {
                    int x_guess = (int) z.charAt(1);
    
                    if (x_guess == x)
                    {
                        x_final = x_counter * 2.5;
                    }
                    x_counter ++;
                }
            }
            y_counter ++;
            
        }
        
        double[] returnlist = {x_final, y_final};

        return returnlist;
    }


}
