/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.IntellijProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.RuntimeTestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.UiProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WebProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;
import org.eclipse.xtext.xtext.wizard.ecore2xtext.Ecore2XtextGrammarCreator;

@SuppressWarnings("all")
public class RuntimeProjectDescriptor extends TestedProjectDescriptor {
  private final String MWE2_VERSION = "[2.8.2,3.0)";
  
  private final Ecore2XtextGrammarCreator grammarCreator = new Ecore2XtextGrammarCreator();
  
  private final RuntimeTestProjectDescriptor testProject;
  
  public RuntimeProjectDescriptor(final WizardConfiguration config) {
    super(config);
    this.setEnabled(true);
    RuntimeTestProjectDescriptor _runtimeTestProjectDescriptor = new RuntimeTestProjectDescriptor(this);
    this.testProject = _runtimeTestProjectDescriptor;
  }
  
  @Override
  public void setEnabled(final boolean enabled) {
    if ((!enabled)) {
      throw new IllegalArgumentException("The runtime project is always enabled");
    }
    super.setEnabled(enabled);
  }
  
  private String nameQualifier = "";
  
  @Override
  public String getNameQualifier() {
    return this.nameQualifier;
  }
  
  public void setNameQualifier(final String nameQualifier) {
    this.nameQualifier = nameQualifier;
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    boolean _or = false;
    WizardConfiguration _config = this.getConfig();
    BuildSystem _preferredBuildSystem = _config.getPreferredBuildSystem();
    boolean _equals = Objects.equal(_preferredBuildSystem, BuildSystem.NONE);
    if (_equals) {
      _or = true;
    } else {
      WizardConfiguration _config_1 = this.getConfig();
      UiProjectDescriptor _uiProject = _config_1.getUiProject();
      boolean _isEnabled = _uiProject.isEnabled();
      _or = _isEnabled;
    }
    return _or;
  }
  
  @Override
  public boolean isPartOfGradleBuild() {
    return true;
  }
  
  @Override
  public boolean isPartOfMavenBuild() {
    return true;
  }
  
