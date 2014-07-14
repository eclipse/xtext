/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.resource;

import java.util.Collections;
import org.eclipse.xtend.core.resource.DescriptionFlags;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendResourceDescriptionDelta extends DefaultResourceDescriptionDelta {
  @Extension
  private DescriptionFlags _descriptionFlags = new DescriptionFlags();
  
  public XtendResourceDescriptionDelta(final IResourceDescription old, final IResourceDescription _new) {
    super(old, _new);
  }
  
  protected boolean internalHasChanges() {
    boolean _xblockexpression = false;
    {
      Iterable<IEObjectDescription> _elvis = null;
      IResourceDescription _old = this.getOld();
      Iterable<IEObjectDescription> _exportedObjects = null;
      if (_old!=null) {
        _exportedObjects=_old.getExportedObjects();
      }
      if (_exportedObjects != null) {
        _elvis = _exportedObjects;
      } else {
        _elvis = Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList());
      }
      final Iterable<IEObjectDescription> oldObjects = _elvis;
      boolean _or = false;
      final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
        public Boolean apply(final IEObjectDescription it) {
          boolean _or = false;
          boolean _isActiveAnnotation = XtendResourceDescriptionDelta.this._descriptionFlags.isActiveAnnotation(it);
          if (_isActiveAnnotation) {
            _or = true;
          } else {
            boolean _isAnnotationProcessor = XtendResourceDescriptionDelta.this._descriptionFlags.isAnnotationProcessor(it);
            _or = _isAnnotationProcessor;
          }
          return Boolean.valueOf(_or);
        }
      };
      boolean _exists = IterableExtensions.<IEObjectDescription>exists(oldObjects, _function);
      if (_exists) {
        _or = true;
      } else {
        boolean _internalHasChanges = super.internalHasChanges();
        _or = _internalHasChanges;
      }
      _xblockexpression = _or;
    }
    return _xblockexpression;
  }
}
