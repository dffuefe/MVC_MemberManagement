//데이터베이스의 data에 접근하기 위한 객체
import java.sql.*;
import java.util.Vector;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Member_DAO {
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/mydb";
    private static final String PASS = "system";
    private static final String USER = "root";

    Member_List mList;

    public Connection getConn(){
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USER,PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public MemberDTO getMemberDTO(String id){
        MemberDTO dto = new MemberDTO();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            con = getConn();
            //Prepared Statement 가독성이 좋고 보안서이 뛰어남
            String sql = "SELECT * FROM th_member WHERE id=?";
            ps= con.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();

            if(rs.next()){
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("Pwd"));
                dto.setName(rs.getString("Name"));
                dto.setTel(rs.getString("tel"));
                dto.setAddr(rs.getString("addr"));
                dto.setBirth(rs.getString("birth"));
                dto.setJob(rs.getString("job"));
                dto.setGender(rs.getString("gender"));
                dto.setEmail(rs.getString("email"));
                dto.setIntro(rs.getString("intro"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    public Vector getMemberList(){
        Vector data = new Vector();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            con = getConn();
            ////Prepared Statement 가독성이 좋고 보안성이 뛰어남
            String sql = "SELECT * FROM tb_member";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            while(rs.next()){//rs에 저장된 데이터를 한 행씩 불러온다
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String addr = rs.getString("addr");
                String birth = rs.getString("birth");
                String job = rs.getString("job");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String intro = rs.getString("intro");

                Vector row = new Vector();
                row.add(id);
                row.add(pwd);
                row.add(name);
                row.add(tel);
                row.add(addr);
                row.add(birth);
                row.add(job);
                row.add(gender);
                row.add(email);
                row.add(intro);

                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean insertMember(MemberDTO dto){//dto를 통해 값을 받는구나
        boolean ok = false;

        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = getConn();
            String sql = "INSERT INTO tb_member(id, pwd, name, tel, addr, birth, job, gender, email, intro)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getTel());
            ps.setString(5, dto.getAddr());
            ps.setString(6, dto.getBirth());
            ps.setString(7, dto.getJob());
            ps.setString(8, dto.getGender());
            ps.setString(9, dto.getEmail());
            ps.setString(10, dto.getIntro());

            int r = ps.executeUpdate();

            if(r > 0){
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean updateMember(MemberDTO vMem){//dto를 통해 값을 받는구나
        boolean ok = false;

        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = getConn();
            String sql = "UPDATE tb_member SET name=?, tel=?, addr=?, birth=?, job=?, gender=?, email=?, intro=?"
                    + "WHERE id=? AND pwd=?";

            ps = con.prepareStatement(sql);
            ps.setString(1, vMem.getName());
            ps.setString(2, vMem.getTel());
            ps.setString(3, vMem.getAddr());
            ps.setString(4, vMem.getBirth());
            ps.setString(5, vMem.getJob());
            ps.setString(6, vMem.getGender());
            ps.setString(7, vMem.getEmail());
            ps.setString(8, vMem.getIntro());
            ps.setString(9, vMem.getId());
            ps.setString(10, vMem.getPwd());


            int r = ps.executeUpdate();

            if(r > 0){
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean deleteMember(String id, String pwd){
        boolean ok = false;

        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = getConn();
            String sql = "DELETE FROM tb_member WHERE id=? AND pwd=?";

            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);

            int r = ps.executeUpdate();

            if(r > 0){
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }
}
