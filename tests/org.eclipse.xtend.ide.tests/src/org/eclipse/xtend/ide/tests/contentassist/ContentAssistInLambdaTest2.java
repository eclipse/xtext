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
public class ContentAssistInLambdaTest2 extends ContentAssistTest {

	// class, interface, enum, annotation proposed???
	@Ignore
	@Override
	@Test
	public void testAfterVariableDeclaration_11() throws Exception {
		super.testAfterVariableDeclaration_11();
	}
	
	// class, interface, enum, annotation proposed???
	@Ignore
	@Override
	@Test
	public void testOnStringLiteral_11() throws Exception {
		super.testOnStringLiteral_11();
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
		return "class Name { def (String)=>void _operation() { [ '' => [ String mySpecialLocalVariable|";
	}
	
	@Override
	protected String getSuffix() {
		return "\n]\n]\n}\n}";
	}
	
	@Override
	protected String[] getKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.getKeywordsAndStatics());
		result.add("it");
		result.add("self");
		result.add("mySpecialLocalVariable");
		String[] stringFeatures = super.getStringFeatures();
		List<String> soFar = Lists.newArrayList(result);
		for (String stringFeature : stringFeatures) {
			if (!soFar.contains(stringFeature))
				result.add(stringFeature);
		}
		return result.toArray(new String[result.size()]);
	}
}
