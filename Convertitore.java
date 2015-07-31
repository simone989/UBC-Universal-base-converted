
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Convertitore{
	public static void main(String argv[]){
            new Linguaggio();
        }
}

class GestoreFinestra implements WindowListener{
	public void windowIconified(WindowEvent e){ }
	public void windowDeiconified(WindowEvent e){ }
	public void windowActivated(WindowEvent e){ }
	public void windowDeactivated(WindowEvent e){ }
	public void windowOpened(WindowEvent e){ }
	public void windowClosed(WindowEvent e){ }
	public void windowClosing(WindowEvent e){
		System.out.println("Fine Programma.");
		System.exit(0);
	}
}
@SuppressWarnings("serial")
class Pop_up extends Frame implements ActionListener,WindowListener{
	private JButton ok;
    private TextArea t;
	
	public Pop_up(){
		super("");
		
		ok = new JButton("Ok");
		ok.addActionListener(this);
		t = new TextArea("");
        t.setEditable(false);
		add(t);
		add(ok);
		addWindowListener(this);
		setLayout(new FlowLayout());
		setResizable(false);
		
		setVisible(false);
	}
	public void apri(String testo, String titolo){
		setLocation(0,0);
		setTitle(titolo);
		t.setText(testo);
        pack();
		setVisible(true);
	}
	public void chiudi(){
		setVisible(false);
	}
	public void actionPerformed(ActionEvent e){
		setVisible(false);
	}
	
	public void windowIconified(WindowEvent e){ }
	public void windowDeiconified(WindowEvent e){ }
	public void windowActivated(WindowEvent e){ }
	public void windowDeactivated(WindowEvent e){ }
	public void windowOpened(WindowEvent e){ }
	public void windowClosed(WindowEvent e){ }
	public void windowClosing(WindowEvent e){
		dispose();
	}
}
@SuppressWarnings("serial")
class Pop_up2 extends Frame implements ActionListener,WindowListener{
	private JButton ok;
	private JTextArea t;
	
	public Pop_up2(){
		super("");
		
		ok = new JButton("Ok");
		ok.addActionListener(this);
		t = new JTextArea("");
        t.setEditable(false);
		add(t);
		add(ok);

		setLayout(new FlowLayout());
		setResizable(false);
		addWindowListener(this);
		setVisible(false);
	}
	public void apri(String testo, String titolo){
		setLocation(0,0);
		setTitle(titolo);
		t.setText(testo);
        pack();
		setVisible(true);
	}
	public void chiudi(){
		setVisible(false);
	}
	public void actionPerformed(ActionEvent e){
		setVisible(false);
	}
	
	public void windowIconified(WindowEvent e){ }
	public void windowDeiconified(WindowEvent e){ }
	public void windowActivated(WindowEvent e){ }
	public void windowDeactivated(WindowEvent e){ }
	public void windowOpened(WindowEvent e){ }
	public void windowClosed(WindowEvent e){ }
	public void windowClosing(WindowEvent e){
		dispose();
	}
}
@SuppressWarnings("serial")
class Finestra extends JFrame implements ActionListener {
    private boolean ok;
	private Converti conv;
	public JTextField inserisci,risultato,baseiniziale,basefinale,risultatofin;
	public JTextField potenza,modulo;
	private JPanel p1,p3;
	private JPanel q1,q2,q3,q4;
	private JButton invio , step, reset;
	private String lingua[];
	private Pop_up pop;

	private long appmod;//serve per conservare il risultato del resto della divisione per la simulazione
	

