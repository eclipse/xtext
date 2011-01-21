package org.eclipse.xtext.xtend2.tests.parsing;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

public class ParserTest extends AbstractXtend2TestCase {
	
	public void testFunction_0() throws Exception {
		XtendFunction func = function("foo() bar");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_1() throws Exception {
		XtendFunction func = function("String foo() bar");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNotNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_2() throws Exception {
		XtendFunction func = function("foo(String s) bar");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(1, func.getParameters().size());
		assertEquals("s", func.getParameters().get(0).getName());
		assertNotNull(func.getParameters().get(0).getParameterType());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_3() throws Exception {
		XtendFunction func = function("foo(String s, Integer i) bar");
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
		XtendFunction func = function("foo() bar");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNull(func.getReturnType());
//		assertTrue(func.getVisibility() == JvmVisibility.PRIVATE);
		assertEquals(0, func.getTypeParameters().size());
	}


	public void testTypeParams_1() throws Exception {
		XtendFunction func = function("<T> foo(T t) bar");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(0, tp.getConstraints().size());
	}

	public void testTypeParams_2() throws Exception {
		XtendFunction func = function("<T extends Bar> foo(T t) bar");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmUpperBound);
	}

	public void testTypeParams_3() throws Exception {
		XtendFunction func = function("<T extends Foo & Bar> foo(T t) bar");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(2, tp.getConstraints().size());
		for (JvmTypeConstraint constraint : tp.getConstraints()) {
			assertTrue(constraint instanceof JvmUpperBound);
		}
	}

	public void testTypeParams_4() throws Exception {
		XtendFunction func = function("<T super Foo> foo(T t) bar");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmLowerBound);
	}
	
	public void testFunctionTypeRef_0() throws Exception {
		XtendFunction func = function("=>Boolean foo() [|true]");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(0,type.getParamTypes().size());
	}
	
	public void testFunctionTypeRef_1() throws Exception {
		XtendFunction func = function("(String)=>Boolean foo() [String s|s==null]");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(1,type.getParamTypes().size());
		assertNotNull(type.getParamTypes().get(0));
	}
	
	public void testUnambiguity_00() throws Exception {
		XtendClass clazz = clazz("package x\n" +
			"class Foo {\n" +
			"  String x(Foo bar) String\n" +
			"  x(Baz x) baz\n" +
			"}");
		XtendFunction f1 = (XtendFunction) clazz.getMembers().get(0);
		XtendFunction f2 = (XtendFunction) clazz.getMembers().get(1);
		assertEquals("String",((XFeatureCall)f1.getExpression()).getConcreteSyntaxFeatureName());
		assertNull(f2.getReturnType());
	}
	
	public void testUnambiguity_01() throws Exception {
		XtendClass clazz = clazz("package x\n" +
				"class Foo {\n" +
				"  String x(Foo bar) String\n" +
				"  String x(Baz x) baz\n" +
		"}");
		XtendFunction f1 = (XtendFunction) clazz.getMembers().get(0);
		XtendFunction f2 = (XtendFunction) clazz.getMembers().get(1);
		assertEquals("String",((XFeatureCall)f1.getExpression()).getConcreteSyntaxFeatureName());
		assertNotNull(f2.getReturnType());
	}

	public void testRichString_00() throws Exception {
		XtendFunction function = function("foo() ''' foo '''");
		assertTrue(function.getExpression() instanceof RichString);
		RichString richString = (RichString) function.getExpression();
		assertEquals(1, richString.getElements().size());
		RichStringLiteral stringLiteral = (RichStringLiteral) richString.getElements().get(0);
		assertEquals(" foo ", stringLiteral.getValue());
	}
	
	public void testRichString_01() throws Exception {
		XtendFunction function = function("foo() ''' foo «'holla'» bar '''");
		final RichString richString = (RichString) function.getExpression();
		assertTrue(richString.getElements().get(0) instanceof RichStringLiteral); 
		assertTrue(richString.getElements().get(1) instanceof XStringLiteral); 
		assertTrue(richString.getElements().get(2) instanceof RichStringLiteral); 
	}
	
	public void testRichString_02() throws Exception {
		XtendFunction function = function("foo() ''''''");
		assertTrue(function.getExpression() instanceof RichString); 
	}
	
	public void testRichStringIF_00() throws Exception {
		XtendFunction function = function("foo() ''' foo «IF true» wurst «ELSEIF f==3» brot «ELSE» machine «ENDIF» bar '''");
		final RichString richString = (RichString) function.getExpression();
		assertTrue(richString.getElements().get(0) instanceof RichStringLiteral);
		
		final RichStringIf rsIf = (RichStringIf) richString.getElements().get(1);
		assertTrue(rsIf.getIf() instanceof XBooleanLiteral); 
		assertTrue(rsIf.getThen() instanceof RichString);
		assertEquals(1,rsIf.getElseIfs().size());
		
		RichStringElseIf elseIf = rsIf.getElseIfs().get(0);
		assertTrue(elseIf.getIf() instanceof XBinaryOperation);
		assertTrue(elseIf.getThen() instanceof RichString);
		
		assertTrue(rsIf.getElse() instanceof RichString);
		
		assertTrue(richString.getElements().get(2) instanceof RichStringLiteral); 
	}
	
	public void testRichStringIF_01() throws Exception {
		XtendFunction function = function("foo() ''' foo «IF true» wurst «IF false» brot «ELSE» machine «ENDIF» bar «ENDIF»'''");
		final RichString richString = (RichString) function.getExpression();
		assertTrue(richString.getElements().get(0) instanceof RichStringLiteral);
		
		final RichStringIf rsIf = (RichStringIf) richString.getElements().get(1);
		assertTrue(rsIf.getIf() instanceof XBooleanLiteral);
		
		final RichString then = (RichString) rsIf.getThen();
		assertEquals(3,then.getElements().size());
		RichStringIf innerIf = (RichStringIf) then.getElements().get(1);
		assertTrue(innerIf.getIf() instanceof XBooleanLiteral);
		assertTrue(innerIf.getElse() instanceof RichString);
		
		assertTrue(rsIf.getElse()==null);
		
		assertTrue(richString.getElements().get(2) instanceof RichStringLiteral); 
	}
}
