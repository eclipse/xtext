/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaModelMarker;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * This class copies the error markers from a given derived resources into its source resource.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class DerivedResourceMarkerCopier {

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Inject
	private ITraceForStorageProvider traceInformation;

	/**
	 * Looks for JDT error marker in javaFile and adds a copy to the corresponding<br>
	 * source resource. If the source resource already contains error marker, nothing will be added.
	 *
	 * @param javaFile
	 *            - Java file to inspect
	 */
	public void reflectErrorMarkerInSource(IFile javaFile) throws CoreException {
		if (javaFile.findMaxProblemSeverity(IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, true, IResource.DEPTH_ZERO) < IMarker.SEVERITY_ERROR) {
			return;
		}
		ITrace traceToSource = traceInformation.getTraceToSource(javaFile);
		if (traceToSource != null) {
			IWorkspace workspace = javaFile.getWorkspace();
			Set<Triple<IFile, String, ILocationInResource>> markers = new HashSet<Triple<IFile, String, ILocationInResource>>();

			for (IMarker marker : javaFile.findMarkers(IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, true,
					IResource.DEPTH_ZERO)) {
				String message = (String) marker.getAttribute(IMarker.MESSAGE);
				if (message == null) {
					continue;
				}
				Integer charStart = marker.getAttribute(IMarker.CHAR_START, 0);
				Integer charEnd = marker.getAttribute(IMarker.CHAR_END, 0);

				ILocationInResource associatedLocation = traceToSource.getBestAssociatedLocation(new TextRegion(
						charStart, charEnd - charStart));
				if (associatedLocation != null) {
					IFile srcFile = workspace.getRoot().getFile(associatedLocation.getStorage().getFullPath());

					if (srcFile.findMaxProblemSeverity(MarkerTypes.ANY_VALIDATION, true, IResource.DEPTH_ZERO) < IMarker.SEVERITY_ERROR) {

						Triple<IFile, String, ILocationInResource> markerData = Tuples.create(srcFile, message,
								associatedLocation);
						markers.add(markerData);
					}
				}
			}
			if (markers.size() > 0) {
				createMarkers(markers, workspace);
			}
		}
	}

	private void createMarkers(final Set<Triple<IFile, String, ILocationInResource>> markers, IWorkspace workspace) {
		final Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setType(CheckType.NORMAL);

		WorkspaceJob job = new WorkspaceJob("Show derived issues") {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				for (Triple<IFile, String, ILocationInResource> markerData : markers) {
					ILocationInResource locationInSrc = markerData.getThird();
					IResourceServiceProvider serviceProvider = serviceProviderRegistry
							.getResourceServiceProvider(locationInSrc.getAbsoluteResourceURI());
					if (serviceProvider == null)
						continue;

					MarkerTypeProvider typeProvider = serviceProvider.get(MarkerTypeProvider.class);

					IMarker xtendMarker = markerData.getFirst().createMarker(typeProvider.getMarkerType(issue));
					xtendMarker.setAttribute(IMarker.MESSAGE, markerData.getSecond());
					xtendMarker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
					ITextRegionWithLineInformation region = locationInSrc.getTextRegion();
					xtendMarker.setAttribute(IMarker.LINE_NUMBER, region.getLineNumber());
					xtendMarker.setAttribute(IMarker.CHAR_START, region.getOffset());
					xtendMarker.setAttribute(IMarker.CHAR_END, region.getOffset() + region.getLength());
					xtendMarker.setAttribute(IMarker.SOURCE_ID, "JDT");
				}
				return Status.OK_STATUS;
			}
		};
		job.setRule(workspace.getRuleFactory().markerRule(workspace.getRoot()));
		job.schedule();
	}

}
