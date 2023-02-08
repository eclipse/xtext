/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 * @deprecated Use org.eclipse.xtext.xbase.testing.RegisteringFileSystemAccess instead
 */
@Deprecated(forRemoval = true)
public class RegisteringFileSystemAccess extends InMemoryFileSystemAccess {
	/**
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class GeneratedFile {
		private final String path;

		private final String javaClassName;

		private final CharSequence contents;

		public GeneratedFile(String path, String javaClassName, CharSequence contents) {
			this.path = path;
			this.javaClassName = javaClassName;
			this.contents = contents;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((contents == null) ? 0 : contents.hashCode());
			result = prime * result + ((javaClassName == null) ? 0 : javaClassName.hashCode());
			result = prime * result + ((path == null) ? 0 : path.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GeneratedFile other = (GeneratedFile) obj;
			if (contents == null) {
				if (other.contents != null)
					return false;
			} else if (!contents.equals(other.contents))
				return false;
			if (javaClassName == null) {
				if (other.javaClassName != null)
					return false;
			} else if (!javaClassName.equals(other.javaClassName))
				return false;
			if (path == null) {
				if (other.path != null)
					return false;
			} else if (!path.equals(other.path))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("path", this.path);
			b.add("javaClassName", this.javaClassName);
			b.add("contents", this.contents);
			return b.toString();
		}

		public String getPath() {
			return path;
		}

		public String getJavaClassName() {
			return javaClassName;
		}

		public CharSequence getContents() {
			return contents;
		}
	}

	private final Set<GeneratedFile> generatedFiles = new HashSet<>();

	private String projectName;

	@Override
	public void generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		super.generateFile(fileName, outputConfigurationName, contents);
		String path = getPath(fileName, outputConfigurationName);
		String javaName = null;
		if (fileName.endsWith(".java")) {
			javaName = fileName.substring(0, fileName.length() - 5).replace("/", ".");
		}
		generatedFiles.add(new GeneratedFile(path, javaName, contents));
	}

	protected String getPath(String fileName, String outputConfigurationName) {
		String path = getPathes().get(outputConfigurationName);
		return "/" + projectName + "/" + path + "/" + fileName;
	}

	public Set<GeneratedFile> getGeneratedFiles() {
		return generatedFiles;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
