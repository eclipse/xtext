/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.codemining;

import com.google.inject.Inject;
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
 * @Beta
 * @since 2.14
 * @author René Purrio - Initial contribution and API
 */
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
      Set<String> _requiredBundles = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.ui.codemining");
      Set<String> _requiredBundles_1 = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      _requiredBundles_1.add("org.eclipse.ui.workbench.texteditor");
      Set<String> _importedPackages = this.getProjectConfig().getEclipsePlugin().getManifest().getImportedPackages();
      _importedPackages.add("org.eclipse.xtext.ui.codemining");
    }
    ManifestAccess _manifest_1 = this.getProjectConfig().getGenericIde().getManifest();
    boolean _tripleNotEquals_1 = (_manifest_1 != null);
    if (_tripleNotEquals_1) {
      Set<String> _exportedPackages = this.getProjectConfig().getGenericIde().getManifest().getExportedPackages();
      String _string = this.getCodeMiningStrategyClass().skipLast(1).toString();
      _exportedPackages.add(_string);
      Set<String> _requiredBundles_2 = this.getProjectConfig().getGenericIde().getManifest().getRequiredBundles();
      _requiredBundles_2.add("org.eclipse.jface.text");
      Set<String> _requiredBundles_3 = this.getProjectConfig().getGenericIde().getManifest().getRequiredBundles();
      _requiredBundles_3.add("org.eclipse.xtext.ui.codemining");
      Set<String> _requiredBundles_4 = this.getProjectConfig().getGenericIde().getManifest().getRequiredBundles();
      _requiredBundles_4.add("org.eclipse.core.runtime");
      Set<String> _requiredBundles_5 = this.getProjectConfig().getGenericIde().getManifest().getRequiredBundles();
      _requiredBundles_5.add("org.eclipse.swt");
      Set<String> _requiredBundles_6 = this.getProjectConfig().getGenericIde().getManifest().getRequiredBundles();
      _requiredBundles_6.add("org.eclipse.xtext.ui");
      Set<String> _importedPackages_1 = this.getProjectConfig().getGenericIde().getManifest().getImportedPackages();
      _importedPackages_1.add("org.eclipse.xtext.ui.codemining");
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    final Procedure1<GuiceModuleAccess.BindingFactory> _function = (GuiceModuleAccess.BindingFactory it) -> {
      it.addTypeToType(TypeReference.typeRef("org.eclipse.jface.text.codemining.ICodeMiningProvider"), TypeReference.typeRef(this.getCodeMiningStrategyClass().toString()));
      it.addTypeToType(TypeReference.typeRef("org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy"), TypeReference.typeRef("org.eclipse.xtext.ui.codemining.XtextCodeMiningReconcileStrategy"));
      it.contributeTo(this.getLanguage().getEclipsePluginGenModule());
    };
    ObjectExtensions.<GuiceModuleAccess.BindingFactory>operator_doubleArrow(_bindingFactory, _function);
    boolean _isGenerateXtendStub = this.isGenerateXtendStub();
    if (_isGenerateXtendStub) {
      this.generateXtendCodeMiningStrategy();
    } else {
      this.generateJavaCodeMiningStrategy();
    }
    PluginXmlAccess _pluginXml = this.getProjectConfig().getEclipsePlugin().getPluginXml();
    boolean _tripleNotEquals_2 = (_pluginXml != null);
    if (_tripleNotEquals_2) {
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
  
  protected QualifiedName getCodeMiningStrategyClass() {
    String _genericIdeBasePackage = this._xtextGeneratorNaming.getGenericIdeBasePackage(this.getGrammar());
    String _plus = (_genericIdeBasePackage + ".codemining.");
    String _simpleName = GrammarUtil.getSimpleName(this.getGrammar());
    String _plus_1 = (_plus + _simpleName);
    return this._iQualifiedNameConverter.toQualifiedName((_plus_1 + "CodeMiningStrategy"));
  }
  
  protected void generateXtendCodeMiningStrategy() {
    TypeReference _typeRef = TypeReference.typeRef(this.getCodeMiningStrategyClass().toString());
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
        _builder.append("import org.eclipse.xtext.ui.codemining.XtextCodeMiningProvider");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.CancelIndicator");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.IAcceptor");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class ");
        String _lastSegment = CodeMiningFragment.this.getCodeMiningStrategyClass().getLastSegment();
        _builder.append(_lastSegment);
        _builder.append(" extends XtextCodeMiningProvider {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("def override protected void createLineHeaderCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor) throws BadLocationException{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//TODO: implement me");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//example:");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//acceptor.accept(createNewLineHeaderCodeMining(1, document, \"Header annotation\"))");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//if (indicator.isCanceled()) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//\treturn");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def override protected void createLineContentCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor)  throws BadLocationException {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//TODO: implement me");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use acceptor.accept(super.createNewLineContentCodeMining(...)) to add a new code mining to the final list");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//example:");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//acceptor.accept(createNewLineContentCodeMining(5, \" Inline annotation \"))");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//if (indicator.isCanceled()) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//\treturn");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createXtendFile(_typeRef, _client).writeTo(this.getProjectConfig().getGenericIde().getSrc());
  }
  
  protected void generateJavaCodeMiningStrategy() {
    TypeReference _typeRef = TypeReference.typeRef(this.getCodeMiningStrategyClass().toString());
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
        _builder.append("import org.eclipse.xtext.ui.codemining.XtextCodeMiningProvider;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.CancelIndicator;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.util.IAcceptor;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("@SuppressWarnings(\"restriction\")");
        _builder.newLine();
        _builder.append("public class ");
        String _lastSegment = CodeMiningFragment.this.getCodeMiningStrategyClass().getLastSegment();
        _builder.append(_lastSegment);
        _builder.append(" extends XtextCodeMiningProvider {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void createLineHeaderCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor) throws BadLocationException{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//TODO: implement me");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//example:");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//acceptor.accept(createNewLineHeaderCodeMining(1, document, \"Header annotation\"));");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//if (indicator.isCanceled()) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//\treturn;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void createLineContentCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor)  throws BadLocationException {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//TODO: implement me");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use acceptor.accept(super.createNewLineContentCodeMining(...)) to add a new code mining to the final list");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//example:");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//acceptor.accept(createNewLineContentCodeMining(5, \" Inline annotation \"));");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//if (indicator.isCanceled()) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//\treturn;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createJavaFile(_typeRef, _client).writeTo(this.getProjectConfig().getGenericIde().getSrc());
  }
}
