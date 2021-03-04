package com.example.facemaker;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
/**
 *
 * @author Saylene Hernandez
 * @date 03/03/2021
 *
 */
public class FaceController implements	View.OnClickListener,
										SeekBar.OnSeekBarChangeListener,
										RadioGroup.OnCheckedChangeListener,
										AdapterView.OnItemSelectedListener
{
	private FaceView view;
	private FaceModel model;

	private SeekBar red;
	private SeekBar green;
	private SeekBar blue;

	private RadioGroup radioGroup;

	private Spinner spinner;

//Initial COmmit

	public FaceController(FaceView view, SeekBar red, SeekBar green, SeekBar blue, RadioGroup radioGroup, Spinner spinner)
	{
		this.view = view;
		model = view.getFaceModel();

		this.red = red;
		this.green = green;
		this.blue = blue;

		this.radioGroup = radioGroup;

		this.spinner = spinner;

		this.onClick(view);
	}


	public void onClick(View v)
	{
		view.getFace().randomize();

		switch(model.getSelectedAttribute())
		{
			case HAIR:
				this.onCheckedChanged(radioGroup, R.id.hairRadioButton);
				break;

			case EYES:
				this.onCheckedChanged(radioGroup, R.id.eyeRadioButton);
				break;

			case SKIN:
				this.onCheckedChanged(radioGroup, R.id.skinRadioButton);
				break;

			default:
				Log.d("FaceController.java:52", "ERROR: ENUM selected_attribute CORRUPTED");
				break;
		}

		int num = view.getFace().gen.nextInt(3);
		this.spinner.setSelection(num);
		model.setSelectedStyle(num);

		view.invalidate();
	}


	public void onProgressChanged(SeekBar sb, int progress, boolean fromUser)
	{
		if(fromUser)
		{
			switch(model.getSelectedAttribute())
			{
				case HAIR:
					model.setHairPaint( FaceModel.compileColor(red.getProgress(), green.getProgress(), blue.getProgress()) );
					break;
				case EYES:
					model.setEyePaint( FaceModel.compileColor(red.getProgress(), green.getProgress(), blue.getProgress()) );
					break;
				case SKIN:
					model.setSkinPaint( FaceModel.compileColor(red.getProgress(), green.getProgress(), blue.getProgress()) );
					break;
				default:
					Log.d("FaceController.java:47", "ERROR: ENUM selected_attribute CORRUPTED");
					break;
			}
			this.view.invalidate();
		}
	}
	public void onStartTrackingTouch(SeekBar sb) {}
	public void onStopTrackingTouch(SeekBar sb) {}

	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		switch(checkedId)
		{
			case R.id.hairRadioButton:
				model.setSelectedAttribute(Attribute.HAIR);
				red.setProgress( FaceModel.decompilePaint(model.getHairPaint(), 'r') );
				green.setProgress( FaceModel.decompilePaint(model.getHairPaint(), 'g') );
				blue.setProgress( FaceModel.decompilePaint(model.getHairPaint(), 'b') );
				break;

			case R.id.eyeRadioButton:
				model.setSelectedAttribute(Attribute.EYES);
				red.setProgress( FaceModel.decompilePaint(model.getEyePaint(), 'r') );
				green.setProgress( FaceModel.decompilePaint(model.getEyePaint(), 'g') );
				blue.setProgress( FaceModel.decompilePaint(model.getEyePaint(), 'b') );
				break;

			case R.id.skinRadioButton:
				model.setSelectedAttribute(Attribute.SKIN);
				red.setProgress( FaceModel.decompilePaint(model.getSkinPaint(), 'r') );
				green.setProgress( FaceModel.decompilePaint(model.getSkinPaint(), 'g') );
				blue.setProgress( FaceModel.decompilePaint(model.getSkinPaint(), 'b') );
				break;

			default:
				Log.d("FaceController.java:82", "ERROR: R.id checkedId CORRUPTED");
				break;
		}
	}

	public void onItemSelected(AdapterView parent, View view, int position, long id)
	{
		switch(position)
		{
			case 0:
				model.setSelectedStyle(Style.MUSTACHE);
				break;

			case 1:
				model.setSelectedStyle(Style.SOUL_PATCH);
				break;

			case 2:
				model.setSelectedStyle(Style.GOATEE);
				break;

			default:
				Log.d("FaceController.java:140", "ERROR: INVALID ENUM position PASSED TO onItemSelected()");
		}
		this.view.invalidate();
	}
	public void onNothingSelected(AdapterView parent) {}

}
