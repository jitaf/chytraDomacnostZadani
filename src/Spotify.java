/**
 * Třída Spotify implementuje rozhraní IStreamingService a poskytuje
 * konkrétní implementace metod pro přehrávání, pauzu a zastavení obsahu.
 */
class Spotify implements IStreamingService {
    private boolean prehravani;

    /**
     * Přehrává zadaný titul na Spotify.
     *
     * @param nazevTitulu Název titulu, který má být přehrán.
     */
    @Override
    public void prehrat(String nazevTitulu) {
        prehravani = true;
        System.out.println("Přehrávání na Spotify: " + nazevTitulu);
    }

    /**
     * Zastaví aktuálně přehrávaný obsah na Spotify.
     */
    @Override
    public void stop() {
        prehravani = false;
        System.out.println("Spotify přehrávání ukončeno.");
    }

    @Override
    public boolean prehrava() {
        return prehravani;
    }
}