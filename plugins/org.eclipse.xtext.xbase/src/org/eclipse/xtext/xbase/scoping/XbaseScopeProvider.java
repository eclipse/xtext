/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.XClass;
import org.eclipse.xtext.xbase.XFunction;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge
 */
public class XbaseScopeProvider extends XpressionScopeProvider {
	
	@Override
	protected IScope getLocalVariableScope(EObject context, EReference reference, Predicate<EObject> featurePredicate) {
		if (context instanceof XClass) {
			XClass clazz = (XClass) context;
			return getAllFeatures(clazz, IScope.NULLSCOPE, featurePredicate);
		} else if  (context instanceof XFunction) {
			XFunction func = (XFunction) context;
			EList<JvmFormalParameter> list = func.getParameters();
			Map<String,IEObjectDescription> map = Maps.newHashMap();
			for (JvmFormalParameter jvmFormalParameter : list) {
				IEObjectDescription desc = createIEObjectDescription(jvmFormalParameter);
				map.put(desc.getName(),desc);
			}
			return new MapBasedScope(super.getLocalVariableScope(context, reference,featurePredicate), map);
		}
		return super.getLocalVariableScope(context, reference,featurePredicate);
	}

	protected IEObjectDescription createIEObjectDescription(JvmFormalParameter jvmFormalParameter) {
		return new EObjectDescription(jvmFormalParameter.getName(), jvmFormalParameter, null);
	}

}
