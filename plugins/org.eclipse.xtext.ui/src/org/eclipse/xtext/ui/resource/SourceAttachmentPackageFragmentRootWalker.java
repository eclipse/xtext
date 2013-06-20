package org.eclipse.xtext.ui.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ExternalPackageFragmentRoot;

import com.google.common.collect.Sets;

/**
 * @since 2.4
 */
abstract class SourceAttachmentPackageFragmentRootWalker<T> extends PackageFragmentRootWalker<T> {

	private final static Logger LOG = Logger.getLogger(SourceAttachmentPackageFragmentRootWalker.class);

	private static final Pattern COMMA = Pattern.compile(",");

	private Set<Pattern> binIncludePatterns;
	private boolean visitAll;
	private String bundleSymbolicName;

	public String getBundleSymbolicName() {
		return bundleSymbolicName;
	}

	/**
	 * Also traverse the source attachment's folder's bin includes, if it's an attachment for a bundle.
	 */
	@Override
	public T traverse(IPackageFragmentRoot root, boolean stopOnFirstResult) throws JavaModelException {
		try {
			bundleSymbolicName = null;
			// Determine the bundle name from the manifest.
			//
			IPath path = root.isExternal() ? root.getPath() : root.getUnderlyingResource().getLocation();
			if (path != null) {
				if ("jar".equals(path.getFileExtension())) {
					try {
						final File file = path.toFile();
						if (file != null && file.exists()) {
							JarFile jarFile = new JarFile(file);
							try {
								Manifest manifest = jarFile.getManifest();
								if (manifest != null)
									bundleSymbolicName = getBundleSymbolicName(manifest);
							} finally {
								jarFile.close();
							}
						}
					} catch (IOException e) {
						LOG.error(e.getMessage(), e);
					}
				}
			}

			IPath sourceAttachmentPath = root.getSourceAttachmentPath();
			if (sourceAttachmentPath != null && sourceAttachmentPath.isPrefixOf(path)) {
				// This is not a package fragment root we can actually walk because it's not on the project's class path.
				//
				IPackageFragmentRoot packageFragmentRoot = root.getJavaProject().getPackageFragmentRoot(
						sourceAttachmentPath.toOSString());
				if (packageFragmentRoot instanceof ExternalPackageFragmentRoot) {
					// This lets us determine the linked resource for this attachement
					//
					IResource resource = ((ExternalPackageFragmentRoot) packageFragmentRoot).resource();
					if (resource instanceof IFolder) {
						IFolder folder = (IFolder) resource;

						// Use the build.properties to determine which resources are destined for the deployed bundle.
						//
						IFile buildPropertiesFile = folder.getFile("build.properties");
						if (buildPropertiesFile.exists()) {
							Properties buildProperties = new Properties();
							try {
								loadBuildProperties(buildPropertiesFile, buildProperties);
								// Process the bin includes entries.
								//
								String binIncludes = buildProperties.getProperty("bin.includes");
								if (binIncludes != null) {
									binIncludePatterns = Sets.newHashSet();
									for (String binInclude : COMMA.split(binIncludes)) {
										// For any entry that specifies a source, ignore that entry.
										//
										if (buildProperties.get("source." + binInclude) == null) {
											// Normalize the Ant pattern.
											// If any patterns start with ** we are forced to visit the whole tree.
											// I don't expect any bundle would actually do that, i.e., it's nonsense for the bin includes...
											//
											if (binInclude.endsWith("/")) {
												binInclude += "**";
											}
											if (binInclude.startsWith("/")) {
												binInclude = "**" + binInclude;
												visitAll = true;
											} else if (binInclude.startsWith("**")) {
												visitAll = true;
											}

											// Convert the normalized pattern to a regular expression.
											//
											String binIncludePattern = Pattern.quote(binInclude);
											if (binIncludePattern.contains("**")) {
												binIncludePattern = binIncludePattern.replace("**", "\0")
														.replace("*", "\\E[^/]*\\Q").replace("\0", "\\E.*\\Q");
											} else if (binIncludePattern.contains("*")) {
												binIncludePattern = binIncludePattern.replace("*", "\\E[^/]*\\Q");
											}

											// Keep a collection of all the bin include patterns.
											//
											binIncludePatterns.add(Pattern.compile(binIncludePattern));
										}
									}

									// Determine the bundle name from the manifest.
									//
									File manifestFile = sourceAttachmentPath.append("META-INF/MANIFEST.MF").toFile();
									if (manifestFile.exists()) {
										InputStream inputStream = null;
										try {
											inputStream = new FileInputStream(manifestFile);
											Manifest manifest = new Manifest(inputStream);
											bundleSymbolicName = getBundleSymbolicName(manifest);
										} finally {
											if (inputStream != null)
												inputStream.close();
										}
									}

									// Traverse the folder; the traversal is guarded to visit only the bin includes.
									//
									TraversalState state = new TraversalState(folder);
									T result = traverse(folder, stopOnFirstResult, state);
									if (stopOnFirstResult && result != null) {
										return result;
									}
								}

							} catch (Exception e) {
								LOG.error(e.getMessage(), e);
							}
						}
					}
				}
			}
			return super.traverse(root, stopOnFirstResult);
		} finally {
			// Clear the state that's cached during this traversal.
			//
			visitAll = false;
			binIncludePatterns = null;
		}
	}

