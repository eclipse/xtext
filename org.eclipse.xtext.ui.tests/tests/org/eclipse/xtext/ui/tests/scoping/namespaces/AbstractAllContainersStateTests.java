/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.scoping.namespaces;

import org.eclipse.core.runtime.CoreException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractAllContainersStateTests extends AbstractContainerRelatedTests {

	public abstract void testRemoveNature() throws CoreException;
	
}
