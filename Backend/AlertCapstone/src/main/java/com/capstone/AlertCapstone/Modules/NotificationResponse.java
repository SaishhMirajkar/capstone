package com.capstone.AlertCapstone.Modules;
public class NotificationResponse {
    private String request;
    private String payout;
    private String streams;
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getPayout() {
		return payout;
	}
	public void setPayout(String payout) {
		this.payout = payout;
	}
	public String getStreams() {
		return streams;
	}
	public void setStreams(String streams) {
		this.streams = streams;
	}
	@Override
	public String toString() {
		return "NotificationResponse [request=" + request + ", payout=" + payout + ", streams=" + streams + "]";
	}
    
}
