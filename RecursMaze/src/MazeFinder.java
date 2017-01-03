import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeFinder
{
    //Recursive Maze finding

    static int row, col;
    static boolean deadEnd = false;
    public static void mazeSolver (char mazeAr[][],int row, int col)
    {    	
    	if(mazeAr[row][col] == 'e'){
    		System.out.println("You have reached your destination");
    		printMaz(mazeAr);
    		return;
    	}
    	mazeAr[row][col] = 'p';
    	if(mazeAr[row+1][col] == ' '|| mazeAr[row+1][col] == 'e'){//check all the left right up and bottom for movement opendings
    		System.out.println("Move Down");
    		mazeSolver(mazeAr, row+1, col);//then move if opening available
    	}else if(mazeAr[row][col+1] == ' '||mazeAr[row][col+1] == 'e'){
    		System.out.println("Move to the right");
    		mazeSolver(mazeAr, row, col+1);
    	}else if(mazeAr[row-1][col] == ' '||mazeAr[row-1][col] == 'e'){
    		System.out.println("Move Up");
    		mazeSolver(mazeAr, row-1, col);
    	}else if(mazeAr[row][col-1] == ' '||mazeAr[row][col-1] == 'e'){
    		System.out.println("Move Up");
    		mazeSolver(mazeAr, row, col-1);
    	}else{
    		deadEnd = true;//if no opening availible(have been marked by p then you have reached dead end
    		return;//will prevent code from proceeding and return to previous calls
       	}
    	if(deadEnd==true){//if there is a dead end
    		deadEnd = false;//set the dead end to false
    		mazeSolver(mazeAr,row,col);//thought of it as creating the new start at the current position
    	}
    	
    	
    }

    private static void printMaz(char[][] mazeAr) {
    	for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                System.out.print(mazeAr [i] [j]);
            }
            System.out.println();
        }
		
	}

	public static void main (String[] args) throws IOException
    {
        
        String line = "";
   
        BufferedReader fr = new BufferedReader (new FileReader ("maze3.txt"));
        
        row = Integer.parseInt(fr.readLine ());
        col = Integer.parseInt(fr.readLine ());
        
        char mazeArray[][]=new char [row][col];;
        
      //  char tim[]=new char [9];
        for (int i = 0 ; i < row ; i++)
        {

            line = fr.readLine ();
           // System.out.println(line);
             char [] tim = line.toCharArray ();

            for (int j = 0 ; j < tim.length ; j++)
            {
                mazeArray [i] [j] = tim [j];
                System.out.print(mazeArray [i] [j]);
            }
            System.out.println();
        }
        fr.close ();
        System.out.println(mazeArray[0][1]);
        mazeSolver (mazeArray,0,1);
///////////////////////////////////////////////////////////
        // Place your code here
    } // main method
    
} // MazeFinder class
