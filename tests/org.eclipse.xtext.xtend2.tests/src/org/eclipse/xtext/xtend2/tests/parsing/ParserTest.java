package org.eclipse.xtext.xtend2.tests.parsing;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2Test;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

public class ParserTest extends AbstractXtend2Test {
	
	public void testFunction_0() throws Exception {
		XtendFunction func = function("foo() : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_1() throws Exception {
		XtendFunction func = function("String foo() : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNotNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_2() throws Exception {
		XtendFunction func = function("foo(String s) : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(1, func.getParameters().size());
		assertEquals("s", func.getParameters().get(0).getName());
		assertNotNull(func.getParameters().get(0).getParameterType());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_3() throws Exception {
		XtendFunction func = function("foo(String s, Integer i) : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(2, func.getParameters().size());
		assertEquals("s", func.getParameters().get(0).getName());
		assertNotNull(func.getParameters().get(0).getParameterType());
		assertEquals("i", func.getParameters().get(1).getName());
		assertNotNull(func.getParameters().get(1).getParameterType());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_4() throws Exception {
		XtendFunction func = function("foo() : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNull(func.getReturnType());
//		assertTrue(func.getVisibility() == JvmVisibility.PRIVATE);
		assertEquals(0, func.getTypeParameters().size());
	}


	public void testTypeParams_1() throws Exception {
		XtendFunction func = function("<T> foo(T t) : bar;");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(0, tp.getConstraints().size());
	}

	public void testTypeParams_2() throws Exception {
		XtendFunction func = function("<T extends Bar> foo(T t) : bar;");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmUpperBound);
	}

	public void testTypeParams_3() throws Exception {
		XtendFunction func = function("<T extends Foo & Bar> foo(T t) : bar;");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(2, tp.getConstraints().size());
		for (JvmTypeConstraint constraint : tp.getConstraints()) {
			assertTrue(constraint instanceof JvmUpperBound);
		}
	}

	public void testTypeParams_4() throws Exception {
		XtendFunction func = function("<T super Foo> foo(T t) : bar;");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmLowerBound);
	}
	
	public void testFunctionTypeRef_0() throws Exception {
		XtendFunction func = function("=>Boolean foo() : |true;");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(0,type.getParamTypes().size());
	}
	
	public void testFunctionTypeRef_1() throws Exception {
		XtendFunction func = function("(String)=>Boolean foo() : String s|s==null;");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(1,type.getParamTypes().size());
		assertNotNull(type.getParamTypes().get(0));
	}
}
