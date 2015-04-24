package org.eclipse.xtext.psi

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.util.Alarm
import com.intellij.util.Alarm.ThreadToUse
import java.util.Collection
import java.util.Queue
import java.util.Set
import java.util.concurrent.ConcurrentLinkedQueue
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.idea.resource.ProjectAwareResourceDescriptions
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescription.Event
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.jetbrains.annotations.NotNull

abstract class ResourceDescriptionDeltaQueue implements IResourceDescription.Event.Listener {

	def static getInstance(@NotNull Project project) {
		project.getComponent(ResourceDescriptionDeltaQueue)
	}

}

class ResourceDescriptionDeltaQueueImpl extends ResourceDescriptionDeltaQueue {

	val Project project

	val Alarm alarm

	val int delayMillis

	val Queue<Event> pendingChanges

	val Runnable processChangesRequest

	@Inject
	IPsiModelAssociations psiModelAssociations

	@Inject
	extension IResourceServiceProvider.Registry

	val IResourceDescriptions resourceDescriptions

	new(Project project) {
		IdeaSharedInjectorProvider.injector.injectMembers(this)
		this.project = project
		this.delayMillis = 500
		this.alarm = new Alarm(ThreadToUse.POOLED_THREAD, project)
		pendingChanges = new ConcurrentLinkedQueue
		processChangesRequest = [|
			processChanges
		]

		resourceDescriptions = ProjectAwareResourceDescriptions.getInstance(project)
		ResourceDescriptionEventSource.getInstance(project).addListener(this)
	}

	override descriptionsChanged(Event event) {
		pendingChanges += event
		if (alarm.activeRequestCount == 0) {
			alarm.addRequest(processChangesRequest, delayMillis)
		}
	}

	protected def processChanges() {
		alarm.cancelAllRequests
		try {
			ApplicationManager.application.runReadAction [|
				val changes = Lists.newArrayList(pendingChanges.iterator)
				val count = changes.size

				val deltas = changes.map[deltas].flatten.toList
				if (!deltas.empty) {
					processDeltas(deltas)
				}

				for (i : 0 ..< count) {
					pendingChanges.poll
				}
			]
		} finally {
			alarm.addRequest(processChangesRequest, delayMillis)
		}
	}

	protected def void processDeltas(Collection<Delta> pendingChanges) {
		val allDeltas = pendingChanges
		val allRemainingURIs = resourceDescriptions.allResourceDescriptions.map[URI].toSet
		allRemainingURIs -= allDeltas.map[uri].toSet

		val Queue<IResourceDescription> affectedResources = newLinkedList
		queueAffectedResources(allRemainingURIs, allDeltas, allDeltas, affectedResources)
		while (!affectedResources.empty) {
			val changedDeltas = newArrayList
			affectedResources.invalidate(changedDeltas, allDeltas)
			queueAffectedResources(allRemainingURIs, changedDeltas, allDeltas, affectedResources)
		}
	}

	protected def void invalidate(
		Queue<IResourceDescription> affectedResources,
		Collection<Delta> changedDeltas,
		Collection<Delta> allDeltas
	) {
		while (!affectedResources.empty) {
			val delta = affectedResources.poll.invalidate
			if (delta != null) {
				allDeltas += delta
				if (delta.haveEObjectDescriptionsChanged) {
					changedDeltas += delta
				}
			}
		}
	}

	protected def invalidate(IResourceDescription resourceDescription) {
		val resourceURI = resourceDescription.URI
		val manager = resourceURI.resourceServiceProvider?.resourceDescriptionManager
		if (manager == null)
			return null
		val psiFile = psiModelAssociations.getPsiFile(resourceURI, project)
		if (psiFile instanceof BaseXtextFile) {
			psiFile.invalidate

			val newDescription = resourceDescriptions.getResourceDescription(resourceURI)
			manager.createDelta(resourceDescription, newDescription)
		}
	}

	protected def void queueAffectedResources(
		Set<URI> allRemainingURIs,
		Collection<Delta> changedDeltas,
		Collection<Delta> allDeltas,
		Queue<IResourceDescription> affectedResources
	) {
		if (allDeltas.empty) {
			return
		}
		val i = allRemainingURIs.iterator
		while (i.hasNext) {
			val candidateURI = i.next
			val candidateDescription = resourceDescriptions.getResourceDescription(candidateURI)
			val manager = candidateURI.resourceServiceProvider?.resourceDescriptionManager
			if (candidateDescription == null || manager == null) {
				i.remove
			} else {
				val affected = if (manager instanceof IResourceDescription.Manager.AllChangeAware) {
						manager.isAffectedByAny(allDeltas, candidateDescription, resourceDescriptions)
					} else if (changedDeltas.empty) {
						false
					} else {
						manager.isAffected(changedDeltas, candidateDescription, resourceDescriptions)
					}
				if (affected) {
					affectedResources += candidateDescription
					i.remove
				}
			}
		}
	}

}