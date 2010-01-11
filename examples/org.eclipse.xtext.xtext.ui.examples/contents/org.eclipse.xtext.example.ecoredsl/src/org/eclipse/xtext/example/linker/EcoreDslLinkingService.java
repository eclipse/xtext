/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.linker;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.example.ecoredsl.EcoredslPackage;
import org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslLinkingService extends DefaultLinkingService {

	private static Logger log = Logger.getLogger(EcoreDslLinkingService.class);

	@Inject
	private IValueConverterService valueConverterService;

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref,
			AbstractNode node) throws IllegalNodeException {
		if (ref == EcoredslPackage.eINSTANCE.getReferencedMetamodel_EPackage())
			return getPackage((ReferencedMetamodel) context, (LeafNode) node);
		return super.getLinkedObjects(context, ref, node);
	}

	private List<EObject> getPackage(ReferencedMetamodel context, LeafNode text) {
		String nsUri = getMetamodelNsURI(text);
		if (nsUri == null) {
			return Collections.emptyList();
		}
		EPackage ePackage = loadEPackage(nsUri, context.eResource().getResourceSet());
		if (ePackage != null) {
			return Collections.<EObject> singletonList(ePackage);
		}
		return Collections.emptyList();
	}

	private String getMetamodelNsURI(LeafNode text) {
		try {
			return (String) valueConverterService.toValue(text.getText(),
					linkingHelper.getRuleNameFrom(text.getGrammarElement()), text);
		} catch (ValueConverterException e) {
			log.debug("Exception on leaf '" + text.getText() + "'", e);
			return null;
		}
	}

	private EPackage loadEPackage(String resourceOrNsURI,
			ResourceSet resourceSet) {
		if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
			return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		try {
			URI uri = URI.createURI(resourceOrNsURI);
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				EPackage result = (EPackage) resource.getContents().get(0);
				return result;
			}
			return (EPackage) resourceSet.getEObject(uri, true);

		} catch (RuntimeException ex) {
			log.trace("Cannot load package with URI '" + resourceOrNsURI + "'",ex);
		}
		return null;
	}

}