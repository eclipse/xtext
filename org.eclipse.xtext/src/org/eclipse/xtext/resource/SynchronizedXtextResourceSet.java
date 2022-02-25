/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SynchronizedXtextResourceSet extends XtextResourceSet implements ISynchronizable<SynchronizedXtextResourceSet> {
	private final Object lock = new Object();

	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		synchronized (lock) {
			return super.getResource(uri, loadOnDemand);
		}
	}

	@Override
	public Resource createResource(URI uri) {
		synchronized (lock) {
			return super.createResource(uri);
		}
	}

	// Befriend the API tooling
	@Override
	public EList<Resource> getResources() {
		return super.getResources();
	}
	
	@Override
	protected void registerURI(Resource resource) {
		synchronized (lock) {
			super.registerURI(resource);
		}
	}
	
	@Override
	void updateURI(Resource resource, URI old, Map<URI, Resource> uriResourceMap) {
		synchronized (lock) {
			super.updateURI(resource, old, uriResourceMap);
		}
	}
	
	/**
	 * Returns a synchronization lock that works for the complete resource set.
	 * @since 2.4
	 */
	/* @NonNull */
	@Override
	public Object getLock() {
		return lock;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @since 2.4
	 */
	/* @Nullable */
	@Override
	public <Result> Result execute(/* @NonNull */ IUnitOfWork<Result, ? super SynchronizedXtextResourceSet> unit) throws Exception {
		synchronized (getLock()) {
			return unit.exec(this);
		}
	}

	/**
	 * @since 2.4
	 */
	@Override
	protected ResourcesList createResourceList() {
		return new ResourcesList() {

			private static final long serialVersionUID = -4217297874237993194L;

			@Override
			public boolean containsAll(Collection<?> c) {
				synchronized (lock) {
					return super.containsAll(c);
				}
			}

			@Override
			public Resource set(int index, Resource object) {
				synchronized (lock) {
					return super.set(index, object);
				}
			}

			@Override
			public boolean add(Resource object) {
				synchronized (lock) {
					return super.add(object);
				}
			}

			@Override
			public void add(int index, Resource object) {
				synchronized (lock) {
					super.add(index, object);
				}
			}

			@Override
			public boolean addAll(Collection<? extends Resource> collection) {
				synchronized (lock) {
					return super.addAll(collection);
				}
			}

			@Override
			public boolean addAll(int index, Collection<? extends Resource> collection) {
				synchronized (lock) {
					return super.addAll(index, collection);
				}
			}

			@Override
			public boolean remove(Object object) {
				synchronized (lock) {
					return super.remove(object);
				}
			}

			@Override
			public boolean retainAll(Collection<?> collection) {
				synchronized (lock) {
					return super.retainAll(collection);
				}
			}

			@Override
			public void move(int index, Resource object) {
				synchronized (lock) {
					super.move(index, object);
				}
			}

			@Override
			public boolean equals(Object object) {
				synchronized (lock) {
					return super.equals(object);
				}
			}

			@Override
			public int hashCode() {
				synchronized (lock) {
					return super.hashCode();
				}
			}

			@Override
			public String toString() {
				synchronized (lock) {
					return super.toString();
				}
			}

			@Override
			public Iterator<Resource> iterator() {
				return new SynchronizedEIterator();
			}

			class SynchronizedEIterator extends AbstractEList<Resource>.EIterator<Resource> {
				@Override
				public boolean hasNext() {
					synchronized (lock) {
						return super.hasNext();
					}
				}

				@Override
				public Resource next() {
					synchronized (lock) {
						return super.next();
					}
				}

				@Override
				public void remove() {
					synchronized (lock) {
						super.remove();
					}
				}
			}

			class SynchronizedEListIterator extends AbstractEList<Resource>.EListIterator<Resource> {

				public SynchronizedEListIterator() {
					super();
				}

				public SynchronizedEListIterator(int index) {
					super(index);
				}

				@Override
				public void add(Resource object) {
					synchronized (lock) {
						super.add(object);
					}
				}

				@Override
				public boolean hasNext() {
					synchronized (lock) {
						return super.hasNext();
					}
				}

				@Override
				public boolean hasPrevious() {
					synchronized (lock) {
						return super.hasPrevious();
					}
				}

				@Override
				public Resource next() {
					synchronized (lock) {
						return super.next();
					}
				}

				@Override
				public Resource previous() {
					synchronized (lock) {
						return super.previous();
					}
				}

				@Override
				public int previousIndex() {
					synchronized (lock) {
						return super.previousIndex();
					}
				}

				@Override
				public void remove() {
					synchronized (lock) {
						super.remove();
					}
				}

				@Override
				public void set(Resource object) {
					synchronized (lock) {
						super.set(object);
					}
				}
			}

			@Override
			public ListIterator<Resource> listIterator() {
				return new SynchronizedEListIterator();
			}

			@Override
			public ListIterator<Resource> listIterator(int index) {
				synchronized (lock) {
					int size = size();
					if (index < 0 || index > size)
						throw new BasicIndexOutOfBoundsException(index, size);
					return new SynchronizedEListIterator(index);
				}
			}

			@Override
			public int indexOf(Object object) {
				synchronized (lock) {
					return super.indexOf(object);
				}
			}

			@Override
			public int lastIndexOf(Object object) {
				synchronized (lock) {
					return super.lastIndexOf(object);
				}
			}

			@Override
			public Object[] toArray() {
				synchronized (lock) {
					return super.toArray();
				}
			}

			@Override
			public <T> T[] toArray(T[] array) {
				synchronized (lock) {
					return super.toArray(array);
				}
			}

			@Override
			public void setData(int size, Object[] data) {
				synchronized (lock) {
					super.setData(size, data);
				}
			}

			@Override
			public Resource get(int index) {
				synchronized (lock) {
					return super.get(index);
				}
			}

			@Override
			public Resource basicGet(int index) {
				synchronized (lock) {
					return super.basicGet(index);
				}
			}

			@Override
			public void shrink() {
				synchronized (lock) {
					super.shrink();
				}
			}

			@Override
			public void grow(int minimumCapacity) {
				synchronized (lock) {
					super.grow(minimumCapacity);
				}
			}

			@Override
			public Object clone() {
				synchronized (lock) {
					return super.clone();
				}
			}

			@Override
			public void addUnique(Resource object) {
				synchronized (lock) {
					super.addUnique(object);
				}
			}

			@Override
			public void addUnique(int index, Resource object) {
				synchronized (lock) {
					super.addUnique(index, object);
				}
			}

			@Override
			public boolean addAllUnique(Collection<? extends Resource> collection) {
				synchronized (lock) {
					return super.addAllUnique(collection);
				}
			}

			@Override
			public boolean addAllUnique(int index, Collection<? extends Resource> collection) {
				synchronized (lock) {
					return super.addAllUnique(index, collection);
				}
			}

			@Override
			public boolean addAllUnique(Object[] objects, int start, int end) {
				synchronized (lock) {
					return super.addAllUnique(objects, start, end);
				}
			}

			@Override
			public boolean addAllUnique(int index, Object[] objects, int start, int end) {
				synchronized (lock) {
					return super.addAllUnique(index, objects, start, end);
				}
			}

			@Override
			public NotificationChain basicAdd(Resource object, NotificationChain notifications) {
				synchronized (lock) {
					return super.basicAdd(object, notifications);
				}
			}

			@Override
			public Resource remove(int index) {
				synchronized (lock) {
					return super.remove(index);
				}
			}

			@Override
			public boolean removeAll(Collection<?> collection) {
				synchronized (lock) {
					return super.removeAll(collection);
				}
			}

			@Override
			public NotificationChain basicRemove(Object object, NotificationChain notifications) {
				synchronized (lock) {
					return super.basicRemove(object, notifications);
				}
			}

			@Override
			public void clear() {
				synchronized (lock) {
					super.clear();
				}
			}

			@Override
			public Resource setUnique(int index, Resource object) {
				synchronized (lock) {
					return super.setUnique(index, object);
				}
			}

			@Override
			public NotificationChain basicSet(int index, Resource object, NotificationChain notifications) {
				synchronized (lock) {
					return super.basicSet(index, object, notifications);
				}
			}

			@Override
			public Resource move(int targetIndex, int sourceIndex) {
				synchronized (lock) {
					return super.move(targetIndex, sourceIndex);
				}
			}

			@Override
			public List<Resource> basicList() {
				synchronized (lock) {
					return super.basicList();
				}
			}

			@Override
			public Iterator<Resource> basicIterator() {
				return new SynchronizedNonResolvingEIterator();
			}

			@Override
			public ListIterator<Resource> basicListIterator() {
				return new SynchronizedNonResolvingEListIterator();
			}

			@Override
			public ListIterator<Resource> basicListIterator(int index) {
				synchronized (lock) {
					int size = size();
					if (index < 0 || index > size)
						throw new BasicIndexOutOfBoundsException(index, size);
					return new SynchronizedNonResolvingEListIterator(index);
				}
			}

			class SynchronizedNonResolvingEIterator extends AbstractEList<Resource>.NonResolvingEIterator<Resource> {
				@Override
				public boolean hasNext() {
					synchronized (lock) {
						return super.hasNext();
					}
				}

				@Override
				public Resource next() {
					synchronized (lock) {
						return super.next();
					}
				}

				@Override
				public void remove() {
					synchronized (lock) {
						super.remove();
					}
				}
			}

			class SynchronizedNonResolvingEListIterator extends
					AbstractEList<Resource>.NonResolvingEListIterator<Resource> {

				public SynchronizedNonResolvingEListIterator() {
					super();
				}

				public SynchronizedNonResolvingEListIterator(int index) {
					super(index);
				}

				@Override
				public void add(Resource object) {
					synchronized (lock) {
						super.add(object);
					}
				}

				@Override
				public boolean hasNext() {
					synchronized (lock) {
						return super.hasNext();
					}
				}

				@Override
				public boolean hasPrevious() {
					synchronized (lock) {
						return super.hasPrevious();
					}
				}

				@Override
				public Resource next() {
					synchronized (lock) {
						return super.next();
					}
				}

				@Override
				public Resource previous() {
					synchronized (lock) {
						return super.previous();
					}
				}

				@Override
				public int previousIndex() {
					synchronized (lock) {
						return super.previousIndex();
					}
				}

				@Override
				public void remove() {
					synchronized (lock) {
						super.remove();
					}
				}

				@Override
				public void set(Resource object) {
					synchronized (lock) {
						super.set(object);
					}
				}
			}

			@Override
			public boolean contains(Object object) {
				synchronized (lock) {
					return super.contains(object);
				}
			}

		};
	}
}