/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseImportedNamespaceScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		return singletonList(new ImportNormalizer(QualifiedName.create("java","lang"), true, ignoreCase));
	}
	
	@Inject private IJvmModelAssociations associations;
	@Inject private IQualifiedNameConverter nameConverter;
	
	@Override
	protected IScope getLocalElementsScope(IScope parent, EObject context, EReference reference) {
		IScope result = parent;
		ISelectable allDescriptions = getAllDescriptions(context.eResource());
		QualifiedName name = getQualifiedNameOfLocalElement(context);
		boolean ignoreCase = isIgnoreCase(reference);
		
		// imports
		final List<ImportNormalizer> namespaceResolvers = getImportedNamespaceResolvers(context, ignoreCase);
		if (!namespaceResolvers.isEmpty()) {
			if (isRelativeImport() && name!=null) {
				ImportNormalizer localNormalizer = new ImportNormalizer(name, true, ignoreCase); 
				result = createImportScope(result, singletonList(localNormalizer), allDescriptions, reference.getEReferenceType(), ignoreCase);
			}
			result = createImportScope(result, namespaceResolvers, null, reference.getEReferenceType(), ignoreCase);
		}
		
		// local element
		if (name!=null) {
			ImportNormalizer localNormalizer = new ImportNormalizer(name, true, ignoreCase); 
			result = createImportScope(result, singletonList(localNormalizer), allDescriptions, reference.getEReferenceType(), ignoreCase);
		}
		
		// scope for jvm elements
		Set<EObject> elements = associations.getJvmElements(context);
		for (EObject derivedJvmElement : elements) {
			// scope for JvmDeclaredTypes
			if (derivedJvmElement instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) derivedJvmElement;
				QualifiedName jvmTypeName = getQualifiedNameOfLocalElement(declaredType);
				if (jvmTypeName != null && !jvmTypeName.equals(name)) {
					ImportNormalizer localNormalizer = new ImportNormalizer(jvmTypeName, true, ignoreCase); 
					result = createImportScope(result, singletonList(localNormalizer), allDescriptions, reference.getEReferenceType(), ignoreCase);
				}
			}
			// scope for JvmTypeParameterDeclarator
			if (derivedJvmElement instanceof JvmTypeParameterDeclarator) {
				JvmTypeParameterDeclarator parameterDeclarator = (JvmTypeParameterDeclarator) derivedJvmElement;
				List<IEObjectDescription> descriptions = null;
				for (JvmTypeParameter param : parameterDeclarator.getTypeParameters()) {
					if (param.getSimpleName() != null) {
						if (descriptions == null)
							descriptions = Lists.newArrayList();
						QualifiedName paramName = QualifiedName.create(param.getSimpleName());
						descriptions.add(EObjectDescription.create(paramName, param));
					}
				}
				if (descriptions != null && !descriptions.isEmpty())
					result = MapBasedScope.createScope(result, descriptions);
			}
		}
		return result;
	}
}
