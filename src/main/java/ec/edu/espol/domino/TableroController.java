/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.domino;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import modelo.Ficha;
import modelo.Juego;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author jose-
 */
public class TableroController implements Initializable {
    Juego juego = new Juego();
 
    @FXML
    private Pane mod1;
    @FXML
    private Label maq;
    @FXML
    private Label NomJu;
    @FXML
    private ImageView Fondo;
    @FXML
    private AnchorPane mode;
  
    @FXML
    private HBox ManoJug21;
    @FXML
    private HBox ManoMaq21;
    @FXML
    private HBox ManoTab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mod1.getChildren().clear();
        juego.agregarJugador(" Jugador 0");
        juego.agregarJugador("Maquina");
        NomJu.setText("Jugador 1");
        maq.setText("Maquina");
        mod1.getChildren().addAll(Fondo,NomJu,maq,mode);
        for(Jugador jugador: juego.getJugadores()){
            if(jugador.getNombre().equalsIgnoreCase("Maquina")){
                ArrayList<Ficha> mano= jugador.getMano();
                System.out.println(mano);
                for (Ficha ficha : mano){
                    ImageView imv= new ImageView("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
                    imv.setId(ficha.getLado1()+"."+ficha.getLado2());
                    event(ManoTab,imv);
                    imv.setFitWidth(90);
                    imv.setFitHeight(120);
                    ManoMaq21.getChildren().addAll(imv);
                    ManoMaq21.setSpacing(20);

                }
            }else{
                ArrayList<Ficha> mano= jugador.getMano();
                System.out.println(mano);
                for (Ficha ficha : mano){
                    ImageView imv= new ImageView("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
                    imv.setId(ficha.getLado1()+"."+ficha.getLado2());
                    System.out.println(imv.getId());
                    event(ManoTab,imv);
                    imv.setFitWidth(90);
                    imv.setFitHeight(120);
                    ManoJug21.getChildren().addAll(imv);
                    ManoJug21.setSpacing(20);
            }
            
        
                
            
        
            
        }
        mode.getChildren().clear();
        mode.getChildren().addAll(ManoMaq21,ManoJug21,ManoTab);
        }
        
    }
    
    public void event(HBox hb,ImageView imv){
        imv.setCursor(Cursor.HAND);
        System.out.println(imv.getId());
        String[] p= imv.getId().split("\\.");
        String[] string = new String[2];
        ImageView imv1= new ImageView();
        ImageView imv2= new ImageView();
        ObservableList<Node> hijos = hb.getChildren();
        int lastIndex = hijos.size() - 1;
        if(!hijos.isEmpty()){
            System.out.println("No vacia1");
            if (!hijos.isEmpty()) {
                Node primerNodo = hijos.get(0);
                imv1= (ImageView)primerNodo;
                String[] p1= imv1.getId().split("\\.");
                string[0]=p1[1];


            }else if (lastIndex >= 0) {
                System.out.println("No vacia2");
                Node ultimoNodo = hijos.get(lastIndex);
                imv2= (ImageView)ultimoNodo;
                String[] p1= imv1.getId().split("\\.");
                string[0]=p1[1];

            }
        }
//            
//            imv.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
//                System.out.println("No vacia");
//                int lado1= Integer.parseInt(p[0]);
//                int lado2= Integer.parseInt(p[1]);
//                int lado1i= Integer.parseInt(string[0]);
//                int lado2i= Integer.parseInt(string[1]);
//                if (lado1==lado2i){
//                    hb.getChildren().add(0,imv);
//                }else if (lado2==lado1i){
//                    hb.getChildren().add(imv);
//                }
//            });
        
        System.out.println("vacia");
        imv.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
                if(hijos.isEmpty()){
                    System.out.println("vacia");
                    System.out.println("ola");
                    System.out.println(p[0]);
                    System.out.println(p[1]);
                    ImageView imv12= new ImageView("fichasag/"+"Ficha"+p[0]+"."+p[1]+".png");
                    hb.getChildren().addAll(imv12);
                }else if (!hijos.isEmpty()){
                    System.out.println("No vacia3");
                    int lado1= Integer.parseInt(p[0]);
                    int lado2= Integer.parseInt(p[1]);
                    int lado1i= Integer.parseInt(string[0]);
                    int lado2i= Integer.parseInt(string[1]);
                    if (lado1==lado2i){
                        ImageView imv14= new ImageView("fichasag/"+"Ficha"+p[0]+"."+p[1]+".png");ImageView imv12= new ImageView("fichasag/"+"Ficha"+p[0]+"."+p[1]+".png");
                        hb.getChildren().add(0,imv14);
                    }else if (lado2==lado1i){
                        ImageView imv14= new ImageView("fichasag/"+"Ficha"+p[0]+"."+p[1]+".png");ImageView imv12= new ImageView("fichasag/"+"Ficha"+p[0]+"."+p[1]+".png");
                        hb.getChildren().add(imv14);
                    }
                }
        });
                    
            
        }


        

                
                
        

        
                

              
            
        
    
        
   
}

//        for (Jugador jugador : juego.getJugadores()){
//            if(jugador.getNombre().equalsIgnoreCase("Maquina")){
//                ArrayList<Ficha> mano= jugador.getMano();
//                System.out.println(mano);
//                for(Ficha ficha: mano){
//                    System.out.println("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    ImageView imv= new ImageView("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    imv.setFitWidth(90);
//                    imv.setFitHeight(120);
//                    ManoMaq21.getChildren().addAll(imv);
//                    ManoMaq21.setSpacing(20);
//                    
//                }
//            }else{
//                ArrayList<Ficha> mano= jugador.getMano();
//                System.out.println(mano);
//                for(Ficha ficha: mano){
//                    System.out.println("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    ImageView imv= new ImageView("fichas/"+"Ficha"+ficha.getLado1()+"."+ficha.getLado2()+".png");
//                    imv.setFitWidth(90);
//                    imv.setFitHeight(120);
//                    ManoJug21.getChildren().addAll(imv);
//                    ManoJug21.setSpacing(20);
//                    
//                }          
//        }
//        }
//        mode.getChildren().addAll(ManoJug21,ManoMaq21);
//         
    