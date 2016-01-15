/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.TypesPackage;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectStandaloneSetup extends XpectStandaloneSetupGenerated {

	public static void doSetup() {
		new XpectStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		if (!EPackage.Registry.INSTANCE.containsKey(TypesPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, TypesPackage.eINSTANCE);
		if (!EPackage.Registry.INSTANCE.containsKey(XpectJavaModelPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(XpectJavaModelPackage.eNS_URI, XpectJavaModelPackage.eINSTANCE);
		if (!EPackage.Registry.INSTANCE.containsKey(XpectPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(XpectPackage.eNS_URI, XpectPackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}

	@Override
	public void register(Injector injector) {
		super.register(injector);
	}
}
