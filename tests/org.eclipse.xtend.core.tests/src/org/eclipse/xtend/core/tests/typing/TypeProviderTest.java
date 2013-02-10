/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typing;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class TypeProviderTest extends AbstractXtendTestCase {

	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private MockedXtendTypeProvider mockedTypeProvider;

	@Override
	protected XtendFile file(String string) throws Exception {
		return file(string, true);
	}
	
	protected ITypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	protected XtendConstructor constructor(String string, boolean validate) throws Exception {
		String clazzString = "class Foo { " + string + "}";
		XtendClass clazz = (XtendClass) file(clazzString, validate).getXtendTypes().get(0);
		return (XtendConstructor) clazz.getMembers().get(0);
	}
	
	@Test public void testParameterizedExtension_01() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C {\n" + 
				"	extension ParseHelper<XtendFile>\n" +
				"	def m() {" +
				"		parse('')\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("XtendFile", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_02() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends ParseHelper<XtendFile>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		parse('')\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("XtendFile", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_03() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends XtendFile> {\n" + 
				"	extension ParseHelper<T>\n" +
				"	def m() {" +
				"		parse('')\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("T", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_04() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<F extends XtendFile, T extends ParseHelper<F>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		parse('')\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("F", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_05() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<F extends XtendFile> extends ParseHelper<F> {\n" + 
				"	def m() {" +
				"		parse('')\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("F", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_06() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C extends ParseHelper<XtendFile> {\n" + 
				"	def m() {" +
				"		parse('')\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("XtendFile", typeProvider.getType(parse).getSimpleName());
	}
	

	@Test public void testParameterizedExtension_07() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<F extends XtendFile> extends ParseHelper<F> {\n" + 
				"	def m() {" +
				"		''.parse\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("F", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_08() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C extends ParseHelper<XtendFile> {\n" + 
				"	def m() {" +
				"		''.parse\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("XtendFile", typeProvider.getType(parse).getSimpleName());
	}
	

	@Test public void testParameterizedExtension_09() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C {\n" + 
				"	extension ParseHelper<XtendFile>\n" +
				"	def m() {" +
				"		''.parse\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("XtendFile", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_10() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends ParseHelper<XtendFile>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		''.parse\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("XtendFile", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_11() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends XtendFile> {\n" + 
				"	extension ParseHelper<T>\n" +
				"	def m() {" +
				"		''.parse\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("T", typeProvider.getType(parse).getSimpleName());
	}
	
	@Test public void testParameterizedExtension_12() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<F extends XtendFile, T extends ParseHelper<F>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		''.parse\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall parse = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.junit4.util.ParseHelper.parse(java.lang.CharSequence)", parse.getFeature().getIdentifier());
		assertEquals("F", typeProvider.getType(parse).getSimpleName());
	}
	
	private XAbstractFeatureCall findSingleFeatureCall(XtendClass xtendClass) {
		XtendFunction function = (XtendFunction) xtendClass.getMembers().get(xtendClass.getMembers().size() - 1);
		XBlockExpression block = (XBlockExpression) function.getExpression();
		return (XAbstractFeatureCall) block.getExpressions().get(0);
	}
	
	@Test public void testExpectationRelevantExpressionType_01() throws Exception {
		String clazzString = "import java.util.Set\n" +
			"import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor\n" +
			"import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference\n" +
			"class C extends TypeParameterSubstitutor<Set<String>> {\n" +
			"  override substitute(LightweightTypeReference original) {\n" + 
			"    original.accept(this, newHashSet)\n" + 
			"  }" +
			"}";
		XtendClass clazz = (XtendClass) file(clazzString, false).getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XMemberFeatureCall invocation = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall newHashSet = (XFeatureCall) invocation.getActualArguments().get(1);
		assertEquals("newHashSet", newHashSet.getFeature().getSimpleName());
		assertEquals("Set<String>", typeProvider.getExpectedType(newHashSet).getSimpleName());
		assertEquals("HashSet<String>", typeProvider.getType(newHashSet).getSimpleName());
	}
	
	@Test public void testExpectationRelevantExpressionType_02() throws Exception {
		String clazzString = "import java.util.Set\n" +
				"import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor\n" +
				"import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference\n" +
				"class C<T> extends TypeParameterSubstitutor<Set<T>> {\n" +
				"  override substitute(LightweightTypeReference original) {\n" + 
				"    original.accept(this, newHashSet)\n" + 
				"  }" +
				"}";
		XtendClass clazz = (XtendClass) file(clazzString, false).getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XMemberFeatureCall invocation = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall newHashSet = (XFeatureCall) invocation.getActualArguments().get(1);
		assertEquals("newHashSet", newHashSet.getFeature().getSimpleName());
		assertEquals("HashSet<T>", typeProvider.getType(newHashSet).getSimpleName());
		assertEquals("Set<T>", typeProvider.getExpectedType(newHashSet).getSimpleName());
	}
	
	@Test public void testExpectationRelevantExpressionType_03() throws Exception {
		String clazzString = 
			"class C {\n" +
			"  def m() {\n" + 
			"    typeof(C).getMethod('', newArrayList)\n" +  
			"  }\n" +
			"}";
		XtendClass clazz = (XtendClass) file(clazzString, false).getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XMemberFeatureCall invocation = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall newArrayList = (XFeatureCall) invocation.getActualArguments().get(1);
		assertEquals("newArrayList", newArrayList.getFeature().getSimpleName());
		assertEquals("Class<?>[]", typeProvider.getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<?>>", typeProvider.getType(newArrayList).getSimpleName());
	}
	
	@Test public void testExpectationRelevantExpressionType_04() throws Exception {
		String clazzString = 
			"class C<T> {\n" +
			"  def String m(String s, Class<T>[] types) {\n" + 
			"    this.m('', newArrayList)\n" +  
			"  }\n" +
			"}";
		XtendClass clazz = (XtendClass) file(clazzString, false).getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XMemberFeatureCall invocation = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall newArrayList = (XFeatureCall) invocation.getActualArguments().get(1);
		assertEquals("newArrayList", newArrayList.getFeature().getSimpleName());
		assertEquals("Class<T>[]", typeProvider.getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<T>>", typeProvider.getType(newArrayList).getSimpleName());
	}
	
	@Test public void testExpectationRelevantExpressionType_05() throws Exception {
		String clazzString = 
				"class C<T> {\n" +
				"  def String m(String s, Class<? super T>[] types) {\n" + 
				"    this.m('', newArrayList)\n" +  
				"  }\n" +
				"}";
		XtendClass clazz = (XtendClass) file(clazzString, false).getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XMemberFeatureCall invocation = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall newArrayList = (XFeatureCall) invocation.getActualArguments().get(1);
		assertEquals("newArrayList", newArrayList.getFeature().getSimpleName());
		assertEquals("Class<? super T>[]", typeProvider.getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<? super T>>", typeProvider.getType(newArrayList).getSimpleName());
	}
	
	@Test public void testExpectationRelevantExpressionType_06() throws Exception {
		String clazzString = 
				"class C<T> {\n" +
				"  def String m(String s, Class<? extends T>[] types) {\n" + 
				"    this.m('', newArrayList)\n" +  
				"  }\n" +
				"}";
		XtendClass clazz = (XtendClass) file(clazzString, false).getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XMemberFeatureCall invocation = (XMemberFeatureCall) body.getExpressions().get(0);
		XFeatureCall newArrayList = (XFeatureCall) invocation.getActualArguments().get(1);
		assertEquals("newArrayList", newArrayList.getFeature().getSimpleName());
		assertEquals("Class<? extends T>[]", typeProvider.getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<? extends T>>", typeProvider.getType(newArrayList).getSimpleName());
	}
	
	@Test public void testReturnTypeInConstructor_01() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	''.toString\n" + 
				"}\n");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		assertEquals("void", typeProvider.getExpectedType(body).getIdentifier());
		assertEquals("void", typeProvider.getExpectedReturnType(body, true).getIdentifier());
		XMemberFeatureCall toString = (XMemberFeatureCall) body.getExpressions().get(0);
		assertNull(typeProvider.getExpectedType(toString));
		assertNull(typeProvider.getExpectedReturnType(toString, true));
	}
	
	@Test public void testReturnTypeInConstructor_02() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	return ''.toString\n" + 
				"}\n", false);
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		assertEquals("void", typeProvider.getExpectedType(body).getIdentifier());
		assertEquals("void", typeProvider.getExpectedReturnType(body, true).getIdentifier());
		XReturnExpression returnExpression = (XReturnExpression) body.getExpressions().get(0);
		XMemberFeatureCall toString = (XMemberFeatureCall) returnExpression.getExpression();
		assertEquals("void", typeProvider.getExpectedType(toString).getIdentifier());
		assertEquals("void", typeProvider.getExpectedReturnType(toString, true).getIdentifier());
	}
	
	@Test public void testTypeOfSuperInConstructor() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	super()\n" + 
				"}\n");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		XFeatureCall superCall = (XFeatureCall) body.getExpressions().get(0);
		assertEquals("void", typeProvider.getType(superCall).getIdentifier());
		assertNull(typeProvider.getExpectedType(superCall));
		assertNull(typeProvider.getExpectedReturnType(superCall, true));
	}
	
	@Test public void testTypeOfThisInConstructor() throws Exception {
		XtendConstructor constructor = constructor(
				"new(int a) {\n" + 
				"	this()\n" + 
				"}\n" +
				"new() {}");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		XFeatureCall thisCall = (XFeatureCall) body.getExpressions().get(0);
		assertEquals("void", typeProvider.getType(thisCall).getIdentifier());
		assertNull(typeProvider.getExpectedType(thisCall));
		assertNull(typeProvider.getExpectedReturnType(thisCall, true));
	}

	@Test public void testBug380063NoException() throws Exception {
		XtendClass clazz = clazz("class Foo<T> { " +
				"def foo(java.util.List<? extends T> l) { " +
				"	l.add(null)" +
				"}}");
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XtendParameter xtendParameter = function.getParameters().get(0);
		XBlockExpression expr = (XBlockExpression) function.getExpression();
		XMemberFeatureCall call = (XMemberFeatureCall) expr.getExpressions().get(0);
		JvmTypeReference type = typeProvider.getType(call.getMemberCallTarget());
		assertEquals("List<? extends T>", type.getSimpleName());
		assertEquals("List<? extends T>", xtendParameter.getParameterType().getSimpleName());
	}

	@Test public void testTypeOfRichStringWithExpectedString() throws Exception {
		XtendFunction function = function("def String foo() '''" +
				"SomeString" +
				"'''");
		XExpression expression = function.getExpression();
		assertEquals("java.lang.String", typeProvider.getType(expression).getIdentifier());
	}

	@Test public void testTypeOfRichStringWithExpectedString_1() throws Exception {
		XtendFunction function = function("def String foo(String x) {" +
				"foo('''someString''')" +
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XAbstractFeatureCall call = (XAbstractFeatureCall) block.getExpressions().get(0);
		XExpression expression = call.getExplicitArguments().get(0);
		assertEquals("java.lang.String", typeProvider.getType(expression).getIdentifier());
	}

	@Ignore("TODO improve expectation if the expected type is an unresolved type parameter")
	@Test public void testTypeOfRichStringWithExpectedString_2() throws Exception {
		XtendFunction function = function("def String foo(String x) {" +
				"println('''someString''')" +
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XAbstractFeatureCall call = (XAbstractFeatureCall) block.getExpressions().get(0);
		XExpression expression = call.getExplicitArguments().get(0);
		assertEquals("java.lang.String", typeProvider.getType(expression).getIdentifier());
	}

	@Ignore("TODO improve expectation if the expected type is an unresolved type parameter")
	@Test public void testTypeOfRichStringWithExpectedString_3() throws Exception {
		XtendFunction function = function("def foo(String x) {" +
				"System::out.println('''someString''')" +
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XMemberFeatureCall call = (XMemberFeatureCall) block.getExpressions().get(0);
		XExpression expression = call.getMemberCallArguments().get(0);
		assertEquals("java.lang.String", typeProvider.getType(expression).getIdentifier());
	}

	@Test public void testTypeOfRichStringWithNoExpectedString() throws Exception {
		XtendFunction function = function("def foo() '''" +
				"SomeString" +
				"'''");
		XExpression expression = function.getExpression();
		assertEquals("java.lang.CharSequence", typeProvider.getType(expression).getIdentifier());
	}

	@Test public void testTypeOfRichStringWithNoExpectedString_1() throws Exception {
		XtendFunction function = function("def foo(String x) {" +
				"println('''someString''')" +
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XAbstractFeatureCall call = (XAbstractFeatureCall) block.getExpressions().get(0);
		XExpression expression = call.getExplicitArguments().get(0);
		// TODO propagate the expectation better via unbound type parameters
		// could still be a charsequence, here
		assertEquals("java.lang.String", typeProvider.getType(expression).getIdentifier());
	}

	@Test public void testTypeOfRichStringDelegatingType() throws Exception {
		XtendFunction function = function("def foo()'''someString'''");
		XExpression expression = function.getExpression();
		assertEquals("java.lang.String", mockedTypeProvider.getType(expression).getIdentifier());
	}

}
