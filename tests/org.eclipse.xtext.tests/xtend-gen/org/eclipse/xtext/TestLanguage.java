/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorComparisonFragment;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2;
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.XtextAntlrIDEAGeneratorFragment;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.resourceFactory.ResourceFactoryFragment2;
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2;

/**
 * @author efftinge - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class TestLanguage extends XtextGeneratorLanguage {
  private GrammarAccessFragment2 grammarAccess = new GrammarAccessFragment2();
  
  private SerializerFragment2 serializer = ObjectExtensions.<SerializerFragment2>operator_doubleArrow(new SerializerFragment2(), new Procedure1<SerializerFragment2>() {
    @Override
    public void apply(final SerializerFragment2 it) {
      it.setGenerateStub(true);
    }
  });
  
  private ResourceFactoryFragment2 resourceFactoryFragment = new ResourceFactoryFragment2();
  
  private EMFGeneratorFragment2 emfGenerator = new EMFGeneratorFragment2();
  
  private XtextAntlrGeneratorFragment2 parserGenerator = ObjectExtensions.<XtextAntlrGeneratorFragment2>operator_doubleArrow(new XtextAntlrGeneratorFragment2(), new Procedure1<XtextAntlrGeneratorFragment2>() {
    @Override
    public void apply(final XtextAntlrGeneratorFragment2 it) {
      it.setDebugGrammar(true);
      AntlrOptions _options = it.getOptions();
      final Procedure1<AntlrOptions> _function = new Procedure1<AntlrOptions>() {
        @Override
        public void apply(final AntlrOptions it) {
          it.setClassSplitting(true);
        }
      };
      ObjectExtensions.<AntlrOptions>operator_doubleArrow(_options, _function);
    }
  });
  
  private XtextAntlrIDEAGeneratorFragment ideaParser = new XtextAntlrIDEAGeneratorFragment();
  
  private IdeaPluginGenerator ideaPlugin = new IdeaPluginGenerator();
  
  @Override
  protected List<? extends IXtextGeneratorFragment> getImplicitFragments() {
    List<? extends IXtextGeneratorFragment> _implicitFragments = super.getImplicitFragments();
    final ArrayList<IXtextGeneratorFragment> result = new ArrayList<IXtextGeneratorFragment>(_implicitFragments);
    result.add(this.parserGenerator);
    final XtextAntlrGeneratorComparisonFragment comparison = new XtextAntlrGeneratorComparisonFragment();
    org.eclipse.xtext.generator.parser.antlr.AntlrOptions _antlrOptions = new org.eclipse.xtext.generator.parser.antlr.AntlrOptions();
    final Procedure1<org.eclipse.xtext.generator.parser.antlr.AntlrOptions> _function = new Procedure1<org.eclipse.xtext.generator.parser.antlr.AntlrOptions>() {
      @Override
      public void apply(final org.eclipse.xtext.generator.parser.antlr.AntlrOptions it) {
        AntlrOptions _options = TestLanguage.this.parserGenerator.getOptions();
        boolean _isBacktrack = _options.isBacktrack();
        it.setBacktrack(_isBacktrack);
        AntlrOptions _options_1 = TestLanguage.this.parserGenerator.getOptions();
        boolean _isBacktrackLexer = _options_1.isBacktrackLexer();
        it.setBacktrackLexer(_isBacktrackLexer);
        AntlrOptions _options_2 = TestLanguage.this.parserGenerator.getOptions();
        boolean _isClassSplitting = _options_2.isClassSplitting();
        it.setClassSplitting(_isClassSplitting);
        AntlrOptions _options_3 = TestLanguage.this.parserGenerator.getOptions();
        int _casesPerSpecialStateSwitch = _options_3.getCasesPerSpecialStateSwitch();
        String _string = Integer.valueOf(_casesPerSpecialStateSwitch).toString();
        it.setCasesPerSpecialStateSwitch(_string);
        AntlrOptions _options_4 = TestLanguage.this.parserGenerator.getOptions();
        int _fieldsPerClass = _options_4.getFieldsPerClass();
        String _string_1 = Integer.valueOf(_fieldsPerClass).toString();
        it.setFieldsPerClass(_string_1);
        AntlrOptions _options_5 = TestLanguage.this.parserGenerator.getOptions();
        boolean _isIgnoreCase = _options_5.isIgnoreCase();
        it.setIgnoreCase(_isIgnoreCase);
        AntlrOptions _options_6 = TestLanguage.this.parserGenerator.getOptions();
        int _k = _options_6.getK();
        it.setK(_k);
        AntlrOptions _options_7 = TestLanguage.this.parserGenerator.getOptions();
        boolean _isMemoize = _options_7.isMemoize();
        it.setMemoize(_isMemoize);
        AntlrOptions _options_8 = TestLanguage.this.parserGenerator.getOptions();
        boolean _isOptimizeCodeQuality = _options_8.isOptimizeCodeQuality();
        it.setOptimizeCodeQuality(_isOptimizeCodeQuality);
        AntlrOptions _options_9 = TestLanguage.this.parserGenerator.getOptions();
        boolean _isSkipUnusedRules = _options_9.isSkipUnusedRules();
        it.setSkipUnusedRules(_isSkipUnusedRules);
        AntlrOptions _options_10 = TestLanguage.this.parserGenerator.getOptions();
        boolean _isStripAllComments = _options_10.isStripAllComments();
        it.setStripAllComments(_isStripAllComments);
      }
    };
    org.eclipse.xtext.generator.parser.antlr.AntlrOptions _doubleArrow = ObjectExtensions.<org.eclipse.xtext.generator.parser.antlr.AntlrOptions>operator_doubleArrow(_antlrOptions, _function);
    comparison.setOptions(_doubleArrow);
    result.add(comparison);
    result.add(this.grammarAccess);
    result.add(this.emfGenerator);
    result.add(this.serializer);
    result.add(this.resourceFactoryFragment);
    result.add(this.ideaParser);
    result.add(this.ideaPlugin);
    return result;
  }
  
  @Pure
  public GrammarAccessFragment2 getGrammarAccess() {
    return this.grammarAccess;
  }
  
  public void setGrammarAccess(final GrammarAccessFragment2 grammarAccess) {
    this.grammarAccess = grammarAccess;
  }
  
  @Pure
  public SerializerFragment2 getSerializer() {
    return this.serializer;
  }
  
  public void setSerializer(final SerializerFragment2 serializer) {
    this.serializer = serializer;
  }
  
  @Pure
  public ResourceFactoryFragment2 getResourceFactoryFragment() {
    return this.resourceFactoryFragment;
  }
  
  public void setResourceFactoryFragment(final ResourceFactoryFragment2 resourceFactoryFragment) {
    this.resourceFactoryFragment = resourceFactoryFragment;
  }
  
  @Pure
  public EMFGeneratorFragment2 getEmfGenerator() {
    return this.emfGenerator;
  }
  
  public void setEmfGenerator(final EMFGeneratorFragment2 emfGenerator) {
    this.emfGenerator = emfGenerator;
  }
  
  @Pure
  public XtextAntlrGeneratorFragment2 getParserGenerator() {
    return this.parserGenerator;
  }
  
  public void setParserGenerator(final XtextAntlrGeneratorFragment2 parserGenerator) {
    this.parserGenerator = parserGenerator;
  }
  
  @Pure
  public XtextAntlrIDEAGeneratorFragment getIdeaParser() {
    return this.ideaParser;
  }
  
  public void setIdeaParser(final XtextAntlrIDEAGeneratorFragment ideaParser) {
    this.ideaParser = ideaParser;
  }
  
  @Pure
  public IdeaPluginGenerator getIdeaPlugin() {
    return this.ideaPlugin;
  }
  
  public void setIdeaPlugin(final IdeaPluginGenerator ideaPlugin) {
    this.ideaPlugin = ideaPlugin;
  }
}
