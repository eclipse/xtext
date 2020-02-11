/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug347012TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug347012TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug347012Test extends AbstractContentAssistTest {
	
	@Test public void testEmptyDocument() throws Exception {
		newBuilder().assertText("package");
	}
	
	@Test public void testCurlyAfterPackageName() throws Exception {
		newBuilder("package a ").assertText("{");
	}
	
	@Test public void testPublicClass() throws Exception {
		newBuilder("package a { ").assertText("public", "class", "}");
	}
	
	@Test public void testClassName() throws Exception {
		newBuilder("package a { public class ").assertText();
	}
	
	@Test public void testCurlyAfterClassName() throws Exception {
		newBuilder("package a { public class Aa ").assertText("{");
	}
	
	@Test public void testInsideClass() throws Exception {
		// this will kill the production parser
//		newBuilder("package a { public class Aa { ").assertText("public", "private", "var", "}");
		newBuilder("package a { public class Aa { }").assertTextAtCursorPosition("}", "public", "private", "var" 
				// , "}" // this one is skipped because of the infinite recursion detections
		);
	}
	
	@Test public void testAfterVar() throws Exception {
		// those will kill the production parser
//		newBuilder("package a { public class Aa { var ").assertText();
//		newBuilder("package a { public class Aa { var }").assertTextAtCursorPosition("}");
//		newBuilder("package a { public class Aa { var  Name }").assertTextAtCursorPosition(" Name");
		newBuilder("package a { public class Aa { var  Name; }").assertTextAtCursorPosition(" Name");
	}
	
	@Test public void testAfterBindingName() throws Exception {
		newBuilder("package a { public class Aa { var Name  ;}").assertTextAtCursorPosition(" ;", ":", "=", ",");
	}
	
	@Test public void testAfterBindingType() throws Exception {
		newBuilder("package a { public class Aa { var name:String  ; }").assertTextAtCursorPosition(" ;", "=", ",");
	}
	
	public ContentAssistProcessorTestBuilder newBuilder(String initial) throws Exception {
		return newBuilder().appendNl(initial);
	}

}
