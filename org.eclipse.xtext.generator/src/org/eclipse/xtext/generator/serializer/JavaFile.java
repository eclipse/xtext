/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.internal.CodeGenUtil2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
public class JavaFile {

	protected String body;

	protected final Map<String, String> imports = Maps.newHashMap();

	protected final String packageName;
	
	protected final String fileHeader;

	public JavaFile(String packageName, String fileHeader) {
		super();
		this.packageName = packageName;
		this.fileHeader = fileHeader;
	}
	
	public JavaFile(String packageName) {
		this(packageName, null);
	}

	public String imported(Class<?> clazz) {
		return imported(clazz.getName().replace('$', '.'));
	}

	public String imported(String clazz) {
		String simpleName = Strings.lastToken(clazz, ".");
		if (CodeGenUtil2.isJavaDefaultType(simpleName))
			return clazz;
		String imported = imports.get(simpleName);
		if (imported != null) {
			if (imported.equals(clazz))
				return simpleName;
			else
				return clazz;
		}
		imports.put(simpleName, clazz);
		return simpleName;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (fileHeader != null) {
			result.append(fileHeader).append('\n');
		}
		result.append("package ").append(packageName).append(";\n\n");
		List<String> sortedImports = Lists.newArrayList(imports.values());
		Collections.sort(sortedImports);
		for (String importName : sortedImports) {
			result.append("import ");
			result.append(importName);
			result.append(";\n");
		}
		result.append("\n");
		result.append(body);
		return result.toString();
	}
}
