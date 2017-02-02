package com.dev.container;

import java.util.ArrayList;
import java.util.List;

public class Container<T> {

	private static final long serialVersionUID = 5670880027563421734L;

	public Container(T data) {

		this.data = data;
		root = this;
		children = new ArrayList<>();
	}

	Container<T> root;
	T data;
	List<Container<T>> children;

	public void add(T data) {

		children.add(new Container<T>(data));
	}

	public boolean contains(T data) {
		// start at root
		if (root == null)
			return false;
		else {
			// look for data in children
			for (Container<T> c : children) {
				if (c.data.equals(data))
					return true;
			}
		}

		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Container<?>))
			return false;

		final Container<T> other = (Container<T>) obj;
		if ((this.data == null) ? (other.data != null) : !this.data.equals(other.data)) {
			return false;
		}
		return true;
	}

	public Container<T> getRoot() {
		return this.root;
	}

}
