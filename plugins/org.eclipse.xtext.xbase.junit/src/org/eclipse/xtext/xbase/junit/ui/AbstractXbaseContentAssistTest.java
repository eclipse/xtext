package org.eclipse.xtext.xbase.junit.ui;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit.util.ResourceLoadHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public abstract class AbstractXbaseContentAssistTest extends TestCase implements ResourceLoadHelper {

	@Inject
	protected IWorkspace workspace;

	protected String fileExtension;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getInjector().injectMembers(this);
	}

	@Override
	protected void tearDown() throws Exception {
		if (doCleanWorkspace())
			IResourcesSetupUtil.cleanWorkspace();
		super.tearDown();
	}
	
	protected boolean doCleanWorkspace() {
		return true;
	}
	
	protected abstract Injector getInjector();
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected XExpression expression(String string) throws Exception {
		XtextResource resource = getResourceFor(new StringInputStream(string));
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XExpression result = (XExpression) resource.getContents().get(0);
		return result;
	}
	
	public XtextResource getResourceFor(InputStream stream) {
		try {
			XtextResourceSet set = get(XtextResourceSet.class);
			XtextResource result = (XtextResource) set.createResource(URI.createURI("Test." + fileExtension));
			result.load(stream, null);
			return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Inject
	protected void setExtensions(@Named(Constants.FILE_EXTENSIONS) String extensions) {
		this.fileExtension = extensions.split(",")[0];
	}
	
	@Test public void testEmptyInput() throws Exception {
		newBuilder().assertText(getKeywordsAndStatics());
	}
	
	protected String[] getKeywordsAndStatics() {
		return KEYWORDS_AND_STATICS;
	}
	
	protected static String[] KEYWORDS_AND_STATICS = {
		"if", 
		"while", "for", "do",
		"true", "false",
		"typeof",
		"try",
		"switch",
		"new",
		"throw",
		"return",
		"null",
		// Collection Literals
		"emptyList",
		"emptySet",
		"emptyMap",
		"newImmutableList()",
		"newImmutableSet()",
		"newImmutableMap()",
		"newArrayList()",
		"newLinkedList()",
		"newHashSet()",
		"newLinkedHashSet()",
		"newTreeSet()",
		"newHashMap()",
		"newLinkedHashMap()",
		"newTreeMap()",
		// InputOutput,
		"print()",
		"println()"
	};
	
	protected static String[] STRING_OPERATORS = {
		"==", "!=",
		"+",
		"<=", ">=", "<", ">",
		"->"
	};
	
	protected static String[] CAST_INSTANCEOF = {
		"as", "instanceof"
	};
	
	protected static final String[] STRING_FEATURES;
	
	static {
		List<String> features = Lists.newArrayList();
		for(Method method: String.class.getMethods()) {
			if (method.getParameterTypes().length == 0) {
				if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
					features.add(Strings.toFirstLower(method.getName().substring(3)));
				} else {
					features.add(method.getName());
				}
			} else {
				features.add(method.getName() + "()");				
			}
		}
		// compareTo(T) is actually overridden by compareTo(String) but contained twice in String.class#getMethods
		features.remove("compareTo()");
		Set<String> featuresAsSet = Sets.newHashSet(features);
		for(Field field: String.class.getFields()) {
			if (featuresAsSet.add(field.getName()))
				features.add(field.getName());
		}
		// StringExtensions
		features.add("toFirstLower");
		features.add("toFirstUpper");
		features.add("nullOrEmpty");
		STRING_FEATURES = features.toArray(new String[features.size()]);
	}
	
	public String[] getStringFeatures() {
		return STRING_FEATURES;
	}

	protected String[] expect(String[]... arrays) {
		List<String> expectation = Lists.newArrayList();
		for(String[] array: arrays) {
			expectation.addAll(Arrays.asList(array));
		}
		return expectation.toArray(new String[expectation.size()]);
	}
	
	@Test public void testOnStringLiteral_01() throws Exception {
		newBuilder().append("''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_02() throws Exception {
		newBuilder().append("''.").assertText(getStringFeatures());
	}
	
	@Test public void testOnStringLiteral_03() throws Exception {
		newBuilder().append("''.").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_04() throws Exception {
		newBuilder().append("''+''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_05() throws Exception {
		newBuilder().append("''+''").assertTextAtCursorPosition("+''", 1, expect(new String[]{"+"}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_06() throws Exception {
		newBuilder().append("''==''").assertTextAtCursorPosition("==", 1, "==");
	}
	
	@Test public void testOnStringLiteral_07() throws Exception {
		newBuilder().append("''==''").assertTextAtCursorPosition("==", 2, expect(new String[]{"=="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_08() throws Exception {
		newBuilder().append("''<=''").assertTextAtCursorPosition("<=", 1, expect(new String[]{"<", "<="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_09() throws Exception {
		newBuilder().append("''<=''").assertTextAtCursorPosition("<=", 2, expect(new String[]{"<="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_10() throws Exception {
		newBuilder().append("'' ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_11() throws Exception {
		newBuilder().append("''. ").assertText(getStringFeatures());
	}
	
	@Test public void testOnStringLiteral_12() throws Exception {
		newBuilder().append("'' .").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_13() throws Exception {
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_14() throws Exception {
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+ ''", 2, getKeywordsAndStatics());
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+ ''", 1, expect(new String[]{"+"}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_15() throws Exception {
		newBuilder().append("'' == ''").assertTextAtCursorPosition("==", 1, "==");
	}
	
	@Test public void testOnStringLiteral_16() throws Exception {
		newBuilder().append("'' == ''").assertTextAtCursorPosition("==", 2, expect(new String[]{"=="}, getKeywordsAndStatics()));
		newBuilder().append("'' == ''").assertTextAtCursorPosition("==", 3, getKeywordsAndStatics());
	}
	
	@Test public void testOnStringLiteral_17() throws Exception {
		newBuilder().append("'' <= ''").assertTextAtCursorPosition("<=", 1, expect(new String[]{"<", "<="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_18() throws Exception {
		newBuilder().append("'' <= ''").assertTextAtCursorPosition("<=", 2, expect(new String[]{"<="}, getKeywordsAndStatics()));
		newBuilder().append("'' <= ''").assertTextAtCursorPosition("<=", 3, getKeywordsAndStatics());
	}
	
	@Test public void testOnStringLiteral_19() throws Exception {
		newBuilder().append("''.toString").assertText(expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	@Test public void testOnStringLiteral_20() throws Exception {
		newBuilder().append("''.toString.").assertText(getStringFeatures());
	}
	
	@Test public void testOnStringLiteral_21() throws Exception {
		newBuilder().append("''.toString.").assertTextAtCursorPosition("g.", 1, expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	@Test public void testOnStringLiteral_22() throws Exception {
		newBuilder().append("''.toString+''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	@Test public void testOnStringLiteral_23() throws Exception {
		newBuilder().append("''.toString+''").assertTextAtCursorPosition("+''", 1, expect(new String[]{"+"}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_24() throws Exception {
		newBuilder().append("''.toString==''").assertTextAtCursorPosition("==", 1, expect(new String[] {"=="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_25() throws Exception {
		newBuilder().append("''.toString==''").assertTextAtCursorPosition("==", 2, expect(new String[]{"=="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_26() throws Exception {
		newBuilder().append("''.toString<=''").assertTextAtCursorPosition("<=", 1, expect(new String[]{"<", "<="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_27() throws Exception {
		newBuilder().append("''.toString<=''").assertTextAtCursorPosition("<=", 2, expect(new String[]{"<="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_28() throws Exception {
		newBuilder().append("''.toString.toString").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_29() throws Exception {
		newBuilder().append("''.toString.toString.toString").assertTextAtCursorPosition("g.", 1, expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	@Test public void testOnStringLiteral_30() throws Exception {
		newBuilder().append("('')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_31() throws Exception {
		newBuilder().append("('').").assertText(getStringFeatures());
	}
	
	@Test public void testOnStringLiteral_32() throws Exception {
		newBuilder().append("(''.toString)").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_33() throws Exception {
		newBuilder().append("(''.toString )").assertTextAtCursorPosition(")", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_34() throws Exception {
		newBuilder().append("''.toString ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}

	@Test public void testOnStringLiteral_35() throws Exception {
		newBuilder().append("''.toString .").assertTextAtCursorPosition("g .", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_36() throws Exception {
		newBuilder().append("''.toString +''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testOnStringLiteral_37() throws Exception {
		newBuilder().append("''.toString ==''").assertTextAtCursorPosition("==", 1, expect(new String[] {"=="}, getKeywordsAndStatics()));
	}
	
	@Test public void testOnStringLiteral_38() throws Exception {
		newBuilder().append("''.toString.toString").assertTextAtCursorPosition("g.", 1, expect(STRING_OPERATORS, new String[]{"toString"}));
	}
	
	@Test public void testAfterBinaryOperation_01() throws Exception {
		newBuilder().append("''+''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testAfterBinaryOperation_02() throws Exception {
		newBuilder().append("'' + ''+''").assertTextAtCursorPosition("''+", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testAfterBinaryOperation_03() throws Exception {
		newBuilder().append("(''+'')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}

	@Test public void testAfterBinaryOperation_04() throws Exception {
		newBuilder().append("(''+'').").assertText(getStringFeatures());
	}
	
	@Test public void testAfterBinaryOperation_05() throws Exception {
		newBuilder().append("((''+''))").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testAfterBinaryOperation_06() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", 1, expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}
	
	@Test public void testAfterBinaryOperation_07() throws Exception {
		newBuilder().append("((''+''))").assertTextAtCursorPosition("))", expect(STRING_OPERATORS, CAST_INSTANCEOF));
	}

	@Test public void testAfterBinaryOperation_08() throws Exception {
		newBuilder().append("((''+(''.bytes)))").assertTextAtCursorPosition(")", "==", "!=", "+=", "+", "->", "bytes");
	}
	
	@Test public void testAfterBinaryOperation_09() throws Exception {
		newBuilder().append("((''+''.bytes))").assertTextAtCursorPosition(")", "==", "!=", "+=", "+", "->", "bytes");
	}
	
	@Test public void testAfterBinaryOperation_10() throws Exception {
		newBuilder().append("((''+null))").assertTextAtCursorPosition(")", "null", "!=", "==", "->");
	}
	
	// TODO: limit to static features
	@Test public void testStaticFeatures_01() throws Exception {
		newBuilder().append("String::").assertText(getStringFeatures());
	}
	
	@Test public void testNull() throws Exception {
		newBuilder().append("null").assertText("null", "!=", "==", "->");
	}
	
	@Test public void testForLoop_01() throws Exception {
		newBuilder().append("for (String s: null) ").assertText(expect(new String[]{"s"}, getKeywordsAndStatics()));
	}
	
	@Test public void testForLoop_02() throws Exception {
		newBuilder().append("for (String string: null) string").assertTextAtCursorPosition(") string", 6, "string");
	}
	
	@Test public void testForLoop_03() throws Exception {
		newBuilder().append("for (String string: null) ''+").assertText(expect(new String[] {"string", "+"}, getKeywordsAndStatics()));
	}
	
	@Test public void testForLoop_04() throws Exception {
		newBuilder().append("for (String string: ").assertText(getKeywordsAndStatics());
	}
	
	@Test public void testForLoop_05() throws Exception {
		newBuilder().append("for (String string: )").assertTextAtCursorPosition(")", getKeywordsAndStatics());
	}
	
	@Test public void testClosure_01() throws Exception {
		newBuilder().append("[String a, String b|").assertText(expect(new String[]{"a", "b"}, getKeywordsAndStatics()));
	}
	
	@Test public void testCatchParameter_01() throws Exception {
		newBuilder().append("try {} catch(NullPointerException e) e").assertTextAtCursorPosition(") e", 2, expect(new String[]{"e"}, getKeywordsAndStatics()));
	}
	
	@Test public void testCatchParameter_02() throws Exception {
		newBuilder().append("try {} catch(NullPointerException e) ").assertText(expect(new String[]{"e"}, getKeywordsAndStatics()));
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}
	
}
