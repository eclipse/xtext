/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.IFormatterExtension;
import org.eclipse.xtext.formatting.INodeModelStreamer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.util.ITextRegion;

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
	public IFormattedRegion format(ICompositeNode root, int offset, int length) {
		String indent = getIndentation(root, offset);
		TokenStringBuffer buf = new TokenStringBuffer();
		ITokenStream out = offset == 0 ? buf : new FilterFirstWhitespaceStream(buf);
		ITokenStream fmt;
		if (formatter instanceof IFormatterExtension) {
			EObject semanticElement = NodeModelUtils.findActualSemanticObjectFor(root);
			if (semanticElement != null)
				fmt = ((IFormatterExtension) formatter).createFormatterStream(semanticElement, indent, out, false);
			else {
				// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=380406
				ITextRegion rootRegion = root.getTextRegion();
				return new FormattedRegion(rootRegion.getOffset(), rootRegion.getLength(), root.getText());
			}
		} else
			fmt = formatter.createFormatterStream(indent, out, false);
		try {
			ITextRegion range = nodeModelStreamer.feedTokenStream(fmt, root, offset, length);
			return new FormattedRegion(range.getOffset(), range.getLength(), buf.toString());
		} catch (IOException e) {
			// this should never happen since TokenStringBuffer doesn't throw IOEs.
			throw new RuntimeException(e);
		}
	}

	protected String getIndentation(ICompositeNode root, int fromOffset) {
		if (fromOffset == 0)
			return "";

		List<ILeafNode> r = new ArrayList<ILeafNode>();
		// add all nodes until fromOffset
		for(ILeafNode l: root.getLeafNodes()) {
			if (l.getOffset() >= fromOffset)
				break;
			else
				r.add(l);
		}

		// go backwards until first linewrap
		Pattern p = Pattern.compile("(\\n|\\r)([ \\t]*)");
		for (int i = r.size() - 1; i >= 0; i--) {
			Matcher m = p.matcher(r.get(i).getText());
			if (m.find()) {
				String ind = m.group(2);
				while (m.find())
					ind = m.group(2);
				return ind;
			}
		}
		return "";
	}

}
