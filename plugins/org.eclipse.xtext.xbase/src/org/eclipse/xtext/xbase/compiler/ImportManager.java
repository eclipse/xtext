/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVoid;

import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportManager {

	private Map<String, String> imports = newHashMap();

	private boolean organizeImports;
	

	private Set<String> thisTypeSimpleNames = Sets.newHashSet();
	private Set<String> thisTypeQualifiedNames = Sets.newHashSet();

	private final char innerTypeSeparator;

	public ImportManager(boolean organizeImports, char innerTypeSeparator) {
		this(organizeImports, null, innerTypeSeparator);
	}

	public ImportManager() {
		this(true, null);
	}
	
	public ImportManager(boolean organizeImports) {
		this(organizeImports, null);
	}
	
	public ImportManager(boolean organizeImports, JvmDeclaredType thisType) {
		this(organizeImports, thisType, '.');
	}
	
	public ImportManager(boolean organizeImports, JvmDeclaredType thisType, char innerTypeSeparator) {
		this.organizeImports = organizeImports;
		this.innerTypeSeparator = innerTypeSeparator;
		if (thisType != null) {
			thisTypeSimpleNames.add(thisType.getSimpleName());
			thisTypeQualifiedNames.add(thisType.getQualifiedName(innerTypeSeparator));
			thisCollidesWithJavaLang = CodeGenUtil.isJavaLangType(thisType.getSimpleName());
			for (JvmMember jvmMember : filter(thisType.getMembers(), Predicates.instanceOf(JvmDeclaredType.class))) {
				thisTypeSimpleNames.add(jvmMember.getSimpleName());
				thisTypeQualifiedNames.add(jvmMember.getQualifiedName(innerTypeSeparator));
				thisCollidesWithJavaLang |= CodeGenUtil.isJavaLangType(jvmMember.getSimpleName());
			}
		}
	}

	public CharSequence serialize(JvmType type) {
		StringBuilder sb = new StringBuilder();
		appendType(type, sb);
		return sb;
	}
	
	public CharSequence serialize(Class<?> type) {
		StringBuilder sb = new StringBuilder();
		appendType(type, sb);
		return sb;
	}

	private Pattern JAVA_LANG_PACK = Pattern.compile("java\\.lang\\.[\\w]+");

	private boolean thisCollidesWithJavaLang;

	public void appendType(final JvmType type, StringBuilder builder) {
		if (type instanceof JvmPrimitiveType || type instanceof JvmVoid || type instanceof JvmTypeParameter) {
			builder.append(type.getQualifiedName(innerTypeSeparator));
		} else if (type instanceof JvmArrayType) {
			appendType(((JvmArrayType) type).getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getQualifiedName(innerTypeSeparator);
			final String simpleName = type.getSimpleName();
			appendType(qualifiedName, simpleName, builder);
		}
	}

	public void appendType(final Class<?> type, StringBuilder builder) {
		if (type.isPrimitive()) {
			builder.append(type.getSimpleName());
		} else if (type.isArray()) {
			appendType(type.getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getCanonicalName();
			final String simpleName = type.getSimpleName();
			appendType(qualifiedName, simpleName, builder);
		}
	}
	
	protected void appendType(final String qualifiedName, final String simpleName, StringBuilder builder) {
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

	protected boolean allowsSimpleName(String qualifiedName, String simpleName) {
		return thisTypeQualifiedNames.contains(qualifiedName)
				|| (!thisCollidesWithJavaLang && JAVA_LANG_PACK.matcher(qualifiedName).matches())
				|| equal(qualifiedName, simpleName);
	}

	protected boolean needsQualifiedName(String qualifiedName, String simpleName) {
		return !organizeImports
				|| (thisTypeSimpleNames.contains(simpleName) && !thisTypeQualifiedNames.contains(qualifiedName))
				|| CodeGenUtil.isJavaLangType(simpleName);
	}

	public boolean addImportFor(JvmType type) {
		final String qualifiedName = type.getQualifiedName(innerTypeSeparator);
		final String simpleName = type.getSimpleName();
		if (!allowsSimpleName(qualifiedName, simpleName) && !needsQualifiedName(qualifiedName, simpleName)
				&& !imports.containsKey(simpleName)) {
			imports.put(simpleName, qualifiedName);
			return true;
		}
		return false;
	}

	public List<String> getImports() {
		ArrayList<String> result = newArrayList(imports.values());
		Collections.sort(result);
		return result;
	}
}
