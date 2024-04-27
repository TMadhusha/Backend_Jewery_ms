package jwl.mis.jewelry_ms.model;

import jakarta.persistence.*;

@Entity
public class Attendance {
    //fields
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
//    @SequenceGenerator(name = "id_seq", sequenceName = "id_sequence", allocationSize = 1)
    private Long att_id;
    private String emp_id;
    private String month;
    private String date;
    private String check_In;
    private String check_Out;

    //getter and setter


    public Long getAtt_id() {
        return att_id;
    }

    public void setAtt_id(Long att_id) {
        this.att_id = att_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheck_In() {
        return check_In;
    }

    public void setCheck_In(String check_In) {
        this.check_In = check_In;
    }

    public String getCheck_Out() {
        return check_Out;
    }

    public void setCheck_Out(String check_Out) {
        this.check_Out = check_Out;
    }

}

