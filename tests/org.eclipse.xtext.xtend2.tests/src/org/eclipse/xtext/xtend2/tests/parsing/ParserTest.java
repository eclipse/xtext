package org.eclipse.xtext.xtend2.tests.parsing;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

public class ParserTest extends AbstractXtend2TestCase {
	
	@Inject private IXtend2JvmAssociations associations; 
	
	public void testCreateExtension_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def create list: newArrayList('foo') getListWithFooAnd(String s) {" +
				"    list.add(s)" +
				"  }" +
				"}");
		assertEquals(1, clazz.getMembers().size());
		
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		assertNotNull(func.getCreateExtensionInfo().getCreateExpression());
		assertEquals("list", func.getCreateExtensionInfo().getName());
	}
	
	public void testCreateExtension_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def create foo : newArrayList('foo') getListWithFooAnd(String s) {" +
				"    foo.add(s)" +
				"  }" +
		"}");
		assertEquals(1, clazz.getMembers().size());
		
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		assertNotNull(func.getCreateExtensionInfo().getCreateExpression());
		assertEquals("foo", func.getCreateExtensionInfo().getName());
	}
	
	public void testXtendField_00() throws Exception {
		XtendClass clazz = clazz(
			"class Foo { " +
			"  @com.google.inject.Inject java.util.Map<String,String> map" +
			"}");
		assertEquals(1, clazz.getMembers().size());
		XtendField field = (XtendField) clazz.getMembers().get(0);
		assertEquals("java.util.Map",field.getType().getType().getIdentifier());
		assertEquals("map",field.getName());
		assertEquals("java.util.Map<java.lang.String,java.lang.String>", field.getType().getIdentifier());
	}
	
	public void testXtendField_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  @com.google.inject.Inject java.util.Map<String,String> map def map() {null as String}" +
		"}");
		assertEquals(2, clazz.getMembers().size());
		XtendField field = (XtendField) clazz.getMembers().get(0);
		assertEquals("java.util.Map",field.getType().getType().getIdentifier());
		assertEquals("map",field.getName());
		assertEquals("java.util.Map<java.lang.String,java.lang.String>", field.getType().getIdentifier());
		assertTrue(clazz.getMembers().get(1) instanceof XtendFunction);
	}
	
	public void testXtendField_03() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  @com.google.inject.Inject java.util.Map<String,String> map" +
				"  @com.google.inject.Inject java.util.List myList" +
		"}");
		assertEquals(2, clazz.getMembers().size());
		XtendField field = (XtendField) clazz.getMembers().get(0);
		assertEquals("java.util.Map",field.getType().getType().getIdentifier());
		assertEquals("map",field.getName());
		assertEquals("java.util.Map<java.lang.String,java.lang.String>", field.getType().getIdentifier());
		field = (XtendField) clazz.getMembers().get(1);
		assertEquals("java.util.List",field.getType().getType().getIdentifier());
		assertEquals("myList",field.getName());
		assertEquals("java.util.List", field.getType().getIdentifier());
	}
	
	public void testFunction_0() throws Exception {
		XtendFunction func = function("def foo() {foo}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_1() throws Exception {
		XtendFunction func = function("def String foo() {foo}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNotNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_2() throws Exception {
		XtendFunction func = function("def foo(String s) {s}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(1, func.getParameters().size());
		assertEquals("s", func.getParameters().get(0).getName());
		assertNotNull(func.getParameters().get(0).getParameterType());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_3() throws Exception {
		XtendFunction func = function("def foo(String s, Integer i) {s}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(2, func.getParameters().size());
		assertEquals("s", func.getParameters().get(0).getName());
		assertNotNull(func.getParameters().get(0).getParameterType());
		assertEquals("i", func.getParameters().get(1).getName());
		assertNotNull(func.getParameters().get(1).getParameterType());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParameters().size());
	}

	public void testFunction_4() throws Exception {
		XtendFunction func = function("def foo() {foo}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNull(func.getReturnType());
		assertFalse(func.isDispatch());
		assertEquals(0, func.getTypeParameters().size());
	}
	
	public void testFunction_5() throws Exception {
		XtendFunction func = function("def dispatch foo(String s) {foo('x')}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(1, func.getParameters().size());
		assertNull(func.getReturnType());
		assertTrue(func.isDispatch());
		assertEquals(0, func.getTypeParameters().size());
	}
	
	public void testFunction_6() throws Exception {
		XtendFunction func = function("override dispatch foo(String s) { foo('x')}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(1, func.getParameters().size());
		assertNull(func.getReturnType());
		assertTrue(func.isOverride());
		assertTrue(func.isDispatch());
		assertEquals(0, func.getTypeParameters().size());
	}
	
	public void testFunction_7() throws Exception {
		XtendFunction func = function("override foo() { foo}");
		assertEquals("foo", func.getName());
		assertTrue(((XBlockExpression)func.getExpression()).getExpressions().get(0) instanceof XFeatureCall);
		assertEquals(0, func.getParameters().size());
		assertNull(func.getReturnType());
		assertTrue(func.isOverride());
		assertFalse(func.isDispatch());
		assertEquals(0, func.getTypeParameters().size());
	}


	public void testTypeParams_1() throws Exception {
		XtendFunction func = function("def <T> foo(T t) {t}");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(0, tp.getConstraints().size());
	}

	public void testTypeParams_2() throws Exception {
		XtendFunction func = function("def <T extends CharSequence> foo(T t) { t}");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmUpperBound);
	}

	public void testTypeParams_3() throws Exception {
		XtendFunction func = function("def <T extends CharSequence & java.io.Serializable> foo(T t) { t}");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(2, tp.getConstraints().size());
		for (JvmTypeConstraint constraint : tp.getConstraints()) {
			assertTrue(constraint instanceof JvmUpperBound);
		}
	}

	public void testTypeParams_4() throws Exception {
		XtendFunction func = function("def <T super Foo> foo(T t) { t}");
		assertEquals(1, func.getTypeParameters().size());
		JvmTypeParameter tp = func.getTypeParameters().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmLowerBound);
	}
	
	public void testFunctionTypeRef_0() throws Exception {
		XtendFunction func = function("def =>Boolean foo() { [|true]}");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(0,type.getParamTypes().size());
	}
	
	public void testFunctionTypeRef_1() throws Exception {
		XtendFunction func = function("def (String)=>Boolean foo() { [String s|s==null]}");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(1,type.getParamTypes().size());
		assertNotNull(type.getParamTypes().get(0));
	}
	
	public void testUnambiguity_00() throws Exception {
		XtendClass clazz = clazz("package x\n" +
			"class Foo {\n" +
			"  def String x(String bar) {String}\n" +
			"  def String(String x) {x}\n" +
			"}");
		XtendFunction f1 = (XtendFunction) clazz.getMembers().get(0);
		XtendFunction f2 = (XtendFunction) clazz.getMembers().get(1);
		assertEquals("String",((XFeatureCall)((XBlockExpression)f1.getExpression()).getExpressions().get(0)).getConcreteSyntaxFeatureName());
		assertNull(f2.getReturnType());
	}
	
	public void testUnambiguity_01() throws Exception {
		XtendClass clazz = clazz("package x\n" +
				"class Foo {\n" +
				"  def String x(Foo bar) {String}\n" +
				"  def String x(Baz x) {baz}\n" +
		"}");
		XtendFunction f1 = (XtendFunction) clazz.getMembers().get(0);
		XtendFunction f2 = (XtendFunction) clazz.getMembers().get(1);
		assertEquals("String",((XFeatureCall)((XBlockExpression)f1.getExpression()).getExpressions().get(0)).getConcreteSyntaxFeatureName());
		assertNotNull(f2.getReturnType());
	}

	public void testRichString_00() throws Exception {
		XtendFunction function = function("def foo() ''' foo '''");
		assertTrue(function.getExpression() instanceof RichString);
		RichString richString = (RichString) function.getExpression();
		assertEquals(1, richString.getExpressions().size());
		RichStringLiteral stringLiteral = (RichStringLiteral) richString.getExpressions().get(0);
		assertEquals(" foo ", stringLiteral.getValue());
	}
	
	public void testRichString_01() throws Exception {
		XtendFunction function = function("def foo() ''' foo «'holla'» bar '''");
		final RichString richString = (RichString) function.getExpression();
		assertTrue(richString.getExpressions().get(0) instanceof RichStringLiteral); 
		assertTrue(richString.getExpressions().get(1) instanceof XStringLiteral); 
		assertTrue(richString.getExpressions().get(2) instanceof RichStringLiteral); 
	}
	
	public void testRichString_02() throws Exception {
		XtendFunction function = function("def foo() ''''''");
		assertTrue(function.getExpression() instanceof RichString); 
	}
	
	public void testRichStringIF_00() throws Exception {
		XtendFunction function = function("def foo() ''' foo «IF true» wurst «ELSEIF null==3» brot «ELSE» machine «ENDIF» bar '''");
		final RichString richString = (RichString) function.getExpression();
		assertTrue(richString.getExpressions().get(0) instanceof RichStringLiteral);
		
		final RichStringIf rsIf = (RichStringIf) richString.getExpressions().get(1);
		assertTrue(rsIf.getIf() instanceof XBooleanLiteral); 
		assertTrue(rsIf.getThen() instanceof RichString);
		assertEquals(1,rsIf.getElseIfs().size());
		
		RichStringElseIf elseIf = rsIf.getElseIfs().get(0);
		assertTrue(elseIf.getIf() instanceof XBinaryOperation);
		assertTrue(elseIf.getThen() instanceof RichString);
		
		assertTrue(rsIf.getElse() instanceof RichString);
		
		assertTrue(richString.getExpressions().get(2) instanceof RichStringLiteral); 
	}
	
	public void testRichStringIF_01() throws Exception {
		XtendFunction function = function("def foo() ''' foo «IF true» wurst «IF false» brot «ELSE» machine «ENDIF» bar «ENDIF»'''");
		final RichString richString = (RichString) function.getExpression();
		assertTrue(richString.getExpressions().get(0) instanceof RichStringLiteral);
		
		final RichStringIf rsIf = (RichStringIf) richString.getExpressions().get(1);
		assertTrue(rsIf.getIf() instanceof XBooleanLiteral);
		
		final RichString then = (RichString) rsIf.getThen();
		assertEquals(3,then.getExpressions().size());
		RichStringIf innerIf = (RichStringIf) then.getExpressions().get(1);
		assertTrue(innerIf.getIf() instanceof XBooleanLiteral);
		assertTrue(innerIf.getElse() instanceof RichString);
		
		assertTrue(rsIf.getElse()==null);
		
		assertTrue(richString.getExpressions().get(2) instanceof RichStringLiteral); 
	}
	
	public void testRichStringFOR_01() throws Exception {
		XtendFunction function = function("def withForLoop() '''«FOR i: 1..10»«i»«ENDFOR»'''");
		final RichString richString = (RichString) function.getExpression();
		final RichStringForLoop rsFor = (RichStringForLoop) richString.getExpressions().get(1);
		assertTrue(rsFor.getForExpression() instanceof XBinaryOperation);
		assertEquals("i", rsFor.getDeclaredParam().getName());
		
		RichString eachRichString = (RichString) rsFor.getEachExpression();
		assertEquals(3, eachRichString.getExpressions().size());
		XExpression variableReference = eachRichString.getExpressions().get(1);
		assertTrue(variableReference instanceof XFeatureCall);
		assertSame(rsFor.getDeclaredParam(), ((XAbstractFeatureCall) variableReference).getFeature());
	}
	
	public void testRichStringFOR_02() throws Exception {
		XtendFunction function = function("def withForLoop() '''«FOR i: 1..10 BEFORE 'a' SEPARATOR '\t' AFTER i»«ENDFOR»'''");
		final RichString richString = (RichString) function.getExpression();
		final RichStringForLoop rsFor = (RichStringForLoop) richString.getExpressions().get(1);
		assertTrue(rsFor.getForExpression() instanceof XBinaryOperation);
		assertEquals("i", rsFor.getDeclaredParam().getName());
		assertTrue(rsFor.getSeparator() instanceof XStringLiteral);
		assertTrue(rsFor.getBefore() instanceof XStringLiteral);
		assertTrue(rsFor.getAfter() instanceof XFeatureCall);
		assertTrue(((XAbstractFeatureCall) rsFor.getAfter()).getFeature().eIsProxy());
	}
	
	public void testRichStringFOR_03() throws Exception {
		XtendFunction function = function("def withForLoop(String it) '''«it»«val it = 1..10»«FOR i: it SEPARATOR it»«ENDFOR»'''");
		final RichString richString = (RichString) function.getExpression();
		assertTrue(richString.getExpressions().get(0) instanceof RichStringLiteral);
		assertTrue(richString.getExpressions().get(1) instanceof XFeatureCall);
		JvmOperation operation = associations.getDirectlyInferredOperation(function);
		assertSame(operation.getParameters().get(0), ((XAbstractFeatureCall) richString.getExpressions().get(1)).getFeature());
		assertTrue(richString.getExpressions().get(2) instanceof RichStringLiteral);
		assertTrue(richString.getExpressions().get(3) instanceof XVariableDeclaration);
		assertTrue(richString.getExpressions().get(4) instanceof RichStringLiteral);
		assertTrue(richString.getExpressions().get(5) instanceof RichStringForLoop);
		
		final RichStringForLoop rsFor = (RichStringForLoop) richString.getExpressions().get(5);
		assertTrue(rsFor.getForExpression() instanceof XFeatureCall);
		assertSame(richString.getExpressions().get(3), ((XAbstractFeatureCall) rsFor.getForExpression()).getFeature()); 
		assertEquals("i", rsFor.getDeclaredParam().getName());
		assertTrue(rsFor.getSeparator() instanceof XFeatureCall);
		assertSame(richString.getExpressions().get(3), ((XAbstractFeatureCall) rsFor.getSeparator()).getFeature());
	}
	
	public void testRichStringWithComment_00() throws Exception {
		XtendFunction function = function("def foo() '''first««« comment \nsecond'''");
		assertTrue(function.getExpression() instanceof RichString);
		RichString richString = (RichString) function.getExpression();
		assertEquals(2, richString.getExpressions().size());
		RichStringLiteral first = (RichStringLiteral) richString.getExpressions().get(0);
		assertEquals("first", first.getValue());
		RichStringLiteral second = (RichStringLiteral) richString.getExpressions().get(1);
		assertEquals("second", second.getValue());
	}
	
	public void testRichStringWithComment_01() throws Exception {
		XtendFunction function = function("def foo() '''first« /* ml comment\n */ «« sl_comment \nsecond'''");
		assertTrue(function.getExpression() instanceof RichString);
		RichString richString = (RichString) function.getExpression();
		assertEquals(2, richString.getExpressions().size());
		RichStringLiteral first = (RichStringLiteral) richString.getExpressions().get(0);
		assertEquals("first", first.getValue());
		RichStringLiteral second = (RichStringLiteral) richString.getExpressions().get(1);
		assertEquals("second", second.getValue());
	}
	
	public void testRichStringWithComment_03() throws Exception {
		XtendFunction function = function("def foo() '''first««« comment \nsecond« /* ml comment */ »third'''");
		assertTrue(function.getExpression() instanceof RichString);
		RichString richString = (RichString) function.getExpression();
		assertEquals(3, richString.getExpressions().size());
		RichStringLiteral first = (RichStringLiteral) richString.getExpressions().get(0);
		assertEquals("first", first.getValue());
		RichStringLiteral second = (RichStringLiteral) richString.getExpressions().get(1);
		assertEquals("second", second.getValue());
		RichStringLiteral third = (RichStringLiteral) richString.getExpressions().get(2);
		assertEquals("third", third.getValue());
	}
	
	public void testImport_01() throws Exception {
		XtendImport importDeclaration = importDeclaration("");
		assertNull(importDeclaration);
	}
	
	public void testImport_02() throws Exception {
		XtendImport importDeclaration = importDeclaration("import java . util . /*comment*/ List");
		assertNotNull(importDeclaration);
		assertEquals("java.util.List", importDeclaration.getImportedTypeName());
		assertFalse(importDeclaration.isWildcard());
		assertFalse(importDeclaration.isStatic());
		assertFalse(importDeclaration.isExtension());
	}
	
	public void testImport_03() throws Exception {
		XtendImport importDeclaration = importDeclaration("import static java.util.Collections. * // foobar");
		assertNotNull(importDeclaration);
		assertEquals("java.util.Collections", importDeclaration.getImportedTypeName());
		assertTrue(importDeclaration.isWildcard());
		assertTrue(importDeclaration.isStatic());
		assertFalse(importDeclaration.isExtension());
	}
	
	public void testImport_04() throws Exception {
		XtendImport importDeclaration = importDeclaration("import static extension java.lang.reflect.\nArrays.*");
		assertNotNull(importDeclaration);
		assertEquals("java.lang.reflect.Arrays", importDeclaration.getImportedTypeName());
		assertTrue(importDeclaration.isWildcard());
		assertTrue(importDeclaration.isStatic());
		assertTrue(importDeclaration.isExtension());
	}
	
	public void testConstructor_01() throws Exception {
		XtendConstructor constructor = constructor("new() {}");
		assertTrue(constructor.getTypeParameters().isEmpty());
		assertTrue(constructor.getExceptions().isEmpty());
		assertTrue(constructor.getParameters().isEmpty());
		assertEquals(JvmVisibility.PUBLIC, constructor.getVisibility());
	}
	
	public void testConstructor_02() throws Exception {
		XtendConstructor constructor = constructor("protected new(int a) throws RuntimeException { super() }");
		assertTrue(constructor.getTypeParameters().isEmpty());
		assertEquals(1, constructor.getExceptions().size());
		assertEquals(1, constructor.getParameters().size());
		assertEquals(JvmVisibility.PROTECTED, constructor.getVisibility());
	}
	
	protected XtendImport importDeclaration(String importAsString) throws Exception {
		XtendFile file = file(importAsString + "\nclass Foo{}");
		if (file.getImports().isEmpty())
			return null;
		return file.getImports().get(0);
	}
}
