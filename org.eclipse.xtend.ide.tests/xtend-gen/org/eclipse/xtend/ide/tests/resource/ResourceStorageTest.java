/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.resource;

import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.ui.editor.SchedulingRuleFactory;
import org.eclipse.xtext.ui.generator.trace.StorageAwareTrace;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
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
      final ResourceSet resourceSet = this.resourceSetProvider.get(file.getProject());
      SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
      Resource _resource = resourceSet.getResource(uri2, true);
      final StorageAwareResource resource2 = ((StorageAwareResource) _resource);
      Assert.assertTrue(resource2.isLoadedFromStorage());
      EcoreUtil.resolveAll(resource2);
      final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
        return it.getName().toString();
      };
      Assert.assertEquals("mypack.OtherClass", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(resource2.getResourceDescription().getExportedObjects(), _function), ","));
      Resource _resource_1 = resourceSet.getResource(uri, false);
      final StorageAwareResource resource = ((StorageAwareResource) _resource_1);
      Assert.assertTrue(resource.isLoadedFromStorage());
      final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
        return it.getName().toString();
      };
      Assert.assertEquals("mypack.MyClass", IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(resource.getResourceDescription().getExportedObjects(), _function_1), ","));
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
      final ResourceSet resourceSet = this.resourceSetProvider.get(file.getProject());
      SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
      Resource _createResource = resourceSet.createResource(uri);
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final Procedure0 _function = () -> {
        Assert.assertTrue(resource.getResourceStorageFacade().shouldLoadFromStorage(resource));
      };
      this.doWorkInJob(_function);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      file.delete(true, _nullProgressMonitor);
      IResourcesSetupUtil.waitForBuild();
      final Procedure0 _function_1 = () -> {
        Assert.assertFalse(resource.getResourceStorageFacade().shouldLoadFromStorage(resource));
      };
      this.doWorkInJob(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testUpstreamResourcesAreLoadedFromStorage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.helper.createFile("mypack/MyClass.xtend", _builder.toString());
      final IProject downStreamProject = WorkbenchTestHelper.createPluginProject("downstream", this.helper.getProject().getName());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package downstream");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class SomeClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void foo(mypack.MyClass myClass) {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile downstreamFile = this.helper.createFileImpl("/downstream/src/downstream/SomeClass.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      final URI downstreamUri = this.uriMapper.getUri(downstreamFile);
      final ResourceSet resourceSet = this.resourceSetProvider.get(downStreamProject);
      SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(downstreamUri)));
      Resource _resource = resourceSet.getResource(downstreamUri, true);
      final StorageAwareResource downstreamResource = ((StorageAwareResource) _resource);
      EObject _get = downstreamResource.getContents().get(1);
      final JvmGenericType type = ((JvmGenericType) _get);
      final JvmType parameterType = IterableExtensions.<JvmFormalParameter>head(IterableExtensions.<JvmOperation>head(Iterables.<JvmOperation>filter(type.getMembers(), JvmOperation.class)).getParameters()).getParameterType().getType();
      Assert.assertNotNull(parameterType);
      Resource _eResource = parameterType.eResource();
      Assert.assertTrue(((StorageAwareResource) _eResource).isLoadedFromStorage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void doWorkInJob(final Procedure0 work) {
    try {
      final ArrayList<Throwable> throwables = CollectionLiterals.<Throwable>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String _name = this.getClass().getName();
      _builder.append(_name);
      _builder.append(".TestJob");
      final Procedure1<Job> _function = (Job it) -> {
        it.setRule(SchedulingRuleFactory.INSTANCE.newSequence());
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
      if ((t != null)) {
        Throwables.throwIfUnchecked(t);
        throw new RuntimeException(t);
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
      this.getInjector().injectMembers(storageAwareTrace);
      storageAwareTrace.setLocalStorage(file);
      URI _createURI = URI.createURI("mypack/MyClass%20Foo.xtend");
      SourceRelativeURI _sourceRelativeURI = new SourceRelativeURI(_createURI);
      AbsoluteURI result = storageAwareTrace.resolvePath(_sourceRelativeURI);
      Assert.assertEquals("platform:/resource/test.project/src/mypack/MyClass%20Foo.xtend", result.toString());
      IProject _project = this.helper.getProject();
      URI _createURI_1 = URI.createURI("src/mypack/MyClass%20Foo.xtend");
      SourceRelativeURI _sourceRelativeURI_1 = new SourceRelativeURI(_createURI_1);
      result = storageAwareTrace.resolvePath(_project, _sourceRelativeURI_1);
      Assert.assertEquals("platform:/resource/test.project/src/mypack/MyClass%20Foo.xtend", result.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
