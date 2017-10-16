/** 
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing.util

import com.google.common.base.Strings
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.MarkerTypes

/** 
 * @author Moritz Eysholdt - Initial contribution and API
 */
class AnnotatedTextToString {

	@FinalFieldsConstructor static protected class CommentedRegion {
		val int start
		val int end
		val String text
	}

	@Accessors String contents
	@Accessors IFile file
	@Accessors val List<CommentedRegion> regions = newArrayList()
	@Accessors val List<String> emptyMessage = newArrayList

	def String getContents() {
		if (contents !== null) {
			return contents
		}
		if (file !== null) {
			return IResourcesSetupUtil.fileToString(file)
		}
	}

	def AnnotatedTextToString withFile(IFile file) {
		this.file = file
		return this
	}

	def AnnotatedTextToString withMarkers(IMarker[] markers) {
		withMarkers(markers, IMarker.MESSAGE)
	}

	def AnnotatedTextToString withMarkers(IMarker[] markers, String ... attributes) {
		for (marker : markers) {
			val comment = attributes.map[it + "=" + marker.getAttribute(it)].join(", ")
			val offset = marker.getAttribute(IMarker.CHAR_START) as Integer
			val length = marker.getAttribute(IMarker.CHAR_END) as Integer
			regions += new CommentedRegion(offset, length, comment)
		}
		emptyMessage += "(no markers found)"
		return this
	}

	def AnnotatedTextToString withMarkersFromFile(String type, String ... attributes) {
		withMarkers(file.findMarkers(type, true, IResource.DEPTH_INFINITE), attributes)
	}

	def AnnotatedTextToString withMarkersFromFile() {
		withMarkersFromFile(MarkerTypes.FAST_VALIDATION, IMarker.MESSAGE)
	}

	override toString() {
		val cnt = getContents()
		val sorted = regions.sortBy[start].indexed
		val locations = sorted.map[#[value.start -> "<" + key + "<", value.end -> ">" + key + ">"]].flatten.sortBy[key]
		val result = new StringBuilder()
		var lastOffset = 0;
		for (var i = 0; i < locations.length; i++) {
			val l = locations.get(i)
			val offset = l.key
			val comment = l.value
			result.append(cnt.substring(lastOffset, offset))
			result.append(comment)
			lastOffset = offset
		}
		result.append(cnt.substring(lastOffset, cnt.length))
		val maxLineLenght = result.toString.replace("\t", "    ").split("\n").map[length].max
		if (result.substring(result.length - 1, result.length) != "\n") {
			result.append("\n")
		}
		result.append(Strings.repeat("-", maxLineLenght))
		if (sorted.isEmpty) {
			for (c : emptyMessage) {
				result.append("\n")
				result.append(c)
			}
		} else {
			for (c : sorted) {
				result.append("\n")
				result.append(c.key)
				result.append(": ")
				result.append(c.value.text)
			}
		}
		return result.toString
	}

}
