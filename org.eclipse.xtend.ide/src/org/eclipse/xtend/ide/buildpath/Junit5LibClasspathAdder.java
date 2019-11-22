/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author vivienjovet - Initial contribution and API
 */
public class Junit5LibClasspathAdder extends AbstractLibClasspathAdder {

	public static final IPath JUNIT5_LIBRARY_PATH = new Path("org.eclipse.jdt.junit.JUNIT_CONTAINER/5");
	public static final String[] BUNDLE_IDS = new String[] { 
			"org.junit", "org.junit.jupiter.api", "org.junit.jupiter.engine",
			"org.junit.jupiter.migrationsupport", "org.junit.jupiter.params", 
			"org.junit.platform.commons", "org.junit.platform.engine",
			"org.junit.platform.launcher", "org.junit.platform.runner", 
			"org.junit.platform.suite.api", "org.junit.vintage.engine",
			"org.hamcrest.core", "org.opentest4j", "org.apiguardian"
	};

	@Override
	protected IClasspathEntry createContainerClasspathEntry() {
		return JavaCore.newContainerEntry(JUNIT5_LIBRARY_PATH);
	}

	@Override
	protected String[] getBundleIds() {
		return BUNDLE_IDS;
	}

}
