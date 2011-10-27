/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVoid;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportManager {

	private Map<String,String> imports = newHashMap();

	private boolean organizeImports;

	private String thisTypeSimpleName;
	private String thisTypeQualifiedName;
	
	public ImportManager(boolean organizeImports) {
		this(organizeImports, null);
	}
	
	public ImportManager(boolean organizeImports, JvmDeclaredType thisType) {
		this.organizeImports = organizeImports;
		if(thisType != null) {
			thisTypeSimpleName = thisType.getSimpleName();
			thisTypeQualifiedName = thisType.getQualifiedName('.');
		}
	}
	
	public CharSequence serialize(JvmType type) {
		StringBuilder sb = new StringBuilder();
		appendType(type, sb);
		return sb;
	}
	
	private Pattern JAVA_LANG_PACK = Pattern.compile("java\\.lang\\.[\\w]+");

	public void appendType(final JvmType type, StringBuilder builder) {
		if (type instanceof JvmPrimitiveType || type instanceof JvmVoid || type instanceof JvmTypeParameter) {
			builder.append(type.getQualifiedName('.'));
		} else if (type instanceof JvmArrayType) {
			appendType(((JvmArrayType) type).getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getQualifiedName('.');
			final String simpleName = type.getSimpleName();
			if (allowsSimpleName(qualifiedName, simpleName)) {
				builder.append(simpleName);
			} else if (needsQualifiedName(qualifiedName, simpleName)) {
				builder.append(qualifiedName);
			} else {
				if (imports.containsKey(simpleName)) {
					if (qualifiedName.equals(imports.get(simpleName))) {
						builder.append(simpleName);
					} else {
						builder.append(qualifiedName);
					}
				} else {
					imports.put(simpleName, qualifiedName);
					builder.append(simpleName);
				}
			}
		}
	}
	
	protected boolean allowsSimpleName(String qualifiedName, String simpleName) {
		return equal(qualifiedName, thisTypeQualifiedName) 
				|| (JAVA_LANG_PACK.matcher(qualifiedName).matches() && !CodeGenUtil.isJavaLangType(thisTypeSimpleName)) 
				|| equal(qualifiedName, simpleName);
	}
	
	protected boolean needsQualifiedName(String qualifiedName, String simpleName) {
		return !organizeImports 
				|| (equal(simpleName, thisTypeSimpleName) 
						&& !equal(qualifiedName, thisTypeQualifiedName))
				|| CodeGenUtil.isJavaLangType(simpleName);
	}

	public List<String> getImports() {
		ArrayList<String> result = newArrayList(imports.values());
		Collections.sort(result);
		return result;
	}
}
