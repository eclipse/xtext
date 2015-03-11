/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.tests.containers;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class URIBasedTestResourceDescription extends AbstractResourceDescription {
  private final URI uri;
  
  @Override
  protected List<IEObjectDescription> computeExportedObjects() {
    return CollectionLiterals.<IEObjectDescription>emptyList();
  }
  
  @Override
  public Iterable<QualifiedName> getImportedNames() {
    return CollectionLiterals.<QualifiedName>emptyList();
  }
  
  @Override
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    return CollectionLiterals.<IReferenceDescription>emptyList();
  }
  
  @Override
  public URI getURI() {
    return this.uri;
  }
  
  public URIBasedTestResourceDescription(final URI uri) {
    super();
    this.uri = uri;
  }
}
