package com.example.xogame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayWithRobot {
    @FXML
    private Text x,c;
    @FXML
    private Button board00 =new Button("");
    @FXML
    private Button board01 =new Button("");
    @FXML
    private Button board02 =new Button("");
    @FXML
    private Button board10 =new Button("");
    @FXML
    private Button board11 =new Button("");
    @FXML
    private Button board12 =new Button("");
    @FXML
    private Button board20 =new Button("");
    @FXML
    private Button board21 =new Button("");
    @FXML
    private Button board22 =new Button("");
    private int XScore=0,CScore=0;
    private final char[][] b =new char[3][3];
    static int checkForWinner(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2] ){
                if(board[i][0]=='x') {
                    System.out.println(1);
                    return 1;
                }
                else if(board[i][0]=='o') {
                    System.out.println(-1);
                    return -1;
                }
            }
        }
        for(int i=0;i<3;i++) {
            if(board[0][i]==board[1][i] && board[1][i]==board[2][i]){
                if(board[0][i]=='x') {
                    System.out.println(1);
                    return 1;
                }
                else if(board[0][i]=='o') {
                    System.out.println(-1);
                    return -1;
                }
            }
        }
        if(board[0][0]==board[1][1] && board[2][2]==board[1][1]){
            if(board[0][0]=='x') {
                System.out.println(1);
                return 1;
            }
            else if(board[0][0]=='o') {
                System.out.println(-1);
                return -1;
            }
        }
        if(board[2][0]==board[1][1] && board[0][2]==board[1][1]){
            if(board[1][1]=='x') {
                System.out.println(1);
                return 1;
            }
            else if(board[1][1]=='o') {
                System.out.println(-1);
                return -1;
            }
        }
        return 0;
    }
    private int checkForWinner() {
        for (int i = 0; i < 3; i++) {
            if(b[i][0]==b[i][1] && b[i][1]==b[i][2] ){
                if(b[i][0]=='x') {
                    return 1;
                }
                else if(b[i][0]=='o') {
                    return -1;
                }
            }
        }
        for(int i=0;i<3;i++) {
            if(b[0][i]==b[1][i] && b[1][i]==b[2][i]){
                if(b[0][i]=='x') {
                    return 1;
                }
                else if(b[0][i]=='o') {
                    return -1;
                }
            }
        }
        if(b[0][0]==b[1][1] && b[2][2]==b[1][1]){
            if(b[0][0]=='x') {
                return 1;
            }
            else if(b[0][0]=='o') {
                return -1;
            }
        }
        if(b[2][0]==b[1][1] && b[0][2]==b[1][1]){
            if(b[1][1]=='x') {
                return 1;
            }
            else if(b[1][1]=='o') {
                return -1;
            }
        }
        return 0;
    }
    static Boolean isMovesLeft(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] !='x' && board[i][j]!='o')
                    return true;
        return false;
    }
    private void clear(){
        board00.setText("");
        board01.setText("");
        board02.setText("");
        board10.setText("");
        board11.setText("");
        board12.setText("");
        board20.setText("");
        board21.setText("");
        board22.setText("");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                b[i][j]='-';
        }
    }
    static class Move{
        int row, col;
    }
    private int mxScore=0,mnScore=0,drScore=0;

    ////////// minimax algorithm

     int minimax(char[][] board, int depth, Boolean isMax)
    {
        int score = checkForWinner(board);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == -1) {
            mxScore++;
            return score;
        }

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == 1) {
            mnScore++;
            return score;
        }

        // If there are no more moves and
        // no winner then it is a tie
        if (!isMovesLeft(board)) {
            drScore++;
            return 0;
        }

        // If this maximizer's move
        if (isMax)
        {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]!='x' && board[i][j]!='o')
                    {
                        // Make the move
                        board[i][j] = 'x';

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = '-';
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else
        {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]!='x' && board[i][j]!='o')
                    {
                        // Make the move
                        board[i][j] = 'o';

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = '-';
                    }
                }
            }
            return best;
        }
    }

    // This will return the best possible