	public Finestra(Converti conv, String lingua[]){
		super("UBC---Universal Base Converter");
        this.lingua = new String[30];
		pop = new Pop_up();
        for(int i = 0; i < 30;i++){
            this.lingua[i]=lingua[i];
        }
		p1=new JPanel();// input
		p3= new JPanel(); // risultato
                
        appmod=0;
        ok=false;

		inserisci = new JTextField(10);
		risultato = new JTextField(50);
		risultato.setEditable(false);
		baseiniziale = new JTextField(4);
		basefinale = new JTextField(4);

		invio=new JButton(lingua[4]);
		invio.addActionListener(this);
		reset = new JButton(lingua[22]);
		reset.addActionListener(this);

		this.conv=conv;

		p1.add(new Label(lingua[1]));
		p1.add(inserisci);
		p1.add(new Label(lingua[2]));
		p1.add(baseiniziale);
		p1.add(new Label(lingua[3]));
		p1.add(basefinale);
		p1.add(invio);
		p1.add(reset);

		p3.add(new Label(lingua[5]));
		p3.add(risultato);
		
        Menu esercitazione = new Menu(lingua[13]);	
		Menu help = new Menu(lingua[14]);
		Menu crediti = new Menu(lingua[15]);
		MenuItem esercizi = new MenuItem(lingua[27]);
		MenuItem aiuto = new MenuItem(lingua[28]);
		MenuItem crediti2 = new MenuItem(lingua[29]);
		esercizi.addActionListener(this);
		aiuto.addActionListener(this);
		crediti2.addActionListener(this);
		esercitazione.add(esercizi);
		help.add(aiuto);
		crediti.add(crediti2);
		MenuBar barra=new MenuBar();
        barra.add(esercitazione);
		barra.add(help);
		barra.add(crediti);
		setMenuBar(barra);
		
		p1.setBounds(0,0,800,30);
		p3.setBounds(0,30,800,30);

		setLayout(null);
		addWindowListener(new GestoreFinestra());

		add(p1);
		add(p3);



		q1= new JPanel(); 
		q2= new JPanel();
		q3= new JPanel();
		q4= new JPanel();

		step = new JButton(lingua[7]);           

		q1.add(new JLabel(lingua[6])); 		//inizio q1
		q1.add(step);
		q1.setBounds(0,60,800,30);
		add(q1);                                 // fine q1


		q2.add(new Label(lingua[8]));


		potenza = new JTextField(70);
		q2.add(potenza);
		q2.setBounds(0,90,800,60);
		add(q2);
		potenza.setEditable(false);

		step.addActionListener(this);



		q3.add(new Label(lingua[9]));

		modulo = new JTextField(70);
		q3.add(modulo);
		q3.setBounds(0,150,800,60);
		add(q3);
		modulo.setEditable(false);


		q4.add(new Label(lingua[10]));
		risultatofin = new JTextField(70);
		q4.add(risultatofin);
		q4.setBounds(0,210,800,60);
		add(q4);
		risultatofin.setEditable(false);


		getContentPane().setBackground(Color.white);
		setResizable(false);
		setSize(800,320);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()==lingua[22]){
			inserisci.setText("");
			risultato.setText("");
			baseiniziale.setText("");
			basefinale.setText("");
			risultatofin.setText("");
	 		potenza.setText("");
	 		modulo.setText("");
	 		return;
		}
		if(e.getActionCommand()==lingua[27]){
			new Esercitazione(lingua);
			return;
		}
		if(e.getActionCommand()==lingua[28]){
			aiuto();
			return;
		}
		if(e.getActionCommand()==lingua[29]){
			about();
			return;
		}
        if(e.getActionCommand()==lingua[7] && ok)
			simulazione();
        else{
		    conv.compatta(inserisci.getText());
		    try{
		        conv.base_iniziale=Integer.parseInt(baseiniziale.getText());
		        conv.base_finale=Integer.parseInt(basefinale.getText());
		    }catch(NumberFormatException p){
		        System.out.println(lingua[11]);
		        return;
		    }
		    if(!conv.controllo_base()){
		        pop.chiudi();
				pop.apri(lingua[12], "");
			}
		    else{
		        if((e.getActionCommand())==(lingua[4])){
		            potenza.setText("");
		            modulo.setText("");
		            risultatofin.setText("");
		            conv.esegui_conversione();
		            ok=false;
		        }
		        else{
		            String numeropotenza=new String();
		            int j=conv.lunghezza_input;
		            int l = conv.lunghezza_input;
		            for(int i=0;i<=l;i++){
		                if(i==l)
		                    numeropotenza+=((int)conv.getVettore_Input()[i])+" *"+conv.base_iniziale+"^"+j;
		                else 
		                    numeropotenza+=((int)conv.getVettore_Input()[i])+" *"+conv.base_iniziale+"^"+j+" + ";
		                j--;
		            }
		            numeropotenza+="   =  "+(int)conv.baseDieci();
		            potenza.setText(numeropotenza);
		            appmod=conv.baseDieci();
		            ok=true;
		        }
		    }
		}    	
	}
	
	void aiuto(){
		LeggiFile f ;
		/*switch(lingua[0]){
			case "italiano" : f = new LeggiFile("aiutoIT");  break;
			case "english" : f = new LeggiFile("aiutoEG"); break;
			case "spagnolo" : f = new LeggiFile("aiutoSP"); break;
			default : f = new LeggiFile("aiutoIT");  break;
		}*/
		if(lingua[0] == "italiano" ) f = new LeggiFile("aiutoIT");
		else if(lingua[0] == "english") f = new LeggiFile("aiutoEG");
		else if(lingua[0] == "spagnolo" ) f = new LeggiFile("aiutoSP");
		else f = new LeggiFile("aiutoIT");
		String con[] = new String[36];
		con = f.leggi();
		String con2 = "";
		for(int i=1;i<36;i++)
			con2=con2+con[i]+"\n";
		pop.chiudi();
		pop.apri(con2,"Aiuto"/*,300,300*/);
	}
	
	void about(){
		String about = "";
		String nome = "";
		if(lingua[0]== "italiano"){
			about = "Programma creato da : \n"+
						"Indrit Gjonaj : Implementazione dell'algoritmo di conversione.\n"+
						"Cutuli Giuseppe : Algoritmo di esercitazione e multilingua \n"+
						"Di Mauro Simone : Creazione parte grafica\n"+
						"\n\n"+
						"Per maggiori informazioni visitate questo link : \n"+
						"https://galileo.dmi.unict.it/projects/ubcuiversalbaseconverter/index.html \n\n";
			nome = "Crediti";
		}else if(lingua[0] == "english"){
				about = 
					"Program created by:/n"+
					"Indrit Gjonaj: Implementation of the algorithm conversion.\n"+
					"Cutuli Joseph algorithm and exercise Multilingual\n"+
					"Di Mauro Simone: Creating the graphics\n"+
					"\n\n"+
					"For more information visit this link:\n"+
					"https://galileo.dmi.unict.it/projects/ubcuiversalbaseconverter/index.html \n\n";
				nome = "Credits";
		}
		else if(lingua[0] == "spagnolo"){
				about = 
						"Programa creado por:\n"+
						"Indrit Gjonaj: Implementaci\u00F3n de la conversi\u00F3n algoritmo.\n"+
						"Cutuli Giuseppe : Algoritmo y el ejercicio multiling\u00FCe.\n"+
						"Di Mauro Simone: Creaci\u00F3n de los gr\u00E1ficos.\n"+
						"\n\n"+
						"Para obtener m\u00E1s informaci\u00F3n, visite este enlace:\n"+
						"https://galileo.dmi.unict.it/projects/ubcuiversalbaseconverter/index.html \n\n";
				nome = "Cr\u00E9ditos";
		}
		pop.apri(about,nome);
	}
	
	void simulazione(){
        if(appmod!=0){
			long resto_div= appmod % conv.base_finale;	
			long risultato_div=(appmod-resto_div) / conv.base_finale;
			String testo= appmod + " / " + (long)conv.base_finale+" = " + risultato_div + "   r = " + resto_div; 
		    modulo.setText(testo);
		
			String attuale = risultatofin.getText();
			attuale = "[ "+(int)resto_div+" ]" + attuale;
		
			risultatofin.setText(attuale);
			appmod=risultato_div;
      	}
	}
}
@SuppressWarnings("serial")
class Esercitazione extends JFrame implements ActionListener{
    private JButton facile, medio, difficile, aiuto, consiglio, invio, reset;
    private JPanel informazioni, inserimenti, difficolta;
    private JTextField numero, baseiniziale, basefinale, risultato;
    private int cifreRandom[]=new int[1000], dim = 0;
    private int baseMax, numeroMax,numeroCifre,numeroRand,inizRand,finRand;
    private long basedieci;
    private boolean gerati;
    private String aiutostringa="";
    private String lingua[];
	private Pop_up pop;
	private Pop_up2 pop2;
    
