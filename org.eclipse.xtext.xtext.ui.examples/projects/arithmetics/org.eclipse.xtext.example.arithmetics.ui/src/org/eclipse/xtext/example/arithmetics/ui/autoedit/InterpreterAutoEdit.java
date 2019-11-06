/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import java.math.BigDecimal;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * An interactive interpreter as an {@link IAutoEditStrategy}
 */
public class InterpreterAutoEdit implements IAutoEditStrategy {
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;

	@Override
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		for (String lineDelimiter : document.getLegalLineDelimiters()) {
			if (Objects.equal(command.text, lineDelimiter)) {
				try {
					int line = document.getLineOfOffset(command.offset);
					int lineStart = document.getLineOffset(line);
					String text = document.get(lineStart, 3);
					if (!"def".equals(text)) {
						BigDecimal computedResult = computeResult(document, command);
						if (computedResult != null) {
							command.text = lineDelimiter + "// = " + computedResult + lineDelimiter;
						}
					}
				} catch (BadLocationException t) {
					// may happen
				}
			}
		}
	}

	private BigDecimal computeResult(IDocument document, DocumentCommand command) {
		return xtextDocumentUtil.getXtextDocument(document).tryReadOnly((XtextResource resource) -> {
			Evaluation stmt = findEvaluation(command, resource);
			if (stmt == null) {
				return null;
			}
			return evaluate(stmt);
		});
	}

	protected BigDecimal evaluate(Evaluation stmt) {
		return new Calculator().evaluate(stmt.getExpression());
	}

	protected Evaluation findEvaluation(DocumentCommand command, XtextResource state) {
		if (!state.getContents().isEmpty()) {
			org.eclipse.xtext.example.arithmetics.arithmetics.Module m = 
					(org.eclipse.xtext.example.arithmetics.arithmetics.Module) state.getContents().get(0);
			for (Evaluation evaluation : Iterables.filter(m.getStatements(), Evaluation.class)) {
				ICompositeNode node = NodeModelUtils.getNode(evaluation);
				if (node.getOffset() <= command.offset && node.getOffset() + node.getLength() >= command.offset) {
					return evaluation;
				}
			}
		}
		return null;
	}
}
