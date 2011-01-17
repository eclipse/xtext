package org.eclipse.xtext.xtend2.tests.conversion;

import org.eclipse.xtext.xtend2.conversion.RichTextEndValueConverter;
import org.eclipse.xtext.xtend2.conversion.RichTextInBetweenValueConverter;
import org.eclipse.xtext.xtend2.conversion.RichTextStartValueConverter;
import org.eclipse.xtext.xtend2.conversion.RichTextValueConverter;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

public class RichTextValueConverterTest extends AbstractXtend2TestCase {

	public void testRichText() {
		String text = "''' foobar '''";
		String expectation = " foobar ";
		RichTextValueConverter converter = get(RichTextValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testRichTextInBetween() {
		String text = "» foobar  «";
		String expectation = " foobar  ";
		RichTextInBetweenValueConverter converter = get(RichTextInBetweenValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testRichTextStart() {
		String text = "''' foobar«";
		String expectation = " foobar";
		RichTextStartValueConverter converter = get(RichTextStartValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
	
	public void testRichTextEnd() {
		String text = "»foobar   '''";
		String expectation = "foobar   ";
		RichTextEndValueConverter converter = get(RichTextEndValueConverter.class);
		String value = converter.toValue(text, null);
		assertEquals(expectation, value);
	}
}
