/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import java.io.File;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtext.util.Strings;

/**
 * This class is responsible for binding {@link RelengProjectInfo} to the corresponding {@link Control}s.
 * 
 * @author dhuebner - Initial contribution and API
 */
public class ProjectInfoBinder {

	private final DataBindingContext dbc;
	private final RelengProjectInfo projectInfo;

	public ProjectInfoBinder(DataBindingContext dbc, RelengProjectInfo projectInfo) {
		this.dbc = dbc;
		this.projectInfo = projectInfo;
	}

	public IObservableValue bindFeatureProjectField(Control featureProjectField) {
		IObservableValue featPrjObserv = PojoObservables.observeValue(projectInfo, "buildFeatureName"); //$NON-NLS-1$
		dbc.bindValue(SWTObservables.observeText(featureProjectField, SWT.Modify), featPrjObserv,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
						.setBeforeSetValidator(new FeatureProjectValidator()), null);
		//		ControlDecorationSupport.create(featBinding, SWT.LEFT | SWT.TOP);
		return featPrjObserv;
	}

	public void bindTestLaunchers(StructuredViewer testsList) {
		IObservableList observeList = new WritableList(projectInfo.getTestLaunchers(), IFile.class);
		testsList.setInput(observeList);
		testsList.setLabelProvider(new WorkbenchLabelProvider());

	}

	public void bindBuckyLocationField(Text buckyField) {
		dbc.bindValue(SWTObservables.observeText(buckyField, SWT.Modify), PojoObservables.observeValue(projectInfo,
				"buckyLocation"), new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE) //$NON-NLS-1$
				.setBeforeSetValidator(new BuckminsterLocationValidator()), null);
		//		ControlDecorationSupport.create(binding, SWT.LEFT | SWT.TOP, buckyField.getParent());
	}

	public void bindSiteProjectField(Text sitePrjField, IObservableValue featPrjObserv) {
		IObservableValue siteFeatureObservable = PojoObservables.observeValue(projectInfo, "siteFeatureProjectName"); //$NON-NLS-1$
		dbc.bindValue(SWTObservables.observeText(sitePrjField, SWT.Modify), siteFeatureObservable);
		dbc.bindValue(featPrjObserv, siteFeatureObservable, new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
				.setConverter(new SuffixedNameComputedValue(projectInfo, "site")), null); //$NON-NLS-1$
	}

	public void bindProjectField(Text prjField, IObservableValue featPrjObserv) {
		IObservableValue prjObserv = PojoObservables.observeValue(projectInfo, "projectName"); //$NON-NLS-1$
		dbc.bindValue(SWTObservables.observeText(prjField, SWT.Modify), prjObserv);
		dbc.bindValue(featPrjObserv, prjObserv, new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE)
				.setConverter(new SuffixedNameComputedValue(projectInfo, "buckminster")), null); //$NON-NLS-1$
	}

	final private static class SuffixedNameComputedValue extends Converter {
		private final String suffix;
		private final RelengProjectInfo projectInfo;

		public SuffixedNameComputedValue(RelengProjectInfo projectInfo, String suffix) {
			super(String.class, String.class);
			this.projectInfo = projectInfo;
			this.suffix = suffix;
		}

		public Object convert(Object fromObject) {
			return calculateProjectName();
		}

		private String calculateProjectName() {
			String nameSpace = projectInfo.getProjectNameSpace();
			if (Strings.isEmpty(nameSpace))
				return ""; //$NON-NLS-1$
			String projectsuffix = findNextValidProjectSuffix(nameSpace, suffix); //$NON-NLS-1$ //$NON-NLS-2$
			return nameSpace + "." + projectsuffix; //$NON-NLS-1$
		}

		/**
		 * TODO extract to util Find the next available (default) DSL name
		 */
		private String findNextValidProjectSuffix(final String prefix, final String name) {
			String candidate = name;
			int suffix = 1;
			while (ResourcesPlugin.getWorkspace().getRoot()
					.getProject((prefix + "." + candidate).toLowerCase()).exists()) { //$NON-NLS-1$
				candidate = name + suffix;
				suffix++;
			}
			return candidate;
		}
	}

	static private class FeatureProjectValidator implements IValidator {

		public IStatus validate(Object value) {
			if (value == null || Strings.isEmpty(value.toString())) {
				return ValidationStatus.error(Messages.ProjectInfoBinder_errorFeatureNotSelected);
			} else {
				String featureProjectName = value.toString();
				if (!PDEUtils.featureProjectExists(featureProjectName)) {
					return ValidationStatus.error(NLS.bind(Messages.ProjectInfoBinder_errorFeatureNotExists,
							featureProjectName));
				}
			}
			return ValidationStatus.ok();
		}
	}

	static private class BuckminsterLocationValidator implements IValidator {

		public IStatus validate(Object value) {
			if (value == null || Strings.isEmpty(value.toString())) {
				return ValidationStatus.warning(Messages.ProjectInfoBinder_warnBuckyHeadlessNotSet);
			} else {
				File buckyHeadless = new File(value.toString());
				File[] files = buckyHeadless.listFiles();
				boolean buckminsterExecutableFound = false;
				if (files != null) {
					for (File file : files) {
						if (file.isFile() && "buckminster".equals(file.getName())) { //$NON-NLS-1$
							buckminsterExecutableFound = true;
							break;
						}
					}
				}
				if (!buckminsterExecutableFound) {
					return ValidationStatus.warning(NLS.bind(Messages.ProjectInfoBinder_warnNotBucky, buckyHeadless));
				}
			}
			return ValidationStatus.ok();
		}

	}

}
