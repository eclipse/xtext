/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.internal.corext.refactoring.ParameterInfo;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.refactoring.IndentationUtil;
import org.eclipse.xtext.xbase.ui.refactoring.NewFeatureNameUtil;
import org.eclipse.xtext.xbase.ui.refactoring.TypeSerializationUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExtractMethodRefactoring extends Refactoring {

	public static final Logger LOG = Logger.getLogger(ExtractMethodRefactoring.class);
	
	@Inject
	private Provider<StatusWrapper> statusProvider;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private TypeConformanceComputer typeConformance;
	
	@Inject
	private TypeSerializationUtil typeUtil;
	
	@Inject
	private ExpressionUtil expressionUtil;
	
	@Inject
	private NewFeatureNameUtil nameUtil;
	
	@Inject
	private IndentationUtil indentationUtil;

	
	private IDocument document;

	private List<XExpression> expressions;

	private String methodName = "";

	private JvmVisibility visibility;

	private boolean isStatic;
	
	private List<ParameterInfo> parameterInfos = newArrayList();
	
	private boolean isExplicitlyDeclareReturnType;

	
	private XExpression firstExpression;
	
	private XExpression lastExpression; 

	private URI resourceURI;

	private XtendClass xtendClass;

	private XtendFunction originalMethod;

	private MultiTextEdit textEdit;

	private List<String> localFeatureNames = newArrayList();

	private XExpression returnExpression;
	
	private JvmTypeReference returnType;
	

	public boolean initialize(IXtextDocument document, List<XExpression> expressions) {
		if(expressions.isEmpty() || document == null)
			return false;
		this.document = document;
		this.expressions = expressions;
		this.firstExpression = expressions.get(0);
		this.lastExpression = expressions.get(expressions.size()-1);
		this.resourceURI = EcoreUtil2.getNormalizedResourceURI(firstExpression);
		this.xtendClass = EcoreUtil2.getContainerOfType(firstExpression, XtendClass.class);
		this.originalMethod = EcoreUtil2.getContainerOfType(firstExpression, XtendFunction.class);
		if (xtendClass == null || originalMethod == null)
			return false;
		this.visibility = originalMethod.getVisibility();
		this.isStatic = originalMethod.isStatic();
		XExpression successorExpression = expressionUtil
				.findSuccessorExpressionForVariableDeclaration(lastExpression);
		nameUtil.setFeatureScopeContext(successorExpression);
		indentationUtil.initialize(document, resourceURI);
		return true;
	}

	@Override
	public String getName() {
		return "Extract Method Refactoring";
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public RefactoringStatus validateMethodName(String newMethodName) {
		RefactoringStatus status = new RefactoringStatus();
		nameUtil.checkNewFeatureName(newMethodName, true, status);
		return status;
	}

	public JvmVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(JvmVisibility visibility) {
		this.visibility = visibility;
	}

	public void setExplicitlyDeclareReturnType(boolean isExplicitlyDeclareReturnType) {
		this.isExplicitlyDeclareReturnType = isExplicitlyDeclareReturnType;
	}
	
	public boolean isExplicitlyDeclareReturnType() {
		return isExplicitlyDeclareReturnType;
	}

	public XtendClass getXtendClass() {
		return xtendClass;
	}

	public List<ParameterInfo> getParameterInfos() {
		return parameterInfos;
	}

	public RefactoringStatus validateParameters() {
		RefactoringStatus status = new RefactoringStatus();
		Set<String> namesSoFar = newHashSet();
		for (ParameterInfo parameterInfo : parameterInfos) {
			String newName = parameterInfo.getNewName();
			if (namesSoFar.contains(newName))
				status.addError("Duplicate parameter name '" + newName + "'");
			if (!equal(newName, parameterInfo.getOldName()) && localFeatureNames.contains(newName))
				status.addError("'" + newName + "' is already used as a name in the selected code");
			nameUtil.checkNewFeatureName(newName, false, status);
			namesSoFar.add(newName);
		}
		// TODO: vararg order
		return status;
	}

	public String getMethodSignature() {
		StringBuilder builder = new StringBuilder("def ");
		if (visibility != JvmVisibility.PUBLIC)
			builder.append(getVisibility().getName().toLowerCase()).append(" ");
		if (isStatic)
			builder.append("static ");
		if (isExplicitlyDeclareReturnType) {
			builder.append(typeUtil.serialize(returnType, firstExpression)).append(" ");
		}
		builder.append(methodName).append("(");
		boolean isFirst = true;
		for (ParameterInfo parameterInfo : getParameterInfos()) {
			if (!isFirst)
				builder.append(", ");
			isFirst = false;
			builder.append(parameterInfo.getOldTypeName()).append(" ").append(parameterInfo.getNewName());
		}
		builder.append(")");
		return builder.toString();
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		StatusWrapper status = statusProvider.get();
		try {
			Set<String> calledExternalFeatureNames = newHashSet();
			returnType = calculateReturnType();
			if (!equal("void", typeUtil.serialize(returnType, firstExpression)))
				returnExpression = lastExpression;
			boolean isReturnAllowed = isEndOfOriginalMethod(); 
			for (EObject element : EcoreUtil2.eAllContents(originalMethod.getExpression())) {
				boolean isLocalExpression = EcoreUtil.isAncestor(expressions, element);
				if (element instanceof XFeatureCall) {
					XFeatureCall featureCall = (XFeatureCall) element;
					JvmIdentifiableElement feature = featureCall.getFeature();
					JvmTypeReference featureType = typeProvider.getType(featureCall);
					boolean isLocalFeature = EcoreUtil.isAncestor(expressions, feature);
					if (!isLocalFeature && isLocalExpression) {
						// call-out
						if (!calledExternalFeatureNames.contains(feature.getSimpleName())) {
							if (feature instanceof JvmFormalParameter || feature instanceof XVariableDeclaration) {
								calledExternalFeatureNames.add(feature.getSimpleName());
								parameterInfos.add(
										new ParameterInfo(typeUtil.serialize(featureType, firstExpression), 
										feature.getSimpleName(), 
										parameterInfos.size()));
							}
						}
					} else if (isLocalFeature && !isLocalExpression) {
						// call-in
						if (returnExpression != null) {
							status.add(RefactoringStatus.FATAL,
									"Ambiguous return value: Multiple local variables are accesed in subsequent code.");
							break;
						}
						returnExpression = featureCall;
						returnType = featureType;
					}
				} else if(isLocalExpression) {
					if(element instanceof XReturnExpression && !isReturnAllowed) {
						status.add(RefactoringStatus.FATAL,
							"Extracting method would break control flow due to return statements.");
						break;
					} else if (element instanceof JvmFormalParameter)
						localFeatureNames.add(((JvmFormalParameter) element).getName());
					else if (element instanceof XVariableDeclaration)
						localFeatureNames.add(((XVariableDeclaration) element).getIdentifier());
				}
			}
		} catch (Exception exc) {
			handleException(exc, status);
		}
		return status.getRefactoringStatus();
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		StatusWrapper status = statusProvider.get();
		try {
			status.merge(validateMethodName(methodName));
			status.merge(validateParameters());
			
			ITextRegion expressionsRegion = getExpressionsRegion();
			textEdit = new MultiTextEdit();
			textEdit.addChild(createMethodCallEdit(expressionsRegion));
			textEdit.addChild(createMethodDeclarationEdit(expressionsRegion));
		} catch (Exception exc) {
			handleException(exc, status);
		}
		return status.getRefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		DocumentChange change = new DocumentChange("Extract Method", document);
		change.setEdit(textEdit);
		change.setTextType(resourceURI.fileExtension());
		return new DisplayChangeWrapper(change);
	}

	protected void handleException(Exception exc, StatusWrapper status) {
		status.add(FATAL, "Error during refactoring: {0}", exc, LOG);
	}

	protected JvmTypeReference calculateReturnType() {
		List<JvmTypeReference> returnTypes = newArrayList();
		for(XExpression expression: expressions) {
			returnTypes.add(typeProvider.getCommonReturnType(expression, expression == lastExpression));
		}		
		returnTypes.add(typeProvider.getType(lastExpression));
		return typeConformance.getCommonSuperType(returnTypes);
	}

	protected ITextRegion getExpressionsRegion() {
		ITextRegion firstRegion = locationInFileProvider.getFullTextRegion(firstExpression);
		ITextRegion lastRegion = locationInFileProvider.getFullTextRegion(lastExpression);
		ITextRegion expressionRegion = new TextRegion(firstRegion.getOffset(), lastRegion.getOffset()
				+ lastRegion.getLength() - firstRegion.getOffset());
		return expressionRegion;
	}

	protected TextEdit createMethodDeclarationEdit(ITextRegion expressionsRegion) throws BadLocationException {
		String expressionsAsString = document.get(expressionsRegion.getOffset(), expressionsRegion.getLength());
		if(expressions.size() == 1 
				&& firstExpression instanceof XClosure 
				&& (!expressionsAsString.startsWith("[") || !expressionsAsString.endsWith("]"))) {
			// legacy closure argument syntax
			expressionsAsString = "[" + expressionsAsString + "]";
		}
		ITextRegion predecessorRegion = locationInFileProvider.getFullTextRegion(originalMethod);
		int methodIndentLevel = indentationUtil.getIndentationLevelAtOffset(predecessorRegion.getOffset());
		int expressionIndentLevel = indentationUtil.getIndentationLevelAtOffset(
				locationInFileProvider.getFullTextRegion(firstExpression).getOffset());
		StringBuilder declaration = new StringBuilder()
				.append(indentationUtil.getLineSeparator())
				.append(indentationUtil.getLineSeparator())
				.append(indentationUtil.indent(methodIndentLevel))
				.append(getMethodSignature())
				.append(" {")
				.append(indentationUtil.getLineSeparator())
				.append(indentationUtil.indent(methodIndentLevel + 1))
				.append(expressionsAsString.replaceAll(
						Pattern.quote(indentationUtil.getLineSeparator()) + indentationUtil.indent(expressionIndentLevel),
						indentationUtil.getLineSeparator() + indentationUtil.indent(methodIndentLevel + 1)));
		if (isNeedsReturnExpression())
			declaration.append(indentationUtil.getLineSeparator()).append(indentationUtil.indent(methodIndentLevel + 1))
					.append(((XFeatureCall) returnExpression).getFeature().getSimpleName());
		declaration.append(indentationUtil.getLineSeparator()).append(indentationUtil.indent(methodIndentLevel))
				.append("}");

		return new InsertEdit(predecessorRegion.getOffset() + predecessorRegion.getLength(), declaration.toString());
	}

	protected ReplaceEdit createMethodCallEdit(ITextRegion expressionRegion) throws BadLocationException {
		StringBuilder builder = new StringBuilder();
		if (isNeedsReturnExpression()) {
			JvmIdentifiableElement returnFeature = ((XFeatureCall) returnExpression).getFeature();
			if (isFinalFeature(returnFeature))
				builder.append("val ");
			else
				builder.append("var ");
			builder.append(returnFeature.getSimpleName()).append(" = ");
		}
		boolean needsSurroundingParentheses = false;
		if(firstExpression.eContainer() instanceof XMemberFeatureCall) {
			if(((XMemberFeatureCall) firstExpression.eContainer()).getMemberCallArguments().size() == 1) {
				String expressionExpanded = document.get(expressionRegion.getOffset()-1, expressionRegion.getLength() + 2);
				if(!expressionExpanded.startsWith("(") || !expressionExpanded.endsWith(")")) {
					needsSurroundingParentheses = true;
					builder.append("(");
				}
			}
		}
		builder.append(methodName).append("(");
		boolean isFirst = true;
		for (ParameterInfo parameterInfo : getParameterInfos()) {
			if (!isFirst)
				builder.append(", ");
			isFirst = false;
			builder.append(parameterInfo.getOldName());
		}
		builder.append(")");
		if(needsSurroundingParentheses)
			builder.append(")");
		return new ReplaceEdit(expressionRegion.getOffset(), expressionRegion.getLength(), builder.toString());
	}

	protected boolean isEndOfOriginalMethod() {
		EObject eContainer = lastExpression.eContainer();
		if(eContainer instanceof XBlockExpression) {
			if(eContainer.eContainer() == originalMethod) {
				EList<XExpression> siblings = ((XBlockExpression)eContainer).getExpressions();
				return siblings.indexOf(lastExpression) == siblings.size()-1;
			}
		}
		return false;
	}

	protected boolean isNeedsReturnExpression() {
		return returnExpression != null && returnExpression != lastExpression;
	}

	protected boolean isFinalFeature(JvmIdentifiableElement returnFeature) {
		return returnFeature instanceof JvmFormalParameter
				|| (returnFeature instanceof XVariableDeclaration && !((XVariableDeclaration) returnFeature)
						.isWriteable());
	}
}
