/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.services.XtextResourceFactory;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class XtextMetamodelResource extends ResourceImpl {

	public XtextMetamodelResource(URI uri) {
		super(uri);
	}

	private Grammar getGrammar(String languageID) {
		IServiceScope serviceScope = ServiceScopeFactory.get(languageID);
		IGrammarAccess service = ServiceRegistry.getService(serviceScope, IGrammarAccess.class);
		return service.getGrammar();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.resource.impl.ResourceImpl#doLoad(java.io.InputStream
	 * , java.util.Map)
	 */
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		XtextResourceFactory xtextResourceFactory = new XtextResourceFactory();
		Resource xtextResource = xtextResourceFactory.createResource(getURI());
//		xtextResource.load(inputStream, options);
//		EList<EObject> grammarResourceContents = xtextResource.getContents();
//		if (grammarResourceContents.size() != 1) {
//			throw new IllegalStateException("XtextResource " + Strings.notNull(getURI().toString())
//					+ " contains other than 1 elements");
//		}
//		EObject firstObject = grammarResourceContents.get(0);
//		if (!(firstObject instanceof Grammar)) {
//			throw new IllegalStateException("XtextResource " + Strings.notNull(getURI().toString())
//					+ " does not contain a root element of type Grammar");
//		}
//		Grammar grammar = (Grammar) firstObject;
//		Xtext2EcoreTransformer xtext2EcoreTransformer = new Xtext2EcoreTransformer();
//		List<EPackage> ePackages = xtext2EcoreTransformer.transform(grammar);
//		getContents().addAll(ePackages);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doUnload()
	 */
	@Override
	protected void doUnload() {
		// TODO Auto-generated method stub
		super.doUnload();
	}
}
