package com.example.xogame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class playWithFriendController{
        @FXML
    private Text x,o;
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
    private char turn='x';
    private int Xscore=0,Oscore=0;
    private char b[][]=new char[3][3];
int checkForWinner() {
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
    private void endOfGame(int winner){
        FXMLLoader fx=new FXMLLoader();
        Stage stage = new Stage();
        Pane pane=new Pane();
        if(winner==1) {
            Xscore++;
            String st=Integer.toString(Xscore);
            x.setText(st);
            fx = new FXMLLoader(HelloApplication.class.getResource("Xwin.fxml"));
        }
         else if(winner==0){
            fx = new FXMLLoader(HelloApplication.class.getResource("tie.fxml"));
        }
         else if(winner==-1){
            Oscore++;
            String st=Integer.toString(Oscore);
            o.setText(st);
            fx = new FXMLLoader(HelloApplication.class.getResource("Owin.fxml"));
        }
        try {
            pane.getChildren().add(fx.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
//////// modifing board by playing
    @FXML
    protected void play00(){
            if(b[0][0]=='x' || b[0][0]=='o'){
                return;
            }
            if(turn=='x'){
                b[0][0]=turn;
                board00.setText("X");
                board00.setTextFill(Paint.valueOf("#009688"));
                turn='o';
                if (checkForWinner()==1){
                    clear();
                    endOfGame(1);
                    return;
                }
            }
            else{
                b[0][0]=turn;
                board00.setText("O");
                board00.setTextFill(Paint.valueOf("#2c3e50"));
                turn='x';
                if(checkForWinner()==-1){
                    clear();
                    endOfGame(-1);
                    return;
                }
            }
            if(findAmove()==0){// tie
                clear();
                endOfGame(0);
                return;
            }
    }
    @FXML
    protected void play01(){
        if(b[0][1]=='x' || b[0][1]=='o'){
            return;
        }
        if(turn=='x'){
            b[0][1]=turn;
            board01.setText("X");
            board01.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[0][1]=turn;
            board01.setText("O");
            board01.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }
    @FXML
    protected void play02(){
        if(b[0][2]=='x' || b[0][2]=='o'){
            return;
        }
        if(turn=='x'){
            b[0][2]=turn;
            board02.setText("X");
            board02.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[0][2]=turn;
            board02.setText("O");
            board02.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }
    @FXML
    protected void play10(){
        if(b[1][0]=='x' || b[1][0]=='o'){
            return;
        }
        if(turn=='x'){
            b[1][0]=turn;
            board10.setText("X");
            board10.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[1][0]=turn;
            board10.setText("O");
            board10.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }
    @FXML
    protected void play11(){
        if(b[1][1]=='x' || b[1][1]=='o'){
            return;
        }
        if(turn=='x'){
            b[1][1]=turn;
            board11.setText("X");
            board11.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[1][1]=turn;
            board11.setText("O");
            board11.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }
    @FXML
    protected void play12(){
        if(b[1][2]=='x' || b[1][2]=='o'){
            return;
        }
        if(turn=='x'){
            b[1][2]=turn;
            board12.setText("X");
            board12.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[1][2]=turn;
            board12.setText("O");
            board12.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }
    @FXML
    protected void play200(){
        if(b[2][0]=='x' || b[2][0]=='o'){
            return;
        }
        if(turn=='x'){
            b[2][0]=turn;
            board20.setText("X");
            board20.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[2][0]=turn;
            board20.setText("O");
            board20.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }
    @FXML
    protected void play21(){
        if(b[2][1]=='x' || b[2][1]=='o'){
            return;
        }
        if(turn=='x'){
            b[2][1]=turn;
            board21.setText("X");
            board21.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[2][1]=turn;
            board21.setText("O");
            board21.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }
    @FXML
    protected void play22(){
        if(b[2][2]=='x' || b[2][2]=='o'){
            return;
        }
        if(turn=='x'){
            b[2][2]=turn;
            board22.setText("X");
            board22.setTextFill(Paint.valueOf("#009688"));
            turn='o';
            if (checkForWinner()==1){
                clear();
                endOfGame(1);
                return;
            }
        }
        else{
            b[2][2]=turn;
            board22.setText("O");
            board22.setTextFill(Paint.valueOf("#2c3e50"));
            turn='x';
            if(checkForWinner()==-1){
                clear();
                endOfGame(-1);
                return;
            }
        }
        if(findAmove()==0){// tie
            clear();
            endOfGame(0);
            return;
        }
    }

}
