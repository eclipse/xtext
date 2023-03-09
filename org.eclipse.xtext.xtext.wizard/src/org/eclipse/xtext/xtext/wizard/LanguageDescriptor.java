/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import java.util.Iterator;

import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class LanguageDescriptor {
	public static class FileExtensions implements Iterable<String> {

		public FileExtensions(Iterable<String> fileExtensions) {
			this.fileExtensions = fileExtensions;
		}

		public static FileExtensions fromString(String fileExtensions) {
			Iterable<String> splitFileExtensions = Splitter.on(",").trimResults().omitEmptyStrings()
					.split(fileExtensions);
			return new FileExtensions(splitFileExtensions);
		}

		private final Iterable<String> fileExtensions;

		@Override
		public Iterator<String> iterator() {
			return fileExtensions.iterator();
		}

		@Override
		public String toString() {
			return Joiner.on(",").join(fileExtensions);
		}
	}

	private String name;

	private FileExtensions fileExtensions;

	public String getBasePackage() {
		int i = name.lastIndexOf(".");
		int endIndex = 0;
		if (i == -1) {
			endIndex = name.length();
		} else {
			endIndex = i;
		}
		return name.substring(0, endIndex);
	}

	public String getBasePackagePath() {
		return getBasePackage().replaceAll("\\.", "/");
	}

	public String getSimpleName() {
		String[] segments = name.split("\\.");
		return StringExtensions.toFirstUpper(segments[segments.length - 1]);
	}

	public String getNsURI() {
		String[] strings = this.name.split("\\.");
		if (strings.length < 2) {
			return "http://www." + this.name;
		}
		String s = "http://www." + strings[1] + "." + strings[0];
		for (int i = 2; i < strings.length; i++) {
			s = s + "/" + strings[i];
		}
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileExtensions getFileExtensions() {
		return fileExtensions;
	}

	public void setFileExtensions(FileExtensions fileExtensions) {
		this.fileExtensions = fileExtensions;
	}
}
