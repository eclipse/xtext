/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.inject.Injector;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

@Accessors
@SuppressWarnings("all")
public class WizardConfig extends XtextProjectConfig {
  private boolean eclipseEditor = true;
  
  private boolean ideaEditor = false;
  
  private boolean webSupport = false;
  
  private boolean genericIdeSupport = false;
  
  private boolean testingSupport = false;
  
  private boolean mavenLayout = false;
  
  @Mandatory
  @Override
  public void setRuntimeRoot(final String path) {
    super.setRuntimeRoot(path);
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    IXtextGeneratorFileSystemAccess _runtimeRoot = this.getRuntimeRoot();
    String _path = null;
    if (_runtimeRoot!=null) {
      _path=_runtimeRoot.getPath();
    }
    final String runtimeBase = _path;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(runtimeBase);
    if (_isNullOrEmpty) {
      issues.addError("The property \'runtimeBase\' must be set.", this);
    }
    int _length = runtimeBase.length();
    int _minus = (_length - 1);
    char _charAt = runtimeBase.charAt(_minus);
    boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart(_charAt);
    boolean _not = (!_isJavaIdentifierPart);
    if (_not) {
      issues.addError("The runtime base path must end with a valid package name.", this);
    }
    if (((this.ideaEditor || this.webSupport) && (!this.genericIdeSupport))) {
      issues.addError("Generic IDE support must be enabled when the IDEA or Orion editors are enabled.", this);
    }
  }
  
