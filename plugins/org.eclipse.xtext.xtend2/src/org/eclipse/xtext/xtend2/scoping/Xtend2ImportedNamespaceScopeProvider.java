/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2ImportedNamespaceScopeProvider extends XbaseImportedNamespaceScopeProvider {

	@Inject 
	private IQualifiedNameConverter nameConverter;
	
	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		XtendFile xtendFile = EcoreUtil2.getContainerOfType(context, XtendFile.class);
		List<ImportNormalizer> importedNamespaceResolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		if(xtendFile != null && xtendFile.getPackage() != null) {
			importedNamespaceResolvers.add(new ImportNormalizer(nameConverter.toQualifiedName(xtendFile.getPackage()), true, ignoreCase));
		}
		return importedNamespaceResolvers;
	}
}
