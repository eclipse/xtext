/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.AbstractNestedTypeAwareImportNormalizer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractNestedTypeAwareImportNormalizerTestBase extends Assert {

	protected ImportNormalizer createImportNormalizer(QualifiedName imported, boolean wildcard) {
		return AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(imported, wildcard, false);
	}
	
	@Test public abstract void testIgnoreCase();
	
}
