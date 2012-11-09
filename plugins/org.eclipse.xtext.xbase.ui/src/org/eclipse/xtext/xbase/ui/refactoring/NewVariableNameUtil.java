/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static com.google.common.collect.Iterables.*;

import java.util.Set;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
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
public class NewVariableNameUtil {
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject 
	private Primitives primitives;
	
	@Inject
	private XbaseScopeProvider scopeProvider;
	
	@Inject
	private IGrammarAccess grammarAccess;

	private Set<String> allKeywords;

	private IScope featureCallScope;
	
	public void initialize(XExpression expression, XBlockExpression block) {
		allKeywords = GrammarUtil.getAllKeywords(grammarAccess.getGrammar());
		// TODO: what is the non-deprecated way of achieving this?
		featureCallScope = scopeProvider.createSimpleFeatureCallScope(block, 
				XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 
				expression.eResource(), 
				true, 
				(block != null) ? block.getExpressions().size() : 0);
		
	}
	
	public void checkNewVariable(String newVariableName, 
			XExpression successor, XBlockExpression block, 
			RefactoringStatus status) {
		if(isKeyword(newVariableName)) {
			status.addError("'" + newVariableName + "' is keyword.");
			return;
		}
		if(isAlreadyDefined(newVariableName)) {
			status.addError("The name '" + newVariableName + "' is already defined in this scope.");
		}
	}

	protected boolean isKeyword(String newVariableName) {
		return allKeywords.contains(newVariableName);
	}
	
	protected boolean isAlreadyDefined(String newVariableName) {
		Iterable<IEObjectDescription> elements = featureCallScope.getElements(QualifiedName.create(newVariableName));
		return !isEmpty(elements);
	}

	public String getDefaultName(XExpression expression) {
		String defaultName = getFancyDefaultName(expression);
		String currentName = defaultName;
		int count = 0;
		for(;;) {
			if(!isKeyword(currentName) && !isAlreadyDefined(currentName)) 
				return currentName;
			currentName = defaultName + ++count;
		}
	}
	
	protected String getFancyDefaultName(XExpression expression) {
		if(expression instanceof XMemberFeatureCall || expression instanceof XFeatureCall) {
			String featureName = ((XAbstractFeatureCall) expression).getFeature().getSimpleName();
			if(featureName.startsWith("get")) 
				return toVariableName(featureName.substring(3));
			else
				return toVariableName(featureName);
		}
		JvmTypeReference type = typeProvider.getType(expression);
		if(type != null) {
			if(primitives.isPrimitive(type)) 
				return type.getSimpleName().substring(0, 1);
			else
				return toVariableName(type.getSimpleName());
		}
		return "";
	}
	
	protected String toVariableName(String name) {
		if(name.toUpperCase().equals(name)) {
			StringBuilder camelCaseBuilder = new StringBuilder();
			boolean isFirst = true;
			for(String fragment: name.toLowerCase().split("_")) {
				camelCaseBuilder.append(isFirst ? fragment : StringExtensions.toFirstUpper(fragment));
				isFirst = false;
			}
			return camelCaseBuilder.toString();
		}
		return StringExtensions.toFirstLower(name);
	}

}
