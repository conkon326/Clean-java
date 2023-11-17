package modelPack;

import java.sql.Timestamp;

public class BbsEntity {

	private int threadId;
	private String speaker;
	private String comment;
	private Timestamp ymdhms;

	public BbsEntity(int threadId, String speaker, String comment, Timestamp ymdhms) {
		this.threadId = threadId;
		this.speaker = speaker;
		this.comment = comment;
		this.ymdhms = ymdhms;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getYmdhms() {
		return ymdhms;
	}

	public void setYmdhms(Timestamp ymdhms) {
		this.ymdhms = ymdhms;
	}

}
