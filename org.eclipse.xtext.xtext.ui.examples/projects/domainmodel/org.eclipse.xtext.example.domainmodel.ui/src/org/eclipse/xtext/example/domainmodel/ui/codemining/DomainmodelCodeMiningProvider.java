/*******************************************************************************
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.codemining;


import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.codemining.ICodeMining;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.example.domainmodel.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * Provide code minings for the Domainmodel example.
 */
public class DomainmodelCodeMiningProvider extends AbstractXtextCodeMiningProvider {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	@Inject
	private DomainmodelGrammarAccess grammar;

	@Override
	protected void createCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator,
			IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
		if (resource.getContents().isEmpty()) {
			return;
		}
		
		// get all entities in the open document
		List<Entity> allEntities = EcoreUtil2.eAllOfType(resource.getContents().get(0), Entity.class);
		for (Entity e : allEntities) {
			int propertiesCount = (int) e.getFeatures().stream().filter(f -> (f instanceof Property)).count();
			String propertiesHeaderText = propertiesCount + " " + (propertiesCount == 1 ? "property" : "properties");
			
			int operationsCount = (int) e.getFeatures().stream().filter(f -> (f instanceof Operation)).count();
			String operationsHeaderText = operationsCount + " operation" + (operationsCount == 1 ? "" : "s");
			
			ICompositeNode node = NodeModelUtils.getNode(e);
			int beforeLineNumber = document.getLineOfOffset(node.getOffset());
			// create two line header code minings before the entity: one for the properties, one for the operations
			acceptor.accept(createNewLineHeaderCodeMining(beforeLineNumber, document, propertiesHeaderText));
			acceptor.accept(createNewLineHeaderCodeMining(beforeLineNumber, document, operationsHeaderText));
		}
		
		// get all operations in the open document
		List<Operation> allOperations = EcoreUtil2.eAllOfType(resource.getContents().get(0), Operation.class);
		// get keyword for ')'
		Keyword rightParenthesisKeyword_4 = grammar.getOperationAccess().getRightParenthesisKeyword_4();
		for (Operation o : allOperations) {
			//inline annotations only for methods with no return type
			if (o.getType() != null) {
				continue;
			}
			// get return type name from operation
			JvmOperation inferredOp = (JvmOperation) jvmModelAssociations.getPrimaryJvmElement(o);
			if (inferredOp == null || inferredOp.getReturnType() == null) {
				continue; // broken model
			}
			String returnTypeName = inferredOp.getReturnType().getSimpleName();
			// find document offset for inline annotation
			ICompositeNode node = NodeModelUtils.findActualNodeFor(o);
			for (Iterator<INode> it = node.getAsTreeIterable().iterator(); it.hasNext();) {
				INode child = it.next();
				if (rightParenthesisKeyword_4.equals(child.getGrammarElement())) {
					// create line content code mining for inline annotation after grammarElement ')'
					String annotationText = " : " + returnTypeName;
					acceptor.accept(createNewLineContentCodeMining(child.getTotalOffset() + 1, annotationText));
				}
			}
		}
	}
}
