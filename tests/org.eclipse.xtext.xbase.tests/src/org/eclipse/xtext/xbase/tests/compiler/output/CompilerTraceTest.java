/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler.output;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.builder.trace.AbstractTrace;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompilerTraceTest extends AbstractXbaseTestCase {
	
	public static class SimpleTrace extends AbstractTrace {

		private final AbstractTraceRegion root;

		public SimpleTrace(AbstractTraceRegion root) {
			this.root = root;
		}
		
		@Override
		protected AbstractTraceRegion getRootTraceRegion() {
			return root;
		}
		
	}
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Test 
	public void testNullLiteral() throws Exception {
		assertTrace("\nreturn #null#;", "#null#");
	}
	
	@Test 
	public void testStringLiteral() throws Exception {
		assertTrace("\nreturn #\"fo\\no\"#;", "#'fo\no'#");
	}
	
	@Test
	public void testStringLiteral_02() throws Exception {
		assertTrace("\nreturn \"f#o\\n#o\";", "#'fo\no'#");
	}
	
	@Test
	public void testFeatureCall_01() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _newArrayList = CollectionLiterals.<Object>newA#rray#List();\n" + 
				"return _newArrayList;", 
				"#newArrayList#");
	}
	
	@Test
	public void testFeatureCall_02() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _newArrayList = CollectionLiterals.<Object>newA#rrayList(#);\n" + 
				"return _newArrayList;", 
				"#newArrayList()#");
	}
	
	@Test
	public void testFeatureCall_03() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _newArrayList = CollectionLiterals.<Object>newA#rrayList#();\n" + 
				"return _newArrayList;", 
				"#newArrayList#()");
	}
	
	@Test
	public void testFeatureCall_04() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<String>newA#rrayList#();\n" + 
				"return _newArrayList;", 
				"<String>#newArrayList#()");
	}
	
	@Test
	public void testFeatureCall_05() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<Stri#ng>newArrayList#();\n" + 
				"return _newArrayList;", 
				"#<String>newArrayList()#");
	}
	
	@Test
	public void testFeatureCall_06() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<St#ri#ng>newArrayList();\n" + 
				"return _newArrayList;", 
				"<#String#>newArrayList()");
	}
	
	@Test
	public void testFeatureCall_07() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<String>newA#rrayList(\"a#\");\n" + 
				"return _newArrayList;", 
				"#newArrayList('a')#");
	}
	
	@Test
	public void testFeatureCall_08() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<String>ne#wArrayList(#);\n" + 
				"return _newArrayList;", 
				"<String>#newArrayList()#");
	}
	
	private static final Pattern p = Pattern.compile("([^#]*)#([^#]*)#([^#]*)", Pattern.DOTALL);
	
	protected void assertTrace(final String javaCodeWithMarker, String xbaseCodeWithMarker) throws Exception {
		xbaseCodeWithMarker = " " + xbaseCodeWithMarker + " ";
		Matcher xbaseMatcher = p.matcher(xbaseCodeWithMarker);
		assertTrue(xbaseMatcher.matches());
		String actualCode = xbaseMatcher.group(1) + xbaseMatcher.group(2) + xbaseMatcher.group(3); 
		XExpression model = expression(actualCode,true);
		TreeAppendable appendable = new TreeAppendable(new ImportManager(true), locationProvider, model, "  ", "\n");
		XbaseCompiler compiler = get(XbaseCompiler.class);
		JvmTypeReference returnType = typeProvider.getCommonReturnType(model, true);
		compiler.compile(model, appendable, returnType);
		String compiledJavaCode = appendable.getContent();
		Matcher javaMatcher = p.matcher(javaCodeWithMarker);
		assertTrue(javaMatcher.matches());
		String actualExpectation = javaMatcher.group(1) + javaMatcher.group(2) + javaMatcher.group(3);
		assertEquals(actualExpectation, compiledJavaCode);
		ITrace trace = new SimpleTrace(appendable.getTraceRegion());
		ILocationInResource location = trace.getBestAssociatedLocation(new TextRegion(javaMatcher.group(1).length(), javaMatcher.group(2).length()));
		assertEquals(new TextRegion(xbaseMatcher.group(1).length(), xbaseMatcher.group(2).length()), location.getRange());
	}
}
