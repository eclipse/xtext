/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.ChildList;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode;
import org.eclipse.xtext.parser.indentation.services.IndentationAwareTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

@SuppressWarnings("all")
public abstract class AbstractIndentationAwareTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IndentationAwareTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == IndentationAwareTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case IndentationAwareTestLanguagePackage.CHILD_LIST:
				sequence_ChildList(context, (ChildList) semanticObject); 
				return; 
			case IndentationAwareTestLanguagePackage.OTHER_TREE_NODE:
				sequence_OtherTreeNode(context, (OtherTreeNode) semanticObject); 
				return; 
			case IndentationAwareTestLanguagePackage.TREE:
				sequence_Tree(context, (Tree) semanticObject); 
				return; 
			case IndentationAwareTestLanguagePackage.TREE_NODE:
				sequence_TreeNode(context, (TreeNode) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     ChildList returns ChildList
	 *
	 * Constraint:
	 *     children+=OtherTreeNode+
	 * </pre>
	 */
	protected void sequence_ChildList(ISerializationContext context, ChildList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OtherTreeNode returns OtherTreeNode
	 *
	 * Constraint:
	 *     (name=STRING childList=ChildList?)
	 * </pre>
	 */
	protected void sequence_OtherTreeNode(ISerializationContext context, OtherTreeNode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TreeNode returns TreeNode
	 *
	 * Constraint:
	 *     (name=ID children+=TreeNode*)
	 * </pre>
	 */
	protected void sequence_TreeNode(ISerializationContext context, TreeNode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Tree returns Tree
	 *
	 * Constraint:
	 *     (nodes+=TreeNode* moreNodes+=OtherTreeNode*)
	 * </pre>
	 */
	protected void sequence_Tree(ISerializationContext context, Tree semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
