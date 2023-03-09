/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.CompletionDataAcceptor;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.VariableType;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NewFeatureNameUtil {
	
	@Inject
	private IValueConverterService valueConverterService;

	@Inject
	private IBatchTypeResolver batchTypeResolver;

	@Inject 
	private JdtVariableCompletions jdtVariableCompletions;
	
	private Set<String> allKeywords;
	
	private IScope featureCallScope;
	

	@Inject
	public NewFeatureNameUtil(IGrammarAccess grammarAccess) {
		allKeywords = GrammarUtil.getAllKeywords(grammarAccess.getGrammar());
	}
	
	public void setFeatureScopeContext(XExpression siblingExpression) {
		XBlockExpression containerBlock = 
				(siblingExpression.eContainer() instanceof XBlockExpression) 
				? (XBlockExpression) siblingExpression.eContainer() 
				: null;
		EObject context = siblingExpression;
		if (containerBlock != null && !containerBlock.getExpressions().isEmpty()) {
			context = containerBlock.getExpressions().get(containerBlock.getExpressions().size() - 1);
		}
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(context).getExpressionScope(context, IExpressionScope.Anchor.AFTER);
		featureCallScope = expressionScope.getFeatureScope();
	}

	public void checkNewFeatureName(String newFeatureName, boolean isLookupInScope, RefactoringStatus status) {
		if (isEmpty(newFeatureName)) { 
			status.addFatalError("Choose a name");
			return;
		}
		try {
			Object value = valueConverterService.toValue(newFeatureName, "ValidID", null);
			valueConverterService.toString(value, "ValidID");
		} catch(ValueConverterException exc) {
			status.addFatalError(exc.getMessage());
		}
		if (Character.isUpperCase(newFeatureName.charAt(0))) 
			status.addError("Discouraged name '" + newFeatureName + "'. Name should start with a lowercase letter. ");
		if (isKeyword(newFeatureName)) 
			status.addFatalError("'" + newFeatureName + "' is keyword.");
		@SuppressWarnings("restriction")
		Class<?> asPrimitive = org.eclipse.xtext.common.types.access.impl.Primitives.forName(newFeatureName);
		if(asPrimitive != null) 
			status.addFatalError("'" + newFeatureName + "' is reserved.");
		if (isLookupInScope && featureCallScope != null && isAlreadyDefined(newFeatureName)) 
			status.addError("The name '" + newFeatureName + "' is already defined in this scope.");
	}

	protected boolean isKeyword(String newFeatureName) {
		return allKeywords.contains(newFeatureName);
	}

	protected boolean isAlreadyDefined(String newFeatureName) {
		IEObjectDescription existing = featureCallScope.getSingleElement(QualifiedName.create(newFeatureName));
		return existing != null;
	}

	public String getDefaultName(XExpression expression) {
		String baseName = getBaseName(expression);
		final List<String> candidates = newArrayList();
		Set<String> excludedNames = new HashSet<String>(allKeywords); 
		for(IEObjectDescription featureDescription: featureCallScope.getAllElements()) {
			QualifiedName featureQName = featureDescription.getQualifiedName();
			if(featureQName.getSegmentCount() == 1)
				excludedNames.add(featureQName.getLastSegment());
		}
		jdtVariableCompletions.getVariableProposals(baseName, expression, VariableType.LOCAL_VAR, excludedNames, new CompletionDataAcceptor() {
			@Override
			public void accept(String replaceText, StyledString label, Image img) {
				candidates.add(replaceText);
			}
		});
		return candidates.isEmpty() ? "dingenskirchen" : candidates.get(0);
	}
	
	protected String getBaseName(XExpression expression) {
		if (expression instanceof XMemberFeatureCall || expression instanceof XFeatureCall) {
			String featureName = ((XAbstractFeatureCall) expression).getFeature().getSimpleName();
			if (featureName.startsWith("get"))
				return featureName.substring(3);
			else if (featureName.startsWith("is"))
				return featureName.substring(2);
			else
				return featureName;
		}
		if(expression instanceof XClosure)
			return "function";
		LightweightTypeReference type = batchTypeResolver.resolveTypes(expression).getActualType(expression);
		if (type != null) 
			return type.getSimpleName();
		return "";
	}
}
