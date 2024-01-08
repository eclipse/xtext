/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.MergeableManifest2.BundleOrPackage;
import org.eclipse.xtext.util.MergeableManifest2.BundleOrPackageList;

/**
 * @author Sebastian - Initial contribution and API
 */
public class BumpVersions {

	public static void main(String[] args) throws IOException {
		String newVersion = args[0];
		File gitRoot = new File("./..");
		for (File bundleDir : gitRoot.listFiles()) {
			if (bundleDir.isDirectory()) {
				File manifest = new File(bundleDir, "META-INF/MANIFEST.MF");
				if (manifest.exists()) {
					MergeableManifest2 mergable;
					try (FileInputStream is = new FileInputStream(manifest)) {
						mergable = new MergeableManifest2(is);
					}
					mergable.getMainAttributes().put(MergeableManifest2.BUNDLE_VERSION, newVersion + ".qualifier");
					updateRequiredBundles(mergable, newVersion);
					updateImportedPackages(mergable, newVersion);
					updateExportedPackages(mergable, newVersion);
					try (FileOutputStream out = new FileOutputStream(manifest)) {
						mergable.write(out);
					}
				}
			}
		}
	}

	private static void updateRequiredBundles(MergeableManifest2 mergable, String newVersion) {
		String oldBundles = mergable.getMainAttributes().get(MergeableManifest2.REQUIRE_BUNDLE);
		if (oldBundles == null)
			return;
		BundleOrPackageList requiredBundles = BundleOrPackageList.fromInput(oldBundles, mergable.getLineDelimiter(),
				"bundle-version");
		List<String> updatedBundles = new ArrayList<>();
		for (BundleOrPackage requiredBundle : requiredBundles.list()) {
			String bundleName = requiredBundle.getName();
			if (bundleName.startsWith("org.eclipse.x")) {
				updatedBundles.add(bundleName + ";bundle-version=\"" + newVersion + "\"");
			}
		}
		mergable.addRequiredBundles(updatedBundles.toArray(new String[0]), true);
	}

	private static void updateImportedPackages(MergeableManifest2 mergable, String newVersion) {
		String oldPackages = mergable.getMainAttributes().get(MergeableManifest2.IMPORT_PACKAGE);
		if (oldPackages == null)
			return;
		BundleOrPackageList importedPackages = BundleOrPackageList.fromInput(oldPackages, mergable.getLineDelimiter(),
				"version");
		List<String> updatedPackages = new ArrayList<>();
		for (BundleOrPackage importedPackage : importedPackages.list()) {
			String packageName = importedPackage.getName();
			if (packageName.startsWith("org.eclipse.x")) {
				updatedPackages.add(packageName + ";version=\"" + newVersion + "\"");
			}
		}
		mergable.addImportedPackages(updatedPackages.toArray(new String[0]), true);
	}

	private static void updateExportedPackages(MergeableManifest2 mergable, String newVersion) {
		String oldPackages = mergable.getMainAttributes().get(MergeableManifest2.EXPORT_PACKAGE);
		if (oldPackages == null)
			return;
		BundleOrPackageList exportedPackages = BundleOrPackageList.fromInput(oldPackages, mergable.getLineDelimiter(),
				"version");
		List<String> updatedPackages = new ArrayList<>();
		for (BundleOrPackage exportedPackage : exportedPackages.list()) {
			String packageName = exportedPackage.getName();
			updatedPackages.add(packageName + ";version=\"" + newVersion + "\"");
		}
		mergable.addExportedPackages(updatedPackages.toArray(new String[0]), true);
	}
}
