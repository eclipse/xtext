/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.debug;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class TextDocumentChangeToString {

	private List<IEmfResourceChange> changes = Lists.newArrayList();

	public TextDocumentChangeToString add(IEmfResourceChange change) {
		changes.add(change);
		return this;
	}

	public TextDocumentChangeToString add(Collection<IEmfResourceChange> changes) {
		this.changes.addAll(changes);
		return this;
	}

	// TODO: de-duplicate with org.eclipse.xtext.formatting2.debug.TextRegionsInTextToString.box(String, String)
	private String box(String title, String content) {
		final int width = 80;
		final int min = 3;
		int titleLength = title.length() + 2;
		final int left = Math.max((width - titleLength) / 2, min);
		StringBuilder result = new StringBuilder();
		result.append(Strings.repeat("-", left));
		result.append(" ");
		result.append(title);
		result.append(" ");
		if (left > min)
			result.append(Strings.repeat("-", width - left - titleLength));
		result.append("\n");
		result.append(org.eclipse.xtext.util.Strings.trimTrailingLineBreak(content));
		result.append("\n");
		result.append(Strings.repeat("-", width));
		return result.toString();
	}

	@Override
	public String toString() {
		List<String> result = Lists.newArrayList();
		for (IEmfResourceChange c : changes) {
			String title = getTitle(c);
			if (c instanceof ITextDocumentChange) {
				ITextDocumentChange change = (ITextDocumentChange) c;
				TextRegionsToString textRegionsToString = new TextRegionsToString();
				textRegionsToString.setIgnoreCarriageReturnInQuotes(true);
				textRegionsToString.addAllReplacements(change.getReplacements());
				textRegionsToString.setTitle(title);
				result.add(textRegionsToString.toString());
			} else {
				String box = box(title, c.toString());
				result.add(box);
			}
		}
		return Joiner.on("\n").join(result);
	}

	protected String getTitle(IEmfResourceChange change) {
		URI newUri = change.getNewURI();
		URI oldURI = change.getOldURI();
		if (oldURI == null && newUri == null) {
			return "error, both URIs are null";
		}
		if (newUri == null) {
			return "deleted " + oldURI;
		}
		if (oldURI == null) {
			return "created " + newUri;
		}
		if (oldURI.equals(newUri)) {
			return oldURI.toString();
		}
		return "renamed " + oldURI + " to " + newUri;
	}

}
