/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.xtext.util.Strings;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Anton Kosyakov - https://bugs.eclipse.org/bugs/show_bug.cgi?id=379220
 * @author Karsten Thoms - bug#378821
 */
public class XtendTypeCreatorUtil {

	public static String createPackageDeclaration(String typeName, IPackageFragment packageFragment, String lineSeparator) {
		StringBuffer sb = new StringBuffer();
		if(packageFragment.getElementName() != null && !packageFragment.getElementName().equals("")){
			sb.append("package ");
			sb.append(packageFragment.getElementName());
		}
		return sb.toString();
	}

	public static String createPackageDeclaration(String typeName, IPackageFragment packageFragment, String superClass, 
			@SuppressWarnings("rawtypes") List superInterfaces, String lineSeparator) {
		StringBuffer sb = new StringBuffer();
		if(packageFragment.getElementName() != null && !packageFragment.getElementName().equals("")){
			sb.append("package ");
			sb.append(packageFragment.getElementName());
		}
		int size = superInterfaces.size();
		if(size > 0 || !superClass.equals("java.lang.Object")) {
			sb.append(lineSeparator);
			sb.append(lineSeparator);
		}
		if(!Strings.isEmpty(superClass) && !superClass.equals("java.lang.Object")) {
			addImport(sb, superClass, size != 0 ? lineSeparator : null);
		}
		for (int index = 0; index < size; index++) {
			Object superInterface = superInterfaces.get(index);
			addImport(sb, superInterface, index + 1 != size ? lineSeparator : null);
		}
		return sb.toString();
	}

	public static String createPackageDeclaration(String typeName, IPackageFragment packageFragment, @SuppressWarnings("rawtypes") List superInterfaces, String lineSeparator) {
		StringBuffer sb = new StringBuffer();
		if(packageFragment.getElementName() != null && !packageFragment.getElementName().equals("")){
			sb.append("package ");
			sb.append(packageFragment.getElementName());
		}
		int size = superInterfaces.size();
		if(size > 0) {
			sb.append(lineSeparator);
			sb.append(lineSeparator);
		}
		for (int index = 0; index < size; index++) {
			Object superInterface = superInterfaces.get(index);
			addImport(sb, superInterface, index + 1 != size ? lineSeparator : null);
		}
		return sb.toString();
	}

	public static String createClassContent(String typeName, String superClass, @SuppressWarnings("rawtypes") List superInterfaces,
			String indentation, String lineSeparator, boolean createMain) {
		StringBuffer sb = new StringBuffer();
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
		if (createMain) {
			sb.append("def static void main(String[] args) {");
			sb.append(lineSeparator);
			sb.append(indentation);
			sb.append(indentation);
			sb.append(lineSeparator);
			sb.append(indentation);
			sb.append("}");
		}
		sb.append(lineSeparator);
		sb.append("}");
		return sb.toString();
	}

	public static String createInterfaceContent(String typeName, @SuppressWarnings("rawtypes") List superInterfaces, String indentation, String lineSeparator) {
		StringBuffer sb = new StringBuffer();
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

	public static String createEnumContent(String typeName, String indentation, String lineSeparator) {
		StringBuffer sb = new StringBuffer();
		sb.append("enum ");
		sb.append(typeName);
		sb.append(" {");
		sb.append(lineSeparator);
		sb.append(indentation);
		sb.append(lineSeparator);
		sb.append("}");
		return sb.toString();
	}
	
	public static String createAnnotationContent(String typeName, String indentation, String lineSeparator) {
		StringBuffer sb = new StringBuffer();
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
		if (lineSeparator != null) {
			sb.append(lineSeparator);
		}
	}

	private static String removeGenerics(Object object) {
		String ret = object.toString().replaceAll("<.*>$", "");
		return ret;
	}
	
}
