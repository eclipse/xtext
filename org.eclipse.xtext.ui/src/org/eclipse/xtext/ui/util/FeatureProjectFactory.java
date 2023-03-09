/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;

import com.google.common.base.Strings;

/**
 * Creates a simple feature project.<br>
 * Created project contains .project, build.properties and feature.xml files<br>
 * Plugin entries can be added using {@link FeatureProjectFactory#addBundle(String)} method.<br>
 *
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 *
 * @deprecated move code to your codebase.
 */
@Deprecated
public class FeatureProjectFactory extends ProjectFactory {
	private static String MANIFEST_FILENAME = "feature.xml";

	private static String CATEGORY_FILE_NAME = "category.xml";

	private static String BUILD_PROPS_FILE_NAME = "build.properties";

	private static String SOURCE_FEAT_ENDING = ".source";

	private static String FEAT_ENDING = ".feature";

	private List<String> containedBundles = new ArrayList<>();

	private List<String> includedFeatures = new ArrayList<>();

	private String mainCategoryName;

	private String featureLabel;

	public void setFeatureLabel(String label) {
		this.featureLabel = label;
	}

	/**
	 * Adds a new plugin entry
	 */
	public FeatureProjectFactory addBundle(String bundleId) {
		containedBundles.add(bundleId);
		return this;
	}

	/**
	 * Adds a new included feature entry
	 */
	public FeatureProjectFactory addFeature(String featureId) {
		includedFeatures.add(featureId);
		return this;
	}

	/**
	 * @param mainCategoryName
	 *            If not null or empty a category.xml will be created
	 */
	public FeatureProjectFactory withCategoryFile(String mainCategoryName) {
		this.mainCategoryName = mainCategoryName;
		return this;
	}

	@Override
	protected void enhanceProject(IProject project, SubMonitor subMonitor, Shell shell) throws CoreException {
		super.enhanceProject(project, subMonitor, shell);
		createManifest(project, subMonitor.newChild(1));
		createBuildProperties(project, subMonitor.newChild(1));
		if (!Strings.isNullOrEmpty(mainCategoryName)) {
			createCategoryFile(project, mainCategoryName, subMonitor.newChild(1));
		}
	}

	private void createBuildProperties(IProject project, IProgressMonitor monitor) {
		StringConcatenation content = new StringConcatenation();
		content.append("bin.includes =");
		content.append(FeatureProjectFactory.MANIFEST_FILENAME);
		content.newLineIfNotEmpty();
		writeToFile(content, FeatureProjectFactory.BUILD_PROPS_FILE_NAME, project, monitor);
	}

	private void createManifest(IProject project, IProgressMonitor monitor) {
		StringConcatenation content = new StringConcatenation();
		content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		content.newLine();
		content.append("<feature id=\"");
		content.append(projectName);
		content.append("\"");
		content.newLineIfNotEmpty();
		content.append("\t");
		content.append("label=\"");
		String label = null;
		if (!Strings.isNullOrEmpty(featureLabel)) {
			label = featureLabel;
		} else {
			label = projectName + " Feature";
		}
		content.append(label, "\t");
		content.append("\"");
		content.newLineIfNotEmpty();
		content.append("\t");
		content.append("version=\"1.0.0.qualifier\">");
		content.newLine();
		for (String includedFeature : includedFeatures) {
			content.append("\t");
			content.append("<includes");
			content.newLine();
			content.append("\t");
			content.append("\t");
			content.append("id=\"");
			content.append(includedFeature, "\t\t");
			content.append("\"");
			content.newLineIfNotEmpty();
			content.append("\t");
			content.append("\t");
			content.append("version=\"0.0.0\"/>");
			content.newLine();
		}
		for (String containedBundle : containedBundles) {
			content.append("\t");
			content.append("<plugin");
			content.newLine();
			content.append("\t");
			content.append("\t\t");
			content.append("id=\"");
			content.append(containedBundle, "\t\t\t");
			content.append("\"");
			content.newLineIfNotEmpty();
			content.append("\t");
			content.append("\t\t");
			content.append("download-size=\"0\"");
			content.newLine();
			content.append("\t");
			content.append("\t\t");
			content.append("install-size=\"0\"");
			content.newLine();
			content.append("\t");
			content.append("\t\t");
			content.append("version=\"0.0.0\"");
			content.newLine();
			content.append("\t");
			content.append("\t\t");
			content.append("unpack=\"false\"/>");
			content.newLine();
		}
		content.append("</feature>");
		content.newLine();
		writeToFile(content, FeatureProjectFactory.MANIFEST_FILENAME, project, monitor);
	}

	private void createCategoryFile(IProject project, String categoryName, IProgressMonitor monitor) {
		StringConcatenation content = new StringConcatenation();
		content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		content.newLine();
		content.append("<site>");
		content.newLine();
		for (String includedFeature : includedFeatures) {
			content.append("\t");
			content.append("<feature id=\"");
			content.append(includedFeature, "\t");
			content.append("\" version=\"0.0.0\">");
			content.newLineIfNotEmpty();
			content.append("\t");
			content.append("\t");
			content.append("<category name=\"main\"/>");
			content.newLine();
			content.append("\t");
			content.append("</feature>");
			content.newLine();
			content.append("\t");
			content.append("<feature id=\"");
			String sourceFeatureName = null;
			if (includedFeature != null) {
				sourceFeatureName = sourceFeatureName(includedFeature);
			}
			content.append(sourceFeatureName, "\t");
			content.append("\" version=\"0.0.0\">");
			content.newLineIfNotEmpty();
			content.append("\t");
			content.append("\t");
			content.append("<category name=\"main.source\"/>");
			content.newLine();
			content.append("\t");
			content.append("</feature>");
			content.newLine();
		}
		content.append("   ");
		content.append("<category-def name=\"main\" label=\"");
		content.append(categoryName, "   ");
		content.append("\"/>");
		content.newLineIfNotEmpty();
		content.append("   ");
		content.append("<category-def name=\"main.source\" label=\"Source for ");
		content.append(categoryName, "   ");
		content.append("\"/>");
		content.newLineIfNotEmpty();
		content.append("</site>");
		content.newLine();
		this.writeToFile(content, FeatureProjectFactory.CATEGORY_FILE_NAME, project, monitor);
	}

	private String sourceFeatureName(String featureId) {
		if (featureId.endsWith(FeatureProjectFactory.FEAT_ENDING)) {
			return featureId.replaceAll("\\" + FeatureProjectFactory.FEAT_ENDING + "$",
					FeatureProjectFactory.SOURCE_FEAT_ENDING + FeatureProjectFactory.FEAT_ENDING);
		}
		return featureId + FeatureProjectFactory.SOURCE_FEAT_ENDING;
	}
}
