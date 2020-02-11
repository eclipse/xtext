/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;


/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class AnonymousClassUtil {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private LazyURIEncoder uriEncoder;
	
	@Inject
	private LinkingHelper linkingHelper;
	
	public JvmDeclaredType getSuperTypeNonResolving(AnonymousClass anonymousClass, IScope typeScope) {
		XConstructorCall constructorCall = anonymousClass.getConstructorCall();
		EObject constructorProxy = (EObject) constructorCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		IEObjectDescription description = null;
		if (constructorProxy != null) {
			if (!constructorProxy.eIsProxy()) {
				return getSuperType(anonymousClass);
			}
			String fragment = EcoreUtil.getURI(constructorProxy).fragment();
			INode node = uriEncoder.getNode(constructorCall, fragment);
			String name = linkingHelper.getCrossRefNodeAsString(node, true);
			QualifiedName superTypeName = qualifiedNameConverter.toQualifiedName(name);
			description = typeScope.getSingleElement(superTypeName);
		}
		if (description == null || !EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_DECLARED_TYPE, description.getEClass())) {
			description = typeScope.getSingleElement(QualifiedName.create("java", "lang", "Object"));
		}
		if (description != null && EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_DECLARED_TYPE, description.getEClass())) {
			JvmDeclaredType type = (JvmDeclaredType) description.getEObjectOrProxy();
			if (!type.eIsProxy())
				return type;
			return (JvmDeclaredType) EcoreUtil.resolve(type, anonymousClass);
		}
		return null;
	}
	
	/* @Nullable */
	public JvmGenericType getSuperType(AnonymousClass anonymousClass) {
		JvmConstructor constructor = anonymousClass.getConstructorCall().getConstructor();
		if(constructor != null && ! constructor.eIsProxy()) {
			JvmDeclaredType declaringType = constructor.getDeclaringType();
			JvmType superType = Iterables.getLast(declaringType.getSuperTypes()).getType();
			if(superType instanceof JvmGenericType)
				return (JvmGenericType) superType;
		}
		return null;
	}
	
	public JvmConstructor getSuperTypeConstructor(AnonymousClass anonymousClass) {
		JvmGenericType superType = getSuperType(anonymousClass);
		if(superType != null) {
			JvmConstructor constructor = anonymousClass.getConstructorCall().getConstructor();
			for(JvmMember superMember: superType.getMembers()) {
				if(superMember instanceof JvmConstructor && isSameSignature(constructor, (JvmConstructor) superMember)) 
					return (JvmConstructor) superMember;
			}
		}
		return null;
	}

	protected boolean isSameSignature(JvmConstructor constructor, JvmConstructor superConstructor) {
		if(constructor.getParameters().size() != superConstructor.getParameters().size())
			return false;
		for(int i=0; i<constructor.getParameters().size(); ++i) {
			JvmTypeReference paramType = constructor.getParameters().get(i).getParameterType();
			JvmTypeReference superParamType = superConstructor.getParameters().get(i).getParameterType();
			if(!paramType.getIdentifier().equals(superParamType.getIdentifier()))
				return false;
		}
		return true;
	}
}
