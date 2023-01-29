/* **********************
 * CSC-20004 2022/23    *
 * Java Collections     *
 * **********************/
package uk.ac.keele.csc20004;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/** A concrete implementation of {@link DataRecordCollection} using an array for
 * internal storage.
 * This is just an empty stub! All methods are intentionally left unimplemented 
 * and will generate 
 *
 * @author Marco Ortolani
 */
public class DataRecordDynArray extends DataRecordCollection {
    private static final int BATCH_SIZE = 10;
    private DataRecord[] storage = new DataRecord[BATCH_SIZE];


    // the number of elements stored in the array (i.e. its size)
    private int numElements;
    // the position holding the current element to be read
    private int currentPos;

    /** A public constructor, providing a concrete implementation for the one in
     * the abstract superclass.
     * The constructor just builds a buffered reader, and calls the other (non public)
     * constructor.
     *
     * @param inputFile the name of the file containing the csv data
     * @throws FileNotFoundException if the input file cannot be found/opened
     */
    public DataRecordDynArray(String inputFile) throws FileNotFoundException {
        this(new BufferedReader(new FileReader(inputFile)));
    }

    /** This constructor is not supposed to be used by end users.
     * In this implementation, it will read enough data to fill the
     * initial storage. The storage will be increased only if more
     * data are requested.
     *
     * @param r a buffered stream to read data from
     */
    DataRecordDynArray(BufferedReader r) {
        super(r);

        numElements = 0;
        currentPos = 0;

        for (int i = 0; i < storage.length; i++) {
            storage[i] = super.loadDataRecord();
            if (storage[i] == null) break;
            numElements++;
        }
    }

    /** This method returns the first entry of the collection.
     * It is the implementation of the abstract method in the superclass.
     *
     * @see DataRecordCollection#first()
     * @return the first entry of the csv as a DataRecord
     */
    @Override
    public DataRecord first() {
        // delete the next line
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** This methods returns the next entry of the collection, reading more data
     * from the file if necessary.
     * It is the implementation of the abstract method in the superclass.
     *
     * @see DataRecordCollection#next()
     * @return the next entry as a DataRecord (may be null, if EOF reached)
     */
    @Override
    public DataRecord next() {
        // delete the next line
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** Checks if we have scanned through the entire collection.
     * It is the implementation of the abstract method in the superclass.
     *
     * @see DataRecordCollection#atEnd()
     * @return true if we have scanned all entries
     */
    @Override
    public boolean atEnd() {
        // delete the next line
        throw new UnsupportedOperationException("Not supported yet.");
    }

   /** This method returns the current number of entries read into the collection
     *
     * @return the number of entries read so far in the collection
     */
    @Override
    public int size() {
        // delete the next line
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
