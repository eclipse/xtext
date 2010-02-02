/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui;

import java.util.Collections;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Michael Clay
 */
public class SimpleLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private final PolymorphicDispatcher<Object> textDispatcher = new PolymorphicDispatcher<Object>("text", 1, 1,
			Collections.singletonList(this), new PolymorphicDispatcher.ErrorHandler<Object>() {

				private final PolymorphicDispatcher<Object> recoverText = new PolymorphicDispatcher<Object>(
						"error_text", 2, 2, Collections.singletonList(SimpleLabelProvider.this));

				public Object handle(Object[] params, Throwable e) {
					return recoverText.invoke(params[0], e);
				}
			});

	private final PolymorphicDispatcher<Object> imageDispatcher = new PolymorphicDispatcher<Object>("image", 1, 1,
			Collections.singletonList(this), new PolymorphicDispatcher.ErrorHandler<Object>() {

				private final PolymorphicDispatcher<Object> recoverImage = new PolymorphicDispatcher<Object>(
						"error_image", 2, 2, Collections.singletonList(SimpleLabelProvider.this));

				public Object handle(Object[] params, Throwable e) {
					return recoverImage.invoke(params[0], e);
				}
			});

	@Inject
	private IImageHelper imageHelper;

	@Override
	public String getText(Object element) {
		Object result = getTextDispatcher().invoke(element);
		if (result == null) {
			return null;
		}
		if (result instanceof String) {
			return (String) result;
		}
		if (result instanceof StyledString) {
			return ((StyledString) result).getString();
		}
		return (String) unkownReturnType(result);
	}

	public StyledString getStyledText(Object element) {
		Object result = getTextDispatcher().invoke(element);
		if (result == null) {
			return null;
		}
		if (result instanceof String) {
			return new StyledString((String) result);
		}
		if (result instanceof StyledString) {
			return (StyledString) result;
		}
		return (StyledString) unkownReturnType(result);
	}

	@Override
	public Image getImage(Object element) {
		Object result = getImageDispatcher().invoke(element);
		return doGetImage(result);
	}

	protected Image doGetImage(Object result) {
		if (result == null) {
			return null;
		} else if (result instanceof String) {
			return getImageHelper().getImage((String) result);
		} else if (result instanceof ImageDescriptor) {
			return getImageHelper().getImage((ImageDescriptor) result);
		} else if (result instanceof Image) {
			return (Image) result;
		}
		return (Image) unkownReturnType(result);
	}

	public String error_text(Object object, Exception e) {
		throw new WrappedException(e);
	}

	public String error_text(Object object, NullPointerException e) {
		return text(object);
	}

	public String text(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			EClass eClass = eObject.eClass();

			EStructuralFeature feature = getLabelFeature(eClass);
			if (feature != null) {
				Object value = eObject.eGet(feature);
				if (value != null) {
					return value.toString();
				}
			}
		}
		return null;
	}

	public String error_image(Object object, Exception e) {
		throw new WrappedException(e);
	}

	public String error_image(Object object, NullPointerException e) {
		return image(object);
	}

	public String image(Object obj) {
		return null;
	}

	protected Object unkownReturnType(Object result) {
		throw new IllegalStateException("The return type " + result.getClass()
				+ " is not supported for the polymorphic text(Object o) or image(Object o) method.");
	}

	protected EStructuralFeature getLabelFeature(EClass eClass) {
		EAttribute result = null;
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if ("name".equalsIgnoreCase(eAttribute.getName())) {
					result = eAttribute;
					break;
				} else if (result == null) {
					result = eAttribute;
				} else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
						&& result.getEAttributeType().getInstanceClass() != String.class) {
					result = eAttribute;
				}
			}
		}
		return result;
	}

	public void setImageHelper(IImageHelper imageHelper) {
		this.imageHelper = imageHelper;
	}

	public IImageHelper getImageHelper() {
		return imageHelper;
	}

	public PolymorphicDispatcher<Object> getTextDispatcher() {
		return textDispatcher;
	}

	public PolymorphicDispatcher<Object> getImageDispatcher() {
		return imageDispatcher;
	}
	
}
