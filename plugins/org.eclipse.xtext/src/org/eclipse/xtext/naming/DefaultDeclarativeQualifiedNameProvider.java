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
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.SimpleAttributeResolver;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * computes the fully qualified name of an EObject by first invoking a method <br/>
 * <code>String qualifiedName(MyType ele)</code><br/>
 * reflectively.
 * 
 * And if no such method is found looks up a property 'name' and invokes the value and concats it to the
 * eContainer's qualifiedName separated by a delimiter, which is returned by {@link #getDelimiter()}
 * 
 */
public class DefaultDeclarativeQualifiedNameProvider extends IQualifiedNameProvider.AbstractImpl {
	
	private PolymorphicDispatcher<String> qualifiedName = new PolymorphicDispatcher<String>("qualifiedName",1,1,Collections.singletonList(this), PolymorphicDispatcher.NullErrorHandler.<String>get())
	{
		@Override
		protected String handleNoSuchMethod(Object... params) { 
			return null;
		}
	}; 

	public String getDelimiter() {
		return ".";
	}
	
	public String getWildcard() {
		return "*";
	}
	
	private final SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");

	public final String getQualifiedName(EObject obj) {
		String name = qualifiedName.invoke(obj);
		if (name!=null)
			return name;
		String value = resolver.getValue(obj);
		if (value == null)
			return null;
		while (obj.eContainer() != null) {
			obj = obj.eContainer();
			String parentsName = getQualifiedName(obj);
			if (parentsName != null)
				return parentsName + getDelimiter() + value;
		}
		return value;
	}

	
}
