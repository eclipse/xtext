/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.util.IAcceptor;

/**
 * A base dispatch class to be subclassed by Xtend.
 * It allows subclasses to use Xtend's dispatch methods in order to avoid explicit tree navigation and 
 * instanceof checking.
 * 
 * see also {@link IJvmModelInferrer}
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractModelInferrer implements IJvmModelInferrer {
	
	private static Logger log = Logger.getLogger(AbstractModelInferrer.class);
	private Method oldApiMethod;
	private boolean hasLoggedAboutDeprecation = false;
	
	public AbstractModelInferrer() {
		try {
			oldApiMethod = this.getClass().getMethod("infer", new Class[]{EObject.class, Object.class, Boolean.TYPE});
		} catch (Exception e) {
		}
	}
	
	public void infer(EObject e, final /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		if (oldApiMethod != null) {
			try {
				if (!hasLoggedAboutDeprecation) {
					hasLoggedAboutDeprecation = true;
					log.error("The class '"+getClass().getName()+"' is using a deprecated implementation of IJvmModelInferrer. Please change the type of the acceptor in your 'infer' method" +
							".\nIt should be 'org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor'.\nThis backward compatibility mode will be removed in the next release (2.3 June 2012).");
				}
				oldApiMethod.invoke(this, e, new IAcceptor<JvmDeclaredType>() {
					public void accept(JvmDeclaredType t) {
						acceptor.accept(t);
					}
				}, preIndexingPhase);
			} catch (IllegalArgumentException e1) {
				log.error(e1);
			} catch (IllegalAccessException e1) {
				log.error(e1);
			} catch (InvocationTargetException e1) {
				if (e1.getTargetException() instanceof IllegalArgumentException) {
					_infer(e, acceptor, preIndexingPhase);
				} else {
					log.error(e1.getTargetException());
				}
			}
		} else {
			_infer(e, acceptor, preIndexingPhase);
		}
	}

	
	public void _infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		for (EObject child : e.eContents()) {
			infer(child, acceptor, preIndexingPhase);
		}
	}
}
