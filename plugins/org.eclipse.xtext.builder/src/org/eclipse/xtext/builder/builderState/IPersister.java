package org.eclipse.xtext.builder.builderState;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

@ImplementedBy(IPersister.DefaultImpl.class)
public interface IPersister {
	void load(Resource state);
	void save(Resource state);
	
	public class DefaultImpl implements IPersister {
		
		private final static Logger log = Logger.getLogger(org.eclipse.xtext.builder.builderState.IPersister.DefaultImpl.class);

		public void load(Resource state) {
			try {
				state.load(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}

		public void save(Resource state) {
			try {
				state.save(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		
	}
}
