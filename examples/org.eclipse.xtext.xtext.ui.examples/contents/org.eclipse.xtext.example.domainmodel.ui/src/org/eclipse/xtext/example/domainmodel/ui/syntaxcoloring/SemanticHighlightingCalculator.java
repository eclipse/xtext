/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.syntaxcoloring;

import java.util.Iterator;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;

public class SemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	
	@Override
	public void doProvideHighlightingFor(final XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		Iterator<INode> allNodes = resource.getParseResult().getRootNode().getAsTreeIterable().iterator();
		while(allNodes.hasNext()) {
			INode node = allNodes.next();
			if (node.getGrammarElement() instanceof CrossReference) {
				highlightNode(acceptor, node, SemanticHighlightingConfiguration.CROSS_REF);
			}
		}
		super.doProvideHighlightingFor(resource, acceptor);
	}

}