/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.Range;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextDamagerRepairer extends DefaultDamagerRepairer {

	public XtextDamagerRepairer(ITokenScanner scanner) {
		super(scanner);
	}

	protected XtextDocument getDocument() {
		return (XtextDocument) fDocument;
	}

	@Override
	public void setDocument(IDocument document) {
		if (document != null && !(document instanceof XtextDocument))
			throw new IllegalArgumentException("document is invalid: " + document);
		super.setDocument(document);
	}

	@Override
	public IRegion getDamageRegion(ITypedRegion partition, final DocumentEvent e, boolean documentPartitioningChanged) {
		if (documentPartitioningChanged)
			return partition;

		IRegion result = getDocument().readOnly(new UnitOfWork<IRegion>(){
			private final int offset = e.getOffset();
			private final int endOffset = offset + e.getLength();

			public IRegion exec(XtextResource resource) throws Exception {
				AbstractNode node = resource.getParseResult().getRootNode();
				AbstractNode start = null;
				AbstractNode end = null;
				// find latest node that covers the start of the change
				while(node != null && start == null) {
					if (node instanceof CompositeNode) {
						if (((CompositeNode) node).getChildren().isEmpty())
							break;
						for(AbstractNode child: ((CompositeNode) node).getChildren()) {
							if (child.getTotalOffset() <= offset && child.getTotalOffset() + child.getTotalLength() >= offset) {
								node = child;
								if (node instanceof LeafNode || node.getTotalOffset() == offset)
									start = node;
								break;
							}
						}
					} else {
						throw new IllegalStateException("node is not in expected range but is not a composite.");
					}
				}
				// search up to the first, deepest node, that covers the end
				node = start;
				while(node != null && end == null) {
					if (node.getTotalLength() + node.getTotalOffset() >= endOffset) {
						while(end == null) {
							if (node instanceof CompositeNode) {
								if (((CompositeNode) node).getChildren().isEmpty())
									break;
								for(int i = ((CompositeNode) node).getChildren().size() - 1; i >= 0; i--) {
									AbstractNode child = ((CompositeNode) node).getChildren().get(i);
									if (child.getTotalOffset() + child.getTotalLength() >= endOffset && child.getTotalOffset() <= endOffset) {
										node = child;
										if (node instanceof LeafNode || node.getTotalOffset() + node.getTotalLength() == endOffset)
											end = node;
										break;
									}
								}
							} else {
								end = node;
							}
						}
					} else {
						node = node.getParent();
					}
				}
				// include region with syntax errors
				int startOffset = start != null ? start.getTotalOffset() : offset;
				int endOffset = end != null ? end.getTotalOffset() + end.getTotalLength() : this.endOffset;
				Range range = new Range(startOffset, endOffset);
				range.mergeAllErrors(resource.getParseResult().getRootNode());
				// cover the difference between inserted text and removed text
				return new Region(range.getFromOffset(), range.getToOffset() - range.getFromOffset() + e.getText().length() - e.getLength());
			}
		});
		return result;
	}

}
