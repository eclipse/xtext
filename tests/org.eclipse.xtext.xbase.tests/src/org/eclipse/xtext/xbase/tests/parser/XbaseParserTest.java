package org.eclipse.xtext.xbase.tests.parser;

import org.eclipse.xtext.xbase.File;
import org.eclipse.xtext.xbase.Function;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xpression.BinaryOperation;
import org.eclipse.xtext.xpression.BlockExpression;
import org.eclipse.xtext.xpression.BooleanLiteral;
import org.eclipse.xtext.xpression.CasePart;
import org.eclipse.xtext.xpression.CastedExpression;
import org.eclipse.xtext.xpression.Closure;
import org.eclipse.xtext.xpression.ConstructorCall;
import org.eclipse.xtext.xpression.FeatureCall;
import org.eclipse.xtext.xpression.IfExpression;
import org.eclipse.xtext.xpression.IntLiteral;
import org.eclipse.xtext.xpression.RichString;
import org.eclipse.xtext.xpression.RichStringLiteral;
import org.eclipse.xtext.xpression.StringLiteral;
import org.eclipse.xtext.xpression.SwitchExpression;
import org.eclipse.xtext.xpression.UnaryOperation;
import org.eclipse.xtext.xpression.VariableDeclaration;
import org.eclipse.xtext.xpression.WhileExpression;
import org.eclipse.xtext.xtype.FunctionTypeRef;
import org.eclipse.xtext.xtype.TypeParamDeclaration;

public class XbaseParserTest extends AbstractXbaseTestCase {

	public void testAddition_1() throws Exception {
		BinaryOperation operation = (BinaryOperation) expression("3 + 4");
		assertEquals(3, ((IntLiteral) operation.getLeft()).getValue());
		assertEquals("+", operation.getOperator());
		assertEquals(4, ((IntLiteral) operation.getRight()).getValue());
	}

	public void testAddition_2() throws Exception {
		BinaryOperation operation = (BinaryOperation) expression("foo + 'bar'");
		assertEquals("foo", ((FeatureCall) operation.getLeft()).getName());
		assertEquals("+", operation.getOperator());
		assertEquals("bar", ((StringLiteral) operation.getRight()).getValue());
	}

	public void testStringLiteral() throws Exception {
		StringLiteral literal = (StringLiteral) expression("'bar'");
		assertEquals("bar", literal.getValue());
	}

	public void testBooleanLiteral() throws Exception {
		BooleanLiteral literal = (BooleanLiteral) expression("true");
		assertTrue(literal.isIsTrue());
		literal = (BooleanLiteral) expression("false");
		assertFalse(literal.isIsTrue());
	}

	public void testClosure_1() throws Exception {
		Closure closure = (Closure) expression("|'foo'");
		assertEquals("foo", ((StringLiteral) closure.getExpression())
				.getValue());
	}

	public void testClosure_2() throws Exception {
		Closure closure = (Closure) expression("bar|'foo'");
		assertEquals("foo", ((StringLiteral) closure.getExpression())
				.getValue());
		assertEquals("bar", closure.getParams().get(0).getName());
		assertNull(closure.getParams().get(0).getType());
	}

	public void testClosure_3() throws Exception {
		Closure closure = (Closure) expression("String bar|'foo'");
		assertEquals("foo", ((StringLiteral) closure.getExpression())
				.getValue());
		assertEquals("bar", closure.getParams().get(0).getName());
		assertEquals(1, closure.getParams().size());
		assertNotNull(closure.getParams().get(0).getType());
	}

	public void testClosure_4() throws Exception {
		Closure closure = (Closure) expression("foo, String bar|'foo'");
		assertEquals("foo", ((StringLiteral) closure.getExpression())
				.getValue());
		assertEquals("foo", closure.getParams().get(0).getName());
		assertEquals("bar", closure.getParams().get(1).getName());
		assertEquals(2, closure.getParams().size());
		assertNull(closure.getParams().get(0).getType());
		assertNotNull(closure.getParams().get(1).getType());
	}

	public void testCastedExpression() throws Exception {
		CastedExpression cast = (CastedExpression) expression("(Foo)bar");
		assertTrue(cast.getTarget() instanceof FeatureCall);
		assertNotNull(cast.getType());
	}

	public void testCastedExpression_1() throws Exception {
		FeatureCall call = (FeatureCall) expression("(Foo)");
		assertNotNull(call);
	}

	public void testUnaryOperation() throws Exception {
		UnaryOperation call = (UnaryOperation) expression("-(Foo)");
		assertNotNull(call);
	}

	public void testFeatureCall_0() throws Exception {
		FeatureCall call = (FeatureCall) expression("foo");
		assertNotNull(call);
	}

	public void testFeatureCall_1() throws Exception {
		FeatureCall call = (FeatureCall) expression("foo.bar");
		assertNotNull(call);
		assertTrue(call.getTarget() instanceof FeatureCall);
	}

