package event;

import java.awt.Frame;
import java.awt.event.*;
import java.awt.*;

public class EventHandling1 extends Frame {
	// ������
	public EventHandling1() {
		// ��ġ, ũ�⼳��
		setBounds(550, 400, 500, 200);
		setTitle("�̺�Ʈ ó�� ����");
		// ���� ���� ��ġ�ϱ� ���� �г� ��ġ
		Panel panel = new Panel();

		TextField tf1 = new TextField(5);
		panel.add(tf1);
		Label plus = new Label("+");
		panel.add(plus);
		TextField tf2 = new TextField(5);
		panel.add(tf2);
		Label assign = new Label("=");
		panel.add(assign);

		TextField result = new TextField(6);
		panel.add(result);

		Button btn = new Button("���");
		panel.add(btn);
		
		Button exit = new Button("����");
		panel.add(exit);

		// ActionListener �������̽��� anonymousŬ���� ����

		ActionListener listener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ù ��°�� �� ��° �ؽ�Ʈ�ʵ��� ���� ������
				String n1 = tf1.getText();
				String n2 = tf2.getText();
				// ���ڿ��� ������ ��ȯ�ؼ� ���ϱ�
				int r = Integer.parseInt(n1) + Integer.parseInt(n2);
				result.setText(r + "");
			}
		};
		btn.addActionListener(listener1);
		
		
		ActionListener listener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		exit.addActionListener(listener2);


		Label lblPw = new Label("��й�ȣ");
		panel.add(lblPw);
		TextField pw = new TextField(15);
		panel.add(pw);
		Label pwResult = new Label();
		panel.add("South", pwResult);

		// �ؽ�Ʈ �ʵ��� ������ ����� ���� ó���� �� �ִ� �������̽��� �ν��Ͻ� ����
		TextListener txl = new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				String password = pw.getText();
				// ���� ��ҹ� ���� Ư�������� ���� ����
				// ������ ������ ���������
				int dae = 0;
				int so = 0;
				int su = 0;
				int etc = 0;
				// password�� ��� ���� ��ȸ
				for (int i = 0; i < password.length(); i++) {
					// i��° ���� ��������
					char ch = password.charAt(i);
					// �빮������ Ȯ��: A-Z
					if (ch >= 'A' && ch <= 'Z') {
						dae++;
					} else if (ch >= 'a' && ch <= 'z') {
						so++;
					} else if (ch >= '0' && ch <= '9') {
						su++;
					} else {
						etc++;
					}
				}
				if (dae * so * su * etc > 0) {
					pwResult.setBackground(Color.green);
					pwResult.setText(" O ");
				} else {
					pwResult.setBackground(Color.red);
					pwResult.setText(" X ");
				}
			}
		};
		pw.addTextListener(txl);

		add(panel);
		// ȭ�� ���
		setVisible(true);
	}
}
