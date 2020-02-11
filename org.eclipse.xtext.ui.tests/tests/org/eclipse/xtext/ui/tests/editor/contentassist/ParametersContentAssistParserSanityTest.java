/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.TwoParametersTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalTwoParametersTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.TwoParametersTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.editor.contentassist.tests.TwoParametersTestLanguageInjectorProvider;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xtext.FlattenedGrammarAccess;
import org.eclipse.xtext.xtext.RuleFilter;
import org.eclipse.xtext.xtext.RuleNames;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Parameterized.class)
public class ParametersContentAssistParserSanityTest {
	/**
	 * The name of the method that need to be present in the InternalN4JSParser class.
	 */
	@Parameter(0)
	public String methodName;

	/**
	 * All rules that are supposed to be present in the generated parser class
	 */
	@Parameter(1)
	public Set<String> flattenedRuleNames;

	private static class DummyParser extends TwoParametersTestLanguageParser {
		@Override
		protected String getRuleName(AbstractElement element) {
			return super.getRuleName(element);
		}
	}

	/**
	 * Returns test data.
	 */
	@Parameters(name = "{0}")
	public static Collection<Object[]> methodNames() {
		try {
			TwoParametersTestLanguageInjectorProvider injectorProvider = new TwoParametersTestLanguageInjectorProvider();
			try {
				injectorProvider.setupRegistry();
				Injector injector = injectorProvider.getInjector();
				DummyParser dummyParser = new DummyParser();
				TwoParametersTestLanguageGrammarAccess grammarAccess = injector.getInstance(TwoParametersTestLanguageGrammarAccess.class);
				RuleNames ruleNames = RuleNames.getRuleNames(grammarAccess.getGrammar(), false);
				RuleFilter ruleFilter = new RuleFilter();
				ruleFilter.setDiscardUnreachableRules(true);
				FlattenedGrammarAccess flattened = new FlattenedGrammarAccess(ruleNames, ruleFilter);
				Grammar flattenedGrammar = flattened.getFlattenedGrammar();
				dummyParser.setGrammarAccess(grammarAccess);
				dummyParser.setNameMappings(new TwoParametersTestLanguageParser.NameMappings(grammarAccess));
				dummyParser.getRuleName(null);
				Map<AbstractElement, String> nameMappings = new ReflectExtensions().get(dummyParser.getNameMappings(), "mappings");
				List<String> methodNames = Lists.newArrayList(nameMappings.values());
				Collections.sort(methodNames);
				Set<String> flattenedRuleNames = Sets.newHashSet(Lists.transform(flattenedGrammar.getRules(), r -> r.getName()));
				return Lists.transform(methodNames, (s) -> new Object[] { s, flattenedRuleNames });
			} finally {
				injectorProvider.restoreRegistry();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Tests if the method is actually present in the parser.
	 */
	@Test
	public void testMethodExists() throws Exception {
		Class<?> type = InternalTwoParametersTestLanguageParser.class;
		try {
			Method method = type.getDeclaredMethod(methodName);
			// will throw if missing but just to make it more obvious
			Assert.assertNotNull("method is not null", method);
		} catch (NoSuchMethodException e) {
			String withoutPrefix = methodName.substring("rule__".length());
			String withoutSuffix = withoutPrefix.substring(0, withoutPrefix.indexOf('_'));
			String flattenedRuleName = "rule" + withoutSuffix;
			switch (flattenedRuleName) {
				case "ruleIdOrKeyword":
					Assert.assertTrue("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.containsAll(Arrays.asList("norm1_IdOrKeyword")));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm2_IdOrKeyword"));
					break;
				case "ruleIdOrKeyword2":
					Assert.assertTrue("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.containsAll(Arrays.asList("norm2_IdOrKeyword2", "norm7_IdOrKeyword2")));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm1_IdOrKeyword2"));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm3_IdOrKeyword2"));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm4_IdOrKeyword2"));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm5_IdOrKeyword2"));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm6_IdOrKeyword2"));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm8_IdOrKeyword2"));
					break;
				case "ruleScenario6":
					Assert.assertTrue("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.containsAll(Arrays.asList("norm3_Scenario6")));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm1_Scenario6"));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm2_Scenario6"));
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains("norm4_Scenario6"));
					break;
				default:
					Assert.assertFalse("methodName " + methodName + " points to a never called rule",
							flattenedRuleNames.contains(flattenedRuleName));
				}
		}
	}
}
