/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.linking.BatchLinkingTest;
import org.eclipse.xtext.xbase.tests.typing.XbaseTypeProviderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	BatchTypeResolverTest.class,
	BatchReturnTypeResolverTest.class,
	BatchFeatureCallTypeTest.class,
	BatchIdentifiableTypeTest.class,
	BatchConstructorCallTypeTest.class,
	RecomputingTypeSystemSuite.class,
	StringLiteralTest.class,
	ClosureTypeSystemSuite.class,
	BatchLinkingTest.class,
	ExpectationSuite.class,
	XbaseTypeProviderTest.class
})
public class TypeSystemSuite {}
