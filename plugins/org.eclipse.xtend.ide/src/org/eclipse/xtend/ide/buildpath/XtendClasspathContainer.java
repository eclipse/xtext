/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
final public class XtendClasspathContainer implements IClasspathContainer {

	private static final String SOURCE_SUFIX = ".source"; //$NON-NLS-1$

	private final IPath containerPath;

	private IClasspathEntry[] classPathEnries;
	static final Logger LOG = Logger.getLogger(XtendClasspathContainer.class);

	XtendClasspathContainer(IPath containerPath) {
		this.containerPath = containerPath;
	}

	/**
	 * {@inheritDoc}
	 */
	public IClasspathEntry[] getClasspathEntries() {
		if (classPathEnries == null) {
			List<IClasspathEntry> cpEntries = new ArrayList<IClasspathEntry>();
			for (String bundleId : XtendContainerInitializer.BUNDLE_IDS_TO_INCLUDE) {
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
			IClasspathAttribute[] extraAttributes = null;
			if (XtendContainerInitializer.XTEXT_XBASE_LIB_BUNDLE_ID.equals(bundleId)
					|| XtendContainerInitializer.XTEND_LIB_BUNDLE_ID.equals(bundleId)) {
				extraAttributes = new IClasspathAttribute[] { JavaCore.newClasspathAttribute(
						IClasspathAttribute.JAVADOC_LOCATION_ATTRIBUTE_NAME, calculateJavadocURL()) };
			}
			cpEntries.add(JavaCore.newLibraryEntry(bundlePath, sourceBundlePath, null, new IAccessRule[] {},
					extraAttributes, false));
		}
	}

	/**
	 * Builds the Javadoc online URL.<br>
	 * For example javadoc for version 2.3.0 looks like this:<br>
	 * http://download.eclipse.org/modeling/tmf/xtext/javadoc/2.3/
	 */
	private String calculateJavadocURL() {
		Version xtendVersion = XtendActivator.getInstance().getBundle().getVersion();
		StringBuilder builder = new StringBuilder("http://download.eclipse.org/modeling/tmf/xtext/javadoc/");
		builder.append(xtendVersion.getMajor()).append(".");
		builder.append(xtendVersion.getMinor()).append("/");
		return builder.toString();
	}

	private IPath bundlePath(Bundle bundle) {
		IPath path = null;
		try {
			URL binFolderURL = binFolderURL(bundle);
			if (binFolderURL != null) {
				path = new Path(FileLocator.toFileURL(binFolderURL).getPath()).makeAbsolute();
			} else {
				path = new Path(FileLocator.getBundleFile(bundle).getAbsolutePath());
			}
		} catch (IOException e) {
			LOG.error("Can't resolve path '" + bundle.getSymbolicName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return path;

	}

	private URL binFolderURL(Bundle bundle) {
		URL binFolderURL = FileLocator.find(bundle, new Path("bin"), null);
		return binFolderURL;
	}

	/**
	 * <p>
	 * We can't use P2Utils and we can't use SimpleConfiguratorManipulator because of API breakage between 3.5 and 4.2.
	 * So we do a bit EDV (Computer data processing) ;-)
	 * </p>
	 */
	private IPath calculateSourceBundlePath(Bundle bundle, IPath bundleLocation) {
		IPath sourcesPath = null;
		try {
			URL binFolderURL = binFolderURL(bundle);
			if (binFolderURL == null) {
				//common case, jar file.
				IPath bundlesParentFolder = bundleLocation.removeLastSegments(1);
				String binaryJarName = bundleLocation.lastSegment();
				String symbolicName = bundle.getSymbolicName();
				String sourceJarName = binaryJarName.replace(symbolicName, symbolicName.concat(SOURCE_SUFIX));
				IPath potentialSourceJar = bundlesParentFolder.append(sourceJarName);
				if (potentialSourceJar.toFile().exists())
					sourcesPath = potentialSourceJar;
			} else {
				sourcesPath = new Path(FileLocator.toFileURL(binFolderURL).getPath()).removeLastSegments(1);
			}
		} catch (Throwable t) {
			//Not an essential functionality, make it robust
			LOG.warn("Exception during source bundle inverstigation.", t);
		}
		return sourcesPath;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return Messages.XtendClasspathContainer_Description;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPath getPath() {
		return containerPath;
	}
}