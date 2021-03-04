
package com.example.facemaker;
/**
 *
 * @author Saylene Hernandez
 * @date 03/03/2021
 *
 */
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView
{
	private Face face;
	private FaceModel model;


	public FaceView(Context c, AttributeSet as)
	{
		super(c, as);
		setWillNotDraw(false);

		// creates a FaceModel object
		this.model = new FaceModel();
		// creates a Face object, and passes the FaceModel object to the new Face object, through its constructor, so it can
		// read / edit FaceModel's variables.
		this.face = new Face(model);
	}


	public void onDraw(Canvas c) { face.draw(c); }

	public Face getFace() { return this.face; }
	public FaceModel getFaceModel() { return this.model; }
}
