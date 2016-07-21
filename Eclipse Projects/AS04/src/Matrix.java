/**
 *
 * @author Airinei
 */
public class Matrix {
    private final int n;             
    private final int m;             
    private final int[][] valori;   

    public Matrix() {
        
        n = 2;
        m = 2;
        
        this.valori = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                    this.valori[i][j] = 0;
    }
    
    public Matrix(int x) {
        
        n = x;
        m = x;
        
        this.valori = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                    this.valori[i][j] = 0;
    }
    
    public Matrix(int linii, int coloane) {
        
        n=linii;
        m=coloane;
        valori = new int[n][m];
    }
   
    
    public Matrix(int[][] matrice) {
        
        n = matrice.length;
        m = matrice[0].length;
        
        this.valori = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                    this.valori[i][j] = matrice[i][j];
    }

    private Matrix(Matrix A) { 
        
        this(A.valori);
        
    }
    
    public void adunare(Matrix B) {
      
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                this.valori[i][j] = this.valori[i][j] + B.valori[i][j];

    }
    
    public void inmultireConstanta(int k){
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                this.valori[i][j]=this.valori[i][j]*k;
            }
        }
    }
    
    
    public void afisare() { 
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)                
                System.out.printf("%s ", this.valori[i][j]);
            System.out.println();
        }
        System.out.println(" ");
    }
    
    public static void main(String[] args) {
        System.out.printf("Constructorul implicit");
        Matrix m = new Matrix();
        m.afisare();
        
        System.out.printf("Constructorul de instantiere a unei matrici patratice");
        Matrix n = new Matrix(6);
        n.afisare();
        
        System.out.printf("Obiect Matrice instantiat cu ajutorul unui masic");
        int[][] v = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9} };
        Matrix a1= new Matrix(v);
        a1.afisare();
        
        System.out.printf("Inmultirea a doua matrici");
        Matrix a2= new Matrix(a1);
        a2.inmultireConstanta(2);
        a2.afisare();
        
        System.out.printf("Adunarea a doua matrice");
        a1.adunare(a2);
        a1.afisare();
    }
    
}
