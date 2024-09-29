/**
 * Rozhraní pro chytré zařízení, které definuje základní operace.
 */
public interface ISmartDevice {
    /**
     * Zapne chytré zařízení.
     */
    public void zapni();

    /**
     * Vypne chytré zařízení.
     */
    public void vypni();

    /**
     * Vrátí aktuální stav chytrého zařízení.
     *
     * @return Řetězec reprezentující aktuální stav zařízení.
     */
    public String stav();
}
