package torrehanoi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;



public class Principal extends Application {
    
 int cont = 0; 
    
 public static void main(String[] args) {
  launch();
 }

 @Override
 public void start(Stage palco) throws Exception {
     

     
    Group componentes = new Group(); 
    Scene cena = new Scene(componentes, 400, 250);
    
    Text instruction = new Text(8, 25, "Utilize os botões do mouse para movimentar entre as torres");
    
    instruction.setScaleX(0.95);
    instruction.setScaleY(0.95);

    //////////////Torres//////////
     
    Rectangle torre1 = new Rectangle(5, 150); 
    torre1.setTranslateX(50);
    torre1.setTranslateY(50);
    torre1.setFill(Color.BLACK); 
  
    Rectangle torre2 = new Rectangle(5, 150); 
    torre2.setTranslateX(200);
    torre2.setTranslateY(50);
    torre2.setFill(Color.BLACK); 

    Rectangle torre3 = new Rectangle(5, 150); 
    torre3.setTranslateX(330);
    torre3.setTranslateY(50);
    torre3.setFill(Color.BLACK); 
    
    //////////////Peças////////////
  
    Rectangle pecaMaior = new Rectangle(80, 20); 
    pecaMaior.setTranslateX(15);
    pecaMaior.setTranslateY(180);
    pecaMaior.setFill(Color.PURPLE); 
  

    Rectangle pecaMedia = new Rectangle(50, 20); 
    pecaMedia.setTranslateX(28);
    pecaMedia.setTranslateY(160);
    pecaMedia.setFill(Color.BLUE); 

    Rectangle pecaMenor = new Rectangle(30, 20); 
    pecaMenor.setTranslateX(38);
    pecaMenor.setTranslateY(140);
    pecaMenor.setFill(Color.RED); 
    
    Text movimentos = new Text(250, 230, "Movimentos:" + cont);
    
    movimentos.setScaleX(0.95);
    movimentos.setScaleY(0.95);
    
    
    //////////////Lógica do jogo////////////
    
    pecaMenor.addEventHandler(MouseEvent.MOUSE_CLICKED,  (MouseEvent  me) ->  {
 
        if (me.getButton() == MouseButton.PRIMARY)  {
            
            cont++;
            movimentos.setText("Movimentos:" + cont);
            
            pecaMenor.setTranslateX(38);

        }
        if (me.getButton() == MouseButton.MIDDLE)  {
            
            cont++;
            movimentos.setText("Movimentos:" + cont);
            
            pecaMenor.setTranslateX(188);

        }
        
        if(me.getButton() == MouseButton.SECONDARY){
            
            cont++;
            movimentos.setText("Movimentos:" + cont);
            
            pecaMenor.setTranslateX(318);
   
        }
  
    });
    
    pecaMedia.addEventHandler(MouseEvent.MOUSE_CLICKED,  (MouseEvent  me) ->  {
    
        if (me.getButton() == MouseButton.PRIMARY && pecaMenor.getTranslateX() != 38)  {
            
            if((pecaMedia.getTranslateX() == 178 && pecaMenor.getTranslateX() != 188)
                    || (pecaMedia.getTranslateX() == 308 && pecaMenor.getTranslateX() != 318)){
                
                    cont++;
                    movimentos.setText("Movimentos:" + cont);
   
                    pecaMedia.setTranslateX(28);

            }

        }

        if (me.getButton() == MouseButton.MIDDLE && pecaMenor.getTranslateX() != 188)  {
            
            if((pecaMedia.getTranslateX() == 28 && pecaMenor.getTranslateX() != 38)
                    || (pecaMedia.getTranslateX() == 308 && pecaMenor.getTranslateX() != 318)){
                
                    cont++;
                    movimentos.setText("Movimentos:" + cont);
   
                    pecaMedia.setTranslateX(178);

            
            }            

        }
        
        if(me.getButton() == MouseButton.SECONDARY && pecaMenor.getTranslateX() != 318){
            
            if((pecaMedia.getTranslateX() == 28 && pecaMenor.getTranslateX() != 38)
                    || (pecaMedia.getTranslateX() == 178 && pecaMenor.getTranslateX() != 188)){
                
                    cont++;
                    movimentos.setText("Movimentos:" + cont);
   
                    pecaMedia.setTranslateX(308);
                    
                
            
            } 
  
        }
  
    });    
    pecaMaior.addEventHandler(MouseEvent.MOUSE_CLICKED,  (MouseEvent  me) ->  {
        
        if(me.getButton() == MouseButton.PRIMARY){
            
            if(pecaMenor.getTranslateX() != 38){ 
                    
                if(pecaMedia.getTranslateX() != 28){
                    
                    cont++;
                    movimentos.setText("Movimentos:" + cont);

                    pecaMaior.setTranslateX(15);
                    
                }
            }
 
        }        
        
        if (me.getButton() == MouseButton.MIDDLE)  {
            
            if(pecaMenor.getTranslateX() != 188 && (pecaMenor.getTranslateX() != 38 && pecaMedia.getTranslateX() != 28)){ 
                    
                if(pecaMedia.getTranslateX() != 178){
                    
                    cont++;
                    movimentos.setText("Movimentos:" + cont);

                    pecaMaior.setTranslateX(165);
   
                    
                }
            }

        }
        
        if(me.getButton() == MouseButton.SECONDARY){
            
            if(pecaMenor.getTranslateX() != 318 && (pecaMenor.getTranslateX() != 38 && pecaMedia.getTranslateX() != 28)){ 
                    
                if(pecaMedia.getTranslateX() != 308){
                    
                    cont++;
                    movimentos.setText("Movimentos:" + cont);

                    pecaMaior.setTranslateX(295);

                    
                }
            }
 
        }
  
    });

    //////////////Componentes e palco////////////
  
    componentes.getChildren().addAll(torre1, torre2, torre3, pecaMaior, pecaMedia, pecaMenor, instruction, movimentos); // 10
    
  
    palco.setTitle("Torre de Hanói");
    palco.setScene(cena);
    palco.show();
  

     
  }

 
 
 
 
}