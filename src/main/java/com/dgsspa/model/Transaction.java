package com.dgsspa.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class Transaction {
	private String processClientId;
	private String currStatus;
	private String targetStatus;

	@DynamoDbPartitionKey
	public String getProcessClientId() {
		return processClientId;
	}

	public void setProcessClientId(String processClientId) {
		this.processClientId = processClientId;
	}

	@DynamoDbSortKey
	public String getCurrStatus() {
		return currStatus;
	}

	public void setCurrStatus(String currStatus) {
		this.currStatus = currStatus;
	}

	public String getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(String targetStatus) {
		this.targetStatus = targetStatus;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"processClientId='" + processClientId + '\'' +
				", currStatus='" + currStatus + '\'' +
				", targetStatus='" + targetStatus + '\'' +
				'}';
	}
}
