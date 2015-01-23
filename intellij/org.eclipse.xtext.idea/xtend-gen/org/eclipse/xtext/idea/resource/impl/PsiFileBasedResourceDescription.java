/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource.impl;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class PsiFileBasedResourceDescription extends AbstractResourceDescription implements IResourceDescription {
  @Accessors
  private final BaseXtextFile xtextFile;
  
  @Override
  protected List<IEObjectDescription> computeExportedObjects() {
    return this.xtextFile.getExportedObjects();
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
    return this.xtextFile.getURI();
  }
  
  @Override
  public String toString() {
    Class<? extends PsiFileBasedResourceDescription> _class = this.getClass();
    String _name = _class.getName();
    String _plus = (_name + ":");
    String _string = this.xtextFile.toString();
    return (_plus + _string);
  }
  
  public PsiFileBasedResourceDescription(final BaseXtextFile xtextFile) {
    super();
    this.xtextFile = xtextFile;
  }
  
  @Pure
  public BaseXtextFile getXtextFile() {
    return this.xtextFile;
  }
}
