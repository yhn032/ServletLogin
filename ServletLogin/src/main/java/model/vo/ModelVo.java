package model.vo;

public class ModelVo {


	public class memberVo {

		String id;
		String pwd;
		String name;
		String nickname;
		String birth;
		String tel;
		String email;
		String question;
		String answer;
		
		public memberVo() {
			
		}

		public memberVo(String id, String pwd, String name, String nickname, String birth, String tel, String email,
				String question, String answer) {
			super();
			this.id = id;
			this.pwd = pwd;
			this.name = name;
			this.nickname = nickname;
			this.birth = birth;
			this.tel = tel;
			this.email = email;
			this.question = question;
			this.answer = answer;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getBirth() {
			return birth;
		}

		public void setBirth(String birth) {
			this.birth = birth;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}
		
		
		
		
		
	}

}
