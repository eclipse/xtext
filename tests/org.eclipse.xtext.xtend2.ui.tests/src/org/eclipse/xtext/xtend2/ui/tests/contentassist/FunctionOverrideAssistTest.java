/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.contentassist;

import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.xtend2.formatting.OverrideFunction;

import com.google.inject.Inject;

import junit.framework.Test;

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
				getOverridingFunctionCode("protected clone() throws CloneNotSupportedException"));
	}

	protected String getOverridingFunctionCode(String signature) {
		return "\n" + indent.getIndentString() + "override " + signature + " {\n" + indent.getIndentString()
				+ indent.getIndentString() + OverrideFunction.DEFAULT_BODY + "\n" + indent.getIndentString() + "}\n\n";
	}

	public static Test suite() {
		return createSuite(FunctionOverrideAssistTest.class);
	}

}
