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
import org.eclipse.core.resources.IMarker
import org.eclipse.ui.IMarkerResolution

/**
 * 
 * Creates new WorkbenchMarkerResolutionAdapter
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.13
 */
class WorkbenchMarkerResolutionAdapterFactory {
	@Inject
	Provider<WorkbenchMarkerResolutionAdapter> provider

	def IMarkerResolution create(IMarker marker, IssueResolution resolution) {
		val resolutionFix = provider.get()
		resolutionFix.primaryResolution = resolution
		resolutionFix.primaryMarker = marker
		return resolutionFix
	}

}