	public void testFeatureCall_2() throws Exception {
		FeatureCall call = (FeatureCall) expression("'holla'.bar()");
		assertNotNull(call);
		assertEquals(0, call.getParams().size());
		assertTrue(call.getTarget() instanceof StringLiteral);
	}

	public void testFeatureCall_3() throws Exception {
		FeatureCall call = (FeatureCall) expression("'holla'.bar(4)");
		assertNotNull(call);
		assertEquals(1, call.getParams().size());
		assertEquals(4, ((IntLiteral) call.getParams().get(0)).getValue());
		assertTrue(call.getTarget() instanceof StringLiteral);
	}

	public void testFeatureCall_4() throws Exception {
		FeatureCall call = (FeatureCall) expression("bar(0,1,2)");
		assertNotNull(call);
		assertEquals(3, call.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((IntLiteral) call.getParams().get(i)).getValue());
		assertNull(call.getTarget());
	}

	public void testIf_0() throws Exception {
		IfExpression ie = (IfExpression) expression("if (true) false");
		assertTrue(((BooleanLiteral) ie.getIf()).isIsTrue());
		assertFalse(((BooleanLiteral) ie.getThen()).isIsTrue());
		assertNull(ie.getElse());
	}

	public void testIf_1() throws Exception {
		IfExpression ie = (IfExpression) expression("if (true) false else bar");
		assertTrue(((BooleanLiteral) ie.getIf()).isIsTrue());
		assertFalse(((BooleanLiteral) ie.getThen()).isIsTrue());
		assertTrue(ie.getElse() instanceof FeatureCall);
	}

	public void testSwitch_0() throws Exception {
		SwitchExpression se = (SwitchExpression) expression("switch { case 1==0 : '1' }");
		assertNull(se.getDefault());
		assertEquals(1, se.getCases().size());
		assertNull(se.getSwitch());
		CasePart casePart = se.getCases().get(0);
		assertTrue(casePart.getCase() instanceof BinaryOperation);
		assertTrue(casePart.getThen() instanceof StringLiteral);
	}

	public void testSwitch_1() throws Exception {
		SwitchExpression se = (SwitchExpression) expression("switch number{case 1:'1'case 2:'2'default:'3'}");
		assertTrue(se.getDefault() instanceof StringLiteral);
		assertEquals(2, se.getCases().size());
		assertTrue(se.getSwitch() instanceof FeatureCall);

		CasePart case1 = se.getCases().get(0);
		assertEquals(1, ((IntLiteral) case1.getCase()).getValue());
		assertTrue(case1.getThen() instanceof StringLiteral);

		CasePart case2 = se.getCases().get(1);
		assertEquals(2, ((IntLiteral) case2.getCase()).getValue());
		assertTrue(case2.getThen() instanceof StringLiteral);
	}

	public void testBlockExpression_0() throws Exception {
		BlockExpression be = (BlockExpression) expression("{foo;}");
		assertEquals(1, be.getExpressions().size());
		assertTrue(be.getExpressions().get(0) instanceof FeatureCall);
	}

	public void testBlockExpression_1() throws Exception {
		BlockExpression be = (BlockExpression) expression("{foo;bar;}");
		assertEquals(2, be.getExpressions().size());
		assertTrue(be.getExpressions().get(0) instanceof FeatureCall);
		assertTrue(be.getExpressions().get(1) instanceof FeatureCall);
	}

	public void testBlockExpression_withVariableDeclaration_0()
			throws Exception {
		BlockExpression be = (BlockExpression) expression("{def foo := bar;bar;}");
		assertEquals(2, be.getExpressions().size());
		VariableDeclaration vd = (VariableDeclaration) be.getExpressions().get(
				0);
		assertEquals("foo", vd.getName());
		assertTrue(vd.getRight() instanceof FeatureCall);
		assertNull(vd.getType());
		assertTrue(be.getExpressions().get(1) instanceof FeatureCall);
	}

	public void testBlockExpression_withVariableDeclaration_1()
			throws Exception {
		BlockExpression be = (BlockExpression) expression("{MyType foo := bar;bar;}");
		assertEquals(2, be.getExpressions().size());
		VariableDeclaration vd = (VariableDeclaration) be.getExpressions().get(
				0);
		assertEquals("foo", vd.getName());
		assertTrue(vd.getRight() instanceof FeatureCall);
		assertNotNull(vd.getType());
		assertTrue(be.getExpressions().get(1) instanceof FeatureCall);
	}

	public void testConstructorCall_0() throws Exception {
		ConstructorCall cc = (ConstructorCall) expression("new Foo");
		assertNotNull(cc.getType());
		assertNull(cc.getInitializer());
		assertEquals(0, cc.getParams().size());
	}

