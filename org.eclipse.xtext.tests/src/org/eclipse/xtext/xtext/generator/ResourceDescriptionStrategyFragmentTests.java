/**
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.List;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.index.ResourceDescriptionStrategyFragment;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
public class ResourceDescriptionStrategyFragmentTests extends AbstractGeneratorFragmentTests {
	public static class TestableResourceDescriptionStrategyFragment extends ResourceDescriptionStrategyFragment {
		@Override
		protected TypeReference getAbstractResourceDescriptionStrategyClass() {
			return super.getAbstractResourceDescriptionStrategyClass();
		}

		@Override
		protected TypeReference getDefaultResourceDescriptionStrategyClass() {
			return super.getDefaultResourceDescriptionStrategyClass();
		}

		@Override
		public List<AbstractRule> getExportedRulesFromGrammar() {
			return super.getExportedRulesFromGrammar();
		}

		@Override
		protected boolean shouldGenerateArtefacts(Iterable<AbstractRule> exportedRules) {
			return super.shouldGenerateArtefacts(exportedRules);
		}

		@Override
		protected JavaFileAccess generateResourceDescriptionStrategy(Iterable<AbstractRule> exportedRules) {
			return super.generateResourceDescriptionStrategy(exportedRules);
		}

		@Override
		protected TypeReference getSuperTypeRef() {
			return super.getSuperTypeRef();
		}
	}

	@Test
	public void testGenerateNothing() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"Rule: name=ID;\n";
		TestableResourceDescriptionStrategyFragment fragment = this
				.initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment.class, grammar);
		List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
		Assert.assertTrue(exportedRules.isEmpty());
		Assert.assertFalse(fragment.shouldGenerateArtefacts(exportedRules));
	}

	@Test
	public void testGenerateNothing_1() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Exported\n" +
				"Rule: name=ID;\n";
		TestableResourceDescriptionStrategyFragment fragment = this
				.initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment.class, grammar);
		fragment.setGenerate(false);
		List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
		Assert.assertFalse(exportedRules.isEmpty());
		Assert.assertFalse(fragment.shouldGenerateArtefacts(exportedRules));
	}

	@Test
	public void testGenerate() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Exported\n" +
				"Rule: name=ID;\n" +
				"@Exported\n" +
				"Foo returns Rule: name=ID;\n";
		TestableResourceDescriptionStrategyFragment fragment = this
				.initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment.class, grammar);
		List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
		Assert.assertFalse(exportedRules.isEmpty());
		Assert.assertEquals(1, exportedRules.size());
		Assert.assertTrue(fragment.shouldGenerateArtefacts(exportedRules));
		String expectation =
				"package org.xtext.resource;\n" +
				"\n" +
				"import org.eclipse.emf.ecore.EObject;\n" +
				"import org.eclipse.xtext.resource.IEObjectDescription;\n" +
				"import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;\n" +
				"import org.eclipse.xtext.util.IAcceptor;\n" +
				"import org.xtext.foo.Rule;\n" +
				"\n" +
				"public class FooAbstractResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {\n" +
				"	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {\n" +
				"		if(eObject instanceof Rule) {\n" +
				"			return createEObjectDescriptionsForRule(eObject, acceptor);\n" +
				"		}\n" +
				"		return true;\n" +
				"	}\n" +
				"\n" +
				"	protected boolean createEObjectDescriptionsForRule(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {\n" +
				"		return super.createEObjectDescriptions(eObject, acceptor);\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateResourceDescriptionStrategy(exportedRules)));
	}

	@Test
	public void testGenerate_NoStubs() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Exported\n" +
				"Rule: name=ID;\n" +
				"@Exported\n" +
				"Foo returns Rule: name=ID;\n";
		TestableResourceDescriptionStrategyFragment fragment = this
				.initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment.class, grammar);
		fragment.setGenerateStub(false);
		fragment.setGenerateXtendStub(false);
		List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
		Assert.assertFalse(exportedRules.isEmpty());
		Assert.assertEquals(1, exportedRules.size());
		Assert.assertTrue(fragment.shouldGenerateArtefacts(exportedRules));
		String expectation =
				"package org.xtext.resource;\n" +
				"\n" +
				"import org.eclipse.emf.ecore.EObject;\n" +
				"import org.eclipse.xtext.resource.IEObjectDescription;\n" +
				"import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;\n" +
				"import org.eclipse.xtext.util.IAcceptor;\n" +
				"import org.xtext.foo.Rule;\n" +
				"\n" +
				"public class FooDefaultResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {\n" +
				"	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {\n" +
				"		if(eObject instanceof Rule) {\n" +
				"			return createEObjectDescriptionsForRule(eObject, acceptor);\n" +
				"		}\n" +
				"		return true;\n" +
				"	}\n" +
				"\n" +
				"	protected boolean createEObjectDescriptionsForRule(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {\n" +
				"		return super.createEObjectDescriptions(eObject, acceptor);\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateResourceDescriptionStrategy(exportedRules)));
	}
}
