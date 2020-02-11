/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.labels.INameLabelProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.SimpleAttributeResolver;

@SuppressWarnings("all")
public class SimpleNameLabelProvider implements INameLabelProvider {
  @Override
  public String getNameLabel(final Object element) {
    String _switchResult = null;
    boolean _matched = false;
    if (element instanceof EObject) {
      _matched=true;
      _switchResult = SimpleAttributeResolver.NAME_RESOLVER.apply(((EObject)element));
    }
    if (!_matched) {
      if (element instanceof IEObjectDescription) {
        _matched=true;
        _switchResult = ((IEObjectDescription)element).getName().getLastSegment();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
}
