/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.WebProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

/**
 * @noextend
 */
@Accessors
@SuppressWarnings("all")
public class StandardProjectConfig extends XtextProjectConfig {
  /**
   * set to {@code true} by the project wizard(s) in case "Maven/Gradle" source layout is selected.
   */
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
          String _computeName = StandardProjectConfig.this.computeName(it);
          it.setName(_computeName);
        }
        String _rootPath = it.getRootPath();
        boolean _tripleEquals_1 = (_rootPath == null);
        if (_tripleEquals_1) {
          String _computeRoot = StandardProjectConfig.this.computeRoot(it);
          it.setRoot(_computeRoot);
        }
        String _metaInfPath = it.getMetaInfPath();
        boolean _tripleEquals_2 = (_metaInfPath == null);
        if (_tripleEquals_2) {
          String _computeMetaInf = StandardProjectConfig.this.computeMetaInf(it);
          it.setMetaInf(_computeMetaInf);
        }
        String _srcPath = it.getSrcPath();
        boolean _tripleEquals_3 = (_srcPath == null);
        if (_tripleEquals_3) {
          String _computeSrc = StandardProjectConfig.this.computeSrc(it);
          it.setSrc(_computeSrc);
        }
        String _srcGenPath = it.getSrcGenPath();
        boolean _tripleEquals_4 = (_srcGenPath == null);
        if (_tripleEquals_4) {
          String _computeSrcGen = StandardProjectConfig.this.computeSrcGen(it);
          it.setSrcGen(_computeSrcGen);
        }
        if ((it instanceof BundleProjectConfig)) {
          if (StandardProjectConfig.this.createEclipseMetaData) {
            ManifestAccess _manifest = ((BundleProjectConfig)it).getManifest();
            boolean _tripleEquals_5 = (_manifest == null);
            if (_tripleEquals_5) {
              ManifestAccess _newManifestAccess = StandardProjectConfig.this.newManifestAccess();
              ((BundleProjectConfig)it).setManifest(_newManifestAccess);
            }
            PluginXmlAccess _pluginXml = ((BundleProjectConfig)it).getPluginXml();
            boolean _tripleEquals_6 = (_pluginXml == null);
            if (_tripleEquals_6) {
              PluginXmlAccess _newPluginXmlAccess = StandardProjectConfig.this.newPluginXmlAccess();
              ((BundleProjectConfig)it).setPluginXml(_newPluginXmlAccess);
            }
          }
        }
        if ((it instanceof RuntimeProjectConfig)) {
          String _ecoreModelPath = ((RuntimeProjectConfig)it).getEcoreModelPath();
          boolean _tripleEquals_7 = (_ecoreModelPath == null);
          if (_tripleEquals_7) {
            String _computeEcoreModel = StandardProjectConfig.this.computeEcoreModel(((RuntimeProjectConfig)it));
            ((RuntimeProjectConfig)it).setEcoreModel(_computeEcoreModel);
          }
        }
        if ((it instanceof WebProjectConfig)) {
          String _assetsPath = ((WebProjectConfig)it).getAssetsPath();
          boolean _tripleEquals_8 = (_assetsPath == null);
          if (_tripleEquals_8) {
            String _computeAssets = StandardProjectConfig.this.computeAssets(((WebProjectConfig)it));
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
    RuntimeProjectConfig _runtime = this.getRuntime();
    if (Objects.equal(project, _runtime)) {
      _matched=true;
      _switchResult = this.baseName;
    }
    if (!_matched) {
      BundleProjectConfig _runtimeTest = this.getRuntimeTest();
      if (Objects.equal(project, _runtimeTest)) {
        _matched=true;
        String _xifexpression = null;
        if ((!this.mavenLayout)) {
          _xifexpression = (this.baseName + ".tests");
        } else {
          _xifexpression = this.baseName;
        }
        _switchResult = _xifexpression;
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
        String _xifexpression_1 = null;
        if ((!this.mavenLayout)) {
          _xifexpression_1 = (this.baseName + ".ui.tests");
        } else {
          _xifexpression_1 = (this.baseName + ".ui");
        }
        _switchResult = _xifexpression_1;
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
  
  /**
   * In case of "Maven/Gradle" source layout the src outlet is named 'src/main/java',
   * test classes go into 'src/test/java' instead of any dedicated '...tests' project.
   */
  protected String computeSrc(final SubProjectConfig project) {
    String _rootPath = project.getRootPath();
    String _plus = (_rootPath + "/");
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
  
  /**
   * In case of "Maven/Gradle" source layout the srcGen outlet is named 'src/main/xtext-gen',
   * test-related srcGen classes go into 'src/test/xtext-gen' instead of any dedicated '...tests' project.
   * Don't confuse it with 'src/main/xtend-gen'!
   */
  protected String computeSrcGen(final SubProjectConfig project) {
    String _rootPath = project.getRootPath();
    String _plus = (_rootPath + "/");
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
    String _rootPath = project.getRootPath();
    String _plus = (_rootPath + "/");
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
    String _rootPath = project.getRootPath();
    String _plus = (_rootPath + "/");
    return (_plus + "model/generated");
  }
  
  protected String computeAssets(final WebProjectConfig project) {
    String _rootPath = project.getRootPath();
    String _plus = (_rootPath + "/");
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
