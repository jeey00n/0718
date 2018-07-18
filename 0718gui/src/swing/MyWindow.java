package swing;

import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

//������ Ŭ����
public class MyWindow extends JFrame {
	public MyWindow() {
		// ��ġ�� ũ�� ����
		setBounds(550, 400, 280, 280);
		// ���� ����
		setTitle("������ �̿��� ������");
		// ���� ��ư �̺�Ʈ ó��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// �г� ����
		JPanel panel = new JPanel();
//		ImageIcon icon = new ImageIcon("C:\\Users\\503-20\\Downloads\\������1.png");
		JLabel label = new JLabel();
//		label.setIcon(icon);
		label.setToolTipText("�ȳ��ϼ���");
//		TitledBorder border = new TitledBorder("��輱");
		EtchedBorder border = new EtchedBorder(Color.BLACK, Color.PINK);
		label.setBorder(border);
		panel.add(label);
		
		
		JButton btn = new JButton("��ư");
		panel.add(btn);
		
		
		
		// �г��� �����ӿ� ����
		add(panel);
		// ȭ�� ���
		setVisible(true);

		// �׸� ���� �̸��� �迭�� �����
		// �迭�� ����� ũ�� ������ �ȵ�.
//		String [] images = {"������1.png", "������2.png", "������3.png", "������4.png", "������5.png"};
		
		// ����Ʈ�� ũ�� ������ ����.
		ArrayList<String> list = new ArrayList<String>();
		list.add("������1.png");
		list.add("������2.png");
		list.add("������3.png");
		list.add("������4.png");
		list.add("������5.png");

		// �̹����� ����Ǵ� ���ȿ��� �ٸ� �۾��� �� �� �־�� �ϹǷ� �̹��� ������ ������� ����
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
