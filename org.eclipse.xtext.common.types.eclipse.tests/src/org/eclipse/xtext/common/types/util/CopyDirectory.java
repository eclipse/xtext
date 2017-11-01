/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

/**
 * Copies the entire directory tree from {@link #sourcePath} to {@link #targetPath}. The contents of the target directory is erased before
 * the copy operation starts.
 */
public class CopyDirectory extends SimpleFileVisitor<Path> implements IWorkflowComponent {

	private String sourcePath;
	private String targetPath;

	private Path internalSourcePath;
	private Path internalTargetPath;
	
	@Override
	public void preInvoke() {
	}

	@Override
	public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
		if (internalSourcePath == null) {
			internalSourcePath = dir;
		} else {
			Files.createDirectories(internalTargetPath.resolve(internalSourcePath.relativize(dir)));
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
		Files.copy(file, internalTargetPath.resolve(internalSourcePath.relativize(file)));
		return FileVisitResult.CONTINUE;
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		File sourceDir = new File(sourcePath);
		File targetDir = new File(targetPath);
		try {
			org.eclipse.xtext.util.Files.sweepFolder(targetDir);
			internalTargetPath = targetDir.toPath();
			Files.walkFileTree(sourceDir.toPath(), this);
		} catch(IOException e) {
			throw new RuntimeException(e);
		} finally {
			internalSourcePath = null;
			internalTargetPath = null;
		}
	}

	@Override
	public void postInvoke() {
	}

	public String getSourcePath() {
		return sourcePath;
	}

	@Mandatory
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public String getTargetPath() {
		return targetPath;
	}

	@Mandatory
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

}
