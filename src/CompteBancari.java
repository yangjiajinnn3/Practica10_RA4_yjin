public class CompteBancari {
    private String titular;
    private String iban;
    private double saldo;

    public CompteBancari(String titular, String iban, double saldoInicial) {
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("El nom del titular no pot estar buit.");
        }
        if (iban == null || iban.isEmpty()) {
            throw new IllegalArgumentException("L'IBAN no pot estar buit.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no pot ser negatiu.");
        }

        this.titular = titular;
        this.iban = iban;
        this.saldo = saldoInicial;
    }

    public void ingressar(double quantitat) {
        validarQuantitat(quantitat);
        
        System.out.println("Ingrés iniciat");
        this.saldo += quantitat;
        
        System.out.println("S'ha ingressat " + quantitat);
        imprimirResumSaldo();
        System.out.println("Ingrés acabat");
    }

    public void retirar(double quantitat) {
        validarQuantitat(quantitat);
        if (quantitat > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficient per realitzar la retirada.");
        }

        System.out.println("Retirada iniciada");
        this.saldo -= quantitat;
        
        System.out.println("S'ha retirat " + quantitat);
        imprimirResumSaldo();
        System.out.println("Retirada acabada");
    }

    public void mostrarDades() {
        System.out.println("Titular: " + titular);
        System.out.println("IBAN: " + iban);
        imprimirResumSaldo();
    }

    // --- MÈTODES REFACTORITZATS (EXTRACT METHOD) ---

    /**
     * Mètode extret per eliminar la duplicació de missatges sobre l'estat del saldo.
     * Soluciona el Code Smell: "Codi duplicat" i "Condicionals repetits".
     */
    private void imprimirResumSaldo() {
        System.out.println("Saldo actual: " + this.saldo);
        if (this.saldo < 1000) {
            System.out.println("Saldo baix");
        } else if (this.saldo < 5000) {
            System.out.println("Saldo normal");
        } else {
            System.out.println("Saldo alt");
        }
    }

    /**
     * Valida que la quantitat sigui positiva. 
     * Millora el missatge d'error i centralitza la lògica.
     */
    private void validarQuantitat(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException("La quantitat ha de ser superior a zero.");
        }
    }

    // Getters
    public String getTitular() { return titular; }
    public String getIban() { return iban; }
    public double getSaldo() { return saldo; }
}
