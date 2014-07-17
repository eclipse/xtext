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
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.impl.EditorDocumentChange;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter.Section;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExtractVariableRefactoring extends Refactoring {

	public static final Logger LOG = Logger.getLogger(ExtractVariableRefactoring.class);

	@Inject
	private Provider<StatusWrapper> statusProvider;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject 
	private ExpressionUtil expressionUtil;
	
	@Inject 
	private NewFeatureNameUtil nameUtil;
	
	@Inject 
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private DocumentRewriter.Factory rewriterFactory;
	
	@Inject 
	private ReplaceConverter replaceConverter;
	
	private IXtextDocument document;

	private XExpression expression;

	private String variableName;

	private boolean isFinal = true;

	private URI resourceURI;

	private boolean isNeedsNewBlock;
	
	private XExpression successor;

	private DocumentRewriter rewriter;

	private XtextEditor editor;

	public boolean initialize(XtextEditor editor, XExpression expression) {
		this.editor = editor;
		this.document = editor.getDocument();
		this.expression = expression;
		resourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(expression).trimFragment();
		successor = expressionUtil.findSuccessorExpressionForVariableDeclaration(expression);
		if(successor == null)
			return false;
		isNeedsNewBlock = !(successor.eContainer() instanceof XBlockExpression);
		nameUtil.setFeatureScopeContext(successor);
		variableName = nameUtil.getDefaultName(expression);
		rewriter = rewriterFactory.create(document, (XtextResource) expression.eResource());
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
		return status.getRefactoringStatus();
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		StatusWrapper status = statusProvider.get();
		try {
			status.merge(validateNewVariableName(variableName));
			ITextRegion expressionRegion = locationInFileProvider.getFullTextRegion(expression);
			ITextRegion successorRegion = locationInFileProvider.getFullTextRegion(successor);
			
			Section callerSection = rewriter.newSection(expressionRegion.getOffset(), expressionRegion.getLength());
			if (pm.isCanceled()) {
				throw new OperationCanceledException();
			}
			if (isNeedsNewBlock) {
				IRegion lineInformation = document.getLineInformationOfOffset(successorRegion.getOffset());
				int previousLineEnd = lineInformation.getOffset() - rewriter.getLineSeparator().length();
				Section blockStartSection = getDeclarationSection(Math.max(0,  previousLineEnd), expressionRegion.getOffset(), callerSection);
				if(previousLineEnd > 0 && !Character.isWhitespace(document.getChar(previousLineEnd-1))) 
					blockStartSection.append(" ");
				blockStartSection.append("{").increaseIndentation().newLine();
				appendDeclaration(blockStartSection, expressionRegion);
				Section blockEndSection = rewriter.newSection(successorRegion.getOffset() + successorRegion.getLength(), 0);
				blockEndSection.decreaseIndentation().newLine().append("}");
			} else {
				Section declarationSection = getDeclarationSection(successorRegion.getOffset(), expressionRegion.getOffset(), callerSection);
				appendDeclaration(declarationSection, expressionRegion);
				declarationSection.newLine();
			}
			if (pm.isCanceled()) {
				throw new OperationCanceledException();
			}
			String callerText = variableName;
			// handle closure shortcut syntaxes
			if(expression.eContainer() instanceof XMemberFeatureCall) {
				if(((XMemberFeatureCall) expression.eContainer()).getMemberCallArguments().size() == 1) {
					String expressionExpanded = document.get(expressionRegion.getOffset()-1, expressionRegion.getLength() + 2);
					if(!expressionExpanded.startsWith("(") || !expressionExpanded.endsWith(")")) 
						callerText = "(" + callerText + ")";
				}
			}
			callerSection.append(callerText);
		} catch (OperationCanceledException e) {
			throw e;
		} catch (Exception exc) {
			handleException(exc, status);
		}
		return status.getRefactoringStatus();
	}

	protected Section getDeclarationSection(int declarationOffset, int callerOffset, Section callerSection) {
		if(callerOffset == declarationOffset) {
			return callerSection;
		} else {
			return rewriter.newSection(declarationOffset, 0);
		}
	}
	
	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		TextEdit textEdit = replaceConverter.convertToTextEdit(rewriter.getChanges());
		EditorDocumentChange change = new EditorDocumentChange("Extract local variable", editor, false);
		change.setEdit(textEdit);
		change.setTextType(resourceURI.fileExtension());
		return change;
	}

	protected void handleException(Exception exc, StatusWrapper status) {
		status.add(FATAL, "Error during refactoring: {0}", exc, LOG);
	}

	protected void appendDeclaration(ISourceAppender section, ITextRegion expressionRegion) throws BadLocationException {
		section
			.append((isFinal) ? "val" : "var")
			.append(" ")
			.append(variableName)
			.append(" = ");
		String expressionAsString = document.get(expressionRegion.getOffset(), expressionRegion.getLength());
		if(expression instanceof XClosure) {
			XClosure closure = (XClosure) expression;
			if(expressionAsString.startsWith("[") && expressionAsString.endsWith("]")) {
				expressionAsString = expressionAsString.substring(1, expressionAsString.length()-1);
			} 
			section.append("[");
			boolean isFirst = true;
			if(!closure.getFormalParameters().isEmpty()) {
				IResolvedTypes types = typeResolver.resolveTypes(closure);
				for(JvmFormalParameter parameter: closure.getFormalParameters()) {
					if(!isFirst)
						section.append(", ");
					isFirst = false;
					LightweightTypeReference parameterType = types.getActualType(parameter);
					section.append(parameterType);
					section
						.append(" ")
						.append(parameter.getIdentifier());
				}
			}
			section.append(" | ");
			if(!closure.getDeclaredFormalParameters().isEmpty())
				section.append(expressionAsString.substring(expressionAsString.indexOf("|")+1));
			else 
				section.append(expressionAsString);
			section.append("]");
		} else {
			section.append(expressionAsString);
		}
	}
	
}
