/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.crossref.impl.SimpleAttributeResolver;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkingService;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinkingService extends XtextBuiltinLinkingService {

	private final SimpleAttributeResolver<String> aliasResolver;
	
	public XtextLinkingService() {
		super();
		aliasResolver = SimpleAttributeResolver.newResolver(String.class, "alias");
	}
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, LeafNode text) {
		if (ref == XtextPackage.eINSTANCE.getTypeRef_Metamodel())
			return getLinkedMetaModel((TypeRef)context, ref, text);
		return super.getLinkedObjects(context, ref, text);
	}
	
	private List<EObject> getLinkedMetaModel(TypeRef context, EReference ref, LeafNode text) {
		final CompositeNode parentNode = text.getParent();
		for(int i = parentNode.getChildren().size() - 1; i >= 0; i-- ) {
			AbstractNode child = parentNode.getChildren().get(i);
			if (child instanceof LeafNode) {
				LeafNode leaf = (LeafNode) child;
				if (text == leaf)
					return super.getLinkedObjects(context, ref, text);
				if (!(leaf.getGrammarElement() instanceof Keyword) && !leaf.isHidden()) {
					return XtextMetamodelReferenceHelper.findBestMetamodelForType(
							context, ref, text.getText(), leaf.getText(), getObjectsInScope(context, ref));
				}
			}				
		}
		return Collections.emptyList();
	}
	
	@Override
	public String getLinkText(EObject object, EReference reference, EObject context) {
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Metamodel())
			return aliasResolver.getValue(object);
		return super.getLinkText(object, reference, context);
	}
	
}