  @Override
  public TestProjectDescriptor getTestProject() {
    return this.testProject;
  }
  
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    LinkedHashSet<ExternalDependency> _xblockexpression = null;
    {
      final LinkedHashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newLinkedHashSet();
      Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
      Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
      ExternalDependency _createXtextDependency = ExternalDependency.createXtextDependency("org.eclipse.xtext");
      deps.add(_createXtextDependency);
      ExternalDependency _createXtextDependency_1 = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase");
      deps.add(_createXtextDependency_1);
      ExternalDependency _externalDependency = new ExternalDependency();
      final Procedure1<ExternalDependency> _function = new Procedure1<ExternalDependency>() {
        @Override
        public void apply(final ExternalDependency it) {
          final Procedure1<ExternalDependency.P2Coordinates> _function = new Procedure1<ExternalDependency.P2Coordinates>() {
            @Override
            public void apply(final ExternalDependency.P2Coordinates it) {
              it.setBundleId("org.eclipse.equinox.common");
              it.setVersion("3.5.0");
            }
          };
          it.p2(_function);
        }
      };
      ExternalDependency _doubleArrow = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency, _function);
      deps.add(_doubleArrow);
      WizardConfiguration _config = this.getConfig();
      Ecore2XtextConfiguration _ecore2Xtext = _config.getEcore2Xtext();
      Set<EPackageInfo> _ePackageInfos = _ecore2Xtext.getEPackageInfos();
      for (final EPackageInfo ePackage : _ePackageInfos) {
        {
          String _bundleID = ePackage.getBundleID();
          ExternalDependency _createBundleDependency = ExternalDependency.createBundleDependency(_bundleID);
          deps.add(_createBundleDependency);
          URI _genmodelURI = ePackage.getGenmodelURI();
          String _fileExtension = _genmodelURI.fileExtension();
          boolean _equals = Objects.equal(_fileExtension, "xcore");
          if (_equals) {
            ExternalDependency _createBundleDependency_1 = ExternalDependency.createBundleDependency("org.eclipse.emf.ecore.xcore");
            deps.add(_createBundleDependency_1);
          }
        }
      }
      boolean _and = false;
      boolean _isEclipsePluginProject = this.isEclipsePluginProject();
      boolean _not = (!_isEclipsePluginProject);
      if (!_not) {
        _and = false;
      } else {
        WizardConfiguration _config_1 = this.getConfig();
        boolean _needsMavenBuild = _config_1.needsMavenBuild();
        _and = _needsMavenBuild;
      }
      if (_and) {
        ExternalDependency _createXtextDependency_2 = ExternalDependency.createXtextDependency("org.eclipse.xtext.xtext");
        final Procedure1<ExternalDependency> _function_1 = new Procedure1<ExternalDependency>() {
          @Override
          public void apply(final ExternalDependency it) {
            ExternalDependency.MavenCoordinates _maven = it.getMaven();
            _maven.setOptional(true);
          }
        };
        ExternalDependency _doubleArrow_1 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency_2, _function_1);
        deps.add(_doubleArrow_1);
        ExternalDependency _createXtextDependency_3 = ExternalDependency.createXtextDependency("org.eclipse.xtext.xtext.generator");
        final Procedure1<ExternalDependency> _function_2 = new Procedure1<ExternalDependency>() {
          @Override
          public void apply(final ExternalDependency it) {
            ExternalDependency.MavenCoordinates _maven = it.getMaven();
            _maven.setOptional(true);
          }
        };
        ExternalDependency _doubleArrow_2 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency_3, _function_2);
        deps.add(_doubleArrow_2);
      }
      _xblockexpression = deps;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<String> getDevelopmentBundles() {
    return CollectionLiterals.<String>newLinkedHashSet(
      "org.eclipse.xtext.xbase", 
      "org.eclipse.xtext.common.types", 
      "org.eclipse.xtext.xtext.generator", 
      "org.eclipse.emf.codegen.ecore", 
      "org.eclipse.emf.mwe.utils", 
      "org.eclipse.emf.mwe2.launch", 
      "org.eclipse.emf.mwe2.lib", 
      "org.objectweb.asm", 
      "org.apache.commons.logging", 
      "org.apache.log4j", 
      "com.ibm.icu");
  }
  
  @Override
  public Set<String> getBinIncludes() {
    LinkedHashSet<String> _xblockexpression = null;
    {
      final LinkedHashSet<String> includes = CollectionLiterals.<String>newLinkedHashSet();
      Set<String> _binIncludes = super.getBinIncludes();
      Iterables.<String>addAll(includes, _binIncludes);
      includes.add("plugin.xml");
      _xblockexpression = includes;
    }
    return _xblockexpression;
  }
  
  @Override
  public Iterable<? extends AbstractFile> getFiles() {
    final ArrayList<AbstractFile> files = CollectionLiterals.<AbstractFile>newArrayList();
    Iterable<? extends AbstractFile> _files = super.getFiles();
    Iterables.<AbstractFile>addAll(files, _files);
    PlainTextFile _grammarFile = this.getGrammarFile();
    files.add(_grammarFile);
    String _workflowFilePath = this.getWorkflowFilePath();
    CharSequence _workflow = this.workflow();
    PlainTextFile _file = this.file(Outlet.MAIN_JAVA, _workflowFilePath, _workflow);
    files.add(_file);
    boolean _isPlainMavenBuild = this.isPlainMavenBuild();
    if (_isPlainMavenBuild) {
      CharSequence _jarDescriptor = this.jarDescriptor();
      PlainTextFile _file_1 = this.file(Outlet.ROOT, "jar-with-ecore-model.xml", _jarDescriptor);
      files.add(_file_1);
    }
    return files;
  }
  
  private boolean isPlainMavenBuild() {
    boolean _and = false;
    WizardConfiguration _config = this.getConfig();
    boolean _needsMavenBuild = _config.needsMavenBuild();
    if (!_needsMavenBuild) {
      _and = false;
    } else {
      boolean _isEclipsePluginProject = this.isEclipsePluginProject();
      boolean _not = (!_isEclipsePluginProject);
      _and = _not;
    }
    return _and;
  }
  
  public PlainTextFile getGrammarFile() {
    String _grammarFilePath = this.getGrammarFilePath();
    CharSequence _grammar = this.grammar();
    return this.file(Outlet.MAIN_JAVA, _grammarFilePath, _grammar);
  }
  
  public String getGrammarFilePath() {
    StringConcatenation _builder = new StringConcatenation();
    WizardConfiguration _config = this.getConfig();
    LanguageDescriptor _language = _config.getLanguage();
    String _basePackagePath = _language.getBasePackagePath();
    _builder.append(_basePackagePath, "");
    _builder.append("/");
    WizardConfiguration _config_1 = this.getConfig();
    LanguageDescriptor _language_1 = _config_1.getLanguage();
    String _simpleName = _language_1.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(".xtext");
    return _builder.toString();
  }
  
  public CharSequence grammar() {
    CharSequence _xifexpression = null;
    boolean _isFromExistingEcoreModels = this.isFromExistingEcoreModels();
    if (_isFromExistingEcoreModels) {
      WizardConfiguration _config = this.getConfig();
      _xifexpression = this.grammarCreator.grammar(_config);
    } else {
      _xifexpression = this.defaultGrammar();
    }
    return _xifexpression;
  }
  
  private CharSequence defaultGrammar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar ");
    WizardConfiguration _config = this.getConfig();
    LanguageDescriptor _language = _config.getLanguage();
    String _name = _language.getName();
    _builder.append(_name, "");
    _builder.append(" with org.eclipse.xtext.common.Terminals");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("generate ");
    WizardConfiguration _config_1 = this.getConfig();
    LanguageDescriptor _language_1 = _config_1.getLanguage();
    String _simpleName = _language_1.getSimpleName();
    String _firstLower = StringExtensions.toFirstLower(_simpleName);
    _builder.append(_firstLower, "");
    _builder.append(" \"");
    WizardConfiguration _config_2 = this.getConfig();
    LanguageDescriptor _language_2 = _config_2.getLanguage();
    String _nsURI = _language_2.getNsURI();
    _builder.append(_nsURI, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("greetings+=Greeting*;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("Greeting:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'Hello\' name=ID \'!\';");
    _builder.newLine();
    return _builder;
  }
  
  public String getWorkflowFilePath() {
    StringConcatenation _builder = new StringConcatenation();
    WizardConfiguration _config = this.getConfig();
    LanguageDescriptor _language = _config.getLanguage();
    String _basePackagePath = _language.getBasePackagePath();
    _builder.append(_basePackagePath, "");
    _builder.append("/Generate");
    WizardConfiguration _config_1 = this.getConfig();
    LanguageDescriptor _language_1 = _config_1.getLanguage();
    String _simpleName = _language_1.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(".mwe2");
    return _builder.toString();
  }
  
  public CharSequence workflow() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module ");
    WizardConfiguration _config = this.getConfig();
    LanguageDescriptor _language = _config.getLanguage();
    String _basePackagePath = _language.getBasePackagePath();
    String _plus = (_basePackagePath + "/Generate");
    WizardConfiguration _config_1 = this.getConfig();
    LanguageDescriptor _language_1 = _config_1.getLanguage();
    String _simpleName = _language_1.getSimpleName();
    String _plus_1 = (_plus + _simpleName);
    String _replaceAll = _plus_1.replaceAll("/", ".");
    _builder.append(_replaceAll, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.*");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xtext.generator.model.project.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("var rootPath = \"..\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Workflow {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component = XtextGenerator {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("configuration = {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("project = StandardProjectConfig {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("baseName = \"");
    String _name = this.getName();
    _builder.append(_name, "\t\t\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("rootPath = rootPath");
    _builder.newLine();
    {
      boolean _isEnabled = this.testProject.isEnabled();
      if (_isEnabled) {
        _builder.append("\t\t\t\t");
        _builder.append("runtimeTest = {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("enabled = true");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      boolean _and = false;
      WizardConfiguration _config_2 = this.getConfig();
      IdeProjectDescriptor _ideProject = _config_2.getIdeProject();
      boolean _isEnabled_1 = _ideProject.isEnabled();
      if (!_isEnabled_1) {
        _and = false;
      } else {
        WizardConfiguration _config_3 = this.getConfig();
        WebProjectDescriptor _webProject = _config_3.getWebProject();
        WizardConfiguration _config_4 = this.getConfig();
        IntellijProjectDescriptor _intellijProject = _config_4.getIntellijProject();
        WizardConfiguration _config_5 = this.getConfig();
        UiProjectDescriptor _uiProject = _config_5.getUiProject();
        final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
          @Override
          public Boolean apply(final ProjectDescriptor it) {
            return Boolean.valueOf(it.isEnabled());
          }
        };
        boolean _exists = IterableExtensions.exists(Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(_webProject, _intellijProject, _uiProject)), _function);
        boolean _not = (!_exists);
        _and = _not;
      }
      if (_and) {
        _builder.append("\t\t\t\t");
        _builder.append("genericIde = {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("enabled = true");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      WizardConfiguration _config_6 = this.getConfig();
      UiProjectDescriptor _uiProject_1 = _config_6.getUiProject();
      boolean _isEnabled_2 = _uiProject_1.isEnabled();
      if (_isEnabled_2) {
        _builder.append("\t\t\t\t");
        _builder.append("eclipsePlugin = {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("enabled = true");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      WizardConfiguration _config_7 = this.getConfig();
      UiProjectDescriptor _uiProject_2 = _config_7.getUiProject();
      TestProjectDescriptor _testProject = _uiProject_2.getTestProject();
      boolean _isEnabled_3 = _testProject.isEnabled();
      if (_isEnabled_3) {
        _builder.append("\t\t\t\t");
        _builder.append("eclipsePluginTest = {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("enabled = true");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      WizardConfiguration _config_8 = this.getConfig();
      IntellijProjectDescriptor _intellijProject_1 = _config_8.getIntellijProject();
      boolean _isEnabled_4 = _intellijProject_1.isEnabled();
      if (_isEnabled_4) {
        _builder.append("\t\t\t\t");
        _builder.append("ideaPlugin = {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("enabled = true");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      WizardConfiguration _config_9 = this.getConfig();
      WebProjectDescriptor _webProject_1 = _config_9.getWebProject();
      boolean _isEnabled_5 = _webProject_1.isEnabled();
      if (_isEnabled_5) {
        _builder.append("\t\t\t\t");
        _builder.append("web = {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("enabled = true");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      WizardConfiguration _config_10 = this.getConfig();
      SourceLayout _sourceLayout = _config_10.getSourceLayout();
      boolean _equals = Objects.equal(_sourceLayout, SourceLayout.MAVEN);
      if (_equals) {
        _builder.append("\t\t\t\t");
        _builder.append("mavenLayout = true");
        _builder.newLine();
      }
    }
    {
      boolean _isEclipsePluginProject = this.isEclipsePluginProject();
      if (_isEclipsePluginProject) {
        _builder.append("\t\t\t\t");
        _builder.append("createEclipseMetaData = true");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("code = {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("encoding = \"");
    WizardConfiguration _config_11 = this.getConfig();
    Charset _encoding = _config_11.getEncoding();
    _builder.append(_encoding, "\t\t\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("fileHeader = \"/*\\n * generated by Xtext \\${version}\\n */\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("language = StandardLanguage {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("name = \"");
    WizardConfiguration _config_12 = this.getConfig();
    LanguageDescriptor _language_2 = _config_12.getLanguage();
    String _name_1 = _language_2.getName();
    _builder.append(_name_1, "\t\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("fileExtensions = \"");
    WizardConfiguration _config_13 = this.getConfig();
    LanguageDescriptor _language_3 = _config_13.getLanguage();
    LanguageDescriptor.FileExtensions _fileExtensions = _language_3.getFileExtensions();
    _builder.append(_fileExtensions, "\t\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      WizardConfiguration _config_14 = this.getConfig();
      Ecore2XtextConfiguration _ecore2Xtext = _config_14.getEcore2Xtext();
      Set<EPackageInfo> _ePackageInfos = _ecore2Xtext.getEPackageInfos();
      boolean _isEmpty = _ePackageInfos.isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("standaloneSetup = {");
        _builder.newLine();
        {
          WizardConfiguration _config_15 = this.getConfig();
          Ecore2XtextConfiguration _ecore2Xtext_1 = _config_15.getEcore2Xtext();
          Set<EPackageInfo> _ePackageInfos_1 = _ecore2Xtext_1.getEPackageInfos();
          final Function1<EPackageInfo, String> _function_1 = new Function1<EPackageInfo, String>() {
            @Override
            public String apply(final EPackageInfo it) {
              URI _genmodelURI = it.getGenmodelURI();
              return _genmodelURI.toString();
            }
          };
          Iterable<String> _map = IterableExtensions.<EPackageInfo, String>map(_ePackageInfos_1, _function_1);
          Set<String> _set = IterableExtensions.<String>toSet(_map);
          for(final String genmodelURI : _set) {
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("loadedResource = \"");
            _builder.append(genmodelURI, "\t\t\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      boolean _isFromExistingEcoreModels = this.isFromExistingEcoreModels();
      if (_isFromExistingEcoreModels) {
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("fragment = ecore2xtext.Ecore2XtextValueConverterServiceFragment2 auto-inject {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("fragment = adapter.FragmentAdapter {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("fragment = ecore2xtext.FormatterFragment {}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("serializer = {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("generateStub = false");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("validator = {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// composedCheck = \"org.eclipse.xtext.validation.NamesAreUniqueValidator\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private boolean isFromExistingEcoreModels() {
    WizardConfiguration _config = this.getConfig();
    Ecore2XtextConfiguration _ecore2Xtext = _config.getEcore2Xtext();
    Set<EPackageInfo> _ePackageInfos = _ecore2Xtext.getEPackageInfos();
    boolean _isEmpty = _ePackageInfos.isEmpty();
    return (!_isEmpty);
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    GradleBuildFile _buildGradle = super.buildGradle();
    final Procedure1<GradleBuildFile> _function = new Procedure1<GradleBuildFile>() {
      @Override
      public void apply(final GradleBuildFile it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("configurations {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("mwe2 {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("extendsFrom compile");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("dependencies {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("mwe2 \"org.eclipse.emf:org.eclipse.emf.mwe2.launch:");
        _builder.append(RuntimeProjectDescriptor.this.MWE2_VERSION, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("mwe2 \"org.eclipse.xtext:org.eclipse.xtext.xtext.generator:${xtextVersion}\"");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("task generateXtextLanguage(type: JavaExec) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("main = \'org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher\'");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("classpath = configurations.mwe2");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("inputs.file \"");
        String _sourceFolder = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_JAVA);
        _builder.append(_sourceFolder, "\t");
        _builder.append("/");
        String _workflowFilePath = RuntimeProjectDescriptor.this.getWorkflowFilePath();
        _builder.append(_workflowFilePath, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("inputs.file \"");
        String _sourceFolder_1 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_JAVA);
        _builder.append(_sourceFolder_1, "\t");
        _builder.append("/");
        String _grammarFilePath = RuntimeProjectDescriptor.this.getGrammarFilePath();
        _builder.append(_grammarFilePath, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("outputs.dir \"");
        String _sourceFolder_2 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_SRC_GEN);
        _builder.append(_sourceFolder_2, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("args += \"");
        String _sourceFolder_3 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_JAVA);
        _builder.append(_sourceFolder_3, "\t");
        _builder.append("/");
        String _workflowFilePath_1 = RuntimeProjectDescriptor.this.getWorkflowFilePath();
        _builder.append(_workflowFilePath_1, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("args += \"-p\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("args += \"rootPath=/${projectDir}/..\"");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("compileXtend.dependsOn(generateXtextLanguage)");
        _builder.newLine();
        _builder.append("clean.dependsOn(cleanGenerateXtextLanguage)");
        _builder.newLine();
        _builder.append("eclipse.classpath.plusConfigurations += [configurations.mwe2]");
        _builder.newLine();
        it.setAdditionalContent(_builder.toString());
      }
    };
    return ObjectExtensions.<GradleBuildFile>operator_doubleArrow(_buildGradle, _function);
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        String _xifexpression = null;
        boolean _isEclipsePluginProject = RuntimeProjectDescriptor.this.isEclipsePluginProject();
        if (_isEclipsePluginProject) {
          _xifexpression = "eclipse-plugin";
        } else {
          _xifexpression = "jar";
        }
        it.setPackaging(_xifexpression);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<build>");
        _builder.newLine();
        {
          boolean _and = false;
          boolean _isEclipsePluginProject_1 = RuntimeProjectDescriptor.this.isEclipsePluginProject();
          boolean _not = (!_isEclipsePluginProject_1);
          if (!_not) {
            _and = false;
          } else {
            WizardConfiguration _config = RuntimeProjectDescriptor.this.getConfig();
            SourceLayout _sourceLayout = _config.getSourceLayout();
            boolean _equals = Objects.equal(_sourceLayout, SourceLayout.PLAIN);
            _and = _equals;
          }
          if (_and) {
            _builder.append("\t");
            _builder.append("<sourceDirectory>");
            String _sourceFolder = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_JAVA);
            _builder.append(_sourceFolder, "\t");
            _builder.append("</sourceDirectory>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<resources>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<resource>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<directory>");
            String _sourceFolder_1 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_RESOURCES);
            _builder.append(_sourceFolder_1, "\t\t\t");
            _builder.append("</directory>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<excludes>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("<exclude>**/*.java</exclude>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("<exclude>**/*.xtend</exclude>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("<exclude>**/*.xtext</exclude>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("<exclude>**/*.mwe2</exclude>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("</excludes>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("</resource>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("</resources>");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("<plugins>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<groupId>org.codehaus.mojo</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<artifactId>exec-maven-plugin</artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<version>1.4.0</version>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<executions>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<execution>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<id>mwe2Launcher</id>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<phase>generate-sources</phase>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<goals>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("<goal>java</goal>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("</goals>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("</execution>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("</executions>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<configuration>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<mainClass>org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher</mainClass>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<arguments>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<argument>/${project.basedir}/");
        String _sourceFolder_2 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_JAVA);
        _builder.append(_sourceFolder_2, "\t\t\t\t\t");
        _builder.append("/");
        String _workflowFilePath = RuntimeProjectDescriptor.this.getWorkflowFilePath();
        _builder.append(_workflowFilePath, "\t\t\t\t\t");
        _builder.append("</argument>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t\t");
        _builder.append("<argument>-p</argument>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<argument>rootPath=/${project.basedir}/..</argument>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("</arguments>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<classpathScope>compile</classpathScope>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<includePluginDependencies>true</includePluginDependencies>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<cleanupDaemonThreads>false</cleanupDaemonThreads><!-- see https://bugs.eclipse.org/bugs/show_bug.cgi?id=475098#c3 -->");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("</configuration>");
        _builder.newLine();
        {
          WizardConfiguration _config_1 = RuntimeProjectDescriptor.this.getConfig();
          boolean _needsTychoBuild = _config_1.needsTychoBuild();
          if (_needsTychoBuild) {
            _builder.append("\t\t\t");
            _builder.append("<dependencies>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("<dependency>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<groupId>org.eclipse.emf</groupId>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<artifactId>org.eclipse.emf.mwe2.launch</artifactId>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<version>");
            _builder.append(RuntimeProjectDescriptor.this.MWE2_VERSION, "\t\t\t\t\t");
            _builder.append("</version>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("</dependency>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("<dependency>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<groupId>org.eclipse.xtext</groupId>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<artifactId>org.eclipse.xtext.xtext.generator</artifactId>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<version>${xtextVersion}</version>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("</dependency>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("<dependency>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<groupId>org.eclipse.xtext</groupId>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<artifactId>org.eclipse.xtext.xbase</artifactId>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("<version>${xtextVersion}</version>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("</dependency>");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("</dependencies>");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<groupId>org.eclipse.xtend</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<artifactId>xtend-maven-plugin</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<groupId>org.apache.maven.plugins</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<artifactId>maven-clean-plugin</artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<configuration>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<filesets combine.children=\"append\">");
        _builder.newLine();
        {
          WizardConfiguration _config_2 = RuntimeProjectDescriptor.this.getConfig();
          IdeProjectDescriptor _ideProject = _config_2.getIdeProject();
          WizardConfiguration _config_3 = RuntimeProjectDescriptor.this.getConfig();
          UiProjectDescriptor _uiProject = _config_3.getUiProject();
          WizardConfiguration _config_4 = RuntimeProjectDescriptor.this.getConfig();
          WebProjectDescriptor _webProject = _config_4.getWebProject();
          for(final ProjectDescriptor p : Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(RuntimeProjectDescriptor.this, _ideProject, _uiProject, _webProject))) {
            {
              boolean _isEnabled = p.isEnabled();
              if (_isEnabled) {
                _builder.append("\t\t\t\t\t");
                _builder.append("<fileset>");
                _builder.newLine();
                _builder.append("\t\t\t\t\t");
                _builder.append("\t");
                _builder.append("<directory>${basedir}/../");
                String _name = p.getName();
                _builder.append(_name, "\t\t\t\t\t\t");
                _builder.append("/");
                String _sourceFolder_3 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_SRC_GEN);
                _builder.append(_sourceFolder_3, "\t\t\t\t\t\t");
                _builder.append("/</directory>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t");
                _builder.append("\t");
                _builder.append("<includes>");
                _builder.newLine();
                _builder.append("\t\t\t\t\t");
                _builder.append("\t\t");
                _builder.append("<include>**/*</include>");
                _builder.newLine();
                _builder.append("\t\t\t\t\t");
                _builder.append("\t");
                _builder.append("</includes>");
                _builder.newLine();
                _builder.append("\t\t\t\t\t");
                _builder.append("</fileset>");
                _builder.newLine();
                {
                  if ((p instanceof TestedProjectDescriptor)) {
                    {
                      TestProjectDescriptor _testProject = ((TestedProjectDescriptor)p).getTestProject();
                      boolean _isEnabled_1 = _testProject.isEnabled();
                      if (_isEnabled_1) {
                        _builder.append("\t\t\t\t\t");
                        _builder.append("<fileset>");
                        _builder.newLine();
                        _builder.append("\t\t\t\t\t");
                        _builder.append("\t");
                        _builder.append("<directory>${basedir}/../");
                        String _xifexpression_1 = null;
                        TestProjectDescriptor _testProject_1 = ((TestedProjectDescriptor)p).getTestProject();
                        boolean _isInlined = _testProject_1.isInlined();
                        if (_isInlined) {
                          _xifexpression_1 = ((TestedProjectDescriptor)p).getName();
                        } else {
                          TestProjectDescriptor _testProject_2 = ((TestedProjectDescriptor)p).getTestProject();
                          _xifexpression_1 = _testProject_2.getName();
                        }
                        _builder.append(_xifexpression_1, "\t\t\t\t\t\t");
                        _builder.append("/");
                        String _sourceFolder_4 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.TEST_SRC_GEN);
                        _builder.append(_sourceFolder_4, "\t\t\t\t\t\t");
                        _builder.append("/</directory>");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t\t\t");
                        _builder.append("\t");
                        _builder.append("<includes>");
                        _builder.newLine();
                        _builder.append("\t\t\t\t\t");
                        _builder.append("\t\t");
                        _builder.append("<include>**/*</include>");
                        _builder.newLine();
                        _builder.append("\t\t\t\t\t");
                        _builder.append("\t");
                        _builder.append("</includes>");
                        _builder.newLine();
                        _builder.append("\t\t\t\t\t");
                        _builder.append("</fileset>");
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
          }
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("<fileset>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("<directory>${basedir}/model/generated/</directory>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("</fileset>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("</filesets>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("</configuration>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        {
          boolean _isEclipsePluginProject_2 = RuntimeProjectDescriptor.this.isEclipsePluginProject();
          boolean _not_1 = (!_isEclipsePluginProject_2);
          if (_not_1) {
            _builder.append("\t\t");
            _builder.append("<plugin>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("<groupId>org.codehaus.mojo</groupId>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("<artifactId>build-helper-maven-plugin</artifactId>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("<version>1.9.1</version>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("<executions>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("<execution>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("<id>add-source</id>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("<phase>initialize</phase>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("<goals>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("<goal>add-source</goal>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("<goal>add-resource</goal>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("</goals>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("<configuration>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("<sources>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<source>");
            String _sourceFolder_5 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_SRC_GEN);
            _builder.append(_sourceFolder_5, "\t\t\t\t\t\t\t");
            _builder.append("</source>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("</sources>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("<resources>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<resource>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("<directory>");
            String _sourceFolder_6 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.MAIN_SRC_GEN);
            _builder.append(_sourceFolder_6, "\t\t\t\t\t\t\t\t");
            _builder.append("</directory>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("<excludes>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("<exclude>**/*.java</exclude>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("<exclude>**/*.g</exclude>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("</excludes>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("</resource>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("</resources>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("</configuration>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("</execution>");
            _builder.newLine();
            {
              boolean _isInlined_1 = RuntimeProjectDescriptor.this.testProject.isInlined();
              if (_isInlined_1) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<execution>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<id>add-test-source</id>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<phase>initialize</phase>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<goals>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<goal>add-test-source</goal>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<goal>add-test-resource</goal>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("</goals>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<configuration>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<sources>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("<source>");
                String _sourceFolder_7 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.TEST_SRC_GEN);
                _builder.append(_sourceFolder_7, "\t\t\t\t\t\t\t");
                _builder.append("</source>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("</sources>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<resources>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("<resource>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t\t\t");
                _builder.append("<directory>");
                String _sourceFolder_8 = RuntimeProjectDescriptor.this.sourceFolder(Outlet.TEST_SRC_GEN);
                _builder.append(_sourceFolder_8, "\t\t\t\t\t\t\t\t");
                _builder.append("</directory>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t\t\t");
                _builder.append("<excludes>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("<exclude>**/*.java</exclude>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t\t\t");
                _builder.append("</excludes>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("</resource>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("</resources>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("</configuration>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("</execution>");
                _builder.newLine();
              }
            }
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("</executions>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("</plugin>");
            _builder.newLine();
            {
              boolean _isPlainMavenBuild = RuntimeProjectDescriptor.this.isPlainMavenBuild();
              if (_isPlainMavenBuild) {
                _builder.append("\t\t");
                _builder.append("<plugin>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<artifactId>maven-assembly-plugin</artifactId>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<version>2.5.5</version>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<configuration>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<descriptors>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("<descriptor>jar-with-ecore-model.xml</descriptor>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("</descriptors>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<appendAssemblyId>false</appendAssemblyId>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("</configuration>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<executions>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("<execution>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("<id>make-assembly</id>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("<phase>package</phase>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("<goals>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t\t");
                _builder.append("<goal>single</goal>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("</goals>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("</execution>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("</executions>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("</plugin>");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("</plugins>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<pluginManagement>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<plugins>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<groupId>org.eclipse.m2e</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<artifactId>lifecycle-mapping</artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<version>1.0.0</version>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<configuration>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<lifecycleMappingMetadata>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("<pluginExecutions>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("<pluginExecution>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("<pluginExecutionFilter>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("<groupId>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t\t");
        _builder.append("org.codehaus.mojo");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("<artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t\t");
        _builder.append("exec-maven-plugin");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("</artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("<versionRange>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t\t");
        _builder.append("[1.2.1,)");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("</versionRange>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("<goals>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t\t");
        _builder.append("<goal>java</goal>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("</goals>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("</pluginExecutionFilter>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("<action>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("<ignore></ignore>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("</action>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("</pluginExecution>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("</pluginExecutions>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("</lifecycleMappingMetadata>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("</configuration>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</plugins>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</pluginManagement>");
        _builder.newLine();
        _builder.append("</build>");
        _builder.newLine();
        it.setBuildSection(_builder.toString());
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public CharSequence jarDescriptor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<assembly xmlns=\"http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.3\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.3 http://maven.apache.org/xsd/assembly-1.1.3.xsd\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<id>jar-with-ecore-model</id>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<formats>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<format>jar</format>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</formats>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<includeBaseDirectory>false</includeBaseDirectory>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<fileSets>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<fileSet>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<outputDirectory>/</outputDirectory>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<directory>target/classes</directory>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</fileSet>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<fileSet>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<outputDirectory>model/generated</outputDirectory>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<directory>model/generated</directory>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</fileSet>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</fileSets>");
    _builder.newLine();
    _builder.append("</assembly>");
    _builder.newLine();
    return _builder;
  }
}
