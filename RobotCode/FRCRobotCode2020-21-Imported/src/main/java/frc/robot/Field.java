package frc.robot;

public class Field 
{
    //Robot position variable x pos and then y pos
    public double[] robotpos = {0.0, 0.0};

    public double robot_angle = 0;

    public String[][] field_cords= {
                                    {"Z0", "Z1", "Z2", "Z3", "Z4", "Z5", "Z6", "Z7", "Z8", "Z9", "Z10", "Z11", "Z12"},
                                    {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12"},
                                    {"B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12"},
                                    {"C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12"},
                                    {"D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12"},
                                    {"E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "E11", "E12"},
                                    {"F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12"},
                                   }; // A LIST OF ALL POSSIBLE ROBOT AND ITEM LOCATIONS. AcTuAl BrAin DeAtH

    public Field()
    {
        //Constructor
    }

    public double[] Cord_Pos_Ft (String cord)
    {
        
        //Input: A string cordinate. The letter must be uppercase.
        //Output: a list of two doubles, the x position and y position
        

        char y = cord.charAt(0);
        int x = (int) cord.charAt(1);
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

    public void Update_Robot_Pos (double[] newpos)
    {
        
        //Input: double list of robot position
        //Output: None
        
        robotpos = newpos;
    }

    public void Update_Robot_Angle (double newangle)
    {
        // Input: souble angle of robot
        // Output: none
        robot_angle = newangle;
    }

    public double[] Get_Distance_From_Point (String cord)
    {
        
        //Input: The point you want to get a distance to (A string)
        //Output: The distance in the x axis and the distance in the y axis in feet.

        //If x axis is negative, then the poit is to the left of the robot on the x axis
        //IF y axis is negative, then the point is to the right of the robot on the y axis
        

        double[] Robot_Cords = robotpos;

        double[] Point_Feet_Cords = Cord_Pos_Ft(cord);

        double Delta_X = Point_Feet_Cords[0] - Robot_Cords[0];

        double Delta_Y = Point_Feet_Cords[1] - Robot_Cords[1];

        double[] returnlis = {Delta_X, Delta_Y};

        return returnlis;
    }

    public double[] Get_Optimum_angle_To_Point_and_Distance (String cord)
    {
        // Input: cordinate
        // Output: List with angle (DEG) and distance needed top drive to reach the point.

        double[] deltalist = Get_Distance_From_Point(cord);

        double angle_in_rad = Math.atan(deltalist[1]/deltalist[0]); 

        double angle = Math.toDegrees(angle_in_rad);

        double hypotenuse = Math.sqrt(deltalist[0]*deltalist[0] + deltalist[1]*deltalist[1]);
        
        double[] returnlis = {angle, hypotenuse};

        return returnlis;
    }


}
