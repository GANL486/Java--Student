/*
* 功能：添加学生成绩功能实现
*
* */
package com.roadjava.student.view;

import com.roadjava.entity.StudentDO;
import com.roadjava.handler.AddStudentViewHandler;
import com.roadjava.service.StudentService;
import com.roadjava.service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class AddStudentView extends JDialog {
    //添加学生界面设计
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20)); //设置水平间距10，垂直间距20
    JLabel nameLabel = new JLabel("姓名",JLabel.RIGHT);
    JTextField nameText = new JTextField();
    JLabel collegeLabel = new JLabel("学院",JLabel.RIGHT);
    JTextField collegeText = new JTextField();
    JLabel gradeLabel = new JLabel("年级",JLabel.RIGHT);
    JTextField gradeText = new JTextField();
    JLabel classLabel = new JLabel("班级",JLabel.RIGHT);
    JTextField classText = new JTextField();
    JLabel sexLabel = new JLabel("性别",JLabel.RIGHT);
    JTextField sexText = new JTextField();
    JLabel birthdayLabel = new JLabel("出生年月",JLabel.RIGHT);
    JTextField birthdayText = new JTextField();
    JButton addBtn = new JButton("添加");

    String no1 = null;



    AddStudentViewHandler addStudentViewHandler;
    public AddStudentView(MainView mainView,String no){  //添加参数表明是从哪个窗体弹出来  AddStudentView构造函数
        super(mainView,"编辑",true);

        if (null != no && no.length() > 0){
            no1 =no;
            addBtn.setText("修改");
            //查数据set进去
            StudentService studentService = new StudentServiceImpl();
            StudentDO studentDO = studentService.getByNo(no);
            if (studentDO != null){
                nameText.setText(studentDO.getName());
                collegeText.setText(studentDO.getCollege());
                gradeText.setText(studentDO.getGrade());
                classText.setText(studentDO.getClasses());
                sexText.setText(studentDO.getSex());
                birthdayText.setText(studentDO.getBirthday());
            }

        }



        addStudentViewHandler = new AddStudentViewHandler(this,mainView);
        //添加组件设置大小
        nameLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(nameLabel);
        nameText.setPreferredSize(new Dimension(200,30));
        jPanel.add(nameText);

        collegeLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(collegeLabel);
        collegeText.setPreferredSize(new Dimension(200,30));
        jPanel.add(collegeText);

        gradeLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(gradeLabel);
        gradeText.setPreferredSize(new Dimension(200,30));
        jPanel.add(gradeText);

        classLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(classLabel);
        classText.setPreferredSize(new Dimension(200,30));
        jPanel.add(classText);

        sexLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(sexLabel);
        sexText.setPreferredSize(new Dimension(200,30));
        jPanel.add(sexText);

        birthdayLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(birthdayLabel);
        birthdayText.setPreferredSize(new Dimension(200,30));
        jPanel.add(birthdayText);


        addBtn.addActionListener(addStudentViewHandler);//对添加按钮增加事件响应
        jPanel.add(addBtn);
        //将上述元素添加到内容面板
        Container contentPane = getContentPane();
        contentPane.add(jPanel); //将jPanel的内容添加到内容面板
        setSize(350,500);  //设置大小
        setLocationRelativeTo(null);//直接居中显示
        //DISPOSE_ON_CLOSE:只销毁当前窗体
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //大小不可改变d
        setResizable(false);
        setVisible(true);//设置可见
    }
    public StudentDO buildStudentDO(){    //获取新添加学生的信息
        StudentDO studentDO = new StudentDO();
        studentDO.setNo(no1);
        studentDO.setName(nameText.getText());
        studentDO.setCollege(collegeText.getText());
        studentDO.setGrade(gradeText.getText());
        studentDO.setClasses(classText.getText());
        studentDO.setSex(sexText.getText());
        studentDO.setBirthday(sexText.getText());
        return studentDO;
    }
}
