
package com.example.facemaker;
/**
 *
 * @author Saylene Hernandez
 * @date 03/03/2021
 *
 */
import android.graphics.Paint;
import android.util.Log;

public class FaceModel
{
	private int hairColor;
	private int eyeColor;
	private int skinColor;
	private int noseColor;
	private Paint hairPaint;
	private Paint eyePaint;
	private Paint skinPaint;
	private Paint nosePaint;
	public static final Paint WHITE_PAINT = new Paint();
	public static final Paint BLACK_PAINT = new Paint();
	public static final Paint RED_PAINT = new Paint();

	private Attribute selectedAttribute;
	private Style selectedStyle;


	public FaceModel()
	{
		this.hairColor = 0xffffffff;
		this.eyeColor = 0xffffffff;
		this.skinColor = 0xffffffff;
		this.noseColor = 0xffffffff;

		this.hairPaint = new Paint();
		this.eyePaint = new Paint();
		this.skinPaint = new Paint();
		this.nosePaint = new Paint();
		this.WHITE_PAINT.setColor(0xffffffff);
		this.BLACK_PAINT.setColor(0xff000000);
		this.RED_PAINT.setColor(0xffff0000);

		this.setHairPaint(this.hairColor);
		this.setEyePaint(this.eyeColor);
		this.setSkinPaint(this.skinColor);
		this.setNosePaint(this.noseColor);

		this.selectedAttribute = Attribute.HAIR;
		this.selectedStyle = Style.MUSTACHE;
	}


	public static int compileColor(int red, int green, int blue)
	{
		return ( (red * 256 * 256) | (green * 256) | blue );
	}


	public static int decompilePaint(Paint paint, char rgb)
	{
		switch(rgb)
		{
			case 'b':
				return 0xff & paint.getColor();

			case 'g':
				return 0xff & (paint.getColor() >> 8);

			case 'r':
				return 0xff & (paint.getColor() >> 16);

			default:
				Log.d("FaceModel.java:52", "ERROR: MISUSE OF decompile_paint()");
				return 0;
		}
	}

//	public int get_hair_color() { return this.hair_color; }
//	public int get_eye_color() { return this.eye_color; }
//	public int get_skin_color() { return this.skin_color; }
	public Paint getHairPaint() { return this.hairPaint; }
	public Paint getEyePaint() { return this.eyePaint; }
	public Paint getSkinPaint() { return this.skinPaint; }
	public Paint getNosePaint() { return this.nosePaint; }
	public Attribute getSelectedAttribute() { return this.selectedAttribute; }
	public Style getSelectedStyle() { return this.selectedStyle; }

	public void setHairPaint(int hairColor)
	{
		// ensures that all colors' opacity (alpha value) is set to 100%
		this.hairColor = 0xff000000 | hairColor;

		this.hairPaint.setColor(this.hairColor);
	}
	public void setEyePaint(int eyeColor)
	{
		// ensures that all colors' opacity (alpha value) is set to 100%
		this.eyeColor = 0xff000000 | eyeColor;

		this.eyePaint.setColor(this.eyeColor);
	}
	public void setSkinPaint(int skinColor)
	{
		// ensures that all colors' opacity (alpha value) is set to 100%
		this.skinColor = 0xff000000 | skinColor;

		this.skinPaint.setColor(this.skinColor);
	}
	public void setNosePaint(int noseColor)
	{
		// ensures that all colors' opacity (alpha value) is set to 100%
		this.noseColor = 0xff000000 | noseColor;

		this.nosePaint.setColor(this.noseColor);
	}
	public void setSelectedAttribute(Attribute selectedAttribute) { this.selectedAttribute = selectedAttribute; }
	public void setSelectedStyle(Style selectedStyle) { this.selectedStyle = selectedStyle; }
	public void setSelectedStyle(int selectedStyle)
	{
		switch(selectedStyle)
		{
			case 0:
				this.selectedStyle = Style.MUSTACHE;
				break;

			case 1:
				this.selectedStyle = Style.SOUL_PATCH;
				break;

			case 2:
				this.selectedStyle = Style.GOATEE;
				break;

			default:
				Log.d("FaceModel.java:136", "ERROR: selectedStyle OUT OF BOUNDS");
		}
	}
}
