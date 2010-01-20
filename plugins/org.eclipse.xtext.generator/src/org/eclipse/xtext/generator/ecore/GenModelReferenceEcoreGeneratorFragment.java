/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import org.apache.log4j.Logger;


/**
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @deprecated - Use {@link EcoreGeneratorFragment} instead.
 */
@Deprecated
public class GenModelReferenceEcoreGeneratorFragment extends EcoreGeneratorFragment {
	
	private final static Logger log = Logger.getLogger(GenModelReferenceEcoreGeneratorFragment.class);

	{
		log.warn("The fragment "+GenModelReferenceEcoreGeneratorFragment.class+" has been deprecated. Please use "+EcoreGeneratorFragment.class+" instead.");
	}
	/**
	 * Sets the URIs for the generated EMF generator models (aka genmodels).
	 * 
	 * @param uris
	 */
	public void setReferencedGenModel(String uris) {
		log.warn("the property 'referencedGenModel' is deprecated. Use 'genModel' instead.");
		super.setGenModel(uris);
	}
}
