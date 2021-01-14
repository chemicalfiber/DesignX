package com.gdkm.po;

public class News {
   private Integer newsId;  //ID
   private NewsColumn newsColumn; //新闻关联栏目
   private String title;   //标题
   private String message;   //新闻详细
   private String account;   //发布人账号
   private Integer num;   //阅读次数
   private String createTime;   //发布时间
   private String pic;   //图片地址
   private String appendix;   //附件地址
   private String video;   //视频地址
   private Integer start;   //分页起始行
   private Integer rows;   //每行页数
public Integer getNewsId() {
	return newsId;
}
public void setNewsId(Integer newsId) {
	this.newsId = newsId;
}
public NewsColumn getNewsColumn() {
	return newsColumn;
}
public void setNewsColumn(NewsColumn newsColumn) {
	this.newsColumn = newsColumn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public String getAppendix() {
	return appendix;
}
public void setAppendix(String appendix) {
	this.appendix = appendix;
}
public String getVideo() {
	return video;
}
public void setVideo(String video) {
	this.video = video;
}
public Integer getStart() {
	return start;
}
public void setStart(Integer start) {
	this.start = start;
}
public Integer getRows() {
	return rows;
}
public void setRows(Integer rows) {
	this.rows = rows;
}
@Override
public String toString() {
	return "News [newsId=" + newsId + ", newsColumn=" + newsColumn + ", title=" + title + ", message=" + message
			+ ", account=" + account + ", num=" + num + ", createTime=" + createTime + ", pic=" + pic + ", appendix="
			+ appendix + ", video=" + video + ", start=" + start + ", rows=" + rows + "]";
}
   
}
