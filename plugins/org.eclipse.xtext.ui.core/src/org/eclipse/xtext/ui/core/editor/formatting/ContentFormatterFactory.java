/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.formatting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.reconciler.ReplaceRegion;

import com.google.inject.Inject;

public class ContentFormatterFactory implements IContentFormatterFactory {

	public class ContentFormatter implements IContentFormatter {

		public void format(IDocument document, IRegion region) {
			IXtextDocument doc = (IXtextDocument) document;
			ReplaceRegion r = doc.readOnly(new FormattingUnitOfWork(region));
			try {
				if (r != null)
					doc.replace(r.getOffset(), r.getLength(), r.getText());
			} catch (BadLocationException e) {
				throw new RuntimeException(e);
			}
		}

		public IFormattingStrategy getFormattingStrategy(String contentType) {
			return null;
		}
	}

	public class FormattingUnitOfWork implements
			IUnitOfWork<ReplaceRegion, XtextResource> {

		protected final IRegion region;

		public FormattingUnitOfWork(IRegion region) {
			super();
			this.region = region;
		}

		public ReplaceRegion exec(XtextResource state) throws Exception {
			List<LeafNode> nodes = getLeafs(state.getParseResult()
					.getRootNode(), region.getOffset(), region.getOffset()
					+ region.getLength());
			if (nodes.size() == 0)
				return null;

			String indent = getIndentation(
					state.getParseResult().getRootNode(), region.getOffset());
			TokenStringBuffer buf = new TokenStringBuffer();
			ITokenStream fmt = formatter.createFormatterStream(indent, buf,
					false);
			for (LeafNode n : nodes) {
				if (n.isHidden())
					fmt.writeHidden(n.getGrammarElement(), n.getText());
				else
					fmt.writeSemantic(n.getGrammarElement(), n.getText());
			}
			fmt.close();
			int start = nodes.get(0).getOffset();
			int lengt = (nodes.get(nodes.size() - 1).getOffset() + nodes.get(
					nodes.size() - 1).getLength())
					- start;
			return new ReplaceRegion(start, lengt, buf.toString().trim());
		}

	}

	@Inject
	protected IFormatter formatter;

	public IContentFormatter createConfiguredFormatter(
			SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		return new ContentFormatter();
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

	protected List<LeafNode> getLeafs(EObject root, int fromOffset, int toOffset) {
		List<LeafNode> r = new ArrayList<LeafNode>();
		Iterator<EObject> it = root.eAllContents();

		// seek to fromOffset
		if (fromOffset > 0)
			while (it.hasNext()) {
				EObject o = it.next();
				if (o instanceof LeafNode) {
					LeafNode l = (LeafNode) o;
					if (!l.isHidden()
							&& l.getOffset() + l.getLength() >= fromOffset) {
						r.add(l);
						break;
					}
				}
			}

		// add Leafs within the range
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof LeafNode) {
				LeafNode l = (LeafNode) o;
				if (l.getOffset() > toOffset)
					break;
				else
					r.add(l);
			}
		}

		// remove tailing hidden leafs
		for (int i = r.size() - 1; i >= 0; i--)
			if (r.get(i).isHidden())
				r.remove(i);
			else
				break;
		return r;
	}

}
