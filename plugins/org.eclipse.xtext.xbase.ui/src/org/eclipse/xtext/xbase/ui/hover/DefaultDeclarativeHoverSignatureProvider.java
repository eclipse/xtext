/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.net.URL;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.eclipse.xtext.xbase.validation.UIStrings;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class DefaultDeclarativeHoverSignatureProvider {

	@Inject
	protected HoverUiStrings hoverUiStrings;

	@Inject
	protected UIStrings uiStrings;

	public String getHoverText(EObject object) {
		PolymorphicDispatcher<String> polymorphicDispatcher = new PolymorphicDispatcher<String>("_hoverText", 1, 1,
				Collections.singletonList(this), new ErrorHandler<String>() {
					public String handle(Object[] params, Throwable throwable) {
						return null;
					}
				});
		String result = polymorphicDispatcher.invoke(object);
		if(result == null)
			return null;
		return "<b>" + result + "</b>";
	}

	protected String _hoverText(JvmGenericType clazz) {
		String imageTag = getImageTag(JavaElementImageProvider.getTypeImageDescriptor(false, false,
				toFlags(clazz.getVisibility()), false));
		return imageTag + getSignature(clazz);

	}

	private String getSignature(JvmGenericType clazz) {
		return clazz.getPackageName() + "." + clazz.getSimpleName();
	}

	protected String _hoverText(JvmOperation operation) {
		if (operation != null) {
			ImageDescriptor descriptor = JavaElementImageProvider.getMethodImageDescriptor(false,
					toFlags(operation.getVisibility()));
			String imageTag = "";
			if (operation.isStatic()) {
				imageTag = getImageTag(getDecoratedJdtImageDescriptor(descriptor, JavaElementImageDescriptor.STATIC));
			} else
				imageTag = getImageTag(descriptor);
			return imageTag + " " + getSignature(operation);
		}
		return "";
	}

	protected String getSignature(JvmOperation jvmOperation) {
		String returnTypeString = "void";
		JvmTypeReference returnType = jvmOperation.getReturnType();
		if (returnType != null) {
			if (returnType instanceof JvmAnyTypeReference) {
				returnTypeString = "Object";
			} else {
				returnTypeString = returnType.getSimpleName();
			}
		}
		return returnTypeString + " " + jvmOperation.getSimpleName() + hoverUiStrings.parameters(jvmOperation) + getThrowsDeclaration(jvmOperation);
	}

	protected String getSimpleSignature(JvmOperation jvmOperation) {
		return jvmOperation.getSimpleName() + uiStrings.parameters(jvmOperation);
	}

	protected String _hoverText(JvmField field) {
			ImageDescriptor descriptor = JavaElementImageProvider.getFieldImageDescriptor(false,
					toFlags(field.getVisibility()));
			String imageTag = "";
			if (field.isStatic()) {
				imageTag = getImageTag(getDecoratedJdtImageDescriptor(descriptor, JavaElementImageDescriptor.STATIC));
			} else
				imageTag = getImageTag(descriptor);

			return imageTag + getSignature(field);
	}

	protected String getSignature(JvmField jvmField) {
		JvmTypeReference type = jvmField.getType();
		if (type != null) {
			return type.getSimpleName() + " " + jvmField.getQualifiedName();
		}
		return "";
	}

	protected String _hoverText(JvmConstructor constructor) {
			ImageDescriptor imageDescriptor = JavaElementImageProvider.getMethodImageDescriptor(false,
					toFlags(constructor.getVisibility()));
			String imageTag = getImageTag(getDecoratedJdtImageDescriptor(imageDescriptor,
					JavaElementImageDescriptor.CONSTRUCTOR));
			return imageTag + getSignature(constructor);
	}

	protected String getSignature(JvmConstructor contructor) {
		return contructor.getQualifiedName() + " " + hoverUiStrings.parameters(contructor) + getThrowsDeclaration(contructor);
	}

	protected String getSimpleSignature(JvmConstructor contructor) {
		return contructor.getQualifiedName() + " " + uiStrings.parameters(contructor);
	}

	protected String _hoverText(JvmFormalParameter parameter) {
		ImageDescriptor descriptor = JavaPluginImages.DESC_OBJS_LOCAL_VARIABLE;
		String imageTag = getImageTag(descriptor);
		return imageTag + " " + getSignature(parameter);
	}

	protected String getSignature(JvmFormalParameter parameter) {
		JvmTypeReference parameterType = parameter.getParameterType();
		if (parameterType != null) {
			EObject container = parameter.eContainer();
			return parameterType.getSimpleName() + " " + parameter.getName() + JavaElementLabels.CONCAT_STRING
					+ getSignature(container);
		}
		return "";
	}
	
	protected String getThrowsDeclaration(JvmExecutable executable){
		String result = "";
		EList<JvmTypeReference> exceptions = executable.getExceptions();
		if(exceptions.size() > 0){
			result += " throws ";
			Iterator<JvmTypeReference> iterator = exceptions.iterator();
			while(iterator.hasNext()){
				JvmTypeReference next = iterator.next();
				result += next.getSimpleName();
				if(iterator.hasNext())
					result += ", ";
			}
		}
		return result;
	}

	protected String getSignature(EObject container) {
		if (container instanceof JvmOperation) {
				return getSimpleSignature((JvmOperation) container);
		} else if (container instanceof JvmConstructor) {
				return getSimpleSignature((JvmConstructor) container);
		}
		return "";
	}

	protected String getImageTag(ImageDescriptor imageDescriptor) {
		URL url = getURL(imageDescriptor);
		if (url != null)
			return "<image src='" + url.toExternalForm() + "'/>";
		return "";
	}

	protected URL getURL(ImageDescriptor descriptor) {
		return JavaPlugin.getDefault().getImagesOnFSRegistry().getImageURL(descriptor);
	}

	protected ImageDescriptor getDecoratedJdtImageDescriptor(ImageDescriptor descriptor, int adornment) {
		return new JavaElementImageDescriptor(descriptor, adornment, JavaElementImageProvider.SMALL_SIZE);
	}

	protected int toFlags(JvmVisibility visibility) {
		switch (visibility) {
			case PRIVATE:
				return Flags.AccPrivate;
			case PROTECTED:
				return Flags.AccProtected;
			case PUBLIC:
				return Flags.AccPublic;
			default:
				return Flags.AccDefault;
		}
	}
}
