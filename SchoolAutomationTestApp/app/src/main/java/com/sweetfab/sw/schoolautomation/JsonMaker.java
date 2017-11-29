package com.sweetfab.sw.schoolautomation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mskan on 2017-10-12.
 */

public class JsonMaker {
	String json1 = "{\n" +
			"  \"session\": {\n" +
			"    \"new\": true,\n" +
			"    \"sessionId\": \"SessionId.f7ad620c-978a-47ff-b338-6fce0c59b345\",\n" +
			"    \"application\": {\n" +
			"      \"applicationId\": \"amzn1.ask.skill.123729bb-588b-4dbc-a9ff-9213e7ef89d1\"\n" +
			"    },\n" +
			"    \"attributes\": {},\n" +
			"    \"user\": {\n" +
			"      \"userId\": \"amzn1.ask.account.AES2ANGH7QMF7Q4MKTCKR2STOVAEKEIW5LSSPIYAKSGVFLDNPK6ZR2DB3ODT43GTHDI74C33DETY7SWJ5H5R7UYK5QUQFF7DOSZ7U6ZYO4ZI7XI2ARW4AIP2DZ47ZV5KFEAVSHA5IC7LP5I3LE6N2TVGKGE3X25U5V7ZMM2G4T4RGWD7KWKL6ZSRHTW6ADU4UHVHF4AODC7S7DQ\"\n" +
			"    }\n" +
			"  },\n" +
			"  \"request\": {\n" +
			"    \"type\": \"IntentRequest\",\n" +
			"    \"requestId\": \"EdwRequestId.dd12cfda-045d-4043-b41b-e6b74af1ff22\",\n" +
			"    \"intent\": {\n" +
			"      \"name\": \"";
	String json2 = "\",\n" +
			"      \"slots\": {}\n" +
			"    },\n" +
			"    \"locale\": \"en-US\",\n" +
			"    \"timestamp\": \"";
	String json3 = "\"\n" +
			"  },\n" +
			"  \"context\": {\n" +
			"    \"AudioPlayer\": {\n" +
			"      \"playerActivity\": \"IDLE\"\n" +
			"    },\n" +
			"    \"System\": {\n" +
			"      \"application\": {\n" +
			"        \"applicationId\": \"amzn1.ask.skill.123729bb-588b-4dbc-a9ff-9213e7ef89d1\"\n" +
			"      },\n" +
			"      \"user\": {\n" +
			"        \"userId\": \"amzn1.ask.account.AES2ANGH7QMF7Q4MKTCKR2STOVAEKEIW5LSSPIYAKSGVFLDNPK6ZR2DB3ODT43GTHDI74C33DETY7SWJ5H5R7UYK5QUQFF7DOSZ7U6ZYO4ZI7XI2ARW4AIP2DZ47ZV5KFEAVSHA5IC7LP5I3LE6N2TVGKGE3X25U5V7ZMM2G4T4RGWD7KWKL6ZSRHTW6ADU4UHVHF4AODC7S7DQ\"\n" +
			"      },\n" +
			"      \"device\": {\n" +
			"        \"supportedInterfaces\": {}\n" +
			"      }\n" +
			"    }\n" +
			"  },\n" +
			"  \"version\": \"1.0\"\n" +
			"}";
	public String getJsonData(String command){
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh-mm-ss");
		Date date = new Date();
		String timestamp = dateFormat1.format(date) + "T" + dateFormat2.format(date) + "Z";
		return (json1 + command + json2 + timestamp + json3);
	}
}
