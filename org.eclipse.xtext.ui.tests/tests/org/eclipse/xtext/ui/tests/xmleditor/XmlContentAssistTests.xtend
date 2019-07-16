package org.eclipse.xtext.ui.tests.xmleditor

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.ui.tests.xmleditor.ui.tests.XmlUiInjectorProvider

@RunWith(XtextRunner)
@InjectWith(XmlUiInjectorProvider)
class XmlContentAssistTests extends AbstractContentAssistTest {

	@Test def void test01() {
		newBuilder.assertText("")
	}

	@Test def void test02() {
		newBuilder.append('''<a b="" />''').assertTextAtCursorPosition(6, "")
	}
}
