/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.findReferences;

import com.google.inject.Inject;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
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
      return 31 * 1 + ((this.declaratorNames== null) ? 0 : this.declaratorNames.hashCode());
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

  public static final TargetURIs.Key<Declarators.DeclaratorsData> KEY = TargetURIs.Key.<Declarators.DeclaratorsData>from("Xtend", Declarators.DeclaratorsData.class);

  @Inject
  private IQualifiedNameConverter nameConverter;

  public Declarators.DeclaratorsData getDeclaratorData(final TargetURIs targetURIs, final IReferenceFinder.IResourceAccess resourceAccess) {
    Declarators.DeclaratorsData result = targetURIs.<Declarators.DeclaratorsData>getUserData(Declarators.KEY);
    if ((result != null)) {
      return result;
    }
    final HashSet<QualifiedName> declaratorNames = CollectionLiterals.<QualifiedName>newHashSet();
    final Consumer<URI> _function = (URI uri) -> {
      final IUnitOfWork<Object, ResourceSet> _function_1 = (ResourceSet it) -> {
        Object _xblockexpression = null;
        {
          final Consumer<URI> _function_2 = (URI objectURI) -> {
            final EObject object = it.getEObject(objectURI, true);
            if ((object != null)) {
              final JvmType type = EcoreUtil2.<JvmType>getContainerOfType(object, JvmType.class);
              if ((type != null)) {
                QualifiedName _lowerCase = this.nameConverter.toQualifiedName(type.getIdentifier()).toLowerCase();
                declaratorNames.add(_lowerCase);
                QualifiedName _lowerCase_1 = this.nameConverter.toQualifiedName(type.getQualifiedName('.')).toLowerCase();
                declaratorNames.add(_lowerCase_1);
              }
            }
          };
          targetURIs.getEObjectURIs(uri).forEach(_function_2);
          _xblockexpression = null;
        }
        return _xblockexpression;
      };
      resourceAccess.<Object>readOnly(uri, _function_1);
    };
    targetURIs.getTargetResourceURIs().forEach(_function);
    Declarators.DeclaratorsData _declaratorsData = new Declarators.DeclaratorsData(declaratorNames);
    result = _declaratorsData;
    targetURIs.<Declarators.DeclaratorsData>putUserData(Declarators.KEY, result);
    return result;
  }
}
