/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.macros;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtend.ide.builder.UIResourceChangeRegistry;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class UIResourceChangeRegistryTest extends AbstractXtendUITestCase {
  public static class TestUiResourceChangeRegistry extends UIResourceChangeRegistry {
    public volatile boolean waitForEvent = false;
    
    public List<URI> queuedURIs = CollectionLiterals.<URI>newArrayList();
    
    @Override
    public void queueURIs(final Set<URI> interestedFiles) {
      Iterables.<URI>addAll(this.queuedURIs, interestedFiles);
    }
    
    @Inject
    @Override
    public void init(final IWorkspace workspace) {
      workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
    }
    
    @Override
    public void resourceChanged(final IResourceChangeEvent event) {
      super.resourceChanged(event);
      this.waitForEvent = false;
    }
    
    public static String toReadableString(final IResourceDelta delta) {
      StringConcatenation _builder = new StringConcatenation();
      IPath _fullPath = delta.getFullPath();
      _builder.append(_fullPath, "");
      _builder.append(" ");
      String _switchResult = null;
      int _kind = delta.getKind();
      switch (_kind) {
        case IResourceDelta.ADDED:
          _switchResult = "ADDED";
          break;
        case IResourceDelta.REMOVED:
          _switchResult = "REMOVED";
          break;
        case IResourceDelta.CHANGED:
          _switchResult = "CHANGED";
          break;
      }
      _builder.append(_switchResult, "");
      _builder.append(" ");
      Pair<Integer, String> _mappedTo = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.CONTENT), "CONTENT");
      Pair<Integer, String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.DERIVED_CHANGED), "DERIVED_CHANGED");
      Pair<Integer, String> _mappedTo_2 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.DESCRIPTION), "DESCRIPTION");
      Pair<Integer, String> _mappedTo_3 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.ENCODING), "ENCODING");
      Pair<Integer, String> _mappedTo_4 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.LOCAL_CHANGED), "LOCAL_CHANGED");
      Pair<Integer, String> _mappedTo_5 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.OPEN), "OPEN");
      Pair<Integer, String> _mappedTo_6 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.MOVED_TO), "MOVED_TO");
      Pair<Integer, String> _mappedTo_7 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.MOVED_FROM), "MOVED_FROM");
      Pair<Integer, String> _mappedTo_8 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.COPIED_FROM), "COPIED_FROM");
      Pair<Integer, String> _mappedTo_9 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.TYPE), "TYPE");
      Pair<Integer, String> _mappedTo_10 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.SYNC), "SYNC");
      Pair<Integer, String> _mappedTo_11 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.MARKERS), "MARKERS");
      Pair<Integer, String> _mappedTo_12 = Pair.<Integer, String>of(Integer.valueOf(IResourceDelta.REPLACED), "REPLACED");
      final Function1<Pair<Integer, String>, String> _function = new Function1<Pair<Integer, String>, String>() {
        @Override
        public String apply(final Pair<Integer, String> it) {
          String _xifexpression = null;
          int _flags = delta.getFlags();
          Integer _key = it.getKey();
          int _bitwiseAnd = (_flags & (_key).intValue());
          boolean _notEquals = (_bitwiseAnd != 0);
          if (_notEquals) {
            _xifexpression = it.getValue();
          } else {
            _xifexpression = null;
          }
          return _xifexpression;
        }
      };
      List<String> _map = ListExtensions.<Pair<Integer, String>, String>map(Collections.<Pair<Integer, String>>unmodifiableList(CollectionLiterals.<Pair<Integer, String>>newArrayList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10, _mappedTo_11, _mappedTo_12)), _function);
      Iterable<String> _filterNull = IterableExtensions.<String>filterNull(_map);
      String _join = IterableExtensions.join(_filterNull, ",");
      _builder.append(_join, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        IResourceDelta[] _affectedChildren = delta.getAffectedChildren();
        for(final IResourceDelta child : _affectedChildren) {
          _builder.append("\t");
          String _readableString = UIResourceChangeRegistryTest.TestUiResourceChangeRegistry.toReadableString(child);
          _builder.append(_readableString, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }
  
  @Inject
  private UIResourceChangeRegistryTest.TestUiResourceChangeRegistry resourceChangeRegistry;
  
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Rule
  public StopwatchRule rule = new StopwatchRule(true);
  
  @After
  @Override
  public void tearDown() {
    try {
      IProject _project = this.workbenchTestHelper.getProject();
      _project.delete(true, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final URI uri = URI.createURI("synthetic://testing/uri");
  
  @Test
  public void testConcurrentDiscard() throws Exception {
    try {
      IntegerRange _upTo = new IntegerRange(1, 10000);
      for (final Integer it : _upTo) {
        String _string = it.toString();
        URI _appendSegment = this.uri.appendSegment(_string);
        this.resourceChangeRegistry.registerCreateOrModify("/foo", _appendSegment);
      }
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          final SecureRandom random = new SecureRandom(new byte[] { ((byte) 1) });
          IntegerRange _upTo = new IntegerRange(1, 1000);
          for (final Integer it : _upTo) {
            {
              int _nextInt = random.nextInt(10000);
              String _string = Integer.valueOf(_nextInt).toString();
              final URI removedURI = UIResourceChangeRegistryTest.this.uri.appendSegment(_string);
              UIResourceChangeRegistryTest.this.resourceChangeRegistry.discardCreateOrModifyInformation(removedURI);
            }
          }
        }
      };
      final Runnable r = _function;
      final ExecutorService executorService = Executors.newCachedThreadPool();
      try {
        final Future<?> future1 = executorService.submit(r);
        final Future<?> future2 = executorService.submit(r);
        final Future<?> future3 = executorService.submit(r);
        final Future<?> future4 = executorService.submit(r);
        future1.get();
        future2.get();
        future3.get();
        future4.get();
      } catch (final Throwable _t) {
        if (_t instanceof ExecutionException) {
          final ExecutionException e = (ExecutionException)_t;
          throw e.getCause();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        executorService.shutdown();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSerialization() {
    this.resourceChangeRegistry.registerExists("/foo", this.uri);
    this.resourceChangeRegistry.registerExists("/foo/bar", this.uri);
    URI _appendFragment = this.uri.appendFragment("fragment");
    this.resourceChangeRegistry.registerExists("/foo/bar", _appendFragment);
    this.resourceChangeRegistry.registerGetCharset("/foo", this.uri);
    this.resourceChangeRegistry.registerGetCharset("/foo/bar", this.uri);
    URI _appendFragment_1 = this.uri.appendFragment("fragment");
    this.resourceChangeRegistry.registerGetCharset("/foo/bar", _appendFragment_1);
    this.resourceChangeRegistry.registerGetChildren("/foo", this.uri);
    this.resourceChangeRegistry.registerGetChildren("/foo/bar", this.uri);
    URI _appendFragment_2 = this.uri.appendFragment("fragment");
    this.resourceChangeRegistry.registerGetChildren("/foo/bar", _appendFragment_2);
    this.resourceChangeRegistry.registerGetContents("/foo", this.uri);
    this.resourceChangeRegistry.registerGetContents("/foo/bar", this.uri);
    URI _appendFragment_3 = this.uri.appendFragment("fragment");
    this.resourceChangeRegistry.registerGetContents("/foo/bar", _appendFragment_3);
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    this.resourceChangeRegistry.writeState(out);
    final UIResourceChangeRegistryTest.TestUiResourceChangeRegistry copy = new UIResourceChangeRegistryTest.TestUiResourceChangeRegistry();
    byte[] _byteArray = out.toByteArray();
    ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
    copy.readState(_byteArrayInputStream);
    HashMultimap<String, URI> _existsListeners = this.resourceChangeRegistry.getExistsListeners();
    HashMultimap<String, URI> _existsListeners_1 = copy.getExistsListeners();
    Assert.assertEquals(_existsListeners, _existsListeners_1);
    HashMultimap<String, URI> _charsetListeners = this.resourceChangeRegistry.getCharsetListeners();
    HashMultimap<String, URI> _charsetListeners_1 = copy.getCharsetListeners();
    Assert.assertEquals(_charsetListeners, _charsetListeners_1);
    HashMultimap<String, URI> _contentsListeners = this.resourceChangeRegistry.getContentsListeners();
    HashMultimap<String, URI> _contentsListeners_1 = copy.getContentsListeners();
    Assert.assertEquals(_contentsListeners, _contentsListeners_1);
    HashMultimap<String, URI> _childrenListeners = this.resourceChangeRegistry.getChildrenListeners();
    HashMultimap<String, URI> _childrenListeners_1 = copy.getChildrenListeners();
    Assert.assertEquals(_childrenListeners, _childrenListeners_1);
  }
  
  @Test
  public void testFolderExists() {
    try {
      final String folderPath = "/foo/bar";
      this.resourceChangeRegistry.registerExists(folderPath, this.uri);
      HashMultimap<String, URI> _existsListeners = this.resourceChangeRegistry.getExistsListeners();
      boolean _containsKey = _existsListeners.containsKey(folderPath);
      Assert.assertTrue(_containsKey);
      final IProject project = WorkbenchTestHelper.createPluginProject("foo");
      HashMultimap<String, URI> _existsListeners_1 = this.resourceChangeRegistry.getExistsListeners();
      boolean _containsKey_1 = _existsListeners_1.containsKey(folderPath);
      Assert.assertTrue(_containsKey_1);
      final IFolder folder = project.getFolder("bar");
      HashMultimap<String, URI> _existsListeners_2 = this.resourceChangeRegistry.getExistsListeners();
      boolean _containsKey_2 = _existsListeners_2.containsKey(folderPath);
      Assert.assertTrue(_containsKey_2);
      final WorkspaceModifyOperation _function = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.create(true, true, null);
        }
      };
      this.modifyWorkspace(_function);
      HashMultimap<String, URI> _existsListeners_3 = this.resourceChangeRegistry.getExistsListeners();
      boolean _containsKey_3 = _existsListeners_3.containsKey(folderPath);
      Assert.assertFalse(_containsKey_3);
      int _size = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(1, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFolderChildren() {
    try {
      final IProject project = WorkbenchTestHelper.createPluginProject("foo");
      final String folderPath = "/foo/bar";
      this.resourceChangeRegistry.registerGetChildren(folderPath, this.uri);
      HashMultimap<String, URI> _childrenListeners = this.resourceChangeRegistry.getChildrenListeners();
      boolean _containsKey = _childrenListeners.containsKey(folderPath);
      Assert.assertTrue(_containsKey);
      final IFolder folder = project.getFolder("bar");
      final WorkspaceModifyOperation _function = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.create(true, true, null);
        }
      };
      this.modifyWorkspace(_function);
      HashMultimap<String, URI> _childrenListeners_1 = this.resourceChangeRegistry.getChildrenListeners();
      boolean _containsKey_1 = _childrenListeners_1.containsKey(folderPath);
      Assert.assertFalse(_containsKey_1);
      int _size = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(1, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFolderChildren_AddedChild() {
    try {
      final IProject project = WorkbenchTestHelper.createPluginProject("foo");
      final IFolder folder = project.getFolder("bar");
      final WorkspaceModifyOperation _function = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.create(true, true, null);
        }
      };
      this.modifyWorkspace(_function);
      final String folderPath = "/foo/bar";
      this.resourceChangeRegistry.registerGetChildren(folderPath, this.uri);
      final WorkspaceModifyOperation _function_1 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          IFile _file = folder.getFile("test.txt");
          StringInputStream _stringInputStream = new StringInputStream("Hello World");
          _file.create(_stringInputStream, true, null);
        }
      };
      this.modifyWorkspace(_function_1);
      HashMultimap<String, URI> _childrenListeners = this.resourceChangeRegistry.getChildrenListeners();
      boolean _containsKey = _childrenListeners.containsKey(folderPath);
      Assert.assertFalse(_containsKey);
      int _size = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(1, _size);
      this.resourceChangeRegistry.registerGetChildren(folderPath, this.uri);
      final WorkspaceModifyOperation _function_2 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          IFile _file = folder.getFile("test.txt");
          StringInputStream _stringInputStream = new StringInputStream("Hello Xtend");
          _file.setContents(_stringInputStream, true, true, null);
        }
      };
      this.modifyWorkspace(_function_2);
      HashMultimap<String, URI> _childrenListeners_1 = this.resourceChangeRegistry.getChildrenListeners();
      boolean _containsKey_1 = _childrenListeners_1.containsKey(folderPath);
      Assert.assertTrue(_containsKey_1);
      int _size_1 = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(1, _size_1);
      final WorkspaceModifyOperation _function_3 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          IFile _file = folder.getFile("test.txt");
          _file.delete(true, true, null);
        }
      };
      this.modifyWorkspace(_function_3);
      HashMultimap<String, URI> _childrenListeners_2 = this.resourceChangeRegistry.getChildrenListeners();
      boolean _containsKey_2 = _childrenListeners_2.containsKey(folderPath);
      Assert.assertFalse(_containsKey_2);
      int _size_2 = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(2, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFileContents_changed() {
    try {
      final IProject project = WorkbenchTestHelper.createPluginProject("foo");
      final IFolder folder = project.getFolder("bar");
      final WorkspaceModifyOperation _function = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.create(true, true, null);
          IFile _file = folder.getFile("test.txt");
          StringInputStream _stringInputStream = new StringInputStream("Hello");
          _file.create(_stringInputStream, true, null);
        }
      };
      this.modifyWorkspace(_function);
      final String folderPath = "/foo/bar/test.txt";
      this.resourceChangeRegistry.registerGetContents(folderPath, this.uri);
      final WorkspaceModifyOperation _function_1 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          IFile _file = folder.getFile("test.txt");
          StringInputStream _stringInputStream = new StringInputStream("Hello Xtend");
          _file.setContents(_stringInputStream, true, true, null);
        }
      };
      this.modifyWorkspace(_function_1);
      HashMultimap<String, URI> _contentsListeners = this.resourceChangeRegistry.getContentsListeners();
      boolean _containsKey = _contentsListeners.containsKey(folderPath);
      Assert.assertFalse(_containsKey);
      int _size = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(1, _size);
      this.resourceChangeRegistry.registerGetContents(folderPath, this.uri);
      final WorkspaceModifyOperation _function_2 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          IFile _file = folder.getFile("test.txt");
          _file.setCharset("UTF-8", null);
        }
      };
      this.modifyWorkspace(_function_2);
      HashMultimap<String, URI> _contentsListeners_1 = this.resourceChangeRegistry.getContentsListeners();
      boolean _containsKey_1 = _contentsListeners_1.containsKey(folderPath);
      Assert.assertFalse(_containsKey_1);
      int _size_1 = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(2, _size_1);
      this.resourceChangeRegistry.registerGetContents(folderPath, this.uri);
      final WorkspaceModifyOperation _function_3 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          IFile _file = folder.getFile("test.txt");
          _file.delete(true, true, null);
        }
      };
      this.modifyWorkspace(_function_3);
      HashMultimap<String, URI> _contentsListeners_2 = this.resourceChangeRegistry.getContentsListeners();
      boolean _containsKey_2 = _contentsListeners_2.containsKey(folderPath);
      Assert.assertFalse(_containsKey_2);
      int _size_2 = this.resourceChangeRegistry.queuedURIs.size();
      Assert.assertEquals(3, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void modifyWorkspace(final WorkspaceModifyOperation op) {
    try {
      this.resourceChangeRegistry.waitForEvent = true;
      op.run(null);
      while (this.resourceChangeRegistry.waitForEvent) {
        Thread.sleep(100);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
