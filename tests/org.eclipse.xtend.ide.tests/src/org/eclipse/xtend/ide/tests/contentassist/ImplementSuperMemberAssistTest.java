/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend.ide.codebuilder.AbstractExecutableBuilder;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.contentassist.ImportOrganizingProposal;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImplementSuperMemberAssistTest extends AbstractXtendContentAssistBugTest {

	@Inject
	private IIndentationInformation indentationInfo;
	
	private String indent;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		indent = indentationInfo.getIndentString();
	}
	
	@Test public void testAbstractMethod() throws Exception {
		newBuilder().append("class Foo implements Comparable<String> { co").assertText(
				getOverridingFunctionCode("compareTo(String o)"));
	}

	@Test public void testNonAbstractMethod() throws Exception {
		newBuilder().append("class Foo implements Comparable<String> { clo").assertText(
				"\n" + indent + "\n" + indent + "override protected clone() throws CloneNotSupportedException {\n" + 
				indent + indent + "super.clone()\n" +
				indent + "}");
	}

	@Test public void testStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { currentT").assertText("");
	}
	
	@Test public void testMethodTypeParameter() throws Exception {
		newBuilder().append("class Foo <T> { def <U extends T> foo() {} } class Bar extends Foo<CharSequence>{ foo").assertText(
				"\n" + indent + "\n" + indent + "override <U extends CharSequence> foo() {\n" + indent + indent + "super.<U>foo()\n" + indent +"}");
	}
	
	@Test public void testVarArgsMethod_01() throws Exception {
		newBuilder().append("class A { def <T> Iterable<T> x(T... args) {} } class B extends A { x").assertText(
				"\n" + indent + "\n" + indent + "override <T> x(T... args) {\n" +
				indent + indent + "super.<T>x(args)\n" +
				indent + "}");
	}
	
	@Test public void testVarArgsMethod_02() throws Exception {
		newBuilder().append("class A { def void x(String s, int... i) {} } class B extends A { x").assertText(
				"\n" + indent + "\n" + indent + "override x(String s, int... i) {\n" +
				indent + indent + "super.x(s, i)\n" +
				indent + "}");
	}
	
	@Test public void testVarArgsConstructor_01() throws Exception {
		newBuilder().append("class A { new(Class<?>... c) {} } class B extends A { ne").assertText(
				"\n" + indent + "\n" + indent + "new(Class<?>... c) {\n" + // should be Class<?>
				indent + indent + "super(c)\n" +
				indent + "}", 
				"new");
	}
	
	@Test public void testVarArgsConstructor_02() throws Exception {
		newBuilder().append("class A<X> { new(Class<X>... c) {} } class B<Z> extends A<Z> { ne").assertText(
				"\n" + indent + "\n" + indent + "new(Class<Z>... c) {\n" +
				indent + indent + "super(c)\n" +
				indent + "}", 
				"new");
	}
	
	@Test public void testVarArgsConstructor_03() throws Exception {
		newBuilder().append("class A<X> { new(Class<X>... c) {} } class B extends A<String> { ne").assertText(
				"\n" + indent + "\n" + indent + "new(Class<String>... c) {\n" +
				indent + indent + "super(c)\n" +
				indent + "}", 
				"new");
	}

	@Test public void testNonStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { getI").assertText(
				"\n" + indent + "\n" + 
				indent + "override getId() {\n" + 
				indent + indent + "super.getId()\n" + 
				indent + "}");
	}
	
	@Test public void testExistingStaticImport() throws Exception {
		ICompletionProposal[] proposals = newBuilder().append("import static java.util.Collection.*" +
				"class SpecialList extends java.util.ArrayList { removeAll").computeCompletionProposals();
		assertEquals(1, proposals.length);
		ImportOrganizingProposal proposal = (ImportOrganizingProposal) proposals[0];
		ReplacingAppendable appendable = proposal.getAppendable();
		RewritableImportSection importSection = appendable.getImportSection();
		List<ReplaceRegion> imports = importSection.rewrite();
		assertEquals(1, imports.size());
		assertEquals("import java.util.Collection", imports.get(0).getText().trim());
	}

	@Test public void testExtensionKeyword_01() throws Exception {
		newBuilder()
			.append("import org.eclipse.xtext.xbase.lib.Extension class A { def void x(@Extension String arg) {} } class B extends A { x")
			.assertText(
				"\n" + indent + "\n" + indent + "override x(extension String arg) {\n" +
				indent + indent + "super.x(arg)\n" +
				indent + "}");
	}
	
	@Test public void testExtensionKeyword_02() throws Exception {
		newBuilder().append("class A { def void x(extension String arg) {} } class B extends A { x").assertText(
				"\n" + indent + "\n" + indent + "override x(extension String arg) {\n" +
						indent + indent + "super.x(arg)\n" +
						indent + "}");
	}
	
	@Test public void testConstructor() throws Exception {
		newBuilder().append("class Foo extends java.util.ArrayList<String> { new").assertText(
				"\n" + indent + "\n" + indent + "new() {\n"+ indent + indent + "\n"  + indent + "}",
				"\n" + indent + "\n" + indent + "new(Collection<? extends String> c) {\n"+ indent + indent + "super(c)\n" + indent + "}",
				"\n" + indent + "\n" + indent + "new(int initialCapacity) {\n"+ indent + indent + "super(initialCapacity)\n" + indent + "}",
				"new"
				);
	}

	protected String getOverridingFunctionCode(String signature) {
		return "\n" + indent + "\n" + indent + "override " + signature + " {\n" + indent
				+ indent + AbstractExecutableBuilder.DEFAULT_BODY + "\n" + indent + "}";
	}

}
