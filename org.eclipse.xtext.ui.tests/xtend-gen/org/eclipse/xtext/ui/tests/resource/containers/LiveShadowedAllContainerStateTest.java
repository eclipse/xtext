/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.resource.containers;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.XtextLiveScopeResourceSetProvider;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class LiveShadowedAllContainerStateTest {
  @Inject
  private IAllContainersState.Provider containerStateProvider;
  
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionProvider;
  
  @Inject
  private XtextLiveScopeResourceSetProvider liveScopeResourceSetProvider;
  
  @Inject
  @Extension
  private FileExtensionProvider _fileExtensionProvider;
  
  @Before
  public void setUp() throws Exception {
    TestsActivator.getInstance().getInjector(TestsActivator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE).injectMembers(this);
  }
  
  @After
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  @Test
  public void testInMemoryResourceWithoutProject() {
    try {
      final XtextResourceSet rs = new XtextResourceSet();
      rs.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
      String _primaryFileExtension = this._fileExtensionProvider.getPrimaryFileExtension();
      String _plus = ("myproject/myfile." + _primaryFileExtension);
      final Resource resource = rs.createResource(URI.createPlatformResourceURI(_plus, true));
      StringInputStream _stringInputStream = new StringInputStream("stuff foo");
      resource.load(_stringInputStream, CollectionLiterals.<Object, Object>emptyMap());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container myproject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/myproject/myfile.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, this.formatContainers(rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInMemoryResourceWithProject() {
    try {
      final IProject project = IResourcesSetupUtil.createProject("MyProject");
      IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
      final ResourceSet rs = this.liveScopeResourceSetProvider.get(project);
      String _primaryFileExtension = this._fileExtensionProvider.getPrimaryFileExtension();
      String _plus = ("MyProject/myfile." + _primaryFileExtension);
      final Resource resource = rs.createResource(URI.createPlatformResourceURI(_plus, true));
      StringInputStream _stringInputStream = new StringInputStream("stuff foo");
      resource.load(_stringInputStream, CollectionLiterals.<Object, Object>emptyMap());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container MyProject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, this.formatContainers(rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptyProject() {
    try {
      final IProject project = IResourcesSetupUtil.createProject("MyProject");
      IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
      final ResourceSet rs = this.liveScopeResourceSetProvider.get(project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container MyProject isEmpty=true {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, this.formatContainers(rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPersistedWithoutResource() {
    try {
      final IProject project = IResourcesSetupUtil.createProject("MyProject");
      IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
      String _primaryFileExtension = this._fileExtensionProvider.getPrimaryFileExtension();
      final String fileName = ("MyProject/myfile." + _primaryFileExtension);
      IResourcesSetupUtil.createFile(fileName, "stuff foo");
      IResourcesSetupUtil.waitForBuild();
      final ResourceSet rs = this.liveScopeResourceSetProvider.get(project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container MyProject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, this.formatContainers(rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPersistedWithResource() {
    try {
      final IProject project = IResourcesSetupUtil.createProject("MyProject");
      IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
      String _primaryFileExtension = this._fileExtensionProvider.getPrimaryFileExtension();
      final String fileName = ("MyProject/myfile." + _primaryFileExtension);
      IResourcesSetupUtil.createFile(fileName, "stuff foo");
      IResourcesSetupUtil.waitForBuild();
      final ResourceSet rs = this.liveScopeResourceSetProvider.get(project);
      Assert.assertNotNull(rs.getResource(URI.createPlatformResourceURI(fileName, true), true));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container MyProject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, this.formatContainers(rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPersistedWithOtherResource() {
    try {
      final IProject project = IResourcesSetupUtil.createProject("MyProject");
      IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
      String _primaryFileExtension = this._fileExtensionProvider.getPrimaryFileExtension();
      final String fileName = ("MyProject/myfile1." + _primaryFileExtension);
      IResourcesSetupUtil.createFile(fileName, "stuff foo");
      IResourcesSetupUtil.waitForBuild();
      final ResourceSet rs = this.liveScopeResourceSetProvider.get(project);
      String _primaryFileExtension_1 = this._fileExtensionProvider.getPrimaryFileExtension();
      String _plus = ("MyProject/myfile2." + _primaryFileExtension_1);
      final Resource resource = rs.createResource(URI.createPlatformResourceURI(_plus, true));
      StringInputStream _stringInputStream = new StringInputStream("stuff bar");
      resource.load(_stringInputStream, CollectionLiterals.<Object, Object>emptyMap());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container MyProject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/MyProject/myfile1.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/MyProject/myfile2.testlanguage exported=[bar]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, this.formatContainers(rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private String formatContainers(final ResourceSet rs) {
    String _xblockexpression = null;
    {
      final IResourceDescriptions resourceDescriptions = this.resourceDescriptionProvider.getResourceDescriptions(rs);
      final IAllContainersState containerState = this.containerStateProvider.get(resourceDescriptions);
      final Function1<Resource, URI> _function = (Resource it) -> {
        return it.getURI();
      };
      final Set<URI> allURIs = IterableExtensions.<URI>toSet(ListExtensions.<Resource, URI>map(rs.getResources(), _function));
      final Function1<URI, String> _function_1 = (URI it) -> {
        return containerState.getContainerHandle(it);
      };
      final Set<String> allContainers = IterableExtensions.<String>toSet(IterableExtensions.<String>filterNull(IterableExtensions.<URI, String>map(allURIs, _function_1)));
      final Function1<IProject, String> _function_2 = (IProject it) -> {
        return it.getName();
      };
      List<String> _map = ListExtensions.<IProject, String>map(((List<IProject>)Conversions.doWrapArray(ResourcesPlugin.getWorkspace().getRoot().getProjects())), _function_2);
      Iterables.<String>addAll(allContainers, _map);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final String container : allContainers) {
          _builder.append("container ");
          _builder.append(container);
          _builder.append(" isEmpty=");
          boolean _isEmpty = containerState.isEmpty(container);
          _builder.append(_isEmpty);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            final Function1<URI, String> _function_3 = (URI it) -> {
              return it.toString();
            };
            List<URI> _sortBy = IterableExtensions.<URI, String>sortBy(containerState.getContainedURIs(container), _function_3);
            for(final URI uri : _sortBy) {
              _builder.append("\t");
              _builder.append("resourceURI=");
              _builder.append(uri, "\t");
              _builder.append(" exported=[");
              final Function1<IEObjectDescription, QualifiedName> _function_4 = (IEObjectDescription it) -> {
                return it.getName();
              };
              String _join = IterableExtensions.join(IterableExtensions.<IEObjectDescription, QualifiedName>map(resourceDescriptions.getResourceDescription(uri).getExportedObjects(), _function_4), ", ");
              _builder.append(_join, "\t");
              _builder.append("]");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
