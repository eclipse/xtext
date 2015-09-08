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
import com.intellij.facet.Facet;
import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeId;
import com.intellij.facet.FacetTypeRegistry;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import java.util.List;
import javax.inject.Provider;
import javax.swing.JComponent;
import org.eclipse.xtend.core.idea.config.GradleBuildFileUtility;
import org.eclipse.xtend.core.idea.config.XtendLibraryDescription;
import org.eclipse.xtend.core.idea.config.XtendLibraryManager;
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSupportConfigurable extends FrameworkSupportInModuleConfigurable {
  @Inject
  private Provider<XtendLibraryDescription> libraryDescriptionProvider;
  
  @Inject
  private XtendLibraryManager xtendLibManager;
  
  @Inject
  @Extension
  private GradleBuildFileUtility _gradleBuildFileUtility;
  
  @Override
  public void addSupport(final Module module, final ModifiableRootModel rootModel, final ModifiableModelsProvider modifiableModelsProvider) {
    final XtendFacetConfiguration conf = this.createOrGetXtendFacetConf(module);
    this.setupOutputConfiguration(rootModel, conf);
    XbaseGeneratorConfigurationState _state = conf.getState();
    this.createOutputFolders(rootModel, _state);
    this.xtendLibManager.ensureXtendLibAvailable(rootModel);
  }
  
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
      Project _project = module.getProject();
      List<PsiFile> _newImmutableList = CollectionLiterals.<PsiFile>newImmutableList(buildFile);
      new WriteCommandAction.Simple(_project, "Gradle: Xtend Configuration", ((PsiFile[])Conversions.unwrapArray(_newImmutableList, PsiFile.class))) {
        @Override
        protected void run() throws Throwable {
          XtendSupportConfigurable.this._gradleBuildFileUtility.setupGradleBuild(module, buildFile);
        }
      }.execute();
      XbaseGeneratorConfigurationState _state = conf.getState();
      this.presetGradleOutputDirectories(_state, module);
    } else {
      XbaseGeneratorConfigurationState _state_1 = conf.getState();
      this.presetPlainJavaOutputDirectories(_state_1, rootModel);
    }
  }
  
  public XtendFacetConfiguration createOrGetXtendFacetConf(final Module module) {
    FacetTypeRegistry _instance = FacetTypeRegistry.getInstance();
    String _iD = XtendLanguage.INSTANCE.getID();
    final FacetType facetType = _instance.findFacetType(_iD);
    if ((facetType == null)) {
      return null;
    }
    final FacetManager mnr = FacetManager.getInstance(module);
    Facet _elvis = null;
    FacetTypeId _id = facetType.getId();
    String _defaultFacetName = facetType.getDefaultFacetName();
    Facet _findFacet = mnr.<Facet>findFacet(_id, _defaultFacetName);
    if (_findFacet != null) {
      _elvis = _findFacet;
    } else {
      FacetManager _instance_1 = FacetManager.getInstance(module);
      String _defaultFacetName_1 = facetType.getDefaultFacetName();
      Facet _addFacet = _instance_1.<Facet, FacetConfiguration>addFacet(facetType, _defaultFacetName_1, null);
      _elvis = _addFacet;
    }
    Facet facet = _elvis;
    FacetConfiguration _configuration = facet.getConfiguration();
    return ((XtendFacetConfiguration) _configuration);
  }
  
  public void presetGradleOutputDirectories(final XbaseGeneratorConfigurationState state, final Module module) {
    ModuleRootManager _instance = ModuleRootManager.getInstance(module);
    VirtualFile[] _contentRoots = _instance.getContentRoots();
    VirtualFile _head = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
    final String parentPath = _head.getPath();
    boolean _isAndroidGradleModule = this._gradleBuildFileUtility.isAndroidGradleModule(module);
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
    boolean _notEquals = (!Objects.equal(mainSrc, null));
    if (_notEquals) {
      String _siblingPath = this.siblingPath(mainSrc, "xtend-gen");
      state.setOutputDirectory(_siblingPath);
    } else {
      final VirtualFile contentRoot = this.findBestContentRoot(model);
      String _path = contentRoot.getPath();
      String _plus = (_path + Character.valueOf(VfsUtil.VFS_SEPARATOR_CHAR));
      String _plus_1 = (_plus + "xtend-gen");
      state.setOutputDirectory(_plus_1);
    }
    boolean _notEquals_1 = (!Objects.equal(testSrc, null));
    if (_notEquals_1) {
      String _siblingPath_1 = this.siblingPath(testSrc, "xtend-gen");
      state.setTestOutputDirectory(_siblingPath_1);
    } else {
      String _outputDirectory = state.getOutputDirectory();
      state.setTestOutputDirectory(_outputDirectory);
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
  
  private VirtualFile findBestContentRoot(final ModifiableRootModel model) {
    final Module module = model.getModule();
    Project _project = module.getProject();
    VirtualFile contentRoot = _project.getBaseDir();
    VirtualFile _moduleFile = module.getModuleFile();
    boolean _tripleNotEquals = (_moduleFile != null);
    if (_tripleNotEquals) {
      Project _project_1 = module.getProject();
      ProjectRootManager _instance = ProjectRootManager.getInstance(_project_1);
      ProjectFileIndex _fileIndex = _instance.getFileIndex();
      VirtualFile _moduleFile_1 = module.getModuleFile();
      final VirtualFile moduleFileRoot = _fileIndex.getContentRootForFile(_moduleFile_1);
      if ((moduleFileRoot != null)) {
        return contentRoot;
      }
    }
    VirtualFile[] _contentRoots = model.getContentRoots();
    boolean _isEmpty = ((List<VirtualFile>)Conversions.doWrapArray(_contentRoots)).isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      VirtualFile[] _contentRoots_1 = model.getContentRoots();
      VirtualFile _head = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots_1)));
      contentRoot = _head;
    }
    return contentRoot;
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
    VirtualFile[] _contentRoots = rootModel.getContentRoots();
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        return Boolean.valueOf(VfsUtil.isAncestor(it, xtendGenMain, true));
      }
    };
    final VirtualFile contentRootFile = IterableExtensions.<VirtualFile>findFirst(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)), _function);
    ContentEntry[] _contentEntries = rootModel.getContentEntries();
    final Function1<ContentEntry, Boolean> _function_1 = new Function1<ContentEntry, Boolean>() {
      @Override
      public Boolean apply(final ContentEntry it) {
        VirtualFile _file = it.getFile();
        return Boolean.valueOf(Objects.equal(_file, contentRootFile));
      }
    };
    final ContentEntry contentRoot = IterableExtensions.<ContentEntry>findFirst(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)), _function_1);
    JpsJavaExtensionService _instance = JpsJavaExtensionService.getInstance();
    final JavaSourceRootProperties properties = _instance.createSourceRootProperties("", true);
    if (contentRoot!=null) {
      contentRoot.<JavaSourceRootProperties>addSourceFolder(xtendGenMain, type, properties);
    }
  }
  
  private String siblingPath(final VirtualFile sibling, final String path) {
    VirtualFile _parent = sibling.getParent();
    String _path = _parent.getPath();
    String _plus = (_path + Character.valueOf(VfsUtil.VFS_SEPARATOR_CHAR));
    return (_plus + path);
  }
  
  @Override
  public JComponent createComponent() {
    return null;
  }
  
  @Override
  public CustomLibraryDescription createLibraryDescription() {
    return this.libraryDescriptionProvider.get();
  }
}
