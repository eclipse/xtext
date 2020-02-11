/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.compiler.util.ObjectVector;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NameLookup;
import org.eclipse.jdt.internal.core.search.BasicSearchEngine;
import org.eclipse.jdt.internal.core.search.IndexQueryRequestor;
import org.eclipse.jdt.internal.core.search.PatternSearchJob;
import org.eclipse.jdt.internal.core.search.indexing.IIndexConstants;
import org.eclipse.jdt.internal.core.search.indexing.IndexManager;
import org.eclipse.jdt.internal.core.search.matching.TypeDeclarationPattern;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.ShadowedTypeException;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.UnknownNestedTypeException;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.resource.ResourceSetContext;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Wrapper;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JdtTypeProvider extends AbstractJvmTypeProvider implements IJdtTypeProvider {
	
	private static final String PRIMITIVES = URIHelperConstants.PRIMITIVES_URI.segment(0);

	private static final boolean SKIP_SECONDARY_TYPES = Boolean.getBoolean("xtext.skipSecondaryTypes");
	
	private final IJavaProject javaProject;

	private final TypeURIHelper typeUriHelper;

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
		super(resourceSet, indexedJvmTypeAccess, services);
		if (javaProject == null)
			throw new IllegalArgumentException("javaProject may not be null");
		this.javaProject = javaProject;
		this.typeUriHelper = createTypeURIHelper();
		this.workingCopyOwner = workingCopyOwner;
		this.typeFactory = createTypeFactory();
	}

	protected JdtBasedTypeFactory createTypeFactory() {
		return new JdtBasedTypeFactory(typeUriHelper, workingCopyOwner);
	}

	protected TypeURIHelper createTypeURIHelper() {
		return new TypeURIHelper();
	}
	
	@Override
	public JvmType findTypeByName(String name) {
		return doFindTypeByName(name, false);
	}
	
	/**
	 * @since 2.9
	 */
	protected JvmType doFindTypeByName(String name, boolean traverseNestedTypes) {
		String signature = getSignature(name);
		if (signature == null)
			return null;
		URI resourceURI = typeUriHelper.createResourceURI(signature);
		if (resourceURI.segment(0) == PRIMITIVES) {
			return findPrimitiveType(signature, resourceURI);
		} else {
			return findObjectType(signature, resourceURI, traverseNestedTypes);
		}
	}

	/**
	 * @since 2.4
	 */
	@Override
	public JvmType findTypeByName(String name, boolean binaryNestedTypeDelimiter) {
		JvmType result = doFindTypeByName(name, false);
		if (result != null || isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter)) {
			return result;
		}
		ClassNameVariants nameVariants = new ClassNameVariants(name);
		while (result == null && nameVariants.hasNext()) {
			String nextVariant = nameVariants.next();
			result = doFindTypeByName(nextVariant, true);
		}
		return result;
	}

	/* @Nullable */
	private String getSignature(String name) {
		if (Strings.isEmpty(name))
			throw new IllegalArgumentException("null");
		String signature = null;
		try {
			signature = name.startsWith("[") ? name : Signature.createTypeSignature(name, true);
		} catch (IllegalArgumentException e) {
			return null;
		}
		return signature;
	}

	/**
	 * @since 2.9
	 */
	/* @Nullable */
	private JvmType findObjectType(/* @NonNull */ String signature, /* @NonNull */ URI resourceURI, boolean traverseNestedTypes) {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet instanceof SynchronizedXtextResourceSet) {
			synchronized (((SynchronizedXtextResourceSet) resourceSet).getLock()) {
				return doFindObjectType(signature, resourceURI, traverseNestedTypes);		
			}
		}
		return doFindObjectType(signature, resourceURI, traverseNestedTypes);
	}

	/**
	 * @since 2.9
	 */
	protected JvmType doFindObjectType(String signature, URI resourceURI, boolean traverseNestedTypes) {
		TypeResource resource = getLoadedResourceForJavaURI(resourceURI);
		try {
			JvmType result = findLoadedOrDerivedObjectType(signature, resourceURI, resource, traverseNestedTypes);
			if (result != null || resource != null) {
				if (result != null && !canLink(result)) {
					return null;
				}
				return result;
			}
			try {
				return findObjectTypeInJavaProject(signature, resourceURI, traverseNestedTypes);
			} catch (JavaModelException e) {
				return null;
			} catch (NullPointerException e) { // JDT throws NPEs see https://bugs.eclipse.org/bugs/show_bug.cgi?id=369391
				return null;
			}
		} catch (ShadowedTypeException e) {
			return null;
		} catch (UnknownNestedTypeException e) {
			return null;
		}
	}

	private boolean canLink(JvmType type) {
		Resource resource = type.eResource();
		if (resource instanceof TypeResource) {
			IMirror mirror = ((TypeResource) resource).getMirror();
			if (mirror instanceof JdtTypeMirror) {
				try {
					return canLink(((JdtTypeMirror) mirror).getMirroredType());
				} catch (JavaModelException e) {
					return false;
				}
			} else {
				return true;
			}
		}
		URI resourceURI = resource.getURI();
		if (resourceURI.isPlatformResource() && resourceURI.segment(1).equals(javaProject.getProject().getName())) {
			IndexedJvmTypeAccess indexedJvmTypeAccess = this.getIndexedJvmTypeAccess();
			if (indexedJvmTypeAccess != null && indexedJvmTypeAccess.isIndexingPhase(getResourceSet())) {
				return false;
			}
		}
		return true;
	}

	/* @Nullable */
	private JvmType findLoadedOrDerivedObjectType(/* @NonNull */ String signature, /* @NonNull */ URI resourceURI,
			/* @Nullable */ TypeResource resource, boolean traverseNestedTypes) throws UnknownNestedTypeException {
		JvmType result = resource != null ? findTypeBySignature(signature, resource, traverseNestedTypes) : null;
		if (result != null) {
			return result;
		}
		result = findObjectTypeInIndex(signature, resourceURI);
		if (result != null) {
			return result;
		}
		return null;
	}

	/* @Nullable */
	private JvmType findObjectTypeInJavaProject(/* @NonNull */ String signature, /* @NonNull */ URI resourceURI, boolean traverseNestedTypes)
			throws JavaModelException {
		IType type = findObjectTypeInJavaProject(resourceURI);
		if (type != null) {
			try {
				return createResourceAndFindType(resourceURI, type, signature, traverseNestedTypes);
			} catch (IOException ioe) {
				return null;
			} catch (WrappedException wrapped) {
				if (wrapped.getCause() instanceof IOException) {
					return null;
				}
				throw wrapped;
			}
		}
		return null;
	}

	/* @Nullable */
	private JvmType createResourceAndFindType(/* @NonNull */ URI resourceURI, /* @NonNull */ IType type, /* @NonNull */ String signature, boolean traverseNestedTypes)
			throws IOException {
		TypeResource resource = createResource(resourceURI, type);
		resource.load(Collections.singletonMap(TypeResource.OPTION_CLASSPATH_CONTEXT, javaProject));
		return findTypeBySignature(signature, resource, traverseNestedTypes);
	}

	private TypeResource createResource(URI resourceURI, IType type) {
		TypeResource resource = doCreateResource(resourceURI);
		getResourceSet().getResources().add(resource);
		if (type.exists()) {
			IMirror mirror = createMirror(type);
			resource.setMirror(mirror);
		}
		return resource;
	}
	
	private IType findObjectTypeInJavaProject(/* @NonNull */ URI resourceURI) throws JavaModelException {
		String topLevelType = resourceURI.segment(resourceURI.segmentCount() - 1);
		return findObjectTypeInJavaProject(topLevelType);
	}

	private IType findObjectTypeInJavaProject(String topLevelType) throws JavaModelException {
		int lastDot = topLevelType.lastIndexOf('.');
		String packageName = null;
		String typeName = topLevelType;
		if (lastDot != -1) {
			typeName = typeName.substring(lastDot + 1);
			packageName = topLevelType.substring(0, lastDot);
		}
		
		/*
		 * IJavaProject.findType(pack, type, progressMonitor) would search for secondary types, too
		 * but it turns out to be quite slow due to some waiting for a busy index. That's why we use
		 * a more low level API to find the secondary types only if the type was not found as a primary
		 * type.
		 */
		
		// fast operation first: try to find top level types
		IType type = findPrimaryType(packageName, typeName);
		if (type == null && !SKIP_SECONDARY_TYPES) {
			// no luck, try again - this time look for secondary types
			type = findSecondaryType(Strings.emptyIfNull(packageName), typeName);
		}
		if (type != null && !canLink(type)) {
			return null;
		}
		return type;
	}

	/**
	 * @since 2.9
	 */
	protected IType findPrimaryType(String packageName, String typeName) throws JavaModelException {
		JavaProject casted = (JavaProject) javaProject;
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

	private NameLookup getNameLookup(JavaProject casted) throws JavaModelException {
		return casted.newNameLookup(getWorkingCopies());
	}
	
	/**
	 * Searches a secondary type with the given name and package.
	 * 
	 * Secondary types are toplevel types with a name that does not match the name of the compilation unit.
	 * @since 2.9
	 */
	protected IType findSecondaryType(String packageName, final String typeName)  throws JavaModelException {
		IPackageFragmentRoot[] sourceFolders = getSourceFolders();
		IndexManager indexManager = JavaModelManager.getIndexManager();
		if (indexManager.awaitingJobsCount() > 0) { // still indexing - don't enter a busy wait loop but ask the source folders directly
			return findSecondaryTypeInSourceFolders(packageName, typeName, sourceFolders);
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

	/**
	 * @since 2.9
	 */
	protected IType findSecondaryTypeInSourceFolders(String packageName, final String typeName, IPackageFragmentRoot[] sourceFolders) throws JavaModelException {
		for(IPackageFragmentRoot sourceFolder: sourceFolders) {
			IPackageFragment packageFragment = sourceFolder.getPackageFragment(Strings.emptyIfNull(packageName));
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
		return null;
	}

	private ICompilationUnit[] getWorkingCopies() {
		if (ResourceSetContext.get(getResourceSet()).isBuilder()) {
			return new ICompilationUnit[0];
		}
		return JavaModelManager.getJavaModelManager().getWorkingCopies(DefaultWorkingCopyOwner.PRIMARY, false/*don't add primary WCs a second time*/);
	}

	private IPackageFragmentRoot[] getSourceFolders() throws JavaModelException {
		// Build scope using prereq projects but only source folders
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
	
	private IPackageFragmentRoot[] getSourceFolders(JavaProject javaProject) throws JavaModelException {
		/*
		 * IJavaProject#getAllPackageFragmentRoots will open all references archives to read the JDK version from
		 * the first class file it finds. This isn't necessary for our case thus we try to avoid this by copying a lot of 
		 * code. 
		 */
		ObjectVector result = new ObjectVector();
		collectSourcePackageFragmentRoots(javaProject, Sets.<String>newHashSet(), null, result);
		IPackageFragmentRoot[] rootArray = new IPackageFragmentRoot[result.size()];
		result.copyInto(rootArray);
		return rootArray;
	}

	/**
	 * @see JavaProject computePackageFragmentRoots(IClasspathEntry, ObjectVector, HashSet, IClasspathEntry, boolean, boolean, java.util.Map)
	 */
	private void collectSourcePackageFragmentRoots(JavaProject javaProject, HashSet<String> rootIDs, IClasspathEntry referringEntry, ObjectVector result) throws JavaModelException {
		if (referringEntry == null){
			rootIDs.add(javaProject.rootID());
		} else if (rootIDs.contains(javaProject.rootID())) {
			return;
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
					// inlined from org.eclipse.jdt.internal.core.JavaProject
					// .computePackageFragmentRoots(IClasspathEntry, ObjectVector, HashSet, IClasspathEntry, boolean, boolean, Map)
					IPath projectPath = javaProject.getProject().getFullPath();
					IPath entryPath = entry.getPath();
					if (projectPath.isPrefixOf(entryPath)){
						Object target = JavaModel.getTarget(entryPath, true/*check existency*/);
						if (target != null) {
							if (target instanceof IFolder || target instanceof IProject){
								IPackageFragmentRoot root = javaProject.getPackageFragmentRoot((IResource)target);
								result.add(root);
							}
						}
					}
					break;
			}
		}
	}
	
	/**
	 * @since 2.9
	 */
	protected boolean canLink(IType type) throws JavaModelException {
		IndexedJvmTypeAccess indexedJvmTypeAccess = this.getIndexedJvmTypeAccess();
		if (indexedJvmTypeAccess != null && indexedJvmTypeAccess.isIndexingPhase(getResourceSet())) {
			IResource underlyingResource = type.getUnderlyingResource();
			if (underlyingResource == null) {
				return true;
			}
			for (IPackageFragmentRoot root : javaProject.getPackageFragmentRoots()) {
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
					IResource srcUnderlyingResource = root.getUnderlyingResource();
					if (srcUnderlyingResource != null && srcUnderlyingResource.contains(underlyingResource)) {
						return false;
					}
				}
			}
			return true;
		}
		return true;
	}

	private JvmType findObjectTypeInIndex(/* @NonNull */ String signature, /* @NonNull */ URI resourceURI) throws UnknownNestedTypeException {
		IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
		if (indexedJvmTypeAccess != null) {
			URI proxyURI = resourceURI.appendFragment(typeUriHelper.getFragment(signature));
			EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, getResourceSet(), true);
			if (candidate instanceof JvmType) {
				return (JvmType) candidate;
			}
		}
		return null;
	}

	/* @Nullable */
	private TypeResource getLoadedResourceForJavaURI(/* @NonNull */ URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, false);
		return resource;
	}

	private JvmType findPrimitiveType(/* @NonNull */ String signature, /* @NonNull */ URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, true);
		JvmType result = findTypeBySignature(signature, resource, false);
		return result;
	}

	/**
	 * @since 2.3
	 */
	protected Resource getResourceForJavaURI(/* @NonNull */ URI resourceURI, boolean loadOnDemand) {
		return getResourceSet().getResource(resourceURI, loadOnDemand);
	}
	
	/**
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public JvmType findTypeBySignature(String signature, TypeResource resource) {
		return findTypeBySignature(signature, resource, false);
	}
	
	private JvmType findTypeBySignature(String signature, TypeResource resource, boolean traverseNestedTypes) {
		// TODO: Maybe iterate the resource without computing a fragment
		String fragment = typeUriHelper.getFragment(signature);
		JvmType result = (JvmType) resource.getEObject(fragment);
		if (result != null || !traverseNestedTypes)
			return result;
		List<EObject> contents = resource.getContents();
		if (contents.isEmpty()) {
			return null;
		}
		String rootTypeName = resource.getURI().segment(1);
		String nestedTypeName = fragment.substring(rootTypeName.length() + 1);
		List<String> segments = Strings.split(nestedTypeName, "$");
		EObject rootType = contents.get(0);
		if (rootType instanceof JvmDeclaredType) {
			result = findNestedType((JvmDeclaredType) rootType, segments, 0);
		}
		return result;
	}

	/**
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	protected IMirror createMirrorForFQN(String name) {
		try {
			IType type = findObjectTypeInJavaProject(name);
			if (type == null || !type.exists())
				return null;
			return createMirror(type);
		} catch (JavaModelException e) {
			return null;
		}
	}

	/**
	 * @since 2.9
	 */
	/* @Nullable */
	protected IMirror createMirror(/* @NonNull */ IType type) {
		String elementName = type.getElementName();
		if (!elementName.equals(type.getTypeQualifiedName())) {
			// workaround for bug in jdt with binary type names that start with a $ dollar sign
			// e.g. $ImmutableList
			// it manifests itself in a way that allows to retrieve ITypes but one cannot obtain bindings for that type
			return null;
		}
		return new JdtTypeMirror(type, typeFactory, services);
	}
	
	@Override
	public IJavaProject getJavaProject() {
		return javaProject;
	}
	
	@Override
	public TypeURIHelper getTypeUriHelper() {
		return typeUriHelper;
	}
	
	public JdtBasedTypeFactory getJdtBasedTypeFactory() {
		return typeFactory;
	}

}
