/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.index;

import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Annotation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.AnnotationNames;
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

/**
 * By default the @link DefaultResourceDescriptionStrategy exposes all model element that have a name.
 * That means a given ParserRule with a corresponding model type with a name gets stored to the index by default.
 * Normally one would bind a custom impl of @link IDefaultResourceDescriptionStrategy to filter.
 * By using this fragment and @Exported on a AbstractRule in the Xtext grammar the corresponding model element gets explicitly visible
 * stored to the index and all others don't.
 * 
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceDescriptionStrategyFragment extends AbstractInheritingFragment {
  /**
   * if this flag is set to false nothing get's generated or bound
   */
  @Accessors
  private boolean generate = true;

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  private FileAccessFactory fileAccessFactory;

  protected TypeReference getDefaultResourceDescriptionStrategyClass() {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
    String _plus = (_runtimeBasePackage + ".resource.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "DefaultResourceDescriptionStrategy");
    return new TypeReference(_plus_2);
  }

  protected TypeReference getAbstractResourceDescriptionStrategyClass() {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
    String _plus = (_runtimeBasePackage + ".resource.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "AbstractResourceDescriptionStrategy");
    return new TypeReference(_plus_2);
  }

  protected TypeReference getResourceDescriptionStrategyClass(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".resource.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ResourceDescriptionStrategy");
    return new TypeReference(_plus_2);
  }

  protected TypeReference getStubResourceDescriptionStrategyClass() {
    return this.getResourceDescriptionStrategyClass(this.getGrammar());
  }

  protected boolean needsToInvokeSuperResourceDescriptionStrategy() {
    return (this.isInheritImplementation() && (GrammarUtil2.getNonTerminalsSuperGrammar(this.getGrammar()) != null));
  }

  protected TypeReference getResourceDescriptionSuperClass() {
    final Grammar superGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(this.getGrammar());
    if ((this.isInheritImplementation() && (superGrammar != null))) {
      return this.getResourceDescriptionStrategyClass(superGrammar);
    } else {
      return new TypeReference("org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy");
    }
  }

  protected void contributeRuntimeGuiceBindings() {
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    if ((this.isGenerateStub() || this.isGenerateXtendStub())) {
      bindingFactory.addTypeToType(TypeReference.typeRef(IDefaultResourceDescriptionStrategy.class), this.getStubResourceDescriptionStrategyClass());
    } else {
      bindingFactory.addTypeToType(TypeReference.typeRef(IDefaultResourceDescriptionStrategy.class), this.getDefaultResourceDescriptionStrategyClass());
    }
    bindingFactory.contributeTo(this.getLanguage().getRuntimeGenModule());
  }

  protected List<AbstractRule> getExportedRulesFromGrammar() {
    List<AbstractRule> _xblockexpression = null;
    {
      final HashSet<EClassifier> alreadyCollected = CollectionLiterals.<EClassifier>newHashSet();
      final Function1<AbstractRule, Boolean> _function = (AbstractRule it) -> {
        return Boolean.valueOf((this.isExported(it) && alreadyCollected.add(it.getType().getClassifier())));
      };
      _xblockexpression = IterableExtensions.<AbstractRule>toList(IterableExtensions.<AbstractRule>filter(this.getGrammar().getRules(), _function));
    }
    return _xblockexpression;
  }

  @Override
  public void generate() {
    final List<AbstractRule> exportedRules = this.getExportedRulesFromGrammar();
    boolean _shouldGenerateArtefacts = this.shouldGenerateArtefacts(exportedRules);
    if (_shouldGenerateArtefacts) {
      this.contributeRuntimeGuiceBindings();
      this.generateResourceDescriptionStrategy(exportedRules).writeTo(this.getProjectConfig().getRuntime().getSrcGen());
      this.generateResourceDescriptionStrategyStub(exportedRules);
      ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      if (_tripleNotEquals) {
        Set<String> _exportedPackages = this.getProjectConfig().getRuntime().getManifest().getExportedPackages();
        String _packageName = this.getResourceDescriptionStrategyClass(this.getGrammar()).getPackageName();
        _exportedPackages.add(_packageName);
      }
    }
  }

  protected boolean shouldGenerateArtefacts(final Iterable<AbstractRule> exportedRules) {
    return (this.generate && (!IterableExtensions.isEmpty(exportedRules)));
  }

  protected TypeReference getSuperTypeRef() {
    TypeReference _xifexpression = null;
    if ((this.isGenerateStub() || this.isGenerateXtendStub())) {
      _xifexpression = this.getAbstractResourceDescriptionStrategyClass();
    } else {
      _xifexpression = this.getDefaultResourceDescriptionStrategyClass();
    }
    return _xifexpression;
  }

  protected JavaFileAccess generateResourceDescriptionStrategy(final Iterable<AbstractRule> exportedRules) {
    TypeReference _abstractResourceDescriptionStrategyClass = this.getAbstractResourceDescriptionStrategyClass();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = ResourceDescriptionStrategyFragment.this.getSuperTypeRef().getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _resourceDescriptionSuperClass = ResourceDescriptionStrategyFragment.this.getResourceDescriptionSuperClass();
        _builder.append(_resourceDescriptionSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public boolean createEObjectDescriptions(");
        _builder.append(EObject.class, "\t");
        _builder.append(" eObject, ");
        _builder.append(IAcceptor.class, "\t");
        _builder.append("<");
        _builder.append(IEObjectDescription.class, "\t");
        _builder.append("> acceptor) {");
        _builder.newLineIfNotEmpty();
        {
          for(final AbstractRule exportedRule : exportedRules) {
            _builder.append("\t\t");
            _builder.append("if(eObject instanceof ");
            EClassifier _classifier = exportedRule.getType().getClassifier();
            ResourceSet _resourceSet = ResourceDescriptionStrategyFragment.this.getGrammar().eResource().getResourceSet();
            TypeReference _typeReference = new TypeReference(((EClass) _classifier), _resourceSet);
            _builder.append(_typeReference, "\t\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return createEObjectDescriptionsFor");
            String _name = exportedRule.getType().getClassifier().getName();
            _builder.append(_name, "\t\t\t");
            _builder.append("(eObject, acceptor);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          boolean _needsToInvokeSuperResourceDescriptionStrategy = ResourceDescriptionStrategyFragment.this.needsToInvokeSuperResourceDescriptionStrategy();
          if (_needsToInvokeSuperResourceDescriptionStrategy) {
            _builder.append("\t\t");
            _builder.append("return super.createEObjectDescriptions(eObject, acceptor);");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("return true;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        {
          for(final AbstractRule exportedRule_1 : exportedRules) {
            _builder.append("\t");
            _builder.append("protected boolean createEObjectDescriptionsFor");
            String _name_1 = exportedRule_1.getType().getClassifier().getName();
            _builder.append(_name_1, "\t");
            _builder.append("(");
            _builder.append(EObject.class, "\t");
            _builder.append(" eObject, ");
            _builder.append(IAcceptor.class, "\t");
            _builder.append("<");
            _builder.append(IEObjectDescription.class, "\t");
            _builder.append("> acceptor) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return super.createEObjectDescriptions(eObject, acceptor);");
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
    return this.fileAccessFactory.createJavaFile(_abstractResourceDescriptionStrategyClass, _client);
  }

  protected void generateResourceDescriptionStrategyStub(final Iterable<AbstractRule> exportedRules) {
    if ((this.isGenerateStub() || this.isGenerateXtendStub())) {
      TypeReference _stubResourceDescriptionStrategyClass = this.getStubResourceDescriptionStrategyClass();
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          String _simpleName = ResourceDescriptionStrategyFragment.this.getStubResourceDescriptionStrategyClass().getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _abstractResourceDescriptionStrategyClass = ResourceDescriptionStrategyFragment.this.getAbstractResourceDescriptionStrategyClass();
          _builder.append(_abstractResourceDescriptionStrategyClass);
          _builder.append("{");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this.fileAccessFactory.createJavaFile(_stubResourceDescriptionStrategyClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
    } else {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        TypeReference _stubResourceDescriptionStrategyClass_1 = this.getStubResourceDescriptionStrategyClass();
        StringConcatenationClient _client_1 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("class ");
            TypeReference _stubResourceDescriptionStrategyClass = ResourceDescriptionStrategyFragment.this.getStubResourceDescriptionStrategyClass();
            _builder.append(_stubResourceDescriptionStrategyClass);
            _builder.append(" extends ");
            TypeReference _abstractResourceDescriptionStrategyClass = ResourceDescriptionStrategyFragment.this.getAbstractResourceDescriptionStrategyClass();
            _builder.append(_abstractResourceDescriptionStrategyClass);
            _builder.append("{");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        };
        this.fileAccessFactory.createXtendFile(_stubResourceDescriptionStrategyClass_1, _client_1).writeTo(this.getProjectConfig().getRuntime().getSrc());
      }
    }
  }

  protected boolean isExported(final AbstractRule rule) {
    final Function1<Annotation, Boolean> _function = (Annotation it) -> {
      return Boolean.valueOf(AnnotationNames.EXPORTED.equals(it.getName()));
    };
    return IterableExtensions.<Annotation>exists(rule.getAnnotations(), _function);
  }

  @Pure
  public boolean isGenerate() {
    return this.generate;
  }

  public void setGenerate(final boolean generate) {
    this.generate = generate;
  }
}