    public Esercitazione(String lingua[]){
        super(lingua[13]);
        this.lingua = new String[30];
        for(int i = 0; i < 30;i++){
            this.lingua[i]=lingua[i];
        }
        
		pop = new Pop_up();
		pop2 = new Pop_up2();
		
        facile = new JButton(lingua[17]);
        medio = new JButton(lingua[18]);
        difficile = new JButton(lingua[19]);
       
        gerati = false;
        
        numero = new JTextField(10);
        baseiniziale = new JTextField(10);
        basefinale = new JTextField(10);
        
        numero.setEditable(false);
        baseiniziale.setEditable(false);
        basefinale.setEditable(false);
        
        informazioni = new JPanel();
        add(informazioni); 
        informazioni.setLayout(new GridLayout(7,2,10,10));
        difficolta = new JPanel();
        inserimenti= new JPanel();
        inserimenti.setLayout(new GridLayout(2,2,10,10));
        
        aiuto= new JButton(lingua[14]);
        consiglio= new JButton(lingua[21]);
        invio= new JButton(lingua[4]);
        risultato= new JTextField();
        reset = new JButton(lingua[22]);
        
        
        difficolta.add(facile);
        difficolta.add(medio);
        difficolta.add(difficile);
        informazioni.add(new Label(lingua[16]));
        informazioni.add(difficolta);
        informazioni.add(new Label(lingua[20]));
        informazioni.add(numero);
        informazioni.add(new Label(lingua[2]));
        informazioni.add(baseiniziale);
        informazioni.add(new Label(lingua[3]));
        informazioni.add(basefinale);
        
        JPanel uno= new JPanel();
        JPanel due= new JPanel();
        //JPanel tre= new JPanel();
        JPanel quattro= new JPanel();
        JPanel cinque= new JPanel();
        JPanel sei= new JPanel();
        uno.add(aiuto);
        due.add(consiglio);
        quattro.add(risultato);
        sei.add(invio);
        cinque.add(reset);
        informazioni.add(uno);
        informazioni.add(due);
        informazioni.add(new JLabel("                    "+lingua[23]));
        informazioni.add(risultato);
        informazioni.add(cinque);
        informazioni.add(sei);
        medio.addActionListener(this);
        difficile.addActionListener(this);
        facile.addActionListener(this);
        aiuto.addActionListener(this);
        consiglio.addActionListener(this);
        reset.addActionListener(this);
        invio.addActionListener(this);
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        /*switch(e.getActionCommand()){
            case "Facile": generaf(1);break;
            case "Medio": generaf(2);break;
            case "Difficile": generaf(3);break;
            case "Aiuto": aiutof();break;
            case "Consiglio": consigliof();break;
            case "Invio": inviof();break;
            case "Reset": resetf();break;
        }*/
        if(e.getActionCommand()==lingua[17])generaf(1);
        else if(e.getActionCommand()==lingua[18])generaf(2);
        else if(e.getActionCommand()==lingua[19])generaf(3);
        else if(e.getActionCommand()==lingua[14])aiutof();
        else if(e.getActionCommand()==lingua[21])consigliof();
        else if(e.getActionCommand()==lingua[4])inviof();
        else if(e.getActionCommand()==lingua[22])resetf();
        
            
    }
    private void generaf(int x){
        boolean cifrazero;
        gerati=true;
        aiutostringa="";
        switch(x){
            case 1: 
				dim=0;
                numero.setText(null);
                baseMax = 10;
                numeroMax = 100;
                numeroCifre = 2;  
                numeroRand=0;
                inizRand=(int)((Math.random()*(baseMax-2))+2);
                finRand=(int)(((Math.random()*numeroMax)%(baseMax-2))+2);
                baseiniziale.setText(Integer.toString(inizRand));
                basefinale.setText(Integer.toString(finRand));
                cifrazero=true;
                for(int i=0;i<numeroCifre;i++){
                    numeroRand=(int)((Math.random()*baseMax)%inizRand);
                    if(!cifrazero){ 
                        numero.setText(numero.getText()+"["+numeroRand+"]");
                        cifreRandom[dim]=numeroRand;
                        dim++;
                    }
                    else if(numeroRand!=0){   
                        numero.setText(numero.getText()+"["+numeroRand+"]");
                        cifreRandom[dim]=numeroRand;
                        dim++;
                        cifrazero=false;
                    }
                }
                if(cifrazero){ // caso 0 0
                    numeroRand=(int)(Math.random()*(baseMax-1)+1);
                    numero.setText(numero.getText()+"["+numeroRand+"]");
                    cifreRandom[dim]=numeroRand;
                    dim++;
                }
                break;
            
            case 2:
                dim=0;
                numero.setText(null);
                baseMax = 100;
                numeroMax = 1000;
                numeroCifre = 4;  
                numeroRand=0;
                inizRand=(int)((Math.random()*(baseMax-2))+2);
                finRand=(int)(((Math.random()*numeroMax)%(baseMax-2))+2);
                baseiniziale.setText(Integer.toString(inizRand));
                basefinale.setText(Integer.toString(finRand));
                cifrazero=true;
                for(int i=0;i<numeroCifre;i++){
                    numeroRand=(int)((Math.random()*baseMax)%inizRand);
                    if(!cifrazero){ 
                        numero.setText(numero.getText()+"["+numeroRand+"]");
                        cifreRandom[dim]=numeroRand;
                        dim++;
                    }
                    else if(numeroRand!=0){   
                        numero.setText(numero.getText()+"["+numeroRand+"]");
                        cifrazero=false;
                        cifreRandom[dim]=numeroRand;
                        dim++;
                    }
                }
                if(cifrazero){ // caso 0 0
                    numeroRand=(int)(Math.random()*(baseMax-1)+1);
                    numero.setText(numero.getText()+"["+numeroRand+"]");
                    cifreRandom[dim]=numeroRand;
                    dim++;
                }
                break;
            case 3:
                dim=0;
                numero.setText(null);
                baseMax = 500;
                numeroMax = 5000;
                numeroCifre = 5;
                numeroRand=0;
                inizRand=(int)((Math.random()*(baseMax-2))+2);
                finRand=(int)(((Math.random()*numeroMax)%(baseMax-2))+2);
                baseiniziale.setText(Integer.toString(inizRand));
                basefinale.setText(Integer.toString(finRand));
                cifrazero=true;
                for(int i=0;i<numeroCifre;i++){
                    numeroRand=(int)((Math.random()*baseMax)%inizRand);
                    if(!cifrazero){ 
                        numero.setText(numero.getText()+"["+numeroRand+"]");
                        cifreRandom[dim]=numeroRand;
                        dim++;
                    }
                    else if(numeroRand!=0){   
                        numero.setText(numero.getText()+"["+numeroRand+"]");
                        cifrazero=false;
                        cifreRandom[dim]=numeroRand;
                        dim++;
                    }
                }
                if(cifrazero){ // caso 0 0
                    numeroRand=(int)(Math.random()*(baseMax-1)+1);
                    numero.setText(numero.getText()+"["+numeroRand+"]");
                    cifreRandom[dim]=numeroRand;
                    dim++;
                }
                break;    
        }
        basedieci = baseDieci();
    }
    private void aiutof(){
    	simulazione();
    }
    long baseDieci(){
		long convert=0,j=0; 
		for(int i=dim-1;i>=0;i--){
		        long x=(long)(Math.pow(Double.parseDouble(baseiniziale.getText()),j));
		        convert=convert+(cifreRandom[i]*x);
		        j++;
		}
		return convert;
	}
    private void consigliof(){
		LeggiFile f ;
		if(lingua[0] == "italiano") f = new LeggiFile("consiglio");
		else if(lingua[0] == "english")  f = new LeggiFile("advice");
		else if(lingua[0]== "spagnolo") f = new LeggiFile("asesoramiento"); 
		else f = new LeggiFile("consiglio");  
		String con[] = new String[9];
		con = f.leggi();
		String con2 = "";
		for(int i=1;i<8;i++)
			con2=con2+con[i]+"\n";
		pop.apri(con2,"");
    }
    private void inviof(){
        if(!gerati) // non ha ancora generato i numeri casuali
            return;
        String input_utente = risultato.getText();
        if(input_utente!=""){
            Converti cf = new Converti(dim,cifreRandom,lingua); //vett classe converti
            cf.base_finale=finRand;
            cf.base_iniziale= inizRand;
            cf.compatta(input_utente); //string input class converti
            String x = cf.esegui_conversione2();
            boolean ok=true;
            if(x.length()==input_utente.length()){
                for(int i = 0; i<input_utente.length();i++){
					System.out.println("x"+x.charAt(i)+"input"+input_utente.charAt(i));
                    if(x.charAt(i)!=input_utente.charAt(i)){
                    	ok=false;
                        break;
                    }
                }
            }else{
				
				ok = false;
			} 
            if(ok){
				pop2.chiudi();
                pop2.apri(lingua[25],"");
            }else{
				pop2.chiudi();
                pop2.apri(lingua[26],"");
            }
        }
        
    }
    private void resetf(){
        risultato.setText("");        
    }
    void simulazione(){
		if(basedieci!=0){
            long resto_div= basedieci % finRand;
            basedieci=(basedieci-resto_div) / finRand;
            aiutostringa=" "+(int)(resto_div)+aiutostringa;
			pop2.chiudi();
            pop2.apri(aiutostringa,"");
        }else if(aiutostringa!=""){
			pop2.chiudi();
            pop2.apri(aiutostringa,"");
        }
    }
}

