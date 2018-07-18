package event;

import java.awt.Frame;
import java.awt.event.*;
import java.awt.*;

public class EventHandling1 extends Frame {
	// 생성자
	public EventHandling1() {
		// 위치, 크기설정
		setBounds(550, 400, 500, 200);
		setTitle("이벤트 처리 연습");
		// 여러 개를 배치하기 위해 패널 배치
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

		Button btn = new Button("계산");
		panel.add(btn);
		
		Button exit = new Button("종료");
		panel.add(exit);

		// ActionListener 인터페이스의 anonymous클래스 생성

		ActionListener listener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 첫 번째와 두 번째 텍스트필드의 내용 가져옴
				String n1 = tf1.getText();
				String n2 = tf2.getText();
				// 문자열을 정수로 변환해서 더하기
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


		Label lblPw = new Label("비밀번호");
		panel.add(lblPw);
		TextField pw = new TextField(15);
		panel.add(pw);
		Label pwResult = new Label();
		panel.add("South", pwResult);

		// 텍스트 필드의 내용이 변경될 때를 처리할 수 있는 인터페이스의 인스턴스 생성
		TextListener txl = new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				String password = pw.getText();
				// 영문 대소문 숫자 특수문자의 개수 세기
				// 개수를 저장할 변수만들기
				int dae = 0;
				int so = 0;
				int su = 0;
				int etc = 0;
				// password의 모든 글자 순회
				for (int i = 0; i < password.length(); i++) {
					// i번째 글자 가져오기
					char ch = password.charAt(i);
					// 대문자인지 확인: A-Z
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
		// 화면 출력
		setVisible(true);
	}
}
