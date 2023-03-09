/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.annotations;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * A class annotation configuration for the <code>@Generated</code> annotation.
 */
public class GeneratedClassAnnotation implements IClassAnnotation {
	private boolean includeDate = false;

	private String comment;

	@Override
	public CharSequence generate() {
		StringBuilder stringBuilder = new StringBuilder("@Generated(");
		if (includeDate || !Strings.isEmpty(comment)) {
			stringBuilder.append("value = ");
		}
		stringBuilder.append("\"");
		stringBuilder.append(getGeneratorName());
		stringBuilder.append("\"");
		if (includeDate) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mmZ");
			String date = dateFormat.format(new Date());
			stringBuilder.append(", date = \"");
			stringBuilder.append(date);
			stringBuilder.append("\"");
		}
		if (!Strings.isEmpty(comment)) {
			stringBuilder.append(", comments = \"");
			stringBuilder.append(Strings.convertToJavaString(comment));
			stringBuilder.append("\"");
		}
		stringBuilder.append(")");
		return stringBuilder;
	}

	protected String getGeneratorName() {
		return XtextGenerator.class.getName();
	}

	@Override
	public boolean appliesTo(JavaFileAccess javaFile) {
		return javaFile.isMarkedAsGenerated();
	}

	@Override
	public TypeReference getAnnotationImport() {
		return new TypeReference("javax.annotation.Generated");
	}

	@Override
	public String toString() {
		return generate().toString();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof GeneratedClassAnnotation;
	}

	@Override
	public int hashCode() {
		return getClass().getName().hashCode();
	}

	public boolean isIncludeDate() {
		return includeDate;
	}

	public void setIncludeDate(boolean includeDate) {
		this.includeDate = includeDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
