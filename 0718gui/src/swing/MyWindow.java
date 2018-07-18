package swing;

import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

//윈도우 클래스
public class MyWindow extends JFrame {
	public MyWindow() {
		// 위치와 크기 설정
		setBounds(550, 400, 280, 280);
		// 제목 설정
		setTitle("스윙을 이용한 윈도우");
		// 종료 버튼 이벤트 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 패널 생성
		JPanel panel = new JPanel();
//		ImageIcon icon = new ImageIcon("C:\\Users\\503-20\\Downloads\\스누피1.png");
		JLabel label = new JLabel();
//		label.setIcon(icon);
		label.setToolTipText("안녕하세요");
//		TitledBorder border = new TitledBorder("경계선");
		EtchedBorder border = new EtchedBorder(Color.BLACK, Color.PINK);
		label.setBorder(border);
		panel.add(label);
		
		
		JButton btn = new JButton("버튼");
		panel.add(btn);
		
		
		
		// 패널을 프레임에 부착
		add(panel);
		// 화면 출력
		setVisible(true);

		// 그림 파일 이름을 배열로 만들기
		// 배열은 만들면 크기 변경이 안됨.
//		String [] images = {"스누피1.png", "스누피2.png", "스누피3.png", "스누피4.png", "스누피5.png"};
		
		// 리스트는 크기 변경이 가능.
		ArrayList<String> list = new ArrayList<String>();
		list.add("스누피1.png");
		list.add("스누피2.png");
		list.add("스누피3.png");
		list.add("스누피4.png");
		list.add("스누피5.png");

		// 이미지가 변경되는 동안에도 다른 작업을 할 수 있어야 하므로 이미지 변경은 스레드로 생성
		Thread th = new Thread() {
			public void run() {
				int idx = 0;
				while (true) {
					try {
						Thread.sleep(300);
//						ImageIcon iconChange = new ImageIcon("C:\\Users\\503-20\\Downloads\\"+images[idx%images.length]);
						ImageIcon iconChange = new ImageIcon("C:\\Users\\503-20\\Downloads\\"+list.get(idx%list.size()));
//						label.setIcon(iconChange);
						label.setIcon(iconChange);
						idx++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		th.start();
	}
}
