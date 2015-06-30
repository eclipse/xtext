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
		import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
		import org.eclipse.xtext.xtext.generator.model.ModuleAccess;
		import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
		
		public interface «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» {
			
			«FOR p : PROJECTS»
				IFileSystemAccess2 get«p.toFirstUpper»Src();
				IFileSystemAccess2 get«p.toFirstUpper»SrcGen();
				ManifestAccess get«p.toFirstUpper»Manifest();
				PluginXmlAccess get«p.toFirstUpper»PluginXml();
				ModuleAccess get«p.toFirstUpper»Module();
				
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
		import org.eclipse.xtext.xtext.generator.model.FileSystemAccess;
		import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
		import org.eclipse.xtext.xtext.generator.model.ModuleAccess;
		import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
		
		public class «IMPL_NAME.substring(IMPL_NAME.lastIndexOf('.') + 1)» implements «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» {
			
			@Inject private IEncodingProvider encodingProvider;
			
			«FOR p : PROJECTS»
				private FileSystemAccess «p»SrcAccess;
				private FileSystemAccess «p»SrcGenAccess;
				private ManifestAccess «p»ManifestAccess;
				private PluginXmlAccess «p»PluginXmlAccess;
				private ModuleAccess «p»ModuleAccess;
			«ENDFOR»
			private FileSystemAccess orionJsGenAccess;
			private FileSystemAccess aceJsGenAccess;
			
			«FOR p : PROJECTS»
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»Src() {
					return «p»SrcAccess;
				}
				
				public void set«p.toFirstUpper»Src(String path) {
					«p»SrcAccess = new FileSystemAccess(path, encodingProvider);
				}
				
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»SrcGen() {
					return «p»SrcGenAccess;
				}
				
				public void set«p.toFirstUpper»SrcGen(String path) {
					«p»SrcGenAccess = new FileSystemAccess(path, encodingProvider);
					«p»ModuleAccess = new ModuleAccess(«p»SrcGenAccess);
				}
				
				@Override
				public ManifestAccess get«p.toFirstUpper»Manifest() {
					return «p»ManifestAccess;
				}
				
				public void set«p.toFirstUpper»Manifest(String path) {
					«p»ManifestAccess = new ManifestAccess(path);
				}
				
				@Override
				public PluginXmlAccess get«p.toFirstUpper»PluginXml() {
					return «p»PluginXmlAccess;
				}
				
				public void set«p.toFirstUpper»PluginXml(String path) {
					«p»PluginXmlAccess = new PluginXmlAccess(path);
				}
				
				@Override
				public ModuleAccess get«p.toFirstUpper»Module() {
					return «p»ModuleAccess;
				}
				
			«ENDFOR»
			@Override
			public IFileSystemAccess2 getOrionJsGen() {
				return orionJsGenAccess;
			}
			
			public void setOrionJsGen(String path) {
				orionJsGenAccess = new FileSystemAccess(path, encodingProvider);
			}
			
			@Override
			public IFileSystemAccess2 getAceJsGen() {
				return aceJsGenAccess;
			}
			
			public void setAceJsGen(String path) {
				aceJsGenAccess = new FileSystemAccess(path, encodingProvider);
			}
			
		}
	'''
	
}