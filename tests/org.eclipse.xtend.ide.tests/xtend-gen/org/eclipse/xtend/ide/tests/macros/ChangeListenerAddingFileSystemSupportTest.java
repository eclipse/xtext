/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.macros;

import com.google.common.collect.HashMultimap;
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
    org.eclipse.emf.common.util.URI _createPlatformResourceURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI("myProject/src/com/acme/C.xtend", true);
    this.uri = _createPlatformResourceURI;
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
    HashMultimap<String, org.eclipse.emf.common.util.URI> _contentsListeners = this.registry.getContentsListeners();
    String _string = this.path.toString();
    boolean _containsEntry = _contentsListeners.containsEntry(_string, this.uri);
    Assert.assertTrue(_containsEntry);
  }
  
  @Test
  public void readWriteAndReadFile() {
    this.fsa.setContents(this.path, "");
    this.fsa.getContents(this.path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _contentsListeners = this.registry.getContentsListeners();
    boolean _isEmpty = _contentsListeners.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void readReadAndWriteFile() {
    this.fsa.getContents(this.path);
    this.fsa.setContents(this.path, "");
    HashMultimap<String, org.eclipse.emf.common.util.URI> _contentsListeners = this.registry.getContentsListeners();
    boolean _isEmpty = _contentsListeners.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void listChildren() {
    this.fsa.getChildren(this.path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _childrenListeners = this.registry.getChildrenListeners();
    String _string = this.path.toString();
    boolean _containsEntry = _childrenListeners.containsEntry(_string, this.uri);
    Assert.assertTrue(_containsEntry);
  }
  
  @Test
  public void exists() {
    this.fsa.exists(this.path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _existsListeners = this.registry.getExistsListeners();
    String _string = this.path.toString();
    boolean _containsEntry = _existsListeners.containsEntry(_string, this.uri);
    Assert.assertTrue(_containsEntry);
  }
  
  @Test
  public void isFile() {
    this.fsa.isFile(this.path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _existsListeners = this.registry.getExistsListeners();
    String _string = this.path.toString();
    boolean _containsEntry = _existsListeners.containsEntry(_string, this.uri);
    Assert.assertTrue(_containsEntry);
  }
  
  @Test
  public void isFolder() {
    this.fsa.isFolder(this.path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _existsListeners = this.registry.getExistsListeners();
    String _string = this.path.toString();
    boolean _containsEntry = _existsListeners.containsEntry(_string, this.uri);
    Assert.assertTrue(_containsEntry);
  }
  
  @Test
  public void mkDir() {
    this.fsa.mkdir(this.path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _childrenListeners = this.registry.getChildrenListeners();
    boolean _isEmpty = _childrenListeners.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void isFolderAndMkDir() {
    this.fsa.isFolder(this.path);
    this.fsa.mkdir(this.path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _childrenListeners = this.registry.getChildrenListeners();
    boolean _isEmpty = _childrenListeners.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void discardCreateAndModifyInformation() {
    this.fsa.mkdir(this.path);
    Path _path = new Path("b");
    this.fsa.mkdir(_path);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _changesNotRelevantListeners = this.registry.getChangesNotRelevantListeners();
    String _string = this.path.toString();
    boolean _containsEntry = _changesNotRelevantListeners.containsEntry(_string, this.uri);
    Assert.assertTrue(_containsEntry);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _changesNotRelevantListeners_1 = this.registry.getChangesNotRelevantListeners();
    boolean _containsEntry_1 = _changesNotRelevantListeners_1.containsEntry("b", this.uri);
    Assert.assertTrue(_containsEntry_1);
    this.registry.discardCreateOrModifyInformation(this.uri);
    HashMultimap<String, org.eclipse.emf.common.util.URI> _changesNotRelevantListeners_2 = this.registry.getChangesNotRelevantListeners();
    boolean _isEmpty = _changesNotRelevantListeners_2.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
}
