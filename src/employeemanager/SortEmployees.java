//Packages
package employeemanager;

//Imports
import java.util.Comparator;

//Start of class
public class SortEmployees implements Comparator<Employee> {

    //Override methods
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
    }
}
