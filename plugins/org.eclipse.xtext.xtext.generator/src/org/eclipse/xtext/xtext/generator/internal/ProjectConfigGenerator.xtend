/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.internal

import java.io.Closeable
import java.util.ArrayList
import java.io.FileWriter
import java.io.File

/**
 * A utility class for generating XtextProjectConfig. Not intended to be used outside of this project.
 */
class ProjectConfigGenerator {
	
	static val INTERFACE_NAME = 'org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig'
	static val IMPL_NAME = 'org.eclipse.xtext.xtext.generator.model.XtextProjectConfig'
	
	static val PROJECTS = #[
		'runtime', 'runtimeTest', 'genericIde', 'genericIdeTest', 'eclipsePlugin', 'eclipsePluginTest',
		'ideaPlugin', 'ideaPluginTest', 'web', 'webTest'
	]
	
	static def void main(String[] args) {
		val closeables = new ArrayList<Closeable>
		try {
			val interfaceWriter = new FileWriter('src' + File.separator + INTERFACE_NAME.replace('.', File.separator) + '.java')
			closeables += interfaceWriter
			val implWriter = new FileWriter('src' + File.separator + IMPL_NAME.replace('.', File.separator) + '.java')
			closeables += implWriter
			
			val generator = new ProjectConfigGenerator
			interfaceWriter.write(generator.generateInterface().toString)
			implWriter.write(generator.generateImpl().toString)
			
		} catch (Throwable t) {
			t.printStackTrace()
		} finally {
			closeables.forEach[close()]
		}
	}
	
	def generateInterface() '''
		/*******************************************************************************
		 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
		 * All rights reserved. This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *******************************************************************************/
		package «INTERFACE_NAME.substring(0, INTERFACE_NAME.lastIndexOf('.'))»;
		
		import org.eclipse.xtext.generator.IFileSystemAccess2;
		import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
		
		/**
		 * Inject an instance of this interface in order to generate code in a generator fragment.
		 *
		 * <p>This file has been generated with {@link «ProjectConfigGenerator.name»}.</p>
		 */
		public interface «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» extends IGuiceAwareGeneratorComponent {
			
			«FOR p : PROJECTS»
				IFileSystemAccess2 get«p.toFirstUpper»Src();
				IFileSystemAccess2 get«p.toFirstUpper»SrcGen();
				ManifestAccess get«p.toFirstUpper»Manifest();
				TextFileAccess get«p.toFirstUpper»PluginXml();
				
			«ENDFOR»
			IFileSystemAccess2 getOrionJsGen();
			IFileSystemAccess2 getAceJsGen();
			
		}
	'''
	
	def generateImpl() '''
		/*******************************************************************************
		 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
		 * All rights reserved. This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *******************************************************************************/
		package «IMPL_NAME.substring(0, IMPL_NAME.lastIndexOf('.'))»;
		
		import com.google.inject.Injector;
		import org.eclipse.xtext.generator.IFileSystemAccess2;
		
		/**
		 * Use this class to configure output paths in the XtextGenerator.
		 *
		 * <p>This file has been generated with {@link «ProjectConfigGenerator.name»}.</p>
		 */
		public class «IMPL_NAME.substring(IMPL_NAME.lastIndexOf('.') + 1)» implements «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» {
			
			«FOR p : PROJECTS»
				private FileSystemAccess «p»Src;
				private FileSystemAccess «p»SrcGen;
				private ManifestAccess «p»Manifest;
				private TextFileAccess «p»PluginXml;
			«ENDFOR»
			private FileSystemAccess orionJsGen;
			private FileSystemAccess aceJsGen;
			
			@Override
			public void initialize(Injector injector) {
				injector.injectMembers(this);
				«FOR p : PROJECTS»
					if («p»Src != null) {
						«p»Src.initialize(injector);
					}
					if («p»SrcGen != null) {
						«p»SrcGen.initialize(injector);
					}
				«ENDFOR»
				if (orionJsGen != null) {
					orionJsGen.initialize(injector);
				}
				if (aceJsGen != null) {
					aceJsGen.initialize(injector);
				}
			}
			
			«FOR p : PROJECTS»
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»Src() {
					return «p»Src;
				}
				
				public void set«p.toFirstUpper»Src(String path) {
					this.«p»Src = new FileSystemAccess(path);
				}
				
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»SrcGen() {
					return «p»SrcGen;
				}
				
				public void set«p.toFirstUpper»SrcGen(String path) {
					this.«p»SrcGen = new FileSystemAccess(path);
				}
				
				@Override
				public ManifestAccess get«p.toFirstUpper»Manifest() {
					return «p»Manifest;
				}
				
				public void set«p.toFirstUpper»Manifest(ManifestAccess manifest) {
					this.«p»Manifest = manifest;
				}
				
				public void set«p.toFirstUpper»PluginXml(String path) {
					if (path != null) {
						this.«p»PluginXml = new TextFileAccess();
						this.«p»PluginXml.setPath(path);
					} else {
						this.«p»PluginXml = null;
					}
				}
				
				@Override
				public TextFileAccess get«p.toFirstUpper»PluginXml() {
					return this.«p»PluginXml;
				}
				
			«ENDFOR»
			@Override
			public IFileSystemAccess2 getOrionJsGen() {
				return orionJsGen;
			}
			
			public void setOrionJsGen(String path) {
				this.orionJsGen = new FileSystemAccess(path);
			}
			
			@Override
			public IFileSystemAccess2 getAceJsGen() {
				return aceJsGen;
			}
			
			public void setAceJsGen(String path) {
				this.aceJsGen = new FileSystemAccess(path);
			}
			
		}
	'''
	
}