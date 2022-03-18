/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
 package org.eclipse.xtext.testlanguages.fileAware.scoping;

import static org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage.Literals.IMPORT__ELEMENT;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;

public class FileAwareTestLanguageImportScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		List<ImportNormalizer> resolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		if (context instanceof PackageDeclaration) {
			resolvers.add(new ImportNormalizer(getQualifiedNameConverter().toQualifiedName(((PackageDeclaration) context).getName()), true, false));
			for (Import imp : ((PackageDeclaration) context).getImports()) {
				QualifiedName name = getImportedNamespace(imp);
				resolvers.add(new ImportNormalizer(name, false, false));
			}
		}
		return resolvers;
	}

	private QualifiedName getImportedNamespace(Import imp) {
		Element ele = imp.getElement();
		if (ele.eIsProxy()) {
			String name = NodeModelUtils.findNodesForFeature(imp, IMPORT__ELEMENT).get(0).getText().trim();
			return getQualifiedNameConverter().toQualifiedName(name);
		} else {
			return getQualifiedNameProvider().getFullyQualifiedName(ele);
		}
	}
}
