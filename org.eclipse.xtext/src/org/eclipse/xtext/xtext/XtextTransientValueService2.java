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

import static org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient.*;

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
import org.eclipse.xtext.serializer.sequencer.TransientValueService;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class XtextTransientValueService2 extends TransientValueService {

	@Override
	public ValueTransient isValueTransient(EObject owner, EStructuralFeature feature) {
		if (feature == XtextPackage.eINSTANCE.getTypeRef_Metamodel()) {
			final TypeRef typeRef = (TypeRef) owner;
			final AbstractMetamodelDeclaration m = typeRef.getMetamodel();
			if (m == null || Strings.isEmpty(m.getAlias()))
				return YES;
		} else if (feature == XtextPackage.eINSTANCE.getAbstractRule_Type()) {
			final AbstractRule rule = (AbstractRule) owner;
			if (!GrammarUtil.isDatatypeRule(rule) && (rule instanceof ParserRule || rule instanceof EnumRule)) {
				final TypeRef returnType = rule.getType();
				if (returnType == null || returnType.getClassifier() == null)
					return YES;
				else if (rule.getName().equals(returnType.getClassifier().getName())) {
					if (isValueTransient(returnType, XtextPackage.eINSTANCE.getTypeRef_Metamodel()) == YES)
						return PREFERABLY;
					else
						return NO;
				} else if (GrammarUtil.isDatatypeRule(rule)) {
					return NodeModelUtils.getNode(returnType) == null ? YES : NO;
				}
			} else if (rule instanceof TerminalRule || GrammarUtil.isDatatypeRule(rule)) {
				final TypeRef returnType = rule.getType();
				if (returnType == null)
					return YES;
				if (rule instanceof TerminalRule) {
					if (((TerminalRule) rule).isFragment()) {
						return YES;
					}
				}
				if (GrammarUtil.findEString(GrammarUtil.getGrammar(owner)).equals(rule.getType().getClassifier()))
					return PREFERABLY;
				return NO;
			}
		} else if (feature == XtextPackage.eINSTANCE.getCrossReference_Terminal()) {
			final CrossReference ref = (CrossReference) owner;
			if (ref.getTerminal() instanceof RuleCall && ((RuleCall) ref.getTerminal()).getRule() != null) {
				if ("ID".equals(((RuleCall) ref.getTerminal()).getRule().getName()))
					return PREFERABLY;
				else
					return NO;
			}
			return YES;
		} else if (feature == XtextPackage.eINSTANCE.getEnumLiteralDeclaration_Literal()) {
			final EnumLiteralDeclaration decl = (EnumLiteralDeclaration) owner;
			if (decl.getEnumLiteral() != null && decl.getLiteral() != null) {
				if (Strings.equal(decl.getLiteral().getValue(), decl.getEnumLiteral().getName()))
					return PREFERABLY;
				return NO;
			}
			return YES;
		} else if (feature == XtextPackage.eINSTANCE.getRuleCall_ExplicitlyCalled()) {
			return YES;
		} else if (feature == XtextPackage.eINSTANCE.getNamedArgument_Parameter()) {
			if (((NamedArgument)owner).isCalledByName()) {
				return NO;
			}
			return YES;
		}
		return super.isValueTransient(owner, feature);
	}
}
