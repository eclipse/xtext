/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.tests.containers;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModuleRootModificationUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.testFramework.PlatformTestCase;
import com.intellij.testFramework.PsiTestUtil;
import com.intellij.testFramework.UsefulTestCase;
import java.io.File;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.idea.sdomain.idea.tests.containers.URIBasedTestResourceDescription;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ResolveScopeBasedContainerManagerTest extends PlatformTestCase {
  @Inject
  private IContainer.Manager containerManager;
  
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  private List<BaseXtextFile> files;
  
  protected String getTestDataPath() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("./testData/containers");
    return _builder.toString();
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    final Module module = this.createModule("module");
    StringConcatenation _builder = new StringConcatenation();
    String _testDataPath = this.getTestDataPath();
    _builder.append(_testDataPath, "");
    _builder.append("/module");
    File _file = new File(_builder.toString());
    VirtualFile _refreshAndFindFile = UsefulTestCase.refreshAndFindFile(_file);
    PsiTestUtil.addSourceRoot(module, _refreshAndFindFile);
    final Module module2 = this.createModule("module2");
    StringConcatenation _builder_1 = new StringConcatenation();
    String _testDataPath_1 = this.getTestDataPath();
    _builder_1.append(_testDataPath_1, "");
    _builder_1.append("/module2");
    File _file_1 = new File(_builder_1.toString());
    VirtualFile _refreshAndFindFile_1 = UsefulTestCase.refreshAndFindFile(_file_1);
    PsiTestUtil.addSourceRoot(module2, _refreshAndFindFile_1);
    Language _language = SDomainFileType.INSTANCE.getLanguage();
    String _iD = _language.getID();
    LightToolingTest.addFacetToModule(module, _iD);
    Language _language_1 = SDomainFileType.INSTANCE.getLanguage();
    String _iD_1 = _language_1.getID();
    LightToolingTest.addFacetToModule(module2, _iD_1);
    ModuleRootModificationUtil.addDependency(module, module2);
    final Function1<String, PsiFile> _function = new Function1<String, PsiFile>() {
      @Override
      public PsiFile apply(final String path) {
        PsiFile _xblockexpression = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          String _testDataPath = ResolveScopeBasedContainerManagerTest.this.getTestDataPath();
          _builder.append(_testDataPath, "");
          _builder.append("/");
          _builder.append(path, "");
          final File file = new File(_builder.toString());
          final VirtualFile virtualFile = UsefulTestCase.refreshAndFindFile(file);
          PsiManager _psiManager = ResolveScopeBasedContainerManagerTest.this.getPsiManager();
          _xblockexpression = _psiManager.findFile(virtualFile);
        }
        return _xblockexpression;
      }
    };
    List<PsiFile> _map = ListExtensions.<String, PsiFile>map(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("/module/file1.sdomain", "/module/file2.sdomain", "/module2/file3.sdomain")), _function);
    Iterable<BaseXtextFile> _filter = Iterables.<BaseXtextFile>filter(_map, BaseXtextFile.class);
    List<BaseXtextFile> _list = IterableExtensions.<BaseXtextFile>toList(_filter);
    this.files = _list;
    SDomainLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  protected void tearDown() throws Exception {
    this.files = null;
    super.tearDown();
  }
  
  public void testGetContainer_01() {
    BaseXtextFile _head = IterableExtensions.<BaseXtextFile>head(this.files);
    URI _uRI = _head.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _head_1 = IterableExtensions.<BaseXtextFile>head(this.files);
    XtextResource _resource = _head_1.getResource();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(_resource);
    final IContainer container = this.containerManager.getContainer(description, resourceDescriptions);
    Iterable<IResourceDescription> _resourceDescriptions = container.getResourceDescriptions();
    int _size = IterableExtensions.size(_resourceDescriptions);
    TestCase.assertEquals(2, _size);
    BaseXtextFile _head_2 = IterableExtensions.<BaseXtextFile>head(this.files);
    URI _uRI_1 = _head_2.getURI();
    IResourceDescription _resourceDescription = container.getResourceDescription(_uRI_1);
    TestCase.assertNotNull(_resourceDescription);
    BaseXtextFile _get = this.files.get(1);
    URI _uRI_2 = _get.getURI();
    IResourceDescription _resourceDescription_1 = container.getResourceDescription(_uRI_2);
    TestCase.assertNotNull(_resourceDescription_1);
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(this.files);
    URI _uRI_3 = _last.getURI();
    IResourceDescription _resourceDescription_2 = container.getResourceDescription(_uRI_3);
    TestCase.assertNull(_resourceDescription_2);
  }
  
  public void testGetContainer_02() {
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(this.files);
    URI _uRI = _last.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _last_1 = IterableExtensions.<BaseXtextFile>last(this.files);
    XtextResource _resource = _last_1.getResource();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(_resource);
    final IContainer container = this.containerManager.getContainer(description, resourceDescriptions);
    Iterable<IResourceDescription> _resourceDescriptions = container.getResourceDescriptions();
    int _size = IterableExtensions.size(_resourceDescriptions);
    TestCase.assertEquals(1, _size);
    BaseXtextFile _head = IterableExtensions.<BaseXtextFile>head(this.files);
    URI _uRI_1 = _head.getURI();
    IResourceDescription _resourceDescription = container.getResourceDescription(_uRI_1);
    TestCase.assertNull(_resourceDescription);
    BaseXtextFile _get = this.files.get(1);
    URI _uRI_2 = _get.getURI();
    IResourceDescription _resourceDescription_1 = container.getResourceDescription(_uRI_2);
    TestCase.assertNull(_resourceDescription_1);
    BaseXtextFile _last_2 = IterableExtensions.<BaseXtextFile>last(this.files);
    URI _uRI_3 = _last_2.getURI();
    IResourceDescription _resourceDescription_2 = container.getResourceDescription(_uRI_3);
    TestCase.assertNotNull(_resourceDescription_2);
  }
  
  public void testGetVisibleContainers_01() {
    BaseXtextFile _head = IterableExtensions.<BaseXtextFile>head(this.files);
    URI _uRI = _head.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _head_1 = IterableExtensions.<BaseXtextFile>head(this.files);
    XtextResource _resource = _head_1.getResource();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(_resource);
    final List<IContainer> visibleContainers = this.containerManager.getVisibleContainers(description, resourceDescriptions);
    int _size = visibleContainers.size();
    TestCase.assertEquals(2, _size);
    IContainer _head_2 = IterableExtensions.<IContainer>head(visibleContainers);
    Iterable<IResourceDescription> _resourceDescriptions = _head_2.getResourceDescriptions();
    int _size_1 = IterableExtensions.size(_resourceDescriptions);
    TestCase.assertEquals(2, _size_1);
    IContainer _get = visibleContainers.get(1);
    Iterable<IResourceDescription> _resourceDescriptions_1 = _get.getResourceDescriptions();
    int _size_2 = IterableExtensions.size(_resourceDescriptions_1);
    TestCase.assertEquals(1, _size_2);
    IContainer _head_3 = IterableExtensions.<IContainer>head(visibleContainers);
    BaseXtextFile _head_4 = IterableExtensions.<BaseXtextFile>head(this.files);
    URI _uRI_1 = _head_4.getURI();
    IResourceDescription _resourceDescription = _head_3.getResourceDescription(_uRI_1);
    TestCase.assertNotNull(_resourceDescription);
    IContainer _head_5 = IterableExtensions.<IContainer>head(visibleContainers);
    BaseXtextFile _get_1 = this.files.get(1);
    URI _uRI_2 = _get_1.getURI();
    IResourceDescription _resourceDescription_1 = _head_5.getResourceDescription(_uRI_2);
    TestCase.assertNotNull(_resourceDescription_1);
    IContainer _get_2 = visibleContainers.get(1);
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(this.files);
    URI _uRI_3 = _last.getURI();
    IResourceDescription _resourceDescription_2 = _get_2.getResourceDescription(_uRI_3);
    TestCase.assertNotNull(_resourceDescription_2);
  }
  
  public void testGetVisibleContainers_02() {
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(this.files);
    URI _uRI = _last.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _last_1 = IterableExtensions.<BaseXtextFile>last(this.files);
    XtextResource _resource = _last_1.getResource();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(_resource);
    final List<IContainer> visibleContainers = this.containerManager.getVisibleContainers(description, resourceDescriptions);
    int _size = visibleContainers.size();
    TestCase.assertEquals(1, _size);
    IContainer _head = IterableExtensions.<IContainer>head(visibleContainers);
    Iterable<IResourceDescription> _resourceDescriptions = _head.getResourceDescriptions();
    int _size_1 = IterableExtensions.size(_resourceDescriptions);
    TestCase.assertEquals(1, _size_1);
    IContainer _head_1 = IterableExtensions.<IContainer>head(visibleContainers);
    BaseXtextFile _last_2 = IterableExtensions.<BaseXtextFile>last(this.files);
    URI _uRI_1 = _last_2.getURI();
    IResourceDescription _resourceDescription = _head_1.getResourceDescription(_uRI_1);
    TestCase.assertNotNull(_resourceDescription);
  }
}
