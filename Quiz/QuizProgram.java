
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
class  Quiz extends JFrame implements ActionListener{
            JPanel panel;
            JPanel panelresult;
            JRadioButton choice1;
            JRadioButton choice2;
            JRadioButton choice3;
            JRadioButton choice4;
            ButtonGroup bg;
            JLabel lblmess;
            JButton btnext;
            
            String qpa [][];
            String qca[][];
            int qaid;
            HashMap<Integer, String> map;
            Quiz()
           {
                      initializedata();
                      setTitle("Quiz-O-Mania");
                      setDefaultCloseOperation(EXIT_ON_CLOSE);
                      setSize(430,350);
                      setLocation(300,100);
                      setResizable(true);
                      Container cont=getContentPane();
                      cont.setLayout(null);          
                      cont.setBackground(Color.GRAY);
                    bg=new ButtonGroup();     
                    choice1=new JRadioButton("Choice1",true);
                    choice2=new JRadioButton("Choice2",false);
                    choice3=new JRadioButton("Choice3",false);
                    choice4=new JRadioButton("Choice4",false);
                    bg.add(choice1);
                    bg.add(choice2);
                    bg.add(choice3);
                    bg.add(choice4);
                    lblmess=new JLabel("Choose a correct anwswer");
                    lblmess.setForeground(Color.BLUE);
                    lblmess.setFont(new Font("Arial", Font.BOLD, 11));
                    btnext=new JButton("Next");
                    btnext.setForeground(Color.GREEN);                
                    btnext.addActionListener(this);
                    panel=new JPanel();
                    panel.setBackground(Color.LIGHT_GRAY);
                    panel.setLocation(300,100);
                    panel.setSize(850,550);
                    panel.setLayout(new GridLayout(6,2));
                    panel.add(lblmess);
                    panel.add(choice1);
                    panel.add(choice2);
                    panel.add(choice3);
                    panel.add(choice4);
                    panel.add(btnext);
                    cont.add(panel);
                    setVisible(true);
                    qaid=0;
                    readqa(qaid);
            }
        public void actionPerformed(ActionEvent e)
        {   
                        if(btnext.getText().equals("Next"))
                        {
                                    if(qaid<9)
                                    {           
                                                map.put(qaid,getSelection());
                                                qaid++;
                                                readqa(qaid);
                                    }
                                    else 
                                    {
                                                map.put(qaid,getSelection());
                                                btnext.setText("Show answers");
                                             }
                                    }
                        else if(btnext.getText().equals("Show answers"))
                                    new Report();
            } 
        public void initializedata(){
                        //qpa stores pairs of question and its possible answers
                        qpa=new String[10][5];
                        
                        int r;
                        for(int i=0;i<5;i++)
                        {
                            r=(int)(Math.random()*10);
                            System.out.println(r);
                            if(r==1){
                        qpa[0][0]="Which one of the following is a search engine?";
                        qpa[0][1]="Macromedia Flash";
                        qpa[0][2]="Google";
                        qpa[0][3]="Netscape";
                        qpa[0][4]="Librarians’ Index to the Internet";
                    }
                    if(r==2)
                    {

                        qpa[1][0]="Which is the best search tool for finding Web sites that have been handpicked and recommended by someone else?";
                        qpa[1][1]="Subject directories";
                        qpa[1][2]="Search engines";
                        qpa[1][3]="Meta-search engines";
                        qpa[1][4]="Discussion groups";
                    }
                    if(r==3)
                    {
                       
                        qpa[2][0]="What is LCP?";
                        qpa[2][1]="Local Connection Protocol";
                        qpa[2][2]="Lost Connection Problem";
                        qpa[2][3]="Link Control Protocol";
                        qpa[2][4]="Laggy Connection Problem";
                    }
                    if(r==4)
                    {
                        qpa[3][0]="What is VCM?";
                        qpa[3][1]="Virtual Connection Manager";
                        qpa[3][2]="Virtual Channel Memory";
                        qpa[3][3]="Voice Controlled Modem";
                        qpa[3][4]="Voice Communications Module";
                    }
                    if(r==5)
                    {

                        qpa[4][0]="What does the abbreviation http stand for?";
                        qpa[4][1]="Hypertext Transfer Protocol";
                        qpa[4][2]="High Task Termination Procedure";
                        qpa[4][3]="Harvard Teletext Proof";
                        qpa[4][4]="Hindustan Times Technical Proffesionals";
                    }
                    if(r==6)
                    {

                        qpa[5][0]="How do you convert a string of number to a number?";
                        qpa[5][1]="int num=Integer.parseInt(str_num)";
                        qpa[5][2]="int num=str_num.toInteger()";
                        qpa[5][3]="int num=(int)str_num";
                        qpa[5][4]="int num=(Integer)str_num";
                    }
                    if(r==7)
                    {
                        qpa[6][0]="What is the value of x? int x=3>>2";
                        qpa[6][1]="1";
                        qpa[6][2]="0";
                        qpa[6][3]="3";
                        qpa[6][4]="-3";
                    }
                    if(r==8)
                    {
                        qpa[7][0]="Your computer has gradually slowed down. What's the most likely cause?";
                        qpa[7][1]="Overheating";
                        qpa[7][2]="Your processor chip is just getting old";
                        qpa[7][3]="Adware/spyware is infecting your PC";
                        qpa[7][4]="You dropped a sandwich in your computer";
                    }
                    if(r==9)
                    {
                        qpa[8][0]="ARPANET, the precursor to the Internet, was developed by:";
                        qpa[8][1]="FAA";
                        qpa[8][2]="Department of Defence";
                        qpa[8][3]="NATO";
                        qpa[8][4]="UART";
                    }
                    if(r==10)
                    {
                        qpa[9][0]="What is a spider?";
                        qpa[9][1]="A computer virus";
                        qpa[9][2]="A program that catalogs Web sites";
                        qpa[9][3]="A hacker who breaks into computer systems";
                        qpa[9][4]="An application for viewing Web sites";
                    }
                
                       
                        //qca stores pairs of question and its correct answer
                        qca=new String[10][2];
                       
                        qca[0][0]="Which one of the following is a search engine?";
                        qca[0][1]="Google";

                        qca[1][0]="Which is the best search tool for finding Web sites that have been handpicked and recommended by someone else?";
                        qca[1][1]="Subject directories";

                        qca[2][0]="What is LCP?";
                        qca[2][1]="Link Control Protocol";

                        qca[3][0]="What is VCM?";
                        qca[3][1]="Virtual Channel Memory";


                        qca[4][0]="What does the abbreviation http stand for?";
                        qca[4][1]="Hypertext Transfer Protocol";

                        qca[5][0]="How do you convert a string of number to a number?";
                        qca[5][1]="int num=Integer.parseInt(str_num)";

                        qca[6][0]="What is the value of x? int x=3>>2";
                        qca[6][1]="0";
                       
                        qca[7][0]="Your computer has gradually slowed down. What's the most likely cause?";
                        qca[7][1]="Adware/spyware is infecting your PC";
                       
                        qca[8][0]="ARPANET, the precursor to the Internet, was developed by:";
                        qca[8][1]="Department of Defence";

                        qca[9][0]="What is a spider?";
                        qca[9][1]="A program that catalogs Web sites";      
                       
                        //create a map object to store pairs of question and selected answer
                        map=new HashMap<Integer, String>();
                    }
                        }
        public String getSelection(){
                        String selectedChoice=null;
                        Enumeration<AbstractButton> buttons=bg.getElements(); 
                        while(buttons.hasMoreElements()) 
                        { 
                        JRadioButton temp=(JRadioButton)buttons.nextElement(); 
                        if(temp.isSelected()) 
                                    { 
                                                selectedChoice=temp.getText();
                                    } 
                         }  
                        return(selectedChoice);
            }
        public void readqa(int qid){
                        lblmess.setText("  "+qpa[qid][0]);
                        choice1.setText(qpa[qid][1]);
                        choice2.setText(qpa[qid][2]);
                        choice3.setText(qpa[qid][3]);
                        choice4.setText(qpa[qid][4]);
                        choice1.setSelected(true);
            }
        public void reset(){
                        qaid=0;
                        map.clear();
                        readqa(qaid);
                        btnext.setText("Next");
                        }
        public int calCorrectAnswer(){
                        int qnum=10;
                        int count=0;
                        for(int qid=0;qid<qnum;qid++)
                                    if(qca[qid][1].equals(map.get(qid))) count++;
                        return count;
            }
        public class Report extends JFrame{
                        Report(){
                                    setTitle("Answers");
                                    setSize(850,550);
                                    setBackground(Color.WHITE);
                                    addWindowListener(new WindowAdapter(){
                                                            public void windowClosing(WindowEvent e){
                                                                        dispose();
                                                                        reset();
                                                            }
                                                });
                                    Draw d=new Draw();                                  
                                    add(d);
                                    setVisible(true);
                                    }
                    class Draw extends Canvas{
                                    public void paint(Graphics g){
                                                int qnum=10;
                                                int x=10;
                                                int y=20;
                                                for(int i=0;i<qnum;i++){
                                                            //print the 1st column
                                                            g.setFont(new Font("Arial",Font.BOLD,12));                                         
                                                            g.drawString(i+1+". "+qca[i][0], x,y);
                                                            y+=30;           
                                                            g.setFont(new Font("Arial",Font.PLAIN,12));                             
                                                            g.drawString("      Correct answer:"+qca[i][1], x,y);
                                                            y+=30;
                                                            g.drawString("      Your answer:"+map.get(i), x,y);
                                                            y+=30;
                                                            //print the 2nd column
                                                            if(y>400)
                                                            {y=20;
                                                              x=450;
                                                            }
                                                           
                                                }
                                                //Show number of correct answers
                                                int numc=calCorrectAnswer();
                                                g.setColor(Color.BLUE);
                                                g.setFont(new Font("Arial",Font.BOLD,14));
                                                g.drawString("Number of correct answers:"+numc,300,500);
                                    }
                        }             
            }
}
 public class QuizProgram{
            public static void main(String args[]){
                         new Quiz();
  
            }
}