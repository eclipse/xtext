/**
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.PartialClassExtractor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class PartialClassExtractorTest {
	@Test
	public void testEnumRules() {
		String original =
				"import org.eclipse.xtext.*;\n" +
				"import org.eclipse.xtext.parser.*;\n" +
				"import org.eclipse.xtext.parser.impl.*;\n" +
				"import org.eclipse.xtext.IGrammarAccess;\n" +
				"import org.eclipse.emf.common.util.Enumerator;\n" +
				"import org.eclipse.emf.ecore.util.EcoreUtil;\n" +
				"import org.eclipse.emf.ecore.EObject;\n" +
				"import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;\n" +
				"import org.eclipse.xtext.parser.antlr.XtextTokenStream;\n" +
				"import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;\n" +
				"import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;\n" +
				"import org.antlr.runtime.*;\n" +
				"import java.util.Stack;\n" +
				"import java.util.List;\n" +
				"import java.util.ArrayList;\n" +
				"\n" +
				"public class InternalMyDslParser extends AbstractInternalAntlrParser {\n" +
				"    public static final String[] tokenNames = new String[] {\n" +
				"        \"<invalid>\", \"<EOR>\", \"<DOWN>\", \"<UP>\", \"RULE_ID\", \"RULE_INT\", \"RULE_STRING\", \"RULE_ML_COMMENT\", \"RULE_SL_COMMENT\", \"RULE_WS\", \"RULE_ANY_OTHER\", \"'Hello'\", \"'!'\"\n" +
				"    };\n" +
				"    // delegates\n" +
				"    // delegators\n" +
				"    \n" +
				"    public InternalMyDslParser(TokenStream input) {\n" +
				"        this(input, new RecognizerSharedState());\n" +
				"    }\n" +
				"    public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {\n" +
				"        super(input, state);\n" +
				"         \n" +
				"    }\n" +
				"    @Override\n" +
				"    protected String getFirstRuleName() {\n" +
				"        return \"Model\";\n" +
				"    }\n" +
				"    @Override\n" +
				"    protected IGrammarAccess getGrammarAccess() {\n" +
				"        return null;\n" +
				"    }\n" +
				"    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }\n" +
				"    // $ANTLR start \"ruleMySuperDuperObject\"\n" +
				"    public final EObject ruleMySuperDuperObject() throws RecognitionException {\n" +
				"        ruleMySuperDuperEnum();\n" +
				"        return null;\n" +
				"    }\n" +
				"    // $ANTLR end \"ruleMySuperDuperObject\"\n" +
				"    \n" +
				"    // $ANTLR start \"ruleMySuperDuperEnum\"\n" +
				"    public final Enumerator ruleMySuperDuperEnum() throws RecognitionException {\n" +
				"        return null;\n" +
				"    }\n" +
				"    // $ANTLR end \"ruleMySuperDuperEnum\"\n" +
				"    \n" +
				"    // $ANTLR start \"ruleSuperDuperFragment\"\n" +
				"    // InternalMyDsl.g:17296:1: ruleSuperDuperFragment[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '{' ( ( (lv_parameters_1_0= ruleCallParameter ) ) otherlv_2= ';' )* otherlv_3= '}' ) ;\n" +
				"    public final EObject ruleSuperDuperFragment(EObject in_current) throws RecognitionException {\n" +
				"        return null;\n" +
				"    }\n" +
				"    // $ANTLR end \"ruleSuperDuperFragment\"\n" +
				"    // Delegated rules\n" +
				"}\n";
		String splitted =
				"import org.eclipse.xtext.*;\n" +
				"import org.eclipse.xtext.parser.*;\n" +
				"import org.eclipse.xtext.parser.impl.*;\n" +
				"import org.eclipse.xtext.IGrammarAccess;\n" +
				"import org.eclipse.emf.common.util.Enumerator;\n" +
				"import org.eclipse.emf.ecore.util.EcoreUtil;\n" +
				"import org.eclipse.emf.ecore.EObject;\n" +
				"import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;\n" +
				"import org.eclipse.xtext.parser.antlr.XtextTokenStream;\n" +
				"import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;\n" +
				"import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;\n" +
				"import org.antlr.runtime.*;\n" +
				"import java.util.Stack;\n" +
				"import java.util.List;\n" +
				"import java.util.ArrayList;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"interface InternalMyDslParserSignatures {\n" +
				"     EObject ruleMySuperDuperObject() throws RecognitionException;\n" +
				"     Enumerator ruleMySuperDuperEnum() throws RecognitionException;\n" +
				"     EObject ruleSuperDuperFragment(EObject in_current) throws RecognitionException;\n" +
				"}\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"abstract class InternalMyDslParser1 extends AbstractInternalAntlrParser implements InternalMyDslParserSignatures {\n" +
				"\n" +
				"        InternalMyDslParser1(TokenStream input) {\n" +
				"            this(input, new RecognizerSharedState());\n" +
				"        }\n" +
				"\n" +
				"        InternalMyDslParser1(TokenStream input, RecognizerSharedState state) {\n" +
				"            super(input, state);\n" +
				"        }\n" +
				"\n" +
				"    public static final String[] tokenNames = new String[] {\n" +
				"        \"<invalid>\", \"<EOR>\", \"<DOWN>\", \"<UP>\", \"RULE_ID\", \"RULE_INT\", \"RULE_STRING\", \"RULE_ML_COMMENT\", \"RULE_SL_COMMENT\", \"RULE_WS\", \"RULE_ANY_OTHER\", \"'Hello'\", \"'!'\"\n" +
				"    };\n" +
				"\n" +
				"    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }\n" +
				"\n" +
				"    // Delegated rules\n" +
				"}\n" +
				"\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"abstract class InternalMyDslParser2 extends InternalMyDslParser1 {\n" +
				"\n" +
				"        InternalMyDslParser2(TokenStream input) {\n" +
				"            this(input, new RecognizerSharedState());\n" +
				"        }\n" +
				"\n" +
				"        InternalMyDslParser2(TokenStream input, RecognizerSharedState state) {\n" +
				"            super(input, state);\n" +
				"        }\n" +
				"\n" +
				"    // $ANTLR start \"ruleMySuperDuperObject\"\n" +
				"    public final EObject ruleMySuperDuperObject() throws RecognitionException {\n" +
				"        ruleMySuperDuperEnum();\n" +
				"        return null;\n" +
				"    }\n" +
				"    // $ANTLR end \"ruleMySuperDuperObject\"\n" +
				"\n" +
				"}\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"abstract class InternalMyDslParser3 extends InternalMyDslParser2 {\n" +
				"\n" +
				"        InternalMyDslParser3(TokenStream input) {\n" +
				"            this(input, new RecognizerSharedState());\n" +
				"        }\n" +
				"\n" +
				"        InternalMyDslParser3(TokenStream input, RecognizerSharedState state) {\n" +
				"            super(input, state);\n" +
				"        }\n" +
				"\n" +
				"    // $ANTLR start \"ruleMySuperDuperEnum\"\n" +
				"    public final Enumerator ruleMySuperDuperEnum() throws RecognitionException {\n" +
				"        return null;\n" +
				"    }\n" +
				"    // $ANTLR end \"ruleMySuperDuperEnum\"\n" +
				"\n" +
				"}\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"abstract class InternalMyDslParser4 extends InternalMyDslParser3 {\n" +
				"\n" +
				"        InternalMyDslParser4(TokenStream input) {\n" +
				"            this(input, new RecognizerSharedState());\n" +
				"        }\n" +
				"\n" +
				"        InternalMyDslParser4(TokenStream input, RecognizerSharedState state) {\n" +
				"            super(input, state);\n" +
				"        }\n" +
				"\n" +
				"    // $ANTLR start \"ruleSuperDuperFragment\"\n" +
				"    // InternalMyDsl.g:17296:1: ruleSuperDuperFragment[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '{' ( ( (lv_parameters_1_0= ruleCallParameter ) ) otherlv_2= ';' )* otherlv_3= '}' ) ;\n" +
				"    public final EObject ruleSuperDuperFragment(EObject in_current) throws RecognitionException {\n" +
				"        return null;\n" +
				"    }\n" +
				"    // $ANTLR end \"ruleSuperDuperFragment\"\n" +
				"\n" +
				"}\n" +
				"\n" +
				"public class InternalMyDslParser extends InternalMyDslParser4 {\n" +
				"\n" +
				"    \n" +
				"    public InternalMyDslParser(TokenStream input) {\n" +
				"        this(input, new RecognizerSharedState());\n" +
				"    }\n" +
				"    public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {\n" +
				"        super(input, state);\n" +
				"         \n" +
				"    }\n" +
				"    @Override\n" +
				"    protected String getFirstRuleName() {\n" +
				"        return \"Model\";\n" +
				"    }\n" +
				"    @Override\n" +
				"    protected IGrammarAccess getGrammarAccess() {\n" +
				"        return null;\n" +
				"    }\n" +
				"\n" +
				"}\n";
		assertSplitsTo(1, original, splitted);
	}

	protected void assertSplitsTo(int methodsPerClass, String from, String to) {
		Assert.assertEquals(Strings.toPlatformLineSeparator(to), new PartialClassExtractor(Strings.toPlatformLineSeparator(from), methodsPerClass).transform());
	}
}
