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
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 *
 * computes the fully qualified name of an EObject by first invoking a method <br/>
 * <code>String qualifiedName(MyType ele)</code><br/>
 * reflectively.
 * 
 * And if no such method is found looks up a property 'name' and invokes the value and concatenates it to the
 * eContainer's qualifiedName separated by a delimiter, which is returned by {@link #getDelimiter()}
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
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;
	
	private Function<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");
	
	protected Function<EObject, String> getResolver() {
		return resolver;
	}

	public QualifiedName getQualifiedName(final EObject obj) {
		return cache.get(Tuples.pair(obj, "fqn"), obj.eResource(), new Provider<QualifiedName>(){

			public QualifiedName get() {
				EObject temp = obj;
				QualifiedName name = qualifiedName.invoke(temp);
				if (name!=null)
					return name;
				String value = getResolver().apply(temp);
				if (value == null)
					return null;
				QualifiedName qualifiedName = toValue(value);
				while (temp.eContainer() != null) {
					temp = temp.eContainer();
					QualifiedName parentsName = getQualifiedName(temp);
					if (parentsName != null)
						return parentsName.append(qualifiedName);
				}
				return qualifiedName;
			}
			
		});
		
	}

}
