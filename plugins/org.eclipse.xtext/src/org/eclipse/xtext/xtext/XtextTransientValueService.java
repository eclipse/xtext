/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class XtextTransientValueService extends SimpleTransientValueService {

	public boolean isTransient(EObject owner, EStructuralFeature feature,
			int index) {
		if (feature == XtextPackage.eINSTANCE.getTypeRef_Metamodel()) {
			final TypeRef typeRef = (TypeRef) owner;
			final AbstractMetamodelDeclaration m = typeRef.getMetamodel();
			if (m == null || m.getAlias() == null || m.getAlias().equals(""))
				return true;
			if (typeRef.getType() != null) {
				final Grammar g = (Grammar) typeRef.eResource().getContents().get(0);
				final EClassifier lookupType = findEClassByName(g, typeRef.getType().getName());
				if (lookupType == typeRef.getType())
					return true;
			}
		}
		else if (feature == XtextPackage.eINSTANCE.getAbstractRule_Type()) {
			final AbstractRule rule = (AbstractRule) owner;
			if (rule instanceof ParserRule) {
				final TypeRef returnType = rule.getType();
				if (returnType.getType() != null && rule.getName().equals(returnType.getType().getName())) {
					return isTransient(returnType, XtextPackage.eINSTANCE.getTypeRef_Metamodel(), -1);
				}
			} else if (rule instanceof LexerRule) {
				final TypeRef returnType = rule.getType();
				return returnType == null || EcorePackage.eINSTANCE.getEString().equals(rule.getType().getType());
			}
		}
		return super.isTransient(owner, feature, index);
	}
	
	private EClass findEClassByName(Grammar grammar, String fullTypeName) {
		final String[] splitted = fullTypeName.split("::");
		String alias = "";
		String type = fullTypeName;
		if (splitted.length > 1) {
			alias = splitted[0];
			type = splitted[1];
		}
		final List<AbstractMetamodelDeclaration> declarations = GrammarUtil.allMetamodelDeclarations(grammar);
		AbstractMetamodelDeclaration resultMetaModel = null;
		EClassifier result = null;
		for (AbstractMetamodelDeclaration decl : declarations) {
			if (Strings.isEmpty(alias) || GrammarUtil.isSameAlias(decl.getAlias(), alias)) {
				EPackage pack = getEPackage(decl);
				if (pack != null) {
					EClassifier candidate = pack.getEClassifier(type);
					if (candidate != null) {
						if (resultMetaModel == null) {
							resultMetaModel = decl;
							result = candidate;
						} else {
							if (GrammarUtil.isSameAlias(resultMetaModel.getAlias(), alias)) {
								if (GrammarUtil.isSameAlias(decl.getAlias(), alias)) {
									return null;
								}
							} else {
								if (GrammarUtil.isSameAlias(decl.getAlias(), alias)) {
									resultMetaModel = decl;
									result = candidate;
								} else {
									result = null;
								}
							}
						}
					}
				}
			}
		}
		if (!(result instanceof EClass))
			return null;
		return (EClass) result;
	}
	
	protected EPackage getEPackage(AbstractMetamodelDeclaration metaModelDecl) {
		if (metaModelDecl instanceof GeneratedMetamodel) {
			final ResourceSet resourceSet = metaModelDecl.eResource().getResourceSet();
			for(Resource r: resourceSet.getResources()) {
				for(EObject content: r.getContents()) {
					if (content instanceof EPackage) {
						EPackage pack = (EPackage) content;
						if (pack.getNsURI().equals(((GeneratedMetamodel) metaModelDecl).getNsURI())) {
							return pack;
						}
					}
				}
			}
			return null;
		} else {
			final ReferencedMetamodel mm = (ReferencedMetamodel) metaModelDecl;
			return EcoreUtil2.loadEPackage(mm.getUri(), getClass().getClassLoader());
		}
	}

}
