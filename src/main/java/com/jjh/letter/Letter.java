package com.jjh.letter;

public class Letter {
	String letterId; // 편지 번호
	String title; // 제목
	String content; // 내용
	String senderId; // 보내는 사람 ID
	String senderName; // 보내는 사람 이름
	String receiverId; // 받는 사람 ID
	String receiverName; // 받는 사람 이름
	String cdate; // 보낸 시간
	
	public String getLetterId() {
		return letterId;
	}
	public void setLetterId(String letterId) {
		this.letterId = letterId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	public String getContentHtml() {
		if (content != null)
			return content.replace("\n", "<br/>");
		return null;
	}
	
	@Override
	public String toString() {
		return "Letter [letterId=" + letterId + ", title=" + title + ", content=" + content + ", senderId=" + senderId
				+ ", senderName=" + senderName + ", receiverId=" + receiverId + ", receiverName=" + receiverName
				+ ", cdate=" + cdate + ", getLetterId()=" + getLetterId() + ", getTitle()=" + getTitle()
				+ ", getContent()=" + getContent() + ", getSenderId()=" + getSenderId() + ", getSenderName()="
				+ getSenderName() + ", getReceiverId()=" + getReceiverId() + ", getReceiverName()=" + getReceiverName()
				+ ", getCdate()=" + getCdate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
