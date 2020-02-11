/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.containers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.LiveContainerTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.LiveShadowedChunkedContainer;
import org.eclipse.xtext.resource.containers.ProjectConfig;
import org.eclipse.xtext.resource.containers.SourceFolder;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.liveContainerTestLanguage.LiveContainerTestLanguagePackage;
import org.eclipse.xtext.resource.liveContainerTestLanguage.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(LiveContainerTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class LiveShadowedChunkedContainerTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private IResourceDescription.Manager resourceDescriptionManager;
  
  @Inject
  private Provider<LiveShadowedChunkedResourceDescriptions> provider;
  
  private WorkspaceConfig workspaceConfig;
  
  private ProjectConfig fooProject;
  
  private ProjectConfig barProject;
  
  private URI fooURI;
  
  private URI barURI;
  
  private XtextResourceSet rs1;
  
  private LiveShadowedChunkedContainer fooContainer;
  
  private LiveShadowedChunkedContainer barContainer;
  
  private LiveShadowedChunkedResourceDescriptions liveShadowedChunkedResourceDescriptions;
  
  @Before
  public void setUp() {
    try {
      WorkspaceConfig _workspaceConfig = new WorkspaceConfig();
      this.workspaceConfig = _workspaceConfig;
      ProjectConfig _projectConfig = new ProjectConfig("foo", this.workspaceConfig);
      this.fooProject = _projectConfig;
      ProjectConfig _projectConfig_1 = new ProjectConfig("bar", this.workspaceConfig);
      this.barProject = _projectConfig_1;
      final XtextResourceSet rs0 = this.resourceSetProvider.get();
      this.fooURI = IterableExtensions.<SourceFolder>head(this.fooProject.getSourceFolders()).getPath().trimSegments(1).appendSegment("foo.livecontainertestlanguage");
      this.barURI = IterableExtensions.<SourceFolder>head(this.barProject.getSourceFolders()).getPath().trimSegments(1).appendSegment("bar.livecontainertestlanguage");
      ResourceDescriptionsData _createResourceDescriptionData = this.createResourceDescriptionData(this._parseHelper.parse("foo", this.fooURI, rs0).eResource());
      Pair<String, ResourceDescriptionsData> _mappedTo = Pair.<String, ResourceDescriptionsData>of("foo", _createResourceDescriptionData);
      ResourceDescriptionsData _createResourceDescriptionData_1 = this.createResourceDescriptionData(this._parseHelper.parse("bar", this.barURI, rs0).eResource());
      Pair<String, ResourceDescriptionsData> _mappedTo_1 = Pair.<String, ResourceDescriptionsData>of("bar", _createResourceDescriptionData_1);
      final Map<String, ResourceDescriptionsData> chunks = Collections.<String, ResourceDescriptionsData>unmodifiableMap(CollectionLiterals.<String, ResourceDescriptionsData>newHashMap(_mappedTo, _mappedTo_1));
      this.rs1 = this.resourceSetProvider.get();
      new ChunkedResourceDescriptions(chunks, this.rs1);
      ProjectConfigAdapter.install(this.rs1, this.fooProject);
      this.liveShadowedChunkedResourceDescriptions = this.provider.get();
      this.liveShadowedChunkedResourceDescriptions.setContext(this.rs1);
      LiveShadowedChunkedContainer _liveShadowedChunkedContainer = new LiveShadowedChunkedContainer(this.liveShadowedChunkedResourceDescriptions, "foo");
      this.fooContainer = _liveShadowedChunkedContainer;
      LiveShadowedChunkedContainer _liveShadowedChunkedContainer_1 = new LiveShadowedChunkedContainer(this.liveShadowedChunkedResourceDescriptions, "bar");
      this.barContainer = _liveShadowedChunkedContainer_1;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRenameElement() {
    try {
      this._parseHelper.parse("fooChange", this.fooURI, this.rs1);
      final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("fooChange", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(), _function), ","));
      final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("fooChange", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("fooChange"), false), _function_1), ","));
      final Function1<IEObjectDescription, String> _function_2 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("fooChange", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjectsByType(LiveContainerTestLanguagePackage.Literals.MODEL), _function_2), ","));
      Assert.assertEquals(1, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.fooContainer.getResourceDescriptionCount());
      Assert.assertTrue(this.fooContainer.hasResourceDescription(this.fooURI));
      Assert.assertFalse(this.fooContainer.hasResourceDescription(this.barURI));
      Assert.assertEquals(this.fooURI, this.fooContainer.getResourceDescription(this.fooURI).getURI());
      final Function1<IEObjectDescription, String> _function_3 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("bar", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(this.barContainer.getExportedObjects(), _function_3), ","));
      final Function1<IEObjectDescription, String> _function_4 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("bar", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(this.barContainer.getExportedObjects(LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("bar"), false), _function_4), ","));
      final Function1<IEObjectDescription, String> _function_5 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("bar", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(this.barContainer.getExportedObjectsByType(LiveContainerTestLanguagePackage.Literals.MODEL), _function_5), ","));
      Assert.assertEquals(1, IterableExtensions.size(this.barContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.barContainer.getResourceDescriptionCount());
      Assert.assertTrue(this.barContainer.hasResourceDescription(this.barURI));
      Assert.assertFalse(this.barContainer.hasResourceDescription(this.fooURI));
      Assert.assertEquals(this.barURI, this.barContainer.getResourceDescription(this.barURI).getURI());
      this.assertGlobalDescriptionsAreUnaffected();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddRemoveResource() {
    try {
      final Resource bazResource = this._parseHelper.parse("baz", IterableExtensions.<SourceFolder>head(this.fooProject.getSourceFolders()).getPath().trimSegments(1).appendSegment("baz.livecontainertestlanguage"), this.rs1).eResource();
      Assert.assertEquals(2, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(2, this.fooContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("baz,foo", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(), _function)), ","));
      Assert.assertEquals(1, IterableExtensions.size(this.barContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.barContainer.getResourceDescriptionCount());
      this.assertGlobalDescriptionsAreUnaffected();
      this.rs1.getResources().remove(bazResource);
      Assert.assertEquals(1, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.fooContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("foo", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(), _function_1)), ","));
      Assert.assertEquals(1, IterableExtensions.size(this.barContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.barContainer.getResourceDescriptionCount());
      this.assertGlobalDescriptionsAreUnaffected();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMoveResourceBetweenContainers() {
    try {
      final URI oldURI = IterableExtensions.<SourceFolder>head(this.fooProject.getSourceFolders()).getPath().trimSegments(1).appendSegment("baz.livecontainertestlanguage");
      final Resource bazResource = this._parseHelper.parse("baz", oldURI, this.rs1).eResource();
      Assert.assertEquals(2, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(2, this.fooContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("baz,foo", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(), _function)), ","));
      Assert.assertEquals(oldURI, IterableExtensions.<IEObjectDescription>head(this.fooContainer.getExportedObjects(LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("baz"), false)).getEObjectURI().trimFragment());
      Assert.assertEquals(1, IterableExtensions.size(this.barContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.barContainer.getResourceDescriptionCount());
      this.assertGlobalDescriptionsAreUnaffected();
      final URI newURI = URI.createURI(bazResource.getURI().toString().replace("/foo/", "/bar/"));
      bazResource.setURI(newURI);
      Assert.assertEquals(1, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.fooContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("foo", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(), _function_1)), ","));
      Assert.assertEquals(1, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.fooContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function_2 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("bar,baz", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(this.barContainer.getExportedObjects(), _function_2)), ","));
      Assert.assertEquals(2, IterableExtensions.size(this.barContainer.getResourceDescriptions()));
      Assert.assertEquals(2, this.barContainer.getResourceDescriptionCount());
      Assert.assertEquals(newURI, IterableExtensions.<IEObjectDescription>head(this.barContainer.getExportedObjects(LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("baz"), false)).getEObjectURI().trimFragment());
      this.assertGlobalDescriptionsAreUnaffected();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddToNewContainer() {
    try {
      final ProjectConfig bazProject = new ProjectConfig("baz", this.workspaceConfig);
      final URI newURI = IterableExtensions.<SourceFolder>head(bazProject.getSourceFolders()).getPath().trimSegments(1).appendSegment("baz.livecontainertestlanguage");
      this._parseHelper.parse("baz", newURI, this.rs1);
      final LiveShadowedChunkedContainer bazContainer = new LiveShadowedChunkedContainer(this.liveShadowedChunkedResourceDescriptions, "baz");
      Assert.assertEquals(1, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.fooContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("foo", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(), _function)), ","));
      Assert.assertEquals(1, IterableExtensions.size(this.barContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.barContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("bar", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(this.barContainer.getExportedObjects(), _function_1)), ","));
      Assert.assertEquals(1, IterableExtensions.size(bazContainer.getResourceDescriptions()));
      Assert.assertEquals(1, bazContainer.getResourceDescriptionCount());
      final Function1<IEObjectDescription, String> _function_2 = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("baz", IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<IEObjectDescription, String>map(bazContainer.getExportedObjects(), _function_2)), ","));
      Assert.assertEquals(newURI, IterableExtensions.<IEObjectDescription>head(bazContainer.getExportedObjects(LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("baz"), false)).getEObjectURI().trimFragment());
      this.assertGlobalDescriptionsAreUnaffected();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeleteElement() {
    try {
      this._parseHelper.parse("foo", this.fooURI, this.rs1).eResource().getContents().clear();
      final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
        return it.getQualifiedName().toString();
      };
      Assert.assertEquals("", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(this.fooContainer.getExportedObjects(), _function), ","));
      Assert.assertEquals(1, IterableExtensions.size(this.fooContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.fooContainer.getResourceDescriptionCount());
      Assert.assertEquals(0, IterableExtensions.size(this.fooContainer.getExportedObjects()));
      Assert.assertEquals(1, IterableExtensions.size(this.barContainer.getResourceDescriptions()));
      Assert.assertEquals(1, this.barContainer.getResourceDescriptionCount());
      this.assertGlobalDescriptionsAreUnaffected();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertGlobalDescriptionsAreUnaffected() {
    IResourceDescriptions _globalDescriptions = this.liveShadowedChunkedResourceDescriptions.getGlobalDescriptions();
    final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
      return it.getQualifiedName().toString();
    };
    Assert.assertEquals("foo", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(((ChunkedResourceDescriptions) _globalDescriptions).getContainer("foo").getExportedObjects(), _function), ","));
    IResourceDescriptions _globalDescriptions_1 = this.liveShadowedChunkedResourceDescriptions.getGlobalDescriptions();
    final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
      return it.getQualifiedName().toString();
    };
    Assert.assertEquals("bar", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(((ChunkedResourceDescriptions) _globalDescriptions_1).getContainer("bar").getExportedObjects(), _function_1), ","));
  }
  
  private ResourceDescriptionsData createResourceDescriptionData(final Resource... resources) {
    final Function1<Resource, IResourceDescription> _function = (Resource it) -> {
      return this.resourceDescriptionManager.getResourceDescription(it);
    };
    List<IResourceDescription> _map = ListExtensions.<Resource, IResourceDescription>map(((List<Resource>)Conversions.doWrapArray(resources)), _function);
    return new ResourceDescriptionsData(_map);
  }
}
