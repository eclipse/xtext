/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Computes the fully qualified name of an EObject by first invoking a method <br/>
 * <code>QualifiedName qualifiedName(MyType ele)</code><br/>
 * reflectively.
 * 
 * And if no such method is found looks up a property 'name' and invokes the value and appends it to the
 * eContainer's qualifiedName
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DefaultDeclarativeQualifiedNameProvider extends IQualifiedNameProvider.AbstractImpl {
	
	private PolymorphicDispatcher<QualifiedName> qualifiedName = new PolymorphicDispatcher<QualifiedName>("qualifiedName",1,1,Collections.singletonList(this), PolymorphicDispatcher.NullErrorHandler.<QualifiedName>get())
	{
		@Override
		protected QualifiedName handleNoSuchMethod(Object... params) { 
			return null;
		}
	}; 
	
	@Inject
	private IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
	
	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;
	
	private Function<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");
	
	protected Function<EObject, String> getResolver() {
		return resolver;
	}

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		return cache.get(Tuples.pair(obj, "fqn"), obj.eResource(), new Provider<QualifiedName>(){

			@Override
			public QualifiedName get() {
				EObject temp = obj;
				QualifiedName qualifiedNameFromDispatcher = qualifiedName.invoke(temp);
				if (qualifiedNameFromDispatcher!=null)
					return qualifiedNameFromDispatcher;
				String name = getResolver().apply(temp);
				if (Strings.isEmpty(name))
					return null;
				QualifiedName qualifiedNameFromConverter = converter.toQualifiedName(name);
				while (temp.eContainer() != null) {
					temp = temp.eContainer();
					QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
					if (parentsQualifiedName != null)
						return parentsQualifiedName.append(qualifiedNameFromConverter);
				}
				return qualifiedNameFromConverter;
			}
		});
	}
	
	

	/**
	 * Default for qualifiedName dispatcher. Write a method with this signature but custom Type for dispatching other types.
	 * @since 2.3
	 */
	protected QualifiedName qualifiedName(Object ele){
		return null;
	}

	protected IQualifiedNameConverter getConverter() {
		return converter;
	}
}
