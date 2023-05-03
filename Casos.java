public class Casos
{
    public static void main(String [] args){
        String casos [] = generarCasos();
    }
    
    public static String [] generarCasos(){
        String casos [] = new String[100];
   
        String caso1 [] = generarCaso(/*(int)125E3*/100);//125.000

        String caso2 [] = generarCaso(/*(int)25E4*/200);//250.000
 
        String caso3 [] = generarCaso(/*(int)375E3*/300);//375.000

        String caso4 [] = generarCaso(/*(int)5E5*/500);//cota maxima - 500.000 

        for(int i=0,j=0; i<100; i++,j++){
            if(i<25){//llena caso 1
                casos[i] = caso1[j]; 
            }else{
                if(i<50){// llena caso 2
                    j= (j==25?0:j);
                    casos[i] = caso2[j];
                }else{
                    if(i<75){//llena caso 3
                        j= (j==25?0:j);
                        casos[i] = caso3[j];
                    }else{//llena caso 4
                        j= (j==25?0:j);
                        casos[i] = caso4[j];
                    }
                }
            }
        }

        return casos;
    }

    public static String [] generarCaso(int tam){
        String caso [] = new String[25];
        
        for(int i=0; i<25; i++){
            int j = 0;
            String palabra = "";
            int tamañoPalabra = (int)(Math.random()*tam+1);//tamaño entre 1 y tam
            while(j<tamañoPalabra){
                int num = (int)(Math.random()*(122-48+1)+48);//numero entre 48 y 122
                int min, max;
                if(num>96){
                    //Minuscula(a-z)
                    min = 97;
                    max = 122;
                }else{
                    if(num>64){
                        //Mayuscula(A-Z)
                        min = 65;
                        max = 90;
                    }else{
                        //Digitos(0-9)
                        min = 48;
                        max = 57;
                    }
                }
                char caracter = (char)(generarAscii(min,max));//genera el caracter en el rango dado (48-57),(65-90),(97-122)
                palabra += caracter;
                j++;
            }
            System.out.println(palabra);
            caso[i] = palabra;
        }

        return caso;
    }

    public static int generarAscii(int min, int max){
        int ascii = (int)(Math.random()*(max-min+1)+min);//numero entre min y max
        return ascii;
    }

}
