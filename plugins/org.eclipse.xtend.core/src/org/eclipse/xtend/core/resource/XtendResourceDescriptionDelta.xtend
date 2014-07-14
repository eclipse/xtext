/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.resource

import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta
import org.eclipse.xtext.resource.IResourceDescription

class XtendResourceDescriptionDelta extends DefaultResourceDescriptionDelta {

	new(IResourceDescription old, IResourceDescription _new) {
		super(old, _new)
	}

	override protected internalHasChanges() {
		hasAnnotationProcessorChanged || super.internalHasChanges
	}
	
	private def hasAnnotationProcessorChanged() {
		val oldExportedObjects = old?.exportedObjects?.toList ?: #[]
		val newExportedObjects = getNew?.exportedObjects?.toList ?: #[]
		for (oldObject : oldExportedObjects) {
			val oldHash = oldObject.getUserData(XtendResourceDescriptionStrategy.ANNOTATION_PROCESSOR_HASH)
			if (oldHash !== null) {
				for (newObject : newExportedObjects) {
					val newHash = newObject.getUserData(XtendResourceDescriptionStrategy.ANNOTATION_PROCESSOR_HASH)
					if (newObject.qualifiedName == oldObject.qualifiedName
						&& newHash != null 
						&& newHash != oldHash) {
						return true
					}
				}
			}
		}
		return false
	}
}
