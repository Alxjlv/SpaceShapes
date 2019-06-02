package spaceshapes.views;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import spaceshapes.Shape;
import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelEvent.EventType;
import spaceshapes.ShapeModelListener;

public class Task2 extends Task1 implements ShapeModelListener{

	public Task2() {
	}

	public Task2(ShapeModel model) {
		super(model);
	}

	@Override
	public void update(ShapeModelEvent event) {
		int[] index = new int[1];
		index[0] = event.index();
		Shape[] shape = new Shape[1];
		shape[0] = event.operand();
		if(event.eventType().equals(EventType.ShapeAdded)) {
			TreeModelEvent add = new TreeModelEvent(_model,event.parent().path().toArray(),index,shape);
			for(TreeModelListener l : _listeners) {
				l.treeNodesInserted(add);
			}
		}else if(event.eventType().equals(EventType.ShapeRemoved)) {
			TreeModelEvent remove = new TreeModelEvent(_model,event.parent().path().toArray(),index,shape);
			for(TreeModelListener l : _listeners) {
				l.treeNodesRemoved(remove);
			}
		}
	}

}
