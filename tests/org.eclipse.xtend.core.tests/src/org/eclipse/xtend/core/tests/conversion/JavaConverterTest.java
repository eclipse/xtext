/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.conversion;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.conversion.JavaConverter.ConversionResult;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author dhuebner - Initial contribution and API
 */
public class JavaConverterTest extends AbstractXtendTestCase {
	@Inject
	Provider<JavaConverter> javaConverterProvider;
	private JavaConverter j2x;

	@Before
	public void setUp() {
		j2x = javaConverterProvider.get();
	}

	@Test
	public void testSimpleCalssDeclarationCase() throws Exception {
		String javaCode = "package pack; import java.lang.Object; public class JavaToConvert<T,U> {}";
		XtendFile xtendFile = toValidFile("JavaToConvert", javaCode);
		assertEquals("pack", xtendFile.getPackage());
		assertEquals("java.lang.Object", xtendFile.getImportSection().getImportDeclarations().get(0).getImportedName());

		XtendTypeDeclaration typeDeclaration = xtendFile.getXtendTypes().get(0);
		assertEquals("JavaToConvert", typeDeclaration.getName());
		assertTrue("Compiles to class", typeDeclaration instanceof XtendClass);
		XtendClass xtendClass = (XtendClass) typeDeclaration;
		assertEquals(JvmVisibility.PUBLIC, xtendClass.getVisibility());

		assertFalse("Non Final", xtendClass.isFinal());
		assertFalse("Non Static", xtendClass.isStatic());
		//more tests here
		assertEquals("T", xtendClass.getTypeParameters().get(0).getSimpleName());
		assertEquals("U", xtendClass.getTypeParameters().get(1).getSimpleName());
	}

	@Test
	public void testSimpleInterfaceDeclarationCase() throws Exception {
		String javaCode = "public interface JavaToConvert<T> {}";
		XtendTypeDeclaration typeDeclaration = toValidTypeDeclaration("JavaToConvert", javaCode);
		assertTrue("Compiles to interface", typeDeclaration instanceof XtendInterface);

		XtendInterface xtendInterface = (XtendInterface) typeDeclaration;
		assertFalse("Non Final", xtendInterface.isFinal());
		assertFalse("Non Static", xtendInterface.isStatic());
		//more tests here
	}

