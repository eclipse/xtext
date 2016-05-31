/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.labels;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.labels.AlternativeImageDescription;
import org.eclipse.xtext.ide.labels.IImageDescription;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class EClassImageDescriptionProvider implements IImageDescriptionProvider {
  @Override
  public IImageDescription getImageDescription(final Object element) {
    IImageDescription _switchResult = null;
    boolean _matched = false;
    if (element instanceof EClass) {
      _matched=true;
      String _name = ((EClass)element).getName();
      EList<EClass> _eAllSuperTypes = ((EClass)element).getEAllSuperTypes();
      final Function1<EClass, String> _function = new Function1<EClass, String>() {
        @Override
        public String apply(final EClass it) {
          return it.getName();
        }
      };
      List<String> _map = ListExtensions.<EClass, String>map(_eAllSuperTypes, _function);
      Iterable<String> _plus = Iterables.<String>concat(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name)), _map);
      String _imageID = IImageDescription.DEFAULT.getImageID();
      Iterable<String> _plus_1 = Iterables.<String>concat(_plus, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_imageID)));
      _switchResult = new AlternativeImageDescription(_plus_1);
    }
    if (!_matched) {
      if (element instanceof EObject) {
        _matched=true;
        EClass _eClass = ((EObject)element).eClass();
        _switchResult = this.getImageDescription(_eClass);
      }
    }
    if (!_matched) {
      if (element instanceof IEObjectDescription) {
        _matched=true;
        EClass _eClass = ((IEObjectDescription)element).getEClass();
        _switchResult = this.getImageDescription(_eClass);
      }
    }
    if (!_matched) {
      _switchResult = IImageDescription.DEFAULT;
    }
    return _switchResult;
  }
}
