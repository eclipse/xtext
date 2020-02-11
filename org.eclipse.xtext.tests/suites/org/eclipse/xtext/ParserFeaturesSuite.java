/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.xtext.grammarinheritance.SuperCallSuite;
import org.eclipse.xtext.parser.fragments.FragmentsSuite;
import org.eclipse.xtext.parser.parameters.ParametersSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	FragmentsSuite.class,
	SuperCallSuite.class,
	ParametersSuite.class
})
public class ParserFeaturesSuite {

}
