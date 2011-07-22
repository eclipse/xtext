/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmConstructor;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class InferredJvmModelTest extends AbstractXtend2TestCase {

	@Inject
	private IXtend2JvmAssociations associations;
	
	public void testXtendField_00() throws Exception {
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
	
	public void testCaseFunction_00() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Object x) {null} def dispatch foo(String x) {null}}");
		JvmGenericType inferredType = getInferredType(xtendFile);

		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("foo")
						&& input.getParameters().get(0).getParameterType().getIdentifier()
								.equals(Object.class.getName());
			}
		});
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Object.class.getName());
			}
		});
		find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(String.class.getName());
			}
		});
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
	
	public void testCaseFunction_01() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Object x, String y) {null} def dispatch foo(String x) {null}}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// two dispatch methods
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Object.class.getName());
			}
		});
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());
		assertEquals(2, dispatch.getParameters().size());
		
		dispatch = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(String.class.getName());
			}
		});
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());
		assertEquals(1, dispatch.getParameters().size());
		
		// two internal case methods
		find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Object.class.getName())
				&& input.getParameters().get(1).getParameterType().getIdentifier()
				.equals(String.class.getName())
				;
			}
		});
		find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(String.class.getName());
			}
		});
	}
	
	public void testCaseFunction_02() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Object x) {'foo'} def dispatch foo(String x) {'bar'}}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Object.class.getName());
			}
		});
		assertEquals(String.class.getName(), dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Object.class.getName());
			}
		});
		find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(String.class.getName());
			}
		});
	}
	
	public void testCaseFunction_03() throws Exception {
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
				"}", true /* TODO if set to false, test fails - see TODO below*/);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("doStuff")
					&& input.getParameters().get(0).getParameterType().getIdentifier()
					.equals(ENamedElement.class.getName());
			}
		});
		// TODO why does this assertion fail with validate==false? (see above TODO)
		assertEquals("java.util.List<? extends java.lang.Object>", dispatch.getReturnType().getIdentifier());

		// three internal case methods
		JvmOperation eClassParam = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_doStuff")
					&& input.getParameters().get(0).getParameterType().getIdentifier()
					.equals(EClass.class.getName());
			}
		});
		assertEquals("java.util.List<? extends java.lang.Object>", eClassParam.getReturnType().getIdentifier());
		
		JvmOperation ePackageParam = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_doStuff")
					&& input.getParameters().get(0).getParameterType().getIdentifier()
					.equals(EPackage.class.getName());
			}
		});
		assertEquals("java.util.List<? extends java.lang.Object>", ePackageParam.getReturnType().getIdentifier());
		
		JvmOperation eStructuralFeatureParam = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_doStuff")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(EStructuralFeature.class.getName());
			}
		});
		assertEquals("java.util.List<? extends java.lang.Object>", eStructuralFeatureParam.getReturnType().getIdentifier());
	}
	
	public void testCaseFunction_04() throws Exception {
		XtendFile xtendFile = file("class Foo { def dispatch foo(Integer x) {x} def dispatch foo(Double x) {x}}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		
		// one main dispatch
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				// parameter type is resolved multitype of Number and Comparable
				return input.getSimpleName().equals("foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Object.class.getName());
			}
		});
		// return type is specialized
		assertEquals("java.lang.Number & java.lang.Comparable<? extends java.lang.Object>", dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		JvmOperation internal = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Double.class.getName());
			}
		});
		assertEquals(dispatch.getReturnType().getIdentifier(), internal.getReturnType().getIdentifier());
		
		internal = find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("_foo")
				&& input.getParameters().get(0).getParameterType().getIdentifier()
				.equals(Integer.class.getName());
			}
		});
		assertEquals(dispatch.getReturnType().getIdentifier(), internal.getReturnType().getIdentifier());
	}
	
	public void testBug_340611() throws Exception {
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
		JvmOperation dispatch = findSingleParamOperation(operations, "foo", Object.class);
		assertEquals("java.lang.String", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findSingleParamOperation(operations, "_foo", String.class);
		assertEquals("java.lang.String", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findSingleParamOperation(operations, "_foo", Object.class);
		assertEquals("java.lang.String", objectParam.getReturnType().getIdentifier());
	}
	
	public void testBug_340611_02() throws Exception {
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
		JvmOperation dispatch = findSingleParamOperation(operations, "foo", CharSequence.class);
		assertEquals("java.lang.CharSequence", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findSingleParamOperation(operations, "_foo", String.class);
		assertEquals("java.lang.CharSequence", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findSingleParamOperation(operations, "_foo", CharSequence.class);
		assertEquals("java.lang.CharSequence", objectParam.getReturnType().getIdentifier());
	}
	
	public void testBug_340611_03() throws Exception {
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
		JvmOperation dispatch = findSingleParamOperation(operations, "foo", Object.class);
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findSingleParamOperation(operations, "_foo", Appendable.class);
		assertEquals("java.lang.Object", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findSingleParamOperation(operations, "_foo", CharSequence.class);
		assertEquals("java.lang.Object", objectParam.getReturnType().getIdentifier());
	}
	
	public void testBug_340611_04() throws Exception {
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
		JvmOperation dispatch = findSingleParamOperation(operations, "foo", Object.class);
		assertEquals("java.lang.Object", dispatch.getReturnType().getIdentifier());

		// two internal case methods
		JvmOperation stringParam = findSingleParamOperation(operations, "_foo", Appendable.class);
		assertEquals("java.lang.Appendable", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findSingleParamOperation(operations, "_foo", CharSequence.class);
		assertEquals("java.lang.Object", objectParam.getReturnType().getIdentifier());
	}
	
	public void testBug_340611_05() throws Exception {
		XtendFile xtendFile = file(
				"class Bug340611 extends test.Dispatching {\n" + 
				"    override dispatch doDispatch(StringBuilder sb) {\n" + 
				"        sb\n" + 
				"    }\n" + 
				"    def dispatch doDispatch(String s) {\n" + 
				"        s\n" + 
				"    }\n" + 
				"}", false);
		
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(3, IterableExtensions.size(inferredType.getDeclaredOperations()));
		
		Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
		JvmOperation dispatch = findSingleParamOperation(operations, "doDispatch", Object.class);
		assertEquals("java.lang.CharSequence", dispatch.getReturnType().getIdentifier());
		
		// two internal case methods
		JvmOperation stringParam = findSingleParamOperation(operations, "_doDispatch", StringBuilder.class);
		assertEquals("java.lang.StringBuilder", stringParam.getReturnType().getIdentifier());
		
		JvmOperation objectParam = findSingleParamOperation(operations, "_doDispatch", String.class);
		assertEquals("java.lang.CharSequence", objectParam.getReturnType().getIdentifier());
	}

	protected JvmOperation findSingleParamOperation(Iterable<JvmOperation> operations, final String name, final Class<?> paramType) {
		return find(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals(name)
					&& input.getParameters().get(0).getParameterType().getIdentifier().equals(paramType.getName());
			}
		});
	}

	public void testInferredJvmType() throws Exception {
		XtendFile xtendFile = file("class Foo { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(associations.getInferredType(xtendClass), inferredType);
		assertEquals(xtendClass, associations.getXtendClass(inferredType));
		assertEquals(xtendClass.getIdentifier(), inferredType.getIdentifier());
		assertEquals(JvmVisibility.PUBLIC, inferredType.getVisibility());
	}

	public void testInferredJvmConstructor() throws Exception {
		XtendFile xtendFile = file("class Foo { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(1, inferredType.getMembers().size());
		JvmMember inferredFirstMember = inferredType.getMembers().get(0);
		assertTrue(inferredFirstMember instanceof JvmConstructor);
		assertEquals(associations.getInferredConstructor(xtendClass), inferredFirstMember);
		assertEquals(xtendClass.getIdentifier() + "." + xtendClass.getName() + "()", inferredFirstMember.getIdentifier());
	}

	public void testInferredSuperType() throws Exception {
		XtendFile xtendFile = file("class Foo extends Object { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(1, inferredType.getSuperTypes().size());
		assertFalse(xtendClass.getSuperTypes().get(0) == inferredType.getSuperTypes().get(0));
		assertEquals(xtendClass.getSuperTypes().get(0).getType(), inferredType.getSuperTypes().get(0).getType());
		assertEquals(0, xtendClass.getMembers().size());
		assertEquals(1, inferredType.getMembers().size());
	}

	public void testInferredSuperTypeTypeArgument() throws Exception {
		XtendFile xtendFile = file("class Foo extends Iterable<Object> { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(1, inferredType.getSuperTypes().size());
		JvmTypeReference xtendSuperType = xtendClass.getSuperTypes().get(0);
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

	public void testInferredTypeParameter() throws Exception {
		XtendFile xtendFile = file("class Foo <T> { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(1, inferredType.getTypeParameters().size());
		assertFalse(xtendClass.getTypeParameters().get(0) == inferredType.getTypeParameters().get(0));
		assertEquals(xtendClass.getTypeParameters().get(0).getIdentifier(), inferredType.getTypeParameters().get(0)
				.getIdentifier());
	}

	public void testInferredTypeWithSelfReferringTypeParameter() throws Exception {
		XtendFile xtendFile = file("package foo class Foo <T extends Foo> {}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(1, inferredType.getTypeParameters().size());
		JvmTypeParameter typeParameter = inferredType.getTypeParameters().get(0);
		assertEquals(1, typeParameter.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeParameter.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		assertEquals(inferredType, ((JvmUpperBound) typeConstraint).getTypeReference().getType());
	}

	public void testInferredFunction_01() throws Exception {
		XtendFile xtendFile = file("class Foo { def bar() { true } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(2, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(1);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendFunction xtendFunction = (XtendFunction) xtendClass.getMembers().get(0);
		assertEquals(xtendFunction.getIdentifier(), jvmMember.getIdentifier());
		assertEquals(jvmMember, associations.getDirectlyInferredOperation(xtendFunction));
		assertEquals(xtendFunction, associations.getXtendFunction((JvmOperation) inferredType.getMembers().get(1)));
	}
	
	public void testInferredFunction_02() throws Exception {
		XtendFile xtendFile = file("class Foo { def create result: newArrayList(s) newList(String s) {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(2, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(1);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendFunction xtendFunction = (XtendFunction) xtendClass.getMembers().get(0);
		assertEquals(xtendFunction.getIdentifier(), jvmMember.getIdentifier());
		assertEquals("java.util.ArrayList<java.lang.String>", ((JvmOperation) jvmMember).getReturnType().getIdentifier());
	}

	public void testInferredFunctionWithReturnType_01() throws Exception {
		XtendFile xtendFile = file("class Foo { def Boolean bar() { true } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertTrue(inferredType.getMembers().get(0) instanceof JvmConstructor);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
		assertFalse(xtendFunction.getReturnType() == jvmOperation.getReturnType());
		assertEquals(xtendFunction.getReturnType().getType(), jvmOperation.getReturnType().getType());
	}
	
	public void testInferredFunctionWithReturnType_02() throws Exception {
		XtendFile xtendFile = file("class Foo { def Iterable<String> create result: newArrayList newList() {} }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertTrue(inferredType.getMembers().get(0) instanceof JvmConstructor);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
		assertFalse(xtendFunction.getReturnType() == jvmOperation.getReturnType());
		assertEquals(xtendFunction.getReturnType().getType(), jvmOperation.getReturnType().getType());
	}

	public void testInferredFunctionWithParameter() throws Exception {
		XtendFile xtendFile = file("class Foo { def bar(Boolean baz) { true } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
		assertEquals(1, jvmOperation.getParameters().size());
		JvmFormalParameter jvmParameter = jvmOperation.getParameters().get(0);
		XtendParameter xtendParameter = xtendFunction.getParameters().get(0);
		assertEquals(xtendParameter.getIdentifier(), jvmParameter.getIdentifier());
		assertEquals(xtendParameter.getParameterType().getType(), jvmParameter.getParameterType().getType());
	}

	public void testInferredFunctionWithSelfTypeReference() throws Exception {
		XtendFile xtendFile = file("package foo class Foo { def Foo bar() { this } }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
		assertEquals(inferredType, jvmOperation.getReturnType().getType());
		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
		assertEquals(inferredType, xtendFunction.getReturnType().getType());
	}
	
//	public void testInferredFunctionWithTypeParameter() throws Exception {
//		XtendFile xtendFile = file("class Foo<S> { java.util.List<S> foo() {null} }");
//		JvmGenericType inferredType = getInferredType(xtendFile);
//		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(1);
//		assertEquals("java.util.List<S>", jvmOperation.getReturnType().getIdentifier());
//		JvmTypeReference argument = ((JvmParameterizedTypeReference)jvmOperation.getReturnType()).getArguments().get(0);
//		assertSame(inferredType, ((JvmTypeParameter)argument.getType()).getDeclarator());
//		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
//		assertEquals("java.util.List<S>", xtendFunction.getReturnType().getIdentifier());
//	}

	protected JvmGenericType getInferredType(XtendFile xtendFile) {
		assertEquals(2, xtendFile.eResource().getContents().size());
		EObject secondRoot = xtendFile.eResource().getContents().get(1);
		assertTrue(secondRoot instanceof JvmGenericType);
		JvmGenericType inferredType = (JvmGenericType) secondRoot;
		return inferredType;
	}
}
