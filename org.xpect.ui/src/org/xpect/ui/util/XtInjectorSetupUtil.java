/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.util;

import java.util.Set;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.util.Pair;
import org.xpect.XpectFile;
import org.xpect.XtRuntimeModule;
import org.xpect.registry.ILanguageInfo;
import org.xpect.setup.XtextInjectorSetup;
import org.xpect.ui.XtUIModule;

import com.google.common.collect.Sets;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtInjectorSetupUtil {
	public static Injector getWorkbenchInjector(ILanguageInfo lang, IFile file) {
		Injector defaultInjector = lang.getInjector();
		Module xtUIModule = defaultInjector.getInstance(XtUIModule.class);
		Module xtRuntimeModule = defaultInjector.getInstance(XtRuntimeModule.class);
		XpectFile xpectFile = XpectUtil.load(file);
		Class<? extends Module> workbenchModule = XtInjectorSetupUtil.getWorkbenchModule(xpectFile);
		if (workbenchModule != null)
			return lang.getInjector(xtRuntimeModule, xtUIModule, defaultInjector.getInstance(workbenchModule));
		else
			return lang.getInjector(xtRuntimeModule, xtUIModule);
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

	private static Class<? extends Module> getWorkbenchModule(XpectFile xpectFile) {
		if (xpectFile != null && xpectFile.getTest() != null) {
			JvmDeclaredType testType = xpectFile.getTest().getTestClass();
			if (testType != null && !testType.eIsProxy()) {
				Stack<JvmDeclaredType> candidates = new Stack<JvmDeclaredType>();
				candidates.add(testType);
				Set<JvmDeclaredType> visited = Sets.newHashSet(testType);
				while (!candidates.isEmpty()) {
					JvmDeclaredType candidate = candidates.pop();
					Class<?> testClass = TypeUiUtil.getWorkspaceTypeFromHostPlatform(candidate);
					if (testClass != null) {
						XtextInjectorSetup xtextInjectorSetup = testClass.getAnnotation(XtextInjectorSetup.class);
						if (xtextInjectorSetup != null)
							return xtextInjectorSetup.workbenchModule();
					}
					for (JvmTypeReference ref : candidate.getSuperTypes())
						if (ref.getType() instanceof JvmDeclaredType && !ref.getType().eIsProxy()) {
							JvmDeclaredType type = (JvmDeclaredType) ref.getType();
							if (visited.add(type))
								candidates.push(type);
						}
				}
			}
		}
		return null;
	}

}
