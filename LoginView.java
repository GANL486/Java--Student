/*
*
* 登陆界面功能实现
* */
package com.roadjava.student.view;

import com.roadjava.handler.LoginHandler;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoginView extends JFrame {
    JLabel nameLabel = new JLabel("学 生 成 绩 管 理 系 统",JLabel.CENTER);

    SpringLayout springLayout=new SpringLayout();//弹簧布局
    JPanel centerPanel = new JPanel(springLayout);
    JLabel userNameLabel = new JLabel("用户名:");
    JTextField userText = new JTextField();
    JLabel pwdLabel = new JLabel("密码:");
    JPasswordField pwdField = new JPasswordField();
    JButton loginBtn = new JButton("登录");
    JButton resetBtn = new JButton("重置");

    LoginHandler loginHandler;
    public LoginView(){
        super("学生成绩管理系统");

        loginHandler=new LoginHandler(this);

        Container contentPane = getContentPane();//获取内容面板
        //设置大标题字体
        nameLabel.setFont( new Font("华文行楷",Font.PLAIN,40));
        nameLabel.setPreferredSize(new Dimension(0,80));
        //设置登录等字体
        Font centerFont = new Font("楷体",Font.PLAIN,20);
        userNameLabel.setFont(centerFont);
        userText.setPreferredSize(new Dimension(200,30));
        pwdLabel.setFont(centerFont);
        pwdField.setPreferredSize(new Dimension(200,30));
        loginBtn.setFont(centerFont);
        resetBtn.setFont(centerFont);
        //把组件加入面板
        centerPanel.add(userNameLabel);
        centerPanel.add(userText);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdField);
        loginBtn.addActionListener(loginHandler);
        //添加按键事件
        loginBtn.addKeyListener(loginHandler);  //登陆按钮事件监听
        centerPanel.add(loginBtn);
        resetBtn.addActionListener(loginHandler); //重置按钮事件监听
        centerPanel.add(resetBtn);
        //弹簧布局
        layoutCenter();//使用Refactor-Extract method 抽出来的一个方法

        contentPane.add(nameLabel,BorderLayout.NORTH);
        contentPane.add(centerPanel,BorderLayout.CENTER);

       //设置loginBtn为默认按钮(如果不设置键盘不会响应)
        getRootPane().setDefaultButton(loginBtn);
       //可以在这里自定义图标


        setSize(600,400);  //设置大小
        setLocationRelativeTo(null);//直接居中显示
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可改变d
        setResizable(false);
        setVisible(true);//设置可见
    }

    private void layoutCenter() {
        //弹簧布局
        //布局userNameLabel
        Spring childwidth=Spring.sum(Spring.sum(Spring.width(userNameLabel),Spring.width(userText)),Spring.constant(20));
        int offsetX=childwidth.getValue()/2;
        //放置约束
        springLayout.putConstraint(SpringLayout.WEST,userNameLabel,-offsetX,
                SpringLayout.HORIZONTAL_CENTER,centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH,userNameLabel,20,SpringLayout.NORTH,centerPanel);
        //userTest
        springLayout.putConstraint(SpringLayout.WEST,userText,20,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,userText,0,SpringLayout.NORTH,userNameLabel);
        //pwdLabel
        springLayout.putConstraint(SpringLayout.EAST,pwdLabel,0,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdLabel,20,SpringLayout.SOUTH,userNameLabel);
        //pwdField
        springLayout.putConstraint(SpringLayout.WEST,pwdField,20,SpringLayout.EAST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdField,0,SpringLayout.NORTH,pwdLabel);
        //loginBtn
        springLayout.putConstraint(SpringLayout.WEST,loginBtn,50,SpringLayout.WEST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,loginBtn,20,SpringLayout.SOUTH,pwdLabel);
        //resetBtn
        springLayout.putConstraint(SpringLayout.WEST,resetBtn,50,SpringLayout.EAST,loginBtn);
        springLayout.putConstraint(SpringLayout.NORTH,resetBtn,0,SpringLayout.NORTH,loginBtn);
    }


   /* public static void main(String[] args) {

        new LoginView();
    }*/
    public JTextField getUserText() {  //用户名获取方法

        return userText;
    }

    public JPasswordField getPwdField() { //密码获取方法

        return pwdField;
    }

}
