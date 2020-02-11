/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer

import com.google.inject.Binder
import com.google.inject.Inject
import com.google.inject.name.Names
import java.util.Set
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.IStubGenerating
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.eclipse.xtext.generator.adapter.Generator2AdapterSetup
import org.eclipse.xtext.generator.parser.antlr.ex.wsAware.SyntheticTerminalAwareFragmentHelper
import org.eclipse.xtext.generator.terminals.SyntheticTerminalDetector
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.serializer.impl.Serializer
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2

import static java.util.Collections.*
import org.eclipse.xtext.xtext.generator.CodeConfig

/**
 * @author Moritz Eyshold - Initial contribution and API
 */
@Deprecated
class SerializerFragment extends Xtend2GeneratorFragment implements IStubGenerating, IStubGenerating.XtendOption {
	
	@Inject SerializerGenFileNames names
	
	boolean generateDebugData = false;
	
	boolean srcGenOnly = false;
	
	/**
	 * @since 2.8
	 */
	boolean detectSyntheticTerminals = true;
	
	/**
	 * @since 2.8
	 */
	@Accessors SyntheticTerminalDetector syntheticTerminalDetector = new SyntheticTerminalDetector()
	
	@Accessors boolean generateSupportForDeprecatedContextEObject = false
	
	@Accessors boolean generateXtendStub
	
	Generator2AdapterSetup adapterSetup
	
	override protected addLocalBindings(Binder binder) {
		binder
			.bind(Boolean).annotatedWith(Names.named("generateXtendStub")).toInstance(generateXtendStub && generateStub)
	}
	
	def setGenerateDebugData(boolean doGenerate) {
		generateDebugData = doGenerate
	}
	
	def setSrcGenOnly(boolean srcGen) {
		srcGenOnly = srcGen;
	}
	
	/**
	 * @since 2.8
	 */
	def boolean isDetectSyntheticTerminals() {
		return detectSyntheticTerminals;
	}
	
	/**
	 * Set to false if synthetic terminal should be ignored. Synthetic terminals
	 * have the form {@code terminal ABC: 'synthetic:ABC';} in the grammar
	 * and require a customized {@link AbstractSplittingTokenSource token source}.
	 * 
	 * @see SyntheticTerminalAwareFragmentHelper
	 * @since 2.8
	 */
	def void setDetectSyntheticTerminals(boolean detectSyntheticTerminals) {
		this.detectSyntheticTerminals = detectSyntheticTerminals;
	}
	
	override setGenerateStub(boolean generateStub) {
		srcGenOnly = !generateStub
	}
	
	override isGenerateStub() {
		!srcGenOnly
	}
	
	override Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		val bf = new BindFactory();
		bf.addTypeToType(ISemanticSequencer.name, names.semanticSequencer.qualifiedName);
		bf.addTypeToType(ISyntacticSequencer.name, names.syntacticSequencer.qualifiedName);
		bf.addTypeToType(ISerializer.name, Serializer.name);
		return bf.bindings;
	}
	
	override generate(LanguageConfig config, XpandExecutionContext ctx) {
		adapterSetup = new Generator2AdapterSetup(config, ctx, naming)
		adapterSetup.additionalLanguageBindings = [
			bind(org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector)
				.toInstance(syntheticTerminalDetector)
		]
		super.generate(config, ctx)
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		val delegate = new SerializerFragment2
		delegate.generateStub = isGenerateStub
		delegate.detectSyntheticTerminals = detectSyntheticTerminals
		delegate.generateDebugData = generateDebugData
		delegate.generateSupportForDeprecatedContextEObject = generateSupportForDeprecatedContextEObject
		adapterSetup.injector.getInstance(CodeConfig).preferXtendStubs = isGenerateXtendStub
		delegate.initialize(adapterSetup.injector)
		delegate.generate()
	}
	
	override getExportedPackagesRtList(Grammar grammar) {
		return newArrayList(names.semanticSequencer.packageName)
	}
	
	override getRequiredBundlesRt(Grammar grammar) {
		if(generateXtendStub) 
			singletonList('org.eclipse.xtext.xbase.lib')
		else 
			null
	}
	
}