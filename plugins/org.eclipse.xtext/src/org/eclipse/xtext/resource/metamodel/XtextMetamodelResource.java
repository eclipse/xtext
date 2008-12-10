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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.services.XtextResourceFactory;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class XtextMetamodelResource extends ResourceImpl {

	public XtextMetamodelResource(URI uri) {
		super(uri);
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
		if (getResourceSet() == null || !(getResourceSet() instanceof XtextResourceSet))
			throw new IllegalStateException("XtextResource " + Strings.notNull(getURI().toString())
					+ " must must be contained in a XtextResourceSet");
		
		XtextResourceSet containerResourceSet = (XtextResourceSet) this.getResourceSet();
		XtextResourceSet rs = new XtextResourceSet();
		rs.setClasspathURIContext(containerResourceSet.getClasspathURIContext());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(getURI().fileExtension(),
				new XtextResourceFactory());

		Resource xtextResource = rs.getResource(getURI(), true);
		xtextResource.load(inputStream, options);

		EList<EObject> grammarResourceContents = xtextResource.getContents();
		if (grammarResourceContents.size() != 1) {
			throw new IllegalStateException("XtextResource " + Strings.notNull(getURI().toString())
					+ " contains other than 1 element");
		}
		EObject firstObject = grammarResourceContents.get(0);
		if (!(firstObject instanceof Grammar)) {
			throw new IllegalStateException("XtextResource " + Strings.notNull(getURI().toString())
					+ " does not contain a root element of type Grammar");
		}
		Grammar grammar = (Grammar) firstObject;
		List<EPackage> ePackages = Xtext2EcoreTransformer.doGetGeneratedPackages(grammar);
		getContents().addAll(ePackages);
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
