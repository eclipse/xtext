/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.serializer;

import java.util.List;
import java.util.Set;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.adapter.Generator2AdapterSetup;
import org.eclipse.xtext.generator.parser.antlr.ex.wsAware.SyntheticTerminalAwareFragmentHelper;
import org.eclipse.xtext.generator.terminals.SyntheticTerminalDetector;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2;

import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.name.Names;

/**
 * @author Moritz Eyshold - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class SerializerFragment extends Xtend2GeneratorFragment
		implements IStubGenerating, IStubGenerating.XtendOption {
	@Inject
	private SerializerGenFileNames names;

	private boolean generateDebugData = false;

	private boolean srcGenOnly = false;

	/**
	 * @since 2.8
	 */
	private boolean detectSyntheticTerminals = true;

	/**
	 * @since 2.8
	 */
	private SyntheticTerminalDetector syntheticTerminalDetector = new SyntheticTerminalDetector();

	private boolean generateSupportForDeprecatedContextEObject = false;

	private boolean generateXtendStub;

	private Generator2AdapterSetup adapterSetup;

	@Override
	protected void addLocalBindings(Binder binder) {
		binder.bind(Boolean.class).annotatedWith(Names.named("generateXtendStub"))
				.toInstance(generateXtendStub && isGenerateStub());
	}

	public boolean setGenerateDebugData(boolean doGenerate) {
		return generateDebugData = doGenerate;
	}

	public boolean setSrcGenOnly(boolean srcGen) {
		return srcGenOnly = srcGen;
	}

	/**
	 * @since 2.8
	 */
	public boolean isDetectSyntheticTerminals() {
		return detectSyntheticTerminals;
	}

	/**
	 * Set to false if synthetic terminal should be ignored. Synthetic terminals
	 * have the form {@code terminal ABC: 'synthetic:ABC';} in the grammar and
	 * require a customized {@link AbstractSplittingTokenSource token source}.
	 * 
	 * @see SyntheticTerminalAwareFragmentHelper
	 * @since 2.8
	 */
	public void setDetectSyntheticTerminals(boolean detectSyntheticTerminals) {
		this.detectSyntheticTerminals = detectSyntheticTerminals;
	}

	@Override
	public void setGenerateStub(boolean generateStub) {
		srcGenOnly = !generateStub;
	}

	@Override
	public boolean isGenerateStub() {
		return !srcGenOnly;
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		BindFactory bf = new BindFactory();
		bf.addTypeToType(ISemanticSequencer.class.getName(), names.getSemanticSequencer().getQualifiedName());
		bf.addTypeToType(ISyntacticSequencer.class.getName(), names.getSyntacticSequencer().getQualifiedName());
		bf.addTypeToType(ISerializer.class.getName(), Serializer.class.getName());
		return bf.getBindings();
	}

	@Override
	public void generate(LanguageConfig config, XpandExecutionContext ctx) {
		adapterSetup = new Generator2AdapterSetup(config, ctx, getNaming());
		com.google.inject.Module module = new com.google.inject.Module() {

			@Override
			public void configure(Binder binder) {
				binder.bind(org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector.class)
						.toInstance(syntheticTerminalDetector);
			}

		};
		adapterSetup.setAdditionalLanguageBindings(module);
		super.generate(config, ctx);
	}

	@Override
	public void generate(Xtend2ExecutionContext ctx) {
		SerializerFragment2 delegate = new SerializerFragment2();
		delegate.setGenerateStub(isGenerateStub());
		delegate.setDetectSyntheticTerminals(detectSyntheticTerminals);
		delegate.setGenerateDebugData(generateDebugData);
		delegate.setGenerateSupportForDeprecatedContextEObject(generateSupportForDeprecatedContextEObject);
		adapterSetup.getInjector().getInstance(CodeConfig.class).setPreferXtendStubs(isGenerateXtendStub());
		delegate.initialize(adapterSetup.getInjector());
		delegate.generate();
	}

	@Override
	public List<String> getExportedPackagesRtList(Grammar grammar) {
		return Lists.newArrayList(names.getSemanticSequencer().getPackageName());
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		if (generateXtendStub) {
			return new String[] { "org.eclipse.xtext.xbase.lib" };
		} else {
			return null;
		}
	}

	public SyntheticTerminalDetector getSyntheticTerminalDetector() {
		return syntheticTerminalDetector;
	}

	public void setSyntheticTerminalDetector(SyntheticTerminalDetector syntheticTerminalDetector) {
		this.syntheticTerminalDetector = syntheticTerminalDetector;
	}

	public boolean isGenerateSupportForDeprecatedContextEObject() {
		return generateSupportForDeprecatedContextEObject;
	}

	public void setGenerateSupportForDeprecatedContextEObject(boolean generateSupportForDeprecatedContextEObject) {
		this.generateSupportForDeprecatedContextEObject = generateSupportForDeprecatedContextEObject;
	}

	public boolean isGenerateXtendStub() {
		return generateXtendStub;
	}

	public void setGenerateXtendStub(boolean generateXtendStub) {
		this.generateXtendStub = generateXtendStub;
	}
}
