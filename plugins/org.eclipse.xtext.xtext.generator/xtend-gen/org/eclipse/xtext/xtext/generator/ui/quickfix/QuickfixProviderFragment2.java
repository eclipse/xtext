/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.quickfix;

import com.google.common.base.Objects;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
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
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;
import org.eclipse.xtext.xtext.generator.validation.ValidatorNaming;

/**
 * Contributes the Quickfix provider stub, either in Xtend or Java language.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class QuickfixProviderFragment2 extends AbstractInheritingFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private CodeConfig _codeConfig;
  
  @Inject
  @Extension
  private ValidatorNaming _validatorNaming;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  protected TypeReference getQuickfixProviderClass(final Grammar g) {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(g);
    String _plus = (_eclipsePluginBasePackage + ".quickfix.");
    String _simpleName = GrammarUtil.getSimpleName(g);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "QuickfixProvider");
    return new TypeReference(_plus_2);
  }
  
  protected TypeReference getQuickfixProviderSuperClass(final Grammar g) {
    TypeReference _xblockexpression = null;
    {
      final Grammar superGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(g);
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
        _xifexpression = this.getQuickfixProviderClass(superGrammar);
      } else {
        _xifexpression = this.getDefaultQuickfixProviderSuperClass();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Extra getter facilitates customization by overriding.
   */
  protected TypeReference getDefaultQuickfixProviderSuperClass() {
    return new TypeReference("org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider");
  }
  
  @Override
  public void generate() {
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider");
    Grammar _grammar = this.getGrammar();
    TypeReference _quickfixProviderClass = this.getQuickfixProviderClass(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeReference, _quickfixProviderClass);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    _addTypeToType.contributeTo(_eclipsePluginGenModule);
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _src = null;
      if (_eclipsePlugin!=null) {
        _src=_eclipsePlugin.getSrc();
      }
      boolean _tripleNotEquals = (_src != null);
      if (_tripleNotEquals) {
        boolean _isPreferXtendStubs = this._codeConfig.isPreferXtendStubs();
        if (_isPreferXtendStubs) {
          this.generateXtendQuickfixProvider();
        } else {
          this.generateJavaQuickfixProvider();
        }
      }
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      ManifestAccess _manifest = _eclipsePlugin_1.getManifest();
      boolean _notEquals = (!Objects.equal(_manifest, null));
      if (_notEquals) {
        IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_2.getEclipsePlugin();
        ManifestAccess _manifest_1 = _eclipsePlugin_2.getManifest();
        Set<String> _exportedPackages = _manifest_1.getExportedPackages();
        Grammar _grammar_1 = this.getGrammar();
        TypeReference _quickfixProviderClass_1 = this.getQuickfixProviderClass(_grammar_1);
        String _packageName = _quickfixProviderClass_1.getPackageName();
        _exportedPackages.add(_packageName);
      }
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_3 = _projectConfig_3.getEclipsePlugin();
      PluginXmlAccess _pluginXml = _eclipsePlugin_3.getPluginXml();
      boolean _notEquals_1 = (!Objects.equal(_pluginXml, null));
      if (_notEquals_1) {
        this.addRegistrationToPluginXml();
      }
    } else {
      IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_4 = _projectConfig_4.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _srcGen = null;
      if (_eclipsePlugin_4!=null) {
        _srcGen=_eclipsePlugin_4.getSrcGen();
      }
      boolean _tripleNotEquals_1 = (_srcGen != null);
      if (_tripleNotEquals_1) {
        this.generateGenScopeProvider();
      }
      IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_5 = _projectConfig_5.getEclipsePlugin();
      ManifestAccess _manifest_2 = _eclipsePlugin_5.getManifest();
      boolean _notEquals_2 = (!Objects.equal(_manifest_2, null));
      if (_notEquals_2) {
        IXtextProjectConfig _projectConfig_6 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_6 = _projectConfig_6.getEclipsePlugin();
        ManifestAccess _manifest_3 = _eclipsePlugin_6.getManifest();
        Set<String> _exportedPackages_1 = _manifest_3.getExportedPackages();
        Grammar _grammar_2 = this.getGrammar();
        TypeReference _quickfixProviderClass_2 = this.getQuickfixProviderClass(_grammar_2);
        String _packageName_1 = _quickfixProviderClass_2.getPackageName();
        _exportedPackages_1.add(_packageName_1);
      }
    }
  }
  
  public void generateGenScopeProvider() {
    Grammar _grammar = this.getGrammar();
    final TypeReference genClass = this.getQuickfixProviderClass(_grammar);
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar = QuickfixProviderFragment2.this.getGrammar();
        TypeReference _quickfixProviderSuperClass = QuickfixProviderFragment2.this.getQuickfixProviderSuperClass(_grammar);
        _builder.append(_quickfixProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    file.writeTo(_srcGen);
  }
  
  protected void generateXtendQuickfixProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _quickfixProviderClass = this.getQuickfixProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Custom quickfixes.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#quick-fixes");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        Grammar _grammar = QuickfixProviderFragment2.this.getGrammar();
        TypeReference _quickfixProviderClass = QuickfixProviderFragment2.this.getQuickfixProviderClass(_grammar);
        String _simpleName = _quickfixProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = QuickfixProviderFragment2.this.getGrammar();
        TypeReference _quickfixProviderSuperClass = QuickfixProviderFragment2.this.getQuickfixProviderSuperClass(_grammar_1);
        _builder.append(_quickfixProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("//\t@Fix(");
        Grammar _grammar_2 = QuickfixProviderFragment2.this.getGrammar();
        TypeReference _validatorClass = QuickfixProviderFragment2.this._validatorNaming.getValidatorClass(_grammar_2);
        String _simpleName_1 = _validatorClass.getSimpleName();
        _builder.append(_simpleName_1, "");
        _builder.append(".INVALID_NAME)");
        _builder.newLineIfNotEmpty();
        _builder.append("//\tdef capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {");
        _builder.newLine();
        _builder.append("//\t\tacceptor.accept(issue, \'Capitalize name\', \'Capitalize the name.\', \'upcase.png\') [");
        _builder.newLine();
        _builder.append("//\t\t\tcontext |");
        _builder.newLine();
        _builder.append("//\t\t\tval xtextDocument = context.xtextDocument");
        _builder.newLine();
        _builder.append("//\t\t\tval firstLetter = xtextDocument.get(issue.offset, 1)");
        _builder.newLine();
        _builder.append("//\t\t\txtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)");
        _builder.newLine();
        _builder.append("//\t\t]");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_quickfixProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createXtendFile.writeTo(_src);
  }
  
  protected void generateJavaQuickfixProvider() {
    Grammar _grammar = this.getGrammar();
    TypeReference _quickfixProviderClass = this.getQuickfixProviderClass(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Custom quickfixes.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#quick-fixes");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        Grammar _grammar = QuickfixProviderFragment2.this.getGrammar();
        TypeReference _quickfixProviderClass = QuickfixProviderFragment2.this.getQuickfixProviderClass(_grammar);
        String _simpleName = _quickfixProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        Grammar _grammar_1 = QuickfixProviderFragment2.this.getGrammar();
        TypeReference _quickfixProviderSuperClass = QuickfixProviderFragment2.this.getQuickfixProviderSuperClass(_grammar_1);
        _builder.append(_quickfixProviderSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("//\t@Fix(");
        Grammar _grammar_2 = QuickfixProviderFragment2.this.getGrammar();
        TypeReference _validatorClass = QuickfixProviderFragment2.this._validatorNaming.getValidatorClass(_grammar_2);
        String _simpleName_1 = _validatorClass.getSimpleName();
        _builder.append(_simpleName_1, "");
        _builder.append(".INVALID_NAME)");
        _builder.newLineIfNotEmpty();
        _builder.append("//\tpublic void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {");
        _builder.newLine();
        _builder.append("//\t\tacceptor.accept(issue, \"Capitalize name\", \"Capitalize the name.\", \"upcase.png\", new IModification() {");
        _builder.newLine();
        _builder.append("//\t\t\tpublic void apply(IModificationContext context) throws BadLocationException {");
        _builder.newLine();
        _builder.append("//\t\t\t\tIXtextDocument xtextDocument = context.getXtextDocument();");
        _builder.newLine();
        _builder.append("//\t\t\t\tString firstLetter = xtextDocument.get(issue.getOffset(), 1);");
        _builder.newLine();
        _builder.append("//\t\t\t\txtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());");
        _builder.newLine();
        _builder.append("//\t\t\t}");
        _builder.newLine();
        _builder.append("//\t\t});");
        _builder.newLine();
        _builder.append("//\t}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_quickfixProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  protected boolean addRegistrationToPluginXml() {
    boolean _xblockexpression = false;
    {
      Grammar _grammar = this.getGrammar();
      String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(_grammar);
      String _plus = (_eclipsePluginBasePackage + ".");
      Grammar _grammar_1 = this.getGrammar();
      String _simpleName = GrammarUtil.getSimpleName(_grammar_1);
      String _lowerCase = _simpleName.toLowerCase();
      final String markerTypePrefix = (_plus + _lowerCase);
      Grammar _grammar_2 = this.getGrammar();
      final TypeReference executableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(_grammar_2);
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
      PluginXmlAccess _pluginXml = _eclipsePlugin.getPluginXml();
      List<CharSequence> _entries = _pluginXml.getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- quickfix marker resolution generator for ");
      Grammar _grammar_3 = this.getGrammar();
      String _name = _grammar_3.getName();
      _builder.append(_name, "");
      _builder.append(" -->");
      _builder.newLineIfNotEmpty();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("point=\"org.eclipse.ui.ide.markerResolution\">");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<markerResolutionGenerator");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("class=\"");
      _builder.append(executableExtensionFactory, "        ");
      _builder.append(":org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("markerType=\"");
      _builder.append(markerTypePrefix, "        ");
      _builder.append(".check.fast\">");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("<attribute");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("name=\"FIXABLE_KEY\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("value=\"true\">");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("</attribute>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("</markerResolutionGenerator>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<markerResolutionGenerator");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("class=\"");
      _builder.append(executableExtensionFactory, "        ");
      _builder.append(":org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("markerType=\"");
      _builder.append(markerTypePrefix, "        ");
      _builder.append(".check.normal\">");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("<attribute");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("name=\"FIXABLE_KEY\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("value=\"true\">");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("</attribute>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("</markerResolutionGenerator>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<markerResolutionGenerator");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("class=\"");
      _builder.append(executableExtensionFactory, "        ");
      _builder.append(":org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("markerType=\"");
      _builder.append(markerTypePrefix, "        ");
      _builder.append(".check.expensive\">");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("<attribute");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("name=\"FIXABLE_KEY\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("value=\"true\">");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("</attribute>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("</markerResolutionGenerator>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _xblockexpression = _entries.add(_builder.toString());
    }
    return _xblockexpression;
  }
}
