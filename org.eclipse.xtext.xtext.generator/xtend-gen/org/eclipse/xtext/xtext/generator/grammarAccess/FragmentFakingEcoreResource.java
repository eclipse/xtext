/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.grammarAccess;

import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class FragmentFakingEcoreResource extends XMIResourceImpl {
  @FinalFieldsConstructor
  public static class FactoryImpl extends EcoreResourceFactoryImpl {
    public static final String ECORE_SUFFIX = "ecore";
    
    private final Wrapper<Boolean> isSaving;
    
    @Override
    public Resource createResource(final URI uri) {
      return new FragmentFakingEcoreResource(uri, this.isSaving);
    }
    
    public FactoryImpl(final Wrapper<Boolean> isSaving) {
      super();
      this.isSaving = isSaving;
    }
  }
  
  private final Wrapper<Boolean> isSaving;
  
  public FragmentFakingEcoreResource(final URI uri, final Wrapper<Boolean> isSaving) {
    super(uri);
    this.isSaving = isSaving;
    this.encoding = "UTF-8";
    this.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.valueOf(true));
    this.getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(80));
    Map<Object, Object> _defaultSaveOptions = this.getDefaultSaveOptions();
    URIHandlerImpl.PlatformSchemeAware _platformSchemeAware = new URIHandlerImpl.PlatformSchemeAware();
    _defaultSaveOptions.put(XMLResource.OPTION_URI_HANDLER, _platformSchemeAware);
  }
  
  @Override
  protected boolean useIDs() {
    return ((this.eObjectToIDMap != null) || (this.idToEObjectMap != null));
  }
  
  @Override
  public String getURIFragment(final EObject eObject) {
    Boolean _get = this.isSaving.get();
    if ((_get).booleanValue()) {
      if ((eObject instanceof EClassifier)) {
        final String result = this.getURIFragment(((EClassifier)eObject));
        if ((result != null)) {
          return result;
        }
      }
    }
    return super.getURIFragment(eObject);
  }
  
  public String getURIFragment(final EClassifier classifier) {
    EPackage _eSuperPackage = classifier.getEPackage().getESuperPackage();
    boolean _tripleNotEquals = (_eSuperPackage != null);
    if (_tripleNotEquals) {
      final StringBuilder result = new StringBuilder(60);
      this.calculateURIFragment(classifier.getEPackage(), result, CollectionLiterals.<EPackage>newHashSet());
      result.append(classifier.getName());
      return result.toString();
    }
    return null;
  }
  
  private void calculateURIFragment(final EPackage ePackage, final StringBuilder result, final Set<EPackage> visited) {
    boolean _add = visited.add(ePackage);
    boolean _not = (!_add);
    if (_not) {
      throw new IllegalStateException();
    }
    EPackage _eSuperPackage = ePackage.getESuperPackage();
    boolean _tripleNotEquals = (_eSuperPackage != null);
    if (_tripleNotEquals) {
      Resource _eResource = ePackage.eResource();
      Resource _eResource_1 = ePackage.getESuperPackage().eResource();
      boolean _tripleEquals = (_eResource == _eResource_1);
      if (_tripleEquals) {
        this.calculateURIFragment(ePackage.getESuperPackage(), result, visited);
        boolean _isEmpty = ePackage.getEClassifiers().isEmpty();
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
          int _length = result.length();
          boolean _tripleNotEquals_1 = (_length != 0);
          if (_tripleNotEquals_1) {
            result.append(ePackage.getName()).append("/");
          } else {
            result.append("//");
          }
        }
      } else {
        result.append("//");
      }
    } else {
      result.append("//");
    }
  }
}
