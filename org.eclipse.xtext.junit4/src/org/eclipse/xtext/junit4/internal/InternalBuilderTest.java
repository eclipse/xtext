/*******************************************************************************
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.internal;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public class InternalBuilderTest {

	@Test
	public void test() throws CoreException, FileNotFoundException {

		System.out.println("JDT Version:" + JavaCore.getPlugin().getBundle().getVersion());
		System.out.println("JDT UI Version:" + JavaPlugin.getDefault().getBundle().getVersion());
		reportMemoryState("Starting build.");

		try {
			dumpMemoryIndex("Initial Memory Index state");
			dumpDiskIndex();

			clearJdtIndex();
			dumpMemoryIndex("Memory Index state after clear disk");
			dumpDiskIndex();
			
			JavaModelManager.getIndexManager().resetIndex(new Path("/org.eclipse.xtext"));
			dumpMemoryIndex("Memory Index state after reset project");
			dumpDiskIndex();
			
			System.out.println("Saving index.");
			JavaModelManager.getIndexManager().saveIndexes();
			dumpMemoryIndex("Memory Index state after save");
			dumpDiskIndex();

			
			setAutoBuild(true);
			waitForAutoBuild();
		} finally {
			setAutoBuild(false);
			System.out.println("Stopping background indexing.");
			JavaModelManager.getIndexManager().shutdown();
			clearJdtIndex();
			reportMemoryState("Finished build.");
		}
		final IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot()
				.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		List<String> errors = new ArrayList<String>();
		for (IMarker marker : markers) {
			String msg = MarkerUtilities.getMessage(marker);
			if (MarkerUtilities.getSeverity(marker) == IMarker.SEVERITY_ERROR) {
				errors.add(msg + " in " + marker.getResource().getFullPath() + " line: "
						+ MarkerUtilities.getLineNumber(marker));
			}
		}

		List<String> top10;
		if (errors.size() > 10) {
			top10 = toList(take(errors, 10));
		} else {
			top10 = errors;
		}

		assertTrue("Problems found (" + top10.size() + " of " + errors.size() + "): " + join(errors, ", "),
				errors.isEmpty());
	}

	private void dumpMemoryIndex(String message) {
		System.out.println(message + ":\n" + JavaModelManager.getIndexManager().toString());
	}


	private void dumpDiskIndex() {
		File jdtMetadata = JavaCore.getPlugin().getStateLocation().toFile();
		String[] files = jdtMetadata.list();
		System.out.println("Disk index: " + (files == null ? '0' : files.length) + " files.");
	}

	private void clearJdtIndex() throws FileNotFoundException {
		JavaModelManager.getIndexManager().deleteIndexFiles();
		System.out.println("Cleaned up jdt's disk index.");
	}

	private void reportMemoryState(String reportName) {
		System.out.println(reportName + " Memory max=" + Runtime.getRuntime().maxMemory() / (1024 * 1024) + "m, total="
				+ Runtime.getRuntime().totalMemory() / (1024 * 1024) + "m, free=" + Runtime.getRuntime().freeMemory()
				/ (1024 * 1024) + "m");
	}

	public static void cleanBuild() throws CoreException {
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD, null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	public static void fullBuild() throws CoreException {
		System.out.println("Starting full build");
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD, null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	public static void waitForAutoBuild() {
		System.out.println("Waiting for auto-build");

		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	public static void setAutoBuild(boolean b) {
		System.out.println("Setting auto-build to " + b);

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		try {
			IWorkspaceDescription desc = workspace.getDescription();
			desc.setAutoBuilding(b);
			workspace.setDescription(desc);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
