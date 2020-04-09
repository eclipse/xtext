/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.labeling;

import java.util.stream.Collectors;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedField;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

/**
 * Provides the text and image for the label of a a given element.
 */
public class XbaseLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	private XbaseImages2 images;

	@Inject
	private UIStrings uiStrings;

	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private XbaseImageAdornments adornments;

	@Inject
	private CommonTypeComputationServices services;

	@Inject
	public XbaseLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	/**
	 * @return the {@code ImageDescriptor} for a given {@code obj}
	 * @throws NullPointerException
	 *             if the passed {@code obj} is null
	 */
	protected ImageDescriptor imageDescriptor(Object obj) {
		Preconditions.checkNotNull(obj);

		if (obj instanceof JvmConstructor) {
			return _imageDescriptor((JvmConstructor) obj);
		} else if (obj instanceof JvmOperation) {
			return _imageDescriptor((JvmOperation) obj);
		} else if (obj instanceof JvmAnnotationType) {
			return _imageDescriptor((JvmAnnotationType) obj);
		} else if (obj instanceof JvmEnumerationType) {
			return _imageDescriptor((JvmEnumerationType) obj);
		} else if (obj instanceof JvmField) {
			return _imageDescriptor((JvmField) obj);
		} else if (obj instanceof JvmGenericType) {
			return _imageDescriptor((JvmGenericType) obj);
		} else if (obj instanceof JvmTypeParameter) {
			return _imageDescriptor((JvmTypeParameter) obj);
		} else if (obj instanceof JvmFormalParameter) {
			return _imageDescriptor((JvmFormalParameter) obj);
		} else if (obj instanceof XVariableDeclaration) {
			return _imageDescriptor((XVariableDeclaration) obj);
		} else if (obj instanceof IResolvedConstructor) {
			return _imageDescriptor((IResolvedConstructor) obj);
		} else if (obj instanceof IResolvedOperation) {
			return _imageDescriptor((IResolvedOperation) obj);
		} else if (obj instanceof XImportDeclaration) {
			return _imageDescriptor((XImportDeclaration) obj);
		} else if (obj instanceof XImportSection) {
			return _imageDescriptor((XImportSection) obj);
		} else if (obj instanceof IResolvedField) {
			return _imageDescriptor((IResolvedField) obj);
		}
		return _imageDescriptor(obj);
	}

	protected ImageDescriptor _imageDescriptor(Object element) {
		return null;
	}

	protected ImageDescriptor _imageDescriptor(XImportSection importSection) {
		return images.forImportContainer();
	}

	protected ImageDescriptor _imageDescriptor(XImportDeclaration importDeclaration) {
		return images.forImport();
	}

	protected ImageDescriptor _imageDescriptor(JvmGenericType genericType) {
		return genericType.isInterface() // 
				? images.forInterface(genericType.getVisibility(), adornments.get(genericType)) //
				: images.forClass(genericType.getVisibility(), adornments.get(genericType));
	}

	protected ImageDescriptor _imageDescriptor(JvmEnumerationType enumerationType) {
		return images.forEnum(enumerationType.getVisibility(), adornments.get(enumerationType));
	}

	protected ImageDescriptor _imageDescriptor(JvmAnnotationType annotationType) {
		return images.forAnnotation(annotationType.getVisibility(), adornments.get(annotationType));
	}

	protected ImageDescriptor _imageDescriptor(JvmOperation operation) {
		return images.forOperation(operation.getVisibility(), adornments.get(operation));
	}

	protected ImageDescriptor _imageDescriptor(IResolvedOperation operation) {
		return imageDescriptor(operation.getDeclaration());
	}

	protected ImageDescriptor _imageDescriptor(JvmConstructor constructor) {
		return images.forConstructor(constructor.getVisibility(), adornments.get(constructor));
	}

	protected ImageDescriptor _imageDescriptor(IResolvedConstructor constructor) {
		return _imageDescriptor(constructor.getDeclaration());
	}

	protected ImageDescriptor _imageDescriptor(IResolvedField field) {
		return _imageDescriptor(field.getDeclaration());
	}

	protected ImageDescriptor _imageDescriptor(JvmField field) {
		return images.forField(field.getVisibility(), adornments.get(field));
	}

	protected ImageDescriptor _imageDescriptor(JvmFormalParameter parameter) {
		return images.forLocalVariable(adornments.get(parameter));
	}

	protected ImageDescriptor _imageDescriptor(XVariableDeclaration variableDeclaration) {
		return images.forLocalVariable(adornments.get(variableDeclaration));
	}

	protected ImageDescriptor _imageDescriptor(JvmTypeParameter parameter) {
		return images.forTypeParameter(adornments.get(parameter));
	}

	protected String text(JvmConstructor constructor) {
		return "new" + uiStrings.parameters(constructor);
	}

	protected String text(JvmGenericType genericType) {
		return genericType.getSimpleName();
	}

	protected Object text(JvmOperation element) {
		return signature(element.getSimpleName(), element);
	}

	protected Object text(IResolvedOperation element) {
		String returnTypeString = element.getResolvedReturnType().getSimpleName();
		String decoratedPart = " : " + returnTypeString;
		if (!element.getTypeParameters().isEmpty()) {
			decoratedPart = " <" + uiStrings.toString(element.getTypeParameters()) + "> : " + returnTypeString;
		}

		String styledString = element.getDeclaration().getSimpleName() //
				+ element.getResolvedParameterTypes().stream().map(type -> type.getHumanReadableName())
						.collect(Collectors.joining(", ", "(", ")"));
		return new StyledString(styledString).append(new StyledString(decoratedPart, StyledString.DECORATIONS_STYLER));
	}

	protected Object text(IResolvedConstructor constructor) {
		String styledString = constructor.getResolvedParameterTypes().stream().map(type -> type.getHumanReadableName())
				.collect(Collectors.joining(", ", "new(", ")"));
		return new StyledString(styledString);
	}

	protected Object text(IResolvedField field) {
		return new StyledString(field.getSimpleSignature() + " : " + field.getResolvedType().getHumanReadableName());
	}

	protected Object text(JvmField field) {
		return field.getSimpleName() + " : " + field.getType().getSimpleName();
	}

	protected String text(JvmFormalParameter parameter) {
		JvmTypeReference parameterType = parameter.getParameterType();
		if (parameterType == null) {
			return parameter.getName();
		} else {
			return parameterType.getSimpleName() + " " + parameter.getName();
		}
	}

	protected String text(XImportDeclaration importDeclaration) {
		StringBuilder builder = new StringBuilder();
		builder.append(importDeclaration.getImportedTypeName());
		if (importDeclaration.isWildcard()) {
			builder.append(".*");
		} else {
			if (importDeclaration.getMemberName() != null) {
				builder.append(".");
				builder.append(importDeclaration.getMemberName());
			}
		}
		return builder.toString();
	}

	protected String text(XImportSection importSection) {
		return "import declarations";
	}

	protected String text(XVariableDeclaration variableDeclaration) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(variableDeclaration);
		LightweightTypeReference type = resolvedTypes.getActualType((JvmIdentifiableElement) variableDeclaration);
		if (type != null) {
			return type.getHumanReadableName() + " " + variableDeclaration.getName();
		} else {
			return variableDeclaration.getName();
		}
	}

	protected StyledString signature(String simpleName, JvmIdentifiableElement element) {
		JvmTypeReference returnType = null;
		if (element instanceof JvmOperation) {
			returnType = ((JvmOperation) element).getReturnType();
		} else if (element instanceof JvmField) {
			returnType = ((JvmField) element).getType();
		}

		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, element);
		final String returnTypeString;
		if (returnType == null) {
			returnTypeString = "void";
		} else {
			returnTypeString = owner.toLightweightTypeReference(returnType).getHumanReadableName();
		}

		String decoratedPart = " : " + returnTypeString;
		String typeParam = uiStrings.typeParameters(element) != null ? uiStrings.typeParameters(element) : "";
		if (!typeParam.isEmpty()) {
			decoratedPart = " " + typeParam + " : " + returnTypeString;
		}

		return new StyledString(simpleName + uiStrings.parameters(element))
				.append(new StyledString(decoratedPart, StyledString.DECORATIONS_STYLER));
	}

	@Override
	protected Object doGetImage(Object element) {
		if (element != null) {
			ImageDescriptor imageDescriptor = imageDescriptor(element);
			return imageDescriptor != null ? imageDescriptor : super.doGetImage(element);
		}
		return null;
	}

	protected IBatchTypeResolver getTypeResolver() {
		return typeResolver;
	}
}
