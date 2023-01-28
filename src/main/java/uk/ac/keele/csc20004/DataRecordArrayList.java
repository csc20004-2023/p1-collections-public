/* **********************
 * CSC-20004 2022/23    *
 * Java Collections     *
 * **********************/
package uk.ac.keele.csc20004;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/** A concrete implementation of {@link DataRecordCollection} using an ArrayList
 * for internal storage.
 * The ArrayList class already provides automatic resizing, so this may well be a
 * thin wrapper over it.
 * Note however that (internally) ArrayList still uses an array, so resizing is
 * possibly just as costly as in DataRecordDynArray, save for more or less
 * efficient implementations.
 *
 * In addition to the implementation with an array, this class also provides a
 * sort() method.
 *
 * @author Marco Ortolani
 */
public class DataRecordArrayList extends DataRecordCollection {
    private final ArrayList<DataRecord> storage = new ArrayList<>();

    /** A public constructor, providing a concrete implementation for the one in
     * the abstract superclass.
     * The constructor just builds a buffered reader, and calls the other (non public)
     * constructor.
     *
     * @param inputFile the name of the file containing the csv data
     * @throws FileNotFoundException if the input file cannot be found/opened
     */
    public DataRecordArrayList(String inputFile) throws FileNotFoundException {
        this(new BufferedReader(new FileReader(inputFile)));
    }

    /** This constructor is not supposed to be used by end users.
     *
     * @param r a buffered stream to read data from
     */
    DataRecordArrayList(BufferedReader r) {
        super(r);

         /* YOUR CODE HERE */
         /* You may use super.loadDataRecord() from the superclass to read
            DataRecords from the csv file.
            You need to store such DataRecords in the 'storage' private field,
            increasing its size if necessary.
         */

        // delete the next line
        throw new UnsupportedOperationException("Not supported yet.");
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

    /** Sorts the entries of the collection according to a criterion specified
     * by the class {@link DataRecordComparator}
     *
     */
    public void sort() {
        // delete the next line
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
