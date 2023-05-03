public class Main
{
    public static void main(String [] args){
        Casos c = new Casos();//se crea la clase para generar los casos
        
        String casos [] = c.generarCasos();//se crean los casos
        
        SortCharacterByFrecuency s = new SortCharacterByFrecuency();//se crea la clase donde se van a probar los casos
        System.out.println("\n\nSolucion -----------------------------------\n\n");

    
        
        for(int i=0; i<100; i++){//se ejecuta cada caso
            String ans = s.ordenarPorFrecuencia(casos[i]);
            System.out.println(ans);
        }
    }
}