/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.serializer;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
import org.eclipse.xtend.core.xtend.AnonymousClassConstructorCall;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.serializer.SerializerScopeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendSerializerScopeProvider extends SerializerScopeProvider {

	@Inject
	private AnonymousClassUtil anonymousClassUtil;
	
	@Override
	public IScope createConstructorCallSerializationScope(EObject context) {
		IScope constructorCallSerializationScope = super.createConstructorCallSerializationScope(context);
		if(context instanceof AnonymousClassConstructorCall) {
			JvmConstructor constructor = ((AnonymousClassConstructorCall) context).getConstructor();
			if(constructor == null || constructor.eIsProxy())
				return IScope.NULLSCOPE;
			JvmType superType = anonymousClassUtil.getSuperType((AnonymousClassConstructorCall) context);
			if(superType != null) {
				IScope typeScope = getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
				Iterable<IEObjectDescription> superTypeDescriptions = typeScope.getElements(superType);
				Iterable<IEObjectDescription> constructorDescriptions = constructorCallSerializationScope.getElements(constructor);
				List<IEObjectDescription> aliasedDescriptions = newArrayList();
				for(IEObjectDescription constructorDescription: constructorDescriptions) {
					for(IEObjectDescription superElement: superTypeDescriptions) 
						aliasedDescriptions.add(new AliasedEObjectDescription(superElement.getQualifiedName(), constructorDescription));
				}
				SimpleScope aliasedScope = new SimpleScope(aliasedDescriptions);
				return aliasedScope;
			}
		}
		return constructorCallSerializationScope;
	}
}
