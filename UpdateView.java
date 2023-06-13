/*
* 功能：添加学生成绩功能实现
*
* */
package com.roadjava.student.view;

import com.roadjava.entity.StudentDO;
import com.roadjava.handler.AddStudentViewHandler;
import com.roadjava.handler.MainViewHandler;
import com.roadjava.handler.UpdateStudentViewHandler;

import javax.swing.*;
import java.awt.*;

public class UpdateView extends JDialog {
    //修改和删除学生界面设计
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20)); //设置水平间距10，垂直间距20
    JLabel noLabel = new JLabel("学生学号",JLabel.RIGHT);
    JTextField noText = new JTextField();
    JButton addBtn = new JButton("修改");


    UpdateStudentViewHandler updateStudentViewHandler;
    public UpdateView(MainView mainView,int type){  //添加参数表明是从哪个窗体弹出来  AddStudentView构造函数
        super(mainView,type==1?"删除学生":"修改学生",true);
        if (type==1){
            addBtn.setText("删除");
        }

        updateStudentViewHandler = new UpdateStudentViewHandler(this,mainView);
        //添加组件设置大小
        noLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(noLabel);
        noText.setPreferredSize(new Dimension(200,30));
        jPanel.add(noText);

        addBtn.addActionListener(updateStudentViewHandler);//对添加按钮增加事件响应
        jPanel.add(addBtn);
        //将上述元素添加到内容面板
        Container contentPane = getContentPane();
        contentPane.add(jPanel); //将jPanel的内容添加到内容面板
        setSize(350,250);  //设置大小
        setLocationRelativeTo(null);//直接居中显示
        //DISPOSE_ON_CLOSE:只销毁当前窗体
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //大小不可改变d
        setResizable(false);
        setVisible(true);//设置可见
    }


    public String getNo(){
        return noText.getText();
    }

}
