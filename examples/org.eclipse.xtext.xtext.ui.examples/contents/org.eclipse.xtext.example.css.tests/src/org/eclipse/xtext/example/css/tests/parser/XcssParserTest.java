package org.eclipse.xtext.example.css.tests.parser;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.example.css.tests.AbstractXcssTestCase;
import org.eclipse.xtext.example.css.xcss.StyleRule;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.example.css.xcss.WildcardSelector;
import org.eclipse.xtext.xbase.XBinaryOperation;

public class XcssParserTest extends AbstractXcssTestCase {

	public void testSimpleSelector() throws Exception {
		StyleRule rule = rule("Widget { foo: bar; }");
		assertEquals(1, rule.getSelectors().size());
		assertTrue(rule.getSelectors().get(0) instanceof TypeSelector);
		assertNull(rule.getSelectors().get(0).getFilter());
	}
	
	public void testWildcardSelectorWithFilter() throws Exception {
		StyleRule rule = rule("*[a==b] { foo: bar * bar; }");
		assertEquals(1, rule.getSelectors().size());
		assertTrue(rule.getSelectors().get(0) instanceof WildcardSelector);
		assertTrue(rule.getSelectors().get(0).getFilter().getCondition() instanceof XBinaryOperation);
	}
	
	public void testTwoSelectors() throws Exception {
		StyleRule rule = rule("Widget *[condition] { foo: bar * bar; }");
		assertEquals(2, rule.getSelectors().size());
	}
	
	public void testTypeSelectorResolves() throws Exception {
		StyleRule rule = rule("java.lang.String { foo: bar; }");
		TypeSelector selector = (TypeSelector) rule.getSelectors().get(0);
		JvmType type = selector.getType();
		assertFalse(type.eIsProxy());
	}
	
}
