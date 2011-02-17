/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.scoping.featurecalls.AbstractStaticMethodsFeatureForTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

import com.google.inject.internal.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticallyImportedFeaturesProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	@Override
	protected Iterable<String> getVisibleTypesContainingStaticMethods(JvmTypeReference reference) {
		List<XtendImport> imports = getImports();
		boolean extension = reference != null && reference.getType() != null;
		List<String> result = Lists.newArrayList();
		for(XtendImport imported: imports) {
			if (imported.isStatic() && (!extension || imported.isExtension()) &&  imported.isWildcard()) {
				result.add(imported.getImportedTypeName());
			}
		}
		return result;
	}

	protected List<XtendImport> getImports() {
		Resource resource = getContext();
		if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof XtendFile))
			return Collections.emptyList();
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file.getImports();
	}
	
}
