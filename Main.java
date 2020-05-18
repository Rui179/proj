import java.util.*; 
class Main {
  public static void main(String[]args) {
    Scanner sc = new Scanner(System.in);
    Bot bot = new Bot();
    int row = 0;
    int column = 0;
    int winner = 0;
    int moves = 0;
    // char userLocation = 'X'; 
    // char computerLocation = 'O';
    char [][] newBoard = {
      {' ','|',' ','|',' '},
      {'-','+','-','+','-'},
      {' ','|',' ','|',' '},
      {'-','+','-','+','-'},
      {' ','|',' ','|',' '}}; 
    
    boolean[][] used = {
      {false, false, false},
      {false, false, false},
      {false, false, false},
      {false, false, false},
    }; 
    getBoard(newBoard); 
  
  System.out.println("Welcome to THICC TAC TOE!");
  boolean done = true;
  while (done) {
    //User Move
    boolean geyUser = false;
    while(!geyUser){

      System.out.println("Row");
      row = sc.nextInt(); 
      System.out.println("Column");
      column = sc.nextInt();
      geyUser = (check(row, column, used));
    }
    used[row-1][column-1] = true;
    newBoard[2 * (row-1)][2 * (column - 1)] = 'X';
    getBoard(newBoard);
    done = !getWinner(newBoard, 'X');
    if(!done){
      winner = 1;
    }
    moves += 1;
    if (moves >= 9 && !done && !(winner == 1)){
      done = false;
      winner = 3;
    }

    //Bot Move
    if(done){
    boolean geyBot = false;
    while (!geyBot){
      geyBot = bot.botMove(used);
      }
      used[bot.getRow() - 1][bot.getColumn() - 1] = true;
      newBoard[2 * (bot.row - 1)][2 * (bot.column - 1)] = 'O';
      getBoard(newBoard);
      done = !getWinner(newBoard, 'O');
      if(!done){
        winner = 2;
      }
      moves += 1;
      if (moves >= 9 && !done && !(winner == 2)){
        done = false;
        winner = 3;
      }
    }
  }
  switch (winner){
    case 1:
      System.out.println("Congratulations you win!");
    break;
    case 2:
      System.out.println("You Lose!\n\n\nThe bot has no AI bud");
    break;
    case 3:
      System.out.println("Tie!");
    break;
    default:
      System.out.print("error");
    break;
  }
}

  public static boolean check(int row, int column, boolean[][] used) {
    if(row > 3)
    {
      System.out.println("Out of Bounds");
      return false;
    }
     if(column > 3)
    {
      System.out.println("Out of bounds ");
      return false;
    }
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
    System.out.println("Space is used");
    return false;
  }

public static void getBoard(char[][]newBoard) {
  for(char[]newRow : newBoard) {
    for(char w : newRow) {
      System.out.print(w); 
    }
    System.out.println(); 
  }
}
  
  public static boolean getWinner(char[][] board, char var) {
    boolean yes = false;
    for(int a = 0; a < 5; a += 2) {
      yes = true;
      for(int b = 0; b < 5; b += 2){
        if(board[a][b] == var && yes){
          yes = true;
        }
        else
        {
          yes = false;
        }
      }
      if(yes){
      a = 500;
      }
    }
    if (yes)
    {
      return true;
    }
    for(int a = 0; a < 5; a += 2) {
      yes = true;
      for(int b = 0; b < 5; b += 2){
        if(board[b][a] == var && yes){
          yes = true;
        }
        else
        {
          yes = false;
        }
      }
      if(yes){
      a = 500;
      }
    }
    if (yes)
    {
      return true;
    }
    if(board[0][0] == var && board[2][2] == var && board[4][4] == var){
      yes = true;
    }
    if(board[0][4] == var && board[2][2] == var && board[4][0] == var){
      yes = true;
    }
    if(yes){
      return true;
    }
    return false;
  }
}
