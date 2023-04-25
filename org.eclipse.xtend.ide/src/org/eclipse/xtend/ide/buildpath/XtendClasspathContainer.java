/*******************************************************************************
 * Copyright (c) 2012, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;

/**
 * A class-path container that makes the xbase.lib, xtend.lib and xtend.lib.macro, and Guava jars from the Eclipse installation
 * available to a project.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
final public class XtendClasspathContainer implements IClasspathContainer {

	private static final String XTEXT_XBASE_LIB_BUNDLE_ID = "org.eclipse.xtext.xbase.lib";
	private static final String XTEND_LIB_MACRO_BUNDLE_ID = "org.eclipse.xtend.lib.macro";
	private static final String XTEND_LIB_BUNDLE_ID = "org.eclipse.xtend.lib";

	public static final String[] BUNDLE_IDS_TO_INCLUDE = new String[] { "com.google.guava", XTEXT_XBASE_LIB_BUNDLE_ID,
			XTEND_LIB_BUNDLE_ID, XTEND_LIB_MACRO_BUNDLE_ID };

	private static final String SOURCE_SUFIX = ".source"; //$NON-NLS-1$
	private static final Logger LOG = Logger.getLogger(XtendClasspathContainer.class);

	private final IPath containerPath;
	private IClasspathEntry[] classPathEnries;

	XtendClasspathContainer(IPath containerPath) {
		this.containerPath = containerPath;
	}

	@Override
	public IClasspathEntry[] getClasspathEntries() {
		if (classPathEnries == null) {
			List<IClasspathEntry> cpEntries = new ArrayList<IClasspathEntry>();
			for (String bundleId : XtendClasspathContainer.BUNDLE_IDS_TO_INCLUDE) {
				addEntry(cpEntries, bundleId);
			}
			classPathEnries = cpEntries.toArray(new IClasspathEntry[] {});
		}
		return classPathEnries;
	}

	private void addEntry(final List<IClasspathEntry> cpEntries, final String bundleId) {
		Bundle bundle = Platform.getBundle(bundleId);
		if (bundle != null) {
			IPath bundlePath = bundlePath(bundle);
			IPath sourceBundlePath = calculateSourceBundlePath(bundle, bundlePath);
			cpEntries.add(JavaCore.newLibraryEntry(bundlePath, sourceBundlePath, null));
		}
	}

	private IPath bundlePath(Bundle bundle) {
		IPath path = binFolderPath(bundle);
		if (path == null) {
			// common jar file case, no bin folder
			try {
				@SuppressWarnings("all") /* Deprecated on younger TP */
				File bundleFile = FileLocator.getBundleFile(bundle);
				path = new Path(bundleFile.getAbsolutePath());
			} catch (IOException e) {
				LOG.error("Can't resolve path '" + bundle.getSymbolicName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return path;

	}

	private IPath binFolderPath(Bundle bundle) {
		URL binFolderURL = FileLocator.find(bundle, new Path("target/classes"), null); //$NON-NLS-1$
		if (binFolderURL != null) {
			try {
				URL binFolderFileURL = FileLocator.toFileURL(binFolderURL);
				return new Path(binFolderFileURL.getPath()).makeAbsolute();
			} catch (IOException e) {
				LOG.error("Can't resolve path '" + bundle.getSymbolicName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return null;
	}

	/**
	 * <p>
	 * We can't use P2Utils and we can't use SimpleConfiguratorManipulator because of API breakage between 3.5 and 4.2.
	 * So we do a bit EDV (Computer data processing) ;-)
	 * </p>
	 */
	private IPath calculateSourceBundlePath(Bundle bundle, IPath bundleLocation) {
		IPath sourcesPath = null;
		// Not an essential functionality, make it robust
		try {
			IPath binFolderPath = binFolderPath(bundle);
			if (binFolderPath == null) {
				//common case, jar file.
				IPath bundlesParentFolder = bundleLocation.removeLastSegments(1);
				String binaryJarName = bundleLocation.lastSegment();
				String symbolicName = bundle.getSymbolicName();
				String sourceJarName = binaryJarName.replace(symbolicName, symbolicName.concat(SOURCE_SUFIX));
				IPath potentialSourceJar = bundlesParentFolder.append(sourceJarName);
				if (potentialSourceJar.toFile().exists())
					sourcesPath = potentialSourceJar;
			} else {
				if (binFolderPath.toString().endsWith("bin/main/")) { //$NON-NLS-1$
					sourcesPath = binFolderPath.removeLastSegments(2);
				} else {
					sourcesPath = binFolderPath.removeLastSegments(1);
				}
			}
		} catch (Throwable t) {
			LOG.debug("Exception during source bundle inverstigation.", t);
		}
		return sourcesPath;
	}

	@Override
	public String getDescription() {
		return Messages.XtendClasspathContainer_Description;
	}

	@Override
	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	@Override
	public IPath getPath() {
		return containerPath;
	}
}