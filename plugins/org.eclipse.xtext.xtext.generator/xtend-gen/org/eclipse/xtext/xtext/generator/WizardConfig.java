/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.WebProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

@Accessors
@SuppressWarnings("all")
public class WizardConfig extends XtextProjectConfig {
  private boolean mavenLayout;
  
  private boolean createEclipseMetaData;
  
  private String rootPath;
  
  private String baseName;
  
  @Mandatory
  public String setBaseName(final String baseName) {
    return this.baseName = baseName;
  }
  
  @Mandatory
  public String setRootPath(final String rootPath) {
    return this.rootPath = rootPath;
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    if ((this.rootPath == null)) {
      issues.addError("The property \'rootPath\' must be set", this);
    }
    if ((this.baseName == null)) {
      issues.addError("The property \'baseName\' must be set", this);
    }
  }
  
  @Override
  public void setDefaults() {
    super.setDefaults();
    List<? extends SubProjectConfig> _enabledProjects = this.getEnabledProjects();
    final Procedure1<SubProjectConfig> _function = new Procedure1<SubProjectConfig>() {
      @Override
      public void apply(final SubProjectConfig it) {
        String _name = it.getName();
        boolean _tripleEquals = (_name == null);
        if (_tripleEquals) {
          String _computeName = WizardConfig.this.computeName(it);
          it.setName(_computeName);
        }
        IXtextGeneratorFileSystemAccess _root = it.getRoot();
        boolean _tripleEquals_1 = (_root == null);
        if (_tripleEquals_1) {
          String _computeRoot = WizardConfig.this.computeRoot(it);
          it.setRoot(_computeRoot);
        }
        IXtextGeneratorFileSystemAccess _metaInf = it.getMetaInf();
        boolean _tripleEquals_2 = (_metaInf == null);
        if (_tripleEquals_2) {
          String _computeMetaInf = WizardConfig.this.computeMetaInf(it);
          it.setMetaInf(_computeMetaInf);
        }
        IXtextGeneratorFileSystemAccess _src = it.getSrc();
        boolean _tripleEquals_3 = (_src == null);
        if (_tripleEquals_3) {
          String _computeSrc = WizardConfig.this.computeSrc(it);
          it.setSrc(_computeSrc);
        }
        IXtextGeneratorFileSystemAccess _srcGen = it.getSrcGen();
        boolean _tripleEquals_4 = (_srcGen == null);
        if (_tripleEquals_4) {
          String _computeSrcGen = WizardConfig.this.computeSrcGen(it);
          it.setSrcGen(_computeSrcGen);
        }
        if ((it instanceof BundleProjectConfig)) {
          if (WizardConfig.this.createEclipseMetaData) {
            ManifestAccess _manifest = ((BundleProjectConfig)it).getManifest();
            boolean _tripleEquals_5 = (_manifest == null);
            if (_tripleEquals_5) {
              ManifestAccess _manifestAccess = new ManifestAccess();
              ((BundleProjectConfig)it).setManifest(_manifestAccess);
            }
            PluginXmlAccess _pluginXml = ((BundleProjectConfig)it).getPluginXml();
            boolean _tripleEquals_6 = (_pluginXml == null);
            if (_tripleEquals_6) {
              PluginXmlAccess _pluginXmlAccess = new PluginXmlAccess();
              ((BundleProjectConfig)it).setPluginXml(_pluginXmlAccess);
            }
          }
        }
        if ((it instanceof RuntimeProjectConfig)) {
          IXtextGeneratorFileSystemAccess _ecoreModel = ((RuntimeProjectConfig)it).getEcoreModel();
          boolean _tripleEquals_7 = (_ecoreModel == null);
          if (_tripleEquals_7) {
            String _computeEcoreModel = WizardConfig.this.computeEcoreModel(((RuntimeProjectConfig)it));
            ((RuntimeProjectConfig)it).setEcoreModel(_computeEcoreModel);
          }
        }
        if ((it instanceof WebProjectConfig)) {
          IXtextGeneratorFileSystemAccess _assets = ((WebProjectConfig)it).getAssets();
          boolean _tripleEquals_8 = (_assets == null);
          if (_tripleEquals_8) {
            String _computeAssets = WizardConfig.this.computeAssets(((WebProjectConfig)it));
            ((WebProjectConfig)it).setAssets(_computeAssets);
          }
        }
      }
    };
    IterableExtensions.forEach(_enabledProjects, _function);
  }
  
