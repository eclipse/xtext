/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.typesystem.SkipCharacterInBetweenParameterizedTypeCompilerSmokeTest;
import org.eclipse.xtend.core.tests.typesystem.SkipFirstCharactersParameterizedTypeCompilerSmokeTest;
import org.eclipse.xtend.core.tests.typesystem.SkipLastCharactersParameterizedTypeCompilerSmokeTest;
import org.eclipse.xtend.core.tests.typesystem.SkipNodesInBetweenParameterizedTypeCompilerSmokeTest;
import org.eclipse.xtend.core.tests.typesystem.SkipThreeCharactersInBetweenParameterizedTypeCompilerSmokeTest;
import org.eclipse.xtend.core.tests.typesystem.SkipTokensInBetweenParameterizedTypeCompilerSmokeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	SkipCharacterInBetweenParameterizedTypeCompilerSmokeTest.class,
	SkipFirstCharactersParameterizedTypeCompilerSmokeTest.class,
	SkipLastCharactersParameterizedTypeCompilerSmokeTest.class,
	SkipNodesInBetweenParameterizedTypeCompilerSmokeTest.class,
	SkipThreeCharactersInBetweenParameterizedTypeCompilerSmokeTest.class,
	SkipTokensInBetweenParameterizedTypeCompilerSmokeTest.class,
})
public class ParameterizedTypeCompilerSmokeSuite {

}
