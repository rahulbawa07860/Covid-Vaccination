package com.masai.Exceptions;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class MyErrorDetails {
private LocalDateTime timeStamp;
private String msg;
private String details;
public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}


}
