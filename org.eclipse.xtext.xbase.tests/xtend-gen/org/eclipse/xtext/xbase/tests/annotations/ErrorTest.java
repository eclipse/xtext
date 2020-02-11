/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.annotations;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.annotations.AbstractXbaseWithAnnotationsTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
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
    final XAnnotationElementValuePair singleValuePair = IterableExtensions.<XAnnotationElementValuePair>head(annotation.getElementValuePairs());
    Assert.assertNotNull(this.batchTypeResolver.resolveTypes(annotation).getActualType(singleValuePair.getValue()));
  }
  
  public XAnnotation processWithoutException(final CharSequence input) throws Exception {
    final Resource resource = this.newResource(input.toString());
    this.resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    return ((XAnnotation) _head);
  }
}
