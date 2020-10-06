/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.util.Map;

import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmFieldBuilder extends FieldVisitor implements Opcodes {

	protected final Proxies proxies;

    private final JvmDeclaredType declarator;
    private final JvmField result;
	public JvmFieldBuilder(
		JvmDeclaredType declarator,
        Map<String, JvmTypeParameter> typeParameters,
        Proxies proxies,
        final int access,
        final String name,
        final String desc,
        final String signature,
        final Object value)
    {
		super(Opcodes.ASM9);
		this.proxies = proxies;
		this.declarator = declarator;
        if ((access & ACC_ENUM) != 0) {
        	result = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
        } else {
        	result = TypesFactory.eINSTANCE.createJvmField();
        	if (value != null) {
        		result.setConstant(true);
        		if (desc.length() == 1) {
        			switch (desc.charAt(0)) {
        				case 'Z':
        					result.setConstantValue(((Integer)value).intValue() != 0);
        					break;
        	            case 'C':
        	                result.setConstantValue((char) ((Integer) value).intValue());
        	                break;
        	            case 'B':
        	            	result.setConstantValue(((Number) value).byteValue());
        	                break;
        	            case 'S':
        	            	result.setConstantValue(((Number) value).shortValue());
        	                break;
        	            default:
        	            	result.setConstantValue(value);
        			}
        		} else {
        			result.setConstantValue(value);
        		}
        	} else {
        		result.setConstant(false);
        	}
        }
		result.internalSetIdentifier(declarator.getIdentifier() + "." + name);
		result.setSimpleName(name);
		result.setFinal((access & ACC_FINAL) != 0);
		result.setStatic((access & ACC_STATIC) != 0);
		result.setTransient((access & ACC_TRANSIENT) != 0);
		result.setVolatile((access & ACC_VOLATILE) != 0);
		result.setDeprecated((access & ACC_DEPRECATED) != 0);
		proxies.setVisibility(access, result);
		result.setType(proxies.createTypeReference(BinarySignatures.createTypeSignature(signature != null ? signature : desc), typeParameters));
    }
    
    @Override
	public void visitAttribute(Attribute attr) {
    	// nothing to do
    }
    
	@Override
	public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
		return new JvmAnnotationReferenceBuilder((InternalEList<JvmAnnotationReference>) result
				.getAnnotations(), desc, proxies);
	}

	@Override
    public void visitEnd() {
    	InternalEList<JvmMember> members = (InternalEList<JvmMember>) declarator.getMembers();
    	members.addUnique(result);
    }

}
