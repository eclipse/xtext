/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Multimaps.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.io.CharStreams;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTraceRegionToString {
	protected static class Insert {
		private final int offset;

		private final boolean open;

		private final RegionHandle region;

		private final LocationHandle location;

		public Insert(int offset, boolean open, RegionHandle region, LocationHandle location) {
			this.offset = offset;
			this.open = open;
			this.region = region;
			this.location = location;
		}

		public int getOffset() {
			return offset;
		}

		public boolean isOpen() {
			return open;
		}

		public RegionHandle getRegion() {
			return region;
		}

		public LocationHandle getLocation() {
			return location;
		}
	}

	protected static class File {
		private final SourceRelativeURI uri;

		private final List<Insert> inserts = new ArrayList<>();

		private final List<String> lines = new ArrayList<>();

		public File(SourceRelativeURI uri) {
			this.uri = uri;
		}

		public SourceRelativeURI getUri() {
			return uri;
		}

		public List<Insert> getInserts() {
			return inserts;
		}

		public List<String> getLines() {
			return lines;
		}
	}

	protected static class RegionHandle {
		private final int id;

		private final AbstractTraceRegion region;

		private final List<LocationHandle> locations = new ArrayList<>();

		private final List<RegionHandle> children = new ArrayList<>();

		public RegionHandle(int id, AbstractTraceRegion region) {
			this.id = id;
			this.region = region;
		}

		public int getId() {
			return id;
		}

		public AbstractTraceRegion getRegion() {
			return region;
		}

		public List<LocationHandle> getLocations() {
			return locations;
		}

		public List<RegionHandle> getChildren() {
			return children;
		}
	}

	protected static class LocationHandle {
		private final RegionHandle region;

		private final int id;

		private final ILocationData location;

		public LocationHandle(RegionHandle region, int id, ILocationData location) {
			this.region = region;
			this.id = id;
			this.location = location;
		}

		public RegionHandle getRegion() {
			return region;
		}

		public int getId() {
			return id;
		}

		public ILocationData getLocation() {
			return location;
		}
	}

	private int radix = 10;
	private boolean showTree = true;
	private boolean showLegend = true;

	protected abstract String getRemoteText(SourceRelativeURI uri);

	protected abstract String getLocalText();

	protected abstract AbstractTraceRegion getTrace();

	protected ITextRegion getLocalFrame() {
		return null;
	}

	protected ITextRegion getRemoteFrame(SourceRelativeURI uri) {
		return null;
	}

	protected String getLocalTitle() {
		return "generated.java";
	}

	protected String getRemoteTitle(SourceRelativeURI uri) {
		return uri.getURI().toString();
	}

	protected boolean shouldInclude(AbstractTraceRegion region) {
		ITextRegion frame = getLocalFrame();
		return frame == null ? true : frame.contains(region.getMyRegion());
	}

	protected boolean shouldInclude(AbstractTraceRegion region, ILocationData location) {
		SourceRelativeURI srcRelativePath = location.getSrcRelativePath();
		ITextRegion frame = getRemoteFrame(
				srcRelativePath == null ? region.getAssociatedSrcRelativePath() : srcRelativePath);
		return frame == null ? true : frame.contains(location);
	}

	protected void add(Map<SourceRelativeURI, File> files, SourceRelativeURI uri, ITextRegion it, RegionHandle region,
			LocationHandle location) {
		File file = files.get(uri);
		if (file == null) {
			file = new File(uri);
			files.put(uri, file);
		}
		add(file, it, region, location);
	}

	protected void add(File file, ITextRegion it, RegionHandle region, LocationHandle location) {
		file.inserts.add(new Insert(it.getOffset(), true, region, location));
		file.inserts.add(new Insert(it.getOffset() + it.getLength(), false, region, location));
	}

	protected int collect(AbstractTraceRegion reg, int nextID, File lFile, Map<SourceRelativeURI, File> rFiles,
			List<RegionHandle> result) {
		int i = nextID;
		List<RegionHandle> childResult = result;
		if (shouldInclude(reg)) {
			RegionHandle regHandle = new RegionHandle(i++, reg);
			result.add(regHandle);
			childResult = regHandle.children;
			add(lFile, reg.getMyRegion(), regHandle, null);
			List<ILocationData> locs = toList(filter(reg.getAssociatedLocations(), loc -> shouldInclude(reg, loc)));
			for (int j = 0; j < locs.size(); j++) {
				ILocationData loc = locs.get(j);
				LocationHandle locHandle = new LocationHandle(regHandle, locs.size() > 1 ? (j + 1) : -1, loc);
				regHandle.locations.add(locHandle);
				SourceRelativeURI srcRelativePath = loc.getSrcRelativePath();
				SourceRelativeURI path = srcRelativePath == null ? reg.getAssociatedSrcRelativePath() : srcRelativePath;
				add(rFiles, path, loc, regHandle, locHandle);
			}
		}
		for (AbstractTraceRegion child : reg.getNestedRegions()) {
			i = collect(child, i, lFile, rFiles, childResult);
		}
		return i;
	}

	protected String render(AbstractTraceRegionToString.Insert it, int width) {
		String first = Strings.padStart(Integer.toString(it.region.id, this.radix), width, '0');
		return it.location != null && it.location.id >= 0 ? first + "_" + Integer.toString(it.location.id, this.radix)
				: first;
	}

	protected int sortKey(AbstractTraceRegionToString.Insert it) {
		int base = it.region.id * Short.MAX_VALUE;
		return it.location != null && it.location.id >= 0 ? base + it.location.id : base;
	}

	protected String render(Collection<AbstractTraceRegionToString.Insert> inserts, int width) {
		String opens = join(transform(sortBy(filter(inserts, i -> i.open), i -> sortKey(i)), i -> render(i, width)), ",");
		String closes = join(transform(sortBy(filter(inserts, i -> !i.open), i -> -sortKey(i)), i -> render(i, width)), ",");
		String s1 = opens.isEmpty() ? "" : ("[" + opens + "[");
		String s2 = closes.isEmpty() ? "" : ("]" + closes + "]");
		return (s2 + s1);
	}

	protected List<String> render(AbstractTraceRegionToString.File file, int width) {
		try {
			String text = file.uri == null ? getLocalText() : getRemoteText(file.uri);
			ITextRegion localOrRemoteFrame = file.uri == null ? getLocalFrame() : getRemoteFrame(file.uri);
			ITextRegion frame = localOrRemoteFrame == null ? new TextRegion(0, text.length()) : localOrRemoteFrame;
			int last = frame.getOffset();
			StringBuilder result = new StringBuilder();
			for (Map.Entry<Integer, Collection<Insert>> e : sortBy(toList(index(
					filter(file.inserts,
							i -> i.offset >= frame.getOffset() && i.offset <= (frame.getOffset() + frame.getLength())),
					i -> i.offset).asMap().entrySet()), i -> i.getKey())) {
				int offset = e.getKey().intValue();
				result.append(text.substring(last, offset));
				result.append(render(e.getValue(), width));
				last = offset;
			}
			int end = frame.getOffset() + frame.getLength();
			if (last < end) {
				result.append(text.substring(last, end));
			}
			return CharStreams.readLines(new StringReader(result.toString()));
		} catch (IOException t) {
			throw new RuntimeIOException(t);
		}
	}

	protected String title(SourceRelativeURI uri, int width) {
		String s = " " + (uri == null ? getLocalTitle() : getRemoteTitle(uri)) + " ";
		String left = Strings.repeat("-", (width - s.length()) / 2);
		String right = Strings.repeat("-", (width - (s.length() + left.length())));
		return left + s + right;
	}

	protected <T extends Object> Set<T> collect(T start, Function1<? super T, ? extends Iterable<T>> reachable) {
		return collect(start, reachable, new LinkedHashSet<>());
	}

	protected <R extends Collection<? super T>, T extends Object> R collect(T start,
			Function1<? super T, ? extends Iterable<T>> reachable, R collector) {
		if (collector.add(start)) {
			for (T r : reachable.apply(start)) {
				collect(r, reachable, collector);
			}
		}
		return collector;
	}

	protected String render(AbstractTraceRegionToString.LocationHandle loc) {
		String prefix = loc.id >= 0 ? Integer.toString(loc.id, this.radix) + ": " : "";
		String name = loc.location.getClass().getSimpleName();
		String path = loc.location.getSrcRelativePath() == null ? "" : ("," + loc.location.getSrcRelativePath());
		return prefix + name + "[" + loc.location.getOffset() + "," + loc.location.getLength() + path + "]";
	}

	protected void render(AbstractTraceRegionToString.RegionHandle region, int idW, int offsetW, int lengthW,
			int indent, List<String> result) {
		String id = Strings.padStart(Integer.toString(region.id, radix), idW, '0');
		String debug = region.region.isUseForDebugging() ? "D" : " ";
		String offset = Strings.padStart(Integer.toString(region.region.getMyOffset()), offsetW, '0');
		String length = Strings.padStart(Integer.toString(region.region.getMyLength()), lengthW, '0');
		String space = Strings.repeat(" ", indent);
		String name = region.region.getClass().getSimpleName();
		String locations = join(transform(region.locations, it -> render(it)), ", ");
		String loc = debug + " " + offset + "-" + length + space;
		String header = id + ": " + loc + name + " -> " + locations;
		if (region.children.isEmpty()) {
			result.add(header);
		} else {
			result.add((header + " {"));
			for (RegionHandle child : region.children) {
				render(child, idW, offsetW, lengthW, (indent + 2), result);
			}
			result.add((id + ": " + Strings.repeat(" ", loc.length())) + "}");
		}
	}

	protected String render() {
		File localFile = new File(null);
		LinkedHashMap<SourceRelativeURI, File> remoteFiles = new LinkedHashMap<>();
		List<RegionHandle> roothandles = new ArrayList<>();
		int maxid = collect(getTrace(), 1, localFile, remoteFiles, roothandles);
		int idwidth = Integer.toString(maxid, radix).length();
		addAll(localFile.lines, render(localFile, idwidth));
		for (File file : remoteFiles.values()) {
			addAll(file.lines, render(file, idwidth));
		}
		int localWidth = Math.max(max(transform(localFile.lines, (String it) -> Integer.valueOf(it.length()))),
				getLocalTitle().length() + 2);
		int remoteWidth = max(transform(remoteFiles.values(),
				(File it) -> Math.max(max(transform(it.lines, (String it_1) -> Integer.valueOf(it_1.length()))),
						getRemoteTitle(it.uri).length() + 2)));
		localFile.lines.add(0, title(null, localWidth));
		for (File file : remoteFiles.values()) {
			file.lines.add(0, title(file.uri, remoteWidth));
		}
		List<String> left = localFile.lines;
		List<String> right = toList(concat(transform(remoteFiles.values(), it -> it.lines)));
		ArrayList<String> result = new ArrayList<>();
		if (showLegend) {
			result.add(
					"Regions are surrounded by [N[ ... ]N]. Regions on the left and right with the same N are associated.");
		}
		for (int i = 0; i < left.size() || i < right.size(); i++) {
			String l = Strings.padEnd(i < left.size() ? left.get(i) : "", localWidth, ' ');
			String r = i < right.size() ? right.get(i) : "";
			result.add(l + " | " + r);
		}
		if (showTree) {
			result.add(Strings.repeat("-", localWidth + remoteWidth + 3));
			if (showLegend) {
				result.add(
						"<N>: <isDebug> <offset>-<length> <RegionJavaClass> -> <LocationJavaClass>[<offset>,<length>,<uri>]");
			}
			Iterable<RegionHandle> allhandles = concat(transform(roothandles, it -> collect(it, it_1 -> it_1.children)));
			int offsetWidth = String
					.valueOf(max(transform(allhandles, (RegionHandle it) -> Integer.valueOf(it.region.getMyOffset()))))
					.length();
			int lengthWidth = String
					.valueOf(max(transform(allhandles, (RegionHandle it) -> Integer.valueOf(it.region.getMyLength()))))
					.length();
			for (RegionHandle handle : roothandles) {
				render(handle, idwidth, offsetWidth, lengthWidth, 1, result);
			}
		}
		return join(result, newLine());
	}

	@Override
	public String toString() {
		try {
			return render();
		} catch (Exception t) {
			return Throwables.getStackTraceAsString(t);
		}
	}

	public int getRadix() {
		return radix;
	}

	public void setRadix(int radix) {
		this.radix = radix;
	}

	public boolean isShowTree() {
		return showTree;
	}

	public void setShowTree(boolean showTree) {
		this.showTree = showTree;
	}

	public boolean isShowLegend() {
		return showLegend;
	}

	public void setShowLegend(boolean showLegend) {
		this.showLegend = showLegend;
	}
}
