/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Copied from org.eclipse.xtext.builder.clustering.CopiedResourceDescription to avoid a
 * dependency on org.eclipse.xtext.builder plug-in
 * 
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvedResourceDescription extends AbstractResourceDescription {
  private final static Logger LOG = Logger.getLogger(ResolvedResourceDescription.class);
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private URI URI;
  
  private ImmutableList<IEObjectDescription> exported;
  
  public ResolvedResourceDescription(final IResourceDescription original) {
    URI _uRI = original.getURI();
    this.URI = _uRI;
    Iterable<IEObjectDescription> _exportedObjects = original.getExportedObjects();
    final Function1<IEObjectDescription, IEObjectDescription> _function = new Function1<IEObjectDescription, IEObjectDescription>() {
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
            boolean _equals = Objects.equal(userData, null);
            if (_equals) {
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
    Iterable<IEObjectDescription> _map = IterableExtensions.<IEObjectDescription, IEObjectDescription>map(_exportedObjects, _function);
    ImmutableList<IEObjectDescription> _copyOf = ImmutableList.<IEObjectDescription>copyOf(_map);
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
    _builder.append(this.URI, "");
    IllegalStateException exception = new IllegalStateException(_builder.toString());
    ResolvedResourceDescription.LOG.error(exception, exception);
    return CollectionLiterals.<QualifiedName>emptyList();
  }
  
  @Override
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("getReferenceDescriptions ");
    _builder.append(this.URI, "");
    IllegalStateException exception = new IllegalStateException(_builder.toString());
    ResolvedResourceDescription.LOG.error(exception, exception);
    return CollectionLiterals.<IReferenceDescription>emptyList();
  }
  
  @Pure
  public URI getURI() {
    return this.URI;
  }
}
