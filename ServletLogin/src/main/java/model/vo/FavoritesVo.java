package model.vo;

public class FavoritesVo {
	int idx;
	String coTitle;
	String coId;
	int coView;
	String coText;
	
	
	
	public FavoritesVo() {
		super();
	}



	public FavoritesVo(int idx, String coTitle, String coId, int coView, String coText) {
		super();
		this.idx = idx;
		this.coTitle = coTitle;
		this.coId = coId;
		this.coView = coView;
		this.coText = coText;
	}



	public String getCoText() {
		return coText;
	}



	public void setCoText(String coText) {
		this.coText = coText;
	}



	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getCoTitle() {
		return coTitle;
	}



	public void setCoTitle(String coTitle) {
		this.coTitle = coTitle;
	}



	public String getCoId() {
		return coId;
	}



	public void setCoId(String coId) {
		this.coId = coId;
	}



	public int getCoView() {
		return coView;
	}



	public void setCoView(int coView) {
		this.coView = coView;
	}
	
	
}
