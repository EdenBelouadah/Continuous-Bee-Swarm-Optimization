/**
 * @author: ZOUGGARI Feriel & BELOUADAH Eden
 */

import javax.swing.UIManager;

public class Main 
{

    public static void main(String[] args) 
    {
        try 
        { 
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        GUI form =new GUI();
        form.setVisible(true);
    }   
}