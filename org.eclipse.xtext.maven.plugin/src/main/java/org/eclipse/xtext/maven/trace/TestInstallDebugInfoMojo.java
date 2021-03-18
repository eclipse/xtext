/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.maven.trace;

import java.io.File;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Attaches trace (debug) information to all target test classes
 * 
 * @since 2.26
 * 
 * @author Heinrich Weichert
 */
@Mojo(name = "test-install-debug-info", defaultPhase = LifecyclePhase.PROCESS_TEST_CLASSES, threadSafe = true)
public class TestInstallDebugInfoMojo extends AbstractInstallDebugInfoMojo {

	protected File getOutputDirectory() {
		return resolveFilePath(getProject().getBuild().getTestOutputDirectory());
	}

}
