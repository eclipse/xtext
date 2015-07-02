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
		
		/**
		 * Inject an instance of this interface in order to generate code in a generator fragment.
		 *
		 * <p>This file has been generated with {@link «ProjectConfigGenerator.name»}.</p>
		 */
		public interface «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» {
			
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
		
		import com.google.inject.Inject;
		import org.eclipse.xtext.generator.IFileSystemAccess2;
		import org.eclipse.xtext.parser.IEncodingProvider;
		
		/**
		 * Use this class to configure output paths in the XtextGenerator.
		 *
		 * <p>This file has been generated with {@link «ProjectConfigGenerator.name»}.</p>
		 */
		public class «IMPL_NAME.substring(IMPL_NAME.lastIndexOf('.') + 1)» implements «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» {
			
			@Inject private IEncodingProvider encodingProvider;
			
			«FOR p : PROJECTS»
				private String «p»SrcPath;
				private String «p»SrcGenPath;
				private ManifestAccess «p»ManifestAccess;
				private TextFileAccess «p»PluginXmlAccess;
			«ENDFOR»
			private String orionJsGenPath;
			private String aceJsGenPath;
			
			public void initialize() {
			}
			
			«FOR p : PROJECTS»
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»Src() {
					if («p»SrcPath != null)
						return new FileSystemAccess(«p»SrcPath, encodingProvider);
					else
						return null;
				}
				
				public void set«p.toFirstUpper»Src(String path) {
					this.«p»SrcPath = path;
				}
				
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»SrcGen() {
					if («p»SrcGenPath != null)
						return new FileSystemAccess(«p»SrcGenPath, encodingProvider);
					else
						return null;
				}
				
				public void set«p.toFirstUpper»SrcGen(String path) {
					this.«p»SrcGenPath = path;
				}
				
				@Override
				public ManifestAccess get«p.toFirstUpper»Manifest() {
					return «p»ManifestAccess;
				}
				
				public void set«p.toFirstUpper»Manifest(ManifestAccess manifest) {
					this.«p»ManifestAccess = manifest;
				}
				
				public void set«p.toFirstUpper»PluginXml(String path) {
					if (path != null) {
						this.«p»PluginXmlAccess = new TextFileAccess();
						this.«p»PluginXmlAccess.setPath(path);
					} else {
						this.«p»PluginXmlAccess = null;
					}
				}
				
				@Override
				public TextFileAccess get«p.toFirstUpper»PluginXml() {
					return this.«p»PluginXmlAccess;
				}
				
			«ENDFOR»
			@Override
			public IFileSystemAccess2 getOrionJsGen() {
				if (orionJsGenPath != null)
					return new FileSystemAccess(orionJsGenPath, encodingProvider);
				else
					return null;
			}
			
			public void setOrionJsGen(String path) {
				this.orionJsGenPath = path;
			}
			
			@Override
			public IFileSystemAccess2 getAceJsGen() {
				if (aceJsGenPath != null)
					return new FileSystemAccess(aceJsGenPath, encodingProvider);
				else
					return null;
			}
			
			public void setAceJsGen(String path) {
				this.aceJsGenPath = path;
			}
			
		}
	'''
	
}