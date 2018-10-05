/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class StubUtilityProxy {
	
	
	public static String getCompilationUnitContent(ICompilationUnit cu, String packDecl, String fileComment, String typeComment, String typeContent, String lineDelimiter) throws CoreException {
		Class<?> utilityClass = null;
		try {
			utilityClass = Class.forName("org.eclipse.jdt.internal.corext.codemanipulation.StubUtility");
		} catch (ClassNotFoundException e) {
			try {
				utilityClass = Class.forName("org.eclipse.jdt.internal.core.manipulation.StubUtility");
			} catch (ClassNotFoundException e1) {
				throw new IllegalStateException("could not find StubUtility class");
			}
		}
		try {
			Method declaredMethod = utilityClass.getDeclaredMethod("getCompilationUnitContent", ICompilationUnit.class, String.class, String.class, String.class, String.class, String.class);
			Object result = declaredMethod.invoke(null, cu, packDecl, fileComment, typeComment, typeContent, lineDelimiter);
			if (result == null || result instanceof String) {
				return (String) result;
			}
			throw new IllegalStateException("Unexpected result");
		} catch (NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("Method getCompilationUnitContent not found");
		} catch (IllegalAccessException | IllegalArgumentException e) {
			throw new IllegalStateException("Method getCompilationUnitContent could not be called");
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				throw (CoreException) e.getTargetException();
			}
			throw new IllegalStateException(e);
		}
	}

}
