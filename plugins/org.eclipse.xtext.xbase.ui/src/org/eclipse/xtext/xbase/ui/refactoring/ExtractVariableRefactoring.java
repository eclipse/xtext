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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

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

	private boolean isFinal = true;

	@Inject
	private Provider<StatusWrapper> statusProvider;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject 
	private ExpressionUtil expressionUtil;

	@Inject 
	private NewFeatureNameUtil nameUtil;
	
	@Inject 
	private IndentationUtil indentationUtil;
	
	@Inject 
	private ITypeProvider typeProvider;

	@Inject 
	private TypeSerializationUtil serializer;

	private URI resourceURI;

	private boolean isNeedsNewBlock;
	
	private XExpression successor;

	private MultiTextEdit textEdit;

	public boolean initialize(IXtextDocument document, XExpression expression) {
		this.document = document;
		this.expression = expression;
		resourceURI = EcoreUtil2.getNormalizedResourceURI(expression);
		successor = expressionUtil.findSuccessorExpressionForVariableDeclaration(expression);
		if(successor == null)
			return false;
		isNeedsNewBlock = !(successor.eContainer() instanceof XBlockExpression);
		indentationUtil.initialize(document, resourceURI);
		nameUtil.setFeatureScopeContext(successor);
		variableName = nameUtil.getDefaultName(expression);
		return true;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public RefactoringStatus validateNewVariableName(String newVariableName) {
		RefactoringStatus status = new RefactoringStatus();
		nameUtil.checkNewFeatureName(newVariableName, true, status);
		return status;
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

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		StatusWrapper status = statusProvider.get();
		try {
			status.merge(validateNewVariableName(variableName));
			ITextRegion expressionRegion = locationInFileProvider.getFullTextRegion(expression);
			String expressionAsString = createInsertExpression(expressionRegion);
			ITextRegion successorRegion = locationInFileProvider.getFullTextRegion(successor);
			int indentationLevel = indentationUtil.getIndentationLevelAtOffset(successorRegion.getOffset());
			textEdit = new MultiTextEdit();
			if (isNeedsNewBlock) {
				createInsertNewBlockEdits(expressionAsString, successorRegion, indentationLevel);
			} else {
				createInsertInBlockEdits(expressionAsString, successorRegion, indentationLevel);
			}
			String callerText = variableName;
			if(expression.eContainer() instanceof XMemberFeatureCall) {
				if(((XMemberFeatureCall) expression.eContainer()).getMemberCallArguments().size() == 1) {
					String expressionExpanded = document.get(expressionRegion.getOffset()-1, expressionRegion.getLength() + 2);
					if(!expressionExpanded.startsWith("(") || !expressionExpanded.endsWith(")")) 
						callerText = "(" + callerText + ")";
				}
			}
			textEdit.addChild(new ReplaceEdit(expressionRegion.getOffset(), expressionRegion.getLength(), callerText));
		} catch (Exception exc) {
			handleException(exc, status);
		}
		return status.getRefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		DocumentChange change = new DocumentChange("Extract local variable", document);
		change.setEdit(textEdit);
		change.setTextType(resourceURI.fileExtension());
		return new DisplayChangeWrapper(change);
	}

	protected void handleException(Exception exc, StatusWrapper status) {
		status.add(FATAL, "Error during refactoring: {0}", exc, LOG);
	}

	protected void createInsertInBlockEdits(String expressionAsString, ITextRegion successorRegion, int indentationLevel) {
		StringBuilder declaration = new StringBuilder();
		declaration.append(createDeclarationString(expressionAsString))
			.append(indentationUtil.getLineSeparator())
			.append(indentationUtil.indent(indentationLevel));
		textEdit.addChild(new InsertEdit(successorRegion.getOffset(), declaration.toString()));
	}

	protected void createInsertNewBlockEdits(String expressionAsString, ITextRegion successorRegion,
			int indentationLevel) throws BadLocationException {
		StringBuilder declaration = new StringBuilder();
		IRegion lineInformation = document.getLineInformationOfOffset(successorRegion.getOffset());
		int previousLineEnd = lineInformation.getOffset() - indentationUtil.getLineSeparator().length();
		if(previousLineEnd > 0 && !Character.isWhitespace(document.getChar(previousLineEnd-1))) 
			declaration.append(" ");
		declaration.append("{")
			.append(indentationUtil.getLineSeparator())
			.append(indentationUtil.indent(indentationLevel)) 
		    .append(createDeclarationString(expressionAsString));
		textEdit.addChild(new InsertEdit(Math.max(0, previousLineEnd), declaration.toString()));
		
		StringBuilder blockClosing = new StringBuilder();
		blockClosing.append(indentationUtil.getLineSeparator())
			.append(indentationUtil.indent(indentationLevel - 1))
			.append("}");
		textEdit.addChild(new InsertEdit(successorRegion.getOffset() + successorRegion.getLength(), blockClosing.toString()));
	}

 	protected String createInsertExpression(ITextRegion expressionRegion) throws BadLocationException {
		String expressionAsString = document.get(expressionRegion.getOffset(), expressionRegion.getLength());
		if(expression instanceof XClosure) {
			XClosure closure = (XClosure) expression;
			StringBuilder builder = new StringBuilder();
			if(expressionAsString.startsWith("[") && expressionAsString.endsWith("]")) {
				expressionAsString = expressionAsString.substring(1, expressionAsString.length()-1);
			} 
			builder.append("[");
			boolean isFirst = true;
			for(JvmFormalParameter parameter: closure.getFormalParameters()) {
				if(!isFirst)
					builder.append(", ");
				isFirst = false;
				builder
					.append(serializer.serialize(typeProvider.getTypeForIdentifiable(parameter), expression))
					.append(" ")
					.append(parameter.getIdentifier());
			}
			builder.append(" | ");
			if(!closure.getDeclaredFormalParameters().isEmpty())
				builder.append(expressionAsString.substring(expressionAsString.indexOf("|")+1));
			else 
				builder.append(expressionAsString);
			builder.append("]");
			return builder.toString();
		}
		return expressionAsString;
	}

	protected String createDeclarationString(String expressionAsString) {
		StringBuilder builder = new StringBuilder();
		if (isFinal)
			builder.append("val ");
		else
			builder.append("var ");
		builder.append(variableName).append(" = ").append(expressionAsString);
		return builder.toString();
	}
	
}
