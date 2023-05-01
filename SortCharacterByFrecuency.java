import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedHashMap;

public class SortCharacterByFrecuency
{
    public static String ordenarPorFrecuencia(String s){
        String ans = "";
        HashMap<Character, Integer> frecuencia = new HashMap<Character, Integer>();//guarda el caracter y su frecuencia
        char [] caracteres = s.toCharArray();
        for(char c : caracteres){
            if(frecuencia.containsKey(c)){//si ya existe
                frecuencia.compute(c, (key,val) -> val+1);//aumenta en 1 su frecuencia
            }else{//lo agrega
                frecuencia.put(c, 1);
            }
        }
        Map<Character, Integer> frecuenciaOrdenada = ordenarFrecuencia(frecuencia);//retorna un nuevo mapa ordenado por sus valores(frecuencias)

        for(char c : frecuenciaOrdenada.keySet()){//se iteran las llaves del mapa ordenando (los caracteres del nuevo String)
            
            //se itera cada valor correspondiente a la llave, si {c,2} = cc (si c existe dos veces, añade el caracter esas veces)
            for(int i=frecuenciaOrdenada.get(c); i>0; i--){
                ans+=c;
            }
        }
        
        return ans;
    }

    public static Map<Character,Integer> ordenarFrecuencia(Map<Character,Integer> mapa){
        //ArrayList con todos los caracteres y sus frecuencias
        ArrayList<Map.Entry<Character,Integer>> lista = new ArrayList<Map.Entry<Character,Integer>>(mapa.entrySet());
        
        //ordena por valores, por frecuencia
        Collections.sort(lista, new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> o1,
                Map.Entry<Character, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });
            
        //una vez ordenadas las frecuencias, se aÃ±aden a un nuevo mapa
        LinkedHashMap<Character, Integer> frecuenciaOrdenada = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> entry : lista) {
            frecuenciaOrdenada.put(entry.getKey(), entry.getValue());//se añaden las entradas ordenadas de mayor a menor en el nuevo mapa
        }

        return frecuenciaOrdenada;
    } 
}
