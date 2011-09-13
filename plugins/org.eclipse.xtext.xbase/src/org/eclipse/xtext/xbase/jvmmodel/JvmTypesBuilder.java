/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypesBuilder {
	
	@Inject
	private IJvmModelAssociator associator;
	
	@Inject
	private IExpressionContextAssociator expressionContextAssociator;
	
	@Inject
	private TypeReferences references;
	
	public void associate(XExpression expr, JvmIdentifiableElement element) {
		expressionContextAssociator.associate(expr, element);
	}

	public JvmField toField(EObject ctx, String name, JvmTypeReference typeRef) {
		JvmField result = create(name, JvmField.class, null);
		if (!result.eIsSet(TypesPackage.Literals.JVM_MEMBER__VISIBILITY))
			result.setVisibility(JvmVisibility.PRIVATE);
		result.setType(cloneWithProxies(typeRef));
		return associate(ctx,result);
	}
	
	public <T extends JvmIdentifiableElement> T associate(EObject source, T target) {
		associator.associatePrimary(source, target);
		return target;
	}

	public JvmOperation toMethod(EObject ctx, String name, JvmTypeReference typeRef, Function1<JvmOperation, Void> init) {
		JvmOperation result = create(name, JvmOperation.class, init);
		if (!result.eIsSet(TypesPackage.Literals.JVM_MEMBER__VISIBILITY))
			result.setVisibility(JvmVisibility.PUBLIC);
		result.setReturnType(cloneWithProxies(typeRef));
		return associate(ctx,result);
	}

	public JvmOperation toGetter(EObject ctx, final String name, JvmTypeReference typeRef) {
		JvmOperation result = create(JvmOperation.class, null);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setSimpleName("get" + Strings.toFirstUpper(name));
		result.setReturnType(cloneWithProxies(typeRef));
		body(result, new Functions.Function1<ImportManager, CharSequence>() {
			public CharSequence apply(ImportManager p) {
				return "return this."+name+";";
			}
		});
		return associate(ctx,result);
	}

	public JvmOperation toSetter(EObject ctx, final String name, JvmTypeReference typeRef) {
		JvmOperation result = create(name, JvmOperation.class, null);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setSimpleName("set" + Strings.toFirstUpper(name));
		result.getParameters().add(toParameter(ctx, name, cloneWithProxies(typeRef)));
		body(result, new Functions.Function1<ImportManager, CharSequence>() {
			public CharSequence apply(ImportManager p) {
				return "this."+name+" = "+name+";";
			}
		});
		return associate(ctx,result);
	}

	public JvmFormalParameter toParameter(EObject ctx, String name, JvmTypeReference typeRef) {
		JvmFormalParameter result = create(JvmFormalParameter.class, null);
		result.setName(name);
		result.setParameterType(cloneWithProxies(typeRef));
		return associate(ctx,result);
	}

	public JvmGenericType toClazz(EObject ctx, String name, Function1<JvmGenericType, Void> init) {
		String simpleName = name;
		String packageName = null;
		final int dotIdx = name.lastIndexOf('.');
		if (dotIdx != -1) {
			simpleName = name.substring(dotIdx+1);
			packageName = name.substring(0, dotIdx);
		}
		final JvmGenericType create = create(simpleName, JvmGenericType.class, init);
		if (packageName!=null)
			create.setPackageName(packageName);
		create.setVisibility(JvmVisibility.PUBLIC);
		if (create.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Object.class, ctx);
			if (objectType != null)
				create.getSuperTypes().add(objectType);
		}
		return associate(ctx,create);
	}
	
	public JvmTypeReference cloneWithProxies(JvmTypeReference typeRef) {
		if (!typeRef.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE))
			throw new IllegalArgumentException("typeref#type was null");
		return EcoreUtil2.cloneWithProxies(typeRef);
	}

	public <T extends JvmMember> T create(String name, Class<T> clazz, Function1<T, Void> init) {
		T result = create(clazz, init);
		result.setSimpleName(name);
		return result;
	}

	@SuppressWarnings("unchecked")
	protected <T> T create(Class<T> clazz, Function1<T, Void> init) {
		EList<EClassifier> classifiers = TypesFactory.eINSTANCE.getEPackage().getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			if (eClassifier instanceof EClass && eClassifier.getInstanceClass() == clazz) {
				T result = (T) TypesFactory.eINSTANCE.create((EClass) eClassifier);
				if (init != null)
					init.apply(result);
				return result;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public void body(final JvmOperation op, Functions.Function1<ImportManager, CharSequence> strategy) {
		CompilationStrategyAdapter adapter = new CompilationStrategyAdapter();
		adapter.setCompilationStrategy(strategy);
		op.eAdapters().add(adapter);
	}
}
