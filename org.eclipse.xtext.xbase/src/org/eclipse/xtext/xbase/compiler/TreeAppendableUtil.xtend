/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler

import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.resource.ILocationInFileProviderExtension
import org.eclipse.xtext.resource.ILocationInFileProvider
import com.google.inject.Inject
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.util.ITextRegion

class TreeAppendableUtil {
	
	@Inject ILocationInFileProvider locationProvider
	
	def traceSignificant(ITreeAppendable appendable, EObject source) {
		traceSignificant(appendable, source, false)
	}
	
	def traceSignificant(ITreeAppendable appendable, EObject source, boolean useForDebugging) {
		if (appendable instanceof TreeAppendable) {
			appendable.trace(source, ILocationInFileProviderExtension.RegionDescription.SIGNIFICANT, useForDebugging)
		} else {
			val it = locationProvider.getSignificantTextRegion(source) as ITextRegionWithLineInformation
			if (it !== null && it !== ITextRegion.EMPTY_REGION)
				appendable.trace(new LocationData(offset, length, lineNumber, endLineNumber, null), useForDebugging)
			else
				appendable
		}
	}
	
	def traceWithComments(ITreeAppendable appendable, EObject source) {
		if (appendable instanceof TreeAppendable) {
			appendable.trace(source, ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS, false)
		} else {
			val it = switch(locationProvider) {
				ILocationInFileProviderExtension: locationProvider.getTextRegion(source, ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS)
				default: locationProvider.getFullTextRegion(source)
			} as ITextRegionWithLineInformation
			if (it !== null && it !== ITextRegion.EMPTY_REGION)
				appendable.trace(new LocationData(offset, length, lineNumber, endLineNumber, null))
			else
				appendable
		}
	}
	
}
