/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.xtext.generator.index.ResourceDescriptionStrategyFragment
import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
class ResourceDescriptionStrategyFragmentTests extends AbstractGeneratorFragmentTests {

	static class TestableResourceDescriptionStrategyFragment extends ResourceDescriptionStrategyFragment {

		override protected getAbstractResourceDescriptionStrategyClass() {
			super.getAbstractResourceDescriptionStrategyClass()
		}
		
		override protected getDefaultResourceDescriptionStrategyClass() {
			super.getDefaultResourceDescriptionStrategyClass()
		}

		override getExportedRulesFromGrammar() {
			super.getExportedRulesFromGrammar()
		}

		override protected shouldGenerateArtefacts(Iterable<AbstractRule> exportedRules) {
			super.shouldGenerateArtefacts(exportedRules)
		}
		
		override protected generateResourceDescriptionStrategy(Iterable<AbstractRule> exportedRules) {
			super.generateResourceDescriptionStrategy(exportedRules)
		}
		
		override protected getSuperTypeRef() {
			super.getSuperTypeRef()
		}
		
	}
	
	@Test
	def testGenerateNothing() {
		val fragment = initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment,'''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			Rule: name=ID;
		''')
		val exportedRules = fragment.getExportedRulesFromGrammar
		assertTrue(exportedRules.empty)
		assertFalse(fragment.shouldGenerateArtefacts(exportedRules))
	}

	@Test
	def testGenerateNothing_1() {
		val fragment = initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment,'''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Exported
			Rule: name=ID;
		''')
		fragment.generate = false
		val exportedRules = fragment.getExportedRulesFromGrammar
		assertFalse(exportedRules.empty)
		assertFalse(fragment.shouldGenerateArtefacts(exportedRules))
	}

	@Test
	def testGenerate() {
		val fragment = initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Exported
			Rule: name=ID;
			@Exported
			Foo returns Rule: name=ID;
		''')

		val exportedRules = fragment.getExportedRulesFromGrammar
		assertFalse(exportedRules.empty)
		assertEquals(1, exportedRules.size)
		assertTrue(fragment.shouldGenerateArtefacts(exportedRules))
		assertEquals('''
			package org.xtext.resource;
			
			import org.eclipse.emf.ecore.EObject;
			import org.eclipse.xtext.resource.IEObjectDescription;
			import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
			import org.eclipse.xtext.util.IAcceptor;
			import org.xtext.foo.Rule;
			
			public class FooAbstractResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
				public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
					if(eObject instanceof Rule) {
						return createEObjectDescriptionsForRule(eObject, acceptor);
					}
					return true;
				}
			
				protected boolean createEObjectDescriptionsForRule(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
					return super.createEObjectDescriptions(eObject, acceptor);
				}
			}
		'''.toString, concatenationClientToString(fragment.generateResourceDescriptionStrategy(exportedRules)))
	}

	@Test
	def testGenerate_NoStubs() {
		val fragment = initializeFragmentWithGrammarFromString(TestableResourceDescriptionStrategyFragment, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Exported
			Rule: name=ID;
			@Exported
			Foo returns Rule: name=ID;
		''')
		fragment.generateStub = false
		fragment.generateXtendStub = false
		val exportedRules = fragment.getExportedRulesFromGrammar
		assertFalse(exportedRules.empty)
		assertEquals(1, exportedRules.size)
		assertTrue(fragment.shouldGenerateArtefacts(exportedRules))
		assertEquals('''
			package org.xtext.resource;
			
			import org.eclipse.emf.ecore.EObject;
			import org.eclipse.xtext.resource.IEObjectDescription;
			import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
			import org.eclipse.xtext.util.IAcceptor;
			import org.xtext.foo.Rule;
			
			public class FooDefaultResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
				public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
					if(eObject instanceof Rule) {
						return createEObjectDescriptionsForRule(eObject, acceptor);
					}
					return true;
				}
			
				protected boolean createEObjectDescriptionsForRule(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
					return super.createEObjectDescriptions(eObject, acceptor);
				}
			}
		'''.toString, concatenationClientToString(fragment.generateResourceDescriptionStrategy(exportedRules)))
	}

}
