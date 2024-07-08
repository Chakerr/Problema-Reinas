package mundo;

public class Logica {
    private String matriz[][];

    public Logica(int columna) {
        matriz = new String[8][8];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j]=" ";
            }
        }
        matriz[0][columna]="Q";
    }
    
    private boolean vertical(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (!matriz[i][columna].equals(" ")) {
                return false;
            }
        }
        return true;
    }

    private boolean diagonalPri(int fila, int columna) {
        for (int i = fila - 1, j = columna - 1; i >= 0 && j >= 0; i--, j--) {
            if (!matriz[i][j].equals(" ")) {
                return false;
            }
        }
        return true;
    }
    private boolean diagonalSecu(int fila, int columna){
        for (int i = fila - 1, j = columna + 1; i >= 0 && j < matriz.length; i--, j++) {
            if (!matriz[i][j].equals(" ")) {
                return false;
            }
        }
        return true;
    }
    private boolean sePuedePoner(int i, int j){
        return vertical(i,j) &&  diagonalPri(i, j) && 
                diagonalSecu(i,j);
    }
    
    public void colocarFichas(){
        ponerReina(1);
    }
            
    public String[][] ponerReina(int fila){
        if (fila == 8) {
            Mostrar();
            return matriz;
        }
        for (int i = 0; i < 8; i++) {
            matriz[fila][i] = "Q";
            if (sePuedePoner(fila, i)) {      
                String aux[][]= ponerReina(fila + 1);
                if (aux!=null) {
                    return aux;
                }
            }
            matriz[fila][i] = " ";
        }
        return null;
    }
    
    public void Mostrar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print( " [" + matriz[i][j] + "] "+ " ");
                
            }
            System.out.println();
        }
        System.out.println();
     
    }

    public String[][] getMatriz() {
        return matriz;
    }
    
}