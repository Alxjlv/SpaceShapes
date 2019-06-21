# SpaceShapes
This SpaceShapes application uses the Java Swing framework to display several shapes bouncing around within a box. The logic for the shapes was developed initially, allowing display in a rudimentary animation viewer. As the design progressed, more complicated shapes were added (such as the CarrierShape which nests other shapes within it). 

GUI elements were then required, and several exisiting components had to be adapted to properly update. For example, the JTree component was used to view the Shape hierarchy, for example to show which shapes are nested where, however this didn't update when shapes were added/deleted and had to be adapted to work with the ShapeModel.

A shape with image displaying functionality was desired. This however led to some performance issues due to image scaling. This was solved using SwingWorker to do image processing in a background thread before returning this to the ED thread to be added to the model.
