/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.junit4.formatter.FormatterTestRequest
import org.eclipse.xtext.junit4.formatter.FormatterTester

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class GenericFormatterTester {
	@Inject FormatterTesterWithImpl tester
	@Inject Provider<GenericFormatterTestRequest> requestProvider

	def void assertFormatted((GenericFormatterTestRequest)=>void test) {
		val request = requestProvider.get()
		test.apply(request)
		tester.assertFormatted(request)
	}
}

class FormatterTesterWithImpl extends FormatterTester {
	override protected createFormatter(FormatterTestRequest req) {
		(req as GenericFormatterTestRequest).formatter
	}
}

class GenericFormatterTestRequest extends FormatterTestRequest {
	@Accessors GenericFormatter<? extends EObject> formatter
}

@Accessors abstract class GenericFormatter<T extends EObject> extends AbstractFormatter2 {
	def dispatch format(EObject obj, IFormattableDocument document) {
		format(obj as T, request.textRegionAccess, document)
	}

	def protected abstract void format(T model, ITextRegionAccess regionAccess, IFormattableDocument document)
}
