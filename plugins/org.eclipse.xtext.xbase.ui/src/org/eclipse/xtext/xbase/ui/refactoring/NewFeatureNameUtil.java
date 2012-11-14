/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Set;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
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
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NewFeatureNameUtil {
	
	@Inject
	private XbaseScopeProvider scopeProvider;
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private IValueConverterService valueConverterService;
	
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
		featureCallScope = scopeProvider.createSimpleFeatureCallScope(
				siblingExpression.eContainer(), 
				XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 
				siblingExpression.eResource(), 
				true,
				(containerBlock != null) ? containerBlock.getExpressions().size() : 0);
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
		if(org.eclipse.xtext.common.types.access.impl.Primitives.forName(newFeatureName) != null) 
			status.addFatalError("'" + newFeatureName + "' is reserved.");
		if (isLookupInScope && featureCallScope != null && isAlreadyDefined(newFeatureName)) 
			status.addError("The name '" + newFeatureName + "' is already defined in this scope.");
		
	}

	protected boolean isKeyword(String newFeatureName) {
		return allKeywords.contains(newFeatureName);
	}

	protected boolean isAlreadyDefined(String newFetaureName) {
		Iterable<IEObjectDescription> elements = featureCallScope.getElements(QualifiedName.create(newFetaureName));
		return !isEmpty(elements);
	}

	public String getDefaultName(XExpression expression) {
		String defaultName = getFancyDefaultName(expression);
		String currentName = defaultName;
		int count = 0;
		for (;;) {
			if (!isKeyword(currentName) && !isAlreadyDefined(currentName))
				return currentName;
			currentName = defaultName + ++count;
		}
	}

	protected String getFancyDefaultName(XExpression expression) {
		if (expression instanceof XMemberFeatureCall || expression instanceof XFeatureCall) {
			String featureName = ((XAbstractFeatureCall) expression).getFeature().getSimpleName();
			if (featureName.startsWith("get"))
				return toVariableName(featureName.substring(3));
			else
				return toVariableName(featureName);
		}
		if(expression instanceof XClosure)
			return "function";
		JvmTypeReference type = typeProvider.getType(expression);
		if (type != null) {
			if (primitives.isPrimitive(type))
				return type.getSimpleName().substring(0, 1);
			else
				return toVariableName(type.getSimpleName());
		}
		return "";
	}

	protected String toVariableName(String name) {
		if (name.toUpperCase().equals(name)) {
			StringBuilder camelCaseBuilder = new StringBuilder();
			boolean isFirst = true;
			for (String fragment : name.toLowerCase().split("_")) {
				camelCaseBuilder.append(isFirst ? fragment : StringExtensions.toFirstUpper(fragment));
				isFirst = false;
			}
			return camelCaseBuilder.toString();
		}
		return StringExtensions.toFirstLower(name);
	}

}
