/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.StringTokenizer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Simple value object class containing all relevant attributes necessary for the creation of new Xtext projects.
 * 
 * @author Michael Clay - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class XtextProjectInfo implements IProjectInfo {
  public final static String GENERATOR = "generator";
  
  public final static String TESTS = "tests";
  
  public final static String IDE = "ide";
  
  public final static String SDK = "sdk";
  
  public final static String UI = "ui";
  
  public final static String WEB = "web";
  
  public final static String INTELLIJ = "idea";
  
  private String projectName;
  
  private String languageName;
  
  private String fileExtension;
  
  private String encoding;
  
  private Iterable<IWorkingSet> workingSets;
  
  private IWorkbench workbench;
  
  private IPath projectsRootLocation;
  
  private boolean createTestProject = false;
  
  private boolean createUiProject;
  
  private boolean createIdeProject;
  
  private boolean createIntellijProject;
  
  private boolean createWebProject;
  
  private boolean createEclipseRuntimeLaunchConfig;
  
  public String getGeneratorProjectName() {
    return this.asProjectName(XtextProjectInfo.GENERATOR);
  }
  
  public String getTestProjectName() {
    return this.asProjectName(XtextProjectInfo.TESTS);
  }
  
  public String getIdeProjectName() {
    return this.asProjectName(XtextProjectInfo.IDE);
  }
  
  public String getFeatureProjectName() {
    return this.asProjectName(XtextProjectInfo.SDK);
  }
  
  public String getUiProjectName() {
    return this.asProjectName(XtextProjectInfo.UI);
  }
  
  public String getIntellijProjectName() {
    return this.asProjectName(XtextProjectInfo.INTELLIJ);
  }
  
  public String getWebProjectName() {
    return this.asProjectName(XtextProjectInfo.WEB);
  }
  
  private String asProjectName(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    String _projectName = this.getProjectName();
    _builder.append(_projectName, "");
    _builder.append(".");
    _builder.append(string, "");
    return _builder.toString();
  }
  
  public String getBasePackagePath() {
    String _basePackage = this.getBasePackage();
    return _basePackage.replaceAll("\\.", "/");
  }
  
  public String getBasePackage() {
    String _languageName = this.getLanguageName();
    int lastIndexOf = _languageName.lastIndexOf(".");
    String _languageName_1 = this.getLanguageName();
    int _xifexpression = (int) 0;
    if ((lastIndexOf == (-1))) {
      String _languageName_2 = this.getLanguageName();
      _xifexpression = _languageName_2.length();
    } else {
      _xifexpression = lastIndexOf;
    }
    return _languageName_1.substring(0, _xifexpression);
  }
  
  public String getLanguageNameAbbreviation() {
    String[] packageNames = this.languageName.split("\\.");
    final String[] _converted_packageNames = (String[])packageNames;
    String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(_converted_packageNames)));
    return Strings.toFirstUpper(_last);
  }
  
  public String getNsURI() {
    String[] strings = this.languageName.split("\\.");
    int _length = strings.length;
    boolean _lessThan = (_length < 2);
    if (_lessThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("http://www.");
      _builder.append(this.languageName, "");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("http://www.");
    String _get = strings[1];
    _builder_1.append(_get, "");
    _builder_1.append(".");
    String _get_1 = strings[0];
    _builder_1.append(_get_1, "");
    String s = _builder_1.toString();
    for (int i = 2; (i < strings.length); i++) {
      String _s = s;
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("/");
      String _get_2 = strings[i];
      _builder_2.append(_get_2, "");
      s = (_s + _builder_2);
    }
    return s;
  }
  
  public String getFirstFileExtension() {
    String delim = ",";
    boolean _and = false;
    String _fileExtension = this.getFileExtension();
    boolean _tripleNotEquals = (_fileExtension != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      String _fileExtension_1 = this.getFileExtension();
      boolean _contains = _fileExtension_1.contains(delim);
      _and = _contains;
    }
    if (_and) {
      String _fileExtension_2 = this.getFileExtension();
      StringTokenizer tokenizer = new StringTokenizer(_fileExtension_2, delim, false);
      boolean _hasMoreTokens = tokenizer.hasMoreTokens();
      if (_hasMoreTokens) {
        String _nextToken = tokenizer.nextToken();
        return _nextToken.trim();
      }
    }
    return this.fileExtension;
  }
  
  public IPath getDslProjectLocation() {
    return this.asLocation(this.projectName);
  }
  
  public IPath getUiProjectLocation() {
    String _uiProjectName = this.getUiProjectName();
    return this.asLocation(_uiProjectName);
  }
  
  public IPath getIdeProjectLocation() {
    String _ideProjectName = this.getIdeProjectName();
    return this.asLocation(_ideProjectName);
  }
  
  public IPath getTestProjectLocation() {
    String _testProjectName = this.getTestProjectName();
    return this.asLocation(_testProjectName);
  }
  
  public IPath getFeatureProjectLocation() {
    String _featureProjectName = this.getFeatureProjectName();
    return this.asLocation(_featureProjectName);
  }
  
  public IPath getIntellijProjectLocation() {
    String _intellijProjectName = this.getIntellijProjectName();
    return this.asLocation(_intellijProjectName);
  }
  
  public IPath getWebProjectLocation() {
    String _webProjectName = this.getWebProjectName();
    return this.asLocation(_webProjectName);
  }
  
  public IPath asLocation(final String projName) {
    return this.projectsRootLocation.append(projName);
  }
  
  public String getGrammarFilePath() {
    StringConcatenation _builder = new StringConcatenation();
    String _basePackagePath = this.getBasePackagePath();
    _builder.append(_basePackagePath, "");
    _builder.append("/");
    String _languageNameAbbreviation = this.getLanguageNameAbbreviation();
    _builder.append(_languageNameAbbreviation, "");
    _builder.append(".xtext");
    return _builder.toString();
  }
  
  @Pure
  public String getProjectName() {
    return this.projectName;
  }
  
  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }
  
  @Pure
  public String getLanguageName() {
    return this.languageName;
  }
  
  public void setLanguageName(final String languageName) {
    this.languageName = languageName;
  }
  
  @Pure
  public String getFileExtension() {
    return this.fileExtension;
  }
  
  public void setFileExtension(final String fileExtension) {
    this.fileExtension = fileExtension;
  }
  
  @Pure
  public String getEncoding() {
    return this.encoding;
  }
  
  public void setEncoding(final String encoding) {
    this.encoding = encoding;
  }
  
  @Pure
  public Iterable<IWorkingSet> getWorkingSets() {
    return this.workingSets;
  }
  
  public void setWorkingSets(final Iterable<IWorkingSet> workingSets) {
    this.workingSets = workingSets;
  }
  
  @Pure
  public IWorkbench getWorkbench() {
    return this.workbench;
  }
  
  public void setWorkbench(final IWorkbench workbench) {
    this.workbench = workbench;
  }
  
  @Pure
  public IPath getProjectsRootLocation() {
    return this.projectsRootLocation;
  }
  
  public void setProjectsRootLocation(final IPath projectsRootLocation) {
    this.projectsRootLocation = projectsRootLocation;
  }
  
  @Pure
  public boolean isCreateTestProject() {
    return this.createTestProject;
  }
  
  public void setCreateTestProject(final boolean createTestProject) {
    this.createTestProject = createTestProject;
  }
  
  @Pure
  public boolean isCreateUiProject() {
    return this.createUiProject;
  }
  
  public void setCreateUiProject(final boolean createUiProject) {
    this.createUiProject = createUiProject;
  }
  
  @Pure
  public boolean isCreateIdeProject() {
    return this.createIdeProject;
  }
  
  public void setCreateIdeProject(final boolean createIdeProject) {
    this.createIdeProject = createIdeProject;
  }
  
  @Pure
  public boolean isCreateIntellijProject() {
    return this.createIntellijProject;
  }
  
  public void setCreateIntellijProject(final boolean createIntellijProject) {
    this.createIntellijProject = createIntellijProject;
  }
  
  @Pure
  public boolean isCreateWebProject() {
    return this.createWebProject;
  }
  
  public void setCreateWebProject(final boolean createWebProject) {
    this.createWebProject = createWebProject;
  }
  
  @Pure
  public boolean isCreateEclipseRuntimeLaunchConfig() {
    return this.createEclipseRuntimeLaunchConfig;
  }
  
  public void setCreateEclipseRuntimeLaunchConfig(final boolean createEclipseRuntimeLaunchConfig) {
    this.createEclipseRuntimeLaunchConfig = createEclipseRuntimeLaunchConfig;
  }
}
