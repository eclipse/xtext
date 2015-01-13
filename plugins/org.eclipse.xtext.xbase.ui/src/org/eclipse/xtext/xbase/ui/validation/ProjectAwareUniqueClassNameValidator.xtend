/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IPackageFragment
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.core.IType
import org.eclipse.jdt.core.compiler.CharOperation
import org.eclipse.jdt.core.search.IJavaSearchConstants
import org.eclipse.jdt.core.search.SearchPattern
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner
import org.eclipse.jdt.internal.core.JavaModelManager
import org.eclipse.jdt.internal.core.search.BasicSearchEngine
import org.eclipse.jdt.internal.core.search.IndexQueryRequestor
import org.eclipse.jdt.internal.core.search.PatternSearchJob
import org.eclipse.jdt.internal.core.search.indexing.IIndexConstants
import org.eclipse.jdt.internal.core.search.indexing.IndexManager
import org.eclipse.jdt.internal.core.search.matching.TypeDeclarationPattern
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.generator.IDerivedResourceMarkers
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.xbase.validation.UniqueClassNameValidator

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ProjectAwareUniqueClassNameValidator extends UniqueClassNameValidator {
	
	@Inject IJavaProjectProvider javaProjectProvider
	
	@Inject IDerivedResourceMarkers derivedResourceMarkers
	
	@Inject IOutputConfigurationProvider outputConfigurationProvider
	
	override doCheckUniqueName(QualifiedName name, JvmDeclaredType type) {
		if (super.doCheckUniqueName(name, type)) {
			return doCheckUniqueInProject(name, type)
		} else {
			return true
		}
	}
	
	def boolean doCheckUniqueInProject(QualifiedName name, JvmDeclaredType type) {
		val javaProject = javaProjectProvider.getJavaProject(type.eResource.resourceSet)
		val packageName = type.packageName
		val typeName = type.simpleName
		val sourceFolders = javaProject.packageFragmentRoots.filter[ kind == IPackageFragmentRoot.K_SOURCE ]
		var IndexManager indexManager = JavaModelManager.getIndexManager
		
		if (indexManager.awaitingJobsCount() > 0) {
			// still indexing - don't enter a busy wait loop but ask the source folders directly
			for (IPackageFragmentRoot sourceFolder : sourceFolders) {
				if (indexManager.awaitingJobsCount() > 0 && !isDerived(type, sourceFolder.resource)) {
					var IPackageFragment packageFragment = sourceFolder.getPackageFragment(packageName)
					if (packageFragment.exists()) {
						var ICompilationUnit[] units = packageFragment.getCompilationUnits(DefaultWorkingCopyOwner.PRIMARY)
						for (ICompilationUnit unit : units) {
							val resource = unit.resource
							if (!isDerived(type, resource)) {
								var javaType = unit.getType(typeName)
								if (javaType.exists()) {
									addIssue(type, unit.elementName)
									return false
								}
							}
						}
					}
				}
			}
			return true
		}
		
		val workingCopyPaths = newHashSet
		var copies = getWorkingCopies(type)
		if (copies != null) {
			for (workingCopy: copies) {
				val path = workingCopy.path
				if (javaProject.path.isPrefixOf(path) && !isDerived(type, workingCopy.resource)) {
					if (workingCopy.getPackageDeclaration(packageName).exists()) {
						var IType result = workingCopy.getType(typeName)
						if (result.exists()) {
							addIssue(type, workingCopy.elementName)
							return false
						}
					}
					workingCopyPaths.add(workingCopy.path.toString())
				}
			}
		}

		
		// code below is adapted from BasicSearchEnginge.searchAllSecondaryTypes
		// index is ready, query it for a secondary type 
		val TypeDeclarationPattern pattern = new TypeDeclarationPattern(
			if(packageName == null) CharOperation.NO_CHAR else packageName.toCharArray(), CharOperation.NO_CHAR_CHAR, // top level type - no enclosing type names
			typeName.toCharArray(), IIndexConstants.TYPE_SUFFIX,
			SearchPattern.R_EXACT_MATCH.bitwiseOr(SearchPattern.R_CASE_SENSITIVE))
		
		var IndexQueryRequestor searchRequestor = [ documentPath, indexRecord, participant, access |
			if (workingCopyPaths.contains(documentPath)) {
				return true // filter out working copies
			}
			var IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(documentPath))
			if (!isDerived(type, file)) {
				addIssue(type, file.name)
				return false
			}
			return true
		]
		try {
			indexManager.performConcurrentJob(
				new PatternSearchJob(pattern, BasicSearchEngine.getDefaultSearchParticipant(), // Java search only
				BasicSearchEngine.createJavaSearchScope(sourceFolders), searchRequestor),
				IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, null)
			return true
		} catch (OperationCanceledException oce) {
			return false
		}
		
	}
	
	def private ICompilationUnit[] getWorkingCopies(JvmDeclaredType type) {
		if (isBuilderScope(type)) {
			return #[]
		}
		return JavaModelManager.getJavaModelManager().getWorkingCopies(DefaultWorkingCopyOwner.PRIMARY, false);
	}

	def private boolean isBuilderScope(JvmDeclaredType type) {
		val resourceSet = type.eResource.resourceSet
		val builderScope = resourceSet.getLoadOptions().containsKey(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE);
		return builderScope;
	}
	
	def protected isDerived(JvmDeclaredType type, IResource resource) {
		if (derivedResourceMarkers.findDerivedResourceMarkers(resource).length >= 1) {
			return true
		}
		val projectRelativePath = resource.projectRelativePath
		for(outputConfiguration: outputConfigurationProvider.outputConfigurations) {
			for(dir: outputConfiguration.outputDirectories) {
				if (new Path(dir).isPrefixOf(projectRelativePath)) {
					return true
				}
			}
		}
		return false
	}
	
	override protected checkUniqueInIndex(JvmDeclaredType type, Iterable<IEObjectDescription> descriptions) {
		val objectURI = EcoreUtil.getURI(type)
		if (objectURI.isPlatformResource) {
			val project = objectURI.segment(1)
			return super.checkUniqueInIndex(type, descriptions.filter[
				val candidate = EObjectURI
				return candidate.isPlatformResource && candidate.segment(1) == project
			])
		}
		return true
	}
	
}