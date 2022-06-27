import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

//회원 리스트 출력 GUI
@SuppressWarnings({"serial", "rawtypes", "unused", "unchecked"})
public class Member_List extends JFrame implements MouseListener, ActionListener {

    Vector v;
    Vector cols;
    DefaultTableModel model;
    JTable jTable;
    JScrollPane pane;
    JPanel pbtn;
    JButton btnInsert;

    public Member_List(){
        super("회원관리 프로그램");
        Member_DAO dao = new Member_DAO();
        v = dao.getMemberList();
        cols = getColmn();

        model = new DefaultTableModel(v, cols){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        jTable = new JTable(model);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setResizingAllowed(false);
        pane = new JScrollPane(jTable);
        add(pane);

        pbtn = new JPanel();
        btnInsert = new JButton("회원가입");
        pbtn.add(btnInsert);
        add(pbtn, BorderLayout.SOUTH);

        jTable.addMouseListener(this);
        btnInsert.addActionListener(this);

        setSize(600,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Vector getColmn() {
        Vector col = new Vector();
        col.add("아이디");
        col.add("비밀번호");
        col.add("이름");
        col.add("전화");
        col.add("주소");
        col.add("생일");
        col.add("직업");
        col.add("성별");
        col.add("이메일");
        col.add("자기소개");

        return col;
    }

    public void jTableRefresh(){
        Member_DAO dao = new Member_DAO();
        DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColmn());
        jTable.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnInsert){
            new MemberProc(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
