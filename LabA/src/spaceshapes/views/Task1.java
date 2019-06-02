package spaceshapes.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

public class Task1 implements TreeModel {

	protected ShapeModel _model;
	
	protected List<TreeModelListener> _listeners = new ArrayList<TreeModelListener>();
	
	public Task1() {
	}

	public Task1(ShapeModel model) {
		_model = model;
	}

	@Override
	public Object getRoot() {
		return _model.root();
	}

	@Override
	public Object getChild(Object parent, int index) {
		if (parent instanceof CarrierShape) {
			try {
				return ((CarrierShape)parent).shapeAt(index);
			}catch(IndexOutOfBoundsException I){
				return null;
			}
		}else {
			return null;
		}
	}

	@Override
	public int getChildCount(Object parent) {
		if (parent instanceof CarrierShape) {
			return ((CarrierShape)parent).shapeCount();
		}else {
			return 0;
		}
	}

	@Override
	public boolean isLeaf(Object node) {
		if (node instanceof CarrierShape) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		return;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if(parent instanceof CarrierShape) {
			if(child instanceof Shape) {
				return ((CarrierShape)parent).indexOf(((Shape)child));
			}
		}
		return -1;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		_listeners.add(l);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		_listeners.remove(l);

	}

}
