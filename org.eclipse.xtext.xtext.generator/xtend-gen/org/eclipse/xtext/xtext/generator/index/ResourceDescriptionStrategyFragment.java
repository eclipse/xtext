/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.index;

import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Annotation;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.AnnotationNames;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceDescriptionStrategyFragment extends AbstractXtextGeneratorFragment {
  @Accessors
  private boolean isGenerateStub = true;
  
  @Accessors
  private boolean isGenerateXtendStub;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  protected TypeReference getResourceDescriptionStrategyClass() {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
    String _plus = (_runtimeBasePackage + ".index.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "DefaultResourceDescriptionStrategy");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getStubResourceDescriptionStrategyClass() {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
    String _plus = (_runtimeBasePackage + ".index.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "ResourceDescriptionStrategy");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getDefaultResourceDescriptionSuperClass() {
    return new TypeReference("org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy");
  }
  
  protected void contributeRuntimeGuiceBindings() {
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    if ((this.isGenerateStub() || this.isGenerateXtendStub())) {
      bindingFactory.addTypeToType(TypeReference.typeRef(IDefaultResourceDescriptionStrategy.class), this.getStubResourceDescriptionStrategyClass());
    } else {
      bindingFactory.addTypeToType(TypeReference.typeRef(IDefaultResourceDescriptionStrategy.class), this.getResourceDescriptionStrategyClass());
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
    boolean _shouldGenerate = this.shouldGenerate(exportedRules);
    if (_shouldGenerate) {
      this.contributeRuntimeGuiceBindings();
      this.generateResourceDescriptionStrategy(exportedRules);
    }
  }
  
  protected boolean shouldGenerate(final Iterable<AbstractRule> exportedRules) {
    boolean _isEmpty = IterableExtensions.isEmpty(exportedRules);
    return (!_isEmpty);
  }
  
  protected StringConcatenationClient generateSuperResourceDescriptionStrategyContent(final Iterable<AbstractRule> exportedRules) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = ResourceDescriptionStrategyFragment.this.getResourceDescriptionStrategyClass().getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _defaultResourceDescriptionSuperClass = ResourceDescriptionStrategyFragment.this.getDefaultResourceDescriptionSuperClass();
        _builder.append(_defaultResourceDescriptionSuperClass);
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
        _builder.append("\t\t");
        _builder.append("return true;");
        _builder.newLine();
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
    return _client;
  }
  
  protected void generateResourceDescriptionStrategy(final Iterable<AbstractRule> exportedRules) {
    this.fileAccessFactory.createJavaFile(this.getResourceDescriptionStrategyClass(), this.generateSuperResourceDescriptionStrategyContent(exportedRules)).writeTo(this.getProjectConfig().getRuntime().getSrcGen());
    if ((this.isGenerateStub() && (!this.isGenerateXtendStub()))) {
      TypeReference _stubResourceDescriptionStrategyClass = this.getStubResourceDescriptionStrategyClass();
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          String _simpleName = ResourceDescriptionStrategyFragment.this.getStubResourceDescriptionStrategyClass().getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _resourceDescriptionStrategyClass = ResourceDescriptionStrategyFragment.this.getResourceDescriptionStrategyClass();
          _builder.append(_resourceDescriptionStrategyClass);
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
            TypeReference _resourceDescriptionStrategyClass = ResourceDescriptionStrategyFragment.this.getResourceDescriptionStrategyClass();
            _builder.append(_resourceDescriptionStrategyClass);
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
    final Predicate<Annotation> _function = (Annotation e) -> {
      return AnnotationNames.EXPORTED.equals(e.getName());
    };
    return rule.getAnnotations().stream().anyMatch(_function);
  }
  
  @Pure
  public boolean isGenerateStub() {
    return this.isGenerateStub;
  }
  
  public void setIsGenerateStub(final boolean isGenerateStub) {
    this.isGenerateStub = isGenerateStub;
  }
  
  @Pure
  public boolean isGenerateXtendStub() {
    return this.isGenerateXtendStub;
  }
  
  public void setIsGenerateXtendStub(final boolean isGenerateXtendStub) {
    this.isGenerateXtendStub = isGenerateXtendStub;
  }
}
