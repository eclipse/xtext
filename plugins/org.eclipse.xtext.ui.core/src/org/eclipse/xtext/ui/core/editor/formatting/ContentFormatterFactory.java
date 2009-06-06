/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.formatting;

import java.util.Iterator;

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
			LeafIterator it = new LeafIterator(state.getParseResult()
					.getRootNode());
			// System.out.println("Formatting: offset: " + region.getOffset()
			// + " length:" + region.getLength());
			it.seekToOffset(region.getOffset());

			TokenStringBuffer buf = new TokenStringBuffer();
			ITokenStream fmt = formatter
					.createFormatterStream(null, buf, false);
			int border = region.getOffset() + region.getLength();
			if (it.leaf() != null) {
				int start = it.leaf().getOffset();
				do {
					LeafNode n = it.leaf();
					if (n.isHidden())
						fmt.writeHidden(n.getGrammarElement(), n.getText());
					else
						fmt.writeSemantic(n.getGrammarElement(), n.getText());
					// System.out.println("formatting: " + n.getText());
				} while (it.hasNextBefore(border));
				fmt.close();
				int lengt = (it.leaf().getOffset() + it.leaf().getLength())
						- start;
				return new ReplaceRegion(start, lengt, buf.toString());
			}
			return null;
		}

	}

	public static class LeafIterator {

		private Iterator<EObject> it;

		private LeafNode next;

		public LeafIterator(EObject root) {
			it = root.eAllContents();
		}

		public boolean hasNextBefore(int offset) {
			while (it.hasNext()) {
				EObject o = it.next();
				if (o instanceof LeafNode) {
					next = (LeafNode) o;
					return next.getOffset() < offset;
				}
			}
			return false;
		}

		public LeafNode leaf() {
			return next;
		}

		public void seekToOffset(int offset) {
			while (it.hasNext()) {
				EObject o = it.next();
				if (o instanceof LeafNode) {
					LeafNode l = (LeafNode) o;
					if (l.getOffset() + l.getLength() >= offset) {
						next = l;
						return;
					}
				}
			}
		}

	}

	@Inject
	protected IFormatter formatter;

	public IContentFormatter createConfiguredFormatter(
			SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		return new ContentFormatter();
	}

}
