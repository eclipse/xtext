/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ContentAssistInElseBlockTest extends ContentAssistTest {

	//TODO CA works for the ignored cases, but have additional superfluous, wrong proposals (add members)
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_01() throws Exception {
		super.testAfterVariableDeclaration_01();
	}
	
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_02() throws Exception {
		super.testAfterVariableDeclaration_02();
	}
	
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_03() throws Exception {
		super.testAfterVariableDeclaration_03();
	}
	
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_04() throws Exception {
		super.testAfterVariableDeclaration_04();
	}
	
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_05() throws Exception {
		super.testAfterVariableDeclaration_05();
	}
	
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_06() throws Exception {
		super.testAfterVariableDeclaration_06();
	}
	
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_07() throws Exception {
		super.testAfterVariableDeclaration_07();
	}
	
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_08() throws Exception {
		super.testAfterVariableDeclaration_08();
	}
	
	@Ignore
	@Override
	@Test
	public void testEmptyInput() throws Exception {
		super.testEmptyInput();
	}
	
	@Override
	@Test public void testAfterBinaryOperation_10() throws Exception {
		newBuilder().append("((''+null))").assertTextAtCursorPosition(")", 
				"null", "!=", "!==", "==", "===", 
				"->", "=>", 
				"+", 
				"?:",
				"<", "<=", "<=>", ">=", ">",
				/*it.*/"nullOrEmpty");
	}
	
	@Override
	@Test public void testNull() throws Exception {
		newBuilder().append("null").assertText("null", "!=", "!==", "+", "==", "===", "->", "?:", "=>",
				"%", "*", "**", "-", "+=", "-=", "/", "<", "<=", "<=>", ">=", ">", "++", "--",
				/*it.*/"nullOrEmpty");
	}
	
	@Override
	protected String getPrefix() {
		return "class Name {\n"
				+ "  def void _operation() {\n"
				+ "    if ('foo' == 'bar') {\n"
				+ "    } else {\n"
				+ "      val it = 'my string'\n"
				+ "      ";
	}
	
	@Override
	protected String getSuffix() {
		return "\n}\n}\n}";
	}
	
	@Override
	protected String[] getKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.getKeywordsAndStatics());
		result.add("it");
		String[] stringFeatures = super.getStringFeatures();
		List<String> soFar = Lists.newArrayList(result);
		for (String stringFeature : stringFeatures) {
			if (!soFar.contains(stringFeature))
				result.add(stringFeature);
		}
		return result.toArray(new String[result.size()]);
	}
}
