/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.config;

import com.google.common.base.Objects;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeRegistry;
import com.intellij.facet.ModifiableFacetModel;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.framework.detection.FacetBasedFrameworkDetector;
import com.intellij.framework.detection.FrameworkDetector;
import com.intellij.framework.detection.impl.FrameworkDetectorRegistry;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportConfigurable;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModelImpl;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportUtil;
import com.intellij.ide.util.newProjectWizard.OldFrameworkSupportProviderWrapper;
import com.intellij.ide.util.newProjectWizard.impl.FrameworkSupportCommunicator;
import com.intellij.openapi.application.RunResult;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.IdeaModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer;
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainerFactory;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.PlatformTestCase;
import com.intellij.testFramework.PsiTestCase;
import com.intellij.testFramework.PsiTestUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration;
import org.eclipse.xtend.core.idea.facet.XtendFacetType;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSupportConfigurableTest extends PsiTestCase {
  public void testPlainJavaOutputConfiguration_01() {
    final ModuleRootManager manager = ModuleRootManager.getInstance(this.myModule);
    VirtualFile[] _contentRoots = manager.getContentRoots();
    int _size = ((List<VirtualFile>)Conversions.doWrapArray(_contentRoots)).size();
    TestCase.assertEquals(0, _size);
    this.addFrameworkSupport(this.myModule);
    VirtualFile[] _contentRoots_1 = manager.getContentRoots();
    int _size_1 = ((List<VirtualFile>)Conversions.doWrapArray(_contentRoots_1)).size();
    TestCase.assertEquals(1, _size_1);
    FacetManager _instance = FacetManager.getInstance(this.myModule);
    Collection<Facet<XtendFacetConfiguration>> _facetsByType = _instance.<Facet<XtendFacetConfiguration>>getFacetsByType(XtendFacetType.TYPEID);
    final Facet<XtendFacetConfiguration> facet = IterableExtensions.<Facet<XtendFacetConfiguration>>head(_facetsByType);
    TestCase.assertNotNull(facet);
    XtendFacetConfiguration _configuration = facet.getConfiguration();
    final XbaseGeneratorConfigurationState xtendConfig = _configuration.getState();
    String _outputDirectory = xtendConfig.getOutputDirectory();
    boolean _endsWith = _outputDirectory.endsWith("xtend-gen");
    TestCase.assertTrue(_endsWith);
    String _testOutputDirectory = xtendConfig.getTestOutputDirectory();
    boolean _endsWith_1 = _testOutputDirectory.endsWith("xtend-gen");
    TestCase.assertTrue(_endsWith_1);
    ContentEntry[] _contentEntries = manager.getContentEntries();
    ContentEntry _head = IterableExtensions.<ContentEntry>head(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)));
    SourceFolder[] _sourceFolders = _head.getSourceFolders();
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _xblockexpression = false;
        {
          VirtualFile _file = it.getFile();
          String _path = _file.getPath();
          final String urlToCheck = _path.replace("file://", "");
          boolean _and = false;
          String _outputDirectory = xtendConfig.getOutputDirectory();
          boolean _equals = Objects.equal(_outputDirectory, urlToCheck);
          if (!_equals) {
            _and = false;
          } else {
            boolean _isTestSource = it.isTestSource();
            boolean _not = (!_isTestSource);
            _and = _not;
          }
          _xblockexpression = _and;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    Iterable<SourceFolder> _filter = IterableExtensions.<SourceFolder>filter(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)), _function);
    int _size_2 = IterableExtensions.size(_filter);
    TestCase.assertEquals(1, _size_2);
  }
  
  public void testPlainJavaOutputConfiguration_02() {
    try {
      final Module module = this.createModule("module1");
      Project _project = module.getProject();
      VirtualFile _baseDir = _project.getBaseDir();
      String _name = module.getName();
      final VirtualFile moduleRoot = VfsUtil.createDirectoryIfMissing(_baseDir, _name);
      final VirtualFile srcDirVf = VfsUtil.createDirectoryIfMissing(moduleRoot, "src/main/java");
      final VirtualFile testDirVf = VfsUtil.createDirectoryIfMissing(moduleRoot, "src/test/java");
      PsiTestUtil.addContentRoot(module, moduleRoot);
      PsiTestUtil.addSourceRoot(module, srcDirVf);
      PsiTestUtil.addSourceRoot(module, testDirVf, true);
      final ModuleRootManager manager = ModuleRootManager.getInstance(module);
      final VirtualFile[] srcFolders = manager.getSourceRoots(true);
      int _size = ((List<VirtualFile>)Conversions.doWrapArray(srcFolders)).size();
      TestCase.assertEquals(2, _size);
      this.addFrameworkSupport(module);
      FacetManager _instance = FacetManager.getInstance(module);
      Collection<Facet<XtendFacetConfiguration>> _facetsByType = _instance.<Facet<XtendFacetConfiguration>>getFacetsByType(XtendFacetType.TYPEID);
      final Facet<XtendFacetConfiguration> facet = IterableExtensions.<Facet<XtendFacetConfiguration>>head(_facetsByType);
      TestCase.assertNotNull(facet);
      XtendFacetConfiguration _configuration = facet.getConfiguration();
      final XbaseGeneratorConfigurationState xtendConfig = _configuration.getState();
      String _outputDirectory = xtendConfig.getOutputDirectory();
      String _testOutputDirectory = xtendConfig.getTestOutputDirectory();
      boolean _equals = Objects.equal(_outputDirectory, _testOutputDirectory);
      TestCase.assertFalse(_equals);
      String _outputDirectory_1 = xtendConfig.getOutputDirectory();
      boolean _endsWith = _outputDirectory_1.endsWith("module1/src/main/xtend-gen");
      TestCase.assertTrue(_endsWith);
      String _testOutputDirectory_1 = xtendConfig.getTestOutputDirectory();
      boolean _endsWith_1 = _testOutputDirectory_1.endsWith("module1/src/test/xtend-gen");
      TestCase.assertTrue(_endsWith_1);
      ModuleRootManager _instance_1 = ModuleRootManager.getInstance(module);
      final VirtualFile[] sourceRoots = _instance_1.getSourceRoots(true);
      final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
        @Override
        public Boolean apply(final VirtualFile it) {
          boolean _xblockexpression = false;
          {
            String _path = it.getPath();
            final String urlToCheck = _path.replace("file://", "");
            String _outputDirectory = xtendConfig.getOutputDirectory();
            _xblockexpression = Objects.equal(_outputDirectory, urlToCheck);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      Iterable<VirtualFile> _filter = IterableExtensions.<VirtualFile>filter(((Iterable<VirtualFile>)Conversions.doWrapArray(sourceRoots)), _function);
      int _size_1 = IterableExtensions.size(_filter);
      TestCase.assertEquals(1, _size_1);
      final Function1<VirtualFile, Boolean> _function_1 = new Function1<VirtualFile, Boolean>() {
        @Override
        public Boolean apply(final VirtualFile it) {
          boolean _xblockexpression = false;
          {
            String _path = it.getPath();
            final String urlToCheck = _path.replace("file://", "");
            String _testOutputDirectory = xtendConfig.getTestOutputDirectory();
            _xblockexpression = Objects.equal(_testOutputDirectory, urlToCheck);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      Iterable<VirtualFile> _filter_1 = IterableExtensions.<VirtualFile>filter(((Iterable<VirtualFile>)Conversions.doWrapArray(sourceRoots)), _function_1);
      int _size_2 = IterableExtensions.size(_filter_1);
      TestCase.assertEquals(1, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testPlainJavaOutputConfiguration_03() {
    final ModuleRootManager manager = ModuleRootManager.getInstance(this.myModule);
    VirtualFile[] _contentRoots = manager.getContentRoots();
    int _size = ((List<VirtualFile>)Conversions.doWrapArray(_contentRoots)).size();
    TestCase.assertEquals(0, _size);
    this.addFrameworkSupportUsingDetector(this.myModule);
    VirtualFile[] _contentRoots_1 = manager.getContentRoots();
    int _size_1 = ((List<VirtualFile>)Conversions.doWrapArray(_contentRoots_1)).size();
    TestCase.assertEquals(1, _size_1);
    FacetManager _instance = FacetManager.getInstance(this.myModule);
    Collection<Facet<XtendFacetConfiguration>> _facetsByType = _instance.<Facet<XtendFacetConfiguration>>getFacetsByType(XtendFacetType.TYPEID);
    final Facet<XtendFacetConfiguration> facet = IterableExtensions.<Facet<XtendFacetConfiguration>>head(_facetsByType);
    TestCase.assertNotNull(facet);
    XtendFacetConfiguration _configuration = facet.getConfiguration();
    final XbaseGeneratorConfigurationState xtendConfig = _configuration.getState();
    String _outputDirectory = xtendConfig.getOutputDirectory();
    boolean _endsWith = _outputDirectory.endsWith("xtend-gen");
    TestCase.assertTrue(_endsWith);
    String _testOutputDirectory = xtendConfig.getTestOutputDirectory();
    boolean _endsWith_1 = _testOutputDirectory.endsWith("xtend-gen");
    TestCase.assertTrue(_endsWith_1);
    ContentEntry[] _contentEntries = manager.getContentEntries();
    ContentEntry _head = IterableExtensions.<ContentEntry>head(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)));
    SourceFolder[] _sourceFolders = _head.getSourceFolders();
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _xblockexpression = false;
        {
          VirtualFile _file = it.getFile();
          String _path = _file.getPath();
          final String urlToCheck = _path.replace("file://", "");
          boolean _and = false;
          String _outputDirectory = xtendConfig.getOutputDirectory();
          boolean _equals = Objects.equal(_outputDirectory, urlToCheck);
          if (!_equals) {
            _and = false;
          } else {
            boolean _isTestSource = it.isTestSource();
            boolean _not = (!_isTestSource);
            _and = _not;
          }
          _xblockexpression = _and;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    Iterable<SourceFolder> _filter = IterableExtensions.<SourceFolder>filter(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)), _function);
    int _size_2 = IterableExtensions.size(_filter);
    TestCase.assertEquals(1, _size_2);
  }
  
  protected void addFrameworkSupportUsingDetector(final Module moduleToHandle) {
    Project _project = this.getProject();
    RunResult<Object> _execute = new WriteCommandAction.Simple(_project) {
      @Override
      protected void run() throws Throwable {
        XtendSupportConfigurableTest.this.createContentRoot(moduleToHandle);
        final IdeaModifiableModelsProvider modifiableModelsProvider = new IdeaModifiableModelsProvider();
        final ModifiableFacetModel model = modifiableModelsProvider.getFacetModifiableModel(moduleToHandle);
        try {
          FacetTypeRegistry _instance = FacetTypeRegistry.getInstance();
          String _string = XtendFacetType.TYPEID.toString();
          final FacetType facetType = _instance.findFacetType(_string);
          final FacetConfiguration facetConfiguration = facetType.createDefaultConfiguration();
          FrameworkDetectorRegistry _instance_1 = FrameworkDetectorRegistry.getInstance();
          Collection<Integer> _detectorIds = _instance_1.getDetectorIds(XtendFileType.INSTANCE);
          final Integer detId = IterableExtensions.<Integer>head(_detectorIds);
          FrameworkDetectorRegistry _instance_2 = FrameworkDetectorRegistry.getInstance();
          FrameworkDetector _detectorById = _instance_2.getDetectorById((detId).intValue());
          final FacetBasedFrameworkDetector detector = ((FacetBasedFrameworkDetector) _detectorById);
          FacetManager _instance_3 = FacetManager.getInstance(moduleToHandle);
          String _defaultFacetName = facetType.getDefaultFacetName();
          final Facet facet = _instance_3.<Facet, FacetConfiguration>createFacet(facetType, _defaultFacetName, facetConfiguration, null);
          model.addFacet(facet);
          modifiableModelsProvider.commitFacetModifiableModel(moduleToHandle, model);
          final ModifiableRootModel rootModel = modifiableModelsProvider.getModuleModifiableModel(moduleToHandle);
          detector.setupFacet(facet, rootModel);
          modifiableModelsProvider.commitModuleModifiableModel(rootModel);
        } finally {
          model.commit();
        }
      }
    }.execute();
    _execute.throwException();
  }
  
  protected ContentEntry createContentRoot(final Module moduleToHandle) {
    try {
      ContentEntry _xblockexpression = null;
      {
        File _createTempDir = PlatformTestCase.createTempDir("contentRoot");
        final VirtualFile root = PlatformTestCase.getVirtualFile(_createTempDir);
        _xblockexpression = PsiTestUtil.addContentRoot(moduleToHandle, root);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void addFrameworkSupport(final Module moduleToHandle) {
    Project _project = this.getProject();
    RunResult<Object> _execute = new WriteCommandAction.Simple(_project) {
      @Override
      protected void run() throws Throwable {
        XtendSupportConfigurableTest.this.createContentRoot(moduleToHandle);
        ModuleRootManager _instance = ModuleRootManager.getInstance(moduleToHandle);
        final ModifiableRootModel model = _instance.getModifiableModel();
        String _iD = XtendLanguage.INSTANCE.getID();
        List<FrameworkSupportInModuleProvider> _allProviders = FrameworkSupportUtil.getAllProviders();
        final FrameworkSupportInModuleProvider provider = FrameworkSupportUtil.findProvider(_iD, _allProviders);
        Project _project = this.getProject();
        Project _project_1 = this.getProject();
        LibrariesContainer _createContainer = LibrariesContainerFactory.createContainer(_project_1);
        final FrameworkSupportModelImpl myFrameworkSupportModel = new FrameworkSupportModelImpl(_project, "", _createContainer);
        final FrameworkSupportInModuleConfigurable configurable = provider.createConfigurable(myFrameworkSupportModel);
        try {
          ArrayList<FrameworkSupportConfigurable> selectedConfigurables = new ArrayList<FrameworkSupportConfigurable>();
          IdeaModifiableModelsProvider _ideaModifiableModelsProvider = new IdeaModifiableModelsProvider();
          configurable.addSupport(moduleToHandle, model, _ideaModifiableModelsProvider);
          if ((configurable instanceof OldFrameworkSupportProviderWrapper.FrameworkSupportConfigurableWrapper)) {
            FrameworkSupportConfigurable _configurable = ((OldFrameworkSupportProviderWrapper.FrameworkSupportConfigurableWrapper)configurable).getConfigurable();
            selectedConfigurables.add(_configurable);
          }
          FrameworkSupportCommunicator[] _extensions = FrameworkSupportCommunicator.EP_NAME.getExtensions();
          for (final FrameworkSupportCommunicator communicator : _extensions) {
            communicator.onFrameworkSupportAdded(moduleToHandle, model, selectedConfigurables, myFrameworkSupportModel);
          }
        } finally {
          model.commit();
          boolean _isDisposed = Disposer.isDisposed(configurable);
          boolean _not = (!_isDisposed);
          if (_not) {
            Disposer.dispose(configurable);
          }
        }
      }
    }.execute();
    _execute.throwException();
  }
}