// move for the player
     Move findBestMove(char[][] board)
    {
        int minloses = 1000,mxwons=-1000,ties=-1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++) {   // checking for win
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (board[i][j] != 'x' && board[i][j] != 'o') {
                    // Make the move
                    board[i][j] = 'o';
                    int check=checkForWinner(board);
                    System.out.println(" check = "+i+" "+j+ " "+check);
                    if ( check== -1) {
                        board[i][j] = '-';
                        bestMove.row = i;
                        bestMove.col = j;
                        return bestMove;
                    }
                    board[i][j] = '-';
                }
            }
        }

        for (int i = 0; i < 3; i++) {   // checking for lose
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (board[i][j] != 'x' && board[i][j] != 'o') {
                    // Make the move
                    board[i][j] = 'x';
                    int check=checkForWinner(board);
                    System.out.println(" check = "+i+" "+j+ " "+check);
                    if ( check== 1) {
                        board[i][j] = '-';
                        bestMove.row = i;
                        bestMove.col = j;
                        return bestMove;
                    }
                    board[i][j] = '-';
                }
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (board[i][j]!='x' && board[i][j]!='o')
                {
                    // Make the move
                    board[i][j] = 'o';
                    mxScore=0;
                    mnScore=0;
                    drScore=0;
                    // compute evaluation function for this
                    // move.
                   minimax(board, 0, false);

                    // Undo the move
                    board[i][j] = '-';


                    if (mnScore < minloses)
                    {
                        bestMove.row = i;
                        bestMove.col = j;
                       minloses=mnScore;
                    }
                    else if(mnScore==minloses){
                        if(drScore>ties){
                            ties=drScore;
                            bestMove.row = i;
                            bestMove.col = j;
                        } else if(mxwons>mxScore){
                            mxwons=mxScore;
                            bestMove.row = i;
                            bestMove.col = j;
                        }
                    }
                }
            }
        }
        System.out.println(bestMove.row+" "+bestMove.col);

        return bestMove;
    }

    private int findAmove() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] !='x' && b[i][j]!='o') {
                    return 1;
                }
            }
        }
        return 0;
    }

    private void endOfGame(int winner) throws IOException, InterruptedException {
        FXMLLoader fx=new FXMLLoader();
        Stage stage = new Stage();
        Pane pane=new Pane();
        if(winner==1) {
            XScore++;
            String st=Integer.toString(XScore);
            x.setText(st);
            fx = new FXMLLoader(HelloApplication.class.getResource("Xwin.fxml"));
        }
        else if(winner==0){
            fx = new FXMLLoader(HelloApplication.class.getResource("tie.fxml"));
        }
        else if(winner==-1){
            CScore++;
            String st=Integer.toString(CScore);
            c.setText(st);
             fx = new FXMLLoader(HelloApplication.class.getResource("Rwin.fxml"));
        }
        pane.getChildren().add(fx.load());
        Scene s1=new Scene(pane,600,400);
        stage.setScene(s1);
        stage.show();
        clear();
    }
    private void doRobotMove(Move m) throws InterruptedException {
        b[m.row][m.col]='o';
        if(m.row==0){
            if(m.col==0){
                board00.setText("O");
                board00.setTextFill(Paint.valueOf("#2c3e50"));
            }
            else if(m.col==1){
                board01.setText("O");
                board01.setTextFill(Paint.valueOf("#2c3e50"));
            }
            else if(m.col==2){
                board02.setText("O");
                board02.setTextFill(Paint.valueOf("#2c3e50"));
            }
        }
        else if(m.row==1){
            if(m.col==0){
                board10.setText("O");
                board10.setTextFill(Paint.valueOf("#2c3e50"));
            }
            else if(m.col==1){
                board11.setText("O");
                board11.setTextFill(Paint.valueOf("#2c3e50"));
            }
            else if(m.col==2){
                board12.setText("O");
                board12.setTextFill(Paint.valueOf("#2c3e50"));
            }
        }
        else if(m.row==2){
            if(m.col==0){
                board20.setText("O");
                board20.setTextFill(Paint.valueOf("#2c3e50"));
            }
            else if(m.col==1){
                board21.setText("O");
                board21.setTextFill(Paint.valueOf("#2c3e50"));
            }
            else if(m.col==2){
                board22.setText("O");
                board22.setTextFill(Paint.valueOf("#2c3e50"));
            }
        }
    }
    //////// modifing board by playing
    @FXML
    protected void play00() throws InterruptedException, IOException {
        if(b[0][0]=='x' || b[0][0]=='o'){
            return;
        }

            b[0][0]='x';
            board00.setText("X");
            board00.setTextFill(Paint.valueOf("#009688"));
            if (checkForWinner()==1){
                endOfGame(1);
                return;
            }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
       doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }
    @FXML
    protected void play01() throws InterruptedException, IOException {
        if(b[0][1]=='x' || b[0][1]=='o'){
            return;
        }

            b[0][1]='x';
            board01.setText("X");
            board01.setTextFill(Paint.valueOf("#009688"));
        if (checkForWinner()==1){
            endOfGame(1);
            return;
        }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }
    @FXML
    protected void play02() throws InterruptedException, IOException {
        if(b[0][2]=='x' || b[0][2]=='o'){
            return;
        }

            b[0][2]='x';
            board02.setText("X");
            board02.setTextFill(Paint.valueOf("#009688"));
        if (checkForWinner()==1){
            endOfGame(1);
            return;
        }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }
    @FXML
    protected void play10() throws InterruptedException, IOException {
        if(b[1][0]=='x' || b[1][0]=='o'){
            return;
        }

            b[1][0]='x';
            board10.setText("X");
            board10.setTextFill(Paint.valueOf("#009688"));
        if (checkForWinner()==1){
            endOfGame(1);
            return;
        }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }
    @FXML
    protected void play11() throws InterruptedException, IOException {
        if(b[1][1]=='x' || b[1][1]=='o'){
            return;
        }

            b[1][1]='x';
            board11.setText("X");
            board11.setTextFill(Paint.valueOf("#009688"));
            if (checkForWinner()==1){
                endOfGame(1);
                return;
            }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=new Move();
        move.row=0;
        move.col=0;
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }

        if(findAmove()==0){// tie

            endOfGame(0);
        }
    }
    @FXML
    protected void play12() throws InterruptedException, IOException {
        if(b[1][2]=='x' || b[1][2]=='o'){
            return;
        }
            b[1][2]='x';
            board12.setText("X");
            board12.setTextFill(Paint.valueOf("#009688"));
        if (checkForWinner()==1){
            endOfGame(1);
            return;
        }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }
    @FXML
    protected void play200() throws InterruptedException, IOException {
        if(b[2][0]=='x' || b[2][0]=='o'){
            return;
        }
            b[2][0]='x';
            board20.setText("X");
            board20.setTextFill(Paint.valueOf("#009688"));
        if (checkForWinner()==1){
            endOfGame(1);
            return;
        }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }
    @FXML
    protected void play21() throws InterruptedException, IOException {
        if(b[2][1]=='x' || b[2][1]=='o'){
            return;
        }
            b[2][1]='x';
            board21.setText("X");
            board21.setTextFill(Paint.valueOf("#009688"));
        if (checkForWinner()==1){
            endOfGame(1);
            return;
        }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }
    @FXML
    protected void play22() throws InterruptedException, IOException {
        if(b[2][2]=='x' || b[2][2]=='o'){
            return;
        }
            b[2][2]='x';
            board22.setText("X");
            board22.setTextFill(Paint.valueOf("#009688"));
        if (checkForWinner()==1){
            endOfGame(1);
            return;
        }

        if(findAmove()==0){// tie
            endOfGame(0);
            return;
        }
        Move move=findBestMove(b);
        doRobotMove(move);
        if (checkForWinner()==-1){
            endOfGame(-1);
            return;
        }
        if(findAmove()==0){// tie
            endOfGame(0);
        }
    }

}
