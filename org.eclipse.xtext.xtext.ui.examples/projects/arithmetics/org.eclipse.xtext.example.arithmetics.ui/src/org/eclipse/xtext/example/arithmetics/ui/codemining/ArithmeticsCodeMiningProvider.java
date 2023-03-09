/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.codemining;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.codemining.ICodeMining;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
public class ArithmeticsCodeMiningProvider extends AbstractXtextCodeMiningProvider {

	@Inject
	private ArithmeticsGrammarAccess grammar;

	@Inject
	private Calculator calculator;

	@Override
	protected void createCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator,
		IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {

		EList<EObject> contents = resource.getContents();
		if (contents.isEmpty()) {
			return;
		}

		// get all evaluations contained by the open document
		List<Evaluation> allEvaluations = EcoreUtil2.eAllOfType(contents.get(0), Evaluation.class);

		// get keyword for ';'
		Keyword semicolon = grammar.getEvaluationAccess().getSemicolonKeyword_1();

		for (Evaluation evaluation : allEvaluations) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(evaluation);
			for (Iterator<INode> it = node.getAsTreeIterable().iterator(); it.hasNext();) {
				INode child = it.next();
				if (semicolon.equals(child.getGrammarElement())) {
					int annotationOffset = child.getTotalOffset();
					String annotationText = getAnnotationText(evaluation);
					acceptor.accept(createNewLineContentCodeMining(annotationOffset, annotationText));
				}
			}
		}
	}

	private String getAnnotationText(Evaluation evaluation) {
		BigDecimal value = calculator.evaluate(evaluation.getExpression());
		// use always the english locale when formatting BigDecimals (use '.' as decimal sign)
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
		return " = " + new DecimalFormat("#0.##", symbols).format(value);
	}
}
