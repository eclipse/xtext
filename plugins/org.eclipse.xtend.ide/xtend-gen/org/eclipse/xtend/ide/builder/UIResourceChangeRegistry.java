/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.builder;

import com.google.common.collect.HashMultimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ISaveContext;
import org.eclipse.core.resources.ISaveParticipant;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.core.macro.declaration.IResourceChangeRegistry;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.builder.impl.BuildScheduler;
import org.eclipse.xtext.builder.impl.IBuildFlag;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Singleton
@SuppressWarnings("all")
public class UIResourceChangeRegistry implements IResourceChangeListener, IResourceChangeRegistry, IResourceDeltaVisitor {
  private final static Logger logger = Logger.getLogger(UIResourceChangeRegistry.class);
  
  @Inject
  private QueuedBuildData queue;
  
  @Inject
  private BuildScheduler scheduler;
  
  @Inject
  private AbstractUIPlugin uiPlugin;
  
  private IWorkspace workspace;
  
  @Accessors
  private final HashMultimap<String, URI> existsListeners = HashMultimap.<String, URI>create();
  
  @Accessors
  private final HashMultimap<String, URI> charsetListeners = HashMultimap.<String, URI>create();
  
  @Accessors
  private final HashMultimap<String, URI> childrenListeners = HashMultimap.<String, URI>create();
  
  @Accessors
  private final HashMultimap<String, URI> contentsListeners = HashMultimap.<String, URI>create();
  
  @Accessors
  private final HashMultimap<String, URI> changesNotRelevantListeners = HashMultimap.<String, URI>create();
  
  @Override
  public synchronized void registerExists(final String path, final URI uri) {
    boolean _containsEntry = this.changesNotRelevantListeners.containsEntry(path, uri);
    boolean _not = (!_containsEntry);
    if (_not) {
      this.existsListeners.put(path, uri);
    }
  }
  
  @Override
  public synchronized void registerGetCharset(final String path, final URI uri) {
    boolean _containsEntry = this.changesNotRelevantListeners.containsEntry(path, uri);
    boolean _not = (!_containsEntry);
    if (_not) {
      this.charsetListeners.put(path, uri);
    }
  }
  
  @Override
  public synchronized void registerGetChildren(final String path, final URI uri) {
    boolean _containsEntry = this.changesNotRelevantListeners.containsEntry(path, uri);
    boolean _not = (!_containsEntry);
    if (_not) {
      this.childrenListeners.put(path, uri);
    }
  }
  
  @Override
  public synchronized void registerGetContents(final String path, final URI uri) {
    boolean _containsEntry = this.changesNotRelevantListeners.containsEntry(path, uri);
    boolean _not = (!_containsEntry);
    if (_not) {
      this.contentsListeners.put(path, uri);
    }
  }
  
  @Override
  public synchronized void registerCreateOrModify(final String string, final URI uri) {
    this.existsListeners.remove(string, uri);
    this.charsetListeners.remove(string, uri);
    this.childrenListeners.remove(string, uri);
    this.contentsListeners.remove(string, uri);
    this.changesNotRelevantListeners.put(string, uri);
  }
  
  @Override
  public synchronized void discardCreateOrModifyInformation(final URI uri) {
    Collection<URI> _values = this.changesNotRelevantListeners.values();
    Set<URI> _singleton = Collections.<URI>singleton(uri);
    _values.removeAll(_singleton);
  }
  
