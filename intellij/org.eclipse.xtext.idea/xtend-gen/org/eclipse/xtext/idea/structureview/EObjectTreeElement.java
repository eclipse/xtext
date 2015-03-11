/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.psi.PsiElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.AbstractStructureViewTreeElement;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class EObjectTreeElement extends AbstractStructureViewTreeElement {
  @Inject
  private PsiModelAssociations psiModelAssociations;
  
  private URI uri;
  
  @Accessors
  private EObject object;
  
  public void setObject(final EObject object) {
    this.object = object;
    URI _uRI = EcoreUtil.getURI(object);
    this.uri = _uRI;
  }
  
  @Override
  public Object getValue() {
    return this.uri;
  }
  
  @Override
  protected PsiElement getInternalNavigationElement() {
    return this.psiModelAssociations.getPsiElement(this.object);
  }
  
  @Override
  protected Object getObjectToPresent() {
    return this.object;
  }
  
  @Override
  public boolean equals(final Object obj) {
    boolean _xifexpression = false;
    if ((this == obj)) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      if ((obj instanceof EObjectTreeElement)) {
        _xifexpression_1 = Objects.equal(this.uri, ((EObjectTreeElement)obj).uri);
      } else {
        _xifexpression_1 = false;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  public int hashCode() {
    return this.uri.hashCode();
  }
  
  @Pure
  public EObject getObject() {
    return this.object;
  }
}
