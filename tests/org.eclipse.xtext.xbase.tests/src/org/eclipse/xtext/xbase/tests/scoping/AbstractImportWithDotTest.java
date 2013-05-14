/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping;

import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractImportWithDotTest extends AbstractImportNormalizerTest {

	@Override
	protected QualifiedName createMapEntryImport() {
		return QualifiedName.create("java", "util", "Map", "Entry");
	}
	
}
