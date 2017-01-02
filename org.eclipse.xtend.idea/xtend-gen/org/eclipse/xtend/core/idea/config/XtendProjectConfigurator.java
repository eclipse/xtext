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
import org.jetbrains.jps.model.JpsElement;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;
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
    if ((this._gradleBuildFileUtility.isGradleedModule(module) && (buildFile != null))) {
      this.presetGradleOutputDirectories(conf.getState(), rootModel);
    } else {
      this.presetPlainJavaOutputDirectories(conf.getState(), rootModel);
    }
  }
  
  public XtendFacetConfiguration createOrGetXtendFacetConf(final Module module) {
    AbstractFacetConfiguration _createOrGetFacetConf = this.createOrGetFacetConf(module, XtendLanguage.INSTANCE.getID());
    return ((XtendFacetConfiguration) _createOrGetFacetConf);
  }
  
  public void presetGradleOutputDirectories(final XbaseGeneratorConfigurationState state, final ModifiableRootModel rootModel) {
    final Function1<SourceFolder, Boolean> _function = (SourceFolder it) -> {
      return Boolean.valueOf(((!it.isTestSource()) && it.getUrl().endsWith("xtend-gen")));
    };
    final VirtualFile existingXtendGen = this.findSourceFolder(rootModel, _function);
    final Function1<SourceFolder, Boolean> _function_1 = (SourceFolder it) -> {
      return Boolean.valueOf((it.isTestSource() && it.getUrl().endsWith("xtend-gen")));
    };
    final VirtualFile existingXtendTestGen = this.findSourceFolder(rootModel, _function_1);
    if (((existingXtendGen != null) || (existingXtendTestGen != null))) {
      VirtualFile _elvis = null;
      if (existingXtendGen != null) {
        _elvis = existingXtendGen;
      } else {
        _elvis = existingXtendTestGen;
      }
      state.setOutputDirectory(_elvis.getPath());
      VirtualFile _elvis_1 = null;
      if (existingXtendTestGen != null) {
        _elvis_1 = existingXtendTestGen;
      } else {
        _elvis_1 = existingXtendGen;
      }
      state.setTestOutputDirectory(_elvis_1.getPath());
      return;
    }
    final String parentPath = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(rootModel.getContentRoots()))).getPath();
    boolean _isAndroidGradleModule = this._gradleBuildFileUtility.isAndroidGradleModule(rootModel.getModule());
    if (_isAndroidGradleModule) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(parentPath);
      _builder.append("/build/generated/source/xtend/debug");
      state.setOutputDirectory(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(parentPath);
      _builder_1.append("/build/generated/source/xtend/androidTest/debug");
      state.setTestOutputDirectory(_builder_1.toString());
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(parentPath);
      _builder_2.append("/build/xtend-gen/main");
      state.setOutputDirectory(_builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(parentPath);
      _builder_3.append("/build/xtend-gen/test");
      state.setTestOutputDirectory(_builder_3.toString());
    }
    final GroovyFile buildFile = this._gradleBuildFileUtility.locateBuildFile(rootModel.getModule());
    if ((buildFile != null)) {
      Project _project = rootModel.getProject();
      List<PsiFile> _newImmutableList = CollectionLiterals.<PsiFile>newImmutableList(buildFile);
      new WriteCommandAction.Simple(_project, "Gradle: Xtend Configuration", ((PsiFile[])Conversions.unwrapArray(_newImmutableList, PsiFile.class))) {
        @Override
        protected void run() throws Throwable {
          XtendProjectConfigurator.this._gradleBuildFileUtility.setupGradleBuild(rootModel.getModule(), buildFile);
        }
      }.execute();
    }
  }
  
  public void presetPlainJavaOutputDirectories(final XbaseGeneratorConfigurationState state, final ModifiableRootModel model) {
    final Function1<SourceFolder, Boolean> _function = (SourceFolder it) -> {
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
    };
    final VirtualFile mainSrc = this.findSourceFolder(model, _function);
    final Function1<SourceFolder, Boolean> _function_1 = (SourceFolder it) -> {
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
    };
    final VirtualFile testSrc = this.findSourceFolder(model, _function_1);
    if (((mainSrc == null) && (testSrc == null))) {
      final VirtualFile contentRoot = this.findBestContentRoot(model);
      String _path = contentRoot.getPath();
      String _plus = (_path + Character.valueOf(VfsUtil.VFS_SEPARATOR_CHAR));
      String _plus_1 = (_plus + "xtend-gen");
      state.setOutputDirectory(_plus_1);
      state.setTestOutputDirectory(state.getOutputDirectory());
    } else {
      VirtualFile _elvis = null;
      if (mainSrc != null) {
        _elvis = mainSrc;
      } else {
        _elvis = testSrc;
      }
      state.setOutputDirectory(this.siblingPath(_elvis, "xtend-gen"));
      VirtualFile _elvis_1 = null;
      if (testSrc != null) {
        _elvis_1 = testSrc;
      } else {
        _elvis_1 = mainSrc;
      }
      state.setTestOutputDirectory(this.siblingPath(_elvis_1, "xtend-gen"));
    }
  }
  
  public void createOutputFolders(final ModifiableRootModel rootModel, final XbaseGeneratorConfigurationState state) {
    try {
      VirtualFile xtendGenMain = VfsUtil.createDirectoryIfMissing(state.getOutputDirectory());
      if ((xtendGenMain != null)) {
        this.addAsSourceFolder(rootModel, xtendGenMain, JavaSourceRootType.SOURCE);
      }
      String _outputDirectory = state.getOutputDirectory();
      String _testOutputDirectory = state.getTestOutputDirectory();
      boolean _notEquals = (!Objects.equal(_outputDirectory, _testOutputDirectory));
      if (_notEquals) {
        VirtualFile xtendGenTest = VfsUtil.createDirectoryIfMissing(state.getTestOutputDirectory());
        if ((xtendGenTest != null)) {
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
          final Function1<VirtualFile, Boolean> _function = (VirtualFile it) -> {
            boolean _isAncestor = VfsUtil.isAncestor(it, module.getModuleFile(), true);
            return Boolean.valueOf((!_isAncestor));
          };
          return IterableExtensions.<VirtualFile>findFirst(((Iterable<VirtualFile>)Conversions.doWrapArray(roots)), _function);
        } else {
          return IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(roots)));
        }
      }
    }
    return model.getProject().getBaseDir();
  }
  
  private VirtualFile findSourceFolder(final ModifiableRootModel rootModel, final Function1<? super SourceFolder, ? extends Boolean> fun) {
    final Function1<ContentEntry, Boolean> _function = (ContentEntry it) -> {
      final Function1<SourceFolder, Boolean> _function_1 = (SourceFolder it_1) -> {
        return fun.apply(it_1);
      };
      SourceFolder _findFirst = IterableExtensions.<SourceFolder>findFirst(((Iterable<SourceFolder>)Conversions.doWrapArray(it.getSourceFolders())), _function_1);
      return Boolean.valueOf((_findFirst != null));
    };
    final ContentEntry contnentRoot = IterableExtensions.<ContentEntry>findFirst(((Iterable<ContentEntry>)Conversions.doWrapArray(rootModel.getContentEntries())), _function);
    if ((contnentRoot != null)) {
      return IterableExtensions.<SourceFolder>findFirst(((Iterable<SourceFolder>)Conversions.doWrapArray(contnentRoot.getSourceFolders())), ((Function1<? super SourceFolder, Boolean>)fun)).getFile();
    }
    return null;
  }
  
  public void addAsSourceFolder(final ModifiableRootModel rootModel, final VirtualFile xtendGenMain, final JavaSourceRootType type) {
    final Function1<ContentEntry, Boolean> _function = (ContentEntry it) -> {
      return Boolean.valueOf(VfsUtil.isAncestor(it.getFile(), xtendGenMain, true));
    };
    final ContentEntry contentRoot = IterableExtensions.<ContentEntry>findFirst(((Iterable<ContentEntry>)Conversions.doWrapArray(rootModel.getContentEntries())), _function);
    if ((contentRoot != null)) {
      final Function1<ExcludeFolder, Boolean> _function_1 = (ExcludeFolder it) -> {
        return Boolean.valueOf(((it.getFile() != null) && VfsUtil.isAncestor(it.getFile(), xtendGenMain, true)));
      };
      final ExcludeFolder excludedParent = IterableExtensions.<ExcludeFolder>findFirst(((Iterable<ExcludeFolder>)Conversions.doWrapArray(contentRoot.getExcludeFolders())), _function_1);
      if ((excludedParent != null)) {
        contentRoot.removeExcludeFolder(excludedParent);
      }
      final JavaSourceRootProperties properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
      final Function1<SourceFolder, Boolean> _function_2 = (SourceFolder it) -> {
        return Boolean.valueOf(VfsUtil.isEqualOrAncestor(it.getUrl(), xtendGenMain.getUrl()));
      };
      final SourceFolder existingSrc = IterableExtensions.<SourceFolder>findFirst(((Iterable<SourceFolder>)Conversions.doWrapArray(contentRoot.getSourceFolders())), _function_2);
      if ((existingSrc != null)) {
        final JpsElement props = existingSrc.getJpsElement().getProperties();
        if ((props instanceof JavaSourceRootProperties)) {
          ((JavaSourceRootProperties)props).applyChanges(properties);
        }
      } else {
        contentRoot.<JavaSourceRootProperties>addSourceFolder(xtendGenMain, type, properties);
      }
    }
  }
  
  private String siblingPath(final VirtualFile sibling, final String path) {
    String _path = sibling.getParent().getPath();
    String _plus = (_path + Character.valueOf(VfsUtil.VFS_SEPARATOR_CHAR));
    return (_plus + path);
  }
}
