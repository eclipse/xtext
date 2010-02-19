/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import java.util.Collections;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * A label provider that dispatches to typed <code>Object image()</code> and <code>Object text()</code> methods.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class DeclarativeLabelProvider extends AbstractLabelProvider {

	private final PolymorphicDispatcher<Object> textDispatcher = new PolymorphicDispatcher<Object>("text", 1, 1,
			Collections.singletonList(this), new PolymorphicDispatcher.ErrorHandler<Object>() {

				private final PolymorphicDispatcher<Object> recoverText = new PolymorphicDispatcher<Object>(
						"error_text", 2, 2, Collections.singletonList(DeclarativeLabelProvider.this));

				public Object handle(Object[] params, Throwable e) {
					return recoverText.invoke(params[0], e);
				}
			});

	private final PolymorphicDispatcher<Object> imageDispatcher = new PolymorphicDispatcher<Object>("image", 1, 1,
			Collections.singletonList(this), new PolymorphicDispatcher.ErrorHandler<Object>() {

				private final PolymorphicDispatcher<Object> recoverImage = new PolymorphicDispatcher<Object>(
						"error_image", 2, 2, Collections.singletonList(DeclarativeLabelProvider.this));

				public Object handle(Object[] params, Throwable e) {
					return recoverImage.invoke(params[0], e);
				}
			});
	

	public DeclarativeLabelProvider() {
		super();
	}

	public DeclarativeLabelProvider(ILabelProvider delegate) {
		super(delegate);
	}

	@Override
	protected Object doGetText(Object element) {
		Object text = textDispatcher.invoke(element);
		if(text != null) { 
			return text;
		}
		return null;
	}

	@Override
	protected Object doGetImage(Object element) {
		Object image = imageDispatcher.invoke(element);
		if(image != null) {
			return image;
		}
		return super.doGetImage(element);
	}
	
	protected String error_text(Object object, Exception e) {
		throw new WrappedException(e);
	}

	protected String error_text(Object object, NullPointerException e) {
		return getDefaultText();
	}
	
	protected Object error_image(Object object, Exception e) {
		throw new WrappedException(e);
	}

	protected Object error_image(Object object, NullPointerException e) {
		return getDefaultImage();
	}
	
	public Object image(Object element) {
		return null;
	}
	
	public Object text(Object element) {
		return null;
	}
}
