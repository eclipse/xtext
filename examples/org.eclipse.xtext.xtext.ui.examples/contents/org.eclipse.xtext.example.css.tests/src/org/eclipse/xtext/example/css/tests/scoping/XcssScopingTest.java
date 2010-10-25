package org.eclipse.xtext.example.css.tests.scoping;

import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xtext.example.css.tests.AbstractXcssTestCase;
import org.eclipse.xtext.example.css.xcss.ColorConstant;
import org.eclipse.xtext.example.css.xcss.Filter;
import org.eclipse.xtext.example.css.xcss.StyleRule;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.xbase.XFeatureCall;

public class XcssScopingTest extends AbstractXcssTestCase {

	public void testImplicitImport() throws Exception {
		StyleRule rule = rule("Widget {}");
		assertEquals(Widget.class.getName(), ((TypeSelector)rule.getSelectors().get(0)).getType().getCanonicalName());
	}
	
	public void testThisInFilter() throws Exception {
		StyleRule rule = rule("Widget [this] {}");
		Filter filter = rule.getSelectors().get(0).getFilter();
		XFeatureCall call = (XFeatureCall) filter.getCondition();
		assertEquals(rule.getSelectors().get(0), call.getFeature());
	}
	
	public void testThisInSelector() throws Exception {
		StyleRule rule = rule("Widget { this; }");
		XFeatureCall call = (XFeatureCall) rule.getSettings().get(0);
		assertEquals(rule.getSelectors().get(0), call.getFeature());
	}
	
	public void testColorLiteral() throws Exception {
		StyleRule rule = rule("Control { setBackground(#red); }");
		XFeatureCall setBackground = (XFeatureCall) rule.getSettings().get(0);
		ColorConstant color = (ColorConstant) setBackground.getArguments().get(0);
		assertEquals("org.eclipse.swt.SWT.COLOR_RED", color.getConstant().getCanonicalName());
	}
	
	@Override
	protected StyleSheet styleSheet(String string) throws IOException {
		StyleSheet result = super.styleSheet(string);
		EcoreUtil.resolveAll(result);
		assertTrue("Errors: "+result.eResource().getErrors(), result.eResource().getErrors().isEmpty());
		return result;
	}
	
}
