package testdata

package abstract class AbstractIntrospectableClosable implements AutoCloseable {
	package boolean isOpen;

	new() {
		isOpen = true;
	}

	def isOpen() {
		return isOpen
	}
}

class IntrospectableClosableExceptionsConstructor extends AbstractIntrospectableClosable {

	new() throws InstantiationException {
		isOpen = true;
		throw new InstantiationException()
	}

	override close() {
		isOpen = false;
	}
}

class IntrospectableClosableExceptionsClose extends AbstractIntrospectableClosable {

	override void close() throws CloseException{
		isOpen = false;
		throw new CloseException
	}
}

class IntrospectableClosable extends AbstractIntrospectableClosable {

	override close() {
		isOpen = false
	}
}

class CloseException extends Exception {
	val text = "Exception on close"

	def getText() {
		return text
	}
}
