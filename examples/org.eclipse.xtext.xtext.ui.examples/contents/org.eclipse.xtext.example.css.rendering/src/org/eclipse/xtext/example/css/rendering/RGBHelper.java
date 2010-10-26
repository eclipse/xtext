package org.eclipse.xtext.example.css.rendering;

import org.eclipse.swt.graphics.RGB;

public class RGBHelper {

	public static RGB create(int value) {
		int redValue = (value >> 16) & 255;
		int greenValue = (value >> 8) & 255;
		int blueValue = value & 255;
		RGB result = new RGB(redValue, greenValue, blueValue);
		return result;
	}
	
}
