/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import junit.framework.Test;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug347012TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug347012Test extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new Bug347012TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug347012TestLanguageRuntimeModule(), 
						new Bug347012TestLanguageUiModule(Activator.getInstance()), new SharedStateModule()));
			}
		};
	}
	
	public void testEmptyDocument() throws Exception {
		newBuilder().assertText("package");
	}
	
	public void testCurlyAfterPackageName() throws Exception {
		newBuilder("package a ").assertText("{");
	}
	
	public void testPublicClass() throws Exception {
		newBuilder("package a { ").assertText("public", "class", "}");
	}
	
	public void testClassName() throws Exception {
		newBuilder("package a { public class ").assertText();
	}
	
	public void testCurlyAfterClassName() throws Exception {
		newBuilder("package a { public class Aa ").assertText("{");
	}
	
	public void testInsideClass() throws Exception {
		// this will kill the production parser
//		newBuilder("package a { public class Aa { ").assertText("public", "private", "var", "}");
		newBuilder("package a { public class Aa { }").assertTextAtCursorPosition("}", "public", "private", "var" 
				// , "}" // this one is skipped because of the infinite recursion detections
		);
	}
	
	public void testAfterVar() throws Exception {
		// those will kill the production parser
//		newBuilder("package a { public class Aa { var ").assertText();
//		newBuilder("package a { public class Aa { var }").assertTextAtCursorPosition("}");
//		newBuilder("package a { public class Aa { var  Name }").assertTextAtCursorPosition(" Name");
		newBuilder("package a { public class Aa { var  Name; }").assertTextAtCursorPosition(" Name");
	}
	
	public void testAfterBindingName() throws Exception {
		newBuilder("package a { public class Aa { var Name  ;}").assertTextAtCursorPosition(" ;", ":", "=", ",");
	}
	
	public void testAfterBindingType() throws Exception {
		newBuilder("package a { public class Aa { var name:String  ; }").assertTextAtCursorPosition(" ;", "=", ",");
	}
	
	public ContentAssistProcessorTestBuilder newBuilder(String initial) throws Exception {
		return newBuilder().appendNl(initial);
	}

	public static Test suite() {
		return AbstractContentAssistProcessorTest.suite(Bug347012Test.class);
	}
	
}
