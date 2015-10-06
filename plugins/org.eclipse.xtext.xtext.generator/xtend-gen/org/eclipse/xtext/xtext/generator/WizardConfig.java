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
    boolean _equals = Objects.equal(this.rootPath, null);
    if (_equals) {
      issues.addError("The property \'rootPath\' must be set.", this);
      return;
    }
    boolean _equals_1 = Objects.equal(this.baseName, null);
    if (_equals_1) {
      issues.addError("The property \'baseName\' must be set.", this);
      return;
    }
    IXtextGeneratorFileSystemAccess _runtimeRoot = this.getRuntimeRoot();
    String _path = null;
    if (_runtimeRoot!=null) {
      _path=_runtimeRoot.getPath();
    }
    final String runtimeBase = _path;
    int _length = runtimeBase.length();
    int _minus = (_length - 1);
    char _charAt = runtimeBase.charAt(_minus);
    boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart(_charAt);
    boolean _not = (!_isJavaIdentifierPart);
    if (_not) {
      issues.addError("The runtime root path must end with a valid package name.", this);
    }
    if (((this.ideaEditor || this.webSupport) && (!this.genericIdeSupport))) {
      issues.addError("Generic IDE support must be enabled when the IDEA or web editors are enabled.", this);
    }
  }
  
  @Override
  public void initialize(final Injector injector) {
    String src = "src";
    String testSrc = src;
    String srcGen = "src-gen";
    String testSrcGen = srcGen;
    String metaInf = "META-INF";
    String modelGen = "model/generated";
    String srcWeb = "WebRoot";
    if (this.mavenLayout) {
      src = "src/main/java";
      testSrc = "src/test/java";
      srcGen = "src/main/xtext-gen";
      testSrcGen = "src/test/xtext-gen";
      metaInf = "src/main/resources/META-INF";
      modelGen = "src/main/model-gen";
      srcWeb = "src/main/webapp";
    }
    String _runtimeProjectName = this.getRuntimeProjectName();
    boolean _tripleEquals = (_runtimeProjectName == null);
    if (_tripleEquals) {
      this.setRuntimeProjectName(this.baseName);
    }
    IXtextGeneratorFileSystemAccess _runtimeRoot = this.getRuntimeRoot();
    boolean _tripleEquals_1 = (_runtimeRoot == null);
    if (_tripleEquals_1) {
      String _runtimeProjectName_1 = this.getRuntimeProjectName();
      String _plus = ((this.rootPath + "/") + _runtimeProjectName_1);
      this.setRuntimeRoot(_plus);
    }
    IXtextGeneratorFileSystemAccess _runtimeMetaInf = this.getRuntimeMetaInf();
    boolean _tripleEquals_2 = (_runtimeMetaInf == null);
    if (_tripleEquals_2) {
      IXtextGeneratorFileSystemAccess _runtimeRoot_1 = this.getRuntimeRoot();
      String _path = _runtimeRoot_1.getPath();
      String _plus_1 = (_path + "/");
      String _plus_2 = (_plus_1 + metaInf);
      this.setRuntimeMetaInf(_plus_2);
    }
    IXtextGeneratorFileSystemAccess _runtimeSrc = this.getRuntimeSrc();
    boolean _tripleEquals_3 = (_runtimeSrc == null);
    if (_tripleEquals_3) {
      IXtextGeneratorFileSystemAccess _runtimeRoot_2 = this.getRuntimeRoot();
      String _path_1 = _runtimeRoot_2.getPath();
      String _plus_3 = (_path_1 + "/");
      String _plus_4 = (_plus_3 + src);
      this.setRuntimeSrc(_plus_4);
    }
    IXtextGeneratorFileSystemAccess _runtimeSrcGen = this.getRuntimeSrcGen();
    boolean _tripleEquals_4 = (_runtimeSrcGen == null);
    if (_tripleEquals_4) {
      IXtextGeneratorFileSystemAccess _runtimeRoot_3 = this.getRuntimeRoot();
      String _path_2 = _runtimeRoot_3.getPath();
      String _plus_5 = (_path_2 + "/");
      String _plus_6 = (_plus_5 + srcGen);
      this.setRuntimeSrcGen(_plus_6);
    }
    ManifestAccess _runtimeManifest = this.getRuntimeManifest();
    boolean _tripleEquals_5 = (_runtimeManifest == null);
    if (_tripleEquals_5) {
      ManifestAccess _instance = injector.<ManifestAccess>getInstance(ManifestAccess.class);
      this.setRuntimeManifest(_instance);
    }
    PluginXmlAccess _runtimePluginXml = this.getRuntimePluginXml();
    boolean _tripleEquals_6 = (_runtimePluginXml == null);
    if (_tripleEquals_6) {
      PluginXmlAccess _instance_1 = injector.<PluginXmlAccess>getInstance(PluginXmlAccess.class);
      this.setRuntimePluginXml(_instance_1);
    }
    IXtextGeneratorFileSystemAccess _runtimeModelGen = this.getRuntimeModelGen();
    boolean _tripleEquals_7 = (_runtimeModelGen == null);
    if (_tripleEquals_7) {
      IXtextGeneratorFileSystemAccess _runtimeRoot_4 = this.getRuntimeRoot();
      String _path_3 = _runtimeRoot_4.getPath();
      String _plus_7 = (_path_3 + "/");
      String _plus_8 = (_plus_7 + modelGen);
      this.setRuntimeModelGen(_plus_8);
    }
    if (this.testingSupport) {
      String _runtimeTestProjectName = this.getRuntimeTestProjectName();
      boolean _tripleEquals_8 = (_runtimeTestProjectName == null);
      if (_tripleEquals_8) {
        if (this.mavenLayout) {
          String _runtimeProjectName_2 = this.getRuntimeProjectName();
          this.setRuntimeTestProjectName(_runtimeProjectName_2);
        } else {
          String _runtimeProjectName_3 = this.getRuntimeProjectName();
          String _plus_9 = (_runtimeProjectName_3 + ".tests");
          this.setRuntimeTestProjectName(_plus_9);
        }
      }
      IXtextGeneratorFileSystemAccess _runtimeTestRoot = this.getRuntimeTestRoot();
      boolean _tripleEquals_9 = (_runtimeTestRoot == null);
      if (_tripleEquals_9) {
        String _runtimeTestProjectName_1 = this.getRuntimeTestProjectName();
        String _plus_10 = ((this.rootPath + "/") + _runtimeTestProjectName_1);
        this.setRuntimeTestRoot(_plus_10);
      }
      IXtextGeneratorFileSystemAccess _runtimeTestMetaInf = this.getRuntimeTestMetaInf();
      boolean _tripleEquals_10 = (_runtimeTestMetaInf == null);
      if (_tripleEquals_10) {
        IXtextGeneratorFileSystemAccess _runtimeTestRoot_1 = this.getRuntimeTestRoot();
        String _path_4 = _runtimeTestRoot_1.getPath();
        String _plus_11 = (_path_4 + "/");
        String _plus_12 = (_plus_11 + metaInf);
        this.setRuntimeTestMetaInf(_plus_12);
      }
      IXtextGeneratorFileSystemAccess _runtimeTestSrc = this.getRuntimeTestSrc();
      boolean _tripleEquals_11 = (_runtimeTestSrc == null);
      if (_tripleEquals_11) {
        IXtextGeneratorFileSystemAccess _runtimeTestRoot_2 = this.getRuntimeTestRoot();
        String _path_5 = _runtimeTestRoot_2.getPath();
        String _plus_13 = (_path_5 + "/");
        String _plus_14 = (_plus_13 + testSrc);
        this.setRuntimeTestSrc(_plus_14);
      }
      IXtextGeneratorFileSystemAccess _runtimeTestSrcGen = this.getRuntimeTestSrcGen();
      boolean _tripleEquals_12 = (_runtimeTestSrcGen == null);
      if (_tripleEquals_12) {
        IXtextGeneratorFileSystemAccess _runtimeTestRoot_3 = this.getRuntimeTestRoot();
        String _path_6 = _runtimeTestRoot_3.getPath();
        String _plus_15 = (_path_6 + "/");
        String _plus_16 = (_plus_15 + testSrcGen);
        this.setRuntimeTestSrcGen(_plus_16);
      }
      ManifestAccess _runtimeTestManifest = this.getRuntimeTestManifest();
      boolean _tripleEquals_13 = (_runtimeTestManifest == null);
      if (_tripleEquals_13) {
        ManifestAccess _instance_2 = injector.<ManifestAccess>getInstance(ManifestAccess.class);
        this.setRuntimeTestManifest(_instance_2);
      }
    }
    if (this.eclipseEditor) {
      String _eclipsePluginProjectName = this.getEclipsePluginProjectName();
      boolean _tripleEquals_14 = (_eclipsePluginProjectName == null);
      if (_tripleEquals_14) {
        this.setEclipsePluginProjectName((this.baseName + ".ui"));
      }
      IXtextGeneratorFileSystemAccess _eclipsePluginRoot = this.getEclipsePluginRoot();
      boolean _tripleEquals_15 = (_eclipsePluginRoot == null);
      if (_tripleEquals_15) {
        String _eclipsePluginProjectName_1 = this.getEclipsePluginProjectName();
        String _plus_17 = ((this.rootPath + "/") + _eclipsePluginProjectName_1);
        this.setEclipsePluginRoot(_plus_17);
      }
      IXtextGeneratorFileSystemAccess _eclipsePluginMetaInf = this.getEclipsePluginMetaInf();
      boolean _tripleEquals_16 = (_eclipsePluginMetaInf == null);
      if (_tripleEquals_16) {
        IXtextGeneratorFileSystemAccess _eclipsePluginRoot_1 = this.getEclipsePluginRoot();
        String _path_7 = _eclipsePluginRoot_1.getPath();
        String _plus_18 = (_path_7 + "/");
        String _plus_19 = (_plus_18 + metaInf);
        this.setEclipsePluginMetaInf(_plus_19);
      }
      IXtextGeneratorFileSystemAccess _eclipsePluginSrc = this.getEclipsePluginSrc();
      boolean _tripleEquals_17 = (_eclipsePluginSrc == null);
      if (_tripleEquals_17) {
        IXtextGeneratorFileSystemAccess _eclipsePluginRoot_2 = this.getEclipsePluginRoot();
        String _path_8 = _eclipsePluginRoot_2.getPath();
        String _plus_20 = (_path_8 + "/");
        String _plus_21 = (_plus_20 + src);
        this.setEclipsePluginSrc(_plus_21);
      }
      IXtextGeneratorFileSystemAccess _eclipsePluginSrcGen = this.getEclipsePluginSrcGen();
      boolean _tripleEquals_18 = (_eclipsePluginSrcGen == null);
      if (_tripleEquals_18) {
        IXtextGeneratorFileSystemAccess _eclipsePluginRoot_3 = this.getEclipsePluginRoot();
        String _path_9 = _eclipsePluginRoot_3.getPath();
        String _plus_22 = (_path_9 + "/");
        String _plus_23 = (_plus_22 + srcGen);
        this.setEclipsePluginSrcGen(_plus_23);
      }
      ManifestAccess _eclipsePluginManifest = this.getEclipsePluginManifest();
      boolean _tripleEquals_19 = (_eclipsePluginManifest == null);
      if (_tripleEquals_19) {
        ManifestAccess _instance_3 = injector.<ManifestAccess>getInstance(ManifestAccess.class);
        this.setEclipsePluginManifest(_instance_3);
      }
      PluginXmlAccess _eclipsePluginPluginXml = this.getEclipsePluginPluginXml();
      boolean _tripleEquals_20 = (_eclipsePluginPluginXml == null);
      if (_tripleEquals_20) {
        PluginXmlAccess _instance_4 = injector.<PluginXmlAccess>getInstance(PluginXmlAccess.class);
        this.setEclipsePluginPluginXml(_instance_4);
      }
      if (this.testingSupport) {
        String _eclipsePluginTestProjectName = this.getEclipsePluginTestProjectName();
        boolean _tripleEquals_21 = (_eclipsePluginTestProjectName == null);
        if (_tripleEquals_21) {
          String _eclipsePluginProjectName_2 = this.getEclipsePluginProjectName();
          String _plus_24 = (_eclipsePluginProjectName_2 + ".tests");
          this.setEclipsePluginTestProjectName(_plus_24);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot = this.getEclipsePluginTestRoot();
        boolean _tripleEquals_22 = (_eclipsePluginTestRoot == null);
        if (_tripleEquals_22) {
          String _eclipsePluginTestProjectName_1 = this.getEclipsePluginTestProjectName();
          String _plus_25 = ((this.rootPath + "/") + _eclipsePluginTestProjectName_1);
          this.setEclipsePluginTestRoot(_plus_25);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot_1 = this.getEclipsePluginTestRoot();
        boolean _tripleEquals_23 = (_eclipsePluginTestRoot_1 == null);
        if (_tripleEquals_23) {
          IXtextGeneratorFileSystemAccess _eclipsePluginRoot_4 = this.getEclipsePluginRoot();
          String _path_10 = _eclipsePluginRoot_4.getPath();
          String _plus_26 = (_path_10 + ".tests");
          this.setEclipsePluginTestRoot(_plus_26);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestMetaInf = this.getEclipsePluginTestMetaInf();
        boolean _tripleEquals_24 = (_eclipsePluginTestMetaInf == null);
        if (_tripleEquals_24) {
          IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot_2 = this.getEclipsePluginTestRoot();
          String _path_11 = _eclipsePluginTestRoot_2.getPath();
          String _plus_27 = (_path_11 + "/");
          String _plus_28 = (_plus_27 + metaInf);
          this.setEclipsePluginTestMetaInf(_plus_28);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestSrc = this.getEclipsePluginTestSrc();
        boolean _tripleEquals_25 = (_eclipsePluginTestSrc == null);
        if (_tripleEquals_25) {
          IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot_3 = this.getEclipsePluginTestRoot();
          String _path_12 = _eclipsePluginTestRoot_3.getPath();
          String _plus_29 = (_path_12 + "/");
          String _plus_30 = (_plus_29 + testSrc);
          this.setEclipsePluginTestSrc(_plus_30);
        }
        IXtextGeneratorFileSystemAccess _eclipsePluginTestSrcGen = this.getEclipsePluginTestSrcGen();
        boolean _tripleEquals_26 = (_eclipsePluginTestSrcGen == null);
        if (_tripleEquals_26) {
          IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot_4 = this.getEclipsePluginTestRoot();
          String _path_13 = _eclipsePluginTestRoot_4.getPath();
          String _plus_31 = (_path_13 + "/");
          String _plus_32 = (_plus_31 + testSrcGen);
          this.setEclipsePluginTestSrcGen(_plus_32);
        }
        ManifestAccess _eclipsePluginTestManifest = this.getEclipsePluginTestManifest();
        boolean _tripleEquals_27 = (_eclipsePluginTestManifest == null);
        if (_tripleEquals_27) {
          ManifestAccess _instance_5 = injector.<ManifestAccess>getInstance(ManifestAccess.class);
          this.setEclipsePluginTestManifest(_instance_5);
        }
      }
    }
    if (this.ideaEditor) {
      String _ideaPluginProjectName = this.getIdeaPluginProjectName();
      boolean _tripleEquals_28 = (_ideaPluginProjectName == null);
      if (_tripleEquals_28) {
        this.setIdeaPluginProjectName((this.baseName + ".idea"));
      }
      IXtextGeneratorFileSystemAccess _ideaPluginRoot = this.getIdeaPluginRoot();
      boolean _tripleEquals_29 = (_ideaPluginRoot == null);
      if (_tripleEquals_29) {
        String _ideaPluginProjectName_1 = this.getIdeaPluginProjectName();
        String _plus_33 = ((this.rootPath + "/") + _ideaPluginProjectName_1);
        this.setIdeaPluginRoot(_plus_33);
      }
      IXtextGeneratorFileSystemAccess _ideaPluginSrc = this.getIdeaPluginSrc();
      boolean _tripleEquals_30 = (_ideaPluginSrc == null);
      if (_tripleEquals_30) {
        IXtextGeneratorFileSystemAccess _ideaPluginRoot_1 = this.getIdeaPluginRoot();
        String _path_14 = _ideaPluginRoot_1.getPath();
        String _plus_34 = (_path_14 + "/");
        String _plus_35 = (_plus_34 + src);
        this.setIdeaPluginSrc(_plus_35);
      }
      IXtextGeneratorFileSystemAccess _ideaPluginSrcGen = this.getIdeaPluginSrcGen();
      boolean _tripleEquals_31 = (_ideaPluginSrcGen == null);
      if (_tripleEquals_31) {
        IXtextGeneratorFileSystemAccess _ideaPluginRoot_2 = this.getIdeaPluginRoot();
        String _path_15 = _ideaPluginRoot_2.getPath();
        String _plus_36 = (_path_15 + "/");
        String _plus_37 = (_plus_36 + srcGen);
        this.setIdeaPluginSrcGen(_plus_37);
      }
      IXtextGeneratorFileSystemAccess _ideaPluginMetaInf = this.getIdeaPluginMetaInf();
      boolean _tripleEquals_32 = (_ideaPluginMetaInf == null);
      if (_tripleEquals_32) {
        IXtextGeneratorFileSystemAccess _ideaPluginRoot_3 = this.getIdeaPluginRoot();
        String _path_16 = _ideaPluginRoot_3.getPath();
        String _plus_38 = (_path_16 + "/");
        String _plus_39 = (_plus_38 + metaInf);
        this.setIdeaPluginMetaInf(_plus_39);
      }
    }
    if (this.webSupport) {
      String _webProjectName = this.getWebProjectName();
      boolean _tripleEquals_33 = (_webProjectName == null);
      if (_tripleEquals_33) {
        this.setWebProjectName((this.baseName + ".web"));
      }
      IXtextGeneratorFileSystemAccess _webRoot = this.getWebRoot();
      boolean _tripleEquals_34 = (_webRoot == null);
      if (_tripleEquals_34) {
        String _webProjectName_1 = this.getWebProjectName();
        String _plus_40 = ((this.rootPath + "/") + _webProjectName_1);
        this.setWebRoot(_plus_40);
      }
      IXtextGeneratorFileSystemAccess _webSrc = this.getWebSrc();
      boolean _tripleEquals_35 = (_webSrc == null);
      if (_tripleEquals_35) {
        IXtextGeneratorFileSystemAccess _webRoot_1 = this.getWebRoot();
        String _path_17 = _webRoot_1.getPath();
        String _plus_41 = (_path_17 + "/");
        String _plus_42 = (_plus_41 + src);
        this.setWebSrc(_plus_42);
      }
      IXtextGeneratorFileSystemAccess _webSrcGen = this.getWebSrcGen();
      boolean _tripleEquals_36 = (_webSrcGen == null);
      if (_tripleEquals_36) {
        IXtextGeneratorFileSystemAccess _webRoot_2 = this.getWebRoot();
        String _path_18 = _webRoot_2.getPath();
        String _plus_43 = (_path_18 + "/");
        String _plus_44 = (_plus_43 + srcGen);
        this.setWebSrcGen(_plus_44);
      }
      IXtextGeneratorFileSystemAccess _webApp = this.getWebApp();
      boolean _tripleEquals_37 = (_webApp == null);
      if (_tripleEquals_37) {
        IXtextGeneratorFileSystemAccess _webRoot_3 = this.getWebRoot();
        String _path_19 = _webRoot_3.getPath();
        String _plus_45 = (_path_19 + "/");
        String _plus_46 = (_plus_45 + srcWeb);
        this.setWebApp(_plus_46);
      }
    }
    if (this.genericIdeSupport) {
      String _genericIdeProjectName = this.getGenericIdeProjectName();
      boolean _tripleEquals_38 = (_genericIdeProjectName == null);
      if (_tripleEquals_38) {
        this.setGenericIdeProjectName((this.baseName + ".ide"));
      }
      IXtextGeneratorFileSystemAccess _genericIdeRoot = this.getGenericIdeRoot();
      boolean _tripleEquals_39 = (_genericIdeRoot == null);
      if (_tripleEquals_39) {
        String _genericIdeProjectName_1 = this.getGenericIdeProjectName();
        String _plus_47 = ((this.rootPath + "/") + _genericIdeProjectName_1);
        this.setGenericIdeRoot(_plus_47);
      }
      IXtextGeneratorFileSystemAccess _genericIdeMetaInf = this.getGenericIdeMetaInf();
      boolean _tripleEquals_40 = (_genericIdeMetaInf == null);
      if (_tripleEquals_40) {
        IXtextGeneratorFileSystemAccess _genericIdeRoot_1 = this.getGenericIdeRoot();
        String _path_20 = _genericIdeRoot_1.getPath();
        String _plus_48 = (_path_20 + "/");
        String _plus_49 = (_plus_48 + metaInf);
        this.setGenericIdeMetaInf(_plus_49);
      }
      IXtextGeneratorFileSystemAccess _genericIdeSrc = this.getGenericIdeSrc();
      boolean _tripleEquals_41 = (_genericIdeSrc == null);
      if (_tripleEquals_41) {
        IXtextGeneratorFileSystemAccess _genericIdeRoot_2 = this.getGenericIdeRoot();
        String _path_21 = _genericIdeRoot_2.getPath();
        String _plus_50 = (_path_21 + "/");
        String _plus_51 = (_plus_50 + src);
        this.setGenericIdeSrc(_plus_51);
      }
      IXtextGeneratorFileSystemAccess _genericIdeSrcGen = this.getGenericIdeSrcGen();
      boolean _tripleEquals_42 = (_genericIdeSrcGen == null);
      if (_tripleEquals_42) {
        IXtextGeneratorFileSystemAccess _genericIdeRoot_3 = this.getGenericIdeRoot();
        String _path_22 = _genericIdeRoot_3.getPath();
        String _plus_52 = (_path_22 + "/");
        String _plus_53 = (_plus_52 + srcGen);
        this.setGenericIdeSrcGen(_plus_53);
      }
      ManifestAccess _genericIdeManifest = this.getGenericIdeManifest();
      boolean _tripleEquals_43 = (_genericIdeManifest == null);
      if (_tripleEquals_43) {
        ManifestAccess _instance_6 = injector.<ManifestAccess>getInstance(ManifestAccess.class);
        this.setGenericIdeManifest(_instance_6);
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
  
  @Pure
  public String getRootPath() {
    return this.rootPath;
  }
  
  @Pure
  public String getBaseName() {
    return this.baseName;
  }
}
