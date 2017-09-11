/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import java.util.List;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 */
@FinalFieldsConstructor
@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public class ResourceRelocationContext {
  private final List<ResourceRelocationChange> changes;
  
  private final RefactoringIssueAcceptor issueAcceptor;
  
  private final IChangeSerializer changeSerializer;
  
  private final ResourceSet resourceSet;
  
  public ResourceRelocationContext(final List<ResourceRelocationChange> changes, final RefactoringIssueAcceptor issueAcceptor, final IChangeSerializer changeSerializer, final ResourceSet resourceSet) {
    super();
    this.changes = changes;
    this.issueAcceptor = issueAcceptor;
    this.changeSerializer = changeSerializer;
    this.resourceSet = resourceSet;
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
