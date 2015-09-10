package org.eclipse.xtend.core.macro

import com.google.common.io.ByteStreams
import com.google.common.io.CharStreams
import com.google.inject.Inject
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.net.URL
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.generator.IFilePostProcessor
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider

import static org.eclipse.emf.ecore.resource.URIConverter.*
import static org.eclipse.xtend.lib.macro.file.Path.*

import static extension org.eclipse.xtext.util.UriUtil.*
import java.net.MalformedURLException
import java.net.URISyntaxException

abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {

	@Inject @Accessors IEncodingProvider encodingProvider
	@Inject(optional=true) @Accessors IFilePostProcessor postProcessor
	@Inject @Accessors extension IWorkspaceConfigProvider workspaceConfigProvider
	@Accessors ResourceSet context
	
	override CharSequence getContents(Path path) {
		try {
			val reader = new InputStreamReader(path.contentsAsStream, path.getCharset)
			var IOException threw = null
			try {
				return CharStreams.toString(reader)
			} catch(IOException e) {
				threw = e;
			} finally {
				try {
					reader.close
				} catch(IOException e) {
					if (threw === null)
						threw = e
				}
			}
			if (threw === null) {
				throw new AssertionError("threw cannot be null here")
			}
			throw threw
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)	
		}
	}
	
	override void setContents(Path path, CharSequence contents) {
		val uri = path.URI
		if (uri === null)
			throw new IllegalArgumentException('The file cannot be found: ' + path)

		val processedContents = postProcessor?.postProcess(uri, contents) ?: contents
		try {
			path.setContentsAsStream(new StringInputStream(processedContents.toString, path.getCharset))
		} catch (UnsupportedEncodingException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	override setContentsAsStream(Path path, InputStream source) {
		val uri = path.URI
		if (uri === null)
			throw new IllegalArgumentException('The file cannot be found: ' + path)
		try {
			if (uri.exists && isFile(uri)) {
				if (source.markSupported) {
					if (!hasContentsChanged(source, path.contentsAsStream))
						return;
						
					source.reset
				}
			}
		
			val out = URIConverter.createOutputStream(uri)
			try {
				ByteStreams.copy(source, out)
			} finally {
				out.close
			}
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	// TODO consider extracting common logic from here and EclipseResourceFileSystemAccess2
	protected def hasContentsChanged(InputStream newContent, InputStream oldContent) {
		var contentChanged = false;
		try {
			var int newByte = newContent.read();
			var int oldByte = oldContent.read();
			while (newByte != -1 && oldByte != -1 && newByte == oldByte) {
				newByte = newContent.read();
				oldByte = oldContent.read();
			}
			contentChanged = newByte != oldByte;
		} catch (IOException e) {
			contentChanged = true;
		} finally {
			if (oldContent !== null) {
				try {
					oldContent.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return contentChanged;
	}

	override getChildren(Path path) {
		if (path == ROOT) {
			return context.workspaceConfig.projects.map[path.getAbsolutePath(name)].filter[exists]
		}
		val uri = path.URI
		if (uri === null || !uri.exists || !uri.folder)
			return emptyList
			
		return uri.getChildren(path)
	}
	
	protected def Iterable<? extends Path> getChildren(URI uri, Path path)
	
	override mkdir(Path path) {
		// Do nothing
	}
	
	override getContentsAsStream(Path path) {
		val uri = path.URI
		if (uri === null || !uri.exists || !isFile(uri))
			throw new IllegalArgumentException('The file cannot be found: ' + path)
		
		try {
			return URIConverter.createInputStream(uri)
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	override delete(Path path) {
		val uri = path.URI
		if (uri === null)
			return;
			
		if (uri.folder && !uri.getChildren(path).empty)
			return;

		try {
			URIConverter.delete(uri, null)
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	override exists(Path path) {
		if (path == ROOT)
			return true

		path.URI.exists
	}
	
	protected def exists(URI uri) {
		if (uri === null)
			false
		else
			URIConverter.exists(uri, null)
	}

	override getCharset(Path path) {
		path.URI.charset
	}

	protected def getCharset(URI uri) {
		encodingProvider.getEncoding(uri)
	}

	override getLastModification(Path path) {
		path.URI.lastModification
	}
	
	protected def getLastModification(URI uri) {
		val timeStamp = uri.getAttribute(ATTRIBUTE_TIME_STAMP)
		if (timeStamp instanceof Long)
			timeStamp
		else
			0L
	}

	override isFile(Path path) {
		isFile(path.URI)
	}
	
	protected def isFile(URI uri) {
		val directory = uri.getAttribute(ATTRIBUTE_DIRECTORY)
		if (directory instanceof Boolean)
			!directory
		else
			false
	}

	override isFolder(Path path) {
		path.URI.folder
	}
	
	protected def isFolder(URI uri) {
		val directory = uri.getAttribute(ATTRIBUTE_DIRECTORY)
		if (directory instanceof Boolean)
			directory
		else
			false
	}

	override toURI(Path path) {
		val uri = path.URI
		if (uri !== null)
			uri.toURI
	}
	
	protected def toURI(URI uri) {
		try {
			new URL(uri.toString).toURI
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e.message, e)
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e.message, e)
		}
	}

	protected def getURI(Path path) {
		if(path === null) return null

		val workspaceConfig = context.workspaceConfig
		if (workspaceConfig === null) return null

		val moduleName = path.segments.head
		if (moduleName === null) return null

		val projectConfig = workspaceConfig.findProjectByName(moduleName)
		if (projectConfig === null) return null

		val projectURI = projectConfig.path
		val segments = path.segments.tail
		if (segments.empty)
			return projectURI

		val relativeURI = URI.createURI(segments.head).appendSegments(segments.tail)
		val uri = relativeURI.resolve(projectURI)
		if (uri.folder)
			return uri.toFolderURI

		return uri
	}

	protected def getAttribute(URI uri, String attributeName) {
		if (uri === null) return null
		val options = newHashMap
		options.put(OPTION_REQUESTED_ATTRIBUTES, #{attributeName})
		URIConverter.getAttributes(uri, options).get(attributeName)
	}

	protected def getURIConverter() {
		context.URIConverter
	}

	def Path getPath(Resource res) {
		res.URI.getPath(res.resourceSet)
	}
	
	protected def getPath(URI uri, ResourceSet context) {
		val workspaceConfig = context.workspaceConfig
		if(workspaceConfig === null) return null

		val projectConfig = workspaceConfig.findProjectContaining(uri)
		if (projectConfig === null) return null

		return uri.getPath(projectConfig.path, ROOT.append(projectConfig.name))
	}

	protected def getPath(URI absoluteURI, URI baseURI, Path basePath) {
		val relativeURI = absoluteURI.deresolve(baseURI)
		if (relativeURI.empty || relativeURI == absoluteURI)
			return null
		
		basePath.getAbsolutePath(relativeURI.toString)
	}

}
