/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Injector;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.XtextProjectConfig;

@Accessors
@SuppressWarnings("all")
public class WizardConfig extends XtextProjectConfig {
  private String runtimeBase;
  
  private boolean eclipseEditor = true;
  
  private boolean ideaEditor = false;
  
  private boolean orionEditor = false;
  
  private boolean genericIdeSupport = false;
  
  private boolean testingSupport = false;
  
  private boolean mavenLayout = false;
  
  @Mandatory
  public void setRuntimeBase(final String runtimeBase) {
    this.runtimeBase = runtimeBase;
  }
  
  @Override
  public void checkConfiguration(final XtextGenerator generator, final Issues issues) {
    super.checkConfiguration(generator, issues);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.runtimeBase);
    if (_isNullOrEmpty) {
      issues.addError(generator, "The property \'runtimeBase\' must be set.", this);
    }
    int _length = this.runtimeBase.length();
    int _minus = (_length - 1);
    char _charAt = this.runtimeBase.charAt(_minus);
    boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart(_charAt);
    boolean _not = (!_isJavaIdentifierPart);
    if (_not) {
      issues.addError(generator, "The runtime base path must end with a valid package name.", this);
    }
    if (((this.ideaEditor || this.orionEditor) && (!this.genericIdeSupport))) {
      issues.addError(generator, "Generic IDE support must be enabled when the IDEA or Orion editors are enabled.", this);
    }
  }
  
  @Override
  public void initialize(final Injector injector) {
    String src = "src";
    String srcGen = "src-gen";
    String srcWeb = "web";
    if (this.mavenLayout) {
      src = "src/main/java";
      srcGen = "src/main/xtext-gen";
      srcWeb = "src/main/webapp";
    }
    IFileSystemAccess2 _runtimeSrc = this.getRuntimeSrc();
    boolean _tripleEquals = (_runtimeSrc == null);
    if (_tripleEquals) {
      this.setRuntimeSrc(((this.runtimeBase + "/") + src));
    }
    IFileSystemAccess2 _runtimeSrcGen = this.getRuntimeSrcGen();
    boolean _tripleEquals_1 = (_runtimeSrcGen == null);
    if (_tripleEquals_1) {
      this.setRuntimeSrcGen(((this.runtimeBase + "/") + srcGen));
    }
    ManifestAccess _runtimeManifest = this.getRuntimeManifest();
    boolean _tripleEquals_2 = (_runtimeManifest == null);
    if (_tripleEquals_2) {
      ManifestAccess _manifestAccess = new ManifestAccess();
      final Procedure1<ManifestAccess> _function = new Procedure1<ManifestAccess>() {
        @Override
        public void apply(final ManifestAccess it) {
          it.setPath((WizardConfig.this.runtimeBase + "/META-INF/MANIFEST.MF"));
        }
      };
      ManifestAccess _doubleArrow = ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifestAccess, _function);
      this.setRuntimeManifest(_doubleArrow);
    }
    PluginXmlAccess _runtimePluginXml = this.getRuntimePluginXml();
    boolean _tripleEquals_3 = (_runtimePluginXml == null);
    if (_tripleEquals_3) {
      PluginXmlAccess _pluginXmlAccess = new PluginXmlAccess();
      final Procedure1<PluginXmlAccess> _function_1 = new Procedure1<PluginXmlAccess>() {
        @Override
        public void apply(final PluginXmlAccess it) {
          it.setPath((WizardConfig.this.runtimeBase + "/plugin.xml"));
        }
      };
      PluginXmlAccess _doubleArrow_1 = ObjectExtensions.<PluginXmlAccess>operator_doubleArrow(_pluginXmlAccess, _function_1);
      this.setRuntimePluginXml(_doubleArrow_1);
    }
    if (this.eclipseEditor) {
      IFileSystemAccess2 _eclipsePluginSrc = this.getEclipsePluginSrc();
      boolean _tripleEquals_4 = (_eclipsePluginSrc == null);
      if (_tripleEquals_4) {
        this.setEclipsePluginSrc(((this.runtimeBase + ".ui/") + src));
      }
      IFileSystemAccess2 _eclipsePluginSrcGen = this.getEclipsePluginSrcGen();
      boolean _tripleEquals_5 = (_eclipsePluginSrcGen == null);
      if (_tripleEquals_5) {
        this.setEclipsePluginSrcGen(((this.runtimeBase + ".ui/") + srcGen));
      }
      ManifestAccess _eclipsePluginManifest = this.getEclipsePluginManifest();
      boolean _tripleEquals_6 = (_eclipsePluginManifest == null);
      if (_tripleEquals_6) {
        ManifestAccess _manifestAccess_1 = new ManifestAccess();
        final Procedure1<ManifestAccess> _function_2 = new Procedure1<ManifestAccess>() {
          @Override
          public void apply(final ManifestAccess it) {
            it.setPath((WizardConfig.this.runtimeBase + ".ui/META-INF/MANIFEST.MF"));
          }
        };
        ManifestAccess _doubleArrow_2 = ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifestAccess_1, _function_2);
        this.setEclipsePluginManifest(_doubleArrow_2);
      }
      PluginXmlAccess _eclipsePluginPluginXml = this.getEclipsePluginPluginXml();
      boolean _tripleEquals_7 = (_eclipsePluginPluginXml == null);
      if (_tripleEquals_7) {
        PluginXmlAccess _pluginXmlAccess_1 = new PluginXmlAccess();
        final Procedure1<PluginXmlAccess> _function_3 = new Procedure1<PluginXmlAccess>() {
          @Override
          public void apply(final PluginXmlAccess it) {
            it.setPath((WizardConfig.this.runtimeBase + ".ui/plugin.xml"));
          }
        };
        PluginXmlAccess _doubleArrow_3 = ObjectExtensions.<PluginXmlAccess>operator_doubleArrow(_pluginXmlAccess_1, _function_3);
        this.setEclipsePluginPluginXml(_doubleArrow_3);
      }
    }
    if (this.ideaEditor) {
      IFileSystemAccess2 _ideaPluginSrc = this.getIdeaPluginSrc();
      boolean _tripleEquals_8 = (_ideaPluginSrc == null);
      if (_tripleEquals_8) {
        this.setIdeaPluginSrc(((this.runtimeBase + ".idea/") + src));
      }
      IFileSystemAccess2 _ideaPluginSrcGen = this.getIdeaPluginSrcGen();
      boolean _tripleEquals_9 = (_ideaPluginSrcGen == null);
      if (_tripleEquals_9) {
        this.setIdeaPluginSrcGen(((this.runtimeBase + ".idea/") + srcGen));
      }
    }
    if (this.orionEditor) {
      IFileSystemAccess2 _webSrc = this.getWebSrc();
      boolean _tripleEquals_10 = (_webSrc == null);
      if (_tripleEquals_10) {
        this.setWebSrc(((this.runtimeBase + ".web/") + src));
      }
      IFileSystemAccess2 _webSrcGen = this.getWebSrcGen();
      boolean _tripleEquals_11 = (_webSrcGen == null);
      if (_tripleEquals_11) {
        this.setWebSrcGen(((this.runtimeBase + ".web/") + srcGen));
      }
      IFileSystemAccess2 _orionJsGen = this.getOrionJsGen();
      boolean _tripleEquals_12 = (_orionJsGen == null);
      if (_tripleEquals_12) {
        this.setOrionJsGen((((this.runtimeBase + ".web/") + srcWeb) + "/xtext/generated"));
      }
    }
    if (this.genericIdeSupport) {
      IFileSystemAccess2 _genericIdeSrc = this.getGenericIdeSrc();
      boolean _tripleEquals_13 = (_genericIdeSrc == null);
      if (_tripleEquals_13) {
        this.setGenericIdeSrc(((this.runtimeBase + ".ide/") + src));
      }
      IFileSystemAccess2 _genericIdeSrcGen = this.getGenericIdeSrcGen();
      boolean _tripleEquals_14 = (_genericIdeSrcGen == null);
      if (_tripleEquals_14) {
        this.setGenericIdeSrcGen(((this.runtimeBase + ".ide/") + srcGen));
      }
      ManifestAccess _genericIdeManifest = this.getGenericIdeManifest();
      boolean _tripleEquals_15 = (_genericIdeManifest == null);
      if (_tripleEquals_15) {
        ManifestAccess _manifestAccess_2 = new ManifestAccess();
        final Procedure1<ManifestAccess> _function_4 = new Procedure1<ManifestAccess>() {
          @Override
          public void apply(final ManifestAccess it) {
            it.setPath((WizardConfig.this.runtimeBase + ".ide/META-INF/MANIFEST.MF"));
          }
        };
        ManifestAccess _doubleArrow_4 = ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifestAccess_2, _function_4);
        this.setGenericIdeManifest(_doubleArrow_4);
      }
    }
    if (this.testingSupport) {
      IFileSystemAccess2 _runtimeTestSrc = this.getRuntimeTestSrc();
      boolean _tripleEquals_16 = (_runtimeTestSrc == null);
      if (_tripleEquals_16) {
        this.setRuntimeTestSrc(((this.runtimeBase + ".tests/") + src));
      }
      IFileSystemAccess2 _runtimeTestSrcGen = this.getRuntimeTestSrcGen();
      boolean _tripleEquals_17 = (_runtimeTestSrcGen == null);
      if (_tripleEquals_17) {
        this.setRuntimeTestSrcGen(((this.runtimeBase + ".tests/") + srcGen));
      }
      ManifestAccess _runtimeTestManifest = this.getRuntimeTestManifest();
      boolean _tripleEquals_18 = (_runtimeTestManifest == null);
      if (_tripleEquals_18) {
        ManifestAccess _manifestAccess_3 = new ManifestAccess();
        final Procedure1<ManifestAccess> _function_5 = new Procedure1<ManifestAccess>() {
          @Override
          public void apply(final ManifestAccess it) {
            it.setPath((WizardConfig.this.runtimeBase + ".tests/META-INF/MANIFEST.MF"));
          }
        };
        ManifestAccess _doubleArrow_5 = ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifestAccess_3, _function_5);
        this.setRuntimeTestManifest(_doubleArrow_5);
      }
      IFileSystemAccess2 _eclipsePluginTestSrc = this.getEclipsePluginTestSrc();
      boolean _tripleEquals_19 = (_eclipsePluginTestSrc == null);
      if (_tripleEquals_19) {
        this.setEclipsePluginTestSrc(((this.runtimeBase + ".tests/") + src));
      }
      IFileSystemAccess2 _eclipsePluginTestSrcGen = this.getEclipsePluginTestSrcGen();
      boolean _tripleEquals_20 = (_eclipsePluginTestSrcGen == null);
      if (_tripleEquals_20) {
        this.setEclipsePluginTestSrcGen(((this.runtimeBase + ".tests/") + srcGen));
      }
      ManifestAccess _eclipsePluginTestManifest = this.getEclipsePluginTestManifest();
      boolean _tripleEquals_21 = (_eclipsePluginTestManifest == null);
      if (_tripleEquals_21) {
        ManifestAccess _manifestAccess_4 = new ManifestAccess();
        final Procedure1<ManifestAccess> _function_6 = new Procedure1<ManifestAccess>() {
          @Override
          public void apply(final ManifestAccess it) {
            it.setPath((WizardConfig.this.runtimeBase + ".tests/META-INF/MANIFEST.MF"));
          }
        };
        ManifestAccess _doubleArrow_6 = ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifestAccess_4, _function_6);
        this.setEclipsePluginTestManifest(_doubleArrow_6);
      }
    }
    super.initialize(injector);
  }
  
  @Pure
  public String getRuntimeBase() {
    return this.runtimeBase;
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
  public boolean isOrionEditor() {
    return this.orionEditor;
  }
  
  public void setOrionEditor(final boolean orionEditor) {
    this.orionEditor = orionEditor;
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
