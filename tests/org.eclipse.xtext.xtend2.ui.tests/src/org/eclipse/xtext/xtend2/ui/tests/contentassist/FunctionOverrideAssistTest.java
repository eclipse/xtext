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
import org.eclipse.xtext.xtend2.formatting.OverrideFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FunctionOverrideAssistTest extends AbstractXtendContentAssistBugTest {

	@Inject
	private IIndentationInformation indent;

	public void testAbstractMethod() throws Exception {
		newBuilder().append("class Foo implements Comparable<String> { co").assertText(
				getOverridingFunctionCode("compareTo(String o)"));
	}

	public void testAbstractAndNonAbstractMethod() throws Exception {
		newBuilder().append("class Foo implements Comparable<String> { c").assertText(
				getOverridingFunctionCode("compareTo(String o)"),
				"\n"+indent.getIndentString() + "override protected clone() throws CloneNotSupportedException {\n" + 
				indent.getIndentString() + indent.getIndentString() + "super.clone()\n" +
				indent.getIndentString() + "}\n");
	}

	public void testStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { currentT").assertText("");
	}

	public void testNonStaticMethod() throws Exception {
		newBuilder().append("class Foo extends Thread { getI").assertText(
				"\n" + 
				indent.getIndentString() + "override getId() {\n" + 
				indent.getIndentString() + indent.getIndentString() + "super.getId()\n" + 
				indent.getIndentString() + "}\n");
	}

	protected String getOverridingFunctionCode(String signature) {
		return "\n" + indent.getIndentString() + "override " + signature + " {\n" + indent.getIndentString()
				+ indent.getIndentString() + OverrideFunction.DEFAULT_BODY + "\n" + indent.getIndentString() + "}\n";
	}

	public static Test suite() {
		return createSuite(FunctionOverrideAssistTest.class);
	}

}
