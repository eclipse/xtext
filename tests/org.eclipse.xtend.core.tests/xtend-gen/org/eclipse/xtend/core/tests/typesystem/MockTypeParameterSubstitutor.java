/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.core.tests.typesystem.SimpleUnboundTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class MockTypeParameterSubstitutor extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
  private final PublicResolvedTypes resolvedTypes;
  
  public MockTypeParameterSubstitutor(final ITypeReferenceOwner owner, final PublicResolvedTypes resolvedTypes) {
    super(CollectionLiterals.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner);
    this.resolvedTypes = resolvedTypes;
  }
  
  public Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
    return super.getTypeParameterMapping();
  }
  
  public LightweightTypeReference doVisitParameterizedTypeReference(final ParameterizedTypeReference reference, final Set<JvmTypeParameter> visiting) {
    final JvmType type = reference.getType();
    if ((type instanceof JvmTypeParameter)) {
      boolean _add = visiting.add(((JvmTypeParameter)type));
      boolean _not = (!_add);
      if (_not) {
        return null;
      }
      try {
        Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _typeParameterMapping = this.getTypeParameterMapping();
        final LightweightMergedBoundTypeArgument mappedReference = _typeParameterMapping.get(type);
        boolean _notEquals = (!Objects.equal(mappedReference, null));
        if (_notEquals) {
          LightweightTypeReference _typeReference = mappedReference.getTypeReference();
          return _typeReference.<Set<JvmTypeParameter>, LightweightTypeReference>accept(this, visiting);
        } else {
          ITypeReferenceOwner _owner = this.getOwner();
          Object _object = new Object();
          final SimpleUnboundTypeReference result = new SimpleUnboundTypeReference(_owner, ((JvmTypeParameter)type), _object);
          Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> _typeParameterMapping_1 = this.getTypeParameterMapping();
          LightweightMergedBoundTypeArgument _lightweightMergedBoundTypeArgument = new LightweightMergedBoundTypeArgument(result, VarianceInfo.INVARIANT);
          _typeParameterMapping_1.put(((JvmTypeParameter)type), _lightweightMergedBoundTypeArgument);
          return result;
        }
      } finally {
        visiting.remove(type);
      }
    }
    return super.doVisitParameterizedTypeReference(reference, visiting);
  }
  
  public LightweightTypeReference doVisitUnboundTypeReference(final UnboundTypeReference reference, final Set<JvmTypeParameter> param) {
    ITypeReferenceOwner _owner = this.getOwner();
    return reference.copyInto(_owner);
  }
  
  public LightweightTypeReference substitute(final LightweightTypeReference original) {
    HashSet<JvmTypeParameter> _newHashSet = CollectionLiterals.<JvmTypeParameter>newHashSet();
    return original.<Set<JvmTypeParameter>, LightweightTypeReference>accept(this, _newHashSet);
  }
  
  protected Set<JvmTypeParameter> createVisiting() {
    return CollectionLiterals.<JvmTypeParameter>newHashSet();
  }
}
