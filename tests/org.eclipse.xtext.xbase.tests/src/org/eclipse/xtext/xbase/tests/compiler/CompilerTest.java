/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXbaseTestCase {
	
	@Inject
	private ITypeProvider typeProvider;
	
	public void testSimple() throws Exception {
		assertCompilesTo("\nint _length = \"foo\".length();\n" + 
				"return _length;", "'foo'.length");
	}
	
	public void testBlock() throws Exception {
		assertCompilesTo(
				"\nint _xblockexpression = (int)-1;\n" +
				"{\n" +
				"  final java.util.ArrayList<String> _this = new java.util.ArrayList<String>();\n" +
				"  int _size = _this.size();\n" + 
				"  _xblockexpression = (_size);\n" +
				"}\n" +
				"return _xblockexpression;"
				, "{ val this = new java.util.ArrayList<String>(); size;}");
	}
	
	public void testIf() throws Exception {
		assertCompilesTo(
				"\nInteger _xifexpression = null;\n" +
				"if (true) {\n" +
				"  _xifexpression = 42;\n" +
				"} else {\n" +
				"  _xifexpression = 21;\n}\n" +
				"return _xifexpression;"
				, "if (true) 42 else 21");
	}

	public void testForEach() throws Exception {
		assertCompilesTo(
				"\nfor (String s : new java.util.ArrayList<String>()) {\n" +
				"  s.length();\n" +
				"}"
				, "for (String s : new java.util.ArrayList<String>())" +
						"s.length");
	}
	
	protected void assertCompilesTo(final String expectedJavaCode, final String xbaseCode) throws Exception {
		XExpression model = expression(xbaseCode,true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		IAppendable appandable = new IAppendable.StringBuilderBasedAppendable();
		JvmTypeReference returnType = typeProvider.getCommonReturnType(model, true);
		compiler.compile(model,appandable, returnType);
		assertEquals(expectedJavaCode,appandable.toString());
	}
}
