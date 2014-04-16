/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmElementAtOffsetHelper {
  @Inject
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;

  @Inject
  private IJvmModelAssociations associations;

  public JvmIdentifiableElement getJvmIdentifiableElement(final XtextResource resource, final int offset) {
    final EObject selectedElement = this.eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    boolean _equals = Objects.equal(selectedElement, null);
    if (_equals) {
      return null;
    }
    if ((selectedElement instanceof JvmIdentifiableElement)) {
      return ((JvmIdentifiableElement)selectedElement);
    }
    final Set<EObject> jvmElements = this.associations.getJvmElements(selectedElement);
    boolean _isEmpty = jvmElements.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EObject _head = IterableExtensions.<EObject>head(jvmElements);
      final JvmIdentifiableElement type = ((JvmIdentifiableElement) _head);
      boolean _notEquals = (!Objects.equal(type, null));
      if (_notEquals) {
        return type;
      }
    }
    return null;
  }
}
