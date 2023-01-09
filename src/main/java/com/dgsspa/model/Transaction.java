package com.dgsspa.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class Transaction {
	@Override
	public String toString() {
		return "Transaction{" +
				"process_id='" + process_id + '\'' +
				", client_id='" + client_id + '\'' +
				", curr_status='" + curr_status + '\'' +
				", target_status='" + target_status + '\'' +
				'}';
	}

	private String process_id;
	
	private String client_id;
	
	private String curr_status;
	private String target_status;

	@DynamoDbPartitionKey
	public String getProcess_id() {
		return process_id;
	}

	public void setProcess_id(String process_id) {
		this.process_id = process_id;
	}

	@DynamoDbSortKey
	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String clieent_id) {
		this.client_id = clieent_id;
	}

	public String getCurr_status() {
		return curr_status;
	}

	public void setCurr_status(String curr_status) {
		this.curr_status = curr_status;
	}

	public String getTarget_status() {
		return target_status;
	}

	public void setTarget_status(String target_status) {
		this.target_status = target_status;
	}


}
