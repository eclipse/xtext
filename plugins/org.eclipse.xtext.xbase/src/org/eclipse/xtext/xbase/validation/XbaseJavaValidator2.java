/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

import com.google.inject.Inject;

/**
 * Xbase Validator that does use the scope provider. It basically disables all call-outs to the scope and some
 * validations that will be superseded by immediate error annotations during type resolution.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseJavaValidator2 extends XbaseJavaValidator {
	
	@Override
	@Check
	public void checkImplicitReturn(XExpression expr) {
		// disabled for now
	}
	
	@Override
	protected void checkDeclaredVariableName(EObject nameDeclarator, EObject attributeHolder, EAttribute attr) {
		if (nameDeclarator.eContainer() == null)
			return;
		if (attr.getEContainingClass().isInstance(attributeHolder)) {
			String name = (String) attributeHolder.eGet(attr);
			// shadowing 'it' is allowed
			if (name == null || equal(name, IFeatureNames.IT.toString()))
				return;
			if (getDisallowedVariableNames().contains(name)) {
				error("'" + name + "' is not a valid name.", attributeHolder, attr, -1,
						IssueCodes.VARIABLE_NAME_SHADOWING);
				return;
			}
			// temporarily disabled
//			int idx = 0;
//			if (nameDeclarator.eContainer() instanceof XBlockExpression) {
//				idx = ((XBlockExpression) nameDeclarator.eContainer()).getExpressions().indexOf(nameDeclarator);
//			}
//			IScope scope = getScopeProvider().createSimpleFeatureCallScope(nameDeclarator.eContainer(),
//					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, nameDeclarator.eResource(), true, idx);
//			Iterable<IEObjectDescription> elements = scope.getElements(QualifiedName.create(name));
//			for (IEObjectDescription desc : elements) {
//				if (desc.getEObjectOrProxy() != nameDeclarator && !(desc.getEObjectOrProxy() instanceof JvmFeature)) {
//					error("Duplicate variable name '" + name + "'", attributeHolder, attr,
//							IssueCodes.VARIABLE_NAME_SHADOWING);
//				}
//			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected org.eclipse.xtext.xbase.scoping.XbaseScopeProvider getScopeProvider() {
		throw new UnsupportedOperationException();
	}
}