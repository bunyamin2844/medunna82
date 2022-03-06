package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseStepDefinitions {

    @Given("user connects to the database")
    public void user_connects_to_the_database() {


        DBUtils.createConnection();
    }

    @Given("user gets the {string} from {string} table")
    public void user_gets_the_from_table(String column, String table) {
//        Select * from tp_customer;
        String myDynamicQuery = "Select "+column+" from "+table;
        DBUtils.executeQuery(myDynamicQuery);
    }

    @Given("user reads all of the {string} column data")
    public void user_reads_all_of_the_column_data(String column) throws SQLException {
//        next() takes us to the next row
        DBUtils.getResultset().next();
//        I am on row 1
//        This gives me the single object on that row
        Object columnData = DBUtils.getResultset().getObject(column);
        System.out.println(columnData);//123-34-3434

//        Going to the next row
        DBUtils.getResultset().next();
//        Getting the data on that row
        Object columnData2=DBUtils.getResultset().getObject(column);
        System.out.println(columnData2);//823-25-7239

//        Going to the next row
        DBUtils.getResultset().next();
        Object columnData3=DBUtils.getResultset().getObject(column);
        System.out.println(columnData3);//761-59-2911

        while(DBUtils.getResultset().next()){//If there is next row data, then get in the loop
            Object eachColumnData=DBUtils.getResultset().getObject(column);
            System.out.println(eachColumnData);
        }

    }

    @Then("close the database connection")
    public void close_the_database_connection() {
        DBUtils.closeConnection();
    }


    @Given("verify {string} table {string} column contains {string} data")
    public void verify_table_column_contains_data(String table, String column, String data) {

//        get the list of column data
//        getColumnData @return list of values of a single column from the result set
        List<Object> allColumnData= DBUtils.getColumnData("select * from "+table,column);
        System.out.println(allColumnData);//prints all columns data

//        add our expected data in a list
        List<Object> expectedData = new ArrayList<>();
        expectedData.add(data);

//        then compare the objects
        Assert.assertTrue(allColumnData.containsAll(expectedData));

    }

    @Given("verify the row count")
    public void verify_the_row_count() throws Exception {
        int rowCount = DBUtils.getRowCount();
        System.out.println("Table Row Count : "+rowCount);
    }
    @Given("verify the column names of {string} table")
    public void verify_the_column_names_of_table(String table) {
        System.out.println("Table Column Names : "+DBUtils.getColumnNames("select * from "+table));
    }
}
