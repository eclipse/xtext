/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.ISelector.SelectByName;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedHashMultimap;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ImportScope extends AbstractScope {
	private List<ImportNormalizer> normalizers;

	private boolean ignoreCase;

	public ImportScope(List<ImportNormalizer> namespaceResolvers, IScope parent, boolean ignoreCase) {
		super(parent);
		this.normalizers = namespaceResolvers;
		this.ignoreCase = ignoreCase;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+normalizers+getLocalElements(ISelector.SELECT_ALL)+" -> "+getParent();
	}

	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			final SelectByName selectByName = (ISelector.SelectByName) selector;
			final QualifiedName name = selectByName.getName();
			Iterable<Iterable<IEObjectDescription>> iterables = transform(normalizers, new Function<ImportNormalizer, Iterable<IEObjectDescription>>(){
				public Iterable<IEObjectDescription> apply(ImportNormalizer normalizer) {
					final QualifiedName resolved = normalizer.resolve(name);
					if (resolved!=null) {
						final ISelector.SelectByName selector2 = new ISelector.SelectByName(resolved, ignoreCase);
						selector2.getDelegateSelectors().addAll(selectByName.getDelegateSelectors());
						Iterable<IEObjectDescription> elements = getParent().getElements(selector2);
						Function<IEObjectDescription, IEObjectDescription> aliaser = new Function<IEObjectDescription, IEObjectDescription>() {
							public IEObjectDescription apply(IEObjectDescription from) {
								return new AliasedEObjectDescription(resolved, from, ignoreCase);
							}
						};
						return transform(elements, aliaser);
					}
					return null;
				}
			});
			final Iterable<IEObjectDescription> iterable = concat(filter(iterables,Predicates.notNull()));
			return new Iterable<IEObjectDescription>() {
				
				public Iterator<IEObjectDescription> iterator() {
					Iterator<IEObjectDescription> iterator = iterable.iterator();
					if (!iterator.hasNext()) 
						return Iterators.emptyIterator();
					IEObjectDescription next = iterator.next();
					if (iterator.hasNext())
						return Iterators.emptyIterator();
					return Iterators.singletonIterator(next);
				}
			};
		}
		
		Iterable<IEObjectDescription> candidates = getParent().getElements(selector);
		final LinkedHashMultimap<QualifiedName, IEObjectDescription> map = LinkedHashMultimap.create();
		for (IEObjectDescription from : candidates) {
			QualifiedName fullyQualifiedName = from.getName();
			for (ImportNormalizer normalizer : normalizers) {
				QualifiedName qualifiedName = normalizer.deresolve(fullyQualifiedName);
				if (qualifiedName != null) {
					map.put(ignoreCase?qualifiedName.toLowerCase():qualifiedName, from);
				}
			}
		}
		final Iterable<IEObjectDescription> aliased = transform(map.keys(),
				new Function<QualifiedName, IEObjectDescription>() {
					public IEObjectDescription apply(QualifiedName from) {
						Set<IEObjectDescription> set = map.get(from);
						if (set.size()==1) {
							final IEObjectDescription element = set.iterator().next();
							QualifiedName name = from;
							if (ignoreCase) {
								for (ImportNormalizer normalizer : normalizers) {
									QualifiedName qualifiedName = normalizer.deresolve(element.getName());
									if (qualifiedName != null) {
										name = qualifiedName;
									}
								}
							}
							return new AliasedEObjectDescription(name, element, ignoreCase);
						}
						return null;
					}

				});
		return filter(aliased, Predicates.notNull());
	}
	
	

}
