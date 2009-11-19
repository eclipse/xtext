package org.eclipse.xtext.builder.impl;


import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;
import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.BuilderModule;
import org.eclipse.xtext.builder.builderState.BuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateManager;
import org.eclipse.xtext.builder.builderState.Container;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ResourceIndexerTest extends TestCase {
	
	private static final String EXT = "buildertestlanguage";
	private ResourceIndexer indexer;
	private BuilderStateManager stateManager;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Injector injector = Guice.createInjector(new BuilderModule());
		indexer = injector.getInstance(ResourceIndexer.class);
		stateManager = injector.getInstance(BuilderStateManager.class);
	}
	
	public void testSimpleAdd() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addSourceFolder(project, "src");
		IFile file1 = createFile("/foo/bar."+EXT, "namespace foo { object bar }");
		
		indexer.updateExportedElements(file1);
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {

			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(1,state.getContainers().size());
				Container container = state.getContainers().get(0);
				
				assertEquals("foo", container.getName());
				assertEquals("foo", container.getProject());
				
				return null;
			}});
	}
	
	public void testSimpleUpdate() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addSourceFolder(project, "src");
		IFile file1 = createFile("/foo/bar."+EXT, "namespace foo { object bar }");
		
		indexer.updateExportedElements(file1);
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {
			
			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(1,state.getContainers().size());
				Container container = state.getContainers().get(0);
				
				assertEquals("foo", container.getName());
				assertEquals("foo", container.getProject());
				
				return null;
			}});
		
		file1.setContents(new StringInputStream("namespace foo2 { object bar2 }"), true, true, monitor());
		
		indexer.updateExportedElements(file1);
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {
			
			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(1,state.getContainers().size());
				Container container = state.getContainers().get(0);
				
				assertEquals("foo", container.getName());
				assertEquals("foo", container.getProject());
				
				assertEquals("foo2",container.getResourceDescriptors().get(0).getEObjectDescriptions().get(1).getName());
				assertEquals("bar2",container.getResourceDescriptors().get(0).getEObjectDescriptions().get(0).getName());
				return null;
			}});
	}
}
