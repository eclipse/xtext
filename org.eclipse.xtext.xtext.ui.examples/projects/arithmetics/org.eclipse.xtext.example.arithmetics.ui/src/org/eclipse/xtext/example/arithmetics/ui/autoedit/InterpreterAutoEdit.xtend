/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.autoedit

import java.math.BigDecimal
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.DocumentCommand
import org.eclipse.jface.text.IAutoEditStrategy
import org.eclipse.jface.text.IDocument
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation
import org.eclipse.xtext.example.arithmetics.arithmetics.Module
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.model.IXtextDocument

/** 
 * An interactive interpreter as an {@link IAutoEditStrategy}
 */
class InterpreterAutoEdit implements IAutoEditStrategy {

	override void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		for (lineDelimiter : document.legalLineDelimiters) {
			if (command.text == lineDelimiter) {
				try {
					val line = document.getLineOfOffset(command.offset)
					val lineStart = document.getLineOffset(line)
					if (document.get(lineStart, 3) != "def") {
						var computedResult = computeResult(document, command)
						if (computedResult !== null)
							command.text = lineDelimiter+"// = "+computedResult+lineDelimiter
					}
				} catch (BadLocationException e) {
					// ignore
				}
			}
		}
	}

	def private BigDecimal computeResult(IDocument document, DocumentCommand command) {
		return ((document as IXtextDocument)).tryReadOnly([ resource |
			val stmt = findEvaluation(command, resource)
			if(stmt === null) 
				return null
			return evaluate(stmt)
		])
	}

	def protected BigDecimal evaluate(Evaluation stmt) {
		return new Calculator().evaluate(stmt.expression)
	}

	def protected Evaluation findEvaluation(DocumentCommand command, XtextResource state) {
		if (!state.contents.isEmpty) {
			var m = state.contents.filter(Module).head
			for (evaluation : m.statements.filter(Evaluation)) {
				var node = NodeModelUtils.getNode(evaluation)
				if (node.offset <= command.offset && (node.offset + node.length) >= command.offset) {
					return evaluation
				}
			}
		}
		return null
	}
}