class Converti{
	public long string_input[]=new long[1000];
	public int lung,lunghezza_input;
	public int base_iniziale,base_finale;
    private long vett[] = new long[1000];
	public Finestra f;
    private String lingua[];
    
	public Converti(String lingua[]){
			if(lingua[0]=="#######") return; // controllo se ha aperto correttamente i file lingua
            this.lingua = new String[30];
            f = new Finestra(this,lingua);
            for(int i = 0 ; i< 30;i++)
                this.lingua[i]=lingua[i];
	}
	
    public Converti(int dim,int vex[],String lingua[]){
        this.lingua = new String[30];
        for(int i = 0 ; i< 30;i++)
            this.lingua[i]=lingua[i];
        lung = dim;
        lunghezza_input = 0;
        for(int i=0;i<dim;i++)
            vett[i] = vex[i];
    }
    
	public void esegui_conversione(){
        long convert,app;
        int j=0;
        convert = baseDieci();
        int i;
        for(i=0;i<1000;i++){ // da base 10 a base finale
        	app=convert%base_finale;
        	if(convert<base_finale){
				vett[i]=app;
				break;
            }else{
				convert=(convert-app)/base_finale;
				vett[i]=app;
        	}
		}
        String x = new String(); 
        for(j=i;j>=0;j--){// coinverte il numero convertito in stringa 
            x+="["+Long.toString(vett[j])+"]";
        }
        f.risultato.setText(x);
	}
        
