/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import java.io.StringWriter;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

public class Xtend2CompilerTest extends AbstractXtend2TestCase {

	public void testJavaLangReflectImport() throws Exception {
		final String input = "package foo\n" +
				"class Bar {\n" +
				"  void doStuff(java.lang.reflect.Method m) {}\n" +
				"}\n";
		final String expected = "package foo;\n" + 
				"\n" +
				"import java.lang.reflect.Method;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" + 
				"public class Bar {\n" +
				"  private final Bar _this = this;\n" + 
				"  \n" +
				"  public void doStuff(final Method m) {\n" + 
				"  }\n" + 
				"}";
		assertCompilesTo(expected, input);
	}
	
	public void testSimple() throws Exception {
		final String input = "package foo\n" +
		"class Bar {\n" +
		"  Integer doStuff(String x) {x.length}\n" +
		"}\n";
		final String expected = "package foo;\n" + 
		"\n" +
		"\n" +
		"@SuppressWarnings(\"all\")\n" + 
		"public class Bar {\n" +
		"  private final Bar _this = this;\n" + 
		"  \n" +
		"  public Integer doStuff(final String x) {\n" + 
		"    int _length = x.length();\n" + 
		"    return ((Integer)_length);\n" + 
		"  }\n" + 
		"}";
		assertCompilesTo(expected, input);
	}
	
	public void testConstructor() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar {\n" +
		"  foo() {new String()}\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar {\n" +
		"  private final Bar _this = this;\n" + 
		"  \n" + 
		"  public String foo() {\n" + 
		"    String _string = new String();\n" + 
		"    return _string;\n" + 
		"  }\n" + 
		"}";
		assertCompilesTo(expected, input);
	}

	public void testExtends() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar extends Object {\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar extends Object {\n" +
		"  private final Bar _this = this;\n" + 
		"}";
		assertCompilesTo(expected, input);
	}

	public void testImplements() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar implements Cloneable, java.io.Serializable {\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"import java.io.Serializable;\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar implements Cloneable, Serializable {\n" +
		"  private final Bar _this = this;\n" + 
		"}";
		assertCompilesTo(expected, input);
	}
	
	public void testConstructor_2() throws Exception {
		final String input = 
			"package foo\n" +
			"class Bar {\n" +
			"  foo() {new java.util.HashMap<String,java.io.Serializable>()}" +
			"}\n";
		final String expected =  
			"package foo;\n" +
			"\n" + 
			"import java.io.Serializable;\n" + 
			"import java.util.HashMap;\n" + 
			"\n" +
			"@SuppressWarnings(\"all\")\n" +
			"public class Bar {\n" +
			"  private final Bar _this = this;\n" +
			"  \n" +
			"  public HashMap<String,Serializable> foo() {\n" +
			"    HashMap<String,Serializable> _hashMap = new HashMap<String,Serializable>();\n" + 
			"    return _hashMap;\n" +
			"  }\n" + 
			"}";
		assertCompilesTo(expected, input);
	}
	
	protected static class JavaxInjectAwareTypeReferences extends TypeReferences {
		
		private boolean javaxInjectAvailable = true;
		
		@Override
		public JvmTypeReference getTypeForName(String typeName, Notifier context, JvmTypeReference... params) {
			if ("javax.inject.Inject".equals(typeName)) {
				if (javaxInjectAvailable) {
					JvmAnnotationType inject = TypesFactory.eINSTANCE.createJvmAnnotationType();
					inject.setPackageName("javax.inject");
					inject.setSimpleName("Inject");
					return createTypeRef(inject);
				} else {
					return null;
				}
			}
			return super.getTypeForName(typeName, context, params);
		}
	}
	
	public void testJavaxInject() throws Exception {
		final String input = 
			"package foo\n" +
			"class Bar {\n" +
			"  @Inject String" +
			"}\n";
		final String expected =  
			"package foo;\n" +
			"\n" + 
			"import javax.inject.Inject;\n" + 
			"\n" +
			"@SuppressWarnings(\"all\")\n" +
			"public class Bar {\n" +
			"  private final Bar _this = this;\n" +
			"  @Inject private String string;\n" + 
			"}";
		XtendFile file = file(input,true);
		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		JavaxInjectAwareTypeReferences typeReferences = get(JavaxInjectAwareTypeReferences.class);
		typeReferences.javaxInjectAvailable = true;
		compiler.setTypeReferences(typeReferences);
		StringWriter appendable = new StringWriter();
		compiler.compile(file, appendable);
		assertEquals(expected,appendable.toString());
	}
	
	public void testGoogleInject() throws Exception {
		final String input = 
			"package foo\n" +
			"class Bar {\n" +
			"  @Inject String" +
			"}\n";
		final String expected =  
			"package foo;\n" +
			"\n" + 
			"import com.google.inject.Inject;\n" + 
			"\n" +
			"@SuppressWarnings(\"all\")\n" +
			"public class Bar {\n" +
			"  private final Bar _this = this;\n" +
			"  @Inject private String string;\n" + 
			"}";
		XtendFile file = file(input,true);
		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		JavaxInjectAwareTypeReferences typeReferences = get(JavaxInjectAwareTypeReferences.class);
		typeReferences.javaxInjectAvailable = false;
		compiler.setTypeReferences(typeReferences);
		StringWriter appendable = new StringWriter();
		compiler.compile(file, appendable);
		assertEquals(expected,appendable.toString());
	}

	protected void assertCompilesTo(final String expected, final String input) throws Exception {
		XtendFile file = file(input,true);
		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		StringWriter appendable = new StringWriter();
		compiler.compile(file, appendable);
		assertEquals(expected,appendable.toString());
	}
	
}
