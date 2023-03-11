/*******************************************************************************
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.List;

import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ContentAssistInLambda2Test extends ContentAssistTest {

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
	protected String[] baseGetKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.baseGetKeywordsAndStatics());
		result.add("mySpecialLocalVariable");
		return result.toArray(new String[result.size()]);
	}
	
	@Override
	@Test public void testForLoop_02() throws Exception {
		if (JavaRuntimeVersion.isJava13OrLater()) {
			newBuilder().append("for (String string: null) string").assertTextAtCursorPosition(") string", 6, "string", "strip", "stripIndent", "stripLeading", "stripTrailing");
		} else {
			newBuilder().append("for (String string: null) string").assertTextAtCursorPosition(") string", 6, "string", "strip", "stripLeading", "stripTrailing");
		}
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
