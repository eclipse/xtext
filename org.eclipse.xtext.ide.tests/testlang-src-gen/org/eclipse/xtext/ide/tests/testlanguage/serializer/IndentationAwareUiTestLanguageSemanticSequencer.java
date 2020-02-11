/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.ChildList;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.IndentationAwareUiTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.OtherTreeNode;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.Tree;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.TreeNode;
import org.eclipse.xtext.ide.tests.testlanguage.services.IndentationAwareUiTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

@SuppressWarnings("all")
public class IndentationAwareUiTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IndentationAwareUiTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == IndentationAwareUiTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case IndentationAwareUiTestLanguagePackage.CHILD_LIST:
				sequence_ChildList(context, (ChildList) semanticObject); 
				return; 
			case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE:
				sequence_OtherTreeNode(context, (OtherTreeNode) semanticObject); 
				return; 
			case IndentationAwareUiTestLanguagePackage.TREE:
				sequence_Tree(context, (Tree) semanticObject); 
				return; 
			case IndentationAwareUiTestLanguagePackage.TREE_NODE:
				sequence_TreeNode(context, (TreeNode) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ChildList returns ChildList
	 *
	 * Constraint:
	 *     children+=OtherTreeNode+
	 */
	protected void sequence_ChildList(ISerializationContext context, ChildList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OtherTreeNode returns OtherTreeNode
	 *
	 * Constraint:
	 *     (name=STRING childList=ChildList?)
	 */
	protected void sequence_OtherTreeNode(ISerializationContext context, OtherTreeNode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TreeNode returns TreeNode
	 *
	 * Constraint:
	 *     (name=ID children+=TreeNode*)
	 */
	protected void sequence_TreeNode(ISerializationContext context, TreeNode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Tree returns Tree
	 *
	 * Constraint:
	 *     (nodes+=TreeNode* moreNodes+=OtherTreeNode*)
	 */
	protected void sequence_Tree(ISerializationContext context, Tree semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