  @Override
  public void initialize(final Injector injector) {
    String src = "src";
    String srcGen = "src-gen";
    String srcWeb = "WebRoot";
    String metaInf = "META-INF";
    if (this.mavenLayout) {
      src = "src/main/java";
      metaInf = "src/main/resources/META-INF";
      srcGen = "src/main/xtext-gen";
      srcWeb = "src/main/webapp";
    }
    IXtextGeneratorFileSystemAccess _runtimeMetaInf = this.getRuntimeMetaInf();
    boolean _tripleEquals = (_runtimeMetaInf == null);
    if (_tripleEquals) {
      IXtextGeneratorFileSystemAccess _runtimeRoot = this.getRuntimeRoot();
      String _path = _runtimeRoot.getPath();
      String _plus = (_path + "/");
      String _plus_1 = (_plus + metaInf);
      this.setRuntimeMetaInf(_plus_1);
    }
    IXtextGeneratorFileSystemAccess _runtimeSrc = this.getRuntimeSrc();
    boolean _tripleEquals_1 = (_runtimeSrc == null);
    if (_tripleEquals_1) {
      IXtextGeneratorFileSystemAccess _runtimeRoot_1 = this.getRuntimeRoot();
      String _path_1 = _runtimeRoot_1.getPath();
      String _plus_2 = (_path_1 + "/");
      String _plus_3 = (_plus_2 + src);
      this.setRuntimeSrc(_plus_3);
    }
    IXtextGeneratorFileSystemAccess _runtimeSrcGen = this.getRuntimeSrcGen();
    boolean _tripleEquals_2 = (_runtimeSrcGen == null);
    if (_tripleEquals_2) {
      IXtextGeneratorFileSystemAccess _runtimeRoot_2 = this.getRuntimeRoot();
      String _path_2 = _runtimeRoot_2.getPath();
      String _plus_4 = (_path_2 + "/");
      String _plus_5 = (_plus_4 + srcGen);
      this.setRuntimeSrcGen(_plus_5);
    }
    ManifestAccess _runtimeManifest = this.getRuntimeManifest();
    boolean _tripleEquals_3 = (_runtimeManifest == null);
    if (_tripleEquals_3) {
      ManifestAccess _manifestAccess = new ManifestAccess();
      this.setRuntimeManifest(_manifestAccess);
    }
    PluginXmlAccess _runtimePluginXml = this.getRuntimePluginXml();
    boolean _tripleEquals_4 = (_runtimePluginXml == null);
    if (_tripleEquals_4) {
      PluginXmlAccess _pluginXmlAccess = new PluginXmlAccess();
      this.setRuntimePluginXml(_pluginXmlAccess);
    }
    if (this.testingSupport) {
      IXtextGeneratorFileSystemAccess _runtimeTestRoot = this.getRuntimeTestRoot();
      boolean _tripleEquals_5 = (_runtimeTestRoot == null);
      if (_tripleEquals_5) {
        IXtextGeneratorFileSystemAccess _runtimeRoot_3 = this.getRuntimeRoot();
        String _path_3 = _runtimeRoot_3.getPath();
        String _plus_6 = (_path_3 + ".tests");
        this.setRuntimeTestRoot(_plus_6);
      }
      IXtextGeneratorFileSystemAccess _runtimeTestMetaInf = this.getRuntimeTestMetaInf();
      boolean _equals = Objects.equal(_runtimeTestMetaInf, null);
      if (_equals) {
        IXtextGeneratorFileSystemAccess _runtimeTestRoot_1 = this.getRuntimeTestRoot();
        String _path_4 = _runtimeTestRoot_1.getPath();
        String _plus_7 = (_path_4 + "/");
        String _plus_8 = (_plus_7 + metaInf);
        this.setRuntimeTestMetaInf(_plus_8);
      }
      IXtextGeneratorFileSystemAccess _runtimeTestSrc = this.getRuntimeTestSrc();
      boolean _tripleEquals_6 = (_runtimeTestSrc == null);
      if (_tripleEquals_6) {
        IXtextGeneratorFileSystemAccess _runtimeTestRoot_2 = this.getRuntimeTestRoot();
        String _path_5 = _runtimeTestRoot_2.getPath();
        String _plus_9 = (_path_5 + "/");
        String _plus_10 = (_plus_9 + src);
        this.setRuntimeTestSrc(_plus_10);
      }
      IXtextGeneratorFileSystemAccess _runtimeTestSrcGen = this.getRuntimeTestSrcGen();
      boolean _tripleEquals_7 = (_runtimeTestSrcGen == null);
      if (_tripleEquals_7) {
        IXtextGeneratorFileSystemAccess _runtimeTestRoot_3 = this.getRuntimeTestRoot();
        String _path_6 = _runtimeTestRoot_3.getPath();
        String _plus_11 = (_path_6 + "/");
        String _plus_12 = (_plus_11 + srcGen);
        this.setRuntimeTestSrcGen(_plus_12);
      }
      ManifestAccess _runtimeTestManifest = this.getRuntimeTestManifest();
      boolean _tripleEquals_8 = (_runtimeTestManifest == null);
      if (_tripleEquals_8) {
        ManifestAccess _manifestAccess_1 = new ManifestAccess();
        this.setRuntimeTestManifest(_manifestAccess_1);
      }
    }
    if (this.eclipseEditor) {
      IXtextGeneratorFileSystemAccess _eclipsePluginRoot = this.getEclipsePluginRoot();
      boolean _tripleEquals_9 = (_eclipsePluginRoot == null);
      if (_tripleEquals_9) {
        IXtextGeneratorFileSystemAccess _runtimeRoot_4 = this.getRuntimeRoot();
        String _path_7 = _runtimeRoot_4.getPath();
        String _plus_13 = (_path_7 + ".ui");
        this.setEclipsePluginRoot(_plus_13);
      }
      IXtextGeneratorFileSystemAccess _eclipsePluginMetaInf = this.getEclipsePluginMetaInf();
      boolean _tripleEquals_10 = (_eclipsePluginMetaInf == null);
      if (_tripleEquals_10) {
        IXtextGeneratorFileSystemAccess _eclipsePluginRoot_1 = this.getEclipsePluginRoot();
        String _path_8 = _eclipsePluginRoot_1.getPath();
        String _plus_14 = (_path_8 + "/");
        String _plus_15 = (_plus_14 + metaInf);
        this.setEclipsePluginMetaInf(_plus_15);
      }
      IXtextGeneratorFileSystemAccess _eclipsePluginSrc = this.getEclipsePluginSrc();
      boolean _tripleEquals_11 = (_eclipsePluginSrc == null);
      if (_tripleEquals_11) {
        IXtextGeneratorFileSystemAccess _eclipsePluginRoot_2 = this.getEclipsePluginRoot();
        String _path_9 = _eclipsePluginRoot_2.getPath();
        String _plus_16 = (_path_9 + "/");
        String _plus_17 = (_plus_16 + src);
        this.setEclipsePluginSrc(_plus_17);
      }
      IXtextGeneratorFileSystemAccess _eclipsePluginSrcGen = this.getEclipsePluginSrcGen();
      boolean _tripleEquals_12 = (_eclipsePluginSrcGen == null);
      if (_tripleEquals_12) {
        IXtextGeneratorFileSystemAccess _eclipsePluginRoot_3 = this.getEclipsePluginRoot();
        String _path_10 = _eclipsePluginRoot_3.getPath();
        String _plus_18 = (_path_10 + "/");
        String _plus_19 = (_plus_18 + srcGen);
        this.setEclipsePluginSrcGen(_plus_19);
      }
      ManifestAccess _eclipsePluginManifest = this.getEclipsePluginManifest();
      boolean _tripleEquals_13 = (_eclipsePluginManifest == null);
      if (_tripleEquals_13) {
        ManifestAccess _manifestAccess_2 = new ManifestAccess();
        this.setEclipsePluginManifest(_manifestAccess_2);
      }
      PluginXmlAccess _eclipsePluginPluginXml = this.getEclipsePluginPluginXml();
      boolean _tripleEquals_14 = (_eclipsePluginPluginXml == null);
      if (_tripleEquals_14) {
        PluginXmlAccess _pluginXmlAccess_1 = new PluginXmlAccess();
        this.setEclipsePluginPluginXml(_pluginXmlAccess_1);
      }
      if (this.testingSupport) {
        IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot = this.getEclipsePluginTestRoot();
        boolean _tripleEquals_15 = (_eclipsePluginTestRoot == null);
        if (_tripleEquals_15) {
          IXtextGeneratorFileSystemAccess _runtimeRoot_5 = this.getRuntimeRoot();
          String _path_11 = _runtimeRoot_5.getPath();
          String _plus_20 = (_path_11 + ".tests");
          this.setEclipsePluginTestRoot(_plus_20);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestMetaInf = this.getEclipsePluginTestMetaInf();
        boolean _tripleEquals_16 = (_eclipsePluginTestMetaInf == null);
        if (_tripleEquals_16) {
          IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot_1 = this.getEclipsePluginTestRoot();
          String _path_12 = _eclipsePluginTestRoot_1.getPath();
          String _plus_21 = (_path_12 + "/");
          String _plus_22 = (_plus_21 + metaInf);
          this.setEclipsePluginTestMetaInf(_plus_22);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestSrc = this.getEclipsePluginTestSrc();
        boolean _tripleEquals_17 = (_eclipsePluginTestSrc == null);
        if (_tripleEquals_17) {
          IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot_2 = this.getEclipsePluginTestRoot();
          String _path_13 = _eclipsePluginTestRoot_2.getPath();
          String _plus_23 = (_path_13 + "/");
          String _plus_24 = (_plus_23 + src);
          this.setEclipsePluginTestSrc(_plus_24);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestSrcGen = this.getEclipsePluginTestSrcGen();
        boolean _tripleEquals_18 = (_eclipsePluginTestSrcGen == null);
        if (_tripleEquals_18) {
          IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot_3 = this.getEclipsePluginTestRoot();
          String _path_14 = _eclipsePluginTestRoot_3.getPath();
          String _plus_25 = (_path_14 + "/");
          String _plus_26 = (_plus_25 + srcGen);
          this.setEclipsePluginTestSrcGen(_plus_26);
        }
        ManifestAccess _eclipsePluginTestManifest = this.getEclipsePluginTestManifest();
        boolean _tripleEquals_19 = (_eclipsePluginTestManifest == null);
        if (_tripleEquals_19) {
          ManifestAccess _manifestAccess_3 = new ManifestAccess();
          this.setEclipsePluginTestManifest(_manifestAccess_3);
        }
      }
    }
    if (this.ideaEditor) {
      IXtextGeneratorFileSystemAccess _ideaPluginRoot = this.getIdeaPluginRoot();
      boolean _tripleEquals_20 = (_ideaPluginRoot == null);
      if (_tripleEquals_20) {
        IXtextGeneratorFileSystemAccess _runtimeRoot_6 = this.getRuntimeRoot();
        String _path_15 = _runtimeRoot_6.getPath();
        String _plus_27 = (_path_15 + ".idea");
        this.setIdeaPluginRoot(_plus_27);
      }
      IXtextGeneratorFileSystemAccess _ideaPluginSrc = this.getIdeaPluginSrc();
      boolean _tripleEquals_21 = (_ideaPluginSrc == null);
      if (_tripleEquals_21) {
        IXtextGeneratorFileSystemAccess _ideaPluginRoot_1 = this.getIdeaPluginRoot();
        String _path_16 = _ideaPluginRoot_1.getPath();
        String _plus_28 = (_path_16 + "/");
        String _plus_29 = (_plus_28 + src);
        this.setIdeaPluginSrc(_plus_29);
      }
      IXtextGeneratorFileSystemAccess _ideaPluginSrcGen = this.getIdeaPluginSrcGen();
      boolean _tripleEquals_22 = (_ideaPluginSrcGen == null);
      if (_tripleEquals_22) {
        IXtextGeneratorFileSystemAccess _ideaPluginRoot_2 = this.getIdeaPluginRoot();
        String _path_17 = _ideaPluginRoot_2.getPath();
        String _plus_30 = (_path_17 + "/");
        String _plus_31 = (_plus_30 + srcGen);
        this.setIdeaPluginSrcGen(_plus_31);
      }
    }
    if (this.webSupport) {
      IXtextGeneratorFileSystemAccess _webRoot = this.getWebRoot();
      boolean _tripleEquals_23 = (_webRoot == null);
      if (_tripleEquals_23) {
        IXtextGeneratorFileSystemAccess _runtimeRoot_7 = this.getRuntimeRoot();
        String _path_18 = _runtimeRoot_7.getPath();
        String _plus_32 = (_path_18 + ".web");
        this.setWebRoot(_plus_32);
      }
      IXtextGeneratorFileSystemAccess _webSrc = this.getWebSrc();
      boolean _tripleEquals_24 = (_webSrc == null);
      if (_tripleEquals_24) {
        IXtextGeneratorFileSystemAccess _webRoot_1 = this.getWebRoot();
        String _path_19 = _webRoot_1.getPath();
        String _plus_33 = (_path_19 + "/");
        String _plus_34 = (_plus_33 + src);
        this.setWebSrc(_plus_34);
      }
      IXtextGeneratorFileSystemAccess _webSrcGen = this.getWebSrcGen();
      boolean _tripleEquals_25 = (_webSrcGen == null);
      if (_tripleEquals_25) {
        IXtextGeneratorFileSystemAccess _webRoot_2 = this.getWebRoot();
        String _path_20 = _webRoot_2.getPath();
        String _plus_35 = (_path_20 + "/");
        String _plus_36 = (_plus_35 + srcGen);
        this.setWebSrcGen(_plus_36);
      }
      IXtextGeneratorFileSystemAccess _webWebApp = this.getWebWebApp();
      boolean _tripleEquals_26 = (_webWebApp == null);
      if (_tripleEquals_26) {
        IXtextGeneratorFileSystemAccess _webRoot_3 = this.getWebRoot();
        String _path_21 = _webRoot_3.getPath();
        String _plus_37 = (_path_21 + "/");
        String _plus_38 = (_plus_37 + srcWeb);
        this.setWebWebApp(_plus_38);
      }
    }
    if (this.genericIdeSupport) {
      IXtextGeneratorFileSystemAccess _genericIdeRoot = this.getGenericIdeRoot();
      boolean _tripleEquals_27 = (_genericIdeRoot == null);
      if (_tripleEquals_27) {
        IXtextGeneratorFileSystemAccess _runtimeRoot_8 = this.getRuntimeRoot();
        String _path_22 = _runtimeRoot_8.getPath();
        String _plus_39 = (_path_22 + ".ide");
        this.setGenericIdeRoot(_plus_39);
      }
      IXtextGeneratorFileSystemAccess _genericIdeMetaInf = this.getGenericIdeMetaInf();
      boolean _tripleEquals_28 = (_genericIdeMetaInf == null);
      if (_tripleEquals_28) {
        IXtextGeneratorFileSystemAccess _genericIdeRoot_1 = this.getGenericIdeRoot();
        String _path_23 = _genericIdeRoot_1.getPath();
        String _plus_40 = (_path_23 + "/");
        String _plus_41 = (_plus_40 + metaInf);
        this.setGenericIdeMetaInf(_plus_41);
      }
      IXtextGeneratorFileSystemAccess _genericIdeSrc = this.getGenericIdeSrc();
      boolean _tripleEquals_29 = (_genericIdeSrc == null);
      if (_tripleEquals_29) {
        IXtextGeneratorFileSystemAccess _genericIdeRoot_2 = this.getGenericIdeRoot();
        String _path_24 = _genericIdeRoot_2.getPath();
        String _plus_42 = (_path_24 + "/");
        String _plus_43 = (_plus_42 + src);
        this.setGenericIdeSrc(_plus_43);
      }
      IXtextGeneratorFileSystemAccess _genericIdeSrcGen = this.getGenericIdeSrcGen();
      boolean _tripleEquals_30 = (_genericIdeSrcGen == null);
      if (_tripleEquals_30) {
        IXtextGeneratorFileSystemAccess _genericIdeRoot_3 = this.getGenericIdeRoot();
        String _path_25 = _genericIdeRoot_3.getPath();
        String _plus_44 = (_path_25 + "/");
        String _plus_45 = (_plus_44 + srcGen);
        this.setGenericIdeSrcGen(_plus_45);
      }
      ManifestAccess _genericIdeManifest = this.getGenericIdeManifest();
      boolean _tripleEquals_31 = (_genericIdeManifest == null);
      if (_tripleEquals_31) {
        ManifestAccess _manifestAccess_4 = new ManifestAccess();
        this.setGenericIdeManifest(_manifestAccess_4);
      }
    }
    super.initialize(injector);
  }
  
  @Pure
  public boolean isEclipseEditor() {
    return this.eclipseEditor;
  }
  
  public void setEclipseEditor(final boolean eclipseEditor) {
    this.eclipseEditor = eclipseEditor;
  }
  
  @Pure
  public boolean isIdeaEditor() {
    return this.ideaEditor;
  }
  
  public void setIdeaEditor(final boolean ideaEditor) {
    this.ideaEditor = ideaEditor;
  }
  
  @Pure
  public boolean isWebSupport() {
    return this.webSupport;
  }
  
  public void setWebSupport(final boolean webSupport) {
    this.webSupport = webSupport;
  }
  
  @Pure
  public boolean isGenericIdeSupport() {
    return this.genericIdeSupport;
  }
  
  public void setGenericIdeSupport(final boolean genericIdeSupport) {
    this.genericIdeSupport = genericIdeSupport;
  }
  
  @Pure
  public boolean isTestingSupport() {
    return this.testingSupport;
  }
  
  public void setTestingSupport(final boolean testingSupport) {
    this.testingSupport = testingSupport;
  }
  
  @Pure
  public boolean isMavenLayout() {
    return this.mavenLayout;
  }
  
  public void setMavenLayout(final boolean mavenLayout) {
    this.mavenLayout = mavenLayout;
  }
}
