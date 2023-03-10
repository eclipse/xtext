/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.label.ILabelProviderImageDescriptorExtension;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.InvokedResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.validation.UIStrings;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseDeclarativeHoverSignatureProvider {

	@Inject
	protected HoverUiStrings hoverUiStrings;

	@Inject
	protected UIStrings uiStrings;
	
	@Inject
	private ILabelProvider labelProvider;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private InvokedResolvedOperation.Provider invokedOperationProvider;

	public String getSignature(EObject object) {
		return internalGetSignature(object, false);
	}
	
	protected String _signature(XConstructorCall constructorCall, boolean typeAtEnd) {
		if (typeAtEnd) {
			throw new UnsupportedOperationException();
		}
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(constructorCall);
		LightweightTypeReference createdType = resolvedTypes.getActualType(constructorCall);
		final List<LightweightTypeReference> typeArguments = resolvedTypes.getActualTypeArguments(constructorCall);
		final int typeArgumentCount = createdType.getTypeArguments().size();
		final int constructorTypeArgumentCount = typeArguments.size();
		final JvmConstructor constructor = constructorCall.getConstructor();
		ResolvedConstructor resolvedConstructor = new ResolvedConstructor(constructor, createdType) {
			@Override
			protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> computeContextTypeParameterMapping() {
				Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result = super.computeContextTypeParameterMapping();
				if (typeArgumentCount == constructorTypeArgumentCount)
					return result;
				List<JvmTypeParameter> constructorTypeParameters = getDeclaration().getTypeParameters();
				for(int i = 0; i < constructorTypeParameters.size(); i++) {
					result.put(constructorTypeParameters.get(i), new LightweightMergedBoundTypeArgument(typeArguments.get(i), VarianceInfo.INVARIANT));
				}
				return result;
			}
		};
		StringBuilder result = new StringBuilder(250);
		if (typeArgumentCount != constructorTypeArgumentCount) {
			result.append("<");
			for(int i = 0; i < constructorTypeArgumentCount - typeArgumentCount; i++) {
				if (i != 0) {
					result.append(", ");
				}
				result.append(typeArguments.get(i).getHumanReadableName());
			}
			result.append("> ");
		}
		result.append(constructor.getDeclaringType().getSimpleName());
		if (typeArgumentCount != 0) {
			result.append("<");
			for(int i = constructorTypeArgumentCount - typeArgumentCount; i < constructorTypeArgumentCount; i++) {
				if (i != constructorTypeArgumentCount - typeArgumentCount) {
					result.append(", ");
				}
				result.append(typeArguments.get(i).getHumanReadableName());
			}
			result.append(">");
		}
		result.append('(');
		List<LightweightTypeReference> parameterTypes = resolvedConstructor.getResolvedParameterTypes();
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(", ");
			}
			result.append(parameterTypes.get(i).getHumanReadableName());
			result.append(' ').append(constructor.getParameters().get(i).getSimpleName());
		}
		result.append(')');
		List<LightweightTypeReference> exceptions = resolvedConstructor.getResolvedExceptions();
		if (!exceptions.isEmpty()) {
			result.append(" throws ");
			for(int i = 0 ; i < exceptions.size(); i++) {
				if (i != 0) {
					result.append(", ");
				}
				result.append(exceptions.get(i).getHumanReadableName());
			}
		}
		return result.toString();
	}
	protected String _signature(XAbstractFeatureCall featureCall, boolean typeAtEnd) {
		if (typeAtEnd) {
			throw new UnsupportedOperationException();
		}
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature instanceof JvmOperation) {
			InvokedResolvedOperation resolvedOperation = invokedOperationProvider.resolve(featureCall);
			StringBuilder result = new StringBuilder(250);
			List<LightweightTypeReference> typeArguments = resolvedOperation.getResolvedTypeArguments();
			if (!typeArguments.isEmpty()) {
				result.append("<");
				for(int i = 0 ; i < typeArguments.size(); i++) {
					if (i != 0) {
						result.append(", ");
					}
					result.append(typeArguments.get(i).getHumanReadableName());
				}
				result.append("> ");
			}
			result.append(resolvedOperation.getResolvedReturnType().getHumanReadableName()).append(' ');
			JvmOperation operation = resolvedOperation.getDeclaration();
			result.append(getDeclaratorName(operation)).append('.');
			result.append(operation.getSimpleName()).append('(');
			List<LightweightTypeReference> parameterTypes = resolvedOperation.getResolvedParameterTypes();
			for(int i = 0; i < parameterTypes.size(); i++) {
				if (i != 0) {
					result.append(", ");
				}
				result.append(parameterTypes.get(i).getHumanReadableName());
				result.append(' ').append(operation.getParameters().get(i).getSimpleName());
			}
			result.append(')');
			List<LightweightTypeReference> exceptions = resolvedOperation.getResolvedExceptions();
			if (!exceptions.isEmpty()) {
				result.append(" throws ");
				for(int i = 0 ; i < exceptions.size(); i++) {
					if (i != 0) {
						result.append(", ");
					}
					result.append(exceptions.get(i).getHumanReadableName());
				}
			}
			return result.toString();
		} else if (feature instanceof JvmConstructor) {
			// TODO this or super
			// see ignored tests in
		} else if (feature instanceof JvmField) {
			LightweightTypeReference referenceType = typeResolver.resolveTypes(featureCall).getActualType(featureCall);
			StringBuilder result = new StringBuilder(250);
			result.append(referenceType.getHumanReadableName()).append(' ');
			JvmField field = (JvmField) feature;
			result.append(getDeclaratorName(field)).append('.');
			result.append(field.getSimpleName());
			return result.toString();
		} else {
			String simpleName = feature.getSimpleName();
			String type = typeResolver.resolveTypes(featureCall).getActualType(featureCall).getHumanReadableName();
			if (simpleName != null) {
				return type + ' ' + simpleName;
			} else {
				return type;
			}
		}
		return getSignature(feature);
	}

	protected String getDeclaratorName(JvmMember member) {
		return member.getDeclaringType().getSimpleName();
	}

	public String getDerivedOrSourceSignature(EObject object) {
		return internalGetSignature(object, true);
	}

	protected String internalGetSignature(EObject object, boolean typeAtEnd) {
		PolymorphicDispatcher<String> polymorphicDispatcher = new PolymorphicDispatcher<String>("_signature", 2, 2,
				Collections.singletonList(this), new ErrorHandler<String>() {
					@Override
					public String handle(Object[] params, Throwable throwable) {
						return null;
					}
				});
		String result = polymorphicDispatcher.invoke(object, typeAtEnd);
		if (result != null)
			return result;
		if (object instanceof JvmIdentifiableElement) {
			return getLabel(object);
		}
		return getLabelForNonXbaseElement(object);
	}

	private String getLabelForNonXbaseElement(EObject object) {
		String label = getLabel(object);
		return object.eClass().getName() + ((label != null) ? " " + label : "");
	}

	protected String _signature(JvmGenericType clazz, boolean typeAtEnd) {
		return clazz.getSimpleName() + hoverUiStrings.typeParameters(clazz.getTypeParameters());
	}

	protected String _signature(JvmOperation jvmOperation, boolean typeAtEnd) {
		String returnTypeString = "void";
		// TODO resolved operations?
		JvmTypeReference returnType = jvmOperation.getReturnType();
		if (returnType != null) {
			if (returnType instanceof JvmAnyTypeReference) {
				throw new IllegalStateException();
//				returnTypeString = "Object";
			} else {
				returnTypeString = returnType.getSimpleName();
			}
		}

		String signature = jvmOperation.getSimpleName() + hoverUiStrings.parameters(jvmOperation)
				+ getThrowsDeclaration(jvmOperation);
		String typeParameter = uiStrings.typeParameters(jvmOperation.getTypeParameters());
		if(typeParameter != null && typeParameter.length() > 0){
			if (typeAtEnd)
				return signature + " " + typeParameter + " : " + returnTypeString;
			return typeParameter + " " + returnTypeString + " " + signature;
		}
		if (typeAtEnd)
			return signature + " : " + returnTypeString;
		return returnTypeString + " " + enrichWithDeclarator(signature, jvmOperation);
	}

	protected String _signature(JvmField jvmField, boolean typeAtEnd) {
		JvmTypeReference type = jvmField.getType();
		if (type != null) {
			String signature = jvmField.getSimpleName();
			if (typeAtEnd)
				return signature + " : " + type.getSimpleName();
			return type.getSimpleName() + " " + enrichWithDeclarator(signature, jvmField);
		}
		return "";
	}

	protected String enrichWithDeclarator(String signature, EObject o) {
		if(o instanceof JvmMember && ((JvmMember) o).getDeclaringType() != null){
			String parentsName = getDeclaratorName((JvmMember) o);
			return parentsName + "." + signature;
		}
		return signature;
	}

	protected String _signature(JvmConstructor constructor, boolean typeAtEnd) {
		return constructor.getSimpleName() + hoverUiStrings.typeParameters(constructor.getDeclaringType()) + hoverUiStrings.parameters(constructor)
				+ getThrowsDeclaration(constructor);
	}

	protected String _signature(JvmFormalParameter parameter, boolean typeAtEnd) {
		EObject container = parameter.eContainer();
		LightweightTypeReference parameterType = typeResolver.resolveTypes(parameter).getActualType(parameter);
		if (parameterType != null) {
			String signature = parameter.getName();
			String signatureOfFather = getSimpleSignature(container);
			if(signatureOfFather != null){
				signature += JavaElementLabels.CONCAT_STRING + signatureOfFather;
			}
			if (typeAtEnd)
				return signature + " : " + parameterType.getHumanReadableName();
			return parameterType.getHumanReadableName() + " " + signature;
		}
		return parameter.getName();
	}

	protected String _signature(JvmTypeParameter parameter, boolean typeAtEnd){
		EObject container = parameter.eContainer();
		String signature = parameter.getName();
		String signatureOfFather = getSimpleSignature(container);
		if(signatureOfFather != null){
			signature += JavaElementLabels.CONCAT_STRING + signatureOfFather;
		}
		return signature;
	}
	
	protected String _signature(JvmEnumerationType jvmEnumerationType, boolean typeAtEnd) {
		return jvmEnumerationType.getSimpleName();
	}

	protected String _signature(JvmAnnotationType jvmAnnotationType, boolean typeAtEnd) {
		return jvmAnnotationType.getSimpleName();
	}

	protected String getThrowsDeclaration(JvmExecutable executable) {
		String result = "";
		EList<JvmTypeReference> exceptions = executable.getExceptions();
		if (exceptions.size() > 0) {
			result += " throws ";
			Iterator<JvmTypeReference> iterator = exceptions.iterator();
			while (iterator.hasNext()) {
				JvmTypeReference next = iterator.next();
				result += next.getSimpleName();
				if (iterator.hasNext())
					result += ", ";
			}
		}
		return result;
	}

	protected String getSimpleSignature(EObject container) {
		if (container instanceof JvmOperation) {
			return getSimpleSignature((JvmOperation) container);
		} else if (container instanceof JvmConstructor) {
			return getSimpleSignature((JvmConstructor) container);
		}
		return labelProvider.getText(container);
	}

	protected String getSimpleSignature(JvmConstructor contructor) {
		return contructor.getSimpleName() + " " + uiStrings.parameters(contructor);
	}

	protected String getSimpleSignature(JvmOperation jvmOperation) {
		return jvmOperation.getSimpleName() + uiStrings.parameters(jvmOperation);
	}

	public String getImageTag(final EObject object) {
		if (labelProvider instanceof ILabelProviderImageDescriptorExtension) {
			ILabelProviderImageDescriptorExtension extension = (ILabelProviderImageDescriptorExtension) labelProvider;
			ImageDescriptor descriptor = extension.getImageDescriptor(object);
			if (descriptor != null)
				return getImageTagLink(descriptor);
		}
		return null;
	}

	protected String getImageTagLink(ImageDescriptor imageDescriptor) {
		URL url = getURL(imageDescriptor);
		if (url != null)
			return "<image src='" + url.toExternalForm() + "'/>";
		return "";
	}

	@SuppressWarnings("restriction")
	protected URL getURL(ImageDescriptor descriptor) {
		return org.eclipse.jdt.internal.ui.JavaPlugin.getDefault().getImagesOnFSRegistry().getImageURL(descriptor);
	}

	protected String getLabel(EObject object) {
		return labelProvider.getText(object);
	}
}
