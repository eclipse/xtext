/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.resource;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.core.resource.XtendResourceDescriptionStrategy;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendResourceDescriptionDelta extends DefaultResourceDescriptionDelta {
  public XtendResourceDescriptionDelta(final IResourceDescription old, final IResourceDescription _new) {
    super(old, _new);
  }
  
  protected boolean internalHasChanges() {
    boolean _or = false;
    boolean _hasAnnotationProcessorChanged = this.hasAnnotationProcessorChanged();
    if (_hasAnnotationProcessorChanged) {
      _or = true;
    } else {
      boolean _internalHasChanges = super.internalHasChanges();
      _or = _internalHasChanges;
    }
    return _or;
  }
  
  private boolean hasAnnotationProcessorChanged() {
    List<IEObjectDescription> _elvis = null;
    IResourceDescription _old = this.getOld();
    Iterable<IEObjectDescription> _exportedObjects = null;
    if (_old!=null) {
      _exportedObjects=_old.getExportedObjects();
    }
    List<IEObjectDescription> _list = null;
    if (_exportedObjects!=null) {
      _list=IterableExtensions.<IEObjectDescription>toList(_exportedObjects);
    }
    if (_list != null) {
      _elvis = _list;
    } else {
      _elvis = Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList());
    }
    final List<IEObjectDescription> oldExportedObjects = _elvis;
    List<IEObjectDescription> _elvis_1 = null;
    IResourceDescription _new = this.getNew();
    Iterable<IEObjectDescription> _exportedObjects_1 = null;
    if (_new!=null) {
      _exportedObjects_1=_new.getExportedObjects();
    }
    List<IEObjectDescription> _list_1 = null;
    if (_exportedObjects_1!=null) {
      _list_1=IterableExtensions.<IEObjectDescription>toList(_exportedObjects_1);
    }
    if (_list_1 != null) {
      _elvis_1 = _list_1;
    } else {
      _elvis_1 = Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList());
    }
    final List<IEObjectDescription> newExportedObjects = _elvis_1;
    for (final IEObjectDescription oldObject : oldExportedObjects) {
      {
        final String oldHash = oldObject.getUserData(XtendResourceDescriptionStrategy.ANNOTATION_PROCESSOR_HASH);
        boolean _tripleNotEquals = (oldHash != null);
        if (_tripleNotEquals) {
          for (final IEObjectDescription newObject : newExportedObjects) {
            {
              final String newHash = newObject.getUserData(XtendResourceDescriptionStrategy.ANNOTATION_PROCESSOR_HASH);
              boolean _and = false;
              boolean _and_1 = false;
              QualifiedName _qualifiedName = newObject.getQualifiedName();
              QualifiedName _qualifiedName_1 = oldObject.getQualifiedName();
              boolean _equals = Objects.equal(_qualifiedName, _qualifiedName_1);
              if (!_equals) {
                _and_1 = false;
              } else {
                boolean _notEquals = (!Objects.equal(newHash, null));
                _and_1 = _notEquals;
              }
              if (!_and_1) {
                _and = false;
              } else {
                boolean _notEquals_1 = (!Objects.equal(newHash, oldHash));
                _and = _notEquals_1;
              }
              if (_and) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
}
