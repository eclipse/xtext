package org.eclipse.xtend.core.macro.fsaccess

import java.io.Closeable

import static extension com.google.common.io.Closeables.*

class IOUtils {

	def static <T, C extends Closeable> T tryWith(()=>C provider, (C)=>T consumer) {
		var closeable = null as C
		try {
			closeable = provider.apply()
			return consumer.apply(closeable)
		} finally {
			closeable.closeQuietly
		}
	}

	def static <C extends Closeable> tryWith(()=>C provider, (C)=>void consumer) {
		var closeable = null as C
		try {
			closeable = provider.apply()
			consumer.apply(closeable)
		} finally {
			closeable.closeQuietly
		}
	}

}
