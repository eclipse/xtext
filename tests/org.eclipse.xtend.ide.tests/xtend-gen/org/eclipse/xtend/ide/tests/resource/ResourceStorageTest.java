/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.resource;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.ui.editor.SchedulingRuleFactory;
import org.eclipse.xtext.ui.generator.trace.StorageAwareTrace;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceStorageTest extends AbstractXtendUITestCase {
  public static class TestableStorageAwareTrace extends StorageAwareTrace {
    @Override
    public void setLocalStorage(final IStorage derivedResource) {
      super.setLocalStorage(derivedResource);
    }
    
    @Override
    public AbsoluteURI resolvePath(final IProject project, final SourceRelativeURI path) {
      return super.resolvePath(project, path);
    }
    
    @Override
    public AbsoluteURI resolvePath(final SourceRelativeURI path) {
      return super.resolvePath(path);
    }
  }
  
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
      IResourcesSetupUtil.waitForBuild();
      final URI uri = this.uriMapper.getUri(file);
      final URI uri2 = this.uriMapper.getUri(file2);
      IProject _project = file.getProject();
      final ResourceSet resourceSet = this.resourceSetProvider.get(_project);
      SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
      Resource _resource = resourceSet.getResource(uri2, true);
      final StorageAwareResource resource2 = ((StorageAwareResource) _resource);
      boolean _isLoadedFromStorage = resource2.isLoadedFromStorage();
      Assert.assertTrue(_isLoadedFromStorage);
      EcoreUtil.resolveAll(resource2);
      IResourceDescription _resourceDescription = resource2.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects = _resourceDescription.getExportedObjects();
      final Function1<IEObjectDescription, String> _function = new Function1<IEObjectDescription, String>() {
        @Override
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
      boolean _isLoadedFromStorage_1 = resource.isLoadedFromStorage();
      Assert.assertTrue(_isLoadedFromStorage_1);
      IResourceDescription _resourceDescription_1 = resource.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects_1 = _resourceDescription_1.getExportedObjects();
      final Function1<IEObjectDescription, String> _function_1 = new Function1<IEObjectDescription, String>() {
        @Override
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
  
  @Test
  public void testShouldLoadFromStorage() {
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
      final IFile file = this.helper.createFile("mypack/MyClass.xtend", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      final URI uri = this.uriMapper.getUri(file);
      IProject _project = file.getProject();
      final ResourceSet resourceSet = this.resourceSetProvider.get(_project);
      SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
      Resource _createResource = resourceSet.createResource(uri);
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final Procedure0 _function = new Procedure0() {
        @Override
        public void apply() {
          IResourceStorageFacade _resourceStorageFacade = resource.getResourceStorageFacade();
          boolean _shouldLoadFromStorage = _resourceStorageFacade.shouldLoadFromStorage(resource);
          Assert.assertTrue(_shouldLoadFromStorage);
        }
      };
      this.doWorkInJob(_function);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      file.delete(true, _nullProgressMonitor);
      IResourcesSetupUtil.waitForBuild();
      final Procedure0 _function_1 = new Procedure0() {
        @Override
        public void apply() {
          IResourceStorageFacade _resourceStorageFacade = resource.getResourceStorageFacade();
          boolean _shouldLoadFromStorage = _resourceStorageFacade.shouldLoadFromStorage(resource);
          Assert.assertFalse(_shouldLoadFromStorage);
        }
      };
      this.doWorkInJob(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void doWorkInJob(final Procedure0 work) {
    try {
      final ArrayList<Throwable> throwables = CollectionLiterals.<Throwable>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      Class<? extends ResourceStorageTest> _class = this.getClass();
      String _name = _class.getName();
      _builder.append(_name, "");
      _builder.append(".TestJob");
      final Procedure1<Job> _function = new Procedure1<Job>() {
        @Override
        public void apply(final Job it) {
          ISchedulingRule _newSequence = SchedulingRuleFactory.INSTANCE.newSequence();
          it.setRule(_newSequence);
        }
      };
      final Job testShouldLoadFromStorageJob = ObjectExtensions.<Job>operator_doubleArrow(new Job(_builder.toString()) {
        @Override
        protected IStatus run(final IProgressMonitor monitor) {
          IStatus _xblockexpression = null;
          {
            try {
              work.apply();
            } catch (final Throwable _t) {
              if (_t instanceof Throwable) {
                final Throwable t = (Throwable)_t;
                throwables.add(t);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            _xblockexpression = Status.OK_STATUS;
          }
          return _xblockexpression;
        }
      }, _function);
      testShouldLoadFromStorageJob.schedule();
      testShouldLoadFromStorageJob.join();
      final Throwable t = IterableExtensions.<Throwable>head(throwables);
      boolean _notEquals = (!Objects.equal(t, null));
      if (_notEquals) {
        Throwables.propagate(t);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDecodeURI() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public def void foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile file = this.helper.createFile("mypack/MyClass Foo.xtend", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      final ResourceStorageTest.TestableStorageAwareTrace storageAwareTrace = new ResourceStorageTest.TestableStorageAwareTrace();
      Injector _injector = this.getInjector();
      _injector.injectMembers(storageAwareTrace);
      storageAwareTrace.setLocalStorage(file);
      URI _createURI = URI.createURI("mypack/MyClass%20Foo.xtend");
      SourceRelativeURI _sourceRelativeURI = new SourceRelativeURI(_createURI);
      AbsoluteURI result = storageAwareTrace.resolvePath(_sourceRelativeURI);
      String _string = result.toString();
      Assert.assertEquals("platform:/resource/test.project/src/mypack/MyClass%20Foo.xtend", _string);
      IProject _project = this.helper.getProject();
      URI _createURI_1 = URI.createURI("src/mypack/MyClass%20Foo.xtend");
      SourceRelativeURI _sourceRelativeURI_1 = new SourceRelativeURI(_createURI_1);
      AbsoluteURI _resolvePath = storageAwareTrace.resolvePath(_project, _sourceRelativeURI_1);
      result = _resolvePath;
      String _string_1 = result.toString();
      Assert.assertEquals("platform:/resource/test.project/src/mypack/MyClass%20Foo.xtend", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
