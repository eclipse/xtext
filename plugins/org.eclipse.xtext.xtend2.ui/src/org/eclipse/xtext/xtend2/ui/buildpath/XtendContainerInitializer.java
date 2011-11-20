/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.buildpath;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendContainerInitializer extends ClasspathContainerInitializer {

	private static final String XTEXT_XTEND2_LIB_BUNDLE_ID = "org.eclipse.xtend2.lib";

	private static final String XTEXT_XBASE_LIB_BUNDLE_ID = "org.eclipse.xtext.xbase.lib";

	public static final Path XTEND_LIBRARY_PATH = new Path("org.eclipse.xtend.XTEND_CONTAINER"); //$NON-NLS-1$

	public static final String[] BUNDLE_IDS_TO_INCLUDE = new String[] { "com.google.collect", "com.google.inject",
			XTEXT_XBASE_LIB_BUNDLE_ID, XTEXT_XTEND2_LIB_BUNDLE_ID };

	private static final Logger LOG = Logger.getLogger(XtendContainerInitializer.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(final IPath containerPath, final IJavaProject project) throws CoreException {
		if (isXtendPath(containerPath)) {
			IClasspathContainer container = createContainer(containerPath);
			JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
					new IClasspathContainer[] { container }, null);
		}
	}

	/**
	 * Allows users to manually add source bundles
	 */
	@Override
	public boolean canUpdateClasspathContainer(IPath containerPath, IJavaProject project) {
		return true;
	}

	@Override
	public void requestClasspathContainerUpdate(final IPath containerPath, final IJavaProject project,
			final IClasspathContainer containerSuggestion) throws CoreException {
		super.requestClasspathContainerUpdate(containerPath, project, containerSuggestion);
		new Job("Classpath container update") { //$NON-NLS-1$
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
							new IClasspathContainer[] { containerSuggestion }, null);
				} catch (CoreException ex) {
					return new Status(IStatus.ERROR, Xtend2Activator.getInstance().getBundle().getSymbolicName(), 0,
							"Classpath container update failed", ex); //$NON-NLS-1$
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private IClasspathContainer createContainer(final IPath containerPath) {
		return new XtendClasspathContainer(containerPath);
	}

	private boolean isXtendPath(final IPath containerPath) {
		return XTEND_LIBRARY_PATH.equals(containerPath);
	}

	/**
	 * @author Dennis Huebner - Initial contribution and API
	 */
	private final static class XtendClasspathContainer implements IClasspathContainer {

		private static final String SOURCE_SUFIX = ".source"; //$NON-NLS-1$

		private final IPath containerPath;

		private XtendClasspathContainer(IPath containerPath) {
			this.containerPath = containerPath;
		}

		/**
		 * {@inheritDoc}
		 */
		public IClasspathEntry[] getClasspathEntries() {
			List<IClasspathEntry> cpEntries = new ArrayList<IClasspathEntry>();
			for (String bundleId : BUNDLE_IDS_TO_INCLUDE) {
				addEntry(cpEntries, bundleId);
			}
			return cpEntries.toArray(new IClasspathEntry[] {});
		}

		private void addEntry(final List<IClasspathEntry> cpEntries, final String bundleId) {
			IPath bundlePath = findBundle(bundleId);
			if (bundlePath != null) {
				IPath sourceBundlePath = findBundle(bundleId.concat(SOURCE_SUFIX));
				IClasspathAttribute[] extraAttributes = null;
				if (XTEXT_XBASE_LIB_BUNDLE_ID.equals(bundleId) || XTEXT_XTEND2_LIB_BUNDLE_ID.equals(bundleId)) {
					extraAttributes = new IClasspathAttribute[] { JavaCore.newClasspathAttribute(
							IClasspathAttribute.JAVADOC_LOCATION_ATTRIBUTE_NAME, calculateJavadocURL()) };
				}
				cpEntries.add(JavaCore.newLibraryEntry(bundlePath, sourceBundlePath, null, new IAccessRule[] {},
						extraAttributes, false));
			}
		}

		/**
		 * Builds the Javadoc online URL.<br>
		 * For example javadoc for version 2.1.1 looks like this:<br>
		 * http://download.eclipse.org/modeling/tmf/xtext/javadoc/2.1.1/
		 */
		private String calculateJavadocURL() {
			Version xtend2version = Xtend2Activator.getInstance().getBundle().getVersion();
			StringBuilder builder = new StringBuilder("http://download.eclipse.org/modeling/tmf/xtext/javadoc/");
			builder.append(xtend2version.getMajor()).append(".");
			builder.append(xtend2version.getMinor()).append(".");
			builder.append(xtend2version.getMicro()).append("/");
			return builder.toString();
		}

		private IPath findBundle(String bundleId) {
			Bundle bundle = Platform.getBundle(bundleId);
			if (bundle != null) {
				File bundleFile = null;
				try {
					bundleFile = FileLocator.getBundleFile(bundle);
					IPath path = new Path(bundleFile.getAbsolutePath());
					if (!path.isAbsolute()) {
						path = path.makeAbsolute();
					}
					return path;
				} catch (IOException e) {
					LOG.error("Can't resolve bundle '" + bundleId + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
			return null;

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

}