	public void testConstructorCall_1() throws Exception {
		ConstructorCall cc = (ConstructorCall) expression("new Foo(0,1,2)");
		assertNotNull(cc.getType());
		assertNull(cc.getInitializer());
		assertEquals(3, cc.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((IntLiteral) cc.getParams().get(i)).getValue());
	}

	public void testConstructorCall_2() throws Exception {
		ConstructorCall cc = (ConstructorCall) expression("new Foo(0,1,2) { this.foo = bar;}");
		assertNotNull(cc.getType());
		assertTrue(cc.getInitializer() instanceof BlockExpression);
		assertEquals(3, cc.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((IntLiteral) cc.getParams().get(i)).getValue());
	}

	public void testRichString() throws Exception {
		RichString rs = (RichString) expression("\u00BBHallo \u00ABfoo\u00BB Welt!\u00AB");
		assertEquals(3, rs.getExpressions().size());
		assertTrue(rs.getExpressions().get(0) instanceof RichStringLiteral);
		assertTrue(rs.getExpressions().get(1) instanceof FeatureCall);
		assertTrue(rs.getExpressions().get(2) instanceof RichStringLiteral);
	}
	
	public void testWhileExpression() throws Exception {
		WhileExpression expression = (WhileExpression) expression("while (true) 'foo'");
		assertTrue(expression.getPredicate() instanceof BooleanLiteral);
		assertTrue(expression.getBody() instanceof StringLiteral);
	}

	public void testFile_0() throws Exception {
		File file = file("foo() : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNull(func.getReturnType());
		assertNull(func.getGuard());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFile_1() throws Exception {
		File file = file("String foo() : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNotNull(func.getReturnType());
		assertNull(func.getGuard());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFile_2() throws Exception {
		File file = file("foo(String s) : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(1, func.getDeclaredParams().size());
		assertEquals("s", func.getDeclaredParams().get(0).getName());
		assertNotNull(func.getDeclaredParams().get(0).getType());
		assertNull(func.getReturnType());
		assertNull(func.getGuard());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFile_3() throws Exception {
		File file = file("foo(String s, Integer i) : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(2, func.getDeclaredParams().size());
		assertEquals("s", func.getDeclaredParams().get(0).getName());
		assertNotNull(func.getDeclaredParams().get(0).getType());
		assertEquals("i", func.getDeclaredParams().get(1).getName());
		assertNotNull(func.getDeclaredParams().get(1).getType());
		assertNull(func.getReturnType());
		assertNull(func.getGuard());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFile_4() throws Exception {
		File file = file("private foo() : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNull(func.getReturnType());
		assertNull(func.getGuard());
		assertFalse(func.isFinal());
		assertTrue(func.isPrivate());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFile_5() throws Exception {
		File file = file("private final foo() : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNull(func.getReturnType());
		assertNull(func.getGuard());
		assertTrue(func.isFinal());
		assertTrue(func.isPrivate());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFile_6() throws Exception {
		File file = file("final private foo() : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNull(func.getReturnType());
		assertNull(func.getGuard());
		assertTrue(func.isFinal());
		assertTrue(func.isPrivate());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFile_7() throws Exception {
		File file = file("final foo() : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof FeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNull(func.getReturnType());
		assertNull(func.getGuard());
		assertTrue(func.isFinal());
		assertFalse(func.isPrivate());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testTypeParams_1() throws Exception {
		File file = file("<T> foo(T t) : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals(1, func.getTypeParams().size());
		TypeParamDeclaration tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(0, tp.getExtends().size());
		assertNull(tp.getSuper());
	}

	public void testTypeParams_2() throws Exception {
		File file = file("<T extends Bar> foo(T t) : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals(1, func.getTypeParams().size());
		TypeParamDeclaration tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getExtends().size());
		assertNull(tp.getSuper());
	}

	public void testTypeParams_3() throws Exception {
		File file = file("<T extends Foo & Bar> foo(T t) : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals(1, func.getTypeParams().size());
		TypeParamDeclaration tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(2, tp.getExtends().size());
		assertNull(tp.getSuper());
	}

	public void testTypeParams_4() throws Exception {
		File file = file("<T super Foo> foo(T t) : bar;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		assertEquals(1, func.getTypeParams().size());
		TypeParamDeclaration tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(0, tp.getExtends().size());
		assertNotNull(tp.getSuper());
	}
	
	public void testFunctionTypeRef_0() throws Exception {
		File file = file("=>Boolean foo() : |true;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		FunctionTypeRef type = (FunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(0,type.getParamTypes().size());
	}
	
	public void testFunctionTypeRef_1() throws Exception {
		File file = file("(String)=>Boolean foo() : String s|s==null;");
		assertNotNull(file);
		assertEquals(1, file.getFunctions().size());
		Function func = file.getFunctions().get(0);
		FunctionTypeRef type = (FunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(1,type.getParamTypes().size());
		assertNotNull(type.getParamTypes().get(0));
	}
}
