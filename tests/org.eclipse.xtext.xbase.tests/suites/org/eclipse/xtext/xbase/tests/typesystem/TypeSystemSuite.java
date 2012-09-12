/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.linking.BatchLinkingTest;
import org.eclipse.xtext.xbase.tests.typesystem.BatchClosureTypeTest;
import org.eclipse.xtext.xbase.tests.typesystem.BatchConstructorCallTypeTests;
import org.eclipse.xtext.xbase.tests.typesystem.BatchFeatureCallTypeTests;
import org.eclipse.xtext.xbase.tests.typesystem.BatchIdentifiableTypeTests;
import org.eclipse.xtext.xbase.tests.typesystem.BatchTypeArgumentTest;
import org.eclipse.xtext.xbase.tests.typesystem.BatchTypeResolverTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	BatchTypeResolverTest.class,
	BatchFeatureCallTypeTests.class,
	BatchClosureTypeTest.class,
	BatchIdentifiableTypeTests.class,
	BatchConstructorCallTypeTests.class,
	BatchTypeArgumentTest.class,
	BatchLinkingTest.class,
	StringLiteralTest.class,
	ClosureTypeTest1.class,
	ClosureTypeTest2.class,
	ClosureTypeTest3.class,
	ClosureTypeComputerUnitTest.class,
})
public class TypeSystemSuite {}
