/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.tests.junit5;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.UseTechnicalNames;
import org.junit.runner.RunWith;

/**
 * Test suite that will pick up all Junit5 tests from the listed package and run them
 * when the suite is executed with Junit4.
 */
@RunWith(JUnitPlatform.class)
@UseTechnicalNames
@SelectPackages("org.eclipse.xtext.testing.tests.junit5")
public class RunJUnit5Suite {

}
