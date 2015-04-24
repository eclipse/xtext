/**
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
@SuppressWarnings("all")
public class CopiedResourceDescription extends AbstractResourceDescription {
  private final static Logger log = Logger.getLogger(CopiedResourceDescription.class);
  
  private URI uri;
  
  private ImmutableList<IEObjectDescription> exported;
  
  public CopiedResourceDescription(final IResourceDescription original) {
    URI _uRI = original.getURI();
    this.uri = _uRI;
    Iterable<IEObjectDescription> _exportedObjects = original.getExportedObjects();
    final Function<IEObjectDescription, IEObjectDescription> _function = new Function<IEObjectDescription, IEObjectDescription>() {
      @Override
      public IEObjectDescription apply(final IEObjectDescription from) {
        EObject _eObjectOrProxy = from.getEObjectOrProxy();
        boolean _eIsProxy = _eObjectOrProxy.eIsProxy();
        if (_eIsProxy) {
          return from;
        }
        EClass _eClass = from.getEClass();
        EObject _create = EcoreUtil.create(_eClass);
        InternalEObject result = ((InternalEObject) _create);
        URI _eObjectURI = from.getEObjectURI();
        result.eSetProxyURI(_eObjectURI);
        Map<String, String> userData = null;
        String[] _userDataKeys = from.getUserDataKeys();
        for (final String key : _userDataKeys) {
          {
            if ((userData == null)) {
              HashMap<String, String> _newHashMapWithExpectedSize = Maps.<String, String>newHashMapWithExpectedSize(2);
              userData = _newHashMapWithExpectedSize;
            }
            String _userData = from.getUserData(key);
            userData.put(key, _userData);
          }
        }
        QualifiedName _name = from.getName();
        return EObjectDescription.create(_name, result, userData);
      }
    };
    Iterable<IEObjectDescription> _transform = Iterables.<IEObjectDescription, IEObjectDescription>transform(_exportedObjects, _function);
    ImmutableList<IEObjectDescription> _copyOf = ImmutableList.<IEObjectDescription>copyOf(_transform);
    this.exported = _copyOf;
  }
  
  @Override
  protected List<IEObjectDescription> computeExportedObjects() {
    return this.exported;
  }
  
  @Override
  public Iterable<QualifiedName> getImportedNames() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("getImportedNames ");
    URI _uRI = this.getURI();
    _builder.append(_uRI, "");
    IllegalStateException exception = new IllegalStateException(_builder.toString());
    CopiedResourceDescription.log.error(exception, exception);
    return Collections.<QualifiedName>emptyList();
  }
  
  @Override
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("getReferenceDescriptions ");
    URI _uRI = this.getURI();
    _builder.append(_uRI, "");
    IllegalStateException exception = new IllegalStateException(_builder.toString());
    CopiedResourceDescription.log.error(exception, exception);
    return Collections.<IReferenceDescription>emptyList();
  }
  
  @Override
  public URI getURI() {
    return this.uri;
  }
}
