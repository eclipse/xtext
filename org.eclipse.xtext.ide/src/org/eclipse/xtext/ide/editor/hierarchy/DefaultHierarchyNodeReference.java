/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class DefaultHierarchyNodeReference implements IHierarchyNodeReference {
	private final String text;

	private final ITextRegionWithLineInformation textRegion;

	private final Object navigationElement;

	public DefaultHierarchyNodeReference(String text, ITextRegionWithLineInformation textRegion,
			Object navigationElement) {
		this.text = text;
		this.textRegion = textRegion;
		this.navigationElement = navigationElement;
	}

	public String getText() {
		return text;
	}

	public ITextRegionWithLineInformation getTextRegion() {
		return textRegion;
	}

	public Object getNavigationElement() {
		return navigationElement;
	}

	public boolean contains(ITextRegion other) {
		return textRegion.contains(other);
	}

	public boolean contains(int offset) {
		return textRegion.contains(offset);
	}

	public int getEndLineNumber() {
		return textRegion.getEndLineNumber();
	}

	public int getLength() {
		return textRegion.getLength();
	}

	public int getLineNumber() {
		return textRegion.getLineNumber();
	}

	public int getOffset() {
		return textRegion.getOffset();
	}

	public ITextRegion merge(ITextRegion region) {
		return textRegion.merge(region);
	}

	public ITextRegionWithLineInformation merge(ITextRegionWithLineInformation other) {
		return textRegion.merge(other);
	}
}
