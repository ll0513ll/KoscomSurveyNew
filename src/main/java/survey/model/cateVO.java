package survey.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cateVO {

	private int cateNo;
	private String cateName;
	private String cateInfo;
	

	public cateVO() {

	}


	public cateVO(int cateNo, String cateName, String cateInfo) {
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.cateInfo = cateInfo;
	}


	public int getCateNo() {
		return cateNo;
	}


	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}


	public String getCateName() {
		return cateName;
	}


	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public String getCateInfo() {
		return cateInfo;
	}


	public void setCateInfo(String cateInfo) {
		this.cateInfo = cateInfo;
	}


	@Override
	public String toString() {
		return "cateVO [cateNo=" + cateNo + ", cateName=" + cateName + ", cateInfo=" + cateInfo + "]";
	}


	
}