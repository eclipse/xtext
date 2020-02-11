/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmDeclaredTypeBuilder extends ClassVisitor implements Opcodes {

	protected final Proxies proxies;

    protected JvmDeclaredType result;
    
    protected int offset = 0;
    
    private Map<String, JvmTypeParameter> typeParameters;

	private final ClassLoader classLoader;

	private final BinaryClass binaryClass;

	private final ClassFileBytesAccess bytesAccess;

    public JvmDeclaredTypeBuilder(BinaryClass binaryClass, ClassFileBytesAccess bytesAccess, ClassLoader classLoader) {
		this(binaryClass, bytesAccess, classLoader, null, new Proxies());
	}
    
    protected JvmDeclaredTypeBuilder(BinaryClass binaryClass, ClassFileBytesAccess bytesAccess, ClassLoader classLoader, Map<String, JvmTypeParameter> typeParameters, Proxies proxies) {
    	super(Opcodes.ASM7);
    	this.proxies = proxies;
		this.binaryClass = binaryClass;
		this.bytesAccess = bytesAccess;
		this.classLoader = classLoader;
		this.typeParameters = typeParameters;
    }

    public JvmDeclaredType buildType() {
    	byte[] bytes = bytesAccess.getBytes(binaryClass);
    	if (bytes == null) {
    		return null;
    	}
		ClassReader reader = new ClassReader(bytes);
		reader.accept(this, 
			  ClassReader.SKIP_DEBUG 
			| ClassReader.SKIP_FRAMES 
			| ClassReader.SKIP_CODE
		);
		return result;
	}
    
    // ------------------------------------------------------------------------
    // Implementation of the ClassVisitor interface
    // ------------------------------------------------------------------------

    @Override
	public void visit(
        final int version,
        final int access,
        final String name,
        final String signature,
        final String superName,
        final String[] interfaces)
    {
    	if ((access & ACC_SYNTHETIC) != 0)
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
    	if ((ACC_ENUM & access) != 0) {
    		result = TypesFactory.eINSTANCE.createJvmEnumerationType();
    		offset = 2;
    	} else if ((ACC_ANNOTATION & access) != 0) {
    		result = TypesFactory.eINSTANCE.createJvmAnnotationType();
    	} else {
    		JvmGenericType generic = TypesFactory.eINSTANCE.createJvmGenericType(); 
    		result = generic;

    		generic.setInterface((access & ACC_INTERFACE) != 0);
    		generic.setStrictFloatingPoint((access & ACC_STRICT) != 0);
    	}
    	setTypeModifiers(access);
    	
    	proxies.setVisibility(access, result);
    	
    	setNameAndPackage(name);

    	BinarySuperTypeSignature genericSignature = null;
		if (signature != null) {
			if ((access & (ACC_STATIC | ACC_INTERFACE)) != 0) {
				typeParameters = Collections.emptyMap();
			}
			genericSignature = BinarySignatures.createSuperTypeSignature(signature);
			if (((ACC_ENUM | ACC_ANNOTATION) & access) == 0) {
				typeParameters = proxies.createTypeParameters(genericSignature, (JvmTypeParameterDeclarator) result, typeParameters);
			}
		}
		setSuperTypes(name, genericSignature, superName, interfaces);
    }
    
	@Override
	public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
		return new JvmAnnotationReferenceBuilder((InternalEList<JvmAnnotationReference>) result
				.getAnnotations(), desc, proxies);
	}

	@Override
	public void visitEnd() {
	}
    
    @Override
	public void visitAttribute(Attribute attr) {
    	// ignore
    }

    private void setSuperTypes(String name, BinarySuperTypeSignature signature, String superName, String[] interfaces) {
    	InternalEList<JvmTypeReference> superTypes = (InternalEList<JvmTypeReference>) result.getSuperTypes();
		if (signature != null) {
			List<BinaryGenericTypeSignature> superTypeSignatures = signature.getSuperTypes();
			if (result.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) result).isInterface()) {
				if (superTypeSignatures.size() > 1) {
					superTypeSignatures = superTypeSignatures.subList(1, superTypeSignatures.size());
				}
			}
			for (int i = 0; i < superTypeSignatures.size(); i++) {
				superTypes.addUnique(proxies.createTypeReference(superTypeSignatures.get(i), typeParameters));
			}
		} else {
			if (superName != null && result.eClass() != TypesPackage.Literals.JVM_ANNOTATION_TYPE) {
				superTypes.addUnique(proxies.createTypeReference(BinarySignatures.createObjectTypeSignature(superName), typeParameters));
			}
			setInterfaces(interfaces, typeParameters, superTypes);
			if (superTypes.isEmpty() && !Proxies.JAVA_LANG_OBJECT.equals(name)) {
				superTypes.addUnique(proxies.createObjectTypeReference());
			}
		}
	}
    
    protected void setInterfaces(String[] interfaces, Map<String, JvmTypeParameter> typeParameters,
			InternalEList<JvmTypeReference> result) {
		if (interfaces != null) {
			for (int i = 0; i < interfaces.length; i++) {
				String interfaceName = interfaces[i];
				result.addUnique(proxies.createTypeReference(BinarySignatures.createObjectTypeSignature(interfaceName), typeParameters));
			}
		}
	}
    
    protected void setNameAndPackage(String binaryName) {
    	int slash = binaryName.lastIndexOf('/');
    	if (slash == -1) { // no package
    		result.setSimpleName(binaryName);
    		result.internalSetIdentifier(binaryName);
    	} else {
    		String identifier = binaryName.replace('/', '.');
    		String simpleName = identifier.substring(slash + 1);
    		result.setSimpleName(simpleName);
    		String packageName = identifier.substring(0, slash);
    		result.setPackageName(packageName);
    		result.internalSetIdentifier(identifier);
    	}
	}
    
    protected void setTypeModifiers(int accessFlags) {
		result.setAbstract((accessFlags & ACC_ABSTRACT) != 0);
		result.setStatic((accessFlags & ACC_STATIC) != 0);
		result.setDeprecated((accessFlags & ACC_DEPRECATED) != 0);
		if (result.eClass() != TypesPackage.Literals.JVM_ENUMERATION_TYPE) {
			if (result.isStatic()) {
				offset = 0;
			}
			result.setFinal((accessFlags & ACC_FINAL) != 0);
		}
	}

    @Override
	public void visitSource(final String file, final String debug) {
        // ignore
    }

    @Override
	public void visitOuterClass(
        final String owner,
        final String name,
        final String desc)
    {
    	throw new IllegalStateException("Expected top-level type");
    }

    @Override
	public void visitInnerClass(
        final String name,
        final String outerName,
        final String innerName,
        final int access)
    {
    	if (outerName != null && innerName != null && outerName.replace('/', '.').equals(result.getIdentifier())) {
    		BinaryClass binaryClass = new BinaryClass(name, classLoader);
    		boolean isStatic = (access & ACC_STATIC) != 0;
			NestedJvmDeclaredTypeBuilder builder = new NestedJvmDeclaredTypeBuilder(
    				innerName,
    				!isStatic? 1 : 0, 
    				binaryClass,
    				bytesAccess,
    				classLoader,
    				typeParameters,
    				proxies);
    		JvmDeclaredType nestedType = builder.buildType();
    		if (nestedType != null) {
	    		if (isStatic) {
	    			nestedType.setStatic(isStatic);
	    		}
	    		proxies.setVisibility(access, nestedType);
	    		result.getMembers().add(nestedType);
    		}
    	}
    }
    
    static class NestedJvmDeclaredTypeBuilder extends JvmDeclaredTypeBuilder {

		private final String innerName;

		protected NestedJvmDeclaredTypeBuilder(
				String innerName,
				int offset,
				BinaryClass binaryClass,
				ClassFileBytesAccess bytesAccess,
				ClassLoader classLoader,
				Map<String, JvmTypeParameter> typeParameters,
				Proxies proxies) {
			super(binaryClass, bytesAccess, classLoader, typeParameters, proxies);
			this.innerName = innerName;
			this.offset = offset;
		}
		
		@Override
		protected void setTypeModifiers(int accessFlags) {
			super.setTypeModifiers(accessFlags);
			if (result.eClass() != TypesPackage.Literals.JVM_GENERIC_TYPE) {
				result.setStatic(true);
			} else if (((JvmGenericType) result).isInterface()) {
				result.setStatic(true);
			}
		}
		
		@Override
		public void visitOuterClass(String owner, String name, String desc) {
			// ignore
		}
		
		@Override
		protected void setNameAndPackage(String binaryName) {
    		String identifier = binaryName.replace('/', '.');
    		result.setSimpleName(innerName);
			result.internalSetIdentifier(identifier);
		}
    	
    }
    
    @Override
	public FieldVisitor visitField(
        final int access,
        final String name,
        final String desc,
        final String signature,
        final Object value)
    {
    	if ((access & ACC_SYNTHETIC) == 0) {
	        JvmFieldBuilder fieldBuilder = new JvmFieldBuilder(
	        		result,
	        		(access & ACC_STATIC) == 0 ? typeParameters : null,
	        		proxies,
    				access,
	        		name,
	        		desc,
	        		signature,
	        		value);
	        return fieldBuilder;
    	}
    	return null;
    }

    @Override
	public MethodVisitor visitMethod(
        final int access,
        final String name,
        final String desc,
        final String signature,
        final String[] exceptions)
    {
    	if ((access & (ACC_SYNTHETIC | ACC_BRIDGE)) == 0 && !isClinit(name)) {
    		JvmExecutableBuilder builder = new JvmExecutableBuilder(
    				result,
    				offset,
    				(access & ACC_STATIC) == 0 ? typeParameters : null,
					proxies,
    				access,
                    name,
                    desc,
                    signature,
                    exceptions);
            return builder;
    	}
    	return null;
    }

    /**
	 * Answer true if the method is a class initializer, false otherwise.
	 * 
	 * @return boolean
	 */
	private boolean isClinit(String selector) {
		return selector.charAt(0) == '<' && selector.length() == 8; // Can only match <clinit>
	}
}
