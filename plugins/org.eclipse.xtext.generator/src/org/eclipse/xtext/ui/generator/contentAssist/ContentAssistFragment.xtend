/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.contentAssist

import javax.inject.Inject
import javax.inject.Named
import org.eclipse.xpand2.XpandFacade
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IInheriting
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

import static java.util.Collections.*
import static org.eclipse.xtext.GrammarUtil.*
import org.eclipse.xtext.generator.IStubGenerating

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
class ContentAssistFragment extends Xtend2GeneratorFragment implements IInheriting, IStubGenerating {
	
	@Inject extension Naming

	@Inject Grammar grammar

	@Property boolean inheritImplementation

	@Property boolean generateStub = true;
	
	@Inject@Named("fileHeader") String fileHeader
	
	def String getProposalProviderName() {
		return grammar.basePackageUi + ".contentassist." + getName(grammar) + "ProposalProvider"
	}
	
	def String getGenProposalProviderName() {
		return grammar.basePackageUi + ".contentassist.Abstract" + getName(grammar) + "ProposalProvider"
	}
	
	override getGuiceBindingsUi(Grammar grammar) {
		val bindFactory = new BindFactory()
		if(generateStub)
			bindFactory
				.addTypeToType('org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider',
						proposalProviderName)
		else 
			bindFactory
				.addTypeToType('org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider',
						genProposalProviderName)
		bindFactory.bindings
	}
	
	override getRequiredBundlesUi(Grammar grammar) {
		singletonList('org.eclipse.xtext.ui')
	}
	
	override getImportedPackagesUi(Grammar grammar) {
		if(generateStub)
			newArrayList('org.apache.log4j', 'org.eclipse.xtext.xbase.lib')
		else
			singleton('org.apache.log4j')
	}
	
	override getExportedPackagesUi(Grammar grammar) {
		singletonList(proposalProviderName.packageName)
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		if(generateStub) {
			ctx.writeFile(Generator::SRC_UI, proposalProviderName.asPath + '.xtend', '''
				/*
				 «fileHeader»
				 */
				package «proposalProviderName.packageName»
				
				import «genProposalProviderName»
				
				/**
				 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
				 */
				class «proposalProviderName.toSimpleName» extends «genProposalProviderName.toSimpleName» {
				}
			''')
		}
		XpandFacade::create(ctx.xpandExecutionContext).evaluate2(
			"org::eclipse::xtext::ui::generator::contentAssist::JavaBasedContentAssistFragment::GenProposalProvider", 
			grammar, 
			<Object>singletonList(inheritImplementation)
		);
	}
	
}