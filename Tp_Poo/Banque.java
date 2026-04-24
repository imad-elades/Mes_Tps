class CompteBancaire {
    protected String numeroCompte;
    protected double solde;

    public CompteBancaire(String numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt: " + montant + ", Nouveau solde: " + solde);
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            System.out.println("Retrait: " + montant + ", Nouveau solde: " + solde);
        } else {
            System.out.println("Fonds insuffisants.");
        }
    }
}

class CompteCourant extends CompteBancaire {
    public CompteCourant(String numeroCompte, double solde) {
        super(numeroCompte, solde);
    }
}

class CompteEpargne extends CompteBancaire {
    public CompteEpargne(String numeroCompte, double solde) {
        super(numeroCompte, solde);
    }

    public void calculerInterets(double taux) {
        if (taux > 0) {
            double interets = solde * (taux / 100);
            solde += interets;
            System.out.println("Intérêts ajoutés: " + interets + ", Nouveau solde: " + solde);
        }
    }
}

public class Banque {
    public static void main(String[] args) {
        CompteCourant cc = new CompteCourant("CC-101", 1000.0);
        CompteEpargne ce = new CompteEpargne("CE-202", 2000.0);

        cc.deposer(500.0);
        cc.retirer(200.0);
        cc.retirer(2000.0); 

        ce.deposer(1000.0);
        ce.calculerInterets(5.0);
        ce.retirer(500.0);
    }
}
