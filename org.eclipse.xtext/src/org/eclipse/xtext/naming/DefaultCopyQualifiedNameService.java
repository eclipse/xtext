/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.naming;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Default implementation for {@link ICopyQualifiedNameService}. Clients might use this implementation as base class.
 * 
 * @author Anton Kosyakov - Initial contribution and API
 * @author Arne Deutsch - Moved to new package
 * @since 2.14
 */
public class DefaultCopyQualifiedNameService implements ICopyQualifiedNameService {
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	private PolymorphicDispatcher<String> dispatchGetQualifiedName = PolymorphicDispatcher
			.createForSingleTarget("_getQualifiedName", 2, 2, this);

	public String getQualifiedName(EObject it, EObject context) {
		return dispatchGetQualifiedName.invoke(it, context);
	}

	protected String _getQualifiedName(EObject object, EObject context) {
		return toFullyQualifiedName(object);
	}

	protected String _getQualifiedName(EObject object, Void context) {
		return toFullyQualifiedName(object);
	}

	protected String _getQualifiedName(Void nullObject, EObject context) {
		return null;
	}

	protected String _getQualifiedName(Void nullObject, Void context) {
		return null;
	}

	protected <T> CharSequence toQualifiedNames(List<T> list,
			Function1<? super T, ? extends String> toQualifiedNameFunction) {
		if (list == null || list.isEmpty()) {
			return "";
		}
		return Joiner.on(", ").skipNulls().join(Lists.transform(list, toQualifiedNameFunction::apply));
	}

	protected String toFullyQualifiedName(EObject object) {
		return toString(object, getFullyQualifiedName(object));
	}

	protected QualifiedName getFullyQualifiedName(EObject object) {
		if (object == null) {
			return null;
		}
		return qualifiedNameProvider.getFullyQualifiedName(object);
	}

	protected String toString(EObject it, QualifiedName fullyQualifiedName) {
		if (fullyQualifiedName == null) {
			return null;
		}
		return qualifiedNameConverter.toString(fullyQualifiedName);
	}
}
