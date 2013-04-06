/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.expectation;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Strings;
import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.parameter.IParameterProvider;
import org.xpect.util.IRegion;
import org.xpect.util.Region;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractExpectation implements IParsedParameterProvider {
	private final String document;
	private final IExpectationRegion region;

	public AbstractExpectation(String document, IExpectationRegion region) {
		super();
		Preconditions.checkPositionIndex(region.getOffset(), document.length());
		Preconditions.checkPositionIndex(region.getOffset() + region.getLength(), document.length());
		this.document = document;
		this.region = region;
	}

	public boolean canProvide(Class<?> expectedType) {
		return expectedType.isInstance(this);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType, Map<Class<? extends Annotation>, IParameterProvider> context) {
		if (expectedType.isInstance(this))
			return (T) this;
		return null;
	}

	public IExpectationRegion getClaimedRegion() {
		return region;
	}

	protected String getExpectation() {
		if (getLength() < 0)
			return "";
		String substring = document.substring(getOffset(), getOffset() + getLength());
		String indentation = region.getIndentation();
		if (indentation != null) {
			String[] lines = substring.split("\\n");
			String newLines[] = new String[lines.length];
			for (int i = 0; i < lines.length; i++)
				if (lines[i].startsWith(indentation))
					newLines[i] = lines[i].substring(indentation.length());
				else
					newLines[i] = lines[i];
			return Joiner.on("\n").join(newLines);
		} else {
			return substring;
		}
	}

	public int getLength() {
		return region.getLength();
	}

	public int getOffset() {
		return region.getOffset();
	}

	public List<IRegion> getSemanticRegions() {
		return Collections.<IRegion> singletonList(new Region(getOffset(), getLength()));
	}

	protected String replaceInDocument(String value) {
		String indented;
		String indentation = region.getIndentation();
		if (!Strings.isEmpty(indentation))
			indented = indentation + value.replace("\n", "\n" + indentation);
		else
			indented = value;
		String before = document.substring(0, getOffset());
		String after = document.substring(getOffset() + getLength(), document.length());
		return before + indented + after;
	}
}