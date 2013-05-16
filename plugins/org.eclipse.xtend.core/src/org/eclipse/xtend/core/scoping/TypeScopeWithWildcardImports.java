/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeScopeWithWildcardImports extends AbstractScope {

	private final ImportNormalizer[][] imports;
	private final AbstractTypeScope typeScope;
	private final IScope parent;

	public TypeScopeWithWildcardImports(ImportNormalizer[][] imports, AbstractTypeScope typeScope) {
		this.imports = imports;
		this.typeScope = typeScope;
		this.parent = typeScope;
	}
	
	public TypeScopeWithWildcardImports(List<ImportNormalizer> imports, AbstractTypeScope typeScope, IScope parent) {
		this.imports = new ImportNormalizer[][] { imports.toArray(new ImportNormalizer[imports.size()]) };
		this.typeScope = typeScope;
		this.parent = parent;
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		for(int i = 0; i < imports.length; i++) {
			ImportNormalizer[] chunk = imports[i];
			IEObjectDescription result = null;
			for(int j = 0; j < chunk.length; j++) {
				ImportNormalizer normalizer = chunk[j];
				QualifiedName resolvedName = normalizer.resolve(name);
				if (resolvedName != null) {
					IEObjectDescription candidate = typeScope.getSingleElement(resolvedName, true);
					if (candidate != null) {
						if (result == null) {
							result = candidate;
						} else {
							return null;
						}
					}
				}
			}
			if (result != null) {
				return result;
			}
		}
		return parent.getSingleElement(name);
	}

}