/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.osgi.internal.framework.EquinoxBundle;
import org.eclipse.osgi.storage.BundleInfo.Generation;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetLocation;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.core.target.LoadTargetDefinitionJob;
import org.eclipse.pde.internal.core.target.TargetPlatformService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author dietrich - Initial contribution and API
 * 
 * @since 2.12
 */
public class TargetPlatformUtil {
	
	/**
	 * @deprecated use {@link #setTargetPlatform(Class)} instead.
	 */
	@Deprecated
	public static void setTargetPlatform() throws Exception {
		setTargetPlatform(TargetPlatformUtil.class);
	}
	
	/**
	 * Sets the target platform for tests (to be used in tycho mainly)
	 * @param context any class of the test bundle to be able to determine the test bundle
	 * @since 2.14
	 */
	public static void setTargetPlatform(Class<?> context) throws Exception {
		if (isPdeLaunch()) {
			return;
		}
		Bundle currentBundle = FrameworkUtil.getBundle(context);
		ITargetPlatformService tpService = TargetPlatformService.getDefault();
		ITargetDefinition targetDef = tpService.newTarget();
		targetDef.setName("Tycho platform");
		Bundle[] bundles = FrameworkUtil.getBundle(Platform.class).getBundleContext().getBundles();
		List<ITargetLocation> bundleContainers = new ArrayList<ITargetLocation>();
		Set<File> dirs = new HashSet<File>();
		for (Bundle bundle : bundles) {
			if (bundle.equals(currentBundle)) {
				// we skip the current bundle, otherwise the folder for the target platform
				// will include the absolute directory of the maven parent project
				// since the projects are nested in the parent project the result
				// would be that Java packages of our project will be available twice
				// and Java won't be able to find our classes leading in compilation
				// errors during our tests.
				continue;
			}
			EquinoxBundle bundleImpl = (EquinoxBundle) bundle;
			Generation generation = (Generation) bundleImpl.getModule().getCurrentRevision().getRevisionInfo();
			File file = generation.getBundleFile().getBaseFile();
			File folder = file.getParentFile();
			if (!dirs.contains(folder)) {
				dirs.add(folder);
				bundleContainers.add(tpService.newDirectoryLocation(folder.getAbsolutePath()));
			}
		}
		targetDef.setTargetLocations(bundleContainers.toArray(new ITargetLocation[bundleContainers.size()]));
		targetDef.setArch(Platform.getOSArch());
		targetDef.setOS(Platform.getOS());
		targetDef.setWS(Platform.getWS());
		targetDef.setNL(Platform.getNL());
		// targetDef.setJREContainer()
		tpService.saveTargetDefinition(targetDef);

		Job job = new LoadTargetDefinitionJob(targetDef);
		job.schedule();
		job.join();
	}

	private static boolean isPdeLaunch() {
		return Boolean.getBoolean("eclipse.pde.launch");
	}

}
