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
    public DataRecordArrayList(String inputFile) throws FileNotFoundException {
        this(new BufferedReader(new FileReader(inputFile)));
    }

    /** This constructor is not supposed to be used by end users.
     *
     * @param r a buffered stream to read data from
     */
    DataRecordArrayList(BufferedReader r) {
        super(r);

        currentPos = 0;
        DataRecord dr = super.loadDataRecord();
        if (dr != null) {
            storage.add(dr);
            currentPos++;
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
      currentPos = 0;
      if (storage.isEmpty()) {
          return null;
      } else {
          return storage.get(currentPos++);
      }
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
      if (currentPos < storage.size()) {
          return storage.get(currentPos++);
      } else {
          DataRecord dr = super.loadDataRecord();

          if (dr != null) {
              currentPos++;

              storage.add(dr);
          }

          return dr;
      }
    }

    /** Checks if we have scanned through the entire collection.
     * It is the implementation of the abstract method in the superclass.
     *
     * @see DataRecordCollection#atEnd()
     * @return true if we have scanned all entries
     */
    @Override
    public boolean atEnd() {
      // we need to trigger a data load, to check if we have reached the end
      DataRecord dr = super.loadDataRecord();
      if (dr != null) {
          // do NOT update counter, as it is not actually "read"
          storage.add(dr);
      }

      if (super.dataAvailable()) {
          return false;
      } else {
          return (currentPos >= storage.size());
      }
    }

   /** This method returns the current number of entries read into the collection
     *
     * @return the number of entries read so far in the collection
     */
    @Override
    public int size() {
      return storage.size();
    }
}
