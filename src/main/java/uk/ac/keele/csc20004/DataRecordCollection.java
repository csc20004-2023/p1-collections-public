/* **********************
 * CSC-20004 2022/23    *
 * Java Collections     *
 * **********************/
package uk.ac.keele.csc20004;

import java.io.BufferedReader;
import java.io.IOException;


/** This abstract class mimics the behaviour of the classes from the
 * Java Collections Framework.
 * It is meant to store a collection of DataRecord, but it does not provide any
 * actual implementation of that; this is delegated to the concrete subclasses.
 * This abstract class, however, defines the access methods that the concrete
 * subclasses will have to implement (in other words, the interface for the collection.
 *
 * The methods first(), next(), and atEnd() are supposed to be used to iterate
 * through the collection (in a for-loop style)
 *
 * @author Marco Ortolani
 */
public abstract class DataRecordCollection {
    private BufferedReader fh;

    private boolean endOfFile = true;

    private DataRecordCollection() {
        // not possible to use this
    }

    /** A constructor based on BufferedReader.
     * Note that the constructor is <b>not</b> public; it may be used by all classes
     * in this package, but it is not supposed to be visible externally.
     *
     * @param inputData a buffered stream from which data is to be read
     */
    DataRecordCollection(BufferedReader inputData) {
        try {
            fh = inputData;

            endOfFile = false;

            fh.readLine();  // Discard the header line.
        } catch (IOException e) {
            System.out.println("DataRecordCollection(): " + e.toString());
        }
    }

    /** Load one data entry from the previously opened stream
     *
     * @return a DataRecord representing one entry of the csv
     */
    protected DataRecord loadDataRecord() {
        DataRecord dr = null;

        if (!endOfFile) {
            try {
                String line = fh.readLine();
                if(line == null) {
                    endOfFile = true;
                    fh.close();
                } else {
                    line = line.replace("\"", "");  // Because some fields in the CSV are enclosed in quotes (CSV strings).
                    String[] lineElements = line.split(",");
                    dr = new DataRecord(Integer.parseInt(lineElements[0]),
                                         Integer.parseInt(lineElements[1]),
                                         Integer.parseInt(lineElements[2]),
                                         Integer.parseInt(lineElements[3]),
                                         Integer.parseInt(lineElements[4]));
                }
            } catch (IOException e) {
                System.out.println("loadDataRecord(): " + e.toString());
            }
        }

        return dr;
    }

    /** Checks if more data can be read from the file.
     * Note that loadDataRecord() needs to be called for it to notice that
     * the EOF has been reached.
     *
     * @return true if we have not yet reached the end of the file
     */
    protected boolean dataAvailable() {
        return !endOfFile;
    }

    /** This method returns the first entry of the collection.
     * If called repeatedly, it should not read data from the file again,
     * but just reset a pointer to the beginning of the internal storage
     *
     * @return the first entry of the csv as a DataRecord
     */
    public abstract DataRecord first();

    /** This methods returns the next entry of the collection, reading more data
     * from the file if necessary.
     *
     * @return the next entry as a DataRecord (may be null, if EOF reached)
     */
    public abstract DataRecord next();

    /** Checks if we have scanned through the entire collection.
     * Note that this is <b>not</b> exactly equivalent to dataAvailable(), as we
     * may read all data in, then call first() again and iterate through all data
     * again.
     *
     * @return true if we have scanned all entries
     */
    public abstract boolean atEnd();

    /** This method returns the current number of entries read into the collection
     *
     * @return the number of entries read so far in the collection
     */
    public abstract int size();
}
