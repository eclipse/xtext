/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtext.junit4.smoketest.ProcessedBy;
import org.eclipse.xtext.junit4.smoketest.XtextSmokeTestRunner;
import org.eclipse.xtext.xbase.junit.typesystem.NoJRESmokeTester;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextSmokeTestRunner.class)
@ProcessedBy(value = NoJRESmokeTester.class, processCompleteInput = true)
public class NoJRESuite extends CompilerSuite {
}
