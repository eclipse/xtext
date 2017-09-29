/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@FinalFieldsConstructor
@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public class ResourceRelocationContext {
  public enum ChangeType {
    COPY,
    
    MOVE,
    
    RENAME;
  }
  
  private final ResourceRelocationContext.ChangeType changeType;
  
  private final List<ResourceRelocationChange> changes;
  
  private final RefactoringIssueAcceptor issueAcceptor;
  
  private final IChangeSerializer changeSerializer;
  
  private final ResourceSet resourceSet;
  
  /**
   * Loads and watches the respective resource, applies the relocation change and
   * calls the given <code>modification</code> with the renamed/moved/copied resource.
   * 
   * @param change the change to execute
   * @param modification the side-effect the rename/move/copy operation should have.
   */
  public void addModification(final ResourceRelocationChange change, final IChangeSerializer.IModification<Resource> modification) {
    this.changeSerializer.<Resource>addModification(this.loadAndWatchResource(change), modification);
  }
  
  /**
   * Loads and watches the respective resource and applies the relocation change.
   * Clients may usually rather call {@link #addModification()} to register their
   * side-effects.
   * 
   * @param change the change to execute
   */
  public Resource loadAndWatchResource(final ResourceRelocationChange change) {
    try {
      Resource _switchResult = null;
      final ResourceRelocationContext.ChangeType changeType = this.changeType;
      if (changeType != null) {
        switch (changeType) {
          case MOVE:
          case RENAME:
            Resource _xblockexpression = null;
            {
              final Resource original = this.resourceSet.getResource(change.getFromURI(), true);
              final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
                original.setURI(change.getToURI());
              };
              this.changeSerializer.<Resource>addModification(original, _function);
              _xblockexpression = original;
            }
            _switchResult = _xblockexpression;
            break;
          case COPY:
            Resource _xblockexpression_1 = null;
            {
              final Resource copy = this.resourceSet.createResource(change.getFromURI());
              copy.load(this.resourceSet.getURIConverter().createInputStream(change.getFromURI()), null);
              copy.setURI(change.getToURI());
              _xblockexpression_1 = copy;
            }
            _switchResult = _xblockexpression_1;
            break;
          default:
            break;
        }
      }
      final Resource resource = _switchResult;
      return resource;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceRelocationContext(final ResourceRelocationContext.ChangeType changeType, final List<ResourceRelocationChange> changes, final RefactoringIssueAcceptor issueAcceptor, final IChangeSerializer changeSerializer, final ResourceSet resourceSet) {
    super();
    this.changeType = changeType;
    this.changes = changes;
    this.issueAcceptor = issueAcceptor;
    this.changeSerializer = changeSerializer;
    this.resourceSet = resourceSet;
  }
  
  @Pure
  public ResourceRelocationContext.ChangeType getChangeType() {
    return this.changeType;
  }
  
  @Pure
  public List<ResourceRelocationChange> getChanges() {
    return this.changes;
  }
  
  @Pure
  public RefactoringIssueAcceptor getIssueAcceptor() {
    return this.issueAcceptor;
  }
  
  @Pure
  public IChangeSerializer getChangeSerializer() {
    return this.changeSerializer;
  }
  
  @Pure
  public ResourceSet getResourceSet() {
    return this.resourceSet;
  }
}
