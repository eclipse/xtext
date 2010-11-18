/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Collections;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.ISelector.SelectByName;

import com.google.common.base.Function;
import com.google.common.base.Predicates;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ImportScope extends AbstractScope {
	private ImportNormalizer normalizer;

	public ImportScope(ImportNormalizer normalizer, IScope parent) {
		super(parent);
		this.normalizer = normalizer;
	}

	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			final SelectByName selectByName = (ISelector.SelectByName) selector;
			final QualifiedName name = selectByName.getName();
			final QualifiedName resolved = normalizer.resolve(name);
			if (resolved==null)
				return Collections.emptySet();
			final ISelector.SelectByName selector2 = new ISelector.SelectByName(resolved);
			selector2.getDelegateSelectors().addAll(selectByName.getDelegateSelectors());
			Iterable<IEObjectDescription> elements = getParent().getElements(selector2);
			Function<IEObjectDescription, IEObjectDescription> aliaser = new Function<IEObjectDescription, IEObjectDescription>() {
				public IEObjectDescription apply(IEObjectDescription from) {
					return new AliasedEObjectDescription(resolved, from);
				}
			};
			return transform(elements, aliaser);

		}
		Iterable<IEObjectDescription> candidates = getParent().getElements(selector);
		final Iterable<IEObjectDescription> aliased = transform(candidates,
				new Function<IEObjectDescription, IEObjectDescription>() {
					public IEObjectDescription apply(IEObjectDescription from) {
						QualifiedName fullyQualifiedName = from.getQualifiedName();
						QualifiedName qualifiedName = normalizer.deresolve(fullyQualifiedName);
						if (qualifiedName == null)
							return null;
						return new AliasedEObjectDescription(qualifiedName, from);
					}
				});
		return filter(aliased, Predicates.notNull());
	}

}
