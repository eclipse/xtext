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