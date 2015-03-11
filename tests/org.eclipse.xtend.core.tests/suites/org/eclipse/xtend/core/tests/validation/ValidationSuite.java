/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	CheckedExceptionTest.class,
	FeatureCallValidationTest.class,
	FeatureCallValidationWithCustomSynonymsTest.class,
	OverrideValidationTest.class,
	RichStringValidationTest.class,
	XtendValidationTest.class,
	AnnotationValidationTest.class,
	CompoundAssignmentOperatorValidationTest.class,
	LambdaValidationTest.class,
	ModifierValidationTest.class,
	OperatorDeclarationTest.class,
	PostfixOperatorValidationTest.class,
	SuspiciousOverloadValidationTest.class,
	ValidationBug371957Test.class,
	ValidationBug398302Test.class,
	ValidationBug409602Test.class,
	ValidationBug419050Test.class,
	ValidationBug427432Test.class,
	ValidationBug432193Test.class,
	ValidationBug433213Test.class,
	ValidationBug434409Test.class,
	ValidationBug437678Test.class,
	ValidationBug447516Test.class,
	ValidationBug450834Test.class,
	ValidationBug452602Test.class,
	AmbiguityValidationSuite.class,
	AnonymousClassValidationTest.class,
	NestedClassValidationTest.class,
	VisibilityValidationTest.class,
	UniqueClassNameValidatorRuntimeTest.class
})
public class ValidationSuite {
}
