/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.contentAssist;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

/**
 * Contributes the 'Abstract...ProposalProvider' and '...ProposalProvider' stub,
 *  the latter either in Xtend or Java language.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class ContentAssistFragment2 extends AbstractInheritingFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private CodeConfig _codeConfig;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  protected TypeReference getProposalProviderClass(final Grammar g) {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(g);
    String _plus = (_eclipsePluginBasePackage + ".contentassist.");
    String _simpleName = GrammarUtil.getSimpleName(g);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ProposalProvider");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getGenProposalProviderClass(final Grammar g) {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(g);
    String _plus = (_eclipsePluginBasePackage + ".contentassist.Abstract");
    String _simpleName = GrammarUtil.getSimpleName(g);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ProposalProvider");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getGenProposalProviderSuperClass(final Grammar g) {
    TypeReference _xblockexpression = null;
    {
      EList<Grammar> _usedGrammars = g.getUsedGrammars();
      final Grammar superGrammar = IterableExtensions.<Grammar>head(_usedGrammars);
      TypeReference _xifexpression = null;
      boolean _and = false;
      boolean _isInheritImplementation = this.isInheritImplementation();
      if (!_isInheritImplementation) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(superGrammar, null));
        _and = _notEquals;
      }
      if (_and) {
        _xifexpression = this.getProposalProviderClass(superGrammar);
      } else {
        _xifexpression = this.getDefaultGenProposalProviderSuperClass();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Extra getter facilitates customization by overriding.
   */
  protected TypeReference getDefaultGenProposalProviderSuperClass() {
    return new TypeReference("org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider");
  }
  
  @Override
  public void generate() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    ManifestAccess _manifest = _eclipsePlugin.getManifest();
    boolean _notEquals = (!Objects.equal(_manifest, null));
    if (_notEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.ui");
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider");
    Grammar _grammar = this.getGrammar();
    TypeReference _proposalProviderClass = this.getProposalProviderClass(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeReference, _proposalProviderClass);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    _addTypeToType.contributeTo(_eclipsePluginGenModule);
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_2.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _srcGen = _eclipsePlugin_2.getSrcGen();
    boolean _tripleNotEquals = (_srcGen != null);
    if (_tripleNotEquals) {
      this.generateGenJavaProposalProvider();
    }
    boolean _and = false;
    boolean _isGenerateStub = this.isGenerateStub();
    if (!_isGenerateStub) {
      _and = false;
    } else {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_3 = _projectConfig_3.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _src = _eclipsePlugin_3.getSrc();
      boolean _notEquals_1 = (!Objects.equal(_src, null));
      _and = _notEquals_1;
    }
    if (_and) {
      boolean _isPreferXtendStubs = this._codeConfig.isPreferXtendStubs();
      if (_isPreferXtendStubs) {
        this.generateXtendProposalProviderStub();
        IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_4 = _projectConfig_4.getEclipsePlugin();
        ManifestAccess _manifest_2 = _eclipsePlugin_4.getManifest();
        boolean _notEquals_2 = (!Objects.equal(_manifest_2, null));
        if (_notEquals_2) {
          IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
          IBundleProjectConfig _eclipsePlugin_5 = _projectConfig_5.getEclipsePlugin();
          ManifestAccess _manifest_3 = _eclipsePlugin_5.getManifest();
          Set<String> _requiredBundles_1 = _manifest_3.getRequiredBundles();
          _requiredBundles_1.add("org.eclipse.xtext.xbase.lib");
          IXtextProjectConfig _projectConfig_6 = this.getProjectConfig();
          IBundleProjectConfig _eclipsePlugin_6 = _projectConfig_6.getEclipsePlugin();
          ManifestAccess _manifest_4 = _eclipsePlugin_6.getManifest();
          Set<String> _requiredBundles_2 = _manifest_4.getRequiredBundles();
          _requiredBundles_2.add("org.eclipse.xtend.lib;resolution:=optional");
        }
      } else {
        this.generateJavaProposalProviderStub();
      }
    }
    IXtextProjectConfig _projectConfig_7 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_7 = _projectConfig_7.getEclipsePlugin();
    ManifestAccess _manifest_5 = _eclipsePlugin_7.getManifest();
    boolean _notEquals_3 = (!Objects.equal(_manifest_5, null));
    if (_notEquals_3) {
      IXtextProjectConfig _projectConfig_8 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_8 = _projectConfig_8.getEclipsePlugin();
      ManifestAccess _manifest_6 = _eclipsePlugin_8.getManifest();
      Set<String> _exportedPackages = _manifest_6.getExportedPackages();
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _proposalProviderClass_1 = this.getProposalProviderClass(_grammar_1);
      String _packageName = _proposalProviderClass_1.getPackageName();
      _exportedPackages.add(_packageName);
    }
  }
  
  public void generateXtendProposalProviderStub() {
    Grammar _grammar = this.getGrammar();
    TypeReference _proposalProviderClass = this.getProposalProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* on how to customize the content assistant.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        Grammar _grammar = ContentAssistFragment2.this.getGrammar();
        TypeReference _proposalProviderClass = ContentAssistFragment2.this.getProposalProviderClass(_grammar);
        String _simpleName = _proposalProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ContentAssistFragment2.this.getGrammar();
        TypeReference _genProposalProviderClass = ContentAssistFragment2.this.getGenProposalProviderClass(_grammar_1);
        _builder.append(_genProposalProviderClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_proposalProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  public void generateJavaProposalProviderStub() {
    Grammar _grammar = this.getGrammar();
    TypeReference _proposalProviderClass = this.getProposalProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* on how to customize the content assistant.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        Grammar _grammar = ContentAssistFragment2.this.getGrammar();
        TypeReference _proposalProviderClass = ContentAssistFragment2.this.getProposalProviderClass(_grammar);
        String _simpleName = _proposalProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = ContentAssistFragment2.this.getGrammar();
        TypeReference _genProposalProviderClass = ContentAssistFragment2.this.getGenProposalProviderClass(_grammar_1);
        _builder.append(_genProposalProviderClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_proposalProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  public GeneratedJavaFileAccess generateGenJavaProposalProvider() {
    GeneratedJavaFileAccess _xblockexpression = null;
    {
      Grammar _grammar = this.getGrammar();
      final Set<String> excludedFqnFeatureNames = this.getFQFeatureNamesToExclude(_grammar);
      final HashSet<String> processedNames = CollectionLiterals.<String>newHashSet();
      Grammar _grammar_1 = this.getGrammar();
      List<Assignment> _containedAssignments = GrammarUtil.containedAssignments(_grammar_1);
      ArrayList<Assignment> _newArrayList = CollectionLiterals.<Assignment>newArrayList();
      final Function2<ArrayList<Assignment>, Assignment, ArrayList<Assignment>> _function = new Function2<ArrayList<Assignment>, Assignment, ArrayList<Assignment>>() {
        @Override
        public ArrayList<Assignment> apply(final ArrayList<Assignment> candidates, final Assignment assignment) {
          ArrayList<Assignment> _xblockexpression = null;
          {
            final String fqFeatureName = ContentAssistFragment2.this.getFQFeatureName(assignment);
            boolean _and = false;
            boolean _contains = processedNames.contains(fqFeatureName);
            boolean _not = (!_contains);
            if (!_not) {
              _and = false;
            } else {
              boolean _contains_1 = excludedFqnFeatureNames.contains(fqFeatureName);
              boolean _not_1 = (!_contains_1);
              _and = _not_1;
            }
            if (_and) {
              processedNames.add(fqFeatureName);
              candidates.add(assignment);
            }
            _xblockexpression = candidates;
          }
          return _xblockexpression;
        }
      };
      final ArrayList<Assignment> assignments = IterableExtensions.<Assignment, ArrayList<Assignment>>fold(_containedAssignments, _newArrayList, _function);
      Grammar _grammar_2 = this.getGrammar();
      EList<AbstractRule> _rules = _grammar_2.getRules();
      ArrayList<AbstractRule> _newArrayList_1 = CollectionLiterals.<AbstractRule>newArrayList();
      final Function2<ArrayList<AbstractRule>, AbstractRule, ArrayList<AbstractRule>> _function_1 = new Function2<ArrayList<AbstractRule>, AbstractRule, ArrayList<AbstractRule>>() {
        @Override
        public ArrayList<AbstractRule> apply(final ArrayList<AbstractRule> candidates, final AbstractRule rule) {
          ArrayList<AbstractRule> _xblockexpression = null;
          {
            final String fqnFeatureName = ContentAssistFragment2.this.getFQFeatureName(rule);
            boolean _and = false;
            boolean _contains = processedNames.contains(fqnFeatureName);
            boolean _not = (!_contains);
            if (!_not) {
              _and = false;
            } else {
              boolean _contains_1 = excludedFqnFeatureNames.contains(fqnFeatureName);
              boolean _not_1 = (!_contains_1);
              _and = _not_1;
            }
            if (_and) {
              processedNames.add(fqnFeatureName);
              candidates.add(rule);
            }
            _xblockexpression = candidates;
          }
          return _xblockexpression;
        }
      };
      final ArrayList<AbstractRule> remainingRules = IterableExtensions.<AbstractRule, ArrayList<AbstractRule>>fold(_rules, _newArrayList_1, _function_1);
      TypeReference _xifexpression = null;
      boolean _isGenerateStub = this.isGenerateStub();
      if (_isGenerateStub) {
        Grammar _grammar_3 = this.getGrammar();
        _xifexpression = this.getGenProposalProviderClass(_grammar_3);
      } else {
        Grammar _grammar_4 = this.getGrammar();
        _xifexpression = this.getProposalProviderClass(_grammar_4);
      }
      final TypeReference genClass = _xifexpression;
      GeneratedJavaFileAccess _createGeneratedJavaFile = this.fileAccessFactory.createGeneratedJavaFile(genClass);
      final Procedure1<GeneratedJavaFileAccess> _function_2 = new Procedure1<GeneratedJavaFileAccess>() {
        @Override
        public void apply(final GeneratedJavaFileAccess it) {
          Grammar _grammar = ContentAssistFragment2.this.getGrammar();
          final TypeReference superClass = ContentAssistFragment2.this.getGenProposalProviderSuperClass(_grammar);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("/**");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("* Represents a generated, default implementation of superclass {@link ");
              _builder.append(superClass, " ");
              _builder.append("}.");
              _builder.newLineIfNotEmpty();
              _builder.append(" ");
              _builder.append("* Methods are dynamically dispatched on the first parameter, i.e., you can override them ");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("* with a more concrete subtype. ");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("*/");
              _builder.newLine();
            }
          };
          it.setTypeComment(_client);
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("public ");
              {
                boolean _isGenerateStub = ContentAssistFragment2.this.isGenerateStub();
                if (_isGenerateStub) {
                  _builder.append("abstract ");
                }
              }
              _builder.append("class ");
              String _simpleName = genClass.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" extends ");
              _builder.append(superClass, "");
              _builder.append(" {");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
              {
                boolean _isEmpty = assignments.isEmpty();
                boolean _not = (!_isEmpty);
                if (_not) {
                  {
                    for(final Assignment assignment : assignments) {
                      _builder.append("\t");
                      StringConcatenationClient _handleAssignment = ContentAssistFragment2.this.handleAssignment(assignment);
                      _builder.append(_handleAssignment, "\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.newLine();
                }
              }
              {
                for(final AbstractRule rule : remainingRules) {
                  _builder.append("\t");
                  _builder.append("public void complete");
                  String _fQFeatureName = ContentAssistFragment2.this.getFQFeatureName(rule);
                  _builder.append(_fQFeatureName, "\t");
                  _builder.append("(");
                  _builder.append(EObject.class, "\t");
                  _builder.append(" model, ");
                  _builder.append(RuleCall.class, "\t");
                  _builder.append(" ruleCall, ");
                  TypeReference _contentAssistContextClass = ContentAssistFragment2.this.getContentAssistContextClass();
                  _builder.append(_contentAssistContextClass, "\t");
                  _builder.append(" context, ");
                  TypeReference _iCompletionProposalAcceptorClass = ContentAssistFragment2.this.getICompletionProposalAcceptorClass();
                  _builder.append(_iCompletionProposalAcceptorClass, "\t");
                  _builder.append(" acceptor) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("// subclasses may override");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
              _builder.append("}");
              _builder.newLine();
            }
          };
          it.setContent(_client_1);
          IXtextProjectConfig _projectConfig = ContentAssistFragment2.this.getProjectConfig();
          IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
          IXtextGeneratorFileSystemAccess _srcGen = _eclipsePlugin.getSrcGen();
          it.writeTo(_srcGen);
        }
      };
      _xblockexpression = ObjectExtensions.<GeneratedJavaFileAccess>operator_doubleArrow(_createGeneratedJavaFile, _function_2);
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient handleAssignment(final Assignment assignment) {
    StringConcatenationClient _xblockexpression = null;
    {
      ParserRule _containingParserRule = GrammarUtil.containingParserRule(assignment);
      List<Assignment> _containedAssignments = GrammarUtil.containedAssignments(_containingParserRule);
      final Function1<Assignment, Boolean> _function = new Function1<Assignment, Boolean>() {
        @Override
        public Boolean apply(final Assignment it) {
          String _feature = it.getFeature();
          String _feature_1 = assignment.getFeature();
          return Boolean.valueOf(Objects.equal(_feature, _feature_1));
        }
      };
      Iterable<Assignment> _filter = IterableExtensions.<Assignment>filter(_containedAssignments, _function);
      final Function1<Assignment, AbstractElement> _function_1 = new Function1<Assignment, AbstractElement>() {
        @Override
        public AbstractElement apply(final Assignment it) {
          return it.getTerminal();
        }
      };
      Iterable<AbstractElement> _map = IterableExtensions.<Assignment, AbstractElement>map(_filter, _function_1);
      final List<AbstractElement> terminals = IterableExtensions.<AbstractElement>toList(_map);
      final Function1<AbstractElement, EClass> _function_2 = new Function1<AbstractElement, EClass>() {
        @Override
        public EClass apply(final AbstractElement it) {
          return it.eClass();
        }
      };
      List<EClass> _map_1 = ListExtensions.<AbstractElement, EClass>map(terminals, _function_2);
      final Set<EClass> terminalTypes = IterableExtensions.<EClass>toSet(_map_1);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public void complete");
          String _fQFeatureName = ContentAssistFragment2.this.getFQFeatureName(assignment);
          _builder.append(_fQFeatureName, "");
          _builder.append("(");
          _builder.append(EObject.class, "");
          _builder.append(" model, ");
          _builder.append(Assignment.class, "");
          _builder.append(" assignment, ");
          TypeReference _contentAssistContextClass = ContentAssistFragment2.this.getContentAssistContextClass();
          _builder.append(_contentAssistContextClass, "");
          _builder.append(" context, ");
          TypeReference _iCompletionProposalAcceptorClass = ContentAssistFragment2.this.getICompletionProposalAcceptorClass();
          _builder.append(_iCompletionProposalAcceptorClass, "");
          _builder.append(" acceptor) {");
          _builder.newLineIfNotEmpty();
          {
            int _size = terminalTypes.size();
            boolean _greaterThan = (_size > 1);
            if (_greaterThan) {
              _builder.append("\t");
              StringConcatenationClient _handleAssignmentOptions = ContentAssistFragment2.this.handleAssignmentOptions(terminals);
              _builder.append(_handleAssignmentOptions, "\t");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              AbstractElement _terminal = assignment.getTerminal();
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append("assignment.getTerminal()");
                }
              };
              StringConcatenationClient _assignmentTerminal = ContentAssistFragment2.this.assignmentTerminal(_terminal, _client);
              _builder.append(_assignmentTerminal, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient handleAssignmentOptions(final Iterable<AbstractElement> terminals) {
    StringConcatenationClient _xblockexpression = null;
    {
      final HashSet<EClass> processedTerminals = CollectionLiterals.<EClass>newHashSet();
      ArrayList<AbstractElement> _newArrayList = CollectionLiterals.<AbstractElement>newArrayList();
      final Function2<ArrayList<AbstractElement>, AbstractElement, ArrayList<AbstractElement>> _function = new Function2<ArrayList<AbstractElement>, AbstractElement, ArrayList<AbstractElement>>() {
        @Override
        public ArrayList<AbstractElement> apply(final ArrayList<AbstractElement> candidates, final AbstractElement terminal) {
          ArrayList<AbstractElement> _xblockexpression = null;
          {
            EClass _eClass = terminal.eClass();
            boolean _contains = processedTerminals.contains(_eClass);
            boolean _not = (!_contains);
            if (_not) {
              EClass _eClass_1 = terminal.eClass();
              processedTerminals.add(_eClass_1);
              candidates.add(terminal);
            }
            _xblockexpression = candidates;
          }
          return _xblockexpression;
        }
      };
      final ArrayList<AbstractElement> candidates = IterableExtensions.<AbstractElement, ArrayList<AbstractElement>>fold(terminals, _newArrayList, _function);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            for(final AbstractElement terminal : candidates) {
              _builder.append("if (assignment.getTerminal() instanceof ");
              EClass _eClass = terminal.eClass();
              Class<?> _instanceClass = _eClass.getInstanceClass();
              _builder.append(_instanceClass, "");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append("assignment.getTerminal()");
                }
              };
              StringConcatenationClient _assignmentTerminal = ContentAssistFragment2.this.assignmentTerminal(terminal, _client);
              _builder.append(_assignmentTerminal, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient _assignmentTerminal(final AbstractElement element, final StringConcatenationClient accessor) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("// subclasses may override");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  private StringConcatenationClient _assignmentTerminal(final CrossReference element, final StringConcatenationClient accessor) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("lookupCrossReference(((");
        _builder.append(CrossReference.class, "");
        _builder.append(")");
        _builder.append(accessor, "");
        _builder.append("), context, acceptor);");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  private StringConcatenationClient _assignmentTerminal(final RuleCall element, final StringConcatenationClient accessor) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("completeRuleCall(((");
        _builder.append(RuleCall.class, "");
        _builder.append(")");
        _builder.append(accessor, "");
        _builder.append("), context, acceptor);");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  private StringConcatenationClient _assignmentTerminal(final Alternatives alternatives, final StringConcatenationClient accessor) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          EList<AbstractElement> _elements = alternatives.getElements();
          Iterable<Pair<Integer, AbstractElement>> _indexed = IterableExtensions.<AbstractElement>indexed(_elements);
          for(final Pair<Integer, AbstractElement> pair : _indexed) {
            AbstractElement _value = pair.getValue();
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("((");
                _builder.append(Alternatives.class, "");
                _builder.append(")");
                _builder.append(accessor, "");
                _builder.append(").getElements().get(");
                Integer _key = pair.getKey();
                _builder.append(_key, "");
                _builder.append(")");
              }
            };
            StringConcatenationClient _assignmentTerminal = ContentAssistFragment2.this.assignmentTerminal(_value, _client);
            _builder.append(_assignmentTerminal, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    };
    return _client;
  }
  
  private TypeReference getContentAssistContextClass() {
    return new TypeReference("org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext");
  }
  
  private TypeReference getICompletionProposalAcceptorClass() {
    return new TypeReference("org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor");
  }
  
  private String getFQFeatureName(final AbstractRule r) {
    String _name = r.getName();
    return ("_" + _name);
  }
  
  private String getFQFeatureName(final Assignment a) {
    ParserRule _containingParserRule = GrammarUtil.containingParserRule(a);
    String _name = _containingParserRule.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    String _plus = (_firstUpper + "_");
    String _feature = a.getFeature();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_feature);
    return (_plus + _firstUpper_1);
  }
  
  private Iterable<String> computeFQFeatureNames(final Grammar g) {
    List<Assignment> _containedAssignments = GrammarUtil.containedAssignments(g);
    final Function1<Assignment, String> _function = new Function1<Assignment, String>() {
      @Override
      public String apply(final Assignment it) {
        return ContentAssistFragment2.this.getFQFeatureName(it);
      }
    };
    List<String> _map = ListExtensions.<Assignment, String>map(_containedAssignments, _function);
    EList<AbstractRule> _rules = g.getRules();
    final Function1<AbstractRule, String> _function_1 = new Function1<AbstractRule, String>() {
      @Override
      public String apply(final AbstractRule it) {
        return ContentAssistFragment2.this.getFQFeatureName(it);
      }
    };
    List<String> _map_1 = ListExtensions.<AbstractRule, String>map(_rules, _function_1);
    return Iterables.<String>concat(_map, _map_1);
  }
  
  public Set<String> getFQFeatureNamesToExclude(final Grammar g) {
    Set<String> _xifexpression = null;
    Grammar _nonTerminalsSuperGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(g);
    boolean _notEquals = (!Objects.equal(_nonTerminalsSuperGrammar, null));
    if (_notEquals) {
      Sets.SetView<String> _xblockexpression = null;
      {
        Iterable<String> _computeFQFeatureNames = this.computeFQFeatureNames(g);
        final Set<String> thisGrammarFqFeatureNames = IterableExtensions.<String>toSet(_computeFQFeatureNames);
        List<Grammar> _allUsedGrammars = GrammarUtil.allUsedGrammars(g);
        final Function1<Grammar, Iterable<String>> _function = new Function1<Grammar, Iterable<String>>() {
          @Override
          public Iterable<String> apply(final Grammar it) {
            return ContentAssistFragment2.this.computeFQFeatureNames(it);
          }
        };
        List<Iterable<String>> _map = ListExtensions.<Grammar, Iterable<String>>map(_allUsedGrammars, _function);
        Iterable<String> _flatten = Iterables.<String>concat(_map);
        final Set<String> superGrammarsFqFeatureNames = IterableExtensions.<String>toSet(_flatten);
        _xblockexpression = Sets.<String>intersection(thisGrammarFqFeatureNames, superGrammarsFqFeatureNames);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = CollectionLiterals.<String>emptySet();
    }
    return _xifexpression;
  }
  
  private StringConcatenationClient assignmentTerminal(final AbstractElement alternatives, final StringConcatenationClient accessor) {
    if (alternatives instanceof Alternatives) {
      return _assignmentTerminal((Alternatives)alternatives, accessor);
    } else if (alternatives instanceof CrossReference) {
      return _assignmentTerminal((CrossReference)alternatives, accessor);
    } else if (alternatives instanceof RuleCall) {
      return _assignmentTerminal((RuleCall)alternatives, accessor);
    } else if (alternatives != null) {
      return _assignmentTerminal(alternatives, accessor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(alternatives, accessor).toString());
    }
  }
}
