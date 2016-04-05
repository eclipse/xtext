/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.findReferences;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Declarators {
  @Data
  public static class DeclaratorsData {
    private final Set<QualifiedName> declaratorNames;
    
    public DeclaratorsData(final Set<QualifiedName> declaratorNames) {
      super();
      this.declaratorNames = declaratorNames;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.declaratorNames== null) ? 0 : this.declaratorNames.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Declarators.DeclaratorsData other = (Declarators.DeclaratorsData) obj;
      if (this.declaratorNames == null) {
        if (other.declaratorNames != null)
          return false;
      } else if (!this.declaratorNames.equals(other.declaratorNames))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("declaratorNames", this.declaratorNames);
      return b.toString();
    }
    
    @Pure
    public Set<QualifiedName> getDeclaratorNames() {
      return this.declaratorNames;
    }
  }
  
  public final static TargetURIs.Key<Declarators.DeclaratorsData> KEY = TargetURIs.Key.<Declarators.DeclaratorsData>from("Xtend", Declarators.DeclaratorsData.class);
  
  @Inject
  private IQualifiedNameConverter nameConverter;
  
  public Declarators.DeclaratorsData getDeclaratorData(final TargetURIs targetURIs, final IReferenceFinder.IResourceAccess resourceAccess) {
    Declarators.DeclaratorsData result = targetURIs.<Declarators.DeclaratorsData>getUserData(Declarators.KEY);
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      return result;
    }
    final HashSet<QualifiedName> declaratorNames = CollectionLiterals.<QualifiedName>newHashSet();
    Collection<URI> _targetResourceURIs = targetURIs.getTargetResourceURIs();
    for (final URI uri : _targetResourceURIs) {
      final IUnitOfWork<Object, ResourceSet> _function = new IUnitOfWork<Object, ResourceSet>() {
        @Override
        public Object exec(final ResourceSet it) throws Exception {
          Object _xblockexpression = null;
          {
            Collection<URI> _eObjectURIs = targetURIs.getEObjectURIs(uri);
            for (final URI objectURI : _eObjectURIs) {
              {
                final EObject object = it.getEObject(objectURI, true);
                boolean _notEquals = (!Objects.equal(object, null));
                if (_notEquals) {
                  final JvmType type = EcoreUtil2.<JvmType>getContainerOfType(object, JvmType.class);
                  boolean _notEquals_1 = (!Objects.equal(type, null));
                  if (_notEquals_1) {
                    String _identifier = type.getIdentifier();
                    QualifiedName _qualifiedName = Declarators.this.nameConverter.toQualifiedName(_identifier);
                    QualifiedName _lowerCase = _qualifiedName.toLowerCase();
                    declaratorNames.add(_lowerCase);
                    String _qualifiedName_1 = type.getQualifiedName('.');
                    QualifiedName _qualifiedName_2 = Declarators.this.nameConverter.toQualifiedName(_qualifiedName_1);
                    QualifiedName _lowerCase_1 = _qualifiedName_2.toLowerCase();
                    declaratorNames.add(_lowerCase_1);
                  }
                }
              }
            }
            _xblockexpression = null;
          }
          return _xblockexpression;
        }
      };
      resourceAccess.<Object>readOnly(uri, _function);
    }
    Declarators.DeclaratorsData _declaratorsData = new Declarators.DeclaratorsData(declaratorNames);
    result = _declaratorsData;
    targetURIs.<Declarators.DeclaratorsData>putUserData(Declarators.KEY, result);
    return result;
  }
}
