/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.labels;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.labels.INameLabelProvider;
import org.eclipse.xtext.naming.QualifiedName;
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
        QualifiedName _name = ((IEObjectDescription)element).getName();
        _switchResult = _name.getLastSegment();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
}
