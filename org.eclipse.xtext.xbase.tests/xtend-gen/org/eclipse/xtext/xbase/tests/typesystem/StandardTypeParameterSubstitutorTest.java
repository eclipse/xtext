/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Map;
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
    Assert.assertEquals("Object[]", substituted.getSimpleName());
  }
  
  @Test
  public void testArrayOfWildcardString() {
    final LightweightTypeReference substituted = this.substituteInArrayContext("? extends String");
    Assert.assertEquals("String[]", substituted.getSimpleName());
  }
  
  @Test
  public void testArrayOfWildcardSuperString() {
    final LightweightTypeReference substituted = this.substituteInArrayContext("? super String");
    Assert.assertEquals("Object[]", substituted.getSimpleName());
  }
  
  protected LightweightTypeReference substituteInArrayContext(final String componentType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Iterable<");
    _builder.append(componentType);
    _builder.append(">");
    final LightweightTypeReference typeReference = this.toTypeReference(_builder);
    final DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
    final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = collector.getTypeParameterMapping(typeReference);
    Assert.assertEquals(1, mapping.size());
    final JvmTypeParameter typeParameter = IterableExtensions.<JvmTypeParameter>head(mapping.keySet());
    final LightweightMergedBoundTypeArgument boundArgument = mapping.get(typeParameter);
    Assert.assertEquals(componentType, boundArgument.getTypeReference().getSimpleName());
    final ITypeReferenceOwner owner = typeReference.getOwner();
    final ArrayTypeReference originalArray = owner.newArrayTypeReference(owner.newParameterizedTypeReference(typeParameter));
    Assert.assertEquals("T[]", originalArray.getSimpleName());
    ITypeReferenceOwner _owner = typeReference.getOwner();
    final LightweightTypeReference substitutedArray = new StandardTypeParameterSubstitutor(mapping, _owner).substitute(originalArray);
    return substitutedArray;
  }
  
  protected LightweightTypeReference toTypeReference(final CharSequence reference) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("null as ");
      _builder.append(reference);
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
