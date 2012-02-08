/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import java.net.URL;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
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
public class XtendDeclarativeHoverSignatureProvider {
	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private HoverUiStrings hoverUiStrings;
	
	@Inject
	private UIStrings uiStrings;

	public String getHoverText(EObject object) {
		PolymorphicDispatcher<String> polymorphicDispatcher = new PolymorphicDispatcher<String>("_hoverText", 1, 1,
				Collections.singletonList(this), new ErrorHandler<String>() {
					public String handle(Object[] params, Throwable throwable) {
						return "";
					}
				});
		return "<b>" + polymorphicDispatcher.invoke(object) + "</b>";
	}

	public String _hoverText(XtendClass clazz) {
		JvmGenericType inferredType = associations.getInferredType(clazz);
		if (inferredType != null) {
			String imageTag = getImageTag(JavaElementImageProvider.getTypeImageDescriptor(false, false,
					toFlags(inferredType.getVisibility()), false));
			return imageTag + getSignature(clazz);
		}
		return "";
	}
	
	private String getSignature(XtendClass clazz){
		return clazz.getPackageName() + "." + clazz.getSimpleName();
	}

	public String _hoverText(XtendFunction function) {
		JvmOperation inferredType = associations.getDirectlyInferredOperation(function);
		if (inferredType != null) {
			ImageDescriptor descriptor = JavaElementImageProvider.getMethodImageDescriptor(false,
					toFlags(inferredType.getVisibility()));
			String imageTag = "";
			if (inferredType.isStatic()) {
				imageTag = getImageTag(getDecoratedJdtImageDescriptor(descriptor, JavaElementImageDescriptor.STATIC));
			} else
				imageTag = getImageTag(descriptor);
			return imageTag + " " + getSignature(inferredType);
		}
		return "";
	}

	private String getSignature(JvmOperation jvmOperation) {
		String returnTypeString = "void";
		JvmTypeReference returnType = jvmOperation.getReturnType();
		if (returnType != null) {
			if (returnType instanceof JvmAnyTypeReference) {
				returnTypeString = "Object";
			} else {
				returnTypeString = returnType.getSimpleName();
			}
		}
		return returnTypeString + " " + jvmOperation.getSimpleName() + hoverUiStrings.parameters(jvmOperation);
	}
	
	private String getSimpleSignature(JvmOperation jvmOperation){
		return jvmOperation.getSimpleName() + uiStrings.parameters(jvmOperation);
	}

	public String _hoverText(XtendField field) {
		JvmField inferredType = associations.getJvmField(field);
		if (inferredType != null) {
			ImageDescriptor descriptor = JavaElementImageProvider.getFieldImageDescriptor(false,
					toFlags(inferredType.getVisibility()));
			String imageTag = "";
			if (inferredType.isStatic()) {
				imageTag = getImageTag(getDecoratedJdtImageDescriptor(descriptor, JavaElementImageDescriptor.STATIC));
			} else
				imageTag = getImageTag(descriptor);

			return imageTag + getSignature(inferredType);
		}
		return "";
	}

	private String getSignature(JvmField jvmField) {
		JvmTypeReference type = jvmField.getType();
		if (type != null) {
			return type.getSimpleName() + " " + jvmField.getQualifiedName();
		}
		return "";
	}

	public String _hoverText(XtendConstructor constructor) {
		JvmConstructor inferredConstructor = associations.getInferredConstructor(constructor);
		if (inferredConstructor != null) {
			ImageDescriptor imageDescriptor = JavaElementImageProvider.getMethodImageDescriptor(false,
					toFlags(inferredConstructor.getVisibility()));
			String imageTag = getImageTag(getDecoratedJdtImageDescriptor(imageDescriptor,
					JavaElementImageDescriptor.CONSTRUCTOR));
			return imageTag + getSignature(inferredConstructor);
		}
		return "";
	}

	private String getSignature(JvmConstructor contructor) {
		return contructor.getQualifiedName() + " " + hoverUiStrings.parameters(contructor);
	}
	
	private String getSimpleSignature(JvmConstructor contructor) {
		return contructor.getQualifiedName() + " " + uiStrings.parameters(contructor);
	}

	public String _hoverText(XtendParameter parameter) {
		ImageDescriptor descriptor = JavaPluginImages.DESC_OBJS_LOCAL_VARIABLE;
		String imageTag = getImageTag(descriptor);
		return imageTag + " " + getSignature(parameter);
	}

	private String getSignature(XtendParameter parameter) {
		JvmTypeReference parameterType = parameter.getParameterType();
		if (parameterType != null) {
			EObject container = parameter.eContainer();
			return parameterType.getSimpleName() +  " " + parameter.getName() + JavaElementLabels.CONCAT_STRING + getSignature(container);
		}
		return "";
	}

	private String getSignature(EObject container) {
		if(container instanceof XtendFunction){
			JvmOperation inferredType = associations.getDirectlyInferredOperation((XtendFunction)container);
			if(inferredType != null)
				return getSimpleSignature(inferredType);
		} else if(container instanceof XtendConstructor) {
			JvmConstructor inferredConstructor = associations.getInferredConstructor((XtendConstructor)container);
			if(inferredConstructor != null)
				return getSimpleSignature(inferredConstructor);
		}
		return "";
	}

	private String getImageTag(ImageDescriptor imageDescriptor) {
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
