/* **********************
 * CSC-20004 2022/23    *
 * Java Collections     *
 * **********************/
package uk.ac.keele.csc20004;

/** The basic class storing a single entry (line) from our source file
 *
 * @author Marco Ortolani
 */
public class DataRecord {
    final int serial, speed, period, warning, pair;

    /** The constructor initialises each field from the corresponding one in the
     * file (as described in the accompanying amis.txt)
     *
     * @param theSerial a serial number identifying the entry
     * @param theSpeed speeds of cars (in miles per hour)
     * @param thePeriod the time that the reading was taken
     * @param theWarning a numeric value (1 = presence of a sign; 2 = no sign)
     * @param thePair the pair number (between 1 and 14 ) at which the reading was taken.
     */
    public DataRecord(int theSerial, int theSpeed, int thePeriod,
            int theWarning, int thePair) {
        serial = theSerial;
        speed = theSpeed;
        period = thePeriod;
        warning = theWarning;
        pair = thePair;
    }

    /** Converts the data stored in the object to a (CSV) string
     *
     * @return a properly formatted CSV string based on the stored data
     */
    @Override
    public String toString() {
        return serial + "," + speed + "," + period + "," + warning + "," + pair;
    }

}
