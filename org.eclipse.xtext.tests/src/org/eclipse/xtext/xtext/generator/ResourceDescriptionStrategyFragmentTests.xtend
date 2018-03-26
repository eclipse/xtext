/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.xtext.generator.index.ResourceDescriptionStrategyFragment
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.junit.Test
import org.junit.Ignore

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
class ResourceDescriptionStrategyFragmentTests extends AbstractGeneratorFragmentTests {

	static class TestableResourceDescriptionStrategyFragment extends ResourceDescriptionStrategyFragment {

		override getExportedRulesFromGrammar() {
			super.getExportedRulesFromGrammar()
		}

		override protected shouldGenerateArtefacts(Iterable<AbstractRule> exportedRules) {
			super.shouldGenerateArtefacts(exportedRules)
		}
		
		override protected generateResourceDescriptionStrategyContent(TypeReference superTypeRef, Iterable<AbstractRule> exportedRules) {
			super.generateResourceDescriptionStrategyContent(superTypeRef, exportedRules)
		}
		
		override protected getSuperTypeRef() {
			super.getSuperTypeRef()
		}
		
	}
	@Ignore
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
	@Ignore
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
	@Ignore
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
		val result = fragment.generateResourceDescriptionStrategyContent(fragment.superTypeRef, exportedRules)
		assertEquals('''
			public class FooAbstractResourceDescriptionStrategy extends org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy {
				public boolean createEObjectDescriptions(interface org.eclipse.emf.ecore.EObject eObject, interface org.eclipse.xtext.util.IAcceptor<interface org.eclipse.xtext.resource.IEObjectDescription> acceptor) {
					if(eObject instanceof org.xtext.foo.Rule) {
						return createEObjectDescriptionsForRule(eObject, acceptor);
					}
					return true;
				}
			
				protected boolean createEObjectDescriptionsForRule(interface org.eclipse.emf.ecore.EObject eObject, interface org.eclipse.xtext.util.IAcceptor<interface org.eclipse.xtext.resource.IEObjectDescription> acceptor) {
					return super.createEObjectDescriptions(eObject, acceptor);
				}
			}
		'''.toString, result.concatenationClientToString)
	}
	@Ignore
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
		val result = fragment.generateResourceDescriptionStrategyContent(fragment.superTypeRef, exportedRules)
		assertEquals('''
			public class FooDefaultResourceDescriptionStrategy extends org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy {
				public boolean createEObjectDescriptions(interface org.eclipse.emf.ecore.EObject eObject, interface org.eclipse.xtext.util.IAcceptor<interface org.eclipse.xtext.resource.IEObjectDescription> acceptor) {
					if(eObject instanceof org.xtext.foo.Rule) {
						return createEObjectDescriptionsForRule(eObject, acceptor);
					}
					return true;
				}
			
				protected boolean createEObjectDescriptionsForRule(interface org.eclipse.emf.ecore.EObject eObject, interface org.eclipse.xtext.util.IAcceptor<interface org.eclipse.xtext.resource.IEObjectDescription> acceptor) {
					return super.createEObjectDescriptions(eObject, acceptor);
				}
			}
		'''.toString, result.concatenationClientToString)
	}

}
