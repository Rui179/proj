import java.util.*;

class Bot {
  public int row = 0;
  public int column = 0;  
  public Bot(){
  }

  public int getRow(){
    return row;
  }

  public int getColumn(){
    return column;
  }

  public boolean botMove (boolean[][] used)
  {
    row = randomNumSpace();
    column = randomNumSpace();
    switch(row) {
      case 1:
        switch(column) {
        case 1: 
          if (!used[0][0]){ 
            return true;
          }
        break; 
        case 2: 
          if (!used[0][1]){
            return true; 
          }
        break; 
        case 3: 
          if (!used[0][2]){
            return true;
          }
        break; 
        }
      break;
      case 2:
        switch(column) {
        case 1: 
          if (!used[1][0]){
            return true;
          }
        break; 
        case 2: 
          if (!used[1][1]){
            return true;
          }
          break; 
        case 3: 
          if (!used[1][2]){
            return true;
          }
          break;
        }
        break;
      case 3:
        switch(column) {
        case 1: 
          if (!used[2][0]){
            return true;
          }
          break; 
        case 2: 
          if (!used[2][1]){
            return true;
          }
          break; 
        case 3: 
          if (!used[2][2]){
            return true;
          }
          break;
        }
      break;
    }
    return false;
  }
  
  private static int randomNumSpace ()
  {
    float num = 3 * ((float) Math.random());
    return (int) Math.ceil(num);
  }
}

  
