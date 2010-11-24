/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;

/**
 * Represents a class which provides various static helper functions used to
 * support the work with object models containing
 * {@link org.eclipse.xtext.AbstractElement} and
 * {@link org.eclipse.xtext.parsetree.AbstractNode} composite structure models.
 *
 *
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 *
 * @see org.eclipse.xtext.AbstractElement
 * @see org.eclipse.xtext.parsetree.AbstractNode
 */
public final class ParseTreeUtil {

	/**
	 * @param contextNode		the node representing the 'scope' of the current lookup
	 * @param offsetPosition	the text position within the the current sentence
	 * @return the last 'complete' (an associated grammar element is available)
	 *         node element contained within the given contextNode at the
	 *         provided position
	 */
	public static final AbstractNode getLastCompleteNodeByOffset(AbstractNode contextNode, int offsetPosition) {
		assertParameterNotNull(contextNode, "contextNode");
		AbstractNode result = contextNode.eContainer()==null ? contextNode : null;
		TreeIterator<EObject> allContentsTreeIterator = EcoreUtil.getRootContainer(contextNode).eAllContents();
		while (allContentsTreeIterator.hasNext()) {
			EObject eObject = allContentsTreeIterator.next();
			if (eObject instanceof AbstractNode) {
				AbstractNode abstractNode = (AbstractNode) eObject;
				if (abstractNode.getOffset() >= offsetPosition ) {
					break;
				} else if ((abstractNode instanceof LeafNode || null == result) &&
						   (abstractNode.getGrammarElement() == null ||
						    abstractNode.getGrammarElement() instanceof AbstractElement ||
					    	abstractNode.getGrammarElement() instanceof ParserRule)) {
					result = abstractNode;
				}
			}
		}
		return result;
	}
	
	/**
	 * asserts if the given parameter object isnt null
	 *
	 * @param parameter		the reference to assert
	 * @param parameterName	the name of the parameter
	 */
	public static final void assertParameterNotNull(Object parameter, String parameterName) {
		if (parameter == null)
			throw new IllegalArgumentException("parameter '" + parameterName + "' must not be null.");
	}

}