/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.validation;

import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.validation.JvmGenericTypeValidator;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@ComposedChecks(validators = JvmGenericTypeValidator.class)
public class JvmGenericTypeValidatorTestLangValidator extends AbstractJvmGenericTypeValidatorTestLangValidator {
	
}
