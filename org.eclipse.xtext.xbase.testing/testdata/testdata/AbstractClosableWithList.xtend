package testdata

import java.util.List
import java.util.ArrayList

abstract class AbstractClosableWithList implements AutoCloseable {
	package List<String> list;

	new() {
		list = new ArrayList
		list.add("new")
	}

	def void add(String entry) {
		list.add(entry)
	}

	def List<String> getList() {
		return list
	}

	def printList() {
		return list.toString
	}
}

class ClosableWithList extends AbstractClosableWithList {

	new() {
	}
	
	new(List<String> collector) {
		collector.addAll(list)
		this.list = collector
	}

	override close() {
		list.add("close")
	}
}

class ClosableWithListExceptionOnConstr extends ClosableWithList {

	new() throws InstantiationException {
		list.add("new")
		throw new InstantiationException
	}
}

class ClosableWithListExceptionOnClose extends AbstractClosableWithList {

	override close() throws CloseException {
		list.add("close")
		throw new CloseException
	}
}

class ClosableWithListExceptionOnAdd extends ClosableWithList {

	def void addExc() throws TryBodyException {
		list.add("exception")
		throw new TryBodyException
	}

}

class TryBodyException extends Exception {
	val text = "Exception in try (with resources) body"

	def getText() {
		return text
	}
}
