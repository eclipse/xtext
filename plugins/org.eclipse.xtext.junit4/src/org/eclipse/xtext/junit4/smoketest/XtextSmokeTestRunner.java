/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
public class XtextSmokeTestRunner extends Suite {

	public XtextSmokeTestRunner(Class<?> klass) throws InitializationError {
		super(klass, new RunnerBuilder(klass));
	}

}
