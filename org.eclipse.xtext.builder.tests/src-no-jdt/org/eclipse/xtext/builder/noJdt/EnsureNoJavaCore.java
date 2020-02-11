/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.noJdt;

import org.eclipse.jdt.core.JavaCore;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
public class EnsureNoJavaCore {

	@Test(expected = NoClassDefFoundError.class)
	public void testJavaCoreNotAvailable() {
		JavaCore.class.getName();
	}
	
}
