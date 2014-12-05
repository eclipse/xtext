/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.resource;

import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceStorageTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper helper;
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Inject
  private IStorage2UriMapper uriMapper;
  
  @Test
  public void testLoadFromStorage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public def void foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile file = this.helper.createFile("src/mypack/MyClass.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class OtherClass extends MyClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override foo() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile file2 = this.helper.createFile("src/mypack/OtherClass.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      final URI uri = this.uriMapper.getUri(file);
      final URI uri2 = this.uriMapper.getUri(file2);
      IProject _project = file.getProject();
      final ResourceSet resourceSet = this.resourceSetProvider.get(_project);
      SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
      Resource _resource = resourceSet.getResource(uri2, true);
      final StorageAwareResource resource2 = ((StorageAwareResource) _resource);
      boolean _isIsLoadedFromStorage = resource2.isIsLoadedFromStorage();
      Assert.assertTrue(_isIsLoadedFromStorage);
      EcoreUtil.resolveAll(resource2);
      IResourceDescription _resourceDescription = resource2.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects = _resourceDescription.getExportedObjects();
      final Function1<IEObjectDescription, String> _function = new Function1<IEObjectDescription, String>() {
        public String apply(final IEObjectDescription it) {
          QualifiedName _name = it.getName();
          return _name.toString();
        }
      };
      Iterable<String> _map = IterableExtensions.<IEObjectDescription, String>map(_exportedObjects, _function);
      String _join = IterableExtensions.join(_map, ",");
      Assert.assertEquals("mypack.OtherClass", _join);
      Resource _resource_1 = resourceSet.getResource(uri, false);
      final StorageAwareResource resource = ((StorageAwareResource) _resource_1);
      boolean _isIsLoadedFromStorage_1 = resource.isIsLoadedFromStorage();
      Assert.assertTrue(_isIsLoadedFromStorage_1);
      IResourceDescription _resourceDescription_1 = resource.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects_1 = _resourceDescription_1.getExportedObjects();
      final Function1<IEObjectDescription, String> _function_1 = new Function1<IEObjectDescription, String>() {
        public String apply(final IEObjectDescription it) {
          QualifiedName _name = it.getName();
          return _name.toString();
        }
      };
      Iterable<String> _map_1 = IterableExtensions.<IEObjectDescription, String>map(_exportedObjects_1, _function_1);
      String _join_1 = IterableExtensions.join(_map_1, ",");
      Assert.assertEquals("mypack.MyClass", _join_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
