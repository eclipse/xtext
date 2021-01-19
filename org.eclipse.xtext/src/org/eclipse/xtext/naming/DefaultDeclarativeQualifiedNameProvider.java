/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.Collections;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.SimpleCache;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * Computes the fully qualified name of an EObject by first invoking a method <br/>
 * <code>QualifiedName qualifiedName(MyType ele)</code><br/>
 * reflectively.
 * 
 * And if no such method is found looks up a property 'name' and invokes the value and appends it to the
 * eContainer's qualifiedName.
 * 
 * The default implementation performs extensive caching by means of a {@link SimpleCache}. Under
 * some circumstances, this may downgrade the performance.
 * Clients may want to override {@link #computeFullyQualifiedName(EObject)} or {@link #getOrComputeFullyQualifiedName(EObject)}.
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
		return getOrComputeFullyQualifiedName(obj);
	}

	/**
	 * Tries to obtain the FQN of the given object from the {@link #cache}. If it is absent,
	 * it computes a new name.
	 * 
	 * @see #computeFullyQualifiedName(EObject)
	 * @since 2.15
	 */
	protected QualifiedName getOrComputeFullyQualifiedName(final EObject obj) {
		return cache.get(Tuples.pair(obj, "fqn"), obj.eResource(), ()->computeFullyQualifiedName(obj));
	}
	
	/**
	 * Default for qualifiedName dispatcher. Write a method with this signature but custom Type for dispatching other types.
	 * @since 2.3
	 */
	protected QualifiedName qualifiedName(Object ele){
		return null;
	}

	/**
	 * Returns the {@link IQualifiedNameConverter} that is used to convert a string which was read from a model
	 * to an instance of {@link QualifiedName}.
	 */
	protected IQualifiedNameConverter getConverter() {
		return converter;
	}

	/**
	 * Computes the fully qualified name for the given object, if any.
	 * Uses the reflective {@link PolymorphicDispatcher} on the method name {@link #qualifiedName(Object)}.
	 * If there is no such reflective name found, it tries to read an {@link EAttribute} {@code name} from the
	 * given object and appends that to its containers qualified name.
	 * 
	 * @see #computeFullyQualifiedNameFromNameAttribute(EObject)
	 * 
	 * @since 2.15
	 */
	protected QualifiedName computeFullyQualifiedName(EObject obj) {
		QualifiedName qualifiedNameFromDispatcher = qualifiedName.invoke(obj);
		if (qualifiedNameFromDispatcher!=null)
			return qualifiedNameFromDispatcher;
		return computeFullyQualifiedNameFromNameAttribute(obj);
	}

	/**
	 * Tries to read an {@link EAttribute} {@code name} from the
	 * given object and appends that to its container's qualified name.
	 * 
	 * @since 2.15
	 */
	protected QualifiedName computeFullyQualifiedNameFromNameAttribute(EObject obj) {
		String name = getResolver().apply(obj);
		if (Strings.isEmpty(name))
			return null;
		QualifiedName qualifiedNameFromConverter = converter.toQualifiedName(name);
		while (obj.eContainer() != null) {
			obj = obj.eContainer();
			QualifiedName parentsQualifiedName = getFullyQualifiedName(obj);
			if (parentsQualifiedName != null)
				return parentsQualifiedName.append(qualifiedNameFromConverter);
		}
		return qualifiedNameFromConverter;
	}
}
