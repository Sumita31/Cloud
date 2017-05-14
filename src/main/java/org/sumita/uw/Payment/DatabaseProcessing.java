package org.sumita.uw.Payment;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.math.BigDecimal;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DatabaseProcessing {
	
	public static void main(String[] args){
		String uid = "123";
		int cardno = 1234567890;
		System.out.println(verifyCard(uid, cardno));
	        	
	}
	public static String verifyCard(String uid, int cardno){
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_WEST_2).build();
		
		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("UserPaymentInfo");

		Item item = table.getItem("CardNo", cardno);
		if(item == null)
			return "Invalid Card No";
//		BigDecimal bi_uid = new BigDecimal(uid);
		String userid = (String)item.get("UserId");
		if(uid.equals(userid)){
			return "Payement was successful";
		} else return "Card number doesn't belong to the user";
	}
}
