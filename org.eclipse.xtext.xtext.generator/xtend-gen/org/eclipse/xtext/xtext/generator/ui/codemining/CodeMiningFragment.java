/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.codemining;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.name.Names;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * This fragment activates code mining functionalities and generates the appropriate stubs.
 * 
 * @author René Purrio - Initial contribution and API
 * @author Karsten Thoms - Review and improvements on initial implementation
 * @since 2.14
 */
@Beta
@SuppressWarnings("all")
public class CodeMiningFragment extends AbstractStubGeneratingFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  @Extension
  private IQualifiedNameConverter _iQualifiedNameConverter;
  
  @Override
  public void generate() {
    ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _importedPackages = this.getProjectConfig().getEclipsePlugin().getManifest().getImportedPackages();
      _importedPackages.add("org.eclipse.xtext.ui.codemining;resolution:=optional");
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    final Procedure1<GuiceModuleAccess.BindingFactory> _function = (GuiceModuleAccess.BindingFactory it) -> {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("try {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("Class.forName(\"org.eclipse.jface.text.codemining.ICodeMiningProvider\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("binder.bind(");
          TypeReference _typeRef = TypeReference.typeRef("org.eclipse.jface.text.codemining.ICodeMiningProvider");
          _builder.append(_typeRef, "\t");
          _builder.append(".class)");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append(".to(");
          TypeReference _typeRef_1 = TypeReference.typeRef(CodeMiningFragment.this.getCodeMiningProviderClass().toString());
          _builder.append(_typeRef_1, "\t\t");
          _builder.append(".class);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("binder.bind(");
          TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.reconciler.IReconcileStrategyFactory");
          _builder.append(_typeRef_2, "\t");
          _builder.append(".class).annotatedWith(");
          TypeReference _typeRef_3 = TypeReference.typeRef(Names.class);
          _builder.append(_typeRef_3, "\t");
          _builder.append(".named(\"codeMinding\"))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append(".to(");
          TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.ui.codemining.XtextCodeMiningReconcileStrategy");
          _builder.append(_typeRef_4, "\t\t");
          _builder.append(".Factory.class);");
          _builder.newLineIfNotEmpty();
          _builder.append("} catch(");
          TypeReference _typeRef_5 = TypeReference.typeRef(ClassNotFoundException.class);
          _builder.append(_typeRef_5);
          _builder.append(" ignore) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("// no bindings if code mining is not available at runtime");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      it.addConfiguredBinding("CodeMinding", _client);
      it.contributeTo(this.getLanguage().getEclipsePluginGenModule());
    };
    ObjectExtensions.<GuiceModuleAccess.BindingFactory>operator_doubleArrow(_bindingFactory, _function);
    boolean _isGenerateXtendStub = this.isGenerateXtendStub();
    if (_isGenerateXtendStub) {
      this.generateXtendCodeMiningProvider();
    } else {
      this.generateJavaCodeMiningProvider();
    }
    PluginXmlAccess _pluginXml = this.getProjectConfig().getEclipsePlugin().getPluginXml();
    boolean _tripleNotEquals_1 = (_pluginXml != null);
    if (_tripleNotEquals_1) {
      List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- code mining -->");
      _builder.newLine();
      _builder.append("<extension point=\"org.eclipse.ui.workbench.texteditor.codeMiningProviders\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<codeMiningProvider");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class=\"");
      TypeReference _eclipsePluginExecutableExtensionFactory = this._xtextGeneratorNaming.getEclipsePluginExecutableExtensionFactory(this.getGrammar());
      _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
      _builder.append(":org.eclipse.jface.text.codemining.ICodeMiningProvider\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("id=\"");
      String _name = this.getGrammar().getName();
      _builder.append(_name, "\t\t");
      _builder.append(".CodeMiningProvider\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("label=\"");
      String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
      _builder.append(_simpleName, "\t\t");
      _builder.append(" Codemining\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("<enabledWhen>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<with variable=\"editorInput\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<adapt type=\"org.eclipse.core.resources.IFile\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("<test");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("property=\"org.eclipse.core.resources.contentTypeId\"");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("value=\"");
      String _name_1 = this.getGrammar().getName();
      _builder.append(_name_1, "\t\t\t\t\t\t");
      _builder.append(".contenttype\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("</test>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("</adapt>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</with>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</enabledWhen>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</codeMiningProvider>");
      _builder.newLine();
      _builder.append("</extension>");
      _builder.newLine();
      _entries.add(_builder.toString());
    }
  }
  
  protected QualifiedName getCodeMiningProviderClass() {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(this.getGrammar());
    String _plus = (_eclipsePluginBasePackage + ".codemining.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    return this._iQualifiedNameConverter.toQualifiedName((_plus_1 + "CodeMiningProvider"));
  }
  
  protected void generateXtendCodeMiningProvider() {
    TypeReference _typeRef = TypeReference.typeRef(this.getCodeMiningProviderClass().toString());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import org.eclipse.jface.text.BadLocationException");
        _builder.newLine();
        _builder.append("import org.eclipse.jface.text.IDocument");
        _builder.newLine();
        _builder.append("import org.eclipse.jface.text.codemining.ICodeMining");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.resource.XtextResource");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.CancelIndicator");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.IAcceptor");
        _builder.newLine();
        _builder.newLine();
        _builder.append("class ");
        String _lastSegment = CodeMiningFragment.this.getCodeMiningProviderClass().getLastSegment();
        _builder.append(_lastSegment);
        _builder.append(" extends AbstractXtextCodeMiningProvider {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("override void createCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator,");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// TODO: implement me");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// example:");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// acceptor.accept(createNewLineHeaderCodeMining(1, document, \"Header annotation\"))");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createXtendFile(_typeRef, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }
  
  protected void generateJavaCodeMiningProvider() {
    TypeReference _typeRef = TypeReference.typeRef(this.getCodeMiningProviderClass().toString());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("import org.eclipse.jface.text.BadLocationException;");
        _builder.newLine();
        _builder.append("import org.eclipse.jface.text.IDocument;");
        _builder.newLine();
        _builder.append("import org.eclipse.jface.text.codemining.ICodeMining;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.resource.XtextResource;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.CancelIndicator;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.IAcceptor;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("@SuppressWarnings(\"restriction\")");
        _builder.newLine();
        _builder.append("public class ");
        String _lastSegment = CodeMiningFragment.this.getCodeMiningProviderClass().getLastSegment();
        _builder.append(_lastSegment);
        _builder.append(" extends AbstractXtextCodeMiningProvider {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void createCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator,");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// TODO: implement me");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// example:");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// acceptor.accept(createNewLineHeaderCodeMining(1, document, \"Header annotation\"));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createJavaFile(_typeRef, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }
}
