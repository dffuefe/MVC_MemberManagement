//Data Transfer Object :계층 간 데이터 교환을 하기 위해 사용하는 객체로,
// 로직을 가지지 않는 순수한 데이터 객체, 여기서는 데이터에 접근하기 위한 회원 한명의 정보 저장
public class MemberDTO {
    private String id;
    private String pwd;
    private String name;
    private String tel;
    private String addr;
    private String birth;
    private String job;
    private String gender;
    private String email;
    private String intro;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    public String getName(){
        return name;
    }

    public void setName(String  name){
        this.name = name;
    }
    public String getTel(){
        return tel;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
    public String getAddr(){
        return addr;
    }

    public void setAddr(String addr){
        this.addr = addr;
    }
    public String getBirth(){
        return birth;
    }

    public void setBirth(String birth){
        this.birth = birth;
    }

    public String getJob(){
        return job;
    }

    public void setJob(String job){
        this.job = job;
    }
    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getIntro(){
        return email;
    }

    public void setIntro(String intro){
        this.intro = intro;
    }
}
