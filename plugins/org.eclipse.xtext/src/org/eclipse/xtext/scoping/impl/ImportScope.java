/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Selectors;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class ImportScope extends AbstractScope {

	private final List<ImportNormalizer> normalizers;

	private final ISelectable importFrom;

	private final EClass type;

	public ImportScope(List<ImportNormalizer> namespaceResolvers, IScope parent, ISelectable importFrom, EClass type, boolean ignoreCase) {
		super(parent, ignoreCase);
		this.type = type;
		this.normalizers = removeDuplicates(namespaceResolvers);
		this.importFrom = importFrom;
	}
	
	protected List<ImportNormalizer> removeDuplicates(List<ImportNormalizer> namespaceResolvers) {
		ArrayList<ImportNormalizer> list = newArrayList();
		for (ImportNormalizer importNormalizer : namespaceResolvers) {
			if (!list.contains(importNormalizer))
				list.add(importNormalizer);
		}
		return list;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+normalizers+getAllLocalElements()+" -> "+getParent();
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllElements() {
		final Iterable<IEObjectDescription> globalElements = getParent().getElements(Selectors.selectAll());
		Iterable<IEObjectDescription> importedElements = importFrom != null ? importFrom.getExportedObjects() : globalElements;
		Iterable<IEObjectDescription> aliased = getAllAliasedElements(importedElements);
		final Map<QualifiedName,IEObjectDescription> elements = Maps.uniqueIndex(aliased,
				new Function<IEObjectDescription, QualifiedName>() {
					public QualifiedName apply(IEObjectDescription from) {
						return isIgnoreCase() ? from.getName().toLowerCase(): from.getName();
					}
				});
		return concat(aliased, filter(globalElements, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return !elements.containsKey(isIgnoreCase() ? input.getName().toLowerCase() : input.getName());
			}
		}));
	}
	
	protected Iterable<IEObjectDescription> getAllAliasedElements(Iterable<IEObjectDescription> allImportedElements) {
		Map<QualifiedName, IEObjectDescription> aliasToDescription = Maps.newHashMap();
		for (IEObjectDescription imported : allImportedElements) {
			QualifiedName fullyQualifiedName = imported.getName();
			for (ImportNormalizer normalizer : normalizers) {
				QualifiedName alias = normalizer.deresolve(fullyQualifiedName);
				if (alias != null) {
					QualifiedName key = alias;
					if (isIgnoreCase()) {
						key = key.toLowerCase();
					}
					if (aliasToDescription.containsKey(alias)) {
						aliasToDescription.put(alias, null);
					} else {
						aliasToDescription.put(alias, imported);
					}
				}
			}
		}
		final Iterable<IEObjectDescription> aliased = transform(aliasToDescription.entrySet(),
				new Function<Map.Entry<QualifiedName, IEObjectDescription>, IEObjectDescription>() {
					public IEObjectDescription apply(Map.Entry<QualifiedName, IEObjectDescription> entry) {
						if (entry.getValue() != null) {
							return new AliasedEObjectDescription(entry.getKey(), entry.getValue());
						}
						return null;
					}

				});
		return filter(aliased, Predicates.notNull());
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
		if (importFrom != null) {
			Iterable<IEObjectDescription> candidates = importFrom.getExportedObjectsByObject(object);
			return getAliasedElements(candidates);
		} else {
			Iterable<IEObjectDescription> candidates = getParent().getElements(Selectors.selectByEObject(object));
			return getAliasedElements(candidates);
		}
	}
	
	protected Iterable<IEObjectDescription> getAliasedElements(Iterable<IEObjectDescription> candidates) {
		final LinkedHashMultimap<QualifiedName, IEObjectDescription> aliasToDescription = LinkedHashMultimap.create();
		for (IEObjectDescription from : candidates) {
			QualifiedName fullyQualifiedName = from.getName();
			for (ImportNormalizer normalizer : normalizers) {
				QualifiedName qualifiedName = normalizer.deresolve(fullyQualifiedName);
				if (qualifiedName != null) {
					aliasToDescription.put(isIgnoreCase() ? qualifiedName.toLowerCase() : qualifiedName, from);
				}
			}
		}
		final Iterable<IEObjectDescription> aliased = transform(aliasToDescription.keys(),
				new Function<QualifiedName, IEObjectDescription>() {
					public IEObjectDescription apply(QualifiedName shortName) {
						Set<IEObjectDescription> set = aliasToDescription.get(shortName);
						if (set.size()==1) {
							return getSingleLocalElementByName(shortName);
						}
						return null;
					}

				});
		return filter(aliased, Predicates.notNull());
	}
	
	@Override
	protected IEObjectDescription getSingleLocalElementByName(QualifiedName name) {
		IEObjectDescription result = null;
		ISelectable importFrom = this.importFrom;
		if (importFrom == null) {
			importFrom = new ScopeBasedSelectable(getParent());
		}
		for(ImportNormalizer normalizer: normalizers) {
			final QualifiedName resolvedName = normalizer.resolve(name);
			if (resolvedName != null) {
				Iterable<IEObjectDescription> resolvedElements = importFrom.getExportedObjects(type, resolvedName, isIgnoreCase());
				for(IEObjectDescription resolvedElement: resolvedElements) {
					if (result != null) {
						return null;
					}
					QualifiedName alias = normalizer.deresolve(resolvedElement.getName());
					if (alias==null)
						throw new IllegalStateException("Couldn't deresolve "+resolvedElement.getName()+" with import "+normalizer);
					result = new AliasedEObjectDescription(alias, resolvedElement);
				}
			}
		}
		return result;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		IEObjectDescription result = getSingleLocalElementByName(name);
		if (result == null)
			return Collections.emptyList();
		return Collections.singleton(result);
	}

}
