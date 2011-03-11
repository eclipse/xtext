/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.scoping;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class DomainmodelScopeProvider extends XbaseScopeProvider {

	@Inject
	private IJvmModelAssociations associations;
	
	@Override
	protected IScope createLocalVarScope(EObject context, EReference reference, IScope parent,
			boolean includeCurrentBlock, int idx) {
		if (context instanceof Entity) {
			JvmType jvmType = getJvmType((Entity) context);
			if(jvmType != null)
				return new SimpleScope(parent, singleton(EObjectDescription.create(THIS, jvmType)));
		} else if (context instanceof Operation) {
			Operation operation  = (Operation) context;
			List<JvmFormalParameter> list = operation.getParams();
			List<IEObjectDescription> descriptions = Lists.newArrayList();
			for (JvmFormalParameter jvmFormalParameter : list) {
				if (!Strings.isEmpty(jvmFormalParameter.getName())) {
					IEObjectDescription desc = createIEObjectDescription(jvmFormalParameter);
					descriptions.add(desc);
				}
			}
			return MapBasedScope.createScope(
					super.createLocalVarScope(context, reference, parent, includeCurrentBlock, idx), descriptions);
		}
		return super.createLocalVarScope(context, reference, parent, includeCurrentBlock, idx);
	}
	
	protected IEObjectDescription createIEObjectDescription(JvmFormalParameter jvmFormalParameter) {
		return EObjectDescription.create(QualifiedName.create(jvmFormalParameter.getName()), jvmFormalParameter, null);
	}

	protected JvmType getJvmType(Entity entity) {
		Iterable<JvmType> jvmElements = filter(associations.getJvmElements(entity), JvmType.class);
		return (isEmpty(jvmElements) ? null : jvmElements.iterator().next());
	}
	
	@Override
	protected JvmDeclaredType getContextType(EObject call) {
		if (call == null)
			return null;
		Entity containerClass = EcoreUtil2.getContainerOfType(call, Entity.class);
		if (containerClass != null)
			return (JvmDeclaredType) getJvmType(containerClass);
		else
			return super.getContextType(call);
	}
}
