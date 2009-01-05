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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.impl.SimpleAttributeResolver;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkingService;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinkingService extends XtextBuiltinLinkingService {

	private static Logger log = Logger.getLogger(XtextLinkingService.class);
	
	private final SimpleAttributeResolver<String> aliasResolver;
	
	@Inject
	private IValueConverterService valueConverterService;
	
	public XtextLinkingService() {
		super();
		aliasResolver = SimpleAttributeResolver.newResolver(String.class, "alias");
	}
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, LeafNode text) {
		if (ref == XtextPackage.eINSTANCE.getTypeRef_Metamodel())
			return getLinkedMetaModel((TypeRef)context, ref, text);
		if (ref == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage() && context instanceof GeneratedMetamodel)
			return createPackage((GeneratedMetamodel) context, text);
		if (ref == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage() && context instanceof ReferencedMetamodel)
			return getPackage((ReferencedMetamodel)context, text);
		return super.getLinkedObjects(context, ref, text);
	}
	
	/**
	 * @param context
	 * @param text
	 * @return
	 */
	private List<EObject> getPackage(ReferencedMetamodel context, LeafNode text) {
		EPackage pack = loadEPackage(
				getMetamodelNsURI(text), 
				context.eResource().getResourceSet());
		if (pack != null)
			return Collections.<EObject>singletonList(pack);
		return Collections.emptyList();
	}
	
	private String getMetamodelNsURI(LeafNode text) {
		return (String) valueConverterService.toValue(text.getText(),
				((CrossReference)text.getGrammarElement()).getRule().getName(), text);
	}
	
	EPackage loadEPackage(String resourceOrNsURI, ResourceSet resourceSet) {
		if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
			return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		try {
			URI uri = URI.createURI(resourceOrNsURI);
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				return (EPackage) resource.getContents().get(0);
			}
			else {
				return (EPackage) resourceSet.getEObject(uri, true);
			}
		} catch(RuntimeException ex) {
			log.trace("Cannot load package with URI '" + resourceOrNsURI + "'", ex);
			return null;
		}
	}

	private List<EObject> createPackage(GeneratedMetamodel generatedMetamodel, LeafNode text) {
		final String nsURI = getMetamodelNsURI(text);
		final URI uri = URI.createURI(nsURI);
		if (uri == null || isReferencedBySupergrammar(generatedMetamodel, nsURI))
			return Collections.emptyList();
		final EPackage generatedEPackage = EcoreFactory.eINSTANCE.createEPackage();
		generatedEPackage.setName(generatedMetamodel.getName());
		generatedEPackage.setNsPrefix(generatedMetamodel.getName());
		generatedEPackage.setNsURI(nsURI);
		final Resource generatedPackageResource = new XMIResourceFactoryImpl().createResource(uri);
		generatedMetamodel.eResource().getResourceSet().getResources().add(generatedPackageResource);
		generatedPackageResource.getContents().add(generatedEPackage);
		return Collections.<EObject>singletonList(generatedEPackage);
	}

	private boolean isReferencedBySupergrammar(GeneratedMetamodel generatedMetamodel, String nsURI) {
		final Grammar g = GrammarUtil.getGrammar(generatedMetamodel);
		try {
			Grammar superGrammar = GrammarUtil.getSuperGrammar(g);
			while(superGrammar != null) {
				for(AbstractMetamodelDeclaration decl: superGrammar.getMetamodelDeclarations()) {
					EPackage pack = decl.getEPackage();
					if (pack != null && nsURI.equals(pack.getNsURI())) {
						return true;
					}
				}
				superGrammar = GrammarUtil.getSuperGrammar(superGrammar);
			}
		} catch(IllegalArgumentException ex) {
			log.trace(ex.getMessage(), ex);
		}
		return false;
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
							context, text.getText(), leaf.getText(), getObjectsInScope(context, ref));
				}
			}				
		}
		return Collections.emptyList();
	}
	
	@Override
	public String getLinkText(EObject object, EReference reference, EObject context) {
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Metamodel())
			return aliasResolver.getValue(object);
		if (reference == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage())
			// TODO use value converter that produces double quotes
			return '"' + ((EPackage) object).getNsURI() + '"';
		return super.getLinkText(object, reference, context);
	}
	
}
