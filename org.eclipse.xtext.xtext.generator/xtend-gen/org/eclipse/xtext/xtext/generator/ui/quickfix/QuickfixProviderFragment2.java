/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.quickfix;

import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
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
      if ((this.isInheritImplementation() && (superGrammar != null))) {
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
    _bindingFactory.addTypeToType(_typeReference, 
      this.getQuickfixProviderClass(this.getGrammar())).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _src = null;
      if (_eclipsePlugin!=null) {
        _src=_eclipsePlugin.getSrc();
      }
      boolean _tripleNotEquals = (_src != null);
      if (_tripleNotEquals) {
        boolean _isGenerateXtendStub = this.isGenerateXtendStub();
        if (_isGenerateXtendStub) {
          this.generateXtendQuickfixProvider();
        } else {
          this.generateJavaQuickfixProvider();
        }
      }
      ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
      boolean _tripleNotEquals_1 = (_manifest != null);
      if (_tripleNotEquals_1) {
        Set<String> _exportedPackages = this.getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages();
        String _packageName = this.getQuickfixProviderClass(this.getGrammar()).getPackageName();
        _exportedPackages.add(_packageName);
      }
      PluginXmlAccess _pluginXml = this.getProjectConfig().getEclipsePlugin().getPluginXml();
      boolean _tripleNotEquals_2 = (_pluginXml != null);
      if (_tripleNotEquals_2) {
        this.addRegistrationToPluginXml();
      }
    } else {
      IBundleProjectConfig _eclipsePlugin_1 = this.getProjectConfig().getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _srcGen = null;
      if (_eclipsePlugin_1!=null) {
        _srcGen=_eclipsePlugin_1.getSrcGen();
      }
      boolean _tripleNotEquals_3 = (_srcGen != null);
      if (_tripleNotEquals_3) {
        this.generateGenQuickfixProvider();
      }
      ManifestAccess _manifest_1 = this.getProjectConfig().getEclipsePlugin().getManifest();
      boolean _tripleNotEquals_4 = (_manifest_1 != null);
      if (_tripleNotEquals_4) {
        Set<String> _exportedPackages_1 = this.getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages();
        String _packageName_1 = this.getQuickfixProviderClass(this.getGrammar()).getPackageName();
        _exportedPackages_1.add(_packageName_1);
      }
    }
  }

  public void generateGenQuickfixProvider() {
    final TypeReference genClass = this.getQuickfixProviderClass(this.getGrammar());
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(genClass);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = genClass.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _quickfixProviderSuperClass = QuickfixProviderFragment2.this.getQuickfixProviderSuperClass(QuickfixProviderFragment2.this.getGrammar());
        _builder.append(_quickfixProviderSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
  }

  protected void generateXtendQuickfixProvider() {
    TypeReference _quickfixProviderClass = this.getQuickfixProviderClass(this.getGrammar());
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
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = QuickfixProviderFragment2.this.getQuickfixProviderClass(QuickfixProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _quickfixProviderSuperClass = QuickfixProviderFragment2.this.getQuickfixProviderSuperClass(QuickfixProviderFragment2.this.getGrammar());
        _builder.append(_quickfixProviderSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("//\t@Fix(");
        String _simpleName_1 = QuickfixProviderFragment2.this._validatorNaming.getValidatorClass(QuickfixProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName_1);
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
    this.fileAccessFactory.createXtendFile(_quickfixProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected void generateJavaQuickfixProvider() {
    TypeReference _quickfixProviderClass = this.getQuickfixProviderClass(this.getGrammar());
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
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = QuickfixProviderFragment2.this.getQuickfixProviderClass(QuickfixProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _quickfixProviderSuperClass = QuickfixProviderFragment2.this.getQuickfixProviderSuperClass(QuickfixProviderFragment2.this.getGrammar());
        _builder.append(_quickfixProviderSuperClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("//\t@Fix(");
        String _simpleName_1 = QuickfixProviderFragment2.this._validatorNaming.getValidatorClass(QuickfixProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName_1);
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
    this.fileAccessFactory.createJavaFile(_quickfixProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected boolean addRegistrationToPluginXml() {
    boolean _xblockexpression = false;
    {
      String _name = this.getProjectConfig().getEclipsePlugin().getName();
      String _plus = (_name + ".");
      String _lowerCase = GrammarUtil.getSimpleName(this.getGrammar()).toLowerCase();
      final String markerTypePrefix = (_plus + _lowerCase);
      final TypeReference executableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- quickfix marker resolution generator for ");
      String _name_1 = this.getGrammar().getName();
      _builder.append(_name_1);
      _builder.append(" -->");
      _builder.newLineIfNotEmpty();
      _builder.append("<extension");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("point=\"org.eclipse.ui.ide.markerResolution\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<markerResolutionGenerator");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      _builder.append(executableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("markerType=\"");
      _builder.append(markerTypePrefix, "\t\t");
      _builder.append(".check.fast\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("<attribute");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("name=\"FIXABLE_KEY\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("value=\"true\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</attribute>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</markerResolutionGenerator>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<markerResolutionGenerator");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      _builder.append(executableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("markerType=\"");
      _builder.append(markerTypePrefix, "\t\t");
      _builder.append(".check.normal\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("<attribute");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("name=\"FIXABLE_KEY\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("value=\"true\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</attribute>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</markerResolutionGenerator>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<markerResolutionGenerator");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      _builder.append(executableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("markerType=\"");
      _builder.append(markerTypePrefix, "\t\t");
      _builder.append(".check.expensive\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("<attribute");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("name=\"FIXABLE_KEY\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("value=\"true\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</attribute>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</markerResolutionGenerator>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _xblockexpression = _entries.add(_builder.toString());
    }
    return _xblockexpression;
  }
}