  protected String computeName(final SubProjectConfig project) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      RuntimeProjectConfig _runtime = this.getRuntime();
      if (Objects.equal(project, _runtime)) {
        _matched=true;
        _switchResult = this.baseName;
      }
    }
    if (!_matched) {
      BundleProjectConfig _runtimeTest = this.getRuntimeTest();
      if (Objects.equal(project, _runtimeTest)) {
        _matched=true;
        _switchResult = (this.baseName + ".tests");
      }
    }
    if (!_matched) {
      BundleProjectConfig _genericIde = this.getGenericIde();
      if (Objects.equal(project, _genericIde)) {
        _matched=true;
        _switchResult = (this.baseName + ".ide");
      }
    }
    if (!_matched) {
      BundleProjectConfig _eclipsePlugin = this.getEclipsePlugin();
      if (Objects.equal(project, _eclipsePlugin)) {
        _matched=true;
        _switchResult = (this.baseName + ".ui");
      }
    }
    if (!_matched) {
      BundleProjectConfig _eclipsePluginTest = this.getEclipsePluginTest();
      if (Objects.equal(project, _eclipsePluginTest)) {
        _matched=true;
        _switchResult = (this.baseName + ".ui.tests");
      }
    }
    if (!_matched) {
      SubProjectConfig _ideaPlugin = this.getIdeaPlugin();
      if (Objects.equal(project, _ideaPlugin)) {
        _matched=true;
        _switchResult = (this.baseName + ".idea");
      }
    }
    if (!_matched) {
      WebProjectConfig _web = this.getWeb();
      if (Objects.equal(project, _web)) {
        _matched=true;
        _switchResult = (this.baseName + ".web");
      }
    }
    return _switchResult;
  }
  
  protected String computeRoot(final SubProjectConfig project) {
    String _name = project.getName();
    return ((this.rootPath + "/") + _name);
  }
  
  protected String computeSrc(final SubProjectConfig project) {
    IXtextGeneratorFileSystemAccess _root = project.getRoot();
    String _path = _root.getPath();
    String _plus = (_path + "/");
    String _xifexpression = null;
    if (this.mavenLayout) {
      String _computeSourceSet = this.computeSourceSet(project);
      String _plus_1 = ("src/" + _computeSourceSet);
      _xifexpression = (_plus_1 + "/java");
    } else {
      _xifexpression = "src";
    }
    return (_plus + _xifexpression);
  }
  
  protected String computeSrcGen(final SubProjectConfig project) {
    IXtextGeneratorFileSystemAccess _root = project.getRoot();
    String _path = _root.getPath();
    String _plus = (_path + "/");
    String _xifexpression = null;
    if (this.mavenLayout) {
      String _computeSourceSet = this.computeSourceSet(project);
      String _plus_1 = ("src/" + _computeSourceSet);
      _xifexpression = (_plus_1 + "/xtext-gen");
    } else {
      _xifexpression = "src-gen";
    }
    return (_plus + _xifexpression);
  }
  
  protected String computeMetaInf(final SubProjectConfig project) {
    IXtextGeneratorFileSystemAccess _root = project.getRoot();
    String _path = _root.getPath();
    String _plus = (_path + "/");
    String _xifexpression = null;
    if (this.mavenLayout) {
      String _computeSourceSet = this.computeSourceSet(project);
      String _plus_1 = ("src/" + _computeSourceSet);
      _xifexpression = (_plus_1 + "/resources/META-INF");
    } else {
      _xifexpression = "META-INF";
    }
    return (_plus + _xifexpression);
  }
  
  protected String computeEcoreModel(final RuntimeProjectConfig project) {
    IXtextGeneratorFileSystemAccess _root = project.getRoot();
    String _path = _root.getPath();
    String _plus = (_path + "/");
    String _xifexpression = null;
    if (this.mavenLayout) {
      String _computeSourceSet = this.computeSourceSet(project);
      String _plus_1 = ("src/" + _computeSourceSet);
      _xifexpression = (_plus_1 + "/ecore/generated");
    } else {
      _xifexpression = "model/generated";
    }
    return (_plus + _xifexpression);
  }
  
  protected String computeAssets(final WebProjectConfig project) {
    IXtextGeneratorFileSystemAccess _root = project.getRoot();
    String _path = _root.getPath();
    String _plus = (_path + "/");
    String _xifexpression = null;
    if (this.mavenLayout) {
      String _computeSourceSet = this.computeSourceSet(project);
      String _plus_1 = ("src/" + _computeSourceSet);
      _xifexpression = (_plus_1 + "/webapp");
    } else {
      _xifexpression = "WebRoot";
    }
    return (_plus + _xifexpression);
  }
  
  protected String computeSourceSet(final SubProjectConfig project) {
    String _xifexpression = null;
    List<? extends SubProjectConfig> _testProjects = this.getTestProjects();
    boolean _contains = _testProjects.contains(project);
    if (_contains) {
      _xifexpression = "test";
    } else {
      _xifexpression = "main";
    }
    return _xifexpression;
  }
  
  @Pure
  public boolean isMavenLayout() {
    return this.mavenLayout;
  }
  
  public void setMavenLayout(final boolean mavenLayout) {
    this.mavenLayout = mavenLayout;
  }
  
  @Pure
  public boolean isCreateEclipseMetaData() {
    return this.createEclipseMetaData;
  }
  
  public void setCreateEclipseMetaData(final boolean createEclipseMetaData) {
    this.createEclipseMetaData = createEclipseMetaData;
  }
  
  @Pure
  public String getRootPath() {
    return this.rootPath;
  }
  
  @Pure
  public String getBaseName() {
    return this.baseName;
  }
}
