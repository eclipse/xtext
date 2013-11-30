/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.expectation;

import java.util.List;

import org.xpect.expectation.ITargetSyntaxSupport.ITargetLiteralSupport;
import org.xpect.text.IReplacement;
import org.xpect.text.Replacement;
import org.xpect.text.Text;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractExpectation {
	private final IExpectationRegion region;
	private final ITargetLiteralSupport targetLiteral;
	private final ITargetSyntaxSupport targetSyntax;

	public AbstractExpectation(ITargetSyntaxSupport targetSyntax, IExpectationRegion region) {
		super();
		Preconditions.checkPositionIndex(region.getOffset(), region.getDocument().length());
		Preconditions.checkPositionIndex(region.getOffset() + region.getLength(), region.getDocument().length());
		this.targetSyntax = targetSyntax;
		this.targetLiteral = targetSyntax.getLiteralSupport(region.getOffset());
		this.region = region;
	}

	protected String findValidSeparator(String value, String suggestedSeparator) {
		if (suggestedSeparator != null && !value.contains(suggestedSeparator))
			return suggestedSeparator;
		final String chars = "-~=+*%#$&";
		for (int i = 3; i < 80; i++) {
			for (int c = 0; i < chars.length(); c++) {
				String separator = Strings.repeat(String.valueOf(chars.charAt(c)), i);
				if (!value.contains(separator))
					return separator;
			}
		}
		throw new IllegalStateException();
	}

	public String getExpectation() {
		if (region.getLength() < 0)
			return "";
		Text substring = new Text(region.getDocument().toString().substring(region.getOffset(), region.getOffset() + region.getLength()));
		if (region instanceof IMultiLineExpectationRegion) {
			String indentation = ((IMultiLineExpectationRegion) region).getIndentation();
			List<String> lines = substring.splitIntoLines();
			String newLines[] = new String[lines.size()];
			for (int i = 0; i < lines.size(); i++)
				if (lines.get(i).startsWith(indentation))
					newLines[i] = lines.get(i).substring(indentation.length());
				else
					newLines[i] = lines.get(i);
			return Joiner.on(substring.getNL()).join(newLines);
		} else {
			return substring.getText().toString();
		}
	}

	public IExpectationRegion getRegion() {
		return region;
	}

	protected IReplacement getReplacement(Text value, boolean enforceMultiLine) {
		Text document = new Text(region.getDocument());
		if (region instanceof IMultiLineExpectationRegion) {
			IMultiLineExpectationRegion mlRegion = (IMultiLineExpectationRegion) region;
			String indentation = mlRegion.getIndentation();
			String separator = findValidSeparator(value.toString(), mlRegion.getSeparator());
			int sepOpening = mlRegion.getOpeningSeparatorOffset();
			int sepClosing = mlRegion.getClosingSeparatorOffset();
			String betweenSeparatorAndExpectation = document.substring(sepOpening + mlRegion.getSeparator().length(), mlRegion.getOffset());
			String betweenExpectationAndSeparator = document.substring(mlRegion.getOffset() + mlRegion.getLength(), sepClosing);
			String indented = indentation + value.indentWith(indentation);
			StringBuilder builder = new StringBuilder();
			builder.append(separator);
			builder.append(betweenSeparatorAndExpectation);
			builder.append(indented);
			builder.append(betweenExpectationAndSeparator);
			builder.append(separator);
			return new Replacement(sepOpening, (sepClosing + mlRegion.getSeparator().length()) - sepOpening, builder.toString());
		} else if (region instanceof ISingleLineExpectationRegion) {
			ISingleLineExpectationRegion slRegion = (ISingleLineExpectationRegion) region;
			if (enforceMultiLine) {
				String separator = findValidSeparator(value.toString(), null);
				String indentation = document.findIndentation(slRegion.getOpeningSeparatorOffset());
				String insideIndentation = indentation;
				if (insideIndentation.length() > 0) {
					char first = insideIndentation.charAt(0);
					if (first == '\t')
						insideIndentation += first;
					else
						insideIndentation += "" + first + first + first + first;
				}
				String indented = insideIndentation + value.indentWith(insideIndentation);
				StringBuilder builder = new StringBuilder();
				builder.append(separator);
				builder.append(document.getNL());
				builder.append(indented);
				builder.append(document.getNL());
				builder.append(indentation);
				builder.append(separator);
				int length = (slRegion.getOffset() - slRegion.getOpeningSeparatorOffset()) + slRegion.getLength();
				return new Replacement(slRegion.getOpeningSeparatorOffset(), length, builder.toString());
			} else {
				return new Replacement(region.getOffset(), region.getLength(), value.toString());
			}
		}
		throw new IllegalStateException();
	}

	public ITargetSyntaxSupport getTargetSyntax() {
		return targetSyntax;
	}

	public ITargetLiteralSupport getTargetSyntaxLiteral() {
		return targetLiteral;
	}

	protected String replaceInDocument(String newValue) {
		Text document = new Text(region.getDocument());
		Text value = new Text(newValue);
		boolean multiline = targetSyntax.supportsMultiLineLiteral() && value.isMultiline();
		IReplacement replacement = getReplacement(value, multiline);
		IReplacement targetReplacement = targetLiteral.adoptToTargetSyntax(replacement, multiline);
		return document.with(targetReplacement);
	}
}