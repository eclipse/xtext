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
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SdkFeatureProject;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class P2RepositoryProject extends ProjectDescriptor {
  @Override
  public String getNameQualifier() {
    return ".repository";
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    return false;
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
    boolean _and = false;
    boolean _isEnabled = super.isEnabled();
    if (!_isEnabled) {
      _and = false;
    } else {
      WizardConfiguration _config = this.getConfig();
      RuntimeProjectDescriptor _runtimeProject = _config.getRuntimeProject();
      boolean _isEclipsePluginProject = _runtimeProject.isEclipsePluginProject();
      _and = _isEclipsePluginProject;
    }
    return _and;
  }
  
  @Override
  public Iterable<? extends AbstractFile> getFiles() {
    ArrayList<AbstractFile> _xblockexpression = null;
    {
      final ArrayList<AbstractFile> files = CollectionLiterals.<AbstractFile>newArrayList();
      Iterable<? extends AbstractFile> _files = super.getFiles();
      Iterables.<AbstractFile>addAll(files, _files);
      CharSequence _categoryXml = this.categoryXml();
      PlainTextFile _file = this.file(Outlet.ROOT, "category.xml", _categoryXml);
      files.add(_file);
      _xblockexpression = files;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<String> getSourceFolders() {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
  }
  
  public CharSequence categoryXml() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<site>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<feature id=\"");
    WizardConfiguration _config = this.getConfig();
    SdkFeatureProject _sdkProject = _config.getSdkProject();
    String _name = _sdkProject.getName();
    _builder.append(_name, "\t");
    _builder.append("\" version=\"0.0.0\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<category name=\"main\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</feature>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<feature id=\"");
    WizardConfiguration _config_1 = this.getConfig();
    SdkFeatureProject _sdkProject_1 = _config_1.getSdkProject();
    String _name_1 = _sdkProject_1.getName();
    _builder.append(_name_1, "\t");
    _builder.append(".source\" version=\"0.0.0\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<category name=\"main.source\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</feature>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<category-def name=\"main\" label=\"");
    WizardConfiguration _config_2 = this.getConfig();
    LanguageDescriptor _language = _config_2.getLanguage();
    String _simpleName = _language.getSimpleName();
    _builder.append(_simpleName, "\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<category-def name=\"main.source\" label=\"");
    WizardConfiguration _config_3 = this.getConfig();
    LanguageDescriptor _language_1 = _config_3.getLanguage();
    String _simpleName_1 = _language_1.getSimpleName();
    _builder.append(_simpleName_1, "\t");
    _builder.append(" (Sources)\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</site>");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    throw new UnsupportedOperationException("Eclipse repositories are not yet supported in Gradle");
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        it.setPackaging("eclipse-repository");
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public P2RepositoryProject(final WizardConfiguration config) {
    super(config);
  }
}
