/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix

import com.google.inject.Inject
import com.google.inject.Provider
import org.apache.log4j.Logger
import org.eclipse.core.resources.IMarker
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.swt.graphics.Image
import org.eclipse.ui.IMarkerResolution
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ui.editor.model.edit.BatchModification
import org.eclipse.xtext.ui.editor.model.edit.BatchModification.IBatchableModification
import org.eclipse.xtext.ui.util.IssueUtil
import org.eclipse.core.runtime.SubMonitor

/**
 *  MarkerResolution which extends WorkbenchMarkerResolution and can be applied on multiple markers.
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.13
 */
class WorkbenchMarkerResolutionAdapter extends WorkbenchMarkerResolution {

	static class Factory {
		@Inject
		Provider<WorkbenchMarkerResolutionAdapter> provider

		def IMarkerResolution create(IMarker marker, IssueResolution resolution) {
			val resolutionFix = provider.get()
			resolutionFix.primaryResolution = resolution
			resolutionFix.primaryMarker = marker
			return resolutionFix
		}

	}

	@Inject MarkerResolutionGenerator resolutionsGenerator
	@Inject IssueUtil issueUtil
	@Inject Provider<BatchModification> batchModificationProvider
	final static Logger LOG = Logger.getLogger(WorkbenchMarkerResolutionAdapter);
	@Accessors IssueResolution primaryResolution
	@Accessors IMarker primaryMarker

	override findOtherMarkers(IMarker[] markers) {
		markers.filter[it != primaryMarker && issueUtil.getCode(primaryMarker) == issueUtil.getCode(it)]
	}

	override String getLabel() {
		return primaryResolution.getLabel()
	}

	override void run(IMarker marker) {
		if (!marker.exists) {
			return
		}
		run(#[marker], new NullProgressMonitor)
	}

	override run(IMarker[] markers, IProgressMonitor progressMonitor) {
		val markersByProject = markers.groupBy[resource.project]
		val monitor = SubMonitor.convert(progressMonitor)
		monitor.beginTask("Applying resolutions", markersByProject.size)
		for (g : markersByProject.entrySet) {
			val batch = batchModificationProvider.get
			batch.project = g.key
			val markersInProject = g.value
			val resolutions = markersInProject.map[resolution].filterNull.toList
			monitor.cancelIfNeeded
			val modifications = resolutions.map[modification].filter(IBatchableModification)
			monitor.cancelIfNeeded
			batch.apply(modifications, monitor.newChild(1))
			monitor.cancelIfNeeded
		}
		monitor.done
	}

	def protected cancelIfNeeded(IProgressMonitor monitor) {
		if (monitor.isCanceled) {
			throw new OperationCanceledException()
		}
	}

	def resolution(IMarker marker) {
		if (!marker.exists) {
			return null;
		}
		val issue = issueUtil.createIssue(marker)
		val resolutions = resolutionsGenerator.resolutionProvider.getResolutions(issue)
		val resolution = resolutions.filter[isSameResolution(primaryResolution)].head
		if (resolution === null) {
			LOG.warn("Resolution missing for " + issue.code)
		}
		return resolution
	}

	override String getDescription() {
		return primaryResolution.getDescription()
	}

	override Image getImage() {
		return resolutionsGenerator.getImage(primaryResolution)
	}

	private def boolean isSameResolution(IssueResolution it, IssueResolution other) {
		return it !== null && other !== null && description == other.description && label == other.label &&
			image == other.image
	}
}
