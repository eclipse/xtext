/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ExcludeFolder;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import java.util.List;
import org.eclipse.xtend.core.idea.config.GradleBuildFileUtility;
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.config.XtextProjectConfigurator;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.jetbrains.jps.model.JpsElement;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;
import org.jetbrains.jps.model.module.JpsModuleSourceRoot;
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendProjectConfigurator extends XtextProjectConfigurator {
  @Inject
  @Extension
  private GradleBuildFileUtility _gradleBuildFileUtility;
  
  public void setupOutputConfiguration(final ModifiableRootModel rootModel, final XtendFacetConfiguration conf) {
    final Module module = rootModel.getModule();
    final GroovyFile buildFile = this._gradleBuildFileUtility.locateBuildFile(module);
    boolean _and = false;
    boolean _isGradleedModule = this._gradleBuildFileUtility.isGradleedModule(module);
    if (!_isGradleedModule) {
      _and = false;
    } else {
      _and = (buildFile != null);
    }
    if (_and) {
      XbaseGeneratorConfigurationState _state = conf.getState();
      this.presetGradleOutputDirectories(_state, rootModel);
    } else {
      XbaseGeneratorConfigurationState _state_1 = conf.getState();
      this.presetPlainJavaOutputDirectories(_state_1, rootModel);
    }
  }
  
  public XtendFacetConfiguration createOrGetXtendFacetConf(final Module module) {
    String _iD = XtendLanguage.INSTANCE.getID();
    AbstractFacetConfiguration _createOrGetFacetConf = this.createOrGetFacetConf(module, _iD);
    return ((XtendFacetConfiguration) _createOrGetFacetConf);
  }
  
  public void presetGradleOutputDirectories(final XbaseGeneratorConfigurationState state, final ModifiableRootModel rootModel) {
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _and = false;
        boolean _isTestSource = it.isTestSource();
        boolean _not = (!_isTestSource);
        if (!_not) {
          _and = false;
        } else {
          String _url = it.getUrl();
          boolean _endsWith = _url.endsWith("xtend-gen");
          _and = _endsWith;
        }
        return Boolean.valueOf(_and);
      }
    };
    final VirtualFile existingXtendGen = this.findSourceFolder(rootModel, _function);
    final Function1<SourceFolder, Boolean> _function_1 = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _and = false;
        boolean _isTestSource = it.isTestSource();
        if (!_isTestSource) {
          _and = false;
        } else {
          String _url = it.getUrl();
          boolean _endsWith = _url.endsWith("xtend-gen");
          _and = _endsWith;
        }
        return Boolean.valueOf(_and);
      }
    };
    final VirtualFile existingXtendTestGen = this.findSourceFolder(rootModel, _function_1);
    if (((existingXtendGen != null) || (existingXtendTestGen != null))) {
      VirtualFile _elvis = null;
      if (existingXtendGen != null) {
        _elvis = existingXtendGen;
      } else {
        _elvis = existingXtendTestGen;
      }
      String _path = _elvis.getPath();
      state.setOutputDirectory(_path);
      VirtualFile _elvis_1 = null;
      if (existingXtendTestGen != null) {
        _elvis_1 = existingXtendTestGen;
      } else {
        _elvis_1 = existingXtendGen;
      }
      String _path_1 = _elvis_1.getPath();
      state.setTestOutputDirectory(_path_1);
      return;
    }
    VirtualFile[] _contentRoots = rootModel.getContentRoots();
    VirtualFile _head = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
    final String parentPath = _head.getPath();
    Module _module = rootModel.getModule();
    boolean _isAndroidGradleModule = this._gradleBuildFileUtility.isAndroidGradleModule(_module);
    if (_isAndroidGradleModule) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(parentPath, "");
      _builder.append("/build/generated/source/xtend/debug");
      state.setOutputDirectory(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(parentPath, "");
      _builder_1.append("/build/generated/source/xtend/androidTest/debug");
      state.setTestOutputDirectory(_builder_1.toString());
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(parentPath, "");
      _builder_2.append("/build/xtend-gen/main");
      state.setOutputDirectory(_builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(parentPath, "");
      _builder_3.append("/build/xtend-gen/test");
      state.setTestOutputDirectory(_builder_3.toString());
    }
    Module _module_1 = rootModel.getModule();
    final GroovyFile buildFile = this._gradleBuildFileUtility.locateBuildFile(_module_1);
    if ((buildFile != null)) {
      Project _project = rootModel.getProject();
      List<PsiFile> _newImmutableList = CollectionLiterals.<PsiFile>newImmutableList(buildFile);
      new WriteCommandAction.Simple(_project, "Gradle: Xtend Configuration", ((PsiFile[])Conversions.unwrapArray(_newImmutableList, PsiFile.class))) {
        @Override
        protected void run() throws Throwable {
          Module _module = rootModel.getModule();
          XtendProjectConfigurator.this._gradleBuildFileUtility.setupGradleBuild(_module, buildFile);
        }
      }.execute();
    }
  }
  
  public void presetPlainJavaOutputDirectories(final XbaseGeneratorConfigurationState state, final ModifiableRootModel model) {
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _and = false;
        boolean _isTestSource = it.isTestSource();
        boolean _not = (!_isTestSource);
        if (!_not) {
          _and = false;
        } else {
          VirtualFile _file = it.getFile();
          boolean _exists = false;
          if (_file!=null) {
            _exists=_file.exists();
          }
          _and = _exists;
        }
        return Boolean.valueOf(_and);
      }
    };
    final VirtualFile mainSrc = this.findSourceFolder(model, _function);
    final Function1<SourceFolder, Boolean> _function_1 = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _and = false;
        boolean _isTestSource = it.isTestSource();
        if (!_isTestSource) {
          _and = false;
        } else {
          VirtualFile _file = it.getFile();
          boolean _exists = false;
          if (_file!=null) {
            _exists=_file.exists();
          }
          _and = _exists;
        }
        return Boolean.valueOf(_and);
      }
    };
    final VirtualFile testSrc = this.findSourceFolder(model, _function_1);
    if (((mainSrc == null) && (testSrc == null))) {
      final VirtualFile contentRoot = this.findBestContentRoot(model);
      String _path = contentRoot.getPath();
      String _plus = (_path + Character.valueOf(VfsUtil.VFS_SEPARATOR_CHAR));
      String _plus_1 = (_plus + "xtend-gen");
      state.setOutputDirectory(_plus_1);
      String _outputDirectory = state.getOutputDirectory();
      state.setTestOutputDirectory(_outputDirectory);
    } else {
      String _siblingPath = this.siblingPath(
        ObjectExtensions.<VirtualFile>operator_elvis(mainSrc, testSrc), "xtend-gen");
      state.setOutputDirectory(_siblingPath);
      String _siblingPath_1 = this.siblingPath(
        ObjectExtensions.<VirtualFile>operator_elvis(testSrc, mainSrc), "xtend-gen");
      state.setTestOutputDirectory(_siblingPath_1);
    }
  }
  
  public void createOutputFolders(final ModifiableRootModel rootModel, final XbaseGeneratorConfigurationState state) {
    try {
      String _outputDirectory = state.getOutputDirectory();
      VirtualFile xtendGenMain = VfsUtil.createDirectoryIfMissing(_outputDirectory);
      boolean _notEquals = (!Objects.equal(xtendGenMain, null));
      if (_notEquals) {
        this.addAsSourceFolder(rootModel, xtendGenMain, JavaSourceRootType.SOURCE);
      }
      String _outputDirectory_1 = state.getOutputDirectory();
      String _testOutputDirectory = state.getTestOutputDirectory();
      boolean _notEquals_1 = (!Objects.equal(_outputDirectory_1, _testOutputDirectory));
      if (_notEquals_1) {
        String _testOutputDirectory_1 = state.getTestOutputDirectory();
        VirtualFile xtendGenTest = VfsUtil.createDirectoryIfMissing(_testOutputDirectory_1);
        boolean _notEquals_2 = (!Objects.equal(xtendGenTest, null));
        if (_notEquals_2) {
          this.addAsSourceFolder(rootModel, xtendGenTest, JavaSourceRootType.TEST_SOURCE);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * For single contentRoot use it
   * 	For multiple use first that not contains the module config file
   * 	For any use project baseDir
   */
  private VirtualFile findBestContentRoot(final ModifiableRootModel model) {
    final Module module = model.getModule();
    final VirtualFile[] roots = model.getContentRoots();
    int _size = ((List<VirtualFile>)Conversions.doWrapArray(roots)).size();
    boolean _equals = (_size == 1);
    if (_equals) {
      return roots[0];
    } else {
      int _size_1 = ((List<VirtualFile>)Conversions.doWrapArray(roots)).size();
      boolean _greaterThan = (_size_1 > 1);
      if (_greaterThan) {
        VirtualFile _moduleFile = module.getModuleFile();
        boolean _tripleNotEquals = (_moduleFile != null);
        if (_tripleNotEquals) {
          final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
            @Override
            public Boolean apply(final VirtualFile it) {
              VirtualFile _moduleFile = module.getModuleFile();
              boolean _isAncestor = VfsUtil.isAncestor(it, _moduleFile, true);
              return Boolean.valueOf((!_isAncestor));
            }
          };
          return IterableExtensions.<VirtualFile>findFirst(((Iterable<VirtualFile>)Conversions.doWrapArray(roots)), _function);
        } else {
          return IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(roots)));
        }
      }
    }
    Project _project = model.getProject();
    return _project.getBaseDir();
  }
  
  private VirtualFile findSourceFolder(final ModifiableRootModel rootModel, final Function1<? super SourceFolder, ? extends Boolean> fun) {
    ContentEntry[] _contentEntries = rootModel.getContentEntries();
    final Function1<ContentEntry, Boolean> _function = new Function1<ContentEntry, Boolean>() {
      @Override
      public Boolean apply(final ContentEntry it) {
        SourceFolder[] _sourceFolders = it.getSourceFolders();
        final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
          @Override
          public Boolean apply(final SourceFolder it) {
            return fun.apply(it);
          }
        };
        SourceFolder _findFirst = IterableExtensions.<SourceFolder>findFirst(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)), _function);
        return Boolean.valueOf((_findFirst != null));
      }
    };
    final ContentEntry contnentRoot = IterableExtensions.<ContentEntry>findFirst(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)), _function);
    if ((contnentRoot != null)) {
      SourceFolder[] _sourceFolders = contnentRoot.getSourceFolders();
      SourceFolder _findFirst = IterableExtensions.<SourceFolder>findFirst(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)), ((Function1<? super SourceFolder, Boolean>)fun));
      return _findFirst.getFile();
    }
    return null;
  }
  
  public void addAsSourceFolder(final ModifiableRootModel rootModel, final VirtualFile xtendGenMain, final JavaSourceRootType type) {
    ContentEntry[] _contentEntries = rootModel.getContentEntries();
    final Function1<ContentEntry, Boolean> _function = new Function1<ContentEntry, Boolean>() {
      @Override
      public Boolean apply(final ContentEntry it) {
        VirtualFile _file = it.getFile();
        return Boolean.valueOf(VfsUtil.isAncestor(_file, xtendGenMain, true));
      }
    };
    final ContentEntry contentRoot = IterableExtensions.<ContentEntry>findFirst(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)), _function);
    if ((contentRoot != null)) {
      ExcludeFolder[] _excludeFolders = contentRoot.getExcludeFolders();
      final Function1<ExcludeFolder, Boolean> _function_1 = new Function1<ExcludeFolder, Boolean>() {
        @Override
        public Boolean apply(final ExcludeFolder it) {
          boolean _and = false;
          VirtualFile _file = it.getFile();
          boolean _tripleNotEquals = (_file != null);
          if (!_tripleNotEquals) {
            _and = false;
          } else {
            VirtualFile _file_1 = it.getFile();
            boolean _isAncestor = VfsUtil.isAncestor(_file_1, xtendGenMain, true);
            _and = _isAncestor;
          }
          return Boolean.valueOf(_and);
        }
      };
      final ExcludeFolder excludedParent = IterableExtensions.<ExcludeFolder>findFirst(((Iterable<ExcludeFolder>)Conversions.doWrapArray(_excludeFolders)), _function_1);
      if ((excludedParent != null)) {
        contentRoot.removeExcludeFolder(excludedParent);
      }
      JpsJavaExtensionService _instance = JpsJavaExtensionService.getInstance();
      final JavaSourceRootProperties properties = _instance.createSourceRootProperties("", true);
      SourceFolder[] _sourceFolders = contentRoot.getSourceFolders();
      final Function1<SourceFolder, Boolean> _function_2 = new Function1<SourceFolder, Boolean>() {
        @Override
        public Boolean apply(final SourceFolder it) {
          String _url = it.getUrl();
          String _url_1 = xtendGenMain.getUrl();
          return Boolean.valueOf(VfsUtil.isEqualOrAncestor(_url, _url_1));
        }
      };
      final SourceFolder existingSrc = IterableExtensions.<SourceFolder>findFirst(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)), _function_2);
      if ((existingSrc != null)) {
        JpsModuleSourceRoot _jpsElement = existingSrc.getJpsElement();
        final JpsElement props = _jpsElement.getProperties();
        if ((props instanceof JavaSourceRootProperties)) {
          ((JavaSourceRootProperties)props).applyChanges(properties);
        }
      } else {
        contentRoot.<JavaSourceRootProperties>addSourceFolder(xtendGenMain, type, properties);
      }
    }
  }
  
  private String siblingPath(final VirtualFile sibling, final String path) {
    VirtualFile _parent = sibling.getParent();
    String _path = _parent.getPath();
    String _plus = (_path + Character.valueOf(VfsUtil.VFS_SEPARATOR_CHAR));
    return (_plus + path);
  }
}
