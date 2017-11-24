/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.ui.editor;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

/**
 * @author fstolte - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
public class EditorFragment2 extends AbstractStubGeneratingFragment {
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Override
  public void generate() {
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      IBundleProjectConfig _eclipsePlugin = this.getProjectConfig().getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _srcGen = null;
      if (_eclipsePlugin!=null) {
        _srcGen=_eclipsePlugin.getSrcGen();
      }
      boolean _tripleNotEquals = (_srcGen != null);
      if (_tripleNotEquals) {
        this.generateEditor();
      }
      ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
      boolean _tripleNotEquals_1 = (_manifest != null);
      if (_tripleNotEquals_1) {
        Set<String> _exportedPackages = this.getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages();
        String _packageName = this._xtextGeneratorNaming.getEclipsePluginEditor(this.getGrammar()).getPackageName();
        _exportedPackages.add(_packageName);
      }
    }
  }
  
  protected void generateEditor() {
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(this._xtextGeneratorNaming.getEclipsePluginEditor(this.getGrammar()));
    TypeReference _xifexpression = null;
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(this.getGrammar());
    if (_inheritsXbase) {
      _xifexpression = this._xtextGeneratorNaming.getEclipsePluginXbaseEditor(this.getGrammar());
    } else {
      _xifexpression = this._xtextGeneratorNaming.getEclipsePluginDefaultEditor(this.getGrammar());
    }
    final TypeReference superClass = _xifexpression;
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* This class was generated. Customizations should only happen in a newly");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* introduced subclass.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        String _simpleName = EditorFragment2.this._xtextGeneratorNaming.getEclipsePluginEditor(EditorFragment2.this.getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        _builder.append(superClass);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    file.writeTo(this.getProjectConfig().getEclipsePlugin().getSrcGen());
  }
}
