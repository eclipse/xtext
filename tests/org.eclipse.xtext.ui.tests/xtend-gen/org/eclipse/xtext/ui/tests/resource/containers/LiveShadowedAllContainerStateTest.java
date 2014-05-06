/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.resource.containers;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.XtextLiveScopeResourceSetProvider;
import org.eclipse.xtext.ui.tests.Activator;
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
    Activator _instance = Activator.getInstance();
    Injector _injector = _instance.getInjector(Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE);
    _injector.injectMembers(this);
  }
  
  @After
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  @Test
  public void testInMemoryResourceWithoutProject() {
    try {
      final XtextResourceSet rs = new XtextResourceSet();
      Map<Object, Object> _loadOptions = rs.getLoadOptions();
      _loadOptions.put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
      String _primaryFileExtension = this._fileExtensionProvider.getPrimaryFileExtension();
      String _plus = ("myproject/myfile." + _primaryFileExtension);
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_plus, true);
      final Resource resource = rs.createResource(_createPlatformResourceURI);
      StringInputStream _stringInputStream = new StringInputStream("stuff foo");
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      resource.load(_stringInputStream, _emptyMap);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container myproject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/myproject/myfile.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      String _formatContainers = this.formatContainers(rs);
      Assert.assertEquals(expected, _formatContainers);
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
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_plus, true);
      final Resource resource = rs.createResource(_createPlatformResourceURI);
      StringInputStream _stringInputStream = new StringInputStream("stuff foo");
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      resource.load(_stringInputStream, _emptyMap);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container MyProject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      String _formatContainers = this.formatContainers(rs);
      Assert.assertEquals(expected, _formatContainers);
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
      String _formatContainers = this.formatContainers(rs);
      Assert.assertEquals(expected, _formatContainers);
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
      IResourcesSetupUtil.waitForAutoBuild();
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
      String _formatContainers = this.formatContainers(rs);
      Assert.assertEquals(expected, _formatContainers);
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
      IResourcesSetupUtil.waitForAutoBuild();
      final ResourceSet rs = this.liveScopeResourceSetProvider.get(project);
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(fileName, true);
      Resource _resource = rs.getResource(_createPlatformResourceURI, true);
      Assert.assertNotNull(_resource);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("container MyProject isEmpty=false {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      String _formatContainers = this.formatContainers(rs);
      Assert.assertEquals(expected, _formatContainers);
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
      IResourcesSetupUtil.waitForAutoBuild();
      final ResourceSet rs = this.liveScopeResourceSetProvider.get(project);
      String _primaryFileExtension_1 = this._fileExtensionProvider.getPrimaryFileExtension();
      String _plus = ("MyProject/myfile2." + _primaryFileExtension_1);
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_plus, true);
      final Resource resource = rs.createResource(_createPlatformResourceURI);
      StringInputStream _stringInputStream = new StringInputStream("stuff bar");
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      resource.load(_stringInputStream, _emptyMap);
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
      String _formatContainers = this.formatContainers(rs);
      Assert.assertEquals(expected, _formatContainers);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private String formatContainers(final ResourceSet rs) {
    String _xblockexpression = null;
    {
      final IResourceDescriptions resourceDescriptions = this.resourceDescriptionProvider.getResourceDescriptions(rs);
      final IAllContainersState containerState = this.containerStateProvider.get(resourceDescriptions);
      EList<Resource> _resources = rs.getResources();
      final Function1<Resource, URI> _function = new Function1<Resource, URI>() {
        public URI apply(final Resource it) {
          return it.getURI();
        }
      };
      List<URI> _map = ListExtensions.<Resource, URI>map(_resources, _function);
      final Set<URI> allURIs = IterableExtensions.<URI>toSet(_map);
      final Function1<URI, String> _function_1 = new Function1<URI, String>() {
        public String apply(final URI it) {
          return containerState.getContainerHandle(it);
        }
      };
      Iterable<String> _map_1 = IterableExtensions.<URI, String>map(allURIs, _function_1);
      Iterable<String> _filterNull = IterableExtensions.<String>filterNull(_map_1);
      final Set<String> allContainers = IterableExtensions.<String>toSet(_filterNull);
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      IProject[] _projects = _root.getProjects();
      final Function1<IProject, String> _function_2 = new Function1<IProject, String>() {
        public String apply(final IProject it) {
          return it.getName();
        }
      };
      List<String> _map_2 = ListExtensions.<IProject, String>map(((List<IProject>)Conversions.doWrapArray(_projects)), _function_2);
      Iterables.<String>addAll(allContainers, _map_2);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final String container : allContainers) {
          _builder.append("container ");
          _builder.append(container, "");
          _builder.append(" isEmpty=");
          boolean _isEmpty = containerState.isEmpty(container);
          _builder.append(_isEmpty, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            Collection<URI> _containedURIs = containerState.getContainedURIs(container);
            final Function1<URI, String> _function_3 = new Function1<URI, String>() {
              public String apply(final URI it) {
                return it.toString();
              }
            };
            List<URI> _sortBy = IterableExtensions.<URI, String>sortBy(_containedURIs, _function_3);
            for(final URI uri : _sortBy) {
              _builder.append("\t");
              _builder.append("resourceURI=");
              _builder.append(uri, "\t");
              _builder.append(" exported=[");
              IResourceDescription _resourceDescription = resourceDescriptions.getResourceDescription(uri);
              Iterable<IEObjectDescription> _exportedObjects = _resourceDescription.getExportedObjects();
              final Function1<IEObjectDescription, QualifiedName> _function_4 = new Function1<IEObjectDescription, QualifiedName>() {
                public QualifiedName apply(final IEObjectDescription it) {
                  return it.getName();
                }
              };
              Iterable<QualifiedName> _map_3 = IterableExtensions.<IEObjectDescription, QualifiedName>map(_exportedObjects, _function_4);
              String _join = IterableExtensions.join(_map_3, ", ");
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
