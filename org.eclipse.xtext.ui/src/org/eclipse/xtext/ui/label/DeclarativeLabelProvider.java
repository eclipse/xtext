/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import java.util.Collections;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;

/**
 * A label provider that dispatches to typed <code>Object image()</code> and <code>Object text()</code> methods.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DeclarativeLabelProvider extends AbstractLabelProvider {

	
	private final PolymorphicDispatcher<Object> textDispatcher = new PolymorphicDispatcher<Object>("text", 1, 1,
			Collections.singletonList(this), new ErrorHandler<Object>() {
				@Override
				public Object handle(Object[] params, Throwable e) {
					return handleTextError(params, e);
				}
			});

	private final PolymorphicDispatcher<Object> imageDispatcher = new PolymorphicDispatcher<Object>("image", 1, 1,
			Collections.singletonList(this), new ErrorHandler<Object>() {
			@Override
			public Object handle(Object[] params, Throwable e) {
				return handleImageError(params, e);
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
		if (text != null) {
			return text;
		}
		return null;
	}

	@Override
	protected Object doGetImage(Object element) {
		Object image = imageDispatcher.invoke(element);
		if (image != null) {
			return image;
		}
		return super.doGetImage(element);
	}

	public Object image(Object element) {
		return null;
	}

	public Object text(Object element) {
		return null;
	}
	
	public Object image(Void element) {
		return null;
	}
	
	public Object text(Void element) {
		return null;
	}
	
	protected Object handleTextError(Object[] params, Throwable e) {
		if(e instanceof NullPointerException) {
			return getDefaultText();
		}
		return Exceptions.throwUncheckedException(e);
	}

	protected Object handleImageError(Object[] params, Throwable e) {
		if(e instanceof NullPointerException) {
			return getDefaultImage();
		}
		return Exceptions.throwUncheckedException(e);
	}
}
