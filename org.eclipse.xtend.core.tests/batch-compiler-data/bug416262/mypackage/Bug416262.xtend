package mypackage

import java.util.concurrent.Future

import static java.util.concurrent.Executors.*

class Bug416262 {
	def <R> void createDelete(() => R create) {
		val pool = newCachedThreadPool
		val Iterable<Future<R>> creates = (0 ..< 3).map[
			pool.submit[|create.apply]
		]
	}
}