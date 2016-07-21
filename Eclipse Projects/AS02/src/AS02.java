
import java.util.Scanner;
/**
 *
 * @author Airinei
 */

public class AS02 {
    public static void tablaInmultirii (int n){
        System.out.println("Tabla inmultirii pana la " + n + " \n");
        
        for(int i=1;i<n;i++){
            for(int j=1;j<=n;j++){
                System.out.println(i + "*" + j+ " = " + i*j );
            }
            System.out.println("\n");
         }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Pana la ce numar sa fie afisata tabla inmultirii? ");

        int i= in.nextInt();
        
        tablaInmultirii (i);
                
        System.exit(0);
        
        in.close();
        
    }
    
}