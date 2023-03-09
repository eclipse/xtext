/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import org.eclipse.xtext.xbase.tests.annotations.AnnotationsValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	AnnotationsValidatorTest.class,
	AssignmentTests.class,
	FeatureCallValidationTest.class,
	JvmTypeReferencesValidatorTest.class,
	TypeConformanceValidatorTest.class,
	ValidationTests.class,
	CheckedExceptionTest.class,
	EqualsWithNullTest.class,
	XbaseValidationTest.class
})
public class ValidationSuite {}
