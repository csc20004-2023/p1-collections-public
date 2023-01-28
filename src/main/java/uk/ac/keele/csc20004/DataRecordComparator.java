/* **********************
 * CSC-20004 2022/23    *
 * Java Collections     *
 * **********************/
package uk.ac.keele.csc20004;

import java.util.Comparator;

/** A DataRecordComparator implements the Comparator interface and provides
 * the compare() method. The comparison is performed according to the
 * criteria specified in the assignment.
 *
 * @author Marco Ortolani
 */
public class DataRecordComparator implements Comparator<DataRecord> {

    /** The comparison will be first compare the 'pair' field, then
     * the 'warning', then 'period' and finally 'speed'.
     * Each comparison returns 1 if the first field is "greater" than the second,
     * and -1 otherwise.
     * If the two objects to be compared are "equal" for the specified criterion,
     * 0 is returned.
     *
     * @param a first DataRecord to compare
     * @param b second DataRecord to compare
     * @return a negative value (e.g. -1) to represent that record a is 
     * "less than" record b, a positive value (e.g. 1) represent that record a 
     * is "greater than" record b, or 0 if the two records are to be considered 
     * equal
     */
    @Override
    public int compare(DataRecord a, DataRecord b) {
        // implement your code for comaprison here
        return 0;
    }

}
