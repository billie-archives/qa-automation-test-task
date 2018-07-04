/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import com.mycompany.rest_task_comments.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author a.bahgat
 */
public class Get_TestCases {

    public static String url = "https://jsonplaceholder.typicode.com/comments";
    public static ResponseDto[] mapResponse;

    public Get_TestCases() {
    }

    @Test
    public static void Test_PostId_40_IsExist_5Times() {
        //Call API @BeforeClass        
        int idExistCount = 0;
        // Check how many times there is a post with Id 40
        for (ResponseDto node : mapResponse) {
            if (node.postId.equals("40")) {
                idExistCount++;
            }
        }
        assertEquals(idExistCount, 5, "Post Id [ 40 ] is exist " + idExistCount + "time Not [5] as expected");
    }

    @Test
    public static void Test_PostWithId_40_IsExist_5Times() {
        //Call API @BeforeClass        
        int idExistCount = 0;
        // Check how many times there is a post with Id 40
        for (ResponseDto node : mapResponse) {
            if (node.id.equals("40")) {
                idExistCount++;
            }
        }
        assertEquals(idExistCount, 5, "Post Id [ 40 ] is exist " + idExistCount + "time Not [5] as expected");
    }
    
    @Test
    public static void Test_PostWithId_40_include_5_CommentsInBody() {
        //Call API @BeforeClass
        // Check that Body of Post with Id=40 include 5 comments seperated with "/n"
        for (ResponseDto node : mapResponse) {
            if (node.id.equals("40")) {
                String[] comments = node.body.split("\n");
                assertEquals(comments.length, 5, "There are [" + comments.length + "] comment in Body not 5 as expected");
                break;
            }
        }
    }

    @Test
    public static void Test_PostId_40_includespecificData() {
        //Call API @BeforeClass
        int dataMatchedCount = 0;
        // Check how many times there is a post with Id 40
        for (ResponseDto node : mapResponse) {
            System.out.print(node.id);
            if (node.postId.equals("40")) {
                if (node.name.equals("pariatur aspernatur nam atque quis")) {
                    if (node.email.equals("Cooper_Boehm@damian.biz")) {
                        if (node.body.equals("veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla")) {
                            dataMatchedCount++;
                        }
                    }
                }
            }
        }
        assertTrue(dataMatchedCount >= 1, "Data is Not Matched with any Comment");
    }

    @Test
    public static void Test_PostWithId_40_includespecificName() {
        //Call API @BeforeClass
        // Check that Post that Id =40 has specific name
        for (ResponseDto node : mapResponse) {
            if (node.id.equals("40")) {
                assertEquals(node.name, "pariatur aspernatur nam atque quis", "Name at Id=40 is Not as Expected");
            }
        }
    }

    @Test
    public static void Test_PostWithId_40_includespecificEmail() {
        //Call API @BeforeClass
        // Check that Post that Id =40 has specific Email
        for (ResponseDto node : mapResponse) {
            if (node.id.equals("40")) {
                assertEquals(node.email, "Cooper_Boehm@damian.biz", "Email at Id=40 is Not as Expected");
            }
        }
    }

    @Test
    public static void Test_PostWithId_40_includespecificBody() {
        //Call API @BeforeClass
        // Check that Post that Id =40 has specific Body
        
        for (ResponseDto node : mapResponse) {
            if (node.id.equals("40")) {
                assertEquals(node.body, "veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla", "Body at Id=40 is Not as Expected");
            }
        }
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //Call API before Class
        String response = new HttpClient().GetAPI(url);
        //Deserialize Response to Array of Object
        mapResponse = new Gson().fromJson(response, ResponseDto[].class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
