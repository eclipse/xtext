/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.contentassist;

import junit.framework.Test;

import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.xtend2.formatting.MemberFromSuperImplementor;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImplementSuperMemberAssistTest extends AbstractXtendContentAssistBugTest {

	@Inject
	private IIndentationInformation indentationInfo;
	
	private String indent;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indent = indentationInfo.getIndentString();
	}
	
	public void testAbstractMethod() throws Exception {
		newBuilder().append("class Foo implements Comparable<String> { co").assertText(
				getOverridingFunctionCode("compareTo(String o)"));
	}

	public void testNonAbstractMethod() throws Exception {
		newBuilder().append("class Foo implements Comparable<String> { cl").assertText(
				"\n" + indent + "\n" + indent + "override protected clone() throws CloneNotSupportedException {\n" + 
				indent + indent + "super.clone()\n" +
				indent + "}");
	}

	public void testStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { currentT").assertText("");
	}

	public void testNonStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { getI").assertText(
				"\n" + indent + "\n" + 
				indent + "override getId() {\n" + 
				indent + indent + "super.getId()\n" + 
				indent + "}");
	}
	
	public void testConstructor() throws Exception {
		newBuilder().append("class Foo extends Exception { new").assertText(
				"\n" + indent + "\n" + indent + "new() {\n"+ indent + indent + "\n"  + indent + "}",
				"\n" + indent + "\n" + indent + "new(String message_1) {\n"+ indent + indent + "super(message_1)\n" + indent + "}",
				"\n" + indent + "\n" + indent + "new(String message_1, Throwable cause_1) {\n"+ indent + indent + "super(message_1, cause_1)\n" + indent + "}",
				"\n" + indent + "\n" + indent + "new(Throwable cause_1) {\n"+ indent + indent + "super(cause_1)\n" + indent + "}",
				"new"
				);
	}

	protected String getOverridingFunctionCode(String signature) {
		return "\n" + indent + "\n" + indent + "override " + signature + " {\n" + indent
				+ indent + MemberFromSuperImplementor.DEFAULT_BODY + "\n" + indent + "}";
	}

	public static Test suite() {
		return createSuite(ImplementSuperMemberAssistTest.class);
	}

}
