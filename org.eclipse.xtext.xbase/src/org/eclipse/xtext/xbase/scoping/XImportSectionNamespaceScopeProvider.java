/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeDelegatingScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.MultimapBasedSelectable;
import org.eclipse.xtext.scoping.impl.ScopeBasedSelectable;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XImportSectionNamespaceScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {
	
	public static final QualifiedName JAVA_LANG = QualifiedName.create("java","lang");
	public static final QualifiedName XBASE_LIB = QualifiedName.create("org","eclipse","xtext","xbase","lib");

	@Inject private IJvmModelAssociations associations;
	@Inject private IResourceScopeCache cache;
	@Inject private IQualifiedNameProvider qualifiedNameProvider;
	@Inject private IQualifiedNameConverter qualifiedNameConverter;
	@Inject private IImportsConfiguration importsConfiguration;
	
	public IQualifiedNameProvider getQualifiedNameProvider() {
		return qualifiedNameProvider;
	}

	public IQualifiedNameConverter getQualifiedNameConverter() {
		return qualifiedNameConverter;
	}
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (context == null)
			throw new NullPointerException("context");
		if (context.eResource() == null)
			throw new IllegalArgumentException("context must be contained in a resource");
		IScope globalScope = getGlobalScope(context.eResource(), reference);
		return internalGetScope(globalScope, globalScope, context, reference);
	}
	
	@Override
	protected IScope getGlobalScope(final Resource context, final EReference reference) {
		IScope globalScope = super.getGlobalScope(context, reference, null);
		return SelectableBasedScope.createScope(globalScope, getAllDescriptions(context), reference.getEReferenceType(), isIgnoreCase(reference));
	}
	
	protected IScope internalGetScope(IScope parent, IScope globalScope, EObject context, EReference reference) {
		if(context instanceof XImportDeclaration) {
			return globalScope;
		}
		IScope result = parent;
		if (context.eContainer() == null) {
			if (parent != globalScope)
				throw new IllegalStateException("the parent should be the global scope");
			result = getResourceScope(globalScope, context.eResource(), reference);
		} else {
			result = internalGetScope(parent, globalScope, context.eContainer(), reference);
		}
		return getLocalElementsScope(result, globalScope, context, reference);
	}
	
	protected IScope getLocalElementsScope(IScope parent, IScope globalScope, EObject context, EReference reference) {
		IScope result = parent;
		QualifiedName name = getQualifiedNameOfLocalElement(context);
		boolean ignoreCase = isIgnoreCase(reference);
		ISelectable resourceOnlySelectable = getAllDescriptions(context.eResource());
		ISelectable globalScopeSelectable = new ScopeBasedSelectable(globalScope);
		
		// imports
		List<ImportNormalizer> explicitImports = getImportedNamespaceResolvers(context, ignoreCase);
		if (!explicitImports.isEmpty()) {
			result = createImportScope(result, explicitImports, globalScopeSelectable, reference.getEReferenceType(), ignoreCase);
		}
		
		// local element
		if (name!=null) {
			ImportNormalizer localNormalizer = doCreateImportNormalizer(name, true, ignoreCase); 
			result = createImportScope(result, singletonList(localNormalizer), resourceOnlySelectable, reference.getEReferenceType(), ignoreCase);
		}
		
		// scope for jvm elements
		Set<EObject> elements = associations.getJvmElements(context);
		for (EObject derivedJvmElement : elements) {
			// scope for JvmDeclaredTypes
			if (derivedJvmElement instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) derivedJvmElement;
				QualifiedName jvmTypeName = getQualifiedNameOfLocalElement(declaredType);
				if (declaredType.getDeclaringType() == null && !Strings.isEmpty(declaredType.getPackageName())) {
					QualifiedName packageName = this.qualifiedNameConverter.toQualifiedName(declaredType.getPackageName());
					ImportNormalizer normalizer = doCreateImportNormalizer(packageName, true, ignoreCase);
					result = createImportScope(result, singletonList(normalizer), globalScopeSelectable, reference.getEReferenceType(), ignoreCase);
				}
				if (jvmTypeName != null && !jvmTypeName.equals(name)) {
					ImportNormalizer localNormalizer = doCreateImportNormalizer(jvmTypeName, true, ignoreCase); 
					result = createImportScope(result, singletonList(localNormalizer), resourceOnlySelectable, reference.getEReferenceType(), ignoreCase);
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
	
	protected IScope getResourceScope(IScope globalScope, @SuppressWarnings("unused") Resource res, EReference reference) {
		IScope result = globalScope;
		ISelectable globalScopeSelectable = new ScopeBasedSelectable(result);
		
		// implicit imports (i.e. java.lang.*)
		List<ImportNormalizer> normalizers = getImplicitImports(isIgnoreCase(reference));
		if (!normalizers.isEmpty()) {
			result = createImportScope(result, normalizers, globalScopeSelectable, reference.getEReferenceType(), isIgnoreCase(reference));
		}
		
		return result;
	}
	
	/**
	 * @param ignoreCase {@code true} if the import normalizer should use case insensitive compare logic. 
	 */
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		return Lists.<ImportNormalizer>newArrayList(
				doCreateImportNormalizer(JAVA_LANG, true, false),
				doCreateImportNormalizer(XBASE_LIB, true, false));
	}
	
	protected ImportScope createImportScope(IScope parent, List<ImportNormalizer> namespaceResolvers, ISelectable importFrom, EClass type, boolean ignoreCase) {
		if (importFrom == null)
			throw new NullPointerException("importFrom");
		
		return new ImportScope(namespaceResolvers, parent, importFrom, type, ignoreCase);
	}
	
	protected Object getKey(Notifier context, EReference reference) {
		return Tuples.create(XImportSectionNamespaceScopeProvider.class, context, reference);
	}

	protected List<ImportNormalizer> getImportedNamespaceResolvers(final EObject context, final boolean ignoreCase) {
		return cache.get(Tuples.create(context, ignoreCase, "imports"), context.eResource(), new Provider<List<ImportNormalizer>>() {
			@Override
			public List<ImportNormalizer> get() {
				return internalGetImportedNamespaceResolvers(context, ignoreCase);
			}
		});
	}
	
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		if(EcoreUtil.getRootContainer(context) != context) 
			return Collections.emptyList();
		XImportSection importSection = importsConfiguration.getImportSection((XtextResource) context.eResource());
		if(importSection != null) {
			return getImportedNamespaceResolvers(importSection, ignoreCase);
		}
		return Collections.emptyList();
	}
	
	protected IImportsConfiguration getImportsConfiguration() {
		return importsConfiguration;
	}

	protected List<ImportNormalizer> getImportedNamespaceResolvers(XImportSection importSection, boolean ignoreCase) {
		List<XImportDeclaration> importDeclarations = importSection.getImportDeclarations();
		List<ImportNormalizer> result = Lists.newArrayListWithExpectedSize(importDeclarations.size());
		for (XImportDeclaration imp: importDeclarations) {
			if (!imp.isStatic()) {
				String value = imp.getImportedNamespace();
				if(value == null)
					value = imp.getImportedTypeName();
				ImportNormalizer resolver = createImportedNamespaceResolver(value, ignoreCase);
				if (resolver != null)
					result.add(resolver);
			}
		}
		return result;
	}


	/**
	 * Create a new {@link ImportNormalizer} for the given namespace.
	 * @param namespace the namespace.
	 * @param ignoreCase <code>true</code> if the resolver should be case insensitive.
	 * @return a new {@link ImportNormalizer} or <code>null</code> if the namespace cannot be converted to a valid
	 * qualified name.
	 */
	protected ImportNormalizer createImportedNamespaceResolver(final String namespace, boolean ignoreCase) {
		if (Strings.isEmpty(namespace))
			return null;
		QualifiedName importedNamespace = qualifiedNameConverter.toQualifiedName(namespace);
		if (importedNamespace == null || importedNamespace.isEmpty()) {
			return null;
		}
		boolean hasWildcard = ignoreCase ? 
				importedNamespace.getLastSegment().equalsIgnoreCase(getWildcard()) :
				importedNamespace.getLastSegment().equals(getWildcard());
		if (hasWildcard) {
			if (importedNamespace.getSegmentCount() <= 1)
				return null;
			return doCreateImportNormalizer(importedNamespace.skipLast(1), true, ignoreCase);
		} else {
			return doCreateImportNormalizer(importedNamespace, false, ignoreCase);
		}
	}

	protected ImportNormalizer doCreateImportNormalizer(QualifiedName importedNamespace, boolean wildcard,
			boolean ignoreCase) {
		return AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(importedNamespace, wildcard, ignoreCase);
	}

	protected QualifiedName getQualifiedNameOfLocalElement(final EObject context) {
		return qualifiedNameProvider.getFullyQualifiedName(context);
	}

	protected ISelectable getAllDescriptions(final Resource resource) {
		return cache.get("internalGetAllDescriptions", resource, new Provider<ISelectable>() {
			@Override
			public ISelectable get() {
				return internalGetAllDescriptions(resource);
			}
		});
	}
	
	protected ISelectable internalGetAllDescriptions(final Resource resource) {
		Iterable<EObject> allContents = new Iterable<EObject>(){
			@Override
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllContents(resource, false);
			}
		}; 
		Iterable<IEObjectDescription> allDescriptions = Scopes.scopedElementsFor(allContents, qualifiedNameProvider);
		return new MultimapBasedSelectable(allDescriptions);
	}

	public String getWildcard() {
		return "*";
	}
	
	protected IJvmModelAssociations getAssociations() {
		return associations;
	}
}
