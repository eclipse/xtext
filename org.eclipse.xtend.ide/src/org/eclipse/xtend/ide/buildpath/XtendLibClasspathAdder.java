/*******************************************************************************
 * Copyright (c) 2011, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendLibClasspathAdder extends AbstractLibClasspathAdder {

	@Override
	protected IClasspathEntry createContainerClasspathEntry() {
		return JavaCore.newContainerEntry(XtendContainerInitializer.XTEND_LIBRARY_PATH);
	}

	@Override
	protected String[] getBundleIds() {
		return XtendClasspathContainer.BUNDLE_IDS_TO_INCLUDE;
	}	

	@Override
	protected String[] getImportedPackages() {
		return new String[0];
	}
}
