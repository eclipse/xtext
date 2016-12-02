/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.util;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ElementAtOffsetUtil {
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Inject
  @Extension
  private ILocationInFileProvider _iLocationInFileProvider;
  
  public EObject getElementAt(final XtextResource resource, final int offset) {
    EObject crossLinkedEObject = this._eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
    if ((crossLinkedEObject != null)) {
      return crossLinkedEObject;
    } else {
      EObject containedEObject = this._eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
      if ((containedEObject != null)) {
        final ITextRegion nameRegion = this._iLocationInFileProvider.getSignificantTextRegion(containedEObject);
        boolean _contains = nameRegion.contains(offset);
        if (_contains) {
          return containedEObject;
        }
      }
    }
    return null;
  }
}
