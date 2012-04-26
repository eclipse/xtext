/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.core.formatting.MemberFromSuperImplementor;
import org.eclipse.xtext.formatting.IIndentationInformation;
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
		newBuilder().append("class Foo implements Comparable<String> { cl").assertText(
				"\n" + indent + "\n" + indent + "override protected clone() throws CloneNotSupportedException {\n" + 
				indent + indent + "super.clone()\n" +
				indent + "}");
	}

	@Test public void testStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { currentT").assertText("");
	}

	@Test public void testNonStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { getI").assertText(
				"\n" + indent + "\n" + 
				indent + "override getId() {\n" + 
				indent + indent + "super.getId()\n" + 
				indent + "}");
	}
	
	@Test public void testConstructor() throws Exception {
		newBuilder().append("class Foo extends Exception { new").assertText(
				"\n" + indent + "\n" + indent + "new() {\n"+ indent + indent + "\n"  + indent + "}",
				"\n" + indent + "\n" + indent + "new(String message) {\n"+ indent + indent + "super(message)\n" + indent + "}",
				"\n" + indent + "\n" + indent + "new(String message, Throwable cause) {\n"+ indent + indent + "super(message, cause)\n" + indent + "}",
				"\n" + indent + "\n" + indent + "new(Throwable cause) {\n"+ indent + indent + "super(cause)\n" + indent + "}",
				"new"
				);
	}

	protected String getOverridingFunctionCode(String signature) {
		return "\n" + indent + "\n" + indent + "override " + signature + " {\n" + indent
				+ indent + MemberFromSuperImplementor.DEFAULT_BODY + "\n" + indent + "}";
	}

}
