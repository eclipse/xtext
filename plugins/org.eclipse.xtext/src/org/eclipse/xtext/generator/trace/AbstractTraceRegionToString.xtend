/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace

import com.google.common.base.Throwables
import com.google.common.io.CharStreams
import java.io.StringReader
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion

import static org.eclipse.xtext.util.Strings.*

import static extension com.google.common.base.Strings.*
import static extension com.google.common.collect.Multimaps.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Accessors abstract class AbstractTraceRegionToString {
	@Accessors protected static class Insert {
		val int offset
		val boolean open
		val RegionHandle region
		val LocationHandle location
	}

	@Accessors protected static class File {
		val SourceRelativeURI uri
		val List<Insert> inserts = newArrayList()
		val List<String> lines = newArrayList()
	}

	@Accessors protected static class RegionHandle {
		val int id
		val AbstractTraceRegion region
		val List<LocationHandle> locations = newArrayList()
		val List<RegionHandle> children = newArrayList()
	}

	@Accessors protected static class LocationHandle {
		val RegionHandle region
		val int id
		val ILocationData location
	}

	int radix = 10 // Character.MAX_RADIX
	boolean showTree = true
	boolean showLegend = true

	def protected abstract String getRemoteText(SourceRelativeURI uri) ;

	def protected abstract String getLocalText() ;

	def protected abstract AbstractTraceRegion getTrace();

	def protected ITextRegion getLocalFrame() {
		null
	}

	def protected ITextRegion getRemoteFrame(SourceRelativeURI uri) {
		null
	}

	def protected String getLocalTitle() {
		"generated.java"
	}

	def protected String getRemoteTitle(SourceRelativeURI uri) {
		uri.URI.toString
	}

	def protected boolean shouldInclude(AbstractTraceRegion region) {
		val frame = getLocalFrame()
		if (frame == null)
			return true
		else
			return frame.contains(region.myRegion)
	}

	def protected boolean shouldInclude(AbstractTraceRegion region, ILocationData location) {
		val frame = getRemoteFrame(location.srcRelativePath ?: region.associatedSrcRelativePath)
		if (frame == null)
			return true
		else
			return frame.contains(location)
	}

	def protected void add(Map<SourceRelativeURI, File> files, SourceRelativeURI uri, ITextRegion it,
		RegionHandle region, LocationHandle location) {
		var file = files.get(uri)
		if (file === null)
			files.put(uri, file = new File(uri))
		file.add(it, region, location)
	}

	def protected void add(File file, ITextRegion it, RegionHandle region, LocationHandle location) {
		file.inserts += new Insert(offset, true, region, location)
		file.inserts += new Insert(offset + length, false, region, location)
	}

	def protected int collect(AbstractTraceRegion reg, int nextID, File lFile, Map<SourceRelativeURI, File> rFiles,
		List<RegionHandle> result) {
		var i = nextID
		var childResult = result
		if (shouldInclude(reg)) {
			val regHandle = new RegionHandle(i++, reg)
			result += regHandle
			childResult = regHandle.children
			lFile.add(reg.myRegion, regHandle, null)
			val locs = reg.associatedLocations.filter[shouldInclude(reg, it)].toList
			for (var j = 0; j < locs.size; j++) {
				val loc = locs.get(j)
				val locHandle = new LocationHandle(regHandle, if(locs.size > 1) j + 1 else -1, loc)
				regHandle.locations += locHandle
				val path = loc.srcRelativePath ?: reg.associatedSrcRelativePath
				rFiles.add(path, loc, regHandle, locHandle)
			}
		}
		for (child : reg.nestedRegions) {
			i = child.collect(i, lFile, rFiles, childResult)
		}
		return i
	}

	def protected String render(Insert it, int width) {
		val first = padStart(Integer.toString(region.id, radix), width, "0")
		return if(location !== null && location.id >= 0) first + "_" + Integer.toString(location.id, radix) else first
	}

	def protected int sortKey(Insert it) {
		val base = (region.id * Short.MAX_VALUE)
		return if(location != null && location.id >= 0) base + location.id else base
	}

	def protected String render(Collection<Insert> inserts, int width) {
		val opens = inserts.filter[open].sortBy[sortKey].map[render(width)].join(",")
		val closes = inserts.filter[!open].sortBy[-sortKey].map[render(width)].join(",")
		val s1 = if(opens.isEmpty) "" else "[" + opens + "["
		val s2 = if(closes.isEmpty) "" else "]" + closes + "]"
		return s1 + s2
	}

	def protected List<String> render(File file, int width) {
		val text = if(file.uri == null) localText else file.uri.remoteText
		val frame = (if(file.uri == null) localFrame else file.uri.remoteFrame) ?: new TextRegion(0, text.length)
		val inframe = file.inserts.filter[offset >= frame.offset && offset <= frame.offset + frame.length]
		val offsets = inframe.index[offset].asMap.entrySet.toList.sortBy[key]
		var last = frame.offset
		val result = new StringBuilder
		for (e : offsets) {
			val offset = e.key
			val insert = e.value.render(width)
			val prefix = text.substring(last, offset)
			result.append(prefix)
			result.append(insert)
			last = offset
		}
		val end = frame.offset + frame.length
		if (last < end)
			result.append(text.substring(last, end))
		return CharStreams.readLines(new StringReader(result.toString))
	}

	def protected String title(SourceRelativeURI uri, int width) {
		val s = " " + (if(uri === null) localTitle else uri.remoteTitle) + " "
		val left = "-".repeat((width - s.length) / 2)
		val right = "-".repeat(width - (s.length + left.length))
		return left + s + right
	}

	// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=383426
	def protected <T> Set<T> collect(T start, (T)=>Iterable<T> reachable) {
		return collect(start, reachable, newLinkedHashSet)
	}

	def protected <R extends Collection<? super T>, T> R collect(T start, (T)=>Iterable<T> reachable, R collector) {
		if (collector.add(start))
			for (r : reachable.apply(start))
				collect(r, reachable, collector)
		return collector
	}

	def protected String render(LocationHandle loc) {
		val prefix = if(loc.id >= 0) Integer.toString(loc.id, radix) + ": " else ""
		val name = loc.location.class.simpleName
		val path = if(loc.location.srcRelativePath !== null) "," + loc.location.srcRelativePath else ""
		return prefix + name + "[" + loc.location.offset + "," + loc.location.length + path + "]"
	}

	def protected void render(RegionHandle region, int idW, int offsetW, int lengthW, int indent, List<String> result) {
		val id = Integer.toString(region.id, radix).padStart(idW, "0")
		val debug = if(region.region.isUseForDebugging) "D" else " "
		val offset = Integer.toString(region.region.myOffset).padStart(offsetW, "0")
		val length = Integer.toString(region.region.myLength).padStart(lengthW, "0")
		val space = repeat(" ", indent)
		val name = region.region.class.simpleName
		val locations = region.locations.map[it.render].join(", ")
		val loc = debug + " " + offset + "-" + length + space
		val header = id + ": " + loc + name + " -> " + locations
		if (region.children.isEmpty) {
			result += header
		} else {
			result += header + " {"
			for (child : region.children)
				render(child, idW, offsetW, lengthW, indent + 2, result)
			result += id + ": " + repeat(" ", loc.length) + "}"
		}
	}

	def protected String render() {
		val localFile = new File(null)
		val remoteFiles = <SourceRelativeURI, File>newLinkedHashMap()
		val List<RegionHandle> roothandles = newArrayList()
		val maxid = trace.collect(1, localFile, remoteFiles, roothandles)
		val idwidth = Integer.toString(maxid, radix).length
		localFile.lines += localFile.render(idwidth)
		for (file : remoteFiles.values)
			file.lines += file.render(idwidth)
		val localWidth = Math.max(localFile.lines.map[length].max, localTitle.length + 2)
		val remoteWidth = remoteFiles.values.map[Math.max(lines.map[length].max, uri.remoteTitle.length + 2)].max
		localFile.lines.add(0, title(null, localWidth))
		for (file : remoteFiles.values)
			file.lines.add(0, title(file.uri, remoteWidth))
		val left = localFile.lines
		val right = remoteFiles.values.map[lines].flatten.toList
		val result = newArrayList()
		if (showLegend)
			result +=
				"Regions are surrounded by [N[ ... ]N]. Regions on the left and right with the same N are associated."
		for (var i = 0; i < left.length || i < right.length; i++) {
			val l = (if(i < left.size) left.get(i) else "").padEnd(localWidth, " ")
			val r = if(i < right.size) right.get(i) else ""
			result += l + " | " + r
		}
		if (showTree) {
			result += repeat("-", localWidth + remoteWidth + 3)
			if (showLegend)
				result +=
					"<N>: <isDebug> <offset>-<length> <RegionJavaClass> -> <LocationJavaClass>[<offset>,<length>,<uri>]"
			val allhandles = roothandles.map[collect[children]].flatten
			val offsetWidth = String.valueOf(allhandles.map[region.myOffset].max).length
			val lengthWidth = String.valueOf(allhandles.map[region.myLength].max).length
			for (handle : roothandles)
				render(handle, idwidth, offsetWidth, lengthWidth, 1, result)
		}
		return result.join(newLine)
	}

	override toString() {
		try {
			return render();
		} catch (Exception e) {
			Throwables.getStackTraceAsString(e);
		}
	}

}

