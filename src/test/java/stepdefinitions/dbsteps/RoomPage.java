package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class RoomPage {
    List<Object> AllNumber;
    @Given("user connects to the databases")
    public void user_connects_to_the_databases() {
        DBUtils.createConnection();
    }
    @Given("user get the {string} from {string} table")
    public void user_get_the_from_table(String room_number, String room) {
        List<Object> AllNumber = DBUtils.getColumnData("select * from"+" "+room ,room_number);

    }
    @Given("verify {string} table {string} column contain {string} data")
    public void verify_table_column_contain_data(String table, String column, String data) {

        List<Object> AllNumber = DBUtils.getColumnData("select * from"+" "+ table ,column);

        System.out.println(AllNumber);

        List<Object> expecteddata = new ArrayList<>();
        expecteddata.add(data);

       Assert.assertTrue(AllNumber.contains(expecteddata));

    }


    @Then("closes the databases connections")
    public void closesTheDatabasesConnections() {
        DBUtils.closeConnection();
    }
}
