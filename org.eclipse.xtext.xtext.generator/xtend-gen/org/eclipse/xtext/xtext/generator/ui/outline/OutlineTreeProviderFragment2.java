/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ui.outline;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class OutlineTreeProviderFragment2 extends AbstractStubGeneratingFragment {
  @Inject
  private FileAccessFactory fileAccessFactory;

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  protected TypeReference getOutlineTreeProviderClass(final Grammar grammar) {
    String _eclipsePluginBasePackage = this._xtextGeneratorNaming.getEclipsePluginBasePackage(grammar);
    String _plus = (_eclipsePluginBasePackage + ".outline.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "OutlineTreeProvider");
    return new TypeReference(_plus_2);
  }

  @Override
  public void generate() {
    ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _requiredBundles = this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.ui");
    }
    boolean _isGenerateStub = this.isGenerateStub();
    boolean _not = (!_isGenerateStub);
    if (_not) {
      return;
    }
    IXtextGeneratorFileSystemAccess _src = this.getProjectConfig().getEclipsePlugin().getSrc();
    boolean _tripleNotEquals_1 = (_src != null);
    if (_tripleNotEquals_1) {
      boolean _isGenerateXtendStub = this.isGenerateXtendStub();
      if (_isGenerateXtendStub) {
        this.generateXtendOutlineTreeProvider();
      } else {
        this.generateJavaOutlineTreeProvider();
      }
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeReference, 
      this.getOutlineTreeProviderClass(this.getGrammar()));
    TypeReference _typeReference_1 = new TypeReference("org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider");
    _addTypeToType.addTypeToType(_typeReference_1, 
      this.getOutlineTreeProviderClass(this.getGrammar())).contributeTo(this.getLanguage().getEclipsePluginGenModule());
  }

  protected void generateJavaOutlineTreeProvider() {
    TypeReference _outlineTreeProviderClass = this.getOutlineTreeProviderClass(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Customization of the default outline structure.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = OutlineTreeProviderFragment2.this.getOutlineTreeProviderClass(OutlineTreeProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider");
        _builder.append(_typeRef);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createJavaFile(_outlineTreeProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }

  protected void generateXtendOutlineTreeProvider() {
    TypeReference _outlineTreeProviderClass = this.getOutlineTreeProviderClass(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Customization of the default outline structure.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("class ");
        String _simpleName = OutlineTreeProviderFragment2.this.getOutlineTreeProviderClass(OutlineTreeProviderFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider");
        _builder.append(_typeRef);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createXtendFile(_outlineTreeProviderClass, _client).writeTo(this.getProjectConfig().getEclipsePlugin().getSrc());
  }
}
