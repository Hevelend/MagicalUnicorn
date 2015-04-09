package ca.magical.unicorn.hud;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hud {
	private Image firstHeart;
	private Image secondHeart;
	private Image thirdHeart;
	private Image cookieSymbol;
	private Image crossSymbol;
	private Image firstNumber;
	private Image secondNumber;
	private static final int P_FIRSTH_X = 10; // Position X de l'image
	private static final int P_HEART_Y = 10; // position Y de l'image
	private static final int P_SECONDH_X = 62;
	private static final int P_THIRDH_X = 114;
	private static final int P_COOKIE_X = 10;
	private static final int P_COOKIE_Y = 62;
	private static final int P_CROSS_X = 50;
	private static final int P_CROSS_Y = 67;
	private static final int P_NUMBER_Y = 62;
	private static final int P_FIRSTN_X = 92;
	private static final int P_SECONDN_X = 125;
	
	public void init() throws SlickException {
		this.firstHeart = new Image("res/hud/UI_HEART_FULL.png");
		this.secondHeart = new Image("res/hud/UI_HEART_FULL.png");
		this.thirdHeart = new Image("res/hud/UI_HEART_FULL.png");
		this.cookieSymbol = new Image("res/hud/cookie.png");
		this.crossSymbol = new Image("res/hud/SYMB_X.png");
		this.firstNumber = new Image("res/hud/SYMB_0.png");
		this.secondNumber = new Image("res/hud/SYMB_0.png");
	}
	
	public void render(Graphics g, float playerHealth, int NBCookies) throws SlickException {
		g.resetTransform();
		
		firstHeart = new Image("res/hud/UI_HEART_FULL.png");
		secondHeart = new Image("res/hud/UI_HEART_FULL.png");
		thirdHeart = new Image("res/hud/UI_HEART_FULL.png");
		firstNumber = new Image("res/hud/SYMB_0.png");
		secondNumber = new Image("res/hud/SYMB_0.png");
		
		if(playerHealth == 2.5){
			firstHeart = new Image("res/hud/UI_HEART_HALF.png");
		} else if(playerHealth == 2) {
			firstHeart = new Image("res/hud/UI_HEART_EMPTY.png");
		} else if(playerHealth == 1.5) {
			secondHeart = new Image("res/hud/UI_HEART_HALF.png");
		} else if(playerHealth == 1) {
			secondHeart = new Image("res/hud/UI_HEART_EMPTY.png");
		} else if(playerHealth == 0.5) {
			thirdHeart = new Image("res/hud/UI_HEART_HALF.png");
		} else if(playerHealth == 0) {
			firstHeart = new Image("res/hud/UI_HEART_EMPTY.png");
			secondHeart = new Image("res/hud/UI_HEART_EMPTY.png");
			thirdHeart = new Image("res/hud/UI_HEART_EMPTY.png");
		}
		
		String tempString = "00";
		
		if(Integer.toString(NBCookies).length() > 1){
			tempString = Integer.toString(NBCookies);
		} else {
			tempString = "0" + Integer.toString(NBCookies);
		}
		
		switch(Integer.parseInt(tempString.substring(0,1))){
			case 1:
				firstNumber = new Image("res/hud/SYMB_1.png");
				break;
			case 2:
				firstNumber = new Image("res/hud/SYMB_2.png");
				break;
			case 3:
				firstNumber = new Image("res/hud/SYMB_3.png");
				break;
			case 4:
				firstNumber = new Image("res/hud/SYMB_4.png");
				break;
			case 5:
				firstNumber = new Image("res/hud/SYMB_5.png");
				break;
			case 6:
				firstNumber = new Image("res/hud/SYMB_6.png");
				break;
			case 7:
				firstNumber = new Image("res/hud/SYMB_7.png");
				break;
			case 8:
				firstNumber = new Image("res/hud/SYMB_8.png");
				break;
			case 9:
				firstNumber = new Image("res/hud/SYMB_9.png");
				break;
			default :
				firstNumber = new Image("res/hud/SYMB_0.png");
				break;
		}
		
		switch(Integer.parseInt(tempString.substring(1,2))){
			case 1:
				secondNumber = new Image("res/hud/SYMB_1.png");
				break;
			case 2:
				secondNumber = new Image("res/hud/SYMB_2.png");
				break;
			case 3:
				secondNumber = new Image("res/hud/SYMB_3.png");
				break;
			case 4:
				secondNumber = new Image("res/hud/SYMB_4.png");
				break;
			case 5:
				secondNumber = new Image("res/hud/SYMB_5.png");
				break;
			case 6:
				secondNumber = new Image("res/hud/SYMB_6.png");
				break;
			case 7:
				secondNumber = new Image("res/hud/SYMB_7.png");
				break;
			case 8:
				secondNumber = new Image("res/hud/SYMB_8.png");
				break;
			case 9:
				secondNumber = new Image("res/hud/SYMB_9.png");
				break;
			default :
				secondNumber = new Image("res/hud/SYMB_0.png");
				break;
		}
		
		g.drawImage(firstHeart, P_FIRSTH_X, P_HEART_Y);
		g.drawImage(secondHeart, P_SECONDH_X, P_HEART_Y);
		g.drawImage(thirdHeart, P_THIRDH_X, P_HEART_Y);
		g.drawImage(cookieSymbol, P_COOKIE_X, P_COOKIE_Y);
		g.drawImage(crossSymbol, P_CROSS_X, P_CROSS_Y);
		g.drawImage(firstNumber, P_FIRSTN_X, P_NUMBER_Y);
		g.drawImage(secondNumber, P_SECONDN_X, P_NUMBER_Y);
	}
}
