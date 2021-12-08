package tyukan;

import java.math.BigDecimal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class dentaku extends Application {

	//宣言
	TextField tf1;
	Button []btn = new Button[17];
	VBox vb;

	/*ans1,ans2 :計算用		
	 *ope:前の押された演算子判定
	 *t:演算子押した回数(＝は含まない) 
	 *k:1の時、直前に演算子押された	 0の時:逆 
	 * */
	public static BigDecimal ans1 = BigDecimal.valueOf(0);
	public static BigDecimal ans2 = BigDecimal.valueOf(0);
	public static int ope = 0, t = 0, k = 0;

	@Override
	public void start(Stage primaryStage) {


		//テキストフィールド命名
		tf1 = new TextField("");

		// ボタン命名
		btn[0] = new Button("0");
		btn[1] = new Button("1");
		btn[2] = new Button("2");
		btn[3] = new Button("3");
		btn[4] = new Button("4");
		btn[5] = new Button("5");
		btn[6] = new Button("6");
		btn[7] = new Button("7");
		btn[8] = new Button("8");
		btn[9] = new Button("9");
		btn[10] = new Button(".");
		btn[11] = new Button("＋");
		btn[12] = new Button("－");
		btn[13] = new Button("×");
		btn[14] = new Button("÷");
		btn[15] = new Button("AC");
		btn[16] = new Button("＝");

		//ボダンの動作 0～9
		for(int i = 0; i<= 9; i++) {
			btn[i].setOnAction((ActionEvent event) -> {
				String s = tf1.getText().trim();
				if(!s.equals("エラー(ACを押してね)")) {
					if(k == 1 || s.equals("0") || ope == 5 ) {
						Button b = (Button) event.getSource();
						tf1.setText(b.getText());
						k = 0;
					}
					else if(s.matches("^-?(0|[1-9]\\d*)(\\.)?(\\d*)$") || s.equals("")) {
						Button b = (Button) event.getSource();
						tf1.appendText(b.getText());
					}
				}
			});
		}

		//ボタンの動作 ピリオド
		btn[10].setOnAction((ActionEvent event) -> {
			String s = tf1.getText().trim();
			if(s.matches("^-?(0|[1-9]\\d*)(\\d*)$")) {
				tf1.appendText(".");
			}
		});

		//＋ ボタンの動作
		btn[11].setOnAction((ActionEvent event) -> {
			String s = tf1.getText().trim();
			if(!s.equals("エラー(ACを押してね)") || !s.equals("")) {
				t++;
				if(k==1 || (ope == 4 && s.equals("0"))) {
					tf1.setText("エラー(ACを押してね)");
				}
				else {
					if(t==1) {
						ans1 = new BigDecimal(s);
					}
					else if(t>1) {
						ans2 = new BigDecimal(s);
						if(ope == 1) ans1 = ans1.add(ans2);
						else if(ope == 2) ans1 = ans1.subtract(ans2);
						else if(ope == 3) ans1 = ans1.multiply(ans2);
						else if(ope == 4) ans1 = ans1.divide(ans2);
						ans1 = ans1.stripTrailingZeros();
						String s1 = ans1.toPlainString();
						tf1.setText(s1);
					}
				}
				k = 1;
				ope = 1;
			}
		});

		//－ ボタンの動作
		btn[12].setOnAction((ActionEvent event) -> {
			String s = tf1.getText().trim();
			if(!s.equals("エラー(ACを押してね)")) {
				t++;
				if(k==1 || (ope == 4 && s.equals("0"))) {
					tf1.setText("エラー(ACを押してね)");
				}
				else {
					if(t==1) {
						ans1 = new BigDecimal(s);
					}
					else if(t>1) {
						ans2 = new BigDecimal(s);
						if(ope == 1) ans1 = ans1.add(ans2);
						else if(ope == 2) ans1 = ans1.subtract(ans2);
						else if(ope == 3) ans1 = ans1.multiply(ans2);
						else if(ope == 4) ans1 = ans1.divide(ans2);
						ans1 = ans1.stripTrailingZeros();
						String s1 = ans1.toPlainString();
						tf1.setText(s1);
					}
				}
				k = 1;
				ope = 2;
			}
		});

		//× ボタンの動作
		btn[13].setOnAction((ActionEvent event) -> {
			String s = tf1.getText().trim();
			if(!s.equals("エラー(ACを押してね)")) {
				t++;
				if(k==1 || (ope == 4 && s.equals("0"))) {
					tf1.setText("エラー(ACを押してね)");
				}
				else {
					if(t==1) {
						ans1 = new BigDecimal(s);
					}
					else if(t>1) {
						ans2 = new BigDecimal(s);
						if(ope == 1) ans1 = ans1.add(ans2);
						else if(ope == 2) ans1 = ans1.subtract(ans2);
						else if(ope == 3) ans1 = ans1.multiply(ans2);
						else if(ope == 4) ans1 = ans1.divide(ans2);
						ans1 = ans1.stripTrailingZeros();
						String s1 = ans1.toPlainString();
						tf1.setText(s1);
					}
				}
				k = 1;
				ope = 3;
			}
		});

		//÷ ボタンの動作
		btn[14].setOnAction((ActionEvent event) -> {
			String s = tf1.getText().trim();
			if(!s.equals("エラー(ACを押してね)")) {
				t++;
				if(k==1 || (ope == 4 && s.equals("0"))) {
					tf1.setText("エラー(ACを押してね)");
				}
				else {
					if(t==1) {
						ans1 = new BigDecimal(s);
					}
					else if(t>1) {
						ans2 = new BigDecimal(s);
						if(ope == 1) ans1 = ans1.add(ans2);
						else if(ope == 2) ans1 = ans1.subtract(ans2);
						else if(ope == 3) ans1 = ans1.multiply(ans2);
						else if(ope == 4) ans1 = ans1.divide(ans2);
						ans1 = ans1.stripTrailingZeros();
						String s1 = ans1.toPlainString();
						tf1.setText(s1);
					}
				}
				k = 1;
				ope = 4;
			}
		});

		//AC ボタンの動作 
		btn[15].setOnAction((ActionEvent event) -> {
			tf1.setText("");
			t = 0;
			k = 0;
			ans1 = BigDecimal.valueOf(0);
			ans2 = BigDecimal.valueOf(0);
		});

		//= ボタンの動作 
		btn[16].setOnAction((ActionEvent event) -> {
			String s = tf1.getText().trim();
			if(!s.equals("エラー(ACを押してね)")) {
				t++;
				if(k==1 || (ope == 4 && s.equals("0"))) {
					tf1.setText("エラー(ACを押してね)");
				}
				else {
					if(t>1) {
						ans2 = new BigDecimal(s);
						if(ope == 1) ans1 = ans1.add(ans2);
						else if(ope == 2) ans1 = ans1.subtract(ans2);
						else if(ope == 3) ans1 = ans1.multiply(ans2);
						else if(ope == 4) ans1 = ans1.divide(ans2);
						ans1 = ans1.stripTrailingZeros();
						String s1 = ans1.toPlainString();
						tf1.setText(s1);
						t = 0;				
					}
				}
			}
			ope = 5;
		});

		// レイアウト
		makeLayout();

		// レイアウト表示
		Scene scene = new Scene(vb);
		primaryStage.setScene(scene);
		primaryStage.setTitle("簡易電卓");
		primaryStage.show();
	}

	// レイアウトの作成
	public void makeLayout() {

		//配置
		HBox hb1 = new HBox(0, tf1);
		hb1.setAlignment(Pos.CENTER);
		HBox hb2 = new HBox(0, btn[15], btn[14]);
		HBox hb3 = new HBox(0, btn[7], btn[8], btn[9], btn[13]);
		HBox hb4 = new HBox(0, btn[4], btn[5], btn[6], btn[12]);
		HBox hb5 = new HBox(0, btn[1], btn[2], btn[3], btn[11]);
		HBox hb6 = new HBox(0, btn[0], btn[10], btn[16]);

		//ボタン幅、高さ、文字サイズ
		for(int i = 0; i<= 16; i++) {
			btn[i].setPrefWidth(70);
			btn[i].setPrefHeight(55);
			btn[i].setFont(new Font(15));
			if (i==0)
				btn[0].setPrefWidth(140);
			else if (i==15)
				btn[15].setPrefWidth(210);
		}

		//テキストフィールド編集不可、表示右揃え
		tf1.setAlignment(Pos.BASELINE_RIGHT);
		tf1.setEditable(false);

		vb = new VBox();
		vb = new VBox(2, hb1,hb2, hb3,hb4,hb5,hb6);
	}

	public static void main(String[] args) {
		// アプリケーションを起動する
		Application.launch(args);
		System.out.println("完了");
	}
}
