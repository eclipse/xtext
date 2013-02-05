/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.xtext.util.Strings;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendTypeCreatorUtil {
	public static String createClass(String typeName, IPackageFragment packageFragment, String superClass,
			@SuppressWarnings("rawtypes") List superInterfaces, String indentation, String lineSeparator,
			IProgressMonitor monitor) throws CoreException {
		StringBuffer sb = new StringBuffer();
		if(packageFragment.getElementName() != null && !packageFragment.getElementName().equals("")){
			sb.append("package ");
			sb.append(packageFragment.getElementName());
			sb.append(lineSeparator);
			sb.append(lineSeparator);
		}
		if(!Strings.isEmpty(superClass) && !superClass.equals("java.lang.Object")) {
			addImport(sb, superClass, lineSeparator);
		}
		for (Object object : superInterfaces) {
			addImport(sb, object, lineSeparator);
		}
		if(superInterfaces.size() > 0 || !superClass.equals("java.lang.Object")) {
			sb.append(lineSeparator);
		}
		sb.append("class ");
		sb.append(typeName);
		if(!Strings.isEmpty(superClass) && !superClass.equals("java.lang.Object")) {
			sb.append(" extends ");
			sb.append(stripPackage(superClass));
		}
		@SuppressWarnings("rawtypes")
		Iterator i = superInterfaces.iterator();
		if(i.hasNext()) {
			sb.append(" implements ");
			sb.append(stripPackage(i.next()));
			while (i.hasNext()) {
				sb.append(", ");
				sb.append(stripPackage(i.next()));
			}
		}
		sb.append(" {");
		sb.append(lineSeparator);
		sb.append(indentation);
		sb.append(lineSeparator);
		sb.append("}");
		return sb.toString();
	}

	public static String createInterface(String typeName, IPackageFragment packageFragment,
			@SuppressWarnings("rawtypes") List superInterfaces, String indentation, String lineSeparator,
			IProgressMonitor monitor) throws CoreException {
		StringBuffer sb = new StringBuffer();
		if(packageFragment.getElementName() != null && !packageFragment.getElementName().equals("")){
			sb.append("package ");
			sb.append(packageFragment.getElementName());
			sb.append(lineSeparator);
			sb.append(lineSeparator);
		}
		for (Object object : superInterfaces) {
			addImport(sb, object, lineSeparator);
		}
		if(superInterfaces.size() > 0) {
			sb.append(lineSeparator);
		}
		sb.append("interface ");
		sb.append(typeName);
		@SuppressWarnings("rawtypes")
		Iterator i = superInterfaces.iterator();
		if(i.hasNext()) {
			sb.append(" extends ");
			sb.append(stripPackage(i.next()));
			while (i.hasNext()) {
				sb.append(", ");
				sb.append(stripPackage(i.next()));
			}
		}
		sb.append(" {");
		sb.append(lineSeparator);
		sb.append(indentation);
		sb.append(lineSeparator);
		sb.append("}");
		return sb.toString();
	}

	public static String createEnum(String typeName, IPackageFragment packageFragment, String indentation,
			String lineSeparator, IProgressMonitor monitor) {
		StringBuffer sb = new StringBuffer();
		if(packageFragment.getElementName() != null && !packageFragment.getElementName().equals("")){
			sb.append("package ");
			sb.append(packageFragment.getElementName());
			sb.append(lineSeparator);
			sb.append(lineSeparator);
		}
		sb.append("enum ");
		sb.append(typeName);
		sb.append(" {");
		sb.append(lineSeparator);
		sb.append(indentation);
		sb.append(lineSeparator);
		sb.append("}");
		return sb.toString();
	}

	public static String createAnnotation(String typeName, IPackageFragment packageFragment, String indentation,
			String lineSeparator, IProgressMonitor monitor) {
		StringBuffer sb = new StringBuffer();
		if(packageFragment.getElementName() != null && !packageFragment.getElementName().equals("")){
			sb.append("package ");
			sb.append(packageFragment.getElementName());
			sb.append(lineSeparator);
			sb.append(lineSeparator);
		}
		sb.append("annotation ");
		sb.append(typeName);
		sb.append(" {");
		sb.append(lineSeparator);
		sb.append(indentation);
		sb.append(lineSeparator);
		sb.append("}");
		return sb.toString();
	}

	private static Object stripPackage(Object superType) {
		return superType.toString().replaceAll("^(\\w+\\.)*", "") ;
	}

	private static void addImport(StringBuffer sb, Object object, String lineSeparator) {
		sb.append("import ");
		sb.append(removeGenerics(object));
		sb.append(lineSeparator);
	}

	private static String removeGenerics(Object object) {
		String ret = object.toString().replaceAll("<.*>$", "");
		return ret;
	}
}
