package model.vo;

public class FavoritesVo {
	int f_idx;
	String coTitle;
	String coId;
	int coView;
	String coText;
	String coPhoto1;
	String coPhoto2;
	String coPhoto3;
	
	
	
	public String getCoPhoto1() {
		return coPhoto1;
	}



	public void setCoPhoto1(String coPhoto1) {
		this.coPhoto1 = coPhoto1;
	}



	public String getCoPhoto2() {
		return coPhoto2;
	}



	public void setCoPhoto2(String coPhoto2) {
		this.coPhoto2 = coPhoto2;
	}



	public String getCoPhoto3() {
		return coPhoto3;
	}



	public void setCoPhoto3(String coPhoto3) {
		this.coPhoto3 = coPhoto3;
	}



	public FavoritesVo() {
		super();
	}



	public FavoritesVo(int f_idx, String coTitle, String coId, int coView, String coText) {
		super();
		this.f_idx = f_idx;
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



	public int getF_idx() {
		return f_idx;
	}



	public void setF_idx(int f_idx) {
		this.f_idx = f_idx;
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
