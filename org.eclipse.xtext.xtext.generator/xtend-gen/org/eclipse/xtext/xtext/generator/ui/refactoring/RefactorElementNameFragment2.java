/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.refactoring;

import com.google.inject.Inject;
import com.google.inject.name.Names;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.util.BooleanGeneratorOption;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

/**
 * Contributes the registration of element renaming infrastructure.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class RefactorElementNameFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  private final BooleanGeneratorOption useJdtRefactoring = new BooleanGeneratorOption();
  
  protected boolean isUseJdtRefactoring(final Grammar grammar) {
    boolean _xifexpression = false;
    boolean _isSet = this.useJdtRefactoring.isSet();
    if (_isSet) {
      _xifexpression = this.useJdtRefactoring.get();
    } else {
      _xifexpression = this._xbaseUsageDetector.inheritsXbase(grammar);
    }
    return _xifexpression;
  }
  
  public void setUseJdtRefactoring(final boolean useJdtRefactoring) {
    this.useJdtRefactoring.set(useJdtRefactoring);
  }
  
  @Override
  public void generate() {
    IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
    ManifestAccess _manifest = null;
    if (_eclipsePlugin!=null) {
      _manifest=_eclipsePlugin.getManifest();
    }
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _requiredBundles = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.ui");
    }
    GuiceModuleAccess.BindingFactory _addTypeToType = new GuiceModuleAccess.BindingFactory().addTypeToType(
      TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.IRenameStrategy"), 
      TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy")).addTypeToType(
      TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.IReferenceUpdater"), 
      TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater"));
    String _join = IterableExtensions.join(TypeReference.typeRef("org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer").getSimpleNames(), ".");
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer");
        _builder.append(_typeRef);
        _builder.append(".class)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".annotatedWith(");
        _builder.append(Names.class, "\t");
        _builder.append(".named(\"RefactoringPreferences\"))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".to(");
        TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "RefactoringPreferences.Initializer");
        _builder.append(_typeReference, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    final GuiceModuleAccess.BindingFactory bindings = _addTypeToType.addConfiguredBinding(_join, _client);
    boolean _isUseJdtRefactoring = this.isUseJdtRefactoring(this.getGrammar());
    if (_isUseJdtRefactoring) {
      GuiceModuleAccess.BindingFactory _addTypeToType_1 = bindings.addTypeToType(
        TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory"), 
        TypeReference.typeRef("org.eclipse.xtext.common.types.ui.refactoring.JdtRefactoringContextFactory")).addTypeToType(
        TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider"), 
        TypeReference.typeRef("org.eclipse.xtext.common.types.ui.refactoring.JvmRenameRefactoringProvider"));
      TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "IRenameSupport.Factory");
      TypeReference _typeReference_1 = new TypeReference("org.eclipse.xtext.common.types.ui.refactoring", "JdtRenameSupport.Factory");
      GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addTypeToType_1.addTypeToType(_typeReference, _typeReference_1);
      TypeReference _typeReference_2 = new TypeReference("org.eclipse.xtext.ui.refactoring", "IRenameStrategy.Provider");
      TypeReference _typeReference_3 = new TypeReference("org.eclipse.xtext.common.types.ui.refactoring.participant", "JvmMemberRenameStrategy.Provider");
      GuiceModuleAccess.BindingFactory _addTypeToType_3 = _addTypeToType_2.addTypeToType(_typeReference_2, _typeReference_3);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("binder.bind(");
          TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.refactoring", "IRenameStrategy.Provider");
          _builder.append(_typeReference);
          _builder.append(".class).annotatedWith(");
          TypeReference _typeReference_1 = new TypeReference("org.eclipse.xtext.common.types.ui.refactoring.participant", "JvmMemberRenameStrategy.Provider.Delegate");
          _builder.append(_typeReference_1);
          _builder.append(".class).to(");
          TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider");
          _builder.append(_typeRef);
          _builder.append(".class);");
          _builder.newLineIfNotEmpty();
        }
      };
      _addTypeToType_3.addConfiguredBinding(
        "JvmMemberRenameStrategy.Provider.Delegate", _client_1);
    } else {
      GuiceModuleAccess.BindingFactory _addTypeToType_4 = bindings.addTypeToType(
        TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider"), 
        TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider"));
      TypeReference _typeReference_4 = new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "IRenameSupport.Factory");
      TypeReference _typeReference_5 = new TypeReference("org.eclipse.xtext.ui.refactoring.ui", "DefaultRenameSupport.Factory");
      _addTypeToType_4.addTypeToType(_typeReference_4, _typeReference_5);
    }
    bindings.contributeTo(this.getLanguage().getEclipsePluginGenModule());
    IBundleProjectConfig _eclipsePlugin_1 = this.getProjectConfig().getEclipsePlugin();
    PluginXmlAccess _pluginXml = null;
    if (_eclipsePlugin_1!=null) {
      _pluginXml=_eclipsePlugin_1.getPluginXml();
    }
    boolean _tripleNotEquals_1 = (_pluginXml != null);
    if (_tripleNotEquals_1) {
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- Rename Refactoring -->");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.handlers\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<handler ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("commandId=\"org.eclipse.xtext.ui.refactoring.RenameElement\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<activeWhen>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<reference");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("definitionId=\"");
      String _name = this.getGrammar().getName();
      _builder.append(_name, "\t\t\t\t");
      _builder.append(".Editor.opened\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("</reference>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</activeWhen>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</handler>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.menus\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<menuContribution");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("locationURI=\"popup:#TextEditorContext?after=group.edit\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<command commandId=\"org.eclipse.xtext.ui.refactoring.RenameElement\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("style=\"push\">");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<visibleWhen checkEnabled=\"false\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<reference");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("definitionId=\"");
      String _name_1 = this.getGrammar().getName();
      _builder.append(_name_1, "\t\t\t\t\t");
      _builder.append(".Editor.opened\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("</reference>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</visibleWhen>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</command>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</menuContribution>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.preferencePages\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<page");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("category=\"");
      String _name_2 = this.getGrammar().getName();
      _builder.append(_name_2, "\t\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory_1 = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferencePage\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("id=\"");
      String _name_3 = this.getGrammar().getName();
      _builder.append(_name_3, "\t\t");
      _builder.append(".refactoring\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("name=\"Refactoring\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<keywordReference id=\"");
      String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
      String _plus = (_runtimeBasePackage + ".ui.keyword_");
      String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
      String _plus_1 = (_plus + _simpleName);
      _builder.append(_plus_1, "\t\t");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</page>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
  }
}
