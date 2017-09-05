/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.ResourceModification;
import org.eclipse.xtext.ide.refactoring.ResourceURIChange;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class MoveResourceContext {
  private final static Logger LOG = Logger.getLogger(MoveResourceContext.class);
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final List<ResourceURIChange> fileChanges;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final List<ResourceURIChange> folderChanges;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final RefactoringIssueAcceptor issueAcceptor;
  
  private final IChangeSerializer changeSerializer;
  
  private final ResourceSet resourceSet;
  
  private final Map<Resource, ResourceModification> modifications = CollectionLiterals.<Resource, ResourceModification>newHashMap();
  
  public ResourceModification addModification(final URI uri, final ResourceModification modification) {
    ResourceModification _xtrycatchfinallyexpression = null;
    try {
      ResourceModification _xblockexpression = null;
      {
        final Resource resource = this.resourceSet.getResource(uri, true);
        this.changeSerializer.beginRecordChanges(resource);
        _xblockexpression = this.modifications.put(resource, modification);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        String _string = null;
        if (uri!=null) {
          _string=uri.toString();
        }
        String _plus = ("Error loading resource " + _string);
        this.issueAcceptor.add(RefactoringIssueAcceptor.Severity.ERROR, _plus, t);
        MoveResourceContext.LOG.error(t);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public void executeModifications() {
    final Consumer<Map.Entry<Resource, ResourceModification>> _function = (Map.Entry<Resource, ResourceModification> it) -> {
      try {
        it.getValue().modify(it.getKey());
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          Resource _key = it.getKey();
          URI _uRI = null;
          if (_key!=null) {
            _uRI=_key.getURI();
          }
          String _string = null;
          if (_uRI!=null) {
            _string=_uRI.toString();
          }
          String _plus = ("Error executing modification on resource " + _string);
          this.issueAcceptor.add(RefactoringIssueAcceptor.Severity.ERROR, _plus, t);
          MoveResourceContext.LOG.error(t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    this.modifications.entrySet().forEach(_function);
  }
  
  public MoveResourceContext(final List<ResourceURIChange> fileChanges, final List<ResourceURIChange> folderChanges, final RefactoringIssueAcceptor issueAcceptor, final IChangeSerializer changeSerializer, final ResourceSet resourceSet) {
    super();
    this.fileChanges = fileChanges;
    this.folderChanges = folderChanges;
    this.issueAcceptor = issueAcceptor;
    this.changeSerializer = changeSerializer;
    this.resourceSet = resourceSet;
  }
  
  @Pure
  public List<ResourceURIChange> getFileChanges() {
    return this.fileChanges;
  }
  
  @Pure
  public List<ResourceURIChange> getFolderChanges() {
    return this.folderChanges;
  }
  
  @Pure
  public RefactoringIssueAcceptor getIssueAcceptor() {
    return this.issueAcceptor;
  }
}
