/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import java.math.BigDecimal;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sven Efftinge - initial contribution and API
 * 
 *         an interactive interpreter as an {@link IAutoEditStrategy}
 */
public class InterpreterAutoEdit implements IAutoEditStrategy {

	public void customizeDocumentCommand(IDocument document,
			DocumentCommand command) {
		for (String lineDelimiter : document.getLegalLineDelimiters()) {
			if (command.text.equals(lineDelimiter)) {
				int line;
				int lineStart;
				try {
					line = document.getLineOfOffset(command.offset);
					lineStart = document.getLineOffset(line);
					if (!document.get(lineStart, 3).equals("def")) {
						BigDecimal computedResult = computeResult(document,
								command);
						if (computedResult != null)
							command.text = lineDelimiter + "// = " + computedResult + lineDelimiter;
					}
				} catch (BadLocationException e) {
					// ignore
				}
			}
		}
	}

	private BigDecimal computeResult(IDocument document,
			final DocumentCommand command) {
		return ((IXtextDocument) document)
				.readOnly(new IUnitOfWork<BigDecimal, XtextResource>() {
					public BigDecimal exec(XtextResource state)
							throws Exception {
						Evaluation stmt = findEvaluation(command, state);
						if (stmt == null)
							return null;
						return evaluate(stmt);
					}
				});
	}

	protected BigDecimal evaluate(Evaluation stmt) {
		return new Calculator().evaluate(stmt.getExpression());
	}

	protected Evaluation findEvaluation(final DocumentCommand command,
			XtextResource state) {
		if(!state.getContents().isEmpty()) {
			Module m = (Module) state.getContents().get(0);
			for (Statement stmt : m.getStatements()) {
				if (stmt instanceof Evaluation) {
					ICompositeNode node = NodeModelUtils.getNode(stmt);
					if (node.getOffset() <= command.offset
							&& (node.getOffset() + node.getLength()) >= command.offset) {
						return (Evaluation) stmt;
					}
				}
			}
		}
		return null;
	}
}
