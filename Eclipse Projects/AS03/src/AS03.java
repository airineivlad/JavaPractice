
import java.util.Random;
/**
 *
 * @author Airinei
 */
public class AS03 {
    
    public static void Random100 (){
        int[] vectorAleator = new int[101];
        Random aleator= new Random();
        float medie=0;
        
        for(int i=0;i<100;i++){
            vectorAleator[i]=aleator.nextInt(999);
            medie=medie+vectorAleator[i];
        }
        
        medie=medie/100;
        
        System.out.println("Media celor 100 de numere aleatoare este: " + medie);
        
        
        int numerePesteMedie=0;
        for(int i=0;i<100;i++){
            if( vectorAleator[i]>medie){
                numerePesteMedie++;
            }
        }
        
        System.out.println("Numerele peste medie sunt:  " + numerePesteMedie);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random100();
        
    }
    
}
