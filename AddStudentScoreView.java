/*
* 功能：添加学生成绩功能实现
*
* */
package com.roadjava.student.view;

import com.roadjava.entity.StudentDO;
import com.roadjava.handler.AddStudentScoreViewHandler;

import javax.swing.*;
import java.awt.*;

public class AddStudentScoreView extends JDialog {
    //添加学生成绩界面设计
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20)); //设置水平间距10，垂直间距20
    JLabel noLabel = new JLabel("学号",JLabel.RIGHT);
    JTextField noText = new JTextField();
    JLabel mathLabel = new JLabel("高等数学",JLabel.RIGHT);
    JTextField mathText = new JTextField();
    JLabel englishLabel = new JLabel("大学体育",JLabel.RIGHT);
    JTextField englishText = new JTextField();
    JLabel JavaLabel = new JLabel("Java程序设计",JLabel.RIGHT);
    JTextField JavaText = new JTextField();
   /* JLabel comLabel = new JLabel("计算机应用基础",JLabel.RIGHT);
    JTextField comText = new JTextField();*/
    JButton addBtn = new JButton("添加");

    AddStudentScoreViewHandler AddStudentScoreViewHandler;
    public AddStudentScoreView(MainView mainView){  //添加参数表明是从哪个窗体弹出来  AddStudentView构造函数
        super(mainView,"录入分数",true);

        AddStudentScoreViewHandler = new AddStudentScoreViewHandler(this,mainView);
        //添加组件设置大小

        noLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(noLabel);
        noText.setPreferredSize(new Dimension(200,30));
        jPanel.add(noText);

        mathLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(mathLabel);
        mathText.setPreferredSize(new Dimension(200,30));
        jPanel.add(mathText);

        englishLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(englishLabel);
        englishText.setPreferredSize(new Dimension(200,30));
        jPanel.add(englishText);

        JavaLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(JavaLabel);
        JavaText.setPreferredSize(new Dimension(200,30));
        jPanel.add(JavaText);

        /*comLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(comLabel);
        comText.setPreferredSize(new Dimension(200,30));
        jPanel.add(comText);*/

        addBtn.addActionListener(AddStudentScoreViewHandler);//对添加按钮增加事件响应
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
        studentDO.setNo(noText.getText());
        studentDO.setMath(Integer.valueOf(mathText.getText()));
        studentDO.setPe(Integer.valueOf(englishText.getText()));
        studentDO.setJava(Integer.valueOf(JavaText.getText()));
        //studentDO.setComputer(Integer.valueOf(comText.getText()));
        return studentDO;
    }
}
