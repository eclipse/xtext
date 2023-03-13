/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
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
  public MockTypeParameterSubstitutor(final ITypeReferenceOwner owner, final PublicResolvedTypes resolvedTypes) {
    super(CollectionLiterals.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner);
  }

  @Override
  public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
    return super.getTypeParameterMapping();
  }

  @Override
  public LightweightTypeReference doVisitParameterizedTypeReference(final ParameterizedTypeReference reference, final Set<JvmTypeParameter> visiting) {
    final JvmType type = reference.getType();
    if ((type instanceof JvmTypeParameter)) {
      boolean _add = visiting.add(((JvmTypeParameter)type));
      boolean _not = (!_add);
      if (_not) {
        return null;
      }
      try {
        final LightweightMergedBoundTypeArgument mappedReference = this.getTypeParameterMapping().get(type);
        if ((mappedReference != null)) {
          return mappedReference.getTypeReference().<Set<JvmTypeParameter>, LightweightTypeReference>accept(this, visiting);
        } else {
          ITypeReferenceOwner _owner = this.getOwner();
          Object _object = new Object();
          final SimpleUnboundTypeReference result = new SimpleUnboundTypeReference(_owner, ((JvmTypeParameter)type), _object);
          Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _typeParameterMapping = this.getTypeParameterMapping();
          LightweightMergedBoundTypeArgument _lightweightMergedBoundTypeArgument = new LightweightMergedBoundTypeArgument(result, VarianceInfo.INVARIANT);
          _typeParameterMapping.put(((JvmTypeParameter)type), _lightweightMergedBoundTypeArgument);
          return result;
        }
      } finally {
        visiting.remove(type);
      }
    }
    return super.doVisitParameterizedTypeReference(reference, visiting);
  }

  @Override
  public LightweightTypeReference doVisitUnboundTypeReference(final UnboundTypeReference reference, final Set<JvmTypeParameter> param) {
    return reference.copyInto(this.getOwner());
  }

  @Override
  public LightweightTypeReference substitute(final LightweightTypeReference original) {
    return original.<Set<JvmTypeParameter>, LightweightTypeReference>accept(this, CollectionLiterals.<JvmTypeParameter>newHashSet());
  }

  @Override
  protected Set<JvmTypeParameter> createVisiting() {
    return CollectionLiterals.<JvmTypeParameter>newHashSet();
  }
}
