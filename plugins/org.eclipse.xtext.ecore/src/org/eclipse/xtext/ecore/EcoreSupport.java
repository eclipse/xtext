/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 
 * This class is intended to be used from an MWE workflow.
 * 
 * It instantiates and registers the Ecore support for Xtext, which allows for referencing ecore models from any Xtext
 * language.
 * 
 * Usage:  
 * 
 * <pre>
 *    component = org.eclipse.xtext.ecore.EcoreSupport{}
 * </pre>
 * 
 * If you want to provide a different guice guiceModule than the default one ({@link EcoreRuntimeModule}) in order to
 * change any implementation classes, you can make use of the property guiceModule. E.g. :
 * 
 * <pre>
 *    component = org.eclipse.xtext.ecore.EcoreSupport{
 *       guiceModule = my.special.CustomizedEcoreRuntimeModule {}
 *    }
 * </pre>
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreSupport extends AbstractGenericResourceSupport implements ISetup {

	@Override
	protected Module createGuiceModule() {
		return new EcoreRuntimeModule();
	}

	/**
	 * @since 2.5
	 */
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = Guice.createInjector(getGuiceModule());
		injector.injectMembers(this);
		registerInRegistry(false);
		return injector;
	}

}
