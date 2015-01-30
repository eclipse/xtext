/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.base.Strings;

/**
 * A class annotation configuration for the <code>@Generated</code> annotation.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.8
 */
public class GeneratedClassAnnotation implements IClassAnnotation {
	
	private boolean includeDate = false;
	
	private String comment;
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("@javax.annotation.Generated(");
		if (includeDate || !Strings.isNullOrEmpty(comment)) {
			stringBuilder.append("value = ");
		}
		stringBuilder.append('\"').append(getGeneratorName()).append('\"');
		if (includeDate) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
			String date = dateFormat.format(new Date());
			stringBuilder.append(", date = \"").append(date).append('\"');
		}
		if (!Strings.isNullOrEmpty(comment)) {
			stringBuilder.append(", comments = \"").append(comment).append('\"');
		}
		return stringBuilder.append(')').toString();
	}
	
	protected String getGeneratorName() {
		return Generator.class.getName();
	}

	/**
	 * Whether the current time should be included in the <code>@Generated</code> annotation.
	 */
	public void setIncludeDate(boolean includeDate) {
		this.includeDate = includeDate;
	}

	/**
	 * An arbitrary comment to include in the <code>@Generated</code> annotation.
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
