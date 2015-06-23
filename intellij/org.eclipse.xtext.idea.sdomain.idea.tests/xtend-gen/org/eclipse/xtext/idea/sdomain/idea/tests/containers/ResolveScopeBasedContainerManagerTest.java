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
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModuleRootModificationUtil;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.PlatformTestCase;
import com.intellij.testFramework.builders.EmptyModuleFixtureBuilder;
import com.intellij.testFramework.fixtures.IdeaProjectTestFixture;
import com.intellij.testFramework.fixtures.IdeaTestFixtureFactory;
import com.intellij.testFramework.fixtures.JavaCodeInsightTestFixture;
import com.intellij.testFramework.fixtures.JavaTestFixtureFactory;
import com.intellij.testFramework.fixtures.ModuleFixture;
import com.intellij.testFramework.fixtures.TestFixtureBuilder;
import java.io.File;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.sdomain.idea.tests.containers.URIBasedTestResourceDescription;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ResolveScopeBasedContainerManagerTest extends PlatformTestCase {
  @Inject
  private IContainer.Manager containerManager;
  
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  private BaseXtextFile[] files;
  
  private JavaCodeInsightTestFixture myFixture;
  
  protected String getTestDataPath() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("./testData/containers");
    return _builder.toString();
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    IdeaTestFixtureFactory _fixtureFactory = IdeaTestFixtureFactory.getFixtureFactory();
    String _name = this.getName();
    final TestFixtureBuilder<IdeaProjectTestFixture> projectBuilder = _fixtureFactory.createFixtureBuilder(_name);
    JavaTestFixtureFactory _fixtureFactory_1 = JavaTestFixtureFactory.getFixtureFactory();
    IdeaProjectTestFixture _fixture = projectBuilder.getFixture();
    JavaCodeInsightTestFixture _createCodeInsightFixture = _fixtureFactory_1.createCodeInsightFixture(_fixture);
    this.myFixture = _createCodeInsightFixture;
    String _testDataPath = this.getTestDataPath();
    this.myFixture.setTestDataPath(_testDataPath);
    final String tempDirPath = this.myFixture.getTempDirPath();
    final EmptyModuleFixtureBuilder moduleFixtureBuilder = projectBuilder.<EmptyModuleFixtureBuilder>addModule(EmptyModuleFixtureBuilder.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(tempDirPath, "");
    _builder.append("/module");
    File _file = new File(_builder.toString());
    _file.mkdir();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(tempDirPath, "");
    _builder_1.append("/module");
    moduleFixtureBuilder.addSourceContentRoot(_builder_1.toString());
    final EmptyModuleFixtureBuilder module2FixtureBuilder = projectBuilder.<EmptyModuleFixtureBuilder>addModule(EmptyModuleFixtureBuilder.class);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(tempDirPath, "");
    _builder_2.append("/module2");
    File _file_1 = new File(_builder_2.toString());
    _file_1.mkdir();
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append(tempDirPath, "");
    _builder_3.append("/module2");
    module2FixtureBuilder.addSourceContentRoot(_builder_3.toString());
    this.myFixture.setUp();
    ModuleFixture _fixture_1 = moduleFixtureBuilder.getFixture();
    final Module module = _fixture_1.getModule();
    ModuleFixture _fixture_2 = module2FixtureBuilder.getFixture();
    final Module module2 = _fixture_2.getModule();
    ModuleRootModificationUtil.addDependency(module, module2);
    PsiFile[] _configureByFiles = this.myFixture.configureByFiles(
      "/module/file1.sdomain", 
      "/module/file2.sdomain", 
      "/module2/file3.sdomain");
    Iterable<BaseXtextFile> _filter = Iterables.<BaseXtextFile>filter(((Iterable<?>)Conversions.doWrapArray(_configureByFiles)), BaseXtextFile.class);
    this.files = ((BaseXtextFile[])Conversions.unwrapArray(_filter, BaseXtextFile.class));
    BaseXtextFile _head = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    IXtextLanguage _xtextLanguage = _head.getXtextLanguage();
    _xtextLanguage.injectMembers(this);
  }
  
  @Override
  protected void tearDown() throws Exception {
    this.files = null;
    this.myFixture.tearDown();
    this.myFixture = null;
    super.tearDown();
  }
  
  public void testGetContainer_01() {
    BaseXtextFile _head = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI = _head.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _head_1 = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    XtextResource _resource = _head_1.getResource();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(_resource);
    final IContainer container = this.containerManager.getContainer(description, resourceDescriptions);
    Iterable<IResourceDescription> _resourceDescriptions = container.getResourceDescriptions();
    int _size = IterableExtensions.size(_resourceDescriptions);
    TestCase.assertEquals(2, _size);
    BaseXtextFile _head_2 = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI_1 = _head_2.getURI();
    IResourceDescription _resourceDescription = container.getResourceDescription(_uRI_1);
    TestCase.assertNotNull(_resourceDescription);
    BaseXtextFile _get = this.files[1];
    URI _uRI_2 = _get.getURI();
    IResourceDescription _resourceDescription_1 = container.getResourceDescription(_uRI_2);
    TestCase.assertNotNull(_resourceDescription_1);
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI_3 = _last.getURI();
    IResourceDescription _resourceDescription_2 = container.getResourceDescription(_uRI_3);
    TestCase.assertNull(_resourceDescription_2);
  }
  
  public void testGetContainer_02() {
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI = _last.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _last_1 = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    XtextResource _resource = _last_1.getResource();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(_resource);
    final IContainer container = this.containerManager.getContainer(description, resourceDescriptions);
    Iterable<IResourceDescription> _resourceDescriptions = container.getResourceDescriptions();
    int _size = IterableExtensions.size(_resourceDescriptions);
    TestCase.assertEquals(1, _size);
    BaseXtextFile _head = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI_1 = _head.getURI();
    IResourceDescription _resourceDescription = container.getResourceDescription(_uRI_1);
    TestCase.assertNull(_resourceDescription);
    BaseXtextFile _get = this.files[1];
    URI _uRI_2 = _get.getURI();
    IResourceDescription _resourceDescription_1 = container.getResourceDescription(_uRI_2);
    TestCase.assertNull(_resourceDescription_1);
    BaseXtextFile _last_2 = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI_3 = _last_2.getURI();
    IResourceDescription _resourceDescription_2 = container.getResourceDescription(_uRI_3);
    TestCase.assertNotNull(_resourceDescription_2);
  }
  
  public void testGetVisibleContainers_01() {
    BaseXtextFile _head = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI = _head.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _head_1 = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
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
    BaseXtextFile _head_4 = IterableExtensions.<BaseXtextFile>head(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI_1 = _head_4.getURI();
    IResourceDescription _resourceDescription = _head_3.getResourceDescription(_uRI_1);
    TestCase.assertNotNull(_resourceDescription);
    IContainer _head_5 = IterableExtensions.<IContainer>head(visibleContainers);
    BaseXtextFile _get_1 = this.files[1];
    URI _uRI_2 = _get_1.getURI();
    IResourceDescription _resourceDescription_1 = _head_5.getResourceDescription(_uRI_2);
    TestCase.assertNotNull(_resourceDescription_1);
    IContainer _get_2 = visibleContainers.get(1);
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI_3 = _last.getURI();
    IResourceDescription _resourceDescription_2 = _get_2.getResourceDescription(_uRI_3);
    TestCase.assertNotNull(_resourceDescription_2);
  }
  
  public void testGetVisibleContainers_02() {
    BaseXtextFile _last = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI = _last.getURI();
    final URIBasedTestResourceDescription description = new URIBasedTestResourceDescription(_uRI);
    BaseXtextFile _last_1 = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
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
    BaseXtextFile _last_2 = IterableExtensions.<BaseXtextFile>last(((Iterable<BaseXtextFile>)Conversions.doWrapArray(this.files)));
    URI _uRI_1 = _last_2.getURI();
    IResourceDescription _resourceDescription = _head_1.getResourceDescription(_uRI_1);
    TestCase.assertNotNull(_resourceDescription);
  }
}
