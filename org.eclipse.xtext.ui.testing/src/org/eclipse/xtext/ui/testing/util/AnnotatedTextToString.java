/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing.util;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.MarkerTypes;

import com.google.common.base.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AnnotatedTextToString {

	protected static class CommentedRegion {

		private final int start;

		private final int end;

		private final String text;

		public CommentedRegion(int start, int end, String text) {
			this.start = start;
			this.end = end;
			this.text = text;
		}
	}

	private String contents;

	private IFile file;

	private List<CommentedRegion> regions = new ArrayList<>();

	private List<String> emptyMessages = new ArrayList<>();

	public String getContents() {
		if (contents != null) {
			return contents;
		}
		try {
			if (file != null) {
				return IResourcesSetupUtil.fileToString(file);
			}
			return null;
		} catch (CoreException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public IFile getFile() {
		return file;
	}

	public void setFile(IFile file) {
		this.file = file;
	}

	public List<CommentedRegion> getRegions() {
		return regions;
	}

	public List<String> getEmptyMessage() {
		return emptyMessages;
	}

	public AnnotatedTextToString withFile(IFile file) {
		this.file = file;
		return this;
	}

	public AnnotatedTextToString withMarkers(IMarker[] markers) {
		return withMarkers(markers, IMarker.MESSAGE);
	}

	public AnnotatedTextToString withMarkers(IMarker[] markers, String... attributes) {
		try {
			for (IMarker marker : markers) {
				List<String> transformed = new ArrayList<>(attributes.length);
				for (String attribute : attributes) {
					transformed.add(attribute + "=" + marker.getAttribute(attribute));
				}

				String comment = String.join(", ", transformed);
				Integer offset = (Integer) marker.getAttribute(IMarker.CHAR_START);
				Integer length = (Integer) marker.getAttribute(IMarker.CHAR_END);
				regions.add(new CommentedRegion(offset, length, comment));
			}
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		emptyMessages.add("(no markers found)");
		return this;
	}

	public AnnotatedTextToString withMarkersFromFile(String type, String... attributes) {
		try {
			return withMarkers(file.findMarkers(type, true, IResource.DEPTH_INFINITE), attributes);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	public AnnotatedTextToString withMarkersFromFile() {
		return withMarkersFromFile(MarkerTypes.FAST_VALIDATION, IMarker.MESSAGE);
	}

	@Override
	public String toString() {
		String contents = getContents();
		/*
		 * This is used in testing to produce a string comparable with a static
		 * test reference. Therefore it is important to produce a deterministic
		 * result. First sort by region start, then end (so we get shorter
		 * regions first), then by message. The latter is important so that
		 * regions with the same start and end get ordered deterministically.
		 */
		regions.sort(Comparator.comparing((CommentedRegion region) -> region.start).thenComparing((region) -> region.end)
				.thenComparing((region) -> region.text));

		List<SimpleEntry<Integer, CommentedRegion>> sorted = new ArrayList<>();
		for (int index = 0; index < regions.size(); index++) {
			sorted.add(new SimpleEntry<>(index, regions.get(index)));
		}

		List<SimpleEntry<Integer, String>> locations = new ArrayList<>();
		sorted.stream().forEach(s -> {
			locations.add(new SimpleEntry<>(s.getValue().start, "<" + s.getKey() + "<"));
			locations.add(new SimpleEntry<>(s.getValue().end, ">" + s.getKey() + ">"));
		});
		locations.sort(Comparator.comparing(SimpleEntry::getKey));

		StringBuilder result = new StringBuilder();
		int lastOffset = 0;
		for (int i = 0; i < locations.size(); i++) {
			SimpleEntry<Integer, String> location = locations.get(i);
			Integer offset = location.getKey();
			String comment = location.getValue();
			result.append(contents.substring(lastOffset, offset));
			result.append(comment);
			lastOffset = offset;
		}

		result.append(contents.substring(lastOffset, contents.length()));

		if (!result.substring(result.length() - 1, result.length()).equals("\n")) {
			result.append("\n");
		}

		result.append(Strings.repeat("-", 5));

		if (sorted.isEmpty()) {
			for (String message : emptyMessages) {
				result.append("\n");
				result.append(message);
			}
		} else {
			for (SimpleEntry<Integer, CommentedRegion> c : sorted) {
				result.append("\n");
				result.append(c.getKey());
				result.append(": ");
				result.append(c.getValue().text);
			}
		}
		return result.toString();
	}

}
