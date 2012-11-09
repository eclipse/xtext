/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExtractVariableRefactoring extends Refactoring {

	public static final Logger LOG = Logger.getLogger(ExtractVariableRefactoring.class);

	private IDocument document;

	private XExpression expression;

	private String variableName;

	private boolean isFinal;

	@Inject
	private Provider<StatusWrapper> statusProvider;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;
	
	@Inject 
	private ExpressionUtil expressionUtil;

	@Inject 
	private NewVariableNameUtil nameUtil;

	private URI resourceURI;

	private XBlockExpression containerBlock;

	private XExpression successor;

	private MultiTextEdit textEdit;

	public boolean initialize(IXtextDocument document, XExpression expression) {
		this.document = document;
		this.expression = expression;
		isFinal = true;
		resourceURI = EcoreUtil2.getNormalizedResourceURI(expression);
		Pair<XBlockExpression, XExpression> blockAndSuccessor = expressionUtil.findInsertionPointForVariableDeclaration(expression);
		if(blockAndSuccessor == null)
			return false;
		containerBlock = blockAndSuccessor.getFirst();
		successor = blockAndSuccessor.getSecond();
		nameUtil.initialize(expression, containerBlock);
		variableName = nameUtil.getDefaultName(expression);
		return true;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	@Override
	public String getName() {
		return "Extract Local Variable Refactoring";
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		StatusWrapper status = statusProvider.get();
		try {
		} catch (Exception exc) {
			handleException(exc, status);
		}
		return status.getRefactoringStatus();
	}

	protected void createInsertInBlockEdits(String expressionAsString, ITextRegion successorRegion, int indentationLevel) {
		StringBuilder declaration = new StringBuilder();
		declaration.append(getDeclarationString(expressionAsString))
			.append(getLineSeparator())
			.append(indent(indentationLevel));
		textEdit.addChild(new InsertEdit(successorRegion.getOffset(), declaration.toString()));
	}

	protected void createInsertNewBlockEdits(String expressionAsString, ITextRegion successorRegion,
			int indentationLevel) throws BadLocationException {
		StringBuilder declaration = new StringBuilder();
		IRegion lineInformation = document.getLineInformationOfOffset(successorRegion.getOffset());
		int previousLineEnd = lineInformation.getOffset() - getLineSeparator().length();
		if(previousLineEnd > 0 && !Character.isWhitespace(document.getChar(previousLineEnd-1))) 
			declaration.append(" ");
		declaration.append("{")
			.append(getLineSeparator())
			.append(indent(indentationLevel)) 
		    .append(getDeclarationString(expressionAsString))
			.append(getIndentString());
		textEdit.addChild(new InsertEdit(Math.max(0, previousLineEnd), declaration.toString()));
		
		StringBuilder blockClosing = new StringBuilder();
		blockClosing.append(getLineSeparator())
			.append(indent(indentationLevel - 1))
			.append("}");
		textEdit.addChild(new InsertEdit(successorRegion.getOffset() + successorRegion.getLength(), blockClosing.toString()));
	}

	protected String indent(int level) {
		String indentString = getIndentString();
		StringBuilder indentBuilder = new StringBuilder();
		for(int i=0; i<level; ++i) 
			indentBuilder.append(indentString);
		return indentBuilder.toString();
	}
	
 	protected String getDeclarationString(String expressionAsString) {
		StringBuilder builder = new StringBuilder();
		if (isFinal)
			builder.append("val ");
		else
			builder.append("var ");
		builder.append(variableName).append(" = ").append(expressionAsString);
		return builder.toString();
	}

	protected void handleException(Exception exc, StatusWrapper status) {
		status.add(FATAL, "Error during refactoring: {0}", exc, LOG);
	}

	protected int getIndentationLevelAtOffset(int offset) {
		try {
			if (offset <= 0)
				return 0;
			int currentOffset = offset - 1;
			char currentChr = document.getChar(currentOffset);
			int indentationOffset = 0;
			while (currentChr != '\n' && currentChr != '\r' && currentOffset > 0) {
				if (Character.isWhitespace(currentChr))
					++indentationOffset;
				else
					indentationOffset = 0;
				--currentOffset;
				currentChr = document.getChar(currentOffset);
			}
			return indentationOffset / getIndentString().length();
		} catch (BadLocationException e) {
			LOG.error("Error calculating indentation at offset", e);
		}
		return 0;
	}

	protected String getIndentString() {
		return whitespaceInformationProvider.getIndentationInformation(resourceURI).getIndentString();
	}

	protected String getLineSeparator() {
		return whitespaceInformationProvider.getLineSeparatorInformation(resourceURI)
				.getLineSeparator();
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		StatusWrapper status = statusProvider.get();
		try {
			ITextRegion expressionRegion = locationInFileProvider.getFullTextRegion(expression);
			String expressionAsString = document.get(expressionRegion.getOffset(), expressionRegion.getLength());
			ITextRegion successorRegion = locationInFileProvider.getFullTextRegion(successor);
			int indentationLevel = getIndentationLevelAtOffset(successorRegion.getOffset());
			textEdit = new MultiTextEdit();
			if (containerBlock == null) {
				createInsertNewBlockEdits(expressionAsString, successorRegion, indentationLevel);
			} else {
				createInsertInBlockEdits(expressionAsString, successorRegion, indentationLevel);
			}
			textEdit.addChild(new ReplaceEdit(expressionRegion.getOffset(), expressionRegion.getLength(), variableName));
		} catch (Exception exc) {
			handleException(exc, status);
		}
		return status.getRefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		DocumentChange change = new DocumentChange("Introduce variable", document);
		change.setEdit(textEdit);
		change.setTextType(resourceURI.fileExtension());
		return new DisplayChangeWrapper(change);
	}

	public RefactoringStatus validateNewVariableName(String newVariableName) {
		RefactoringStatus status = new RefactoringStatus();
		nameUtil.checkNewVariable(newVariableName, successor, containerBlock, status);
		return status;
	}
}
