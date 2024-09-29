import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Třída DomaciAsistent spravuje seznam chytrých zařízení a streamovacích služeb.
 * Umožňuje přidávat zařízení a služby, zapínat a vypínat všechna zařízení,
 * a přehrávat obsah na všech streamovacích službách.
 */
public class DomaciAsistent {
    private List<ISmartDevice> zarizeni = new ArrayList<>();
    private List<IStreamingService> sluzby = new ArrayList<>();
    private Scanner scanner;

    public DomaciAsistent(Scanner scanner){
        this.scanner = scanner;
        sluzby.add(new Netflix());
        sluzby.add(new Spotify());
    }

    /**
     * Přidá chytré zařízení do seznamu spravovaných zařízení.
     *
     */
    public void pridejZarizeni() {
        System.out.println("Vyberte typ zařízení:");
        System.out.println("1. SmartLight");
        System.out.println("2. SmartThermostat");
        int typ = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Zadejte název zařízení: ");
        String nazev = scanner.nextLine();

        switch (typ) {
            case 1:
                zarizeni.add(new SmartLight(nazev));
                break;
            case 2:
                System.out.print("Zadejte počáteční teplotu: ");
                double teplota = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                zarizeni.add(new SmartThermostat(nazev, teplota));
                break;
            default:
                System.out.println("Neplatný typ zařízení.");
        }
    }

    /**
     * Odebere chytré zařízení ze seznamu spravovaných zařízení.
     */
    public void odeberZarizeni() {

    }

    /**
     * Vypíše všechna spravovaná chytrá zařízení.
     */
    public void vypisZarizeni() {
        System.out.println("Seznam spravovaných zařízení:");
        for (ISmartDevice z : zarizeni) {
            System.out.println(z.stav());
        }
    }

        /**
     * Zapne všechna spravovaná chytrá zařízení.
     */
    public void zapniVse() {
        for (ISmartDevice z : zarizeni) {
            z.zapni();
        }
    }

    /**
     * Vypne všechna spravovaná chytrá zařízení.
     */
    public void vypniVse() {
    }

    /**
     * Přehrává zadaný obsah na všech spravovaných streamovacích službách.
     */
    public void prehratNaVsechSluzbach() {
        System.out.print("Zadejte název obsahu, který chcete přehrát: ");
        String nazev = scanner.nextLine();
        for (IStreamingService s : sluzby) {
            s.prehrat(nazev);
        }
    }

    /**
     * Ovládá chytrý termostat podle zadaného názvu a umožňuje nastavit novou teplotu.
     * Pokud termostat s daným názvem není nalezen, zobrazí chybovou zprávu.
     */
    public void ovladaniTermostatu() {
        System.out.println("Zadejte název termostatu, který chcete ovládat:");
        String nazev = scanner.nextLine();
        for (ISmartDevice z : zarizeni) {
            if ((z instanceof SmartThermostat) && (z.stav().equals(nazev))) {
                System.out.print("Zadejte novou teplotu: ");
                double teplota = scanner.nextDouble();
                scanner.nextLine();
                ((SmartThermostat) z).nastavTeplotu(teplota);
                return;
            }
        }
        System.out.println("Termostat s názvem " + nazev + " nebyl nalezen.");
    }

}

