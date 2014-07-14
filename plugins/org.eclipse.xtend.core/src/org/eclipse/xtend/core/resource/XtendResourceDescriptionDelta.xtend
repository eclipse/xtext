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
	extension DescriptionFlags = new DescriptionFlags
	
	new(IResourceDescription old, IResourceDescription _new) {
		super(old, _new)
	}

	override protected internalHasChanges() {
		val oldObjects = old?.exportedObjects ?: #[]
		oldObjects.exists[activeAnnotation||annotationProcessor] || super.internalHasChanges
	}
	
	
}
