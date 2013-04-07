/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.util;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.util.Pair;
import org.xpect.Environment;
import org.xpect.XpectFile;
import org.xpect.XpectJavaModel;
import org.xpect.XpectTest;
import org.xpect.XtRuntimeModule;
import org.xpect.registry.ILanguageInfo;
import org.xpect.setup.IXpectGuiceModuleSetup;
import org.xpect.ui.XtUIModule;

import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtInjectorSetupUtil {
	public static Injector getWorkbenchInjector(ILanguageInfo lang, IFile file) {
		Injector injector = lang.getInjector();
		XpectFile xpectFile = XpectUtil.load(file);
		XpectTest xpectTest = xpectFile.getTest();
		List<Module> modules = Lists.newArrayList();
		modules.add(injector.getInstance(XtRuntimeModule.class));
		modules.add(injector.getInstance(XtUIModule.class));
		if (xpectTest != null && !xpectTest.eIsProxy()) {
			XpectJavaModel javaModel = xpectTest.getTestClassOrSuite();
			if (javaModel != null && !javaModel.eIsProxy()) {
				EList<IXpectGuiceModuleSetup> moduleSetups = javaModel.getSetups(IXpectGuiceModuleSetup.class, Environment.WORKBENCH);
				for (IXpectGuiceModuleSetup moduleSetup : moduleSetups)
					modules.add(injector.getInstance(moduleSetup.getModule()));
			}
		}
		return lang.getInjector(modules.toArray(new Module[modules.size()]));
	}

	public static Injector getWorkbenchInjector(URI uri, String fileExtension) {
		for (Pair<IStorage, IProject> storage : Access.getIStorage2UriMapper().get().getStorages(uri))
			if (storage.getFirst() instanceof IFile) {
				IFile file = (IFile) storage.getFirst();
				ILanguageInfo info = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(fileExtension);
				if (info != null)
					return XtInjectorSetupUtil.getWorkbenchInjector(info, file);
				else
					return null;
			}
		return null;
	}

}
