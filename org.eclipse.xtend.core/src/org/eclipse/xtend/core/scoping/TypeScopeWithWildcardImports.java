/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeScopeWithWildcardImports extends AbstractScope {

	private final ImportNormalizer[][] imports;
	private final RecordingTypeScope typeScope;
	private final AbstractScope parent;
	private final boolean binaryName;

	public TypeScopeWithWildcardImports(ImportNormalizer[][] imports, RecordingTypeScope typeScope, boolean binaryName) {
		this.imports = imports;
		this.typeScope = typeScope;
		this.parent = null;
		this.binaryName = binaryName;
	}
	
	public TypeScopeWithWildcardImports(List<ImportNormalizer> imports, RecordingTypeScope typeScope, AbstractScope parent, boolean binaryName) {
		this.imports = new ImportNormalizer[][] { imports.toArray(new ImportNormalizer[imports.size()]) };
		this.typeScope = typeScope;
		this.parent = parent;
		this.binaryName = binaryName;
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
					IEObjectDescription candidate = typeScope.getSingleElement(resolvedName, binaryName);
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
		return getSingleElementFromParent(name);
	}

	protected IEObjectDescription getSingleElementFromParent(QualifiedName name) {
		if (parent != null)
			return parent.getSingleElement(name);
		return typeScope.getSingleElement(name);
	}
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		if (!(type instanceof JvmDeclaredType)) {
			return;
		}
		JvmDeclaredType declaredType = (JvmDeclaredType) type;
		String packageName = declaredType.getPackageName();
		if (!Strings.isEmpty(packageName)) {
			QualifiedName qualifiedPackageName = QualifiedName.create(Strings.split(packageName, '.'));
			QualifiedName withDot = null;
			String withDollar = null; 
			for(int i = 0; i < imports.length; i++) {
				ImportNormalizer[] chunk = imports[i];
				for(int j = 0; j < chunk.length; j++) {
					ImportNormalizer normalizer = chunk[j];
					QualifiedName namespacePrefix = normalizer.getImportedNamespacePrefix();
					if (namespacePrefix.equals(qualifiedPackageName)) {
						if (withDot == null) {
							withDot = QualifiedName.create(Strings.split(type.getQualifiedName('.'), '.'));
							withDollar = type.eContainer() instanceof JvmType ? type.getQualifiedName('$').substring(packageName.length() + 1) : null;
						}
						result.add(EObjectDescription.create(withDot.skipFirst(qualifiedPackageName.getSegmentCount()), type));
						if (withDollar != null) {
							result.add(EObjectDescription.create(withDollar, type));	
						}
					}
				}
			}
		}
		if (parent != null) {
			parent.doGetElements(type, result);
		} else {
			Iterables.addAll(result, typeScope.getElements(type));
		}
	}

}