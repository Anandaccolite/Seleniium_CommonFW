package framework.common;

import java.io.File;
import java.io.FileReader;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import framework.listeners.Logs;

public class RestUtilities extends CommonUtilties {

	public JSONObject get(String restUrl, boolean Authflag, String userName, String password) throws Exception

	{
		Client client = Client.create();
		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();

		WebResource webResource = client.resource(restUrl);

		if (Authflag)
			client.addFilter(new HTTPBasicAuthFilter(userName, password));

		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);
		Object obj = parser.parse(output);
		jsonObject = (JSONObject) obj;
		Logs.log(jsonObject + "");
		return jsonObject;

	}

	public JSONObject post(String restUrl, JSONObject payload, boolean authflag, String userName, String password)
			throws Exception

	{
		Logs.log("restUrl*****" + restUrl);
		Logs.log("payload*****" + payload);

		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();

		Client client = Client.create();
		WebResource webResource = client.resource(restUrl);
		if (authflag)
			client.addFilter(new HTTPBasicAuthFilter(userName, password));

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, payload.toString());

		String output = response.getEntity(String.class);
		Object obj = parser.parse(output);
		jsonObject = (JSONObject) obj;
		Logs.log(jsonObject + "");
		return jsonObject;
	}

	public JSONObject getPayloadAsJsonfromFile(String payloadFileName) {

		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			String path = new File("./Payloads/" + payloadFileName).getCanonicalPath();
			Object obj = parser.parse(new FileReader(path));
			jsonObject = (JSONObject) obj;
			Logs.log(jsonObject + "");

		} catch (Throwable e) {
			Logs.log(e.getMessage());
		}
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	public JSONObject addorupdateJsonObject(JSONObject json, HashMap<String, Object> map) {
		for (String key : map.keySet())
			json.put(key, map.get(key));
		Logs.log("updated json object" + json.toString());
		return json;
	}

}
