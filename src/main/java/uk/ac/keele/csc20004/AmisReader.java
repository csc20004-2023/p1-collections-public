/* **********************
 * CSC-20004 2022/23    *
 * Java Collections     *
 * **********************/
package uk.ac.keele.csc20004;

import java.io.FileNotFoundException;

/** A use case for our data structures.
 * The class implements only a main method that reads in the
 * csv file, stores internally using DataRecordDynArray, and
 * then prints out its contents.
 * Once you provide the second implementation
 *
 * @author Marco Ortolani
 */
public class AmisReader {
    public static final String SOURCE_FILE_NAME = "./amis.csv";

    public static void main(String[] args) {
        try {
            DataRecordCollection datacoll = new DataRecordDynArray(SOURCE_FILE_NAME);
            /* Change this line as follows to test your alternative implementation */
            // DataRecordCollection datacoll = new DataRecordArrayList(SOURCE_FILE_NAME);

            DataRecord dr = datacoll.first();
            System.out.println("Record: " + dr.toString());

            while(!datacoll.atEnd()) {
              dr = datacoll.next();
              System.out.println("Record: " + dr.toString());
            }
        } catch(FileNotFoundException e) {
            System.out.println("I can't read data file: " +
                    SOURCE_FILE_NAME);
            System.out.println("Your working directory is: " +
                    System.getProperty("user.dir"));

            System.out.println("Giving up.");
        } catch (Exception e) {
            // any opther exception, we just dump the trace on standard output
            e.printStackTrace(System.out);
        }
    }
}
