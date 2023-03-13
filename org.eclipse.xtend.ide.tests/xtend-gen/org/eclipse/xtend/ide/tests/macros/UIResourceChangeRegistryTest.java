/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.macros;

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
import java.util.function.Consumer;
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
import org.eclipse.xtend.ide.tests.StopwatchRule;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
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
    public synchronized void resourceChanged(final IResourceChangeEvent event) {
      super.resourceChanged(event);
      this.waitForEvent = false;
    }

    public static String toReadableString(final IResourceDelta delta) {
      StringConcatenation _builder = new StringConcatenation();
      IPath _fullPath = delta.getFullPath();
      _builder.append(_fullPath);
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
      _builder.append(_switchResult);
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
      final Function1<Pair<Integer, String>, String> _function = (Pair<Integer, String> it) -> {
        String _xifexpression = null;
        if (((delta.getFlags() & (it.getKey()).intValue()) != 0)) {
          _xifexpression = it.getValue();
        } else {
          _xifexpression = null;
        }
        return _xifexpression;
      };
      String _join = IterableExtensions.join(IterableExtensions.<String>filterNull(ListExtensions.<Pair<Integer, String>, String>map(Collections.<Pair<Integer, String>>unmodifiableList(CollectionLiterals.<Pair<Integer, String>>newArrayList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10, _mappedTo_11, _mappedTo_12)), _function)), ",");
      _builder.append(_join);
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
      this.workbenchTestHelper.getProject().delete(true, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private final URI uri = URI.createURI("synthetic://testing/uri");

  @Test
  public void testConcurrentDiscard() throws Exception {
    try {
      final Consumer<Integer> _function = (Integer it) -> {
        this.resourceChangeRegistry.registerCreateOrModify("/foo", this.uri.appendSegment(it.toString()));
      };
      new IntegerRange(1, 10000).forEach(_function);
      final Runnable _function_1 = () -> {
        final SecureRandom random = new SecureRandom(new byte[] { ((byte) 1) });
        final Consumer<Integer> _function_2 = (Integer it) -> {
          final URI removedURI = this.uri.appendSegment(Integer.valueOf(random.nextInt(10000)).toString());
          this.resourceChangeRegistry.discardCreateOrModifyInformation(removedURI);
        };
        new IntegerRange(1, 1000).forEach(_function_2);
      };
      final Runnable r = _function_1;
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
    this.resourceChangeRegistry.registerExists("/foo/bar", this.uri.appendFragment("fragment"));
    this.resourceChangeRegistry.registerGetCharset("/foo", this.uri);
    this.resourceChangeRegistry.registerGetCharset("/foo/bar", this.uri);
    this.resourceChangeRegistry.registerGetCharset("/foo/bar", this.uri.appendFragment("fragment"));
    this.resourceChangeRegistry.registerGetChildren("/foo", this.uri);
    this.resourceChangeRegistry.registerGetChildren("/foo/bar", this.uri);
    this.resourceChangeRegistry.registerGetChildren("/foo/bar", this.uri.appendFragment("fragment"));
    this.resourceChangeRegistry.registerGetContents("/foo", this.uri);
    this.resourceChangeRegistry.registerGetContents("/foo/bar", this.uri);
    this.resourceChangeRegistry.registerGetContents("/foo/bar", this.uri.appendFragment("fragment"));
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    this.resourceChangeRegistry.writeState(out);
    final UIResourceChangeRegistryTest.TestUiResourceChangeRegistry copy = new UIResourceChangeRegistryTest.TestUiResourceChangeRegistry();
    byte[] _byteArray = out.toByteArray();
    ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
    copy.readState(_byteArrayInputStream);
    Assert.assertEquals(this.resourceChangeRegistry.getExistsListeners(), copy.getExistsListeners());
    Assert.assertEquals(this.resourceChangeRegistry.getCharsetListeners(), copy.getCharsetListeners());
    Assert.assertEquals(this.resourceChangeRegistry.getContentsListeners(), copy.getContentsListeners());
    Assert.assertEquals(this.resourceChangeRegistry.getChildrenListeners(), copy.getChildrenListeners());
  }

  @Test
  public void testFolderExists() {
    try {
      final String folderPath = "/foo/bar";
      this.resourceChangeRegistry.registerExists(folderPath, this.uri);
      Assert.assertTrue(this.resourceChangeRegistry.getExistsListeners().containsKey(folderPath));
      final IProject project = WorkbenchTestHelper.createPluginProject("foo");
      Assert.assertTrue(this.resourceChangeRegistry.getExistsListeners().containsKey(folderPath));
      final IFolder folder = project.getFolder("bar");
      Assert.assertTrue(this.resourceChangeRegistry.getExistsListeners().containsKey(folderPath));
      final WorkspaceModifyOperation _function = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.create(true, true, null);
        }
      };
      this.modifyWorkspace(_function);
      Assert.assertFalse(this.resourceChangeRegistry.getExistsListeners().containsKey(folderPath));
      Assert.assertEquals(1, this.resourceChangeRegistry.queuedURIs.size());
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
      Assert.assertTrue(this.resourceChangeRegistry.getChildrenListeners().containsKey(folderPath));
      final IFolder folder = project.getFolder("bar");
      final WorkspaceModifyOperation _function = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.create(true, true, null);
        }
      };
      this.modifyWorkspace(_function);
      Assert.assertFalse(this.resourceChangeRegistry.getChildrenListeners().containsKey(folderPath));
      Assert.assertEquals(1, this.resourceChangeRegistry.queuedURIs.size());
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
      Assert.assertFalse(this.resourceChangeRegistry.getChildrenListeners().containsKey(folderPath));
      Assert.assertEquals(1, this.resourceChangeRegistry.queuedURIs.size());
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
      Assert.assertTrue(this.resourceChangeRegistry.getChildrenListeners().containsKey(folderPath));
      Assert.assertEquals(1, this.resourceChangeRegistry.queuedURIs.size());
      final WorkspaceModifyOperation _function_3 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.getFile("test.txt").delete(true, true, null);
        }
      };
      this.modifyWorkspace(_function_3);
      Assert.assertFalse(this.resourceChangeRegistry.getChildrenListeners().containsKey(folderPath));
      Assert.assertEquals(2, this.resourceChangeRegistry.queuedURIs.size());
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
      Assert.assertFalse(this.resourceChangeRegistry.getContentsListeners().containsKey(folderPath));
      Assert.assertEquals(1, this.resourceChangeRegistry.queuedURIs.size());
      this.resourceChangeRegistry.registerGetContents(folderPath, this.uri);
      final WorkspaceModifyOperation _function_2 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.getFile("test.txt").setCharset("UTF-8", null);
        }
      };
      this.modifyWorkspace(_function_2);
      Assert.assertFalse(this.resourceChangeRegistry.getContentsListeners().containsKey(folderPath));
      Assert.assertEquals(2, this.resourceChangeRegistry.queuedURIs.size());
      this.resourceChangeRegistry.registerGetContents(folderPath, this.uri);
      final WorkspaceModifyOperation _function_3 = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor it) throws CoreException, InvocationTargetException, InterruptedException {
          folder.getFile("test.txt").delete(true, true, null);
        }
      };
      this.modifyWorkspace(_function_3);
      Assert.assertFalse(this.resourceChangeRegistry.getContentsListeners().containsKey(folderPath));
      Assert.assertEquals(3, this.resourceChangeRegistry.queuedURIs.size());
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
