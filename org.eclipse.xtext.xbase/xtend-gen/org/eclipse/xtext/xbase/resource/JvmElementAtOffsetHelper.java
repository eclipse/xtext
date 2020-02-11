/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.resource;

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
    if ((selectedElement == null)) {
      return null;
    }
    if ((selectedElement instanceof JvmIdentifiableElement)) {
      return ((JvmIdentifiableElement)selectedElement);
    }
    final Set<EObject> jvmElements = this.associations.getJvmElements(selectedElement);
    boolean _isEmpty = jvmElements.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final EObject firstElement = IterableExtensions.<EObject>head(jvmElements);
      if ((firstElement instanceof JvmIdentifiableElement)) {
        return ((JvmIdentifiableElement)firstElement);
      }
    }
    return null;
  }
}
