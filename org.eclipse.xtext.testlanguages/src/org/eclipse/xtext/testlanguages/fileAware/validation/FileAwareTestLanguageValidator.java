/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.validation;

import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage;
import org.eclipse.xtext.validation.Check;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class FileAwareTestLanguageValidator extends AbstractFileAwareTestLanguageValidator {

	public static final String INVALID_NAME = "invalidName";

	@Check
	public void checkGreetingStartsWithCapital(Element element) {
		if ("LetItFail".equals(element.getName())) {
			warning("LetItFail really is a bad name!", FileAwarePackage.Literals.ELEMENT__NAME, INVALID_NAME);
		}
	}

}
