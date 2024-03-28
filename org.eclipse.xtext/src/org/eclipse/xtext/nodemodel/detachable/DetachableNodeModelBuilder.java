/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Inject;

/**
 * @since 2.35
 */
public class DetachableNodeModelBuilder extends NodeModelBuilder {
	
	private final Map<EObject, CompositeNodeWithSemanticElement> associations;
	private final DetachableParseResult parseResult;

	@Inject
	public DetachableNodeModelBuilder(GrammarElementLookup grammarElementLookup) {
		this.associations = new HashMap<>();
		this.parseResult = createEmptyParseResult(grammarElementLookup);
	}

	protected DetachableParseResult createEmptyParseResult(GrammarElementLookup grammarElementLookup) {
		return new DetachableParseResult(grammarElementLookup);
	}
	
	@Override
	public void associateWithSemanticElement(ICompositeNode node, EObject astElement) {
		CompositeNodeWithSemanticElement casted = (CompositeNodeWithSemanticElement) node;
		associations.put(astElement, casted);
		basicSetSemanticElement(casted, astElement);
		astElement.eAdapters().add(new NodeReferenceAdapter(parseResult));
	}
	
	@Override
	protected void updateAssociation(CompositeNode oldNode, CompositeNodeWithSemanticElement newNode,
			EObject astElement) {
		associations.put(astElement, newNode);
		basicSetSemanticElement(newNode, astElement);
	}
	
	@Override
	public IParseResult createParseResult(EObject model, ICompositeNode root, boolean hasErrors) {
		parseResult.setRootASTElement(model);
		parseResult.setHasErrors(hasErrors);
		parseResult.setRootNodeAndAssociations(root, associations);
		return parseResult;
	}

	
}
