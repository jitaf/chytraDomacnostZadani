/**
 * Rozhraní pro streamovací službu, které definuje základní operace pro přehrávání obsahu.
 */
public interface IStreamingService {
    /**
     * Přehrává zadaný titul.
     *
     * @param nazevTitulu Název titulu, který má být přehrán.
     */
    public void prehrat(String nazevTitulu);

    /**
     * Zastaví aktuálně přehrávaný obsah.
     */
    public void stop();

    public boolean prehrava();
}
