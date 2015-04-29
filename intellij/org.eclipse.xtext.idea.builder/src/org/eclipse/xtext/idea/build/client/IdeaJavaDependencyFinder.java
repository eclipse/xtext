package org.eclipse.xtext.idea.build.client;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.incremental.IJavaDependencyFinder;
import org.jetbrains.jps.builders.java.dependencyView.ClassRepr;
import org.jetbrains.jps.builders.java.dependencyView.Mappings;
import org.jetbrains.jps.cmdline.ProjectDescriptor;
import org.jetbrains.jps.incremental.CompileContext;

import com.google.common.base.Function;

public class IdeaJavaDependencyFinder implements IJavaDependencyFinder {
	
	private static final Logger LOG = Logger.getLogger(IdeaJavaDependencyFinder.class);
	
	private CompileContext context;

	public IdeaJavaDependencyFinder(CompileContext context) {
		this.context = context;
	}
	
	@Override
	public Iterable<URI> getDependentJavaFiles(final Iterable<URI> javaSources) {
		Set<URI> result = newHashSet();
		ProjectDescriptor projectDescriptor = context.getProjectDescriptor();
		Mappings globalMappings = projectDescriptor.dataManager.getMappings();
		Set<URI> processed = newHashSet(javaSources);
		Queue<String> sourceFiles = newLinkedList(transform(javaSources, new Function<URI, String>() {
			@Override
			public String apply(URI uri) {
				return asPath(uri);
			}
		}));
		while(!sourceFiles.isEmpty()) {
			String sourceFile = sourceFiles.poll();
			Set<ClassRepr> classFiles = globalMappings.getClasses(sourceFile);
			for (ClassRepr classFile : classFiles) {
				// UsageRepr is package private, so we have to use reflection here.
				// As Xtend cannot be convinced to not generate a local var, this class is in Java
				Set<? extends Object> usages = classFile.getUsages();
				for (Object usage : usages) {
					try {
						int dependent = getUsageOwner(usage);
						Iterable<File> dependentSources = globalMappings.getClassSources(dependent);
						for(File dependentSource: dependentSources) {
							URI dependentURI = asURI(dependentSource);
							if(processed.add(dependentURI)) {
								result.add(dependentURI);
								sourceFiles.offer(asPath(dependentURI));
							}
						}
					} catch (Exception exc) {
						LOG.error("Error calling getOwner()", exc);
					}
				}
			}
		}
		return result;
	}
	
	private int getUsageOwner(Object usage) throws Exception {
		Method method = usage.getClass().getMethod("getOwner");
		method.setAccessible(true);
		return ((Integer) method.invoke(usage)).intValue();
	}

}