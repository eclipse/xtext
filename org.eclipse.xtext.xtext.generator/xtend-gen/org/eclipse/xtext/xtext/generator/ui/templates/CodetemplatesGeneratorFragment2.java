/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.templates;

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
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
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
  public static class Disabled extends CodetemplatesGeneratorFragment2 {
    @Override
    public void generate() {
    }
  }

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
    IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
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
        _builder.append(_typeRef);
        _builder.append(".getTemplatesLanguageConfigurationProvider()");
      }
    };
    GuiceModuleAccess.BindingFactory _addTypeToProviderInstance = _bindingFactory.addTypeToProviderInstance(_typeRef, _client);
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry");
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator");
        _builder.append(_typeRef);
        _builder.append(".getLanguageRegistry()");
      }
    };
    _addTypeToProviderInstance.addTypeToProviderInstance(_typeRef_1, _client_1).addTypeToTypeEagerSingleton(
      TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar"), 
      TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar")).addTypeToType(
      TypeReference.typeRef("org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage"), 
      TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage")).addTypeToType(
      TypeReference.typeRef("org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser"), 
      this.getPartialContentAssistParserClass(this.getGrammar())).addTypeToType(
      TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory"), 
      TypeReference.typeRef("org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialEditingContentAssistContextFactory")).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    IBundleProjectConfig _genericIde = this.getProjectConfig().getGenericIde();
    IXtextGeneratorFileSystemAccess _srcGen = null;
    if (_genericIde!=null) {
      _srcGen=_genericIde.getSrcGen();
    }
    boolean _tripleNotEquals = (_srcGen != null);
    if (_tripleNotEquals) {
      GeneratedJavaFileAccess _createGeneratedJavaFile = this.fileAccessFactory.createGeneratedJavaFile(this.getPartialContentAssistParserClass(this.getGrammar()));
      final Procedure1<GeneratedJavaFileAccess> _function = (GeneratedJavaFileAccess it) -> {
        it.setContent(this.getGenPartialContentAssistParser());
        it.writeTo(this.getProjectConfig().getGenericIde().getSrcGen());
      };
      ObjectExtensions.<GeneratedJavaFileAccess>operator_doubleArrow(_createGeneratedJavaFile, _function);
    }
  }

  private StringConcatenationClient getGenPartialContentAssistParser() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = CodetemplatesGeneratorFragment2.this.getPartialContentAssistParserClass(CodetemplatesGeneratorFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _parserClass = CodetemplatesGeneratorFragment2.this.caNaming.getParserClass(CodetemplatesGeneratorFragment2.this.getGrammar());
        _builder.append(_parserClass);
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
