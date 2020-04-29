/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard.cli;

import java.io.File;
import java.io.IOException;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.BinaryFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectsCreator;
import org.eclipse.xtext.xtext.wizard.SourceFolderDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import com.google.common.io.Resources;

public class CliProjectsCreator implements ProjectsCreator {
	private String lineDelimiter;

	@Override
	public void createProjects(WizardConfiguration config) {
		for (ProjectDescriptor p : config.getEnabledProjects()) {
			createProject(p);
		}
	}

	public void createProject(ProjectDescriptor project) {
		Preconditions.checkNotNull(lineDelimiter, "lineDelimiter may not be null");
		try {
			File projectRoot = new File(project.getLocation());
			projectRoot.mkdirs();
			for (AbstractFile f : project.getFiles()) {
				String outletPath = project.getConfig().getSourceLayout().getPathFor(f.getOutlet());
				String projectRelativePath = outletPath + "/" + f.getRelativePath();
				File file = new File(projectRoot, projectRelativePath);
				file.getParentFile().mkdirs();
				if (f instanceof TextFile) {
					String normalizedContent = ((TextFile) f).getContent().replace(Strings.newLine(),
							lineDelimiter);
					Files.asCharSink(file, project.getConfig().getEncoding()).write(normalizedContent);
				} else if (f instanceof BinaryFile) {
					Files.write(Resources.toByteArray(((BinaryFile) f).getContent()), file);
				}
				if (f.isExecutable()) {
					file.setExecutable(true);
				}
			}
			for (SourceFolderDescriptor folder : project.getSourceFolders()) {
				new File(projectRoot, folder.getPath()).mkdirs();
			}
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	public String getLineDelimiter() {
		return lineDelimiter;
	}

	public void setLineDelimiter(String lineDelimiter) {
		this.lineDelimiter = lineDelimiter;
	}
}
