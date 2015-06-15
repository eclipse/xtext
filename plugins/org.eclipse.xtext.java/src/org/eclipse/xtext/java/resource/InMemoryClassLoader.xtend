package org.eclipse.xtext.java.resource

import java.io.ByteArrayInputStream
import java.io.InputStream
import java.net.URL
import java.net.URLConnection
import java.util.Map

class InMemoryClassLoader extends ClassLoader {
	
	Map<String, byte[]> classMap

	new(Map<String, byte[]> classMap, ClassLoader parent) {
		super(parent)
		this.classMap = classMap
	}

	override protected Class<?> findClass(String name) throws ClassNotFoundException {
		var byte[] bytes = classMap.get(name)
		if (bytes === null) {
			return super.findClass(name)
		} else {
			return defineClass(name, bytes, 0, bytes.length)
		}
	}

	override protected findResource(String path) {
		if (path.endsWith(".class")) {
			val className = pathToClassName(path)
			val bytes = classMap.get(className)
			if (bytes != null) {
				return new URL("in-memory", null, -1, path, [
					new URLConnection(it) {
						override void connect() {}

						override InputStream getInputStream() {
							return new ByteArrayInputStream(bytes)
						}
					}
				])
			}
		}
		return super.findResource(path)
	}
	
	protected def pathToClassName(String path) {
		if (path.endsWith(".class"))
			return path.substring(0, path.length - 6).replace("/", ".")
		else 
			return null
	}
}