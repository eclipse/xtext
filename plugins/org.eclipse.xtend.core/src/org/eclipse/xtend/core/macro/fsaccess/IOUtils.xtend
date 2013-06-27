package org.eclipse.xtend.core.macro.fsaccess

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.ByteArrayInputStream
import java.io.Closeable
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.io.Reader
import java.io.StringWriter
import java.io.Writer
import java.net.URI

class IOUtils {

	def static <T, C extends Closeable> T tryWith(()=>C provider, (C)=>T consumer) {
		var closeable = null as C
		try {
			closeable = provider.apply()
			return consumer.apply(closeable)
		} finally {
			closeQuietly(closeable)
		}
	}

	def static <C extends Closeable> tryWith(()=>C provider, (C)=>void consumer) {
		var closeable = null as C
		try {
			closeable = provider.apply()
			consumer.apply(closeable)
		} finally {
			closeQuietly(closeable)
		}
	}

	def static String asString(InputStream inputStream) {
		val stringWriter = new StringWriter
		inputStream.copy(stringWriter)
		stringWriter.toString
	}

	def static copy(InputStream inputStream, Writer writer) {
		inputStream.getReader.copy(writer)
	}

	def static copy(Reader reader, Writer writer) {
		val char[] buffer = newCharArrayOfSize(4096);
		var count = 0;
		var n = 0;
		while (-1 != (n = reader.read(buffer))) {
			writer.write(buffer, 0, n);
			count = count + n;
		}
		return count;
	}

	def static <C extends Closeable> closeQuietly(C closeable) {
		try {
			if (closeable != null) {
				closeable.close
			}
		} catch (IOException e) {
			// ignore
		}
	}

	def static getFile(String path) {
		new File(path)
	}

	def static getFile(URI uri) {
		new File(uri)
	}

	def static getInputStream(File file) {
		new FileInputStream(file)
	}

	def static getOutputStream(File file) {
		new FileOutputStream(file)
	}

	def static getInputStream(byte[] bytes) {
		new ByteArrayInputStream(bytes)
	}

	def static getBuffered(InputStream inputStream) {
		new BufferedInputStream(inputStream)
	}

	def static getBuffered(OutputStream outputStream) {
		new BufferedOutputStream(outputStream)
	}

	def static getReader(InputStream inputStream) {
		new InputStreamReader(inputStream)
	}

	def static getBuffered(Reader reader) {
		new BufferedReader(reader)
	}

	def static getWriter(OutputStream outputStream) {
		new OutputStreamWriter(outputStream)
	}

	def static getBuffered(Writer writer) {
		new BufferedWriter(writer)
	}

}