  @Override
  public synchronized void resourceChanged(final IResourceChangeEvent event) {
    try {
      IResourceDelta _delta = event.getDelta();
      _delta.accept(this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public boolean visit(final IResourceDelta delta) throws CoreException {
    if (((!this.existsListeners.isEmpty()) && this.hasExistsChanged(delta))) {
      IResource _resource = delta.getResource();
      IPath _fullPath = _resource.getFullPath();
      String _string = _fullPath.toString();
      final Set<URI> interestedFiles = this.existsListeners.removeAll(_string);
      boolean _isEmpty = interestedFiles.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.queueURIs(interestedFiles);
      }
    }
    if (((!this.childrenListeners.isEmpty()) && (this.hasExistsChanged(delta) || this.hasChildrenChanged(delta)))) {
      IResource _resource_1 = delta.getResource();
      IPath _fullPath_1 = _resource_1.getFullPath();
      String _string_1 = _fullPath_1.toString();
      final Set<URI> interestedFiles_1 = this.childrenListeners.removeAll(_string_1);
      boolean _isEmpty_1 = interestedFiles_1.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        this.queueURIs(interestedFiles_1);
      }
    }
    if (((!this.charsetListeners.isEmpty()) && (this.hasExistsChanged(delta) || this.hasCharsetChanged(delta)))) {
      IResource _resource_2 = delta.getResource();
      IPath _fullPath_2 = _resource_2.getFullPath();
      String _string_2 = _fullPath_2.toString();
      final Set<URI> interestedFiles_2 = this.charsetListeners.removeAll(_string_2);
      boolean _isEmpty_2 = interestedFiles_2.isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      if (_not_2) {
        this.queueURIs(interestedFiles_2);
      }
    }
    if (((!this.contentsListeners.isEmpty()) && (this.hasExistsChanged(delta) || this.hasContentsChanged(delta)))) {
      IResource _resource_3 = delta.getResource();
      IPath _fullPath_3 = _resource_3.getFullPath();
      String _string_3 = _fullPath_3.toString();
      final Set<URI> interestedFiles_3 = this.contentsListeners.removeAll(_string_3);
      boolean _isEmpty_3 = interestedFiles_3.isEmpty();
      boolean _not_3 = (!_isEmpty_3);
      if (_not_3) {
        this.queueURIs(interestedFiles_3);
      }
    }
    return true;
  }
  
  protected void queueURIs(final Set<URI> interestedFiles) {
    this.queue.queueURIs(interestedFiles);
  }
  
  private boolean hasExistsChanged(final IResourceDelta delta) {
    return ((delta.getKind() == IResourceDelta.ADDED) || (delta.getKind() == IResourceDelta.REMOVED));
  }
  
  private boolean hasChildrenChanged(final IResourceDelta delta) {
    IResource _resource = delta.getResource();
    if ((_resource instanceof IFolder)) {
      IResourceDelta[] _affectedChildren = delta.getAffectedChildren();
      for (final IResourceDelta c : _affectedChildren) {
        boolean _hasExistsChanged = this.hasExistsChanged(c);
        if (_hasExistsChanged) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean hasCharsetChanged(final IResourceDelta delta) {
    return ((delta.getKind() == IResourceDelta.CHANGED) && ((delta.getFlags() & IResourceDelta.ENCODING) != 0));
  }
  
  private static int HAS_CONTENTS_CHANGED_FLAGS = (((IResourceDelta.CONTENT | IResourceDelta.ENCODING) | IResourceDelta.REPLACED) | IResourceDelta.LOCAL_CHANGED);
  
  private boolean hasContentsChanged(final IResourceDelta delta) {
    int _kind = delta.getKind();
    boolean _equals = (_kind == IResourceDelta.CHANGED);
    if (_equals) {
      int _flags = delta.getFlags();
      int _bitwiseAnd = (_flags & UIResourceChangeRegistry.HAS_CONTENTS_CHANGED_FLAGS);
      return (_bitwiseAnd != 0);
    } else {
      return false;
    }
  }
  
  @Inject
  public void init(final IWorkspace workspace) {
    try {
      this.workspace = workspace;
      this.load();
      workspace.addSaveParticipant(this.uiPlugin, new ISaveParticipant() {
        @Override
        public void saving(final ISaveContext context) throws CoreException {
          UIResourceChangeRegistry.this.save();
        }
        
        @Override
        public void doneSaving(final ISaveContext context) {
        }
        
        @Override
        public void prepareToSave(final ISaveContext context) throws CoreException {
        }
        
        @Override
        public void rollback(final ISaveContext context) {
        }
      });
      workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private synchronized void load() {
    try {
      final File location = this.getRegistryStateLocation();
      boolean _exists = location.exists();
      boolean _not = (!_exists);
      if (_not) {
        this.forgetBuildState();
        return;
      }
      FileInputStream _fileInputStream = new FileInputStream(location);
      final BufferedInputStream in = new BufferedInputStream(_fileInputStream);
      try {
        this.readState(in);
      } finally {
        in.close();
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        UIResourceChangeRegistry.logger.warn("Could not load resource listener registry, scheduling a full build", e);
        this.forgetBuildState();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void readState(final InputStream in) {
    try {
      final DataInputStream reader = new DataInputStream(in);
      for (final HashMultimap<String, URI> map : Collections.<HashMultimap<String, URI>>unmodifiableList(CollectionLiterals.<HashMultimap<String, URI>>newArrayList(this.existsListeners, this.charsetListeners, this.childrenListeners, this.contentsListeners))) {
        {
          final int urisForExists = reader.readInt();
          for (int i = 0; (i < urisForExists); i++) {
            {
              final String path = reader.readUTF();
              final String uri = reader.readUTF();
              URI _createURI = URI.createURI(uri);
              map.put(path, _createURI);
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private synchronized void save() {
    try {
      final File location = this.getRegistryStateLocation();
      FileOutputStream _fileOutputStream = new FileOutputStream(location);
      final BufferedOutputStream out = new BufferedOutputStream(_fileOutputStream);
      try {
        this.writeState(out);
      } finally {
        out.close();
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        UIResourceChangeRegistry.logger.warn("Could not save resource listener registry", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void writeState(final OutputStream out) {
    try {
      final DataOutputStream writer = new DataOutputStream(out);
      for (final HashMultimap<String, URI> map : Collections.<HashMultimap<String, URI>>unmodifiableList(CollectionLiterals.<HashMultimap<String, URI>>newArrayList(this.existsListeners, this.charsetListeners, this.childrenListeners, this.contentsListeners))) {
        {
          final Set<Map.Entry<String, URI>> entries = map.entries();
          int _size = entries.size();
          writer.writeInt(_size);
          for (final Map.Entry<String, URI> entry : entries) {
            {
              String _key = entry.getKey();
              writer.writeUTF(_key);
              URI _value = entry.getValue();
              String _string = _value.toString();
              writer.writeUTF(_string);
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private File getRegistryStateLocation() {
    IPath _stateLocation = this.uiPlugin.getStateLocation();
    IPath _append = _stateLocation.append("resource.change.registry");
    return _append.toFile();
  }
  
  private void forgetBuildState() {
    IWorkspaceRoot _root = this.workspace.getRoot();
    IProject[] _projects = _root.getProjects();
    final Function1<IProject, Boolean> _function = new Function1<IProject, Boolean>() {
      @Override
      public Boolean apply(final IProject it) {
        try {
          return Boolean.valueOf(((it.isAccessible() && it.hasNature(XtextProjectHelper.NATURE_ID)) && it.hasNature(JavaCore.NATURE_ID)));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<IProject> projects = IterableExtensions.<IProject>filter(((Iterable<IProject>)Conversions.doWrapArray(_projects)), _function);
    this.scheduler.scheduleBuildIfNecessary(projects, IBuildFlag.FORGET_BUILD_STATE_ONLY);
  }
  
  @Pure
  public HashMultimap<String, URI> getExistsListeners() {
    return this.existsListeners;
  }
  
  @Pure
  public HashMultimap<String, URI> getCharsetListeners() {
    return this.charsetListeners;
  }
  
  @Pure
  public HashMultimap<String, URI> getChildrenListeners() {
    return this.childrenListeners;
  }
  
  @Pure
  public HashMultimap<String, URI> getContentsListeners() {
    return this.contentsListeners;
  }
  
  @Pure
  public HashMultimap<String, URI> getChangesNotRelevantListeners() {
    return this.changesNotRelevantListeners;
  }
}
