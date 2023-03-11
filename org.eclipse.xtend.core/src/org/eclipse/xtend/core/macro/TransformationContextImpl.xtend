/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtend.lib.macro.file.FileSystemSupport
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider
import org.eclipse.xtend.lib.macro.services.Associator
import org.eclipse.xtend.lib.macro.services.ProblemSupport
import org.eclipse.xtend.lib.macro.services.Tracability
import org.eclipse.xtend.lib.macro.services.TypeLookup
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider

class TransformationContextImpl implements TransformationContext {
	@Accessors CompilationUnitImpl unit

	@Delegate def ProblemSupport getProblemSupport() {
		unit.problemSupport
	}

	@Delegate def TypeLookup getTypeLookup() {
		unit.typeLookup
	}

	@Delegate def TypeReferenceProvider getTypeReferenceProvider() {
		unit.typeReferenceProvider
	}

	@Delegate def AnnotationReferenceProvider getAnnotationReferenceProvider() {
		unit.annotationReferenceProvider
	}

	@Delegate def FileSystemSupport getFileSystemSupport() {
		unit.fileSystemSupport
	}

	@Delegate def FileLocations getFileLocations() {
		unit.fileLocations
	}

	@Delegate def Tracability getTracability() {
		unit.tracability
	}

	@Delegate def Associator getAssociator() {
		unit.associator
	}
	
}
