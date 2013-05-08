/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Improved support for nested types in connection with imports
 */
public class XtendImportedNamespaceScopeProvider extends XImportSectionNamespaceScopeProvider {

	public static final QualifiedName XTEND_LIB = QualifiedName.create("org","eclipse","xtend","lib");
	
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> implicitImports = super.getImplicitImports(ignoreCase);
		implicitImports.add(new ImportNormalizer(XTEND_LIB, true, false));
		return implicitImports;
	}

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		if(!(context instanceof XtendFile)) 
			return Collections.emptyList();
		List<ImportNormalizer> importedNamespaceResolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		String packageName = ((XtendFile) context).getPackage();
		if (!Strings.isEmpty(packageName)) {
			ImportNormalizer packageLocalTypes = new ImportNormalizer(getQualifiedNameConverter().toQualifiedName(packageName), true, ignoreCase);
			if (!importedNamespaceResolvers.isEmpty())
				importedNamespaceResolvers.add(packageLocalTypes);
			else
				return Collections.singletonList(packageLocalTypes);
		}
		return importedNamespaceResolvers;
	}
	
	@Override
	protected IScope internalGetScope(IScope parent, IScope globalScope, EObject context, EReference reference) {
		// only members create a new scope, e.g via type parameters
		XtendMember member = EcoreUtil2.getContainerOfType(context, XtendMember.class);
		if (member != null)
			return super.internalGetScope(parent, globalScope, member, reference);
		return super.internalGetScope(parent, globalScope, context, reference);
	}
	
}
