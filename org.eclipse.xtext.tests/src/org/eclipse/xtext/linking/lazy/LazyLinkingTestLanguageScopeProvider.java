/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class LazyLinkingTestLanguageScopeProvider extends AbstractDeclarativeScopeProvider {
	
	public IScope scope_Property(Type t, EReference ref) {
		return new SimpleScope(IScope.NULLSCOPE, Iterables.transform(t.getExtends().getProperties(), new Function<Property, IEObjectDescription>(){
			@Override
			public IEObjectDescription apply(Property param) {
				return EObjectDescription.create(QualifiedName.create(param.getName()), param);
			}
		}));
	}
}
