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
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmExecutableBuilder extends MethodVisitor implements Opcodes {

	protected final Proxies proxies;

	private JvmDeclaredType declarator;
	
	private final JvmExecutable result;
	
	private final int offset;

	private String returnType;

    public JvmExecutableBuilder(
    	final JvmDeclaredType declarator,
    	final int initialOffset,
        Map<String, JvmTypeParameter> typeParameters,
        Proxies proxies,
        final int access,
        final String name,
        final String desc,
        final String signature,
        final String[] exceptions)
    {
    	super(Opcodes.ASM9);
    	this.proxies = proxies;
		this.declarator = declarator;
		final StringBuilder fqName;
		if (isConstructor(name)) {
			result = TypesFactory.eINSTANCE.createJvmConstructor();
			String declaratorIdentifier = declarator.getIdentifier();
			String simpleName = declarator.getSimpleName();
			fqName = new StringBuilder(declaratorIdentifier.length() + 1 + simpleName.length() + desc.length());
			fqName.append(declaratorIdentifier);
			fqName.append('.');
			fqName.append(simpleName);
			result.setSimpleName(simpleName);
			this.offset = initialOffset;
		} else {
			JvmOperation operation = TypesFactory.eINSTANCE.createJvmOperation();
			result = operation;
			String declaratorIdentifier = declarator.getIdentifier();
			fqName = new StringBuilder(declaratorIdentifier.length() + 1 + name.length() + desc.length());
			fqName.append(declaratorIdentifier);
			fqName.append('.');
			fqName.append(name);
			result.setSimpleName(name);
			this.offset = 0;
			
			operation.setAbstract((access & ACC_ABSTRACT) != 0);
			operation.setFinal((access & ACC_FINAL) != 0);
			operation.setStatic((access & ACC_STATIC) != 0);
			operation.setSynchronized((access & ACC_SYNCHRONIZED) != 0);
			operation.setStrictFloatingPoint((access & ACC_STRICT) != 0);
			operation.setNative((access & ACC_NATIVE) != 0);
			if (declarator.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) declarator).isInterface()) {
				if (!operation.isAbstract() && !operation.isStatic()) {
					operation.setDefault(true);
				}
			}
		}
		proxies.setVisibility(access, result);
		
		BinaryMethodSignature binarySignature = BinarySignatures.createMethodSignature(signature != null ? signature: desc);
		typeParameters = proxies.createTypeParameters(binarySignature, result, typeParameters);
		
		if (result.eClass() == TypesPackage.Literals.JVM_OPERATION) {
			returnType = desc;
			((JvmOperation) result).setReturnType(proxies.createTypeReference(binarySignature.getReturnType(), typeParameters));
		}
		
		fqName.append('(');
		List<BinaryGenericTypeSignature> parameterTypes = binarySignature.getParameterTypes();
		int myOffset = signature == null ? offset : 0;
		if (parameterTypes.size() > myOffset) {
//			char[][] argumentNames = method.getArgumentNames();
//			boolean hasArgumentNames = argumentNames != null && argumentNames.length != 0;
			InternalEList<JvmFormalParameter> parameters = (InternalEList<JvmFormalParameter>) result.getParameters();
			for (int i = myOffset; i < parameterTypes.size(); i++) {
				if (i != myOffset)
					fqName.append(',');
				
				BinaryTypeSignature parameterType = parameterTypes.get(i);
				fqName.append(parameterType.getTypeErasure().toIdentifier());
				parameters.addUnique(createFormalParameter(parameterType,
						"arg" + (i - myOffset), result,
						typeParameters));
			}
		}
		fqName.append(')');
		result.internalSetIdentifier(fqName.toString());
		proxies.setVisibility(access, result);
		result.setVarArgs((access & ACC_VARARGS) != 0);
		result.setDeprecated((access & ACC_DEPRECATED) != 0);

		List<BinaryGenericTypeSignature> exceptionSignatures = binarySignature.getExceptionTypes();
		if (exceptionSignatures.size() == 0) {
			if (exceptions != null) {
				InternalEList<JvmTypeReference> resultExceptions = (InternalEList<JvmTypeReference>) result
						.getExceptions();
				for (int i = 0, max = exceptions.length; i < max; i++) {
					resultExceptions.addUnique(proxies.createTypeReference(BinarySignatures.createObjectTypeSignature(exceptions[i]), typeParameters));
				}
			}
		} else {
			InternalEList<JvmTypeReference> resultExceptions = (InternalEList<JvmTypeReference>) result.getExceptions();
			for (int i = 0, max = exceptionSignatures.size(); i < max; i++) {
				resultExceptions.addUnique(proxies.createTypeReference(exceptionSignatures.get(i), typeParameters));
			}
		}
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
    
	protected JvmFormalParameter createFormalParameter(BinaryTypeSignature parameterType, String paramName,
			JvmMember container, Map<String, JvmTypeParameter> typeParameters) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(paramName);
		result.setParameterType(proxies.createTypeReference(parameterType, typeParameters));
		return result;
	}
    
    // ------------------------------------------------------------------------
    // Implementation of the MethodVisitor interface
    // ------------------------------------------------------------------------

    @Override
	public AnnotationVisitor visitAnnotationDefault() {
    	return new JvmAnnotationValueBuilder(proxies) {
			
    		int array = 0;
    		
			@Override
			public void visitEnd() {
				if (array == 0) {
					JvmOperation operation = (JvmOperation) JvmExecutableBuilder.this.result;
					if (result == null) {
						
						if (returnType.equals("()[Ljava/lang/Class;")) {
							result = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
						} else if (returnType.length() == 4 /* ()[I */ ) {
							switch (returnType.charAt(3)) {
								case 'B':
									result = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
									break;
								case 'C':
									result = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
									break;
								case 'D':
									result = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
									break;
								case 'F':
									result = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
									break;
								case 'I':
									result = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
									break;
								case 'J':
									result = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
									break;
								case 'S':
									result = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
									break;
								case 'Z':
									result = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
									break;
								default:
									throw new IllegalArgumentException(returnType.toString());
							}
						} else {
							result = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
						}
					}
					result.setOperation(operation);
					operation.setDefaultValue(result);
				} else {
					array--;
				}
			}
			
			@Override
			public AnnotationVisitor visitArray(String name) {
				array++;
				return this;
			}
		};
    }
    
	@Override
	public AnnotationVisitor visitParameterAnnotation(final int parameter, final String desc, final boolean visible) {
			JvmFormalParameter formalParameter = result.getParameters().get(parameter);
			return new JvmAnnotationReferenceBuilder(
					(InternalEList<JvmAnnotationReference>) formalParameter.getAnnotations(), desc, proxies);
	}

    @Override
	public void visitCode() {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitFrame(
        final int type,
        final int nLocal,
        final Object[] local,
        final int nStack,
        final Object[] stack)
    {
        throw new UnsupportedOperationException();
    }

    @Override
	public void visitInsn(final int opcode) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitIntInsn(final int opcode, final int operand) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitVarInsn(final int opcode, final int var) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitTypeInsn(final int opcode, final String type) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitFieldInsn(
        final int opcode,
        final String owner,
        final String name,
        final String desc)
    {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitMethodInsn(
        final int opcode,
        final String owner,
        final String name,
        final String desc, 
        final boolean itf)
    {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitJumpInsn(final int opcode, final Label label) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitLabel(final Label label) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitLdcInsn(final Object cst) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitIincInsn(final int var, final int increment) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitTableSwitchInsn(
        final int min,
        final int max,
        final Label dflt,
        final Label... labels)
    {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitLookupSwitchInsn(
        final Label dflt,
        final int[] keys,
        final Label[] labels)
    {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitMultiANewArrayInsn(final String desc, final int dims) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitTryCatchBlock(
        final Label start,
        final Label end,
        final Label handler,
        final String type)
    {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitLocalVariable(
        final String name,
        final String desc,
        final String signature,
        final Label start,
        final Label end,
        final int index)
    {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitLineNumber(final int line, final Label start) {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void visitMaxs(final int maxStack, final int maxLocals) {
    	throw new UnsupportedOperationException();
    }

		/**
	 * Answer true if the method is a constructor, false otherwise.
	 * 
	 * @return boolean
	 */
	private boolean isConstructor(String selector) {
		return selector.charAt(0) == '<' && selector.length() == 6; // Can only match <init>
	}

}
