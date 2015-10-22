/** 
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.autoedit

import java.math.BigDecimal
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.DocumentCommand
import org.eclipse.jface.text.IAutoEditStrategy
import org.eclipse.jface.text.IDocument
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation
import org.eclipse.xtext.example.arithmetics.arithmetics.Module
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.model.IXtextDocument

/** 
 * @author Sven Efftinge - initial contribution and API
 * an interactive interpreter as an {@link IAutoEditStrategy}
 */
class InterpreterAutoEdit implements IAutoEditStrategy {

	override void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		for (String lineDelimiter : document.getLegalLineDelimiters()) {
			if (command.text.equals(lineDelimiter)) {
				var int line
				var int lineStart
				try {
					line = document.getLineOfOffset(command.offset)
					lineStart = document.getLineOffset(line)
					if (!document.get(lineStart, 3).equals("def")) {
						var BigDecimal computedResult = computeResult(document, command)
						if (computedResult !== null)
							command.text = '''«lineDelimiter»// = «computedResult»«lineDelimiter»'''
					}
				} catch (BadLocationException e) { // ignore
				}
			}
		}
	}

	def private BigDecimal computeResult(IDocument document, DocumentCommand command) {
		return ((document as IXtextDocument)).readOnly([ XtextResource state |
			var Evaluation stmt = findEvaluation(command, state)
			if(stmt === null) 
				return null
			return evaluate(stmt)
		])
	}

	def protected BigDecimal evaluate(Evaluation stmt) {
		return new Calculator().evaluate(stmt.getExpression())
	}

	def protected Evaluation findEvaluation(DocumentCommand command, XtextResource state) {
		if (!state.getContents().isEmpty()) {
			var Module m = (state.getContents().get(0) as Module)
			for (Statement stmt : m.getStatements()) {
				if (stmt instanceof Evaluation) {
					var ICompositeNode node = NodeModelUtils.getNode(stmt)
					if (node.getOffset() <= command.offset && (node.getOffset() + node.getLength()) >= command.offset) {
						return (stmt as Evaluation)
					}
				}
			}
		}
		return null
	}
}
