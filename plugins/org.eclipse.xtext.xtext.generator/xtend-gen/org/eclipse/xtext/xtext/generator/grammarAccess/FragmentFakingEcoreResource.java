/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.grammarAccess;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
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
    public final static String ECORE_SUFFIX = "ecore";
    
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
    Map<Object, Object> _defaultSaveOptions = this.getDefaultSaveOptions();
    _defaultSaveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.valueOf(true));
    Map<Object, Object> _defaultSaveOptions_1 = this.getDefaultSaveOptions();
    _defaultSaveOptions_1.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(80));
    Map<Object, Object> _defaultSaveOptions_2 = this.getDefaultSaveOptions();
    URIHandlerImpl.PlatformSchemeAware _platformSchemeAware = new URIHandlerImpl.PlatformSchemeAware();
    _defaultSaveOptions_2.put(XMLResource.OPTION_URI_HANDLER, _platformSchemeAware);
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
    EPackage _ePackage = classifier.getEPackage();
    EPackage _eSuperPackage = _ePackage.getESuperPackage();
    boolean _tripleNotEquals = (_eSuperPackage != null);
    if (_tripleNotEquals) {
      final StringBuilder result = new StringBuilder(60);
      EPackage _ePackage_1 = classifier.getEPackage();
      HashSet<EPackage> _newHashSet = CollectionLiterals.<EPackage>newHashSet();
      this.calculateURIFragment(_ePackage_1, result, _newHashSet);
      String _name = classifier.getName();
      result.append(_name);
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
      EPackage _eSuperPackage_1 = ePackage.getESuperPackage();
      Resource _eResource_1 = _eSuperPackage_1.eResource();
      boolean _tripleEquals = (_eResource == _eResource_1);
      if (_tripleEquals) {
        EPackage _eSuperPackage_2 = ePackage.getESuperPackage();
        this.calculateURIFragment(_eSuperPackage_2, result, visited);
        EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
        boolean _isEmpty = _eClassifiers.isEmpty();
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
          int _length = result.length();
          boolean _tripleNotEquals_1 = (_length != 0);
          if (_tripleNotEquals_1) {
            String _name = ePackage.getName();
            StringBuilder _append = result.append(_name);
            _append.append("/");
            return;
          }
        }
      }
    }
    result.append("//");
  }
}
