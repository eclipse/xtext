/*******************************************************************************
 * Copyright (c) 2022 Avaloq Group Ltd (http://www.avaloq.com).
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.syntaxcoloring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Rubén Porras Campo - Initial Contribution and API
 */
public class SemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.eClass() == TestLanguagePackage.Literals.TYPE_DECLARATION) {
			ICompositeNode node = NodeModelUtils.getNode(object);
			for (INode childNode: node.getChildren()) {
				if (childNode.getGrammarElement() instanceof Keyword) {
					String nodeText = childNode.getText();
					if (nodeText.equals("extends") || nodeText.equals("type")) {
						acceptor.addPosition(childNode.getOffset(), childNode.getLength(), HighlightingStyles.KEYWORD_ID);
					}
				}
			}
		}

		return super.highlightElement(object, acceptor, cancelIndicator);
	}
}
