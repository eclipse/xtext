/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceFolderDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class SdkFeatureProject extends ProjectDescriptor {
  @Override
  public String getNameQualifier() {
    return ".feature";
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    return false;
  }
  
  @Override
  public boolean isEclipseFeatureProject() {
    return true;
  }
  
  @Override
  public boolean isPartOfGradleBuild() {
    return false;
  }
  
  @Override
  public boolean isPartOfMavenBuild() {
    return true;
  }
  
  @Override
  public boolean isEnabled() {
    return ((super.isEnabled() && this.getConfig().getRuntimeProject().isEclipsePluginProject()) || 
      this.getConfig().getP2Project().isEnabled());
  }
  
  @Override
  public Iterable<? extends AbstractFile> getFiles() {
    ArrayList<AbstractFile> _xblockexpression = null;
    {
      final ArrayList<AbstractFile> files = CollectionLiterals.<AbstractFile>newArrayList();
      Iterable<? extends AbstractFile> _files = super.getFiles();
      Iterables.<AbstractFile>addAll(files, _files);
      PlainTextFile _file = this.file(Outlet.ROOT, "feature.xml", this.featureXml());
      files.add(_file);
      _xblockexpression = files;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<SourceFolderDescriptor> getSourceFolders() {
    return Collections.<SourceFolderDescriptor>unmodifiableSet(CollectionLiterals.<SourceFolderDescriptor>newHashSet());
  }
  
  @Override
  public Set<String> getBinIncludes() {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("feature.xml"));
  }
  
  /**
   * @since 2.11
   */
  @Override
  public Set<String> getBinExcludes() {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
  }
  
  public CharSequence featureXml() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<feature id=\"");
    String _name = this.getName();
    _builder.append(_name);
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("label=\"");
    String _simpleName = this.getConfig().getLanguage().getSimpleName();
    _builder.append(_simpleName, "\t");
    _builder.append(" Feature \"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("version=\"1.0.0.qualifier\">");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _includedPlugin = this.includedPlugin("");
    _builder.append(_includedPlugin, "\t");
    _builder.newLineIfNotEmpty();
    {
      boolean _isEnabled = this.getConfig().getIdeProject().isEnabled();
      if (_isEnabled) {
        _builder.append("\t");
        CharSequence _includedPlugin_1 = this.includedPlugin(this.getConfig().getIdeProject().getNameQualifier());
        _builder.append(_includedPlugin_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isEnabled_1 = this.getConfig().getUiProject().isEnabled();
      if (_isEnabled_1) {
        _builder.append("\t");
        CharSequence _includedPlugin_2 = this.includedPlugin(this.getConfig().getUiProject().getNameQualifier());
        _builder.append(_includedPlugin_2, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</feature>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence includedPlugin(final String qualifier) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<plugin");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _baseName = this.getConfig().getBaseName();
    String _plus = (_baseName + qualifier);
    _builder.append(_plus, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("download-size=\"0\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("install-size=\"0\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("version=\"0.0.0\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("unpack=\"false\"/>");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    throw new UnsupportedOperationException("Eclipse features are not yet supported in Gradle");
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = (PomFile it) -> {
      it.setPackaging("eclipse-feature");
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public SdkFeatureProject(final WizardConfiguration config) {
    super(config);
  }
}
