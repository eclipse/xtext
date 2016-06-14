/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class InferredJvmModelTest extends AbstractXtendTestCase {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Test public void testXtendField_00() throws Exception {
		XtendFile xtendFile = file("class Foo { @Inject String string }");
		JvmGenericType type = getInferredType(xtendFile);
		Iterable<JvmField> iterable = type.getDeclaredFields();
		JvmField next = iterable.iterator().next();
		assertEquals("string",next.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, next.getVisibility());
		assertEquals("java.lang.String", next.getType().getIdentifier());
		for(JvmMember member: type.getMembers()) {
			if (member instanceof JvmExecutable) {
				assertEquals(JvmVisibility.PUBLIC, member.getVisibility());
			} else {
				assertEquals(JvmVisibility.PRIVATE, member.getVisibility());
			}
		}
	}
	
	@Test public void testXtendField_01() throws Exception {
		XtendFile xtendFile = file("class Foo { public String publicField protected String protectedField private String privateField }");
		JvmGenericType type = getInferredType(xtendFile);
		for(JvmField field: type.getDeclaredFields()) {
			assertEquals(JvmVisibility.get(field.getSimpleName().replace("Field","").toUpperCase()), field.getVisibility());
		}
	}
	
	@Test public void testDispatchFunction_00() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Object x) {null} def dispatch foo(String x) {null}}");
		JvmGenericType inferredType = getInferredType(xtendFile);

		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", Object.class);
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		findByNameAndFirstParameterType(operations, "_foo", Object.class);
		findByNameAndFirstParameterType(operations, "_foo", String.class);
		for(JvmMember member: inferredType.getMembers()) {
			if (member instanceof JvmExecutable) {
				if (member.getSimpleName().startsWith("_"))
					assertEquals(JvmVisibility.PROTECTED, member.getVisibility());
				else
					assertEquals(JvmVisibility.PUBLIC, member.getVisibility());
			} else {
				assertEquals(JvmVisibility.PRIVATE, member.getVisibility());
			}
		}
	}
	
	@Test public void testDispatchFunction_01() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Object x, String y) {null} def dispatch foo(String x) {null}}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// two dispatch methods
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", Object.class);
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());
		assertEquals(2, dispatch.getParameters().size());
		
		dispatch = findByNameAndFirstParameterType(operations, "foo", String.class);
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());
		assertEquals(1, dispatch.getParameters().size());
		
		// two internal case methods
		findByNameAndFirstParameterType(operations, "_foo", Object.class);
		findByNameAndFirstParameterType(operations, "_foo", String.class);
	}
	
	@Test public void testDispatchFunction_02() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Object x) {'foo'} def dispatch foo(String x) {'bar'}}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", Object.class);
		assertEquals(String.class.getName(), dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		findByNameAndFirstParameterType(operations, "_foo", Object.class);
		findByNameAndFirstParameterType(operations, "_foo", String.class);
	}
	
	@Test
	public void testDispatchFunction_03() throws Exception {
		testDispatchFunction_03_impl(true);
	}
	
	@Test
	public void testDispatchFunction_03_noValidate() throws Exception {
		testDispatchFunction_03_impl(false);
	}
	
	protected void testDispatchFunction_03_impl(boolean validation) throws Exception {
		XtendFile xtendFile = file(
				"class Dispatcher {\n" + 
				"	def dispatch doStuff(org.eclipse.emf.ecore.EClass model) {\n" + 
				"		model.ETypeParameters.map(e|doStuff(e))\n" + 
				"	}\n" + 
				"	def dispatch doStuff(org.eclipse.emf.ecore.EPackage packageDecl) {\n" + 
				"		packageDecl.EClassifiers.map(e|doStuff(e))\n" + 
				"	}\n" + 
				"	def dispatch doStuff(org.eclipse.emf.ecore.EStructuralFeature feature) {\n" + 
				"		newArrayList(feature)\n" + 
				"	}\n" + 
				"}", validation);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "doStuff", ENamedElement.class);
		// TODO ultimately this should be List<? extends NamedElement>
		assertEquals("java.util.List<? extends java.lang.Object>", dispatch.getReturnType().getIdentifier());

		// three internal case methods
		JvmOperation eClassParam = findByNameAndFirstParameterType(operations, "_doStuff", EClass.class);
		assertEquals("java.util.List<? extends java.lang.Object>", eClassParam.getReturnType().getIdentifier());
		
		JvmOperation ePackageParam = findByNameAndFirstParameterType(operations, "_doStuff", EPackage.class);
		assertEquals("java.util.List<? extends java.lang.Object>", ePackageParam.getReturnType().getIdentifier());
		
		JvmOperation eStructuralFeatureParam = findByNameAndFirstParameterType(operations, "_doStuff", EStructuralFeature.class);
		assertEquals("java.util.List<? extends java.lang.Object>", eStructuralFeatureParam.getReturnType().getIdentifier());
	}
	
	@Test public void testDispatchFunction_04() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Integer x) {x} def dispatch foo(Double x) {x}}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", Number.class);
		// return type is specialized
		assertEquals("java.lang.Number", dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		JvmOperation internal = findByNameAndFirstParameterType(operations, "_foo", Double.class);
		assertEquals(dispatch.getReturnType().getIdentifier(), internal.getReturnType().getIdentifier());
		
		internal = findByNameAndFirstParameterType(operations, "_foo", Integer.class);
		assertEquals(dispatch.getReturnType().getIdentifier(), internal.getReturnType().getIdentifier());
	}
	
	@Test public void testDispatchFunction_05() throws Exception {
		XtendFile xtendFile = file("class Foo {" + 
				"  def private dispatch private_private  (Integer x) {} def private   dispatch private_private  (Double x) {}" +
				"  def private dispatch private_protected(Integer x) {} def protected dispatch private_protected(Double x) {}" +
				"  def private dispatch private_public   (Integer x) {} def public    dispatch private_public   (Double x) {}" +
				"  def private dispatch private_default  (Integer x) {} def           dispatch private_default  (Double x) {}" +
				"  def protected dispatch protected_private  (Integer x) {} def private   dispatch protected_private  (Double x) {}" +
				"  def protected dispatch protected_protected(Integer x) {} def protected dispatch protected_protected(Double x) {}" +
				"  def protected dispatch protected_public   (Integer x) {} def public    dispatch protected_public   (Double x) {}" +
				"  def protected dispatch protected_default  (Integer x) {} def           dispatch protected_default  (Double x) {}" +
				"  def public dispatch public_private  (Integer x) {} def private   dispatch public_private  (Double x) {}" +
				"  def public dispatch public_protected(Integer x) {} def protected dispatch public_protected(Double x) {}" +
				"  def public dispatch public_public   (Integer x) {} def public    dispatch public_public   (Double x) {}" +
				"  def public dispatch public_default  (Integer x) {} def           dispatch public_default  (Double x) {}" +
				"  def dispatch default_private  (Integer x) {} def private   dispatch default_private  (Double x) {}" +
				"  def dispatch default_protected(Integer x) {} def protected dispatch default_protected(Double x) {}" +
				"  def dispatch default_public   (Integer x) {} def public    dispatch default_public   (Double x) {}" +
				"  def dispatch default_default  (Integer x) {} def           dispatch default_default  (Double x) {}" +
				"}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		for(JvmOperation op: inferredType.getDeclaredOperations()) {
			String[] split = op.getSimpleName().toUpperCase().split("_");
			JvmVisibility expectedVisibility = null;
			if(!op.getSimpleName().startsWith("_")) {
				if(equal(split[0], split[1]))
					expectedVisibility = "DEFAULT".equals(split[0]) ? JvmVisibility.PUBLIC : JvmVisibility.get(split[0]);
				else 	
					expectedVisibility = JvmVisibility.PUBLIC;
			}
			else if(equal(op.getParameters().get(0).getParameterType().getIdentifier(), "java.lang.Integer"))
				expectedVisibility = "DEFAULT".equals(split[1]) ? JvmVisibility.PROTECTED : JvmVisibility.get(split[1]);
			else
				expectedVisibility = "DEFAULT".equals(split[2]) ? JvmVisibility.PROTECTED : JvmVisibility.get(split[2]);
			assertEquals(op.getIdentifier(), expectedVisibility, op.getVisibility());
		}
	}		

	@Test public void testDispatchFunction_06() throws Exception {
		XtendFile xtendFile = file("class Foo {" +
				"def dispatch foo(Object o) throws Exception " +
				"def dispatch foo(Integer i) throws RuntimeException " +
				"}");
		Iterable<JvmOperation> operations = getInferredType(xtendFile).getDeclaredOperations();
		JvmOperation dispatcher = find(operations, new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation input) {
				return equal("foo", input.getSimpleName());
			}
		});
		Iterable<String> exceptionTypeNames = transform(dispatcher.getExceptions(), new Function<JvmTypeReference, String>() {
			@Override
			public String apply(JvmTypeReference input) {
				return input.getQualifiedName();
			}
		});
		assertEquals(2, size(exceptionTypeNames));
		assertTrue(contains(exceptionTypeNames, "java.lang.Exception")); 
		assertTrue(contains(exceptionTypeNames, "java.lang.RuntimeException")); 
	}

	@Test public void testDispatchFunction_07() throws Exception {
		XtendFile xtendFile = file("class Foo {" +
				"def dispatch foo(Object o, boolean b) " +
				"def dispatch foo(Integer i, boolean b) " +
				"}");
		Iterable<JvmOperation> operations = getInferredType(xtendFile).getDeclaredOperations();
		JvmOperation dispatcher = find(operations, new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation input) {
				return equal("foo", input.getSimpleName());
			}
		});
		JvmFormalParameter parameter = dispatcher.getParameters().get(1);
		assertEquals("boolean", parameter.getParameterType().getIdentifier());
	}
	
	@Test public void testDispatchFunction_08() throws Exception {
		XtendFile xtendFile = file("class Z {\n" +
			"  def dispatch create newArrayList foo(Object x) {}\n" +
			"  def dispatch create newArrayList foo(String x) {}\n" +
			"}\n");
		Iterable<JvmOperation> operations = getInferredType(xtendFile).getDeclaredOperations();
		JvmOperation dispatcher = find(operations, new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation input) {
				return equal("foo", input.getSimpleName());
			}
		});
		String identifier = dispatcher.getReturnType().getIdentifier();
		assertEquals("java.util.ArrayList<java.lang.Object>", identifier);
	}
	
	@Test public void testDispatchFunction_09() throws Exception {
		XtendFile xtendFile = file(
			"import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor\n" +
			"import org.eclipse.xtend.core.xtend.XtendClass\n" +
			"import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer\n" +
			"class Z extends AbstractModelInferrer {\n" +
			"  def dispatch infer(XtendClass x, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {}\n" +
			"}\n");
		Iterable<JvmOperation> operations = getInferredType(xtendFile).getDeclaredOperations();
		JvmOperation dispatcher = find(operations, new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation input) {
				return equal("infer", input.getSimpleName());
			}
		});
		JvmFormalParameter firstParameter = dispatcher.getParameters().get(0);
		assertEquals("EObject", firstParameter.getParameterType().getSimpleName());
		String returnType = dispatcher.getReturnType().getIdentifier();
		assertEquals("void", returnType);
	}
	
	@Test public void testDispatchFunction_10() throws Exception {
		XtendFile xtendFile = file(
			"class Foo {\n" +
			"	def dispatch String someMethod(String o) {\n" +
			"		\"String\".someMethod\n" +
			"	}\n" +
			"	def dispatch someMethod(Object o) {\n" +
			"		\"String\"" +
			"	}\n" +
			"	def dispatch someMethod(Double o) {\n" +
			"		\"String\""+
			"	}\n" +
			"}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "someMethod", Object.class);
		assertEquals("java.lang.String", dispatch.getReturnType().getIdentifier());

		JvmOperation dispatchCase = findByNameAndFirstParameterType(operations, "_someMethod", Object.class);
		assertEquals("java.lang.String", dispatchCase.getReturnType().getIdentifier());
		
		JvmOperation dispatchCase2 = findByNameAndFirstParameterType(operations, "_someMethod", String.class);
		assertEquals("java.lang.String", dispatchCase2.getReturnType().getIdentifier());
		
		JvmOperation dispatchCase3 = findByNameAndFirstParameterType(operations, "_someMethod", Double.class);
		assertEquals("java.lang.String", dispatchCase3.getReturnType().getIdentifier());
	}
	
	@Test public void testDispatchFunction_11() throws Exception {
		XtendFile xtendFile = file(
			"class Foo {\n" +
			"	def dispatch someMethod(Object o) {\n" +
			"		\"String\"" +
			"	}\n" +
			"	def dispatch String someMethod(String o) {\n" +
			"		\"String\".someMethod\n" +
			"	}\n" +
			"	def dispatch someMethod(Double o) {\n" +
			"		\"String\""+
			"	}\n" +
			"}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "someMethod", Object.class);
		assertEquals("java.lang.String", dispatch.getReturnType().getIdentifier());

		JvmOperation dispatchCase = findByNameAndFirstParameterType(operations, "_someMethod", Object.class);
		assertEquals("java.lang.String", dispatchCase.getReturnType().getIdentifier());
		
		JvmOperation dispatchCase2 = findByNameAndFirstParameterType(operations, "_someMethod", String.class);
		assertEquals("java.lang.String", dispatchCase2.getReturnType().getIdentifier());
		
		JvmOperation dispatchCase3 = findByNameAndFirstParameterType(operations, "_someMethod", Double.class);
		assertEquals("java.lang.String", dispatchCase3.getReturnType().getIdentifier());
	}
	
	@Test public void testBug_340611() throws Exception {
		XtendFile xtendFile = file(
				"class Bug340611 {\n" + 
				"    def dispatch foo(String string) {\n" + 
				"        string\n" + 
				"    }\n" + 
				"    def dispatch foo(Object o) {\n" + 
				"        null\n" + 
				"    }\n" + 
				"}", false);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(3, IterableExtensions.size(inferredType.getDeclaredOperations()));
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", Object.class);
		assertEquals("java.lang.String", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findByNameAndFirstParameterType(operations, "_foo", String.class);
		assertEquals("java.lang.String", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findByNameAndFirstParameterType(operations, "_foo", Object.class);
		assertEquals("java.lang.String", objectParam.getReturnType().getIdentifier());
	}
	
	@Test public void testBug_340611_02() throws Exception {
		XtendFile xtendFile = file(
				"class Bug340611 {\n" + 
				"    def dispatch foo(String string) {\n" + 
				"        string\n" + 
				"    }\n" + 
				"    def dispatch foo(CharSequence charSeq) {\n" + 
				"        charSeq\n" + 
				"    }\n" + 
				"}", false);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(3, IterableExtensions.size(inferredType.getDeclaredOperations()));
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", CharSequence.class);
		assertEquals("java.lang.CharSequence", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findByNameAndFirstParameterType(operations, "_foo", String.class);
		assertEquals("java.lang.CharSequence", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findByNameAndFirstParameterType(operations, "_foo", CharSequence.class);
		assertEquals("java.lang.CharSequence", objectParam.getReturnType().getIdentifier());
	}
	
	@Test public void testBug_340611_03() throws Exception {
		XtendFile xtendFile = file(
				"class Bug340611 {\n" + 
				"    def dispatch foo(Appendable appendable) {\n" + 
				"        appendable\n" + 
				"    }\n" + 
				"    def dispatch foo(CharSequence charSeq) {\n" + 
				"        charSeq\n" + 
				"    }\n" + 
				"}", false);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(3, IterableExtensions.size(inferredType.getDeclaredOperations()));
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", Object.class);
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findByNameAndFirstParameterType(operations, "_foo", Appendable.class);
		assertEquals("java.lang.Object", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findByNameAndFirstParameterType(operations, "_foo", CharSequence.class);
		assertEquals("java.lang.Object", objectParam.getReturnType().getIdentifier());
	}
	
	@Test public void testBug_340611_04() throws Exception {
		XtendFile xtendFile = file(
				"class Bug340611 {\n" + 
				"    def dispatch Appendable foo(Appendable appendable) {\n" + 
				"        appendable\n" + 
				"    }\n" + 
				"    def dispatch foo(CharSequence charSeq) {\n" + 
				"        charSeq\n" + 
				"    }\n" + 
				"}", false);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(3, IterableExtensions.size(inferredType.getDeclaredOperations()));
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "foo", Object.class);
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findByNameAndFirstParameterType(operations, "_foo", Appendable.class);
		assertEquals("java.lang.Appendable", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findByNameAndFirstParameterType(operations, "_foo", CharSequence.class);
		assertEquals("java.lang.Object", objectParam.getReturnType().getIdentifier());
	}
	
	@Test public void testBug_340611_05() throws Exception {
		XtendFile xtendFile = file(
				"class Bug340611 extends test.Dispatching {\n" + 
				"    override dispatch doDispatch(StringBuilder sb) {\n" + 
				"        null\n" + 
				"    }\n" + 
				"    def dispatch doDispatch(String s) {\n" + 
				"        s\n" + 
				"    }\n" + 
				"}", false);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(3, IterableExtensions.size(inferredType.getDeclaredOperations()));
		
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findByNameAndFirstParameterType(operations, "doDispatch", Object.class);
		assertEquals("java.lang.CharSequence", dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		JvmOperation stringParam = findByNameAndFirstParameterType(operations, "_doDispatch", StringBuilder.class);
		assertEquals("java.lang.StringBuilder", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findByNameAndFirstParameterType(operations, "_doDispatch", String.class);
		assertEquals("java.lang.CharSequence", objectParam.getReturnType().getIdentifier());
	}

	protected JvmOperation findByNameAndFirstParameterType(Iterable<JvmOperation> operations, final String name, final Class<?> paramType) {
		return find(operations, new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals(name)
					&& input.getParameters().get(0).getParameterType().getIdentifier().equals(paramType.getName());
			}
		});
	}

	@Test public void testInferredJvmType() throws Exception {
		XtendFile xtendFile = file("class Foo { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		assertEquals(associations.getInferredType(xtendClass), inferredType);
		assertEquals(xtendClass, associations.getXtendClass(inferredType));
		assertEquals(JvmVisibility.PUBLIC, inferredType.getVisibility());
	}

	@Test public void testInferredJvmConstructor() throws Exception {
		XtendFile xtendFile = file("class Foo { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		assertEquals(1, inferredType.getMembers().size());
		JvmMember inferredFirstMember = inferredType.getMembers().get(0);
		assertTrue(inferredFirstMember instanceof JvmConstructor);
		assertEquals(JvmVisibility.PUBLIC, inferredFirstMember.getVisibility());
		assertEquals(associations.getInferredConstructor(xtendClass), inferredFirstMember);
	}

	@Test public void testInferredSuperType() throws Exception {
		XtendFile xtendFile = file("class Foo extends Object { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		assertEquals(1, inferredType.getSuperTypes().size());
		assertFalse(xtendClass.getExtends() == inferredType.getSuperTypes().get(0));
		assertEquals(xtendClass.getExtends().getType(), inferredType.getSuperTypes().get(0).getType());
		assertEquals(0, xtendClass.getMembers().size());
		assertEquals(1, inferredType.getMembers().size());
	}

	@Test public void testInferredSuperTypeTypeArgument() throws Exception {
		XtendFile xtendFile = file("class Foo extends Iterable<Object> { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		assertEquals(1, inferredType.getSuperTypes().size());
		JvmTypeReference xtendSuperType = xtendClass.getExtends();
		JvmTypeReference jvmSuperType = inferredType.getSuperTypes().get(0);
		assertFalse(xtendSuperType == jvmSuperType);
		assertTrue(jvmSuperType instanceof JvmParameterizedTypeReference);
		assertTrue(xtendSuperType instanceof JvmParameterizedTypeReference);
		EList<JvmTypeReference> xtendTypeArguments = ((JvmParameterizedTypeReference) xtendSuperType).getArguments();
		EList<JvmTypeReference> jvmTypeArguments = ((JvmParameterizedTypeReference) jvmSuperType).getArguments();
		assertEquals(1, jvmTypeArguments.size());
		JvmTypeReference xtendTypeArgument = xtendTypeArguments.get(0);
		JvmTypeReference jvmTypeArgument = jvmTypeArguments.get(0);
		assertFalse(xtendTypeArgument == jvmTypeArgument);
		assertEquals(xtendTypeArgument.getType(), jvmTypeArgument.getType());
	}

	@Test public void testInferredTypeParameter() throws Exception {
		XtendFile xtendFile = file("class Foo <T> { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		assertEquals(1, inferredType.getTypeParameters().size());
		assertFalse(xtendClass.getTypeParameters().get(0) == inferredType.getTypeParameters().get(0));
		assertEquals(xtendClass.getTypeParameters().get(0).getIdentifier(), inferredType.getTypeParameters().get(0)
				.getIdentifier());
	}

	@Test public void testFinalFunction() throws Exception {
		XtendFile xtendFile = file("final class C { final String s = '' def final void m() {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertTrue(inferredType.isFinal());
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation operation = operations.iterator().next();
		assertTrue(operation.isFinal());
		Iterable<JvmField> fields = inferredType.getDeclaredFields();
		JvmField field = fields.iterator().next();
		assertTrue(field.isFinal());	
	}
	
	@Test public void testInferredTypeWithSelfReferringTypeParameter() throws Exception {
		XtendFile xtendFile = file("package foo class Foo <T extends Foo> {}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(1, inferredType.getTypeParameters().size());
		JvmTypeParameter typeParameter = inferredType.getTypeParameters().get(0);
		assertEquals(1, typeParameter.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeParameter.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		assertEquals(inferredType, ((JvmUpperBound) typeConstraint).getTypeReference().getType());
	}

	@Test public void testInferredFunction_01() throws Exception {
		XtendFile xtendFile = file("class Foo { def bar() { true } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(2, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(1);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendFunction xtendFunction = (XtendFunction) xtendClass.getMembers().get(0);
		assertEquals(xtendFunction.getName(), jvmMember.getSimpleName());
		assertEquals(jvmMember, associations.getDirectlyInferredOperation(xtendFunction));
		assertEquals(xtendFunction, associations.getXtendFunction((JvmOperation) inferredType.getMembers().get(1)));
	}
	
	@Test public void testInferredFunction_02() throws Exception {
		XtendFile xtendFile = file("class Foo { def create result: newArrayList(s) newList(String s) {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(4, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(1);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendFunction xtendFunction = (XtendFunction) xtendClass.getMembers().get(0);
		assertEquals(xtendFunction.getName(), jvmMember.getSimpleName());
		assertEquals(JvmVisibility.PUBLIC, jvmMember.getVisibility());
		assertEquals("java.util.ArrayList<java.lang.String>", ((JvmOperation) jvmMember).getReturnType().getIdentifier());
		
		JvmField cacheVar = (JvmField) jvmMembers.get(2);
		assertEquals("_createCache_" + xtendFunction.getName(), cacheVar.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, cacheVar.getVisibility());
		assertEquals("java.util.HashMap<java.util.ArrayList<? extends java.lang.Object>, java.util.ArrayList<java.lang.String>>", cacheVar.getType().getIdentifier());
		
		JvmOperation privateInitializer = (JvmOperation) jvmMembers.get(3);
		assertEquals("_init_"+xtendFunction.getName(), privateInitializer.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, privateInitializer.getVisibility());
		assertEquals("java.util.ArrayList<java.lang.String>", privateInitializer.getParameters().get(0).getParameterType().getIdentifier());
		assertEquals("java.lang.String", privateInitializer.getParameters().get(1).getParameterType().getIdentifier());
	}

	@Test public void testInferredFunction_03() throws Exception {
		XtendFile xtendFile = file("class Foo {def publicMethod(Object dummy) {} def public publicMethod() {} def protected protectedMethod() {} def private privateMethod() {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		for(JvmOperation op: inferredType.getDeclaredOperations()) {
			assertEquals(JvmVisibility.get(op.getSimpleName().replace("Method", "").toUpperCase()), op.getVisibility());
		}
	}
	
	@Test public void testInferredFunction_04() throws Exception {
		XtendFile xtendFile = file("class Foo { def Iterable<CharSequence> create result: newArrayList(s) newList(String s) {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(4, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(1);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendFunction xtendFunction = (XtendFunction) xtendClass.getMembers().get(0);
		assertEquals(xtendFunction.getName(), jvmMember.getSimpleName());
		assertEquals(JvmVisibility.PUBLIC, jvmMember.getVisibility());
		assertEquals("java.lang.Iterable<java.lang.CharSequence>", ((JvmOperation) jvmMember).getReturnType().getIdentifier());
		
		JvmField cacheVar = (JvmField) jvmMembers.get(2);
		assertEquals("_createCache_" + xtendFunction.getName(), cacheVar.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, cacheVar.getVisibility());
		assertEquals("java.util.HashMap<java.util.ArrayList<? extends java.lang.Object>, java.lang.Iterable<java.lang.CharSequence>>", cacheVar.getType().getIdentifier());
		
		JvmOperation privateInitializer = (JvmOperation) jvmMembers.get(3);
		assertEquals("_init_"+xtendFunction.getName(), privateInitializer.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, privateInitializer.getVisibility());
//		This used to be a bogus assertion since Iterable<CharSequence> is not assignable from ArrayList<String>
//		assertEquals("java.util.ArrayList<java.lang.String>", privateInitializer.getParameters().get(0).getParameterType().getIdentifier());
		assertEquals("java.util.ArrayList<java.lang.CharSequence>", privateInitializer.getParameters().get(0).getParameterType().getIdentifier());
		assertEquals("java.lang.String", privateInitializer.getParameters().get(1).getParameterType().getIdentifier());
	}
	
	@Test public void testInferredFunction_05() throws Exception {
		XtendFile xtendFile = file("class Foo { def Iterable<? extends CharSequence> create result: newArrayList(s) newList(String s) {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(4, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(1);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendFunction xtendFunction = (XtendFunction) xtendClass.getMembers().get(0);
		assertEquals(xtendFunction.getName(), jvmMember.getSimpleName());
		assertEquals(JvmVisibility.PUBLIC, jvmMember.getVisibility());
		assertEquals("java.lang.Iterable<? extends java.lang.CharSequence>", ((JvmOperation) jvmMember).getReturnType().getIdentifier());
		
		JvmField cacheVar = (JvmField) jvmMembers.get(2);
		assertEquals("_createCache_" + xtendFunction.getName(), cacheVar.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, cacheVar.getVisibility());
		assertEquals("java.util.HashMap<java.util.ArrayList<? extends java.lang.Object>, java.lang.Iterable<? extends java.lang.CharSequence>>", cacheVar.getType().getIdentifier());
		
		JvmOperation privateInitializer = (JvmOperation) jvmMembers.get(3);
		assertEquals("_init_"+xtendFunction.getName(), privateInitializer.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, privateInitializer.getVisibility());
		assertEquals("java.util.ArrayList<java.lang.String>", privateInitializer.getParameters().get(0).getParameterType().getIdentifier());
		assertEquals("java.lang.String", privateInitializer.getParameters().get(1).getParameterType().getIdentifier());
	}
	
	@Test public void testInferredFunction_06() throws Exception {
		XtendFile xtendFile = file("class Foo { def Iterable<? super CharSequence> create result: newArrayList(s) newList(String s) {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = (XtendClass) xtendFile.getXtendTypes().get(0);
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(4, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(1);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendFunction xtendFunction = (XtendFunction) xtendClass.getMembers().get(0);
		assertEquals(xtendFunction.getName(), jvmMember.getSimpleName());
		assertEquals(JvmVisibility.PUBLIC, jvmMember.getVisibility());
		assertEquals("java.lang.Iterable<? extends java.lang.Object & super java.lang.CharSequence>", ((JvmOperation) jvmMember).getReturnType().getIdentifier());
		
		JvmField cacheVar = (JvmField) jvmMembers.get(2);
		assertEquals("_createCache_" + xtendFunction.getName(), cacheVar.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, cacheVar.getVisibility());
		assertEquals("java.util.HashMap<java.util.ArrayList<? extends java.lang.Object>, java.lang.Iterable<? extends java.lang.Object & super java.lang.CharSequence>>", cacheVar.getType().getIdentifier());
		
		JvmOperation privateInitializer = (JvmOperation) jvmMembers.get(3);
		assertEquals("_init_"+xtendFunction.getName(), privateInitializer.getSimpleName());
		assertEquals(JvmVisibility.PRIVATE, privateInitializer.getVisibility());
		assertEquals("java.util.ArrayList<java.lang.CharSequence>", privateInitializer.getParameters().get(0).getParameterType().getIdentifier());
		assertEquals("java.lang.String", privateInitializer.getParameters().get(1).getParameterType().getIdentifier());
	}

	@Test public void testInferredFunctionWithReturnType_01() throws Exception {
		XtendFile xtendFile = file("class Foo { def Boolean bar() { true } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertTrue(inferredType.getMembers().get(0) instanceof JvmConstructor);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		XtendFunction xtendFunction = (XtendFunction) ((XtendClass)xtendFile.getXtendTypes().get(0)).getMembers().get(0);
		assertFalse(xtendFunction.getReturnType() == jvmOperation.getReturnType());
		assertEquals(xtendFunction.getReturnType().getType(), jvmOperation.getReturnType().getType());
	}
	
	@Test public void testInferredFunctionWithReturnType_02() throws Exception {
		XtendFile xtendFile = file("class Foo { def Iterable<String> create result: newArrayList newList() {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertTrue(inferredType.getMembers().get(0) instanceof JvmConstructor);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		XtendFunction xtendFunction = (XtendFunction) ((XtendClass)xtendFile.getXtendTypes().get(0)).getMembers().get(0);
		assertFalse(xtendFunction.getReturnType() == jvmOperation.getReturnType());
		assertEquals(xtendFunction.getReturnType().getType(), jvmOperation.getReturnType().getType());
	}
	
	@Test public void testInferredFunctionWithReturnType_03() throws Exception {
		XtendFile xtendFile = file("class Foo { def bar() { null } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("java.lang.Object", jvmOperation.getReturnType().getIdentifier());
	}
	
	@Test public void testInferredFunctionWithReturnType_04() throws Exception {
		XtendFile xtendFile = file("class Foo { def bar() { if (true) null as Double else null as Integer } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("java.lang.Number", jvmOperation.getReturnType().getIdentifier());
	}
	
	@Test public void testInferredFunctionWithReturnType_05() throws Exception {
		XtendFile xtendFile = file("class Foo { def bar() { newArrayList(if (true) null as Double else null as Integer) } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("java.util.ArrayList<java.lang.Number>", jvmOperation.getReturnType().getIdentifier());
	}
	
	@Test public void testInferredFunctionWithReturnType_06() throws Exception {
		XtendFile xtendFile = file("abstract class Foo implements Iterable<String> { override iterator() }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("java.util.Iterator<java.lang.String>", jvmOperation.getReturnType().getIdentifier());
	}
	
	@Test public void testInferredFunctionWithReturnType_07() throws Exception {
		XtendFile xtendFile = file("abstract class Foo<T> implements Iterable<Iterable<T>> { override iterator() }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("java.util.Iterator<java.lang.Iterable<T>>", jvmOperation.getReturnType().getIdentifier());
	}
	
	@Test public void testInferredFunctionWithReturnType_08() throws Exception {
		XtendFile xtendFile = file("abstract class Foo implements java.util.Comparator<String> { override compare(String a, String b) }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("int", jvmOperation.getReturnType().getIdentifier());
	}
	
	@Test public void testInferredFunctionWithReturnType_09() throws Exception {
		XtendFile xtendFile = file("abstract class Foo<X> implements java.util.Comparator<X> { override compare(X a, X b) }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("int", jvmOperation.getReturnType().getIdentifier());
	}

	@Test public void testInferredFunctionWithParameter() throws Exception {
		XtendFile xtendFile = file("class Foo { def bar(Boolean baz) { true } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		XtendFunction xtendFunction = (XtendFunction) ((XtendClass)xtendFile.getXtendTypes().get(0)).getMembers().get(0);
		assertEquals(1, jvmOperation.getParameters().size());
		JvmFormalParameter jvmParameter = jvmOperation.getParameters().get(0);
		XtendParameter xtendParameter = xtendFunction.getParameters().get(0);
		assertEquals(xtendParameter.getName(), jvmParameter.getSimpleName());
		assertEquals(xtendParameter.getParameterType().getType(), jvmParameter.getParameterType().getType());
	}

	@Test public void testInferredFunctionWithSelfTypeReference() throws Exception {
		XtendFile xtendFile = file("package foo class Foo { def Foo bar() { this } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals(inferredType, jvmOperation.getReturnType().getType());
		XtendFunction xtendFunction = (XtendFunction) ((XtendClass)xtendFile.getXtendTypes().get(0)).getMembers().get(0);
		assertEquals(inferredType, xtendFunction.getReturnType().getType());
	}
	
	@Test public void testExtensionToAnnotation_01() throws Exception {
		XtendFile xtendFile = file("class C { extension String }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmField jvmField = (JvmField) inferredType.getMembers().get(1);
		assertEquals("_string", jvmField.getSimpleName());
		List<JvmAnnotationReference> annotations = jvmField.getAnnotations();
		assertEquals(1, annotations.size());
		assertEquals(Extension.class.getCanonicalName(), annotations.get(0).getAnnotation().getQualifiedName());
	}

	@Test public void testExtensionToAnnotation_02() throws Exception {
		XtendFile xtendFile = file("class C { def void m(extension String s) {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		List<JvmFormalParameter> parameters = jvmOperation.getParameters();
		JvmFormalParameter singleParameter = parameters.get(0);
		List<JvmAnnotationReference> annotations = singleParameter.getAnnotations();
		assertEquals(1, annotations.size());
		assertEquals(Extension.class.getCanonicalName(), annotations.get(0).getAnnotation().getQualifiedName());
	}
	
	@Test public void testNameClashWithAnonymousExtension_00() throws Exception {
		XtendFile xtendFile = file("package foo import com.google.inject.Inject class Foo { @Inject extension String String _string }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmField extension = (JvmField) inferredType.getMembers().get(1);
		assertEquals("_string_1", extension.getSimpleName());
		JvmField field = (JvmField) inferredType.getMembers().get(2);
		assertEquals("_string", field.getSimpleName());
	}

	@Test public void testNameClashWithAnonymousExtension_01() throws Exception {
		XtendFile xtendFile = file("package foo import com.google.inject.Inject class Foo { @Inject extension String @Inject extension String }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmField extension0 = (JvmField) inferredType.getMembers().get(1);
		assertEquals("_string", extension0.getSimpleName());
		JvmField extension1 = (JvmField) inferredType.getMembers().get(2);
		assertEquals("_string_1", extension1.getSimpleName());
	}

	@Test public void testNameClashWithCreateExtension_00() throws Exception {
		XtendFile xtendFile = file("package foo class Foo { def create new String() s(String x) { '' } String _createCache_s }");  
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmField cacheVar = (JvmField) inferredType.getMembers().get(2);
		assertEquals("_createCache_s_1", cacheVar.getSimpleName());
		JvmOperation initializer = (JvmOperation) inferredType.getMembers().get(3);
		assertEquals("_init_s", initializer.getSimpleName());
		JvmField field = (JvmField) inferredType.getMembers().get(4);
		assertEquals("_createCache_s", field.getSimpleName());
	}
	
	@Test public void testNameClashWithCreateExtension_01() throws Exception {
		XtendFile xtendFile = file("package foo class Foo { def create new String() s(String x) { '' } String _init_s }");  
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmField cacheVar = (JvmField) inferredType.getMembers().get(2);
		assertEquals("_createCache_s", cacheVar.getSimpleName());
		JvmOperation initializer = (JvmOperation) inferredType.getMembers().get(3);
		assertEquals("_init_s_1", initializer.getSimpleName());
		JvmField field = (JvmField) inferredType.getMembers().get(4);
		assertEquals("_init_s", field.getSimpleName());
	}
	
	@Test public void testNameClashWithCreateExtension_02() throws Exception {
		XtendFile xtendFile = file("package foo class Foo { def create new String() s(String x) { '' } def create new String() s(Object x) { '' }}");  
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmField cacheVar0 = (JvmField) inferredType.getMembers().get(2);
		assertEquals("_createCache_s", cacheVar0.getSimpleName());
		JvmOperation initializer0 = (JvmOperation) inferredType.getMembers().get(3);
		assertEquals("_init_s", initializer0.getSimpleName());
		JvmField cacheVar1 = (JvmField) inferredType.getMembers().get(5);
		assertEquals("_createCache_s_1", cacheVar1.getSimpleName());
		JvmOperation initializer1 = (JvmOperation) inferredType.getMembers().get(6);
		assertEquals("_init_s_1", initializer1.getSimpleName());
	}
	
	@Test public void testNameClashWithCreateExtension_03() throws Exception {
		XtendFile xtendFile = file("package foo class Foo { def create new String() s(String x) { '' } def create new String() s(Object x, Object y) { '' }}");  
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmField cacheVar0 = (JvmField) inferredType.getMembers().get(2);
		assertEquals("_createCache_s", cacheVar0.getSimpleName());
		JvmOperation initializer0 = (JvmOperation) inferredType.getMembers().get(3);
		assertEquals("_init_s", initializer0.getSimpleName());
		JvmField cacheVar1 = (JvmField) inferredType.getMembers().get(5);
		assertEquals("_createCache_s_1", cacheVar1.getSimpleName());
		JvmOperation initializer1 = (JvmOperation) inferredType.getMembers().get(6);
		assertEquals("_init_s", initializer1.getSimpleName());
	}
	
	@Test
	public void testInferredFunctionWithTypeParameter() throws Exception {
		XtendFile xtendFile = file("class Foo<S> { def java.util.List<S> foo() {null} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals("java.util.List<S>", jvmOperation.getReturnType().getIdentifier());
		JvmTypeReference argument = ((JvmParameterizedTypeReference)jvmOperation.getReturnType()).getArguments().get(0);
		assertSame(inferredType, ((JvmTypeParameter)argument.getType()).getDeclarator());
		XtendFunction xtendFunction = (XtendFunction) ((XtendClass)xtendFile.getXtendTypes().get(0)).getMembers().get(0);
		assertEquals("java.util.List<S>", xtendFunction.getReturnType().getIdentifier());
	}

	@Test
	public void test_No_Exception_bug395377() throws Exception {
		String content = "@Data class Foo {  String extension }";
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(content);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(content), null);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		getInferredType(file);
    }
	
	@Test
	public void test_bug475337() throws Exception {
		Resource content = file("enum Foo {  bar, ,baz }", false, false).eResource();
		XtendEnum xtendEnumType = (XtendEnum) ((XtendFile)content.getContents().get(0)).getXtendTypes().get(0);
		assertEquals(3, xtendEnumType.getMembers().size());
		assertNull(((XtendEnumLiteral)xtendEnumType.getMembers().get(1)).getName());
		// check jvm model
		JvmEnumerationType enumType = (JvmEnumerationType) content.getContents().get(1);
		assertEquals(2, enumType.getLiterals().size());
		assertEquals("bar", enumType.getLiterals().get(0).getSimpleName());
		assertEquals("baz", enumType.getLiterals().get(1).getSimpleName());
	}

	protected JvmGenericType getInferredType(XtendFile xtendFile) {
		assertEquals(2, xtendFile.eResource().getContents().size());
		EObject secondRoot = xtendFile.eResource().getContents().get(1);
		assertTrue(secondRoot instanceof JvmGenericType);
		JvmGenericType inferredType = (JvmGenericType) secondRoot;
		return inferredType;
	}
}
