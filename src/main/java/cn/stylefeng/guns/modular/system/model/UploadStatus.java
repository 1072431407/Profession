package cn.stylefeng.guns.modular.system.model;

public class UploadStatus {
	private Integer code;
	private String imageUrl;
	
	public UploadStatus(){}
	
	public UploadStatus(Integer code, String imageUrl) {
		super();
		this.code = code;
		this.imageUrl = imageUrl;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
