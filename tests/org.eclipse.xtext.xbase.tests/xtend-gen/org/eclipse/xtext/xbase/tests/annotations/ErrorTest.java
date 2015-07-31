/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.annotations;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.annotations.AbstractXbaseWithAnnotationsTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ErrorTest extends AbstractXbaseWithAnnotationsTest {
  @Inject
  private IResourceValidator resourceValidator;
  
  @Inject
  private IBatchTypeResolver batchTypeResolver;
  
  @Test
  public void testErrorModel_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("estdata.Annotation2(value = \'foo\')");
    _builder.newLine();
    final XAnnotation annotation = this.processWithoutException(_builder);
    EList<XAnnotationElementValuePair> _elementValuePairs = annotation.getElementValuePairs();
    final XAnnotationElementValuePair singleValuePair = IterableExtensions.<XAnnotationElementValuePair>head(_elementValuePairs);
    IResolvedTypes _resolveTypes = this.batchTypeResolver.resolveTypes(annotation);
    XExpression _value = singleValuePair.getValue();
    LightweightTypeReference _actualType = _resolveTypes.getActualType(_value);
    Assert.assertNotNull(_actualType);
  }
  
  public XAnnotation processWithoutException(final CharSequence input) throws Exception {
    try {
      String _string = input.toString();
      final Resource resource = this.newResource(_string);
      this.resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
      EList<EObject> _contents = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      return ((XAnnotation) _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
