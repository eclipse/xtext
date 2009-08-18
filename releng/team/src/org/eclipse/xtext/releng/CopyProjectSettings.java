/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.releng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.releng.GenerateProxyAndPserverPsf;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CopyProjectSettings {

	private static final String XTEXT_PROJECTSET_PSF = GenerateProxyAndPserverPsf.XTEXT_PROJECTSET_PSF;

	private static final String[] includePatterns = { "^com\\.google.*", ".*\\.xtext.*", ".*\\.xpand.*", ".*\\.mwe.*",
			".*\\.generic\\.editor$" };

	private static final String[] excludePatterns = { "^develop$", ".*\\.releng$" };

	// <project reference="1.0,:extssh:dev.eclipse.org:/cvsroot/modeling,org.eclipse.tmf/org.eclipse.xtext/develop,develop"/>
	// <project reference="1.0,:extssh:dev.eclipse.org:/cvsroot/tools,org.eclipse.orbit/javax.xml,javax.xml,v1_3_4"/>
	private static final String projectPattern = "^([^,]*,){3}([^,\\\"]+)";

	public static void main(String[] args) {
		try {
			Collection<String> projects = findProjects();
			File[] settings = findSettingsToCopy();
			for(String project: projects) {
				copySettingsTo(settings, project);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final String naturePattern = "<nature>([^<]*)</nature>";

	private static final String jdtNatureName = "org.eclipse.jdt.core.javanature";
	private static final String pdePluginNatureName = "org.eclipse.pde.PluginNature";
	
	private static void copySettingsTo(File[] settings, String project) throws IOException {
		Pattern nature = Pattern.compile(naturePattern);
		File projectFile = new File(".." + File.separatorChar + project + File.separator + ".project");
		boolean jdtNature = false;
		boolean pdeNature = false;
		if (projectFile.exists()) {
			BufferedReader fileReader = new BufferedReader(new FileReader(projectFile));
			String line = null;
			while ((line = fileReader.readLine()) != null) {
				Matcher matcher = nature.matcher(line);
				if (matcher.find()) {
					String foundNature = matcher.group(1);
					if (foundNature.equals(jdtNatureName))
						jdtNature = true;
					else if (foundNature.equals(pdePluginNatureName))
						pdeNature = true;
				}
			}
			fileReader.close();
			copySettingsTo(settings, projectFile.getParentFile(), jdtNature, pdeNature);
		} else {
			System.err.println("Cannot find project file for: " + project);
		}
	}

	private static void copySettingsTo(File[] settings, File parentFile, boolean jdtNature, boolean pdeNature) throws IOException {
		File settingsDir = new File(parentFile, ".settings");
		if (!settingsDir.exists())
			settingsDir.mkdir();
		for(File setting: settings) {
			if (setting.getName().contains(".pde.") && !pdeNature)
				continue;
			if (setting.getName().contains(".jdt.") && !pdeNature)
				continue;
			copySettingsTo(setting, settingsDir);
		}
	}

	private static void copySettingsTo(File setting, File targetDir) throws IOException {
		File targetFile = new File(targetDir, setting.getName());
		if (!targetFile.exists()) {
			if(!targetFile.createNewFile()) {
				System.err.println("Cannot create file: " + targetFile);
				return;
			}
		}
		FileOutputStream outputStream = new FileOutputStream(targetFile);
		FileInputStream inputStream = new FileInputStream(setting);
		FileChannel outputChannel = outputStream.getChannel();
		FileChannel inputChannel = inputStream.getChannel();
		outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		outputChannel.close();
		inputChannel.close();
	}

	private static File[] findSettingsToCopy() {
		File settingsDir = new File(".settings");
		return settingsDir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !name.toLowerCase().contains("cvs");
			}
		});
	}

	private static Collection<String> findProjects() throws FileNotFoundException, IOException {
		Pattern pattern = Pattern.compile(projectPattern);
		Pattern[] includes = new Pattern[includePatterns.length];
		for (int i = 0; i < includes.length; i++) {
			includes[i] = Pattern.compile(includePatterns[i]);
		}
		Pattern[] excludes = new Pattern[excludePatterns.length];
		for (int i = 0; i < excludes.length; i++) {
			excludes[i] = Pattern.compile(excludePatterns[i]);
		}
		Set<String> projectNames = new HashSet<String>();
		BufferedReader fileReader = new BufferedReader(new FileReader(XTEXT_PROJECTSET_PSF));
		String line;
		while ((line = fileReader.readLine()) != null) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				boolean matches = false;
				String project = matcher.group(2);
				for (Pattern includePattern : includes) {
					if (includePattern.matcher(project).matches()) {
						matches = true;
						break;
					}
				}
				for (Pattern excludePattern : excludes) {
					if (excludePattern.matcher(project).matches()) {
						matches = false;
						break;
					}
				}
				if (matches) {
					projectNames.add(project);
				}
			}
		}
		fileReader.close();
		return projectNames;
	}
}
