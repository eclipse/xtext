/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.splitting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindProjects {
	
	public static final String ALL_FILES = "all-files.txt";
	public static final String ALL_PROJECTS = "all-projects.txt";
	public static final String UNMAPPED_PATHS = "unmapped-paths.txt";

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Expected file list as argument.");
			return;
		}
		String workingDir = args[0];
		try {
			final Directory root = new Directory(".", null);
			try (BufferedReader reader = new BufferedReader(new FileReader(workingDir + "/" + ALL_FILES))) {
				// Gather all paths in a directory structure
				String line;
				while ((line = reader.readLine()) != null) {
					String[] segments = line.split("/");
					DirectoryEntry current = root;
					for (int i = 0; i < segments.length; i++) {
						String segment = segments[i].replaceAll("\"|\\\\.", "");
						if (!segment.isEmpty() && current instanceof Directory) {
							Directory currentDir = (Directory) current;
							if (currentDir.entries.containsKey(segment))
								current = currentDir.entries.get(segment);
							else {
								DirectoryEntry newEntry;
								if (i == segments.length - 1)
									newEntry = new DirectoryEntry(segment, currentDir);
								else
									newEntry = new Directory(segment, currentDir);
								currentDir.entries.put(segment, newEntry);
								current = newEntry;
							}
						}
					}
				}
			}
			
			// Find the projects and unmapped paths that are relevant for the repository history
			final List<Directory> projects = new ArrayList<>();
			final List<DirectoryEntry> otherPaths = new ArrayList<>();
			findProjects(root, projects, otherPaths, false);
			
			// Write the collected projects into a file
			Collections.sort(projects);
			try (FileWriter writer = new FileWriter(workingDir + "/" + ALL_PROJECTS)) {
				for (Directory project : projects) {
					writer.write(project.toString());
					writer.write('\n');
				}
			}
			
			// Write the unmapped paths into another file
			Collections.sort(otherPaths);
			try (FileWriter writer = new FileWriter(workingDir + "/" + UNMAPPED_PATHS)) {
				for (DirectoryEntry path : otherPaths) {
					writer.write(path.toString());
					writer.write('\n');
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boolean findProjects(Directory dir, List<Directory> projects, List<DirectoryEntry> otherPaths, boolean skipOtherPaths) {
		boolean containsProject = dir.parent != null && dir.entries.values().stream().anyMatch((e) -> e.name.equals(".project"));
		if (containsProject) {
			projects.add(dir);
			skipOtherPaths = true;
		}
		Set<Directory> subDirsWithProjects = new HashSet<>();
		for (DirectoryEntry entry : dir.entries.values()) {
			if (entry instanceof Directory) {
				Directory subDir = (Directory) entry;
				if (findProjects(subDir, projects, otherPaths, skipOtherPaths))
					subDirsWithProjects.add(subDir);
			}
		}
		if (!skipOtherPaths && !subDirsWithProjects.isEmpty()) {
			for (DirectoryEntry entry : dir.entries.values()) {
				if (!subDirsWithProjects.contains(entry))
					otherPaths.add(entry);
			}
		}
		return containsProject || !subDirsWithProjects.isEmpty();
	}
	
	private static class DirectoryEntry implements Comparable<DirectoryEntry> {
		final String name;
		final Directory parent;
		
		DirectoryEntry(String name, Directory parent) {
			this.name = name;
			this.parent = parent;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Directory) {
				Directory other = (Directory) obj;
				return this.parent == other.parent && this.name.equals(other.name);
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			if (parent == null)
				return name.hashCode();
			else
				return parent.hashCode() * 7 + name.hashCode();
		}

		@Override
		public int compareTo(DirectoryEntry other) {
			if (this.parent == other.parent)
				return this.name.compareTo(other.name);
			else
				return this.toString().compareTo(other.toString());
		}
		
		@Override
		public String toString() {
			if (parent == null || parent.parent == null)
				return name;
			else
				return parent.toString() + "/" + name;
		}
	}
	
	private static class Directory extends DirectoryEntry {
		final Map<String, DirectoryEntry> entries = new HashMap<>();
		
		Directory(String name, Directory parent) {
			super(name, parent);
		}
	}

}
