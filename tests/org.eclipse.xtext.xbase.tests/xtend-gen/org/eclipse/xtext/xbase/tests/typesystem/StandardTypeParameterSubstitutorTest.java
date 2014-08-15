/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class StandardTypeParameterSubstitutorTest extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Test
  public void testArrayOfWildcard() {
    final LightweightTypeReference substituted = this.substituteInArrayContext("?");
    String _simpleName = substituted.getSimpleName();
    Assert.assertEquals("Object[]", _simpleName);
  }
  
  @Test
  public void testArrayOfWildcardString() {
    final LightweightTypeReference substituted = this.substituteInArrayContext("? extends String");
    String _simpleName = substituted.getSimpleName();
    Assert.assertEquals("String[]", _simpleName);
  }
  
  @Test
  public void testArrayOfWildcardSuperString() {
    final LightweightTypeReference substituted = this.substituteInArrayContext("? super String");
    String _simpleName = substituted.getSimpleName();
    Assert.assertEquals("Object[]", _simpleName);
  }
  
  protected LightweightTypeReference substituteInArrayContext(final String componentType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Iterable<");
    _builder.append(componentType, "");
    _builder.append(">");
    final LightweightTypeReference typeReference = this.toTypeReference(_builder);
    final DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
    final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = collector.getTypeParameterMapping(typeReference);
    int _size = mapping.size();
    Assert.assertEquals(1, _size);
    Set<JvmTypeParameter> _keySet = mapping.keySet();
    final JvmTypeParameter typeParameter = IterableExtensions.<JvmTypeParameter>head(_keySet);
    final LightweightMergedBoundTypeArgument boundArgument = mapping.get(typeParameter);
    LightweightTypeReference _typeReference = boundArgument.getTypeReference();
    String _simpleName = _typeReference.getSimpleName();
    Assert.assertEquals(componentType, _simpleName);
    final ITypeReferenceOwner owner = typeReference.getOwner();
    ParameterizedTypeReference _newParameterizedTypeReference = owner.newParameterizedTypeReference(typeParameter);
    final ArrayTypeReference originalArray = owner.newArrayTypeReference(_newParameterizedTypeReference);
    String _simpleName_1 = originalArray.getSimpleName();
    Assert.assertEquals("T[]", _simpleName_1);
    ITypeReferenceOwner _owner = typeReference.getOwner();
    StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, _owner);
    final LightweightTypeReference substitutedArray = _standardTypeParameterSubstitutor.substitute(originalArray);
    return substitutedArray;
  }
  
  protected LightweightTypeReference toTypeReference(final CharSequence reference) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("null as ");
      _builder.append(reference, "");
      final String expression = _builder.toString();
      XExpression _expression = this.expression(expression);
      final XCastedExpression castExpression = ((XCastedExpression) _expression);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(castExpression);
      return resolvedTypes.getActualType(castExpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
