/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.core.IType
import org.eclipse.jdt.core.JavaModelException
import org.eclipse.jdt.core.compiler.CharOperation
import org.eclipse.jdt.core.search.IJavaSearchConstants
import org.eclipse.jdt.core.search.SearchPattern
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner
import org.eclipse.jdt.internal.core.JavaModelManager
import org.eclipse.jdt.internal.core.search.BasicSearchEngine
import org.eclipse.jdt.internal.core.search.IndexQueryRequestor
import org.eclipse.jdt.internal.core.search.PatternSearchJob
import org.eclipse.jdt.internal.core.search.indexing.IIndexConstants
import org.eclipse.jdt.internal.core.search.matching.TypeDeclarationPattern
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.ResourceSetContext
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers
import org.eclipse.xtext.xbase.validation.UniqueClassNameValidator

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ProjectAwareUniqueClassNameValidator extends UniqueClassNameValidator {
	
	/** Context key for output configurations. */
	static val OUTPUT_CONFIGS = "ProjectAwareUniqueClassNameValidator.outputConfigs"
	
	@Inject IJavaProjectProvider javaProjectProvider
	
	@Inject IDerivedResourceMarkers derivedResourceMarkers
	
	@Inject IContextualOutputConfigurationProvider outputConfigurationProvider
	
	override doCheckUniqueName(QualifiedName name, JvmDeclaredType type) {
		if (super.doCheckUniqueName(name, type)) {
			try {
				return doCheckUniqueInProject(name, type)
			} catch(JavaModelException e) {
				return true
			}
		} else {
			return false
		}
	}
	
	private enum SourceTraversal {
		INTERRUPT, DUPLICATE, UNIQUE
	}
	
	private def SourceTraversal doCheckUniqueInProjectSource(String packageName, String typeName, JvmDeclaredType type,
			IPackageFragmentRoot[] sourceFolders) throws JavaModelException {
		val indexManager = JavaModelManager.getIndexManager
		for (sourceFolder : sourceFolders) {
			if (indexManager.awaitingJobsCount > 0) {
				if (!isDerived(sourceFolder.resource)) {
					var packageFragment = sourceFolder.getPackageFragment(packageName)
					if (packageFragment.exists()) {
						var units = packageFragment.getCompilationUnits()
						for (unit : units) {
							val resource = unit.resource
							if (!isDerived(resource)) {
								var javaType = unit.getType(typeName)
								if (javaType.exists()) {
									addIssue(type, unit.elementName)
									return SourceTraversal.DUPLICATE
								}
							}
						}
					}
				}
			} else {
				return SourceTraversal.INTERRUPT
			}
		}
		return SourceTraversal.UNIQUE
	}
	
	def boolean doCheckUniqueInProject(QualifiedName name, JvmDeclaredType type) throws JavaModelException {
		val javaProject = javaProjectProvider.getJavaProject(type.eResource.resourceSet)
		context.put(OUTPUT_CONFIGS, outputConfigurationProvider.getOutputConfigurations(type.eResource))
		val packageName = type.packageName
		val typeName = type.simpleName
		val sourceFolders = javaProject.packageFragmentRoots.filter[ kind == IPackageFragmentRoot.K_SOURCE ]
		var indexManager = JavaModelManager.getIndexManager
		
		if (sourceFolders.length == 0 || indexManager.awaitingJobsCount() > 0) {
			// still indexing - don't enter a busy wait loop but ask the source folders directly
			switch doCheckUniqueInProjectSource(packageName?:'', typeName, type, sourceFolders) {
				case DUPLICATE: return false
				case UNIQUE: return true
				default: {
					// ok {}
				}
			}
		}
		
		val workingCopyPaths = newHashSet
		var copies = getWorkingCopies(type)
		if (copies != null) {
			for (workingCopy: copies) {
				val path = workingCopy.path
				if (javaProject.path.isPrefixOf(path) && !isDerived(workingCopy.resource)) {
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
		val pattern = new TypeDeclarationPattern(
			if(packageName == null) CharOperation.NO_CHAR else packageName.toCharArray(), CharOperation.NO_CHAR_CHAR, // top level type - no enclosing type names
			typeName.toCharArray(), IIndexConstants.TYPE_SUFFIX,
			SearchPattern.R_EXACT_MATCH.bitwiseOr(SearchPattern.R_CASE_SENSITIVE))
		
		var IndexQueryRequestor searchRequestor = [ documentPath, indexRecord, participant, access |
			if (workingCopyPaths.contains(documentPath)) {
				return true // filter out working copies
			}
			var IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(documentPath))
			if (!isDerived(file)) {
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
		if (ResourceSetContext.get(type).isBuilder) {
			return #[]
		}
		return JavaModelManager.getJavaModelManager().getWorkingCopies(DefaultWorkingCopyOwner.PRIMARY, false);
	}

	def protected isDerived(IResource resource) {
		try {
			if (derivedResourceMarkers.findDerivedResourceMarkers(resource).length >= 1) {
				return true
			}
			val outputConfigurations = context.get(OUTPUT_CONFIGS) as Collection<OutputConfiguration>
			if (outputConfigurations != null) {
				val projectRelativePath = resource.projectRelativePath
				for(outputConfiguration: outputConfigurations) {
					for(dir: outputConfiguration.outputDirectories) {
						if (new Path(dir).isPrefixOf(projectRelativePath)) {
							return true
						}
					}
				}
			}
			return false
		} catch(CoreException e) {
			return false
		}
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