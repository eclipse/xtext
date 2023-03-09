/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtext.ui.editor.model.edit.BatchModification;
import org.eclipse.xtext.ui.editor.model.edit.BatchModification.IBatchableModification;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * MarkerResolution which extends WorkbenchMarkerResolution and can be applied on multiple markers.
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.13
 */
public class WorkbenchMarkerResolutionAdapter extends WorkbenchMarkerResolution {

	public static class Factory {

		@Inject
		private Provider<WorkbenchMarkerResolutionAdapter> provider;

		public IMarkerResolution create(IMarker marker, IssueResolution resolution) {
			WorkbenchMarkerResolutionAdapter resolutionFix = provider.get();
			resolutionFix.primaryResolution = resolution;
			resolutionFix.primaryMarker = marker;
			return resolutionFix;
		}
	}

	private static final Logger LOG = Logger.getLogger(WorkbenchMarkerResolutionAdapter.class);

	@Inject
	private MarkerResolutionGenerator resolutionsGenerator;

	@Inject
	private IssueUtil issueUtil;

	@Inject
	private Provider<BatchModification> batchModificationProvider;

	private IssueResolution primaryResolution;

	private IMarker primaryMarker;

	@Override
	public IMarker[] findOtherMarkers(IMarker[] markers) {
		List<IMarker> otherMarkers = new ArrayList<>();
		for (IMarker marker : markers) {
			if (marker != primaryMarker //
					&& Objects.equals(issueUtil.getCode(primaryMarker), issueUtil.getCode(marker))) {
				otherMarkers.add(marker);
			}
		}
		return otherMarkers.toArray(new IMarker[0]);
	}

	@Override
	public String getLabel() {
		return primaryResolution.getLabel();
	}

	@Override
	public void run(IMarker marker) {
		if (!marker.exists()) {
			return;
		}
		run(new IMarker[] { marker }, new NullProgressMonitor());
	}

	@Override
	public void run(IMarker[] markers, IProgressMonitor progressMonitor) {
		Map<IProject, List<IMarker>> markersByProject = Arrays.asList(markers).stream() //
				.collect(Collectors.groupingBy(marker -> marker.getResource().getProject()));

		SubMonitor monitor = SubMonitor.convert(progressMonitor);
		monitor.beginTask("Applying resolutions", markersByProject.size());

		markersByProject.forEach((key, value) -> {
			BatchModification batch = batchModificationProvider.get();
			batch.setProject(key);

			List<IBatchableModification> modifications = new ArrayList<>();
			List<IMarker> markersInProject = value;
			markersInProject.forEach(marker -> {
				IssueResolution resolution = resolution(marker);
				if (resolution != null) {
					IModification modification = resolution.getModification();
					if (modification instanceof IBatchableModification) {
						modifications.add((IBatchableModification) modification);
					}
				}
			});
			
			cancelIfNeeded(monitor);

			batch.apply(modifications, monitor.newChild(1));
			cancelIfNeeded(monitor);
		});

		monitor.done();
	}

	protected void cancelIfNeeded(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	public IssueResolution resolution(IMarker marker) {
		if (!marker.exists()) {
			return null;
		}
		Issue issue = issueUtil.createIssue(marker);
		List<IssueResolution> resolutions = resolutionsGenerator.getResolutionProvider().getResolutions(issue);
		Optional<IssueResolution> issueResolution = resolutions.stream()
				.filter(resolution -> isSameResolution(resolution, primaryResolution)).findFirst();
		if (!issueResolution.isPresent()) {
			LOG.warn("Resolution missing for " + issue.getCode());
			return null;
		}
		return issueResolution.get();
	}

	@Override
	public String getDescription() {
		return primaryResolution.getDescription();
	}

	@Override
	public Image getImage() {
		return resolutionsGenerator.getImage(primaryResolution);
	}

	private boolean isSameResolution(IssueResolution issueResolution, IssueResolution other) {
		return issueResolution != null //
				&& other != null //
				&& Objects.equals(issueResolution.getDescription(), other.getDescription())//
				&& Objects.equals(issueResolution.getLabel(), other.getLabel())//
				&& Objects.equals(issueResolution.getImage(), other.getImage());
	}

	public IssueResolution getPrimaryResolution() {
		return primaryResolution;
	}

	public void setPrimaryResolution(IssueResolution primaryResolution) {
		this.primaryResolution = primaryResolution;
	}

	public IMarker getPrimaryMarker() {
		return primaryMarker;
	}

	public void setPrimaryMarker(IMarker primaryMarker) {
		this.primaryMarker = primaryMarker;
	}
}
