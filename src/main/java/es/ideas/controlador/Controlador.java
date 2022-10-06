package es.ideas.controlador;


import es.ideas.modelo.Tanque;
import es.ideas.vista.Vista;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Controlador{
    public static void main(String[] args) throws ParseException{
            Tanque tanque = new Tanque();

            // create Options object
            Options options = new Options();

            // add t option
            options.addOption("i","info", false, "Imprime la temperatura del tanque");
            options.addOption("s","sube", true, "Sube la temperatura del tanque");
            options.addOption("b","baja", true, "Baja la temperatura del tanque");
            options.addOption("h","help", false, "Imprime la ayuda de los comandos");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            
            //Si como resultado de calentar los grados indicados por el usuario superamos los 100, el programa debe indicar: “Error, has hervido el agua a más de 100º”
            //Interpreto que SÍ se suma, indica el error pero sí se suma
            
            if(cmd.hasOption("s")) { //Subir
                String tmp;
                tmp = cmd.getOptionValue("s");
                tanque.subirTmp(Integer.parseInt(tmp));
                if (tanque.infoTmp() > 100) {
                    Vista.imprimir("Error, has hervido el agua a más de 100º");
                }
                
            }
            if(cmd.hasOption("b")) { //Bajar
                String tmp;
                tmp = cmd.getOptionValue("b");
                tanque.bajarTmp(Integer.parseInt(tmp));
                if (tanque.infoTmp() < 0) {
                    Vista.imprimir("Error, has congelado el agua");
                }
                
            }
            
            if(cmd.hasOption("i")) { //Info temperatura
                Vista.imprimir(Integer.toString(tanque.infoTmp()));
                
            }
            
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("h", options);
            }
        }
}

/*
public class Controlador {
    
    Tanque t = new Tanque();

    public void subir(String tmpStr){
        int tmp = Integer.parseInt(tmpStr);
        t.subirTmp(tmp);
    }
    
    public void bajar(String tmpStr){
        int tmp = Integer.parseInt(tmpStr);
        t.bajarTmp(tmp);
    }
    
    public String info(){
    return Integer.toString(t.infoTmp());
    } 
}
*/