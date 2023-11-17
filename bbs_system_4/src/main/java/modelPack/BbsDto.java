package modelPack;

public class BbsDto {

	private int threadId;
	private String content;
	private int count;

	public BbsDto(int threadId, String content, int count) {
		this.threadId = threadId;
		this.content = content;
		this.count = count;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
