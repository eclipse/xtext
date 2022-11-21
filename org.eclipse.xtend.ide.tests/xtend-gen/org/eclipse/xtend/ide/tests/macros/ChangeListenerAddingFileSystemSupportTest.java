/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.macros;

import java.io.InputStream;
import java.net.URI;
import org.eclipse.xtend.core.macro.declaration.ChangeListenerAddingFileSystemSupport;
import org.eclipse.xtend.ide.builder.UIResourceChangeRegistry;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ChangeListenerAddingFileSystemSupportTest {
  public static class NoopFileSystemSupport implements MutableFileSystemSupport {
    @Override
    public void delete(final Path path) {
    }

    @Override
    public void mkdir(final Path path) {
    }

    @Override
    public void setContents(final Path path, final CharSequence contents) {
    }

    @Override
    public void setContentsAsStream(final Path path, final InputStream source) {
    }

    @Override
    public boolean exists(final Path path) {
      return false;
    }

    @Override
    public String getCharset(final Path path) {
      return null;
    }

    @Override
    public Iterable<? extends Path> getChildren(final Path path) {
      return null;
    }

    @Override
    public CharSequence getContents(final Path path) {
      return null;
    }

    @Override
    public InputStream getContentsAsStream(final Path path) {
      return null;
    }

    @Override
    public long getLastModification(final Path path) {
      return 0L;
    }

    @Override
    public boolean isFile(final Path path) {
      return true;
    }

    @Override
    public boolean isFolder(final Path path) {
      return true;
    }

    @Override
    public URI toURI(final Path path) {
      return null;
    }
  }

  private UIResourceChangeRegistry registry;

  private org.eclipse.emf.common.util.URI uri;

  @Extension
  private ChangeListenerAddingFileSystemSupport fsa;

  private Path path;

  @Before
  public void setup() {
    UIResourceChangeRegistry _uIResourceChangeRegistry = new UIResourceChangeRegistry();
    this.registry = _uIResourceChangeRegistry;
    this.uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI("myProject/src/com/acme/C.xtend", true);
    ChangeListenerAddingFileSystemSupportTest.NoopFileSystemSupport _noopFileSystemSupport = new ChangeListenerAddingFileSystemSupportTest.NoopFileSystemSupport();
    ChangeListenerAddingFileSystemSupport _changeListenerAddingFileSystemSupport = new ChangeListenerAddingFileSystemSupport(this.uri, _noopFileSystemSupport, this.registry);
    this.fsa = _changeListenerAddingFileSystemSupport;
    Path _path = new Path("a");
    this.path = _path;
  }

  @After
  public void tearDown() {
    this.registry = null;
    this.uri = null;
    this.fsa = null;
    this.path = null;
  }

  @Test
  public void readFile() {
    this.fsa.getContents(this.path);
    Assert.assertTrue(this.registry.getContentsListeners().containsEntry(this.path.toString(), this.uri));
  }

  @Test
  public void readWriteAndReadFile() {
    this.fsa.setContents(this.path, "");
    this.fsa.getContents(this.path);
    Assert.assertTrue(this.registry.getContentsListeners().isEmpty());
  }

  @Test
  public void readReadAndWriteFile() {
    this.fsa.getContents(this.path);
    this.fsa.setContents(this.path, "");
    Assert.assertTrue(this.registry.getContentsListeners().isEmpty());
  }

  @Test
  public void listChildren() {
    this.fsa.getChildren(this.path);
    Assert.assertTrue(this.registry.getChildrenListeners().containsEntry(this.path.toString(), this.uri));
  }

  @Test
  public void exists() {
    this.fsa.exists(this.path);
    Assert.assertTrue(this.registry.getExistsListeners().containsEntry(this.path.toString(), this.uri));
  }

  @Test
  public void isFile() {
    this.fsa.isFile(this.path);
    Assert.assertTrue(this.registry.getExistsListeners().containsEntry(this.path.toString(), this.uri));
  }

  @Test
  public void isFolder() {
    this.fsa.isFolder(this.path);
    Assert.assertTrue(this.registry.getExistsListeners().containsEntry(this.path.toString(), this.uri));
  }

  @Test
  @Deprecated
  public void mkDir() {
    this.fsa.mkdir(this.path);
    Assert.assertTrue(this.registry.getChildrenListeners().isEmpty());
  }

  @Test
  @Deprecated
  public void isFolderAndMkDir() {
    this.fsa.isFolder(this.path);
    this.fsa.mkdir(this.path);
    Assert.assertTrue(this.registry.getChildrenListeners().isEmpty());
  }

  @Test
  @Deprecated
  public void discardCreateAndModifyInformation() {
    this.fsa.mkdir(this.path);
    Path _path = new Path("b");
    this.fsa.mkdir(_path);
    Assert.assertTrue(this.registry.getChangesNotRelevantListeners().containsEntry(this.path.toString(), this.uri));
    Assert.assertTrue(this.registry.getChangesNotRelevantListeners().containsEntry("b", this.uri));
    this.registry.discardCreateOrModifyInformation(this.uri);
    Assert.assertTrue(this.registry.getChangesNotRelevantListeners().isEmpty());
  }
}
