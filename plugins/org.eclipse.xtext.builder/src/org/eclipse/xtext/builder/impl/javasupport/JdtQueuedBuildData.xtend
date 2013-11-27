/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport

import com.google.inject.Singleton
import java.util.Collection
import java.util.Map
import java.util.Set
import org.eclipse.core.resources.IProject
import org.eclipse.xtext.builder.impl.QueuedBuildData
import org.eclipse.xtext.common.types.ui.notification.JavaBuilderState
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta

import static extension java.util.Collections.*
import static extension org.eclipse.xtext.common.types.ui.notification.JavaBuilderState.*
import com.google.inject.Inject
import org.eclipse.xtext.ui.resource.IStorage2UriMapper

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@Singleton
class JdtQueuedBuildData extends QueuedBuildData {

	var Map<String, JavaBuilderState> javaBuildState

	var Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltas
	
	@Inject
	new(IStorage2UriMapper mapper) {
		super(mapper)
	}

	override reset() {
		super.reset
		javaBuildState = newHashMap
		unconfirmedDeltas = newArrayList
	}

	def getUnconfirmedDeltas() {
		unconfirmedDeltas.unmodifiableCollection
	}

	override doQueueChanges(Collection<Delta> queuedDeltas) {
		if (queuedDeltas == null || queuedDeltas.size == 0) {
			return
		}
		for (delta : queuedDeltas) {
			switch delta {
				UnconfirmedStructuralChangesDelta: {
					val project = delta.project
					var state = javaBuildState.get(project)
					if (state == null) {
						javaBuildState.put(project.name, state = project.lastBuiltState)
					}
					delta.buildNumber = state.buildNumber
					unconfirmedDeltas += delta
				}
				default:
					deltas += delta
			}
		}
	}

	override doNeedRebuild(IProject it) {
		val oldState = javaBuildState.get(name)
		val newState = lastBuiltState
		newState.doNeedRebuild(
			if (oldState == null || oldState.lastStructuralBuildTime != newState.lastStructuralBuildTime) {
				[
					val structurallyChangedTypes = newState.structurallyChangedTypes
					if (getNew.namesIntersect(structurallyChangedTypes) || old.namesIntersect(structurallyChangedTypes)) {
						deltas += it
					}
				]
			} else {
				null
			})
	}

	def doNeedRebuild(JavaBuilderState it, (UnconfirmedStructuralChangesDelta)=>void processor) {
		val i = unconfirmedDeltas.iterator
		while (i.hasNext) {
			val unconfirmed = i.next
			if (unconfirmed.buildNumber < buildNumber && unconfirmed.project.equals(project)) {
				i.remove
				if (processor != null) {
					processor.apply(unconfirmed)
				}
			}
		}
		unconfirmedDeltas.size != 0
	}

	def namesIntersect(IResourceDescription resourceDescription, Set<QualifiedName> names) {
		if (resourceDescription == null) {
			return false
		}
		for (objectDescription : resourceDescription.exportedObjects) {
			if (names.contains(objectDescription.qualifiedName)) {
				return true
			}
		}
		false
	}

}
