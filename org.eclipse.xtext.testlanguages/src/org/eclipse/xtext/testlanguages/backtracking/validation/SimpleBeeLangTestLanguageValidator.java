/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.backtracking.validation;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.BeeLangTestLanguagePackage;

import static java.util.Collections.*;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
// Stub is modified as like Sven's changes f96583ec49120cae701c9348bc27e2a66a77563a
public class SimpleBeeLangTestLanguageValidator extends AbstractSimpleBeeLangTestLanguageValidator {

	@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage) BeeLangTestLanguagePackage.eINSTANCE);
	}
}
