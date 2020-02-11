/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.annotations

import com.google.inject.Inject
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.junit.Test
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ErrorTest extends AbstractXbaseWithAnnotationsTest {
	
	@Inject
	IResourceValidator resourceValidator
	
	@Inject
	IBatchTypeResolver batchTypeResolver
	
	@Test
	def void testErrorModel_01() throws Exception {
		val annotation = '''
			estdata.Annotation2(value = 'foo')
		'''.processWithoutException
		val singleValuePair = annotation.elementValuePairs.head
		assertNotNull(batchTypeResolver.resolveTypes(annotation).getActualType(singleValuePair.value))
	}
	
	def processWithoutException(CharSequence input) throws Exception {
		val resource = newResource(input.toString)
		resourceValidator.validate(resource, CheckMode::ALL, CancelIndicator::NullImpl)
		return resource.contents.head as XAnnotation
	}	
}