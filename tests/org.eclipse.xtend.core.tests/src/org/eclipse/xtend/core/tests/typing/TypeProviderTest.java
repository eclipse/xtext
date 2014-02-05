/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typing;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class TypeProviderTest extends AbstractXtendTestCase {

	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Override
	protected XtendFile file(String string) throws Exception {
		return file(string, true);
	}
	
	protected XtendConstructor constructor(String string, boolean validate) throws Exception {
		String clazzString = "class Foo { " + string + "}";
		XtendClass clazz = (XtendClass) file(clazzString, validate).getXtendTypes().get(0);
		return (XtendConstructor) clazz.getMembers().get(0);
	}
	
	@Test public void testBug403357_01() throws Exception {
		doTestBug403357("#[]", "List<String>");
	}
	@Test public void testBug403357_02() throws Exception {
		doTestBug403357("#['']", "List<String>");
	}
	@Test public void testBug403357_03() throws Exception {
		doTestBug403357("newArrayList", "ArrayList<String>");
	}
	@Test public void testBug403357_04() throws Exception {
		doTestBug403357("newArrayList('')", "ArrayList<String>");
	}
	
	protected void doTestBug403357(String expression, String expectation) throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class C {\n" +
				"	def static m() {\n" + 
				"		printMe(" + expression +")\n" +
				"		" + expression +".printMe\n" +
				"		val list = " + expression + "\n" +
				"		printMe(list)\n" +
				"		list.printMe\n" + 
				"	}\n" +
				"	static def void printMe(List<String> listOfStrings) {}" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		XExpression firstArgument = featureCall.getFeatureCallArguments().get(0);
		assertEquals(expectation, getType(firstArgument).getSimpleName());
		XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) body.getExpressions().get(1);
		XExpression target = memberFeatureCall.getMemberCallTarget();
		assertEquals(expectation, getType(target).getSimpleName());
		XFeatureCall deferredFeatureCall = (XFeatureCall) body.getExpressions().get(3);
		XExpression deferredFirstArgument = deferredFeatureCall.getFeatureCallArguments().get(0);
		assertEquals(expectation, getType(deferredFirstArgument).getSimpleName());
		XMemberFeatureCall deferredMemberFeatureCall = (XMemberFeatureCall) body.getExpressions().get(4);
		XExpression deferredTarget = deferredMemberFeatureCall.getMemberCallTarget();
		assertEquals(expectation, getType(deferredTarget).getSimpleName());
	}
	
	private LightweightTypeReference getType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}
	private LightweightTypeReference getExpectedType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getExpectedType(expression);
	}
	private LightweightTypeReference getExpectedReturnType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getExpectedReturnType(expression);
	}
	private LightweightTypeReference getType(JvmIdentifiableElement identifiable) {
		return typeResolver.resolveTypes(identifiable).getActualType(identifiable);
	}

	@Test public void testResolvedMultiType_01() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import java.util.ArrayList\n" +
				"import java.util.LinkedList\n" +
				"class C {\n" +
				"	def m() {\n" + 
				"		if (true) new ArrayList<String> else new LinkedList<String>\n" + 
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) c.getMembers().get(0);
		Set<EObject> jvmElements = jvmModelAssociations.getJvmElements(function);
		JvmIdentifiableElement operation = (JvmIdentifiableElement) jvmElements.iterator().next();
		assertEquals("AbstractList<String>", getType(operation).getSimpleName());
	}
	
	@Test public void testResolvedMultiType_02() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import java.util.ArrayList\n" +
				"import java.util.LinkedList\n" +
				"class C {\n" +
				"	def m() {\n" + 
				"		#[ if (true) new ArrayList<String> else new LinkedList<String> ]\n" + 
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) c.getMembers().get(0);
		Set<EObject> jvmElements = jvmModelAssociations.getJvmElements(function);
		JvmIdentifiableElement operation = (JvmIdentifiableElement) jvmElements.iterator().next();
		assertEquals("List<AbstractList<String>>", getType(operation).getSimpleName());
	}
	
	@Test public void testClosureType_01() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class C {\n" +
				"	def <T1, T2, T3> a((T1)=>T2 p1, (T2)=>T3 p2) {\n" + 
				"		[T1 p|p2.apply(p1.apply(p))]\n" + 
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction function = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XExpression lambda = body.getExpressions().get(0);
		assertEquals("(T1)=>T3", getType(lambda).getSimpleName());
	}
	
	@Test public void testDeferredTypeArgumentResolution_01() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
						"class C {\n" +
						"	def String m(String s) {\n" +
						"		newArrayList().iterator.next\n" + 
						"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall next = findSingleFeatureCall(c);
		assertEquals("java.util.Iterator.next()", next.getFeature().getIdentifier());
		assertEquals("String", getType(next).getSimpleName());
	}
	
	@Test public void testDeferredTypeArgumentResolution_02() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class C {\n" +
				"	def CharSequence m(String s) {\n" +
				"		newArrayList().get(0)	\n" + 
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall get = findSingleFeatureCall(c);
		assertEquals("java.util.ArrayList.get(int)", get.getFeature().getIdentifier());
		assertEquals("CharSequence", getType(get).getSimpleName());
	}
	
	@Test public void testDeferredTypeArgumentResolution_03() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class C {\n" +
				"	def String m(String s) {\n" +
				"		newArrayList.flatten.head\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall head = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.head(java.lang.Iterable)", head.getFeature().getIdentifier());
		assertEquals("String", getType(head).getSimpleName());
	}
	
	@Ignore("TODO")
	@Test public void testDeferredTypeArgumentResolution_04() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class C {\n" +
				"	def <T> T method(java.util.Collection<T> c, (T, T)=>T fun) {}\n" +
				"	def m() {\n" +
				"		method(newArrayList('')) [ CharSequence cs, s2 | cs + s2 ]\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall head = findSingleFeatureCall(c);
		assertEquals("CharSequence", getType(head).getSimpleName());
	}
	
	@Ignore("TODO")
	@Test public void testDeferredTypeArgumentResolution_05() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class C {\n" +
				"	def <T> T method(java.util.Collection<T> c, (T, T)=>T fun) {}\n" +
				"	def m() {\n" +
				"		method(newArrayList('')) [ s1, s2 | null as CharSequence ]\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall head = findSingleFeatureCall(c);
		assertEquals("CharSequence", getType(head).getSimpleName());
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
		assertEquals("XtendFile", getType(parse).getSimpleName());
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
		assertEquals("XtendFile", getType(parse).getSimpleName());
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
		assertEquals("T", getType(parse).getSimpleName());
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
		assertEquals("F", getType(parse).getSimpleName());
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
		assertEquals("F", getType(parse).getSimpleName());
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
		assertEquals("XtendFile", getType(parse).getSimpleName());
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
		assertEquals("F", getType(parse).getSimpleName());
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
		assertEquals("XtendFile", getType(parse).getSimpleName());
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
		assertEquals("XtendFile", getType(parse).getSimpleName());
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
		assertEquals("XtendFile", getType(parse).getSimpleName());
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
		assertEquals("T", getType(parse).getSimpleName());
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
		assertEquals("F", getType(parse).getSimpleName());
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
		assertEquals("Set<String>", getExpectedType(newHashSet).getSimpleName());
		assertEquals("HashSet<String>", getType(newHashSet).getSimpleName());
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
		assertEquals("HashSet<T>", getType(newHashSet).getSimpleName());
		assertEquals("Set<T>", getExpectedType(newHashSet).getSimpleName());
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
		assertEquals("Class<?>[]", getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<?>>", getType(newArrayList).getSimpleName());
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
		assertEquals("Class<T>[]", getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<T>>", getType(newArrayList).getSimpleName());
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
		assertEquals("Class<? super T>[]", getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<? super T>>", getType(newArrayList).getSimpleName());
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
		assertEquals("Class<? extends T>[]", getExpectedType(newArrayList).getSimpleName());
		assertEquals("ArrayList<Class<? extends T>>", getType(newArrayList).getSimpleName());
	}
	
	@Test public void testReturnTypeInConstructor_01() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	''.toString\n" + 
				"}\n");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		assertEquals("void", getExpectedType(body).getIdentifier());
		assertEquals("void", getExpectedReturnType(body).getIdentifier());
		XMemberFeatureCall toString = (XMemberFeatureCall) body.getExpressions().get(0);
		assertNull(getExpectedType(toString));
		assertNull(getExpectedReturnType(toString));
	}
	
	@Test public void testReturnTypeInConstructor_02() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	return ''.toString\n" + 
				"}\n", false);
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		assertEquals("void", getExpectedType(body).getIdentifier());
		assertEquals("void", getExpectedReturnType(body).getIdentifier());
		XReturnExpression returnExpression = (XReturnExpression) body.getExpressions().get(0);
		XMemberFeatureCall toString = (XMemberFeatureCall) returnExpression.getExpression();
		assertEquals("void", getExpectedType(toString).getIdentifier());
		assertEquals("void", getExpectedReturnType(toString).getIdentifier());
	}
	
	@Test public void testTypeOfSuperInConstructor() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	super()\n" + 
				"}\n");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		XFeatureCall superCall = (XFeatureCall) body.getExpressions().get(0);
		assertEquals("void", getType(superCall).getIdentifier());
		assertNull(getExpectedType(superCall));
		assertNull(getExpectedReturnType(superCall));
	}
	
	@Test public void testTypeOfThisInConstructor() throws Exception {
		XtendConstructor constructor = constructor(
				"new(int a) {\n" + 
				"	this()\n" + 
				"}\n" +
				"new() {}");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		XFeatureCall thisCall = (XFeatureCall) body.getExpressions().get(0);
		assertEquals("void", getType(thisCall).getIdentifier());
		assertNull(getExpectedType(thisCall));
		assertNull(getExpectedReturnType(thisCall));
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
		LightweightTypeReference type = getType(call.getMemberCallTarget());
		assertEquals("List<? extends T>", type.getSimpleName());
		assertEquals("List<? extends T>", xtendParameter.getParameterType().getSimpleName());
	}

	@Test public void testTypeOfRichStringWithExpectedString() throws Exception {
		XtendFunction function = function("def String foo() '''" +
				"SomeString" +
				"'''");
		XExpression expression = function.getExpression();
		assertEquals("java.lang.String", getType(expression).getIdentifier());
	}

	@Test public void testTypeOfRichStringWithExpectedString_1() throws Exception {
		XtendFunction function = function("def String foo(String x) {" +
				"foo('''someString''')" +
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XAbstractFeatureCall call = (XAbstractFeatureCall) block.getExpressions().get(0);
		XExpression expression = call.getExplicitArguments().get(0);
		assertEquals("java.lang.String", getType(expression).getIdentifier());
	}

	@Ignore("TODO improve expectation if the expected type is an unresolved type parameter")
	@Test public void testTypeOfRichStringWithExpectedString_2() throws Exception {
		XtendFunction function = function("def String foo(String x) {" +
				"println('''someString''')" +
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XAbstractFeatureCall call = (XAbstractFeatureCall) block.getExpressions().get(0);
		XExpression expression = call.getExplicitArguments().get(0);
		assertEquals("java.lang.String", getType(expression).getIdentifier());
	}

	@Ignore("TODO improve expectation if the expected type is an unresolved type parameter")
	@Test public void testTypeOfRichStringWithExpectedString_3() throws Exception {
		XtendFunction function = function("def foo(String x) {" +
				"System::out.println('''someString''')" +
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XMemberFeatureCall call = (XMemberFeatureCall) block.getExpressions().get(0);
		XExpression expression = call.getMemberCallArguments().get(0);
		assertEquals("java.lang.String", getType(expression).getIdentifier());
	}

	@Test public void testTypeOfRichStringWithNoExpectedString() throws Exception {
		XtendFunction function = function("def foo() '''" +
				"SomeString" +
				"'''");
		XExpression expression = function.getExpression();
		assertEquals("java.lang.CharSequence", getType(expression).getIdentifier());
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
		assertEquals("java.lang.String", getType(expression).getIdentifier());
	}

	@Test public void testTypeOfRichStringDelegatingType() throws Exception {
		XtendFunction function = function("def String foo()'''someString'''");
		XExpression expression = function.getExpression();
		assertEquals("java.lang.String", getType(expression).getIdentifier());
	}
	
	@Test public void testTypeOfRichStringWithExpectedStringConcatenation() throws Exception {
		XtendFunction function = function("def org.eclipse.xtend2.lib.StringConcatenation foo() '''" +
				"SomeString" +
				"'''");
		XExpression expression = function.getExpression();
		assertEquals(StringConcatenation.class.getCanonicalName(), getType(expression).getIdentifier());
	}

}
