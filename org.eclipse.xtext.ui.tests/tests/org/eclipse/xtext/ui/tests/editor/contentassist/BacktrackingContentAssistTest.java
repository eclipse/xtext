/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.BacktrackingContentAssistTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(BacktrackingContentAssistTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class BacktrackingContentAssistTest extends AbstractContentAssistTest {
	
	@Test public void testEmptyDocument() throws Exception {
		newBuilder().assertText("package", "context");
	}
	
	@Test public void testAfterContext() throws Exception {
		newBuilder().append("context ").assertText(
				"Namespace", "Feature", // PropertyContextDecl
				"selfName", "Classifier", // ClassifierContextDecl
				"Operation" // OperationContextDecl
				);
	}
	
	@Test public void testAfterPackage() throws Exception {
		newBuilder().append("package ").assertText("Namespace", "Package");
	}
	
	@Test public void testAfterPackageName() throws Exception {
		newBuilder().append("package PackageOrNamespace ").assertText(
				"::", "context", "endpackage");
	}
	
	@Test public void testAfterContextInPackage_01() throws Exception {
		newBuilder().append("package PackageName context ").assertText(
				"Namespace", "Feature", // PropertyContextDecl
				"selfName", "Classifier", // ClassifierContextDecl
				"Operation" // OperationContextDecl
				);
	}
	
	@Test public void testAfterContextInPackage_02() throws Exception {
		newBuilder().append("package PackageName context first context ").assertText(
				"Namespace", "Feature", // PropertyContextDecl
				"selfName", "Classifier", // ClassifierContextDecl
				"Operation" // OperationContextDecl
				);
	}
	
	@Test public void testAfterSelfName_01() throws Exception {
		newBuilder().append("package PackageName context selfName ").assertText(
				":", // is self name
				"::", // is namespace
				// is classifier name
				"inv", 
				"static", "def",
				"context", "endpackage", // empty context body
				// is operation context decl
				"("
				);
	}
	
	@Test public void testAfterSelfName_02() throws Exception {
		newBuilder().append("package PackageName context first context second ").assertText(
				":", // is self name
				"::", // is namespace
				// is classifier name
				"inv", 
				"static", "def",
				"context", "endpackage", // empty context body
				// is operation context decl
				"("
				);
	}
	
	@Test public void testAfterDef_01() throws Exception {
		newBuilder().append("package PackageName context selfName def ").assertText(
				"constraintName",
				":"
				);
	}
	
	@Test public void testAfterDef_02() throws Exception {
		newBuilder().append("package PackageName context first context second def ").assertText(
				"constraintName",
				":"
				);
	}
	
	@Test public void testAfterInv() throws Exception {
		newBuilder().append("package PackageName context first context second inv ").assertText(
				"constraintName",
				":"
				);
	}
	
	@Test public void testInsideInv_01() throws Exception {
		newBuilder().append("package PackageName context selfName inv: ").assertText(
				"Namespace",
				"Element",
				"self",
				"true", "false",
				"invalid",
				"null",
				"Tuple",
				"if",
				"(",
				"-", "not",
				"let"				
				);
	}
	
	@Test public void testInsideInv_02() throws Exception {
		newBuilder().append(
				"package PackageName context Context inv: " +
				"Sequence{} -> ").assertText(
				"Namespace", "Element"		
				);
	}
	
	@Test public void testInsideInv_03() throws Exception {
		newBuilder().append(
				"package PackageName context Context inv: " +
				"(Sequence{} -> ").assertText(
						"Namespace", "Element"		
				);
	}
	
	@Test public void testInsideInv_04() throws Exception {
		newBuilder().append(
				"package PackageName context Context inv: " +
				"(Sequence{}").assertText(
						"}",
						")",
						"implies",
						"xor",
						"or",
						"and",
						"=", "<>",
						">", "<", ">=", "<=",
						"+", "-",
						"*", "/",
						".", "->",
						"^", "^^"
				);
	}
	
	@Test public void testInsideInv_05() throws Exception {
		newBuilder().append(
				"package PackageName context Context inv: " +
				"Sequence{}").assertText(
						"}",
						"implies",
						"xor",
						"or",
						"and",
						"=", "<>",
						">", "<", ">=", "<=",
						"+", "-",
						"*", "/",
						".", "->",
						"^", "^^",
						"inv", 
						"static", "def",
						"context", "endpackage"
				);
	}
	
	@Test public void testInsideInv_06() throws Exception {
		newBuilder().append("package PackageName context first context second inv: ").assertText(
				"Namespace",
				"Element",
				"self",
				"true", "false",
				"invalid",
				"null",
				"Tuple",
				"if",
				"(",
				"-", "not",
				"let"				
				);
	}
	
	@Test public void testInsideInv_07() throws Exception {
		newBuilder().append(
				"package PackageName context first context second inv: " +
				"Sequence{} -> ").assertText(
				"Namespace", "Element"		
				);
	}
	
	@Test public void testInsideInv_08() throws Exception {
		newBuilder().append(
				"package PackageName context first context second inv: " +
				"(Sequence{} -> ").assertText(
						"Namespace", "Element"		
				);
	}
	
	@Test public void testInsideInv_09() throws Exception {
		newBuilder().append(
				"package PackageName context first context second inv: " +
				"(Sequence{}").assertText(
						"}",
						")",
						"implies",
						"xor",
						"or",
						"and",
						"=", "<>",
						">", "<", ">=", "<=",
						"+", "-",
						"*", "/",
						".", "->",
						"^", "^^"
				);
	}
	
	@Test public void testInsideInv_10() throws Exception {
		newBuilder().append(
				"package PackageName context first context second inv: " +
				"Sequence{}").assertText(
						"}",
						"implies",
						"xor",
						"or",
						"and",
						"=", "<>",
						">", "<", ">=", "<=",
						"+", "-",
						"*", "/",
						".", "->",
						"^", "^^",
						"inv", 
						"static", "def",
						"context", "endpackage"
				);
	}

}
