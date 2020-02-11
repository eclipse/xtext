/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class UnexpectedProxiesException extends RuntimeException {
  public UnexpectedProxiesException(final Map<EObject, Collection<EStructuralFeature.Setting>> unresolved) {
    super(IterableExtensions.<URI>toSet(Iterables.<URI>concat(IterableExtensions.<EStructuralFeature.Setting, List<URI>>map(Iterables.<EStructuralFeature.Setting>concat(unresolved.values()), ((Function1<EStructuralFeature.Setting, List<URI>>) (EStructuralFeature.Setting it) -> {
      return UnexpectedProxiesException.getURIs(it);
    })))).toString());
  }
  
  public static List<URI> getURIs(final EStructuralFeature.Setting setting) {
    List<URI> _switchResult = null;
    Object _get = setting.get(false);
    final Object it = _get;
    boolean _matched = false;
    if (it instanceof EObject) {
      _matched=true;
      _switchResult = CollectionLiterals.<URI>newImmutableList(EcoreUtil.getURI(((EObject)it)));
    }
    if (!_matched) {
      if (it instanceof List) {
        _matched=true;
        final Function1<EObject, URI> _function = (EObject it_1) -> {
          return EcoreUtil.getURI(it_1);
        };
        _switchResult = ListExtensions.<EObject, URI>map(((List<EObject>)it), _function);
      }
    }
    return _switchResult;
  }
}
