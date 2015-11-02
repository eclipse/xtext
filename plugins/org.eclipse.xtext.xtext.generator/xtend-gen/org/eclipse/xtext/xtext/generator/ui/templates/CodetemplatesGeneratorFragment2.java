/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.templates;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.parser.antlr.ContentAssistGrammarNaming;

/**
 * Contributes the 'Partial...ContentAssisParser' and performs further
 *  Guice-based registrations. Does not contribute 'plugin.xml' entries.
 * 
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodetemplatesGeneratorFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  private ContentAssistGrammarNaming caNaming;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  public TypeReference getPartialContentAssistParserClass(final Grammar g) {
    String _genericIdeBasePackage = this._xtextGeneratorNaming.getGenericIdeBasePackage(g);
    String _plus = (_genericIdeBasePackage + ".contentassist.antlr");
    String _simpleName = GrammarUtil.getSimpleName(g);
    String _plus_1 = ("Partial" + _simpleName);
    String _plus_2 = (_plus_1 + "ContentAssistParser");
    return new TypeReference(_plus, _plus_2);
  }
  
  @Override
  public void generate() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    ManifestAccess _manifest = null;
    if (_eclipsePlugin!=null) {
      _manifest=_eclipsePlugin.getManifest();
    }
    Set<String> _requiredBundles = null;
    if (_manifest!=null) {
      _requiredBundles=_manifest.getRequiredBundles();
    }
    if (_requiredBundles!=null) {
      _requiredBundles.addAll(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtext.ui", "org.eclipse.xtext.ui.codetemplates.ui")));
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration");
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator");
        _builder.append(_typeRef, "");
        _builder.append(".getTemplatesLanguageConfigurationProvider()");
      }
    };
    GuiceModuleAccess.BindingFactory _addTypeToProviderInstance = _bindingFactory.addTypeToProviderInstance(_typeRef, _client);
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry");
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator");
        _builder.append(_typeRef, "");
        _builder.append(".getLanguageRegistry()");
      }
    };
    GuiceModuleAccess.BindingFactory _addTypeToProviderInstance_1 = _addTypeToProviderInstance.addTypeToProviderInstance(_typeRef_1, _client_1);
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar");
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar");
    GuiceModuleAccess.BindingFactory _addTypeToTypeEagerSingleton = _addTypeToProviderInstance_1.addTypeToTypeEagerSingleton(_typeRef_2, _typeRef_3);
    TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage");
    TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage");
    GuiceModuleAccess.BindingFactory _addTypeToType = _addTypeToTypeEagerSingleton.addTypeToType(_typeRef_4, _typeRef_5);
    TypeReference _typeRef_6 = TypeReference.typeRef("org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser");
    Grammar _grammar = this.getGrammar();
    TypeReference _partialContentAssistParserClass = this.getPartialContentAssistParserClass(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addTypeToType.addTypeToType(_typeRef_6, _partialContentAssistParserClass);
    TypeReference _typeRef_7 = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory");
    TypeReference _typeRef_8 = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialEditingContentAssistContextFactory");
    GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addTypeToType_1.addTypeToType(_typeRef_7, _typeRef_8);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    _addTypeToType_2.contributeTo(_eclipsePluginGenModule);
    IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
    IBundleProjectConfig _genericIde = _projectConfig_1.getGenericIde();
    IXtextGeneratorFileSystemAccess _srcGen = null;
    if (_genericIde!=null) {
      _srcGen=_genericIde.getSrcGen();
    }
    boolean _notEquals = (!Objects.equal(_srcGen, null));
    if (_notEquals) {
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _partialContentAssistParserClass_1 = this.getPartialContentAssistParserClass(_grammar_1);
      GeneratedJavaFileAccess _createGeneratedJavaFile = this.fileAccessFactory.createGeneratedJavaFile(_partialContentAssistParserClass_1);
      final Procedure1<GeneratedJavaFileAccess> _function = new Procedure1<GeneratedJavaFileAccess>() {
        @Override
        public void apply(final GeneratedJavaFileAccess it) {
          StringConcatenationClient _genPartialContentAssistParser = CodetemplatesGeneratorFragment2.this.getGenPartialContentAssistParser();
          it.setContent(_genPartialContentAssistParser);
          IXtextProjectConfig _projectConfig = CodetemplatesGeneratorFragment2.this.getProjectConfig();
          IBundleProjectConfig _genericIde = _projectConfig.getGenericIde();
          IXtextGeneratorFileSystemAccess _srcGen = _genericIde.getSrcGen();
          it.writeTo(_srcGen);
        }
      };
      ObjectExtensions.<GeneratedJavaFileAccess>operator_doubleArrow(_createGeneratedJavaFile, _function);
    }
  }
  
  private StringConcatenationClient getGenPartialContentAssistParser() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        Grammar _grammar = CodetemplatesGeneratorFragment2.this.getGrammar();
        TypeReference _partialContentAssistParserClass = CodetemplatesGeneratorFragment2.this.getPartialContentAssistParserClass(_grammar);
        String _simpleName = _partialContentAssistParserClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = CodetemplatesGeneratorFragment2.this.getGrammar();
        TypeReference _parserClass = CodetemplatesGeneratorFragment2.this.caNaming.getParserClass(_grammar_1);
        _builder.append(_parserClass, "");
        _builder.append(" implements ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(AbstractRule.class, "\t");
        _builder.append(" rule;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void initializeFor(AbstractRule rule) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("this.rule = rule;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Collection.class, "\t");
        _builder.append("<");
        TypeReference _followElementClass = CodetemplatesGeneratorFragment2.this.getFollowElementClass();
        _builder.append(_followElementClass, "\t");
        _builder.append("> getFollowElements(");
        TypeReference _abstractInternalContentAssistParserClass = CodetemplatesGeneratorFragment2.this.getAbstractInternalContentAssistParserClass();
        _builder.append(_abstractInternalContentAssistParserClass, "\t");
        _builder.append(" parser) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (rule == null || rule.eIsProxy())");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return ");
        _builder.append(Collections.class, "\t\t\t");
        _builder.append(".emptyList();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(String.class, "\t\t");
        _builder.append(" methodName = \"entryRule\" + rule.getName();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(PolymorphicDispatcher.class, "\t\t");
        _builder.append("<Collection<FollowElement>> dispatcher = ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("new PolymorphicDispatcher<Collection<FollowElement>>(methodName, 0, 0, Collections.singletonList(parser));");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("dispatcher.invoke();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return parser.getFollowElements();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  private TypeReference getFollowElementClass() {
    return TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement");
  }
  
  private TypeReference getAbstractInternalContentAssistParserClass() {
    return TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser");
  }
}
