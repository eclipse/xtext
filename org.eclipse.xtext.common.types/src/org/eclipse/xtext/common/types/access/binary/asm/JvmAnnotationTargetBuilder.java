/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.impl.JvmTypeConstraintImplCustom;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmAnnotationTargetBuilder implements Opcodes {

	protected final Proxies proxies;

	protected JvmAnnotationTargetBuilder(Proxies proxies) {
		this.proxies = proxies;
	}

	protected abstract JvmAnnotationTarget getInstance();

	public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
		return new JvmAnnotationReferenceBuilder((InternalEList<JvmAnnotationReference>) this.getInstance()
				.getAnnotations(), desc, proxies);
	}

	public void visitEnd() {
	}

	protected void setVisibility(int accessFlags, JvmMember result) {
		switch (accessFlags & (ACC_PRIVATE | ACC_PROTECTED | ACC_PUBLIC)) {
			case ACC_PRIVATE:
				result.setVisibility(JvmVisibility.PRIVATE);
				return;
			case ACC_PROTECTED:
				result.setVisibility(JvmVisibility.PROTECTED);
				return;
			case ACC_PUBLIC:
				result.setVisibility(JvmVisibility.PUBLIC);
				return;
			default:
				result.setVisibility(JvmVisibility.DEFAULT);
				return;
		}
	}

	/**
	 * Answer true if the method is a class initializer, false otherwise.
	 * 
	 * @return boolean
	 */
	protected boolean isClinit(String selector) {
		return selector.charAt(0) == '<' && selector.length() == 8; // Can only match <clinit>
	}

	/**
	 * Answer true if the method is a constructor, false otherwise.
	 * 
	 * @return boolean
	 */
	protected boolean isConstructor(String selector) {
		return selector.charAt(0) == '<' && selector.length() == 6; // Can only match <init>
	}

	protected Map<String, JvmTypeParameter> createTypeParameters(AbstractBinarySignature signature,
			JvmTypeParameterDeclarator container, Map<String, JvmTypeParameter> knownTypeParameters) {

		List<BinaryTypeParameter> typeParameters = signature.getTypeParameters();
		if (typeParameters.size() != 0) {
			Map<String, JvmTypeParameter> result = Maps
					.newHashMapWithExpectedSize((knownTypeParameters != null ? knownTypeParameters.size() : 0)
							+ typeParameters.size());
			if (knownTypeParameters != null)
				result.putAll(knownTypeParameters);
			InternalEList<JvmTypeParameter> jvmTypeParameters = (InternalEList<JvmTypeParameter>) container
					.getTypeParameters();
			for (int i = 0; i < typeParameters.size(); i++) {
				JvmTypeParameter typeParameter = TypesFactory.eINSTANCE.createJvmTypeParameter();
				String name = typeParameters.get(i).getName();
				typeParameter.setName(name);
				jvmTypeParameters.addUnique(typeParameter);
				result.put(name, typeParameter);
			}

			for (int i = 0; i < typeParameters.size(); i++) {
				List<BinaryGenericTypeSignature> bounds = typeParameters.get(i).getBounds();
				JvmTypeParameter typeParameter = jvmTypeParameters.get(i);
				InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>) typeParameter
						.getConstraints();
				for (int j = 0; j < bounds.size(); j++) {
					JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
					((JvmTypeConstraintImplCustom) upperBound).internalSetTypeReference(proxies.createTypeReference(bounds.get(j), result));
					constraints.addUnique(upperBound);
				}
			}
			return result;
		}
		return knownTypeParameters;
	}
}
