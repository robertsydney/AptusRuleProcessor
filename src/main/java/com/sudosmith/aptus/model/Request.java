package com.sudosmith.aptus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "request_log")
@NamedQueries({
@NamedQuery(name = "findRequestByCommonSearch", query = "SELECT request FROM Request request WHERE request.requestId= :queryString"),
@NamedQuery(name = "findRequestByRequestIdResponse", query = "SELECT request FROM Request request WHERE request.requestId= :queryString1 AND request.responseRecieved = :queryString2"),
@NamedQuery(name = "findRequestByRequestIdInterrupt", query = "SELECT request FROM Request request WHERE request.requestId= :queryString1 AND request.interrupt = :queryString2"),
@NamedQuery(name="findAllRequestsByPaging" , query="from Request")
})
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3784744836763917275L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "request_id")
	private String requestId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "queue_name")
	private String queueName;

	@Column(name = "request_produced_at")
	private String requestProducedAt;

	@Column(name = "request_recieved_at")
	private String requestRecievedAt;

	@Column(name = "response_recieved")
	private boolean responseRecieved;
	
	@Column(name = "interrupt")
	private boolean interrupt;	
	
	public Request() {

	}

	public Request(int id, String requestId, int eventId, String queueName,
			String requestProducedAt, String requestRecievedAt,
			boolean responseRecieved, boolean interrupt) {
		super();
		this.id = id;
		this.requestId = requestId;
		this.eventId = eventId;
		this.queueName = queueName;
		this.requestProducedAt = requestProducedAt;
		this.requestRecievedAt = requestRecievedAt;
		this.responseRecieved = responseRecieved;
		this.interrupt = interrupt;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the queueName
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * @param queueName the queueName to set
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	/**
	 * @return the requestProducedAt
	 */
	public String getRequestProducedAt() {
		return requestProducedAt;
	}

	/**
	 * @param requestProducedAt the requestProducedAt to set
	 */
	public void setRequestProducedAt(String requestProducedAt) {
		this.requestProducedAt = requestProducedAt;
	}

	/**
	 * @return the requestRecievedAt
	 */
	public String getRequestRecievedAt() {
		return requestRecievedAt;
	}

	/**
	 * @param requestRecievedAt the requestRecievedAt to set
	 */
	public void setRequestRecievedAt(String requestRecievedAt) {
		this.requestRecievedAt = requestRecievedAt;
	}

	/**
	 * @return the responseRecieved
	 */
	public boolean isResponseRecieved() {
		return responseRecieved;
	}

	/**
	 * @param responseRecieved the responseRecieved to set
	 */
	public void setResponseRecieved(boolean responseRecieved) {
		this.responseRecieved = responseRecieved;
	}

	/**
	 * @return the interrupt
	 */
	public boolean isInterrupt() {
		return interrupt;
	}

	/**
	 * @param interrupt the interrupt to set
	 */
	public void setInterrupt(boolean interrupt) {
		this.interrupt = interrupt;
	}
	

}
