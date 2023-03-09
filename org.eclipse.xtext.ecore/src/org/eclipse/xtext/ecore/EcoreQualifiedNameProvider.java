/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import java.util.Collections;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EcoreQualifiedNameProvider extends IQualifiedNameProvider.AbstractImpl {

	private PolymorphicDispatcher<String> nameDispatcher = new PolymorphicDispatcher<String>("name", 1, 1,
			Collections.singletonList(this), PolymorphicDispatcher.NullErrorHandler.<String> get()) {
		@Override
		protected String handleNoSuchMethod(Object... params) {
			return null;
		}
	};

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		return cache.get(Tuples.pair(obj, getCacheKey()), obj.eResource(), new Provider<QualifiedName>() {

			@Override
			public QualifiedName get() {
				EObject temp = obj;
				String name = nameDispatcher.invoke(temp);
				if (Strings.isEmpty(name))
					return null;
				QualifiedName qualifiedName = QualifiedName.create(name);
				if(!isRecurseParent(obj))
					return qualifiedName;
				QualifiedName parentsQualifiedName = getFullyQualifiedName(obj.eContainer());
				if (parentsQualifiedName == null)
					return null;
				else 
					return parentsQualifiedName.append(qualifiedName);
			}

		});
	}

	protected boolean isRecurseParent(final EObject obj) {
		return obj.eContainer() != null;
	}

	protected String getCacheKey() {
		return "fqn";
	}

	protected String name(EPackage ePackage) {
		return defaultName(ePackage);
	}

	protected String name(EClassifier eClassifier) {
		return defaultName(eClassifier);
	}

	protected String name(EStructuralFeature eStructuralFeature) {
		return defaultName(eStructuralFeature);
	}

	protected String name(EEnumLiteral enumLiteral) {
		return defaultName(enumLiteral);
	}

	protected String name(EOperation eOperation) {
		return defaultName(eOperation);
	}

	/**
	 * Default implementation: simply returns {@link ENamedElement#getName()}.
	 * 
	 * @since 2.30
	 */
	protected String defaultName(ENamedElement element) {
		return element.getName();
	}
}
