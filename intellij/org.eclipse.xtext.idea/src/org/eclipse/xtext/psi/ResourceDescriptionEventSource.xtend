package org.eclipse.xtext.psi

import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.util.messages.MessageBusConnection
import com.intellij.util.messages.Topic
import org.eclipse.xtext.resource.IResourceDescription.Event
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener
import org.eclipse.xtext.resource.IResourceDescription.Event.Source

abstract class ResourceDescriptionEventSource implements Source {

	static def Source getInstance(Project project) {
		project.getComponent(ResourceDescriptionEventSource)
	}
}

class ResourceDescriptionEventSourceImpl extends ResourceDescriptionEventSource implements Disposable {

	static val TOPIC = Topic.create(ResourceDescriptionEventSourceImpl.simpleName, Listener)

	val Project project

	val connects = <Listener, MessageBusConnection>newHashMap

	new(Project project) {
		this.project = project
		Disposer.register(project, this);
	}

	override synchronized addListener(Listener listener) {
		val connect = project.messageBus.connect(this)
		connect.subscribe(TOPIC, listener)
		connects.put(listener, connect)
	}

	override synchronized removeListener(Listener listener) {
		val connect = connects.remove(listener)
		if (connect != null) {
			connect.disconnect
		}
	}

	override notifyListeners(Event event) {
		project.messageBus.syncPublisher(TOPIC).descriptionsChanged(event)
	}

	override synchronized dispose() {
		connects.clear
	}

}