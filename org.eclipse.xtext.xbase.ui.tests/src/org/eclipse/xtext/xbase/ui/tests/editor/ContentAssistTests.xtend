/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor

import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInArgumentListTest extends ContentAssistTest {
	override protected getPrefix() {
		return "doesNotExist("
	}
	override protected getSuffix() {
		return ")" 
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInArgumentListTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "doesNotExist(null,"
	}
	override protected getSuffix() {
		return ")" 
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInArgumentListTest3 extends ContentAssistTest {
	override protected getPrefix() {
		return "does.not().exist("
	}
	override protected getSuffix() {
		return ")" 
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInArgumentListTest4 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "doesNotExist[|"
	}
	override protected getSuffix() {
		return "]" 
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInArgumentListTest5 extends ContentAssistTest {
	override protected getPrefix() {
		return "does.not().exist(null,"
	}
	override protected getSuffix() {
		return ")" 
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInArgumentListTest6 extends ContentAssistTest {
	override protected getPrefix() {
		return "does.not().exist(|"
	}
	override protected getSuffix() {
		return ")" 
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInIfConditionTest extends ContentAssistTest {
	override protected getPrefix() {
		return "if ("
	}
	override protected getSuffix() {
		return ") {}" 
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInIfThenTest extends ContentAssistTest {
	override protected getPrefix() {
		return "if (true)"
	}
	
	@AfterClass
	def static void resetCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'instanceof']
	}
	@BeforeClass
	def static void addElseToCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'else', 'instanceof']
	}
	override testOnStringLiteral_33() throws Exception {
		newBuilder().append("(''.toString )").assertTextAtCursorPosition(")", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_06() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", 1, expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_07() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testOnVoidMethod_01() throws Exception {
		newBuilder().append("(null as java.util.List).clear ").assertText('else');
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInIfThenTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "if (true) ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInIfThenTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "if (true) {"
	}
	
	override protected getSuffix() {
		return "\n}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInIfElseTest extends ContentAssistTest {
	override protected getPrefix() {
		return "if (true) {} else"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInIfElseTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "if (true) {} else ("
	}
	
	override protected getSuffix() {
		return ")"
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistInIfElseTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "if (true) {} else {"
	}
	
	override protected getSuffix() {
		return "\n}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistReturnTest extends ContentAssistTest {
	override protected getPrefix() {
		return "return"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistReturnTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "return ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistReturnTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "return {"
	}
	
	override protected getSuffix() {
		return "}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistReturnTest4 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "{ return "
	}
	
	override protected getSuffix() {
		return "}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistThrowTest extends ContentAssistTest {
	override protected getPrefix() {
		return "throw"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistThrowTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "throw ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistThrowTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "throw {"
	}
	
	override protected getSuffix() {
		return "}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistTryTest extends ContentAssistTest {
	override protected getPrefix() {
		return "try"
	}
	
	@AfterClass
	def static void resetCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'instanceof']
	}
	@BeforeClass
	def static void addCatchAndFinallyToCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'catch', 'finally', 'instanceof']
	}
	override testOnStringLiteral_33() throws Exception {
		newBuilder().append("(''.toString )").assertTextAtCursorPosition(")", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_06() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", 1, expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_07() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testOnVoidMethod_01() throws Exception {
		newBuilder().append("(null as java.util.List).clear ").assertText('catch', 'finally');
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistTryTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "try ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistTryTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "try {"
	}
	
	override protected getSuffix() {
		return "}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistCatchTest extends ContentAssistTest {
	override protected getPrefix() {
		return "try { var x = 0 } catch(Exception ex)"
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'ex'
		return result
	}
	
	@AfterClass
	def static void resetCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'instanceof']
	}
	@BeforeClass
	def static void addCatchAndFinallyToCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'catch', 'finally', 'instanceof']
	}
	override testOnStringLiteral_33() throws Exception {
		newBuilder().append("(''.toString )").assertTextAtCursorPosition(")", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_06() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", 1, expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_07() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testOnVoidMethod_01() throws Exception {
		newBuilder().append("(null as java.util.List).clear ").assertText('catch', 'finally');
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistCatchTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "try { var x = 0 } catch(Exception ex) ("
	}
	
	override protected getSuffix() {
		return ")"
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'ex'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistCatchTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "try { var x = 0 } catch(Exception ex) {"
	}
	
	override protected getSuffix() {
		return "}"
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'ex'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistFinallyTest extends ContentAssistTest {
	override protected getPrefix() {
		return "try { var x = 0 } finally"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistFinallyTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "try { var x = 0 } finally ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistFinallyTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "try { var x = 0 } finally {"
	}
	
	override protected getSuffix() {
		return "}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistFinallyTest4 extends ContentAssistTest {
	override protected getPrefix() {
		return "try { var x = 0 } catch(Exception ex) {} finally"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistFinallyTest5 extends ContentAssistTest {
	override protected getPrefix() {
		return "try { var x = 0 } catch(Exception ex) {} finally ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistFinallyTest6 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "try { var x = 0 } catch(Exception ex) {} finally {"
	}
	
	override protected getSuffix() {
		return "}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest extends ContentAssistTest {
	override protected getPrefix() {
		return "for("
	}
	
	override protected getSuffix() {
		return ", var z = 1"
	}
	
	override testEmptyInput() throws Exception {
		newBuilder().assertText(expect(getKeywordsAndStatics(), #['var', 'val']));
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "for( var x = 1,"
	}
	
	override protected getSuffix() {
		return ", var z = 1"
	}
	
	override testEmptyInput() throws Exception {
		newBuilder().assertText(expect(getKeywordsAndStatics(), #['var', 'val']));
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'x'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest3 extends ContentAssistTest {
	override protected getPrefix() {
		return "for( var x = 1;"
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'x'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest4 extends ContentAssistTest {
	override protected getPrefix() {
		return "for( var x = 1; x < 10;"
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'x'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest5 extends ContentAssistTest {
	override protected getPrefix() {
		return "for( var x = 1; x < 10; x++,"
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'x'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest6 extends ContentAssistTest {
	override protected getPrefix() {
		return "for(var x = 1; x < 10; x++)"
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'x'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest7 extends ContentAssistTest {
	override protected getPrefix() {
		return "for( var x = 1; x < 10; x++) ("
	}
	
	override protected getSuffix() {
		return ')'
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'x'
		return result
	}
}


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest8 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "for( var y = 1; x < 10; x++) {"
	}
	
	override protected getSuffix() {
		return '}'
	}
	
	override protected getKeywordsAndStatics() {
		val result = newArrayList(super.getKeywordsAndStatics)
		result += 'y'
		return result
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistForTest9 extends ContentAssistTest {
	override protected getPrefix() {
		return "for( String s:"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistWhileTest extends ContentAssistTest {
	override protected getPrefix() {
		return "while (true)"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistWhileTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "while (true) ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistWhileTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "while (true) {"
	}
	
	override protected getSuffix() {
		return "}"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistWhileTest4 extends ContentAssistTest {
	override protected getPrefix() {
		return "while ("
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistDoWhileTest extends ContentAssistTest {
	override protected getPrefix() {
		return "do"
	}
	
	@AfterClass
	def static void resetCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'instanceof']
	}
	@BeforeClass
	def static void addWhileToCastInstanceOf() {
		CAST_INSTANCEOF = #['as', 'while', 'instanceof']
	}
	override testOnStringLiteral_33() throws Exception {
		newBuilder().append("(''.toString )").assertTextAtCursorPosition(")", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_06() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", 1, expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testAfterBinaryOperation_07() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", expect(STRING_OPERATORS, #['as', 'instanceof']));
	}
	override testOnVoidMethod_01() throws Exception {
		newBuilder().append("(null as java.util.List).clear ").assertText('while');
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistDoWhileTest2 extends ContentAssistTest {
	override protected getPrefix() {
		return "do ("
	}
	
	override protected getSuffix() {
		return ")"
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ContentAssistDoWhileTest3 extends ContentAssistInBlockTest {
	override protected getPrefix() {
		return "do {"
	}
	
	override protected getSuffix() {
		return "}"
	}
}