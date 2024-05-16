/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.testlanguages.jvmmodel.JvmGenericTypeValidatorTestLangJmvModelInferrer;
import org.eclipse.xtext.xbase.testlanguages.scoping.JvmGenericTypeValidatorTestLangQualifiedNameProvider;

/**
 * @author Lorenzo Bettini
 */
public class JvmGenericTypeValidatorTestLangRuntimeModule extends AbstractJvmGenericTypeValidatorTestLangRuntimeModule {
	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return JvmGenericTypeValidatorTestLangJmvModelInferrer.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return JvmGenericTypeValidatorTestLangQualifiedNameProvider.class;
	}
}
