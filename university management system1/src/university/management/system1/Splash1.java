
package university.management.system1;


import javax.swing.*;
import java.awt.*;
public class Splash1 extends JFrame implements Runnable{

    Thread t;
    Splash1() {                                    //frame visibilty is hidden than we use setvisible()
           
        t= new Thread(this);
        t.start();                                // call the run function to run the frame
        setVisible(true);
        
//        JLabel name=new JLabel("GRAPHIC ERA HILL UNIVERSITY");
//        name.setFont(new Font("serif",Font.BOLD,60));
//        name.setBounds(80,30,1200,40);
//        add(name);
        
        ImageIcon img_gehu=new ImageIcon(ClassLoader.getSystemResource("icons/gehu_imgNEW.jpg")); // gives image
        Image img_gehu2=img_gehu.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
                   //we cant pass direct image to JLabel the we make icon of above image
        ImageIcon img_gehu3=new ImageIcon(img_gehu2);
        JLabel img2=new JLabel(img_gehu3);
        add(img2);                                     // add image in frame present in JFrame

        int x=1;
        for(int i=2;i <=670;i+=3,x+=1 ){
            
            setLocation(470-((i+x)/3), 350 - (i/2));                    // set the frame from where it open
            setSize((i-2) +2*x,(i-2) +(x+2)/6);                                   //fix the length and width of frame

            try{
                Thread.sleep(10);
            }catch(Exception e) { }
        }
    }
     public void run(){
         try{
             Thread.sleep(7000);
             setVisible(false);                      //to close the frame

             new Login1();
        }catch(Exception e){}
     }
    public static void main(String[] args) {
        new Splash1();                                  //object of splash

    }
}
