/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import java.util.List;

import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.AbstractTraceRegionToString;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AppendableBasedTraceRegion extends AbstractTraceRegion {
	
	private final String generatedText;
	private final String sourceText;
	private final List<ILocationData> locations;
	private int offset;
	private int length;
	private int lineNumber;
	private int endLineNumber;
	
	private boolean useForDebugging;
	
	@Override
	public boolean isUseForDebugging() {
		return useForDebugging;
	}

	public AppendableBasedTraceRegion(/* @Nullable */ AbstractTraceRegion parent, TreeAppendable delegate, int offset, int lineNumber) {
		super(parent);
		this.offset = offset;
		this.lineNumber = lineNumber;
		this.useForDebugging = delegate.isUseForDebugging();
		boolean useLocationsFromDelegate = true;
		if (parent != null) {
			SourceRelativeURI parentPath = parent.getAssociatedSrcRelativePath();
			if (parentPath != null) {
				useLocationsFromDelegate = !allLocationsMatch(delegate, parentPath);
			}
		}
		this.locations = copyLocationData(delegate, useLocationsFromDelegate);
		int length = 0;
		int line = lineNumber;
		for (Object child : delegate.getChildren()) {
			if (child instanceof TreeAppendable) {
				TreeAppendable castedChild = (TreeAppendable) child;
				if (hasVisibleChildren(castedChild)) {
					AppendableBasedTraceRegion childRegion = new AppendableBasedTraceRegion(this, castedChild, offset + length, line);
					length += childRegion.getMyLength();
					line = childRegion.getMyEndLineNumber();
				}
			} else {
				String s = child.toString();
				length += s.length();
				line += Strings.countLineBreaks(s);
			}
		}
		this.length = length;
		this.endLineNumber = line;
		if (parent == null) {
			this.generatedText = delegate.getContent();
			compressTrace(this.generatedText);
			IParseResult result = ((XtextResource) delegate.getState().getResource()).getParseResult();
			if (result != null)
				this.sourceText = result.getRootNode().getText();
			else
				this.sourceText = null;
		} else {
			this.generatedText = null;
			this.sourceText = null;
		}
	}

	private List<ILocationData> copyLocationData(TreeAppendable delegate, boolean useOriginalLocations) {
		if (useOriginalLocations) {
			return Lists.newArrayList(delegate.getLocationData());
		} else {
			List<ILocationData> result = Lists.newArrayList();
			for(ILocationData locationData: delegate.getLocationData()) {
				result.add(new LocationData(locationData, null));
			}
			return result;
		}
	}

	private boolean allLocationsMatch(TreeAppendable appendable, SourceRelativeURI path) {
		for(ILocationData locationData: appendable.getLocationData()) {
			if (!path.equals(locationData.getSrcRelativePath())) {
				return false;
			}
		}
		return true;
	}
	
	protected void compressTrace(String completeContent) {
		leftCompressTrace(completeContent);
		rightCompressTrace(completeContent);
	}

	protected void leftCompressTrace(String completeContent) {
		List<AbstractTraceRegion> allNested = getWritableNestedRegions();
		int i = 0;
		while (i < allNested.size()) {
			AppendableBasedTraceRegion nested = (AppendableBasedTraceRegion) allNested.get(i);
			int offset = nested.getMyOffset();
			int diff = 0;
			while(completeContent.charAt(offset + diff) <= ' ' && diff < nested.length) {
				diff++;
			}
			if (diff == nested.length) {
				allNested.remove(i);
			} else {
				nested.lineNumber += Strings.countLineBreaks(completeContent, offset, offset + diff);
				nested.offset += diff;
				nested.length -= diff;
				nested.leftCompressTrace(completeContent);
				i++;
			}
		}
	}
	
	protected void rightCompressTrace(String completeContent) {
		List<AbstractTraceRegion> allNested = getWritableNestedRegions();
		int i = 0;
		while (i < allNested.size()) {
			AppendableBasedTraceRegion nested = (AppendableBasedTraceRegion) allNested.get(i);
			int endOffset = nested.getMyOffset() + nested.getMyLength() - 1;
			int diff = 0;
			while(completeContent.charAt(endOffset - diff) <= ' ' && diff < nested.length) {
				diff++;
			}
			if (diff != 0) {
				nested.endLineNumber -= Strings.countLineBreaks(completeContent, endOffset - diff + 1, endOffset + 1);
				nested.length -= diff;
				nested.rightCompressTrace(completeContent);
			}
			i++;
		}
	}

	protected boolean hasVisibleChildren(TreeAppendable castedChild) {
		for(Object o: castedChild.getChildren()) {
			if (o instanceof String)
				return true;
			if (hasVisibleChildren((TreeAppendable) o))
				return true;
		}
		return false;
	}

	@Override
	public int getMyLength() {
		return length;
	}

	@Override
	public int getMyOffset() {
		return offset;
	}
	
	@Override
	public int getMyLineNumber() {
		return lineNumber;
	}
	
	@Override
	public int getMyEndLineNumber() {
		return endLineNumber;
	}

	@Override
	public List<ILocationData> getAssociatedLocations() {
		return locations;
	}
	
	@Override
	public AppendableBasedTraceRegion getRoot() {
		return (AppendableBasedTraceRegion) super.getRoot();
	}

	@Override
	public String toString() {
		return new AbstractTraceRegionToString() {

			@Override
			protected String getRemoteText(SourceRelativeURI uri) {
				return AppendableBasedTraceRegion.this.getRoot().sourceText;
			}

			@Override
			protected String getLocalText() {
				return AppendableBasedTraceRegion.this.getRoot().generatedText;
			}

			@Override
			protected AbstractTraceRegion getTrace() {
				return AppendableBasedTraceRegion.this;
			}

		}.toString();
	}
	
}