	protected void loadBuildProperties(IFile buildPropertiesFile, Properties result) throws CoreException, IOException {
		InputStream buildPropertiesContents = buildPropertiesFile.getContents(true);
		result.load(buildPropertiesContents);
		buildPropertiesContents.close();
	}

	private static final int YES = 1;
	private static final int MAYBE = 0;
	private static final int NO = -1;

	/**
	 * Determine if the entry is for sure in the bin includes, maybe in the bin includes, or definitely not in the bin
	 * includes.
	 */
	protected int isBinInclude(String path) {
		for (Pattern pattern : binIncludePatterns) {
			if (pattern.matcher(path.toString()).matches()) {
				return YES;
			}
		}
		return visitAll ? MAYBE : NO;
	}

	public T traverse(IFolder folder, boolean stopOnFirstResult, TraversalState state) {
		T result = null;
		try {
			IPath path = new Path("");
			List<?> parents = state.getParents();
			for (int i = 1, count = parents.size(); i < count; ++i) {
				path = path.append(((IFolder) parents.get(i)).getName());
			}
			for (IResource resource : folder.members()) {
				switch (resource.getType()) {
					case IResource.FOLDER: {
						// If something in this folder might be in the bin includes, traverse it.
						//
						if (isBinInclude(path.append(resource.getName()).toString() + "/") != NO) {
							state.push(resource);
							result = traverse((IFolder) resource, stopOnFirstResult, state);
							state.pop();
						}
						break;
					}
					case IResource.FILE: {
						// If the file is definitely in the bin includes, handle it.
						//
						if (isBinInclude(path.append(resource.getName()).toString()) == YES) {
							result = handle((IFile) resource, state);
						}
						break;
					}
				}
				if (stopOnFirstResult && result != null) {
					break;
				}
			}
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
		}
		return result;
	}

	protected boolean isValid(URI uri, IStorage storage) {
		return uri != null;
	}

	protected T handle(IFile file, TraversalState state) {
		URI uri = getURI(file, state);
		if (isValid(uri, file)) {
			return handle(getLogicalURI(uri, file, state), file, state);
		}
		return null;
	}

	/**
	 * Converts the physical URI to a logic URI based on the bundle symbolic name.
	 */
	protected URI getLogicalURI(URI uri, IStorage storage, TraversalState state) {
		if (bundleSymbolicName != null) {
			URI logicalURI = URI.createPlatformResourceURI(bundleSymbolicName, false);
			List<?> parents = state.getParents();
			for (int i = 1; i < parents.size(); i++) {
				Object obj = parents.get(i);
				if (obj instanceof IPackageFragment) {
					logicalURI = logicalURI.appendSegments(((IPackageFragment) obj).getElementName().split("\\."));
				} else if (obj instanceof IJarEntryResource) {
					logicalURI = logicalURI.appendSegment(((IJarEntryResource) obj).getName());
				} else if (obj instanceof IFolder) {
					logicalURI = logicalURI.appendSegment(((IFolder) obj).getName());
				}
			}
			return logicalURI.appendSegment(uri.lastSegment());
		}
		return uri;
	}

	/**
	 * Delegate to
	 * {@link #handle(URI, IStorage, org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState)}.
	 */
	@Override
	protected T handle(IJarEntryResource jarEntry, TraversalState state) {
		URI uri = getURI(jarEntry, state);
		if (isValid(uri, jarEntry)) {
			return handle(getLogicalURI(uri, jarEntry, state), jarEntry, state);
		}
		return null;
	}

	/**
	 * Extracts the bundle name from the manifest.
	 */
	private String getBundleSymbolicName(Manifest manifest) {
		String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
		if (name != null) {
			final int indexOf = name.indexOf(';');
			if (indexOf > 0)
				name = name.substring(0, indexOf);
			return name;
		}
		return null;
	}

	/**
	 * Determine the URI for this file.
	 */
	protected URI getURI(IFile file, TraversalState state) {
		return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}

	/**
	 * Determine the URI for this jar entry.
	 */
	protected abstract URI getURI(IJarEntryResource jarEntry, TraversalState state);

	/**
	 * Handle this URI, where the storage is either a jar entry from the classpath or an IFile in the bundle's bin
	 * includes.
	 */
	protected abstract T handle(URI uri, IStorage storage, TraversalState state);

}
