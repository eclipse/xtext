/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.xtext.util.Strings;

/**
 * A class annotation configuration for the <code>@Generated</code> annotation.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.8
 */
@Deprecated(forRemoval = true)
public class GeneratedClassAnnotation implements IClassAnnotation {
	
	private boolean includeDate = false;
	
	private String comment;
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("@Generated(");
		if (includeDate || !Strings.isEmpty(comment)) {
			stringBuilder.append("value = ");
		}
		stringBuilder.append('\"').append(getGeneratorName()).append('\"');
		if (includeDate) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
			String date = dateFormat.format(new Date());
			stringBuilder.append(", date = \"").append(date).append('\"');
		}
		if (!Strings.isEmpty(comment)) {
			String convertedComment = Strings.convertToJavaString(comment);
			stringBuilder.append(", comments = \"").append(convertedComment).append('\"');
		}
		return stringBuilder.append(')').toString();
	}
	
	protected String getGeneratorName() {
		return Generator.class.getName();
	}

	@Override
	public String getAnnotationImport() {
		return "javax.annotation.Generated";
	}

	/**
	 * Whether the current time should be included in the <code>@Generated</code> annotation.
	 */
	public void setIncludeDate(boolean includeDate) {
		this.includeDate = includeDate;
	}

	/**
	 * An arbitrary comment to include in the <code>@Generated</code> annotation. Characters that
	 * are not valid for Java strings are escaped, e.g. " becomes \".
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
