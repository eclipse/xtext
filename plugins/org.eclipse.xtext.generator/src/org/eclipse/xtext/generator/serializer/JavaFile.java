/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JavaFile {

	protected String body;

	protected List<String> imports = Lists.newArrayList();

	protected String packageName;

	protected JavaFile(String packageName) {
		super();
		this.packageName = packageName;
	}

	public List<String> getImports() {
		return imports;
	}

	protected boolean isImportUsed(String importName) {
		if (importName.endsWith("*"))
			return true;
		String simpleName = Strings.lastToken(importName, ".");
		Pattern p = Pattern.compile("[^a-zA-Z0-9]" + simpleName + "[^a-zA-Z0-9]");
		return p.matcher(body).find();
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("package " + packageName + ";\n\n");
		for (String importName : imports)
			if (isImportUsed(importName)) {
				result.append("import ");
				result.append(importName);
				result.append(";\n");
			}
		result.append("\n");
		result.append(body);
		return result.toString();
	}
}