	@Test
	public void testFieldDeclarationCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("public class JavaToConvert { private String str = \"myString\";}");
		EList<XtendMember> members = xtendClazz.getMembers();
		assertEquals("Simple fields count", 1, members.size());
		XtendField xtendMember = (XtendField) members.get(0);
		assertEquals(JvmVisibility.PRIVATE, xtendMember.getVisibility());
		assertEquals("String", xtendMember.getType().getSimpleName());
		assertEquals("str", xtendMember.getName());
		assertEquals("myString", ((XStringLiteral) xtendMember.getInitialValue()).getValue());
	}

	@Test
	public void testFieldVisibility() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("public class JavaToConvert { " + "private String priv ;"
				+ "public String pub;" + "protected String prot;" + "String def;" + "}");
		checkVisibility(xtendClazz);
		xtendClazz = toValidXtendClass("public class JavaToConvert { " + "private static String priv ;"
				+ "public static String pub;" + "protected static String prot;" + "static String def;" + "}");
		checkVisibility(xtendClazz);
	}

	private void checkVisibility(XtendClass xtendClazz) {
		EList<XtendMember> members = xtendClazz.getMembers();
		assertEquals("Simple fields count", 4, members.size());
		XtendField xtendMember = (XtendField) members.get(0);

		assertEquals("priv", xtendMember.getName());
		assertEquals("field PRIVATE visibility", JvmVisibility.PRIVATE, xtendMember.getVisibility());
		assertEquals("String", xtendMember.getType().getSimpleName());

		xtendMember = (XtendField) members.get(1);
		assertEquals("pub", xtendMember.getName());
		assertEquals("field public visibility", JvmVisibility.PUBLIC, xtendMember.getVisibility());
		assertEquals("String", xtendMember.getType().getSimpleName());

		xtendMember = (XtendField) members.get(2);
		assertEquals("prot", xtendMember.getName());
		assertEquals("field PROTECTED visibility", JvmVisibility.PROTECTED, xtendMember.getVisibility());
		assertEquals("String", xtendMember.getType().getSimpleName());

		xtendMember = (XtendField) members.get(3);
		assertEquals("def", xtendMember.getName());
		assertEquals("field DEFAULT visibility", JvmVisibility.DEFAULT, xtendMember.getVisibility());
		assertEquals("String", xtendMember.getType().getSimpleName());
	}

	@Test
	public void testOverrideMethodeDeclarationCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("public class JavaToConvert {  @Override public String toString() {} }");
		EList<XtendMember> members = xtendClazz.getMembers();
		assertEquals("Simple methods count", 1, members.size());
		XtendFunction xtendMember = (XtendFunction) members.get(0);
		assertEquals(JvmVisibility.PUBLIC, xtendMember.getVisibility());
		assertTrue(xtendMember.isOverride());
		assertEquals("String", xtendMember.getReturnType().getSimpleName());
		assertEquals("toString", xtendMember.getName());
	}

	@Test
	public void testMethodeDeclarationCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("public class JavaToConvert { public boolean visit(final Object node) { return true;}}");
		EList<XtendMember> members = xtendClazz.getMembers();
		assertEquals("Simple methods count", 1, members.size());
		XtendFunction xtendMember = (XtendFunction) members.get(0);
		assertEquals(JvmVisibility.PUBLIC, xtendMember.getVisibility());
		assertEquals("boolean", xtendMember.getReturnType().getSimpleName());
		assertEquals("visit", xtendMember.getName());
	}

	@Test
	public void testBasicForStatementCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("import java.util.Iterator; public class JavaToConvert { StringBuffer fBuffer=null; public void visit(Node node) {this.fBuffer.append(\"{\");"
				+ "for (Iterator<Statement> it= node.statements().iterator(); it.hasNext();) {"
				+ "Statement s= it.next(); s.accept(this);this.fBuffer.append(\"}\");"
				+ "} }interface Node { Iterable statements(); } interface Statement { void accept(JavaToConvert v); }");
		EList<XtendMember> members = xtendClazz.getMembers();
		assertEquals("Simple methods count", 4, members.size());
		XtendFunction xtendMember = (XtendFunction) members.get(1);
		assertEquals(JvmVisibility.PUBLIC, xtendMember.getVisibility());
		assertEquals("void", xtendMember.getReturnType().getSimpleName());
		assertEquals("visit", xtendMember.getName());
	}

	@Test
	public void testOverride() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("import public class JavaToConvert implements Statement{"
				+ "public Iterable statements() { return null;} " + "public String toString() { return null;} "
				+ "public void accept(JavaToConvert v){}}" + "interface Node { Iterable statements(); } "
				+ "interface Statement extends Node{ void accept(JavaToConvert v); }");
		EList<XtendMember> members = xtendClazz.getMembers();
		assertEquals("Simple methods count", 3, members.size());
		assertTrue(((XtendFunction) members.get(0)).isOverride());
		assertTrue(((XtendFunction) members.get(1)).isOverride());
		assertTrue(((XtendFunction) members.get(2)).isOverride());
	}

	@Test
	public void testStringLiteralCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("class TestStringLiteral { String withLineWrap=\"string with wrap\\n\";}");
		XtendField xtendMember = (XtendField) xtendClazz.getMembers().get(0);
		assertEquals("withLineWrap", xtendMember.getName());
		assertEquals("string with wrap\n", ((XStringLiteral) xtendMember.getInitialValue()).getValue());
	}

	@Test
	public void testSimpleTypeParameterCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("public class TestTypeParameter <T,U extends T> { <D extends T>  T doStuff(Iterable<? super U> us, Iterable<? extends D> d, T t) { return t; }}");
		JvmTypeParameter typeParameter = xtendClazz.getTypeParameters().get(0);
		assertEquals("T", typeParameter.getName());
		typeParameter = xtendClazz.getTypeParameters().get(1);
		assertEquals("U", typeParameter.getName());
		assertEquals("extends T", typeParameter.getConstraints().get(0).getSimpleName());

		XtendFunction xtendMember = (XtendFunction) xtendClazz.getMembers().get(0);
		assertEquals("doStuff", xtendMember.getName());
		typeParameter = xtendMember.getTypeParameters().get(0);
		assertEquals("D", typeParameter.getName());
		assertEquals("extends T", typeParameter.getConstraints().get(0).getSimpleName());

	}

	@Test
	public void testSimpleAssigmentCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("class TestAssiment {  void doStuff() { String x = null; x = new String();}");
		assertNotNull(xtendClazz);

	}

	@Test
	public void testSimpleInstanceOfCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("class Test {  void doStuff() { String x = null; if(!(x instanceof String)) x = \"\";}");
		assertNotNull(xtendClazz);
	}

	@Test
	public void testCommentsCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("/** javadoc */public class TestComment { //singleline \\n void doStuff() { /*multiline*/}");
		assertNotNull(xtendClazz);

	}

	@Test
	public void testCastCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("public class TestCast { void doStuff() { Object o = (Object)this;}");
		assertNotNull(xtendClazz);

	}

	@Test
	public void testIfElseCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("public class TestCast { Object o=null; String it = (o==null)?\"true\":\"false\";"
				+ "String other = it; public void fooo() {this.it = null;}}");
		assertNotNull(xtendClazz);

	}

	@Test
	public void testStaticImportCase() throws Exception {
		XtendClass xtendClazz = toValidXtendClass("package foo; import static java.awt.AWTEvent.*; public class Test { long o= ACTION_EVENT_MASK;}");
		XtendField xtendMember = (XtendField) xtendClazz.getMembers().get(0);
		assertEquals("o", xtendMember.getName());
		XFeatureCall xFeatureCall = (XFeatureCall) xtendMember.getInitialValue();
		assertEquals("ACTION_EVENT_MASK", xFeatureCall.getFeature().getSimpleName());

	}

	@Test
	public void testInnerClassCase() throws Exception {
		ConversionResult conversionResult = j2x.toXtend("Clazz", "public class Clazz { class Inner {}"
				+ " public void inMeth() { class OuterImpl extends Outer {} }}");
		String xtendCode = conversionResult.getXtendCode();
		assertFalse(xtendCode.isEmpty());
		assertEquals(2, Iterables.size(conversionResult.getProblems()));
	}

	@Test
	public void testStaticBlockCase() throws Exception {
		ConversionResult conversionResult = j2x.toXtend("Clazz",
				"public class Clazz { static String foo;static{foo=\"\";}}");
		String xtendCode = conversionResult.getXtendCode();
		assertFalse(xtendCode.isEmpty());
		assertEquals(0, Iterables.size(conversionResult.getProblems()));
	}

	@Test
	public void testConstructorCase() throws Exception {
		XtendClass clazz = toValidXtendClass("public class Clazz { public Clazz(){}}");
		assertEquals(JvmVisibility.PUBLIC, ((XtendConstructor) clazz.getMembers().get(0)).getVisibility());

	}

	@Test
	public void testArrayAccessCase() throws Exception {
		XtendClass clazz = toValidXtendClass("public class Clazz { String foo(String... strAr) { "
				+ "String a = (strAr[0] =\"2\"); strAr[1]=a; a=strAr[0]+strAr[1]; return strAr[1]=\"\";}");
		assertNotNull(clazz);
	}

	@Test
	public void testArrayCreationCase() throws Exception {
		XtendClass clazz = toValidXtendClass("public class Clazz {" + " String[] arr = new String[]{\"\",\"\"};"
				+ "Class<?>[] argTypes = new Class[arr.length];}");
		assertNotNull(clazz);
	}

	@Test
	public void testPrefixPlusMinusCase() throws Exception {
		XtendClass clazz = toValidXtendClass("public class Clazz { " + "public static main(String[] args) {"
				+ "int i=3; System.out.print(\"4=\");System.out.println(++i);"
				+ "System.out.print(\"3=\");System.out.println(--i);" + "}}");
		assertNotNull(clazz);
	}

	@Test
	public void testPrefixPlusMinusArrayCase() throws Exception {
		XtendClass clazz = toValidXtendClass("public class Clazz { " + "public static main(String[] args) {"
				+ "int[] ints = new int[]{1,2,3,4,5};" + "int in = 2;"
				//				+ "System.out.println(\"3=\"+(ints[in++]++));"
				//				+ "System.out.println(\"4=\"+(ints[in--]--));"
				+ "System.out.println(\"1=\"+(--ints[--in]));" + "System.out.println(\"5=\"+(++ints[++in]));" + "}}");
		assertNotNull(clazz);
	}

	private XtendClass toValidXtendClass(String javaCode) throws Exception {
		return (XtendClass) toValidTypeDeclaration("Clazz", javaCode);
	}

	private XtendTypeDeclaration toValidTypeDeclaration(String unitName, String javaCode) throws Exception {
		XtendFile file = toValidFile(unitName, javaCode);
		XtendTypeDeclaration typeDeclaration = file.getXtendTypes().get(0);
		return typeDeclaration;
	}

	private XtendFile toValidFile(String unitName, String javaCode) throws Exception {
		ConversionResult conversionResult = j2x.toXtend(unitName, javaCode);
		String xtendCode = conversionResult.getXtendCode();
		System.out.println(xtendCode);
		for (String problem : conversionResult.getProblems()) {
			System.err.println(problem);
		}
		return file(xtendCode, true);
	}

}