    public String esegui_conversione2(){
		long convert = baseDieci(vett), resto = 0;
		System.out.println("convert"+convert);
		int j=0;
		int i=0;
		System.out.println("basefinale"+base_finale);
		for(i=0;i<1000;i++){
			
	    	resto=convert%base_finale;
	        if(convert<base_finale){
				vett[i]=resto;
				break;
	        }else{
				convert=(convert-resto)/base_finale;
				vett[i]=resto;
	       	}
			
	        
	    }
        String x="";
        for(j=i;j>=0;j--){
            if(j==i)
                x=Long.toString(vett[j]);
            else
                x+=" "+Long.toString(vett[j]);
		}
		System.out.println("X"+x);
        return x ;
    }
    
    public boolean controllo_base(){
        long max=0;
		for(int i=0;i<=lunghezza_input;i++){
            if(max<string_input[i])
				max=string_input[i];
		}
        return !(max>base_iniziale);
    }
    
    public long[] getVettore_Input(){
        return string_input;
    }
    
    public void compatta(String input){
        lunghezza_input=0;
        int cont=0;
        for(int i=0;i<input.length();i++){
            if(i==input.length()-1){
                try{
                    string_input[lunghezza_input]= Integer.parseInt(input.substring(cont,i+1));
                }catch(NumberFormatException p){
                    System.out.println(lingua[11]);
                    return;
                }
            }
            else if(input.charAt(i)==' '){
                try{
                    string_input[lunghezza_input]= Integer.parseInt(input.substring(cont,i));
                }catch(NumberFormatException p){
                    System.out.println(lingua[11]);
                    return;
                }
                cont=i+1;
                lunghezza_input++;
            }
        }
    }
    long baseDieci(){
        long convert=0,j=0; 
		for(int i=lunghezza_input;i>=0;i--){
            long x=(long)(Math.pow(base_iniziale,j));
            convert=convert+(string_input[i]*x);
            j++;
		}
		return convert;
    }
    
