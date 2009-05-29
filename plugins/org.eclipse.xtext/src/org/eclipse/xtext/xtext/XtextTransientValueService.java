/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class XtextTransientValueService extends DefaultTransientValueService {

	@Override
	public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
		if (feature == XtextPackage.eINSTANCE.getTypeRef_Metamodel()) {
			final TypeRef typeRef = (TypeRef) owner;
			final AbstractMetamodelDeclaration m = typeRef.getMetamodel();
			if (m == null || Strings.isEmpty(m.getAlias()))
				return true;
		}
		else if (feature == XtextPackage.eINSTANCE.getAbstractRule_Type()) {
			final AbstractRule rule = (AbstractRule) owner;
			if (rule instanceof ParserRule) {
				final TypeRef returnType = rule.getType();
				if(returnType.getClassifier() == null)
					return true;
				else if (rule.getName().equals(returnType.getClassifier().getName())) {
					return isTransient(returnType, XtextPackage.eINSTANCE.getTypeRef_Metamodel(), -1);
				}
			} else if (rule instanceof TerminalRule) {
				final TypeRef returnType = rule.getType();
				return returnType == null || EcorePackage.eINSTANCE.getEString().equals(rule.getType().getClassifier());
			}
		}
		else if (feature == XtextPackage.eINSTANCE.getCrossReference_Terminal()) {
			final CrossReference ref = (CrossReference) owner;
			if (ref.getTerminal() instanceof RuleCall && ((RuleCall) ref.getTerminal()).getRule() != null &&
					"ID".equals(((RuleCall) ref.getTerminal()).getRule().getName()))
				return true;
		}
		else if (feature == XtextPackage.eINSTANCE.getEnumLiteralDeclaration_Literal()) {
			final EnumLiteralDeclaration decl = (EnumLiteralDeclaration) owner;
			return decl.getEnumLiteral() != null && decl.getLiteral() != null &&
				Strings.equal(decl.getLiteral().getValue(), decl.getEnumLiteral().getLiteral());
		}
		return super.isTransient(owner, feature, index);
	}

}
