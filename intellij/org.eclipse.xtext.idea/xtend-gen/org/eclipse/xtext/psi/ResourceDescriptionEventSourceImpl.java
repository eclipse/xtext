package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.util.messages.Topic;
import java.util.HashMap;
import org.eclipse.xtext.psi.ResourceDescriptionEventSource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ResourceDescriptionEventSourceImpl extends ResourceDescriptionEventSource implements Disposable {
  private final static Topic<IResourceDescription.Event.Listener> TOPIC = Topic.<IResourceDescription.Event.Listener>create(ResourceDescriptionEventSourceImpl.class.getSimpleName(), IResourceDescription.Event.Listener.class);
  
  private final Project project;
  
  private final HashMap<IResourceDescription.Event.Listener, MessageBusConnection> connects = CollectionLiterals.<IResourceDescription.Event.Listener, MessageBusConnection>newHashMap();
  
  public ResourceDescriptionEventSourceImpl(final Project project) {
    this.project = project;
    Disposer.register(project, this);
  }
  
  @Override
  public synchronized void addListener(final IResourceDescription.Event.Listener listener) {
    MessageBus _messageBus = this.project.getMessageBus();
    final MessageBusConnection connect = _messageBus.connect(this);
    connect.<IResourceDescription.Event.Listener>subscribe(ResourceDescriptionEventSourceImpl.TOPIC, listener);
    this.connects.put(listener, connect);
  }
  
  @Override
  public synchronized void removeListener(final IResourceDescription.Event.Listener listener) {
    final MessageBusConnection connect = this.connects.remove(listener);
    boolean _notEquals = (!Objects.equal(connect, null));
    if (_notEquals) {
      connect.disconnect();
    }
  }
  
  @Override
  public void notifyListeners(final IResourceDescription.Event event) {
    MessageBus _messageBus = this.project.getMessageBus();
    IResourceDescription.Event.Listener _syncPublisher = _messageBus.<IResourceDescription.Event.Listener>syncPublisher(ResourceDescriptionEventSourceImpl.TOPIC);
    _syncPublisher.descriptionsChanged(event);
  }
  
  @Override
  public synchronized void dispose() {
    this.connects.clear();
  }
}
