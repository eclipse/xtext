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
import java.lang.reflect.InvocationTargetException
import java.util.List
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.ltk.core.refactoring.PerformChangeOperation
import org.eclipse.swt.graphics.Image
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer
import org.eclipse.xtext.ui.editor.model.edit.IMultiModification
import org.eclipse.xtext.ui.editor.model.edit.IMultiModification.PreInitializedModification
import org.eclipse.xtext.ui.refactoring2.ChangeConverter
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.util.IssueUtil

/**
 *  MarkerResolution which extends WorkbenchMarkerResolution and can be applied on multiple markers.
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.13
 */
class WorkbenchMarkerResolutionAdapter extends WorkbenchMarkerResolution {

	@Inject MarkerResolutionGenerator resolutionsGenerator
	@Inject IssueUtil issueUtil
	@Inject IResourceSetProvider resSetProvider
	@Inject Provider<ChangeSerializer> serializerProvider
	private final static Logger LOG = Logger.getLogger(WorkbenchMarkerResolutionAdapter);
	@Accessors IssueResolution primaryResolution
	@Accessors IMarker primaryMarker

	override findOtherMarkers(IMarker[] markers) {
		markers.filter[issueUtil.getCode(primaryMarker) == issueUtil.getCode(it)]
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

	override run(IMarker[] markers, IProgressMonitor monitor) {
		new WorkspaceModifyOperation() {
			override protected execute(
				IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				monitor.beginTask("Applying resolutions", markers.size)
				val grouped = markers.groupBy[resource.project]
				collectResolutions(monitor, grouped).forEach [ proj, resolutions |
					val serializer = serializerProvider.get()
					val converter = converterFactory.create(primaryResolution.label, null, issueAcceptor)
					monitor.taskName = "Applying resolution"
					resolutions.forEach [
						run(it.key, it.value, serializer, monitor)
					]
					monitor.internalWorked(1)
					serializer.applyModifications(converter)
					val ltkChange = converter.change
					ltkChange.initializeValidationData(monitor)
					new PerformChangeOperation(ltkChange).run(monitor)
				]
				monitor.done
			}
		}.run(monitor)
	}

	def collectResolutions(IProgressMonitor monitor, Map<IProject, List<IMarker>> markersByProject) {
		val result = newLinkedHashMap
		markersByProject.forEach [ proj, markers |
			val resSet = resSetProvider.get(proj)
			result.put(proj, markers.map [ marker |
				if (monitor.isCanceled) {
					throw new OperationCanceledException()
				}
				return marker.resolution(resSet)
			].filterNull.toList)
		]
		return result
	}

	def resolution(IMarker marker, ResourceSet resSet) {
		val uri = issueUtil.getUriToProblem(marker)
		val resource = resSet.getResource(uri.trimFragment, true)
		val targetObject = resource.getEObject(uri.fragment)
		if (targetObject !== null) {
			val issue = issueUtil.createIssue(marker)
			val resolution = resolutionsGenerator.resolutionProvider.getResolutions(issue).filter [
				isSameResolution(primaryResolution)
			].head
			if (resolution === null) {
				LOG.warn("Resolution missing for " + issue.code)
			}
			if (resolution.modification instanceof PreInitializedModification) {
				(resolution.modification as PreInitializedModification).init(targetObject)
			}
			return targetObject -> resolution
		}
	}

	@Inject ChangeConverter.Factory converterFactory
	@Inject LtkIssueAcceptor issueAcceptor

	def run(EObject targetObject, IssueResolution resolution, IChangeSerializer serializer, IProgressMonitor monitor) {
		val modification = resolution.modification as IMultiModification
		if (modification instanceof PreInitializedModification) {
			val target = modification.context.modificatioTarget
			serializer.addModification(target) [
				modification.apply(targetObject)
			]
		} else {
			serializer.addModification(targetObject.eResource) [
				modification.apply(targetObject)
			]
		}
		LOG.debug("Resolution applied for " + resolution.label + " in " + targetObject)
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
