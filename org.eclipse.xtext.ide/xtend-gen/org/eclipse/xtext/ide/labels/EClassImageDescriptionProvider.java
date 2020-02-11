/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
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
      final Function1<EClass, String> _function = (EClass it) -> {
        return it.getName();
      };
      List<String> _map = ListExtensions.<EClass, String>map(((EClass)element).getEAllSuperTypes(), _function);
      Iterable<String> _plus = Iterables.<String>concat(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name)), _map);
      String _imageID = IImageDescription.DEFAULT.getImageID();
      Iterable<String> _plus_1 = Iterables.<String>concat(_plus, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_imageID)));
      _switchResult = new AlternativeImageDescription(_plus_1);
    }
    if (!_matched) {
      if (element instanceof EObject) {
        _matched=true;
        _switchResult = this.getImageDescription(((EObject)element).eClass());
      }
    }
    if (!_matched) {
      if (element instanceof IEObjectDescription) {
        _matched=true;
        _switchResult = this.getImageDescription(((IEObjectDescription)element).getEClass());
      }
    }
    if (!_matched) {
      _switchResult = IImageDescription.DEFAULT;
    }
    return _switchResult;
  }
}
