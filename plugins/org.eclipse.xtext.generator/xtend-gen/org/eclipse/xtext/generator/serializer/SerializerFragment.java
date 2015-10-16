/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.adapter.Generator2AdapterSetup;
import org.eclipse.xtext.generator.parser.antlr.ex.wsAware.SyntheticTerminalAwareFragmentHelper;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.generator.terminals.SyntheticTerminalDetector;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2;

/**
 * @author Moritz Eyshold - Initial contribution and API
 */
@SuppressWarnings("all")
public class SerializerFragment extends Xtend2GeneratorFragment implements IStubGenerating, IStubGenerating.XtendOption {
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
  @Accessors
  private SyntheticTerminalDetector syntheticTerminalDetector = new SyntheticTerminalDetector();
  
  @Accessors
  private boolean generateXtendStub;
  
  private Generator2AdapterSetup adapterSetup;
  
  @Override
  protected void addLocalBindings(final Binder binder) {
    AnnotatedBindingBuilder<Boolean> _bind = binder.<Boolean>bind(Boolean.class);
    Named _named = Names.named("generateXtendStub");
    LinkedBindingBuilder<Boolean> _annotatedWith = _bind.annotatedWith(_named);
    boolean _and = false;
    if (!this.generateXtendStub) {
      _and = false;
    } else {
      boolean _isGenerateStub = this.isGenerateStub();
      _and = _isGenerateStub;
    }
    _annotatedWith.toInstance(Boolean.valueOf(_and));
  }
  
  public boolean setGenerateDebugData(final boolean doGenerate) {
    return this.generateDebugData = doGenerate;
  }
  
  public boolean setSrcGenOnly(final boolean srcGen) {
    return this.srcGenOnly = srcGen;
  }
  
  /**
   * @since 2.8
   */
  public boolean isDetectSyntheticTerminals() {
    return this.detectSyntheticTerminals;
  }
  
  /**
   * Set to false if synthetic terminal should be ignored. Synthetic terminals
   * have the form {@code terminal ABC: 'synthetic:ABC';} in the grammar
   * and require a customized {@link AbstractSplittingTokenSource token source}.
   * 
   * @see SyntheticTerminalAwareFragmentHelper
   * @since 2.8
   */
  public void setDetectSyntheticTerminals(final boolean detectSyntheticTerminals) {
    this.detectSyntheticTerminals = detectSyntheticTerminals;
  }
  
  @Override
  public void setGenerateStub(final boolean generateStub) {
    this.srcGenOnly = (!generateStub);
  }
  
  @Override
  public boolean isGenerateStub() {
    return (!this.srcGenOnly);
  }
  
  @Override
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    final BindFactory bf = new BindFactory();
    String _name = ISemanticSequencer.class.getName();
    SerializerGenFileNames.GenFileName _semanticSequencer = this.names.getSemanticSequencer();
    String _qualifiedName = _semanticSequencer.getQualifiedName();
    bf.addTypeToType(_name, _qualifiedName);
    String _name_1 = ISyntacticSequencer.class.getName();
    SerializerGenFileNames.GenFileName _syntacticSequencer = this.names.getSyntacticSequencer();
    String _qualifiedName_1 = _syntacticSequencer.getQualifiedName();
    bf.addTypeToType(_name_1, _qualifiedName_1);
    String _name_2 = ISerializer.class.getName();
    String _name_3 = Serializer.class.getName();
    bf.addTypeToType(_name_2, _name_3);
    return bf.getBindings();
  }
  
  @Override
  public void generate(final LanguageConfig config, final XpandExecutionContext ctx) {
    Naming _naming = this.getNaming();
    Generator2AdapterSetup _generator2AdapterSetup = new Generator2AdapterSetup(config, ctx, _naming);
    this.adapterSetup = _generator2AdapterSetup;
    super.generate(config, ctx);
  }
  
  @Override
  public void generate(final Xtend2ExecutionContext ctx) {
    final SerializerFragment2 delegate = new SerializerFragment2();
    boolean _isGenerateStub = this.isGenerateStub();
    delegate.setGenerateStub(_isGenerateStub);
    delegate.setDetectSyntheticTerminals(this.detectSyntheticTerminals);
    delegate.setSyntheticTerminalDetector(this.syntheticTerminalDetector);
    delegate.setGenerateDebugData(this.generateDebugData);
    Injector _injector = this.adapterSetup.getInjector();
    delegate.initialize(_injector);
    delegate.generate();
  }
  
  @Override
  public List<String> getExportedPackagesRtList(final Grammar grammar) {
    SerializerGenFileNames.GenFileName _semanticSequencer = this.names.getSemanticSequencer();
    String _packageName = _semanticSequencer.getPackageName();
    return CollectionLiterals.<String>newArrayList(_packageName);
  }
  
  @Override
  public String[] getRequiredBundlesRt(final Grammar grammar) {
    List<String> _xifexpression = null;
    if (this.generateXtendStub) {
      _xifexpression = Collections.<String>singletonList("org.eclipse.xtext.xbase.lib");
    } else {
      _xifexpression = null;
    }
    return ((String[])Conversions.unwrapArray(_xifexpression, String.class));
  }
  
  @Pure
  public SyntheticTerminalDetector getSyntheticTerminalDetector() {
    return this.syntheticTerminalDetector;
  }
  
  public void setSyntheticTerminalDetector(final SyntheticTerminalDetector syntheticTerminalDetector) {
    this.syntheticTerminalDetector = syntheticTerminalDetector;
  }
  
  @Pure
  public boolean isGenerateXtendStub() {
    return this.generateXtendStub;
  }
  
  public void setGenerateXtendStub(final boolean generateXtendStub) {
    this.generateXtendStub = generateXtendStub;
  }
}
