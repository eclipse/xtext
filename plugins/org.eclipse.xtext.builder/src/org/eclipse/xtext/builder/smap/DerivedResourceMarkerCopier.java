/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import static com.google.common.collect.Sets.*;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jdt.core.IJavaModelMarker;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;

import com.google.inject.Inject;

/**
 * This class copies the error markers from a given derived resources into its source resource.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class DerivedResourceMarkerCopier {
	private static final Logger LOG = Logger.getLogger(DerivedResourceMarkerCopier.class);
	public static final String COPIED_FROM_FILE = "fromFile";

	// Preference key to control copier behavior. Defined in org.eclipse.xtext.xbase.validation.IssueCodes
	public static final String COPY_JAVA_PROBLEMS_ISSUECODE = "org.eclipse.xtext.builder.copyJavaProblems";

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	/**
	 * Looks for JDT error marker in javaFile and adds a copy to the corresponding<br>
	 * source resource. If the source resource already contains error marker, nothing will be added.
	 *
	 * @param javaFile
	 *            - Java file to inspect. Target file.
	 * @param traceToSource
	 *            - trace information to use. Points to the source file.
	 */
	public void reflectErrorMarkerInSource(IFile javaFile, IEclipseTrace traceToSource) throws CoreException {
		IFile srcFile = findSourceFile(traceToSource, javaFile.getWorkspace());
		if (srcFile == null || !srcFile.exists()) {
			return;
		}
		int maxSeverity = getMaxSeverity(srcFile);

		// clean up marker in source file derived from this java file
		cleanUpCreatedMarkers(javaFile, srcFile);

		Set<IMarker> problemsInJava = findJavaProblemMarker(javaFile, maxSeverity);
		// Any problems found in target, nothing to copy -> return
		if (problemsInJava.size() == 0) {
			return;
		}

		// Do nothing if Source file already has own problems
		if (!hasPlainXtextProblemMarker(srcFile, maxSeverity)) {
			copyProblemMarker(javaFile, traceToSource, problemsInJava, srcFile);
		}

	}

	private int getMaxSeverity(IFile srcFile) {
		URI resourceURI = URI.createPlatformResourceURI(srcFile.getFullPath().toString(), true);
		IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(resourceURI);
		if (serviceProvider == null)
			return Integer.MAX_VALUE;
		IssueSeveritiesProvider severitiesProvider = serviceProvider.get(IssueSeveritiesProvider.class);
		Severity severity = severitiesProvider.getIssueSeverities(new ResourceImpl(resourceURI)).getSeverity(
				COPY_JAVA_PROBLEMS_ISSUECODE);
		switch (severity) {
			case WARNING:
				return IMarker.SEVERITY_WARNING;
			case ERROR:
				return IMarker.SEVERITY_ERROR;
			case INFO:
			case IGNORE:
				return Integer.MAX_VALUE;
			default:
				break;
		}
		return Integer.MAX_VALUE;
	}

	private void copyProblemMarker(IFile javaFile, IEclipseTrace traceToSource, Set<IMarker> problemsInJava, IFile srcFile)
			throws CoreException {
		String sourceMarkerType = null;
		for (IMarker marker : problemsInJava) {
			String message = (String) marker.getAttribute(IMarker.MESSAGE);
			if (message == null) {
				continue;
			}
			Integer charStart = marker.getAttribute(IMarker.CHAR_START, 0);
			Integer charEnd = marker.getAttribute(IMarker.CHAR_END, 0);
			int severity = MarkerUtilities.getSeverity(marker);

			ILocationInEclipseResource associatedLocation = traceToSource.getBestAssociatedLocation(new TextRegion(charStart,
					charEnd - charStart));
			if (associatedLocation != null) {
				if (sourceMarkerType == null) {
					sourceMarkerType = determinateMarkerTypeByURI(associatedLocation.getSrcRelativeResourceURI());
				}
				if (!srcFile.equals(findIFile(associatedLocation, srcFile.getWorkspace()))) {
					LOG.error("File in associated location is not the same as main source file.");
				}
				IMarker xtendMarker = srcFile.createMarker(sourceMarkerType);
				xtendMarker.setAttribute(IMarker.MESSAGE, "Java problem: " + message);
				xtendMarker.setAttribute(IMarker.SEVERITY, severity);
				ITextRegionWithLineInformation region = associatedLocation.getTextRegion();
				xtendMarker.setAttribute(IMarker.LINE_NUMBER, region.getLineNumber());
				xtendMarker.setAttribute(IMarker.CHAR_START, region.getOffset());
				xtendMarker.setAttribute(IMarker.CHAR_END, region.getOffset() + region.getLength());
				xtendMarker.setAttribute(COPIED_FROM_FILE, javaFile.getFullPath().toString());
			}
		}

	}

	private String determinateMarkerTypeByURI(SourceRelativeURI resourceURI) {
		IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(resourceURI.getURI());
		if (serviceProvider == null)
			return null;
		MarkerTypeProvider typeProvider = serviceProvider.get(MarkerTypeProvider.class);
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setType(CheckType.NORMAL);
		return typeProvider.getMarkerType(issue);
	}

	private Set<IMarker> findJavaProblemMarker(IFile javaFile, int maxSeverity) throws CoreException {
		Set<IMarker> problems = newHashSet();
		for (IMarker marker : javaFile.findMarkers(IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, true,
				IResource.DEPTH_ZERO)) {
			if (MarkerUtilities.getSeverity(marker) >= maxSeverity) {
				problems.add(marker);
			}
		}
		return problems;
	}

	/**
	 * @return <code>true</code> if srcFile contains none-derived problem marker >= <code>maxSeverity</code>
	 */
	private boolean hasPlainXtextProblemMarker(IFile srcFile, int maxSeverity) throws CoreException {
		for (IMarker iMarker : srcFile.findMarkers(MarkerTypes.ANY_VALIDATION, true, IResource.DEPTH_ZERO)) {
			if (MarkerUtilities.getSeverity(iMarker) >= maxSeverity && iMarker.getAttribute(COPIED_FROM_FILE) == null) {
				return true;
			}
		}
		return false;
	}

	private void cleanUpCreatedMarkers(IFile javaFile, IResource srcFile) throws CoreException {
		for (IMarker iMarker : srcFile.findMarkers(MarkerTypes.ANY_VALIDATION, true, IResource.DEPTH_ZERO)) {
			if (javaFile.getFullPath().toString().equals(iMarker.getAttribute(COPIED_FROM_FILE, ""))) {
				iMarker.delete();
			}
		}
	}

	private IFile findSourceFile(IEclipseTrace traceToSource, IWorkspace workspace) {
		Iterator<? extends ILocationInEclipseResource> iterator = traceToSource.getAllAssociatedLocations().iterator();
		if (iterator.hasNext()) {
			ILocationInEclipseResource srcLocation = iterator.next();
			return findIFile(srcLocation, workspace);
		}
		return null;
	}

	private IFile findIFile(ILocationInEclipseResource locationInResource, IWorkspace workspace) {
		IStorage storage = locationInResource.getPlatformResource();
		if (storage == null) {
			LOG.warn("Failed to find Storage. Please make sure there are no outdated generated files. URI: " + locationInResource.getAbsoluteResourceURI());
			return null;
		}
		return workspace.getRoot().getFile(storage.getFullPath());
	}
}
