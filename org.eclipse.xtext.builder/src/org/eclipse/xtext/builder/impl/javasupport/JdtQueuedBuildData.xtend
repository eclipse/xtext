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
import org.eclipse.xtext.common.types.ui.notification.JavaBuilderState
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta

import static extension java.util.Collections.*
import static extension org.eclipse.xtext.common.types.ui.notification.JavaBuilderState.*
import org.eclipse.xtext.builder.impl.IQueuedBuildDataContribution
import java.util.HashMap
import java.util.ArrayList

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@Singleton
class JdtQueuedBuildData implements IQueuedBuildDataContribution {

	var Map<String, JavaBuilderState> javaBuildState
	var Map<String, JavaBuilderState> javaBuildStateCopy

	var Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltas
	var Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltasCopy
	
	override reset() {
		javaBuildState = newHashMap
		unconfirmedDeltas = newArrayList
	}

	override reset(IProject project) {
		javaBuildState.remove(project.name)
	}

	/**
	 * Public for testing purpose
	 */
	def getUnconfirmedDeltas() {
		unconfirmedDeltas.unmodifiableCollection
	}

	override queueChange(Delta delta) {
		switch delta {
			UnconfirmedStructuralChangesDelta: {
				val project = delta.project
				var state = javaBuildState.get(project.name)
				if (state == null) {
					javaBuildState.put(project.name, state = project.lastBuiltState)
				}
				delta.buildNumber = state.buildNumber
				unconfirmedDeltas += delta
				true
			}
			default:
				false
		}
	}

	override needsRebuild(IProject it, Collection<Delta> deltas) {
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

	protected def doNeedRebuild(JavaBuilderState it, (UnconfirmedStructuralChangesDelta)=>void processor) {
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

	protected def namesIntersect(IResourceDescription resourceDescription, Set<QualifiedName> names) {
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
	
	override createCheckpoint() {
		javaBuildStateCopy = new HashMap(javaBuildState)
		unconfirmedDeltasCopy = new ArrayList(unconfirmedDeltas)
	}
	
	override discardCheckpoint() {
		javaBuildStateCopy = null
		unconfirmedDeltasCopy = null
	}
	
	override rollback() {
		javaBuildState.clear
		javaBuildState.putAll(javaBuildStateCopy)
		unconfirmedDeltas.clear
		unconfirmedDeltas.addAll(unconfirmedDeltasCopy)
	}
}
