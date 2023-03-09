/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
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
      final Grammar superGrammar = IterableExtensions.<Grammar>head(g.getUsedGrammars());
      TypeReference _xifexpression = null;
      if ((this.isInheritImplementation() && (superGrammar != null))) {
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
    ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _requiredBundles = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.ui");
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider");
    _bindingFactory.addTypeToType(_typeReference, 
      this.getProposalProviderClass(this.getGrammar())).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    IXtextGeneratorFileSystemAccess _srcGen = this.getProjectConfig().getEclipsePlugin().getSrcGen();
    boolean _tripleNotEquals_1 = (_srcGen != null);
    if (_tripleNotEquals_1) {
      this.generateGenJavaProposalProvider();
    }
    if ((this.isGenerateStub() && (this.getProjectConfig().getEclipsePlugin().getSrc() != null))) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.generateXtendProposalProviderStub();
        ManifestAccess _manifest_1 = this.getProjectConfig().getEclipsePlugin().getManifest();
        boolean _tripleNotEquals_2 = (_manifest_1 != null);
        if (_tripleNotEquals_2) {
          Set<String> _requiredBundles_1 = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
          String _xbaseLibVersionLowerBound = this.getProjectConfig().getRuntime().getXbaseLibVersionLowerBound();
          String _plus = ("org.eclipse.xtext.xbase.lib;bundle-version=\"" + _xbaseLibVersionLowerBound);
          String _plus_1 = (_plus + "\"");
          _requiredBundles_1.add(_plus_1);
          Set<String> _requiredBundles_2 = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
          _requiredBundles_2.add("org.eclipse.xtend.lib;resolution:=optional");
        }
      } else {
        this.generateJavaProposalProviderStub();
      }
    }
    ManifestAccess _manifest_2 = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals_3 = (_manifest_2 != null);
    if (_tripleNotEquals_3) {
      Set<String> _exportedPackages = this.getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages();
      String _packageName = this.getProposalProviderClass(this.getGrammar()).getPackageName();
      _exportedPackages.add(_packageName);
    }
  }

  public void generateXtendProposalProviderStub() {
    TypeReference _proposalProviderClass = this.getProposalProviderClass(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* on how to customize the content assistant.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = ContentAssistFragment2.this.getProposalProviderClass(ContentAssistFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _genProposalProviderClass = ContentAssistFragment2.this.getGenProposalProviderClass(ContentAssistFragment2.this.getGrammar());
        _builder.append(_genProposalProviderClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createXtendFile(_proposalProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected void generateJavaProposalProviderStub() {
    TypeReference _proposalProviderClass = this.getProposalProviderClass(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* on how to customize the content assistant.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = ContentAssistFragment2.this.getProposalProviderClass(ContentAssistFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _genProposalProviderClass = ContentAssistFragment2.this.getGenProposalProviderClass(ContentAssistFragment2.this.getGrammar());
        _builder.append(_genProposalProviderClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createJavaFile(_proposalProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected void generateGenJavaProposalProvider() {
    final Set<String> excludedFqnFeatureNames = this.getFQFeatureNamesToExclude(this.getGrammar());
    final HashSet<String> processedNames = CollectionLiterals.<String>newHashSet();
    final List<Assignment> assignments = this.getAssignments(processedNames, excludedFqnFeatureNames);
    final List<AbstractRule> remainingRules = this.getRules(processedNames, excludedFqnFeatureNames);
    this.generateGenJavaProposalProvider(assignments, remainingRules);
  }

  /**
   * @since 2.23
   */
  protected List<Assignment> getAssignments(final Set<String> processedNames, final Set<String> excludedFqnFeatureNames) {
    final Function2<ArrayList<Assignment>, Assignment, ArrayList<Assignment>> _function = (ArrayList<Assignment> candidates, Assignment assignment) -> {
      ArrayList<Assignment> _xblockexpression = null;
      {
        final String fqFeatureName = this.getFQFeatureName(assignment);
        if (((!processedNames.contains(fqFeatureName)) && (!excludedFqnFeatureNames.contains(fqFeatureName)))) {
          processedNames.add(fqFeatureName);
          candidates.add(assignment);
        }
        _xblockexpression = candidates;
      }
      return _xblockexpression;
    };
    return IterableExtensions.<Assignment, ArrayList<Assignment>>fold(GrammarUtil.containedAssignments(this.getGrammar()), CollectionLiterals.<Assignment>newArrayList(), _function);
  }

  /**
   * @since 2.23
   */
  protected List<AbstractRule> getRules(final Set<String> processedNames, final Set<String> excludedFqnFeatureNames) {
    final Function2<ArrayList<AbstractRule>, AbstractRule, ArrayList<AbstractRule>> _function = (ArrayList<AbstractRule> candidates, AbstractRule rule) -> {
      ArrayList<AbstractRule> _xblockexpression = null;
      {
        final String fqnFeatureName = this.getFQFeatureName(rule);
        if (((!processedNames.contains(fqnFeatureName)) && (!excludedFqnFeatureNames.contains(fqnFeatureName)))) {
          processedNames.add(fqnFeatureName);
          candidates.add(rule);
        }
        _xblockexpression = candidates;
      }
      return _xblockexpression;
    };
    return IterableExtensions.<AbstractRule, ArrayList<AbstractRule>>fold(this.getGrammar().getRules(), CollectionLiterals.<AbstractRule>newArrayList(), _function);
  }

  /**
   * @since 2.23
   */
  protected void generateGenJavaProposalProvider(final List<Assignment> assignments, final List<AbstractRule> rules) {
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      _xifexpression = this.getGenProposalProviderClass(this.getGrammar());
    } else {
      _xifexpression = this.getProposalProviderClass(this.getGrammar());
    }
    final TypeReference genClass = _xifexpression;
    final TypeReference superClass = this.getGenProposalProviderSuperClass(this.getGrammar());
    this.generateGenJavaProposalProvider(assignments, rules, genClass, superClass);
  }

  /**
   * @since 2.23
   */
  protected void generateGenJavaProposalProvider(final List<Assignment> assignments, final List<AbstractRule> rules, final TypeReference genClass, final TypeReference superClass) {
    GeneratedJavaFileAccess _createGeneratedJavaFile = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    final Procedure1<GeneratedJavaFileAccess> _function = (GeneratedJavaFileAccess it) -> {
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
          _builder.append(_simpleName);
          _builder.append(" extends ");
          _builder.append(superClass);
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
            for(final AbstractRule rule : rules) {
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
      it.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
    };
    ObjectExtensions.<GeneratedJavaFileAccess>operator_doubleArrow(_createGeneratedJavaFile, _function);
  }

  private StringConcatenationClient handleAssignment(final Assignment assignment) {
    StringConcatenationClient _xblockexpression = null;
    {
      final Function1<Assignment, Boolean> _function = (Assignment it) -> {
        String _feature = it.getFeature();
        String _feature_1 = assignment.getFeature();
        return Boolean.valueOf(Objects.equal(_feature, _feature_1));
      };
      final Function1<Assignment, AbstractElement> _function_1 = (Assignment it) -> {
        return it.getTerminal();
      };
      final List<AbstractElement> terminals = IterableExtensions.<AbstractElement>toList(IterableExtensions.<Assignment, AbstractElement>map(IterableExtensions.<Assignment>filter(GrammarUtil.containedAssignments(GrammarUtil.containingParserRule(assignment)), _function), _function_1));
      final Function1<AbstractElement, EClass> _function_2 = (AbstractElement it) -> {
        return it.eClass();
      };
      final Set<EClass> terminalTypes = IterableExtensions.<EClass>toSet(ListExtensions.<AbstractElement, EClass>map(terminals, _function_2));
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public void complete");
          String _fQFeatureName = ContentAssistFragment2.this.getFQFeatureName(assignment);
          _builder.append(_fQFeatureName);
          _builder.append("(");
          _builder.append(EObject.class);
          _builder.append(" model, ");
          _builder.append(Assignment.class);
          _builder.append(" assignment, ");
          TypeReference _contentAssistContextClass = ContentAssistFragment2.this.getContentAssistContextClass();
          _builder.append(_contentAssistContextClass);
          _builder.append(" context, ");
          TypeReference _iCompletionProposalAcceptorClass = ContentAssistFragment2.this.getICompletionProposalAcceptorClass();
          _builder.append(_iCompletionProposalAcceptorClass);
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
      final Function2<ArrayList<AbstractElement>, AbstractElement, ArrayList<AbstractElement>> _function = (ArrayList<AbstractElement> candidates, AbstractElement terminal) -> {
        ArrayList<AbstractElement> _xblockexpression_1 = null;
        {
          boolean _contains = processedTerminals.contains(terminal.eClass());
          boolean _not = (!_contains);
          if (_not) {
            EClass _eClass = terminal.eClass();
            processedTerminals.add(_eClass);
            candidates.add(terminal);
          }
          _xblockexpression_1 = candidates;
        }
        return _xblockexpression_1;
      };
      final ArrayList<AbstractElement> candidates = IterableExtensions.<AbstractElement, ArrayList<AbstractElement>>fold(terminals, CollectionLiterals.<AbstractElement>newArrayList(), _function);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            for(final AbstractElement terminal : candidates) {
              _builder.append("if (assignment.getTerminal() instanceof ");
              Class<?> _instanceClass = terminal.eClass().getInstanceClass();
              _builder.append(_instanceClass);
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
        _builder.append(CrossReference.class);
        _builder.append(")");
        _builder.append(accessor);
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
        _builder.append(RuleCall.class);
        _builder.append(")");
        _builder.append(accessor);
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
          Iterable<Pair<Integer, AbstractElement>> _indexed = IterableExtensions.<AbstractElement>indexed(alternatives.getElements());
          for(final Pair<Integer, AbstractElement> pair : _indexed) {
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("((");
                _builder.append(Alternatives.class);
                _builder.append(")");
                _builder.append(accessor);
                _builder.append(").getElements().get(");
                Integer _key = pair.getKey();
                _builder.append(_key);
                _builder.append(")");
              }
            };
            StringConcatenationClient _assignmentTerminal = ContentAssistFragment2.this.assignmentTerminal(pair.getValue(), _client);
            _builder.append(_assignmentTerminal);
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
    String _firstUpper = StringExtensions.toFirstUpper(GrammarUtil.containingParserRule(a).getName());
    String _plus = (_firstUpper + "_");
    String _firstUpper_1 = StringExtensions.toFirstUpper(a.getFeature());
    return (_plus + _firstUpper_1);
  }

  private Iterable<String> computeFQFeatureNames(final Grammar g) {
    final Function1<Assignment, String> _function = (Assignment it) -> {
      return this.getFQFeatureName(it);
    };
    List<String> _map = ListExtensions.<Assignment, String>map(GrammarUtil.containedAssignments(g), _function);
    final Function1<AbstractRule, String> _function_1 = (AbstractRule it) -> {
      return this.getFQFeatureName(it);
    };
    List<String> _map_1 = ListExtensions.<AbstractRule, String>map(g.getRules(), _function_1);
    return Iterables.<String>concat(_map, _map_1);
  }

  public Set<String> getFQFeatureNamesToExclude(final Grammar g) {
    Set<String> _xifexpression = null;
    Grammar _nonTerminalsSuperGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(g);
    boolean _tripleNotEquals = (_nonTerminalsSuperGrammar != null);
    if (_tripleNotEquals) {
      Sets.SetView<String> _xblockexpression = null;
      {
        final Set<String> thisGrammarFqFeatureNames = IterableExtensions.<String>toSet(this.computeFQFeatureNames(g));
        final Function1<Grammar, Iterable<String>> _function = (Grammar it) -> {
          return this.computeFQFeatureNames(it);
        };
        final Set<String> superGrammarsFqFeatureNames = IterableExtensions.<String>toSet(Iterables.<String>concat(ListExtensions.<Grammar, Iterable<String>>map(GrammarUtil.allUsedGrammars(g), _function)));
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
