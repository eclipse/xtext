/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.search.BasicSearchEngine;
import org.eclipse.jdt.internal.core.search.IndexQueryRequestor;
import org.eclipse.jdt.internal.core.search.PatternSearchJob;
import org.eclipse.jdt.internal.core.search.indexing.IIndexConstants;
import org.eclipse.jdt.internal.core.search.indexing.IndexManager;
import org.eclipse.jdt.internal.core.search.matching.TypeDeclarationPattern;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ResourceSetContext;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.xbase.validation.UniqueClassNameValidator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ProjectAwareUniqueClassNameValidator extends UniqueClassNameValidator {

	private enum SourceTraversal {
		INTERRUPT,

		DUPLICATE,

		UNIQUE;
	}

	private final static Logger LOG = Logger.getLogger(ProjectAwareUniqueClassNameValidator.class);

	/**
	 * Context key for output configurations.
	 */
	private final static String OUTPUT_CONFIGS = "ProjectAwareUniqueClassNameValidator.outputConfigs";

	@Inject
	private IJavaProjectProvider javaProjectProvider;

	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private IContextualOutputConfigurationProvider outputConfigurationProvider;

	@Override
	public boolean doCheckUniqueName(QualifiedName name, JvmDeclaredType type) {
		if (!super.doCheckUniqueName(name, type)) {
			return false;
		}

		try {
			return doCheckUniqueInProject(name, type);
		} catch (JavaModelException e) {
			if (!e.isDoesNotExist()) {
				LOG.error(e.getMessage(), e);
			}
			return true;
		}
	}

	private SourceTraversal doCheckUniqueInProjectSource(String packageName, String typeName, JvmDeclaredType type,
			List<IPackageFragmentRoot> sourceFolders) throws JavaModelException {
		IndexManager indexManager = JavaModelManager.getIndexManager();
		for (IPackageFragmentRoot sourceFolder : sourceFolders) {
			if (indexManager.awaitingJobsCount() > 0) {
				if (!isDerived(sourceFolder.getResource())) {
					IPackageFragment packageFragment = sourceFolder.getPackageFragment(packageName);
					if (packageFragment.exists()) {
						for (ICompilationUnit unit : packageFragment.getCompilationUnits()) {
							if (!isDerived(unit.getResource())) {
								IType javaType = unit.getType(typeName);
								if (javaType.exists()) {
									addIssue(type, unit.getElementName());
									return SourceTraversal.DUPLICATE;
								}
							}
						}
					}
				}
			} else {
				return SourceTraversal.INTERRUPT;
			}
		}
		return SourceTraversal.UNIQUE;
	}

	public boolean doCheckUniqueInProject(QualifiedName name, JvmDeclaredType type) throws JavaModelException {
		IJavaProject javaProject = javaProjectProvider.getJavaProject(type.eResource().getResourceSet());
		getContext().put(ProjectAwareUniqueClassNameValidator.OUTPUT_CONFIGS,
				outputConfigurationProvider.getOutputConfigurations(type.eResource()));

		String packageName = type.getPackageName();
		String typeName = type.getSimpleName();
		IndexManager indexManager = JavaModelManager.getIndexManager();
		List<IPackageFragmentRoot> sourceFolders = new ArrayList<>();
		for (IPackageFragmentRoot root : javaProject.getPackageFragmentRoots()) {
			if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
				sourceFolders.add(root);
			}
		}

		if (sourceFolders.isEmpty() || indexManager.awaitingJobsCount() > 0) {
			// still indexing - don't enter a busy wait loop but ask the source folders directly
			SourceTraversal sourceTraversal = doCheckUniqueInProjectSource(packageName != null ? packageName : "", typeName, type,
					sourceFolders);
			if (sourceTraversal == SourceTraversal.DUPLICATE) {
				return false;
			} else if (sourceTraversal == SourceTraversal.UNIQUE) {
				return true;
			}
		}

		Set<String> workingCopyPaths = new HashSet<>();
		ICompilationUnit[] copies = getWorkingCopies(type);
		if (copies != null) {
			for (ICompilationUnit workingCopy : copies) {
				IPath path = workingCopy.getPath();
				if (javaProject.getPath().isPrefixOf(path) && !isDerived(workingCopy.getResource())) {
					if (workingCopy.getPackageDeclaration(packageName).exists()) {
						IType result = workingCopy.getType(typeName);
						if (result.exists()) {
							addIssue(type, workingCopy.getElementName());
							return false;
						}
					}
					workingCopyPaths.add(workingCopy.getPath().toString());
				}
			}
		}

		// The code below is adapted from BasicSearchEnginge.searchAllSecondaryTypes
		// The Index is ready, query it for a secondary type 
		char[] pkg = packageName == null ? CharOperation.NO_CHAR : packageName.toCharArray();
		TypeDeclarationPattern pattern = new TypeDeclarationPattern(pkg, //
				CharOperation.NO_CHAR_CHAR, // top level type - no enclosing type names
				typeName.toCharArray(), //
				IIndexConstants.TYPE_SUFFIX, //
				SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE);

		IndexQueryRequestor searchRequestor = new IndexQueryRequestor() {

			@Override
			public boolean acceptIndexMatch(String documentPath, SearchPattern indexRecord, SearchParticipant participant,
					AccessRuleSet access) {
				if (workingCopyPaths.contains(documentPath)) {
					return true; // filter out working copies
				}
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(documentPath));
				if (!isDerived(file) && file.exists()) {
					addIssue(type, file.getName());
					return false;
				}
				return true;
			}
		};

		try {
			SearchParticipant searchParticipant = BasicSearchEngine.getDefaultSearchParticipant(); // Java search only
			IJavaSearchScope javaSearchScope = BasicSearchEngine.createJavaSearchScope(sourceFolders.toArray(new IJavaElement[0]));
			PatternSearchJob patternSearchJob = new PatternSearchJob(pattern, searchParticipant, javaSearchScope, searchRequestor);
			indexManager.performConcurrentJob(patternSearchJob, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, null);
			return true;
		} catch (Throwable OperationCanceledException) {
			return false;
		}
	}

	private ICompilationUnit[] getWorkingCopies(JvmDeclaredType type) {
		return ResourceSetContext.get(type).isBuilder() //
				? new ICompilationUnit[] {} //
				: JavaModelManager.getJavaModelManager().getWorkingCopies(DefaultWorkingCopyOwner.PRIMARY, false);
	}

	@SuppressWarnings("unchecked")
	protected boolean isDerived(IResource resource) {
		try {
			// Nullcheck for test org.eclipse.xtext.xbase.ui.tests.validation.ProjectAwareUniqueClassNameValidatorTest
			if (derivedResourceMarkers != null && derivedResourceMarkers.findDerivedResourceMarkers(resource).length >= 1) {
				return true;
			}
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
			return false;
		}

		Collection<OutputConfiguration> outputConfigurations = (Collection<OutputConfiguration>) getContext()
				.get(ProjectAwareUniqueClassNameValidator.OUTPUT_CONFIGS);
		if (outputConfigurations != null) {
			IPath projectRelativePath = resource.getProjectRelativePath();
			for (OutputConfiguration outputConfiguration : outputConfigurations) {
				for (String dir : outputConfiguration.getOutputDirectories()) {
					for (SourceMapping sourceMapping : outputConfiguration.getSourceMappings()) {
						// Check if there is a sourceFolder that ends with the path of the current output dir
						if (sourceMapping.getSourceFolder().endsWith(dir)) {
							String sourceFolder = sourceMapping.getSourceFolder();
							// Check if there is a sourceMapping that matches the current output dir and is a prefix of the projectRelativePath
							if (new Path(sourceFolder).isPrefixOf(projectRelativePath)) {
								return true;
							}
						}
					}

					// In case no sourceMapping matches
					if (new Path(dir).isPrefixOf(projectRelativePath)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	protected boolean checkUniqueInIndex(JvmDeclaredType type, Iterable<IEObjectDescription> descriptions) {
		URI typeUri = EcoreUtil.getURI(type);
		if (typeUri.isPlatformResource()) {
			String projectName = typeUri.segment(1);
			return super.checkUniqueInIndex(type, Iterables.filter(descriptions, (description) -> {
				URI descriptionUri = description.getEObjectURI();
				return descriptionUri.isPlatformResource() && projectName.equals(descriptionUri.segment(1));
			}));
		}
		return true;
	}
}
