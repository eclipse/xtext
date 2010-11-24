package org.eclipse.xtext.example.css.tests.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.example.css.conversion.XcssValueConverterService;

import junit.framework.TestCase;

public class HexintValueConverterTest extends TestCase {
	
	private IValueConverter<Integer> converter;

	@Override
	protected void setUp() throws Exception {
		converter = new XcssValueConverterService().HEXINT();
	}
	
	public void testIllegalValues() {
		try {
			converter.toValue("", null, null);
			fail("Expected exception");
		} catch(ValueConverterException e) {
		}
		try {
			converter.toValue("fffff", null, null);
			fail("Expected exception");
		} catch(ValueConverterException e) {
		}
		try {
			converter.toValue("fffffff", null, null);
			fail("Expected exception");
		} catch(ValueConverterException e) {
		}
	}
	
	public void testLegalValues() {
		assertEquals(0, converter.toValue("000000", null, null).intValue());
		assertEquals(255, converter.toValue("0000ff", null, null).intValue());
		assertEquals(255, converter.toValue("0000FF", null, null).intValue());
		assertEquals((1<<24) - 1, converter.toValue("ffffff", null, null).intValue());
	}

}
