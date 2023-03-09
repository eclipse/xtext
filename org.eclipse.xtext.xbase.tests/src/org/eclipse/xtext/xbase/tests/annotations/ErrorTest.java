/**
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.annotations;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ErrorTest extends AbstractXbaseWithAnnotationsTest {
	@Inject
	private IResourceValidator resourceValidator;

	@Inject
	private IBatchTypeResolver batchTypeResolver;

	@Test
	public void testErrorModel_01() throws Exception {
		XAnnotation annotation = processWithoutException("estdata.Annotation2(value = 'foo')");
		XAnnotationElementValuePair singleValuePair = Iterables.getFirst(annotation.getElementValuePairs(), null);
		Assert.assertNotNull(singleValuePair);
		Assert.assertNotNull(batchTypeResolver.resolveTypes(annotation).getActualType(singleValuePair.getValue()));
	}

	public XAnnotation processWithoutException(CharSequence input) throws Exception {
		Resource resource = newResource(input.toString());
		resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		return ((XAnnotation) Iterables.getFirst(resource.getContents(), null));
	}
}
