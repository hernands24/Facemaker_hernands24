/**
 *
 * @author Saylene Hernandez
 * @date 03/03/2021
 *
 */
package com.example.facemaker;

import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

public class Face
{
	Random gen = new Random();
	private FaceModel model;

	/**
	 * Face's constructor.
	 */
	public Face(FaceModel model)
	{
		this.model = model;

		// automatically calls randomize on creation
		randomize();
	}
//homework2
	/**
	 * This method randomizes the colors of the paints for eyes/hair/skin.
	 */
	public void randomize()
	{
		model.setHairPaint(gen.nextInt(0x00ffffff));
		model.setEyePaint(gen.nextInt(0x00ffffff));
		model.setSkinPaint(gen.nextInt(0x00ffffff));
		model.setNosePaint(gen.nextInt(0x00ffffff));
	}

	public void draw(Canvas c)
	{
		float centerX = (float) (c.getWidth() / 2);
		float centerY = (float) (c.getHeight() / 2);
		float screenRatio = (float) (c.getWidth() / c.getHeight());

		this.drawFace(c, centerX, centerY);
		this.drawNose(c, centerX, centerY);
		this.drawEyes(c, centerX, centerY, screenRatio);
		this.drawMouth(c, centerX, centerY);

		switch(model.getSelectedStyle())
		{
			case MUSTACHE:
				this.drawMustache(c, centerX, centerY);
				break;

			case SOUL_PATCH:
				this.drawSoulPatch(c, centerX, centerY);
				break;

			case GOATEE:
				this.drawGoatee(c, centerX, centerY);
				break;

			default:
				Log.d("Face.java:71", "ERROR: ENUM selected_style CORRUPTED");
				break;
		}
	}

//draws the face
	private void drawFace(Canvas c, float centerX, float centerY)
	{
		c.drawOval(centerX * 0.7f, centerY * 0.05f, centerX * 1.3f, centerY * 1.95f, model.getSkinPaint());
	}

//draws the nose
	private void drawNose(Canvas c, float centerX, float centerY)
	{
		c.drawOval(centerX * 0.98f, centerY * 0.9f, centerX * 1.02f, centerY * 1.1f, model.getNosePaint());
		centerY *= 1.1f;
		c.drawOval(centerX * 0.95f, centerY * 0.98f, centerX * 1.05f, centerY * 1.02f, model.getNosePaint());
	}

//draws the eyes
	private void drawEyes(Canvas c, float centerX, float centerY, float screenRatio)
	{
		float newCenterY = centerY * 0.75f;
		float newCenterX = centerX * 0.85f;
		float circleRadiusMultiplyer = 0.05f;
		c.drawOval(newCenterX - (centerX * circleRadiusMultiplyer), newCenterY - (centerY * circleRadiusMultiplyer * screenRatio),
				newCenterX + (centerX * circleRadiusMultiplyer), newCenterY + (centerY * circleRadiusMultiplyer * screenRatio),
						model.WHITE_PAINT);
		circleRadiusMultiplyer = 0.025f;
		c.drawOval(newCenterX - (centerX * circleRadiusMultiplyer), newCenterY - (centerY * circleRadiusMultiplyer * screenRatio),
				newCenterX + (centerX * circleRadiusMultiplyer), newCenterY + (centerY * circleRadiusMultiplyer * screenRatio),
				model.getEyePaint());
		circleRadiusMultiplyer = 0.0125f;
		c.drawOval(newCenterX - (centerX * circleRadiusMultiplyer), newCenterY - (centerY * circleRadiusMultiplyer * screenRatio),
				newCenterX + (centerX * circleRadiusMultiplyer), newCenterY + (centerY * circleRadiusMultiplyer * screenRatio),
				model.BLACK_PAINT);

		newCenterX = centerX * 1.15f;
		circleRadiusMultiplyer = 0.05f;
		c.drawOval(newCenterX - (centerX * circleRadiusMultiplyer), newCenterY - (centerY * circleRadiusMultiplyer * screenRatio),
				newCenterX + (centerX * circleRadiusMultiplyer), newCenterY + (centerY * circleRadiusMultiplyer * screenRatio),
				model.WHITE_PAINT);
		circleRadiusMultiplyer = 0.025f;
		c.drawOval(newCenterX - (centerX * circleRadiusMultiplyer), newCenterY - (centerY * circleRadiusMultiplyer * screenRatio),
				newCenterX + (centerX * circleRadiusMultiplyer), newCenterY + (centerY * circleRadiusMultiplyer * screenRatio),
				model.getEyePaint());
		circleRadiusMultiplyer = 0.0125f;
		c.drawOval(newCenterX - (centerX * circleRadiusMultiplyer), newCenterY - (centerY * circleRadiusMultiplyer * screenRatio),
				newCenterX + (centerX * circleRadiusMultiplyer), newCenterY + (centerY * circleRadiusMultiplyer * screenRatio),
				model.BLACK_PAINT);
	}

//draws the mouth
	private void drawMouth(Canvas c, float centerX, float centerY)
	{
		float newCenterY = centerY * 1.50f;
		c.drawOval(centerX * 0.85f, newCenterY - (centerY * 0.05f), centerX * 1.15f, newCenterY + (centerY * 0.05f), model.RED_PAINT);
		c.drawLine(centerX * 0.85f, newCenterY, centerX * 1.15f, newCenterY, model.BLACK_PAINT);
	}

//draws a "mustache" option one
	private void drawMustache(Canvas c, float centerX, float centerY)
	{
		float newCenterY = centerY * 1.25f;
		c.drawRect(centerX * 0.85f, newCenterY - (centerY * 0.05f), centerX * 1.15f, newCenterY + (centerY * 0.05f), model.getHairPaint());
	}

//draws a "soul patch"
	private void drawSoulPatch(Canvas c, float centerX, float centerY)
	{
		float newCenterY = centerY * 1.75f;
		c.drawRect(centerX * 0.95f, newCenterY - (centerY * 0.05f), centerX * 1.05f, newCenterY + (centerY * 0.05f), model.getHairPaint());
	}
//draws a goatee
	private void drawGoatee(Canvas c, float centerX, float centerY)
	{
		this.drawMustache(c, centerX, centerY);
		this.drawSoulPatch(c, centerX, centerY);
	}
}
