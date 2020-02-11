/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * Copies a file or a directory tree from {@link #sourcePath} to {@link #targetPath}. The target is erased before
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
		Files.createDirectories(internalTargetPath.resolve(internalSourcePath.relativize(dir)));
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
		Files.copy(file, internalTargetPath.resolve(internalSourcePath.relativize(file)));
		return FileVisitResult.CONTINUE;
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		File sourceFileOrDir = new File(sourcePath);
		File targetFileOrDir = new File(targetPath);
		try {
			if (targetFileOrDir.exists()) {
				if (targetFileOrDir.isDirectory()) {
					org.eclipse.xtext.util.Files.sweepFolder(targetFileOrDir);	
				} else {
					targetFileOrDir.delete();
				}
			}
			internalTargetPath = targetFileOrDir.toPath();
			internalSourcePath = sourceFileOrDir.toPath();
			Files.walkFileTree(internalSourcePath, this);
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
