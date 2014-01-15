/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import static org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;
import org.eclipse.jdt.internal.compiler.classfmt.FieldInfo;
import org.eclipse.jdt.internal.compiler.env.ClassSignature;
import org.eclipse.jdt.internal.compiler.env.EnumConstantSignature;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;
import org.eclipse.jdt.internal.compiler.env.IBinaryElementValuePair;
import org.eclipse.jdt.internal.compiler.env.IBinaryField;
import org.eclipse.jdt.internal.compiler.env.IBinaryMethod;
import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TagBits;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.TypeIds;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.binary.signatures.AbstractBinarySignature;
import org.eclipse.xtext.common.types.access.binary.signatures.BinaryGenericTypeSignature;
import org.eclipse.xtext.common.types.access.binary.signatures.BinaryMethodSignature;
import org.eclipse.xtext.common.types.access.binary.signatures.BinarySignatures;
import org.eclipse.xtext.common.types.access.binary.signatures.BinarySimpleMemberSignature;
import org.eclipse.xtext.common.types.access.binary.signatures.BinarySuperTypeSignature;
import org.eclipse.xtext.common.types.access.binary.signatures.BinaryTypeArgumentSignature;
import org.eclipse.xtext.common.types.access.binary.signatures.BinaryTypeParameter;
import org.eclipse.xtext.common.types.access.binary.signatures.BinaryTypeSignature;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.common.types.impl.JvmTypeConstraintImplCustom;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ClassReaderTypeFactory implements ITypeFactory<BinaryClass> {

	private static final char[] SIG_JAVA_LANG_OBJECT = "java/lang/Object".toCharArray();

	private final StoppedTask createTypeTask = Stopwatches.forTask("ClassReaderTypeFactory.createType");

	/**
	 * A cache mapping each type to its corresponding type proxy. It's demand populated when
	 * {@link #createProxy(BinaryTypeSignature, Map) creating} a type proxy.
	 */
	private final Map<BinaryTypeSignature, JvmType> typeProxies = new HashMap<BinaryTypeSignature, JvmType>();

	/**
	 * A cache mapping each method to its corresponding operation proxy. It's demand populated when
	 * {@link #createMethodProxy(BinaryTypeSignature, char[]) creating} a method proxy.
	 */
	private final Map<BinarySimpleMemberSignature, JvmOperation> operationProxies = new HashMap<BinarySimpleMemberSignature, JvmOperation>();

	/**
	 * The classLoader that is used to find the class files for nested types.
	 */
	private final ClassLoader classLoader;

	private final ClassFileReaderAccess readerAccess;

	@Inject
	public ClassReaderTypeFactory(ClassFileReaderAccess readerAccess, ClassLoader loader) {
		this.readerAccess = readerAccess;
		this.classLoader = loader;
	}

	/**
	 * Creates a new {@link JvmDeclaredType type} from the given binary class..
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public JvmType createType(BinaryClass binaryClass) {
		try {
			createTypeTask.start();
			return doCreateType(binaryClass, false, null);
		} catch (ClassFormatException e) {
			return null;
		} finally {
			createTypeTask.stop();
		}
	}

	protected JvmDeclaredType doCreateType(BinaryClass binaryClass, boolean allowInner,
			Map<String, JvmTypeParameter> typeParameters) throws ClassFormatException {
		IBinaryType classFile = getBinaryType(binaryClass);
		if (allowInner != isNestedType(classFile)) {
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
		}
		return createType(classFile, typeParameters);
	}

	protected ClassFileReader getBinaryType(BinaryClass binaryClass) throws ClassFormatException {
		return readerAccess.getClassFileReader(binaryClass);
	}

	public JvmDeclaredType createType(IBinaryType classFile, Map<String, JvmTypeParameter> typeParameters) {
		final JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();

		int modifiers = classFile.getModifiers();
		if ((modifiers & AccSynthetic) != 0 || classFile.isAnonymous())
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
		if ((modifiers & AccAnnotation) != 0)
			return createAnnotationType(classFile);
		if ((modifiers & AccEnum) != 0)
			return createEnumerationType(classFile);

		result.setInterface((modifiers & AccInterface) != 0);
		result.setStrictFloatingPoint((modifiers & AccStrictfp) != 0);

		setTypeModifiers(modifiers, result);
		setVisibility(modifiers, result);

		setNameAndPackage(classFile, result);

		char[] signature = classFile.getGenericSignature();
		BinarySuperTypeSignature genericSignature = null;
		if (signature != null) {
			if ((modifiers & (AccStatic | AccInterface)) != 0) {
				typeParameters = Collections.emptyMap();
			}
			genericSignature = BinarySignatures.createSuperTypeSignature(signature);
			typeParameters = createTypeParameters(genericSignature, result, typeParameters);
		}

		createNestedTypes(classFile, result, typeParameters);
		createMethods(classFile, result, typeParameters);
		int offset = 0;
		if (isNestedType(classFile) && !result.isStatic())
			offset = 1;
		createConstructors(classFile, result, offset, typeParameters);
		createFields(classFile, result, typeParameters);

		setSuperTypes(classFile, genericSignature, result, typeParameters);

		createAnnotationValues(classFile.getAnnotations(), classFile.getTagBits(), result);
		return result;
	}

	protected void setNameAndPackage(IBinaryType classFile, final JvmDeclaredType result) {
		BinaryTypeSignature typeSignature = BinarySignatures.createTypeSignature(classFile.getName());
		String identifier = typeSignature.toIdentifier();
		result.internalSetIdentifier(identifier);
		String simpleName = String.valueOf(classFile.getSourceName());
		result.setSimpleName(simpleName);
		if (!isNestedType(classFile)) {
			// only set package name for outermost class
			if (identifier.length() != simpleName.length()) {
				result.setPackageName(identifier.substring(0, identifier.length() - simpleName.length() - 1));
			}
		}
	}

	private boolean isNestedType(IBinaryType type) {
		return ((ClassFileReader) type).isNestedType();
	}

	/**
	 * @param tagBits
	 *            a bit mask that is used to encode standard annotation values, e.g. {@code @Target} or
	 *            {@code @Deprecated}
	 */
	protected void createAnnotationValues(final IBinaryAnnotation[] annotations, long tagBits,
			final JvmAnnotationTarget result) {
		if (annotations != null) {
			InternalEList<JvmAnnotationReference> target = (InternalEList<JvmAnnotationReference>) result
					.getAnnotations();
			for (int i = 0; i < annotations.length; i++) {
				IBinaryAnnotation annotation = annotations[i];
				target.addUnique(createAnnotationReference(annotation));
			}
		}
		createStandardAnnotationValues(tagBits, result);
	}

	private static final BinaryTypeSignature JAVA_LANG_ANNOTATION_TARGET = BinarySignatures
			.createTypeSignature(CharOperation.concatWith(TypeConstants.JAVA_LANG_ANNOTATION_TARGET, '/'));
	private static final BinaryTypeSignature JAVA_LANG_ANNOTATION_ELEMENTTYPE = BinarySignatures
			.createTypeSignature(CharOperation.concatWith(TypeConstants.JAVA_LANG_ANNOTATION_ELEMENTTYPE, '/'));
	private static final BinaryTypeSignature JAVA_LANG_ANNOTATION_RETENTION = BinarySignatures
			.createTypeSignature(CharOperation.concatWith(TypeConstants.JAVA_LANG_ANNOTATION_RETENTION, '/'));
	private static final BinaryTypeSignature JAVA_LANG_ANNOTATION_RETENTIONPOLICY = BinarySignatures
			.createTypeSignature(CharOperation.concatWith(TypeConstants.JAVA_LANG_ANNOTATION_RETENTIONPOLICY, '/'));
	private static final BinaryTypeSignature JAVA_LANG_DEPRECATED = BinarySignatures.createTypeSignature(CharOperation
			.concatWith(TypeConstants.JAVA_LANG_DEPRECATED, '/'));
	private static final BinaryTypeSignature JAVA_LANG_ANNOTATION_DOCUMENTED = BinarySignatures
			.createTypeSignature(CharOperation.concatWith(TypeConstants.JAVA_LANG_ANNOTATION_DOCUMENTED, '/'));
	private static final BinaryTypeSignature JAVA_LANG_ANNOTATION_INHERITED = BinarySignatures
			.createTypeSignature(CharOperation.concatWith(TypeConstants.JAVA_LANG_ANNOTATION_INHERITED, '/'));
	private static final BinaryTypeSignature JAVA_LANG_INVOKE_METHODHANDLE_$_POLYMORPHICSIGNATURE = BinarySignatures
			.createTypeSignature("java/lang/invoke/MethodHandle$PolymorphicSignature".toCharArray());
	private static final BinaryTypeSignature JAVA_LANG_SAFEVARARGS = BinarySignatures
			.createTypeSignature("java/lang/SafeVarargs".toCharArray());
	private static final char[] VALUE = TypeConstants.VALUE;

	private void createStandardAnnotationValues(long tagBits, JvmAnnotationTarget result) {
		if ((tagBits & (TagBits.AllStandardAnnotationsMask | ASTNode.Bit53L | ASTNode.Bit52L)) == 0)
			return;
		InternalEList<JvmAnnotationReference> target = (InternalEList<JvmAnnotationReference>) result.getAnnotations();
		if ((tagBits & TagBits.AnnotationTargetMASK) != 0) {
			target.addUnique(generateStandardAnnotation(JAVA_LANG_ANNOTATION_TARGET, getTargetElementTypes(tagBits)));
		}
		if ((tagBits & TagBits.AnnotationRetentionMASK) != 0) {
			target.addUnique(generateStandardAnnotation(JAVA_LANG_ANNOTATION_RETENTION, getRetentionPolicy(tagBits)));
		}
		if ((tagBits & TagBits.AnnotationDeprecated) != 0) {
			target.addUnique(generateStandardAnnotation(JAVA_LANG_DEPRECATED, null));
		}
		if ((tagBits & TagBits.AnnotationDocumented) != 0) {
			target.addUnique(generateStandardAnnotation(JAVA_LANG_ANNOTATION_DOCUMENTED, null));
		}
		if ((tagBits & TagBits.AnnotationInherited) != 0) {
			target.addUnique(generateStandardAnnotation(JAVA_LANG_ANNOTATION_INHERITED, null));
		}
		if ((tagBits & ASTNode.Bit53L /* TagBits.AnnotationPolymorphicSignature */) != 0) {
			target.addUnique(generateStandardAnnotation(JAVA_LANG_INVOKE_METHODHANDLE_$_POLYMORPHICSIGNATURE, null));
		}
		if ((tagBits & ASTNode.Bit52L /* TagBits.AnnotationSafeVarargs */) != 0) {
			target.addUnique(generateStandardAnnotation(JAVA_LANG_SAFEVARARGS, null));
		}
		// note that JAVA_LANG_SUPPRESSWARNINGS and JAVA_LANG_OVERRIDE cannot appear in binaries
	}

	private JvmAnnotationReference generateStandardAnnotation(BinaryTypeSignature annotationType,
			List<JvmEnumerationLiteral> enumLiterals) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		annotationReference.setAnnotation(createAnnotationProxy(annotationType));
		if (enumLiterals != null) {
			InternalEList<JvmAnnotationValue> values = (InternalEList<JvmAnnotationValue>) annotationReference
					.getExplicitValues();
			JvmEnumAnnotationValue enumAnnotationValue = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
			JvmOperation value = createMethodProxy(annotationType, VALUE);
			enumAnnotationValue.setOperation(value);
			((InternalEList<JvmEnumerationLiteral>) enumAnnotationValue.getValues()).addAllUnique(enumLiterals);
			values.addUnique(enumAnnotationValue);
		}
		return annotationReference;
	}

	private List<JvmEnumerationLiteral> getTargetElementTypes(long tagBits) {
		List<JvmEnumerationLiteral> result = Lists.newArrayListWithCapacity(2);
		if ((tagBits & TagBits.AnnotationForType) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.TYPE, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if ((tagBits & TagBits.AnnotationForField) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.UPPER_FIELD, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if ((tagBits & TagBits.AnnotationForMethod) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.UPPER_METHOD, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if ((tagBits & TagBits.AnnotationForParameter) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.UPPER_PARAMETER, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if ((tagBits & TagBits.AnnotationForConstructor) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.UPPER_CONSTRUCTOR, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if ((tagBits & TagBits.AnnotationForLocalVariable) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.UPPER_LOCAL_VARIABLE, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if ((tagBits & TagBits.AnnotationForAnnotationType) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.UPPER_ANNOTATION_TYPE, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if ((tagBits & TagBits.AnnotationForPackage) != 0) {
			result.add(createEnumLiteralProxy(TypeConstants.UPPER_PACKAGE, JAVA_LANG_ANNOTATION_ELEMENTTYPE));
		}
		if (!result.isEmpty()) {
			return result;
		}
		if ((tagBits & TagBits.AnnotationTarget) != 0) {
			return result;
		}
		return null;
	}

	private List<JvmEnumerationLiteral> getRetentionPolicy(long tagBits) {
		if ((tagBits & TagBits.AnnotationRetentionMASK) == 0)
			return null;
		if ((tagBits & TagBits.AnnotationRuntimeRetention) == TagBits.AnnotationRuntimeRetention) {
			// TagBits.AnnotationRuntimeRetention combines both TagBits.AnnotationClassRetention & TagBits.AnnotationSourceRetention
			return Collections.singletonList(createEnumLiteralProxy(TypeConstants.UPPER_RUNTIME,
					JAVA_LANG_ANNOTATION_RETENTIONPOLICY));
		} else if ((tagBits & TagBits.AnnotationSourceRetention) != 0) {
			return Collections.singletonList(createEnumLiteralProxy(TypeConstants.UPPER_SOURCE,
					JAVA_LANG_ANNOTATION_RETENTIONPOLICY));
		} else {
			return Collections.singletonList(createEnumLiteralProxy(TypeConstants.UPPER_CLASS,
					JAVA_LANG_ANNOTATION_RETENTIONPOLICY));
		}
	}

	protected JvmAnnotationReference createAnnotationReference(IBinaryAnnotation annotation) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		BinaryTypeSignature annotationType = BinarySignatures.createTypeSignature(annotation.getTypeName());
		annotationReference.setAnnotation(createAnnotationProxy(annotationType));

		IBinaryElementValuePair[] elementValuePairs = annotation.getElementValuePairs();
		for (int i = 0; i < elementValuePairs.length; i++) {
			InternalEList<JvmAnnotationValue> values = (InternalEList<JvmAnnotationValue>) annotationReference
					.getExplicitValues();
			IBinaryElementValuePair elementValuePair = elementValuePairs[i];
			Object value = elementValuePair.getValue();
			if (value instanceof Object[]) {
				JvmAnnotationValue annotationValue = createArrayAnnotationValue((Object[]) value);
				values.addUnique(annotationValue);
				annotationValue.setOperation(createMethodProxy(annotationType, elementValuePair.getName()));
			} else {
				JvmAnnotationValue annotationValue = createAnnotationValue(value);
				values.addUnique(annotationValue);
				annotationValue.setOperation(createMethodProxy(annotationType, elementValuePair.getName()));
			}
		}
		return annotationReference;
	}

	protected JvmEnumerationLiteral createEnumLiteralProxy(char[] literalName, char[] typeName) {
		return createEnumLiteralProxy(literalName, BinarySignatures.createTypeSignature(typeName));
	}

	protected JvmEnumerationLiteral createEnumLiteralProxy(char[] literalName, BinaryTypeSignature typeName) {
		JvmEnumerationLiteral enumLiteralProxy = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		InternalEObject internalEObject = (InternalEObject) enumLiteralProxy;
		BinarySimpleMemberSignature fieldSignature = typeName.appendField(literalName);
		URI uri = fieldSignature.getURI();
		internalEObject.eSetProxyURI(uri);
		return enumLiteralProxy;
	}

	protected JvmAnnotationValue createArrayAnnotationValue(Object[] values) {
		if (values.length >= 1) {
			JvmAnnotationValue result = createAnnotationValue(values[0]);
			for (int i = 1; i < values.length; i++) {
				Object value = values[i];
				if (value instanceof Constant) {
					Constant c = (Constant) value;
					switch (c.typeID()) {
						case TypeIds.T_int: {
							((InternalEList<Integer>) ((JvmIntAnnotationValue) result).getValues()).addUnique(c
									.intValue());
							break;
						}
						case TypeIds.T_byte: {
							((InternalEList<Byte>) ((JvmByteAnnotationValue) result).getValues()).addUnique(c
									.byteValue());
							break;
						}
						case TypeIds.T_short: {
							((InternalEList<Short>) ((JvmShortAnnotationValue) result).getValues()).addUnique(c
									.shortValue());
							break;
						}
						case TypeIds.T_char: {
							((InternalEList<Character>) ((JvmCharAnnotationValue) result).getValues()).addUnique(c
									.charValue());
							break;
						}
						case TypeIds.T_float: {
							((InternalEList<Float>) ((JvmFloatAnnotationValue) result).getValues()).addUnique(c
									.floatValue());
							break;
						}
						case TypeIds.T_double: {
							((InternalEList<Double>) ((JvmDoubleAnnotationValue) result).getValues()).addUnique(c
									.doubleValue());
							break;
						}
						case TypeIds.T_boolean: {
							((InternalEList<Boolean>) ((JvmBooleanAnnotationValue) result).getValues()).addUnique(c
									.booleanValue());
							break;
						}
						case TypeIds.T_long: {
							((InternalEList<Long>) ((JvmLongAnnotationValue) result).getValues()).addUnique(c
									.longValue());
							break;
						}
						case TypeIds.T_JavaLangString: {
							((InternalEList<String>) ((JvmStringAnnotationValue) result).getValues()).addUnique(c
									.stringValue());
							break;
						}
					}
				}
				if (value instanceof ClassSignature) {
					char[] typeName = ((ClassSignature) value).getTypeName();
					((InternalEList<JvmTypeReference>) ((JvmTypeAnnotationValue) result).getValues())
							.addUnique(createTypeReference(BinarySignatures.createTypeSignature(typeName), null));
				} else if (value instanceof IBinaryAnnotation) {
					((InternalEList<JvmAnnotationReference>) ((JvmAnnotationAnnotationValue) result).getValues())
							.addUnique(createAnnotationReference((IBinaryAnnotation) value));
				} else if (value instanceof EnumConstantSignature) {
					EnumConstantSignature ref = (EnumConstantSignature) value;
					JvmEnumerationLiteral enumLiteralProxy = createEnumLiteralProxy(ref.getEnumConstantName(),
							ref.getTypeName());
					((InternalEList<JvmEnumerationLiteral>) ((JvmEnumAnnotationValue) result).getValues())
							.addUnique(enumLiteralProxy);
				}
			}
			return result;
		} else {
			return TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
		}
	}

	protected JvmAnnotationValue createAnnotationValue(Object value) {
		if (value == null) {
			// null is handled as a custom annotation value but generally assumend bogus
			return TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
		}
		if (value instanceof Constant) {
			Constant c = (Constant) value;
			switch (c.typeID()) {
				case TypeIds.T_int: {
					JvmIntAnnotationValue result = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
					((InternalEList<Integer>) result.getValues()).addUnique(c.intValue());
					return result;
				}
				case TypeIds.T_byte: {
					JvmByteAnnotationValue result = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
					((InternalEList<Byte>) result.getValues()).addUnique(c.byteValue());
					return result;
				}
				case TypeIds.T_short: {
					JvmShortAnnotationValue result = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
					((InternalEList<Short>) result.getValues()).addUnique(c.shortValue());
					return result;
				}
				case TypeIds.T_char: {
					JvmCharAnnotationValue result = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
					((InternalEList<Character>) result.getValues()).addUnique(c.charValue());
					return result;
				}
				case TypeIds.T_float: {
					JvmFloatAnnotationValue result = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
					((InternalEList<Float>) result.getValues()).addUnique(c.floatValue());
					return result;
				}
				case TypeIds.T_double: {
					JvmDoubleAnnotationValue result = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
					((InternalEList<Double>) result.getValues()).addUnique(c.doubleValue());
					return result;
				}
				case TypeIds.T_boolean: {
					JvmBooleanAnnotationValue result = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
					((InternalEList<Boolean>) result.getValues()).addUnique(c.booleanValue());
					return result;
				}
				case TypeIds.T_long: {
					JvmLongAnnotationValue result = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
					((InternalEList<Long>) result.getValues()).addUnique(c.longValue());
					return result;
				}
				case TypeIds.T_JavaLangString: {
					JvmStringAnnotationValue result = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
					((InternalEList<String>) result.getValues()).addUnique(c.stringValue());
					return result;
				}
				default:
					return TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
			}
		}
		if (value instanceof ClassSignature) {
			char[] typeName = ((ClassSignature) value).getTypeName();
			JvmTypeAnnotationValue result = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
			((InternalEList<JvmTypeReference>) result.getValues()).addUnique(createTypeReference(
					BinarySignatures.createTypeSignature(typeName), null));
			return result;
		}
		if (value instanceof IBinaryAnnotation) {
			JvmAnnotationAnnotationValue result = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
			((InternalEList<JvmAnnotationReference>) result.getValues())
					.addUnique(createAnnotationReference((IBinaryAnnotation) value));
			return result;
		}
		if (value instanceof EnumConstantSignature) {
			EnumConstantSignature ref = (EnumConstantSignature) value;
			JvmEnumerationLiteral enumLiteralProxy = createEnumLiteralProxy(ref.getEnumConstantName(),
					ref.getTypeName());
			JvmEnumAnnotationValue result = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
			((InternalEList<JvmEnumerationLiteral>) result.getValues()).addUnique(enumLiteralProxy);
			return result;
		}
		return null;
	}

	protected JvmAnnotationType createAnnotationProxy(BinaryTypeSignature type) {
		JvmType proxy = typeProxies.get(type);
		if (proxy == null) {
			JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
			URI uri = type.getURI();
			((InternalEObject) result).eSetProxyURI(uri);
			typeProxies.put(type, result);
			return result;
		} else if (proxy.eClass() != TypesPackage.Literals.JVM_ANNOTATION_TYPE) {
			JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
			((InternalEObject) result).eSetProxyURI(((InternalEObject) proxy).eProxyURI());
			typeProxies.put(type, result);
			return result;
		}
		return (JvmAnnotationType) proxy;
	}

	protected JvmOperation createMethodProxy(BinaryTypeSignature type, char[] methodName) {
		BinarySimpleMemberSignature method = type.appendMethod(methodName);
		JvmOperation proxy = operationProxies.get(method);
		if (proxy == null) {
			proxy = TypesFactory.eINSTANCE.createJvmOperation();
			URI uri = method.getURI();
			((InternalEObject) proxy).eSetProxyURI(uri);
			operationProxies.put(method, proxy);
		}
		return proxy;
	}

	protected void setTypeModifiers(int accessFlags, JvmDeclaredType result) {
		result.setAbstract((accessFlags & ClassFileConstants.AccAbstract) != 0);
		result.setStatic((accessFlags & ClassFileConstants.AccStatic) != 0);
		if (result.eClass() != TypesPackage.Literals.JVM_ENUMERATION_TYPE) {
			result.setFinal((accessFlags & ClassFileConstants.AccFinal) != 0);
		} else {
			result.setStatic(true);
		}
	}

	protected void createNestedTypes(IBinaryType classFile, JvmDeclaredType result,
			Map<String, JvmTypeParameter> typeParameters) {
		IBinaryNestedType[] memberTypes = classFile.getMemberTypes();
		if (memberTypes != null) {
			InternalEList<JvmMember> members = (InternalEList<JvmMember>) result.getMembers();
			for (int i = 0; i < memberTypes.length; i++) {
				IBinaryNestedType memberType = memberTypes[i];
				BinaryTypeSignature signature = BinarySignatures.createTypeSignature(memberType.getName());
				try {
					BinaryClass binaryClass = BinaryClass.forName(signature.toIdentifier(), classLoader);
					JvmDeclaredType nestedType = doCreateType(binaryClass, true, typeParameters);
					if (nestedType != null) {
						members.addUnique(nestedType);
					}
				} catch (ClassNotFoundException e) {
					// ignore
				} catch (ClassFormatException e) {
					// ignore
				}
			}
		}
	}

	protected JvmAnnotationType createAnnotationType(IBinaryType classFile) {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();

		int modifiers = classFile.getModifiers();

		setTypeModifiers(modifiers, result);
		setVisibility(modifiers, result);

		setNameAndPackage(classFile, result);

		createNestedTypes(classFile, result, null);
		createMethods(classFile, result, null);
		createFields(classFile, result, null);

		setInterfaces(classFile, null, (InternalEList<JvmTypeReference>) result.getSuperTypes());

		createAnnotationValues(classFile.getAnnotations(), classFile.getTagBits(), result);
		return result;
	}

	protected void setSuperTypes(IBinaryType classFile, BinarySuperTypeSignature genericSignature,
			JvmDeclaredType result, Map<String, JvmTypeParameter> typeParameters) {
		InternalEList<JvmTypeReference> superTypes = (InternalEList<JvmTypeReference>) result.getSuperTypes();
		if (genericSignature != null) {
			List<BinaryGenericTypeSignature> superTypeSignatures = genericSignature.getSuperTypes();
			if (result.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) result).isInterface()) {
				if (superTypeSignatures.size() > 1) {
					superTypeSignatures = superTypeSignatures.subList(1, superTypeSignatures.size());
				}
			}
			for (int i = 0; i < superTypeSignatures.size(); i++) {
				superTypes.addUnique(createTypeReference(superTypeSignatures.get(i), typeParameters));
			}
		} else {
			char[] superType = classFile.getSuperclassName();
			if (superType != null) {
				superTypes.addUnique(createTypeReference(BinarySignatures.createTypeSignature(superType),
						typeParameters));
			}
			setInterfaces(classFile, typeParameters, superTypes);
			if (superTypes.isEmpty() && !Arrays.equals(SIG_JAVA_LANG_OBJECT, classFile.getName())) {
				superTypes.addUnique(createObjectTypeReference());
			}
		}
	}

	protected void setInterfaces(IBinaryType classFile, Map<String, JvmTypeParameter> typeParameters,
			InternalEList<JvmTypeReference> result) {
		char[][] interfaceNames = classFile.getInterfaceNames();
		if (interfaceNames != null) {
			for (int i = 0; i < interfaceNames.length; i++) {
				char[] interfaceName = interfaceNames[i];
				result.addUnique(createTypeReference(BinarySignatures.createTypeSignature(interfaceName),
						typeParameters));
			}
		}
	}

	protected JvmTypeReference createObjectTypeReference() {
		return createTypeReference(BinarySignatures.createTypeSignature(SIG_JAVA_LANG_OBJECT), null);
	}

	protected void createFields(IBinaryType classFile, JvmDeclaredType result,
			Map<String, JvmTypeParameter> typeParameters) {
		IBinaryField[] fields = classFile.getFields();
		if (fields != null) {
			InternalEList<JvmMember> members = (InternalEList<JvmMember>) result.getMembers();
			for (int i = 0; i < fields.length; i++) {
				IBinaryField field = fields[i];
				if ((field.getModifiers() & AccSynthetic) == 0) {
					members.addUnique(createField(field, result.getIdentifier(), typeParameters));
				}
			}
		}
	}

	protected void createConstructors(IBinaryType classFile, JvmDeclaredType result, int offset,
			Map<String, JvmTypeParameter> typeParameters) {
		IBinaryMethod[] declaredMethods = classFile.getMethods();
		if (declaredMethods != null) {
			InternalEList<JvmMember> members = (InternalEList<JvmMember>) result.getMembers();
			for (int i = 0; i < declaredMethods.length; i++) {
				IBinaryMethod method = declaredMethods[i];
				if (method.isConstructor()) {
					int modifiers = method.getModifiers();
					if ((modifiers & AccSynthetic) == 0) {
						members.addUnique(createConstructor(method, offset, result, typeParameters));
					}
				}
			}
		}
	}

	protected void createMethods(IBinaryType classFile, JvmDeclaredType result,
			Map<String, JvmTypeParameter> typeParameters) {
		IBinaryMethod[] declaredMethods = classFile.getMethods();
		if (declaredMethods != null) {
			InternalEList<JvmMember> members = (InternalEList<JvmMember>) result.getMembers();
			for (int i = 0; i < declaredMethods.length; i++) {
				IBinaryMethod method = declaredMethods[i];
				if (!method.isClinit() && !method.isConstructor()) {
					int modifiers = method.getModifiers();
					if ((modifiers & AccSynthetic) == 0 && (modifiers & AccBridge) == 0) {
						JvmOperation operation = createOperation(method, result, typeParameters);
						if (result.eClass() == TypesPackage.Literals.JVM_ANNOTATION_TYPE) {
							setDefaultValue(operation, method);
						}
						members.addUnique(operation);
					}
				}
			}
		}
	}

	private void setDefaultValue(JvmOperation operation, IBinaryMethod method) {
		Object defaultValue = method.getDefaultValue();
		if (defaultValue != null) {
			if (defaultValue instanceof Object[]) {
				Object[] castedDefaultValue = (Object[]) defaultValue;
				if (castedDefaultValue.length == 0) {
					char[] selector = method.getMethodDescriptor();
					BinaryMethodSignature signature = BinarySignatures.createMethodSignature(selector);
					BinaryGenericTypeSignature returnType = signature.getReturnType();
					JvmAnnotationValue annotationValue = null;
					if (returnType.isEqualToSignature("[Ljava/lang/Class;")) {
						annotationValue = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
					} else if (returnType.getLength() == 2) {
						switch (returnType.getChar(1)) {
							case 'B':
								annotationValue = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
								break;
							case 'C':
								annotationValue = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
								break;
							case 'D':
								annotationValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
								break;
							case 'F':
								annotationValue = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
								break;
							case 'I':
								annotationValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
								break;
							case 'J':
								annotationValue = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
								break;
							case 'S':
								annotationValue = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
								break;
							case 'Z':
								annotationValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
								break;
							default:
								throw new IllegalArgumentException(returnType.toString());
						}
					} else {
						annotationValue = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
					}
					operation.setDefaultValue(annotationValue);
					annotationValue.setOperation(operation);
				} else {
					JvmAnnotationValue annotationValue = createArrayAnnotationValue(castedDefaultValue);
					operation.setDefaultValue(annotationValue);
					annotationValue.setOperation(operation);
				}
			} else {
				JvmAnnotationValue annotationValue = createAnnotationValue(defaultValue);
				operation.setDefaultValue(annotationValue);
				annotationValue.setOperation(operation);
			}
		}
	}

	protected JvmEnumerationType createEnumerationType(IBinaryType classFile) {
		JvmEnumerationType result = TypesFactory.eINSTANCE.createJvmEnumerationType();

		int modifiers = classFile.getModifiers();

		setTypeModifiers(modifiers, result);
		setVisibility(modifiers, result);

		setNameAndPackage(classFile, result);

		char[] signature = classFile.getGenericSignature();
		BinarySuperTypeSignature genericSignature = null;
		if (signature != null) {
			genericSignature = BinarySignatures.createSuperTypeSignature(signature);
		}

		createNestedTypes(classFile, result, null);
		createMethods(classFile, result, null);
		createConstructors(classFile, result, 2, null);
		createFields(classFile, result, null);

		setSuperTypes(classFile, genericSignature, result, null);

		createAnnotationValues(classFile.getAnnotations(), classFile.getTagBits(), result);
		return result;
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
					((JvmTypeConstraintImplCustom) upperBound).internalSetTypeReference(createTypeReference(
							bounds.get(j), result));
					constraints.addUnique(upperBound);
				}
			}
			return result;
		}
		return knownTypeParameters;
	}

	protected JvmTypeReference createTypeReference(BinaryTypeSignature type,
			Map<String, JvmTypeParameter> typeParameters) {
		int arrayCount = type.getArrayDimensions();
		if (arrayCount > 0) {
			BinaryTypeSignature elementType = type.getArrayComponentType();
			JvmTypeReference result = createTypeReference(elementType, typeParameters);
			for (int i = 0; i < arrayCount; i++) {
				JvmGenericArrayTypeReference array = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
				array.setComponentType(result);
				result = array;
			}
			return result;
		}
		List<BinaryTypeArgumentSignature> typeArguments = type.getTypeArguments();
		if (typeArguments.size() == 0) {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(type.getTypeErasure(), typeParameters));
			return result;
		} else {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(type.getTypeErasure(), typeParameters));
			InternalEList<JvmTypeReference> arguments = (InternalEList<JvmTypeReference>) result.getArguments();
			for (int i = 0; i < typeArguments.size(); i++) {
				JvmTypeReference argument = createTypeArgument(typeArguments.get(i), typeParameters);
				arguments.addUnique(argument);
			}
			return result;
		}
	}

	protected JvmTypeReference createTypeArgument(BinaryTypeArgumentSignature actualTypeArgument,
			Map<String, JvmTypeParameter> typeParameters) {
		if (actualTypeArgument.isWildcard()) {
			JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
			InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>) result.getConstraints();
			BinaryGenericTypeSignature upperBound = actualTypeArgument.getUpperBound();
			if (upperBound != null) {
				JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				JvmTypeReference upperBoundType = createTypeReference(upperBound, typeParameters);
				((JvmTypeConstraintImplCustom) jvmUpperBound).internalSetTypeReference(upperBoundType);
				constraints.addUnique(jvmUpperBound);
			} else {
				JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				// TODO this might be bogus due to constrained type information on the declarator
				((JvmTypeConstraintImplCustom) jvmUpperBound).internalSetTypeReference(createObjectTypeReference());
				constraints.addUnique(jvmUpperBound);
			}
			BinaryGenericTypeSignature lowerBound = actualTypeArgument.getLowerBound();
			if (lowerBound != null) {
				JvmLowerBound jvmLowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
				JvmTypeReference boundType = createTypeReference(lowerBound, typeParameters);
				((JvmTypeConstraintImplCustom) jvmLowerBound).internalSetTypeReference(boundType);
				constraints.addUnique(jvmLowerBound);
			}
			return result;
		} else {
			return createTypeReference(actualTypeArgument, typeParameters);
		}
	}

	protected JvmType createProxy(BinaryTypeSignature type, Map<String, JvmTypeParameter> typeParameters) {
		String variableName = type.getTypeVariableName();
		if (variableName != null) {
			if (typeParameters == null) {
				throw new IllegalStateException(type.toString());
			}
			JvmType result = typeParameters.get(variableName);
			if (result == null) {
				throw new IllegalStateException(type.toString());
			}
			return result;
		}
		JvmType proxy = typeProxies.get(type);
		if (proxy == null) {
			proxy = TypesFactory.eINSTANCE.createJvmVoid();
			URI uri = type.getURI();
			((InternalEObject) proxy).eSetProxyURI(uri);
			typeProxies.put(type, proxy);
		}
		return proxy;
	}

	protected JvmField createField(IBinaryField field, String enclosingTypeName,
			Map<String, JvmTypeParameter> typeParameters) {
		JvmField result;
		int modifiers = field.getModifiers();
		if ((modifiers & AccEnum) == 0) {
			result = TypesFactory.eINSTANCE.createJvmField();
			FieldInfo fieldInfo = (FieldInfo) field;
			Object value = fieldInfo.getWrappedConstantValue();
			if (value != null) {
				result.setConstant(true);
				result.setConstantValue(value);
			} else {
				result.setConstant(false);
			}
		} else {
			result = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		}
		String fieldName = String.valueOf(field.getName());
		result.internalSetIdentifier(enclosingTypeName + "." + fieldName);
		result.setSimpleName(fieldName);
		result.setFinal((modifiers & AccFinal) != 0);
		result.setStatic((modifiers & AccStatic) != 0);
		result.setTransient((modifiers & AccTransient) != 0);
		result.setVolatile((modifiers & AccVolatile) != 0);
		setVisibility(modifiers, result);
		char[] fieldType = field.getGenericSignature();
		if (fieldType == null) {
			fieldType = field.getTypeName();
		}
		result.setType(createTypeReference(BinarySignatures.createTypeSignature(fieldType), typeParameters));
		createAnnotationValues(field.getAnnotations(), field.getTagBits(), result);
		return result;
	}

	protected JvmConstructor createConstructor(IBinaryMethod method, int offset, JvmDeclaredType declarator,
			Map<String, JvmTypeParameter> typeParameters) {
		JvmConstructor result = TypesFactory.eINSTANCE.createJvmConstructor();
		char[] signature = method.getGenericSignature();
		int annotationOffset = 0;
		if (signature == null) {
			signature = method.getMethodDescriptor();
		} else {
			annotationOffset = offset;
			offset = 0;
		}
		BinaryMethodSignature binarySignature = BinarySignatures.createMethodSignature(signature);
		typeParameters = createTypeParameters(binarySignature, result, typeParameters);

		enhanceExecutable(result, method, binarySignature, declarator, offset, annotationOffset, typeParameters);

		createAnnotationValues(method.getAnnotations(), method.getTagBits(), result);
		return result;
	}

	protected void setVisibility(int accessFlags, org.eclipse.xtext.common.types.JvmMember result) {
		if ((accessFlags & AccPrivate) != 0)
			result.setVisibility(JvmVisibility.PRIVATE);
		else if ((accessFlags & AccProtected) != 0)
			result.setVisibility(JvmVisibility.PROTECTED);
		else if ((accessFlags & AccPublic) != 0)
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(JvmVisibility.DEFAULT);
	}

	@SuppressWarnings("null")
	protected void enhanceExecutable(JvmExecutable result, IBinaryMethod method, BinaryMethodSignature binarySignature,
			JvmDeclaredType owner, int offset, int annotationOffset, Map<String, JvmTypeParameter> typeParameters) {
		int modifier = method.getModifiers();
		StringBuilder fqName = new StringBuilder(48);
		fqName.append(owner.getIdentifier());
		fqName.append('.');
		if (method.isConstructor()) {
			fqName.append(owner.getSimpleName());
			result.setSimpleName(owner.getSimpleName());
		} else {
			fqName.append(method.getSelector());
			String selector = String.valueOf(method.getSelector());
			result.setSimpleName(selector);
		}
		fqName.append('(');
		List<BinaryGenericTypeSignature> parameterTypes = binarySignature.getParameterTypes();
		if (parameterTypes.size() > offset) {
			char[][] argumentNames = method.getArgumentNames();
			boolean hasArgumentNames = argumentNames != null && argumentNames.length != 0;
			InternalEList<JvmFormalParameter> parameters = (InternalEList<JvmFormalParameter>) result.getParameters();
			for (int i = offset; i < parameterTypes.size(); i++) {
				if (i != offset)
					fqName.append(',');
				IBinaryAnnotation[] parameterAnnotations = method.getParameterAnnotations(i + annotationOffset);
				BinaryTypeSignature parameterType = parameterTypes.get(i);
				fqName.append(parameterType.getTypeErasure().toIdentifier());
				parameters.addUnique(createFormalParameter(parameterType,
						hasArgumentNames ? String.valueOf(argumentNames[i - offset]) : "arg" + (i - offset), result,
						method, parameterAnnotations, typeParameters));
			}
		}
		fqName.append(')');
		result.internalSetIdentifier(fqName.toString());
		setVisibility(modifier, result);
		result.setVarArgs((modifier & AccVarargs) != 0);

		List<BinaryGenericTypeSignature> exceptions = binarySignature.getExceptionTypes();
		if (exceptions.size() == 0) {
			char[][] rawExceptionTypes = method.getExceptionTypeNames();
			if (rawExceptionTypes != null) {
				InternalEList<JvmTypeReference> resultExceptions = (InternalEList<JvmTypeReference>) result
						.getExceptions();
				for (int i = 0, max = rawExceptionTypes.length; i < max; i++) {
					resultExceptions.addUnique(createTypeReference(
							BinarySignatures.createTypeSignature(rawExceptionTypes[i]), typeParameters));
				}
			}
		} else {
			InternalEList<JvmTypeReference> resultExceptions = (InternalEList<JvmTypeReference>) result.getExceptions();
			for (int i = 0, max = exceptions.size(); i < max; i++) {
				resultExceptions.addUnique(createTypeReference(exceptions.get(i), typeParameters));
			}
		}
	}

	protected Map<String, JvmTypeParameter> enhanceGenericDeclaration(JvmExecutable result,
			BinaryMethodSignature signature, Map<String, JvmTypeParameter> typeParameters) {
		return createTypeParameters(signature, result, result.isStatic() ? null : typeParameters);
	}

	protected JvmOperation createOperation(IBinaryMethod method, JvmDeclaredType declaringClass,
			Map<String, JvmTypeParameter> typeParameters) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		char[] signature = method.getGenericSignature();
		if (signature == null) {
			signature = method.getMethodDescriptor();
		}
		int modifiers = method.getModifiers();
		result.setAbstract(Modifier.isAbstract(modifiers));
		result.setFinal(Modifier.isFinal(modifiers));
		result.setStatic(Modifier.isStatic(modifiers));
		result.setSynchronized(Modifier.isSynchronized(modifiers));
		result.setStrictFloatingPoint(Modifier.isStrict(modifiers));
		result.setNative(Modifier.isNative(modifiers));

		BinaryMethodSignature binarySignature = BinarySignatures.createMethodSignature(signature);
		typeParameters = enhanceGenericDeclaration(result, binarySignature, typeParameters);

		enhanceExecutable(result, method, binarySignature, declaringClass, 0, 0, typeParameters);
		result.setReturnType(createTypeReference(binarySignature.getReturnType(), typeParameters));

		createAnnotationValues(method.getAnnotations(), method.getTagBits(), result);
		return result;
	}

	protected JvmFormalParameter createFormalParameter(BinaryTypeSignature parameterType, String paramName,
			JvmMember container, IBinaryMethod method, IBinaryAnnotation[] parameterAnnotations,
			Map<String, JvmTypeParameter> typeParameters) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(paramName);
		result.setParameterType(createTypeReference(parameterType, typeParameters));
		if (parameterAnnotations != null) {
			InternalEList<JvmAnnotationReference> annotationsReferences = (InternalEList<JvmAnnotationReference>) result
					.getAnnotations();
			for (int i = 0; i < parameterAnnotations.length; i++) {
				IBinaryAnnotation annotation = parameterAnnotations[i];
				annotationsReferences.addUnique(createAnnotationReference(annotation));
			}
		}
		return result;
	}

}