    long baseDieci(long vex[]){
        long convert=0,j=0, x=0; 
		for(int i=lung-1;i>=0;i--){
			
            x=(long)(Math.pow(base_iniziale,j));
            convert=convert+(vex[i]*x);
            j++;
		}
		
		return convert;
    }
}
@SuppressWarnings("serial")
class Linguaggio extends JFrame implements ActionListener {
    private JButton inglese,italiano,spagnolo;
    public Linguaggio(){
        super("Linguaggio");
        inglese = new JButton("English");
        italiano = new JButton("Italiano");
        spagnolo = new JButton("Espa\u00F1ol");
        setLayout(new GridLayout(1,3));
        
        add(inglese);
        add(italiano);
        add(spagnolo);
        
        inglese.addActionListener(this);
        italiano.addActionListener(this);
        spagnolo.addActionListener(this);
        pack();
        addWindowListener(new GestoreFinestra());
        setVisible(true);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e){
        LeggiFile x;
        if(e.getActionCommand() == "English"){	
   	    	x = new LeggiFile("english"); 
            new Converti(x.leggi());
        }
        else if(e.getActionCommand() == "Italiano"){  	
           	x = new LeggiFile("italiano"); 
            new Converti(x.leggi());
        }else if(e.getActionCommand() == "Espa\u00F1ol"){ 	
           	x = new LeggiFile("spagnolo"); 
            new Converti(x.leggi());
        }
        dispose();
    }
}

class LeggiFile{
    private String lingua;
    private String file[];
    private int i;
	/**
	* Metodo costruttore della classe LeggiFile
	* Come parametro viene passato il nome del file da leggere senza estensione
	* @param x nome del file da leggere senza estensione
	*/
    public LeggiFile(String x){
        file = new String[36];
        i=1;
        lingua = x;
		file[0] = x;
    }
    public String[] leggi(){
    	Closeable resource;
        try{
           // FileReader f;
			InputStreamReader in;
			in = new InputStreamReader(new FileInputStream("lingua/"+lingua+".txt"),"UTF-8");
            //f = new FileReader("lingua/"+lingua+".txt");
            BufferedReader b;
            b=new BufferedReader(in);
            resource = b;
            while(i<36){
                file[i]=b.readLine();
                i=i+1;
            }
            resource.close();
        }
        catch(IOException e){
            System.out.println("Errore nella lettura del file.");
            file[0]="#######";
        }
        
		return file;
    }
}



    


