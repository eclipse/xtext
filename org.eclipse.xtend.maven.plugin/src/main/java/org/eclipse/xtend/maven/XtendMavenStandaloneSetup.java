/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.XtendStandaloneSetupGenerated;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class XtendMavenStandaloneSetup implements ISetup {

	private static Injector injector = null;

	public Injector createInjectorAndDoEMFRegistration() {
		if (injector != null)
			return injector;
		XbaseWithAnnotationsStandaloneSetup.doSetup();
		EPackage.Registry.INSTANCE.put(XtendPackage.eINSTANCE.getNsURI(), XtendPackage.eINSTANCE);
		injector = Guice.createInjector(new XtendMavenModule());
		new XtendStandaloneSetupGenerated().register(injector);
		return injector;
	}

}
