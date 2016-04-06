/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.UiProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class SdkFeatureProject extends ProjectDescriptor {
  @Override
  public String getNameQualifier() {
    return ".sdk";
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
    WizardConfiguration _config = this.getConfig();
    RuntimeProjectDescriptor _runtimeProject = _config.getRuntimeProject();
    return _runtimeProject.isEclipsePluginProject();
  }
  
  @Override
  public Iterable<? extends AbstractFile> getFiles() {
    ArrayList<AbstractFile> _xblockexpression = null;
    {
      final ArrayList<AbstractFile> files = CollectionLiterals.<AbstractFile>newArrayList();
      Iterable<? extends AbstractFile> _files = super.getFiles();
      Iterables.<AbstractFile>addAll(files, _files);
      CharSequence _featureXml = this.featureXml();
      PlainTextFile _file = this.file(Outlet.ROOT, "feature.xml", _featureXml);
      files.add(_file);
      _xblockexpression = files;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<String> getSourceFolders() {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
  }
  
  @Override
  public Set<String> getBinIncludes() {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("feature.xml"));
  }
  
  public CharSequence featureXml() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<feature id=\"");
    String _name = this.getName();
    _builder.append(_name, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("label=\"");
    WizardConfiguration _config = this.getConfig();
    LanguageDescriptor _language = _config.getLanguage();
    String _simpleName = _language.getSimpleName();
    _builder.append(_simpleName, "\t");
    _builder.append(" SDK Feature \"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("version=\"1.0.0.qualifier\">");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _includedPlugin = this.includedPlugin("");
    _builder.append(_includedPlugin, "\t");
    _builder.newLineIfNotEmpty();
    {
      WizardConfiguration _config_1 = this.getConfig();
      IdeProjectDescriptor _ideProject = _config_1.getIdeProject();
      boolean _isEnabled = _ideProject.isEnabled();
      if (_isEnabled) {
        _builder.append("\t");
        WizardConfiguration _config_2 = this.getConfig();
        IdeProjectDescriptor _ideProject_1 = _config_2.getIdeProject();
        String _nameQualifier = _ideProject_1.getNameQualifier();
        CharSequence _includedPlugin_1 = this.includedPlugin(_nameQualifier);
        _builder.append(_includedPlugin_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      WizardConfiguration _config_3 = this.getConfig();
      UiProjectDescriptor _uiProject = _config_3.getUiProject();
      boolean _isEnabled_1 = _uiProject.isEnabled();
      if (_isEnabled_1) {
        _builder.append("\t");
        WizardConfiguration _config_4 = this.getConfig();
        UiProjectDescriptor _uiProject_1 = _config_4.getUiProject();
        String _nameQualifier_1 = _uiProject_1.getNameQualifier();
        CharSequence _includedPlugin_2 = this.includedPlugin(_nameQualifier_1);
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
    WizardConfiguration _config = this.getConfig();
    String _baseName = _config.getBaseName();
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
    final Procedure1<PomFile> _function = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        it.setPackaging("eclipse-feature");
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public SdkFeatureProject(final WizardConfiguration config) {
    super(config);
  }
}
