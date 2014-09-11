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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
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
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.core.macro.declaration.ResourceChangeRegistry;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.builder.impl.BuildScheduler;
import org.eclipse.xtext.builder.impl.IBuildFlag;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class UIResourceChangeRegistry implements IResourceChangeListener, ResourceChangeRegistry, IResourceDeltaVisitor {
  private final static Logger logger = Logger.getLogger(UIResourceChangeRegistry.class);
  
  @Inject
  private QueuedBuildData queue;
  
  @Inject
  private BuildScheduler scheduler;
  
  @Inject
  private AbstractUIPlugin uiPlugin;
  
  private IWorkspace workspace;
  
  private final HashMultimap<IPath, URI> listeners = HashMultimap.<IPath, URI>create();
  
  public synchronized void resourceChanged(final IResourceChangeEvent event) {
    try {
      IResourceDelta _delta = event.getDelta();
      _delta.accept(this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public synchronized void register(final IPath resourcePath, final XtendFile interestedFile) {
    Resource _eResource = interestedFile.eResource();
    URI _uRI = _eResource.getURI();
    this.listeners.put(resourcePath, _uRI);
  }
  
  public boolean visit(final IResourceDelta delta) throws CoreException {
    boolean _xblockexpression = false;
    {
      boolean _hasRelevantChange = this.hasRelevantChange(delta);
      boolean _not = (!_hasRelevantChange);
      if (_not) {
        return true;
      }
      IResource _resource = delta.getResource();
      IPath _fullPath = _resource.getFullPath();
      final Set<URI> interestedFiles = this.listeners.removeAll(_fullPath);
      this.queue.queueURIs(interestedFiles);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  private static int RELEVANT_CHANGE_FLAGS = (((IResourceDelta.CONTENT | IResourceDelta.ENCODING) | IResourceDelta.REPLACED) | IResourceDelta.LOCAL_CHANGED);
  
  private boolean hasRelevantChange(final IResourceDelta delta) {
    int _kind = delta.getKind();
    boolean _equals = (_kind == IResourceDelta.CHANGED);
    if (_equals) {
      int _flags = delta.getFlags();
      int _bitwiseAnd = (_flags & UIResourceChangeRegistry.RELEVANT_CHANGE_FLAGS);
      return (_bitwiseAnd != 0);
    } else {
      return true;
    }
  }
  
  @Inject
  public void init(final IWorkspace workspace) {
    try {
      this.workspace = workspace;
      this.load();
      workspace.addSaveParticipant(this.uiPlugin, new ISaveParticipant() {
        public void saving(final ISaveContext context) throws CoreException {
          UIResourceChangeRegistry.this.save();
        }
        
        public void doneSaving(final ISaveContext context) {
        }
        
        public void prepareToSave(final ISaveContext context) throws CoreException {
        }
        
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
      final FileInputStream in = new FileInputStream(location);
      try {
        final DataInputStream reader = new DataInputStream(in);
        try {
          while (true) {
            {
              final String path = reader.readUTF();
              final int numberOfUris = reader.readInt();
              for (int i = 0; (i < numberOfUris); i++) {
                {
                  final String uri = reader.readUTF();
                  Path _path = new Path(path);
                  URI _createURI = URI.createURI(uri);
                  this.listeners.put(_path, _createURI);
                }
              }
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof EOFException) {
            final EOFException eof = (EOFException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      } finally {
        in.close();
      }
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof Exception) {
        final Exception e = (Exception)_t_1;
        UIResourceChangeRegistry.logger.warn("Could not load resource listener registry, scheduling a full build", e);
        this.forgetBuildState();
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  private synchronized void save() {
    try {
      final File location = this.getRegistryStateLocation();
      final FileOutputStream out = new FileOutputStream(location);
      try {
        final DataOutputStream writer = new DataOutputStream(out);
        Map<IPath, Collection<URI>> _asMap = this.listeners.asMap();
        Set<Map.Entry<IPath, Collection<URI>>> _entrySet = _asMap.entrySet();
        final Procedure1<Map.Entry<IPath, Collection<URI>>> _function = new Procedure1<Map.Entry<IPath, Collection<URI>>>() {
          public void apply(final Map.Entry<IPath, Collection<URI>> entry) {
            try {
              IPath _key = entry.getKey();
              String _string = _key.toString();
              writer.writeUTF(_string);
              Collection<URI> _value = entry.getValue();
              int _size = _value.size();
              writer.writeInt(_size);
              Collection<URI> _value_1 = entry.getValue();
              final Procedure1<URI> _function = new Procedure1<URI>() {
                public void apply(final URI uri) {
                  try {
                    String _string = uri.toString();
                    writer.writeUTF(_string);
                  } catch (Throwable _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                }
              };
              IterableExtensions.<URI>forEach(_value_1, _function);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        IterableExtensions.<Map.Entry<IPath, Collection<URI>>>forEach(_entrySet, _function);
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
  
  private File getRegistryStateLocation() {
    IPath _stateLocation = this.uiPlugin.getStateLocation();
    IPath _append = _stateLocation.append("resource.change.registry");
    return _append.toFile();
  }
  
  private void forgetBuildState() {
    IWorkspaceRoot _root = this.workspace.getRoot();
    IProject[] _projects = _root.getProjects();
    final Function1<IProject, Boolean> _function = new Function1<IProject, Boolean>() {
      public Boolean apply(final IProject it) {
        try {
          boolean _and = false;
          boolean _and_1 = false;
          boolean _isAccessible = it.isAccessible();
          if (!_isAccessible) {
            _and_1 = false;
          } else {
            boolean _hasNature = it.hasNature(XtextProjectHelper.NATURE_ID);
            _and_1 = _hasNature;
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _hasNature_1 = it.hasNature(JavaCore.NATURE_ID);
            _and = _hasNature_1;
          }
          return Boolean.valueOf(_and);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<IProject> projects = IterableExtensions.<IProject>filter(((Iterable<IProject>)Conversions.doWrapArray(_projects)), _function);
    this.scheduler.scheduleBuildIfNecessary(projects, IBuildFlag.FORGET_BUILD_STATE_ONLY);
  }
}
