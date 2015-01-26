/*******************************************************************************
 * Copyright (c) 2009-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.compiler.util.ObjectVector;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NameLookup;
import org.eclipse.jdt.internal.core.search.BasicSearchEngine;
import org.eclipse.jdt.internal.core.search.IndexQueryRequestor;
import org.eclipse.jdt.internal.core.search.PatternSearchJob;
import org.eclipse.jdt.internal.core.search.indexing.IIndexConstants;
import org.eclipse.jdt.internal.core.search.indexing.IndexManager;
import org.eclipse.jdt.internal.core.search.matching.TypeDeclarationPattern;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.util.Wrapper;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JdtTypeProvider extends AbstractJdtTypeProvider implements IJdtTypeProvider {
	
	private final JdtBasedTypeFactory typeFactory;

	private final WorkingCopyOwner workingCopyOwner;
	
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet) {
		this(javaProject, resourceSet, null);
	}
	
	/**
	 * @since 2.1
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		this(javaProject, resourceSet, indexedJvmTypeAccess, null);
	}

	/**
	 * @since 2.4
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	@Deprecated
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess, WorkingCopyOwner workingCopyOwner) {
		this(javaProject, resourceSet, indexedJvmTypeAccess, workingCopyOwner, null);
	}
	
	/**
	 * @since 2.8
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess, WorkingCopyOwner workingCopyOwner, TypeResourceServices services) {
		super(javaProject, resourceSet, indexedJvmTypeAccess, services);
		this.workingCopyOwner = workingCopyOwner;
		this.typeFactory = createTypeFactory();
	}

	protected JdtBasedTypeFactory createTypeFactory() {
		return new JdtBasedTypeFactory(getTypeUriHelper(), workingCopyOwner);
	}

	@Override
	protected IType findObjectTypeInJavaProject(String packageName, String typeName) throws JavaModelException {
		/*
		 * IJavaProject.findType(pack, type, progressMonitor) would search for secondary types, too
		 * but it turns out to be quite slow due to some waiting for a busy index. That's why we use
		 * a more low level API to find the secondary types only if the type was not found as a primary
		 * type.
		 */
		
		// fast operation first: try to find top level types
		IType type = findPrimaryType(packageName, typeName);
		if (type == null) {
			// no luck, try again - this time look for secondary types
			type = findSecondaryType(packageName, typeName);
		}
		if (type != null && !canLink(type)) {
			return null;
		}
		return type;
	}

	private IType findPrimaryType(String packageName, String typeName) throws JavaModelException {
		IJavaProject javaProject = getJavaProject();
		if (javaProject instanceof JavaProject) {
			JavaProject casted = (JavaProject) getJavaProject();
			NameLookup nameLookup = getNameLookup(casted);
			NameLookup.Answer answer = nameLookup.findType(
					typeName,
					packageName,
					false,
					NameLookup.ACCEPT_ALL,
					false, // do not consider secondary types
					true, // wait for indexes (in case we need to consider secondary types)
					false/*don't check restrictions*/,
					null);
			return answer == null ? null : answer.type;
		}
		return javaProject.findType(packageName, typeName);
	}

	private NameLookup getNameLookup(JavaProject casted) throws JavaModelException {
		return casted.newNameLookup(getWorkingCopies());
	}
	
	/**
	 * Searches a secondary type with the given name and package.
	 * 
	 * Secondary types are toplevel types with a name that does not match the name of the compilation unit.
	 */
	private IType findSecondaryType(String packageName, final String typeName)  throws JavaModelException {
		IPackageFragmentRoot[] sourceFolders = getSourceFolders();
		IndexManager indexManager = JavaModelManager.getIndexManager();
		if (indexManager.awaitingJobsCount() > 0) { // still indexing - don't enter a busy wait loop but ask the source folders directly
			for(IPackageFragmentRoot sourceFolder: sourceFolders) {
				if (indexManager.awaitingJobsCount() > 0) {
					IPackageFragment packageFragment = sourceFolder.getPackageFragment(packageName);
					if (packageFragment.exists()) {
						ICompilationUnit[] units = packageFragment.getCompilationUnits();
						for(ICompilationUnit unit: units) {
							IType type = unit.getType(typeName);
							if (type.exists()) {
								return type;
							}
						}
					}
				}
			}
			return null;
		}
		
		// code below is adapted from BasicSearchEnginge.searchAllSecondaryTypes
		
		// index is ready, query it for a secondary type 
		final TypeDeclarationPattern pattern = new TypeDeclarationPattern(
				packageName == null ? CharOperation.NO_CHAR : packageName.toCharArray(),
				CharOperation.NO_CHAR_CHAR, // top level type - no enclosing type names
				typeName.toCharArray(),
				IIndexConstants.SECONDARY_SUFFIX,
				SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE);

		// Get working copy path(s). Store in a single string in case of only one to optimize comparison in requestor
		final HashSet<String> workingCopyPaths = new HashSet<String>();
		String workingCopyPath = null;
		ICompilationUnit[] copies = getWorkingCopies();
		final int copiesLength = copies == null ? 0 : copies.length;
		if (copies != null) {
			if (copiesLength == 1) {
				ICompilationUnit singleWC = copies[0];
				if (singleWC.getPackageDeclaration(packageName).exists()) {
					IType result = singleWC.getType(typeName);
					if (result.exists()) {
						return result;
					}
				}
				workingCopyPath = copies[0].getPath().toString();
			} else {
				for (int i = 0; i < copiesLength; i++) {
					ICompilationUnit workingCopy = copies[i];
					if (workingCopy.getPackageDeclaration(packageName).exists()) {
						IType result = workingCopy.getType(typeName);
						if (result.exists()) {
							return result;
						}
					}
					workingCopyPaths.add(workingCopy.getPath().toString());
				}
			}
		}
		final String singleWkcpPath = workingCopyPath;
		final Wrapper<IType> result = Wrapper.forType(IType.class);

		IndexQueryRequestor searchRequestor = new IndexQueryRequestor(){
			@Override
			public boolean acceptIndexMatch(String documentPath, SearchPattern indexRecord, SearchParticipant participant, AccessRuleSet access) {
				// Filter unexpected types
				switch (copiesLength) {
					case 0:
						break;
					case 1:
						if (singleWkcpPath == null) {
							throw new IllegalStateException();
						}
						if (singleWkcpPath.equals(documentPath)) {
							return true; // filter out *the* working copy
						}
						break;
					default:
						if (workingCopyPaths.contains(documentPath)) {
							return true; // filter out working copies
						}
						break;
				}
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(documentPath));
				ICompilationUnit unit = JavaCore.createCompilationUnitFrom(file);
				IType type = unit.getType(typeName);
				result.set(type);
				return false;
			}
		};

		try {
			indexManager.performConcurrentJob(
				new PatternSearchJob(
					pattern,
					BasicSearchEngine.getDefaultSearchParticipant(), // Java search only
					BasicSearchEngine.createJavaSearchScope(sourceFolders),
					searchRequestor),
				IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
				null);
		} catch (OperationCanceledException oce) {
			// do nothing
		}
		return result.get();
	}

	private ICompilationUnit[] getWorkingCopies() {
		if (isBuilderScope()) {
			return new ICompilationUnit[0];
		}
		return JavaModelManager.getJavaModelManager().getWorkingCopies(DefaultWorkingCopyOwner.PRIMARY, false/*don't add primary WCs a second time*/);
	}

	private IPackageFragmentRoot[] getSourceFolders() throws JavaModelException {
		// Build scope using prereq projects but only source folders
		IJavaProject javaProject = getJavaProject();
		if (javaProject instanceof JavaProject) {
			return getSourceFolders((JavaProject) javaProject);
		} else {
			IPackageFragmentRoot[] allRoots = javaProject.getAllPackageFragmentRoots();
			int length = allRoots.length, size = 0;
			IPackageFragmentRoot[] allSourceFolders = new IPackageFragmentRoot[length];
			for (int i=0; i<length; i++) {
				if (allRoots[i].getKind() == IPackageFragmentRoot.K_SOURCE) {
					allSourceFolders[size++] = allRoots[i];
				}
			}
			if (size < length) {
				System.arraycopy(allSourceFolders, 0, allSourceFolders = new IPackageFragmentRoot[size], 0, size);
			}
			return allSourceFolders;
		}
	}
	
	/*
	 * IJavaProject#getAllPackageFragmentRoots will open all references archives to read the JDK version from
	 * the first class file it finds. This isn't necessary for our case thus we try to avoid this by copying a lot of 
	 * code. 
	 */
	private IPackageFragmentRoot[] getSourceFolders(JavaProject javaProject) throws JavaModelException {
		ObjectVector result = new ObjectVector();
		collectSourcePackageFragmentRoots(javaProject, Sets.<String>newHashSet(), null, result);
		IPackageFragmentRoot[] rootArray = new IPackageFragmentRoot[result.size()];
		result.copyInto(rootArray);
		return rootArray;
	}

	/**
	 * @see JavaProject#computePackageFragmentRoots(IClasspathEntry, ObjectVector, HashSet, IClasspathEntry, boolean, java.util.Map)
	 */
	private void collectSourcePackageFragmentRoots(JavaProject javaProject, HashSet<String> rootIDs, IClasspathEntry referringEntry, ObjectVector result) throws JavaModelException {
		if (referringEntry == null){
			rootIDs.add(javaProject.rootID());
		}
		IWorkspaceRoot workspaceRoot = javaProject.getProject().getWorkspace().getRoot();
		for(IClasspathEntry entry: javaProject.getResolvedClasspath()) {
			switch(entry.getEntryKind()) {
				case IClasspathEntry.CPE_PROJECT:
					if (referringEntry != null && !entry.isExported())
						return;
					
					IPath pathToProject = entry.getPath();
					IResource referencedProject = workspaceRoot.findMember(pathToProject);
					if (referencedProject != null && referencedProject.getType() == IResource.PROJECT) {
						IProject casted = (IProject) referencedProject;
						if (JavaProject.hasJavaNature(casted)) {
							rootIDs.add(javaProject.rootID());
							JavaProject referencedJavaProject = (JavaProject) JavaCore.create(casted);
							collectSourcePackageFragmentRoots(referencedJavaProject, rootIDs, entry, result);
						}
					}
					break;
				case IClasspathEntry.CPE_SOURCE:
					javaProject.computePackageFragmentRoots(
							entry,
							result,
							rootIDs,
							referringEntry,
							true,
							null);
					break;
			}
		}
	}
	
	@Override
	public JdtBasedTypeFactory getJdtBasedTypeFactory() {
		return typeFactory;
	}

}
