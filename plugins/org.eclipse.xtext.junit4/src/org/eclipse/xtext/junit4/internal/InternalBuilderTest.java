/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.util.Files;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
public class InternalBuilderTest {

	@Test
	public void test() throws CoreException, FileNotFoundException {

		reportMemoryState("Starting build.");

		try {
			clearJdtIndex();
			fullBuild();
			waitForAutoBuild();
		} finally {
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

	private void clearJdtIndex() throws FileNotFoundException {
		File jdtMetadata = JavaCore.getPlugin().getStateLocation().toFile();
		boolean success = Files.sweepFolder(jdtMetadata);
		System.out.println("Clean up index " + jdtMetadata.getAbsolutePath() + ": " + (success ? "success" : "fail"));
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
