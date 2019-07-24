import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
/**
 *
 * @author Adrian
 */
public class Web_Browser extends JFrame
        
{
    private JTextField addressBar;
    private JEditorPane display;
    
    //konstruktor
    public Web_Browser()
    {
        super("Przegladarka - wpisz adres po http://");
        
        addressBar = new JTextField("http://google.com");
        /*
           zdarzenie po wpisaniu adresu URL przez uzytkownika
           do JTextField
        */
        addressBar.addActionListener(
            new ActionListener (){
            public void actionPerformed(ActionEvent event){
                load(event.getActionCommand());
                }
        }
        );
        add(addressBar,BorderLayout.NORTH);
        display = new JEditorPane();
        display.setEditable(false); 
        /*
            zdarzenie po kliknieciu linka
        */
        display.addHyperlinkListener(
        new HyperlinkListener(){
            public void hyperlinkUpdate(HyperlinkEvent event){
                if (event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                    load(event.getURL().toString());
                }
        }
        });
        add(new JScrollPane(display),BorderLayout.CENTER);
        setSize(800,500);
        setVisible(true);
    }
    /*
        metoda obss³uguj¹ca adresy url 
        klikniêcie lub wpisanie przez u¿ytkownika         
    */
    private void load(String userText){
    try{
        display.setPage(userText);
        addressBar.setText(userText);        
        
    }catch(Exception e)
    {
        System.out.println("Blad");
    }
}
}
