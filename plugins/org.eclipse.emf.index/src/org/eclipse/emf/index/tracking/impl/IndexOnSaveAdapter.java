package org.eclipse.emf.index.tracking.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;

import com.google.inject.Inject;

public class IndexOnSaveAdapter extends AdapterImpl {

	private ResourceIndexer resourceIndexer;
	private IndexFeeder indexFeeder;

	@Inject 
	public IndexOnSaveAdapter(ResourceIndexer resourceIndexer,
			IndexFeeder indexFeeder) {
		this.resourceIndexer = resourceIndexer;
		this.indexFeeder = indexFeeder;
	}
	
	@Override
	public void setTarget(Notifier newTarget) {
		if(newTarget instanceof Resource) 
			super.setTarget(newTarget);
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type.equals(IndexOnSaveAdapter.class);
	}
	
	@Override
	public void notifyChanged(Notification msg) {
		super.notifyChanged(msg);
		int featureID = msg.getFeatureID(Resource.class);
		if(featureID == Resource.RESOURCE__IS_MODIFIED &&
				msg.getOldBooleanValue() && ! msg.getNewBooleanValue()) {
			resourceIndexer.resourceChanged(((Resource) msg.getNotifier()).getURI(), indexFeeder);
		}
	}
	
}
