/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProviderPerformanceTest;
import org.eclipse.xtext.common.types.access.jdt.JavaProjectAccessTypeProviderPerformanceTest;
import org.eclipse.xtext.common.types.access.jdt.JavaProjectAccessTypeProviderSourceBasedPerformanceTest;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderPerformanceTest;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderSourceBasedPerformanceTest;
import org.eclipse.xtext.common.types.access.reflect.ReflectionTypeProviderPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	JavaProjectAccessTypeProviderPerformanceTest.class,
	JavaProjectAccessTypeProviderSourceBasedPerformanceTest.class,
	JdtTypeProviderPerformanceTest.class,
	JdtTypeProviderSourceBasedPerformanceTest.class,
	ReflectionTypeProviderPerformanceTest.class,
	ClasspathTypeProviderPerformanceTest.class,
})
public class TypeFactoryPerformanceSuite {
}
