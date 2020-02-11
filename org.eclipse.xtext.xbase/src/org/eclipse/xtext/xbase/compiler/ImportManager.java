/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.util.internal.CodeGenUtil2;

import com.google.common.collect.Sets;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Stephane Galland - Add protected accessors to fields.
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
			getThisTypeSimpleNames().add(thisType.getSimpleName());
			getThisTypeQualifiedNames().add(thisType.getQualifiedName(innerTypeSeparator));
			thisCollidesWithJavaLang |= CodeGenUtil2.isJavaLangType(thisType.getSimpleName());
			registerSimpleNamesOfInnerClasses(thisType, new LinkedHashSet<JvmType>());
		}
	}

	protected void registerSimpleNamesOfInnerClasses(JvmDeclaredType thisType, LinkedHashSet<JvmType> handled) {
		if (!handled.add(thisType))
			return;
		List<JvmDeclaredType> nested = EcoreUtil2.typeSelect(thisType.getMembers(), JvmDeclaredType.class);
		for (JvmDeclaredType jvmDeclaredType : nested) {
			getThisTypeSimpleNames().add(jvmDeclaredType.getSimpleName());
			getThisTypeQualifiedNames().add(jvmDeclaredType.getQualifiedName(getInnerTypeSeparator()));
			thisCollidesWithJavaLang |= CodeGenUtil2.isJavaLangType(jvmDeclaredType.getSimpleName());
		}
		for (JvmTypeReference superType: thisType.getSuperTypes()) {
			if (superType.getType() instanceof JvmDeclaredType) {
				registerSimpleNamesOfInnerClasses((JvmDeclaredType) superType.getType(), handled);
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
			builder.append(type.getQualifiedName(getInnerTypeSeparator()));
		} else if (type instanceof JvmArrayType) {
			appendType(((JvmArrayType) type).getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getQualifiedName(getInnerTypeSeparator());
			String nameToImport = qualifiedName;
			String shortName = type.getSimpleName();
			String outerShortName = shortName;
			if (shouldUseQualifiedNestedName(qualifiedName)) {
				JvmType outerContainer = type;
				while (outerContainer.eContainer() instanceof JvmType) {
					outerContainer = (JvmType) outerContainer.eContainer();
				}
				if (type != outerContainer) {
					outerShortName = outerContainer.getSimpleName();
					if(!getThisTypeQualifiedNames().contains(outerContainer.getQualifiedName(getInnerTypeSeparator())) && getThisTypeSimpleNames().contains(outerShortName)) {
						outerShortName = qualifiedName;
						shortName = qualifiedName;
					} else {
						nameToImport = outerContainer.getQualifiedName(getInnerTypeSeparator());
						shortName = outerShortName + qualifiedName.substring(nameToImport.length());
					}
				}
			}
			appendType(qualifiedName, shortName, outerShortName, nameToImport, builder);
		}
	}

	protected boolean shouldUseQualifiedNestedName(String identifier) {
		return !identifier.startsWith("org.eclipse.xtext.xbase.lib.");
	}

	public void appendType(final Class<?> type, StringBuilder builder) {
		if (type.isPrimitive()) {
			builder.append(type.getSimpleName());
		} else if (type.isArray()) {
			appendType(type.getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getCanonicalName();
			String nameToImport = qualifiedName;
			String shortName = type.getSimpleName();
			String outerShortName = shortName;
			if (shouldUseQualifiedNestedName(qualifiedName)) {
				Class<?> outerContainer = type;
				while (outerContainer.getDeclaringClass() != null) {
					outerContainer = outerContainer.getDeclaringClass();
				}
				if (type != outerContainer) {
					outerShortName =  outerContainer.getSimpleName();
					if(!getThisTypeQualifiedNames().contains(outerContainer.getCanonicalName()) && getThisTypeSimpleNames().contains(outerShortName)) {
						outerShortName = qualifiedName;
						shortName = qualifiedName;
					} else {
						nameToImport = outerContainer.getCanonicalName();
						shortName = outerShortName + qualifiedName.substring(nameToImport.length());
					}
				}
			}
			appendType(qualifiedName, shortName, outerShortName, nameToImport, builder);
		}
	}

	protected void appendType(final String qualifiedName, final String shortName, final String namespaceImport, StringBuilder builder) {
		appendType(qualifiedName, shortName, shortName, namespaceImport, builder);
	}

	protected void appendType(final String qualifiedName, final String shortName, final String outerShortName, final String namespaceImport, StringBuilder builder) {
		if (allowsSimpleName(namespaceImport, shortName)) {
			builder.append(shortName);
		} else if (needsQualifiedName(namespaceImport, shortName)) {
			builder.append(qualifiedName);
		} else {
			final Map<String, String> imps = internalGetImports();
			if (imps.containsKey(outerShortName)) {
				if (namespaceImport.equals(imps.get(outerShortName))) {
					builder.append(shortName);
				} else {
					builder.append(qualifiedName);
				}
			} else {
				imps.put(outerShortName, namespaceImport);
				builder.append(shortName);
			}
		}
	}

	protected boolean allowsSimpleName(String qualifiedName, String simpleName) {
		return getThisTypeQualifiedNames().contains(qualifiedName) || ((!thisCollidesWithJavaLang || !getThisTypeSimpleNames().contains(simpleName)) && JAVA_LANG_PACK.matcher(qualifiedName).matches())
				|| equal(qualifiedName, simpleName);
	}

	protected boolean needsQualifiedName(String qualifiedName, String simpleName) {
		return !organizeImports || (getThisTypeSimpleNames().contains(simpleName) && !getThisTypeQualifiedNames().contains(qualifiedName))
				|| CodeGenUtil2.isJavaLangType(simpleName);
	}

	public boolean addImportFor(JvmType type) {
		final String qualifiedName = type.getQualifiedName(getInnerTypeSeparator());
		final String simpleName = type.getSimpleName();
		final Map<String, String> imps = internalGetImports();
		if (!allowsSimpleName(qualifiedName, simpleName) && !needsQualifiedName(qualifiedName, simpleName) && !imps.containsKey(simpleName)) {
			imps.put(simpleName, qualifiedName);
			return true;
		}
		return false;
	}

	public List<String> getImports() {
		ArrayList<String> result = newArrayList(newLinkedHashSet(internalGetImports().values()));
		Collections.sort(result);
		return result;
	}
	
	/**
	 * Replies the internal set that contains the qualified names of "this" type.
	 *
	 * @return the internal set.
	 * @since 2.14
	 */
	protected final Set<String> getThisTypeQualifiedNames() {
		return this.thisTypeQualifiedNames;
	}

	/**
	 * Replies the internal set that contains the simple names of "this" type.
	 *
	 * @return the internal set.
	 * @since 2.14
	 */
	protected final Set<String> getThisTypeSimpleNames() {
		return this.thisTypeSimpleNames;
	}

	/**
	 * Replies the internal import data structure.
	 *
	 * @return the internal import data structure.
	 * @since 2.14
	 */
	protected final Map<String, String> internalGetImports() {
		return this.imports;
	}

	/**
	 * Replies the separator that is used for separating the enclosing type and the inner type names.
	 *
	 * @return the inner type separator.
	 * @since 2.14
	 */
	protected final char getInnerTypeSeparator() {
		return this.innerTypeSeparator;
	}

}
