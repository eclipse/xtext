/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistTest extends AbstractXbaseUITestCase {

	@Override
	protected boolean doCleanWorkspace() {
		return false;
	}
	
	public void testEmptyInput() throws Exception {
		newBuilder().assertText(KEYWORDS);
	}
	
	protected static String[] KEYWORDS = {
		"if", 
		"while", "for", "do",
		"true", "false",
		"typeof",
		"try",
		"switch",
		"new",
		"throw",
		"null"
	};
	
	protected static String[] STRING_OPERATORS = {
		"==", "!=",
		"+",
		"<=", ">=", "<", ">"
	};
	
	protected static String[] CAST_INSTANCEOF = {
		"as", "instanceof"
	};
	
	protected static final String[] STRING_FEATURES;
	
	static {
		Set<String> features = Sets.newHashSet();
		for(Method method: String.class.getMethods()) {
			features.add(method.getName());
			if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
				features.add(Strings.toFirstLower(method.getName().substring(3)));
			}
		}
		for(Field field: String.class.getFields()) {
			features.add(field.getName());
		}
		STRING_FEATURES = features.toArray(new String[features.size()]);
	}

	protected String[] expect(String[]... arrays) {
		List<String> expectation = Lists.newArrayList();
		for(String[] array: arrays) {
			expectation.addAll(Arrays.asList(array));
		}
		return expectation.toArray(new String[expectation.size()]);
	}
	
	public void testOnStringLiteral_01() throws Exception {
		newBuilder().append("''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_02() throws Exception {
		newBuilder().append("''.").assertText(STRING_FEATURES);
	}
	
	public void testOnStringLiteral_03() throws Exception {
		newBuilder().append("''.").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_04() throws Exception {
		newBuilder().append("''+''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_05() throws Exception {
		newBuilder().append("''+''").assertTextAtCursorPosition("+''", 1, expect(new String[]{"+"}, KEYWORDS));
	}
	
	public void testOnStringLiteral_06() throws Exception {
		newBuilder().append("''==''").assertTextAtCursorPosition("==", 1, "==");
	}
	
	public void testOnStringLiteral_07() throws Exception {
		newBuilder().append("''==''").assertTextAtCursorPosition("==", 2, expect(new String[]{"=="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_08() throws Exception {
		newBuilder().append("''<=''").assertTextAtCursorPosition("<=", 1, expect(new String[]{"<", "<="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_09() throws Exception {
		newBuilder().append("''<=''").assertTextAtCursorPosition("<=", 2, expect(new String[]{"<="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_10() throws Exception {
		newBuilder().append("'' ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_11() throws Exception {
		newBuilder().append("''. ").assertText(STRING_FEATURES);
	}
	
	public void testOnStringLiteral_12() throws Exception {
		newBuilder().append("'' .").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_13() throws Exception {
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_14() throws Exception {
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+ ''", 2, KEYWORDS);
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+ ''", 1, expect(new String[]{"+"}, KEYWORDS));
	}
	
	public void testOnStringLiteral_15() throws Exception {
		newBuilder().append("'' == ''").assertTextAtCursorPosition("==", 1, "==");
	}
	
	public void testOnStringLiteral_16() throws Exception {
		newBuilder().append("'' == ''").assertTextAtCursorPosition("==", 2, expect(new String[]{"=="}, KEYWORDS));
		newBuilder().append("'' == ''").assertTextAtCursorPosition("==", 3, KEYWORDS);
	}
	
	public void testOnStringLiteral_17() throws Exception {
		newBuilder().append("'' <= ''").assertTextAtCursorPosition("<=", 1, expect(new String[]{"<", "<="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_18() throws Exception {
		newBuilder().append("'' <= ''").assertTextAtCursorPosition("<=", 2, expect(new String[]{"<="}, KEYWORDS));
		newBuilder().append("'' <= ''").assertTextAtCursorPosition("<=", 3, KEYWORDS);
	}
	
	public void testOnStringLiteral_19() throws Exception {
		newBuilder().append("''.toString").assertText(expect(STRING_OPERATORS, new String[]{"toString"}));
	}
//TODO	
//	public void testOnStringLiteral_20() throws Exception {
//		newBuilder().append("''.toString.").assertText(STRING_FEATURES);
//	}
//	
//	public void testOnStringLiteral_21() throws Exception {
//		newBuilder().append("''.toString.").assertTextAtCursorPosition("g.", 1, expect(STRING_OPERATORS, new String[]{"toString"}));
//	}
	
	public void testOnStringLiteral_22() throws Exception {
		newBuilder().append("''.toString+''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	public void testOnStringLiteral_23() throws Exception {
		newBuilder().append("''.toString+''").assertTextAtCursorPosition("+''", 1, expect(new String[]{"+"}, KEYWORDS));
	}
	
	public void testOnStringLiteral_24() throws Exception {
		newBuilder().append("''.toString==''").assertTextAtCursorPosition("==", 1, expect(new String[] {"=="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_25() throws Exception {
		newBuilder().append("''.toString==''").assertTextAtCursorPosition("==", 2, expect(new String[]{"=="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_26() throws Exception {
		newBuilder().append("''.toString<=''").assertTextAtCursorPosition("<=", 1, expect(new String[]{"<", "<="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_27() throws Exception {
		newBuilder().append("''.toString<=''").assertTextAtCursorPosition("<=", 2, expect(new String[]{"<="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_28() throws Exception {
		newBuilder().append("''.toString.toString").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_29() throws Exception {
		newBuilder().append("''.toString.toString.toString").assertTextAtCursorPosition("g.", 1, expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	public void testOnStringLiteral_30() throws Exception {
		newBuilder().append("('')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_31() throws Exception {
		newBuilder().append("('').").assertText(STRING_FEATURES);
	}
	
	public void testOnStringLiteral_32() throws Exception {
		newBuilder().append("(''.toString)").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_33() throws Exception {
		newBuilder().append("(''.toString )").assertTextAtCursorPosition(")", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_34() throws Exception {
		newBuilder().append("''.toString ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
//TODO	
//	public void testOnStringLiteral_35() throws Exception {
//		newBuilder().append("''.toString .").assertTextAtCursorPosition("g .", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF));
//	}
	
	public void testOnStringLiteral_36() throws Exception {
		newBuilder().append("''.toString +''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testOnStringLiteral_37() throws Exception {
		newBuilder().append("''.toString ==''").assertTextAtCursorPosition("==", 1, expect(new String[] {"=="}, KEYWORDS));
	}
	
	public void testOnStringLiteral_38() throws Exception {
		newBuilder().append("''.toString.toString").assertTextAtCursorPosition("g.", 1, expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	public void testAfterBinaryOperation_01() throws Exception {
		newBuilder().append("''+''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testAfterBinaryOperation_02() throws Exception {
		newBuilder().append("'' + ''+''").assertTextAtCursorPosition("''+", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testAfterBinaryOperation_03() throws Exception {
		newBuilder().append("(''+'')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
//TODO	
//	public void testAfterBinaryOperation_04() throws Exception {
//		newBuilder().append("(''+'').").assertText(STRING_FEATURES);
//	}
	
	public void testAfterBinaryOperation_05() throws Exception {
		newBuilder().append("((''+''))").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testAfterBinaryOperation_06() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", 1, expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	public void testAfterBinaryOperation_07() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
//TODO	
//	public void testAfterBinaryOperation_08() throws Exception {
//		newBuilder().append("((''+(''.bytes)))").assertTextAtCursorPosition(")", "==", "!=", "+=", "+", "bytes");
//	}
//	
//	public void testAfterBinaryOperation_09() throws Exception {
//		newBuilder().append("((''+''.bytes))").assertTextAtCursorPosition(")", "==", "!=", "+=", "+", "bytes");
//	}
	
	public void testAfterBinaryOperation_10() throws Exception {
		newBuilder().append("((''+null))").assertTextAtCursorPosition(")", "null", "!=", "==");
	}
	
	public void testNull() throws Exception {
		newBuilder().append("null").assertText("null", "!=", "==");
	}
	
	public void testForLoop_01() throws Exception {
		newBuilder().append("for (String s: null) ").assertText(expect(new String[]{"s"}, KEYWORDS));
	}
	
	public void testForLoop_02() throws Exception {
		newBuilder().append("for (String string: null) string").assertTextAtCursorPosition(") string", 6, "string");
	}
	
	public void testForLoop_03() throws Exception {
		newBuilder().append("for (String string: null) ''+").assertText(expect(new String[] {"string", "+"}, KEYWORDS));
	}
	
	// ContentAssistInBlockTest defines testForLoop_0[45]
	public void testForLoop_06() throws Exception {
		newBuilder().append("for (String string: ").assertText(KEYWORDS);
	}
	
	public void testForLoop_07() throws Exception {
		newBuilder().append("for (String string: )").assertTextAtCursorPosition(")", KEYWORDS);
	}
	
	public void testClosure_01() throws Exception {
		newBuilder().append("[String a, String b|").assertText(expect(new String[]{"a", "b"}, KEYWORDS));
	}
	
	public void testCatchParameter_01() throws Exception {
		newBuilder().append("try {} catch(NullPointerException e) e").assertTextAtCursorPosition(") e", 2, expect(new String[]{"e"}, KEYWORDS));
	}
	
	public void testCatchParameter_02() throws Exception {
		newBuilder().append("try {} catch(NullPointerException e) ").assertText(expect(new String[]{"e"}, KEYWORDS));
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}
	
	@Override
	public XtextResource getResourceFor(InputStream stream) {
		XtextResource result = super.getResourceFor(stream);
		initializeTypeProvider(result);
		return result;
	}

	protected void initializeTypeProvider(XtextResource result) {
		XtextResourceSet resourceSet = (XtextResourceSet) result.getResourceSet();
		IJvmTypeProvider.Factory typeProviderFactory = new ClasspathTypeProviderFactory(getClass().getClassLoader());
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
	}
}
