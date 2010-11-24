package org.eclipse.xtext.example.css.tests.rendering;

import junit.framework.TestCase;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.example.css.conversion.XcssValueConverterService;
import org.eclipse.xtext.example.css.rendering.RGBHelper;

public class RGBHelperTest extends TestCase {

	private IValueConverter<Integer> converter;

	@Override
	protected void setUp() throws Exception {
		converter = new XcssValueConverterService().HEXINT();
	}
	
	public void testBlue() {
		int color = converter.toValue("0000ff", null);
		RGB rgb = RGBHelper.create(color);
		assertEquals(0, rgb.red);
		assertEquals(0, rgb.green);
		assertEquals(255, rgb.blue);
	}
	
	public void testRed() {
		int color = converter.toValue("ff0000", null);
		RGB rgb = RGBHelper.create(color);
		assertEquals(255, rgb.red);
		assertEquals(0, rgb.green);
		assertEquals(0, rgb.blue);
	}
	
	public void testGreen() {
		int color = converter.toValue("00ff00", null);
		RGB rgb = RGBHelper.create(color);
		assertEquals(0, rgb.red);
		assertEquals(255, rgb.green);
		assertEquals(0, rgb.blue);
	}
	
}
