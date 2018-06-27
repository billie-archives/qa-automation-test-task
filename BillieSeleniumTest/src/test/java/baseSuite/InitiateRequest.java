package baseSuite;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;



public class InitiateRequest {
	StringBuffer result;
	HttpClient client;
	String url="https://jsonplaceholder.typicode.com/comments";
	HttpGet request;
	HttpResponse response;
	ArrayList<JSONObject> listOfElements;
	int count=0;
	JSONArray ja;
	boolean criteria2=false;
	boolean criteria3=false;
	
	@SuppressWarnings("deprecation")
	public InitiateRequest() throws ClientProtocolException, IOException{

	result=new StringBuffer();
	client=new DefaultHttpClient();
	request=new HttpGet(url);
	response=client.execute(request);
	}

	public boolean getRequest(){
		
		int responseCode=response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		
		try{
		if(responseCode==200)
			
		{
			System.out.println("Get Response is Successfull");
			String result = EntityUtils.toString(response.getEntity());
			ja = new JSONArray(result.trim());
			criteria2=true;
		}
	}
		catch(Exception e){
		e.printStackTrace();
		}

		return criteria2;
		
	}

	public boolean validateResponse(){
		for(int countArray=0;countArray<ja.length();countArray++){
			if(ja.getJSONObject(countArray).get("postId").equals(40)){
				count= count+1;
				if(ja.getJSONObject(countArray).get("id").equals(199)){
					 Assert.assertEquals(ja.getJSONObject(countArray).get("id"), 199);
					 Assert.assertEquals(ja.getJSONObject(countArray).get("name"), "pariatur aspernatur nam atque quis");
					 Assert.assertEquals(ja.getJSONObject(countArray).get("email"), "Cooper_Boehm@damian.biz");
					 Assert.assertEquals(ja.getJSONObject(countArray).get("body"), "veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla");
					System.out.println("Criteria 3 : Make sure that post with id 40 contains the following comment: VERIFIED");
					criteria3=true;
				}
			}
		}
		if(count==5){
			System.out.println("Criteria 2 : Make sure that post with id 40 contains 5 comments : VERIFIED");
			criteria2=true;
		}
		if(criteria2 && criteria3)
			return true;
		else
			return false;
	}
}