/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
			if (rule instanceof ParserRule || rule instanceof EnumRule) {
				final TypeRef returnType = rule.getType();
				if(returnType == null || returnType.getClassifier() == null)
					return true;
				else if (rule.getName().equals(returnType.getClassifier().getName())) {
					return isTransient(returnType, XtextPackage.eINSTANCE.getTypeRef_Metamodel(), -1);
				} else if (GrammarUtil.isDatatypeRule(rule)) {
					return NodeModelUtils.getNode(returnType) == null;
				}
			} else if (rule instanceof TerminalRule) {
				final TypeRef returnType = rule.getType();
				return ((TerminalRule) rule).isFragment() || returnType == null || GrammarUtil.findEString(GrammarUtil.getGrammar(owner)).equals(rule.getType().getClassifier());
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
				Strings.equal(decl.getLiteral().getValue(), decl.getEnumLiteral().getName());
		}
		else if (feature == XtextPackage.eINSTANCE.getRuleCall_ExplicitlyCalled()) {
			return true;
		}
		else if (feature == XtextPackage.eINSTANCE.getNamedArgument_Parameter()) {
			return !((NamedArgument)owner).isCalledByName();
		}
		return super.isTransient(owner, feature, index);
	}

}
