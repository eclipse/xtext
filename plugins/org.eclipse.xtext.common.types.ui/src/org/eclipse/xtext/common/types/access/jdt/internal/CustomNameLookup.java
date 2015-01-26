/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.jdt.internal.core.IJavaElementRequestor;
import org.eclipse.jdt.internal.core.JavaElementRequestor;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.NameLookup;
import org.eclipse.jdt.internal.core.PackageFragmentRoot;
import org.eclipse.jdt.internal.core.util.HashtableOfArrayToObject;
import org.eclipse.jdt.internal.core.util.Util;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CustomNameLookup extends NameLookup {

	private static boolean canBeUsed = true;

	private static Field packageFragmentRootsAccess;

	private static Field packageFragmentsAccess;

	private static Field rootToResolvedEntriesAccess;

	private static Field typesInWorkingCopiesAccess;

	private static Constructor<Answer> answerContructorAccess;

	static {
		try {
			Class<?> superClass = NameLookup.class;
			packageFragmentRootsAccess = superClass.getDeclaredField("packageFragmentRoots");
			packageFragmentRootsAccess.setAccessible(true);
			packageFragmentsAccess = superClass.getDeclaredField("packageFragments");
			packageFragmentsAccess.setAccessible(true);
			rootToResolvedEntriesAccess = superClass.getDeclaredField("rootToResolvedEntries");
			rootToResolvedEntriesAccess.setAccessible(true);
			typesInWorkingCopiesAccess = superClass.getDeclaredField("typesInWorkingCopies");
			typesInWorkingCopiesAccess.setAccessible(true);

			answerContructorAccess = Answer.class.getDeclaredConstructor(IType.class, AccessRestriction.class);
			answerContructorAccess.setAccessible(true);
		} catch (Exception e) {
			canBeUsed = false;
		}
	}

	public static NameLookup create(NameLookup prototype) {
		if (!canBeUsed) {
			return prototype;
		}
		try {
			CustomNameLookup result = new CustomNameLookup();
			result.packageFragmentRoots = (IPackageFragmentRoot[]) packageFragmentRootsAccess.get(prototype);
			result.packageFragments = (HashtableOfArrayToObject) packageFragmentsAccess.get(prototype);
			result.rootToResolvedEntries = (Map<?, ?>) rootToResolvedEntriesAccess.get(prototype);
			result.typesInWorkingCopies = (HashMap<?, ?>) typesInWorkingCopiesAccess.get(prototype);
			return result;
		} catch (Exception e) {
			return prototype;
		}
	}

	protected CustomNameLookup() {
		super(null, null, null, null);
	}

	@Override
	public void seekPackageFragments(String name, boolean partialMatch, IJavaElementRequestor requestor) {
		if (partialMatch) {
			String[] splittedName = Util.splitOn('.', name, 0, name.length());
			Object[][] keys = this.packageFragments.keyTable;
			for (int i = 0, length = keys.length; i < length; i++) {
				if (requestor.isCanceled())
					return;
				String[] pkgName = (String[]) keys[i];
				if (pkgName != null && Util.startsWithIgnoreCase(pkgName, splittedName, partialMatch)) {
					Object value = this.packageFragments.valueTable[i];
					if (value instanceof PackageFragmentRoot) {
						PackageFragmentRoot root = (PackageFragmentRoot) value;
						requestor.acceptPackageFragment(root.getPackageFragment(pkgName));
					} else {
						IPackageFragmentRoot[] roots = (IPackageFragmentRoot[]) value;
						for (int j = 0, length2 = roots.length; j < length2; j++) {
							if (requestor.isCanceled())
								return;
							PackageFragmentRoot root = (PackageFragmentRoot) roots[j];
							requestor.acceptPackageFragment(root.getPackageFragment(pkgName));
						}
					}
				}
			}
		} else {
			String[] splittedName = Util.splitOn('.', name, 0, name.length());
			int pkgIndex = this.packageFragments.getIndex(splittedName);
			if (pkgIndex != -1) {
				Object value = this.packageFragments.valueTable[pkgIndex];
				// reuse existing String[]
				String[] pkgName = (String[]) this.packageFragments.keyTable[pkgIndex];
				if (value instanceof PackageFragmentRoot) {
					requestor.acceptPackageFragment(((PackageFragmentRoot) value).getPackageFragment(pkgName));
				} else {
					IPackageFragmentRoot[] roots = (IPackageFragmentRoot[]) value;
					if (roots != null) {
						for (int i = 0, length = roots.length; i < length; i++) {
							if (requestor.isCanceled())
								return;
							PackageFragmentRoot root = (PackageFragmentRoot) roots[i];
							requestor.acceptPackageFragment(root.getPackageFragment(pkgName));
						}
					}
				}
			}
		}
	}

	private Answer createAnswer(IType type, AccessRestriction restriction) {
		try {
			return answerContructorAccess.newInstance(type, restriction);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Find type. Considering secondary types and waiting for indexes depends on given corresponding parameters.
	 */
	@Override
	public Answer findType(String typeName, String packageName, boolean partialMatch, int acceptFlags,
			boolean considerSecondaryTypes, boolean waitForIndexes, boolean checkRestrictions, IProgressMonitor monitor) {
		if (packageName == null || packageName.length() == 0) {
			packageName = IPackageFragment.DEFAULT_PACKAGE_NAME;
		} else if (typeName.length() > 0 && ScannerHelper.isLowerCase(typeName.charAt(0))) {
			// see if this is a known package and not a type
			if (isPackageInsteadOfType(typeName, packageName))
				return null; //$NON-NLS-1$
		}

		// Look for concerned package fragments
		IPackageFragment[] packages = findPackageFragments(packageName);

		// Try to find type in package fragments list
		int length = packages.length;
		Answer suggestedAnswer = null;
		for (int i = 0; i < length; i++) {
			IType type = null;
			type = findType(typeName, packages[i], partialMatch, acceptFlags, waitForIndexes, considerSecondaryTypes);
			if (type != null) {
				AccessRestriction accessRestriction = null;
				if (checkRestrictions) {
					accessRestriction = getViolatedRestriction(typeName, packageName, type, accessRestriction);
				}
				Answer answer = createAnswer(type, accessRestriction);
				if (!answer.ignoreIfBetter()) {
					if (answer.isBetter(suggestedAnswer))
						return answer;
				} else if (answer.isBetter(suggestedAnswer))
					// remember suggestion and keep looking
					suggestedAnswer = answer;
			}
		}
		if (suggestedAnswer != null)
			// no better answer was found
			return suggestedAnswer;
		return null;
	}

	@Override
	public IType findType(String name, IPackageFragment pkg, boolean partialMatch, int acceptFlags,
			boolean waitForIndices, boolean considerSecondaryTypes) {
		if (pkg == null)
			return null;

		SingleTypeRequestor typeRequestor = new SingleTypeRequestor();
		seekTypes(name, pkg, partialMatch, acceptFlags, typeRequestor, considerSecondaryTypes);
		IType type = typeRequestor.getType();
		return type;
	}
	
	@Override
	public void seekTypes(String name, IPackageFragment pkg, boolean partialMatch, int acceptFlags,
			IJavaElementRequestor requestor, boolean considerSecondaryTypes) {
		// we use the acceptFlags to communicate with seekTypesInSourcePackage which does not accept the
		// boolean flag for considerSecondaryTypes
		if (considerSecondaryTypes) {
			acceptFlags |= ASTNode.Bit6;
		}
		super.seekTypes(name, pkg, partialMatch, acceptFlags, requestor, considerSecondaryTypes);
	}
	
	@Override
	protected boolean seekTypesInWorkingCopies(String name, IPackageFragment pkg, int firstDot, boolean partialMatch,
			String topLevelTypeName, int acceptFlags, IJavaElementRequestor requestor, boolean considerSecondaryTypes) {
		// unset the "unexpected" bit
		acceptFlags &= ~ASTNode.Bit16;
		return super.seekTypesInWorkingCopies(name, pkg, firstDot, partialMatch, topLevelTypeName, acceptFlags, requestor,
				considerSecondaryTypes);
	}
	
	@Override
	protected void seekTypesInBinaryPackage(String name, IPackageFragment pkg, boolean partialMatch, int acceptFlags,
			IJavaElementRequestor requestor) {
		// unset the "unexpected" bit
		acceptFlags &= ~ASTNode.Bit16;
		super.seekTypesInBinaryPackage(name, pkg, partialMatch, acceptFlags, requestor);
	}
	
	private IType findSecondaryTypesInSourcePackage(IPackageFragment pkg, String typeName) {
		JavaModelManager manager = JavaModelManager.getJavaModelManager();
		try {
			if (JavaModelManager.getIndexManager().awaitingJobsCount() == 0) {
				@SuppressWarnings("unchecked")
				Map<String, Map<String, IType>> secondaryTypePaths = manager.secondaryTypes(pkg.getJavaProject(), true, null);
				if (secondaryTypePaths.size() > 0) {
					Map<String, IType> types = secondaryTypePaths.get(pkg.getElementName()); //$NON-NLS-1$
					if (types != null && types.size() > 0) {
						IType type = types.get(typeName);
						return type;
					}
				}	
			} else {
				ICompilationUnit[] units = pkg.getCompilationUnits();
				for (ICompilationUnit unit : units) {
					IType type = unit.getType(typeName);
					if (type.exists()) {
						return type;
					}
				}
			}
		}
		catch (JavaModelException jme) {
			// give up
		}
		return null;
	}
	
	@Override
	protected void seekTypesInSourcePackage(String name, IPackageFragment pkg, int firstDot, boolean partialMatch,
			String topLevelTypeName, int acceptFlags, IJavaElementRequestor requestor) {
		boolean secondaryTypes = (acceptFlags & ASTNode.Bit6) == ASTNode.Bit6;
		// unset the "unexpected" bit
		acceptFlags &= ~ASTNode.Bit6;
		super.seekTypesInSourcePackage(name, pkg, firstDot, partialMatch, topLevelTypeName, acceptFlags, requestor);
		if (secondaryTypes && !requestor.isCanceled()) {
			if (partialMatch) {
				try {
					String cuPrefix = firstDot == -1 ? name : name.substring(0, firstDot);
					IJavaElement[] compilationUnits = pkg.getChildren();
					for (int i = 0, length = compilationUnits.length; i < length; i++) {
						if (requestor.isCanceled())
							return;
						IJavaElement cu = compilationUnits[i];
						// inverse to super impl
						if (cu.getElementName().toLowerCase().startsWith(cuPrefix))
							continue;
						try {
							IType[] types = ((ICompilationUnit) cu).getTypes();
							for (int j = 0, typeLength = types.length; j < typeLength; j++)
								seekTypesInTopLevelType(name, firstDot, types[j], requestor, acceptFlags);
						} catch (JavaModelException e) {
							// cu doesn't exist -> ignore
						}
					}
				} catch (JavaModelException e) {
					// package doesn't exist -> ignore
				}
			} else {
				IType type = findSecondaryTypesInSourcePackage(pkg, topLevelTypeName);
				if (type != null) {
					if (firstDot != -1) {
						type = getMemberType(type, name, firstDot);
					}
					if (acceptType(type, acceptFlags, true)) {
						requestor.acceptType(type);
					}
				}
			}
		}
	}
	
	private IType getMemberType(IType type, String name, int dot) {
		while (dot != -1) {
			int start = dot+1;
			dot = name.indexOf('.', start);
			String typeName = name.substring(start, dot == -1 ? name.length() : dot);
			type = type.getType(typeName);
		}
		return type;
	}

	private boolean isPackageInsteadOfType(String typeName, String packageName) {
		String name = packageName + '.' + typeName;
		String[] splittedName = Util.splitOn('.', name, 0, name.length());
		int pkgIndex = this.packageFragments.getIndex(splittedName);
		return pkgIndex != -1;
	}

	private IPackageFragment[] findPackageFragments(String packageName) {
		JavaElementRequestor elementRequestor = new JavaElementRequestor();
		seekPackageFragments(packageName, false, elementRequestor);
		IPackageFragment[] packages = elementRequestor.getPackageFragments();
		return packages;
	}

	private AccessRestriction getViolatedRestriction(String typeName, String packageName, IType type,
			AccessRestriction accessRestriction) {
		PackageFragmentRoot root = (PackageFragmentRoot) type.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
		ClasspathEntry entry = (ClasspathEntry) this.rootToResolvedEntries.get(root);
		if (entry != null) { // reverse map always contains resolved CP entry
			AccessRuleSet accessRuleSet = entry.getAccessRuleSet();
			if (accessRuleSet != null) {
				// TODO (philippe) improve char[] <-> String conversions to avoid performing them on the fly
				char[][] packageChars = CharOperation.splitOn('.', packageName.toCharArray());
				char[] typeChars = typeName.toCharArray();
				accessRestriction = accessRuleSet.getViolatedRestriction(CharOperation.concatWith(packageChars,
						typeChars, '/'));
			}
		}
		return accessRestriction;
	}

}
