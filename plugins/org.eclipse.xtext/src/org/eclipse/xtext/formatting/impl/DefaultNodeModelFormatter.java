/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.INodeModelStreamer;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.util.TextLocation;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultNodeModelFormatter extends AbstractNodeModelFormatter {

	protected class FilterFirstWhitespaceStream extends BaseTokenStream {

		boolean firstPassed = false;

		protected FilterFirstWhitespaceStream(ITokenStream out) {
			super(out);
		}

		@Override
		public void writeHidden(EObject grammarElement, String value) throws IOException {
			if (firstPassed)
				out.writeHidden(grammarElement, value);
			else {
				boolean isWhitespace = grammarElement instanceof AbstractRule
						&& hiddenTokenHelper.isWhitespace((AbstractRule) grammarElement);
				if (!isWhitespace) {
					out.writeHidden(grammarElement, value);
					firstPassed = true;
				}
			}
		}

		@Override
		public void writeSemantic(EObject grammarElement, String value) throws IOException {
			firstPassed = true;
			out.writeSemantic(grammarElement, value);
		}

	}

	@Inject
	protected IFormatter formatter;

	@Inject
	protected IHiddenTokenHelper hiddenTokenHelper;

	@Inject
	protected INodeModelStreamer nodeModelStreamer;

	@Override
	public IFormattedRegion format(CompositeNode root, int offset, int length) {
		String indent = getIndentation(root, offset);
		TokenStringBuffer buf = new TokenStringBuffer();
		ITokenStream out = offset == 0 ? buf : new FilterFirstWhitespaceStream(buf);
		ITokenStream fmt = formatter.createFormatterStream(indent, out, false);
		try {
			TextLocation range = nodeModelStreamer.feedTokenStream(fmt, root, offset, length);
			return new FormattedRegion(range.getOffset(), range.getLength(), buf.toString());
		} catch (IOException e) {
			// this should never happen since TokenStringBuffer doesn't throw IOEs.
			throw new RuntimeException(e);
		}
	}

	protected String getIndentation(EObject root, int fromOffset) {
		if (fromOffset == 0)
			return "";

		List<LeafNode> r = new ArrayList<LeafNode>();
		Iterator<EObject> it = root.eAllContents();

		// add all nodes until fromOffset
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof LeafNode) {
				LeafNode l = (LeafNode) o;
				if (l.getOffset() >= fromOffset)
					break;
				else
					r.add(l);
			}
		}

		// go backwards until first linewrap
		Pattern p = Pattern.compile("\\n([ \\t]*)");
		for (int i = r.size() - 1; i >= 0; i--) {
			Matcher m = p.matcher(r.get(i).getText());
			if (m.find()) {
				String ind = m.group(1);
				while (m.find())
					ind = m.group(1);
				return ind;
			}
		}
		return "";
	}

}
