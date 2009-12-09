/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import java.util.Collections;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleLabelProvider extends LabelProvider {

	private final PolymorphicDispatcher<String> textDispatcher = new PolymorphicDispatcher<String>("text", 1, 1,
			Collections.singletonList(this), new PolymorphicDispatcher.ErrorHandler<String>() {

				private final PolymorphicDispatcher<String> recoverText = new PolymorphicDispatcher<String>(
						"error_text", 2, 2, Collections.singletonList(SimpleLabelProvider.this));

				public String handle(Object[] params, Throwable e) {
					return recoverText.invoke(params[0], e);
				}
			});

	private final PolymorphicDispatcher<String> imageDispatcher = new PolymorphicDispatcher<String>("image", 1, 1,
			Collections.singletonList(this), new PolymorphicDispatcher.ErrorHandler<String>() {

				private final PolymorphicDispatcher<String> recoverImage = new PolymorphicDispatcher<String>(
						"error_image", 2, 2, Collections.singletonList(SimpleLabelProvider.this));

				public String handle(Object[] params, Throwable e) {
					return recoverImage.invoke(params[0], e);
				}
			});

	@Inject
	private IImageHelper imageHelper;

	@Override
	public String getText(Object element) {
		return getTextDispatcher().invoke(element);
	}

	@Override
	public Image getImage(Object element) {
		String imageName = getImageDispatcher().invoke(element);
		return getImageHelper().getImage(imageName);
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

	protected EStructuralFeature getLabelFeature(EClass eClass) {
		EAttribute result = null;
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if ("name".equalsIgnoreCase(eAttribute.getName())) {
					result = eAttribute;
					break;
				}
				else if (result == null) {
					result = eAttribute;
				}
				else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
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

	public PolymorphicDispatcher<String> getTextDispatcher() {
		return textDispatcher;
	}

	public PolymorphicDispatcher<String> getImageDispatcher() {
		return imageDispatcher;
	}

}
